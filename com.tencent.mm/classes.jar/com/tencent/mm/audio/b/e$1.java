package com.tencent.mm.audio.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Timer;

final class e$1
  implements e.c
{
  e$1(e parame) {}
  
  public final void finish()
  {
    AppMethodBeat.i(55749);
    this.ckb.cjS.ckf = null;
    ab.i("MicroMsg.RecordModeAsyncRead", "finish stopRecord");
    if (this.ckb.cjT != null)
    {
      if (this.ckb.cjY != null)
      {
        this.ckb.cjY.cancel();
        this.ckb.cjY = null;
      }
      ??? = this.ckb.cjT;
      ((b)???).elH = 0;
      ((b)???).elI = 0;
      ((b)???).elK = 0;
      ((b)???).elL = 0;
      ((b)???).elJ = null;
    }
    synchronized (this.ckb.cjV)
    {
      this.ckb.cjT = null;
      this.ckb.cjU = null;
      this.ckb.cjZ = false;
      this.ckb.cjT = null;
      AppMethodBeat.o(55749);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.audio.b.e.1
 * JD-Core Version:    0.7.0.1
 */