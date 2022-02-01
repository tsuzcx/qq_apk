package com.tencent.mm.compatible.b;

import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends AudioTrack
{
  public e(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, 2, paramInt4, 1);
    AppMethodBeat.i(155555);
    g.lk(hashCode());
    AppMethodBeat.o(155555);
  }
  
  public final void release()
  {
    AppMethodBeat.i(155556);
    super.release();
    g.ll(hashCode());
    AppMethodBeat.o(155556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.b.e
 * JD-Core Version:    0.7.0.1
 */