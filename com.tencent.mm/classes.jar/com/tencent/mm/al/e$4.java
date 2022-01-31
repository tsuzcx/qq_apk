package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.h;
import java.util.Map;
import java.util.Queue;

final class e$4
  implements Runnable
{
  e$4(e parame, h paramh) {}
  
  public final void run()
  {
    AppMethodBeat.i(50561);
    this.fzs.fyK.add(this.fzt.field_mediaId);
    this.fzs.fyL.put(this.fzt.field_mediaId, this.fzt);
    this.fzs.cV(false);
    AppMethodBeat.o(50561);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.al.e.4
 * JD-Core Version:    0.7.0.1
 */