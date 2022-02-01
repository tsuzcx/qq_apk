package com.tencent.mm.compatible.deviceinfo;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class ae
{
  public static x gKA;
  public static x gKB;
  public static a gKC;
  private static int gKD;
  public static k gKE;
  public static p gKF;
  public static o gKs;
  public static c gKt;
  public static b gKu;
  public static aa gKv;
  public static ag gKw;
  public static t gKx;
  public static y gKy;
  public static ad gKz;
  
  static
  {
    AppMethodBeat.i(155825);
    gKs = new o();
    gKt = new c();
    gKu = new b();
    gKv = new aa();
    gKw = new ag();
    gKx = new t();
    gKy = new y();
    gKz = new ad();
    gKA = new x();
    gKB = new x();
    gKC = new a();
    gKD = -1;
    gKE = new k();
    gKF = new p();
    AppMethodBeat.o(155825);
  }
  
  public static void DV(String paramString)
  {
    AppMethodBeat.i(155823);
    Log.i("MicroMsg.SrvDeviceInfo", "update deviceInfo %s", new Object[] { paramString });
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(155823);
      return;
    }
    if (paramString.hashCode() == gKD)
    {
      AppMethodBeat.o(155823);
      return;
    }
    gKD = paramString.hashCode();
    gKs.reset();
    gKt.reset();
    gKu.reset();
    gKE.reset();
    gKv.reset();
    gKw.reset();
    Object localObject = gKx;
    ((t)localObject).gIE = 0;
    ((t)localObject).gIF = 0;
    localObject = gKy;
    ((y)localObject).gJB = "";
    ((y)localObject).gJC = null;
    localObject = gKz;
    ((ad)localObject).edB = false;
    ((ad)localObject).gKq = 0;
    ((ad)localObject).gKr = false;
    gKA.reset();
    gKB.reset();
    localObject = gKC;
    ((a)localObject).gDy = false;
    ((a)localObject).gDz = "";
    new s();
    if (!s.a(paramString, gKs, gKt, gKu, gKE, gKv, gKw, gKx, gKy, gKz, gKA, gKC, gKB))
    {
      AppMethodBeat.o(155823);
      return;
    }
    Log.i("MicroMsg.SrvDeviceInfo", "steve: mCameraInfo.mSupportVoipBeauty = " + gKt.gGh + ", mVoipBeautyWhiteCfg=" + gKt.gGi);
    paramString = new cx();
    EventCenter.instance.publish(paramString);
    AppMethodBeat.o(155823);
  }
  
  public static String cu(Context paramContext)
  {
    AppMethodBeat.i(155824);
    try
    {
      Log.i("MicroMsg.SrvDeviceInfo", "lm: getManufacturer CurrentLanguage is %s", new Object[] { LocaleUtil.getCurrentLanguage(paramContext) });
      if ((gKy == null) || (gKy.gJC == null) || (gKy.gJC.size() == 0))
      {
        Log.i("MicroMsg.SrvDeviceInfo", "lm: getManufacturer return is %s", new Object[] { Build.MANUFACTURER });
        paramContext = Build.MANUFACTURER;
        AppMethodBeat.o(155824);
        return paramContext;
      }
      paramContext = (String)gKy.gJC.get(".manufacturerName." + LocaleUtil.getCurrentLanguage(paramContext));
      Log.i("MicroMsg.SrvDeviceInfo", "lm: getManufacturer is %s", new Object[] { paramContext });
      boolean bool = Util.isNullOrNil(paramContext);
      if (!bool)
      {
        AppMethodBeat.o(155824);
        return paramContext;
      }
      paramContext = (String)gKy.gJC.get(".manufacturerName.en");
      Log.i("MicroMsg.SrvDeviceInfo", "lm: getManufacturer is %s", new Object[] { paramContext });
      bool = Util.isNullOrNil(paramContext);
      if (!bool)
      {
        AppMethodBeat.o(155824);
        return paramContext;
      }
      paramContext = Build.MANUFACTURER;
      AppMethodBeat.o(155824);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext = Build.MANUFACTURER;
      AppMethodBeat.o(155824);
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.ae
 * JD-Core Version:    0.7.0.1
 */