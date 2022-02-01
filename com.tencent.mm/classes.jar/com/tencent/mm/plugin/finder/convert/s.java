package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.h;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderSearchData;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class s
  extends com.tencent.mm.view.recyclerview.b<h>
{
  public static final a rOj;
  
  static
  {
    AppMethodBeat.i(165417);
    rOj = new a((byte)0);
    AppMethodBeat.o(165417);
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(165415);
    p.h(paramRecyclerView, "recyclerView");
    p.h(parame, "holder");
    Object localObject = parame.auu;
    p.g(localObject, "holder.itemView");
    localObject = ((View)localObject).getLayoutParams();
    if ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)) {
      ((StaggeredGridLayoutManager.LayoutParams)localObject).aE(true);
    }
    parame.auu.setOnClickListener((View.OnClickListener)new b(paramRecyclerView));
    AppMethodBeat.o(165415);
  }
  
  public final int getLayoutId()
  {
    return 2131492869;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(RecyclerView paramRecyclerView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165414);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = new Intent();
      localObject = FinderReporterUIC.tcM;
      localObject = this.rOk.getContext();
      p.g(localObject, "recyclerView.context");
      FinderReporterUIC.a.a((Context)localObject, paramView, 0L, 0, false, 124);
      localObject = com.tencent.mm.plugin.finder.utils.a.sKD;
      localObject = this.rOk.getContext();
      p.g(localObject, "recyclerView.context");
      com.tencent.mm.plugin.finder.utils.a.A((Context)localObject, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(165414);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.s
 * JD-Core Version:    0.7.0.1
 */