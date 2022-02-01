package com.tencent.luggage.k.a.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class b$28$2
  implements Runnable
{
  b$28$2(b.28 param28) {}
  
  public final void run()
  {
    AppMethodBeat.i(210432);
    if (this.ckF.ckB.chW.get())
    {
      AppMethodBeat.o(210432);
      return;
    }
    if (this.ckF.ckB.cjU != null)
    {
      this.ckF.ckB.cjU.setSurface(this.ckF.ckB.mSurface);
      if (!this.ckF.ckB.cjU.isPlaying()) {
        this.ckF.ckB.i(false, true);
      }
    }
    AppMethodBeat.o(210432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.k.a.a.b.b.28.2
 * JD-Core Version:    0.7.0.1
 */