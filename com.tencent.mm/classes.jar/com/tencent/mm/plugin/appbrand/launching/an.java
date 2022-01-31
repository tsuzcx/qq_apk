package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a.a;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.x;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.protocal.protobuf.rt;
import com.tencent.mm.protocal.protobuf.ru;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class an
{
  private final String appId;
  private final String cqq;
  private final String hqh;
  private final boolean hqi;
  
  public an(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.appId = paramString1;
    this.cqq = paramString2;
    this.hqh = paramString3;
    this.hqi = paramBoolean;
  }
  
  private void o(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(131998);
    if ((g.auM().a(this.appId, paramInt, paramString1, paramString2, 0L, 0L)) && (this.hqi)) {
      h.bt(this.appId, 2);
    }
    AppMethodBeat.o(131998);
  }
  
  public final int azZ()
  {
    AppMethodBeat.i(131999);
    Object localObject = this.appId;
    String str1 = this.cqq;
    String str2 = this.hqh;
    b.a locala = new b.a();
    rt localrt = new rt();
    localrt.cwc = ((String)localObject);
    localrt.wJV = str1;
    localrt.wJW = str2;
    locala.fsX = localrt;
    locala.fsY = new ru();
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/checkdemoinfo";
    locala.funcId = 1124;
    localObject = x.c(locala.ado());
    int i;
    if ((((a.a)localObject).errType != 0) || (((a.a)localObject).errCode != 0))
    {
      ab.e("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, errType %d, errCode %d, errMsg %s", new Object[] { this.appId, Integer.valueOf(((a.a)localObject).errType), Integer.valueOf(((a.a)localObject).errCode), ((a.a)localObject).errMsg });
      i = an.a.imU.ordinal();
      AppMethodBeat.o(131999);
      return i;
    }
    try
    {
      localObject = (ru)((a.a)localObject).fsN;
      if (((ru)localObject).wJX == null)
      {
        ab.e("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, null wxaapp resp", new Object[] { this.appId });
        i = an.a.imV.ordinal();
        AppMethodBeat.o(131999);
        return i;
      }
      ab.i("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, wxa.ErrCode %d, has_new_demo %b, url %s, md5 %s", new Object[] { this.appId, Integer.valueOf(((ru)localObject).wJX.lGK), Boolean.valueOf(((ru)localObject).wJY), ((ru)localObject).wJZ, ((ru)localObject).wKa });
      if (((ru)localObject).wJX.lGK != 0)
      {
        i = ((ru)localObject).wJX.lGK;
        AppMethodBeat.o(131999);
        return i;
      }
      if ((((ru)localObject).wJY) && (!bo.isNullOrNil(((ru)localObject).wKa)) && (!bo.isNullOrNil(((ru)localObject).wJZ))) {
        o(2, ((ru)localObject).wJZ, ((ru)localObject).wKa);
      }
      if ((((ru)localObject).wKb) && (!bo.isNullOrNil(((ru)localObject).wKd)) && (!bo.isNullOrNil(((ru)localObject).wKc))) {
        o(10001, ((ru)localObject).wKc, ((ru)localObject).wKd);
      }
      if (!bo.isNullOrNil(((ru)localObject).wKe)) {
        ((m)g.w(m.class)).n(this.appId, 2, ((ru)localObject).wKe);
      }
      i = an.a.imR.ordinal();
      AppMethodBeat.o(131999);
      return i;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", localException, "CgiCheckDemoInfo, appId %s, cast response failed", new Object[] { this.appId });
      i = an.a.imV.ordinal();
      AppMethodBeat.o(131999);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.an
 * JD-Core Version:    0.7.0.1
 */