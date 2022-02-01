package com.tencent.mm.plugin.ball.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.view.FloatBallView;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Vector;

public final class b
{
  protected View nmf;
  private Animator vjw;
  private Animator vjx;
  public Vector<Runnable> vjy;
  
  public b(View paramView)
  {
    AppMethodBeat.i(106042);
    this.vjy = new Vector();
    this.nmf = paramView;
    AppMethodBeat.o(106042);
  }
  
  private Animator a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(288262);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ObjectAnimator localObjectAnimator;
    if (paramBoolean1) {
      if (paramBoolean2) {
        localObjectAnimator = ObjectAnimator.ofFloat(this.nmf, "translationX", new float[] { -paramInt, 0.0F });
      }
    }
    for (;;)
    {
      localObjectAnimator.setDuration(300L);
      localAnimatorSet.playTogether(new Animator[] { localObjectAnimator });
      localAnimatorSet.addListener(paramAnimatorListenerAdapter);
      AppMethodBeat.o(288262);
      return localAnimatorSet;
      localObjectAnimator = ObjectAnimator.ofFloat(this.nmf, "translationX", new float[] { paramInt, 0.0F });
      continue;
      if (paramBoolean2) {
        localObjectAnimator = ObjectAnimator.ofFloat(this.nmf, "translationX", new float[] { 0.0F, -paramInt });
      } else {
        localObjectAnimator = ObjectAnimator.ofFloat(this.nmf, "translationX", new float[] { 0.0F, paramInt });
      }
    }
  }
  
  public final void a(int paramInt, boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(288274);
    if (this.nmf == null)
    {
      AppMethodBeat.o(288274);
      return;
    }
    if (cXD())
    {
      Log.i("MicroMsg.FloatBallViewAnimationHandler", "isAnimatingShow");
      AppMethodBeat.o(288274);
      return;
    }
    if (cXE())
    {
      Log.i("MicroMsg.FloatBallViewAnimationHandler", "cancel hide animator");
      this.vjx.cancel();
    }
    Log.v("MicroMsg.FloatBallViewAnimationHandler", "playShowTranslateAnimation, view:%s, width: %d, isDockLeft: %b", new Object[] { this.nmf, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    this.vjw = a(true, paramInt, paramBoolean, new b(this.nmf, paramAnimatorListenerAdapter));
    this.vjw.start();
    this.nmf.setAlpha(1.0F);
    if ((this.nmf instanceof FloatBallView))
    {
      ((FloatBallView)this.nmf).cZz();
      AppMethodBeat.o(288274);
      return;
    }
    this.nmf.setVisibility(0);
    AppMethodBeat.o(288274);
  }
  
  public final void a(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184558);
    if (this.nmf == null)
    {
      AppMethodBeat.o(184558);
      return;
    }
    if (cXD())
    {
      Log.i("MicroMsg.FloatBallViewAnimationHandler", "isAnimatingShow");
      AppMethodBeat.o(184558);
      return;
    }
    if (cXE())
    {
      Log.i("MicroMsg.FloatBallViewAnimationHandler", "cancel hide animator");
      this.vjx.cancel();
    }
    paramAnimatorListenerAdapter = new b(this.nmf, paramAnimatorListenerAdapter);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.nmf, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(200L);
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator });
    localAnimatorSet.addListener(paramAnimatorListenerAdapter);
    this.vjw = localAnimatorSet;
    this.vjw.start();
    this.nmf.setVisibility(0);
    AppMethodBeat.o(184558);
  }
  
  public final void b(int paramInt, boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(288280);
    if (this.nmf == null)
    {
      AppMethodBeat.o(288280);
      return;
    }
    if (cXE())
    {
      Log.i("MicroMsg.FloatBallViewAnimationHandler", "isAnimatingHide");
      AppMethodBeat.o(288280);
      return;
    }
    if (cXD())
    {
      Log.i("MicroMsg.FloatBallViewAnimationHandler", "cancel show animator");
      this.vjw.cancel();
    }
    Log.v("MicroMsg.FloatBallViewAnimationHandler", "playHideTranslateAnimation, view:%s, width: %d, isDockLeft: %b", new Object[] { this.nmf, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    this.vjx = a(false, paramInt, paramBoolean, new a(this.nmf, paramAnimatorListenerAdapter));
    this.vjx.start();
    AppMethodBeat.o(288280);
  }
  
  public final void b(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184559);
    if (this.nmf == null)
    {
      AppMethodBeat.o(184559);
      return;
    }
    if (cXE())
    {
      Log.i("MicroMsg.FloatBallViewAnimationHandler", "isAnimatingHide");
      AppMethodBeat.o(184559);
      return;
    }
    if (cXD())
    {
      Log.i("MicroMsg.FloatBallViewAnimationHandler", "cancel show animator");
      this.vjw.cancel();
    }
    paramAnimatorListenerAdapter = new a(this.nmf, paramAnimatorListenerAdapter);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.nmf, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator.setDuration(100L);
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator });
    localAnimatorSet.addListener(paramAnimatorListenerAdapter);
    this.vjx = localAnimatorSet;
    this.vjx.start();
    AppMethodBeat.o(184559);
  }
  
  public final boolean cXD()
  {
    AppMethodBeat.i(106043);
    if ((this.vjw != null) && (this.vjw.isRunning()))
    {
      AppMethodBeat.o(106043);
      return true;
    }
    AppMethodBeat.o(106043);
    return false;
  }
  
  public final boolean cXE()
  {
    AppMethodBeat.i(106044);
    if ((this.vjx != null) && (this.vjx.isRunning()))
    {
      AppMethodBeat.o(106044);
      return true;
    }
    AppMethodBeat.o(106044);
    return false;
  }
  
  public final void cXF()
  {
    AppMethodBeat.i(106045);
    if (!this.vjy.isEmpty())
    {
      Log.i("MicroMsg.FloatBallViewAnimationHandler", "firePendingTasks, size:%s", new Object[] { Integer.valueOf(this.vjy.size()) });
      Iterator localIterator = this.vjy.iterator();
      while (localIterator.hasNext()) {
        ((Runnable)localIterator.next()).run();
      }
      this.vjy.clear();
    }
    AppMethodBeat.o(106045);
  }
  
  public final class a
    extends AnimatorListenerAdapter
  {
    private View nmf;
    private AnimatorListenerAdapter vjz;
    
    public a(View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter)
    {
      this.nmf = paramView;
      this.vjz = paramAnimatorListenerAdapter;
    }
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(106030);
      super.onAnimationCancel(paramAnimator);
      if (this.nmf != null) {
        this.nmf.setVisibility(8);
      }
      if (this.vjz != null) {
        this.vjz.onAnimationCancel(paramAnimator);
      }
      b.this.cXF();
      AppMethodBeat.o(106030);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(106031);
      super.onAnimationEnd(paramAnimator);
      if (this.nmf != null) {
        this.nmf.setVisibility(8);
      }
      if (this.vjz != null) {
        this.vjz.onAnimationEnd(paramAnimator);
      }
      b.this.cXF();
      AppMethodBeat.o(106031);
    }
    
    public final void onAnimationPause(Animator paramAnimator)
    {
      AppMethodBeat.i(106034);
      super.onAnimationPause(paramAnimator);
      if (this.vjz != null) {
        this.vjz.onAnimationPause(paramAnimator);
      }
      AppMethodBeat.o(106034);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(106032);
      super.onAnimationRepeat(paramAnimator);
      if (this.vjz != null) {
        this.vjz.onAnimationRepeat(paramAnimator);
      }
      AppMethodBeat.o(106032);
    }
    
    public final void onAnimationResume(Animator paramAnimator)
    {
      AppMethodBeat.i(106035);
      super.onAnimationResume(paramAnimator);
      if (this.vjz != null) {
        this.vjz.onAnimationResume(paramAnimator);
      }
      AppMethodBeat.o(106035);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(106033);
      super.onAnimationStart(paramAnimator);
      if (this.vjz != null) {
        this.vjz.onAnimationStart(paramAnimator);
      }
      AppMethodBeat.o(106033);
    }
  }
  
  public final class b
    extends AnimatorListenerAdapter
  {
    private View nmf;
    private AnimatorListenerAdapter vjz;
    
    public b(View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter)
    {
      this.nmf = paramView;
      this.vjz = paramAnimatorListenerAdapter;
    }
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(106036);
      super.onAnimationCancel(paramAnimator);
      if (this.nmf != null) {
        this.nmf.setVisibility(0);
      }
      if (this.vjz != null) {
        this.vjz.onAnimationCancel(paramAnimator);
      }
      b.this.cXF();
      AppMethodBeat.o(106036);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(106037);
      super.onAnimationEnd(paramAnimator);
      if (this.nmf != null) {
        this.nmf.setVisibility(0);
      }
      if (this.vjz != null) {
        this.vjz.onAnimationEnd(paramAnimator);
      }
      b.this.cXF();
      AppMethodBeat.o(106037);
    }
    
    public final void onAnimationPause(Animator paramAnimator)
    {
      AppMethodBeat.i(106040);
      super.onAnimationPause(paramAnimator);
      if (this.vjz != null) {
        this.vjz.onAnimationPause(paramAnimator);
      }
      AppMethodBeat.o(106040);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(106038);
      super.onAnimationRepeat(paramAnimator);
      if (this.vjz != null) {
        this.vjz.onAnimationRepeat(paramAnimator);
      }
      AppMethodBeat.o(106038);
    }
    
    public final void onAnimationResume(Animator paramAnimator)
    {
      AppMethodBeat.i(106041);
      super.onAnimationResume(paramAnimator);
      if (this.vjz != null) {
        this.vjz.onAnimationResume(paramAnimator);
      }
      AppMethodBeat.o(106041);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(106039);
      super.onAnimationStart(paramAnimator);
      if (this.vjz != null) {
        this.vjz.onAnimationStart(paramAnimator);
      }
      AppMethodBeat.o(106039);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.b.b
 * JD-Core Version:    0.7.0.1
 */