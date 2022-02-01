package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.ast;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedMsgNotifyConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class o
  extends com.tencent.mm.view.recyclerview.b<com.tencent.mm.plugin.finder.model.g>
{
  public static final o.a rWD;
  
  static
  {
    AppMethodBeat.i(165410);
    rWD = new o.a((byte)0);
    AppMethodBeat.o(165410);
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.e parame, int paramInt)
  {
    AppMethodBeat.i(165408);
    p.h(paramRecyclerView, "recyclerView");
    p.h(parame, "holder");
    paramRecyclerView = parame.auu;
    p.g(paramRecyclerView, "holder.itemView");
    paramRecyclerView = paramRecyclerView.getLayoutParams();
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager.LayoutParams)) {
      ((StaggeredGridLayoutManager.LayoutParams)paramRecyclerView).aE(true);
    }
    parame.GD(2131302533).setOnClickListener((View.OnClickListener)new b(parame));
    AppMethodBeat.o(165408);
  }
  
  public final int getLayoutId()
  {
    return 2131492868;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165407);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedMsgNotifyConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = com.tencent.mm.kernel.g.ajR();
      p.g(paramView, "MMKernel.storage()");
      int m = paramView.ajA().getInt(am.a.Jcf, 0);
      paramView = com.tencent.mm.kernel.g.ajR();
      p.g(paramView, "MMKernel.storage()");
      int n = paramView.ajA().getInt(am.a.Jcg, 0);
      paramView = com.tencent.mm.kernel.g.ajR();
      p.g(paramView, "MMKernel.storage()");
      int i1 = paramView.ajA().getInt(am.a.Jch, 0);
      paramView = com.tencent.mm.kernel.g.ajR();
      p.g(paramView, "MMKernel.storage()");
      int i2 = paramView.ajA().getInt(am.a.Jci, 0);
      paramView = com.tencent.mm.plugin.finder.utils.a.sVQ;
      paramView = this.oTF.getContext();
      p.g(paramView, "holder.context");
      com.tencent.mm.plugin.finder.utils.a.eU(paramView);
      paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      com.tencent.mm.plugin.finder.extension.reddot.i locali = ((PluginFinder)paramView).getRedDotManager().aij("TLWxBubble");
      paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      ast localast = ((PluginFinder)paramView).getRedDotManager().aii("TLWxBubble");
      paramView = "2";
      int k;
      if (locali != null)
      {
        paramView = com.tencent.mm.plugin.finder.storage.b.sHP;
        if (((Number)com.tencent.mm.plugin.finder.storage.b.cIR().value()).intValue() != 1) {
          break label471;
        }
        k = 5;
        if (n <= 0) {
          break label498;
        }
      }
      label353:
      label487:
      label498:
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
          paramView = com.tencent.mm.plugin.finder.report.i.syT;
          paramView = this.oTF.getContext();
          p.g(paramView, "holder.context");
          paramView = com.tencent.mm.plugin.finder.report.i.eR(paramView);
          j = i;
          i = k;
          localObject = com.tencent.mm.plugin.finder.report.i.syT;
          String str = locali.field_tipsId;
          localObject = FinderReporterUIC.tnG;
          localObject = this.oTF.getContext();
          p.g(localObject, "holder.context");
          localObject = FinderReporterUIC.a.fc((Context)localObject);
          if (localObject != null)
          {
            localObject = ((FinderReporterUIC)localObject).cQZ();
            com.tencent.mm.plugin.finder.report.i.a(paramView, i, 2, 2, j, m + n + i1 + i2, str, null, 0L, (arn)localObject, 0, 0, 3456);
            if ((locali != null) && (localast != null))
            {
              localObject = h.syO;
              localObject = FinderReporterUIC.tnG;
              localObject = this.oTF.getContext();
              p.g(localObject, "holder.context");
              localObject = FinderReporterUIC.a.fc((Context)localObject);
              if (localObject == null) {
                break label487;
              }
            }
          }
          for (localObject = ((FinderReporterUIC)localObject).cQZ();; localObject = null)
          {
            h.a(paramView, locali, localast, 2, (arn)localObject, 0, 0, 96);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedMsgNotifyConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(165407);
            return;
            paramView = "2";
            i = 1;
            j = 1;
            break;
            localObject = null;
            break label353;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.o
 * JD-Core Version:    0.7.0.1
 */