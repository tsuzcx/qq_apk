package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedMsgNotifyConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class o
  extends com.tencent.mm.view.recyclerview.b<com.tencent.mm.plugin.finder.model.g>
{
  public static final a rOg;
  
  static
  {
    AppMethodBeat.i(165410);
    rOg = new a((byte)0);
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
    parame.Gd(2131302533).setOnClickListener((View.OnClickListener)new b(parame));
    AppMethodBeat.o(165408);
  }
  
  public final int getLayoutId()
  {
    return 2131492868;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedMsgNotifyConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165407);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedMsgNotifyConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = com.tencent.mm.kernel.g.ajC();
      p.g(paramView, "MMKernel.storage()");
      int m = paramView.ajl().getInt(al.a.IHC, 0);
      paramView = com.tencent.mm.kernel.g.ajC();
      p.g(paramView, "MMKernel.storage()");
      int n = paramView.ajl().getInt(al.a.IHD, 0);
      paramView = com.tencent.mm.kernel.g.ajC();
      p.g(paramView, "MMKernel.storage()");
      int i1 = paramView.ajl().getInt(al.a.IHE, 0);
      paramView = com.tencent.mm.kernel.g.ajC();
      p.g(paramView, "MMKernel.storage()");
      int i2 = paramView.ajl().getInt(al.a.IHF, 0);
      paramView = com.tencent.mm.plugin.finder.utils.a.sKD;
      paramView = this.oNd.getContext();
      p.g(paramView, "holder.context");
      com.tencent.mm.plugin.finder.utils.a.eQ(paramView);
      paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      i locali = ((PluginFinder)paramView).getRedDotManager().ahn("TLWxBubble");
      paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      ase localase = ((PluginFinder)paramView).getRedDotManager().ahm("TLWxBubble");
      paramView = "2";
      int k;
      if (locali != null)
      {
        paramView = com.tencent.mm.plugin.finder.storage.b.sxa;
        if (((Number)com.tencent.mm.plugin.finder.storage.b.cGS().value()).intValue() != 1) {
          break label477;
        }
        k = 5;
        if (n <= 0) {
          break label504;
        }
      }
      label360:
      label493:
      label504:
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
          paramView = h.soM;
          paramView = this.oNd.getContext();
          p.g(paramView, "holder.context");
          paramView = h.eN(paramView);
          j = i;
          i = k;
          localObject = h.soM;
          String str = locali.field_tipsId;
          p.g(str, "ctrInfo.field_tipsId");
          localObject = FinderReporterUIC.tcM;
          localObject = this.oNd.getContext();
          p.g(localObject, "holder.context");
          localObject = FinderReporterUIC.a.eY((Context)localObject);
          if (localObject != null)
          {
            localObject = ((FinderReporterUIC)localObject).cOu();
            h.a(paramView, i, 2, 2, j, m + n + i1 + i2, str, null, 0L, (aqy)localObject, 0, 0, 3456);
            if ((locali != null) && (localase != null))
            {
              localObject = com.tencent.mm.plugin.finder.report.g.soH;
              localObject = FinderReporterUIC.tcM;
              localObject = this.oNd.getContext();
              p.g(localObject, "holder.context");
              localObject = FinderReporterUIC.a.eY((Context)localObject);
              if (localObject == null) {
                break label493;
              }
            }
          }
          for (localObject = ((FinderReporterUIC)localObject).cOu();; localObject = null)
          {
            com.tencent.mm.plugin.finder.report.g.b(paramView, locali, localase, 2, (aqy)localObject, 0, 96);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedMsgNotifyConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(165407);
            return;
            paramView = "2";
            i = 1;
            j = 1;
            break;
            localObject = null;
            break label360;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.o
 * JD-Core Version:    0.7.0.1
 */