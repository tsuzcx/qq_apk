package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"print", "", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowEntranceExtInfo;", "plugin-finder_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final String a(FinderTipsShowEntranceExtInfo paramFinderTipsShowEntranceExtInfo)
  {
    AppMethodBeat.i(366751);
    s.u(paramFinderTipsShowEntranceExtInfo, "<this>");
    paramFinderTipsShowEntranceExtInfo = "extInfo{tab_type=" + paramFinderTipsShowEntranceExtInfo.tab_type + " object_id=" + paramFinderTipsShowEntranceExtInfo.object_id + '}';
    AppMethodBeat.o(366751);
    return paramFinderTipsShowEntranceExtInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.j
 * JD-Core Version:    0.7.0.1
 */