package com.tencent.mm.bf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.vfs.e;

final class a$1
  implements ap.a
{
  a$1(a parama) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(116534);
    long l = e.avI(this.fQU.filename);
    ab.d("MicroMsg.NetSceneUploadMedia", g.Ml() + " onTimerExpired: file:" + this.fQU.filename + " nowlen:" + l + " oldoff:" + this.fQU.fQS);
    if (this.fQU.doScene(this.fQU.dispatcher(), this.fQU.callback) == -1) {
      this.fQU.callback.onSceneEnd(3, -1, "doScene failed", this.fQU);
    }
    AppMethodBeat.o(116534);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.bf.a.1
 * JD-Core Version:    0.7.0.1
 */