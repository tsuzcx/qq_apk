package com.tencent.mm.compatible.deviceinfo;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public final class ae
{
  public static t fFA;
  public static y fFB;
  public static ad fFC;
  public static x fFD;
  public static x fFE;
  public static a fFF;
  private static int fFG;
  public static k fFH;
  public static p fFI;
  public static o fFv;
  public static c fFw;
  public static b fFx;
  public static aa fFy;
  public static ag fFz;
  
  static
  {
    AppMethodBeat.i(155825);
    fFv = new o();
    fFw = new c();
    fFx = new b();
    fFy = new aa();
    fFz = new ag();
    fFA = new t();
    fFB = new y();
    fFC = new ad();
    fFD = new x();
    fFE = new x();
    fFF = new a();
    fFG = -1;
    fFH = new k();
    fFI = new p();
    AppMethodBeat.o(155825);
  }
  
  public static String bW(Context paramContext)
  {
    AppMethodBeat.i(155824);
    try
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SrvDeviceInfo", "lm: getManufacturer CurrentLanguage is %s", new Object[] { ac.ir(paramContext) });
      if ((fFB == null) || (fFB.fEO == null) || (fFB.fEO.size() == 0))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SrvDeviceInfo", "lm: getManufacturer return is %s", new Object[] { Build.MANUFACTURER });
        paramContext = Build.MANUFACTURER;
        AppMethodBeat.o(155824);
        return paramContext;
      }
      paramContext = (String)fFB.fEO.get(".manufacturerName." + ac.ir(paramContext));
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SrvDeviceInfo", "lm: getManufacturer is %s", new Object[] { paramContext });
      boolean bool = bt.isNullOrNil(paramContext);
      if (!bool)
      {
        AppMethodBeat.o(155824);
        return paramContext;
      }
      paramContext = (String)fFB.fEO.get(".manufacturerName.en");
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SrvDeviceInfo", "lm: getManufacturer is %s", new Object[] { paramContext });
      bool = bt.isNullOrNil(paramContext);
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
  
  public static void ph(String paramString)
  {
    AppMethodBeat.i(155823);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SrvDeviceInfo", "update deviceInfo %s", new Object[] { paramString });
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(155823);
      return;
    }
    if (paramString.hashCode() == fFG)
    {
      AppMethodBeat.o(155823);
      return;
    }
    fFG = paramString.hashCode();
    fFv.reset();
    fFw.reset();
    fFx.reset();
    fFH.reset();
    fFy.reset();
    fFz.reset();
    Object localObject = fFA;
    ((t)localObject).fDR = 0;
    ((t)localObject).fDS = 0;
    localObject = fFB;
    ((y)localObject).fEN = "";
    ((y)localObject).fEO = null;
    localObject = fFC;
    ((ad)localObject).dAy = false;
    ((ad)localObject).fFt = 0;
    ((ad)localObject).fFu = false;
    fFD.reset();
    fFE.reset();
    localObject = fFF;
    ((a)localObject).fzk = false;
    ((a)localObject).fzl = "";
    new s();
    if (!s.a(paramString, fFv, fFw, fFx, fFH, fFy, fFz, fFA, fFB, fFC, fFD, fFF, fFE))
    {
      AppMethodBeat.o(155823);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SrvDeviceInfo", "steve: mCameraInfo.mSupportVoipBeauty = " + fFw.fBD + ", mVoipBeautyWhiteCfg=" + fFw.fBE);
    paramString = new cq();
    com.tencent.mm.sdk.b.a.ESL.l(paramString);
    AppMethodBeat.o(155823);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.ae
 * JD-Core Version:    0.7.0.1
 */