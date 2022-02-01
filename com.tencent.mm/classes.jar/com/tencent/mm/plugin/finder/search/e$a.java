package com.tencent.mm.plugin.finder.search;

import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.presenter.base.a;
import com.tencent.mm.protocal.protobuf.bbz;
import java.util.List;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$ViewCallback;", "addExposeItem", "", "id", "", "position", "", "type", "", "getContactList", "", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "getFeedList", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "jumpToLive", "feed", "onContactItemClick", "finderSearchInfo", "onContactMoreClick", "onFeedItemClick", "finderFeedObj", "onLoadMoreData", "", "startSearchQuery", "query", "isFromHistory", "isFromHot", "sessionBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "plugin-finder_release"})
public abstract interface e$a
  extends a<e.b>
{
  public abstract void K(long paramLong, int paramInt);
  
  public abstract void a(bbz parambbz, int paramInt);
  
  public abstract void ae(String paramString, int paramInt1, int paramInt2);
  
  public abstract List<BaseFinderFeed> cYD();
  
  public abstract List<bbz> dpA();
  
  public abstract void dpB();
  
  public abstract boolean dpC();
  
  public abstract void q(BaseFinderFeed paramBaseFinderFeed);
  
  public abstract void r(BaseFinderFeed paramBaseFinderFeed);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.e.a
 * JD-Core Version:    0.7.0.1
 */