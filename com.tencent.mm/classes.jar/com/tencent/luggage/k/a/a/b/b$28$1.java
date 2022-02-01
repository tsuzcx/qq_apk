package com.tencent.luggage.k.a.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class b$28$1
  implements Runnable
{
  b$28$1(b.28 param28) {}
  
  public final void run()
  {
    AppMethodBeat.i(210431);
    this.ckF.ckB.k(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(210430);
        if (!b.28.1.this.ckF.ckB.chW.get())
        {
          AppMethodBeat.o(210430);
          return;
        }
        if (b.28.1.this.ckF.ckB.cjU != null)
        {
          b.28.1.this.ckF.ckB.cjU.setSurface(null);
          if (!b.28.1.this.ckF.ckB.cjU.isPlaying()) {
            b.28.1.this.ckF.ckB.i(false, true);
          }
        }
        AppMethodBeat.o(210430);
      }
    });
    AppMethodBeat.o(210431);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.k.a.a.b.b.28.1
 * JD-Core Version:    0.7.0.1
 */