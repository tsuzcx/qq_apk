package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class Fade$a
  extends AnimatorListenerAdapter
{
  private boolean cff = false;
  private final View mView;
  
  Fade$a(View paramView)
  {
    this.mView = paramView;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(201461);
    ai.o(this.mView, 1.0F);
    if (this.cff) {
      this.mView.setLayerType(0, null);
    }
    AppMethodBeat.o(201461);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(201453);
    if ((z.an(this.mView)) && (this.mView.getLayerType() == 0))
    {
      this.cff = true;
      this.mView.setLayerType(2, null);
    }
    AppMethodBeat.o(201453);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.transition.Fade.a
 * JD-Core Version:    0.7.0.1
 */