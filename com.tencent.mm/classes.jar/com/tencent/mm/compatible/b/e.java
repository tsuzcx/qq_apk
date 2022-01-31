package com.tencent.mm.compatible.b;

import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends AudioTrack
{
  public e(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, 2, paramInt4, 1);
    AppMethodBeat.i(92836);
    g.iH(hashCode());
    AppMethodBeat.o(92836);
  }
  
  public final void release()
  {
    AppMethodBeat.i(92837);
    super.release();
    g.iI(hashCode());
    AppMethodBeat.o(92837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.compatible.b.e
 * JD-Core Version:    0.7.0.1
 */