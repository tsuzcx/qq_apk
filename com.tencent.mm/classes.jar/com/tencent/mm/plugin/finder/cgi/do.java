package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aun;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"print", "", "Lcom/tencent/mm/protocal/protobuf/FinderCheckExpireInfo;", "plugin-finder_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class do
{
  public static final String a(aun paramaun)
  {
    AppMethodBeat.i(336874);
    s.u(paramaun, "<this>");
    paramaun = "check_expire_interval_sec=" + paramaun.ZET + ", check_expire_max_count=" + paramaun.ZEU + ", check_expire_valid=" + paramaun.ZES;
    AppMethodBeat.o(336874);
    return paramaun;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.do
 * JD-Core Version:    0.7.0.1
 */