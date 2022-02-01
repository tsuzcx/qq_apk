package com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base;

import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bna;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/convertdata/base/LiveConvertData;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLive;", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/convertdata/base/ConvertDataCollector;", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "container", "Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamContainer;", "extDesc", "", "extCover", "skipAsyncLoadLiveInfo", "", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamContainer;Ljava/lang/String;Ljava/lang/String;Z)V", "getContainer", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamContainer;", "getExtCover", "()Ljava/lang/String;", "getExtDesc", "getSkipAsyncLoadLiveInfo", "()Z", "collectObjectId", "", "", "getContainerId", "", "getContainerLastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getItemType", "overrideGetItemTypePlease", "setContainerLastBuffer", "", "bf", "setContinueFlag", "value", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b
  extends x
  implements a
{
  public final bna ENs;
  public final boolean ENt;
  public final String ENy;
  public final String ENz;
  
  public b(FinderItem paramFinderItem, bna parambna, String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramFinderItem);
    this.ENs = parambna;
    this.ENy = paramString1;
    this.ENz = paramString2;
    this.ENt = paramBoolean;
  }
  
  public final void QQ(int paramInt)
  {
    this.ENs.BeA = paramInt;
  }
  
  public final int bZB()
  {
    return eFQ();
  }
  
  public abstract int eFQ();
  
  public final List<Long> eFR()
  {
    return p.mutableListOf(new Long[] { Long.valueOf(this.feedObject.getFeedObject().id) });
  }
  
  public final int eFS()
  {
    return this.ENs.Zpm;
  }
  
  public final com.tencent.mm.bx.b eFT()
  {
    return this.ENs.Zpn;
  }
  
  public final void f(com.tencent.mm.bx.b paramb)
  {
    this.ENs.Zpn = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.b
 * JD-Core Version:    0.7.0.1
 */