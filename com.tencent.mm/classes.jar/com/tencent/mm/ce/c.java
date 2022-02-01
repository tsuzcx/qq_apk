package com.tencent.mm.ce;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.a.a;
import com.tencent.mm.plugin.expt.e.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class c
{
  static DisplayMetrics aclE;
  private static boolean aclF;
  public static String aclG;
  public static String aclH;
  public static String aclI;
  public static String aclJ;
  public static String aclK;
  public static String aclL;
  static float aclM;
  private static boolean aclN;
  static a aclO;
  private static Boolean aclP;
  private static Boolean aclQ;
  private static Boolean aclR;
  private static boolean aclU;
  private static boolean aclV;
  static DisplayMetrics euS;
  static int xxg;
  private Method aclS;
  private Field aclT;
  
  static
  {
    AppMethodBeat.i(141210);
    aclF = true;
    aclG = "screenResolution_density_dpi";
    aclH = "screenResolution_density_dpi_new";
    aclI = "screenResolution_density_report_new";
    aclJ = "screenResolution_density_report_pad";
    aclK = "screenResolution_target_field";
    aclL = "screenResolution_isModifyDensity";
    aclM = 1.0F;
    aclN = false;
    xxg = 0;
    aclP = null;
    aclQ = null;
    aclR = null;
    aclU = false;
    aclV = false;
    if (Build.BRAND != null)
    {
      String str = Build.BRAND.toLowerCase();
      if (((str.contains("huawei")) || (str.contains("honor"))) && (Build.VERSION.SDK_INT == 24)) {
        aclV = true;
      }
    }
    AppMethodBeat.o(141210);
  }
  
  public c(DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(141187);
    this.aclS = null;
    this.aclT = null;
    aclE = paramDisplayMetrics;
    Object localObject = Build.BRAND;
    boolean bool;
    if (!Util.isNullOrNil((String)localObject))
    {
      localObject = ((String)localObject).toLowerCase();
      if (((((String)localObject).contains("huawei")) || (((String)localObject).contains("honor"))) && (paramDisplayMetrics != null) && (Math.min(paramDisplayMetrics.widthPixels, paramDisplayMetrics.heightPixels) == 720) && ((Build.VERSION.SDK_INT == 26) || (Build.VERSION.SDK_INT == 27)))
      {
        Log.i("MicroMsg.MMDensityManager", "dancy huaweiSpecial 720!!");
        bool = true;
        aclN = bool;
        xxg = aw.getDeviceWidth();
        if (!MMApplicationContext.isMMProcess()) {
          break label295;
        }
        aclF = iRw();
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
        MMApplicationContext.getContext().registerReceiver(new BroadcastReceiver()
        {
          public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(141186);
            if (paramAnonymousIntent.getAction().equalsIgnoreCase("android.intent.action.SCREEN_OFF"))
            {
              if (c.iRH())
              {
                AppMethodBeat.o(141186);
                return;
              }
              if (c.iRI())
              {
                c.iRJ();
                AppMethodBeat.o(141186);
                return;
              }
              if ((c.iRK()) && (c.iRt()))
              {
                Log.i("MicroMsg.MMDensityManager", "killSelfAndCallUp ");
                c.iRJ();
              }
            }
            AppMethodBeat.o(141186);
          }
        }, (IntentFilter)localObject);
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.MMDensityManager", "openScreenAdaptive:%s %s", new Object[] { Boolean.valueOf(aclF), Boolean.valueOf(iRE()) });
      localObject = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit();
      ((SharedPreferences.Editor)localObject).putBoolean(aclL, iRE());
      ((SharedPreferences.Editor)localObject).commit();
      if (!iRE()) {
        break label378;
      }
      euS = d(paramDisplayMetrics);
      paramDisplayMetrics.setTo(euS);
      if (Build.VERSION.SDK_INT >= 21) {
        MMApplicationContext.getContext().getTheme().getResources().getDisplayMetrics().setTo(euS);
      }
      Log.i("MicroMsg.MMDensityManager", " Target DisplayMetrics[%s]", new Object[] { euS });
      AppMethodBeat.o(141187);
      return;
      bool = false;
      break;
      label295:
      if (MMApplicationContext.isAppBrandProcess())
      {
        if ((iRw()) && (iRx())) {}
        for (bool = true;; bool = false)
        {
          aclF = bool;
          break;
        }
      }
      if ((MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()))
      {
        if ((iRw()) && (iRy())) {}
        for (bool = true;; bool = false)
        {
          aclF = bool;
          break;
        }
      }
      if (MMApplicationContext.isImeProcess()) {
        aclF = false;
      }
    }
    label378:
    aclM = 400.0F / (Math.min(aclE.widthPixels, paramDisplayMetrics.heightPixels) / aclE.density);
    euS = aclE;
    AppMethodBeat.o(141187);
  }
  
  public static void a(a parama)
  {
    aclO = parama;
  }
  
  public static void axV(int paramInt)
  {
    AppMethodBeat.i(141204);
    MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putInt(aclK, paramInt);
    AppMethodBeat.o(141204);
  }
  
  public static DisplayMetrics d(DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(141188);
    float f1 = iRG();
    int i = aw.jkR();
    float f3;
    label128:
    float f2;
    if (i >= 600)
    {
      f1 = 700.0F;
      aclM = 1.0F;
      i = Math.min(paramDisplayMetrics.widthPixels, paramDisplayMetrics.heightPixels);
      f3 = i / f1;
      Log.i("MicroMsg.MMDensityManager", "applyScreenAdaptiveDensity originWidth:%s, originheight:%s, targetField:%s, screenWidth:%s", new Object[] { Integer.valueOf(paramDisplayMetrics.widthPixels), Integer.valueOf(paramDisplayMetrics.heightPixels), Float.valueOf(f1), Integer.valueOf(i) });
      int j = aw.jle();
      if ((j == 0) || (xxg == 0)) {
        break label394;
      }
      if (i == 0) {
        break label389;
      }
      f1 = xxg / i;
      int k = aw.jlf();
      if (k == j) {
        break label384;
      }
      f2 = f1 * (k / j);
      label150:
      f1 = f2;
      if (f2 < 0.95F) {
        f1 = 0.95F;
      }
      if ((!aw.jkP()) && (!aw.jkQ())) {
        break label367;
      }
      f2 = f1;
      if (f1 > 1.5F) {
        f2 = 1.5F;
      }
      label190:
      aclM *= f2;
      f1 = f3 * f2;
      Log.i("MicroMsg.MMDensityManager", "scale targetDensity:%s , DeviceDpi:%s, WindowDpi:%s, DeviceWidth:%s, DisplayWidth:%s, dpiScale:%s, systemScale:%s", new Object[] { Float.valueOf(f1), Integer.valueOf(aw.jle()), Integer.valueOf(aw.jlf()), Integer.valueOf(xxg), Integer.valueOf(i), Float.valueOf(f2), Float.valueOf(aclM) });
    }
    for (;;)
    {
      f2 = paramDisplayMetrics.scaledDensity / paramDisplayMetrics.density;
      i = (int)(160.0F * f1);
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      localDisplayMetrics.setTo(paramDisplayMetrics);
      localDisplayMetrics.scaledDensity = (f2 * f1);
      localDisplayMetrics.densityDpi = i;
      localDisplayMetrics.density = f1;
      AppMethodBeat.o(141188);
      return localDisplayMetrics;
      if (i >= 533)
      {
        f1 = 600.0F;
        aclM = 1.0F;
        break;
      }
      aclM = 400.0F / f1;
      break;
      label367:
      f2 = f1;
      if (f1 <= 1.2F) {
        break label190;
      }
      f2 = 1.2F;
      break label190;
      label384:
      f2 = 1.0F;
      break label150;
      label389:
      f1 = 1.0F;
      break label128;
      label394:
      f1 = f3;
    }
  }
  
  public static void e(DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(233094);
    if (iRE())
    {
      paramDisplayMetrics.density = euS.density;
      paramDisplayMetrics.densityDpi = euS.densityDpi;
      paramDisplayMetrics.scaledDensity = euS.scaledDensity;
      euS.setTo(paramDisplayMetrics);
    }
    AppMethodBeat.o(233094);
  }
  
  static String f(DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(141200);
    if (paramDisplayMetrics != null)
    {
      paramDisplayMetrics = String.format("scaledDensity:%s densityDpi:%s density:%s", new Object[] { Float.valueOf(paramDisplayMetrics.scaledDensity), Integer.valueOf(paramDisplayMetrics.densityDpi), Float.valueOf(paramDisplayMetrics.density) });
      AppMethodBeat.o(141200);
      return paramDisplayMetrics;
    }
    AppMethodBeat.o(141200);
    return "";
  }
  
  private static void g(Field paramField)
  {
    AppMethodBeat.i(141201);
    if (aclU)
    {
      AppMethodBeat.o(141201);
      return;
    }
    try
    {
      paramField.setAccessible(true);
      Field localField = Field.class.getDeclaredField("accessFlags");
      localField.setAccessible(true);
      localField.setInt(paramField, paramField.getModifiers() & 0xFFFFFFEF);
      AppMethodBeat.o(141201);
      return;
    }
    catch (Exception paramField)
    {
      Log.printErrStackTrace("MicroMsg.MMDensityManager", paramField, "", new Object[0]);
      aclU = true;
      AppMethodBeat.o(141201);
    }
  }
  
  public static DisplayMetrics getDisplayMetrics()
  {
    AppMethodBeat.i(141195);
    if (iRE())
    {
      localDisplayMetrics = new DisplayMetrics();
      localDisplayMetrics.setTo(euS);
      AppMethodBeat.o(141195);
      return localDisplayMetrics;
    }
    DisplayMetrics localDisplayMetrics = aclE;
    AppMethodBeat.o(141195);
    return localDisplayMetrics;
  }
  
  public static float iRA()
  {
    AppMethodBeat.i(141196);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    float f = localDisplayMetrics.density;
    AppMethodBeat.o(141196);
    return f;
  }
  
  static boolean iRC()
  {
    AppMethodBeat.i(141199);
    if ((com.tencent.mm.cd.a.mk(MMApplicationContext.getContext()) == 0.8F) && (iRG() != 440))
    {
      AppMethodBeat.o(141199);
      return true;
    }
    AppMethodBeat.o(141199);
    return false;
  }
  
  public static void iRD()
  {
    AppMethodBeat.i(233117);
    Log.i("AppBrandWidgetAccessibility", "forceResetOpenScreenAdaptive");
    aclF = false;
    AppMethodBeat.o(233117);
  }
  
  public static boolean iRE()
  {
    AppMethodBeat.i(141202);
    if ((aclF) && (!iRF()))
    {
      AppMethodBeat.o(141202);
      return true;
    }
    AppMethodBeat.o(141202);
    return false;
  }
  
  public static boolean iRF()
  {
    AppMethodBeat.i(141203);
    String str = Build.BRAND;
    if (!Util.isNullOrNil(str))
    {
      if (aclV)
      {
        AppMethodBeat.o(141203);
        return true;
      }
      if ((iRu()) && (aw.atm()))
      {
        Log.i("MicroMsg.MMDensityManager", "dancy huaweiSpecial all!!");
        AppMethodBeat.o(141203);
        return true;
      }
      if ((iRv()) && (aclN))
      {
        AppMethodBeat.o(141203);
        return true;
      }
      if ((str.contains("samsung")) && (Build.VERSION.SDK_INT == 23))
      {
        AppMethodBeat.o(141203);
        return true;
      }
    }
    AppMethodBeat.o(141203);
    return false;
  }
  
  public static int iRG()
  {
    AppMethodBeat.i(141205);
    int i = MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getInt(aclK, 400);
    AppMethodBeat.o(141205);
    return i;
  }
  
  public static float iRs()
  {
    return aclM;
  }
  
  public static boolean iRt()
  {
    AppMethodBeat.i(141189);
    try
    {
      int i = Util.getInt(d.dNI().a("clicfg_android_density_check_kill_enable", "1", false, true), 1);
      if (i > 0)
      {
        AppMethodBeat.o(141189);
        return true;
      }
      AppMethodBeat.o(141189);
      return false;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MMDensityManager", localException, "isOpenKillSelf", new Object[0]);
      AppMethodBeat.o(141189);
    }
    return false;
  }
  
  private static boolean iRu()
  {
    AppMethodBeat.i(141190);
    if (aclP == null) {}
    try
    {
      if (Util.getInt(d.dNI().a("clicfg_screen_adaptive_huawei_four", "0", false, true), 1) > 0) {
        Log.i("MicroMsg.MMDensityManager", "isOpenHuaWeiSpecialAll!!");
      }
      for (aclP = Boolean.TRUE;; aclP = Boolean.FALSE)
      {
        boolean bool = aclP.booleanValue();
        AppMethodBeat.o(141190);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.MMDensityManager", localException, "isOpenHuaWeiSpecialAll", new Object[0]);
        aclP = Boolean.FALSE;
      }
    }
  }
  
  private static boolean iRv()
  {
    AppMethodBeat.i(141191);
    if (aclQ == null) {}
    try
    {
      if (Util.getInt(d.dNI().a("clicfg_screen_adaptive_huawei_three", "1", false, true), 1) > 0) {
        Log.i("MicroMsg.MMDensityManager", "isOpenHuaWeiSpecial360!!");
      }
      for (aclQ = Boolean.TRUE;; aclQ = Boolean.FALSE)
      {
        boolean bool = aclQ.booleanValue();
        AppMethodBeat.o(141191);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.MMDensityManager", localException, "isOpenHuaWeiSpecial360", new Object[0]);
        aclQ = Boolean.FALSE;
      }
    }
  }
  
  public static boolean iRw()
  {
    AppMethodBeat.i(141192);
    try
    {
      int i = Util.getInt(d.dNI().a("clicfg_screen_adaptive", "1", false, true), 1);
      if (i > 0)
      {
        AppMethodBeat.o(141192);
        return true;
      }
      AppMethodBeat.o(141192);
      return false;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MMDensityManager", localException, "isOpenScreenAdaptiveForMM", new Object[0]);
      AppMethodBeat.o(141192);
      return false;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label46:
      break label46;
    }
  }
  
  private static boolean iRx()
  {
    AppMethodBeat.i(141193);
    for (;;)
    {
      try
      {
        com.tencent.mm.i.a locala = a.a.aOa();
        if (locala != null)
        {
          bool = locala.aNZ();
          int i;
          if (Util.getInt(d.dNI().a("clicfg_screen_adaptive_appbrand", "0", false, true), 1) > 0)
          {
            i = 1;
            if ((i != 0) && (bool))
            {
              AppMethodBeat.o(141193);
              return true;
            }
          }
          else
          {
            i = 0;
            continue;
          }
          AppMethodBeat.o(141193);
          return false;
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.MMDensityManager", localException, "isOpenScreenAdaptiveForAppBrand", new Object[0]);
        AppMethodBeat.o(141193);
        return false;
      }
      boolean bool = true;
    }
  }
  
  private static boolean iRy()
  {
    AppMethodBeat.i(141194);
    try
    {
      int i = Util.getInt(d.dNI().a("clicfg_screen_adaptive_tool", "1", false, true), 1);
      if (i > 0)
      {
        AppMethodBeat.o(141194);
        return true;
      }
      AppMethodBeat.o(141194);
      return false;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MMDensityManager", localException, "isOpenScreenAdaptiveForTool", new Object[0]);
      AppMethodBeat.o(141194);
    }
    return false;
  }
  
  public static DisplayMetrics iRz()
  {
    return aclE;
  }
  
  public final Configuration h(Configuration paramConfiguration)
  {
    AppMethodBeat.i(141197);
    if (iRE())
    {
      paramConfiguration = new Configuration(paramConfiguration);
      paramConfiguration.densityDpi = getDisplayMetrics().densityDpi;
      iRB();
      AppMethodBeat.o(141197);
      return paramConfiguration;
    }
    AppMethodBeat.o(141197);
    return paramConfiguration;
  }
  
  final void iRB()
  {
    AppMethodBeat.i(141198);
    try
    {
      DisplayMetrics localDisplayMetrics = getDisplayMetrics();
      if (this.aclS == null)
      {
        Method localMethod = Bitmap.class.getDeclaredMethod("setDefaultDensity", new Class[] { Integer.TYPE });
        localMethod.setAccessible(true);
        this.aclS = localMethod;
      }
      this.aclS.invoke(null, new Object[] { Integer.valueOf(localDisplayMetrics.densityDpi) });
      if (this.aclT == null)
      {
        this.aclT = DisplayMetrics.class.getDeclaredField("DENSITY_DEVICE");
        g(this.aclT);
      }
      this.aclT.setInt(null, localDisplayMetrics.densityDpi);
      AppMethodBeat.o(141198);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MMDensityManager", localException, "", new Object[0]);
      AppMethodBeat.o(141198);
    }
  }
  
  public static abstract interface a
  {
    public abstract void aCy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ce.c
 * JD-Core Version:    0.7.0.1
 */