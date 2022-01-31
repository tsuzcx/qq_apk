package com.tencent.mm.audio.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class j$1
  implements b.a
{
  j$1(j paramj) {}
  
  public final void onError()
  {
    AppMethodBeat.i(116529);
    j.a(this.ckY).Mh();
    if (j.b(this.ckY) != null) {
      j.b(this.ckY).onError();
    }
    try
    {
      j.c(this.ckY).release();
      j.d(this.ckY);
      AppMethodBeat.o(116529);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.SimpleVoiceRecorder", "setErrorListener File[" + this.ckY.fileName + "] ErrMsg[" + localException.getStackTrace() + "]");
      AppMethodBeat.o(116529);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.b.j.1
 * JD-Core Version:    0.7.0.1
 */