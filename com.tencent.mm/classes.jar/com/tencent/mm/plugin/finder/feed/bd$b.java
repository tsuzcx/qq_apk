package com.tencent.mm.plugin.finder.feed;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.presenter.base.b;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallBackTagWrapper;", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getWxRecyclerAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "initView", "", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface bd$b
  extends b, c<bd.a>
{
  public abstract RefreshLoadMoreLayout aNL();
  
  public abstract void ae(ArrayList<cc> paramArrayList);
  
  public abstract WxRecyclerAdapter<cc> ecF();
  
  public abstract RecyclerView getRecyclerView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.bd.b
 * JD-Core Version:    0.7.0.1
 */