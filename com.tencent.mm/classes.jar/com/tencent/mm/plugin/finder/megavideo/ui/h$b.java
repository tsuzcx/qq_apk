package com.tencent.mm.plugin.finder.megavideo.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.presenter.base.c;
import java.util.ArrayList;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$Presenter;", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRootView", "Landroid/view/View;", "getViewActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "initView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "onBackPressed", "", "setOnItemClickListener", "listener", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
public abstract interface h$b
  extends c<h.a>
{
  public abstract void ab(ArrayList<bo> paramArrayList);
  
  public abstract RecyclerView getRecyclerView();
  
  public abstract View getRootView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.h.b
 * JD-Core Version:    0.7.0.1
 */