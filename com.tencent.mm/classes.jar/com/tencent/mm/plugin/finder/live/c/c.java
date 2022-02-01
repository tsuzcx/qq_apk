package com.tencent.mm.plugin.finder.live.c;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.view.recyclerview.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/convert/LocationCommentConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/LocationBoxMsg;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getLayoutId", "", "goToPoiFeedUI", "", "context", "Landroid/content/Context;", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "setCitySpan", "finallyUserMessage", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpannableString;", "setPoiIconSpan", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends f<com.tencent.mm.plugin.finder.live.viewmodel.data.a.j>
{
  private final String TAG = "LocationCommentConvert";
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.j paramj, int paramInt)
  {
    AppMethodBeat.i(371033);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(371033);
  }
  
  public final int getLayoutId()
  {
    return p.f.VIy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.c.c
 * JD-Core Version:    0.7.0.1
 */