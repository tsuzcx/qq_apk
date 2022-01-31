package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.j.a;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.kernel.g;

final class c$6
  extends j.a
{
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(139667);
    if ((g.RG()) && (g.RJ().eHg))
    {
      g.RJ();
      if (!com.tencent.mm.kernel.a.QP())
      {
        paramString = new cv();
        paramString.cqn.state = 0;
        com.tencent.mm.sdk.b.a.ymk.l(paramString);
      }
    }
    AppMethodBeat.o(139667);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(139666);
    if ((g.RG()) && (g.RJ().eHg))
    {
      g.RJ();
      if (!com.tencent.mm.kernel.a.QP())
      {
        paramString = new cv();
        paramString.cqn.state = 1;
        com.tencent.mm.sdk.b.a.ymk.l(paramString);
      }
    }
    AppMethodBeat.o(139666);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.c.6
 * JD-Core Version:    0.7.0.1
 */