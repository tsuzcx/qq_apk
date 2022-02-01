package com.tencent.mm.plugin.ball.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.Vector;

public final class b
{
  private Animator nLk;
  private Animator nLl;
  public Vector<Runnable> nLm;
  protected View targetView;
  
  public b(View paramView)
  {
    AppMethodBeat.i(106042);
    this.nLm = new Vector();
    this.targetView = paramView;
    AppMethodBeat.o(106042);
  }
  
  private Animator a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(209431);
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
      AppMethodBeat.o(209431);
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
  
  public final void Q(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(209429);
    if (this.targetView == null)
    {
      AppMethodBeat.o(209429);
      return;
    }
    if (bKP())
    {
      ae.i("MicroMsg.FloatBallViewAnimationHandler", "isAnimatingShow");
      AppMethodBeat.o(209429);
      return;
    }
    if (bKQ())
    {
      ae.i("MicroMsg.FloatBallViewAnimationHandler", "cancel hide animator");
      this.nLl.cancel();
    }
    ae.v("MicroMsg.FloatBallViewAnimationHandler", "playShowTranslateAnimation, view:%s, width: %d, isDockLeft: %b", new Object[] { this.targetView, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    this.nLk = a(true, paramInt, paramBoolean, new b(this.targetView, null));
    this.nLk.start();
    this.targetView.setAlpha(1.0F);
    this.targetView.setVisibility(0);
    AppMethodBeat.o(209429);
  }
  
  public final void a(int paramInt, boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(209430);
    if (this.targetView == null)
    {
      AppMethodBeat.o(209430);
      return;
    }
    if (bKQ())
    {
      ae.i("MicroMsg.FloatBallViewAnimationHandler", "isAnimatingHide");
      AppMethodBeat.o(209430);
      return;
    }
    if (bKP())
    {
      ae.i("MicroMsg.FloatBallViewAnimationHandler", "cancel show animator");
      this.nLk.cancel();
    }
    ae.v("MicroMsg.FloatBallViewAnimationHandler", "playHideTranslateAnimation, view:%s, width: %d, isDockLeft: %b", new Object[] { this.targetView, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    this.nLl = a(false, paramInt, paramBoolean, new a(this.targetView, paramAnimatorListenerAdapter));
    this.nLl.start();
    AppMethodBeat.o(209430);
  }
  
  public final void a(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184558);
    if (this.targetView == null)
    {
      AppMethodBeat.o(184558);
      return;
    }
    if (bKP())
    {
      ae.i("MicroMsg.FloatBallViewAnimationHandler", "isAnimatingShow");
      AppMethodBeat.o(184558);
      return;
    }
    if (bKQ())
    {
      ae.i("MicroMsg.FloatBallViewAnimationHandler", "cancel hide animator");
      this.nLl.cancel();
    }
    paramAnimatorListenerAdapter = new b(this.targetView, paramAnimatorListenerAdapter);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.targetView, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(200L);
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator });
    localAnimatorSet.addListener(paramAnimatorListenerAdapter);
    this.nLk = localAnimatorSet;
    this.nLk.start();
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
    if (bKQ())
    {
      ae.i("MicroMsg.FloatBallViewAnimationHandler", "isAnimatingHide");
      AppMethodBeat.o(184559);
      return;
    }
    if (bKP())
    {
      ae.i("MicroMsg.FloatBallViewAnimationHandler", "cancel show animator");
      this.nLk.cancel();
    }
    paramAnimatorListenerAdapter = new a(this.targetView, paramAnimatorListenerAdapter);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.targetView, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator.setDuration(100L);
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator });
    localAnimatorSet.addListener(paramAnimatorListenerAdapter);
    this.nLl = localAnimatorSet;
    this.nLl.start();
    AppMethodBeat.o(184559);
  }
  
  public final boolean bKP()
  {
    AppMethodBeat.i(106043);
    if ((this.nLk != null) && (this.nLk.isRunning()))
    {
      AppMethodBeat.o(106043);
      return true;
    }
    AppMethodBeat.o(106043);
    return false;
  }
  
  public final boolean bKQ()
  {
    AppMethodBeat.i(106044);
    if ((this.nLl != null) && (this.nLl.isRunning()))
    {
      AppMethodBeat.o(106044);
      return true;
    }
    AppMethodBeat.o(106044);
    return false;
  }
  
  public final void bKR()
  {
    AppMethodBeat.i(106045);
    if (!this.nLm.isEmpty())
    {
      ae.i("MicroMsg.FloatBallViewAnimationHandler", "firePendingTasks, size:%s", new Object[] { Integer.valueOf(this.nLm.size()) });
      Iterator localIterator = this.nLm.iterator();
      while (localIterator.hasNext()) {
        ((Runnable)localIterator.next()).run();
      }
      this.nLm.clear();
    }
    AppMethodBeat.o(106045);
  }
  
  public final class a
    extends AnimatorListenerAdapter
  {
    private AnimatorListenerAdapter nLn;
    private View targetView;
    
    public a(View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter)
    {
      this.targetView = paramView;
      this.nLn = paramAnimatorListenerAdapter;
    }
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(106030);
      super.onAnimationCancel(paramAnimator);
      if (this.targetView != null) {
        this.targetView.setVisibility(8);
      }
      if (this.nLn != null) {
        this.nLn.onAnimationCancel(paramAnimator);
      }
      b.this.bKR();
      AppMethodBeat.o(106030);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(106031);
      super.onAnimationEnd(paramAnimator);
      if (this.targetView != null) {
        this.targetView.setVisibility(8);
      }
      if (this.nLn != null) {
        this.nLn.onAnimationEnd(paramAnimator);
      }
      b.this.bKR();
      AppMethodBeat.o(106031);
    }
    
    public final void onAnimationPause(Animator paramAnimator)
    {
      AppMethodBeat.i(106034);
      super.onAnimationPause(paramAnimator);
      if (this.nLn != null) {
        this.nLn.onAnimationPause(paramAnimator);
      }
      AppMethodBeat.o(106034);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(106032);
      super.onAnimationRepeat(paramAnimator);
      if (this.nLn != null) {
        this.nLn.onAnimationRepeat(paramAnimator);
      }
      AppMethodBeat.o(106032);
    }
    
    public final void onAnimationResume(Animator paramAnimator)
    {
      AppMethodBeat.i(106035);
      super.onAnimationResume(paramAnimator);
      if (this.nLn != null) {
        this.nLn.onAnimationResume(paramAnimator);
      }
      AppMethodBeat.o(106035);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(106033);
      super.onAnimationStart(paramAnimator);
      if (this.nLn != null) {
        this.nLn.onAnimationStart(paramAnimator);
      }
      AppMethodBeat.o(106033);
    }
  }
  
  public final class b
    extends AnimatorListenerAdapter
  {
    private AnimatorListenerAdapter nLn;
    private View targetView;
    
    public b(View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter)
    {
      this.targetView = paramView;
      this.nLn = paramAnimatorListenerAdapter;
    }
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(106036);
      super.onAnimationCancel(paramAnimator);
      if (this.targetView != null) {
        this.targetView.setVisibility(0);
      }
      if (this.nLn != null) {
        this.nLn.onAnimationCancel(paramAnimator);
      }
      b.this.bKR();
      AppMethodBeat.o(106036);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(106037);
      super.onAnimationEnd(paramAnimator);
      if (this.targetView != null) {
        this.targetView.setVisibility(0);
      }
      if (this.nLn != null) {
        this.nLn.onAnimationEnd(paramAnimator);
      }
      b.this.bKR();
      AppMethodBeat.o(106037);
    }
    
    public final void onAnimationPause(Animator paramAnimator)
    {
      AppMethodBeat.i(106040);
      super.onAnimationPause(paramAnimator);
      if (this.nLn != null) {
        this.nLn.onAnimationPause(paramAnimator);
      }
      AppMethodBeat.o(106040);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(106038);
      super.onAnimationRepeat(paramAnimator);
      if (this.nLn != null) {
        this.nLn.onAnimationRepeat(paramAnimator);
      }
      AppMethodBeat.o(106038);
    }
    
    public final void onAnimationResume(Animator paramAnimator)
    {
      AppMethodBeat.i(106041);
      super.onAnimationResume(paramAnimator);
      if (this.nLn != null) {
        this.nLn.onAnimationResume(paramAnimator);
      }
      AppMethodBeat.o(106041);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(106039);
      super.onAnimationStart(paramAnimator);
      if (this.nLn != null) {
        this.nLn.onAnimationStart(paramAnimator);
      }
      AppMethodBeat.o(106039);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.b.b
 * JD-Core Version:    0.7.0.1
 */