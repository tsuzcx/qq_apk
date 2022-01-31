package com.tencent.mm.plugin.backup.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.plugin.backup.h.b;
import com.tencent.mm.sdk.platformtools.bo;

final class d$a
{
  private long beginTime;
  private long jAB = -1L;
  boolean jAC = false;
  
  private d$a(d paramd) {}
  
  public final void aTj()
  {
    AppMethodBeat.i(17201);
    if (bo.hl(this.beginTime) > 500L) {
      end();
    }
    try
    {
      Thread.sleep(5L);
      label30:
      begin();
      this.beginTime = bo.aoy();
      AppMethodBeat.o(17201);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label30;
    }
  }
  
  public final void begin()
  {
    AppMethodBeat.i(17199);
    if (com.tencent.mm.plugin.backup.h.d.aUK().aUL().eHS != null)
    {
      this.jAB = com.tencent.mm.plugin.backup.h.d.aUK().aUL().eHS.kr(Thread.currentThread().getId());
      this.jAC = true;
      this.beginTime = bo.aoy();
    }
    AppMethodBeat.o(17199);
  }
  
  public final void end()
  {
    AppMethodBeat.i(17200);
    if ((this.jAC) && (com.tencent.mm.plugin.backup.h.d.aUK().aUL().eHS != null))
    {
      com.tencent.mm.plugin.backup.h.d.aUK().aUL().eHS.nY(this.jAB);
      this.jAC = false;
    }
    AppMethodBeat.o(17200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.d.a
 * JD-Core Version:    0.7.0.1
 */