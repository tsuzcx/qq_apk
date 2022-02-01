package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.report.j;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedMsgNotifyConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class ab
  extends com.tencent.mm.view.recyclerview.e<com.tencent.mm.plugin.finder.model.h>
{
  public static final a tDz;
  
  static
  {
    AppMethodBeat.i(165410);
    tDz = new a((byte)0);
    AppMethodBeat.o(165410);
  }
  
  public static void a(com.tencent.mm.view.recyclerview.h paramh, com.tencent.mm.plugin.finder.model.h paramh1)
  {
    AppMethodBeat.i(243077);
    kotlin.g.b.p.h(paramh, "holder");
    kotlin.g.b.p.h(paramh1, "item");
    Log.i("Finder.FeedMsgNotifyConvert", "item count = " + paramh1.count + ",item avatar = " + paramh1.uNR);
    if (paramh1.count > 0)
    {
      Object localObject1 = paramh.Mn(2131304963);
      kotlin.g.b.p.g(localObject1, "holder.getView<View>(R.id.msg_layout)");
      ((View)localObject1).setVisibility(0);
      Object localObject2;
      if (Util.isNullOrNil(paramh1.uNR))
      {
        localObject1 = paramh.Mn(2131304949);
        kotlin.g.b.p.g(localObject1, "holder.getView<View>(R.id.msg_avatar)");
        ((View)localObject1).setVisibility(8);
        localObject1 = paramh.Mn(2131304642);
        kotlin.g.b.p.g(localObject1, "holder.getView<TextView>(R.id.message_count)");
        localObject1 = (TextView)localObject1;
        paramh = paramh.getContext();
        kotlin.g.b.p.g(paramh, "holder.context");
        localObject2 = paramh.getResources();
        if (paramh1.count <= 99) {
          break label264;
        }
      }
      label264:
      for (paramh = "99+";; paramh = Integer.valueOf(paramh1.count))
      {
        ((TextView)localObject1).setText((CharSequence)((Resources)localObject2).getString(2131760264, new Object[] { paramh }));
        AppMethodBeat.o(243077);
        return;
        localObject1 = paramh.Mn(2131304949);
        kotlin.g.b.p.g(localObject1, "holder.getView<View>(R.id.msg_avatar)");
        ((View)localObject1).setVisibility(0);
        localObject1 = m.uJa;
        localObject1 = m.dkb();
        localObject2 = new com.tencent.mm.plugin.finder.loader.p(paramh1.uNR, x.vEo);
        Object localObject3 = paramh.Mn(2131304949);
        kotlin.g.b.p.g(localObject3, "holder.getView<ImageView>(R.id.msg_avatar)");
        localObject3 = (ImageView)localObject3;
        m localm = m.uJa;
        ((d)localObject1).a(localObject2, (ImageView)localObject3, m.a(m.a.uJg));
        break;
      }
    }
    paramh = paramh.Mn(2131304963);
    kotlin.g.b.p.g(paramh, "holder.getView<View>(R.id.msg_layout)");
    paramh.setVisibility(8);
    AppMethodBeat.o(243077);
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.h paramh, int paramInt)
  {
    AppMethodBeat.i(165408);
    kotlin.g.b.p.h(paramRecyclerView, "recyclerView");
    kotlin.g.b.p.h(paramh, "holder");
    paramRecyclerView = paramh.aus;
    kotlin.g.b.p.g(paramRecyclerView, "holder.itemView");
    paramRecyclerView = paramRecyclerView.getLayoutParams();
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager.LayoutParams)) {
      ((StaggeredGridLayoutManager.LayoutParams)paramRecyclerView).aC(true);
    }
    paramh.Mn(2131304963).setOnClickListener((View.OnClickListener)new b(paramh));
    AppMethodBeat.o(165408);
  }
  
  public final int getLayoutId()
  {
    return 2131492872;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedMsgNotifyConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165407);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedMsgNotifyConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = g.aAh();
      kotlin.g.b.p.g(paramView, "MMKernel.storage()");
      int m = paramView.azQ().getInt(ar.a.Olg, 0);
      paramView = g.aAh();
      kotlin.g.b.p.g(paramView, "MMKernel.storage()");
      int n = paramView.azQ().getInt(ar.a.Olh, 0);
      paramView = g.aAh();
      kotlin.g.b.p.g(paramView, "MMKernel.storage()");
      int i1 = paramView.azQ().getInt(ar.a.Oli, 0);
      paramView = g.aAh();
      kotlin.g.b.p.g(paramView, "MMKernel.storage()");
      int i2 = paramView.azQ().getInt(ar.a.Olj, 0);
      paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
      paramView = this.qhp.getContext();
      kotlin.g.b.p.g(paramView, "holder.context");
      com.tencent.mm.plugin.finder.utils.a.fu(paramView);
      paramView = g.ah(PluginFinder.class);
      kotlin.g.b.p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      localObject = ((PluginFinder)paramView).getRedDotManager().asX("TLWxBubble");
      paramView = g.ah(PluginFinder.class);
      kotlin.g.b.p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      bdo localbdo = ((PluginFinder)paramView).getRedDotManager().asW("TLWxBubble");
      int k;
      if (localObject != null)
      {
        paramView = c.vCb;
        if (((Number)c.dsx().value()).intValue() != 1) {
          break label427;
        }
        k = 5;
        if (n <= 0) {
          break label449;
        }
      }
      label318:
      label449:
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
          j = i;
          i = k;
          paramView = com.tencent.mm.plugin.finder.report.k.vfA;
          String str = ((com.tencent.mm.plugin.finder.extension.reddot.k)localObject).field_tipsId;
          paramView = FinderReporterUIC.wzC;
          paramView = this.qhp.getContext();
          kotlin.g.b.p.g(paramView, "holder.context");
          paramView = FinderReporterUIC.a.fH(paramView);
          if (paramView != null)
          {
            paramView = paramView.dIx();
            com.tencent.mm.plugin.finder.report.k.a("7", i, 2, 2, j, m + n + i1 + i2, str, null, 0L, paramView, 0, 0, 3456);
            if ((localObject != null) && (localbdo != null))
            {
              paramView = j.vft;
              paramView = FinderReporterUIC.wzC;
              paramView = this.qhp.getContext();
              kotlin.g.b.p.g(paramView, "holder.context");
              paramView = FinderReporterUIC.a.fH(paramView);
              if (paramView == null) {
                break label439;
              }
            }
          }
          for (paramView = paramView.dIx();; paramView = null)
          {
            j.a("7", (com.tencent.mm.plugin.finder.extension.reddot.k)localObject, localbdo, 2, paramView, 0, 0, 96);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedMsgNotifyConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(165407);
            return;
            i = 1;
            j = 1;
            break;
            paramView = null;
            break label318;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ab
 * JD-Core Version:    0.7.0.1
 */