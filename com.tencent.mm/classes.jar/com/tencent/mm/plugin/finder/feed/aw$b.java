package com.tencent.mm.plugin.finder.feed;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "", "isHideLoading", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRootView", "Landroid/view/View;", "initView", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "tabType", "", "onBackPressed", "setOnItemClickListener", "listener", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "showEmptyView", "showProgress", "isShow", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface aw$b
  extends c<aw.a>
{
  public abstract RefreshLoadMoreLayout aNL();
  
  public abstract void c(long paramLong, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void f(ArrayList<cc> paramArrayList, int paramInt);
  
  public abstract RecyclerView getRecyclerView();
  
  public abstract View getRootView();
  
  public abstract boolean onBackPressed();
  
  public abstract void pZ(boolean paramBoolean);
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.aw.b
 * JD-Core Version:    0.7.0.1
 */