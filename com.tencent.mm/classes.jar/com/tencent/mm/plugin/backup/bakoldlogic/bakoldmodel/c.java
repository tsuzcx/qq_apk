package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h;

public final class c
{
  public long glk = 0L;
  private long mrY = -1L;
  boolean mrZ = false;
  
  public final void begin()
  {
    AppMethodBeat.i(21817);
    ad.d("MicroMsg.Recoverfaster", "begin");
    if (b.byA().byB().gda != null)
    {
      this.mrY = b.byA().byB().gda.rb(Thread.currentThread().getId());
      this.mrZ = true;
    }
    this.glk = bt.eGO();
    AppMethodBeat.o(21817);
  }
  
  public final void end()
  {
    AppMethodBeat.i(21818);
    if ((this.mrZ) && (b.byA().byB().gda != null))
    {
      b.byA().byB().gda.mX(this.mrY);
      this.mrZ = false;
    }
    AppMethodBeat.o(21818);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.c
 * JD-Core Version:    0.7.0.1
 */