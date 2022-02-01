package com.tencent.mm.plugin.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bh;

public final class e
  extends a
{
  private ax ltx;
  
  public e(ax paramax)
  {
    this.ltx = paramax;
  }
  
  public final void execute(g paramg)
  {
    AppMethodBeat.i(22638);
    bh.a(this.ltx, new e.1(this));
    AppMethodBeat.o(22638);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.g.e
 * JD-Core Version:    0.7.0.1
 */