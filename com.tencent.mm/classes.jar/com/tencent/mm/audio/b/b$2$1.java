package com.tencent.mm.audio.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$2$1
  implements Runnable
{
  b$2$1(b.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(116474);
    this.cja.ciZ.Ez();
    if (b.a(this.cja.ciZ) != null) {
      b.a(this.cja.ciZ).onError();
    }
    AppMethodBeat.o(116474);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.audio.b.b.2.1
 * JD-Core Version:    0.7.0.1
 */