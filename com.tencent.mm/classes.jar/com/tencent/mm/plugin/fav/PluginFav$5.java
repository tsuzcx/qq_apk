package com.tencent.mm.plugin.fav;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.g.a.vr;
import com.tencent.mm.kernel.g;

final class PluginFav$5
  extends o.a
{
  PluginFav$5(PluginFav paramPluginFav) {}
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(101538);
    if ((g.ajM()) && (g.ajP().gDk))
    {
      g.ajP();
      com.tencent.mm.kernel.a.aiT();
    }
    AppMethodBeat.o(101538);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(101537);
    if ((g.ajM()) && (g.ajP().gDk))
    {
      g.ajP();
      if (!com.tencent.mm.kernel.a.aiT()) {
        com.tencent.mm.sdk.b.a.IvT.l(new vr());
      }
    }
    AppMethodBeat.o(101537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.PluginFav.5
 * JD-Core Version:    0.7.0.1
 */