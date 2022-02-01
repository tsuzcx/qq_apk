package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.profile.g;
import com.tencent.mm.protocal.protobuf.bpm;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderMixItem;", "", "viewItemPb", "Lcom/tencent/mm/protocal/protobuf/FinderMixItemPb;", "(Lcom/tencent/mm/protocal/protobuf/FinderMixItemPb;)V", "feedItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeedItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeedItem", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "lbsItem", "Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "getLbsItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "setLbsItem", "(Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;)V", "localItem", "Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;", "getLocalItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;", "setLocalItem", "(Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;)V", "poiItem", "Lcom/tencent/mm/plugin/finder/profile/PoiItem;", "getPoiItem", "()Lcom/tencent/mm/plugin/finder/profile/PoiItem;", "setPoiItem", "(Lcom/tencent/mm/plugin/finder/profile/PoiItem;)V", "viewId", "", "getViewId", "()J", "setViewId", "(J)V", "getViewItemPb", "()Lcom/tencent/mm/protocal/protobuf/FinderMixItemPb;", "viewType", "", "getViewType", "()I", "setViewType", "(I)V", "isSame", "", "otherItem", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class y
{
  public static final a FLJ;
  public static final int FLP;
  public static final int FLQ;
  public static final int FLR;
  public static final int FLS;
  public z ECc;
  public final bpm FLK;
  public q FLL;
  public FinderItem FLM;
  public g FLN;
  public long FLO;
  public int viewType;
  
  static
  {
    AppMethodBeat.i(339397);
    FLJ = new a((byte)0);
    FLP = 1;
    FLQ = 2;
    FLR = 3;
    FLS = 4;
    AppMethodBeat.o(339397);
  }
  
  public y(bpm parambpm)
  {
    AppMethodBeat.i(339378);
    this.FLK = parambpm;
    AppMethodBeat.o(339378);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderMixItem$Companion;", "", "()V", "VIEW_ITEM_FEED", "", "getVIEW_ITEM_FEED", "()I", "VIEW_ITEM_LBS", "getVIEW_ITEM_LBS", "VIEW_ITEM_LOCAL", "getVIEW_ITEM_LOCAL", "VIEW_ITEM_POI", "getVIEW_ITEM_POI", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.y
 * JD-Core Version:    0.7.0.1
 */