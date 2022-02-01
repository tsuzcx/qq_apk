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
import com.tencent.mm.plugin.expt.e.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class a
{
  private static boolean GjB;
  public static String GjC;
  public static String GjD;
  public static String GjE;
  public static String GjF;
  public static String GjG;
  public static String GjH;
  static float GjI;
  private static boolean GjJ;
  static a GjK;
  private static Boolean GjL;
  private static Boolean GjM;
  private static Boolean GjN;
  private static boolean GjQ;
  private static boolean GjR;
  static int oPa;
  DisplayMetrics GjA;
  private Method GjO;
  private Field GjP;
  DisplayMetrics aHC;
  
  static
  {
    AppMethodBeat.i(141210);
    GjB = true;
    GjC = "screenResolution_density_dpi";
    GjD = "screenResolution_density_dpi_new";
    GjE = "screenResolution_density_report_new";
    GjF = "screenResolution_density_report_pad";
    GjG = "screenResolution_target_field";
    GjH = "screenResolution_isModifyDensity";
    GjI = 1.0F;
    GjJ = false;
    oPa = 0;
    GjL = null;
    GjM = null;
    GjN = null;
    GjQ = false;
    GjR = false;
    if (Build.BRAND != null)
    {
      String str = Build.BRAND.toLowerCase();
      if (((str.contains("huawei")) || (str.contains("honor"))) && (Build.VERSION.SDK_INT == 24)) {
        GjR = true;
      }
    }
    AppMethodBeat.o(141210);
  }
  
  public a(DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(141187);
    this.GjO = null;
    this.GjP = null;
    this.GjA = paramDisplayMetrics;
    Object localObject = Build.BRAND;
    if (!bs.isNullOrNil((String)localObject))
    {
      localObject = ((String)localObject).toLowerCase();
      if (((((String)localObject).contains("huawei")) || (((String)localObject).contains("honor"))) && (paramDisplayMetrics != null) && (Math.min(paramDisplayMetrics.widthPixels, paramDisplayMetrics.heightPixels) == 720) && ((Build.VERSION.SDK_INT == 26) || (Build.VERSION.SDK_INT == 27)))
      {
        ac.i("MicroMsg.MMDensityManager", "dancy huaweiSpecial 720!!");
        bool = true;
        GjJ = bool;
        oPa = aj.getDeviceWidth();
        if (!ai.ciE()) {
          break label270;
        }
        GjB = eSp();
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
        ai.getContext().registerReceiver(new BroadcastReceiver()
        {
          public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(141186);
            if (paramAnonymousIntent.getAction().equalsIgnoreCase("android.intent.action.SCREEN_OFF"))
            {
              if (a.eSy())
              {
                AppMethodBeat.o(141186);
                return;
              }
              if (a.eSz())
              {
                a.eSA();
                AppMethodBeat.o(141186);
                return;
              }
              if ((a.eSB()) && (a.eSm()))
              {
                ac.i("MicroMsg.MMDensityManager", "killSelfAndCallUp ");
                a.eSA();
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
      localObject = ai.getContext().getSharedPreferences(ai.eUX(), 0).edit();
      ((SharedPreferences.Editor)localObject).putBoolean(GjH, eSv());
      ((SharedPreferences.Editor)localObject).commit();
      if (!eSv()) {
        break label340;
      }
      this.aHC = c(paramDisplayMetrics);
      paramDisplayMetrics.setTo(this.aHC);
      if (Build.VERSION.SDK_INT >= 21) {
        ai.getContext().getTheme().getResources().getDisplayMetrics().setTo(this.aHC);
      }
      ac.i("MicroMsg.MMDensityManager", " Target DisplayMetrics[%s]", new Object[] { this.aHC });
      AppMethodBeat.o(141187);
      return;
      bool = false;
      break;
      if (ai.isAppBrandProcess())
      {
        if ((eSp()) && (eSq())) {}
        for (bool = true;; bool = false)
        {
          GjB = bool;
          break;
        }
      }
    } while ((!ai.eVd()) && (!ai.eVe()));
    if ((eSp()) && (eSr())) {}
    for (boolean bool = true;; bool = false)
    {
      GjB = bool;
      break;
    }
    label340:
    GjI = 400.0F / (Math.min(this.GjA.widthPixels, paramDisplayMetrics.heightPixels) / this.GjA.density);
    this.aHC = this.GjA;
    AppMethodBeat.o(141187);
  }
  
  public static void Ya(int paramInt)
  {
    AppMethodBeat.i(141204);
    aw.aKT(ai.eUX()).putInt(GjG, paramInt);
    AppMethodBeat.o(141204);
  }
  
  public static void a(a parama)
  {
    GjK = parama;
  }
  
  public static DisplayMetrics c(DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(141188);
    float f1 = eSx();
    int i;
    float f3;
    label105:
    float f2;
    if (aj.fhz())
    {
      f1 = 750.0F;
      i = Math.min(paramDisplayMetrics.widthPixels, paramDisplayMetrics.heightPixels);
      f3 = i / f1;
      ac.i("MicroMsg.MMDensityManager", "applyScreenAdaptiveDensity originWidth:%s, originheight:%s, targetField:%s", new Object[] { Integer.valueOf(paramDisplayMetrics.widthPixels), Integer.valueOf(paramDisplayMetrics.heightPixels), Float.valueOf(f1) });
      if ((aj.fhC() == 0) || (oPa == 0)) {
        break label354;
      }
      if (i == 0) {
        break label349;
      }
      f1 = oPa / i;
      if (aj.fhD() == aj.fhC()) {
        break label344;
      }
      f2 = f1 * (aj.fhD() / aj.fhC());
      label126:
      f1 = f2;
      if (f2 < 0.95F) {
        f1 = 0.95F;
      }
      if ((!aj.fhz()) && (!aj.fhA())) {
        break label327;
      }
      f2 = f1;
      if (f1 > 1.5F) {
        f2 = 1.5F;
      }
      label166:
      GjI *= f2;
      f1 = f3 * f2;
      ac.i("MicroMsg.MMDensityManager", "scale targetDensity:%s , DeviceDpi:%s, WindowDpi:%s, DeviceWidth:%s, DisplayWidth:%s, dpiScale:%s", new Object[] { Float.valueOf(f1), Integer.valueOf(aj.fhC()), Integer.valueOf(aj.fhD()), Integer.valueOf(oPa), Integer.valueOf(i), Float.valueOf(f2) });
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
      if (aj.fhA())
      {
        f1 = 600.0F;
        break;
      }
      GjI = 400.0F / f1;
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
    if (GjQ)
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
      ac.printErrStackTrace("MicroMsg.MMDensityManager", paramField, "", new Object[0]);
      GjQ = true;
      AppMethodBeat.o(141201);
    }
  }
  
  public static float eSl()
  {
    return GjI;
  }
  
  public static boolean eSm()
  {
    AppMethodBeat.i(141189);
    try
    {
      int i = bs.getInt(b.cmk().b("clicfg_android_density_check_kill_enable", "1", false, true), 1);
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
      ac.printErrStackTrace("MicroMsg.MMDensityManager", localException, "isOpenKillSelf", new Object[0]);
      AppMethodBeat.o(141189);
    }
    return false;
  }
  
  private static boolean eSn()
  {
    AppMethodBeat.i(141190);
    if (GjL == null) {}
    try
    {
      if (bs.getInt(b.cmk().b("clicfg_screen_adaptive_huawei_four", "0", false, true), 1) > 0) {
        ac.i("MicroMsg.MMDensityManager", "isOpenHuaWeiSpecialAll!!");
      }
      for (GjL = Boolean.TRUE;; GjL = Boolean.FALSE)
      {
        boolean bool = GjL.booleanValue();
        AppMethodBeat.o(141190);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.MMDensityManager", localException, "isOpenHuaWeiSpecialAll", new Object[0]);
        GjL = Boolean.FALSE;
      }
    }
  }
  
  private static boolean eSo()
  {
    AppMethodBeat.i(141191);
    if (GjM == null) {}
    try
    {
      if (bs.getInt(b.cmk().b("clicfg_screen_adaptive_huawei_three", "1", false, true), 1) > 0) {
        ac.i("MicroMsg.MMDensityManager", "isOpenHuaWeiSpecial360!!");
      }
      for (GjM = Boolean.TRUE;; GjM = Boolean.FALSE)
      {
        boolean bool = GjM.booleanValue();
        AppMethodBeat.o(141191);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.MMDensityManager", localException, "isOpenHuaWeiSpecial360", new Object[0]);
        GjM = Boolean.FALSE;
      }
    }
  }
  
  public static boolean eSp()
  {
    AppMethodBeat.i(141192);
    try
    {
      int i = bs.getInt(b.cmk().b("clicfg_screen_adaptive", "1", false, true), 1);
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
      ac.printErrStackTrace("MicroMsg.MMDensityManager", localException, "isOpenScreenAdaptiveForMM", new Object[0]);
      AppMethodBeat.o(141192);
      return false;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label46:
      break label46;
    }
  }
  
  private static boolean eSq()
  {
    AppMethodBeat.i(141193);
    for (;;)
    {
      try
      {
        com.tencent.mm.k.a locala = com.tencent.mm.k.a.a.Xe();
        if (locala != null)
        {
          bool = locala.Kq();
          int i;
          if (bs.getInt(b.cmk().b("clicfg_screen_adaptive_appbrand", "1", false, true), 1) > 0)
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
        ac.printErrStackTrace("MicroMsg.MMDensityManager", localException, "isOpenScreenAdaptiveForAppBrand", new Object[0]);
        AppMethodBeat.o(141193);
        return false;
      }
      boolean bool = false;
    }
  }
  
  private static boolean eSr()
  {
    AppMethodBeat.i(141194);
    try
    {
      int i = bs.getInt(b.cmk().b("clicfg_screen_adaptive_tool", "1", false, true), 1);
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
      ac.printErrStackTrace("MicroMsg.MMDensityManager", localException, "isOpenScreenAdaptiveForTool", new Object[0]);
      AppMethodBeat.o(141194);
    }
    return false;
  }
  
  public static float eSs()
  {
    AppMethodBeat.i(141196);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)ai.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    float f = localDisplayMetrics.density;
    AppMethodBeat.o(141196);
    return f;
  }
  
  static boolean eSu()
  {
    AppMethodBeat.i(141199);
    if ((com.tencent.mm.cc.a.hX(ai.getContext()) == 0.8F) && (eSx() != 440))
    {
      AppMethodBeat.o(141199);
      return true;
    }
    AppMethodBeat.o(141199);
    return false;
  }
  
  public static boolean eSv()
  {
    AppMethodBeat.i(141202);
    if ((GjB) && (!eSw()))
    {
      AppMethodBeat.o(141202);
      return true;
    }
    AppMethodBeat.o(141202);
    return false;
  }
  
  public static boolean eSw()
  {
    AppMethodBeat.i(141203);
    String str = Build.BRAND;
    if (!bs.isNullOrNil(str))
    {
      if (GjR)
      {
        AppMethodBeat.o(141203);
        return true;
      }
      if ((eSn()) && (aj.DU()))
      {
        ac.i("MicroMsg.MMDensityManager", "dancy huaweiSpecial all!!");
        AppMethodBeat.o(141203);
        return true;
      }
      if ((eSo()) && (GjJ))
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
  
  public static int eSx()
  {
    AppMethodBeat.i(141205);
    int i = aw.aKT(ai.eUX()).getInt(GjG, 400);
    AppMethodBeat.o(141205);
    return i;
  }
  
  final void eSt()
  {
    AppMethodBeat.i(141198);
    try
    {
      DisplayMetrics localDisplayMetrics = getDisplayMetrics();
      if (this.GjO == null)
      {
        Method localMethod = Bitmap.class.getDeclaredMethod("setDefaultDensity", new Class[] { Integer.TYPE });
        localMethod.setAccessible(true);
        this.GjO = localMethod;
      }
      this.GjO.invoke(null, new Object[] { Integer.valueOf(localDisplayMetrics.densityDpi) });
      if (this.GjP == null)
      {
        this.GjP = DisplayMetrics.class.getDeclaredField("DENSITY_DEVICE");
        d(this.GjP);
      }
      this.GjP.setInt(null, localDisplayMetrics.densityDpi);
      AppMethodBeat.o(141198);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.MMDensityManager", localException, "", new Object[0]);
      AppMethodBeat.o(141198);
    }
  }
  
  public final Configuration g(Configuration paramConfiguration)
  {
    AppMethodBeat.i(141197);
    if (eSv())
    {
      paramConfiguration = new Configuration(paramConfiguration);
      paramConfiguration.densityDpi = getDisplayMetrics().densityDpi;
      eSt();
      AppMethodBeat.o(141197);
      return paramConfiguration;
    }
    AppMethodBeat.o(141197);
    return paramConfiguration;
  }
  
  public final DisplayMetrics getDisplayMetrics()
  {
    AppMethodBeat.i(141195);
    if (eSv())
    {
      localDisplayMetrics = new DisplayMetrics();
      localDisplayMetrics.setTo(this.aHC);
      AppMethodBeat.o(141195);
      return localDisplayMetrics;
    }
    DisplayMetrics localDisplayMetrics = this.GjA;
    AppMethodBeat.o(141195);
    return localDisplayMetrics;
  }
  
  public static abstract interface a
  {
    public abstract void Kx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cd.a
 * JD-Core Version:    0.7.0.1
 */