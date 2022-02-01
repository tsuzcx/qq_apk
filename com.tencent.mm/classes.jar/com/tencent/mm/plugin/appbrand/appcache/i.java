package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.h;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.b.p;
import com.tencent.mm.cm.f;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.launching.t;
import com.tencent.mm.plugin.appbrand.launching.w;
import com.tencent.mm.protocal.protobuf.bjw;
import com.tencent.mm.protocal.protobuf.bjx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONObject;

public final class i
  extends com.tencent.mm.ak.a<bjx>
{
  public final b rr;
  
  public i(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44238);
    b.a locala = new b.a();
    locala.funcId = 1718;
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/gettestcodedownloadinfo";
    bjw localbjw = new bjw();
    localbjw.dwb = paramString1;
    if (paramInt2 != 12) {
      localbjw.GXn = paramString2;
    }
    localbjw.GXo = paramString3;
    localbjw.GhO = paramInt1;
    localbjw.GXq = paramInt2;
    if (paramInt1 == 1) {
      paramString3 = ((t)j.T(t.class)).bQ(paramString1, paramInt1);
    }
    try
    {
      localbjw.GXp = new p(h.xs(paramString3).optLong("dev_key")).intValue();
      locala.hQF = localbjw;
      locala.hQG = new bjx();
      paramString3 = locala.aDS();
      this.rr = paramString3;
      c(paramString3);
      ae.d("MicroMsg.AppBrand.CgiGetTestCodeDownloadInfo", "appid:%s,module_name:%s,code_type:%d,package type:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(44238);
      return;
    }
    catch (Exception paramString3)
    {
      for (;;)
      {
        ae.e("MicroMsg.AppBrand.CgiGetTestCodeDownloadInfo", "opt devKey %s", new Object[] { paramString3 });
      }
    }
  }
  
  public final f<a.a<bjx>> aET()
  {
    try
    {
      AppMethodBeat.i(44239);
      final long l = bu.fpO();
      f localf2 = w.a(this);
      f localf1 = localf2;
      if (localf2 == null) {
        localf1 = super.aET();
      }
      localf1 = localf1.b(new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(44239);
      return localf1;
    }
    finally {}
  }
  
  public final bjw aZR()
  {
    return (bjw)this.rr.hQD.hQJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.i
 * JD-Core Version:    0.7.0.1
 */