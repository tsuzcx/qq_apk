package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.apb;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"print", "", "Lcom/tencent/mm/protocal/protobuf/FinderCheckExpireInfo;", "plugin-finder_release"})
public final class cj
{
  public static final String a(apb paramapb)
  {
    AppMethodBeat.i(242514);
    p.h(paramapb, "$this$print");
    paramapb = "check_expire_interval_sec=" + paramapb.LBc + ", check_expire_max_count=" + paramapb.LBd + ", check_expire_valid=" + paramapb.LBb;
    AppMethodBeat.o(242514);
    return paramapb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cj
 * JD-Core Version:    0.7.0.1
 */