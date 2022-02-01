package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.h;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.b.p;
import com.tencent.mm.cn.f;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.launching.t;
import com.tencent.mm.plugin.appbrand.launching.w;
import com.tencent.mm.protocal.protobuf.bew;
import com.tencent.mm.protocal.protobuf.bex;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vending.c.a;
import org.json.JSONObject;

public final class i
  extends c<bex>
{
  public final b rr;
  
  public i(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44238);
    b.a locala = new b.a();
    locala.funcId = 1718;
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/gettestcodedownloadinfo";
    bew localbew = new bew();
    localbew.djj = paramString1;
    if (paramInt2 != 12) {
      localbew.EUn = paramString2;
    }
    localbew.EUo = paramString3;
    localbew.Eif = paramInt1;
    localbew.EUq = paramInt2;
    if (paramInt1 == 1) {
      paramString3 = ((t)j.T(t.class)).bK(paramString1, paramInt1);
    }
    try
    {
      localbew.EUp = new p(h.tT(paramString3).optLong("dev_key")).intValue();
      locala.hvt = localbew;
      locala.hvu = new bex();
      paramString3 = locala.aAz();
      this.rr = paramString3;
      this.rr = paramString3;
      ac.d("MicroMsg.AppBrand.CgiGetTestCodeDownloadInfo", "appid:%s,module_name:%s,code_type:%d,package type:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(44238);
      return;
    }
    catch (Exception paramString3)
    {
      for (;;)
      {
        ac.e("MicroMsg.AppBrand.CgiGetTestCodeDownloadInfo", "opt devKey %s", new Object[] { paramString3 });
      }
    }
  }
  
  public final f<c.a<bex>> aBB()
  {
    try
    {
      AppMethodBeat.i(44239);
      final long l = bs.eWj();
      f localf2 = w.a(this);
      f localf1 = localf2;
      if (localf2 == null) {
        localf1 = super.aBB();
      }
      localf1 = localf1.b(new a() {});
      AppMethodBeat.o(44239);
      return localf1;
    }
    finally {}
  }
  
  public final bew aVZ()
  {
    return (bew)this.rr.hvr.hvw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.i
 * JD-Core Version:    0.7.0.1
 */