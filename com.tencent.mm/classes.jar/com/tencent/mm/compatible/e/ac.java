package com.tencent.mm.compatible.e;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ck;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

public final class ac
{
  public static ab erA;
  public static w erB;
  public static w erC;
  public static a erD;
  private static int erE;
  public static k erF;
  public static p erG;
  public static o ert;
  public static c eru;
  public static b erv;
  public static y erw;
  public static ae erx;
  public static t ery;
  public static x erz;
  
  static
  {
    AppMethodBeat.i(139718);
    ert = new o();
    eru = new c();
    erv = new b();
    erw = new y();
    erx = new ae();
    ery = new t();
    erz = new x();
    erA = new ab();
    erB = new w();
    erC = new w();
    erD = new a();
    erE = -1;
    erF = new k();
    erG = new p();
    AppMethodBeat.o(139718);
  }
  
  public static String bH(Context paramContext)
  {
    AppMethodBeat.i(139717);
    try
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SrvDeviceInfo", "lm: getManufacturer CurrentLanguage is %s", new Object[] { aa.gP(paramContext) });
      if ((erz == null) || (erz.erf == null) || (erz.erf.size() == 0))
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SrvDeviceInfo", "lm: getManufacturer return is %s", new Object[] { Build.MANUFACTURER });
        paramContext = Build.MANUFACTURER;
        AppMethodBeat.o(139717);
        return paramContext;
      }
      paramContext = (String)erz.erf.get(".manufacturerName." + aa.gP(paramContext));
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SrvDeviceInfo", "lm: getManufacturer is %s", new Object[] { paramContext });
      boolean bool = bo.isNullOrNil(paramContext);
      if (!bool)
      {
        AppMethodBeat.o(139717);
        return paramContext;
      }
      paramContext = (String)erz.erf.get(".manufacturerName.en");
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SrvDeviceInfo", "lm: getManufacturer is %s", new Object[] { paramContext });
      bool = bo.isNullOrNil(paramContext);
      if (!bool)
      {
        AppMethodBeat.o(139717);
        return paramContext;
      }
      paramContext = Build.MANUFACTURER;
      AppMethodBeat.o(139717);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext = Build.MANUFACTURER;
      AppMethodBeat.o(139717);
    }
    return paramContext;
  }
  
  public static void ll(String paramString)
  {
    AppMethodBeat.i(139716);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SrvDeviceInfo", "update deviceInfo %s", new Object[] { paramString });
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(139716);
      return;
    }
    if (paramString.hashCode() == erE)
    {
      AppMethodBeat.o(139716);
      return;
    }
    erE = paramString.hashCode();
    ert.reset();
    eru.reset();
    erv.reset();
    erF.reset();
    erw.reset();
    erx.reset();
    Object localObject = ery;
    ((t)localObject).eqB = 0;
    ((t)localObject).eqC = 0;
    localObject = erz;
    ((x)localObject).ere = "";
    ((x)localObject).erf = null;
    localObject = erA;
    ((ab)localObject).cJE = false;
    ((ab)localObject).err = 0;
    ((ab)localObject).ers = false;
    erB.reset();
    erC.reset();
    localObject = erD;
    ((a)localObject).emB = false;
    ((a)localObject).emC = "";
    new s();
    if (!s.a(paramString, ert, eru, erv, erF, erw, erx, ery, erz, erA, erB, erD, erC))
    {
      AppMethodBeat.o(139716);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SrvDeviceInfo", "steve: mCameraInfo.mSupportVoipBeauty = " + eru.eoy + ", mVoipBeautyWhiteCfg=" + eru.eoz);
    paramString = new ck();
    com.tencent.mm.sdk.b.a.ymk.l(paramString);
    AppMethodBeat.o(139716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.e.ac
 * JD-Core Version:    0.7.0.1
 */