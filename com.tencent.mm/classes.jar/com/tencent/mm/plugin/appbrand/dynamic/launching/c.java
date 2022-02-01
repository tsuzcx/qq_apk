package com.tencent.mm.plugin.appbrand.dynamic.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.ab;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.protocal.protobuf.fcd;
import com.tencent.mm.protocal.protobuf.yh;
import com.tencent.mm.protocal.protobuf.yi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
{
  private final String appId;
  private final String loO;
  private final boolean loP;
  private final String md5;
  
  private c(String paramString1, String paramString2, String paramString3)
  {
    this.appId = paramString1;
    this.md5 = paramString2;
    this.loO = paramString3;
    this.loP = false;
  }
  
  public c(String paramString1, String paramString2, String paramString3, byte paramByte)
  {
    this(paramString1, paramString2, paramString3);
  }
  
  private void p(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(121408);
    ((e)g.af(e.class)).bub().a(this.appId, paramInt, paramString1, paramString2, 0L, 0L);
    AppMethodBeat.o(121408);
  }
  
  public final int bCj()
  {
    AppMethodBeat.i(121409);
    Object localObject = this.appId;
    String str1 = this.md5;
    String str2 = this.loO;
    d.a locala = new d.a();
    yh localyh = new yh();
    localyh.dNI = ((String)localObject);
    localyh.Ljm = str1;
    localyh.Ljn = str2;
    locala.iLN = localyh;
    locala.iLO = new yi();
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/checkdemoinfo";
    locala.funcId = 1124;
    localObject = ab.e(locala.aXF());
    int i;
    if ((((com.tencent.mm.ak.c.a)localObject).errType != 0) || (((com.tencent.mm.ak.c.a)localObject).errCode != 0))
    {
      Log.e("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, errType %d, errCode %d, errMsg %s", new Object[] { this.appId, Integer.valueOf(((com.tencent.mm.ak.c.a)localObject).errType), Integer.valueOf(((com.tencent.mm.ak.c.a)localObject).errCode), ((com.tencent.mm.ak.c.a)localObject).errMsg });
      i = a.loT.ordinal();
      AppMethodBeat.o(121409);
      return i;
    }
    try
    {
      localObject = (yi)((com.tencent.mm.ak.c.a)localObject).iLC;
      if (((yi)localObject).Ljo == null)
      {
        Log.e("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, null wxaapp resp", new Object[] { this.appId });
        i = a.loU.ordinal();
        AppMethodBeat.o(121409);
        return i;
      }
      Log.i("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, wxa.ErrCode %d, has_new_demo %b, url %s, md5 %s", new Object[] { this.appId, Integer.valueOf(((yi)localObject).Ljo.rBL), Boolean.valueOf(((yi)localObject).Ljp), ((yi)localObject).Ljq, ((yi)localObject).Ljr });
      if (((yi)localObject).Ljo.rBL != 0)
      {
        i = ((yi)localObject).Ljo.rBL;
        AppMethodBeat.o(121409);
        return i;
      }
      if ((((yi)localObject).Ljp) && (!Util.isNullOrNil(((yi)localObject).Ljr)) && (!Util.isNullOrNil(((yi)localObject).Ljq))) {
        p(2, ((yi)localObject).Ljq, ((yi)localObject).Ljr);
      }
      if ((((yi)localObject).Ljs) && (!Util.isNullOrNil(((yi)localObject).Lju)) && (!Util.isNullOrNil(((yi)localObject).Ljt))) {
        p(10001, ((yi)localObject).Ljt, ((yi)localObject).Lju);
      }
      i = a.loQ.ordinal();
      AppMethodBeat.o(121409);
      return i;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", localException, "CgiCheckDemoInfo, appId %s, cast response failed", new Object[] { this.appId });
      i = a.loU.ordinal();
      AppMethodBeat.o(121409);
    }
    return i;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(121407);
      loQ = new a("Ok", 0);
      loR = new a("Fail", 1);
      loS = new a("Timeout", 2);
      loT = new a("CgiFail", 3);
      loU = new a("ResponseInvalid", 4);
      loV = new a("AwaitFail", 5);
      loW = new a[] { loQ, loR, loS, loT, loU, loV };
      AppMethodBeat.o(121407);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.launching.c
 * JD-Core Version:    0.7.0.1
 */