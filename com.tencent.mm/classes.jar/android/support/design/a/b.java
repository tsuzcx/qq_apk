package android.support.design.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import java.util.List;

public final class b
{
  public static void a(AnimatorSet paramAnimatorSet, List<Animator> paramList)
  {
    long l = 0L;
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      localObject = (Animator)paramList.get(i);
      l = Math.max(l, ((Animator)localObject).getStartDelay() + ((Animator)localObject).getDuration());
      i += 1;
    }
    Object localObject = ValueAnimator.ofInt(new int[] { 0, 0 });
    ((Animator)localObject).setDuration(l);
    paramList.add(0, localObject);
    paramAnimatorSet.playTogether(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.a.b
 * JD-Core Version:    0.7.0.1
 */