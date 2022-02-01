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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.h;

public final class c
{
  private static boolean Tq()
  {
    AppMethodBeat.i(131863);
    boolean bool = ax.aFC("service_launch_way").getBoolean("target26_start_service", false);
    ad.i("MicroMsg.CoreServiceUtil", "ifTarget26StartService() result:%s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(131863);
    return bool;
  }
  
  public static void Tr()
  {
    AppMethodBeat.i(131865);
    Context localContext = aj.getContext();
    Object localObject = new Intent().setClassName(localContext, "com.tencent.mm.pluginsdk.permission.PermissionActivity");
    ((Intent)localObject).setFlags(268435456);
    ((Intent)localObject).putExtra("scene", 4);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/booter/CoreServiceUtil", "ignoreBatteryOptimizations", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/booter/CoreServiceUtil", "ignoreBatteryOptimizations", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ad.i("MicroMsg.CoreServiceUtil", "ignoreBatteryOptimizations()");
    AppMethodBeat.o(131865);
  }
  
  private static SharedPreferences Ts()
  {
    AppMethodBeat.i(131867);
    SharedPreferences localSharedPreferences = aj.getContext().getSharedPreferences("service_launch_way", g.XN());
    AppMethodBeat.o(131867);
    return localSharedPreferences;
  }
  
  public static boolean Tt()
  {
    AppMethodBeat.i(131868);
    if (d.lf(26))
    {
      int i = Ts().getInt("huawei_switch", 0);
      boolean bool = com.tencent.mm.sdk.h.a.eHm();
      ad.i("MicroMsg.CoreServiceUtil", "ifUseOnlyBindToCoreService() huaweiEnable:%s isEmui10:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
      if (bool)
      {
        AppMethodBeat.o(131868);
        return false;
      }
      if (bt.iY(i, 0))
      {
        ad.i("MicroMsg.CoreServiceUtil", "ifUseOnlyBindToCoreService() true (huawei)");
        AppMethodBeat.o(131868);
        return true;
      }
    }
    if ((d.lf(26)) && (!Tq()))
    {
      ad.i("MicroMsg.CoreServiceUtil", "ifUseOnlyBindToCoreService() true");
      AppMethodBeat.o(131868);
      return true;
    }
    ad.i("MicroMsg.CoreServiceUtil", "ifUseOnlyBindToCoreService() false");
    AppMethodBeat.o(131868);
    return false;
  }
  
  public static boolean bG(Context paramContext)
  {
    AppMethodBeat.i(131866);
    if (h.IS_UAT)
    {
      ad.i("MicroMsg.CoreServiceUtil", "ignorePermissionActivity for uat wechat pay.");
      AppMethodBeat.o(131866);
      return true;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      boolean bool = ((PowerManager)paramContext.getSystemService("power")).isIgnoringBatteryOptimizations(paramContext.getPackageName());
      ad.i("MicroMsg.CoreServiceUtil", "ifIgnoreBatteryOptimizations() result=%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(131866);
      return bool;
    }
    AppMethodBeat.o(131866);
    return true;
  }
  
  public static void cv(boolean paramBoolean)
  {
    AppMethodBeat.i(131864);
    ax.aFC("service_launch_way").edit().putBoolean("target26_start_service", paramBoolean).commit();
    ad.i("MicroMsg.CoreServiceUtil", "setTarget26StartService() enable: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(131864);
  }
  
  public static void kr(int paramInt)
  {
    AppMethodBeat.i(131862);
    Ts().edit().putInt("huawei_switch", paramInt).commit();
    ad.i("MicroMsg.CoreServiceUtil", "setTarget26StartServiceHuawei() enable: %s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(131862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.booter.c
 * JD-Core Version:    0.7.0.1
 */