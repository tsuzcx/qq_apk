package com.tencent.mm.booter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.h;

public final class c
{
  private static boolean Uk()
  {
    AppMethodBeat.i(131863);
    boolean bool = aw.aKT("service_launch_way").getBoolean("target26_start_service", false);
    ac.i("MicroMsg.CoreServiceUtil", "ifTarget26StartService() result:%s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(131863);
    return bool;
  }
  
  public static void Ul()
  {
    AppMethodBeat.i(131865);
    Context localContext = ai.getContext();
    Object localObject = new Intent().setClassName(localContext, "com.tencent.mm.pluginsdk.permission.PermissionActivity");
    ((Intent)localObject).setFlags(268435456);
    ((Intent)localObject).putExtra("scene", 4);
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/booter/CoreServiceUtil", "ignoreBatteryOptimizations", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/booter/CoreServiceUtil", "ignoreBatteryOptimizations", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ac.i("MicroMsg.CoreServiceUtil", "ignoreBatteryOptimizations()");
    AppMethodBeat.o(131865);
  }
  
  private static SharedPreferences Um()
  {
    AppMethodBeat.i(131867);
    SharedPreferences localSharedPreferences = ai.getContext().getSharedPreferences("service_launch_way", g.YK());
    AppMethodBeat.o(131867);
    return localSharedPreferences;
  }
  
  public static boolean Un()
  {
    AppMethodBeat.i(131868);
    if (d.kZ(26))
    {
      int i = Um().getInt("huawei_switch", 0);
      boolean bool = com.tencent.mm.sdk.h.a.fdl();
      ac.i("MicroMsg.CoreServiceUtil", "ifUseOnlyBindToCoreService() huaweiEnable:%s isNotBelowEmui10:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
      if (bool)
      {
        AppMethodBeat.o(131868);
        return false;
      }
      if (bs.jl(i, 0))
      {
        ac.i("MicroMsg.CoreServiceUtil", "ifUseOnlyBindToCoreService() true (huawei)");
        AppMethodBeat.o(131868);
        return true;
      }
    }
    if ((d.kZ(26)) && (!Uk()))
    {
      ac.i("MicroMsg.CoreServiceUtil", "ifUseOnlyBindToCoreService() true");
      AppMethodBeat.o(131868);
      return true;
    }
    ac.i("MicroMsg.CoreServiceUtil", "ifUseOnlyBindToCoreService() false");
    AppMethodBeat.o(131868);
    return false;
  }
  
  public static boolean bJ(Context paramContext)
  {
    AppMethodBeat.i(131866);
    if (h.IS_UAT)
    {
      ac.i("MicroMsg.CoreServiceUtil", "ignorePermissionActivity for uat wechat pay.");
      AppMethodBeat.o(131866);
      return true;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      boolean bool = ((PowerManager)paramContext.getSystemService("power")).isIgnoringBatteryOptimizations(paramContext.getPackageName());
      ac.i("MicroMsg.CoreServiceUtil", "ifIgnoreBatteryOptimizations() result=%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(131866);
      return bool;
    }
    AppMethodBeat.o(131866);
    return true;
  }
  
  public static void cw(boolean paramBoolean)
  {
    AppMethodBeat.i(131864);
    aw.aKT("service_launch_way").edit().putBoolean("target26_start_service", paramBoolean).commit();
    ac.i("MicroMsg.CoreServiceUtil", "setTarget26StartService() enable: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(131864);
  }
  
  public static void ko(int paramInt)
  {
    AppMethodBeat.i(131862);
    Um().edit().putInt("huawei_switch", paramInt).commit();
    ac.i("MicroMsg.CoreServiceUtil", "setTarget26StartServiceHuawei() enable: %s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(131862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.booter.c
 * JD-Core Version:    0.7.0.1
 */