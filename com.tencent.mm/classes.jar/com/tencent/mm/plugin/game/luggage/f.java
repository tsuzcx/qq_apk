package com.tencent.mm.plugin.game.luggage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.i.a;
import com.tencent.mm.plugin.game.luggage.i.a.3;
import com.tencent.mm.plugin.game.luggage.i.a.a;
import com.tencent.mm.plugin.wepkg.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.util.concurrent.atomic.AtomicInteger;

public final class f
{
  private static AtomicInteger CAa;
  
  static
  {
    AppMethodBeat.i(231258);
    CAa = new AtomicInteger(0);
    AppMethodBeat.o(231258);
  }
  
  public static void cMx()
  {
    AppMethodBeat.i(231254);
    CAa.getAndIncrement();
    AppMethodBeat.o(231254);
  }
  
  public static void remove()
  {
    AppMethodBeat.i(231256);
    int i = CAa.decrementAndGet();
    Log.i("MicroMsg.LuggageGameWebViewActivityStack", "remove count = ".concat(String.valueOf(i)));
    if (i <= 0)
    {
      if (a.exd() != null)
      {
        a locala = a.exd();
        Log.i("MicroMsg.GameJsCore", "stop");
        locala.CDu = a.a.CDF;
        locala.aJE("onStop");
        locala.cts = new MTimerHandler(new a.3(locala), false);
        locala.cts.startTimer(300000L);
      }
      b.tA();
    }
    AppMethodBeat.o(231256);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.f
 * JD-Core Version:    0.7.0.1
 */