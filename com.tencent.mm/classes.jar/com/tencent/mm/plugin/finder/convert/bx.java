package com.tencent.mm.plugin.finder.convert;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.extension.reddot.h.a;
import com.tencent.mm.plugin.finder.extension.reddot.k;
import com.tencent.mm.plugin.finder.model.bh;
import com.tencent.mm.plugin.finder.report.j;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.aa;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderPrivateMsgNotifyConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderPrivateMsgNotifyData;", "()V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "item", "itemPosition", "", "observer", "Landroid/arch/lifecycle/Observer;", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "getLayoutId", "onAttachedToRecyclerView", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "onDetachedFromRecyclerView", "Companion", "plugin-finder_release"})
public final class bx
  extends e<bh>
{
  public static final a tFr;
  private int kf;
  private final Observer<h.a> tFo;
  private WxRecyclerAdapter<?> tFp;
  private bh tFq;
  
  static
  {
    AppMethodBeat.i(243234);
    tFr = new a((byte)0);
    AppMethodBeat.o(243234);
  }
  
  public bx()
  {
    AppMethodBeat.i(243233);
    this.tFo = ((Observer)new b(this));
    this.kf = -1;
    AppMethodBeat.o(243233);
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(243228);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    this.tFp = paramWxRecyclerAdapter;
    paramRecyclerView = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
    com.tencent.mm.plugin.finder.extension.reddot.h.daX().observeForever(this.tFo);
    AppMethodBeat.o(243228);
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.h paramh, int paramInt)
  {
    AppMethodBeat.i(243232);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    AppMethodBeat.o(243232);
  }
  
  public final void a(final com.tencent.mm.view.recyclerview.h paramh, final bh parambh, int paramInt)
  {
    AppMethodBeat.i(243230);
    p.h(paramh, "holder");
    p.h(parambh, "item");
    this.tFq = parambh;
    this.kf = paramInt;
    parambh = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
    parambh = (h.a)com.tencent.mm.plugin.finder.extension.reddot.h.daX().getValue();
    if ((parambh != null) && (parambh.dEF == true))
    {
      parambh = paramh.Mn(2131304963);
      p.g(parambh, "holder.getView<View>(R.id.msg_layout)");
      parambh.setVisibility(0);
      parambh = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
      parambh = (h.a)com.tencent.mm.plugin.finder.extension.reddot.h.daX().getValue();
      final k localk;
      if (parambh != null)
      {
        parambh = parambh.tKT;
        if (parambh != null)
        {
          parambh = parambh.atl("TLWxPrivateMsgBubble");
          localObject = g.ah(PluginFinder.class);
          p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
          localk = ((PluginFinder)localObject).getRedDotManager().asX("TLWxPrivateMsgBubble");
          if (parambh == null) {
            break label227;
          }
        }
      }
      label227:
      for (Object localObject = parambh.qGB;; localObject = null)
      {
        localObject = ((aa)g.af(aa.class)).avi((String)localObject);
        if (localObject == null) {
          break label233;
        }
        ay.a.aVo().a((String)localObject, null, (ay.b.a)new c((String)localObject, paramh, localk, parambh));
        paramh.Mn(2131304963).setOnClickListener((View.OnClickListener)new d(paramh, localk, parambh));
        AppMethodBeat.o(243230);
        return;
        parambh = null;
        break;
      }
      label233:
      AppMethodBeat.o(243230);
      return;
    }
    paramh = paramh.Mn(2131304963);
    if (paramh != null)
    {
      paramh.setVisibility(8);
      AppMethodBeat.o(243230);
      return;
    }
    AppMethodBeat.o(243230);
  }
  
  public final void c(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(243229);
    p.h(paramRecyclerView, "recyclerView");
    super.c(paramRecyclerView);
    paramRecyclerView = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
    com.tencent.mm.plugin.finder.extension.reddot.h.daX().removeObserver(this.tFo);
    AppMethodBeat.o(243229);
  }
  
  public final int getLayoutId()
  {
    return 2131492873;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderPrivateMsgNotifyConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class b<T>
    implements Observer<h.a>
  {
    b(bx parambx) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "username", "", "kotlin.jvm.PlatformType", "succ", "", "getContactCallBack", "com/tencent/mm/plugin/finder/convert/FinderPrivateMsgNotifyConvert$onBindViewHolder$1$1"})
  static final class c
    implements ay.b.a
  {
    c(String paramString, com.tencent.mm.view.recyclerview.h paramh, k paramk, bdo parambdo) {}
    
    public final void p(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(243226);
      Log.i("Finder.PrivateMsgNotifyConvert", "[getNow] username=" + paramString + " succ=" + paramBoolean);
      com.tencent.mm.ui.g.a.a.d((ImageView)paramh.Mn(2131304949), this.naX);
      AppMethodBeat.o(243226);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderPrivateMsgNotifyConvert$onBindViewHolder$1$2"})
  static final class d
    implements View.OnClickListener
  {
    d(com.tencent.mm.view.recyclerview.h paramh, k paramk, bdo parambdo) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243227);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderPrivateMsgNotifyConvert$onBindViewHolder$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      bdo localbdo;
      if ((localk != null) && (parambh != null))
      {
        paramView = j.vft;
        localObject = localk;
        localbdo = parambh;
        paramView = FinderReporterUIC.wzC;
        paramView = this.tzq.getContext();
        p.g(paramView, "holder.context");
        paramView = FinderReporterUIC.a.fH(paramView);
        if (paramView == null) {
          break label147;
        }
      }
      label147:
      for (paramView = paramView.dIx();; paramView = null)
      {
        j.a("7", (k)localObject, localbdo, 2, paramView, 0, 0, 96);
        paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
        paramView = this.tzq.getContext();
        p.g(paramView, "holder.context");
        com.tencent.mm.plugin.finder.utils.a.fB(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderPrivateMsgNotifyConvert$onBindViewHolder$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(243227);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.bx
 * JD-Core Version:    0.7.0.1
 */