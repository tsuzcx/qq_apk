package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h;

public final class c
{
  boolean guj = false;
  public long hfU = 0L;
  private long nuy = -1L;
  
  public final void begin()
  {
    AppMethodBeat.i(21817);
    ad.d("MicroMsg.Recoverfaster", "begin");
    if (b.bJF().bJG().gBq != null)
    {
      this.nuy = b.bJF().bJG().gBq.xO(Thread.currentThread().getId());
      this.guj = true;
    }
    this.hfU = bt.flT();
    AppMethodBeat.o(21817);
  }
  
  public final void end()
  {
    AppMethodBeat.i(21818);
    if ((this.guj) && (b.bJF().bJG().gBq != null))
    {
      b.bJF().bJG().gBq.sJ(this.nuy);
      this.guj = false;
    }
    AppMethodBeat.o(21818);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.c
 * JD-Core Version:    0.7.0.1
 */