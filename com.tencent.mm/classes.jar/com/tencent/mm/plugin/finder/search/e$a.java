package com.tencent.mm.plugin.finder.search;

import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.presenter.base.a;
import com.tencent.mm.protocal.protobuf.anr;
import d.l;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$ViewCallback;", "addExposeItem", "", "id", "", "position", "", "type", "", "getContactList", "", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "getFeedList", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "onContactItemClick", "finderSearchInfo", "onContactMoreClick", "onFeedItemClick", "finderFeedObj", "onLoadMoreData", "", "startSearchQuery", "query", "plugin-finder_release"})
public abstract interface e$a
  extends a<e.b>
{
  public abstract void J(long paramLong, int paramInt);
  
  public abstract void Z(String paramString, int paramInt1, int paramInt2);
  
  public abstract void a(anr paramanr, int paramInt);
  
  public abstract List<BaseFinderFeed> csC();
  
  public abstract List<anr> cxJ();
  
  public abstract void cxK();
  
  public abstract boolean cxL();
  
  public abstract void k(BaseFinderFeed paramBaseFinderFeed);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.e.a
 * JD-Core Version:    0.7.0.1
 */