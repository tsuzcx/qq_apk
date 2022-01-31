package com.tencent.mm.booter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.g;

public final class b
{
  public static void br(Context paramContext)
  {
    AppMethodBeat.i(57745);
    if (c.Ii())
    {
      com.tencent.mm.app.e.Bb();
      AppMethodBeat.o(57745);
      return;
    }
    Intent localIntent = new Intent(paramContext, CoreService.class);
    try
    {
      paramContext.stopService(localIntent);
      AppMethodBeat.o(57745);
      return;
    }
    catch (Exception paramContext)
    {
      ab.e("MicroMsg.CoreServiceHelper", "stopServiceInstance() Exception:%s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(57745);
    }
  }
  
  public static boolean c(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(57744);
    if (((!paramString.equals("noop")) || ((g.ymN) && (g.ymM))) && (l.bQ(paramContext)))
    {
      ab.i("MicroMsg.CoreServiceHelper", "fully exited, no need to start service");
      AppMethodBeat.o(57744);
      return false;
    }
    ab.i("MicroMsg.CoreServiceHelper", "ensure service running, type=%s ifRepeat=%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    Intent localIntent = new Intent(paramContext, CoreService.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("START_TYPE", paramString);
    if (c.Ii())
    {
      ab.i("MicroMsg.CoreServiceHelper", "ensureServiceInstance() bindService");
      ah.getContext().bindService(localIntent, new com.tencent.mm.app.e(), 1);
      ab.i("MicroMsg.CoreServiceUtil", "if_26_num=%s  if_ignore_false=%s  ignore_true=%s", new Object[] { Boolean.valueOf(as.apq("service_launch_way").getBoolean("if_26_num", true)), Boolean.valueOf(as.apq("service_launch_way").getBoolean("if_ignore_false", true)), Boolean.valueOf(as.apq("service_launch_way").getBoolean("ignore_true", false)) });
      if ((d.fv(26)) && (as.apq("service_launch_way").getBoolean("if_26_num", true)))
      {
        as.apq("service_launch_way").edit().putBoolean("if_26_num", false).commit();
        com.tencent.mm.plugin.report.e.qrI.idkeyStat(954L, 92L, 1L, false);
      }
      if (d.fv(26))
      {
        if (c.bs(paramContext)) {
          break label963;
        }
        if (as.apq("service_launch_way").getBoolean("if_ignore_false", true))
        {
          as.apq("service_launch_way").edit().putBoolean("if_ignore_false", false).commit();
          com.tencent.mm.plugin.report.e.qrI.idkeyStat(954L, 90L, 1L, false);
          if (as.apq("service_launch_way").getBoolean("ignore_true", false)) {
            com.tencent.mm.plugin.report.e.qrI.idkeyStat(954L, 91L, 1L, false);
          }
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        AppMethodBeat.o(57744);
        return true;
        ab.i("MicroMsg.CoreServiceHelper", "ensureServiceInstance() startService");
        int i = 0;
        int k = 0;
        int j = 0;
        try
        {
          paramContext.startService(localIntent);
          if (!d.fv(26)) {
            break;
          }
          if (d.fv(26))
          {
            ab.i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService crash_not_ignore=%s service_IllegalStateException=%s", new Object[] { Boolean.valueOf(as.apq("service_launch_way").getBoolean("crash_not_ignore", false)), Boolean.valueOf(c.bs(paramContext)) });
            if ((as.apq("service_launch_way").getBoolean("crash_not_ignore", false)) && (c.bs(paramContext)) && (i == 0))
            {
              as.apq("service_launch_way").edit().putBoolean("crash_not_ignore", false);
              com.tencent.mm.plugin.report.e.qrI.idkeyStat(954L, 85L, 1L, false);
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
            ab.e("MicroMsg.CoreServiceHelper", "ensureServiceInstance() Exception = %s, Detail = %s SDK_INT = %s", new Object[] { localException.getClass().toString(), localException.getMessage(), Integer.valueOf(Build.VERSION.SDK_INT) });
            i = k;
            if ((localException instanceof IllegalStateException)) {
              i = 1;
            }
            if (d.fv(26))
            {
              as localas = as.apq("service_launch_way");
              boolean bool = c.bs(paramContext);
              if (localas.getBoolean("service_first_crash", true))
              {
                ab.i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService service_first_crash=true result=%s", new Object[] { Boolean.valueOf(bool) });
                localas.edit().putBoolean("service_first_crash", false).commit();
                com.tencent.mm.plugin.report.e.qrI.idkeyStat(954L, 80L, 1L, false);
                if ((localException instanceof IllegalStateException))
                {
                  c.bD(false);
                  localas.edit().putBoolean("service_IllegalStateException", true).commit();
                  com.tencent.mm.plugin.report.e.qrI.idkeyStat(954L, 81L, 1L, false);
                  if (bool)
                  {
                    com.tencent.mm.plugin.report.e.qrI.idkeyStat(954L, 82L, 1L, false);
                    k = 1;
                    j = i;
                    i = k;
                    continue;
                  }
                  localas.edit().putBoolean("crash_not_ignore", true).commit();
                  com.tencent.mm.plugin.report.e.qrI.idkeyStat(954L, 83L, 1L, false);
                  k = 1;
                  j = i;
                  i = k;
                  continue;
                }
                com.tencent.mm.plugin.report.e.qrI.idkeyStat(954L, 86L, 1L, false);
                k = 1;
                j = i;
                i = k;
                continue;
              }
              ab.i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService service_first_crash=false result=%s", new Object[] { Boolean.valueOf(bool) });
              if ((localException instanceof IllegalStateException))
              {
                c.bD(false);
                if (!localas.getBoolean("service_IllegalStateException", false))
                {
                  ab.i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService service_first_crash=false service_IllegalStateException=false");
                  localas.edit().putBoolean("service_IllegalStateException", true).commit();
                  com.tencent.mm.plugin.report.e.qrI.idkeyStat(954L, 87L, 1L, false);
                  if (bool)
                  {
                    com.tencent.mm.plugin.report.e.qrI.idkeyStat(954L, 82L, 1L, false);
                    k = 1;
                    j = i;
                    i = k;
                    continue;
                  }
                  localas.edit().putBoolean("crash_not_ignore", true).commit();
                  com.tencent.mm.plugin.report.e.qrI.idkeyStat(954L, 83L, 1L, false);
                  k = 1;
                  j = i;
                  i = k;
                  continue;
                }
                ab.i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService service_first_crash=false service_IllegalStateException=true");
              }
            }
            k = 1;
            j = i;
            i = k;
          }
          AppMethodBeat.o(57744);
          return false;
        }
      }
      label963:
      as.apq("service_launch_way").edit().putBoolean("ignore_true", true).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.booter.b
 * JD-Core Version:    0.7.0.1
 */