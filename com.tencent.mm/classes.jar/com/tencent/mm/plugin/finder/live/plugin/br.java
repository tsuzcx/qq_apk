package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.model.af.c;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.view.convert.e;
import com.tencent.mm.plugin.finder.live.view.convert.f;
import com.tencent.mm.plugin.finder.live.view.convert.g;
import com.tencent.mm.plugin.finder.live.view.convert.h;
import com.tencent.mm.plugin.finder.live.view.convert.i;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.q;
import com.tencent.mm.protocal.protobuf.bkz;
import com.tencent.mm.protocal.protobuf.bnl;
import com.tencent.mm.protocal.protobuf.bnm;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bf;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLivePromoteBubblePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "liveRootView", "Landroid/view/ViewGroup;", "promoteBubbleContainerParent", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "blackList", "", "Ljava/lang/Class;", "bubbleDividerHeight", "", "getBubbleDividerHeight", "()I", "bubbleDividerHeight$delegate", "Lkotlin/Lazy;", "curPromoteItem", "Lcom/tencent/mm/plugin/finder/live/plugin/IFinderLivePromoteItem;", "promoteAnchorBubbleDelToast", "Landroid/view/View;", "promoteAnchorBubbleDelToastText", "Landroid/widget/TextView;", "promoteBubbleContainer", "promoteBubbleContainerScrollView", "Landroid/widget/ScrollView;", "promoteItemTypeList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLivePromoteBubblePlugin$PromoteItemCreator;", "addPromoteBubbleAnim", "", "oldItem", "newItem", "addPromoteData", "promoteData", "", "canClearScreen", "", "checkPromoteDataLegal", "delPromoteData", "findPromoteItem", "hideConfileBubble", "mount", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onPortraitAction", "extraMsg", "Landroid/os/Bundle;", "extraData", "onPortraitDelayAction", "delayMs", "", "startPolling", "data", "Lcom/tencent/mm/plugin/IFinderLivePromoteData;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "stopPolling", "unMount", "updatePromoteData", "PromoteItemCreator", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class br
  extends b
{
  private final ViewGroup DhY;
  private final ViewGroup DhZ;
  private final LinkedList<a> Dia;
  private cx Dib;
  private ViewGroup Dic;
  private ScrollView Did;
  private View Die;
  private TextView Dif;
  private final List<Class<?>> Dig;
  private final kotlin.j Dih;
  private final String TAG;
  private final com.tencent.mm.live.b.b nfT;
  
  public br(ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup2, paramb);
    AppMethodBeat.i(355359);
    this.DhY = paramViewGroup1;
    this.DhZ = paramViewGroup2;
    this.nfT = paramb;
    this.TAG = "FinderLivePromoteBubblePlugin";
    this.Dia = new LinkedList();
    this.Dig = p.listOf(bkz.class);
    this.Dih = kotlin.k.cm((kotlin.g.a.a)new c(this));
    paramViewGroup1 = this.DhZ.findViewById(p.e.BRA);
    s.s(paramViewGroup1, "promoteBubbleContainerPa…e_bubble_container_child)");
    this.Dic = ((ViewGroup)paramViewGroup1);
    paramViewGroup1 = this.DhZ.findViewById(p.e.BRB);
    s.s(paramViewGroup1, "promoteBubbleContainerPa…ble_container_scrollview)");
    this.Did = ((ScrollView)paramViewGroup1);
    paramViewGroup1 = this.DhZ.findViewById(p.e.BRx);
    s.s(paramViewGroup1, "promoteBubbleContainerPa…mote_bubble_anchor_toast)");
    this.Die = paramViewGroup1;
    paramViewGroup1 = this.DhZ.findViewById(p.e.BRy);
    s.s(paramViewGroup1, "promoteBubbleContainerPa…bubble_anchor_toast_text)");
    this.Dif = ((TextView)paramViewGroup1);
    paramViewGroup2 = this.Dif;
    paramViewGroup1 = paramViewGroup2;
    if (paramViewGroup2 == null)
    {
      s.bIx("promoteAnchorBubbleDelToastText");
      paramViewGroup1 = null;
    }
    aw.a((Paint)paramViewGroup1.getPaint(), 0.8F);
    this.Dia.add(new a()
    {
      public final cx erD()
      {
        AppMethodBeat.i(353511);
        Object localObject = br.h(this.Dii).findViewById(p.e.CaW);
        s.s(localObject, "liveRootView.findViewByI…pping_entrance_container)");
        localObject = (ViewGroup)localObject;
        View localView = com.tencent.mm.ui.af.mU(this.Dii.mJe.getContext()).inflate(p.f.Cfy, null);
        if (localView == null)
        {
          localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(353511);
          throw ((Throwable)localObject);
        }
        localObject = (cx)new by((ViewGroup)localObject, (ViewGroup)localView, br.i(this.Dii));
        AppMethodBeat.o(353511);
        return localObject;
      }
      
      public final boolean fv(Object paramAnonymousObject)
      {
        AppMethodBeat.i(353498);
        s.u(paramAnonymousObject, "data");
        if (((paramAnonymousObject instanceof com.tencent.mm.plugin.finder.live.view.convert.k)) || ((paramAnonymousObject instanceof com.tencent.mm.plugin.finder.live.view.convert.j)))
        {
          AppMethodBeat.o(353498);
          return true;
        }
        AppMethodBeat.o(353498);
        return false;
      }
    });
    this.Dia.add(new a()
    {
      public final cx erD()
      {
        AppMethodBeat.i(353553);
        Object localObject = this.Dii.mJe.getContext();
        s.s(localObject, "root.context");
        localObject = (cx)new c((Context)localObject, this.Dii.getBuContext(), br.i(this.Dii));
        AppMethodBeat.o(353553);
        return localObject;
      }
      
      public final boolean fv(Object paramAnonymousObject)
      {
        AppMethodBeat.i(353546);
        s.u(paramAnonymousObject, "data");
        boolean bool = paramAnonymousObject instanceof i;
        AppMethodBeat.o(353546);
        return bool;
      }
    });
    this.Dia.add(new a()
    {
      public final cx erD()
      {
        AppMethodBeat.i(353543);
        Object localObject = this.Dii.mJe.getContext();
        s.s(localObject, "root.context");
        localObject = (cx)new bm((Context)localObject, this.Dii.getBuContext(), br.i(this.Dii));
        AppMethodBeat.o(353543);
        return localObject;
      }
      
      public final boolean fv(Object paramAnonymousObject)
      {
        AppMethodBeat.i(353536);
        s.u(paramAnonymousObject, "data");
        boolean bool = paramAnonymousObject instanceof f;
        AppMethodBeat.o(353536);
        return bool;
      }
    });
    this.Dia.add(new a()
    {
      public final cx erD()
      {
        AppMethodBeat.i(353556);
        Object localObject = this.Dii.mJe.getContext();
        s.s(localObject, "root.context");
        localObject = (cx)new bi((Context)localObject, this.Dii.getBuContext(), br.i(this.Dii));
        AppMethodBeat.o(353556);
        return localObject;
      }
      
      public final boolean fv(Object paramAnonymousObject)
      {
        AppMethodBeat.i(353552);
        s.u(paramAnonymousObject, "data");
        boolean bool = paramAnonymousObject instanceof e;
        AppMethodBeat.o(353552);
        return bool;
      }
    });
    this.Dia.add(new a()
    {
      public final cx erD()
      {
        AppMethodBeat.i(353554);
        Object localObject = this.Dii.mJe.getContext();
        s.s(localObject, "root.context");
        localObject = (cx)new cw((Context)localObject, this.Dii.getBuContext(), br.i(this.Dii));
        AppMethodBeat.o(353554);
        return localObject;
      }
      
      public final boolean fv(Object paramAnonymousObject)
      {
        AppMethodBeat.i(353548);
        s.u(paramAnonymousObject, "data");
        boolean bool = paramAnonymousObject instanceof g;
        AppMethodBeat.o(353548);
        return bool;
      }
    });
    this.Dia.add(new a()
    {
      public final cx erD()
      {
        AppMethodBeat.i(353520);
        Object localObject = this.Dii.mJe.getContext();
        s.s(localObject, "root.context");
        localObject = (cx)new bu((Context)localObject, this.Dii.getBuContext(), br.i(this.Dii));
        AppMethodBeat.o(353520);
        return localObject;
      }
      
      public final boolean fv(Object paramAnonymousObject)
      {
        AppMethodBeat.i(353517);
        s.u(paramAnonymousObject, "data");
        boolean bool = paramAnonymousObject instanceof h;
        AppMethodBeat.o(353517);
        return bool;
      }
    });
    if (!isLandscape())
    {
      paramViewGroup1 = bf.bf(this.DhZ.getContext());
      if (paramViewGroup1.x >= paramViewGroup1.y / 3 * 2)
      {
        paramViewGroup2 = this.DhZ.getLayoutParams();
        paramViewGroup2.width = (paramViewGroup1.x / 2 + (int)this.DhZ.getContext().getResources().getDimension(p.c.Edge_7_5_A));
        this.DhZ.setLayoutParams(paramViewGroup2);
      }
    }
    AppMethodBeat.o(355359);
  }
  
  private static final void a(final View paramView1, View paramView2, br parambr, final cx paramcx)
  {
    AppMethodBeat.i(355402);
    s.u(paramView2, "$newView");
    s.u(parambr, "this$0");
    s.u(paramcx, "$newItem");
    int i = kotlin.k.k.qu(paramView1.getHeight(), paramView2.getHeight());
    paramView2 = parambr.Did;
    if (paramView2 == null)
    {
      s.bIx("promoteBubbleContainerScrollView");
      paramView2 = null;
    }
    for (;;)
    {
      paramView2 = ObjectAnimator.ofInt(paramView2, "scrollY", new int[] { 0, ((Number)parambr.Dih.getValue()).intValue() + i }).setDuration(200L);
      s.s(paramView2, "ofInt(promoteBubbleConta…rHeight).setDuration(200)");
      paramView2.addListener((Animator.AnimatorListener)new b(parambr, paramView1, paramcx));
      paramView2.start();
      AppMethodBeat.o(355402);
      return;
    }
  }
  
  private static final void a(br parambr)
  {
    AppMethodBeat.i(355413);
    s.u(parambr, "this$0");
    View localView = parambr.Die;
    Object localObject = localView;
    if (localView == null)
    {
      s.bIx("promoteAnchorBubbleDelToast");
      localObject = null;
    }
    localObject = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 1.0F, 0.0F }).setDuration(1000L);
    s.s(localObject, "ofFloat(promoteAnchorBub…1f, 0f).setDuration(1000)");
    ((ObjectAnimator)localObject).addListener((Animator.AnimatorListener)new d(parambr));
    ((ObjectAnimator)localObject).start();
    AppMethodBeat.o(355413);
  }
  
  private static final void a(br parambr, Bundle paramBundle, Object paramObject)
  {
    AppMethodBeat.i(355425);
    s.u(parambr, "this$0");
    parambr = parambr.Dib;
    if (parambr != null) {
      parambr.a(paramBundle, paramObject, 0L);
    }
    AppMethodBeat.o(355425);
  }
  
  private final void a(final com.tencent.mm.plugin.j<?> paramj)
  {
    AppMethodBeat.i(355391);
    if (this.Dig.contains(paramj.bUy().getClass()))
    {
      AppMethodBeat.o(355391);
      return;
    }
    erC();
    bnl localbnl = new bnl();
    localbnl.ZVU = ((q)business(q.class)).Eif;
    localbnl.ZUe = paramj.bUA();
    Object localObject = ((q)business(q.class)).Eie;
    if (localObject == null)
    {
      paramj = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.IFinderLivePromoteData<*>");
      AppMethodBeat.o(355391);
      throw paramj;
    }
    localbnl.ZTU = new com.tencent.mm.bx.b(((com.tencent.mm.plugin.j)localObject).bUy().toByteArray());
    localObject = aj.CGT;
    aj.elm().a(7, (com.tencent.mm.bx.a)localbnl, (af.c)new e(this, paramj, bnm.class));
    AppMethodBeat.o(355391);
  }
  
  private static void erC()
  {
    AppMethodBeat.i(355377);
    aj localaj = aj.CGT;
    aj.elm().OQ(7);
    AppMethodBeat.o(355377);
  }
  
  private final cx fu(Object paramObject)
  {
    AppMethodBeat.i(355367);
    Iterator localIterator = ((Iterable)this.Dia).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.fv(paramObject))
      {
        paramObject = locala.erD();
        AppMethodBeat.o(355367);
        return paramObject;
      }
    }
    AppMethodBeat.o(355367);
    return null;
  }
  
  public final void a(Bundle paramBundle, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(355564);
    cx localcx = this.Dib;
    if (localcx != null) {
      localcx.a(paramBundle, paramObject, paramLong);
    }
    AppMethodBeat.o(355564);
  }
  
  public final void c(Bundle paramBundle, Object paramObject)
  {
    AppMethodBeat.i(355570);
    this.mJe.postDelayed(new br..ExternalSyntheticLambda2(this, paramBundle, paramObject), 500L);
    AppMethodBeat.o(355570);
  }
  
  public final boolean eoI()
  {
    return true;
  }
  
  public final void mount()
  {
    AppMethodBeat.i(355584);
    super.mount();
    AppMethodBeat.o(355584);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(355551);
    if (!isLandscape())
    {
      paramConfiguration = bf.bf(this.DhZ.getContext());
      if (paramConfiguration.x >= paramConfiguration.y / 3 * 2)
      {
        ViewGroup.LayoutParams localLayoutParams = this.DhZ.getLayoutParams();
        localLayoutParams.width = (paramConfiguration.x / 2 + (int)this.DhZ.getContext().getResources().getDimension(p.c.Edge_7_5_A));
        this.DhZ.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(355551);
        return;
      }
      paramConfiguration = this.DhZ.getLayoutParams();
      paramConfiguration.width = -1;
      this.DhZ.setLayoutParams(paramConfiguration);
    }
    AppMethodBeat.o(355551);
  }
  
  public final void statusChange(b.c paramc, final Bundle paramBundle)
  {
    AppMethodBeat.i(355558);
    s.u(paramc, "status");
    d.uiThread((kotlin.g.a.a)new f(paramc, paramBundle, this));
    AppMethodBeat.o(355558);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(355592);
    super.unMount();
    cx localcx = this.Dib;
    if (localcx != null) {
      localcx.eoK();
    }
    AppMethodBeat.o(355592);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLivePromoteBubblePlugin$PromoteItemCreator;", "", "create", "Lcom/tencent/mm/plugin/finder/live/plugin/IFinderLivePromoteItem;", "isSupportData", "", "data", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  static abstract interface a
  {
    public abstract cx erD();
    
    public abstract boolean fv(Object paramObject);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLivePromoteBubblePlugin$addPromoteBubbleAnim$1$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Animator.AnimatorListener
  {
    b(br parambr, View paramView, cx paramcx) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      Object localObject = null;
      AppMethodBeat.i(355741);
      ViewGroup localViewGroup = br.d(this.Dii);
      paramAnimator = localViewGroup;
      if (localViewGroup == null)
      {
        s.bIx("promoteBubbleContainer");
        paramAnimator = null;
      }
      paramAnimator.removeView(paramView1);
      paramAnimator = br.e(this.Dii).getLayoutParams();
      paramAnimator.height = -2;
      br.e(this.Dii).setLayoutParams(paramAnimator);
      paramAnimator = br.f(this.Dii);
      if (paramAnimator == null)
      {
        s.bIx("promoteBubbleContainerScrollView");
        paramAnimator = localObject;
      }
      for (;;)
      {
        paramAnimator.setScrollY(0);
        paramcx.eoL();
        AppMethodBeat.o(355741);
        return;
      }
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<Integer>
  {
    c(br parambr)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLivePromoteBubblePlugin$delPromoteData$1$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements Animator.AnimatorListener
  {
    d(br parambr) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      Object localObject = null;
      AppMethodBeat.i(355765);
      View localView = br.g(this.Dii);
      paramAnimator = localView;
      if (localView == null)
      {
        s.bIx("promoteAnchorBubbleDelToast");
        paramAnimator = null;
      }
      paramAnimator.setVisibility(8);
      paramAnimator = br.g(this.Dii);
      if (paramAnimator == null)
      {
        s.bIx("promoteAnchorBubbleDelToast");
        paramAnimator = localObject;
      }
      for (;;)
      {
        paramAnimator.setAlpha(1.0F);
        this.Dii.tO(8);
        AppMethodBeat.o(355765);
        return;
      }
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLivePromoteBubblePlugin$startPolling$1", "Lcom/tencent/mm/plugin/finder/live/model/FinderLivePollingService$PollingEventCallback;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSyncPromoteInfoStatusResp;", "onPollingSuccess", "", "result", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends af.c<bnm>
  {
    e(br parambr, com.tencent.mm.plugin.j<?> paramj, Class<bnm> paramClass)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(b.c paramc, Bundle paramBundle, br parambr)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.br
 * JD-Core Version:    0.7.0.1
 */