package com.tencent.mm.compatible.deviceinfo;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Map;

public final class ae
{
  public static o fJc;
  public static c fJd;
  public static b fJe;
  public static aa fJf;
  public static ag fJg;
  public static t fJh;
  public static y fJi;
  public static ad fJj;
  public static x fJk;
  public static x fJl;
  public static a fJm;
  private static int fJn;
  public static k fJo;
  public static p fJp;
  
  static
  {
    AppMethodBeat.i(155825);
    fJc = new o();
    fJd = new c();
    fJe = new b();
    fJf = new aa();
    fJg = new ag();
    fJh = new t();
    fJi = new y();
    fJj = new ad();
    fJk = new x();
    fJl = new x();
    fJm = new a();
    fJn = -1;
    fJo = new k();
    fJp = new p();
    AppMethodBeat.o(155825);
  }
  
  public static String bZ(Context paramContext)
  {
    AppMethodBeat.i(155824);
    try
    {
      ac.i("MicroMsg.SrvDeviceInfo", "lm: getManufacturer CurrentLanguage is %s", new Object[] { ab.iC(paramContext) });
      if ((fJi == null) || (fJi.fIv == null) || (fJi.fIv.size() == 0))
      {
        ac.i("MicroMsg.SrvDeviceInfo", "lm: getManufacturer return is %s", new Object[] { Build.MANUFACTURER });
        paramContext = Build.MANUFACTURER;
        AppMethodBeat.o(155824);
        return paramContext;
      }
      paramContext = (String)fJi.fIv.get(".manufacturerName." + ab.iC(paramContext));
      ac.i("MicroMsg.SrvDeviceInfo", "lm: getManufacturer is %s", new Object[] { paramContext });
      boolean bool = bs.isNullOrNil(paramContext);
      if (!bool)
      {
        AppMethodBeat.o(155824);
        return paramContext;
      }
      paramContext = (String)fJi.fIv.get(".manufacturerName.en");
      ac.i("MicroMsg.SrvDeviceInfo", "lm: getManufacturer is %s", new Object[] { paramContext });
      bool = bs.isNullOrNil(paramContext);
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
  
  public static void st(String paramString)
  {
    AppMethodBeat.i(155823);
    ac.i("MicroMsg.SrvDeviceInfo", "update deviceInfo %s", new Object[] { paramString });
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(155823);
      return;
    }
    if (paramString.hashCode() == fJn)
    {
      AppMethodBeat.o(155823);
      return;
    }
    fJn = paramString.hashCode();
    fJc.reset();
    fJd.reset();
    fJe.reset();
    fJo.reset();
    fJf.reset();
    fJg.reset();
    Object localObject = fJh;
    ((t)localObject).fHy = 0;
    ((t)localObject).fHz = 0;
    localObject = fJi;
    ((y)localObject).fIu = "";
    ((y)localObject).fIv = null;
    localObject = fJj;
    ((ad)localObject).dyk = false;
    ((ad)localObject).fJa = 0;
    ((ad)localObject).fJb = false;
    fJk.reset();
    fJl.reset();
    localObject = fJm;
    ((a)localObject).fCR = false;
    ((a)localObject).fCS = "";
    new s();
    if (!s.a(paramString, fJc, fJd, fJe, fJo, fJf, fJg, fJh, fJi, fJj, fJk, fJm, fJl))
    {
      AppMethodBeat.o(155823);
      return;
    }
    ac.i("MicroMsg.SrvDeviceInfo", "steve: mCameraInfo.mSupportVoipBeauty = " + fJd.fFk + ", mVoipBeautyWhiteCfg=" + fJd.fFl);
    paramString = new cq();
    com.tencent.mm.sdk.b.a.GpY.l(paramString);
    AppMethodBeat.o(155823);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.ae
 * JD-Core Version:    0.7.0.1
 */