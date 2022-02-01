package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.e;
import com.tencent.mm.plugin.appbrand.widget.recent.k;
import com.tencent.mm.protocal.protobuf.crz;
import com.tencent.mm.protocal.protobuf.csa;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.concurrent.TimeUnit;

public final class x
  extends com.tencent.mm.am.b<csa>
{
  private static final long qPH;
  
  static
  {
    AppMethodBeat.i(44638);
    qPH = TimeUnit.MINUTES.toSeconds(5L);
    AppMethodBeat.o(44638);
  }
  
  private x(a parama)
  {
    AppMethodBeat.i(319308);
    c.a locala = new c.a();
    crz localcrz = new crz();
    localcrz.reason = (parama.ordinal() + 1);
    locala.otE = localcrz;
    locala.otF = new csa();
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getsearchshowoutwxaapp";
    locala.funcId = 1314;
    c(locala.bEF());
    AppMethodBeat.o(319308);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(319310);
    if (!h.baC().mBZ)
    {
      AppMethodBeat.o(319310);
      return;
    }
    if (((k)h.ax(k.class)).cSP())
    {
      AppMethodBeat.o(319310);
      return;
    }
    switch (1.qPI[parama.ordinal()])
    {
    }
    for (;;)
    {
      new x(parama).bFJ();
      AppMethodBeat.o(319310);
      return;
      if (Util.getLong(n.aqS().O("GetSearchShowOutWxaApp_lastCheck", "$$invalid"), 0L) + Util.getLong(n.aqS().O("GetSearchShowOutWxaApp_interval", "$$invalid"), qPH) > Util.nowSecond())
      {
        AppMethodBeat.o(319310);
        return;
      }
      n.aqS().dn("GetSearchShowOutWxaApp_lastCheck", String.valueOf(Util.nowSecond()));
      continue;
      if (((Long)h.baE().ban().get(at.a.acND, Long.valueOf(0L))).longValue() + TimeUnit.DAYS.toSeconds(1L) > Util.nowSecond())
      {
        AppMethodBeat.o(319310);
        return;
      }
      h.baE().ban().set(at.a.acND, Long.valueOf(Util.nowSecond()));
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(44634);
      qPJ = new a("DAILY", 0);
      qPK = new a("SEARCH", 1);
      qPL = new a[] { qPJ, qPK };
      AppMethodBeat.o(44634);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.x
 * JD-Core Version:    0.7.0.1
 */