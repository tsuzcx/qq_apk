package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.e;
import com.tencent.mm.aj.f;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.l.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.storage.bi;

final class PluginBigBallOfMud$12
  implements a
{
  PluginBigBallOfMud$12(PluginBigBallOfMud paramPluginBigBallOfMud) {}
  
  public final String F(String paramString, int paramInt)
  {
    AppMethodBeat.i(18289);
    if (f.lg(paramString))
    {
      paramString = e.sr(((j)g.E(j.class)).bPQ().kB(paramInt).dns);
      AppMethodBeat.o(18289);
      return paramString;
    }
    paramString = bh.aaR();
    AppMethodBeat.o(18289);
    return paramString;
  }
  
  public final void g(bi parambi)
  {
    AppMethodBeat.i(18288);
    if (f.lg(parambi.field_talker))
    {
      parambi.jl(e.aaQ());
      AppMethodBeat.o(18288);
      return;
    }
    parambi.jl(bh.aaR());
    AppMethodBeat.o(18288);
  }
  
  public final String h(bi parambi)
  {
    AppMethodBeat.i(18290);
    if (f.lg(parambi.field_talker))
    {
      parambi = e.sr(parambi.dns);
      AppMethodBeat.o(18290);
      return parambi;
    }
    parambi = bh.aaR();
    AppMethodBeat.o(18290);
    return parambi;
  }
  
  public final boolean lg(String paramString)
  {
    AppMethodBeat.i(18291);
    boolean bool = f.lg(paramString);
    AppMethodBeat.o(18291);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.PluginBigBallOfMud.12
 * JD-Core Version:    0.7.0.1
 */