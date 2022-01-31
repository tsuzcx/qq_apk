package com.tencent.luggage.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Queue;

public final class e$1
  implements Runnable
{
  public e$1(e parame) {}
  
  public final void run()
  {
    AppMethodBeat.i(140394);
    Iterator localIterator = e.a(this.bAG).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      e.b(this.bAG).log(str);
    }
    e.a(this.bAG).clear();
    AppMethodBeat.o(140394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.game.d.e.1
 * JD-Core Version:    0.7.0.1
 */