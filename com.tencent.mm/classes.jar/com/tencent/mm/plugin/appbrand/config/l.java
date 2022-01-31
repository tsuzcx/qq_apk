package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.protocal.protobuf.czz;
import com.tencent.mm.protocal.protobuf.dab;
import com.tencent.mm.sdk.platformtools.bo;

public final class l
  extends a<dab>
{
  final com.tencent.mm.ai.b rr;
  
  public l(String paramString1, String paramString2)
  {
    AppMethodBeat.i(129851);
    b.a locala = new b.a();
    czz localczz = new czz();
    localczz.xTl = paramString1;
    if (bo.isNullOrNil(paramString1))
    {
      paramString1 = g.auF().e(paramString2, new String[] { "syncVersion" });
      if (paramString1 == null) {
        paramString1 = "";
      }
    }
    for (paramString1 = new com.tencent.mm.bv.b(paramString1.getBytes());; paramString1 = g.auF().Ai(paramString1))
    {
      localczz.wxN = paramString1;
      localczz.ygK = paramString2;
      locala.fsX = localczz;
      locala.fsY = new dab();
      locala.funcId = 1151;
      locala.uri = "/cgi-bin/mmbiz-bin/wxaattr/wxaattrsync";
      paramString1 = locala.ado();
      this.rr = paramString1;
      this.rr = paramString1;
      AppMethodBeat.o(129851);
      return;
      paramString1 = bo.nullAsNil(paramString1.field_syncVersion);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.l
 * JD-Core Version:    0.7.0.1
 */