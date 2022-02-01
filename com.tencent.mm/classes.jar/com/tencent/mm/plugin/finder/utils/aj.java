package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.coc;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"toFinder", "Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoExtendedReading;", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoLocation;", "toMega", "plugin-finder_release"})
public final class aj
{
  public static final coc a(axt paramaxt)
  {
    AppMethodBeat.i(253798);
    p.h(paramaxt, "$this$toMega");
    coc localcoc = new coc();
    localcoc.dTj = paramaxt.dTj;
    localcoc.latitude = paramaxt.latitude;
    localcoc.fuK = paramaxt.fuK;
    localcoc.kHV = paramaxt.kHV;
    localcoc.ErZ = paramaxt.ErZ;
    localcoc.LIb = paramaxt.LIb;
    localcoc.Esb = paramaxt.Esb;
    localcoc.fuJ = paramaxt.fuJ;
    localcoc.jlI = paramaxt.jlI;
    localcoc.country = paramaxt.country;
    AppMethodBeat.o(253798);
    return localcoc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.aj
 * JD-Core Version:    0.7.0.1
 */