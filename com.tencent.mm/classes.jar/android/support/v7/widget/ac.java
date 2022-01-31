package android.support.v7.widget;

import android.os.SystemClock;
import android.support.v7.view.menu.s;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;

public abstract class ac
  implements View.OnAttachStateChangeListener, View.OnTouchListener
{
  private final float acT;
  private final int acU;
  private final int acV;
  final View acW;
  private Runnable acX;
  private Runnable acY;
  boolean acZ;
  private final int[] ada = new int[2];
  private int fC;
  
  public ac(View paramView)
  {
    this.acW = paramView;
    paramView.setLongClickable(true);
    paramView.addOnAttachStateChangeListener(this);
    this.acT = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
    this.acU = ViewConfiguration.getTapTimeout();
    this.acV = ((this.acU + ViewConfiguration.getLongPressTimeout()) / 2);
  }
  
  public abstract s eX();
  
  public boolean eY()
  {
    s locals = eX();
    if ((locals != null) && (!locals.isShowing())) {
      locals.show();
    }
    return true;
  }
  
  protected boolean fK()
  {
    s locals = eX();
    if ((locals != null) && (locals.isShowing())) {
      locals.dismiss();
    }
    return true;
  }
  
  final void gG()
  {
    if (this.acY != null) {
      this.acW.removeCallbacks(this.acY);
    }
    if (this.acX != null) {
      this.acW.removeCallbacks(this.acX);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool3 = this.acZ;
    int i;
    if (bool3)
    {
      paramView = this.acW;
      Object localObject = eX();
      if ((localObject == null) || (!((s)localObject).isShowing()))
      {
        i = 0;
        if ((i == 0) && (fK())) {
          break label241;
        }
      }
      label235:
      label241:
      for (bool1 = true;; bool1 = false)
      {
        this.acZ = bool1;
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
        localObject = (z)((s)localObject).getListView();
        if ((localObject == null) || (!((z)localObject).isShown()))
        {
          i = 0;
          break;
        }
        MotionEvent localMotionEvent = MotionEvent.obtainNoHistory(paramMotionEvent);
        int[] arrayOfInt = this.ada;
        paramView.getLocationOnScreen(arrayOfInt);
        localMotionEvent.offsetLocation(arrayOfInt[0], arrayOfInt[1]);
        paramView = this.ada;
        ((View)localObject).getLocationOnScreen(paramView);
        localMotionEvent.offsetLocation(-paramView[0], -paramView[1]);
        bool1 = ((z)localObject).b(localMotionEvent, this.fC);
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
    paramView = this.acW;
    if (paramView.isEnabled()) {}
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      label292:
      i = 0;
      label295:
      if ((i == 0) || (!eY())) {
        break;
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (bool1)
      {
        long l = SystemClock.uptimeMillis();
        paramView = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        this.acW.onTouchEvent(paramView);
        paramView.recycle();
      }
      break;
      this.fC = paramMotionEvent.getPointerId(0);
      if (this.acX == null) {
        this.acX = new a();
      }
      paramView.postDelayed(this.acX, this.acU);
      if (this.acY == null) {
        this.acY = new b();
      }
      paramView.postDelayed(this.acY, this.acV);
      break label292;
      i = paramMotionEvent.findPointerIndex(this.fC);
      if (i < 0) {
        break label292;
      }
      float f1 = paramMotionEvent.getX(i);
      float f2 = paramMotionEvent.getY(i);
      float f3 = this.acT;
      if ((f1 >= -f3) && (f2 >= -f3) && (f1 < paramView.getRight() - paramView.getLeft() + f3) && (f2 < paramView.getBottom() - paramView.getTop() + f3)) {}
      for (i = 1; i == 0; i = 0)
      {
        gG();
        paramView.getParent().requestDisallowInterceptTouchEvent(true);
        i = 1;
        break label295;
      }
      gG();
      break label292;
    }
  }
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    this.acZ = false;
    this.fC = -1;
    if (this.acX != null) {
      this.acW.removeCallbacks(this.acX);
    }
  }
  
  private final class a
    implements Runnable
  {
    a() {}
    
    public final void run()
    {
      ViewParent localViewParent = ac.this.acW.getParent();
      if (localViewParent != null) {
        localViewParent.requestDisallowInterceptTouchEvent(true);
      }
    }
  }
  
  private final class b
    implements Runnable
  {
    b() {}
    
    public final void run()
    {
      ac localac = ac.this;
      localac.gG();
      View localView = localac.acW;
      if ((!localView.isEnabled()) || (localView.isLongClickable())) {}
      while (!localac.eY()) {
        return;
      }
      localView.getParent().requestDisallowInterceptTouchEvent(true);
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
      localView.onTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
      localac.acZ = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ac
 * JD-Core Version:    0.7.0.1
 */