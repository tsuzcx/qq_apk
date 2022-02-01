package com.tencent.mm.compatible.deviceinfo;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cu;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;

public final class ae
{
  public static o geL;
  public static c geM;
  public static b geN;
  public static aa geO;
  public static ag geP;
  public static t geQ;
  public static y geR;
  public static ad geS;
  public static x geT;
  public static x geU;
  public static a geV;
  private static int geW;
  public static k geX;
  public static p geY;
  
  static
  {
    AppMethodBeat.i(155825);
    geL = new o();
    geM = new c();
    geN = new b();
    geO = new aa();
    geP = new ag();
    geQ = new t();
    geR = new y();
    geS = new ad();
    geT = new x();
    geU = new x();
    geV = new a();
    geW = -1;
    geX = new k();
    geY = new p();
    AppMethodBeat.o(155825);
  }
  
  public static String bZ(Context paramContext)
  {
    AppMethodBeat.i(155824);
    try
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SrvDeviceInfo", "lm: getManufacturer CurrentLanguage is %s", new Object[] { com.tencent.mm.sdk.platformtools.ad.iR(paramContext) });
      if ((geR == null) || (geR.ged == null) || (geR.ged.size() == 0))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SrvDeviceInfo", "lm: getManufacturer return is %s", new Object[] { Build.MANUFACTURER });
        paramContext = Build.MANUFACTURER;
        AppMethodBeat.o(155824);
        return paramContext;
      }
      paramContext = (String)geR.ged.get(".manufacturerName." + com.tencent.mm.sdk.platformtools.ad.iR(paramContext));
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SrvDeviceInfo", "lm: getManufacturer is %s", new Object[] { paramContext });
      boolean bool = bu.isNullOrNil(paramContext);
      if (!bool)
      {
        AppMethodBeat.o(155824);
        return paramContext;
      }
      paramContext = (String)geR.ged.get(".manufacturerName.en");
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SrvDeviceInfo", "lm: getManufacturer is %s", new Object[] { paramContext });
      bool = bu.isNullOrNil(paramContext);
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
  
  public static void vE(String paramString)
  {
    AppMethodBeat.i(155823);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SrvDeviceInfo", "update deviceInfo %s", new Object[] { paramString });
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(155823);
      return;
    }
    if (paramString.hashCode() == geW)
    {
      AppMethodBeat.o(155823);
      return;
    }
    geW = paramString.hashCode();
    geL.reset();
    geM.reset();
    geN.reset();
    geX.reset();
    geO.reset();
    geP.reset();
    Object localObject = geQ;
    ((t)localObject).gdg = 0;
    ((t)localObject).gdh = 0;
    localObject = geR;
    ((y)localObject).gec = "";
    ((y)localObject).ged = null;
    localObject = geS;
    ((ad)localObject).dLM = false;
    ((ad)localObject).geJ = 0;
    ((ad)localObject).geK = false;
    geT.reset();
    geU.reset();
    localObject = geV;
    ((a)localObject).fYl = false;
    ((a)localObject).fYm = "";
    new s();
    if (!s.a(paramString, geL, geM, geN, geX, geO, geP, geQ, geR, geS, geT, geV, geU))
    {
      AppMethodBeat.o(155823);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SrvDeviceInfo", "steve: mCameraInfo.mSupportVoipBeauty = " + geM.gaQ + ", mVoipBeautyWhiteCfg=" + geM.gaR);
    paramString = new cu();
    com.tencent.mm.sdk.b.a.IvT.l(paramString);
    AppMethodBeat.o(155823);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.ae
 * JD-Core Version:    0.7.0.1
 */