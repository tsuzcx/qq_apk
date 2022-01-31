package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.sdk.platformtools.ap.a;

final class d$3
  implements ap.a
{
  d$3(d paramd) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(50667);
    if (this.fVJ.doScene(this.fVJ.dispatcher(), this.fVJ.callback) == -1) {
      this.fVJ.callback.onSceneEnd(3, -1, "doScene failed", this.fVJ);
    }
    AppMethodBeat.o(50667);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.d.3
 * JD-Core Version:    0.7.0.1
 */