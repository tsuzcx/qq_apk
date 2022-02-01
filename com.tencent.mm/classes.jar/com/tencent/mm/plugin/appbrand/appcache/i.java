package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.h;
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.b.p;
import com.tencent.mm.cn.f;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.launching.t;
import com.tencent.mm.plugin.appbrand.launching.w;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.protocal.protobuf.bjf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public final class i
  extends com.tencent.mm.al.a<bjf>
{
  public final b rr;
  
  public i(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44238);
    b.a locala = new b.a();
    locala.funcId = 1718;
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/gettestcodedownloadinfo";
    bje localbje = new bje();
    localbje.duW = paramString1;
    if (paramInt2 != 12) {
      localbje.GDK = paramString2;
    }
    localbje.GDL = paramString3;
    localbje.FPp = paramInt1;
    localbje.GDN = paramInt2;
    if (paramInt1 == 1) {
      paramString3 = ((t)j.T(t.class)).bN(paramString1, paramInt1);
    }
    try
    {
      localbje.GDM = new p(h.wJ(paramString3).optLong("dev_key")).intValue();
      locala.hNM = localbje;
      locala.hNN = new bjf();
      paramString3 = locala.aDC();
      this.rr = paramString3;
      c(paramString3);
      ad.d("MicroMsg.AppBrand.CgiGetTestCodeDownloadInfo", "appid:%s,module_name:%s,code_type:%d,package type:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(44238);
      return;
    }
    catch (Exception paramString3)
    {
      for (;;)
      {
        ad.e("MicroMsg.AppBrand.CgiGetTestCodeDownloadInfo", "opt devKey %s", new Object[] { paramString3 });
      }
    }
  }
  
  public final f<a.a<bjf>> aED()
  {
    try
    {
      AppMethodBeat.i(44239);
      final long l = bt.flT();
      f localf2 = w.a(this);
      f localf1 = localf2;
      if (localf2 == null) {
        localf1 = super.aED();
      }
      localf1 = localf1.b(new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(44239);
      return localf1;
    }
    finally {}
  }
  
  public final bje aZu()
  {
    return (bje)this.rr.hNK.hNQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.i
 * JD-Core Version:    0.7.0.1
 */