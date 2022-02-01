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
import com.tencent.mm.plugin.expt.e.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ai;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class a
{
  private static Boolean EMA;
  private static Boolean EMB;
  private static boolean EME;
  private static boolean EMF;
  private static boolean EMp;
  public static String EMq;
  public static String EMr;
  public static String EMs;
  public static String EMt;
  public static String EMu;
  public static String EMv;
  static float EMw;
  private static boolean EMx;
  static a EMy;
  private static Boolean EMz;
  static int olA;
  private Method EMC;
  private Field EMD;
  DisplayMetrics EMo;
  DisplayMetrics aGM;
  
  static
  {
    AppMethodBeat.i(141210);
    EMp = true;
    EMq = "screenResolution_density_dpi";
    EMr = "screenResolution_density_dpi_new";
    EMs = "screenResolution_density_report_new";
    EMt = "screenResolution_density_report_pad";
    EMu = "screenResolution_target_field";
    EMv = "screenResolution_isModifyDensity";
    EMw = 1.0F;
    EMx = false;
    olA = 0;
    EMz = null;
    EMA = null;
    EMB = null;
    EME = false;
    EMF = false;
    if (Build.BRAND != null)
    {
      String str = Build.BRAND.toLowerCase();
      if (((str.contains("huawei")) || (str.contains("honor"))) && (Build.VERSION.SDK_INT == 24)) {
        EMF = true;
      }
    }
    AppMethodBeat.o(141210);
  }
  
  public a(DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(141187);
    this.EMC = null;
    this.EMD = null;
    this.EMo = paramDisplayMetrics;
    Object localObject = Build.BRAND;
    if (!bt.isNullOrNil((String)localObject))
    {
      localObject = ((String)localObject).toLowerCase();
      if (((((String)localObject).contains("huawei")) || (((String)localObject).contains("honor"))) && (paramDisplayMetrics != null) && (Math.min(paramDisplayMetrics.widthPixels, paramDisplayMetrics.heightPixels) == 720) && ((Build.VERSION.SDK_INT == 26) || (Build.VERSION.SDK_INT == 27)))
      {
        ad.i("MicroMsg.MMDensityManager", "dancy huaweiSpecial 720!!");
        bool = true;
        EMx = bool;
        olA = ai.getDeviceWidth();
        if (!aj.cbv()) {
          break label270;
        }
        EMp = eCV();
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
        aj.getContext().registerReceiver(new BroadcastReceiver()
        {
          public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(141186);
            if (paramAnonymousIntent.getAction().equalsIgnoreCase("android.intent.action.SCREEN_OFF"))
            {
              if (a.eDe())
              {
                AppMethodBeat.o(141186);
                return;
              }
              if (a.eDf())
              {
                a.eDg();
                AppMethodBeat.o(141186);
                return;
              }
              if ((a.eDh()) && (a.eCS()))
              {
                ad.i("MicroMsg.MMDensityManager", "killSelfAndCallUp ");
                a.eDg();
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
      localObject = aj.getContext().getSharedPreferences(aj.eFD(), 0).edit();
      ((SharedPreferences.Editor)localObject).putBoolean(EMv, eDb());
      ((SharedPreferences.Editor)localObject).commit();
      if (!eDb()) {
        break label340;
      }
      this.aGM = c(paramDisplayMetrics);
      paramDisplayMetrics.setTo(this.aGM);
      if (Build.VERSION.SDK_INT >= 21) {
        aj.getContext().getTheme().getResources().getDisplayMetrics().setTo(this.aGM);
      }
      ad.i("MicroMsg.MMDensityManager", " Target DisplayMetrics[%s]", new Object[] { this.aGM });
      AppMethodBeat.o(141187);
      return;
      bool = false;
      break;
      if (aj.isAppBrandProcess())
      {
        if ((eCV()) && (eCW())) {}
        for (bool = true;; bool = false)
        {
          EMp = bool;
          break;
        }
      }
    } while ((!aj.eFJ()) && (!aj.eFK()));
    if ((eCV()) && (eCX())) {}
    for (boolean bool = true;; bool = false)
    {
      EMp = bool;
      break;
    }
    label340:
    EMw = 400.0F / (Math.min(this.EMo.widthPixels, paramDisplayMetrics.heightPixels) / this.EMo.density);
    this.aGM = this.EMo;
    AppMethodBeat.o(141187);
  }
  
  public static void VR(int paramInt)
  {
    AppMethodBeat.i(141204);
    ax.aFC(aj.eFD()).putInt(EMu, paramInt);
    AppMethodBeat.o(141204);
  }
  
  public static void a(a parama)
  {
    EMy = parama;
  }
  
  public static DisplayMetrics c(DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(141188);
    float f1 = eDd();
    int i;
    float f3;
    label105:
    float f2;
    if (ai.eRP())
    {
      f1 = 750.0F;
      i = Math.min(paramDisplayMetrics.widthPixels, paramDisplayMetrics.heightPixels);
      f3 = i / f1;
      ad.i("MicroMsg.MMDensityManager", "applyScreenAdaptiveDensity originWidth:%s, originheight:%s, targetField:%s", new Object[] { Integer.valueOf(paramDisplayMetrics.widthPixels), Integer.valueOf(paramDisplayMetrics.heightPixels), Float.valueOf(f1) });
      if ((ai.eRS() == 0) || (olA == 0)) {
        break label354;
      }
      if (i == 0) {
        break label349;
      }
      f1 = olA / i;
      if (ai.eRT() == ai.eRS()) {
        break label344;
      }
      f2 = f1 * (ai.eRT() / ai.eRS());
      label126:
      f1 = f2;
      if (f2 < 0.95F) {
        f1 = 0.95F;
      }
      if ((!ai.eRP()) && (!ai.eRQ())) {
        break label327;
      }
      f2 = f1;
      if (f1 > 1.5F) {
        f2 = 1.5F;
      }
      label166:
      EMw *= f2;
      f1 = f3 * f2;
      ad.i("MicroMsg.MMDensityManager", "scale targetDensity:%s , DeviceDpi:%s, WindowDpi:%s, DeviceWidth:%s, DisplayWidth:%s, dpiScale:%s", new Object[] { Float.valueOf(f1), Integer.valueOf(ai.eRS()), Integer.valueOf(ai.eRT()), Integer.valueOf(olA), Integer.valueOf(i), Float.valueOf(f2) });
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
      if (ai.eRQ())
      {
        f1 = 600.0F;
        break;
      }
      EMw = 400.0F / f1;
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
    if (EME)
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
      EME = true;
      AppMethodBeat.o(141201);
    }
  }
  
  public static float eCR()
  {
    return EMw;
  }
  
  public static boolean eCS()
  {
    AppMethodBeat.i(141189);
    try
    {
      int i = bt.getInt(b.ceD().b("clicfg_android_density_check_kill_enable", "1", false, true), 1);
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
  
  private static boolean eCT()
  {
    AppMethodBeat.i(141190);
    if (EMz == null) {}
    try
    {
      if (bt.getInt(b.ceD().b("clicfg_screen_adaptive_huawei_four", "0", false, true), 1) > 0) {
        ad.i("MicroMsg.MMDensityManager", "isOpenHuaWeiSpecialAll!!");
      }
      for (EMz = Boolean.TRUE;; EMz = Boolean.FALSE)
      {
        boolean bool = EMz.booleanValue();
        AppMethodBeat.o(141190);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.MMDensityManager", localException, "isOpenHuaWeiSpecialAll", new Object[0]);
        EMz = Boolean.FALSE;
      }
    }
  }
  
  private static boolean eCU()
  {
    AppMethodBeat.i(141191);
    if (EMA == null) {}
    try
    {
      if (bt.getInt(b.ceD().b("clicfg_screen_adaptive_huawei_three", "1", false, true), 1) > 0) {
        ad.i("MicroMsg.MMDensityManager", "isOpenHuaWeiSpecial360!!");
      }
      for (EMA = Boolean.TRUE;; EMA = Boolean.FALSE)
      {
        boolean bool = EMA.booleanValue();
        AppMethodBeat.o(141191);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.MMDensityManager", localException, "isOpenHuaWeiSpecial360", new Object[0]);
        EMA = Boolean.FALSE;
      }
    }
  }
  
  public static boolean eCV()
  {
    AppMethodBeat.i(141192);
    try
    {
      int i = bt.getInt(b.ceD().b("clicfg_screen_adaptive", "1", false, true), 1);
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
  
  private static boolean eCW()
  {
    AppMethodBeat.i(141193);
    for (;;)
    {
      try
      {
        com.tencent.mm.k.a locala = com.tencent.mm.k.a.a.Wg();
        if (locala != null)
        {
          bool = locala.KF();
          int i;
          if (bt.getInt(b.ceD().b("clicfg_screen_adaptive_appbrand", "1", false, true), 1) > 0)
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
  
  private static boolean eCX()
  {
    AppMethodBeat.i(141194);
    try
    {
      int i = bt.getInt(b.ceD().b("clicfg_screen_adaptive_tool", "1", false, true), 1);
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
  
  public static float eCY()
  {
    AppMethodBeat.i(141196);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)aj.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    float f = localDisplayMetrics.density;
    AppMethodBeat.o(141196);
    return f;
  }
  
  static boolean eDa()
  {
    AppMethodBeat.i(141199);
    if ((com.tencent.mm.cd.a.hM(aj.getContext()) == 0.8F) && (eDd() != 440))
    {
      AppMethodBeat.o(141199);
      return true;
    }
    AppMethodBeat.o(141199);
    return false;
  }
  
  public static boolean eDb()
  {
    AppMethodBeat.i(141202);
    if ((EMp) && (!eDc()))
    {
      AppMethodBeat.o(141202);
      return true;
    }
    AppMethodBeat.o(141202);
    return false;
  }
  
  public static boolean eDc()
  {
    AppMethodBeat.i(141203);
    String str = Build.BRAND;
    if (!bt.isNullOrNil(str))
    {
      if (EMF)
      {
        AppMethodBeat.o(141203);
        return true;
      }
      if ((eCT()) && (ai.Er()))
      {
        ad.i("MicroMsg.MMDensityManager", "dancy huaweiSpecial all!!");
        AppMethodBeat.o(141203);
        return true;
      }
      if ((eCU()) && (EMx))
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
  
  public static int eDd()
  {
    AppMethodBeat.i(141205);
    int i = ax.aFC(aj.eFD()).getInt(EMu, 400);
    AppMethodBeat.o(141205);
    return i;
  }
  
  final void eCZ()
  {
    AppMethodBeat.i(141198);
    try
    {
      DisplayMetrics localDisplayMetrics = getDisplayMetrics();
      if (this.EMC == null)
      {
        Method localMethod = Bitmap.class.getDeclaredMethod("setDefaultDensity", new Class[] { Integer.TYPE });
        localMethod.setAccessible(true);
        this.EMC = localMethod;
      }
      this.EMC.invoke(null, new Object[] { Integer.valueOf(localDisplayMetrics.densityDpi) });
      if (this.EMD == null)
      {
        this.EMD = DisplayMetrics.class.getDeclaredField("DENSITY_DEVICE");
        d(this.EMD);
      }
      this.EMD.setInt(null, localDisplayMetrics.densityDpi);
      AppMethodBeat.o(141198);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.MMDensityManager", localException, "", new Object[0]);
      AppMethodBeat.o(141198);
    }
  }
  
  public final Configuration f(Configuration paramConfiguration)
  {
    AppMethodBeat.i(141197);
    if (eDb())
    {
      paramConfiguration = new Configuration(paramConfiguration);
      paramConfiguration.densityDpi = getDisplayMetrics().densityDpi;
      eCZ();
      AppMethodBeat.o(141197);
      return paramConfiguration;
    }
    AppMethodBeat.o(141197);
    return paramConfiguration;
  }
  
  public final DisplayMetrics getDisplayMetrics()
  {
    AppMethodBeat.i(141195);
    if (eDb())
    {
      localDisplayMetrics = new DisplayMetrics();
      localDisplayMetrics.setTo(this.aGM);
      AppMethodBeat.o(141195);
      return localDisplayMetrics;
    }
    DisplayMetrics localDisplayMetrics = this.EMo;
    AppMethodBeat.o(141195);
    return localDisplayMetrics;
  }
  
  public static abstract interface a
  {
    public abstract void KM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ce.a
 * JD-Core Version:    0.7.0.1
 */