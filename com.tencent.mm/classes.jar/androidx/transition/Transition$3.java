package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class Transition$3
  extends AnimatorListenerAdapter
{
  Transition$3(Transition paramTransition) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(201455);
    this.cgJ.end();
    paramAnimator.removeListener(this);
    AppMethodBeat.o(201455);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.transition.Transition.3
 * JD-Core Version:    0.7.0.1
 */