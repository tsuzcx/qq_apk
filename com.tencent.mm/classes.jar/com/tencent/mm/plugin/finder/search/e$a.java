package com.tencent.mm.plugin.finder.search;

import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.presenter.base.a;
import com.tencent.mm.protocal.protobuf.ard;
import d.l;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$ViewCallback;", "addExposeItem", "", "id", "", "position", "", "type", "", "getContactList", "", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "getFeedList", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "onContactItemClick", "finderSearchInfo", "onContactMoreClick", "onFeedItemClick", "finderFeedObj", "onLoadMoreData", "", "startSearchQuery", "query", "plugin-finder_release"})
public abstract interface e$a
  extends a<e.b>
{
  public abstract void L(long paramLong, int paramInt);
  
  public abstract void a(ard paramard, int paramInt);
  
  public abstract void ac(String paramString, int paramInt1, int paramInt2);
  
  public abstract List<ard> cEG();
  
  public abstract void cEH();
  
  public abstract boolean cEI();
  
  public abstract List<BaseFinderFeed> cyt();
  
  public abstract void m(BaseFinderFeed paramBaseFinderFeed);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.e.a
 * JD-Core Version:    0.7.0.1
 */