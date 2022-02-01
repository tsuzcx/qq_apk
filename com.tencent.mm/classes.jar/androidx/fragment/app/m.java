package androidx.fragment.app;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class m
  implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener
{
  private ViewTreeObserver Xj;
  private final Runnable mRunnable;
  private final View mView;
  
  private m(View paramView, Runnable paramRunnable)
  {
    AppMethodBeat.i(213127);
    this.mView = paramView;
    this.Xj = paramView.getViewTreeObserver();
    this.mRunnable = paramRunnable;
    AppMethodBeat.o(213127);
  }
  
  public static m b(View paramView, Runnable paramRunnable)
  {
    AppMethodBeat.i(213130);
    paramRunnable = new m(paramView, paramRunnable);
    paramView.getViewTreeObserver().addOnPreDrawListener(paramRunnable);
    paramView.addOnAttachStateChangeListener(paramRunnable);
    AppMethodBeat.o(213130);
    return paramRunnable;
  }
  
  private void removeListener()
  {
    AppMethodBeat.i(213134);
    if (this.Xj.isAlive()) {
      this.Xj.removeOnPreDrawListener(this);
    }
    for (;;)
    {
      this.mView.removeOnAttachStateChangeListener(this);
      AppMethodBeat.o(213134);
      return;
      this.mView.getViewTreeObserver().removeOnPreDrawListener(this);
    }
  }
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(213132);
    removeListener();
    this.mRunnable.run();
    AppMethodBeat.o(213132);
    return true;
  }
  
  public final void onViewAttachedToWindow(View paramView)
  {
    AppMethodBeat.i(213135);
    this.Xj = paramView.getViewTreeObserver();
    AppMethodBeat.o(213135);
  }
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    AppMethodBeat.i(213137);
    removeListener();
    AppMethodBeat.o(213137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.fragment.app.m
 * JD-Core Version:    0.7.0.1
 */