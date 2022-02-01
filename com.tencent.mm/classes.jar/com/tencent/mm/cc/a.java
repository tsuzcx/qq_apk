package com.tencent.mm.cc;

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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class a
{
  public static String IpA;
  public static String IpB;
  public static String IpC;
  static float IpD;
  private static boolean IpE;
  static a IpF;
  private static Boolean IpG;
  private static Boolean IpH;
  private static Boolean IpI;
  private static boolean IpL;
  private static boolean IpM;
  private static boolean Ipw;
  public static String Ipx;
  public static String Ipy;
  public static String Ipz;
  static int pzo;
  private Method IpJ;
  private Field IpK;
  DisplayMetrics Ipv;
  DisplayMetrics aJt;
  
  static
  {
    AppMethodBeat.i(141210);
    Ipw = true;
    Ipx = "screenResolution_density_dpi";
    Ipy = "screenResolution_density_dpi_new";
    Ipz = "screenResolution_density_report_new";
    IpA = "screenResolution_density_report_pad";
    IpB = "screenResolution_target_field";
    IpC = "screenResolution_isModifyDensity";
    IpD = 1.0F;
    IpE = false;
    pzo = 0;
    IpG = null;
    IpH = null;
    IpI = null;
    IpL = false;
    IpM = false;
    if (Build.BRAND != null)
    {
      String str = Build.BRAND.toLowerCase();
      if (((str.contains("huawei")) || (str.contains("honor"))) && (Build.VERSION.SDK_INT == 24)) {
        IpM = true;
      }
    }
    AppMethodBeat.o(141210);
  }
  
  public a(DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(141187);
    this.IpJ = null;
    this.IpK = null;
    this.Ipv = paramDisplayMetrics;
    Object localObject = Build.BRAND;
    if (!bu.isNullOrNil((String)localObject))
    {
      localObject = ((String)localObject).toLowerCase();
      if (((((String)localObject).contains("huawei")) || (((String)localObject).contains("honor"))) && (paramDisplayMetrics != null) && (Math.min(paramDisplayMetrics.widthPixels, paramDisplayMetrics.heightPixels) == 720) && ((Build.VERSION.SDK_INT == 26) || (Build.VERSION.SDK_INT == 27)))
      {
        ae.i("MicroMsg.MMDensityManager", "dancy huaweiSpecial 720!!");
        bool = true;
        IpE = bool;
        pzo = al.getDeviceWidth();
        if (!ak.cpe()) {
          break label270;
        }
        Ipw = flA();
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
        ak.getContext().registerReceiver(new BroadcastReceiver()
        {
          public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(141186);
            if (paramAnonymousIntent.getAction().equalsIgnoreCase("android.intent.action.SCREEN_OFF"))
            {
              if (a.flJ())
              {
                AppMethodBeat.o(141186);
                return;
              }
              if (a.flK())
              {
                a.flL();
                AppMethodBeat.o(141186);
                return;
              }
              if ((a.flM()) && (a.flx()))
              {
                ae.i("MicroMsg.MMDensityManager", "killSelfAndCallUp ");
                a.flL();
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
      localObject = ak.getContext().getSharedPreferences(ak.fow(), 0).edit();
      ((SharedPreferences.Editor)localObject).putBoolean(IpC, flG());
      ((SharedPreferences.Editor)localObject).commit();
      if (!flG()) {
        break label340;
      }
      this.aJt = c(paramDisplayMetrics);
      paramDisplayMetrics.setTo(this.aJt);
      if (Build.VERSION.SDK_INT >= 21) {
        ak.getContext().getTheme().getResources().getDisplayMetrics().setTo(this.aJt);
      }
      ae.i("MicroMsg.MMDensityManager", " Target DisplayMetrics[%s]", new Object[] { this.aJt });
      AppMethodBeat.o(141187);
      return;
      bool = false;
      break;
      if (ak.isAppBrandProcess())
      {
        if ((flA()) && (flB())) {}
        for (bool = true;; bool = false)
        {
          Ipw = bool;
          break;
        }
      }
    } while ((!ak.foC()) && (!ak.foD()));
    if ((flA()) && (flC())) {}
    for (boolean bool = true;; bool = false)
    {
      Ipw = bool;
      break;
    }
    label340:
    IpD = 400.0F / (Math.min(this.Ipv.widthPixels, paramDisplayMetrics.heightPixels) / this.Ipv.density);
    this.aJt = this.Ipv;
    AppMethodBeat.o(141187);
  }
  
  public static void a(a parama)
  {
    IpF = parama;
  }
  
  public static void aaJ(int paramInt)
  {
    AppMethodBeat.i(141204);
    ay.aRW(ak.fow()).putInt(IpB, paramInt);
    AppMethodBeat.o(141204);
  }
  
  public static DisplayMetrics c(DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(141188);
    float f1 = flI();
    int i;
    float f3;
    label105:
    float f2;
    if (al.fBO())
    {
      f1 = 750.0F;
      i = Math.min(paramDisplayMetrics.widthPixels, paramDisplayMetrics.heightPixels);
      f3 = i / f1;
      ae.i("MicroMsg.MMDensityManager", "applyScreenAdaptiveDensity originWidth:%s, originheight:%s, targetField:%s", new Object[] { Integer.valueOf(paramDisplayMetrics.widthPixels), Integer.valueOf(paramDisplayMetrics.heightPixels), Float.valueOf(f1) });
      if ((al.fBR() == 0) || (pzo == 0)) {
        break label354;
      }
      if (i == 0) {
        break label349;
      }
      f1 = pzo / i;
      if (al.fBS() == al.fBR()) {
        break label344;
      }
      f2 = f1 * (al.fBS() / al.fBR());
      label126:
      f1 = f2;
      if (f2 < 0.95F) {
        f1 = 0.95F;
      }
      if ((!al.fBO()) && (!al.fBP())) {
        break label327;
      }
      f2 = f1;
      if (f1 > 1.5F) {
        f2 = 1.5F;
      }
      label166:
      IpD *= f2;
      f1 = f3 * f2;
      ae.i("MicroMsg.MMDensityManager", "scale targetDensity:%s , DeviceDpi:%s, WindowDpi:%s, DeviceWidth:%s, DisplayWidth:%s, dpiScale:%s", new Object[] { Float.valueOf(f1), Integer.valueOf(al.fBR()), Integer.valueOf(al.fBS()), Integer.valueOf(pzo), Integer.valueOf(i), Float.valueOf(f2) });
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
      if (al.fBP())
      {
        f1 = 600.0F;
        break;
      }
      IpD = 400.0F / f1;
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
    if (IpL)
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
      ae.printErrStackTrace("MicroMsg.MMDensityManager", paramField, "", new Object[0]);
      IpL = true;
      AppMethodBeat.o(141201);
    }
  }
  
  public static boolean flA()
  {
    AppMethodBeat.i(141192);
    try
    {
      int i = bu.getInt(d.ctr().b("clicfg_screen_adaptive", "1", false, true), 1);
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
      ae.printErrStackTrace("MicroMsg.MMDensityManager", localException, "isOpenScreenAdaptiveForMM", new Object[0]);
      AppMethodBeat.o(141192);
      return false;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label46:
      break label46;
    }
  }
  
  private static boolean flB()
  {
    AppMethodBeat.i(141193);
    for (;;)
    {
      try
      {
        com.tencent.mm.l.a locala = com.tencent.mm.l.a.a.ZO();
        if (locala != null)
        {
          bool = locala.Mb();
          int i;
          if (bu.getInt(d.ctr().b("clicfg_screen_adaptive_appbrand", "1", false, true), 1) > 0)
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
        ae.printErrStackTrace("MicroMsg.MMDensityManager", localException, "isOpenScreenAdaptiveForAppBrand", new Object[0]);
        AppMethodBeat.o(141193);
        return false;
      }
      boolean bool = false;
    }
  }
  
  private static boolean flC()
  {
    AppMethodBeat.i(141194);
    try
    {
      int i = bu.getInt(d.ctr().b("clicfg_screen_adaptive_tool", "1", false, true), 1);
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
      ae.printErrStackTrace("MicroMsg.MMDensityManager", localException, "isOpenScreenAdaptiveForTool", new Object[0]);
      AppMethodBeat.o(141194);
    }
    return false;
  }
  
  public static float flD()
  {
    AppMethodBeat.i(141196);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)ak.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    float f = localDisplayMetrics.density;
    AppMethodBeat.o(141196);
    return f;
  }
  
  static boolean flF()
  {
    AppMethodBeat.i(141199);
    if ((com.tencent.mm.cb.a.il(ak.getContext()) == 0.8F) && (flI() != 440))
    {
      AppMethodBeat.o(141199);
      return true;
    }
    AppMethodBeat.o(141199);
    return false;
  }
  
  public static boolean flG()
  {
    AppMethodBeat.i(141202);
    if ((Ipw) && (!flH()))
    {
      AppMethodBeat.o(141202);
      return true;
    }
    AppMethodBeat.o(141202);
    return false;
  }
  
  public static boolean flH()
  {
    AppMethodBeat.i(141203);
    String str = Build.BRAND;
    if (!bu.isNullOrNil(str))
    {
      if (IpM)
      {
        AppMethodBeat.o(141203);
        return true;
      }
      if ((fly()) && (al.Fz()))
      {
        ae.i("MicroMsg.MMDensityManager", "dancy huaweiSpecial all!!");
        AppMethodBeat.o(141203);
        return true;
      }
      if ((flz()) && (IpE))
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
  
  public static int flI()
  {
    AppMethodBeat.i(141205);
    int i = ay.aRW(ak.fow()).getInt(IpB, 400);
    AppMethodBeat.o(141205);
    return i;
  }
  
  public static float flw()
  {
    return IpD;
  }
  
  public static boolean flx()
  {
    AppMethodBeat.i(141189);
    try
    {
      int i = bu.getInt(d.ctr().b("clicfg_android_density_check_kill_enable", "1", false, true), 1);
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
      ae.printErrStackTrace("MicroMsg.MMDensityManager", localException, "isOpenKillSelf", new Object[0]);
      AppMethodBeat.o(141189);
    }
    return false;
  }
  
  private static boolean fly()
  {
    AppMethodBeat.i(141190);
    if (IpG == null) {}
    try
    {
      if (bu.getInt(d.ctr().b("clicfg_screen_adaptive_huawei_four", "0", false, true), 1) > 0) {
        ae.i("MicroMsg.MMDensityManager", "isOpenHuaWeiSpecialAll!!");
      }
      for (IpG = Boolean.TRUE;; IpG = Boolean.FALSE)
      {
        boolean bool = IpG.booleanValue();
        AppMethodBeat.o(141190);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.MMDensityManager", localException, "isOpenHuaWeiSpecialAll", new Object[0]);
        IpG = Boolean.FALSE;
      }
    }
  }
  
  private static boolean flz()
  {
    AppMethodBeat.i(141191);
    if (IpH == null) {}
    try
    {
      if (bu.getInt(d.ctr().b("clicfg_screen_adaptive_huawei_three", "1", false, true), 1) > 0) {
        ae.i("MicroMsg.MMDensityManager", "isOpenHuaWeiSpecial360!!");
      }
      for (IpH = Boolean.TRUE;; IpH = Boolean.FALSE)
      {
        boolean bool = IpH.booleanValue();
        AppMethodBeat.o(141191);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.MMDensityManager", localException, "isOpenHuaWeiSpecial360", new Object[0]);
        IpH = Boolean.FALSE;
      }
    }
  }
  
  final void flE()
  {
    AppMethodBeat.i(141198);
    try
    {
      DisplayMetrics localDisplayMetrics = getDisplayMetrics();
      if (this.IpJ == null)
      {
        Method localMethod = Bitmap.class.getDeclaredMethod("setDefaultDensity", new Class[] { Integer.TYPE });
        localMethod.setAccessible(true);
        this.IpJ = localMethod;
      }
      this.IpJ.invoke(null, new Object[] { Integer.valueOf(localDisplayMetrics.densityDpi) });
      if (this.IpK == null)
      {
        this.IpK = DisplayMetrics.class.getDeclaredField("DENSITY_DEVICE");
        d(this.IpK);
      }
      this.IpK.setInt(null, localDisplayMetrics.densityDpi);
      AppMethodBeat.o(141198);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.MMDensityManager", localException, "", new Object[0]);
      AppMethodBeat.o(141198);
    }
  }
  
  public final Configuration g(Configuration paramConfiguration)
  {
    AppMethodBeat.i(141197);
    if (flG())
    {
      paramConfiguration = new Configuration(paramConfiguration);
      paramConfiguration.densityDpi = getDisplayMetrics().densityDpi;
      flE();
      AppMethodBeat.o(141197);
      return paramConfiguration;
    }
    AppMethodBeat.o(141197);
    return paramConfiguration;
  }
  
  public final DisplayMetrics getDisplayMetrics()
  {
    AppMethodBeat.i(141195);
    if (flG())
    {
      localDisplayMetrics = new DisplayMetrics();
      localDisplayMetrics.setTo(this.aJt);
      AppMethodBeat.o(141195);
      return localDisplayMetrics;
    }
    DisplayMetrics localDisplayMetrics = this.Ipv;
    AppMethodBeat.o(141195);
    return localDisplayMetrics;
  }
  
  public static abstract interface a
  {
    public abstract void Mj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cc.a
 * JD-Core Version:    0.7.0.1
 */