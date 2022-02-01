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
  private static AtomicInteger xwf;
  
  static
  {
    AppMethodBeat.i(186829);
    xwf = new AtomicInteger(0);
    AppMethodBeat.o(186829);
  }
  
  public static void cyc()
  {
    AppMethodBeat.i(186827);
    xwf.getAndIncrement();
    AppMethodBeat.o(186827);
  }
  
  public static void remove()
  {
    AppMethodBeat.i(186828);
    int i = xwf.decrementAndGet();
    Log.i("MicroMsg.LuggageGameWebViewActivityStack", "remove count = ".concat(String.valueOf(i)));
    if (i <= 0)
    {
      if (a.dTW() != null)
      {
        a locala = a.dTW();
        Log.i("MicroMsg.GameJsCore", "stop");
        locala.xzp = a.a.xzA;
        locala.azS("onStop");
        locala.cve = new MTimerHandler(new a.3(locala), false);
        locala.cve.startTimer(300000L);
      }
      b.vC();
    }
    AppMethodBeat.o(186828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.f
 * JD-Core Version:    0.7.0.1
 */