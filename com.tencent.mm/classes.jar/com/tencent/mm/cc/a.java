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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class a
{
  private static boolean NCT;
  public static String NCU;
  public static String NCV;
  public static String NCW;
  public static String NCX;
  public static String NCY;
  public static String NCZ;
  static float NDa;
  private static boolean NDb;
  static a NDc;
  private static Boolean NDd;
  private static Boolean NDe;
  private static Boolean NDf;
  private static boolean NDi;
  private static boolean NDj;
  static int qOF;
  DisplayMetrics NCS;
  private Method NDg;
  private Field NDh;
  DisplayMetrics aJm;
  
  static
  {
    AppMethodBeat.i(141210);
    NCT = true;
    NCU = "screenResolution_density_dpi";
    NCV = "screenResolution_density_dpi_new";
    NCW = "screenResolution_density_report_new";
    NCX = "screenResolution_density_report_pad";
    NCY = "screenResolution_target_field";
    NCZ = "screenResolution_isModifyDensity";
    NDa = 1.0F;
    NDb = false;
    qOF = 0;
    NDd = null;
    NDe = null;
    NDf = null;
    NDi = false;
    NDj = false;
    if (Build.BRAND != null)
    {
      String str = Build.BRAND.toLowerCase();
      if (((str.contains("huawei")) || (str.contains("honor"))) && (Build.VERSION.SDK_INT == 24)) {
        NDj = true;
      }
    }
    AppMethodBeat.o(141210);
  }
  
  public a(DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(141187);
    this.NDg = null;
    this.NDh = null;
    this.NCS = paramDisplayMetrics;
    Object localObject = Build.BRAND;
    if (!Util.isNullOrNil((String)localObject))
    {
      localObject = ((String)localObject).toLowerCase();
      if (((((String)localObject).contains("huawei")) || (((String)localObject).contains("honor"))) && (paramDisplayMetrics != null) && (Math.min(paramDisplayMetrics.widthPixels, paramDisplayMetrics.heightPixels) == 720) && ((Build.VERSION.SDK_INT == 26) || (Build.VERSION.SDK_INT == 27)))
      {
        Log.i("MicroMsg.MMDensityManager", "dancy huaweiSpecial 720!!");
        bool = true;
        NDb = bool;
        qOF = ao.getDeviceWidth();
        if (!MMApplicationContext.isMMProcess()) {
          break label270;
        }
        NCT = gvm();
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
        MMApplicationContext.getContext().registerReceiver(new BroadcastReceiver()
        {
          public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(141186);
            if (paramAnonymousIntent.getAction().equalsIgnoreCase("android.intent.action.SCREEN_OFF"))
            {
              if (a.gvv())
              {
                AppMethodBeat.o(141186);
                return;
              }
              if (a.gvw())
              {
                a.gvx();
                AppMethodBeat.o(141186);
                return;
              }
              if ((a.gvy()) && (a.gvj()))
              {
                Log.i("MicroMsg.MMDensityManager", "killSelfAndCallUp ");
                a.gvx();
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
      localObject = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit();
      ((SharedPreferences.Editor)localObject).putBoolean(NCZ, gvs());
      ((SharedPreferences.Editor)localObject).commit();
      if (!gvs()) {
        break label340;
      }
      this.aJm = b(paramDisplayMetrics);
      paramDisplayMetrics.setTo(this.aJm);
      if (Build.VERSION.SDK_INT >= 21) {
        MMApplicationContext.getContext().getTheme().getResources().getDisplayMetrics().setTo(this.aJm);
      }
      Log.i("MicroMsg.MMDensityManager", " Target DisplayMetrics[%s]", new Object[] { this.aJm });
      AppMethodBeat.o(141187);
      return;
      bool = false;
      break;
      if (MMApplicationContext.isAppBrandProcess())
      {
        if ((gvm()) && (gvn())) {}
        for (bool = true;; bool = false)
        {
          NCT = bool;
          break;
        }
      }
    } while ((!MMApplicationContext.isToolsProcess()) && (!MMApplicationContext.isToolsMpProcess()));
    if ((gvm()) && (gvo())) {}
    for (boolean bool = true;; bool = false)
    {
      NCT = bool;
      break;
    }
    label340:
    NDa = 400.0F / (Math.min(this.NCS.widthPixels, paramDisplayMetrics.heightPixels) / this.NCS.density);
    this.aJm = this.NCS;
    AppMethodBeat.o(141187);
  }
  
  public static void a(a parama)
  {
    NDc = parama;
  }
  
  public static void ajy(int paramInt)
  {
    AppMethodBeat.i(141204);
    MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putInt(NCY, paramInt);
    AppMethodBeat.o(141204);
  }
  
  public static DisplayMetrics b(DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(141188);
    float f1 = gvu();
    int i;
    float f3;
    label108:
    float f2;
    if (ao.gJJ() >= 600)
    {
      f1 = 700.0F;
      i = Math.min(paramDisplayMetrics.widthPixels, paramDisplayMetrics.heightPixels);
      f3 = i / f1;
      Log.i("MicroMsg.MMDensityManager", "applyScreenAdaptiveDensity originWidth:%s, originheight:%s, targetField:%s", new Object[] { Integer.valueOf(paramDisplayMetrics.widthPixels), Integer.valueOf(paramDisplayMetrics.heightPixels), Float.valueOf(f1) });
      if ((ao.gJP() == 0) || (qOF == 0)) {
        break label360;
      }
      if (i == 0) {
        break label355;
      }
      f1 = qOF / i;
      if (ao.gJQ() == ao.gJP()) {
        break label350;
      }
      f2 = f1 * (ao.gJQ() / ao.gJP());
      label129:
      f1 = f2;
      if (f2 < 0.95F) {
        f1 = 0.95F;
      }
      if ((!ao.gJH()) && (!ao.gJI())) {
        break label333;
      }
      f2 = f1;
      if (f1 > 1.5F) {
        f2 = 1.5F;
      }
      label169:
      NDa *= f2;
      f1 = f3 * f2;
      Log.i("MicroMsg.MMDensityManager", "scale targetDensity:%s , DeviceDpi:%s, WindowDpi:%s, DeviceWidth:%s, DisplayWidth:%s, dpiScale:%s", new Object[] { Float.valueOf(f1), Integer.valueOf(ao.gJP()), Integer.valueOf(ao.gJQ()), Integer.valueOf(qOF), Integer.valueOf(i), Float.valueOf(f2) });
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
      if (ao.gJJ() >= 533)
      {
        f1 = 600.0F;
        break;
      }
      NDa = 400.0F / f1;
      break;
      label333:
      f2 = f1;
      if (f1 <= 1.2F) {
        break label169;
      }
      f2 = 1.2F;
      break label169;
      label350:
      f2 = 1.0F;
      break label129;
      label355:
      f1 = 1.0F;
      break label108;
      label360:
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
  
  private static void d(Field paramField)
  {
    AppMethodBeat.i(141201);
    if (NDi)
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
      NDi = true;
      AppMethodBeat.o(141201);
    }
  }
  
  public static float gvi()
  {
    return NDa;
  }
  
  public static boolean gvj()
  {
    AppMethodBeat.i(141189);
    try
    {
      int i = Util.getInt(d.cRY().b("clicfg_android_density_check_kill_enable", "1", false, true), 1);
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
  
  private static boolean gvk()
  {
    AppMethodBeat.i(141190);
    if (NDd == null) {}
    try
    {
      if (Util.getInt(d.cRY().b("clicfg_screen_adaptive_huawei_four", "0", false, true), 1) > 0) {
        Log.i("MicroMsg.MMDensityManager", "isOpenHuaWeiSpecialAll!!");
      }
      for (NDd = Boolean.TRUE;; NDd = Boolean.FALSE)
      {
        boolean bool = NDd.booleanValue();
        AppMethodBeat.o(141190);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.MMDensityManager", localException, "isOpenHuaWeiSpecialAll", new Object[0]);
        NDd = Boolean.FALSE;
      }
    }
  }
  
  private static boolean gvl()
  {
    AppMethodBeat.i(141191);
    if (NDe == null) {}
    try
    {
      if (Util.getInt(d.cRY().b("clicfg_screen_adaptive_huawei_three", "1", false, true), 1) > 0) {
        Log.i("MicroMsg.MMDensityManager", "isOpenHuaWeiSpecial360!!");
      }
      for (NDe = Boolean.TRUE;; NDe = Boolean.FALSE)
      {
        boolean bool = NDe.booleanValue();
        AppMethodBeat.o(141191);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.MMDensityManager", localException, "isOpenHuaWeiSpecial360", new Object[0]);
        NDe = Boolean.FALSE;
      }
    }
  }
  
  public static boolean gvm()
  {
    AppMethodBeat.i(141192);
    try
    {
      int i = Util.getInt(d.cRY().b("clicfg_screen_adaptive", "1", false, true), 1);
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
  
  private static boolean gvn()
  {
    AppMethodBeat.i(141193);
    for (;;)
    {
      try
      {
        com.tencent.mm.l.a locala = com.tencent.mm.l.a.a.anB();
        if (locala != null)
        {
          bool = locala.Wo();
          int i;
          if (Util.getInt(d.cRY().b("clicfg_screen_adaptive_appbrand", "1", false, true), 1) > 0)
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
  
  private static boolean gvo()
  {
    AppMethodBeat.i(141194);
    try
    {
      int i = Util.getInt(d.cRY().b("clicfg_screen_adaptive_tool", "1", false, true), 1);
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
  
  public static float gvp()
  {
    AppMethodBeat.i(141196);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    float f = localDisplayMetrics.density;
    AppMethodBeat.o(141196);
    return f;
  }
  
  static boolean gvr()
  {
    AppMethodBeat.i(141199);
    if ((com.tencent.mm.cb.a.je(MMApplicationContext.getContext()) == 0.8F) && (gvu() != 440))
    {
      AppMethodBeat.o(141199);
      return true;
    }
    AppMethodBeat.o(141199);
    return false;
  }
  
  public static boolean gvs()
  {
    AppMethodBeat.i(141202);
    if ((NCT) && (!gvt()))
    {
      AppMethodBeat.o(141202);
      return true;
    }
    AppMethodBeat.o(141202);
    return false;
  }
  
  public static boolean gvt()
  {
    AppMethodBeat.i(141203);
    String str = Build.BRAND;
    if (!Util.isNullOrNil(str))
    {
      if (NDj)
      {
        AppMethodBeat.o(141203);
        return true;
      }
      if ((gvk()) && (ao.Pi()))
      {
        Log.i("MicroMsg.MMDensityManager", "dancy huaweiSpecial all!!");
        AppMethodBeat.o(141203);
        return true;
      }
      if ((gvl()) && (NDb))
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
  
  public static int gvu()
  {
    AppMethodBeat.i(141205);
    int i = MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getInt(NCY, 400);
    AppMethodBeat.o(141205);
    return i;
  }
  
  public final Configuration g(Configuration paramConfiguration)
  {
    AppMethodBeat.i(141197);
    if (gvs())
    {
      paramConfiguration = new Configuration(paramConfiguration);
      paramConfiguration.densityDpi = getDisplayMetrics().densityDpi;
      gvq();
      AppMethodBeat.o(141197);
      return paramConfiguration;
    }
    AppMethodBeat.o(141197);
    return paramConfiguration;
  }
  
  public final DisplayMetrics getDisplayMetrics()
  {
    AppMethodBeat.i(141195);
    if (gvs())
    {
      localDisplayMetrics = new DisplayMetrics();
      localDisplayMetrics.setTo(this.aJm);
      AppMethodBeat.o(141195);
      return localDisplayMetrics;
    }
    DisplayMetrics localDisplayMetrics = this.NCS;
    AppMethodBeat.o(141195);
    return localDisplayMetrics;
  }
  
  final void gvq()
  {
    AppMethodBeat.i(141198);
    try
    {
      DisplayMetrics localDisplayMetrics = getDisplayMetrics();
      if (this.NDg == null)
      {
        Method localMethod = Bitmap.class.getDeclaredMethod("setDefaultDensity", new Class[] { Integer.TYPE });
        localMethod.setAccessible(true);
        this.NDg = localMethod;
      }
      this.NDg.invoke(null, new Object[] { Integer.valueOf(localDisplayMetrics.densityDpi) });
      if (this.NDh == null)
      {
        this.NDh = DisplayMetrics.class.getDeclaredField("DENSITY_DEVICE");
        d(this.NDh);
      }
      this.NDh.setInt(null, localDisplayMetrics.densityDpi);
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
    public abstract void Wu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cc.a
 * JD-Core Version:    0.7.0.1
 */