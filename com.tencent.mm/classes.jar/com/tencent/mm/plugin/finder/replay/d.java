package com.tencent.mm.plugin.finder.replay;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.viewmodel.data.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayAdapter$FinderLiveViewHolder;", "()V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "delete", "", "pos", "", "notify", "", "getData", "getItemCount", "onBindViewHolder", "vh", "onCreateViewHolder", "vg", "Landroid/view/ViewGroup;", "type", "onViewDetachedFromWindow", "holder", "protectViewItemRecycleHealthy", "view", "Landroid/view/View;", "registerDataList", "list", "FinderLiveViewHolder", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends RecyclerView.a<a>
{
  ArrayList<f> pUj;
  
  private final void fM(View paramView)
  {
    AppMethodBeat.i(332667);
    int i;
    int k;
    if ((paramView instanceof ViewGroup))
    {
      i = 0;
      k = ((ViewGroup)paramView).getChildCount();
      if (k <= 0) {}
    }
    for (;;)
    {
      int j = i + 1;
      View localView = ((ViewGroup)paramView).getChildAt(i);
      if (localView != null)
      {
        localView.animate().cancel();
        if (localView.hasTransientState()) {
          Log.i("FinderLiveReplayViewCallback", s.X("[protectViewItemRecycleHealthy] child=", localView));
        }
        fM(localView);
      }
      if (j >= k)
      {
        paramView.animate().cancel();
        AppMethodBeat.o(332667);
        return;
      }
      i = j;
    }
  }
  
  public final void RK(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(332685);
    int i = j;
    if (paramInt >= 0)
    {
      i = j;
      if (paramInt < getItemCount()) {
        i = 1;
      }
    }
    if (i != 0)
    {
      ArrayList localArrayList = this.pUj;
      if (localArrayList != null) {
        localArrayList.remove(paramInt);
      }
      fX(paramInt);
    }
    AppMethodBeat.o(332685);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(332676);
    ArrayList localArrayList = this.pUj;
    if (localArrayList == null)
    {
      AppMethodBeat.o(332676);
      return 0;
    }
    int i = localArrayList.size();
    AppMethodBeat.o(332676);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayAdapter$FinderLiveViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayAdapter;Landroid/view/View;)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends RecyclerView.v
  {
    public a()
    {
      super();
      AppMethodBeat.i(332549);
      AppMethodBeat.o(332549);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.d
 * JD-Core Version:    0.7.0.1
 */