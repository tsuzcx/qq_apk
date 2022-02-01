package com.tencent.mm.plugin.finder.preload.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.apc;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"print", "", "Lcom/tencent/mm/protocal/protobuf/FinderMediaSpec;", "plugin-finder_release"})
public final class b
{
  public static final String a(apc paramapc)
  {
    AppMethodBeat.i(203055);
    p.h(paramapc, "$this$print");
    paramapc = "Spec[" + paramapc.slv + ' ' + paramapc.dDf + ' ' + bt.sy(paramapc.GnC) + ' ' + bt.sy(paramapc.GnD) + ']';
    AppMethodBeat.o(203055);
    return paramapc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.model.b
 * JD-Core Version:    0.7.0.1
 */