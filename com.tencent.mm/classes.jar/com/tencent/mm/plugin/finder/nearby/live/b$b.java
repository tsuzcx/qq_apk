package com.tencent.mm.plugin.finder.nearby.live;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.view.k;
import com.tencent.mm.view.recyclerview.a;
import com.tencent.mm.view.refreshLayout.WxRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$ViewCallback;", "T", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$Presenter;", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/refreshLayout/WxRefreshLayout;", "getRootScrollParent", "Landroid/view/View;", "getSubTabContainer", "getViewCallBack", "Lcom/tencent/mm/view/IViewActionCallback;", "initSubTabPosition", "", "index", "", "initView", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "refreshSubTabByCache", "cacheData", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface b$b<T extends a>
  extends c<b.a<T>>
{
  public abstract void QB(int paramInt);
  
  public abstract void ae(ArrayList<T> paramArrayList);
  
  public abstract RecyclerView eEA();
  
  public abstract WxRefreshLayout eEy();
  
  public abstract k eEz();
  
  public abstract RecyclerView getRecyclerView();
  
  public abstract void pq(List<? extends cc> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.b.b
 * JD-Core Version:    0.7.0.1
 */