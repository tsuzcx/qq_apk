package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.h;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.c;
import com.tencent.mm.al.c.a;
import com.tencent.mm.b.p;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.launching.t;
import com.tencent.mm.plugin.appbrand.launching.w;
import com.tencent.mm.protocal.protobuf.bbe;
import com.tencent.mm.protocal.protobuf.bbf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vending.c.a;
import org.json.JSONObject;

public final class i
  extends c<bbf>
{
  public final b rr;
  
  public i(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44238);
    b.a locala = new b.a();
    locala.funcId = 1718;
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/gettestcodedownloadinfo";
    bbe localbbe = new bbe();
    localbbe.dlB = paramString1;
    if (paramInt2 != 12) {
      localbbe.DyR = paramString2;
    }
    localbbe.DyS = paramString3;
    localbbe.CPu = paramInt1;
    localbbe.DyU = paramInt2;
    if (paramInt1 == 1) {
      paramString3 = ((t)j.T(t.class)).bG(paramString1, paramInt1);
    }
    try
    {
      localbbe.DyT = new p(h.qE(paramString3).optLong("dev_key")).intValue();
      locala.gUU = localbbe;
      locala.gUV = new bbf();
      paramString3 = locala.atI();
      this.rr = paramString3;
      this.rr = paramString3;
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
  
  public final bbe aPh()
  {
    return (bbe)this.rr.gUS.gUX;
  }
  
  public final f<c.a<bbf>> auK()
  {
    try
    {
      AppMethodBeat.i(44239);
      final long l = bt.eGO();
      f localf2 = w.a(this);
      f localf1 = localf2;
      if (localf2 == null) {
        localf1 = super.auK();
      }
      localf1 = localf1.b(new a() {});
      AppMethodBeat.o(44239);
      return localf1;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.i
 * JD-Core Version:    0.7.0.1
 */