package com.tencent.mm.cd;

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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.al;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class a
{
  private static Boolean HVA;
  private static boolean HVD;
  private static boolean HVE;
  private static boolean HVo;
  public static String HVp;
  public static String HVq;
  public static String HVr;
  public static String HVs;
  public static String HVt;
  public static String HVu;
  static float HVv;
  private static boolean HVw;
  static a HVx;
  private static Boolean HVy;
  private static Boolean HVz;
  static int psI;
  private Method HVB;
  private Field HVC;
  DisplayMetrics HVn;
  DisplayMetrics aJt;
  
  static
  {
    AppMethodBeat.i(141210);
    HVo = true;
    HVp = "screenResolution_density_dpi";
    HVq = "screenResolution_density_dpi_new";
    HVr = "screenResolution_density_report_new";
    HVs = "screenResolution_density_report_pad";
    HVt = "screenResolution_target_field";
    HVu = "screenResolution_isModifyDensity";
    HVv = 1.0F;
    HVw = false;
    psI = 0;
    HVy = null;
    HVz = null;
    HVA = null;
    HVD = false;
    HVE = false;
    if (Build.BRAND != null)
    {
      String str = Build.BRAND.toLowerCase();
      if (((str.contains("huawei")) || (str.contains("honor"))) && (Build.VERSION.SDK_INT == 24)) {
        HVE = true;
      }
    }
    AppMethodBeat.o(141210);
  }
  
  public a(DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(141187);
    this.HVB = null;
    this.HVC = null;
    this.HVn = paramDisplayMetrics;
    Object localObject = Build.BRAND;
    if (!bt.isNullOrNil((String)localObject))
    {
      localObject = ((String)localObject).toLowerCase();
      if (((((String)localObject).contains("huawei")) || (((String)localObject).contains("honor"))) && (paramDisplayMetrics != null) && (Math.min(paramDisplayMetrics.widthPixels, paramDisplayMetrics.heightPixels) == 720) && ((Build.VERSION.SDK_INT == 26) || (Build.VERSION.SDK_INT == 27)))
      {
        ad.i("MicroMsg.MMDensityManager", "dancy huaweiSpecial 720!!");
        bool = true;
        HVw = bool;
        psI = al.getDeviceWidth();
        if (!aj.cnC()) {
          break label270;
        }
        HVo = fhI();
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
        aj.getContext().registerReceiver(new BroadcastReceiver()
        {
          public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(141186);
            if (paramAnonymousIntent.getAction().equalsIgnoreCase("android.intent.action.SCREEN_OFF"))
            {
              if (a.fhR())
              {
                AppMethodBeat.o(141186);
                return;
              }
              if (a.fhS())
              {
                a.fhT();
                AppMethodBeat.o(141186);
                return;
              }
              if ((a.fhU()) && (a.fhF()))
              {
                ad.i("MicroMsg.MMDensityManager", "killSelfAndCallUp ");
                a.fhT();
              }
            }
            AppMethodBeat.o(141186);
          }
        }, (IntentFilter)localObject);
      }
    }
    label270:
    do
    {
      localObject = aj.getContext().getSharedPreferences(aj.fkC(), 0).edit();
      ((SharedPreferences.Editor)localObject).putBoolean(HVu, fhO());
      ((SharedPreferences.Editor)localObject).commit();
      if (!fhO()) {
        break label340;
      }
      this.aJt = c(paramDisplayMetrics);
      paramDisplayMetrics.setTo(this.aJt);
      if (Build.VERSION.SDK_INT >= 21) {
        aj.getContext().getTheme().getResources().getDisplayMetrics().setTo(this.aJt);
      }
      ad.i("MicroMsg.MMDensityManager", " Target DisplayMetrics[%s]", new Object[] { this.aJt });
      AppMethodBeat.o(141187);
      return;
      bool = false;
      break;
      if (aj.isAppBrandProcess())
      {
        if ((fhI()) && (fhJ())) {}
        for (bool = true;; bool = false)
        {
          HVo = bool;
          break;
        }
      }
    } while ((!aj.fkI()) && (!aj.fkJ()));
    if ((fhI()) && (fhK())) {}
    for (boolean bool = true;; bool = false)
    {
      HVo = bool;
      break;
    }
    label340:
    HVv = 400.0F / (Math.min(this.HVn.widthPixels, paramDisplayMetrics.heightPixels) / this.HVn.density);
    this.aJt = this.HVn;
    AppMethodBeat.o(141187);
  }
  
  public static void a(a parama)
  {
    HVx = parama;
  }
  
  public static void aad(int paramInt)
  {
    AppMethodBeat.i(141204);
    ax.aQz(aj.fkC()).putInt(HVt, paramInt);
    AppMethodBeat.o(141204);
  }
  
  public static DisplayMetrics c(DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(141188);
    float f1 = fhQ();
    int i;
    float f3;
    label105:
    float f2;
    if (al.fxM())
    {
      f1 = 750.0F;
      i = Math.min(paramDisplayMetrics.widthPixels, paramDisplayMetrics.heightPixels);
      f3 = i / f1;
      ad.i("MicroMsg.MMDensityManager", "applyScreenAdaptiveDensity originWidth:%s, originheight:%s, targetField:%s", new Object[] { Integer.valueOf(paramDisplayMetrics.widthPixels), Integer.valueOf(paramDisplayMetrics.heightPixels), Float.valueOf(f1) });
      if ((al.fxP() == 0) || (psI == 0)) {
        break label354;
      }
      if (i == 0) {
        break label349;
      }
      f1 = psI / i;
      if (al.fxQ() == al.fxP()) {
        break label344;
      }
      f2 = f1 * (al.fxQ() / al.fxP());
      label126:
      f1 = f2;
      if (f2 < 0.95F) {
        f1 = 0.95F;
      }
      if ((!al.fxM()) && (!al.fxN())) {
        break label327;
      }
      f2 = f1;
      if (f1 > 1.5F) {
        f2 = 1.5F;
      }
      label166:
      HVv *= f2;
      f1 = f3 * f2;
      ad.i("MicroMsg.MMDensityManager", "scale targetDensity:%s , DeviceDpi:%s, WindowDpi:%s, DeviceWidth:%s, DisplayWidth:%s, dpiScale:%s", new Object[] { Float.valueOf(f1), Integer.valueOf(al.fxP()), Integer.valueOf(al.fxQ()), Integer.valueOf(psI), Integer.valueOf(i), Float.valueOf(f2) });
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
      if (al.fxN())
      {
        f1 = 600.0F;
        break;
      }
      HVv = 400.0F / f1;
      break;
      label327:
      f2 = f1;
      if (f1 <= 1.2F) {
        break label166;
      }
      f2 = 1.2F;
      break label166;
      label344:
      f2 = 1.0F;
      break label126;
      label349:
      f1 = 1.0F;
      break label105;
      label354:
      f1 = f3;
    }
  }
  
  static String d(DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(141200);
    paramDisplayMetrics = String.format("scaledDensity:%s densityDpi:%s density:%s", new Object[] { Float.valueOf(paramDisplayMetrics.scaledDensity), Integer.valueOf(paramDisplayMetrics.densityDpi), Float.valueOf(paramDisplayMetrics.density) });
    AppMethodBeat.o(141200);
    return paramDisplayMetrics;
  }
  
  private static void d(Field paramField)
  {
    AppMethodBeat.i(141201);
    if (HVD)
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
      ad.printErrStackTrace("MicroMsg.MMDensityManager", paramField, "", new Object[0]);
      HVD = true;
      AppMethodBeat.o(141201);
    }
  }
  
  public static float fhE()
  {
    return HVv;
  }
  
  public static boolean fhF()
  {
    AppMethodBeat.i(141189);
    try
    {
      int i = bt.getInt(d.crP().b("clicfg_android_density_check_kill_enable", "1", false, true), 1);
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
      ad.printErrStackTrace("MicroMsg.MMDensityManager", localException, "isOpenKillSelf", new Object[0]);
      AppMethodBeat.o(141189);
    }
    return false;
  }
  
  private static boolean fhG()
  {
    AppMethodBeat.i(141190);
    if (HVy == null) {}
    try
    {
      if (bt.getInt(d.crP().b("clicfg_screen_adaptive_huawei_four", "0", false, true), 1) > 0) {
        ad.i("MicroMsg.MMDensityManager", "isOpenHuaWeiSpecialAll!!");
      }
      for (HVy = Boolean.TRUE;; HVy = Boolean.FALSE)
      {
        boolean bool = HVy.booleanValue();
        AppMethodBeat.o(141190);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.MMDensityManager", localException, "isOpenHuaWeiSpecialAll", new Object[0]);
        HVy = Boolean.FALSE;
      }
    }
  }
  
  private static boolean fhH()
  {
    AppMethodBeat.i(141191);
    if (HVz == null) {}
    try
    {
      if (bt.getInt(d.crP().b("clicfg_screen_adaptive_huawei_three", "1", false, true), 1) > 0) {
        ad.i("MicroMsg.MMDensityManager", "isOpenHuaWeiSpecial360!!");
      }
      for (HVz = Boolean.TRUE;; HVz = Boolean.FALSE)
      {
        boolean bool = HVz.booleanValue();
        AppMethodBeat.o(141191);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.MMDensityManager", localException, "isOpenHuaWeiSpecial360", new Object[0]);
        HVz = Boolean.FALSE;
      }
    }
  }
  
  public static boolean fhI()
  {
    AppMethodBeat.i(141192);
    try
    {
      int i = bt.getInt(d.crP().b("clicfg_screen_adaptive", "1", false, true), 1);
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
      ad.printErrStackTrace("MicroMsg.MMDensityManager", localException, "isOpenScreenAdaptiveForMM", new Object[0]);
      AppMethodBeat.o(141192);
      return false;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label46:
      break label46;
    }
  }
  
  private static boolean fhJ()
  {
    AppMethodBeat.i(141193);
    for (;;)
    {
      try
      {
        com.tencent.mm.l.a locala = com.tencent.mm.l.a.a.ZF();
        if (locala != null)
        {
          bool = locala.LT();
          int i;
          if (bt.getInt(d.crP().b("clicfg_screen_adaptive_appbrand", "1", false, true), 1) > 0)
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
        ad.printErrStackTrace("MicroMsg.MMDensityManager", localException, "isOpenScreenAdaptiveForAppBrand", new Object[0]);
        AppMethodBeat.o(141193);
        return false;
      }
      boolean bool = false;
    }
  }
  
  private static boolean fhK()
  {
    AppMethodBeat.i(141194);
    try
    {
      int i = bt.getInt(d.crP().b("clicfg_screen_adaptive_tool", "1", false, true), 1);
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
      ad.printErrStackTrace("MicroMsg.MMDensityManager", localException, "isOpenScreenAdaptiveForTool", new Object[0]);
      AppMethodBeat.o(141194);
    }
    return false;
  }
  
  public static float fhL()
  {
    AppMethodBeat.i(141196);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)aj.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    float f = localDisplayMetrics.density;
    AppMethodBeat.o(141196);
    return f;
  }
  
  static boolean fhN()
  {
    AppMethodBeat.i(141199);
    if ((com.tencent.mm.cc.a.ig(aj.getContext()) == 0.8F) && (fhQ() != 440))
    {
      AppMethodBeat.o(141199);
      return true;
    }
    AppMethodBeat.o(141199);
    return false;
  }
  
  public static boolean fhO()
  {
    AppMethodBeat.i(141202);
    if ((HVo) && (!fhP()))
    {
      AppMethodBeat.o(141202);
      return true;
    }
    AppMethodBeat.o(141202);
    return false;
  }
  
  public static boolean fhP()
  {
    AppMethodBeat.i(141203);
    String str = Build.BRAND;
    if (!bt.isNullOrNil(str))
    {
      if (HVE)
      {
        AppMethodBeat.o(141203);
        return true;
      }
      if ((fhG()) && (al.Ft()))
      {
        ad.i("MicroMsg.MMDensityManager", "dancy huaweiSpecial all!!");
        AppMethodBeat.o(141203);
        return true;
      }
      if ((fhH()) && (HVw))
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
  
  public static int fhQ()
  {
    AppMethodBeat.i(141205);
    int i = ax.aQz(aj.fkC()).getInt(HVt, 400);
    AppMethodBeat.o(141205);
    return i;
  }
  
  final void fhM()
  {
    AppMethodBeat.i(141198);
    try
    {
      DisplayMetrics localDisplayMetrics = getDisplayMetrics();
      if (this.HVB == null)
      {
        Method localMethod = Bitmap.class.getDeclaredMethod("setDefaultDensity", new Class[] { Integer.TYPE });
        localMethod.setAccessible(true);
        this.HVB = localMethod;
      }
      this.HVB.invoke(null, new Object[] { Integer.valueOf(localDisplayMetrics.densityDpi) });
      if (this.HVC == null)
      {
        this.HVC = DisplayMetrics.class.getDeclaredField("DENSITY_DEVICE");
        d(this.HVC);
      }
      this.HVC.setInt(null, localDisplayMetrics.densityDpi);
      AppMethodBeat.o(141198);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.MMDensityManager", localException, "", new Object[0]);
      AppMethodBeat.o(141198);
    }
  }
  
  public final Configuration g(Configuration paramConfiguration)
  {
    AppMethodBeat.i(141197);
    if (fhO())
    {
      paramConfiguration = new Configuration(paramConfiguration);
      paramConfiguration.densityDpi = getDisplayMetrics().densityDpi;
      fhM();
      AppMethodBeat.o(141197);
      return paramConfiguration;
    }
    AppMethodBeat.o(141197);
    return paramConfiguration;
  }
  
  public final DisplayMetrics getDisplayMetrics()
  {
    AppMethodBeat.i(141195);
    if (fhO())
    {
      localDisplayMetrics = new DisplayMetrics();
      localDisplayMetrics.setTo(this.aJt);
      AppMethodBeat.o(141195);
      return localDisplayMetrics;
    }
    DisplayMetrics localDisplayMetrics = this.HVn;
    AppMethodBeat.o(141195);
    return localDisplayMetrics;
  }
  
  public static abstract interface a
  {
    public abstract void Mb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cd.a
 * JD-Core Version:    0.7.0.1
 */