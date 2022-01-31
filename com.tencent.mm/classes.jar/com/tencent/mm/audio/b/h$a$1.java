package com.tencent.mm.audio.b;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.j.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class h$a$1
  extends ak
{
  h$a$1(h.a parama, h paramh) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(116499);
    if (h.b(this.ckG.ckE) <= 0)
    {
      AppMethodBeat.o(116499);
      return;
    }
    paramMessage = new StringBuilder("On Part :");
    if (this.ckG.ckE.ckz == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.SceneVoice.Recorder", bool);
      h.c(this.ckG.ckE);
      if (this.ckG.ckE.ckz != null) {
        this.ckG.ckE.ckz.adp();
      }
      AppMethodBeat.o(116499);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.audio.b.h.a.1
 * JD-Core Version:    0.7.0.1
 */