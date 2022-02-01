package com.tencent.mm.plugin.forcenotify.b;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.forcenotify.a.f;
import com.tencent.mm.plugin.forcenotify.c.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/forcenotify/convert/ForceNotifyCommonConvert;", "Lcom/tencent/mm/plugin/forcenotify/convert/BaseMsgCardConvert;", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyCommonItem;", "()V", "getContentLayoutId", "", "onBindContentViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateContentViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends a<f>
{
  public final void a(RecyclerView paramRecyclerView, j paramj)
  {
    AppMethodBeat.i(274828);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(274828);
  }
  
  public final int dTn()
  {
    return a.f.force_notify_content_item_live;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.b.c
 * JD-Core Version:    0.7.0.1
 */