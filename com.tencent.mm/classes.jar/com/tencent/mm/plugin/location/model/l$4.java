package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.j.a;
import com.tencent.mm.g.a.pj;
import com.tencent.mm.kernel.g;

final class l$4
  extends j.a
{
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(145793);
    if ((g.RG()) && (g.RJ().eHg))
    {
      g.RJ();
      if (!com.tencent.mm.kernel.a.QP())
      {
        paramString = new pj();
        paramString.cFU.active = false;
        com.tencent.mm.sdk.b.a.ymk.l(paramString);
      }
    }
    AppMethodBeat.o(145793);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(145792);
    if ((g.RG()) && (g.RJ().eHg))
    {
      g.RJ();
      if (!com.tencent.mm.kernel.a.QP())
      {
        paramString = new pj();
        paramString.cFU.active = true;
        com.tencent.mm.sdk.b.a.ymk.l(paramString);
      }
    }
    AppMethodBeat.o(145792);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.l.4
 * JD-Core Version:    0.7.0.1
 */