package com.tencent.mm.compatible.deviceinfo;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ct;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public final class ae
{
  public static o gcD;
  public static c gcE;
  public static b gcF;
  public static aa gcG;
  public static ag gcH;
  public static t gcI;
  public static y gcJ;
  public static ad gcK;
  public static x gcL;
  public static x gcM;
  public static a gcN;
  private static int gcO;
  public static k gcP;
  public static p gcQ;
  
  static
  {
    AppMethodBeat.i(155825);
    gcD = new o();
    gcE = new c();
    gcF = new b();
    gcG = new aa();
    gcH = new ag();
    gcI = new t();
    gcJ = new y();
    gcK = new ad();
    gcL = new x();
    gcM = new x();
    gcN = new a();
    gcO = -1;
    gcP = new k();
    gcQ = new p();
    AppMethodBeat.o(155825);
  }
  
  public static String bX(Context paramContext)
  {
    AppMethodBeat.i(155824);
    try
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SrvDeviceInfo", "lm: getManufacturer CurrentLanguage is %s", new Object[] { ac.iM(paramContext) });
      if ((gcJ == null) || (gcJ.gbV == null) || (gcJ.gbV.size() == 0))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SrvDeviceInfo", "lm: getManufacturer return is %s", new Object[] { Build.MANUFACTURER });
        paramContext = Build.MANUFACTURER;
        AppMethodBeat.o(155824);
        return paramContext;
      }
      paramContext = (String)gcJ.gbV.get(".manufacturerName." + ac.iM(paramContext));
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SrvDeviceInfo", "lm: getManufacturer is %s", new Object[] { paramContext });
      boolean bool = bt.isNullOrNil(paramContext);
      if (!bool)
      {
        AppMethodBeat.o(155824);
        return paramContext;
      }
      paramContext = (String)gcJ.gbV.get(".manufacturerName.en");
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
  
  public static void vi(String paramString)
  {
    AppMethodBeat.i(155823);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SrvDeviceInfo", "update deviceInfo %s", new Object[] { paramString });
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(155823);
      return;
    }
    if (paramString.hashCode() == gcO)
    {
      AppMethodBeat.o(155823);
      return;
    }
    gcO = paramString.hashCode();
    gcD.reset();
    gcE.reset();
    gcF.reset();
    gcP.reset();
    gcG.reset();
    gcH.reset();
    Object localObject = gcI;
    ((t)localObject).gaY = 0;
    ((t)localObject).gaZ = 0;
    localObject = gcJ;
    ((y)localObject).gbU = "";
    ((y)localObject).gbV = null;
    localObject = gcK;
    ((ad)localObject).dKx = false;
    ((ad)localObject).gcB = 0;
    ((ad)localObject).gcC = false;
    gcL.reset();
    gcM.reset();
    localObject = gcN;
    ((a)localObject).fWf = false;
    ((a)localObject).fWg = "";
    new s();
    if (!s.a(paramString, gcD, gcE, gcF, gcP, gcG, gcH, gcI, gcJ, gcK, gcL, gcN, gcM))
    {
      AppMethodBeat.o(155823);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SrvDeviceInfo", "steve: mCameraInfo.mSupportVoipBeauty = " + gcE.fYJ + ", mVoipBeautyWhiteCfg=" + gcE.fYK);
    paramString = new ct();
    com.tencent.mm.sdk.b.a.IbL.l(paramString);
    AppMethodBeat.o(155823);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.ae
 * JD-Core Version:    0.7.0.1
 */