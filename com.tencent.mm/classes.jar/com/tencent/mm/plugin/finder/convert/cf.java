package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderShowMoreFooterConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "onItemClick", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "getOnItemClick", "()Lkotlin/jvm/functions/Function0;", "getLayoutId", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class cf
  extends e<com.tencent.mm.view.recyclerview.a>
{
  final kotlin.g.a.a<x> tGe;
  
  public cf(kotlin.g.a.a<x> parama)
  {
    this.tGe = parama;
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(243276);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    paramh.aus.setOnClickListener((View.OnClickListener)new a(this));
    AppMethodBeat.o(243276);
  }
  
  public final void a(h paramh, com.tencent.mm.view.recyclerview.a parama, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(243277);
    p.h(paramh, "holder");
    p.h(parama, "item");
    AppMethodBeat.o(243277);
  }
  
  public final int getLayoutId()
  {
    return 2131494633;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(cf paramcf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243275);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderShowMoreFooterConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.tGf.tGe;
      if (paramView != null) {
        paramView.invoke();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderShowMoreFooterConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(243275);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.cf
 * JD-Core Version:    0.7.0.1
 */