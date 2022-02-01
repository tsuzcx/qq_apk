package com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.bna;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/convertdata/BannerLivingOfLiveConvertData;", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/convertdata/base/LiveConvertData;", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "container", "Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamContainer;", "skipAsyncLoadLiveInfo", "", "extDesc", "", "extCover", "dataItemType", "", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamContainer;ZLjava/lang/String;Ljava/lang/String;I)V", "getDataItemType", "()I", "overrideGetItemTypePlease", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends b
{
  private final int akhN;
  
  public c(FinderItem paramFinderItem, bna parambna, boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    super(paramFinderItem, parambna, paramString1, paramString2, paramBoolean);
    AppMethodBeat.i(370492);
    this.akhN = paramInt;
    AppMethodBeat.o(370492);
  }
  
  public final int eFQ()
  {
    return this.akhN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.c
 * JD-Core Version:    0.7.0.1
 */