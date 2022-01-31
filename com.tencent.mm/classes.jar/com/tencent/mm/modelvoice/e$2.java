package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.sdk.platformtools.ap.a;

final class e$2
  implements ap.a
{
  e$2(e parame) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(116566);
    if (this.fZx.doScene(e.a(this.fZx), e.b(this.fZx)) == -1) {
      e.b(this.fZx).onSceneEnd(3, -1, "doScene failed", this.fZx);
    }
    AppMethodBeat.o(116566);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvoice.e.2
 * JD-Core Version:    0.7.0.1
 */