package com.google.android.exoplayer2.a;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i$a
  implements f.f
{
  private i$a(i parami) {}
  
  public final void cX(int paramInt)
  {
    AppMethodBeat.i(94696);
    e.a locala = i.a(this.aAf);
    if (locala.ayp != null) {
      locala.handler.post(new e.a.6(locala, paramInt));
    }
    AppMethodBeat.o(94696);
  }
  
  public final void d(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(94698);
    e.a locala = i.a(this.aAf);
    if (locala.ayp != null) {
      locala.handler.post(new e.a.4(locala, paramInt, paramLong1, paramLong2));
    }
    AppMethodBeat.o(94698);
  }
  
  public final void nc()
  {
    AppMethodBeat.i(94697);
    i.b(this.aAf);
    AppMethodBeat.o(94697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.a.i.a
 * JD-Core Version:    0.7.0.1
 */