package com.tencent.mm.plugin.ball.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.Vector;

public final class b
{
  private Animator nFP;
  private Animator nFQ;
  public Vector<Runnable> nFR;
  protected View targetView;
  
  public b(View paramView)
  {
    AppMethodBeat.i(106042);
    this.nFR = new Vector();
    this.targetView = paramView;
    AppMethodBeat.o(106042);
  }
  
  private Animator a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(217247);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ObjectAnimator localObjectAnimator;
    if (paramBoolean1) {
      if (paramBoolean2) {
        localObjectAnimator = ObjectAnimator.ofFloat(this.targetView, "translationX", new float[] { -paramInt, 0.0F });
      }
    }
    for (;;)
    {
      localObjectAnimator.setDuration(300L);
      localAnimatorSet.playTogether(new Animator[] { localObjectAnimator });
      localAnimatorSet.addListener(paramAnimatorListenerAdapter);
      AppMethodBeat.o(217247);
      return localAnimatorSet;
      localObjectAnimator = ObjectAnimator.ofFloat(this.targetView, "translationX", new float[] { paramInt, 0.0F });
      continue;
      if (paramBoolean2) {
        localObjectAnimator = ObjectAnimator.ofFloat(this.targetView, "translationX", new float[] { 0.0F, -paramInt });
      } else {
        localObjectAnimator = ObjectAnimator.ofFloat(this.targetView, "translationX", new float[] { 0.0F, paramInt });
      }
    }
  }
  
  public final void P(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(217245);
    if (this.targetView == null)
    {
      AppMethodBeat.o(217245);
      return;
    }
    if (bJR())
    {
      ad.i("MicroMsg.FloatBallViewAnimationHandler", "isAnimatingShow");
      AppMethodBeat.o(217245);
      return;
    }
    if (bJS())
    {
      ad.i("MicroMsg.FloatBallViewAnimationHandler", "cancel hide animator");
      this.nFQ.cancel();
    }
    ad.v("MicroMsg.FloatBallViewAnimationHandler", "playShowTranslateAnimation, view:%s, width: %d, isDockLeft: %b", new Object[] { this.targetView, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    this.nFP = a(true, paramInt, paramBoolean, new b(this.targetView, null));
    this.nFP.start();
    this.targetView.setAlpha(1.0F);
    this.targetView.setVisibility(0);
    AppMethodBeat.o(217245);
  }
  
  public final void a(int paramInt, boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(217246);
    if (this.targetView == null)
    {
      AppMethodBeat.o(217246);
      return;
    }
    if (bJS())
    {
      ad.i("MicroMsg.FloatBallViewAnimationHandler", "isAnimatingHide");
      AppMethodBeat.o(217246);
      return;
    }
    if (bJR())
    {
      ad.i("MicroMsg.FloatBallViewAnimationHandler", "cancel show animator");
      this.nFP.cancel();
    }
    ad.v("MicroMsg.FloatBallViewAnimationHandler", "playHideTranslateAnimation, view:%s, width: %d, isDockLeft: %b", new Object[] { this.targetView, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    this.nFQ = a(false, paramInt, paramBoolean, new a(this.targetView, paramAnimatorListenerAdapter));
    this.nFQ.start();
    AppMethodBeat.o(217246);
  }
  
  public final void a(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184558);
    if (this.targetView == null)
    {
      AppMethodBeat.o(184558);
      return;
    }
    if (bJR())
    {
      ad.i("MicroMsg.FloatBallViewAnimationHandler", "isAnimatingShow");
      AppMethodBeat.o(184558);
      return;
    }
    if (bJS())
    {
      ad.i("MicroMsg.FloatBallViewAnimationHandler", "cancel hide animator");
      this.nFQ.cancel();
    }
    paramAnimatorListenerAdapter = new b(this.targetView, paramAnimatorListenerAdapter);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.targetView, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(200L);
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator });
    localAnimatorSet.addListener(paramAnimatorListenerAdapter);
    this.nFP = localAnimatorSet;
    this.nFP.start();
    this.targetView.setVisibility(0);
    AppMethodBeat.o(184558);
  }
  
  public final void b(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184559);
    if (this.targetView == null)
    {
      AppMethodBeat.o(184559);
      return;
    }
    if (bJS())
    {
      ad.i("MicroMsg.FloatBallViewAnimationHandler", "isAnimatingHide");
      AppMethodBeat.o(184559);
      return;
    }
    if (bJR())
    {
      ad.i("MicroMsg.FloatBallViewAnimationHandler", "cancel show animator");
      this.nFP.cancel();
    }
    paramAnimatorListenerAdapter = new a(this.targetView, paramAnimatorListenerAdapter);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.targetView, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator.setDuration(100L);
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator });
    localAnimatorSet.addListener(paramAnimatorListenerAdapter);
    this.nFQ = localAnimatorSet;
    this.nFQ.start();
    AppMethodBeat.o(184559);
  }
  
  public final boolean bJR()
  {
    AppMethodBeat.i(106043);
    if ((this.nFP != null) && (this.nFP.isRunning()))
    {
      AppMethodBeat.o(106043);
      return true;
    }
    AppMethodBeat.o(106043);
    return false;
  }
  
  public final boolean bJS()
  {
    AppMethodBeat.i(106044);
    if ((this.nFQ != null) && (this.nFQ.isRunning()))
    {
      AppMethodBeat.o(106044);
      return true;
    }
    AppMethodBeat.o(106044);
    return false;
  }
  
  public final void bJT()
  {
    AppMethodBeat.i(106045);
    if (!this.nFR.isEmpty())
    {
      ad.i("MicroMsg.FloatBallViewAnimationHandler", "firePendingTasks, size:%s", new Object[] { Integer.valueOf(this.nFR.size()) });
      Iterator localIterator = this.nFR.iterator();
      while (localIterator.hasNext()) {
        ((Runnable)localIterator.next()).run();
      }
      this.nFR.clear();
    }
    AppMethodBeat.o(106045);
  }
  
  public final class a
    extends AnimatorListenerAdapter
  {
    private AnimatorListenerAdapter nFS;
    private View targetView;
    
    public a(View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter)
    {
      this.targetView = paramView;
      this.nFS = paramAnimatorListenerAdapter;
    }
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(106030);
      super.onAnimationCancel(paramAnimator);
      if (this.targetView != null) {
        this.targetView.setVisibility(8);
      }
      if (this.nFS != null) {
        this.nFS.onAnimationCancel(paramAnimator);
      }
      b.this.bJT();
      AppMethodBeat.o(106030);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(106031);
      super.onAnimationEnd(paramAnimator);
      if (this.targetView != null) {
        this.targetView.setVisibility(8);
      }
      if (this.nFS != null) {
        this.nFS.onAnimationEnd(paramAnimator);
      }
      b.this.bJT();
      AppMethodBeat.o(106031);
    }
    
    public final void onAnimationPause(Animator paramAnimator)
    {
      AppMethodBeat.i(106034);
      super.onAnimationPause(paramAnimator);
      if (this.nFS != null) {
        this.nFS.onAnimationPause(paramAnimator);
      }
      AppMethodBeat.o(106034);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(106032);
      super.onAnimationRepeat(paramAnimator);
      if (this.nFS != null) {
        this.nFS.onAnimationRepeat(paramAnimator);
      }
      AppMethodBeat.o(106032);
    }
    
    public final void onAnimationResume(Animator paramAnimator)
    {
      AppMethodBeat.i(106035);
      super.onAnimationResume(paramAnimator);
      if (this.nFS != null) {
        this.nFS.onAnimationResume(paramAnimator);
      }
      AppMethodBeat.o(106035);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(106033);
      super.onAnimationStart(paramAnimator);
      if (this.nFS != null) {
        this.nFS.onAnimationStart(paramAnimator);
      }
      AppMethodBeat.o(106033);
    }
  }
  
  public final class b
    extends AnimatorListenerAdapter
  {
    private AnimatorListenerAdapter nFS;
    private View targetView;
    
    public b(View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter)
    {
      this.targetView = paramView;
      this.nFS = paramAnimatorListenerAdapter;
    }
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(106036);
      super.onAnimationCancel(paramAnimator);
      if (this.targetView != null) {
        this.targetView.setVisibility(0);
      }
      if (this.nFS != null) {
        this.nFS.onAnimationCancel(paramAnimator);
      }
      b.this.bJT();
      AppMethodBeat.o(106036);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(106037);
      super.onAnimationEnd(paramAnimator);
      if (this.targetView != null) {
        this.targetView.setVisibility(0);
      }
      if (this.nFS != null) {
        this.nFS.onAnimationEnd(paramAnimator);
      }
      b.this.bJT();
      AppMethodBeat.o(106037);
    }
    
    public final void onAnimationPause(Animator paramAnimator)
    {
      AppMethodBeat.i(106040);
      super.onAnimationPause(paramAnimator);
      if (this.nFS != null) {
        this.nFS.onAnimationPause(paramAnimator);
      }
      AppMethodBeat.o(106040);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(106038);
      super.onAnimationRepeat(paramAnimator);
      if (this.nFS != null) {
        this.nFS.onAnimationRepeat(paramAnimator);
      }
      AppMethodBeat.o(106038);
    }
    
    public final void onAnimationResume(Animator paramAnimator)
    {
      AppMethodBeat.i(106041);
      super.onAnimationResume(paramAnimator);
      if (this.nFS != null) {
        this.nFS.onAnimationResume(paramAnimator);
      }
      AppMethodBeat.o(106041);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(106039);
      super.onAnimationStart(paramAnimator);
      if (this.nFS != null) {
        this.nFS.onAnimationStart(paramAnimator);
      }
      AppMethodBeat.o(106039);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.b.b
 * JD-Core Version:    0.7.0.1
 */