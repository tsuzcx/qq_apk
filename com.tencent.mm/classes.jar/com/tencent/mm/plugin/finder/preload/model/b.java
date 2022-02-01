package com.tencent.mm.plugin.finder.preload.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.app;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"print", "", "Lcom/tencent/mm/protocal/protobuf/FinderMediaSpec;", "plugin-finder_release"})
public final class b
{
  public static final String a(app paramapp)
  {
    AppMethodBeat.i(203540);
    p.h(paramapp, "$this$print");
    paramapp = "Spec[" + paramapp.suu + ' ' + paramapp.dEk + ' ' + bu.sL(paramapp.GGI) + ' ' + paramapp.GGJ + ']';
    AppMethodBeat.o(203540);
    return paramapp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.model.b
 * JD-Core Version:    0.7.0.1
 */