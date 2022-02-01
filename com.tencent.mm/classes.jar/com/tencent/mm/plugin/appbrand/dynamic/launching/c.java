package com.tencent.mm.plugin.appbrand.dynamic.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.aa;
import com.tencent.mm.am.b.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.protocal.protobuf.aak;
import com.tencent.mm.protocal.protobuf.aal;
import com.tencent.mm.protocal.protobuf.gjx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
{
  private final String appId;
  private final String md5;
  private final String rna;
  private final boolean rnb;
  
  private c(String paramString1, String paramString2, String paramString3)
  {
    this.appId = paramString1;
    this.md5 = paramString2;
    this.rna = paramString3;
    this.rnb = false;
  }
  
  public c(String paramString1, String paramString2, String paramString3, byte paramByte)
  {
    this(paramString1, paramString2, paramString3);
  }
  
  private void s(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(121408);
    ((e)h.ax(e.class)).ceo().a(this.appId, paramInt, paramString1, paramString2, 0L, 0L);
    AppMethodBeat.o(121408);
  }
  
  public final int cnU()
  {
    AppMethodBeat.i(121409);
    Object localObject = this.appId;
    String str1 = this.md5;
    String str2 = this.rna;
    com.tencent.mm.am.c.a locala = new com.tencent.mm.am.c.a();
    aak localaak = new aak();
    localaak.appid = ((String)localObject);
    localaak.ZiN = str1;
    localaak.ZiO = str2;
    locala.otE = localaak;
    locala.otF = new aal();
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/checkdemoinfo";
    locala.funcId = 1124;
    localObject = aa.a(locala.bEF(), 20000L);
    int i;
    if ((((b.a)localObject).errType != 0) || (((b.a)localObject).errCode != 0))
    {
      Log.e("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, errType %d, errCode %d, errMsg %s", new Object[] { this.appId, Integer.valueOf(((b.a)localObject).errType), Integer.valueOf(((b.a)localObject).errCode), ((b.a)localObject).errMsg });
      i = a.rnf.ordinal();
      AppMethodBeat.o(121409);
      return i;
    }
    try
    {
      localObject = (aal)((b.a)localObject).ott;
      if (((aal)localObject).ZiP == null)
      {
        Log.e("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, null wxaapp resp", new Object[] { this.appId });
        i = a.rng.ordinal();
        AppMethodBeat.o(121409);
        return i;
      }
      Log.i("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, wxa.ErrCode %d, has_new_demo %b, url %s, md5 %s", new Object[] { this.appId, Integer.valueOf(((aal)localObject).ZiP.ytv), Boolean.valueOf(((aal)localObject).ZiQ), ((aal)localObject).ZiR, ((aal)localObject).ZiS });
      if (((aal)localObject).ZiP.ytv != 0)
      {
        i = ((aal)localObject).ZiP.ytv;
        AppMethodBeat.o(121409);
        return i;
      }
      if ((((aal)localObject).ZiQ) && (!Util.isNullOrNil(((aal)localObject).ZiS)) && (!Util.isNullOrNil(((aal)localObject).ZiR))) {
        s(2, ((aal)localObject).ZiR, ((aal)localObject).ZiS);
      }
      if ((((aal)localObject).ZiT) && (!Util.isNullOrNil(((aal)localObject).ZiV)) && (!Util.isNullOrNil(((aal)localObject).ZiU))) {
        s(10001, ((aal)localObject).ZiU, ((aal)localObject).ZiV);
      }
      i = a.rnc.ordinal();
      AppMethodBeat.o(121409);
      return i;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", localException, "CgiCheckDemoInfo, appId %s, cast response failed", new Object[] { this.appId });
      i = a.rng.ordinal();
      AppMethodBeat.o(121409);
    }
    return i;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(121407);
      rnc = new a("Ok", 0);
      rnd = new a("Fail", 1);
      rne = new a("Timeout", 2);
      rnf = new a("CgiFail", 3);
      rng = new a("ResponseInvalid", 4);
      rnh = new a("AwaitFail", 5);
      rni = new a[] { rnc, rnd, rne, rnf, rng, rnh };
      AppMethodBeat.o(121407);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.launching.c
 * JD-Core Version:    0.7.0.1
 */