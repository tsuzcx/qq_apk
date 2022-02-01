package com.tencent.mm.booter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.g;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.l;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.j;

public final class b
{
  public static void bH(Context paramContext)
  {
    AppMethodBeat.i(131861);
    if (c.WE())
    {
      g.LO();
      AppMethodBeat.o(131861);
      return;
    }
    Intent localIntent = new Intent(paramContext, CoreService.class);
    try
    {
      paramContext.stopService(localIntent);
      AppMethodBeat.o(131861);
      return;
    }
    catch (Exception paramContext)
    {
      ad.e("MicroMsg.CoreServiceHelper", "stopServiceInstance() Exception:%s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(131861);
    }
  }
  
  public static boolean c(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(131860);
    if (((!paramString.equals("noop")) || ((j.Icz) && (j.Icy))) && (l.cm(paramContext)))
    {
      ad.i("MicroMsg.CoreServiceHelper", "fully exited, no need to start service");
      AppMethodBeat.o(131860);
      return false;
    }
    ad.i("MicroMsg.CoreServiceHelper", "ensure service running, type=%s ifRepeat=%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    Intent localIntent = new Intent(paramContext, CoreService.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("START_TYPE", paramString);
    if (c.WE())
    {
      ad.i("MicroMsg.CoreServiceHelper", "ensureServiceInstance() bindService");
      aj.getContext().bindService(localIntent, new g(), 1);
      ad.i("MicroMsg.CoreServiceUtil", "if_26_num=%s  if_ignore_false=%s  ignore_true=%s", new Object[] { Boolean.valueOf(ax.aQz("service_launch_way").getBoolean("if_26_num", true)), Boolean.valueOf(ax.aQz("service_launch_way").getBoolean("if_ignore_false", true)), Boolean.valueOf(ax.aQz("service_launch_way").getBoolean("ignore_true", false)) });
      if ((d.ly(26)) && (ax.aQz("service_launch_way").getBoolean("if_26_num", true)))
      {
        ax.aQz("service_launch_way").edit().putBoolean("if_26_num", false).commit();
        e.ygI.idkeyStat(954L, 92L, 1L, false);
      }
      if (d.ly(26))
      {
        if (c.bI(paramContext)) {
          break label963;
        }
        if (ax.aQz("service_launch_way").getBoolean("if_ignore_false", true))
        {
          ax.aQz("service_launch_way").edit().putBoolean("if_ignore_false", false).commit();
          e.ygI.idkeyStat(954L, 90L, 1L, false);
          if (ax.aQz("service_launch_way").getBoolean("ignore_true", false)) {
            e.ygI.idkeyStat(954L, 91L, 1L, false);
          }
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        AppMethodBeat.o(131860);
        return true;
        ad.i("MicroMsg.CoreServiceHelper", "ensureServiceInstance() startService");
        int i = 0;
        int k = 0;
        int j = 0;
        try
        {
          paramContext.startService(localIntent);
          if (!d.ly(26)) {
            break;
          }
          if (d.ly(26))
          {
            ad.i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService crash_not_ignore=%s service_IllegalStateException=%s", new Object[] { Boolean.valueOf(ax.aQz("service_launch_way").getBoolean("crash_not_ignore", false)), Boolean.valueOf(c.bI(paramContext)) });
            if ((ax.aQz("service_launch_way").getBoolean("crash_not_ignore", false)) && (c.bI(paramContext)) && (i == 0))
            {
              ax.aQz("service_launch_way").edit().putBoolean("crash_not_ignore", false);
              e.ygI.idkeyStat(954L, 85L, 1L, false);
            }
          }
          if (j == 0) {
            break;
          }
          if (paramBoolean) {
            paramBoolean = false;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.e("MicroMsg.CoreServiceHelper", "ensureServiceInstance() Exception = %s, Detail = %s SDK_INT = %s", new Object[] { localException.getClass().toString(), localException.getMessage(), Integer.valueOf(Build.VERSION.SDK_INT) });
            i = k;
            if ((localException instanceof IllegalStateException)) {
              i = 1;
            }
            if (d.ly(26))
            {
              ax localax = ax.aQz("service_launch_way");
              boolean bool = c.bI(paramContext);
              if (localax.getBoolean("service_first_crash", true))
              {
                ad.i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService service_first_crash=true result=%s", new Object[] { Boolean.valueOf(bool) });
                localax.edit().putBoolean("service_first_crash", false).commit();
                e.ygI.idkeyStat(954L, 80L, 1L, false);
                if ((localException instanceof IllegalStateException))
                {
                  c.cy(false);
                  localax.edit().putBoolean("service_IllegalStateException", true).commit();
                  e.ygI.idkeyStat(954L, 81L, 1L, false);
                  if (bool)
                  {
                    e.ygI.idkeyStat(954L, 82L, 1L, false);
                    k = 1;
                    j = i;
                    i = k;
                    continue;
                  }
                  localax.edit().putBoolean("crash_not_ignore", true).commit();
                  e.ygI.idkeyStat(954L, 83L, 1L, false);
                  k = 1;
                  j = i;
                  i = k;
                  continue;
                }
                e.ygI.idkeyStat(954L, 86L, 1L, false);
                k = 1;
                j = i;
                i = k;
                continue;
              }
              ad.i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService service_first_crash=false result=%s", new Object[] { Boolean.valueOf(bool) });
              if ((localException instanceof IllegalStateException))
              {
                c.cy(false);
                if (!localax.getBoolean("service_IllegalStateException", false))
                {
                  ad.i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService service_first_crash=false service_IllegalStateException=false");
                  localax.edit().putBoolean("service_IllegalStateException", true).commit();
                  e.ygI.idkeyStat(954L, 87L, 1L, false);
                  if (bool)
                  {
                    e.ygI.idkeyStat(954L, 82L, 1L, false);
                    k = 1;
                    j = i;
                    i = k;
                    continue;
                  }
                  localax.edit().putBoolean("crash_not_ignore", true).commit();
                  e.ygI.idkeyStat(954L, 83L, 1L, false);
                  k = 1;
                  j = i;
                  i = k;
                  continue;
                }
                ad.i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService service_first_crash=false service_IllegalStateException=true");
              }
            }
            k = 1;
            j = i;
            i = k;
          }
          AppMethodBeat.o(131860);
          return false;
        }
      }
      label963:
      ax.aQz("service_launch_way").edit().putBoolean("ignore_true", true).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.b
 * JD-Core Version:    0.7.0.1
 */