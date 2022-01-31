package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.j.a;
import com.tencent.mm.blink.b;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;

final class o$1
  extends j.a
{
  o$1(o paramo) {}
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(139645);
    if ((g.RG()) && (g.RJ().eHg))
    {
      g.RJ();
      a.QP();
    }
    AppMethodBeat.o(139645);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(139644);
    if ((g.RG()) && (g.RJ().eHg))
    {
      g.RJ();
      if (!a.QP()) {
        b.HP().o(new o.1.1(this));
      }
    }
    AppMethodBeat.o(139644);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvideo.o.1
 * JD-Core Version:    0.7.0.1
 */