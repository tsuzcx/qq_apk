package com.tencent.mm.plugin.appbrand.dynamic.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a.e;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.protocal.protobuf.dzq;
import com.tencent.mm.protocal.protobuf.uv;
import com.tencent.mm.protocal.protobuf.uw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class c
{
  private final String appId;
  private final String jNC;
  private final boolean jND;
  private final String md5;
  
  private c(String paramString1, String paramString2, String paramString3)
  {
    this.appId = paramString1;
    this.md5 = paramString2;
    this.jNC = paramString3;
    this.jND = false;
  }
  
  public c(String paramString1, String paramString2, String paramString3, byte paramByte)
  {
    this(paramString1, paramString2, paramString3);
  }
  
  private void o(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(121408);
    ((e)g.ab(e.class)).aVa().a(this.appId, paramInt, paramString1, paramString2, 0L, 0L);
    AppMethodBeat.o(121408);
  }
  
  public final int bcE()
  {
    AppMethodBeat.i(121409);
    Object localObject = this.appId;
    String str1 = this.md5;
    String str2 = this.jNC;
    b.a locala = new b.a();
    uv localuv = new uv();
    localuv.djj = ((String)localObject);
    localuv.EoQ = str1;
    localuv.EoR = str2;
    locala.hvt = localuv;
    locala.hvu = new uw();
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/checkdemoinfo";
    locala.funcId = 1124;
    localObject = y.e(locala.aAz());
    int i;
    if ((((com.tencent.mm.ak.c.a)localObject).errType != 0) || (((com.tencent.mm.ak.c.a)localObject).errCode != 0))
    {
      ac.e("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, errType %d, errCode %d, errMsg %s", new Object[] { this.appId, Integer.valueOf(((com.tencent.mm.ak.c.a)localObject).errType), Integer.valueOf(((com.tencent.mm.ak.c.a)localObject).errCode), ((com.tencent.mm.ak.c.a)localObject).errMsg });
      i = a.jNH.ordinal();
      AppMethodBeat.o(121409);
      return i;
    }
    try
    {
      localObject = (uw)((com.tencent.mm.ak.c.a)localObject).hvj;
      if (((uw)localObject).EoS == null)
      {
        ac.e("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, null wxaapp resp", new Object[] { this.appId });
        i = a.jNI.ordinal();
        AppMethodBeat.o(121409);
        return i;
      }
      ac.i("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, wxa.ErrCode %d, has_new_demo %b, url %s, md5 %s", new Object[] { this.appId, Integer.valueOf(((uw)localObject).EoS.pAG), Boolean.valueOf(((uw)localObject).EoT), ((uw)localObject).EoU, ((uw)localObject).EoV });
      if (((uw)localObject).EoS.pAG != 0)
      {
        i = ((uw)localObject).EoS.pAG;
        AppMethodBeat.o(121409);
        return i;
      }
      if ((((uw)localObject).EoT) && (!bs.isNullOrNil(((uw)localObject).EoV)) && (!bs.isNullOrNil(((uw)localObject).EoU))) {
        o(2, ((uw)localObject).EoU, ((uw)localObject).EoV);
      }
      if ((((uw)localObject).EoW) && (!bs.isNullOrNil(((uw)localObject).EoY)) && (!bs.isNullOrNil(((uw)localObject).EoX))) {
        o(10001, ((uw)localObject).EoX, ((uw)localObject).EoY);
      }
      i = a.jNE.ordinal();
      AppMethodBeat.o(121409);
      return i;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", localException, "CgiCheckDemoInfo, appId %s, cast response failed", new Object[] { this.appId });
      i = a.jNI.ordinal();
      AppMethodBeat.o(121409);
    }
    return i;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(121407);
      jNE = new a("Ok", 0);
      jNF = new a("Fail", 1);
      jNG = new a("Timeout", 2);
      jNH = new a("CgiFail", 3);
      jNI = new a("ResponseInvalid", 4);
      jNJ = new a("AwaitFail", 5);
      jNK = new a[] { jNE, jNF, jNG, jNH, jNI, jNJ };
      AppMethodBeat.o(121407);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.launching.c
 * JD-Core Version:    0.7.0.1
 */