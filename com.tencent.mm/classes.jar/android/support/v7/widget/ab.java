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
  private final float anH;
  private final int anI;
  private final int anJ;
  final View anK;
  private Runnable anL;
  private Runnable anM;
  private boolean anN;
  private final int[] anO = new int[2];
  private int mActivePointerId;
  
  public ab(View paramView)
  {
    this.anK = paramView;
    paramView.setLongClickable(true);
    paramView.addOnAttachStateChangeListener(this);
    this.anH = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
    this.anI = ViewConfiguration.getTapTimeout();
    this.anJ = ((this.anI + ViewConfiguration.getLongPressTimeout()) / 2);
  }
  
  private void jJ()
  {
    if (this.anM != null) {
      this.anK.removeCallbacks(this.anM);
    }
    if (this.anL != null) {
      this.anK.removeCallbacks(this.anL);
    }
  }
  
  public abstract s hO();
  
  protected boolean hP()
  {
    s locals = hO();
    if ((locals != null) && (!locals.isShowing())) {
      locals.show();
    }
    return true;
  }
  
  protected boolean iI()
  {
    s locals = hO();
    if ((locals != null) && (locals.isShowing())) {
      locals.dismiss();
    }
    return true;
  }
  
  final void jK()
  {
    jJ();
    View localView = this.anK;
    if ((!localView.isEnabled()) || (localView.isLongClickable())) {}
    while (!hP()) {
      return;
    }
    localView.getParent().requestDisallowInterceptTouchEvent(true);
    long l = SystemClock.uptimeMillis();
    MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
    localView.onTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
    this.anN = true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool3 = this.anN;
    int i;
    if (bool3)
    {
      paramView = this.anK;
      Object localObject = hO();
      if ((localObject == null) || (!((s)localObject).isShowing()))
      {
        i = 0;
        if ((i == 0) && (iI())) {
          break label241;
        }
      }
      label235:
      label241:
      for (bool1 = true;; bool1 = false)
      {
        this.anN = bool1;
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
        int[] arrayOfInt = this.anO;
        paramView.getLocationOnScreen(arrayOfInt);
        localMotionEvent.offsetLocation(arrayOfInt[0], arrayOfInt[1]);
        paramView = this.anO;
        ((View)localObject).getLocationOnScreen(paramView);
        localMotionEvent.offsetLocation(-paramView[0], -paramView[1]);
        bool1 = ((y)localObject).f(localMotionEvent, this.mActivePointerId);
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
    paramView = this.anK;
    if (paramView.isEnabled()) {}
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      label292:
      i = 0;
      label295:
      if ((i == 0) || (!hP())) {
        break;
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (bool1)
      {
        long l = SystemClock.uptimeMillis();
        paramView = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        this.anK.onTouchEvent(paramView);
        paramView.recycle();
      }
      break;
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      if (this.anL == null) {
        this.anL = new a();
      }
      paramView.postDelayed(this.anL, this.anI);
      if (this.anM == null) {
        this.anM = new b();
      }
      paramView.postDelayed(this.anM, this.anJ);
      break label292;
      i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      if (i < 0) {
        break label292;
      }
      float f1 = paramMotionEvent.getX(i);
      float f2 = paramMotionEvent.getY(i);
      float f3 = this.anH;
      if ((f1 >= -f3) && (f2 >= -f3) && (f1 < paramView.getRight() - paramView.getLeft() + f3) && (f2 < paramView.getBottom() - paramView.getTop() + f3)) {}
      for (i = 1; i == 0; i = 0)
      {
        jJ();
        paramView.getParent().requestDisallowInterceptTouchEvent(true);
        i = 1;
        break label295;
      }
      jJ();
      break label292;
    }
  }
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    this.anN = false;
    this.mActivePointerId = -1;
    if (this.anL != null) {
      this.anK.removeCallbacks(this.anL);
    }
  }
  
  final class a
    implements Runnable
  {
    a() {}
    
    public final void run()
    {
      ViewParent localViewParent = ab.this.anK.getParent();
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
      ab.this.jK();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ab
 * JD-Core Version:    0.7.0.1
 */