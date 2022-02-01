package com.tencent.mm.plugin.finder.feed;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.l;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRootView", "Landroid/view/View;", "getTouchPhotoLayout", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "initView", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "tabType", "", "onBackPressed", "setOnItemClickListener", "listener", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "showEmptyView", "plugin-finder_release"})
public abstract interface ac$b
  extends c<ac.a>
{
  public abstract void c(ArrayList<al> paramArrayList, int paramInt);
  
  public abstract TouchMediaPreviewLayout cBB();
  
  public abstract void cBC();
  
  public abstract RefreshLoadMoreLayout cBD();
  
  public abstract RecyclerView getRecyclerView();
  
  public abstract View getRootView();
  
  public abstract boolean onBackPressed();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ac.b
 * JD-Core Version:    0.7.0.1
 */