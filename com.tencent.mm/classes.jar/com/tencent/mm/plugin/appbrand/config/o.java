package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.cm.f;
import com.tencent.mm.cm.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.networking.a;
import com.tencent.mm.protocal.protobuf.eib;
import com.tencent.mm.protocal.protobuf.eid;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vending.g.c.a;

public final class o
  extends com.tencent.mm.plugin.appbrand.networking.b<eid>
{
  final com.tencent.mm.ak.b rr;
  
  public o(String paramString1, String paramString2)
  {
    super(paramString2, paramString1);
    AppMethodBeat.i(44853);
    b.a locala = new b.a();
    eib localeib = new eib();
    localeib.Hhh = paramString1;
    if (bu.isNullOrNil(paramString1))
    {
      paramString1 = j.aZl().e(paramString2, new String[] { "syncVersion" });
      if (paramString1 == null) {
        paramString1 = "";
      }
    }
    for (paramString1 = new com.tencent.mm.bw.b(paramString1.getBytes());; paramString1 = j.aZl().Oe(paramString1))
    {
      localeib.FZb = paramString1;
      localeib.IlG = paramString2;
      locala.hQF = localeib;
      locala.hQG = new eid();
      locala.funcId = 1151;
      locala.uri = "/cgi-bin/mmbiz-bin/wxaattr/wxaattrsync";
      paramString1 = locala.aDS();
      this.rr = paramString1;
      c(paramString1);
      AppMethodBeat.o(44853);
      return;
      paramString1 = bu.nullAsNil(paramString1.field_syncVersion);
      break;
    }
  }
  
  public final f<a.a<eid>> beN()
  {
    AppMethodBeat.i(222223);
    if (!a.ej(((eib)this.rr.hQD.hQJ).IlG, ((eib)this.rr.hQD.hQJ).Hhh))
    {
      f localf = g.c(new c.a() {});
      AppMethodBeat.o(222223);
      return localf;
    }
    AppMethodBeat.o(222223);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.o
 * JD-Core Version:    0.7.0.1
 */