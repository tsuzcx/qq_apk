package com.tencent.mm.plugin.finder.search;

import android.content.Intent;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.presenter.base.a;
import com.tencent.mm.protocal.protobuf.buy;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$ViewCallback;", "addExposeItem", "", "id", "", "position", "", "type", "", "getContactList", "", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "getFeedList", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getQuery", "getSafetyHint", "jumpToLive", "feed", "intent", "Landroid/content/Intent;", "onContactItemClick", "finderSearchInfo", "onContactMoreClick", "onFeedItemClick", "finderFeedObj", "onLoadMoreData", "", "startSearchQuery", "query", "fromType", "isFromHot", "sessionBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "scene", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface g$a
  extends a<g.b>
{
  public abstract void a(BaseFinderFeed paramBaseFinderFeed, Intent paramIntent);
  
  public abstract void a(buy parambuy, int paramInt);
  
  public abstract void am(String paramString, int paramInt1, int paramInt2);
  
  public abstract List<BaseFinderFeed> dWd();
  
  public abstract List<buy> eOH();
  
  public abstract String eOI();
  
  public abstract void eOJ();
  
  public abstract boolean eOK();
  
  public abstract String getQuery();
  
  public abstract void k(BaseFinderFeed paramBaseFinderFeed);
  
  public abstract void s(long paramLong, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.g.a
 * JD-Core Version:    0.7.0.1
 */