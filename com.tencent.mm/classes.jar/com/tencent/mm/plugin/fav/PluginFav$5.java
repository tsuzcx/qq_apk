package com.tencent.mm.plugin.fav;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.j.a;
import com.tencent.mm.g.a.sp;
import com.tencent.mm.kernel.g;

final class PluginFav$5
  extends j.a
{
  PluginFav$5(PluginFav paramPluginFav) {}
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(151911);
    if ((g.RG()) && (g.RJ().eHg))
    {
      g.RJ();
      com.tencent.mm.kernel.a.QP();
    }
    AppMethodBeat.o(151911);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(151910);
    if ((g.RG()) && (g.RJ().eHg))
    {
      g.RJ();
      if (!com.tencent.mm.kernel.a.QP()) {
        com.tencent.mm.sdk.b.a.ymk.l(new sp());
      }
    }
    AppMethodBeat.o(151910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.PluginFav.5
 * JD-Core Version:    0.7.0.1
 */