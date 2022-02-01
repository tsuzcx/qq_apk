package com.tencent.mm.plugin.finder.nearby.live;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.a;
import java.util.ArrayList;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$ViewCallback;", "T", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$Presenter;", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRootScrollParent", "Landroid/view/View;", "initView", "", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "plugin-finder_release"})
public abstract interface b$b<T extends a>
  extends c<b.a<T>>
{
  public abstract void ab(ArrayList<T> paramArrayList);
  
  public abstract RefreshLoadMoreLayout dcQ();
  
  public abstract View dlo();
  
  public abstract RecyclerView getRecyclerView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.b.b
 * JD-Core Version:    0.7.0.1
 */