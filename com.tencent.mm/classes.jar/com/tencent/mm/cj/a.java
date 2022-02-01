package com.tencent.mm.cj;

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
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class a
{
  private static Boolean UQA;
  private static Boolean UQB;
  private static Boolean UQC;
  private static boolean UQF;
  private static boolean UQG;
  static DisplayMetrics UQp;
  private static boolean UQq;
  public static String UQr;
  public static String UQs;
  public static String UQt;
  public static String UQu;
  public static String UQv;
  public static String UQw;
  static float UQx;
  private static boolean UQy;
  static a UQz;
  static int uqJ;
  private Method UQD;
  private Field UQE;
  DisplayMetrics cCm;
  
  static
  {
    AppMethodBeat.i(141210);
    UQq = true;
    UQr = "screenResolution_density_dpi";
    UQs = "screenResolution_density_dpi_new";
    UQt = "screenResolution_density_report_new";
    UQu = "screenResolution_density_report_pad";
    UQv = "screenResolution_target_field";
    UQw = "screenResolution_isModifyDensity";
    UQx = 1.0F;
    UQy = false;
    uqJ = 0;
    UQA = null;
    UQB = null;
    UQC = null;
    UQF = false;
    UQG = false;
    if (Build.BRAND != null)
    {
      String str = Build.BRAND.toLowerCase();
      if (((str.contains("huawei")) || (str.contains("honor"))) && (Build.VERSION.SDK_INT == 24)) {
        UQG = true;
      }
    }
    AppMethodBeat.o(141210);
  }
  
  public a(DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(141187);
    this.UQD = null;
    this.UQE = null;
    UQp = paramDisplayMetrics;
    Object localObject = Build.BRAND;
    boolean bool;
    if (!Util.isNullOrNil((String)localObject))
    {
      localObject = ((String)localObject).toLowerCase();
      if (((((String)localObject).contains("huawei")) || (((String)localObject).contains("honor"))) && (paramDisplayMetrics != null) && (Math.min(paramDisplayMetrics.widthPixels, paramDisplayMetrics.heightPixels) == 720) && ((Build.VERSION.SDK_INT == 26) || (Build.VERSION.SDK_INT == 27)))
      {
        Log.i("MicroMsg.MMDensityManager", "dancy huaweiSpecial 720!!");
        bool = true;
        UQy = bool;
        uqJ = ar.getDeviceWidth();
        if (!MMApplicationContext.isMMProcess()) {
          break label299;
        }
        UQq = hrh();
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
        MMApplicationContext.getContext().registerReceiver(new BroadcastReceiver()
        {
          public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(141186);
            if (paramAnonymousIntent.getAction().equalsIgnoreCase("android.intent.action.SCREEN_OFF"))
            {
              if (a.hrr())
              {
                AppMethodBeat.o(141186);
                return;
              }
              if (a.hrs())
              {
                a.hrt();
                AppMethodBeat.o(141186);
                return;
              }
              if ((a.hru()) && (a.hre()))
              {
                Log.i("MicroMsg.MMDensityManager", "killSelfAndCallUp ");
                a.hrt();
              }
            }
            AppMethodBeat.o(141186);
          }
        }, (IntentFilter)localObject);
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.MMDensityManager", "openScreenAdaptive:%s %s", new Object[] { Boolean.valueOf(UQq), Boolean.valueOf(hro()) });
      localObject = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit();
      ((SharedPreferences.Editor)localObject).putBoolean(UQw, hro());
      ((SharedPreferences.Editor)localObject).commit();
      if (!hro()) {
        break label382;
      }
      this.cCm = b(paramDisplayMetrics);
      paramDisplayMetrics.setTo(this.cCm);
      if (Build.VERSION.SDK_INT >= 21) {
        MMApplicationContext.getContext().getTheme().getResources().getDisplayMetrics().setTo(this.cCm);
      }
      Log.i("MicroMsg.MMDensityManager", " Target DisplayMetrics[%s]", new Object[] { this.cCm });
      AppMethodBeat.o(141187);
      return;
      bool = false;
      break;
      label299:
      if (MMApplicationContext.isAppBrandProcess())
      {
        if ((hrh()) && (hri())) {}
        for (bool = true;; bool = false)
        {
          UQq = bool;
          break;
        }
      }
      if ((MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()))
      {
        if ((hrh()) && (hrj())) {}
        for (bool = true;; bool = false)
        {
          UQq = bool;
          break;
        }
      }
      if (MMApplicationContext.isImeProcess()) {
        UQq = false;
      }
    }
    label382:
    UQx = 400.0F / (Math.min(UQp.widthPixels, paramDisplayMetrics.heightPixels) / UQp.density);
    this.cCm = UQp;
    AppMethodBeat.o(141187);
  }
  
  public static void a(a parama)
  {
    UQz = parama;
  }
  
  public static void arQ(int paramInt)
  {
    AppMethodBeat.i(141204);
    MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putInt(UQv, paramInt);
    AppMethodBeat.o(141204);
  }
  
  public static DisplayMetrics b(DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(141188);
    float f1 = hrq();
    int i;
    float f3;
    label116:
    float f2;
    if (ar.hIG() >= 600)
    {
      f1 = 700.0F;
      i = Math.min(paramDisplayMetrics.widthPixels, paramDisplayMetrics.heightPixels);
      f3 = i / f1;
      Log.i("MicroMsg.MMDensityManager", "applyScreenAdaptiveDensity originWidth:%s, originheight:%s, targetField:%s, screenWidth:%s", new Object[] { Integer.valueOf(paramDisplayMetrics.widthPixels), Integer.valueOf(paramDisplayMetrics.heightPixels), Float.valueOf(f1), Integer.valueOf(i) });
      if ((ar.hIQ() == 0) || (uqJ == 0)) {
        break label368;
      }
      if (i == 0) {
        break label363;
      }
      f1 = uqJ / i;
      if (ar.hIR() == ar.hIQ()) {
        break label358;
      }
      f2 = f1 * (ar.hIR() / ar.hIQ());
      label137:
      f1 = f2;
      if (f2 < 0.95F) {
        f1 = 0.95F;
      }
      if ((!ar.hIE()) && (!ar.hIF())) {
        break label341;
      }
      f2 = f1;
      if (f1 > 1.5F) {
        f2 = 1.5F;
      }
      label177:
      UQx *= f2;
      f1 = f3 * f2;
      Log.i("MicroMsg.MMDensityManager", "scale targetDensity:%s , DeviceDpi:%s, WindowDpi:%s, DeviceWidth:%s, DisplayWidth:%s, dpiScale:%s", new Object[] { Float.valueOf(f1), Integer.valueOf(ar.hIQ()), Integer.valueOf(ar.hIR()), Integer.valueOf(uqJ), Integer.valueOf(i), Float.valueOf(f2) });
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
      if (ar.hIG() >= 533)
      {
        f1 = 600.0F;
        break;
      }
      UQx = 400.0F / f1;
      break;
      label341:
      f2 = f1;
      if (f1 <= 1.2F) {
        break label177;
      }
      f2 = 1.2F;
      break label177;
      label358:
      f2 = 1.0F;
      break label137;
      label363:
      f1 = 1.0F;
      break label116;
      label368:
      f1 = f3;
    }
  }
  
  static String c(DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(141200);
    paramDisplayMetrics = String.format("scaledDensity:%s densityDpi:%s density:%s", new Object[] { Float.valueOf(paramDisplayMetrics.scaledDensity), Integer.valueOf(paramDisplayMetrics.densityDpi), Float.valueOf(paramDisplayMetrics.density) });
    AppMethodBeat.o(141200);
    return paramDisplayMetrics;
  }
  
  private static void f(Field paramField)
  {
    AppMethodBeat.i(141201);
    if (UQF)
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
      UQF = true;
      AppMethodBeat.o(141201);
    }
  }
  
  public static float hrd()
  {
    return UQx;
  }
  
  public static boolean hre()
  {
    AppMethodBeat.i(141189);
    try
    {
      int i = Util.getInt(d.dgX().a("clicfg_android_density_check_kill_enable", "1", false, true), 1);
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
  
  private static boolean hrf()
  {
    AppMethodBeat.i(141190);
    if (UQA == null) {}
    try
    {
      if (Util.getInt(d.dgX().a("clicfg_screen_adaptive_huawei_four", "0", false, true), 1) > 0) {
        Log.i("MicroMsg.MMDensityManager", "isOpenHuaWeiSpecialAll!!");
      }
      for (UQA = Boolean.TRUE;; UQA = Boolean.FALSE)
      {
        boolean bool = UQA.booleanValue();
        AppMethodBeat.o(141190);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.MMDensityManager", localException, "isOpenHuaWeiSpecialAll", new Object[0]);
        UQA = Boolean.FALSE;
      }
    }
  }
  
  private static boolean hrg()
  {
    AppMethodBeat.i(141191);
    if (UQB == null) {}
    try
    {
      if (Util.getInt(d.dgX().a("clicfg_screen_adaptive_huawei_three", "1", false, true), 1) > 0) {
        Log.i("MicroMsg.MMDensityManager", "isOpenHuaWeiSpecial360!!");
      }
      for (UQB = Boolean.TRUE;; UQB = Boolean.FALSE)
      {
        boolean bool = UQB.booleanValue();
        AppMethodBeat.o(141191);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.MMDensityManager", localException, "isOpenHuaWeiSpecial360", new Object[0]);
        UQB = Boolean.FALSE;
      }
    }
  }
  
  public static boolean hrh()
  {
    AppMethodBeat.i(141192);
    try
    {
      int i = Util.getInt(d.dgX().a("clicfg_screen_adaptive", "1", false, true), 1);
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
  
  private static boolean hri()
  {
    AppMethodBeat.i(141193);
    for (;;)
    {
      try
      {
        com.tencent.mm.l.a locala = com.tencent.mm.l.a.a.atC();
        if (locala != null)
        {
          bool = locala.aaJ();
          int i;
          if (Util.getInt(d.dgX().a("clicfg_screen_adaptive_appbrand", "1", false, true), 1) > 0)
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
      boolean bool = false;
    }
  }
  
  private static boolean hrj()
  {
    AppMethodBeat.i(141194);
    try
    {
      int i = Util.getInt(d.dgX().a("clicfg_screen_adaptive_tool", "1", false, true), 1);
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
  
  public static DisplayMetrics hrk()
  {
    return UQp;
  }
  
  public static float hrl()
  {
    AppMethodBeat.i(141196);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    float f = localDisplayMetrics.density;
    AppMethodBeat.o(141196);
    return f;
  }
  
  static boolean hrn()
  {
    AppMethodBeat.i(141199);
    if ((com.tencent.mm.ci.a.ki(MMApplicationContext.getContext()) == 0.8F) && (hrq() != 440))
    {
      AppMethodBeat.o(141199);
      return true;
    }
    AppMethodBeat.o(141199);
    return false;
  }
  
  public static boolean hro()
  {
    AppMethodBeat.i(141202);
    if ((UQq) && (!hrp()))
    {
      AppMethodBeat.o(141202);
      return true;
    }
    AppMethodBeat.o(141202);
    return false;
  }
  
  public static boolean hrp()
  {
    AppMethodBeat.i(141203);
    String str = Build.BRAND;
    if (!Util.isNullOrNil(str))
    {
      if (UQG)
      {
        AppMethodBeat.o(141203);
        return true;
      }
      if ((hrf()) && (ar.SI()))
      {
        Log.i("MicroMsg.MMDensityManager", "dancy huaweiSpecial all!!");
        AppMethodBeat.o(141203);
        return true;
      }
      if ((hrg()) && (UQy))
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
  
  public static int hrq()
  {
    AppMethodBeat.i(141205);
    int i = MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getInt(UQv, 400);
    AppMethodBeat.o(141205);
    return i;
  }
  
  public final Configuration f(Configuration paramConfiguration)
  {
    AppMethodBeat.i(141197);
    if (hro())
    {
      paramConfiguration = new Configuration(paramConfiguration);
      paramConfiguration.densityDpi = getDisplayMetrics().densityDpi;
      hrm();
      AppMethodBeat.o(141197);
      return paramConfiguration;
    }
    AppMethodBeat.o(141197);
    return paramConfiguration;
  }
  
  public final DisplayMetrics getDisplayMetrics()
  {
    AppMethodBeat.i(141195);
    if (hro())
    {
      localDisplayMetrics = new DisplayMetrics();
      localDisplayMetrics.setTo(this.cCm);
      AppMethodBeat.o(141195);
      return localDisplayMetrics;
    }
    DisplayMetrics localDisplayMetrics = UQp;
    AppMethodBeat.o(141195);
    return localDisplayMetrics;
  }
  
  final void hrm()
  {
    AppMethodBeat.i(141198);
    try
    {
      DisplayMetrics localDisplayMetrics = getDisplayMetrics();
      if (this.UQD == null)
      {
        Method localMethod = Bitmap.class.getDeclaredMethod("setDefaultDensity", new Class[] { Integer.TYPE });
        localMethod.setAccessible(true);
        this.UQD = localMethod;
      }
      this.UQD.invoke(null, new Object[] { Integer.valueOf(localDisplayMetrics.densityDpi) });
      if (this.UQE == null)
      {
        this.UQE = DisplayMetrics.class.getDeclaredField("DENSITY_DEVICE");
        f(this.UQE);
      }
      this.UQE.setInt(null, localDisplayMetrics.densityDpi);
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
    public abstract void aaP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.cj.a
 * JD-Core Version:    0.7.0.1
 */