package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.c;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.model.d;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedMsgNotifyConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class k
  extends com.tencent.mm.view.recyclerview.b<d>
{
  public static final a qrt;
  
  static
  {
    AppMethodBeat.i(165410);
    qrt = new a((byte)0);
    AppMethodBeat.o(165410);
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.e parame, int paramInt)
  {
    AppMethodBeat.i(165408);
    d.g.b.k.h(paramRecyclerView, "recyclerView");
    d.g.b.k.h(parame, "holder");
    paramRecyclerView = parame.arI;
    d.g.b.k.g(paramRecyclerView, "holder.itemView");
    paramRecyclerView = paramRecyclerView.getLayoutParams();
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager.LayoutParams)) {
      ((StaggeredGridLayoutManager.LayoutParams)paramRecyclerView).aE(true);
    }
    parame.abq(2131302533).setOnClickListener((View.OnClickListener)new b(parame));
    AppMethodBeat.o(165408);
  }
  
  public final int getLayoutId()
  {
    return 2131492868;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedMsgNotifyConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165407);
      paramView = g.afB();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      int m = paramView.afk().getInt(ae.a.FwJ, 0);
      paramView = g.afB();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      int n = paramView.afk().getInt(ae.a.FwK, 0);
      paramView = g.afB();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      int i1 = paramView.afk().getInt(ae.a.LBe, 0);
      paramView = g.afB();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      int i2 = paramView.afk().getInt(ae.a.LBf, 0);
      paramView = a.qSb;
      paramView = this.nGG.getContext();
      d.g.b.k.g(paramView, "holder.context");
      a.eI(paramView);
      paramView = g.ad(PluginFinder.class);
      d.g.b.k.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      Object localObject1 = ((PluginFinder)paramView).getRedDotManager().YW("TLWxBubble");
      int k;
      if (localObject1 != null)
      {
        paramView = com.tencent.mm.plugin.finder.storage.b.qJA;
        if (com.tencent.mm.plugin.finder.storage.b.fUw())
        {
          k = 5;
          if (n <= 0) {
            break label351;
          }
        }
      }
      label351:
      for (int j = 1;; j = 0)
      {
        int i = j;
        if (m > 0) {
          i = j | 0x8;
        }
        j = i;
        if (i1 > 0) {
          j = i | 0x2;
        }
        if (i2 > 0) {}
        for (i = j | 0x4;; i = j)
        {
          paramView = com.tencent.mm.plugin.finder.report.b.qFq;
          paramView = this.nGG.getContext();
          d.g.b.k.g(paramView, "holder.context");
          paramView = com.tencent.mm.plugin.finder.report.b.lx(paramView);
          j = i;
          i = k;
          Object localObject2 = com.tencent.mm.plugin.finder.report.b.qFq;
          localObject2 = ((f)localObject1).field_tipsId;
          d.g.b.k.g(localObject2, "ctrInfo.field_tipsId");
          localObject1 = FinderReporterUIC.Ljl;
          localObject1 = this.nGG.getContext();
          d.g.b.k.g(localObject1, "holder.context");
          localObject1 = FinderReporterUIC.a.lB((Context)localObject1);
          if (localObject1 != null) {}
          for (localObject1 = ((FinderReporterUIC)localObject1).fXs();; localObject1 = null)
          {
            com.tencent.mm.plugin.finder.report.b.a(paramView, i, 2, 2, j, m + n + i1 + i2, (String)localObject2, null, 0L, (dzp)localObject1, 0, 1408);
            AppMethodBeat.o(165407);
            return;
            paramView = "2";
            i = 1;
            j = 1;
            break;
          }
          AppMethodBeat.o(165407);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.k
 * JD-Core Version:    0.7.0.1
 */