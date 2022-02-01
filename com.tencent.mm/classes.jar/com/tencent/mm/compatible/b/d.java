package com.tencent.mm.compatible.b;

import android.media.AudioRecord;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends AudioRecord
{
  public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, 2, paramInt4);
    AppMethodBeat.i(155553);
    g.qL(hashCode());
    AppMethodBeat.o(155553);
  }
  
  public final void release()
  {
    AppMethodBeat.i(155554);
    super.release();
    g.qM(hashCode());
    AppMethodBeat.o(155554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.b.d
 * JD-Core Version:    0.7.0.1
 */