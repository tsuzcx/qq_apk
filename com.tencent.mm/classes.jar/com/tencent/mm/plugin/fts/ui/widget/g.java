package com.tencent.mm.plugin.fts.ui.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.fts.ui.p.e;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fts/ui/widget/KeyboardSugConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/fts/ui/widget/KeyboardSugItem;", "clickListener", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/OnItemClickListener;", "(Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/OnItemClickListener;)V", "getClickListener", "()Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/OnItemClickListener;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "ui-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends f<i>
{
  private final com.tencent.mm.plugin.appbrand.widget.recyclerview.b HDF;
  
  public g(com.tencent.mm.plugin.appbrand.widget.recyclerview.b paramb)
  {
    AppMethodBeat.i(265862);
    this.HDF = paramb;
    AppMethodBeat.o(265862);
  }
  
  private static final void a(g paramg, int paramInt, i parami, View paramView)
  {
    AppMethodBeat.i(265869);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramg);
    localb.sc(paramInt);
    localb.cH(parami);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/fts/ui/widget/KeyboardSugConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramg, "this$0");
    s.u(parami, "$item");
    paramg.HDF.onItemClick(paramView, paramInt, parami.id);
    a.a(new Object(), "com/tencent/mm/plugin/fts/ui/widget/KeyboardSugConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(265869);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(265883);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(265883);
  }
  
  public final int getLayoutId()
  {
    return p.e.fts_keyboard_sug_view;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.g
 * JD-Core Version:    0.7.0.1
 */