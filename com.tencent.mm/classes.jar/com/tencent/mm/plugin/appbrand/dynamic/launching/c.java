package com.tencent.mm.plugin.appbrand.dynamic.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a.e;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.protocal.protobuf.dtz;
import com.tencent.mm.protocal.protobuf.ul;
import com.tencent.mm.protocal.protobuf.um;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class c
{
  private final String appId;
  private final String jnq;
  private final boolean jnr;
  private final String md5;
  
  private c(String paramString1, String paramString2, String paramString3)
  {
    this.appId = paramString1;
    this.md5 = paramString2;
    this.jnq = paramString3;
    this.jnr = false;
  }
  
  public c(String paramString1, String paramString2, String paramString3, byte paramByte)
  {
    this(paramString1, paramString2, paramString3);
  }
  
  private void p(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(121408);
    ((e)g.ab(e.class)).aOk().a(this.appId, paramInt, paramString1, paramString2, 0L, 0L);
    AppMethodBeat.o(121408);
  }
  
  public final int aVG()
  {
    AppMethodBeat.i(121409);
    Object localObject = this.appId;
    String str1 = this.md5;
    String str2 = this.jnq;
    b.a locala = new b.a();
    ul localul = new ul();
    localul.dlB = ((String)localObject);
    localul.CWh = str1;
    localul.CWi = str2;
    locala.gUU = localul;
    locala.gUV = new um();
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/checkdemoinfo";
    locala.funcId = 1124;
    localObject = y.e(locala.atI());
    int i;
    if ((((com.tencent.mm.al.c.a)localObject).errType != 0) || (((com.tencent.mm.al.c.a)localObject).errCode != 0))
    {
      ad.e("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, errType %d, errCode %d, errMsg %s", new Object[] { this.appId, Integer.valueOf(((com.tencent.mm.al.c.a)localObject).errType), Integer.valueOf(((com.tencent.mm.al.c.a)localObject).errCode), ((com.tencent.mm.al.c.a)localObject).errMsg });
      i = a.jnv.ordinal();
      AppMethodBeat.o(121409);
      return i;
    }
    try
    {
      localObject = (um)((com.tencent.mm.al.c.a)localObject).gUK;
      if (((um)localObject).CWj == null)
      {
        ad.e("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, null wxaapp resp", new Object[] { this.appId });
        i = a.jnw.ordinal();
        AppMethodBeat.o(121409);
        return i;
      }
      ad.i("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, wxa.ErrCode %d, has_new_demo %b, url %s, md5 %s", new Object[] { this.appId, Integer.valueOf(((um)localObject).CWj.oXv), Boolean.valueOf(((um)localObject).CWk), ((um)localObject).CWl, ((um)localObject).CWm });
      if (((um)localObject).CWj.oXv != 0)
      {
        i = ((um)localObject).CWj.oXv;
        AppMethodBeat.o(121409);
        return i;
      }
      if ((((um)localObject).CWk) && (!bt.isNullOrNil(((um)localObject).CWm)) && (!bt.isNullOrNil(((um)localObject).CWl))) {
        p(2, ((um)localObject).CWl, ((um)localObject).CWm);
      }
      if ((((um)localObject).CWn) && (!bt.isNullOrNil(((um)localObject).CWp)) && (!bt.isNullOrNil(((um)localObject).CWo))) {
        p(10001, ((um)localObject).CWo, ((um)localObject).CWp);
      }
      i = a.jns.ordinal();
      AppMethodBeat.o(121409);
      return i;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", localException, "CgiCheckDemoInfo, appId %s, cast response failed", new Object[] { this.appId });
      i = a.jnw.ordinal();
      AppMethodBeat.o(121409);
    }
    return i;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(121407);
      jns = new a("Ok", 0);
      jnt = new a("Fail", 1);
      jnu = new a("Timeout", 2);
      jnv = new a("CgiFail", 3);
      jnw = new a("ResponseInvalid", 4);
      jnx = new a("AwaitFail", 5);
      jny = new a[] { jns, jnt, jnu, jnv, jnw, jnx };
      AppMethodBeat.o(121407);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.launching.c
 * JD-Core Version:    0.7.0.1
 */