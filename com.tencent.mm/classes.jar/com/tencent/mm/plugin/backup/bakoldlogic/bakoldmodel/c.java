package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;

public final class c
{
  public long mJI = 0L;
  private long uXV = -1L;
  boolean uXW = false;
  
  public final void begin()
  {
    AppMethodBeat.i(21817);
    Log.d("MicroMsg.Recoverfaster", "begin");
    if (b.cXr().cXs().mCN != null)
    {
      this.uXV = b.cXr().cXs().mCN.beginTransaction(Thread.currentThread().getId());
      this.uXW = true;
    }
    this.mJI = Util.nowMilliSecond();
    AppMethodBeat.o(21817);
  }
  
  public final void end()
  {
    AppMethodBeat.i(21818);
    if ((this.uXW) && (b.cXr().cXs().mCN != null))
    {
      b.cXr().cXs().mCN.endTransaction(this.uXV);
      this.uXW = false;
    }
    AppMethodBeat.o(21818);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.c
 * JD-Core Version:    0.7.0.1
 */