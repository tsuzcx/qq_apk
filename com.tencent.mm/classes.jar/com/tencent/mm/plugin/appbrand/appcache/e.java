package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.aa.h;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.a.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.cm.f;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.launching.m;
import com.tencent.mm.protocal.protobuf.aqp;
import com.tencent.mm.protocal.protobuf.aqq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class e
  extends a<aqq>
{
  public final b rr;
  
  public e(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129323);
    b.a locala = new b.a();
    locala.funcId = 1718;
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/gettestcodedownloadinfo";
    aqp localaqp = new aqp();
    localaqp.cwc = paramString1;
    if (paramInt2 != 12) {
      localaqp.xfV = paramString2;
    }
    localaqp.xfW = paramString3;
    localaqp.wDT = paramInt1;
    localaqp.xfY = paramInt2;
    if (paramInt1 == 1) {
      paramString3 = ((m)g.w(m.class)).bm(paramString1, paramInt1);
    }
    try
    {
      localaqp.xfX = new p(h.mo(paramString3).optLong("dev_key")).intValue();
      locala.fsX = localaqp;
      locala.fsY = new aqq();
      paramString3 = locala.ado();
      this.rr = paramString3;
      this.rr = paramString3;
      ab.d("MicroMsg.AppBrand.CgiGetTestCodeDownloadInfo", "appid:%s,module_name:%s,code_type:%d,package type:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(129323);
      return;
    }
    catch (Exception paramString3)
    {
      for (;;)
      {
        ab.e("MicroMsg.AppBrand.CgiGetTestCodeDownloadInfo", "opt devKey %s", new Object[] { paramString3 });
      }
    }
  }
  
  public final f<a.a<aqq>> adl()
  {
    try
    {
      AppMethodBeat.i(129324);
      long l = bo.aoy();
      f localf = super.adl().b(new e.1(this, l));
      AppMethodBeat.o(129324);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.e
 * JD-Core Version:    0.7.0.1
 */