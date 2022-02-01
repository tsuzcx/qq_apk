package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storagebase.h;

public final class c
{
  public long gLX = 0L;
  boolean gas = false;
  private long mUa = -1L;
  
  public final void begin()
  {
    AppMethodBeat.i(21817);
    ac.d("MicroMsg.Recoverfaster", "begin");
    if (b.bFw().bFx().ghG != null)
    {
      this.mUa = b.bFw().bFx().ghG.vE(Thread.currentThread().getId());
      this.gas = true;
    }
    this.gLX = bs.eWj();
    AppMethodBeat.o(21817);
  }
  
  public final void end()
  {
    AppMethodBeat.i(21818);
    if ((this.gas) && (b.bFw().bFx().ghG != null))
    {
      b.bFw().bFx().ghG.qL(this.mUa);
      this.gas = false;
    }
    AppMethodBeat.o(21818);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.c
 * JD-Core Version:    0.7.0.1
 */