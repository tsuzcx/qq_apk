package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"print", "", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowEntranceExtInfo;", "plugin-finder_release"})
public final class g
{
  public static final String a(FinderTipsShowEntranceExtInfo paramFinderTipsShowEntranceExtInfo)
  {
    AppMethodBeat.i(288997);
    p.k(paramFinderTipsShowEntranceExtInfo, "$this$print");
    paramFinderTipsShowEntranceExtInfo = "extInfo{tab_type=" + paramFinderTipsShowEntranceExtInfo.tab_type + " object_id=" + paramFinderTipsShowEntranceExtInfo.object_id + '}';
    AppMethodBeat.o(288997);
    return paramFinderTipsShowEntranceExtInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.g
 * JD-Core Version:    0.7.0.1
 */