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
  private static boolean aKr()
  {
    AppMethodBeat.i(131863);
    boolean bool = MultiProcessMMKV.getMMKV("service_launch_way").getBoolean("target26_start_service", false);
    Log.i("MicroMsg.CoreServiceUtil", "ifTarget26StartService() result:%s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(131863);
    return bool;
  }
  
  public static void aKs()
  {
    AppMethodBeat.i(131865);
    Context localContext = MMApplicationContext.getContext();
    Object localObject = new Intent().setClassName(localContext, "com.tencent.mm.pluginsdk.permission.PermissionActivity");
    ((Intent)localObject).setFlags(268435456);
    ((Intent)localObject).putExtra("scene", 4);
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/booter/CoreServiceUtil", "ignoreBatteryOptimizations", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/booter/CoreServiceUtil", "ignoreBatteryOptimizations", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    Log.i("MicroMsg.CoreServiceUtil", "ignoreBatteryOptimizations()");
    AppMethodBeat.o(131865);
  }
  
  private static SharedPreferences aKt()
  {
    AppMethodBeat.i(131867);
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("service_launch_way", g.aQe());
    AppMethodBeat.o(131867);
    return localSharedPreferences;
  }
  
  public static boolean aKu()
  {
    AppMethodBeat.i(131868);
    if (com.tencent.mm.compatible.util.d.rb(26))
    {
      boolean bool1 = Honor.INSTANCE.ifHONOR();
      int i = Util.safeParseInt(com.tencent.mm.plugin.expt.e.d.dNI().hx("clicfg_target26_start_service_switch_huawei", "0"));
      Log.i("MicroMsg.CoreServiceUtil", "ifUseOnlyBindToCoreService() isHonor:%s startServiceSwitchHonor:%s", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i) });
      if ((!bool1) || (i == 0))
      {
        i = aKt().getInt("huawei_switch", 0);
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
    if ((com.tencent.mm.compatible.util.d.rb(26)) && (!aKr()))
    {
      Log.i("MicroMsg.CoreServiceUtil", "ifUseOnlyBindToCoreService() true");
      AppMethodBeat.o(131868);
      return true;
    }
    Log.i("MicroMsg.CoreServiceUtil", "ifUseOnlyBindToCoreService() false");
    AppMethodBeat.o(131868);
    return false;
  }
  
  public static boolean cN(Context paramContext)
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
  
  public static void es(boolean paramBoolean)
  {
    AppMethodBeat.i(131864);
    MultiProcessMMKV.getMMKV("service_launch_way").edit().putBoolean("target26_start_service", paramBoolean).commit();
    Log.i("MicroMsg.CoreServiceUtil", "setTarget26StartService() enable: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(131864);
  }
  
  public static void qe(int paramInt)
  {
    AppMethodBeat.i(131862);
    aKt().edit().putInt("huawei_switch", paramInt).commit();
    Log.i("MicroMsg.CoreServiceUtil", "setTarget26StartServiceHuawei() enable: %s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(131862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.booter.c
 * JD-Core Version:    0.7.0.1
 */