package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.networking.a;
import com.tencent.mm.protocal.protobuf.egk;
import com.tencent.mm.protocal.protobuf.egm;
import com.tencent.mm.sdk.platformtools.bt;

public final class o
  extends a<egm>
{
  final com.tencent.mm.al.b rr;
  
  public o(String paramString1, String paramString2)
  {
    super(paramString2, paramString1);
    AppMethodBeat.i(44853);
    b.a locala = new b.a();
    egk localegk = new egk();
    localegk.GNH = paramString1;
    if (bt.isNullOrNil(paramString1))
    {
      paramString1 = j.aYP().e(paramString2, new String[] { "syncVersion" });
      if (paramString1 == null) {
        paramString1 = "";
      }
    }
    for (paramString1 = new com.tencent.mm.bx.b(paramString1.getBytes());; paramString1 = j.aYP().Nw(paramString1))
    {
      localegk.FGF = paramString1;
      localegk.HRz = paramString2;
      locala.hNM = localegk;
      locala.hNN = new egm();
      locala.funcId = 1151;
      locala.uri = "/cgi-bin/mmbiz-bin/wxaattr/wxaattrsync";
      paramString1 = locala.aDC();
      this.rr = paramString1;
      c(paramString1);
      AppMethodBeat.o(44853);
      return;
      paramString1 = bt.nullAsNil(paramString1.field_syncVersion);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.o
 * JD-Core Version:    0.7.0.1
 */