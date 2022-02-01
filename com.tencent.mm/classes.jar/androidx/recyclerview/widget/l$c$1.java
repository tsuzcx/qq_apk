package androidx.recyclerview.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class l$c$1
  implements ValueAnimator.AnimatorUpdateListener
{
  l$c$1(l.c paramc) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(261464);
    this.aiI.aiH = paramValueAnimator.getAnimatedFraction();
    AppMethodBeat.o(261464);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.recyclerview.widget.l.c.1
 * JD-Core Version:    0.7.0.1
 */