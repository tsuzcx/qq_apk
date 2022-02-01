package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.extension.reddot.h.a;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.findersdk.a.ab;
import com.tencent.mm.protocal.protobuf.bkn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderPrivateMsgNotifyConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderPrivateMsgNotifyData;", "()V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "item", "itemPosition", "", "observer", "Landroidx/lifecycle/Observer;", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "getLayoutId", "onAttachedToRecyclerView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "onDetachedFromRecyclerView", "Companion", "plugin-finder_release"})
public final class ca
  extends e<bm>
{
  public static final a xnT;
  private int bwM;
  private final s<h.a> xnQ;
  private WxRecyclerAdapter<?> xnR;
  private bm xnS;
  
  static
  {
    AppMethodBeat.i(280482);
    xnT = new a((byte)0);
    AppMethodBeat.o(280482);
  }
  
  public ca()
  {
    AppMethodBeat.i(280481);
    this.xnQ = ((s)new b(this));
    this.bwM = -1;
    AppMethodBeat.o(280481);
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(280476);
    p.k(paramRecyclerView, "recyclerView");
    p.k(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    this.xnR = paramWxRecyclerAdapter;
    paramRecyclerView = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
    com.tencent.mm.plugin.finder.extension.reddot.h.drb().a(this.xnQ);
    AppMethodBeat.o(280476);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(280480);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    AppMethodBeat.o(280480);
  }
  
  public final void a(final i parami, final bm parambm, int paramInt)
  {
    AppMethodBeat.i(280478);
    p.k(parami, "holder");
    p.k(parambm, "item");
    this.xnS = parambm;
    this.bwM = paramInt;
    parambm = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
    parambm = (h.a)com.tencent.mm.plugin.finder.extension.reddot.h.drb().getValue();
    if ((parambm != null) && (parambm.fxt == true))
    {
      parambm = parami.RD(b.f.msg_layout);
      p.j(parambm, "holder.getView<View>(R.id.msg_layout)");
      parambm.setVisibility(0);
      parambm = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
      parambm = (h.a)com.tencent.mm.plugin.finder.extension.reddot.h.drb().getValue();
      final com.tencent.mm.plugin.finder.extension.reddot.l locall;
      if (parambm != null)
      {
        parambm = parambm.xur;
        if (parambm != null)
        {
          parambm = parambm.aBy("TLWxPrivateMsgBubble");
          localObject = com.tencent.mm.kernel.h.ag(PluginFinder.class);
          p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
          locall = ((PluginFinder)localObject).getRedDotManager().aBf("TLWxPrivateMsgBubble");
          if (parambm == null) {
            break label229;
          }
        }
      }
      label229:
      for (Object localObject = parambm.ufC;; localObject = null)
      {
        localObject = ((ab)com.tencent.mm.kernel.h.ae(ab.class)).aED((String)localObject);
        if (localObject == null) {
          break label235;
        }
        az.a.ber().a((String)localObject, null, (az.b.a)new c((String)localObject, parami, locall, parambm));
        parami.RD(b.f.msg_layout).setOnClickListener((View.OnClickListener)new d(parami, locall, parambm));
        AppMethodBeat.o(280478);
        return;
        parambm = null;
        break;
      }
      label235:
      AppMethodBeat.o(280478);
      return;
    }
    parami = parami.RD(b.f.msg_layout);
    if (parami != null)
    {
      parami.setVisibility(8);
      AppMethodBeat.o(280478);
      return;
    }
    AppMethodBeat.o(280478);
  }
  
  public final void e(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(280477);
    p.k(paramRecyclerView, "recyclerView");
    super.e(paramRecyclerView);
    paramRecyclerView = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
    com.tencent.mm.plugin.finder.extension.reddot.h.drb().b(this.xnQ);
    AppMethodBeat.o(280477);
  }
  
  public final int getLayoutId()
  {
    return b.g._feed_header_private_msg_notify_item;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderPrivateMsgNotifyConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class b<T>
    implements s<h.a>
  {
    b(ca paramca) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "username", "", "kotlin.jvm.PlatformType", "succ", "", "getContactCallBack", "com/tencent/mm/plugin/finder/convert/FinderPrivateMsgNotifyConvert$onBindViewHolder$1$1"})
  static final class c
    implements az.b.a
  {
    c(String paramString, i parami, com.tencent.mm.plugin.finder.extension.reddot.l paraml, bkn parambkn) {}
    
    public final void s(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(286292);
      Log.i("Finder.PrivateMsgNotifyConvert", "[getNow] username=" + paramString + " succ=" + paramBoolean);
      com.tencent.mm.ui.h.a.a.d((ImageView)parami.RD(b.f.msg_avatar), this.qbm);
      AppMethodBeat.o(286292);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderPrivateMsgNotifyConvert$onBindViewHolder$1$2"})
  static final class d
    implements View.OnClickListener
  {
    d(i parami, com.tencent.mm.plugin.finder.extension.reddot.l paraml, bkn parambkn) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(278596);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderPrivateMsgNotifyConvert$onBindViewHolder$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      bkn localbkn;
      if ((locall != null) && (parambm != null))
      {
        paramView = com.tencent.mm.plugin.finder.report.l.zWx;
        localObject = locall;
        localbkn = parambm;
        paramView = aj.Bnu;
        paramView = this.xhb.getContext();
        p.j(paramView, "holder.context");
        paramView = aj.a.fZ(paramView);
        if (paramView == null) {
          break label149;
        }
      }
      label149:
      for (paramView = paramView.ekY();; paramView = null)
      {
        com.tencent.mm.plugin.finder.report.l.a("7", (com.tencent.mm.plugin.finder.extension.reddot.l)localObject, localbkn, 2, paramView, 0, 0, null, 224);
        paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
        paramView = this.xhb.getContext();
        p.j(paramView, "holder.context");
        com.tencent.mm.plugin.finder.utils.a.fN(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderPrivateMsgNotifyConvert$onBindViewHolder$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(278596);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ca
 * JD-Core Version:    0.7.0.1
 */