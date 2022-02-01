package androidx.core.g;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class u
  implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener
{
  private ViewTreeObserver btw;
  private final Runnable mRunnable;
  private final View mView;
  
  private u(View paramView, Runnable paramRunnable)
  {
    AppMethodBeat.i(195676);
    this.mView = paramView;
    this.btw = paramView.getViewTreeObserver();
    this.mRunnable = paramRunnable;
    AppMethodBeat.o(195676);
  }
  
  public static u a(View paramView, Runnable paramRunnable)
  {
    AppMethodBeat.i(195681);
    if (paramView == null)
    {
      paramView = new NullPointerException("view == null");
      AppMethodBeat.o(195681);
      throw paramView;
    }
    paramRunnable = new u(paramView, paramRunnable);
    paramView.getViewTreeObserver().addOnPreDrawListener(paramRunnable);
    paramView.addOnAttachStateChangeListener(paramRunnable);
    AppMethodBeat.o(195681);
    return paramRunnable;
  }
  
  private void removeListener()
  {
    AppMethodBeat.i(195686);
    if (this.btw.isAlive()) {
      this.btw.removeOnPreDrawListener(this);
    }
    for (;;)
    {
      this.mView.removeOnAttachStateChangeListener(this);
      AppMethodBeat.o(195686);
      return;
      this.mView.getViewTreeObserver().removeOnPreDrawListener(this);
    }
  }
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(195692);
    removeListener();
    this.mRunnable.run();
    AppMethodBeat.o(195692);
    return true;
  }
  
  public final void onViewAttachedToWindow(View paramView)
  {
    AppMethodBeat.i(195697);
    this.btw = paramView.getViewTreeObserver();
    AppMethodBeat.o(195697);
  }
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    AppMethodBeat.i(195703);
    removeListener();
    AppMethodBeat.o(195703);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.core.g.u
 * JD-Core Version:    0.7.0.1
 */