package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.protocal.protobuf.apo;
import java.util.concurrent.TimeUnit;

public final class x
  extends com.tencent.mm.ai.a<apo>
{
  private static final long hcs;
  
  static
  {
    AppMethodBeat.i(129705);
    hcs = TimeUnit.MINUTES.toSeconds(5L);
    AppMethodBeat.o(129705);
  }
  
  public static void axC()
  {
    AppMethodBeat.i(129702);
    if (!com.tencent.mm.kernel.g.RJ().eHg)
    {
      AppMethodBeat.o(129702);
      return;
    }
    com.tencent.mm.kernel.g.E(d.class);
    AppMethodBeat.o(129702);
  }
  
  static apo axD()
  {
    AppMethodBeat.i(129703);
    apo localapo = (apo)com.tencent.mm.plugin.appbrand.app.g.auQ().f("GetSearchShowOutWxaApp_resp", apo.class);
    AppMethodBeat.o(129703);
    return localapo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.x
 * JD-Core Version:    0.7.0.1
 */