package com.tencent.luggage.k.a.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.WXLivePlayer;
import java.util.concurrent.atomic.AtomicBoolean;

final class a$11$2
  implements Runnable
{
  a$11$2(a.11 param11) {}
  
  public final void run()
  {
    AppMethodBeat.i(210410);
    if (this.cid.cia.chW.get())
    {
      AppMethodBeat.o(210410);
      return;
    }
    if (this.cid.cia.chp != null)
    {
      this.cid.cia.chp.f(this.cid.cia.mSurface);
      if (!this.cid.cia.chp.cij.isPlaying()) {
        this.cid.cia.chp.b("play", null);
      }
    }
    AppMethodBeat.o(210410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.k.a.a.a.a.a.11.2
 * JD-Core Version:    0.7.0.1
 */