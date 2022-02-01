package com.tencent.mm.audio.mix.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.audio.mix.h.c;

public final class f
{
  public static l a(com.tencent.mm.audio.mix.g.d paramd, c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(136821);
    if (paramc.ZU().dtU) {}
    for (paramd = new d(paramd, paramc);; paramd = new e(paramd, paramc))
    {
      paramd.init();
      if (paramBoolean) {
        paramd.YU();
      }
      AppMethodBeat.o(136821);
      return paramd;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.f
 * JD-Core Version:    0.7.0.1
 */