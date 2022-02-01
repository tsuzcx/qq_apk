package com.tencent.mm.plugin.finder.nearby.video;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.a;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoContract$ViewCallback;", "T", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoContract$Presenter;", "getClickPosition", "", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "initView", "", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a$b<T extends a>
  extends c<a.a<T>>
{
  public abstract RefreshLoadMoreLayout aNL();
  
  public abstract void ae(ArrayList<T> paramArrayList);
  
  public abstract RecyclerView getRecyclerView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.video.a.b
 * JD-Core Version:    0.7.0.1
 */