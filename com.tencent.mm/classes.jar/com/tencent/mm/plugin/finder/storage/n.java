package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.amd;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/FinderMixItem;", "", "viewItemPb", "Lcom/tencent/mm/protocal/protobuf/FinderMixItemPb;", "(Lcom/tencent/mm/protocal/protobuf/FinderMixItemPb;)V", "feedItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeedItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeedItem", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "lbsItem", "Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "getLbsItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "setLbsItem", "(Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;)V", "localItem", "Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;", "getLocalItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;", "setLocalItem", "(Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;)V", "viewId", "", "getViewId", "()J", "setViewId", "(J)V", "getViewItemPb", "()Lcom/tencent/mm/protocal/protobuf/FinderMixItemPb;", "viewType", "", "getViewType", "()I", "setViewType", "(I)V", "isSame", "", "otherItem", "Companion", "plugin-finder_release"})
public final class n
{
  public static final int rEk = 1;
  public static final int rEl = 2;
  public static final int rEm = 3;
  public static final n.a rEn;
  public int oeH;
  public j rEf;
  public FinderItem rEg;
  public o rEh;
  public long rEi;
  public final amd rEj;
  
  static
  {
    AppMethodBeat.i(202986);
    rEn = new n.a((byte)0);
    rEk = 1;
    rEl = 2;
    rEm = 3;
    AppMethodBeat.o(202986);
  }
  
  public n(amd paramamd)
  {
    AppMethodBeat.i(202985);
    this.rEj = paramamd;
    AppMethodBeat.o(202985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.n
 * JD-Core Version:    0.7.0.1
 */