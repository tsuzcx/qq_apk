package com.tencent.mm.plugin.fts.ui.widget;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/fts/ui/widget/KeyboardSugConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/fts/ui/widget/KeyboardSugItem;", "clickListener", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/OnItemClickListener;", "(Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/OnItemClickListener;)V", "getClickListener", "()Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/OnItemClickListener;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "ui-fts_release"})
public final class e
  extends com.tencent.mm.view.recyclerview.e<g>
{
  final com.tencent.mm.plugin.appbrand.widget.recyclerview.b xfK;
  
  public e(com.tencent.mm.plugin.appbrand.widget.recyclerview.b paramb)
  {
    AppMethodBeat.i(235457);
    this.xfK = paramb;
    AppMethodBeat.o(235457);
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(235455);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    AppMethodBeat.o(235455);
  }
  
  public final int getLayoutId()
  {
    return 2131494760;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(e parame, int paramInt, g paramg) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(235454);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      a.b("com/tencent/mm/plugin/fts/ui/widget/KeyboardSugConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.xfL.xfK.Q(paramView, this.gUj);
      a.a(this, "com/tencent/mm/plugin/fts/ui/widget/KeyboardSugConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(235454);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.e
 * JD-Core Version:    0.7.0.1
 */