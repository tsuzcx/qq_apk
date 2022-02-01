package com.tencent.mm.audio.mix.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  public static k a(com.tencent.mm.audio.mix.f.d paramd, com.tencent.mm.audio.mix.g.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(136821);
    if (paramb.PA().ddd) {}
    for (paramd = new d(paramd, paramb);; paramd = new e(paramd, paramb))
    {
      paramd.init();
      if (paramBoolean) {
        paramd.OC();
      }
      AppMethodBeat.o(136821);
      return paramd;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.f
 * JD-Core Version:    0.7.0.1
 */