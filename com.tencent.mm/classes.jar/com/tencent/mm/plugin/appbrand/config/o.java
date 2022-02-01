package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.c;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.protocal.protobuf.dup;
import com.tencent.mm.protocal.protobuf.dur;
import com.tencent.mm.sdk.platformtools.bt;

public final class o
  extends c<dur>
{
  final com.tencent.mm.al.b rr;
  
  public o(String paramString1, String paramString2)
  {
    AppMethodBeat.i(44853);
    b.a locala = new b.a();
    dup localdup = new dup();
    localdup.DII = paramString1;
    if (bt.isNullOrNil(paramString1))
    {
      paramString1 = j.aOC().e(paramString2, new String[] { "syncVersion" });
      if (paramString1 == null) {
        paramString1 = "";
      }
    }
    for (paramString1 = new com.tencent.mm.bx.b(paramString1.getBytes());; paramString1 = j.aOC().FZ(paramString1))
    {
      localdup.CIu = paramString1;
      localdup.EJa = paramString2;
      locala.gUU = localdup;
      locala.gUV = new dur();
      locala.funcId = 1151;
      locala.uri = "/cgi-bin/mmbiz-bin/wxaattr/wxaattrsync";
      paramString1 = locala.atI();
      this.rr = paramString1;
      this.rr = paramString1;
      AppMethodBeat.o(44853);
      return;
      paramString1 = bt.nullAsNil(paramString1.field_syncVersion);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.o
 * JD-Core Version:    0.7.0.1
 */