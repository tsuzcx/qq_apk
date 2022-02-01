package com.tencent.mm.plugin.fav;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.q.a;
import com.tencent.mm.autogen.a.zq;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;

final class PluginFav$5
  extends q.a
{
  PluginFav$5(PluginFav paramPluginFav) {}
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(101538);
    if ((h.baz()) && (h.baC().mBZ))
    {
      h.baC();
      b.aZG();
    }
    AppMethodBeat.o(101538);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(101537);
    if ((h.baz()) && (h.baC().mBZ))
    {
      h.baC();
      if (!b.aZG()) {
        new zq().publish();
      }
    }
    AppMethodBeat.o(101537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.PluginFav.5
 * JD-Core Version:    0.7.0.1
 */