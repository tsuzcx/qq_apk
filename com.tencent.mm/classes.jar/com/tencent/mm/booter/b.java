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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.k;

public final class b
{
  public static void bJ(Context paramContext)
  {
    AppMethodBeat.i(131861);
    if (c.WM())
    {
      g.LW();
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
      ae.e("MicroMsg.CoreServiceHelper", "stopServiceInstance() Exception:%s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(131861);
    }
  }
  
  public static boolean c(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(131860);
    if (((!paramString.equals("noop")) || ((k.IwK) && (k.IwJ))) && (l.co(paramContext)))
    {
      ae.i("MicroMsg.CoreServiceHelper", "fully exited, no need to start service");
      AppMethodBeat.o(131860);
      return false;
    }
    ae.i("MicroMsg.CoreServiceHelper", "ensure service running, type=%s ifRepeat=%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    Intent localIntent = new Intent(paramContext, CoreService.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("START_TYPE", paramString);
    if (c.WM())
    {
      ae.i("MicroMsg.CoreServiceHelper", "ensureServiceInstance() bindService");
      ak.getContext().bindService(localIntent, new g(), 1);
      ae.i("MicroMsg.CoreServiceUtil", "if_26_num=%s  if_ignore_false=%s  ignore_true=%s", new Object[] { Boolean.valueOf(ay.aRW("service_launch_way").getBoolean("if_26_num", true)), Boolean.valueOf(ay.aRW("service_launch_way").getBoolean("if_ignore_false", true)), Boolean.valueOf(ay.aRW("service_launch_way").getBoolean("ignore_true", false)) });
      if ((d.lA(26)) && (ay.aRW("service_launch_way").getBoolean("if_26_num", true)))
      {
        ay.aRW("service_launch_way").edit().putBoolean("if_26_num", false).commit();
        e.ywz.idkeyStat(954L, 92L, 1L, false);
      }
      if (d.lA(26))
      {
        if (c.bK(paramContext)) {
          break label963;
        }
        if (ay.aRW("service_launch_way").getBoolean("if_ignore_false", true))
        {
          ay.aRW("service_launch_way").edit().putBoolean("if_ignore_false", false).commit();
          e.ywz.idkeyStat(954L, 90L, 1L, false);
          if (ay.aRW("service_launch_way").getBoolean("ignore_true", false)) {
            e.ywz.idkeyStat(954L, 91L, 1L, false);
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
        ae.i("MicroMsg.CoreServiceHelper", "ensureServiceInstance() startService");
        int i = 0;
        int k = 0;
        int j = 0;
        try
        {
          paramContext.startService(localIntent);
          if (!d.lA(26)) {
            break;
          }
          if (d.lA(26))
          {
            ae.i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService crash_not_ignore=%s service_IllegalStateException=%s", new Object[] { Boolean.valueOf(ay.aRW("service_launch_way").getBoolean("crash_not_ignore", false)), Boolean.valueOf(c.bK(paramContext)) });
            if ((ay.aRW("service_launch_way").getBoolean("crash_not_ignore", false)) && (c.bK(paramContext)) && (i == 0))
            {
              ay.aRW("service_launch_way").edit().putBoolean("crash_not_ignore", false);
              e.ywz.idkeyStat(954L, 85L, 1L, false);
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
            ae.e("MicroMsg.CoreServiceHelper", "ensureServiceInstance() Exception = %s, Detail = %s SDK_INT = %s", new Object[] { localException.getClass().toString(), localException.getMessage(), Integer.valueOf(Build.VERSION.SDK_INT) });
            i = k;
            if ((localException instanceof IllegalStateException)) {
              i = 1;
            }
            if (d.lA(26))
            {
              ay localay = ay.aRW("service_launch_way");
              boolean bool = c.bK(paramContext);
              if (localay.getBoolean("service_first_crash", true))
              {
                ae.i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService service_first_crash=true result=%s", new Object[] { Boolean.valueOf(bool) });
                localay.edit().putBoolean("service_first_crash", false).commit();
                e.ywz.idkeyStat(954L, 80L, 1L, false);
                if ((localException instanceof IllegalStateException))
                {
                  c.cy(false);
                  localay.edit().putBoolean("service_IllegalStateException", true).commit();
                  e.ywz.idkeyStat(954L, 81L, 1L, false);
                  if (bool)
                  {
                    e.ywz.idkeyStat(954L, 82L, 1L, false);
                    k = 1;
                    j = i;
                    i = k;
                    continue;
                  }
                  localay.edit().putBoolean("crash_not_ignore", true).commit();
                  e.ywz.idkeyStat(954L, 83L, 1L, false);
                  k = 1;
                  j = i;
                  i = k;
                  continue;
                }
                e.ywz.idkeyStat(954L, 86L, 1L, false);
                k = 1;
                j = i;
                i = k;
                continue;
              }
              ae.i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService service_first_crash=false result=%s", new Object[] { Boolean.valueOf(bool) });
              if ((localException instanceof IllegalStateException))
              {
                c.cy(false);
                if (!localay.getBoolean("service_IllegalStateException", false))
                {
                  ae.i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService service_first_crash=false service_IllegalStateException=false");
                  localay.edit().putBoolean("service_IllegalStateException", true).commit();
                  e.ywz.idkeyStat(954L, 87L, 1L, false);
                  if (bool)
                  {
                    e.ywz.idkeyStat(954L, 82L, 1L, false);
                    k = 1;
                    j = i;
                    i = k;
                    continue;
                  }
                  localay.edit().putBoolean("crash_not_ignore", true).commit();
                  e.ywz.idkeyStat(954L, 83L, 1L, false);
                  k = 1;
                  j = i;
                  i = k;
                  continue;
                }
                ae.i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService service_first_crash=false service_IllegalStateException=true");
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
      ay.aRW("service_launch_way").edit().putBoolean("ignore_true", true).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.b
 * JD-Core Version:    0.7.0.1
 */