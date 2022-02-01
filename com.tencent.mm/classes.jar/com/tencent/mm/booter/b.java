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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.i;

public final class b
{
  public static void bI(Context paramContext)
  {
    AppMethodBeat.i(131861);
    if (c.Un())
    {
      g.Km();
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
      ac.e("MicroMsg.CoreServiceHelper", "stopServiceInstance() Exception:%s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(131861);
    }
  }
  
  public static boolean c(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(131860);
    if (((!paramString.equals("noop")) || ((i.GqL) && (i.GqK))) && (l.cp(paramContext)))
    {
      ac.i("MicroMsg.CoreServiceHelper", "fully exited, no need to start service");
      AppMethodBeat.o(131860);
      return false;
    }
    ac.i("MicroMsg.CoreServiceHelper", "ensure service running, type=%s ifRepeat=%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    Intent localIntent = new Intent(paramContext, CoreService.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("START_TYPE", paramString);
    if (c.Un())
    {
      ac.i("MicroMsg.CoreServiceHelper", "ensureServiceInstance() bindService");
      ai.getContext().bindService(localIntent, new g(), 1);
      ac.i("MicroMsg.CoreServiceUtil", "if_26_num=%s  if_ignore_false=%s  ignore_true=%s", new Object[] { Boolean.valueOf(aw.aKT("service_launch_way").getBoolean("if_26_num", true)), Boolean.valueOf(aw.aKT("service_launch_way").getBoolean("if_ignore_false", true)), Boolean.valueOf(aw.aKT("service_launch_way").getBoolean("ignore_true", false)) });
      if ((d.kZ(26)) && (aw.aKT("service_launch_way").getBoolean("if_26_num", true)))
      {
        aw.aKT("service_launch_way").edit().putBoolean("if_26_num", false).commit();
        e.wTc.idkeyStat(954L, 92L, 1L, false);
      }
      if (d.kZ(26))
      {
        if (c.bJ(paramContext)) {
          break label963;
        }
        if (aw.aKT("service_launch_way").getBoolean("if_ignore_false", true))
        {
          aw.aKT("service_launch_way").edit().putBoolean("if_ignore_false", false).commit();
          e.wTc.idkeyStat(954L, 90L, 1L, false);
          if (aw.aKT("service_launch_way").getBoolean("ignore_true", false)) {
            e.wTc.idkeyStat(954L, 91L, 1L, false);
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
        ac.i("MicroMsg.CoreServiceHelper", "ensureServiceInstance() startService");
        int i = 0;
        int k = 0;
        int j = 0;
        try
        {
          paramContext.startService(localIntent);
          if (!d.kZ(26)) {
            break;
          }
          if (d.kZ(26))
          {
            ac.i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService crash_not_ignore=%s service_IllegalStateException=%s", new Object[] { Boolean.valueOf(aw.aKT("service_launch_way").getBoolean("crash_not_ignore", false)), Boolean.valueOf(c.bJ(paramContext)) });
            if ((aw.aKT("service_launch_way").getBoolean("crash_not_ignore", false)) && (c.bJ(paramContext)) && (i == 0))
            {
              aw.aKT("service_launch_way").edit().putBoolean("crash_not_ignore", false);
              e.wTc.idkeyStat(954L, 85L, 1L, false);
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
            ac.e("MicroMsg.CoreServiceHelper", "ensureServiceInstance() Exception = %s, Detail = %s SDK_INT = %s", new Object[] { localException.getClass().toString(), localException.getMessage(), Integer.valueOf(Build.VERSION.SDK_INT) });
            i = k;
            if ((localException instanceof IllegalStateException)) {
              i = 1;
            }
            if (d.kZ(26))
            {
              aw localaw = aw.aKT("service_launch_way");
              boolean bool = c.bJ(paramContext);
              if (localaw.getBoolean("service_first_crash", true))
              {
                ac.i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService service_first_crash=true result=%s", new Object[] { Boolean.valueOf(bool) });
                localaw.edit().putBoolean("service_first_crash", false).commit();
                e.wTc.idkeyStat(954L, 80L, 1L, false);
                if ((localException instanceof IllegalStateException))
                {
                  c.cw(false);
                  localaw.edit().putBoolean("service_IllegalStateException", true).commit();
                  e.wTc.idkeyStat(954L, 81L, 1L, false);
                  if (bool)
                  {
                    e.wTc.idkeyStat(954L, 82L, 1L, false);
                    k = 1;
                    j = i;
                    i = k;
                    continue;
                  }
                  localaw.edit().putBoolean("crash_not_ignore", true).commit();
                  e.wTc.idkeyStat(954L, 83L, 1L, false);
                  k = 1;
                  j = i;
                  i = k;
                  continue;
                }
                e.wTc.idkeyStat(954L, 86L, 1L, false);
                k = 1;
                j = i;
                i = k;
                continue;
              }
              ac.i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService service_first_crash=false result=%s", new Object[] { Boolean.valueOf(bool) });
              if ((localException instanceof IllegalStateException))
              {
                c.cw(false);
                if (!localaw.getBoolean("service_IllegalStateException", false))
                {
                  ac.i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService service_first_crash=false service_IllegalStateException=false");
                  localaw.edit().putBoolean("service_IllegalStateException", true).commit();
                  e.wTc.idkeyStat(954L, 87L, 1L, false);
                  if (bool)
                  {
                    e.wTc.idkeyStat(954L, 82L, 1L, false);
                    k = 1;
                    j = i;
                    i = k;
                    continue;
                  }
                  localaw.edit().putBoolean("crash_not_ignore", true).commit();
                  e.wTc.idkeyStat(954L, 83L, 1L, false);
                  k = 1;
                  j = i;
                  i = k;
                  continue;
                }
                ac.i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService service_first_crash=false service_IllegalStateException=true");
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
      aw.aKT("service_launch_way").edit().putBoolean("ignore_true", true).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.b
 * JD-Core Version:    0.7.0.1
 */