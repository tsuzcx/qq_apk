package com.tencent.mm.booter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.vendor.Honor;
import com.tencent.mm.sdk.vendor.Huawei;

public final class c
{
  private static boolean aqt()
  {
    AppMethodBeat.i(131863);
    boolean bool = MultiProcessMMKV.getMMKV("service_launch_way").getBoolean("target26_start_service", false);
    Log.i("MicroMsg.CoreServiceUtil", "ifTarget26StartService() result:%s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(131863);
    return bool;
  }
  
  public static void aqu()
  {
    AppMethodBeat.i(131865);
    Context localContext = MMApplicationContext.getContext();
    Object localObject = new Intent().setClassName(localContext, "com.tencent.mm.pluginsdk.permission.PermissionActivity");
    ((Intent)localObject).setFlags(268435456);
    ((Intent)localObject).putExtra("scene", 4);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/booter/CoreServiceUtil", "ignoreBatteryOptimizations", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/booter/CoreServiceUtil", "ignoreBatteryOptimizations", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    Log.i("MicroMsg.CoreServiceUtil", "ignoreBatteryOptimizations()");
    AppMethodBeat.o(131865);
  }
  
  private static SharedPreferences aqv()
  {
    AppMethodBeat.i(131867);
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("service_launch_way", g.avK());
    AppMethodBeat.o(131867);
    return localSharedPreferences;
  }
  
  public static boolean aqw()
  {
    AppMethodBeat.i(131868);
    if (com.tencent.mm.compatible.util.d.qV(26))
    {
      boolean bool1 = Honor.INSTANCE.ifHONOR();
      int i = Util.safeParseInt(com.tencent.mm.plugin.expt.h.d.dgX().gO("clicfg_target26_start_service_switch_huawei", "0"));
      Log.i("MicroMsg.CoreServiceUtil", "ifUseOnlyBindToCoreService() isHonor:%s startServiceSwitchHonor:%s", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i) });
      if ((!bool1) || (i == 0))
      {
        i = aqv().getInt("huawei_switch", 0);
        boolean bool2 = Huawei.isNotBelowEMUI10();
        Log.i("MicroMsg.CoreServiceUtil", "ifUseOnlyBindToCoreService() isHonor:%s huaweiEnable:%s isNotBelowEmui10:%s", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i), Boolean.valueOf(bool2) });
        if ((bool2) || (bool1))
        {
          AppMethodBeat.o(131868);
          return false;
        }
        if (Util.isEqual(i, 0))
        {
          Log.i("MicroMsg.CoreServiceUtil", "ifUseOnlyBindToCoreService() true (huawei)");
          AppMethodBeat.o(131868);
          return true;
        }
      }
    }
    if ((com.tencent.mm.compatible.util.d.qV(26)) && (!aqt()))
    {
      Log.i("MicroMsg.CoreServiceUtil", "ifUseOnlyBindToCoreService() true");
      AppMethodBeat.o(131868);
      return true;
    }
    Log.i("MicroMsg.CoreServiceUtil", "ifUseOnlyBindToCoreService() false");
    AppMethodBeat.o(131868);
    return false;
  }
  
  public static boolean cb(Context paramContext)
  {
    AppMethodBeat.i(131866);
    if (BuildInfo.IS_UAT)
    {
      Log.i("MicroMsg.CoreServiceUtil", "ignorePermissionActivity for uat wechat pay.");
      AppMethodBeat.o(131866);
      return true;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      boolean bool = ((PowerManager)paramContext.getSystemService("power")).isIgnoringBatteryOptimizations(paramContext.getPackageName());
      Log.i("MicroMsg.CoreServiceUtil", "ifIgnoreBatteryOptimizations() result=%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(131866);
      return bool;
    }
    AppMethodBeat.o(131866);
    return true;
  }
  
  public static void dG(boolean paramBoolean)
  {
    AppMethodBeat.i(131864);
    MultiProcessMMKV.getMMKV("service_launch_way").edit().putBoolean("target26_start_service", paramBoolean).commit();
    Log.i("MicroMsg.CoreServiceUtil", "setTarget26StartService() enable: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(131864);
  }
  
  public static void qe(int paramInt)
  {
    AppMethodBeat.i(131862);
    aqv().edit().putInt("huawei_switch", paramInt).commit();
    Log.i("MicroMsg.CoreServiceUtil", "setTarget26StartServiceHuawei() enable: %s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(131862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.booter.c
 * JD-Core Version:    0.7.0.1
 */