package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.live.core.core.d.b.a;
import com.tencent.mm.plugin.finder.live.h;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.widget.l.a;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.report.live.s.au;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.protocal.protobuf.det;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.neattextview.textview.view.NeatTextView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingBubblePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "entranceRoot", "Landroid/view/ViewGroup;", "shoppingWidgetRoot", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "shoppingWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingWidget;", "adjustBubbleLayout", "", "canClearScreen", "", "onPortraitDelayAction", "extraMsg", "Landroid/os/Bundle;", "delayMs", "", "onShoppingBubbleClick", "onShoppingBubbleClickImpl", "setVisible", "visible", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Companion", "plugin-finder_release"})
public final class bd
  extends d
{
  private static final String utD = "PORTRAIT_ACTION_BUBBLE_CLICK";
  public static final a utE;
  private final String TAG;
  private final com.tencent.mm.live.c.b hOp;
  public final com.tencent.mm.plugin.finder.live.widget.l utB;
  private final ViewGroup utC;
  
  static
  {
    AppMethodBeat.i(246979);
    utE = new a((byte)0);
    utD = "PORTRAIT_ACTION_BUBBLE_CLICK";
    AppMethodBeat.o(246979);
  }
  
  public bd(ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup2, paramb);
    AppMethodBeat.i(246978);
    this.utC = paramViewGroup2;
    this.hOp = paramb;
    this.TAG = "Finder.LiveShoppingBubblePlugin";
    paramViewGroup2 = paramViewGroup1.getContext();
    p.g(paramViewGroup2, "entranceRoot.context");
    this.utB = new com.tencent.mm.plugin.finder.live.widget.l(paramViewGroup2, paramViewGroup1, this.utC, this.hOp);
    this.utB.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(246970);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingBubblePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        bd.d(this.utF);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingBubblePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(246970);
      }
    });
    AppMethodBeat.o(246978);
  }
  
  private final void dhL()
  {
    Object localObject2 = null;
    AppMethodBeat.i(246974);
    Object localObject1 = com.tencent.mm.live.core.core.d.b.hCo;
    if (b.a.aDp())
    {
      Object localObject3 = this.TAG;
      Object localObject4 = new StringBuilder("shopping bubble click, productId:");
      localObject1 = getLiveData();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).uEm;
        if (localObject1 != null)
        {
          localObject1 = Long.valueOf(((axg)localObject1).uko);
          localObject4 = ((StringBuilder)localObject4).append(localObject1).append(",buy appId:");
          localObject1 = getLiveData();
          if (localObject1 == null) {
            break label318;
          }
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).uEm;
          if (localObject1 == null) {
            break label318;
          }
          localObject1 = ((axg)localObject1).LHN;
          if (localObject1 == null) {
            break label318;
          }
          localObject1 = ((det)localObject1).appId;
          label106:
          localObject4 = ((StringBuilder)localObject4).append((String)localObject1).append(',').append("buy path:");
          localObject1 = getLiveData();
          if (localObject1 == null) {
            break label323;
          }
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).uEm;
          if (localObject1 == null) {
            break label323;
          }
          localObject1 = ((axg)localObject1).LHN;
          if (localObject1 == null) {
            break label323;
          }
          localObject1 = ((det)localObject1).path;
          label156:
          localObject4 = ((StringBuilder)localObject4).append((String)localObject1).append(",detail appId:");
          localObject1 = getLiveData();
          if (localObject1 == null) {
            break label328;
          }
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).uEm;
          if (localObject1 == null) {
            break label328;
          }
          localObject1 = ((axg)localObject1).LHI;
          if (localObject1 == null) {
            break label328;
          }
          localObject1 = ((det)localObject1).appId;
          label201:
          localObject4 = ((StringBuilder)localObject4).append((String)localObject1).append(" detail path:");
          localObject1 = getLiveData();
          if (localObject1 == null) {
            break label333;
          }
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).uEm;
          if (localObject1 == null) {
            break label333;
          }
          localObject1 = ((axg)localObject1).LHI;
          if (localObject1 == null) {
            break label333;
          }
        }
      }
      label318:
      label323:
      label328:
      label333:
      for (localObject1 = ((det)localObject1).path;; localObject1 = null)
      {
        Log.i((String)localObject3, (String)localObject1);
        localObject1 = com.tencent.mm.plugin.finder.live.g.ufT;
        localObject3 = getLiveData();
        localObject4 = getLiveData();
        localObject1 = localObject2;
        if (localObject4 != null) {
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject4).uEm;
        }
        com.tencent.mm.plugin.finder.live.g.c((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3, (axg)localObject1, (kotlin.g.a.m)new c(this));
        AppMethodBeat.o(246974);
        return;
        localObject1 = null;
        break;
        localObject1 = null;
        break label106;
        localObject1 = null;
        break label156;
        localObject1 = null;
        break label201;
      }
    }
    localObject1 = new Bundle();
    localObject2 = getLiveData();
    if (localObject2 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject2).uEm;
      if (localObject2 == null) {}
    }
    for (long l = ((axg)localObject2).uko;; l = 0L)
    {
      ((Bundle)localObject1).putLong("PARAM_FINDER_LIVE_BUBBLE_PRODUCTID", l);
      this.hOp.statusChange(b.c.hMZ, (Bundle)localObject1);
      AppMethodBeat.o(246974);
      return;
    }
  }
  
  public final void a(Bundle paramBundle, final long paramLong)
  {
    AppMethodBeat.i(246977);
    if (paramBundle != null)
    {
      String str = paramBundle.getString("POST_PORTRAIT_ACTION", "");
      paramBundle = str;
      if (str != null) {}
    }
    else
    {
      paramBundle = "";
    }
    if (p.j(paramBundle, utD)) {
      com.tencent.mm.ac.d.a(paramLong, (Runnable)new b(this, paramLong));
    }
    AppMethodBeat.o(246977);
  }
  
  public final boolean dgK()
  {
    return true;
  }
  
  public final void rg(int paramInt)
  {
    AppMethodBeat.i(246976);
    if ((!getLiveData().isLiveStarted()) && (paramInt == 0))
    {
      Object localObject = o.ujN;
      localObject = o.getFinderLiveAssistant();
      if (localObject != null)
      {
        ((s)localObject).ag((View)this.utC, paramInt);
        AppMethodBeat.o(246976);
        return;
      }
      AppMethodBeat.o(246976);
      return;
    }
    super.rg(paramInt);
    AppMethodBeat.o(246976);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(246975);
    p.h(paramc, "status");
    switch (be.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(246975);
      return;
    }
    com.tencent.mm.plugin.finder.live.widget.l locall = this.utB;
    paramBundle = getLiveData();
    if (paramBundle != null)
    {
      paramc = paramBundle.uEm;
      label67:
      if (paramc == null) {
        break label307;
      }
      locall.liveData = paramBundle;
      if (paramBundle == null) {
        break label309;
      }
      paramc = paramBundle.uEm;
      label86:
      localObject1 = locall.TAG;
      localObject2 = new StringBuilder("update shopping bubble,platformName:");
      if (paramc == null) {
        break label314;
      }
      paramBundle = paramc.LHM;
      label113:
      localObject2 = ((StringBuilder)localObject2).append(paramBundle).append(", productId:");
      if (paramc == null) {
        break label319;
      }
      paramBundle = Long.valueOf(paramc.uko);
      label139:
      localObject2 = ((StringBuilder)localObject2).append(paramBundle).append(", currentId:");
      if (paramc == null) {
        break label324;
      }
      paramBundle = Long.valueOf(paramc.uko);
      label165:
      localObject2 = ((StringBuilder)localObject2).append(paramBundle).append(", promoting:");
      if (paramc == null) {
        break label329;
      }
      paramBundle = Integer.valueOf(paramc.LHK);
      label191:
      localObject2 = ((StringBuilder)localObject2).append(paramBundle).append(",platformId:");
      if (paramc == null) {
        break label334;
      }
    }
    label307:
    label309:
    label314:
    label319:
    label324:
    label329:
    label334:
    for (paramBundle = Integer.valueOf(paramc.LHO);; paramBundle = null)
    {
      Log.i((String)localObject1, paramBundle + '!');
      if (paramc == null) {
        break;
      }
      if (paramc.LHK != 1) {
        break label799;
      }
      if ((paramc.uko != 0L) && (!Util.isNullOrNil(paramc.twt))) {
        break label339;
      }
      if (locall.hOp.getLiveRole() != 0) {
        break label835;
      }
      paramBundle = com.tencent.mm.plugin.finder.report.live.m.vli;
      com.tencent.mm.plugin.finder.report.live.m.a(s.au.vrQ, null, String.valueOf(paramc.uko));
      AppMethodBeat.o(246975);
      return;
      paramc = null;
      break label67;
      break;
      paramc = null;
      break label86;
      paramBundle = null;
      break label113;
      paramBundle = null;
      break label139;
      paramBundle = null;
      break label165;
      paramBundle = null;
      break label191;
    }
    label339:
    paramBundle = com.tencent.mm.plugin.finder.loader.m.uJa;
    paramBundle = com.tencent.mm.plugin.finder.loader.m.dkb();
    Object localObject1 = new com.tencent.mm.plugin.finder.loader.a(paramc.twt);
    Object localObject2 = locall.uBJ;
    Object localObject3 = com.tencent.mm.plugin.finder.loader.m.uJa;
    paramBundle.a(localObject1, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJg));
    if (paramc.LHK == 1)
    {
      locall.uHj.setVisibility(0);
      locall.uHk.setVisibility(0);
    }
    for (;;)
    {
      paramBundle = com.tencent.mm.plugin.finder.utils.m.vVH;
      if (!com.tencent.mm.plugin.finder.utils.m.dBP()) {
        break label645;
      }
      locall.uhh.setVisibility(8);
      locall.uHl.aw((CharSequence)"");
      locall.uBN.setText((CharSequence)"");
      locall.uHm.setVisibility(8);
      locall.nE(true);
      h.ufY.a(locall.liveData);
      locall.uHq.postDelayed((Runnable)new l.a(locall), 300L);
      Log.i(locall.TAG, "showShoppingBubbleAnim，parent visibility:" + locall.parent.getVisibility());
      if (locall.getVisibility() == 0) {
        break;
      }
      locall.setVisibility(0);
      if (locall.uHn == null) {
        locall.uHn = ObjectAnimator.ofFloat(locall.parent, "alpha", new float[] { 0.0F, 1.0F });
      }
      paramBundle = locall.uHn;
      if (paramBundle != null) {
        paramBundle.cancel();
      }
      paramBundle = locall.uHn;
      if (paramBundle == null) {
        break;
      }
      paramBundle.start();
      break;
      locall.uHj.setVisibility(8);
      locall.uHk.setVisibility(8);
    }
    label645:
    locall.uhh.setVisibility(0);
    localObject3 = locall.uHl;
    localObject1 = paramc.LHM;
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = "";
    }
    localObject2 = paramc.title;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    com.tencent.mm.plugin.finder.live.widget.l.a((NeatTextView)localObject3, paramBundle, (String)localObject1);
    if ((paramc.AZr >= 0) && (paramc.AZq >= paramc.AZr))
    {
      paramBundle = locall.uBN;
      localObject1 = y.vXH;
      paramBundle.setText((CharSequence)y.LS(paramc.AZr));
    }
    for (;;)
    {
      locall.uHm.setVisibility(0);
      break;
      Log.i(locall.TAG, "invalid price,min:" + paramc.AZr + ",max:" + paramc.AZq);
    }
    label799:
    locall.djM();
    if (locall.hOp.getLiveRole() == 0)
    {
      paramBundle = com.tencent.mm.plugin.finder.report.live.m.vli;
      com.tencent.mm.plugin.finder.report.live.m.a(s.au.vrY, null, String.valueOf(paramc.uko));
    }
    label835:
    AppMethodBeat.o(246975);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingBubblePlugin$Companion;", "", "()V", "PORTRAIT_ACTION_BUBBLE_CLICK", "", "getPORTRAIT_ACTION_BUBBLE_CLICK", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(bd parambd, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(246972);
      if (!this.utF.isFinished())
      {
        bd.b(this.utF);
        AppMethodBeat.o(246972);
        return;
      }
      Log.i(bd.c(this.utF), "onShoppingBubbleClickImpl delayMs:" + paramLong + ",isFinished!");
      AppMethodBeat.o(246972);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "gotoHalfScreen", "", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.m<Boolean, com.tencent.mm.plugin.appbrand.api.g, x>
  {
    c(bd parambd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bd
 * JD-Core Version:    0.7.0.1
 */