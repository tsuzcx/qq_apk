package android.support.v4.app;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

final class w
  implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener
{
  private ViewTreeObserver GE;
  private final Runnable mRunnable;
  private final View mView;
  
  private w(View paramView, Runnable paramRunnable)
  {
    this.mView = paramView;
    this.GE = paramView.getViewTreeObserver();
    this.mRunnable = paramRunnable;
  }
  
  public static w a(View paramView, Runnable paramRunnable)
  {
    paramRunnable = new w(paramView, paramRunnable);
    paramView.getViewTreeObserver().addOnPreDrawListener(paramRunnable);
    paramView.addOnAttachStateChangeListener(paramRunnable);
    return paramRunnable;
  }
  
  private void removeListener()
  {
    if (this.GE.isAlive()) {
      this.GE.removeOnPreDrawListener(this);
    }
    for (;;)
    {
      this.mView.removeOnAttachStateChangeListener(this);
      return;
      this.mView.getViewTreeObserver().removeOnPreDrawListener(this);
    }
  }
  
  public final boolean onPreDraw()
  {
    removeListener();
    this.mRunnable.run();
    return true;
  }
  
  public final void onViewAttachedToWindow(View paramView)
  {
    this.GE = paramView.getViewTreeObserver();
  }
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    removeListener();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.w
 * JD-Core Version:    0.7.0.1
 */