package com.tencent.mm.plugin.finder.feed;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRootView", "Landroid/view/View;", "initView", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "tabType", "", "onBackPressed", "setOnItemClickListener", "listener", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "showEmptyView", "plugin-finder_release"})
public abstract interface ai$b
  extends c<ai.a>
{
  public abstract void c(ArrayList<bo> paramArrayList, int paramInt);
  
  public abstract void dcP();
  
  public abstract RefreshLoadMoreLayout dcQ();
  
  public abstract RecyclerView getRecyclerView();
  
  public abstract View getRootView();
  
  public abstract boolean onBackPressed();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ai.b
 * JD-Core Version:    0.7.0.1
 */