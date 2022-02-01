package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;

public final class c
{
  boolean hjE = false;
  public long hwQ = 0L;
  private long oKR = -1L;
  
  public final void begin()
  {
    AppMethodBeat.i(21817);
    Log.d("MicroMsg.Recoverfaster", "begin");
    if (b.chw().chx().hqK != null)
    {
      this.oKR = b.chw().chx().hqK.beginTransaction(Thread.currentThread().getId());
      this.hjE = true;
    }
    this.hwQ = Util.nowMilliSecond();
    AppMethodBeat.o(21817);
  }
  
  public final void end()
  {
    AppMethodBeat.i(21818);
    if ((this.hjE) && (b.chw().chx().hqK != null))
    {
      b.chw().chx().hqK.endTransaction(this.oKR);
      this.hjE = false;
    }
    AppMethodBeat.o(21818);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.c
 * JD-Core Version:    0.7.0.1
 */