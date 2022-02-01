package androidx.fragment.app;

import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FragmentManagerImpl$a
  extends FragmentManagerImpl.b
{
  View mView;
  
  FragmentManagerImpl$a(View paramView, Animation.AnimationListener paramAnimationListener)
  {
    super(paramAnimationListener);
    this.mView = paramView;
  }
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(212476);
    if ((w.al(this.mView)) || (Build.VERSION.SDK_INT >= 24)) {
      this.mView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(212468);
          FragmentManagerImpl.a.this.mView.setLayerType(0, null);
          AppMethodBeat.o(212468);
        }
      });
    }
    for (;;)
    {
      super.onAnimationEnd(paramAnimation);
      AppMethodBeat.o(212476);
      return;
      this.mView.setLayerType(0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.fragment.app.FragmentManagerImpl.a
 * JD-Core Version:    0.7.0.1
 */