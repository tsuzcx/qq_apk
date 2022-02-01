package com.tencent.mm.plugin.finder.preload.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.beb;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"print", "", "Lcom/tencent/mm/protocal/protobuf/FinderMediaSpec;", "plugin-finder_release"})
public final class b
{
  public static final String a(beb parambeb)
  {
    AppMethodBeat.i(264311);
    p.k(parambeb, "$this$print");
    parambeb = "Spec[" + parambeb.zKY + ' ' + parambeb.fPD + ' ' + Util.getSizeKB(parambeb.SIw) + ' ' + parambeb.SKL + ']';
    AppMethodBeat.o(264311);
    return parambeb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.model.b
 * JD-Core Version:    0.7.0.1
 */