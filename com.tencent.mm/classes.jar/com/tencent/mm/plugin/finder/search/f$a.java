package com.tencent.mm.plugin.finder.search;

import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.presenter.base.a;
import com.tencent.mm.protocal.protobuf.aky;
import d.l;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$ViewCallback;", "addExposeItem", "", "id", "", "position", "", "type", "", "getContactList", "", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "getFeedList", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "onContactItemClick", "finderSearchInfo", "onContactMoreClick", "onFeedItemClick", "finderFeedObj", "onLoadMoreData", "", "startSearchQuery", "query", "plugin-finder_release"})
public abstract interface f$a
  extends a<f.b>
{
  public abstract void G(long paramLong, int paramInt);
  
  public abstract void a(aky paramaky, int paramInt);
  
  public abstract void ab(String paramString, int paramInt1, int paramInt2);
  
  public abstract List<BaseFinderFeed> ckL();
  
  public abstract List<aky> com();
  
  public abstract void con();
  
  public abstract boolean coo();
  
  public abstract void j(BaseFinderFeed paramBaseFinderFeed);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.f.a
 * JD-Core Version:    0.7.0.1
 */