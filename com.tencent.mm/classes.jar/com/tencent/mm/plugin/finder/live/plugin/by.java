package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.finder.live.cgi.n;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.report.q.bx;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.q;
import com.tencent.mm.plugin.finder.live.widget.FinderLiveShoppingCouponView;
import com.tencent.mm.plugin.finder.live.widget.az;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.aka;
import com.tencent.mm.protocal.protobuf.bhx;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bla;
import com.tencent.mm.protocal.protobuf.bzc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingBubblePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/IFinderLivePromoteItem;", "entranceRoot", "Landroid/view/ViewGroup;", "shoppingWidgetRoot", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "pollingItem", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "shoppingWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingBubbleWidget;", "getShoppingWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingBubbleWidget;", "shoppingWidget$delegate", "Lkotlin/Lazy;", "afterAddAnim", "", "canClearScreen", "", "checkSyncCouponOrGoods", "start", "getView", "Landroid/view/View;", "initView", "data", "", "jumpShoppingBubble", "productItem", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowShelfProductItem;", "onBubbleDel", "onPortraitDelayAction", "extraMsg", "Landroid/os/Bundle;", "extraData", "delayMs", "", "onShoppingBubbleClick", "onShoppingBubbleClickImpl", "setBubbleUIConfig", "config", "Lcom/tencent/mm/plugin/finder/model/FinderLiveShoppingUIConfig;", "setVisible", "visible", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "updateBubbleLayout", "updateCouponBubble", "newCouponItem", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowCouponItem;", "updateGoodsBubble", "newGoodsItem", "updateView", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class by
  extends b
  implements cx
{
  public static final by.a DiZ;
  private final ViewGroup Dja;
  public cc Djb;
  private final kotlin.j Djc;
  public final String TAG;
  private final com.tencent.mm.live.b.b nfT;
  
  static
  {
    AppMethodBeat.i(354236);
    DiZ = new by.a((byte)0);
    AppMethodBeat.o(354236);
  }
  
  public by(ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup2, paramb);
    AppMethodBeat.i(354140);
    this.Dja = paramViewGroup2;
    this.nfT = paramb;
    this.TAG = "Finder.LiveShoppingBubblePlugin";
    this.Djc = kotlin.k.cm((kotlin.g.a.a)new d(paramViewGroup1, this));
    erU().setOnClickListener(new by..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(354140);
  }
  
  private static final ah a(cc paramcc, by paramby, b.a parama)
  {
    AppMethodBeat.i(354197);
    s.u(paramby, "this$0");
    if (paramcc == null)
    {
      paramcc = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.view.convert.ShopWindowShelfProductItem");
      AppMethodBeat.o(354197);
      throw paramcc;
    }
    com.tencent.mm.plugin.finder.live.view.convert.k localk = (com.tencent.mm.plugin.finder.live.view.convert.k)paramcc;
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      Object localObject = ((bhx)parama.ott).ZRc;
      if (localObject != null)
      {
        parama = new bzc();
        paramcc = (com.tencent.mm.bx.a)parama;
        localObject = ((com.tencent.mm.bx.b)localObject).toByteArray();
        try
        {
          paramcc.parseFrom((byte[])localObject);
          paramcc = parama.request_id;
          if (paramcc != null)
          {
            if (((CharSequence)paramcc).length() <= 0) {
              break label231;
            }
            i = 1;
            if (i == 0) {
              break label236;
            }
            if (paramcc != null) {
              ((e)paramby.business(e.class)).ayl(paramcc);
            }
          }
          paramcc = ah.aiuX;
          s.u(parama, "<set-?>");
          localk.DVj = parama;
          if ((((q)paramby.business(q.class)).Eie instanceof com.tencent.mm.plugin.finder.live.view.convert.k))
          {
            paramcc = ((q)paramby.business(q.class)).Eie;
            if (paramcc == null)
            {
              paramcc = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.view.convert.ShopWindowShelfProductItem");
              AppMethodBeat.o(354197);
              throw paramcc;
            }
          }
        }
        catch (Exception paramcc)
        {
          for (;;)
          {
            Log.printDebugStack("safeParser", "", new Object[] { paramcc });
            continue;
            label231:
            int i = 0;
            continue;
            label236:
            paramcc = null;
          }
          if (((com.tencent.mm.plugin.finder.live.view.convert.k)paramcc).DVk == parama.DVk) {
            ((q)paramby.business(q.class)).d((cc)localk);
          }
        }
      }
    }
    paramby.a(localk);
    paramcc = ah.aiuX;
    AppMethodBeat.o(354197);
    return paramcc;
  }
  
  private static final void a(by paramby, long paramLong)
  {
    AppMethodBeat.i(354203);
    s.u(paramby, "this$0");
    if (!paramby.isFinished())
    {
      paramby.erW();
      AppMethodBeat.o(354203);
      return;
    }
    Log.i(paramby.TAG, "onShoppingBubbleClickImpl delayMs:" + paramLong + ",isFinished!");
    AppMethodBeat.o(354203);
  }
  
  private static final void a(by paramby, View paramView)
  {
    AppMethodBeat.i(354185);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramby);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingBubblePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramby, "this$0");
    paramby.erV();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingBubblePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(354185);
  }
  
  private final void a(final com.tencent.mm.plugin.finder.live.view.convert.k paramk)
  {
    Object localObject2 = null;
    AppMethodBeat.i(354176);
    final bzc localbzc = paramk.DVj;
    Object localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if ((com.tencent.mm.plugin.finder.live.utils.a.bUx()) || (((e)business(e.class)).DUe))
    {
      paramk = new Bundle();
      paramk.putLong("PARAM_FINDER_LIVE_BUBBLE_PRODUCTID", localbzc.DVk);
      this.nfT.statusChange(b.c.ndB, paramk);
      AppMethodBeat.o(354176);
      return;
    }
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("shopping bubble click, productId:").append(localbzc.DVk).append(",buy appId:");
    localObject1 = localbzc.DVp;
    if (localObject1 == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(",buy path:");
      localObject1 = localbzc.DVp;
      if (localObject1 != null) {
        break label256;
      }
      localObject1 = null;
      label149:
      localStringBuilder = localStringBuilder.append(localObject1).append(",detail appId:");
      localObject1 = localbzc.DVq;
      if (localObject1 != null) {
        break label264;
      }
      localObject1 = null;
      label175:
      localStringBuilder = localStringBuilder.append(localObject1).append(" detail path:");
      localObject1 = localbzc.DVq;
      if (localObject1 != null) {
        break label272;
      }
    }
    label256:
    label264:
    label272:
    for (localObject1 = localObject2;; localObject1 = ((aka)localObject1).path)
    {
      Log.i(str, localObject1);
      localObject1 = com.tencent.mm.plugin.finder.live.k.Bxu;
      com.tencent.mm.plugin.finder.live.k.c(getBuContext(), paramk, (m)new c(this, localbzc, paramk));
      AppMethodBeat.o(354176);
      return;
      localObject1 = ((aka)localObject1).appid;
      break;
      localObject1 = ((aka)localObject1).path;
      break label149;
      localObject1 = ((aka)localObject1).appid;
      break label175;
    }
  }
  
  private final void erV()
  {
    AppMethodBeat.i(354150);
    boolean bool = isLandscape();
    Log.i(this.TAG, s.X("onShoppingBubbleClick isLandscape:", Boolean.valueOf(bool)));
    if (bool)
    {
      b.a((b)this, "PORTRAIT_ACTION_BUBBLE_CLICK", null, 0, 6);
      AppMethodBeat.o(354150);
      return;
    }
    erW();
    AppMethodBeat.o(354150);
  }
  
  private final void erW()
  {
    AppMethodBeat.i(354165);
    cc localcc = ((q)business(q.class)).Eie;
    Object localObject1 = (com.tencent.mm.plugin.finder.live.view.a)this.nfT;
    Object localObject2;
    if ((localcc instanceof com.tencent.mm.plugin.finder.live.view.convert.k))
    {
      localObject2 = com.tencent.mm.plugin.finder.live.component.statecomponent.b.CCd;
      com.tencent.mm.plugin.finder.live.component.statecomponent.b.a(getBuContext(), 5, 5);
      Log.i(this.TAG, s.X("[onShoppingBubbleClickImpl] needJump:", Boolean.valueOf(((com.tencent.mm.plugin.finder.live.view.convert.k)localcc).hPp)));
      if (((com.tencent.mm.plugin.finder.live.view.convert.k)localcc).hPp)
      {
        localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.view.a)localObject1).getBuContext().business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
        if (localObject1 != null)
        {
          long l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).hKN;
          long l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).liveInfo.liveId;
          localObject1 = ((com.tencent.mm.plugin.finder.live.view.convert.k)localcc).DUN;
          localObject2 = new com.tencent.mm.bx.b(((com.tencent.mm.plugin.finder.live.view.convert.k)localcc).DVj.toByteArray());
          com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          new n(l1, l2, 5, (String)localObject1, (com.tencent.mm.bx.b)localObject2, com.tencent.mm.plugin.finder.live.utils.a.a(getBuContext(), null), ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).sessionBuffer).bFJ().g(new by..ExternalSyntheticLambda1(localcc, this));
          AppMethodBeat.o(354165);
        }
      }
      else
      {
        a((com.tencent.mm.plugin.finder.live.view.convert.k)localcc);
        AppMethodBeat.o(354165);
      }
    }
    else if (((localcc instanceof com.tencent.mm.plugin.finder.live.view.convert.j)) && (((com.tencent.mm.plugin.finder.live.view.convert.j)localcc).DVe) && (this.nfT.getLiveRole() == 0))
    {
      localObject1 = erU();
      localObject2 = this.mJe.getContext();
      s.s(localObject2, "root.context");
      ((az)localObject1).a((Context)localObject2, (com.tencent.mm.plugin.finder.live.view.convert.j)localcc);
    }
    AppMethodBeat.o(354165);
  }
  
  public final void a(Bundle paramBundle, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(354339);
    if (paramBundle == null) {
      paramBundle = "";
    }
    for (;;)
    {
      if (s.p(paramBundle, "PORTRAIT_ACTION_BUBBLE_CLICK")) {
        com.tencent.mm.ae.d.a(paramLong, new by..ExternalSyntheticLambda2(this, paramLong));
      }
      AppMethodBeat.o(354339);
      return;
      paramObject = paramBundle.getString("ACTION_POST_PORTRAIT", "");
      paramBundle = paramObject;
      if (paramObject == null) {
        paramBundle = "";
      }
    }
  }
  
  public final boolean eoI()
  {
    return true;
  }
  
  public final void eoK()
  {
    AppMethodBeat.i(354347);
    Object localObject = aj.CGT;
    localObject = aj.elk();
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.view.a)localObject).unregisterPlugin(by.class);
    }
    AppMethodBeat.o(354347);
  }
  
  public final void eoL()
  {
    AppMethodBeat.i(354356);
    erX();
    AppMethodBeat.o(354356);
  }
  
  public final az erU()
  {
    AppMethodBeat.i(354267);
    az localaz = (az)this.Djc.getValue();
    AppMethodBeat.o(354267);
    return localaz;
  }
  
  public final void erX()
  {
    AppMethodBeat.i(354277);
    if (this.mJe.getVisibility() == 0) {
      erU().erX();
    }
    AppMethodBeat.o(354277);
  }
  
  public final void fs(Object paramObject)
  {
    AppMethodBeat.i(354305);
    s.u(paramObject, "data");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e(paramObject, this));
    AppMethodBeat.o(354305);
  }
  
  public final void ft(Object paramObject)
  {
    AppMethodBeat.i(354321);
    s.u(paramObject, "data");
    az localaz = erU();
    Object localObject1 = getBuContext();
    s.u(paramObject, "data");
    localaz.CvU = ((com.tencent.mm.plugin.finder.live.model.context.a)localObject1);
    Object localObject2;
    if ((paramObject instanceof com.tencent.mm.plugin.finder.live.view.convert.k))
    {
      Log.i(localaz.TAG, "update shopping bubble, productId:" + ((com.tencent.mm.plugin.finder.live.view.convert.k)paramObject).DVk + ", promoting:" + ((com.tencent.mm.plugin.finder.live.view.convert.k)paramObject).DVr + ", platformName:" + ((com.tencent.mm.plugin.finder.live.view.convert.k)paramObject).DUT + ",platformId:" + ((com.tencent.mm.plugin.finder.live.view.convert.k)paramObject).DVs + ",seq:" + ((com.tencent.mm.plugin.finder.live.view.convert.k)paramObject).DVt + '!');
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.live.component.statecomponent.b.CCd;
        com.tencent.mm.plugin.finder.live.component.statecomponent.b.a((com.tencent.mm.plugin.finder.live.model.context.a)localObject1, 1, 5);
      }
      az.a(localaz, ((com.tencent.mm.plugin.finder.live.view.convert.k)paramObject).DVj, false, 6);
      if ((localaz.nfT.getLiveRole() == 0) && (localaz.parent.getVisibility() == 0))
      {
        com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, q.bx.DDF, null, String.valueOf(((com.tencent.mm.plugin.finder.live.view.convert.k)paramObject).DVk));
        AppMethodBeat.o(354321);
      }
    }
    else if ((paramObject instanceof com.tencent.mm.plugin.finder.live.view.convert.j))
    {
      Log.i(localaz.TAG, "update shopping bubble," + ((com.tencent.mm.plugin.finder.live.view.convert.j)paramObject).mdN + ", productId:" + ((com.tencent.mm.plugin.finder.live.view.convert.j)paramObject).title + ", sending:" + ((com.tencent.mm.plugin.finder.live.view.convert.j)paramObject).DVc);
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.live.component.statecomponent.b.CCd;
        com.tencent.mm.plugin.finder.live.component.statecomponent.b.a((com.tencent.mm.plugin.finder.live.model.context.a)localObject1, 1, 6);
      }
      paramObject = (com.tencent.mm.plugin.finder.live.view.convert.j)paramObject;
      boolean bool = localaz.eqc();
      localObject1 = localaz.DUd;
      if (localObject1 != null)
      {
        ((FinderLiveShoppingCouponView)localObject1).a(paramObject, bool, false);
        localObject1 = ((FinderLiveShoppingCouponView)localObject1).getLayoutParams();
        localObject2 = localaz.getContext();
        if (!bool) {
          break label444;
        }
      }
    }
    label444:
    for (int i = p.c.Bzn;; i = p.c.Bzo)
    {
      ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cd.a.bs((Context)localObject2, i);
      localObject1 = localaz.nnX;
      if (localObject1 != null) {
        ((ImageView)localObject1).setColorFilter((ColorFilter)new PorterDuffColorFilter(com.tencent.mm.cd.a.w(localaz.getContext(), p.b.UN_BW_97), PorterDuff.Mode.SRC_ATOP));
      }
      localaz.setupCouponView(true);
      localaz.pd(paramObject.bZA());
      AppMethodBeat.o(354321);
      return;
    }
  }
  
  public final View getView()
  {
    return (View)this.Dja;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(354289);
    s.u(paramc, "status");
    b.c localc;
    Bundle localBundle;
    if (b.$EnumSwitchMapping$0[paramc.ordinal()] == 1)
    {
      paramc = ((q)getBuContext().business(q.class)).Eie;
      if ((paramc instanceof com.tencent.mm.plugin.finder.live.view.convert.j))
      {
        paramc = (com.tencent.mm.plugin.finder.live.view.convert.j)paramc;
        s.u(paramc, "newCouponItem");
        Log.i(this.TAG, s.X("[updateCouponBubble] ", paramc));
        paramBundle = this.nfT;
        localc = b.c.ndP;
        localBundle = new Bundle();
        com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        paramc = com.tencent.mm.plugin.finder.live.utils.a.c((cc)paramc);
        if (paramc != null) {
          break label141;
        }
      }
    }
    label141:
    for (paramc = null;; paramc = paramc.toByteArray())
    {
      localBundle.putByteArray("PARAM_FINDER_LIVE_PROMOTE_DATA", paramc);
      paramc = ah.aiuX;
      paramBundle.statusChange(localc, localBundle);
      AppMethodBeat.o(354289);
      return;
    }
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(354298);
    if (((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu())
    {
      this.mJe.setVisibility(8);
      Log.w(this.TAG, "setVisible return for isTeenMode");
      AppMethodBeat.o(354298);
      return;
    }
    if ((!((e)business(e.class)).isLiveStarted()) && (paramInt == 0))
    {
      Object localObject = aj.CGT;
      localObject = aj.getFinderLiveAssistant();
      if (localObject != null)
      {
        ((ap)localObject).at((View)this.Dja, paramInt);
        AppMethodBeat.o(354298);
      }
    }
    else
    {
      super.tO(paramInt);
    }
    AppMethodBeat.o(354298);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements m<Boolean, g, ah>
  {
    c(by paramby, bzc parambzc, com.tencent.mm.plugin.finder.live.view.convert.k paramk)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingBubbleWidget;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<az>
  {
    d(ViewGroup paramViewGroup, by paramby)
    {
      super();
    }
    
    private static final void b(by paramby, View paramView)
    {
      AppMethodBeat.i(353397);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramby);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingBubblePlugin$shoppingWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramby, "this$0");
      by.e(paramby);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingBubblePlugin$shoppingWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(353397);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(Object paramObject, by paramby)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.by
 * JD-Core Version:    0.7.0.1
 */