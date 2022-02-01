package com.tencent.mm.plugin.finder.feed;

import android.support.v7.widget.RecyclerView;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.presenter.base.b;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.l;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallBackTagWrapper;", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getWxRecyclerAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "initView", "", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "plugin-finder_release"})
public abstract interface ak$b
  extends b, c<ak.a>
{
  public abstract void U(ArrayList<al> paramArrayList);
  
  public abstract RefreshLoadMoreLayout cBD();
  
  public abstract WxRecyclerAdapter<al> cBG();
  
  public abstract RecyclerView getRecyclerView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ak.b
 * JD-Core Version:    0.7.0.1
 */