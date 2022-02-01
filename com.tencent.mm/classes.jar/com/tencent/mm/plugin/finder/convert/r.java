package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.g;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.view.recyclerview.b;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderSearchData;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class r
  extends b<g>
{
  public static final r.a rbt;
  
  static
  {
    AppMethodBeat.i(165417);
    rbt = new r.a((byte)0);
    AppMethodBeat.o(165417);
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(165415);
    k.h(paramRecyclerView, "recyclerView");
    k.h(parame, "holder");
    Object localObject = parame.asD;
    k.g(localObject, "holder.itemView");
    localObject = ((View)localObject).getLayoutParams();
    if ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)) {
      ((StaggeredGridLayoutManager.LayoutParams)localObject).aE(true);
    }
    parame.asD.setOnClickListener((View.OnClickListener)new b(paramRecyclerView));
    AppMethodBeat.o(165415);
  }
  
  public final int getLayoutId()
  {
    return 2131492869;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(RecyclerView paramRecyclerView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165414);
      paramView = new Intent();
      Object localObject = FinderReporterUIC.seQ;
      localObject = this.rbu.getContext();
      k.g(localObject, "recyclerView.context");
      FinderReporterUIC.a.a((Context)localObject, paramView, 0L, 0, false, 124);
      localObject = a.rOv;
      localObject = this.rbu.getContext();
      k.g(localObject, "recyclerView.context");
      a.z((Context)localObject, paramView);
      AppMethodBeat.o(165414);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.r
 * JD-Core Version:    0.7.0.1
 */