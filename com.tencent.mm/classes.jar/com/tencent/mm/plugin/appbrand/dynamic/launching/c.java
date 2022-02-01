package com.tencent.mm.plugin.appbrand.dynamic.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.protocal.protobuf.ehl;
import com.tencent.mm.protocal.protobuf.wx;
import com.tencent.mm.protocal.protobuf.wy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class c
{
  private final String appId;
  private final String kld;
  private final boolean kle;
  private final String md5;
  
  private c(String paramString1, String paramString2, String paramString3)
  {
    this.appId = paramString1;
    this.md5 = paramString2;
    this.kld = paramString3;
    this.kle = false;
  }
  
  public c(String paramString1, String paramString2, String paramString3, byte paramByte)
  {
    this(paramString1, paramString2, paramString3);
  }
  
  private void o(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(121408);
    ((e)g.ab(e.class)).aYP().a(this.appId, paramInt, paramString1, paramString2, 0L, 0L);
    AppMethodBeat.o(121408);
  }
  
  public final int bgQ()
  {
    AppMethodBeat.i(121409);
    Object localObject = this.appId;
    String str1 = this.md5;
    String str2 = this.kld;
    b.a locala = new b.a();
    wx localwx = new wx();
    localwx.dwb = ((String)localObject);
    localwx.GoB = str1;
    localwx.GoC = str2;
    locala.hQF = localwx;
    locala.hQG = new wy();
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/checkdemoinfo";
    locala.funcId = 1124;
    localObject = y.e(locala.aDS());
    int i;
    if ((((a.a)localObject).errType != 0) || (((a.a)localObject).errCode != 0))
    {
      ae.e("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, errType %d, errCode %d, errMsg %s", new Object[] { this.appId, Integer.valueOf(((a.a)localObject).errType), Integer.valueOf(((a.a)localObject).errCode), ((a.a)localObject).errMsg });
      i = a.kli.ordinal();
      AppMethodBeat.o(121409);
      return i;
    }
    try
    {
      localObject = (wy)((a.a)localObject).hQv;
      if (((wy)localObject).GoD == null)
      {
        ae.e("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, null wxaapp resp", new Object[] { this.appId });
        i = a.klj.ordinal();
        AppMethodBeat.o(121409);
        return i;
      }
      ae.i("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, wxa.ErrCode %d, has_new_demo %b, url %s, md5 %s", new Object[] { this.appId, Integer.valueOf(((wy)localObject).GoD.qkQ), Boolean.valueOf(((wy)localObject).GoE), ((wy)localObject).GoF, ((wy)localObject).GoG });
      if (((wy)localObject).GoD.qkQ != 0)
      {
        i = ((wy)localObject).GoD.qkQ;
        AppMethodBeat.o(121409);
        return i;
      }
      if ((((wy)localObject).GoE) && (!bu.isNullOrNil(((wy)localObject).GoG)) && (!bu.isNullOrNil(((wy)localObject).GoF))) {
        o(2, ((wy)localObject).GoF, ((wy)localObject).GoG);
      }
      if ((((wy)localObject).GoH) && (!bu.isNullOrNil(((wy)localObject).GoJ)) && (!bu.isNullOrNil(((wy)localObject).GoI))) {
        o(10001, ((wy)localObject).GoI, ((wy)localObject).GoJ);
      }
      i = a.klf.ordinal();
      AppMethodBeat.o(121409);
      return i;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", localException, "CgiCheckDemoInfo, appId %s, cast response failed", new Object[] { this.appId });
      i = a.klj.ordinal();
      AppMethodBeat.o(121409);
    }
    return i;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(121407);
      klf = new a("Ok", 0);
      klg = new a("Fail", 1);
      klh = new a("Timeout", 2);
      kli = new a("CgiFail", 3);
      klj = new a("ResponseInvalid", 4);
      klk = new a("AwaitFail", 5);
      kll = new a[] { klf, klg, klh, kli, klj, klk };
      AppMethodBeat.o(121407);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.launching.c
 * JD-Core Version:    0.7.0.1
 */