package com.tencent.mm.plugin.appbrand.dynamic.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.protocal.protobuf.efu;
import com.tencent.mm.protocal.protobuf.wu;
import com.tencent.mm.protocal.protobuf.wv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class c
{
  private final String appId;
  private final String khN;
  private final boolean khO;
  private final String md5;
  
  private c(String paramString1, String paramString2, String paramString3)
  {
    this.appId = paramString1;
    this.md5 = paramString2;
    this.khN = paramString3;
    this.khO = false;
  }
  
  public c(String paramString1, String paramString2, String paramString3, byte paramByte)
  {
    this(paramString1, paramString2, paramString3);
  }
  
  private void o(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(121408);
    ((e)g.ab(e.class)).aYu().a(this.appId, paramInt, paramString1, paramString2, 0L, 0L);
    AppMethodBeat.o(121408);
  }
  
  public final int bgi()
  {
    AppMethodBeat.i(121409);
    Object localObject = this.appId;
    String str1 = this.md5;
    String str2 = this.khN;
    b.a locala = new b.a();
    wu localwu = new wu();
    localwu.duW = ((String)localObject);
    localwu.FWc = str1;
    localwu.FWd = str2;
    locala.hNM = localwu;
    locala.hNN = new wv();
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/checkdemoinfo";
    locala.funcId = 1124;
    localObject = y.e(locala.aDC());
    int i;
    if ((((a.a)localObject).errType != 0) || (((a.a)localObject).errCode != 0))
    {
      ad.e("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, errType %d, errCode %d, errMsg %s", new Object[] { this.appId, Integer.valueOf(((a.a)localObject).errType), Integer.valueOf(((a.a)localObject).errCode), ((a.a)localObject).errMsg });
      i = a.khS.ordinal();
      AppMethodBeat.o(121409);
      return i;
    }
    try
    {
      localObject = (wv)((a.a)localObject).hNC;
      if (((wv)localObject).FWe == null)
      {
        ad.e("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, null wxaapp resp", new Object[] { this.appId });
        i = a.khT.ordinal();
        AppMethodBeat.o(121409);
        return i;
      }
      ad.i("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, wxa.ErrCode %d, has_new_demo %b, url %s, md5 %s", new Object[] { this.appId, Integer.valueOf(((wv)localObject).FWe.qel), Boolean.valueOf(((wv)localObject).FWf), ((wv)localObject).FWg, ((wv)localObject).FWh });
      if (((wv)localObject).FWe.qel != 0)
      {
        i = ((wv)localObject).FWe.qel;
        AppMethodBeat.o(121409);
        return i;
      }
      if ((((wv)localObject).FWf) && (!bt.isNullOrNil(((wv)localObject).FWh)) && (!bt.isNullOrNil(((wv)localObject).FWg))) {
        o(2, ((wv)localObject).FWg, ((wv)localObject).FWh);
      }
      if ((((wv)localObject).FWi) && (!bt.isNullOrNil(((wv)localObject).FWk)) && (!bt.isNullOrNil(((wv)localObject).FWj))) {
        o(10001, ((wv)localObject).FWj, ((wv)localObject).FWk);
      }
      i = a.khP.ordinal();
      AppMethodBeat.o(121409);
      return i;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", localException, "CgiCheckDemoInfo, appId %s, cast response failed", new Object[] { this.appId });
      i = a.khT.ordinal();
      AppMethodBeat.o(121409);
    }
    return i;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(121407);
      khP = new a("Ok", 0);
      khQ = new a("Fail", 1);
      khR = new a("Timeout", 2);
      khS = new a("CgiFail", 3);
      khT = new a("ResponseInvalid", 4);
      khU = new a("AwaitFail", 5);
      khV = new a[] { khP, khQ, khR, khS, khT, khU };
      AppMethodBeat.o(121407);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.launching.c
 * JD-Core Version:    0.7.0.1
 */