package com.tencent.mm.audio.mix.decode;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.audio.mix.g.c;

public final class f
{
  public static l a(com.tencent.mm.audio.mix.f.d paramd, c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(136821);
    if (paramc.aGB().hqN) {}
    for (paramd = new d(paramd, paramc);; paramd = new e(paramd, paramc))
    {
      paramd.init();
      if (paramBoolean) {
        paramd.aFB();
      }
      AppMethodBeat.o(136821);
      return paramd;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.decode.f
 * JD-Core Version:    0.7.0.1
 */