package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.backup.i.x;

final class c$1
  implements f
{
  c$1(c paramc, c.b paramb) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(17641);
    paramString = (c)paramm;
    this.jFt.g(c.a.a(c.b(paramString), paramString), paramString.jFp.jKw, paramString.aUC());
    AppMethodBeat.o(17641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.c.1
 * JD-Core Version:    0.7.0.1
 */