package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class c
{
  public long ePF = 0L;
  private long jAB = -1L;
  boolean jAC = false;
  
  public final void begin()
  {
    AppMethodBeat.i(17760);
    ab.d("MicroMsg.Recoverfaster", "begin");
    if (b.aVr().aVs().eHS != null)
    {
      this.jAB = b.aVr().aVs().eHS.kr(Thread.currentThread().getId());
      this.jAC = true;
    }
    this.ePF = bo.aoy();
    AppMethodBeat.o(17760);
  }
  
  public final void end()
  {
    AppMethodBeat.i(17761);
    if ((this.jAC) && (b.aVr().aVs().eHS != null))
    {
      b.aVr().aVs().eHS.nY(this.jAB);
      this.jAC = false;
    }
    AppMethodBeat.o(17761);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.c
 * JD-Core Version:    0.7.0.1
 */