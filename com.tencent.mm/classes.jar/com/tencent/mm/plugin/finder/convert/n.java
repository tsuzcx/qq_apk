package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.view.recyclerview.b;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderSearchData;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class n
  extends b<com.tencent.mm.plugin.finder.model.e>
{
  public static final a qrv;
  
  static
  {
    AppMethodBeat.i(165417);
    qrv = new a((byte)0);
    AppMethodBeat.o(165417);
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.e parame, int paramInt)
  {
    AppMethodBeat.i(165415);
    k.h(paramRecyclerView, "recyclerView");
    k.h(parame, "holder");
    Object localObject = parame.arI;
    k.g(localObject, "holder.itemView");
    localObject = ((View)localObject).getLayoutParams();
    if ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)) {
      ((StaggeredGridLayoutManager.LayoutParams)localObject).aE(true);
    }
    parame.arI.setOnClickListener((View.OnClickListener)new b(paramRecyclerView));
    AppMethodBeat.o(165415);
  }
  
  public final int getLayoutId()
  {
    return 2131492869;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(RecyclerView paramRecyclerView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165414);
      paramView = new Intent();
      Object localObject = FinderReporterUIC.Ljl;
      localObject = this.qrn.getContext();
      k.g(localObject, "recyclerView.context");
      FinderReporterUIC.a.a((Context)localObject, paramView, 0L, 0, false, 124);
      localObject = a.qSb;
      localObject = this.qrn.getContext();
      k.g(localObject, "recyclerView.context");
      a.Z((Context)localObject, paramView);
      AppMethodBeat.o(165414);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.n
 * JD-Core Version:    0.7.0.1
 */