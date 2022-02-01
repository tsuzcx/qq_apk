package com.tencent.mm.plugin.finder.live.olympic;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.olympic.data.b;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicRunnerHeaderConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/live/olympic/data/RunnerPannelFeed;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends com.tencent.mm.view.recyclerview.f<b>
{
  private final String TAG = "FinderLiveOlympicRunnerHeaderConvert";
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(360499);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(360499);
  }
  
  public final int getLayoutId()
  {
    return p.f.CeQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.f
 * JD-Core Version:    0.7.0.1
 */