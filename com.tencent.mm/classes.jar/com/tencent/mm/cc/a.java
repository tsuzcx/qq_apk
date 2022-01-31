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
import com.tencent.mm.plugin.expt.d.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.af;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class a
{
  static int vDR;
  private static boolean yiO;
  public static String yiP;
  public static String yiQ;
  public static String yiR;
  public static String yiS;
  public static String yiT;
  public static String yiU;
  static float yiV;
  private static boolean yiW;
  static a yiX;
  private static Boolean yiY;
  private static Boolean yiZ;
  private static Boolean yja;
  private static boolean yjd;
  private static boolean yje;
  DisplayMetrics bTx;
  DisplayMetrics yiN;
  private Method yjb;
  private Field yjc;
  
  static
  {
    AppMethodBeat.i(142714);
    yiO = true;
    yiP = "screenResolution_density_dpi";
    yiQ = "screenResolution_density_dpi_new";
    yiR = "screenResolution_density_report_new";
    yiS = "screenResolution_density_report_pad";
    yiT = "screenResolution_target_field";
    yiU = "screenResolution_isModifyDensity";
    yiV = 1.0F;
    yiW = false;
    vDR = 0;
    yiY = null;
    yiZ = null;
    yja = null;
    yjd = false;
    yje = false;
    if (Build.BRAND != null)
    {
      String str = Build.BRAND.toLowerCase();
      if (((str.contains("huawei")) || (str.contains("honor"))) && (Build.VERSION.SDK_INT == 24)) {
        yje = true;
      }
    }
    AppMethodBeat.o(142714);
  }
  
  public a(DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(105870);
    this.yjb = null;
    this.yjc = null;
    this.yiN = paramDisplayMetrics;
    Object localObject = Build.BRAND;
    if (!bo.isNullOrNil((String)localObject))
    {
      localObject = ((String)localObject).toLowerCase();
      if (((((String)localObject).contains("huawei")) || (((String)localObject).contains("honor"))) && (paramDisplayMetrics != null) && (Math.min(paramDisplayMetrics.widthPixels, paramDisplayMetrics.heightPixels) == 720) && ((Build.VERSION.SDK_INT == 26) || (Build.VERSION.SDK_INT == 27)))
      {
        ab.i("MicroMsg.MMDensityManager", "dancy huaweiSpecial 720!!");
        bool = true;
        yiW = bool;
        vDR = af.getDeviceWidth();
        if (!ah.brt()) {
          break label318;
        }
        yiO = dqW();
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
        ah.getContext().registerReceiver(new BroadcastReceiver()
        {
          public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(142704);
            if (paramAnonymousIntent.getAction().equalsIgnoreCase("android.intent.action.SCREEN_OFF"))
            {
              if (a.drf())
              {
                AppMethodBeat.o(142704);
                return;
              }
              if (a.drg())
              {
                a.drh();
                AppMethodBeat.o(142704);
                return;
              }
              if ((a.dri()) && (a.dqT()))
              {
                ab.i("MicroMsg.MMDensityManager", "killSelfAndCallUp ");
                a.drh();
              }
            }
            AppMethodBeat.o(142704);
          }
        }, (IntentFilter)localObject);
      }
    }
    label318:
    do
    {
      ab.i("MicroMsg.MMDensityManager", "MMDensityManager switch mm:%s, tools:%s, appbrand:%s, all:%s", new Object[] { Boolean.valueOf(dqW()), Boolean.valueOf(dqY()), Boolean.valueOf(dqX()), Boolean.valueOf(drc()) });
      localObject = ah.getContext().getSharedPreferences(ah.dsP(), 0).edit();
      ((SharedPreferences.Editor)localObject).putBoolean(yiU, drc());
      ((SharedPreferences.Editor)localObject).commit();
      if (!drc()) {
        break label388;
      }
      this.bTx = d(paramDisplayMetrics);
      paramDisplayMetrics.setTo(this.bTx);
      if (Build.VERSION.SDK_INT >= 21) {
        ah.getContext().getTheme().getResources().getDisplayMetrics().setTo(this.bTx);
      }
      ab.i("MicroMsg.MMDensityManager", " Target DisplayMetrics[%s]", new Object[] { this.bTx });
      AppMethodBeat.o(105870);
      return;
      bool = false;
      break;
      if (ah.isAppBrandProcess())
      {
        if ((dqW()) && (dqX())) {}
        for (bool = true;; bool = false)
        {
          yiO = bool;
          break;
        }
      }
    } while ((!ah.dsW()) && (!ah.dsX()));
    if ((dqW()) && (dqY())) {}
    for (boolean bool = true;; bool = false)
    {
      yiO = bool;
      break;
    }
    label388:
    yiV = 400.0F / (Math.min(this.yiN.widthPixels, paramDisplayMetrics.heightPixels) / this.yiN.density);
    this.bTx = this.yiN;
    AppMethodBeat.o(105870);
  }
  
  public static void MW(int paramInt)
  {
    AppMethodBeat.i(142708);
    as.apq(ah.dsP()).putInt(yiT, paramInt);
    AppMethodBeat.o(142708);
  }
  
  public static void a(a parama)
  {
    yiX = parama;
  }
  
  private static void c(Field paramField)
  {
    AppMethodBeat.i(105882);
    if (yjd)
    {
      AppMethodBeat.o(105882);
      return;
    }
    try
    {
      paramField.setAccessible(true);
      Field localField = Field.class.getDeclaredField("accessFlags");
      localField.setAccessible(true);
      localField.setInt(paramField, paramField.getModifiers() & 0xFFFFFFEF);
      AppMethodBeat.o(105882);
      return;
    }
    catch (Exception paramField)
    {
      ab.printErrStackTrace("MicroMsg.MMDensityManager", paramField, "", new Object[0]);
      yjd = true;
      AppMethodBeat.o(105882);
    }
  }
  
  public static DisplayMetrics d(DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(105871);
    float f1 = dre();
    int i;
    float f3;
    label105:
    float f2;
    if (af.dDl())
    {
      f1 = 750.0F;
      i = Math.min(paramDisplayMetrics.widthPixels, paramDisplayMetrics.heightPixels);
      f3 = i / f1;
      ab.i("MicroMsg.MMDensityManager", "applyScreenAdaptiveDensity originWidth:%s, originheight:%s, targetField:%s", new Object[] { Integer.valueOf(paramDisplayMetrics.widthPixels), Integer.valueOf(paramDisplayMetrics.heightPixels), Float.valueOf(f1) });
      if ((af.dDp() == 0) || (vDR == 0)) {
        break label354;
      }
      if (i == 0) {
        break label349;
      }
      f1 = vDR / i;
      if (af.dDq() == af.dDp()) {
        break label344;
      }
      f2 = f1 * (af.dDq() / af.dDp());
      label126:
      f1 = f2;
      if (f2 < 0.95F) {
        f1 = 0.95F;
      }
      if ((!af.dDl()) && (!af.dDm())) {
        break label327;
      }
      f2 = f1;
      if (f1 > 1.5F) {
        f2 = 1.5F;
      }
      label166:
      yiV *= f2;
      f1 = f3 * f2;
      ab.i("MicroMsg.MMDensityManager", "scale targetDensity:%s , DeviceDpi:%s, WindowDpi:%s, DeviceWidth:%s, DisplayWidth:%s, dpiScale:%s", new Object[] { Float.valueOf(f1), Integer.valueOf(af.dDp()), Integer.valueOf(af.dDq()), Integer.valueOf(vDR), Integer.valueOf(i), Float.valueOf(f2) });
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
      AppMethodBeat.o(105871);
      return localDisplayMetrics;
      if (af.dDm())
      {
        f1 = 600.0F;
        break;
      }
      yiV = 400.0F / f1;
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
  
  public static float dqS()
  {
    return yiV;
  }
  
  public static boolean dqT()
  {
    AppMethodBeat.i(142705);
    try
    {
      int i = bo.getInt(b.btj().b("clicfg_android_density_check_kill_enable", "1", false, true), 1);
      if (i > 0)
      {
        AppMethodBeat.o(142705);
        return true;
      }
      AppMethodBeat.o(142705);
      return false;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.MMDensityManager", localException, "isOpenKillSelf", new Object[0]);
      AppMethodBeat.o(142705);
    }
    return false;
  }
  
  private static boolean dqU()
  {
    AppMethodBeat.i(142706);
    if (yiY == null) {}
    try
    {
      if (bo.getInt(b.btj().b("clicfg_screen_adaptive_huawei_four", "0", false, true), 1) > 0) {
        ab.i("MicroMsg.MMDensityManager", "isOpenHuaWeiSpecialAll!!");
      }
      for (yiY = Boolean.TRUE;; yiY = Boolean.FALSE)
      {
        boolean bool = yiY.booleanValue();
        AppMethodBeat.o(142706);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.MMDensityManager", localException, "isOpenHuaWeiSpecialAll", new Object[0]);
        yiY = Boolean.FALSE;
      }
    }
  }
  
  private static boolean dqV()
  {
    AppMethodBeat.i(142707);
    if (yiZ == null) {}
    try
    {
      if (bo.getInt(b.btj().b("clicfg_screen_adaptive_huawei_three", "1", false, true), 1) > 0) {
        ab.i("MicroMsg.MMDensityManager", "isOpenHuaWeiSpecial360!!");
      }
      for (yiZ = Boolean.TRUE;; yiZ = Boolean.FALSE)
      {
        boolean bool = yiZ.booleanValue();
        AppMethodBeat.o(142707);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.MMDensityManager", localException, "isOpenHuaWeiSpecial360", new Object[0]);
        yiZ = Boolean.FALSE;
      }
    }
  }
  
  public static boolean dqW()
  {
    AppMethodBeat.i(105872);
    try
    {
      int i = bo.getInt(b.btj().b("clicfg_screen_adaptive", "1", false, true), 1);
      if (i > 0)
      {
        AppMethodBeat.o(105872);
        return true;
      }
      AppMethodBeat.o(105872);
      return false;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.MMDensityManager", localException, "isOpenScreenAdaptiveForMM", new Object[0]);
      AppMethodBeat.o(105872);
    }
    return false;
  }
  
  public static boolean dqX()
  {
    AppMethodBeat.i(105873);
    for (;;)
    {
      try
      {
        com.tencent.mm.k.a locala = com.tencent.mm.k.a.a.Kx();
        if (locala != null)
        {
          bool = locala.Bh();
          int i;
          if (bo.getInt(b.btj().b("clicfg_screen_adaptive_appbrand", "1", false, true), 1) > 0)
          {
            i = 1;
            if ((i != 0) && (bool))
            {
              AppMethodBeat.o(105873);
              return true;
            }
          }
          else
          {
            i = 0;
            continue;
          }
          AppMethodBeat.o(105873);
          return false;
        }
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.MMDensityManager", localException, "isOpenScreenAdaptiveForAppBrand", new Object[0]);
        AppMethodBeat.o(105873);
        return false;
      }
      boolean bool = false;
    }
  }
  
  private static boolean dqY()
  {
    AppMethodBeat.i(105874);
    try
    {
      int i = bo.getInt(b.btj().b("clicfg_screen_adaptive_tool", "1", false, true), 1);
      if (i > 0)
      {
        AppMethodBeat.o(105874);
        return true;
      }
      AppMethodBeat.o(105874);
      return false;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.MMDensityManager", localException, "isOpenScreenAdaptiveForTool", new Object[0]);
      AppMethodBeat.o(105874);
    }
    return false;
  }
  
  public static float dqZ()
  {
    AppMethodBeat.i(105876);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)ah.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    float f = localDisplayMetrics.density;
    AppMethodBeat.o(105876);
    return f;
  }
  
  static boolean drb()
  {
    AppMethodBeat.i(154292);
    if ((com.tencent.mm.cb.a.gn(ah.getContext()) == 0.8F) && (dre() != 440))
    {
      AppMethodBeat.o(154292);
      return true;
    }
    AppMethodBeat.o(154292);
    return false;
  }
  
  public static boolean drc()
  {
    AppMethodBeat.i(105883);
    if ((yiO) && (!drd()))
    {
      AppMethodBeat.o(105883);
      return true;
    }
    AppMethodBeat.o(105883);
    return false;
  }
  
  private static boolean drd()
  {
    AppMethodBeat.i(105884);
    String str = Build.BRAND;
    if (!bo.isNullOrNil(str))
    {
      if (yje)
      {
        AppMethodBeat.o(105884);
        return true;
      }
      if ((dqU()) && (af.dDn()))
      {
        ab.i("MicroMsg.MMDensityManager", "dancy huaweiSpecial all!!");
        AppMethodBeat.o(105884);
        return true;
      }
      if ((dqV()) && (yiW))
      {
        AppMethodBeat.o(105884);
        return true;
      }
      if ((str.contains("samsung")) && (Build.VERSION.SDK_INT == 23))
      {
        AppMethodBeat.o(105884);
        return true;
      }
    }
    AppMethodBeat.o(105884);
    return false;
  }
  
  public static int dre()
  {
    AppMethodBeat.i(142709);
    int i = as.apq(ah.dsP()).getInt(yiT, 400);
    AppMethodBeat.o(142709);
    return i;
  }
  
  static String e(DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(105881);
    paramDisplayMetrics = String.format("scaledDensity:%s densityDpi:%s density:%s", new Object[] { Float.valueOf(paramDisplayMetrics.scaledDensity), Integer.valueOf(paramDisplayMetrics.densityDpi), Float.valueOf(paramDisplayMetrics.density) });
    AppMethodBeat.o(105881);
    return paramDisplayMetrics;
  }
  
  public final Configuration c(Configuration paramConfiguration)
  {
    AppMethodBeat.i(105878);
    if (drc())
    {
      paramConfiguration = new Configuration(paramConfiguration);
      paramConfiguration.densityDpi = getDisplayMetrics().densityDpi;
      dra();
      AppMethodBeat.o(105878);
      return paramConfiguration;
    }
    AppMethodBeat.o(105878);
    return paramConfiguration;
  }
  
  final void dra()
  {
    AppMethodBeat.i(105879);
    try
    {
      DisplayMetrics localDisplayMetrics = getDisplayMetrics();
      if (this.yjb == null)
      {
        Method localMethod = Bitmap.class.getDeclaredMethod("setDefaultDensity", new Class[] { Integer.TYPE });
        localMethod.setAccessible(true);
        this.yjb = localMethod;
      }
      this.yjb.invoke(null, new Object[] { Integer.valueOf(localDisplayMetrics.densityDpi) });
      if (this.yjc == null)
      {
        this.yjc = DisplayMetrics.class.getDeclaredField("DENSITY_DEVICE");
        c(this.yjc);
      }
      this.yjc.setInt(null, localDisplayMetrics.densityDpi);
      AppMethodBeat.o(105879);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.MMDensityManager", localException, "", new Object[0]);
      AppMethodBeat.o(105879);
    }
  }
  
  public final DisplayMetrics getDisplayMetrics()
  {
    AppMethodBeat.i(105875);
    if (drc())
    {
      localDisplayMetrics = new DisplayMetrics();
      localDisplayMetrics.setTo(this.bTx);
      AppMethodBeat.o(105875);
      return localDisplayMetrics;
    }
    DisplayMetrics localDisplayMetrics = this.yiN;
    AppMethodBeat.o(105875);
    return localDisplayMetrics;
  }
  
  public static abstract interface a
  {
    public abstract void Bl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cc.a
 * JD-Core Version:    0.7.0.1
 */