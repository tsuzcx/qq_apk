package com.tencent.luggage.k.a.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.WXLivePlayer;
import java.util.concurrent.atomic.AtomicBoolean;

final class a$11$1$1
  implements Runnable
{
  a$11$1$1(a.11.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(210408);
    if (!this.cie.cid.cia.chW.get())
    {
      AppMethodBeat.o(210408);
      return;
    }
    if (this.cie.cid.cia.chp != null)
    {
      this.cie.cid.cia.chp.f(null);
      if (!this.cie.cid.cia.chp.cij.isPlaying()) {
        this.cie.cid.cia.chp.b("play", null);
      }
    }
    AppMethodBeat.o(210408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.k.a.a.a.a.a.11.1.1
 * JD-Core Version:    0.7.0.1
 */