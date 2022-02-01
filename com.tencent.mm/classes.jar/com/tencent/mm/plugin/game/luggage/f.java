package com.tencent.mm.plugin.game.luggage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.h.a;
import com.tencent.mm.plugin.game.luggage.h.a.3;
import com.tencent.mm.plugin.game.luggage.h.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import java.util.concurrent.atomic.AtomicInteger;

public final class f
{
  private static AtomicInteger tTo;
  
  static
  {
    AppMethodBeat.i(211590);
    tTo = new AtomicInteger(0);
    AppMethodBeat.o(211590);
  }
  
  public static void bYW()
  {
    AppMethodBeat.i(211588);
    tTo.getAndIncrement();
    AppMethodBeat.o(211588);
  }
  
  public static void remove()
  {
    AppMethodBeat.i(211589);
    int i = tTo.decrementAndGet();
    ad.i("MicroMsg.LuggageGameWebViewActivityStack", "remove count = ".concat(String.valueOf(i)));
    if (i <= 0)
    {
      if (a.cXE() != null)
      {
        a locala = a.cXE();
        ad.i("MicroMsg.GameJsCore", "stop");
        locala.tVW = a.a.tWg;
        locala.alD("onStop");
        locala.cjg = new av(new a.3(locala), false);
        locala.cjg.az(300000L, 300000L);
      }
      ad.i("MicroMsg.GameJsServerCommLibPkg", "load");
    }
    AppMethodBeat.o(211589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.f
 * JD-Core Version:    0.7.0.1
 */