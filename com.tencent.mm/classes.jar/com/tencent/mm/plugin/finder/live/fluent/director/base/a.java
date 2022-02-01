package com.tencent.mm.plugin.finder.live.fluent.director.base;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.tencent.mm.plugin.finder.live.fluent.animate.b;
import com.tencent.mm.plugin.finder.live.fluent.animate.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/fluent/director/base/BaseSwitchDirector;", "Landroid/animation/Animator$AnimatorListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "SCREEN_HEIGHT", "", "getSCREEN_HEIGHT", "()I", "SCREEN_WITDH", "getSCREEN_WITDH", "setSCREEN_WITDH", "(I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "animationSet", "Landroid/animation/AnimatorSet;", "getAnimationSet", "()Landroid/animation/AnimatorSet;", "setAnimationSet", "(Landroid/animation/AnimatorSet;)V", "getContext", "()Landroid/content/Context;", "onAnimationEndCallback", "Lkotlin/Function0;", "", "sourceRect", "Landroid/graphics/Rect;", "targetRect", "transitionContainerView", "Landroid/view/View;", "getTransitionContainerView", "()Landroid/view/View;", "setTransitionContainerView", "(Landroid/view/View;)V", "addTransition", "builder", "Lcom/tencent/mm/plugin/finder/live/fluent/animate/FluentTransitionConfig$Builder;", "attachTransitionContainerView", "beginTransition", "calculateSourceRect", "calculateTargetRect", "createAnimationSet", "config", "Lcom/tencent/mm/plugin/finder/live/fluent/animate/FluentTransitionConfig;", "createTransitionContainerView", "detachTransitionContainerView", "getSourceRect", "getTag", "getTargetRect", "getTransitionConfig", "getTransitionDuration", "", "onAnimationCancel", "p0", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "setTransitionAnimator", "startTransition", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  implements Animator.AnimatorListener
{
  private static long ANIMATION_DURATION = 300L;
  public static final a CCN = new a((byte)0);
  private Rect CCC;
  private int CCO;
  private final int CCP;
  private Rect CCQ;
  private kotlin.g.a.a<ah> CCR;
  private View CCS;
  private AnimatorSet CCT;
  public final String TAG;
  private final Context context;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
    this.TAG = s.X("Finder.", getTag());
    paramContext = com.tencent.mm.plugin.finder.live.fluent.util.a.CDq;
    this.CCO = com.tencent.mm.plugin.finder.live.fluent.util.a.ejw();
    paramContext = com.tencent.mm.plugin.finder.live.fluent.util.a.CDq;
    this.CCP = com.tencent.mm.plugin.finder.live.fluent.util.a.ejx();
  }
  
  public void a(b.a parama)
  {
    s.u(parama, "builder");
    Object localObject = ejH();
    Rect localRect = ejI();
    float f1 = localRect.width() * 1.0F / ((Rect)localObject).width();
    float f2 = localRect.height() * 1.0F / ((Rect)localObject).height();
    float f3 = localRect.centerX() - ((Rect)localObject).centerX();
    float f4 = localRect.centerY() - ((Rect)localObject).centerY();
    Log.i(this.TAG, "setTransitionAnimator sourceRect: " + localObject + "  targetRect: " + localRect + " scaleRatioX: " + f1 + "  scaleRatioY: " + f2 + "  translationX: " + f3 + "  translationY: " + f4 + ' ');
    localObject = ObjectAnimator.ofFloat(this.CCS, "scaleX", new float[] { 1.0F, f1 });
    s.s(localObject, "ofFloat(transitionContai…aleX\", 1.0f, scaleRatioX)");
    parama = parama.c((ValueAnimator)localObject);
    localObject = ObjectAnimator.ofFloat(this.CCS, "scaleY", new float[] { 1.0F, f2 });
    s.s(localObject, "ofFloat(transitionContai…aleY\", 1.0f, scaleRatioY)");
    parama = parama.c((ValueAnimator)localObject);
    localObject = ObjectAnimator.ofFloat(this.CCS, "translationX", new float[] { 0.0F, f3 });
    s.s(localObject, "ofFloat(transitionContai…tionX\", 0f, translationX)");
    parama = parama.c((ValueAnimator)localObject);
    localObject = ObjectAnimator.ofFloat(this.CCS, "translationY", new float[] { 0.0F, f4 });
    s.s(localObject, "ofFloat(transitionContai…tionY\", 0f, translationY)");
    parama.c((ValueAnimator)localObject);
  }
  
  public final void aZ(kotlin.g.a.a<ah> parama)
  {
    s.u(parama, "onAnimationEndCallback");
    this.CCR = parama;
    parama = new b.a();
    a(parama);
    Object localObject = new b(parama.CCM);
    parama = new AnimatorSet();
    parama.setDuration(ejA());
    parama.playTogether((Collection)((b)localObject).CCM);
    localObject = ah.aiuX;
    this.CCT = parama;
    parama = this.CCT;
    if (parama != null) {
      parama.addListener((Animator.AnimatorListener)this);
    }
    if (parama != null) {
      parama.start();
    }
  }
  
  public long ejA()
  {
    return ANIMATION_DURATION;
  }
  
  public abstract View ejB();
  
  public abstract void ejC();
  
  public abstract void ejD();
  
  public abstract Rect ejE();
  
  public abstract Rect ejF();
  
  public final void ejG()
  {
    this.CCC = ejE();
    this.CCQ = ejF();
    Log.i(this.TAG, s.X("targetRect = ", ejI()));
    Log.i(this.TAG, s.X("sourceRect = ", ejH()));
    this.CCS = ejB();
    ejC();
  }
  
  public final Rect ejH()
  {
    Rect localRect2 = this.CCQ;
    Rect localRect1 = localRect2;
    if (localRect2 == null)
    {
      s.bIx("sourceRect");
      localRect1 = null;
    }
    return localRect1;
  }
  
  public final Rect ejI()
  {
    Rect localRect2 = this.CCC;
    Rect localRect1 = localRect2;
    if (localRect2 == null)
    {
      s.bIx("targetRect");
      localRect1 = null;
    }
    return localRect1;
  }
  
  public final int ejw()
  {
    return this.CCO;
  }
  
  public final int ejx()
  {
    return this.CCP;
  }
  
  public final View ejy()
  {
    return this.CCS;
  }
  
  public final AnimatorSet ejz()
  {
    return this.CCT;
  }
  
  public final Context getContext()
  {
    return this.context;
  }
  
  public abstract String getTag();
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.CCR;
    if (paramAnimator != null) {
      paramAnimator.invoke();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/fluent/director/base/BaseSwitchDirector$Companion;", "", "()V", "ANIMATION_DURATION", "", "getANIMATION_DURATION", "()J", "setANIMATION_DURATION", "(J)V", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.fluent.director.base.a
 * JD-Core Version:    0.7.0.1
 */