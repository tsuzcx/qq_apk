package android.support.v4.view;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

final class c$b
  implements c.a
{
  private static final int Fx = ;
  private static final int Fy = ViewConfiguration.getTapTimeout();
  private static final int Fz = ViewConfiguration.getDoubleTapTimeout();
  final GestureDetector.OnGestureListener FA;
  GestureDetector.OnDoubleTapListener FB;
  boolean FC;
  boolean FD;
  boolean FE;
  private boolean FF;
  private boolean FG;
  MotionEvent FH;
  private MotionEvent FI;
  private boolean FJ;
  private float FK;
  private float FL;
  private float FM;
  private float FN;
  private boolean FO;
  private int Ft;
  private int Fu;
  private int Fv;
  private int Fw;
  final Handler mHandler = new c.b.a(this);
  private VelocityTracker mVelocityTracker;
  
  c$b(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
  {
    this.FA = paramOnGestureListener;
    if ((paramOnGestureListener instanceof GestureDetector.OnDoubleTapListener)) {
      this.FB = ((GestureDetector.OnDoubleTapListener)paramOnGestureListener);
    }
    if (paramContext == null) {
      throw new IllegalArgumentException("Context must not be null");
    }
    if (this.FA == null) {
      throw new IllegalArgumentException("OnGestureListener must not be null");
    }
    this.FO = true;
    paramContext = ViewConfiguration.get(paramContext);
    int i = paramContext.getScaledTouchSlop();
    int j = paramContext.getScaledDoubleTapSlop();
    this.Fv = paramContext.getScaledMinimumFlingVelocity();
    this.Fw = paramContext.getScaledMaximumFlingVelocity();
    this.Ft = (i * i);
    this.Fu = (j * j);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    int i;
    if ((i1 & 0xFF) == 6)
    {
      i = 1;
      if (i == 0) {
        break label127;
      }
    }
    int n;
    int m;
    float f1;
    float f2;
    float f4;
    float f3;
    label127:
    for (int k = paramMotionEvent.getActionIndex();; k = -1)
    {
      n = paramMotionEvent.getPointerCount();
      m = 0;
      f1 = 0.0F;
      for (f2 = 0.0F; m < n; f2 = f3)
      {
        f4 = f1;
        f3 = f2;
        if (k != m)
        {
          f3 = f2 + paramMotionEvent.getX(m);
          f4 = f1 + paramMotionEvent.getY(m);
        }
        m += 1;
        f1 = f4;
      }
      i = 0;
      break;
    }
    if (i != 0)
    {
      i = n - 1;
      f2 /= i;
      f1 /= i;
    }
    boolean bool2;
    MotionEvent localMotionEvent;
    Object localObject;
    label757:
    int j;
    switch (i1 & 0xFF)
    {
    case 4: 
    default: 
    case 5: 
    case 6: 
    case 0: 
    case 2: 
      do
      {
        do
        {
          return false;
          i = n;
          break;
          this.FK = f2;
          this.FM = f2;
          this.FL = f1;
          this.FN = f1;
          this.mHandler.removeMessages(1);
          this.mHandler.removeMessages(2);
          this.mHandler.removeMessages(3);
          this.FJ = false;
          this.FF = false;
          this.FG = false;
          this.FD = false;
        } while (!this.FE);
        this.FE = false;
        return false;
        this.FK = f2;
        this.FM = f2;
        this.FL = f1;
        this.FN = f1;
        this.mVelocityTracker.computeCurrentVelocity(1000, this.Fw);
        k = paramMotionEvent.getActionIndex();
        i = paramMotionEvent.getPointerId(k);
        f1 = this.mVelocityTracker.getXVelocity(i);
        f2 = this.mVelocityTracker.getYVelocity(i);
        i = 0;
        while (i < n)
        {
          if (i != k)
          {
            m = paramMotionEvent.getPointerId(i);
            f3 = this.mVelocityTracker.getXVelocity(m);
            if (this.mVelocityTracker.getYVelocity(m) * f2 + f3 * f1 < 0.0F)
            {
              this.mVelocityTracker.clear();
              return false;
            }
          }
          i += 1;
        }
        if (this.FB != null)
        {
          bool2 = this.mHandler.hasMessages(3);
          if (bool2) {
            this.mHandler.removeMessages(3);
          }
          if ((this.FH != null) && (this.FI != null) && (bool2))
          {
            localMotionEvent = this.FH;
            localObject = this.FI;
            if ((this.FG) && (paramMotionEvent.getEventTime() - ((MotionEvent)localObject).getEventTime() <= Fz))
            {
              i = (int)localMotionEvent.getX() - (int)paramMotionEvent.getX();
              k = (int)localMotionEvent.getY() - (int)paramMotionEvent.getY();
              if (k * k + i * i < this.Fu)
              {
                i = 1;
                if (i == 0) {
                  break label757;
                }
                this.FJ = true;
              }
            }
          }
        }
        for (boolean bool1 = this.FB.onDoubleTap(this.FH) | false | this.FB.onDoubleTapEvent(paramMotionEvent);; bool1 = false)
        {
          this.FK = f2;
          this.FM = f2;
          this.FL = f1;
          this.FN = f1;
          if (this.FH != null) {
            this.FH.recycle();
          }
          this.FH = MotionEvent.obtain(paramMotionEvent);
          this.FF = true;
          this.FG = true;
          this.FC = true;
          this.FE = false;
          this.FD = false;
          if (this.FO)
          {
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageAtTime(2, this.FH.getDownTime() + Fy + Fx);
          }
          this.mHandler.sendEmptyMessageAtTime(1, this.FH.getDownTime() + Fy);
          return bool1 | this.FA.onDown(paramMotionEvent);
          bool1 = false;
          break;
          this.mHandler.sendEmptyMessageDelayed(3, Fz);
        }
      } while (this.FE);
      f3 = this.FK - f2;
      f4 = this.FL - f1;
      if (this.FJ) {
        return this.FB.onDoubleTapEvent(paramMotionEvent) | false;
      }
      if (this.FF)
      {
        j = (int)(f2 - this.FM);
        k = (int)(f1 - this.FN);
        j = j * j + k * k;
        if (j <= this.Ft) {
          break label1350;
        }
        bool2 = this.FA.onScroll(this.FH, paramMotionEvent, f3, f4);
        this.FK = f2;
        this.FL = f1;
        this.FF = false;
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
      }
      break;
    }
    for (;;)
    {
      if (j > this.Ft) {
        this.FG = false;
      }
      return bool2;
      if ((Math.abs(f3) < 1.0F) && (Math.abs(f4) < 1.0F)) {
        break;
      }
      bool2 = this.FA.onScroll(this.FH, paramMotionEvent, f3, f4);
      this.FK = f2;
      this.FL = f1;
      return bool2;
      this.FC = false;
      localMotionEvent = MotionEvent.obtain(paramMotionEvent);
      if (this.FJ) {
        bool2 = this.FB.onDoubleTapEvent(paramMotionEvent) | false;
      }
      for (;;)
      {
        if (this.FI != null) {
          this.FI.recycle();
        }
        this.FI = localMotionEvent;
        if (this.mVelocityTracker != null)
        {
          this.mVelocityTracker.recycle();
          this.mVelocityTracker = null;
        }
        this.FJ = false;
        this.FD = false;
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        return bool2;
        if (this.FE)
        {
          this.mHandler.removeMessages(3);
          this.FE = false;
          bool2 = false;
        }
        else if (this.FF)
        {
          boolean bool3 = this.FA.onSingleTapUp(paramMotionEvent);
          bool2 = bool3;
          if (this.FD)
          {
            bool2 = bool3;
            if (this.FB != null)
            {
              this.FB.onSingleTapConfirmed(paramMotionEvent);
              bool2 = bool3;
            }
          }
        }
        else
        {
          localObject = this.mVelocityTracker;
          j = paramMotionEvent.getPointerId(0);
          ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.Fw);
          f1 = ((VelocityTracker)localObject).getYVelocity(j);
          f2 = ((VelocityTracker)localObject).getXVelocity(j);
          if ((Math.abs(f1) > this.Fv) || (Math.abs(f2) > this.Fv))
          {
            bool2 = this.FA.onFling(this.FH, paramMotionEvent, f2, f1);
            continue;
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
            this.FJ = false;
            this.FC = false;
            this.FF = false;
            this.FG = false;
            this.FD = false;
            if (!this.FE) {
              break;
            }
            this.FE = false;
            return false;
          }
          bool2 = false;
        }
      }
      label1350:
      bool2 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.view.c.b
 * JD-Core Version:    0.7.0.1
 */