package com.tencent.mm.at;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.j.a;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;

final class o$2
  extends j.a
{
  o$2(o paramo) {}
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(151566);
    if ((g.RG()) && (g.RJ().eHg))
    {
      g.RJ();
      if (!a.QP()) {
        o.ahE().cP(false);
      }
    }
    AppMethodBeat.o(151566);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(151565);
    if ((g.RG()) && (g.RJ().eHg))
    {
      g.RJ();
      if (!a.QP())
      {
        com.tencent.mm.blink.b.HP().o(new o.2.1(this));
        o.ahE().cP(true);
      }
    }
    AppMethodBeat.o(151565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.at.o.2
 * JD-Core Version:    0.7.0.1
 */