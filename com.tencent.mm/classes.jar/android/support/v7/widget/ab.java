package android.support.v7.widget;

import android.os.SystemClock;
import android.support.v7.view.menu.s;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;

public abstract class ab
  implements View.OnAttachStateChangeListener, View.OnTouchListener
{
  private Runnable anA;
  private boolean anB;
  private final int[] anC = new int[2];
  private final float anv;
  private final int anw;
  private final int anx;
  final View any;
  private Runnable anz;
  private int mActivePointerId;
  
  public ab(View paramView)
  {
    this.any = paramView;
    paramView.setLongClickable(true);
    paramView.addOnAttachStateChangeListener(this);
    this.anv = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
    this.anw = ViewConfiguration.getTapTimeout();
    this.anx = ((this.anw + ViewConfiguration.getLongPressTimeout()) / 2);
  }
  
  private void jA()
  {
    if (this.anA != null) {
      this.any.removeCallbacks(this.anA);
    }
    if (this.anz != null) {
      this.any.removeCallbacks(this.anz);
    }
  }
  
  public abstract s hF();
  
  protected boolean hG()
  {
    s locals = hF();
    if ((locals != null) && (!locals.isShowing())) {
      locals.show();
    }
    return true;
  }
  
  protected boolean iz()
  {
    s locals = hF();
    if ((locals != null) && (locals.isShowing())) {
      locals.dismiss();
    }
    return true;
  }
  
  final void jB()
  {
    jA();
    View localView = this.any;
    if ((!localView.isEnabled()) || (localView.isLongClickable())) {}
    while (!hG()) {
      return;
    }
    localView.getParent().requestDisallowInterceptTouchEvent(true);
    long l = SystemClock.uptimeMillis();
    MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
    localView.onTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
    this.anB = true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool3 = this.anB;
    int i;
    if (bool3)
    {
      paramView = this.any;
      Object localObject = hF();
      if ((localObject == null) || (!((s)localObject).isShowing()))
      {
        i = 0;
        if ((i == 0) && (iz())) {
          break label241;
        }
      }
      label235:
      label241:
      for (bool1 = true;; bool1 = false)
      {
        this.anB = bool1;
        if (!bool1)
        {
          bool1 = bool2;
          if (!bool3) {}
        }
        else
        {
          bool1 = true;
        }
        return bool1;
        localObject = (y)((s)localObject).getListView();
        if ((localObject == null) || (!((y)localObject).isShown()))
        {
          i = 0;
          break;
        }
        MotionEvent localMotionEvent = MotionEvent.obtainNoHistory(paramMotionEvent);
        int[] arrayOfInt = this.anC;
        paramView.getLocationOnScreen(arrayOfInt);
        localMotionEvent.offsetLocation(arrayOfInt[0], arrayOfInt[1]);
        paramView = this.anC;
        ((View)localObject).getLocationOnScreen(paramView);
        localMotionEvent.offsetLocation(-paramView[0], -paramView[1]);
        bool1 = ((y)localObject).b(localMotionEvent, this.mActivePointerId);
        localMotionEvent.recycle();
        i = paramMotionEvent.getActionMasked();
        if ((i != 1) && (i != 3)) {}
        for (i = 1;; i = 0)
        {
          if ((!bool1) || (i == 0)) {
            break label235;
          }
          i = 1;
          break;
        }
        i = 0;
        break;
      }
    }
    paramView = this.any;
    if (paramView.isEnabled()) {}
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      label292:
      i = 0;
      label295:
      if ((i == 0) || (!hG())) {
        break;
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (bool1)
      {
        long l = SystemClock.uptimeMillis();
        paramView = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        this.any.onTouchEvent(paramView);
        paramView.recycle();
      }
      break;
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      if (this.anz == null) {
        this.anz = new a();
      }
      paramView.postDelayed(this.anz, this.anw);
      if (this.anA == null) {
        this.anA = new b();
      }
      paramView.postDelayed(this.anA, this.anx);
      break label292;
      i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      if (i < 0) {
        break label292;
      }
      float f1 = paramMotionEvent.getX(i);
      float f2 = paramMotionEvent.getY(i);
      float f3 = this.anv;
      if ((f1 >= -f3) && (f2 >= -f3) && (f1 < paramView.getRight() - paramView.getLeft() + f3) && (f2 < paramView.getBottom() - paramView.getTop() + f3)) {}
      for (i = 1; i == 0; i = 0)
      {
        jA();
        paramView.getParent().requestDisallowInterceptTouchEvent(true);
        i = 1;
        break label295;
      }
      jA();
      break label292;
    }
  }
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    this.anB = false;
    this.mActivePointerId = -1;
    if (this.anz != null) {
      this.any.removeCallbacks(this.anz);
    }
  }
  
  final class a
    implements Runnable
  {
    a() {}
    
    public final void run()
    {
      ViewParent localViewParent = ab.this.any.getParent();
      if (localViewParent != null) {
        localViewParent.requestDisallowInterceptTouchEvent(true);
      }
    }
  }
  
  final class b
    implements Runnable
  {
    b() {}
    
    public final void run()
    {
      ab.this.jB();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ab
 * JD-Core Version:    0.7.0.1
 */