package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storagebase.h;

public final class c
{
  boolean gwQ = false;
  public long hiI = 0L;
  private long nzT = -1L;
  
  public final void begin()
  {
    AppMethodBeat.i(21817);
    ae.d("MicroMsg.Recoverfaster", "begin");
    if (b.bKD().bKE().gDX != null)
    {
      this.nzT = b.bKD().bKE().gDX.yi(Thread.currentThread().getId());
      this.gwQ = true;
    }
    this.hiI = bu.fpO();
    AppMethodBeat.o(21817);
  }
  
  public final void end()
  {
    AppMethodBeat.i(21818);
    if ((this.gwQ) && (b.bKD().bKE().gDX != null))
    {
      b.bKD().bKE().gDX.sW(this.nzT);
      this.gwQ = false;
    }
    AppMethodBeat.o(21818);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.c
 * JD-Core Version:    0.7.0.1
 */