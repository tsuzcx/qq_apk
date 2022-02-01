package com.tencent.mm.audio.mix.h;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$1
  implements b.a
{
  private Handler handler;
  
  b$1()
  {
    AppMethodBeat.i(136960);
    this.handler = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(136960);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.audio.mix.h.b.1
 * JD-Core Version:    0.7.0.1
 */