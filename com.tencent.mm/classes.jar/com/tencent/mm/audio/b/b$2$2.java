package com.tencent.mm.audio.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$2$2
  implements Runnable
{
  b$2$2(b.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(116475);
    this.cja.ciZ.Ez();
    if (b.a(this.cja.ciZ) != null) {
      b.a(this.cja.ciZ).onError();
    }
    AppMethodBeat.o(116475);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.b.b.2.2
 * JD-Core Version:    0.7.0.1
 */