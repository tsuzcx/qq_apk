package com.tencent.mm.plugin.finder.live.ui.at;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.ui.at.g;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/ui/at/FinderLiveAtSomeoneEmptyConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/ui/at/FinderAtSomeoneLiveItem;", "forceDarkMode", "", "(Ljava/lang/Boolean;)V", "getForceDarkMode", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends f<g>
{
  private final Boolean DHP;
  
  public d(Boolean paramBoolean)
  {
    this.DHP = paramBoolean;
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(352316);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(352316);
  }
  
  public final int getLayoutId()
  {
    return p.f.finder_live_at_someone_empty_item;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.ui.at.d
 * JD-Core Version:    0.7.0.1
 */