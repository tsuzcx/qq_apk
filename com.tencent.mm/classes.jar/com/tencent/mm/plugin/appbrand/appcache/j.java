package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.h;
import com.tencent.mm.am.b;
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.b.p;
import com.tencent.mm.cp.f;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.launching.t;
import com.tencent.mm.plugin.appbrand.launching.w;
import com.tencent.mm.protocal.protobuf.ctn;
import com.tencent.mm.protocal.protobuf.cto;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.c.a;
import org.json.JSONObject;

public final class j
  extends b<cto>
{
  public final c rr;
  
  public j(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44238);
    c.a locala = new c.a();
    locala.funcId = 1718;
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/gettestcodedownloadinfo";
    ctn localctn = new ctn();
    localctn.appid = paramString1;
    if (paramInt2 != 12) {
      localctn.aazm = paramString2;
    }
    localctn.aazn = paramString3;
    localctn.Zby = paramInt1;
    localctn.aazp = paramInt2;
    if (paramInt1 == 1) {
      paramString3 = ((t)n.ag(t.class)).cR(paramString1, paramInt1);
    }
    try
    {
      localctn.aazo = new p(h.Fn(paramString3).optLong("dev_key")).intValue();
      locala.otE = localctn;
      locala.otF = new cto();
      paramString3 = locala.bEF();
      this.rr = paramString3;
      c(paramString3);
      Log.d("MicroMsg.AppBrand.CgiGetTestCodeDownloadInfo", "appid:%s,module_name:%s,code_type:%d,package type:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(44238);
      return;
    }
    catch (Exception paramString3)
    {
      for (;;)
      {
        Log.e("MicroMsg.AppBrand.CgiGetTestCodeDownloadInfo", "opt devKey %s", new Object[] { paramString3 });
      }
    }
  }
  
  public final f<b.a<cto>> bFJ()
  {
    try
    {
      AppMethodBeat.i(44239);
      final long l = Util.nowMilliSecond();
      f localf2 = w.a(this);
      f localf1 = localf2;
      if (localf2 == null) {
        localf1 = super.bFJ();
      }
      localf1 = localf1.b(new a() {});
      AppMethodBeat.o(44239);
      return localf1;
    }
    finally {}
  }
  
  public final ctn cfN()
  {
    AppMethodBeat.i(320293);
    ctn localctn = (ctn)c.b.b(this.rr.otB);
    AppMethodBeat.o(320293);
    return localctn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.j
 * JD-Core Version:    0.7.0.1
 */