package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dzj;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/FinderMixItem;", "", "viewItemPb", "Lcom/tencent/mm/protocal/protobuf/FinderMixItemPb;", "(Lcom/tencent/mm/protocal/protobuf/FinderMixItemPb;)V", "feedItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeedItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeedItem", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "lbsItem", "Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "getLbsItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "setLbsItem", "(Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;)V", "localItem", "Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;", "getLocalItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;", "setLocalItem", "(Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;)V", "viewId", "", "getViewId", "()J", "setViewId", "(J)V", "getViewItemPb", "()Lcom/tencent/mm/protocal/protobuf/FinderMixItemPb;", "viewType", "", "getViewType", "()I", "setViewType", "(I)V", "isSame", "", "otherItem", "Companion", "plugin-finder_release"})
public final class r
{
  public static final int KXf = 1;
  public static final int KXg = 2;
  public static final int KXh = 3;
  public static final a KXi;
  public p KXb;
  public FinderItem KXc;
  public s KXd;
  public final dzj KXe;
  public int nBH;
  public long trO;
  
  static
  {
    AppMethodBeat.i(199022);
    KXi = new a((byte)0);
    KXf = 1;
    KXg = 2;
    KXh = 3;
    AppMethodBeat.o(199022);
  }
  
  public r(dzj paramdzj)
  {
    AppMethodBeat.i(199021);
    this.KXe = paramdzj;
    AppMethodBeat.o(199021);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/FinderMixItem$Companion;", "", "()V", "VIEW_ITEM_FEED", "", "getVIEW_ITEM_FEED", "()I", "VIEW_ITEM_LBS", "getVIEW_ITEM_LBS", "VIEW_ITEM_LOCAL", "getVIEW_ITEM_LOCAL", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.r
 * JD-Core Version:    0.7.0.1
 */