package com.tencent.mm.plugin.finder.megavideo.ui;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.view.k;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$Presenter;", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRootView", "Landroid/view/View;", "getViewActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "initView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "onBackPressed", "", "setOnItemClickListener", "listener", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface h$b
  extends c<h.a>
{
  public abstract void ae(ArrayList<cc> paramArrayList);
  
  public abstract k ecd();
  
  public abstract RecyclerView getRecyclerView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.h.b
 * JD-Core Version:    0.7.0.1
 */