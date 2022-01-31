package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.a.o;
import com.tencent.mm.ah.a;
import com.tencent.mm.ah.a.a;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ck.f;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.protocal.c.alc;
import com.tencent.mm.protocal.c.ald;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class c
  extends a<ald>
{
  public final b dmK;
  
  public c(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    b.a locala = new b.a();
    locala.ecG = 1718;
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/gettestcodedownloadinfo";
    alc localalc = new alc();
    localalc.bOL = paramString1;
    localalc.thh = paramString2;
    localalc.thi = paramString3;
    localalc.sHx = paramInt;
    if (paramInt == 1) {
      paramString1 = ((com.tencent.mm.plugin.appbrand.launching.h)e.G(com.tencent.mm.plugin.appbrand.launching.h.class)).aV(paramString1, paramInt);
    }
    try
    {
      localalc.thj = new o(com.tencent.mm.ab.h.fU(paramString1).optLong("dev_key")).intValue();
      locala.ecH = localalc;
      locala.ecI = new ald();
      paramString1 = locala.Kt();
      this.dmK = paramString1;
      this.dmK = paramString1;
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        y.e("MicroMsg.AppBrand.CgiGetTestCodeDownloadInfo", "opt devKey %s", new Object[] { paramString1 });
      }
    }
  }
  
  public final f<a.a<ald>> Km()
  {
    try
    {
      long l = bk.UY();
      f localf = super.Km().g(new c.1(this, l));
      return localf;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.c
 * JD-Core Version:    0.7.0.1
 */