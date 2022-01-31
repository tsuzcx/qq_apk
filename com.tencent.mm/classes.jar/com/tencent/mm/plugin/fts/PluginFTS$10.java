package com.tencent.mm.plugin.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;

final class PluginFTS$10
  extends com.tencent.mm.plugin.fts.a.a.a
{
  boolean ajY;
  String mQp;
  
  PluginFTS$10(PluginFTS paramPluginFTS)
  {
    AppMethodBeat.i(136594);
    this.mQp = aa.gP(ah.getContext());
    this.ajY = false;
    AppMethodBeat.o(136594);
  }
  
  public final String aAn()
  {
    AppMethodBeat.i(136596);
    String str = String.format("{changed: %b}", new Object[] { Boolean.valueOf(this.ajY) });
    AppMethodBeat.o(136596);
    return str;
  }
  
  public final boolean execute()
  {
    AppMethodBeat.i(136595);
    if ((int)((n)g.G(n.class)).getFTSIndexDB().L(-3L, 0L) != this.mQp.hashCode()) {}
    for (boolean bool = true;; bool = false)
    {
      this.ajY = bool;
      if (this.ajY) {
        com.tencent.mm.sdk.b.a.ymk.l(new uf());
      }
      AppMethodBeat.o(136595);
      return true;
    }
  }
  
  public final String getName()
  {
    return "CheckLanguageUpdate";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.PluginFTS.10
 * JD-Core Version:    0.7.0.1
 */