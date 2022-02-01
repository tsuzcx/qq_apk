package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.h;
import com.tencent.mm.plugin.finder.model.f;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedMsgNotifyConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class n
  extends com.tencent.mm.view.recyclerview.b<f>
{
  public static final n.a rbq;
  
  static
  {
    AppMethodBeat.i(165410);
    rbq = new n.a((byte)0);
    AppMethodBeat.o(165410);
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.e parame, int paramInt)
  {
    AppMethodBeat.i(165408);
    k.h(paramRecyclerView, "recyclerView");
    k.h(parame, "holder");
    paramRecyclerView = parame.asD;
    k.g(paramRecyclerView, "holder.itemView");
    paramRecyclerView = paramRecyclerView.getLayoutParams();
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager.LayoutParams)) {
      ((StaggeredGridLayoutManager.LayoutParams)paramRecyclerView).aE(true);
    }
    parame.adJ(2131302533).setOnClickListener((View.OnClickListener)new b(parame));
    AppMethodBeat.o(165408);
  }
  
  public final int getLayoutId()
  {
    return 2131492868;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165407);
      paramView = g.agR();
      k.g(paramView, "MMKernel.storage()");
      int m = paramView.agA().getInt(ah.a.GUV, 0);
      paramView = g.agR();
      k.g(paramView, "MMKernel.storage()");
      int n = paramView.agA().getInt(ah.a.GUW, 0);
      paramView = g.agR();
      k.g(paramView, "MMKernel.storage()");
      int i1 = paramView.agA().getInt(ah.a.GUX, 0);
      paramView = g.agR();
      k.g(paramView, "MMKernel.storage()");
      int i2 = paramView.agA().getInt(ah.a.GUY, 0);
      paramView = a.rOv;
      paramView = this.ojH.getContext();
      k.g(paramView, "holder.context");
      a.eQ(paramView);
      paramView = g.ad(PluginFinder.class);
      k.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      Object localObject1 = ((PluginFinder)paramView).getRedDotManager().adx("TLWxBubble");
      int j;
      int k;
      if (localObject1 != null)
      {
        j = 0;
        paramView = com.tencent.mm.plugin.finder.storage.b.rCU;
        if (com.tencent.mm.plugin.finder.storage.b.czT())
        {
          k = 5;
          if (n > 0) {
            j = 1;
          }
          i = j;
          if (m > 0) {
            i = j | 0x8;
          }
          j = i;
          if (i1 > 0) {
            j = i | 0x2;
          }
          if (i2 <= 0) {
            break label349;
          }
        }
      }
      label349:
      for (int i = j | 0x4;; i = j)
      {
        paramView = com.tencent.mm.plugin.finder.report.d.rxr;
        paramView = this.ojH.getContext();
        k.g(paramView, "holder.context");
        paramView = com.tencent.mm.plugin.finder.report.d.eN(paramView);
        j = i;
        i = k;
        Object localObject2 = com.tencent.mm.plugin.finder.report.d.rxr;
        localObject2 = ((h)localObject1).field_tipsId;
        k.g(localObject2, "ctrInfo.field_tipsId");
        localObject1 = FinderReporterUIC.seQ;
        localObject1 = this.ojH.getContext();
        k.g(localObject1, "holder.context");
        localObject1 = FinderReporterUIC.a.eV((Context)localObject1);
        if (localObject1 != null) {}
        for (localObject1 = ((FinderReporterUIC)localObject1).cGb();; localObject1 = null)
        {
          com.tencent.mm.plugin.finder.report.d.a(paramView, i, 2, 2, j, m + n + i1 + i2, (String)localObject2, null, 0L, (anm)localObject1, 0, 0, 3456);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.n
 * JD-Core Version:    0.7.0.1
 */