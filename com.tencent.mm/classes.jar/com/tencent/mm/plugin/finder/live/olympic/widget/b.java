package com.tencent.mm.plugin.finder.live.olympic.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import com.tencent.d.a.a.a.b.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.d;
import com.tencent.mm.live.b.e;
import com.tencent.mm.plugin.finder.live.plugin.cc;
import com.tencent.mm.plugin.finder.utils.bj;
import com.tencent.mm.plugin.finder.utils.bk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bf;
import com.tencent.mm.view.RCConstraintLayout;
import com.tencent.mm.view.RCConstraintLayout.a;
import com.tencent.mm.view.RCRelativeLayout;
import com.tencent.mm.view.RCRelativeLayout.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/widget/FinderLiveOlympicsPlayerSwitchWidget;", "", "olympicsSwitchLayout", "Landroid/view/View;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "txLivePlayerPreview", "livePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTXLivePlayerPlugin;", "(Landroid/view/View;Lcom/tencent/mm/live/plugin/ILiveStatus;Landroid/view/View;Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTXLivePlayerPlugin;)V", "TAG", "", "bgIv", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "buContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "getBuContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "dialog", "doAnimate", "", "fullBtn", "isVideoMini", "getLivePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTXLivePlayerPlugin;", "maskView", "getOlympicsSwitchLayout", "()Landroid/view/View;", "root", "Landroid/view/ViewGroup;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "getTxLivePlayerPreview", "videoLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "widgetHeight", "", "getWidgetHeight", "()I", "animateView", "", "fromRect", "Landroid/graphics/Rect;", "toRect", "view", "release", "resetSwitch", "animate", "setVisible", "visible", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "switchToMini", "videoView", "switchToNormal", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public final View CSG;
  public final View CSH;
  private final cc CSI;
  public boolean CSJ;
  public boolean CSK;
  private final View CSL;
  private final View CSM;
  private final ImageView CSN;
  private final int CSO;
  public View.OnLayoutChangeListener CSP;
  private final String TAG;
  private final com.tencent.mm.plugin.finder.live.model.context.a buContext;
  private final ViewGroup mJe;
  public final View maskView;
  private final com.tencent.mm.live.b.b nfT;
  
  public b(View paramView1, com.tencent.mm.live.b.b paramb, View paramView2, cc paramcc)
  {
    AppMethodBeat.i(360752);
    this.CSG = paramView1;
    this.nfT = paramb;
    this.CSH = paramView2;
    this.CSI = paramcc;
    this.TAG = "Finder.FinderLiveOlympicsPlayerSwitchWidget";
    this.mJe = this.CSI.mJe;
    this.buContext = this.CSI.getBuContext();
    this.maskView = this.mJe.findViewById(b.e.live_oly_switch_mask);
    this.CSL = this.mJe.findViewById(b.e.live_oly_full_btn);
    this.CSM = this.mJe.findViewById(b.e.live_oly_switch_dialog_layout);
    this.CSN = ((ImageView)this.mJe.findViewById(b.e.switch_bg_iv));
    this.CSO = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 44);
    this.CSP = new b..ExternalSyntheticLambda1(this);
    doE();
    paramView1 = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
    paramView1 = this.CSN;
    s.s(paramView1, "bgIv");
    com.tencent.mm.plugin.finder.live.olympic.util.a.a(paramView1, b.j.ahoY, b.d.background_mini_window);
    this.CSH.addOnLayoutChangeListener(this.CSP);
    paramView1 = this.CSG;
    if ((paramView1 instanceof RCConstraintLayout)) {}
    for (paramView1 = (RCConstraintLayout)paramView1;; paramView1 = null)
    {
      if (paramView1 != null) {
        paramView1.setRadius(new RCConstraintLayout.a(this.mJe.getContext().getResources().getDimension(com.tencent.mm.live.b.c.Edge_0_5_A), this.mJe.getContext().getResources().getDimension(com.tencent.mm.live.b.c.Edge_0_5_A)));
      }
      AppMethodBeat.o(360752);
      return;
    }
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(360777);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramb);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/olympic/widget/FinderLiveOlympicsPlayerSwitchWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramb, "this$0");
    if (paramb.CSK)
    {
      Log.i(paramb.TAG, "olympics doAnimate click return");
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/olympic/widget/FinderLiveOlympicsPlayerSwitchWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(360777);
      return;
    }
    Log.i(paramb.TAG, s.X("olympics doAnimate click, isVideoMini:", Boolean.valueOf(paramb.CSJ)));
    paramView = paramb.CSH.getParent();
    if (paramView == null)
    {
      paramb = new NullPointerException("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(360777);
      throw paramb;
    }
    paramView = (View)paramView;
    if (paramb.CSJ)
    {
      paramView.animate().setDuration(250L).translationX(0.0F).translationY(0.0F).scaleX(1.0F).scaleY(1.0F).setListener((Animator.AnimatorListener)new c(paramb)).start();
      paramb.CSJ = false;
      paramb.maskView.setAlpha(0.0F);
      Log.i(paramb.TAG, "olympics switchToNormal");
      paramView = paramb.CSH.getParent();
      if ((paramView instanceof RCRelativeLayout)) {}
      for (paramView = (RCRelativeLayout)paramView;; paramView = null)
      {
        if (paramView != null) {
          paramView.setRadius(0.0F);
        }
        paramb.qT(true);
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/olympic/widget/FinderLiveOlympicsPlayerSwitchWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(360777);
        return;
      }
    }
    localObject1 = new Rect();
    localObject2 = new Rect();
    paramView.getGlobalVisibleRect((Rect)localObject1);
    paramb.CSG.getGlobalVisibleRect((Rect)localObject2);
    float f1;
    if ((!((Rect)localObject1).isEmpty()) && (!((Rect)localObject2).isEmpty()))
    {
      bk localbk = bk.GlT;
      bk.a("video", (Rect)localObject1, (Rect)localObject2, paramView, (Animator.AnimatorListener)new b(paramb));
      float f2 = ((Rect)localObject2).width() / ((Rect)localObject1).width();
      float f3 = ((Rect)localObject2).height() / ((Rect)localObject1).height();
      f1 = paramb.mJe.getContext().getResources().getDimension(com.tencent.mm.live.b.c.Edge_0_5_A);
      if ((f2 <= 0.0F) || (f3 <= 0.0F) || (f2 >= 1.0F) || (f3 >= 1.0F)) {
        break label566;
      }
      f1 = Math.max(f1, f1 / Math.min(f2, f3));
      label471:
      Log.i(paramb.TAG, s.X("final radius:", Float.valueOf(f1)));
      paramView = paramb.CSH.getParent();
      if (!(paramView instanceof RCRelativeLayout)) {
        break label569;
      }
    }
    label566:
    label569:
    for (paramView = (RCRelativeLayout)paramView;; paramView = null)
    {
      if (paramView != null) {
        paramView.setRadius(new RCRelativeLayout.a(f1, f1));
      }
      paramb.CSK = true;
      paramb.CSJ = true;
      paramb.maskView.setAlpha(1.0F);
      Log.i(paramb.TAG, "olympics switchToMini");
      com.tencent.mm.live.b.b.b.a(paramb.nfT, com.tencent.mm.live.b.b.c.nfJ);
      break;
      break label471;
    }
  }
  
  private static final void a(b paramb, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(360761);
    s.u(paramb, "this$0");
    paramView = bj.GlQ;
    if (bj.y(paramb.buContext))
    {
      paramInt5 = paramInt3 - paramInt1;
      paramInt6 = paramInt4 - paramInt2;
      paramView = bf.bf(paramb.mJe.getContext());
      Log.i(paramb.TAG, "videoLayoutChangeListener width:" + paramInt5 + ", height:" + paramInt6 + ", screen:" + paramView + ", widgetHeight:" + paramb.CSO + ", " + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramInt4);
      if ((paramInt5 <= 0) || (paramInt6 <= 0) || (paramb.CSO + paramInt6 > paramView.y))
      {
        paramb.CSG.setAlpha(0.0F);
        AppMethodBeat.o(360761);
        return;
      }
      paramb.CSG.setAlpha(1.0F);
    }
    AppMethodBeat.o(360761);
  }
  
  public final void a(com.tencent.mm.live.b.b.c paramc)
  {
    AppMethodBeat.i(360813);
    s.u(paramc, "status");
    switch (b.a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(360813);
      return;
      String str = this.TAG;
      paramc = new StringBuilder("statusChange ").append(paramc).append(", stream_status = video?");
      bj localbj = bj.GlQ;
      Log.i(str, bj.z(this.buContext));
      if (!this.CSI.isLandscape())
      {
        paramc = bj.GlQ;
        if (bj.z(this.buContext))
        {
          doE();
          this.CSG.setOnClickListener(new b..ExternalSyntheticLambda0(this));
          AppMethodBeat.o(360813);
          return;
        }
      }
      doE();
    }
  }
  
  public final void doE()
  {
    AppMethodBeat.i(360806);
    this.maskView.setVisibility(8);
    this.CSL.setVisibility(8);
    this.CSM.setVisibility(8);
    AppMethodBeat.o(360806);
  }
  
  public final void qT(boolean paramBoolean)
  {
    AppMethodBeat.i(360822);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("animate", paramBoolean);
    this.nfT.statusChange(com.tencent.mm.live.b.b.c.nfK, localBundle);
    AppMethodBeat.o(360822);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/olympic/widget/FinderLiveOlympicsPlayerSwitchWidget$animateView$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "p0", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Animator.AnimatorListener
  {
    b(b paramb) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      this.CSQ.CSK = false;
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      this.CSQ.CSK = false;
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/olympic/widget/FinderLiveOlympicsPlayerSwitchWidget$switchToNormal$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "p0", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements Animator.AnimatorListener
  {
    c(b paramb) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      this.CSQ.CSK = false;
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      this.CSQ.CSK = false;
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.widget.b
 * JD-Core Version:    0.7.0.1
 */