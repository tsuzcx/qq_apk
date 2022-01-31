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
    AppMethodBeat.i(144301);
    animList = new ArrayList();
    animSet = null;
    onComplete = null;
    AppMethodBeat.o(144301);
  }
  
  public static void addAnimator(Animator paramAnimator)
  {
    AppMethodBeat.i(144298);
    animList.add(paramAnimator);
    AppMethodBeat.o(144298);
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
    AppMethodBeat.i(144295);
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
    AppMethodBeat.o(144295);
  }
  
  public static void startAnimate(long paramLong, Runnable paramRunnable)
  {
    AppMethodBeat.i(144296);
    KindaAnimatorWatch.post(new KindaGlobalAnimator.2(paramLong, paramRunnable));
    AppMethodBeat.o(144296);
  }
  
  public static void startAnimate(long paramLong, Runnable paramRunnable1, Runnable paramRunnable2)
  {
    AppMethodBeat.i(144297);
    KindaAnimatorWatch.post(new KindaGlobalAnimator.3(paramLong, paramRunnable1, paramRunnable2));
    AppMethodBeat.o(144297);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.framework.animate.KindaGlobalAnimator
 * JD-Core Version:    0.7.0.1
 */