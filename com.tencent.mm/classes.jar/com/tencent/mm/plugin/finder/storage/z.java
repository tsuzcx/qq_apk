package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ayr;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderMixItem;", "", "viewItemPb", "Lcom/tencent/mm/protocal/protobuf/FinderMixItemPb;", "(Lcom/tencent/mm/protocal/protobuf/FinderMixItemPb;)V", "feedItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeedItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeedItem", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "lbsItem", "Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "getLbsItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "setLbsItem", "(Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;)V", "localItem", "Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;", "getLocalItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;", "setLocalItem", "(Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;)V", "viewId", "", "getViewId", "()J", "setViewId", "(J)V", "getViewItemPb", "()Lcom/tencent/mm/protocal/protobuf/FinderMixItemPb;", "viewType", "", "getViewType", "()I", "setViewType", "(I)V", "isSame", "", "otherItem", "Companion", "plugin-finder_release"})
public final class z
{
  public static final int vEJ = 1;
  public static final int vEK = 2;
  public static final int vEL = 3;
  public static final a vEM;
  public int qcr;
  public aa uNH;
  public o vEF;
  public FinderItem vEG;
  public long vEH;
  public final ayr vEI;
  
  static
  {
    AppMethodBeat.i(251813);
    vEM = new a((byte)0);
    vEJ = 1;
    vEK = 2;
    vEL = 3;
    AppMethodBeat.o(251813);
  }
  
  public z(ayr paramayr)
  {
    AppMethodBeat.i(251812);
    this.vEI = paramayr;
    AppMethodBeat.o(251812);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderMixItem$Companion;", "", "()V", "VIEW_ITEM_FEED", "", "getVIEW_ITEM_FEED", "()I", "VIEW_ITEM_LBS", "getVIEW_ITEM_LBS", "VIEW_ITEM_LOCAL", "getVIEW_ITEM_LOCAL", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.z
 * JD-Core Version:    0.7.0.1
 */