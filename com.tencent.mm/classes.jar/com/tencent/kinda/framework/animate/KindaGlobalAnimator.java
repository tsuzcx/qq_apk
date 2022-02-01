package com.tencent.kinda.framework.animate;

import android.animation.Animator;
import android.animation.AnimatorSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class KindaGlobalAnimator
{
  private static List<Animator> animList;
  private static AnimatorSet animSet;
  private static long animateDuration;
  private static boolean isAnimated;
  private static Runnable onComplete;
  
  static
  {
    AppMethodBeat.i(18336);
    animList = new ArrayList();
    animSet = null;
    onComplete = null;
    AppMethodBeat.o(18336);
  }
  
  public static void addAnimator(Animator paramAnimator)
  {
    AppMethodBeat.i(18333);
    animList.add(paramAnimator);
    AppMethodBeat.o(18333);
  }
  
  public static long animateDuration()
  {
    return animateDuration;
  }
  
  public static boolean hasAnimate()
  {
    return (isAnimated) && (animateDuration > 0L);
  }
  
  private static void setupAnimate(long paramLong, Runnable paramRunnable)
  {
    isAnimated = true;
    animateDuration = paramLong;
    onComplete = paramRunnable;
  }
  
  private static void startAnimInternal()
  {
    AppMethodBeat.i(18330);
    isAnimated = false;
    animateDuration = 0L;
    if (animList.size() > 0)
    {
      Object localObject = new AnimatorSet();
      animSet = (AnimatorSet)localObject;
      ((AnimatorSet)localObject).playTogether(animList);
      if (onComplete != null)
      {
        localObject = onComplete;
        animSet.addListener(new KindaGlobalAnimator.1((Runnable)localObject));
      }
      animSet.start();
      animSet = null;
      animList.clear();
      onComplete = null;
    }
    AppMethodBeat.o(18330);
  }
  
  public static void startAnimate(long paramLong, Runnable paramRunnable)
  {
    AppMethodBeat.i(18331);
    KindaAnimatorWatch.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(18328);
        if ((this.val$duration > 0L) && (this.val$run != null))
        {
          KindaGlobalAnimator.access$000(this.val$duration, null);
          this.val$run.run();
          KindaGlobalAnimator.access$100();
        }
        AppMethodBeat.o(18328);
      }
    });
    AppMethodBeat.o(18331);
  }
  
  public static void startAnimate(long paramLong, Runnable paramRunnable1, final Runnable paramRunnable2)
  {
    AppMethodBeat.i(18332);
    KindaAnimatorWatch.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(18329);
        if ((this.val$duration > 0L) && (paramRunnable2 != null))
        {
          KindaGlobalAnimator.access$000(this.val$duration, this.val$complete);
          paramRunnable2.run();
          KindaGlobalAnimator.access$100();
          if (KindaGlobalAnimator.onComplete != null)
          {
            KindaGlobalAnimator.onComplete.run();
            KindaGlobalAnimator.access$202(null);
          }
        }
        AppMethodBeat.o(18329);
      }
    });
    AppMethodBeat.o(18332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.animate.KindaGlobalAnimator
 * JD-Core Version:    0.7.0.1
 */