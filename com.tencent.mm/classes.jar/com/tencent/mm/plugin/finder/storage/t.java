package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.apj;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/FinderMixItem;", "", "viewItemPb", "Lcom/tencent/mm/protocal/protobuf/FinderMixItemPb;", "(Lcom/tencent/mm/protocal/protobuf/FinderMixItemPb;)V", "feedItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeedItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeedItem", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "lbsItem", "Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "getLbsItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "setLbsItem", "(Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;)V", "localItem", "Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;", "getLocalItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;", "setLocalItem", "(Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;)V", "viewId", "", "getViewId", "()J", "setViewId", "(J)V", "getViewItemPb", "()Lcom/tencent/mm/protocal/protobuf/FinderMixItemPb;", "viewType", "", "getViewType", "()I", "setViewType", "(I)V", "isSame", "", "otherItem", "Companion", "plugin-finder_release"})
public final class t
{
  public static final int syX = 1;
  public static final int syY = 2;
  public static final int syZ = 3;
  public static final a sza;
  public int oIb;
  public u sjP;
  public m syT;
  public FinderItem syU;
  public long syV;
  public final apj syW;
  
  static
  {
    AppMethodBeat.i(203718);
    sza = new a((byte)0);
    syX = 1;
    syY = 2;
    syZ = 3;
    AppMethodBeat.o(203718);
  }
  
  public t(apj paramapj)
  {
    AppMethodBeat.i(203717);
    this.syW = paramapj;
    AppMethodBeat.o(203717);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/FinderMixItem$Companion;", "", "()V", "VIEW_ITEM_FEED", "", "getVIEW_ITEM_FEED", "()I", "VIEW_ITEM_LBS", "getVIEW_ITEM_LBS", "VIEW_ITEM_LOCAL", "getVIEW_ITEM_LOCAL", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.t
 * JD-Core Version:    0.7.0.1
 */