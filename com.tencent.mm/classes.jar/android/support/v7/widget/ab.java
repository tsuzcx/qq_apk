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
  private final float akK;
  private final int akL;
  private final int akM;
  final View akN;
  private Runnable akO;
  private Runnable akP;
  private boolean akQ;
  private final int[] akR = new int[2];
  private int mActivePointerId;
  
  public ab(View paramView)
  {
    this.akN = paramView;
    paramView.setLongClickable(true);
    paramView.addOnAttachStateChangeListener(this);
    this.akK = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
    this.akL = ViewConfiguration.getTapTimeout();
    this.akM = ((this.akL + ViewConfiguration.getLongPressTimeout()) / 2);
  }
  
  private void jc()
  {
    if (this.akP != null) {
      this.akN.removeCallbacks(this.akP);
    }
    if (this.akO != null) {
      this.akN.removeCallbacks(this.akO);
    }
  }
  
  protected boolean hZ()
  {
    s locals = hh();
    if ((locals != null) && (locals.isShowing())) {
      locals.dismiss();
    }
    return true;
  }
  
  public abstract s hh();
  
  protected boolean hi()
  {
    s locals = hh();
    if ((locals != null) && (!locals.isShowing())) {
      locals.show();
    }
    return true;
  }
  
  final void jd()
  {
    jc();
    View localView = this.akN;
    if ((!localView.isEnabled()) || (localView.isLongClickable())) {}
    while (!hi()) {
      return;
    }
    localView.getParent().requestDisallowInterceptTouchEvent(true);
    long l = SystemClock.uptimeMillis();
    MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
    localView.onTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
    this.akQ = true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool3 = this.akQ;
    int i;
    if (bool3)
    {
      paramView = this.akN;
      Object localObject = hh();
      if ((localObject == null) || (!((s)localObject).isShowing()))
      {
        i = 0;
        if ((i == 0) && (hZ())) {
          break label241;
        }
      }
      label235:
      label241:
      for (bool1 = true;; bool1 = false)
      {
        this.akQ = bool1;
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
        int[] arrayOfInt = this.akR;
        paramView.getLocationOnScreen(arrayOfInt);
        localMotionEvent.offsetLocation(arrayOfInt[0], arrayOfInt[1]);
        paramView = this.akR;
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
    paramView = this.akN;
    if (paramView.isEnabled()) {}
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      label292:
      i = 0;
      label295:
      if ((i == 0) || (!hi())) {
        break;
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (bool1)
      {
        long l = SystemClock.uptimeMillis();
        paramView = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        this.akN.onTouchEvent(paramView);
        paramView.recycle();
      }
      break;
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      if (this.akO == null) {
        this.akO = new a();
      }
      paramView.postDelayed(this.akO, this.akL);
      if (this.akP == null) {
        this.akP = new b();
      }
      paramView.postDelayed(this.akP, this.akM);
      break label292;
      i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      if (i < 0) {
        break label292;
      }
      float f1 = paramMotionEvent.getX(i);
      float f2 = paramMotionEvent.getY(i);
      float f3 = this.akK;
      if ((f1 >= -f3) && (f2 >= -f3) && (f1 < paramView.getRight() - paramView.getLeft() + f3) && (f2 < paramView.getBottom() - paramView.getTop() + f3)) {}
      for (i = 1; i == 0; i = 0)
      {
        jc();
        paramView.getParent().requestDisallowInterceptTouchEvent(true);
        i = 1;
        break label295;
      }
      jc();
      break label292;
    }
  }
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    this.akQ = false;
    this.mActivePointerId = -1;
    if (this.akO != null) {
      this.akN.removeCallbacks(this.akO);
    }
  }
  
  final class a
    implements Runnable
  {
    a() {}
    
    public final void run()
    {
      ViewParent localViewParent = ab.this.akN.getParent();
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
      ab.this.jd();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ab
 * JD-Core Version:    0.7.0.1
 */