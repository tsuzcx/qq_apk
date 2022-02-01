package com.tencent.mm.plugin.finder.feed;

import android.support.v7.widget.RecyclerView;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.presenter.base.b;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.l;
import java.util.ArrayList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallBackTagWrapper;", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getWxRecyclerAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "initView", "", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "plugin-finder_release"})
public abstract interface ad$b
  extends b, c<ad.a>
{
  public abstract void U(ArrayList<BaseFinderFeed> paramArrayList);
  
  public abstract RefreshLoadMoreLayout cvl();
  
  public abstract WxRecyclerAdapter<BaseFinderFeed> cvo();
  
  public abstract RecyclerView getRecyclerView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ad.b
 * JD-Core Version:    0.7.0.1
 */