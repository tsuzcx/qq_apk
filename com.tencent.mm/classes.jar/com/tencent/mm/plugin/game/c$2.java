package com.tencent.mm.plugin.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.k;

final class c$2
  extends d
{
  c$2(c paramc) {}
  
  public final b PL(String paramString)
  {
    AppMethodBeat.i(111136);
    gz localgz = new gz();
    localgz.cvW.cnC = paramString;
    AppMethodBeat.o(111136);
    return localgz;
  }
  
  public final k bEO()
  {
    AppMethodBeat.i(111137);
    r localr = ((e)g.E(e.class)).bES();
    AppMethodBeat.o(111137);
    return localr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.c.2
 * JD-Core Version:    0.7.0.1
 */