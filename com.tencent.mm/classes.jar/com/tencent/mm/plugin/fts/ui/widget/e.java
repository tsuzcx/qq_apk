package com.tencent.mm.plugin.fts.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.fts.ui.o.e;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/fts/ui/widget/KeyboardSugConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/fts/ui/widget/KeyboardSugItem;", "clickListener", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/OnItemClickListener;", "(Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/OnItemClickListener;)V", "getClickListener", "()Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/OnItemClickListener;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "ui-fts_release"})
public final class e
  extends com.tencent.mm.view.recyclerview.e<g>
{
  final com.tencent.mm.plugin.appbrand.widget.recyclerview.b BRV;
  
  public e(com.tencent.mm.plugin.appbrand.widget.recyclerview.b paramb)
  {
    AppMethodBeat.i(191453);
    this.BRV = paramb;
    AppMethodBeat.o(191453);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(191450);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    AppMethodBeat.o(191450);
  }
  
  public final int getLayoutId()
  {
    return o.e.fts_keyboard_sug_view;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(e parame, int paramInt, g paramg) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(193825);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/fts/ui/widget/KeyboardSugConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.BRW.BRV.S(paramView, this.jEN);
      a.a(this, "com/tencent/mm/plugin/fts/ui/widget/KeyboardSugConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(193825);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.e
 * JD-Core Version:    0.7.0.1
 */