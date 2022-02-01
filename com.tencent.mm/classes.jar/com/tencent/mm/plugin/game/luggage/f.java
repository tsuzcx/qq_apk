package com.tencent.mm.plugin.game.luggage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.h.a;
import com.tencent.mm.plugin.game.luggage.h.a.3;
import com.tencent.mm.plugin.game.luggage.h.a.a;
import com.tencent.mm.plugin.wepkg.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.util.concurrent.atomic.AtomicInteger;

public final class f
{
  private static AtomicInteger ItL;
  
  static
  {
    AppMethodBeat.i(276944);
    ItL = new AtomicInteger(0);
    AppMethodBeat.o(276944);
  }
  
  public static void dqb()
  {
    AppMethodBeat.i(276937);
    ItL.getAndIncrement();
    AppMethodBeat.o(276937);
  }
  
  public static void remove()
  {
    AppMethodBeat.i(276941);
    int i = ItL.decrementAndGet();
    Log.i("MicroMsg.LuggageGameWebViewActivityStack", "remove count = ".concat(String.valueOf(i)));
    if (i <= 0)
    {
      if (a.fFa() != null)
      {
        a locala = a.fFa();
        Log.i("MicroMsg.GameJsCore", "stop");
        locala.Ixz = a.a.IxK;
        locala.aGs("onStop");
        locala.eln = new MTimerHandler(new a.3(locala), false);
        locala.eln.startTimer(300000L);
      }
      b.Td();
    }
    AppMethodBeat.o(276941);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.f
 * JD-Core Version:    0.7.0.1
 */