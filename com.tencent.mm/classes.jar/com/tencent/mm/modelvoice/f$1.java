package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class f$1
  implements ap.a
{
  f$1(f paramf) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(116577);
    r localr = s.vT(this.fZA.fileName);
    if ((localr == null) || (!localr.amw()))
    {
      ab.e("MicroMsg.NetSceneUploadVoice", "Get info Failed file:" + this.fZA.fileName);
      this.fZA.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
      this.fZA.callback.onSceneEnd(3, -1, "doScene failed", this.fZA);
      AppMethodBeat.o(116577);
      return false;
    }
    if ((3 != localr.status) && (8 != localr.status))
    {
      long l = System.currentTimeMillis();
      if (l / 1000L - localr.fXv > 30L)
      {
        ab.e("MicroMsg.NetSceneUploadVoice", "Error ModifyTime in Read file:" + this.fZA.fileName);
        this.fZA.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
        this.fZA.callback.onSceneEnd(3, -1, "doScene failed", this.fZA);
        AppMethodBeat.o(116577);
        return false;
      }
      if (l - this.fZA.fZz < 2000L)
      {
        ab.d("MicroMsg.NetSceneUploadVoice", "TimerExpired :" + this.fZA.fileName + " but last send time:" + (l - this.fZA.fZz));
        AppMethodBeat.o(116577);
        return true;
      }
      g localg = s.vK(this.fZA.fileName).cJ(localr.fWa, 6000);
      ab.d("MicroMsg.NetSceneUploadVoice", "pusher doscene:" + this.fZA.fileName + " readByte:" + localg.ckj + " stat:" + localr.status);
      if (localg.ckj < 2000)
      {
        AppMethodBeat.o(116577);
        return true;
      }
    }
    if (this.fZA.doScene(this.fZA.dispatcher(), this.fZA.callback) == -1)
    {
      this.fZA.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
      this.fZA.callback.onSceneEnd(3, -1, "doScene failed", this.fZA);
    }
    AppMethodBeat.o(116577);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelvoice.f.1
 * JD-Core Version:    0.7.0.1
 */