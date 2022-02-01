package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.l;
import d.z;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderShowMoreFooterConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "onItemClick", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "getOnItemClick", "()Lkotlin/jvm/functions/Function0;", "getLayoutId", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class be
  extends com.tencent.mm.view.recyclerview.b<com.tencent.mm.view.recyclerview.a>
{
  final d.g.a.a<z> rPM;
  
  public be(d.g.a.a<z> parama)
  {
    this.rPM = parama;
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(201484);
    p.h(paramRecyclerView, "recyclerView");
    p.h(parame, "holder");
    parame.auu.setOnClickListener((View.OnClickListener)new a(this));
    AppMethodBeat.o(201484);
  }
  
  public final void a(e parame, com.tencent.mm.view.recyclerview.a parama, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(201485);
    p.h(parame, "holder");
    p.h(parama, "item");
    AppMethodBeat.o(201485);
  }
  
  public final int getLayoutId()
  {
    return 2131496255;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(be parambe) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201483);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderShowMoreFooterConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = this.rPN.rPM;
      if (paramView != null) {
        paramView.invoke();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderShowMoreFooterConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201483);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.be
 * JD-Core Version:    0.7.0.1
 */