package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ipcall.model.e.g;

public final class b
{
  private static b ysv;
  private g ysw;
  
  public static b eaU()
  {
    AppMethodBeat.i(25513);
    if (ysv == null) {
      ysv = new b();
    }
    b localb = ysv;
    AppMethodBeat.o(25513);
    return localb;
  }
  
  public final void qy(boolean paramBoolean)
  {
    AppMethodBeat.i(25514);
    bg.azz().a(this.ysw);
    this.ysw = null;
    if (paramBoolean) {}
    for (this.ysw = new g(1);; this.ysw = new g(0))
    {
      bg.azz().a(this.ysw, 0);
      AppMethodBeat.o(25514);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g.b
 * JD-Core Version:    0.7.0.1
 */