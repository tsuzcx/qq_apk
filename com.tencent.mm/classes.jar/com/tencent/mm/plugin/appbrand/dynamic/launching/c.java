package com.tencent.mm.plugin.appbrand.dynamic.launching;

import com.tencent.mm.ah.a.a;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.x;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.ar;
import com.tencent.mm.protocal.c.cls;
import com.tencent.mm.protocal.c.or;
import com.tencent.mm.protocal.c.os;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class c
{
  private final String appId;
  private final String bIW;
  private final String fWH;
  private final boolean fWI;
  
  private c(String paramString1, String paramString2, String paramString3)
  {
    this.appId = paramString1;
    this.bIW = paramString2;
    this.fWH = paramString3;
    this.fWI = false;
  }
  
  public c(String paramString1, String paramString2, String paramString3, byte paramByte)
  {
    this(paramString1, paramString2, paramString3);
  }
  
  private void g(int paramInt, String paramString1, String paramString2)
  {
    ((com.tencent.mm.plugin.appbrand.a.c)g.r(com.tencent.mm.plugin.appbrand.a.c.class)).aaG().a(this.appId, paramInt, paramString1, paramString2, 0L, 0L);
  }
  
  public final int afv()
  {
    Object localObject = this.appId;
    String str1 = this.bIW;
    String str2 = this.fWH;
    b.a locala = new b.a();
    or localor = new or();
    localor.bOL = ((String)localObject);
    localor.sMi = str1;
    localor.sMj = str2;
    locala.ecH = localor;
    locala.ecI = new os();
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/checkdemoinfo";
    locala.ecG = 1124;
    localObject = x.c(locala.Kt());
    if ((((a.a)localObject).errType != 0) || (((a.a)localObject).errCode != 0))
    {
      y.e("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, errType %d, errCode %d, errMsg %s", new Object[] { this.appId, Integer.valueOf(((a.a)localObject).errType), Integer.valueOf(((a.a)localObject).errCode), ((a.a)localObject).aox });
      return c.a.fWM.ordinal();
    }
    try
    {
      localObject = (os)((a.a)localObject).ecw;
      if (((os)localObject).sMk == null)
      {
        y.e("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, null wxaapp resp", new Object[] { this.appId });
        return c.a.fWN.ordinal();
      }
      y.i("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, wxa.ErrCode %d, has_new_demo %b, url %s, md5 %s", new Object[] { this.appId, Integer.valueOf(((os)localObject).sMk.jxl), Boolean.valueOf(((os)localObject).sMl), ((os)localObject).sMm, ((os)localObject).sMn });
      if (((os)localObject).sMk.jxl != 0) {
        return ((os)localObject).sMk.jxl;
      }
      if ((((os)localObject).sMl) && (!bk.bl(((os)localObject).sMn)) && (!bk.bl(((os)localObject).sMm))) {
        g(2, ((os)localObject).sMm, ((os)localObject).sMn);
      }
      if ((((os)localObject).sMo) && (!bk.bl(((os)localObject).sMq)) && (!bk.bl(((os)localObject).sMp))) {
        g(10001, ((os)localObject).sMp, ((os)localObject).sMq);
      }
      int i = c.a.fWJ.ordinal();
      return i;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", localException, "CgiCheckDemoInfo, appId %s, cast response failed", new Object[] { this.appId });
    }
    return c.a.fWN.ordinal();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.launching.c
 * JD-Core Version:    0.7.0.1
 */