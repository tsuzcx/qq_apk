package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.voip.model.c;

public final class a$a
  implements Runnable
{
  private c nNJ = null;
  
  public a$a(a parama, c paramc)
  {
    this.nNJ = paramc;
  }
  
  public final void run()
  {
    AppMethodBeat.i(21799);
    if (this.nNJ != null)
    {
      this.nNJ.cLJ();
      this.nNJ.cLG();
      this.nNJ = null;
      this.nNI.nNH = false;
    }
    aw.aaA().setMode(0);
    AppMethodBeat.o(21799);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */