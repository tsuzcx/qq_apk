package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.g.a.dg;
import com.tencent.mm.kernel.g;

final class b$6
  extends o.a
{
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(108403);
    if ((g.ajM()) && (g.ajP().gDk))
    {
      g.ajP();
      if (!com.tencent.mm.kernel.a.aiT())
      {
        paramString = new dg();
        paramString.dpg.state = 0;
        com.tencent.mm.sdk.b.a.IvT.l(paramString);
      }
    }
    AppMethodBeat.o(108403);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(108402);
    if ((g.ajM()) && (g.ajP().gDk))
    {
      g.ajP();
      if (!com.tencent.mm.kernel.a.aiT())
      {
        paramString = new dg();
        paramString.dpg.state = 1;
        com.tencent.mm.sdk.b.a.IvT.l(paramString);
      }
    }
    AppMethodBeat.o(108402);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.b.6
 * JD-Core Version:    0.7.0.1
 */