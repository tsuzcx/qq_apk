package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aqn;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"print", "", "Lcom/tencent/mm/protocal/protobuf/FinderCheckExpireInfo;", "plugin-finder_release"})
public final class cn
{
  public static final String a(aqn paramaqn)
  {
    AppMethodBeat.i(270166);
    p.k(paramaqn, "$this$print");
    paramaqn = "check_expire_interval_sec=" + paramaqn.SDL + ", check_expire_max_count=" + paramaqn.SDM + ", check_expire_valid=" + paramaqn.SDK;
    AppMethodBeat.o(270166);
    return paramaqn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cn
 * JD-Core Version:    0.7.0.1
 */