package com.tencent.mm.plugin.finder.order.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.alr;
import com.tencent.mm.protocal.protobuf.fcy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/order/ui/OrderConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/order/data/OrderFeed;", "()V", "TAG", "", "bindDeliveryInfo", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "bindFinderInfo", "bindHeader", "bindPrice", "bindSkuList", "getLayoutId", "", "onBindViewHolder", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.view.recyclerview.f<com.tencent.mm.plugin.finder.order.data.a>
{
  private final String TAG = "Finder.OrderConvert";
  
  private final void a(j paramj, final com.tencent.mm.plugin.finder.order.data.a parama)
  {
    AppMethodBeat.i(332400);
    Object localObject1 = (WxRecyclerView)paramj.UH(p.e.BYX);
    paramj = ((WxRecyclerView)localObject1).getAdapter();
    if (paramj == null)
    {
      paramj = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.RVFeed>");
      AppMethodBeat.o(332400);
      throw paramj;
    }
    paramj = (WxRecyclerAdapter)paramj;
    Object localObject2 = (Collection)parama.ESs;
    if ((localObject2 == null) || (((Collection)localObject2).isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      ((WxRecyclerView)localObject1).setVisibility(8);
      ((List)paramj.data).clear();
      paramj.bZE.notifyChanged();
      AppMethodBeat.o(332400);
      return;
    }
    ((WxRecyclerView)localObject1).setVisibility(0);
    ((List)paramj.data).clear();
    localObject1 = new ArrayList();
    localObject2 = parama.ESs;
    s.s(localObject2, "item.skuList");
    localObject2 = ((Iterable)localObject2).iterator();
    i = 0;
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      int j = i + 1;
      if (i < 0) {
        p.kkW();
      }
      localObject3 = (fcy)localObject3;
      if (localObject3 == null)
      {
        Log.i(this.TAG, "skulist, index:" + i + " is Null");
        i = j;
      }
      else
      {
        ((ArrayList)localObject1).add(new com.tencent.mm.plugin.finder.order.data.f((fcy)localObject3, parama.ESl.YBi));
        i = j;
      }
    }
    if ((((ArrayList)localObject1).size() > 3) && (!parama.pvv))
    {
      localObject2 = (List)paramj.data;
      localObject3 = ((ArrayList)localObject1).subList(0, 3);
      s.s(localObject3, "dataList.subList(0, 3)");
      ((List)localObject2).addAll((Collection)localObject3);
      ((List)paramj.data).add(new com.tencent.mm.plugin.finder.order.data.e(((ArrayList)localObject1).size() - 3, (kotlin.g.a.a)new a(paramj, (ArrayList)localObject1, parama)));
      AppMethodBeat.o(332400);
      return;
    }
    ((List)paramj.data).addAll((Collection)localObject1);
    paramj.bZE.notifyChanged();
    AppMethodBeat.o(332400);
  }
  
  private static final void a(j paramj, com.tencent.mm.plugin.finder.order.data.a parama, View paramView)
  {
    AppMethodBeat.i(332412);
    Object localObject1 = new Object();
    Object localObject2 = new b();
    ((b)localObject2).cH(paramj);
    ((b)localObject2).cH(parama);
    ((b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/order/ui/OrderConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((b)localObject2).aYj());
    s.u(paramj, "$holder");
    s.u(parama, "$item");
    paramView = k.aeZF;
    paramView = paramj.context;
    s.s(paramView, "holder.context");
    localObject2 = (com.tencent.mm.plugin.finder.order.report.a)k.nq(paramView).q(com.tencent.mm.plugin.finder.order.report.a.class);
    r localr1 = new r("finderuin", parama.finderUsername);
    r localr2 = new r("current_page", "order_list");
    localObject1 = parama.ESl.YBi;
    paramView = (View)localObject1;
    if (localObject1 == null) {
      paramView = "";
    }
    ((com.tencent.mm.plugin.finder.order.report.a)localObject2).w("enter_finder_profile", ak.e(new r[] { localr1, localr2, new r("order_id", paramView) }));
    if (((CharSequence)parama.finderUsername).length() == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramView = new Intent();
        paramView.putExtra("finder_username", parama.finderUsername);
        parama = (com.tencent.mm.plugin.f)h.ax(com.tencent.mm.plugin.f.class);
        paramj = paramj.context;
        s.s(paramj, "holder.context");
        parama.enterFinderProfileUI(paramj, paramView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/order/ui/OrderConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(332412);
      return;
    }
  }
  
  private static final void a(j paramj, com.tencent.mm.plugin.finder.order.data.a parama, a parama1, View paramView)
  {
    AppMethodBeat.i(332419);
    Object localObject1 = new Object();
    Object localObject2 = new b();
    ((b)localObject2).cH(paramj);
    ((b)localObject2).cH(parama);
    ((b)localObject2).cH(parama1);
    ((b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/order/ui/OrderConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((b)localObject2).aYj());
    s.u(paramj, "$holder");
    s.u(parama, "$item");
    s.u(parama1, "this$0");
    paramView = k.aeZF;
    paramView = paramj.context;
    s.s(paramView, "holder.context");
    localObject2 = (com.tencent.mm.plugin.finder.order.report.a)k.nq(paramView).q(com.tencent.mm.plugin.finder.order.report.a.class);
    r localr1 = new r("shipment_id", parama.ESq);
    r localr2 = new r("current_page", "order_list");
    localObject1 = parama.ESl.YBi;
    paramView = (View)localObject1;
    if (localObject1 == null) {
      paramView = "";
    }
    ((com.tencent.mm.plugin.finder.order.report.a)localObject2).w("enter_shipment_detail", ak.e(new r[] { localr1, localr2, new r("order_id", paramView) }));
    paramView = parama.ESq;
    int i;
    if (((CharSequence)paramView).length() > 0)
    {
      i = 1;
      if (i == 0) {
        break label357;
      }
      Log.i(parama1.TAG, "delivery appid " + paramView + ", path:" + parama.ESr);
      parama1 = new com.tencent.mm.plugin.appbrand.api.g();
      parama1.appId = paramView;
      parama1.qAF = parama.ESr;
      parama1.scene = 1216;
      ((t)h.ax(t.class)).a(paramj.context, parama1);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/order/ui/OrderConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(332419);
      return;
      i = 0;
      break;
      label357:
      Log.i(parama1.TAG, "delivery appid is empty");
    }
  }
  
  private static final void b(j paramj, com.tencent.mm.plugin.finder.order.data.a parama, View paramView)
  {
    AppMethodBeat.i(332431);
    Object localObject1 = new Object();
    Object localObject2 = new b();
    ((b)localObject2).cH(paramj);
    ((b)localObject2).cH(parama);
    ((b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/order/ui/OrderConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((b)localObject2).aYj());
    s.u(paramj, "$holder");
    s.u(parama, "$item");
    paramView = k.aeZF;
    paramView = paramj.context;
    s.s(paramView, "holder.context");
    localObject2 = (com.tencent.mm.plugin.finder.order.report.a)k.nq(paramView).q(com.tencent.mm.plugin.finder.order.report.a.class);
    r localr1 = new r("shop_id", parama.appid);
    r localr2 = new r("current_page", "order_list");
    localObject1 = parama.ESl.YBi;
    paramView = (View)localObject1;
    if (localObject1 == null) {
      paramView = "";
    }
    ((com.tencent.mm.plugin.finder.order.report.a)localObject2).w("enter_shop_detail", ak.e(new r[] { localr1, localr2, new r("order_id", paramView) }));
    int i;
    if (((CharSequence)parama.ESp).length() == 0)
    {
      i = 1;
      if (i == 0) {
        break label305;
      }
      paramView = new com.tencent.mm.plugin.appbrand.api.g();
      paramView.appId = parama.appid;
      paramView.qAF = parama.path;
      paramView.scene = 1216;
      ((t)h.ax(t.class)).a(paramj.context, paramView);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/order/ui/OrderConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(332431);
      return;
      i = 0;
      break;
      label305:
      paramView = new Intent();
      paramView.putExtra("rawUrl", parama.ESp);
      c.b(paramj.context, "webview", ".ui.tools.WebViewUI", paramView);
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(332459);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    WxRecyclerView localWxRecyclerView = (WxRecyclerView)paramj.UH(p.e.BYX);
    paramRecyclerView.getContext();
    localWxRecyclerView.setLayoutManager((RecyclerView.LayoutManager)new OrderConvert.onCreateViewHolder.1());
    paramRecyclerView = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.g)new b(), new ArrayList(), false);
    paramRecyclerView.agOg = true;
    ah localah = ah.aiuX;
    localWxRecyclerView.setAdapter((RecyclerView.a)paramRecyclerView);
    localWxRecyclerView.a((RecyclerView.h)new c());
    localWxRecyclerView.setNestedScrollingEnabled(false);
    paramRecyclerView = (TextView)paramj.UH(p.e.BZJ);
    paramj = aw.Gjk;
    s.s(paramRecyclerView, "priceTv");
    aw.f(paramRecyclerView, false);
    AppMethodBeat.o(332459);
  }
  
  public final int getLayoutId()
  {
    return p.f.CeX;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(WxRecyclerAdapter<cc> paramWxRecyclerAdapter, ArrayList<cc> paramArrayList, com.tencent.mm.plugin.finder.order.data.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/order/ui/OrderConvert$onCreateViewHolder$2", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.view.recyclerview.g
  {
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(332424);
      if (paramInt == com.tencent.mm.plugin.finder.order.data.f.class.hashCode())
      {
        localObject = (com.tencent.mm.view.recyclerview.f)new f();
        AppMethodBeat.o(332424);
        return localObject;
      }
      if (paramInt == com.tencent.mm.plugin.finder.order.data.e.class.hashCode())
      {
        localObject = (com.tencent.mm.view.recyclerview.f)new e();
        AppMethodBeat.o(332424);
        return localObject;
      }
      s.checkNotNull(null);
      Object localObject = new kotlin.f();
      AppMethodBeat.o(332424);
      throw ((Throwable)localObject);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/order/ui/OrderConvert$onCreateViewHolder$4", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(332427);
      s.u(paramRect, "outRect");
      s.u(paramView, "view");
      s.u(paramRecyclerView, "parent");
      s.u(params, "state");
      int i = (int)paramView.getContext().getResources().getDimension(p.c.Edge_2A);
      paramRect.left = 0;
      paramRect.right = 0;
      paramRect.bottom = i;
      paramRect.top = 0;
      AppMethodBeat.o(332427);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.order.ui.a
 * JD-Core Version:    0.7.0.1
 */