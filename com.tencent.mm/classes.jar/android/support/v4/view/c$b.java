package android.support.v4.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

final class c$b
  implements c.a
{
  private static final int Pv = ;
  private static final int Pw = ViewConfiguration.getTapTimeout();
  private static final int Px = ViewConfiguration.getDoubleTapTimeout();
  boolean PA;
  boolean PB;
  boolean PC;
  private boolean PD;
  private boolean PE;
  MotionEvent PF;
  private MotionEvent PG;
  private boolean PH;
  private float PI;
  private float PJ;
  private float PK;
  private float PL;
  private boolean PM;
  private int Pr;
  private int Ps;
  private int Pt;
  private int Pu;
  final GestureDetector.OnGestureListener Py;
  GestureDetector.OnDoubleTapListener Pz;
  final Handler mHandler = new a();
  private VelocityTracker mVelocityTracker;
  
  c$b(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
  {
    this.Py = paramOnGestureListener;
    if ((paramOnGestureListener instanceof GestureDetector.OnDoubleTapListener)) {
      this.Pz = ((GestureDetector.OnDoubleTapListener)paramOnGestureListener);
    }
    if (paramContext == null) {
      throw new IllegalArgumentException("Context must not be null");
    }
    if (this.Py == null) {
      throw new IllegalArgumentException("OnGestureListener must not be null");
    }
    this.PM = true;
    paramContext = ViewConfiguration.get(paramContext);
    int i = paramContext.getScaledTouchSlop();
    int j = paramContext.getScaledDoubleTapSlop();
    this.Pt = paramContext.getScaledMinimumFlingVelocity();
    this.Pu = paramContext.getScaledMaximumFlingVelocity();
    this.Pr = (i * i);
    this.Ps = (j * j);
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
          this.PI = f2;
          this.PK = f2;
          this.PJ = f1;
          this.PL = f1;
          this.mHandler.removeMessages(1);
          this.mHandler.removeMessages(2);
          this.mHandler.removeMessages(3);
          this.PH = false;
          this.PD = false;
          this.PE = false;
          this.PB = false;
        } while (!this.PC);
        this.PC = false;
        return false;
        this.PI = f2;
        this.PK = f2;
        this.PJ = f1;
        this.PL = f1;
        this.mVelocityTracker.computeCurrentVelocity(1000, this.Pu);
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
        if (this.Pz != null)
        {
          bool2 = this.mHandler.hasMessages(3);
          if (bool2) {
            this.mHandler.removeMessages(3);
          }
          if ((this.PF != null) && (this.PG != null) && (bool2))
          {
            localMotionEvent = this.PF;
            localObject = this.PG;
            if ((this.PE) && (paramMotionEvent.getEventTime() - ((MotionEvent)localObject).getEventTime() <= Px))
            {
              i = (int)localMotionEvent.getX() - (int)paramMotionEvent.getX();
              k = (int)localMotionEvent.getY() - (int)paramMotionEvent.getY();
              if (k * k + i * i < this.Ps)
              {
                i = 1;
                if (i == 0) {
                  break label757;
                }
                this.PH = true;
              }
            }
          }
        }
        for (boolean bool1 = this.Pz.onDoubleTap(this.PF) | false | this.Pz.onDoubleTapEvent(paramMotionEvent);; bool1 = false)
        {
          this.PI = f2;
          this.PK = f2;
          this.PJ = f1;
          this.PL = f1;
          if (this.PF != null) {
            this.PF.recycle();
          }
          this.PF = MotionEvent.obtain(paramMotionEvent);
          this.PD = true;
          this.PE = true;
          this.PA = true;
          this.PC = false;
          this.PB = false;
          if (this.PM)
          {
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageAtTime(2, this.PF.getDownTime() + Pw + Pv);
          }
          this.mHandler.sendEmptyMessageAtTime(1, this.PF.getDownTime() + Pw);
          return bool1 | this.Py.onDown(paramMotionEvent);
          bool1 = false;
          break;
          this.mHandler.sendEmptyMessageDelayed(3, Px);
        }
      } while (this.PC);
      f3 = this.PI - f2;
      f4 = this.PJ - f1;
      if (this.PH) {
        return this.Pz.onDoubleTapEvent(paramMotionEvent) | false;
      }
      if (this.PD)
      {
        j = (int)(f2 - this.PK);
        k = (int)(f1 - this.PL);
        j = j * j + k * k;
        if (j <= this.Pr) {
          break label1350;
        }
        bool2 = this.Py.onScroll(this.PF, paramMotionEvent, f3, f4);
        this.PI = f2;
        this.PJ = f1;
        this.PD = false;
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
      }
      break;
    }
    for (;;)
    {
      if (j > this.Pr) {
        this.PE = false;
      }
      return bool2;
      if ((Math.abs(f3) < 1.0F) && (Math.abs(f4) < 1.0F)) {
        break;
      }
      bool2 = this.Py.onScroll(this.PF, paramMotionEvent, f3, f4);
      this.PI = f2;
      this.PJ = f1;
      return bool2;
      this.PA = false;
      localMotionEvent = MotionEvent.obtain(paramMotionEvent);
      if (this.PH) {
        bool2 = this.Pz.onDoubleTapEvent(paramMotionEvent) | false;
      }
      for (;;)
      {
        if (this.PG != null) {
          this.PG.recycle();
        }
        this.PG = localMotionEvent;
        if (this.mVelocityTracker != null)
        {
          this.mVelocityTracker.recycle();
          this.mVelocityTracker = null;
        }
        this.PH = false;
        this.PB = false;
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        return bool2;
        if (this.PC)
        {
          this.mHandler.removeMessages(3);
          this.PC = false;
          bool2 = false;
        }
        else if (this.PD)
        {
          boolean bool3 = this.Py.onSingleTapUp(paramMotionEvent);
          bool2 = bool3;
          if (this.PB)
          {
            bool2 = bool3;
            if (this.Pz != null)
            {
              this.Pz.onSingleTapConfirmed(paramMotionEvent);
              bool2 = bool3;
            }
          }
        }
        else
        {
          localObject = this.mVelocityTracker;
          j = paramMotionEvent.getPointerId(0);
          ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.Pu);
          f1 = ((VelocityTracker)localObject).getYVelocity(j);
          f2 = ((VelocityTracker)localObject).getXVelocity(j);
          if ((Math.abs(f1) > this.Pt) || (Math.abs(f2) > this.Pt))
          {
            bool2 = this.Py.onFling(this.PF, paramMotionEvent, f2, f1);
            continue;
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
            this.PH = false;
            this.PA = false;
            this.PD = false;
            this.PE = false;
            this.PB = false;
            if (!this.PC) {
              break;
            }
            this.PC = false;
            return false;
          }
          bool2 = false;
        }
      }
      label1350:
      bool2 = false;
    }
  }
  
  final class a
    extends Handler
  {
    a() {}
    
    public final void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        throw new RuntimeException("Unknown message ".concat(String.valueOf(paramMessage)));
      case 1: 
        c.b.this.Py.onShowPress(c.b.this.PF);
      }
      do
      {
        return;
        paramMessage = c.b.this;
        paramMessage.mHandler.removeMessages(3);
        paramMessage.PB = false;
        paramMessage.PC = true;
        paramMessage.Py.onLongPress(paramMessage.PF);
        return;
      } while (c.b.this.Pz == null);
      if (!c.b.this.PA)
      {
        c.b.this.Pz.onSingleTapConfirmed(c.b.this.PF);
        return;
      }
      c.b.this.PB = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.view.c.b
 * JD-Core Version:    0.7.0.1
 */