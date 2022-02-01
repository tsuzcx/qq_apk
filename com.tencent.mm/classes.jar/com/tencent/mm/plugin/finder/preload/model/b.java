package com.tencent.mm.plugin.finder.preload.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ayh;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"print", "", "Lcom/tencent/mm/protocal/protobuf/FinderMediaSpec;", "plugin-finder_release"})
public final class b
{
  public static final String a(ayh paramayh)
  {
    AppMethodBeat.i(249550);
    p.h(paramayh, "$this$print");
    paramayh = "Spec[" + paramayh.uUI + ' ' + paramayh.dVY + ' ' + Util.getSizeKB(paramayh.LEL) + ' ' + paramayh.LGa + ']';
    AppMethodBeat.o(249550);
    return paramayh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.model.b
 * JD-Core Version:    0.7.0.1
 */