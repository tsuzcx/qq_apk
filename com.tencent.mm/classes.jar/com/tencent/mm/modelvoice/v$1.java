package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.j.a;
import com.tencent.mm.audio.b.b;
import com.tencent.mm.audio.b.b.a;
import com.tencent.mm.sdk.platformtools.ab;

final class v$1
  implements b.a
{
  v$1(v paramv) {}
  
  public final void onError()
  {
    AppMethodBeat.i(116658);
    if (v.a(this.gaS) != null) {
      v.a(this.gaS).onError();
    }
    try
    {
      v.b(this.gaS).release();
      v.c(this.gaS);
      AppMethodBeat.o(116658);
      return;
    }
    catch (Exception localException)
    {
      ab.e("VoiceRecorder", "setErrorListener File[" + this.gaS.fileName + "] ErrMsg[" + localException.getStackTrace() + "]");
      AppMethodBeat.o(116658);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvoice.v.1
 * JD-Core Version:    0.7.0.1
 */