package com.tencent.mm.plugin.appbrand.dynamic.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.ab;
import com.tencent.mm.an.d.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.protocal.protobuf.fne;
import com.tencent.mm.protocal.protobuf.yn;
import com.tencent.mm.protocal.protobuf.yo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
{
  private final String appId;
  private final String md5;
  private final String ojy;
  private final boolean ojz;
  
  private c(String paramString1, String paramString2, String paramString3)
  {
    this.appId = paramString1;
    this.md5 = paramString2;
    this.ojy = paramString3;
    this.ojz = false;
  }
  
  public c(String paramString1, String paramString2, String paramString3, byte paramByte)
  {
    this(paramString1, paramString2, paramString3);
  }
  
  private void p(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(121408);
    ((e)h.ae(e.class)).bFb().a(this.appId, paramInt, paramString1, paramString2, 0L, 0L);
    AppMethodBeat.o(121408);
  }
  
  public final int bNF()
  {
    AppMethodBeat.i(121409);
    Object localObject = this.appId;
    String str1 = this.md5;
    String str2 = this.ojy;
    d.a locala = new d.a();
    yn localyn = new yn();
    localyn.appid = ((String)localObject);
    localyn.SkD = str1;
    localyn.SkE = str2;
    locala.lBU = localyn;
    locala.lBV = new yo();
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/checkdemoinfo";
    locala.funcId = 1124;
    localObject = ab.e(locala.bgN());
    int i;
    if ((((com.tencent.mm.an.c.a)localObject).errType != 0) || (((com.tencent.mm.an.c.a)localObject).errCode != 0))
    {
      Log.e("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, errType %d, errCode %d, errMsg %s", new Object[] { this.appId, Integer.valueOf(((com.tencent.mm.an.c.a)localObject).errType), Integer.valueOf(((com.tencent.mm.an.c.a)localObject).errCode), ((com.tencent.mm.an.c.a)localObject).errMsg });
      i = a.ojD.ordinal();
      AppMethodBeat.o(121409);
      return i;
    }
    try
    {
      localObject = (yo)((com.tencent.mm.an.c.a)localObject).lBJ;
      if (((yo)localObject).SkF == null)
      {
        Log.e("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, null wxaapp resp", new Object[] { this.appId });
        i = a.ojE.ordinal();
        AppMethodBeat.o(121409);
        return i;
      }
      Log.i("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, wxa.ErrCode %d, has_new_demo %b, url %s, md5 %s", new Object[] { this.appId, Integer.valueOf(((yo)localObject).SkF.vht), Boolean.valueOf(((yo)localObject).SkG), ((yo)localObject).SkH, ((yo)localObject).SkI });
      if (((yo)localObject).SkF.vht != 0)
      {
        i = ((yo)localObject).SkF.vht;
        AppMethodBeat.o(121409);
        return i;
      }
      if ((((yo)localObject).SkG) && (!Util.isNullOrNil(((yo)localObject).SkI)) && (!Util.isNullOrNil(((yo)localObject).SkH))) {
        p(2, ((yo)localObject).SkH, ((yo)localObject).SkI);
      }
      if ((((yo)localObject).SkJ) && (!Util.isNullOrNil(((yo)localObject).SkL)) && (!Util.isNullOrNil(((yo)localObject).SkK))) {
        p(10001, ((yo)localObject).SkK, ((yo)localObject).SkL);
      }
      i = a.ojA.ordinal();
      AppMethodBeat.o(121409);
      return i;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", localException, "CgiCheckDemoInfo, appId %s, cast response failed", new Object[] { this.appId });
      i = a.ojE.ordinal();
      AppMethodBeat.o(121409);
    }
    return i;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(121407);
      ojA = new a("Ok", 0);
      ojB = new a("Fail", 1);
      ojC = new a("Timeout", 2);
      ojD = new a("CgiFail", 3);
      ojE = new a("ResponseInvalid", 4);
      ojF = new a("AwaitFail", 5);
      ojG = new a[] { ojA, ojB, ojC, ojD, ojE, ojF };
      AppMethodBeat.o(121407);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.launching.c
 * JD-Core Version:    0.7.0.1
 */