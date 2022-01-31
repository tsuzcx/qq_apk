package com.tencent.luggage.game.a;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$2
  implements Runnable
{
  c$2(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(140326);
    if (this.bzQ.bzI != null) {
      synchronized (this.bzQ)
      {
        if (this.bzQ.bzI != null)
        {
          this.bzQ.bzI.destroy();
          this.bzQ.bzI = null;
        }
        AppMethodBeat.o(140326);
        return;
      }
    }
    AppMethodBeat.o(140326);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.a.c.2
 * JD-Core Version:    0.7.0.1
 */