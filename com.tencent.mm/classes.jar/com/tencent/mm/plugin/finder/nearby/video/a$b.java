package com.tencent.mm.plugin.finder.nearby.video;

import android.support.v7.widget.RecyclerView;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.a;
import java.util.ArrayList;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoContract$ViewCallback;", "T", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoContract$Presenter;", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "initView", "", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "plugin-finder_release"})
public abstract interface a$b<T extends a>
  extends c<a.a<T>>
{
  public abstract void ab(ArrayList<T> paramArrayList);
  
  public abstract RefreshLoadMoreLayout dcQ();
  
  public abstract RecyclerView getRecyclerView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.video.a.b
 * JD-Core Version:    0.7.0.1
 */