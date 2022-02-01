package com.tencent.mm.plugin.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ai;

final class PluginFTS$10
  extends com.tencent.mm.plugin.fts.a.a.a
{
  boolean ash;
  String swa;
  
  PluginFTS$10(PluginFTS paramPluginFTS)
  {
    AppMethodBeat.i(52574);
    this.swa = ab.iC(ai.getContext());
    this.ash = false;
    AppMethodBeat.o(52574);
  }
  
  public final String bdq()
  {
    AppMethodBeat.i(52576);
    String str = String.format("{changed: %b}", new Object[] { Boolean.valueOf(this.ash) });
    AppMethodBeat.o(52576);
    return str;
  }
  
  public final boolean execute()
  {
    AppMethodBeat.i(52575);
    if ((int)((n)g.ad(n.class)).getFTSIndexDB().Q(-3L, 0L) != this.swa.hashCode()) {}
    for (boolean bool = true;; bool = false)
    {
      this.ash = bool;
      if (this.ash) {
        com.tencent.mm.sdk.b.a.GpY.l(new wp());
      }
      AppMethodBeat.o(52575);
      return true;
    }
  }
  
  public final String getName()
  {
    return "CheckLanguageUpdate";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.PluginFTS.10
 * JD-Core Version:    0.7.0.1
 */