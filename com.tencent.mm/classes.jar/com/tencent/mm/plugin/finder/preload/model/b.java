package com.tencent.mm.plugin.finder.preload.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.alw;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"print", "", "Lcom/tencent/mm/protocal/protobuf/FinderMediaSpec;", "plugin-finder_release"})
public final class b
{
  public static final String a(alw paramalw)
  {
    AppMethodBeat.i(202634);
    k.h(paramalw, "$this$print");
    paramalw = "Spec[" + paramalw.rvP + ' ' + paramalw.drn + ' ' + bs.qz(paramalw.EFo) + ' ' + bs.qz(paramalw.EFp) + ']';
    AppMethodBeat.o(202634);
    return paramalw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.model.b
 * JD-Core Version:    0.7.0.1
 */