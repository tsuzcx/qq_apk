package com.tencent.mm.plugin.ball.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Vector;

public final class b
{
  protected View kJL;
  private Animator rYg;
  private Animator rYh;
  public Vector<Runnable> rYi;
  
  public b(View paramView)
  {
    AppMethodBeat.i(106042);
    this.rYi = new Vector();
    this.kJL = paramView;
    AppMethodBeat.o(106042);
  }
  
  private Animator a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(187805);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ObjectAnimator localObjectAnimator;
    if (paramBoolean1) {
      if (paramBoolean2) {
        localObjectAnimator = ObjectAnimator.ofFloat(this.kJL, "translationX", new float[] { -paramInt, 0.0F });
      }
    }
    for (;;)
    {
      localObjectAnimator.setDuration(300L);
      localAnimatorSet.playTogether(new Animator[] { localObjectAnimator });
      localAnimatorSet.addListener(paramAnimatorListenerAdapter);
      AppMethodBeat.o(187805);
      return localAnimatorSet;
      localObjectAnimator = ObjectAnimator.ofFloat(this.kJL, "translationX", new float[] { paramInt, 0.0F });
      continue;
      if (paramBoolean2) {
        localObjectAnimator = ObjectAnimator.ofFloat(this.kJL, "translationX", new float[] { 0.0F, -paramInt });
      } else {
        localObjectAnimator = ObjectAnimator.ofFloat(this.kJL, "translationX", new float[] { 0.0F, paramInt });
      }
    }
  }
  
  public final void a(int paramInt, boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(187799);
    if (this.kJL == null)
    {
      AppMethodBeat.o(187799);
      return;
    }
    if (cuT())
    {
      Log.i("MicroMsg.FloatBallViewAnimationHandler", "isAnimatingShow");
      AppMethodBeat.o(187799);
      return;
    }
    if (cuU())
    {
      Log.i("MicroMsg.FloatBallViewAnimationHandler", "cancel hide animator");
      this.rYh.cancel();
    }
    Log.v("MicroMsg.FloatBallViewAnimationHandler", "playShowTranslateAnimation, view:%s, width: %d, isDockLeft: %b", new Object[] { this.kJL, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    this.rYg = a(true, paramInt, paramBoolean, new b(this.kJL, paramAnimatorListenerAdapter));
    this.rYg.start();
    this.kJL.setAlpha(1.0F);
    this.kJL.setVisibility(0);
    AppMethodBeat.o(187799);
  }
  
  public final void a(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184558);
    if (this.kJL == null)
    {
      AppMethodBeat.o(184558);
      return;
    }
    if (cuT())
    {
      Log.i("MicroMsg.FloatBallViewAnimationHandler", "isAnimatingShow");
      AppMethodBeat.o(184558);
      return;
    }
    if (cuU())
    {
      Log.i("MicroMsg.FloatBallViewAnimationHandler", "cancel hide animator");
      this.rYh.cancel();
    }
    paramAnimatorListenerAdapter = new b(this.kJL, paramAnimatorListenerAdapter);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.kJL, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(200L);
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator });
    localAnimatorSet.addListener(paramAnimatorListenerAdapter);
    this.rYg = localAnimatorSet;
    this.rYg.start();
    this.kJL.setVisibility(0);
    AppMethodBeat.o(184558);
  }
  
  public final void b(int paramInt, boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(187802);
    if (this.kJL == null)
    {
      AppMethodBeat.o(187802);
      return;
    }
    if (cuU())
    {
      Log.i("MicroMsg.FloatBallViewAnimationHandler", "isAnimatingHide");
      AppMethodBeat.o(187802);
      return;
    }
    if (cuT())
    {
      Log.i("MicroMsg.FloatBallViewAnimationHandler", "cancel show animator");
      this.rYg.cancel();
    }
    Log.v("MicroMsg.FloatBallViewAnimationHandler", "playHideTranslateAnimation, view:%s, width: %d, isDockLeft: %b", new Object[] { this.kJL, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    this.rYh = a(false, paramInt, paramBoolean, new a(this.kJL, paramAnimatorListenerAdapter));
    this.rYh.start();
    AppMethodBeat.o(187802);
  }
  
  public final void b(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184559);
    if (this.kJL == null)
    {
      AppMethodBeat.o(184559);
      return;
    }
    if (cuU())
    {
      Log.i("MicroMsg.FloatBallViewAnimationHandler", "isAnimatingHide");
      AppMethodBeat.o(184559);
      return;
    }
    if (cuT())
    {
      Log.i("MicroMsg.FloatBallViewAnimationHandler", "cancel show animator");
      this.rYg.cancel();
    }
    paramAnimatorListenerAdapter = new a(this.kJL, paramAnimatorListenerAdapter);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.kJL, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator.setDuration(100L);
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator });
    localAnimatorSet.addListener(paramAnimatorListenerAdapter);
    this.rYh = localAnimatorSet;
    this.rYh.start();
    AppMethodBeat.o(184559);
  }
  
  public final boolean cuT()
  {
    AppMethodBeat.i(106043);
    if ((this.rYg != null) && (this.rYg.isRunning()))
    {
      AppMethodBeat.o(106043);
      return true;
    }
    AppMethodBeat.o(106043);
    return false;
  }
  
  public final boolean cuU()
  {
    AppMethodBeat.i(106044);
    if ((this.rYh != null) && (this.rYh.isRunning()))
    {
      AppMethodBeat.o(106044);
      return true;
    }
    AppMethodBeat.o(106044);
    return false;
  }
  
  public final void cuV()
  {
    AppMethodBeat.i(106045);
    if (!this.rYi.isEmpty())
    {
      Log.i("MicroMsg.FloatBallViewAnimationHandler", "firePendingTasks, size:%s", new Object[] { Integer.valueOf(this.rYi.size()) });
      Iterator localIterator = this.rYi.iterator();
      while (localIterator.hasNext()) {
        ((Runnable)localIterator.next()).run();
      }
      this.rYi.clear();
    }
    AppMethodBeat.o(106045);
  }
  
  public final class a
    extends AnimatorListenerAdapter
  {
    private View kJL;
    private AnimatorListenerAdapter rYj;
    
    public a(View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter)
    {
      this.kJL = paramView;
      this.rYj = paramAnimatorListenerAdapter;
    }
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(106030);
      super.onAnimationCancel(paramAnimator);
      if (this.kJL != null) {
        this.kJL.setVisibility(8);
      }
      if (this.rYj != null) {
        this.rYj.onAnimationCancel(paramAnimator);
      }
      b.this.cuV();
      AppMethodBeat.o(106030);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(106031);
      super.onAnimationEnd(paramAnimator);
      if (this.kJL != null) {
        this.kJL.setVisibility(8);
      }
      if (this.rYj != null) {
        this.rYj.onAnimationEnd(paramAnimator);
      }
      b.this.cuV();
      AppMethodBeat.o(106031);
    }
    
    public final void onAnimationPause(Animator paramAnimator)
    {
      AppMethodBeat.i(106034);
      super.onAnimationPause(paramAnimator);
      if (this.rYj != null) {
        this.rYj.onAnimationPause(paramAnimator);
      }
      AppMethodBeat.o(106034);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(106032);
      super.onAnimationRepeat(paramAnimator);
      if (this.rYj != null) {
        this.rYj.onAnimationRepeat(paramAnimator);
      }
      AppMethodBeat.o(106032);
    }
    
    public final void onAnimationResume(Animator paramAnimator)
    {
      AppMethodBeat.i(106035);
      super.onAnimationResume(paramAnimator);
      if (this.rYj != null) {
        this.rYj.onAnimationResume(paramAnimator);
      }
      AppMethodBeat.o(106035);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(106033);
      super.onAnimationStart(paramAnimator);
      if (this.rYj != null) {
        this.rYj.onAnimationStart(paramAnimator);
      }
      AppMethodBeat.o(106033);
    }
  }
  
  public final class b
    extends AnimatorListenerAdapter
  {
    private View kJL;
    private AnimatorListenerAdapter rYj;
    
    public b(View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter)
    {
      this.kJL = paramView;
      this.rYj = paramAnimatorListenerAdapter;
    }
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(106036);
      super.onAnimationCancel(paramAnimator);
      if (this.kJL != null) {
        this.kJL.setVisibility(0);
      }
      if (this.rYj != null) {
        this.rYj.onAnimationCancel(paramAnimator);
      }
      b.this.cuV();
      AppMethodBeat.o(106036);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(106037);
      super.onAnimationEnd(paramAnimator);
      if (this.kJL != null) {
        this.kJL.setVisibility(0);
      }
      if (this.rYj != null) {
        this.rYj.onAnimationEnd(paramAnimator);
      }
      b.this.cuV();
      AppMethodBeat.o(106037);
    }
    
    public final void onAnimationPause(Animator paramAnimator)
    {
      AppMethodBeat.i(106040);
      super.onAnimationPause(paramAnimator);
      if (this.rYj != null) {
        this.rYj.onAnimationPause(paramAnimator);
      }
      AppMethodBeat.o(106040);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(106038);
      super.onAnimationRepeat(paramAnimator);
      if (this.rYj != null) {
        this.rYj.onAnimationRepeat(paramAnimator);
      }
      AppMethodBeat.o(106038);
    }
    
    public final void onAnimationResume(Animator paramAnimator)
    {
      AppMethodBeat.i(106041);
      super.onAnimationResume(paramAnimator);
      if (this.rYj != null) {
        this.rYj.onAnimationResume(paramAnimator);
      }
      AppMethodBeat.o(106041);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(106039);
      super.onAnimationStart(paramAnimator);
      if (this.rYj != null) {
        this.rYj.onAnimationStart(paramAnimator);
      }
      AppMethodBeat.o(106039);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.b.b
 * JD-Core Version:    0.7.0.1
 */