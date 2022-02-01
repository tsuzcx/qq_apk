package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FragmentManagerImpl$d
  extends AnimatorListenerAdapter
{
  View mView;
  
  FragmentManagerImpl$d(View paramView)
  {
    this.mView = paramView;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(212493);
    this.mView.setLayerType(0, null);
    paramAnimator.removeListener(this);
    AppMethodBeat.o(212493);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(212492);
    this.mView.setLayerType(2, null);
    AppMethodBeat.o(212492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.fragment.app.FragmentManagerImpl.d
 * JD-Core Version:    0.7.0.1
 */