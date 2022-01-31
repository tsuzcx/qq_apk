package android.support.v4.app;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

final class ab
  implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener
{
  private final Runnable mRunnable;
  private final View mView;
  private ViewTreeObserver yK;
  
  private ab(View paramView, Runnable paramRunnable)
  {
    this.mView = paramView;
    this.yK = paramView.getViewTreeObserver();
    this.mRunnable = paramRunnable;
  }
  
  public static ab a(View paramView, Runnable paramRunnable)
  {
    paramRunnable = new ab(paramView, paramRunnable);
    paramView.getViewTreeObserver().addOnPreDrawListener(paramRunnable);
    paramView.addOnAttachStateChangeListener(paramRunnable);
    return paramRunnable;
  }
  
  private void ch()
  {
    if (this.yK.isAlive()) {
      this.yK.removeOnPreDrawListener(this);
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
    ch();
    this.mRunnable.run();
    return true;
  }
  
  public final void onViewAttachedToWindow(View paramView)
  {
    this.yK = paramView.getViewTreeObserver();
  }
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    ch();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.ab
 * JD-Core Version:    0.7.0.1
 */