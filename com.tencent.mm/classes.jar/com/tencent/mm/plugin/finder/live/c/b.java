package com.tencent.mm.plugin.finder.live.c;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.view.recyclerview.a;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/convert/EmptyConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends f<a>
{
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(371017);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(371017);
  }
  
  public final void a(j paramj, a parama, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(371021);
    s.u(paramj, "holder");
    s.u(parama, "item");
    AppMethodBeat.o(371021);
  }
  
  public final int getLayoutId()
  {
    return p.f.WNm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.c.b
 * JD-Core Version:    0.7.0.1
 */