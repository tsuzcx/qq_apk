package com.tencent.mm.booter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;

public final class c
{
  private static boolean If()
  {
    AppMethodBeat.i(57747);
    boolean bool = as.apq("service_launch_way").getBoolean("target26_start_service", false);
    ab.i("MicroMsg.CoreServiceUtil", "ifTarget26StartService() result:%s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(57747);
    return bool;
  }
  
  public static void Ig()
  {
    AppMethodBeat.i(57749);
    Context localContext = ah.getContext();
    Intent localIntent = new Intent().setClassName(localContext, "com.tencent.mm.pluginsdk.permission.PermissionActivity");
    localIntent.putExtra("scene", 4);
    localContext.startActivity(localIntent);
    ab.i("MicroMsg.CoreServiceUtil", "ignoreBatteryOptimizations()");
    AppMethodBeat.o(57749);
  }
  
  private static SharedPreferences Ih()
  {
    AppMethodBeat.i(57751);
    SharedPreferences localSharedPreferences = ah.getContext().getSharedPreferences("service_launch_way", h.Mp());
    AppMethodBeat.o(57751);
    return localSharedPreferences;
  }
  
  public static boolean Ii()
  {
    AppMethodBeat.i(57752);
    if (d.fv(26))
    {
      int i = Ih().getInt("huawei_switch", 0);
      ab.i("MicroMsg.CoreServiceUtil", "ifUseOnlyBindToCoreService() huaweiEnable:%s", new Object[] { Integer.valueOf(i) });
      if (bo.hl(i, 0))
      {
        ab.i("MicroMsg.CoreServiceUtil", "ifUseOnlyBindToCoreService() true (huawei)");
        AppMethodBeat.o(57752);
        return true;
      }
    }
    if ((d.fv(26)) && (!If()))
    {
      ab.i("MicroMsg.CoreServiceUtil", "ifUseOnlyBindToCoreService() true");
      AppMethodBeat.o(57752);
      return true;
    }
    ab.i("MicroMsg.CoreServiceUtil", "ifUseOnlyBindToCoreService() false");
    AppMethodBeat.o(57752);
    return false;
  }
  
  public static void bD(boolean paramBoolean)
  {
    AppMethodBeat.i(57748);
    as.apq("service_launch_way").edit().putBoolean("target26_start_service", paramBoolean).commit();
    ab.i("MicroMsg.CoreServiceUtil", "setTarget26StartService() enable: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(57748);
  }
  
  public static boolean bs(Context paramContext)
  {
    AppMethodBeat.i(57750);
    if (Build.VERSION.SDK_INT >= 23)
    {
      boolean bool = ((PowerManager)paramContext.getSystemService("power")).isIgnoringBatteryOptimizations(paramContext.getPackageName());
      ab.i("MicroMsg.CoreServiceUtil", "ifIgnoreBatteryOptimizations() result=%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(57750);
      return bool;
    }
    AppMethodBeat.o(57750);
    return true;
  }
  
  public static void jdMethod_if(int paramInt)
  {
    AppMethodBeat.i(57746);
    Ih().edit().putInt("huawei_switch", paramInt).commit();
    ab.i("MicroMsg.CoreServiceUtil", "setTarget26StartServiceHuawei() enable: %s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(57746);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.booter.c
 * JD-Core Version:    0.7.0.1
 */