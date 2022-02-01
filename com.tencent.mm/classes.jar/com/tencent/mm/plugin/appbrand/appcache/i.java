package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.h;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.b.p;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.launching.t;
import com.tencent.mm.plugin.appbrand.launching.v;
import com.tencent.mm.protocal.protobuf.bwb;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.c.a;
import org.json.JSONObject;

public final class i
  extends c<bwc>
{
  public final d rr;
  
  public i(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44238);
    d.a locala = new d.a();
    locala.funcId = 1718;
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/gettestcodedownloadinfo";
    bwb localbwb = new bwb();
    localbwb.dNI = paramString1;
    if (paramInt2 != 12) {
      localbwb.MbW = paramString2;
    }
    localbwb.MbX = paramString3;
    localbwb.Lcr = paramInt1;
    localbwb.MbZ = paramInt2;
    if (paramInt1 == 1) {
      paramString3 = ((t)n.W(t.class)).bU(paramString1, paramInt1);
    }
    try
    {
      localbwb.MbY = new p(h.FE(paramString3).optLong("dev_key")).intValue();
      locala.iLN = localbwb;
      locala.iLO = new bwc();
      paramString3 = locala.aXF();
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
  
  public final f<c.a<bwc>> aYI()
  {
    try
    {
      AppMethodBeat.i(44239);
      final long l = Util.nowMilliSecond();
      f localf2 = v.a(this);
      f localf1 = localf2;
      if (localf2 == null) {
        localf1 = super.aYI();
      }
      localf1 = localf1.b(new a() {});
      AppMethodBeat.o(44239);
      return localf1;
    }
    finally {}
  }
  
  public final bwb bvi()
  {
    return (bwb)this.rr.iLK.iLR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.i
 * JD-Core Version:    0.7.0.1
 */