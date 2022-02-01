package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class Transition$2
  extends AnimatorListenerAdapter
{
  Transition$2(Transition paramTransition, a parama) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(201464);
    this.cgI.remove(paramAnimator);
    this.cgJ.cgB.remove(paramAnimator);
    AppMethodBeat.o(201464);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(201459);
    this.cgJ.cgB.add(paramAnimator);
    AppMethodBeat.o(201459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.transition.Transition.2
 * JD-Core Version:    0.7.0.1
 */