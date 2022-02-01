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
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class b
{
  public static boolean c(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(131860);
    if (((!paramString.equals("noop")) || ((ChannelUtil.shouldShowGprsAlert) && (ChannelUtil.isShowingGprsAlert))) && (l.cK(paramContext)))
    {
      Log.i("MicroMsg.CoreServiceHelper", "fully exited, no need to start service");
      AppMethodBeat.o(131860);
      return false;
    }
    Log.i("MicroMsg.CoreServiceHelper", "ensure service running, type=%s ifRepeat=%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    Intent localIntent = new Intent(paramContext, CoreService.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("START_TYPE", paramString);
    if (c.akA())
    {
      Log.i("MicroMsg.CoreServiceHelper", "ensureServiceInstance() bindService");
      MMApplicationContext.getContext().bindService(localIntent, new g(), 1);
      Log.i("MicroMsg.CoreServiceUtil", "if_26_num=%s  if_ignore_false=%s  ignore_true=%s", new Object[] { Boolean.valueOf(MultiProcessMMKV.getMMKV("service_launch_way").getBoolean("if_26_num", true)), Boolean.valueOf(MultiProcessMMKV.getMMKV("service_launch_way").getBoolean("if_ignore_false", true)), Boolean.valueOf(MultiProcessMMKV.getMMKV("service_launch_way").getBoolean("ignore_true", false)) });
      if ((d.oD(26)) && (MultiProcessMMKV.getMMKV("service_launch_way").getBoolean("if_26_num", true)))
      {
        MultiProcessMMKV.getMMKV("service_launch_way").edit().putBoolean("if_26_num", false).commit();
        e.Cxv.idkeyStat(954L, 92L, 1L, false);
      }
      if (d.oD(26))
      {
        if (c.cf(paramContext)) {
          break label963;
        }
        if (MultiProcessMMKV.getMMKV("service_launch_way").getBoolean("if_ignore_false", true))
        {
          MultiProcessMMKV.getMMKV("service_launch_way").edit().putBoolean("if_ignore_false", false).commit();
          e.Cxv.idkeyStat(954L, 90L, 1L, false);
          if (MultiProcessMMKV.getMMKV("service_launch_way").getBoolean("ignore_true", false)) {
            e.Cxv.idkeyStat(954L, 91L, 1L, false);
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
        Log.i("MicroMsg.CoreServiceHelper", "ensureServiceInstance() startService");
        int i = 0;
        int k = 0;
        int j = 0;
        try
        {
          paramContext.startService(localIntent);
          if (!d.oD(26)) {
            break;
          }
          if (d.oD(26))
          {
            Log.i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService crash_not_ignore=%s service_IllegalStateException=%s", new Object[] { Boolean.valueOf(MultiProcessMMKV.getMMKV("service_launch_way").getBoolean("crash_not_ignore", false)), Boolean.valueOf(c.cf(paramContext)) });
            if ((MultiProcessMMKV.getMMKV("service_launch_way").getBoolean("crash_not_ignore", false)) && (c.cf(paramContext)) && (i == 0))
            {
              MultiProcessMMKV.getMMKV("service_launch_way").edit().putBoolean("crash_not_ignore", false);
              e.Cxv.idkeyStat(954L, 85L, 1L, false);
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
            Log.e("MicroMsg.CoreServiceHelper", "ensureServiceInstance() Exception = %s, Detail = %s SDK_INT = %s", new Object[] { localException.getClass().toString(), localException.getMessage(), Integer.valueOf(Build.VERSION.SDK_INT) });
            i = k;
            if ((localException instanceof IllegalStateException)) {
              i = 1;
            }
            if (d.oD(26))
            {
              MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("service_launch_way");
              boolean bool = c.cf(paramContext);
              if (localMultiProcessMMKV.getBoolean("service_first_crash", true))
              {
                Log.i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService service_first_crash=true result=%s", new Object[] { Boolean.valueOf(bool) });
                localMultiProcessMMKV.edit().putBoolean("service_first_crash", false).commit();
                e.Cxv.idkeyStat(954L, 80L, 1L, false);
                if ((localException instanceof IllegalStateException))
                {
                  c.dg(false);
                  localMultiProcessMMKV.edit().putBoolean("service_IllegalStateException", true).commit();
                  e.Cxv.idkeyStat(954L, 81L, 1L, false);
                  if (bool)
                  {
                    e.Cxv.idkeyStat(954L, 82L, 1L, false);
                    k = 1;
                    j = i;
                    i = k;
                    continue;
                  }
                  localMultiProcessMMKV.edit().putBoolean("crash_not_ignore", true).commit();
                  e.Cxv.idkeyStat(954L, 83L, 1L, false);
                  k = 1;
                  j = i;
                  i = k;
                  continue;
                }
                e.Cxv.idkeyStat(954L, 86L, 1L, false);
                k = 1;
                j = i;
                i = k;
                continue;
              }
              Log.i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService service_first_crash=false result=%s", new Object[] { Boolean.valueOf(bool) });
              if ((localException instanceof IllegalStateException))
              {
                c.dg(false);
                if (!localMultiProcessMMKV.getBoolean("service_IllegalStateException", false))
                {
                  Log.i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService service_first_crash=false service_IllegalStateException=false");
                  localMultiProcessMMKV.edit().putBoolean("service_IllegalStateException", true).commit();
                  e.Cxv.idkeyStat(954L, 87L, 1L, false);
                  if (bool)
                  {
                    e.Cxv.idkeyStat(954L, 82L, 1L, false);
                    k = 1;
                    j = i;
                    i = k;
                    continue;
                  }
                  localMultiProcessMMKV.edit().putBoolean("crash_not_ignore", true).commit();
                  e.Cxv.idkeyStat(954L, 83L, 1L, false);
                  k = 1;
                  j = i;
                  i = k;
                  continue;
                }
                Log.i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService service_first_crash=false service_IllegalStateException=true");
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
      MultiProcessMMKV.getMMKV("service_launch_way").edit().putBoolean("ignore_true", true).commit();
    }
  }
  
  public static void ce(Context paramContext)
  {
    AppMethodBeat.i(131861);
    if (c.akA())
    {
      g.Wj();
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
      Log.e("MicroMsg.CoreServiceHelper", "stopServiceInstance() Exception:%s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(131861);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.b
 * JD-Core Version:    0.7.0.1
 */