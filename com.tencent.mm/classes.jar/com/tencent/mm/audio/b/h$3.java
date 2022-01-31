package com.tencent.mm.audio.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.j.a;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.platformtools.ab;

final class h$3
  implements j.a
{
  h$3(h paramh) {}
  
  public final void onError()
  {
    AppMethodBeat.i(116497);
    h.i(this.ckE).Mh();
    ab.e("MicroMsg.SceneVoice.Recorder", "Record Failed file:" + h.a(this.ckE));
    s.vP(h.a(this.ckE));
    if (this.ckE.ckA != null) {
      this.ckE.ckA.onError();
    }
    AppMethodBeat.o(116497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.audio.b.h.3
 * JD-Core Version:    0.7.0.1
 */