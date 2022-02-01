package com.tencent.mm.compatible.deviceinfo;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.dl;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class af
{
  public static o lXX;
  public static c lXY;
  public static b lXZ;
  public static ab lYa;
  public static ah lYb;
  public static t lYc;
  public static z lYd;
  public static ae lYe;
  public static y lYf;
  public static y lYg;
  public static a lYh;
  private static int lYi;
  public static k lYj;
  public static p lYk;
  
  static
  {
    AppMethodBeat.i(155825);
    lXX = new o();
    lXY = new c();
    lXZ = new b();
    lYa = new ab();
    lYb = new ah();
    lYc = new t();
    lYd = new z();
    lYe = new ae();
    lYf = new y();
    lYg = new y();
    lYh = new a();
    lYi = -1;
    lYj = new k();
    lYk = new p();
    AppMethodBeat.o(155825);
  }
  
  public static void Ds(String paramString)
  {
    AppMethodBeat.i(155823);
    Log.i("MicroMsg.SrvDeviceInfo", "update deviceInfo %s", new Object[] { paramString });
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(155823);
      return;
    }
    if (paramString.hashCode() == lYi)
    {
      AppMethodBeat.o(155823);
      return;
    }
    lYi = paramString.hashCode();
    lXX.reset();
    lXY.reset();
    lXZ.reset();
    lYj.reset();
    lYa.reset();
    lYb.reset();
    Object localObject = lYc;
    ((t)localObject).lWo = 0;
    ((t)localObject).lWp = 0;
    localObject = lYd;
    ((z)localObject).lXg = "";
    ((z)localObject).lXh = null;
    localObject = lYe;
    ((ae)localObject).idL = false;
    ((ae)localObject).lXV = 0;
    ((ae)localObject).lXW = false;
    lYf.reset();
    lYg.reset();
    localObject = lYh;
    ((a)localObject).lQQ = false;
    ((a)localObject).lQR = "";
    new s();
    if (!s.a(paramString, lXX, lXY, lXZ, lYj, lYa, lYb, lYc, lYd, lYe, lYf, lYh, lYg))
    {
      AppMethodBeat.o(155823);
      return;
    }
    Log.i("MicroMsg.SrvDeviceInfo", "steve: mCameraInfo.mSupportVoipBeauty = " + lXY.lTz + ", mVoipBeautyWhiteCfg=" + lXY.lTA);
    new dl().publish();
    AppMethodBeat.o(155823);
  }
  
  public static String de(Context paramContext)
  {
    AppMethodBeat.i(155824);
    try
    {
      Log.i("MicroMsg.SrvDeviceInfo", "lm: getManufacturer CurrentLanguage is %s", new Object[] { LocaleUtil.getCurrentLanguage(paramContext) });
      if ((lYd == null) || (lYd.lXh == null) || (lYd.lXh.size() == 0))
      {
        Log.i("MicroMsg.SrvDeviceInfo", "lm: getManufacturer return is %s", new Object[] { Build.MANUFACTURER });
        paramContext = Build.MANUFACTURER;
        AppMethodBeat.o(155824);
        return paramContext;
      }
      paramContext = (String)lYd.lXh.get(".manufacturerName." + LocaleUtil.getCurrentLanguage(paramContext));
      Log.i("MicroMsg.SrvDeviceInfo", "lm: getManufacturer is %s", new Object[] { paramContext });
      boolean bool = Util.isNullOrNil(paramContext);
      if (!bool)
      {
        AppMethodBeat.o(155824);
        return paramContext;
      }
      paramContext = (String)lYd.lXh.get(".manufacturerName.en");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.af
 * JD-Core Version:    0.7.0.1
 */