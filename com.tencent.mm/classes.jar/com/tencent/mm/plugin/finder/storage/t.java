package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.apw;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/FinderMixItem;", "", "viewItemPb", "Lcom/tencent/mm/protocal/protobuf/FinderMixItemPb;", "(Lcom/tencent/mm/protocal/protobuf/FinderMixItemPb;)V", "feedItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeedItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeedItem", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "lbsItem", "Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "getLbsItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "setLbsItem", "(Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;)V", "localItem", "Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;", "getLocalItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;", "setLocalItem", "(Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;)V", "viewId", "", "getViewId", "()J", "setViewId", "(J)V", "getViewItemPb", "()Lcom/tencent/mm/protocal/protobuf/FinderMixItemPb;", "viewType", "", "getViewType", "()I", "setViewType", "(I)V", "isSame", "", "otherItem", "Companion", "plugin-finder_release"})
public final class t
{
  public static final int sJO = 1;
  public static final int sJP = 2;
  public static final int sJQ = 3;
  public static final a sJR;
  public int oOD;
  public m sJK;
  public FinderItem sJL;
  public long sJM;
  public final apw sJN;
  public u ssM;
  
  static
  {
    AppMethodBeat.i(204286);
    sJR = new a((byte)0);
    sJO = 1;
    sJP = 2;
    sJQ = 3;
    AppMethodBeat.o(204286);
  }
  
  public t(apw paramapw)
  {
    AppMethodBeat.i(204285);
    this.sJN = paramapw;
    AppMethodBeat.o(204285);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/FinderMixItem$Companion;", "", "()V", "VIEW_ITEM_FEED", "", "getVIEW_ITEM_FEED", "()I", "VIEW_ITEM_LBS", "getVIEW_ITEM_LBS", "VIEW_ITEM_LOCAL", "getVIEW_ITEM_LOCAL", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.t
 * JD-Core Version:    0.7.0.1
 */