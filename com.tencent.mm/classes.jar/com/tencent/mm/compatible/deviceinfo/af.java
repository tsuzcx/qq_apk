package com.tencent.mm.compatible.deviceinfo;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.db;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class af
{
  public static o juG;
  public static c juH;
  public static b juI;
  public static ab juJ;
  public static ah juK;
  public static t juL;
  public static z juM;
  public static ae juN;
  public static y juO;
  public static y juP;
  public static a juQ;
  private static int juR;
  public static k juS;
  public static p juT;
  
  static
  {
    AppMethodBeat.i(155825);
    juG = new o();
    juH = new c();
    juI = new b();
    juJ = new ab();
    juK = new ah();
    juL = new t();
    juM = new z();
    juN = new ae();
    juO = new y();
    juP = new y();
    juQ = new a();
    juR = -1;
    juS = new k();
    juT = new p();
    AppMethodBeat.o(155825);
  }
  
  public static void KN(String paramString)
  {
    AppMethodBeat.i(155823);
    Log.i("MicroMsg.SrvDeviceInfo", "update deviceInfo %s", new Object[] { paramString });
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(155823);
      return;
    }
    if (paramString.hashCode() == juR)
    {
      AppMethodBeat.o(155823);
      return;
    }
    juR = paramString.hashCode();
    juG.reset();
    juH.reset();
    juI.reset();
    juS.reset();
    juJ.reset();
    juK.reset();
    Object localObject = juL;
    ((t)localObject).jsW = 0;
    ((t)localObject).jsX = 0;
    localObject = juM;
    ((z)localObject).jtP = "";
    ((z)localObject).jtQ = null;
    localObject = juN;
    ((ae)localObject).fXK = false;
    ((ae)localObject).juE = 0;
    ((ae)localObject).juF = false;
    juO.reset();
    juP.reset();
    localObject = juQ;
    ((a)localObject).jnI = false;
    ((a)localObject).jnJ = "";
    new s();
    if (!s.a(paramString, juG, juH, juI, juS, juJ, juK, juL, juM, juN, juO, juQ, juP))
    {
      AppMethodBeat.o(155823);
      return;
    }
    Log.i("MicroMsg.SrvDeviceInfo", "steve: mCameraInfo.mSupportVoipBeauty = " + juH.jqs + ", mVoipBeautyWhiteCfg=" + juH.jqt);
    paramString = new db();
    EventCenter.instance.publish(paramString);
    AppMethodBeat.o(155823);
  }
  
  public static String cq(Context paramContext)
  {
    AppMethodBeat.i(155824);
    try
    {
      Log.i("MicroMsg.SrvDeviceInfo", "lm: getManufacturer CurrentLanguage is %s", new Object[] { LocaleUtil.getCurrentLanguage(paramContext) });
      if ((juM == null) || (juM.jtQ == null) || (juM.jtQ.size() == 0))
      {
        Log.i("MicroMsg.SrvDeviceInfo", "lm: getManufacturer return is %s", new Object[] { Build.MANUFACTURER });
        paramContext = Build.MANUFACTURER;
        AppMethodBeat.o(155824);
        return paramContext;
      }
      paramContext = (String)juM.jtQ.get(".manufacturerName." + LocaleUtil.getCurrentLanguage(paramContext));
      Log.i("MicroMsg.SrvDeviceInfo", "lm: getManufacturer is %s", new Object[] { paramContext });
      boolean bool = Util.isNullOrNil(paramContext);
      if (!bool)
      {
        AppMethodBeat.o(155824);
        return paramContext;
      }
      paramContext = (String)juM.jtQ.get(".manufacturerName.en");
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