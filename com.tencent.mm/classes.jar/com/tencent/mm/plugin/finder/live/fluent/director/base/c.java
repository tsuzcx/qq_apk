package com.tencent.mm.plugin.finder.live.fluent.director.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.plugin.finder.live.fluent.director.b;
import com.tencent.mm.plugin.finder.live.fluent.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.w.a.a.a.b;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/fluent/director/base/BaseSwitchOutDirector;", "Lcom/tencent/mm/plugin/finder/live/fluent/director/base/BaseSwitchDirector;", "Lcom/tencent/mm/plugin/finder/live/fluent/director/ISwitchOutDirector;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "coverViewContainer", "Landroid/widget/FrameLayout;", "getCoverViewContainer", "()Landroid/widget/FrameLayout;", "setCoverViewContainer", "(Landroid/widget/FrameLayout;)V", "isDetachFloatView", "", "()Z", "setDetachFloatView", "(Z)V", "maskViewContainer", "Lcom/tencent/mm/ui/widget/RoundedCornerFrameLayout;", "getMaskViewContainer", "()Lcom/tencent/mm/ui/widget/RoundedCornerFrameLayout;", "setMaskViewContainer", "(Lcom/tencent/mm/ui/widget/RoundedCornerFrameLayout;)V", "targetView", "Landroid/view/View;", "getTargetView", "()Landroid/view/View;", "setTargetView", "(Landroid/view/View;)V", "transitionParams", "Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchParams;", "getTransitionParams", "()Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchParams;", "setTransitionParams", "(Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchParams;)V", "addMaskView", "", "attachTransitionContainerView", "calculateTargetRect", "Landroid/graphics/Rect;", "createTransitionContainerView", "detachTransitionContainerView", "getFloatViewBackgroundColor", "", "isDetach", "setOutParams", "switchLiveParams", "switchOut", "onAnimationEndCallback", "Lkotlin/Function0;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class c
  extends a
  implements b
{
  public h CCW;
  public boolean CCX;
  public FrameLayout CCY;
  private RoundedCornerFrameLayout CCZ;
  private View nmf;
  
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  private static final boolean a(c paramc, View paramView, MotionEvent paramMotionEvent)
  {
    s.u(paramc, "this$0");
    Log.i(paramc.TAG, "onTouch");
    return true;
  }
  
  private void c(h paramh)
  {
    s.u(paramh, "<set-?>");
    this.CCW = paramh;
  }
  
  public final void a(h paramh)
  {
    s.u(paramh, "switchLiveParams");
    c(paramh);
    this.nmf = paramh.uJh;
    ejG();
  }
  
  public final boolean aFA()
  {
    return this.CCX;
  }
  
  public void aX(kotlin.g.a.a<ah> parama)
  {
    s.u(parama, "onAnimationEndCallback");
    aZ(parama);
  }
  
  public final View ejB()
  {
    this.CCY = new FrameLayout(getContext());
    Object localObject = this.CCY;
    if (localObject != null) {
      ((FrameLayout)localObject).setTag(this.TAG);
    }
    localObject = this.CCY;
    if (localObject != null) {
      ((FrameLayout)localObject).setBackground(getContext().getResources().getDrawable(ejQ()));
    }
    localObject = this.CCY;
    if (localObject != null) {
      ((FrameLayout)localObject).setOnTouchListener(new c..ExternalSyntheticLambda0(this));
    }
    this.CCZ = new RoundedCornerFrameLayout(getContext());
    ejP();
    localObject = new FrameLayout.LayoutParams(ejH().width(), ejH().height());
    ((FrameLayout.LayoutParams)localObject).leftMargin = ejH().left;
    ((FrameLayout.LayoutParams)localObject).topMargin = ejH().top;
    FrameLayout localFrameLayout = this.CCY;
    if (localFrameLayout != null) {
      localFrameLayout.addView((View)this.CCZ, (ViewGroup.LayoutParams)localObject);
    }
    localObject = this.CCZ;
    s.checkNotNull(localObject);
    return (View)localObject;
  }
  
  public void ejC()
  {
    View localView = this.nmf;
    s.checkNotNull(localView);
    localView = localView.getRootView();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(ejw(), ejx());
    if (localView == null) {
      throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
    ((ViewGroup)localView).addView((View)this.CCY, (ViewGroup.LayoutParams)localLayoutParams);
    this.CCX = false;
  }
  
  public void ejD()
  {
    this.CCX = true;
    FrameLayout localFrameLayout = this.CCY;
    if (localFrameLayout != null) {
      localFrameLayout.setOnTouchListener(null);
    }
  }
  
  public Rect ejE()
  {
    com.tencent.mm.plugin.finder.live.fluent.util.a locala = com.tencent.mm.plugin.finder.live.fluent.util.a.CDq;
    return com.tencent.mm.plugin.finder.live.fluent.util.a.d(ejN());
  }
  
  public final h ejN()
  {
    h localh = this.CCW;
    if (localh != null) {
      return localh;
    }
    s.bIx("transitionParams");
    return null;
  }
  
  public final RoundedCornerFrameLayout ejO()
  {
    return this.CCZ;
  }
  
  public abstract void ejP();
  
  public int ejQ()
  {
    com.tencent.mm.plugin.finder.nearby.abtest.a locala = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
    if (com.tencent.mm.plugin.finder.nearby.abtest.a.eEi()) {
      return a.b.UN_BW_0_Alpha_0_3;
    }
    return a.b.BW_100_Alpha_0_3;
  }
  
  public final View getTargetView()
  {
    return this.nmf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.fluent.director.base.c
 * JD-Core Version:    0.7.0.1
 */