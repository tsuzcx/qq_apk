package androidx.fragment.app;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

class FragmentManagerImpl$b
  implements Animation.AnimationListener
{
  private final Animation.AnimationListener VS;
  
  FragmentManagerImpl$b(Animation.AnimationListener paramAnimationListener)
  {
    this.VS = paramAnimationListener;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(212482);
    if (this.VS != null) {
      this.VS.onAnimationEnd(paramAnimation);
    }
    AppMethodBeat.o(212482);
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    AppMethodBeat.i(212484);
    if (this.VS != null) {
      this.VS.onAnimationRepeat(paramAnimation);
    }
    AppMethodBeat.o(212484);
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    AppMethodBeat.i(212481);
    if (this.VS != null) {
      this.VS.onAnimationStart(paramAnimation);
    }
    AppMethodBeat.o(212481);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.fragment.app.FragmentManagerImpl.b
 * JD-Core Version:    0.7.0.1
 */