package com.tencent.mm.plugin.game.luggage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.h.a;
import com.tencent.mm.plugin.game.luggage.h.a.3;
import com.tencent.mm.plugin.game.luggage.h.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import java.util.concurrent.atomic.AtomicInteger;

public final class f
{
  private static AtomicInteger uef;
  
  static
  {
    AppMethodBeat.i(192975);
    uef = new AtomicInteger(0);
    AppMethodBeat.o(192975);
  }
  
  public static void cal()
  {
    AppMethodBeat.i(192973);
    uef.getAndIncrement();
    AppMethodBeat.o(192973);
  }
  
  public static void remove()
  {
    AppMethodBeat.i(192974);
    int i = uef.decrementAndGet();
    ae.i("MicroMsg.LuggageGameWebViewActivityStack", "remove count = ".concat(String.valueOf(i)));
    if (i <= 0)
    {
      if (a.dao() != null)
      {
        a locala = a.dao();
        ae.i("MicroMsg.GameJsCore", "stop");
        locala.ugU = a.a.uhe;
        locala.amD("onStop");
        locala.cji = new aw(new a.3(locala), false);
        locala.cji.ay(300000L, 300000L);
      }
      ae.i("MicroMsg.GameJsServerCommLibPkg", "load");
    }
    AppMethodBeat.o(192974);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.f
 * JD-Core Version:    0.7.0.1
 */