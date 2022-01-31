package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.j.a;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;

final class o$1
  extends j.a
{
  o$1(o paramo) {}
  
  public final void onAppBackground(String paramString) {}
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(146144);
    if ((g.RG()) && (g.RJ().eHg))
    {
      g.RJ();
      if (!a.QP()) {
        this.fJA.lL(3);
      }
    }
    AppMethodBeat.o(146144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelmulti.o.1
 * JD-Core Version:    0.7.0.1
 */