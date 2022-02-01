package com.tencent.mm.plugin.finder.search;

import android.content.Intent;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.presenter.base.a;
import com.tencent.mm.protocal.protobuf.bip;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$ViewCallback;", "addExposeItem", "", "id", "", "position", "", "type", "", "getContactList", "", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "getFeedList", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getQuery", "getSafetyHint", "jumpToLive", "feed", "intent", "Landroid/content/Intent;", "onContactItemClick", "finderSearchInfo", "onContactMoreClick", "onFeedItemClick", "finderFeedObj", "onLoadMoreData", "", "startSearchQuery", "query", "fromType", "isFromHot", "sessionBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "scene", "plugin-finder_release"})
public abstract interface f$a
  extends a<f.b>
{
  public abstract void a(BaseFinderFeed paramBaseFinderFeed, Intent paramIntent);
  
  public abstract void a(bip parambip, int paramInt);
  
  public abstract void ah(String paramString, int paramInt1, int paramInt2);
  
  public abstract List<bip> dQN();
  
  public abstract String dQO();
  
  public abstract void dQP();
  
  public abstract boolean dQQ();
  
  public abstract List<BaseFinderFeed> dor();
  
  public abstract String getQuery();
  
  public abstract void k(long paramLong, int paramInt1, int paramInt2);
  
  public abstract void s(BaseFinderFeed paramBaseFinderFeed);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.f.a
 * JD-Core Version:    0.7.0.1
 */