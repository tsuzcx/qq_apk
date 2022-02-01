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
  private static final int Pj = ;
  private static final int Pk = ViewConfiguration.getTapTimeout();
  private static final int Pl = ViewConfiguration.getDoubleTapTimeout();
  private boolean PA;
  private int Pf;
  private int Pg;
  private int Ph;
  private int Pi;
  final GestureDetector.OnGestureListener Pm;
  GestureDetector.OnDoubleTapListener Pn;
  boolean Po;
  boolean Pp;
  boolean Pq;
  private boolean Pr;
  private boolean Ps;
  MotionEvent Pt;
  private MotionEvent Pu;
  private boolean Pv;
  private float Pw;
  private float Px;
  private float Py;
  private float Pz;
  final Handler mHandler = new a();
  private VelocityTracker mVelocityTracker;
  
  c$b(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
  {
    this.Pm = paramOnGestureListener;
    if ((paramOnGestureListener instanceof GestureDetector.OnDoubleTapListener)) {
      this.Pn = ((GestureDetector.OnDoubleTapListener)paramOnGestureListener);
    }
    if (paramContext == null) {
      throw new IllegalArgumentException("Context must not be null");
    }
    if (this.Pm == null) {
      throw new IllegalArgumentException("OnGestureListener must not be null");
    }
    this.PA = true;
    paramContext = ViewConfiguration.get(paramContext);
    int i = paramContext.getScaledTouchSlop();
    int j = paramContext.getScaledDoubleTapSlop();
    this.Ph = paramContext.getScaledMinimumFlingVelocity();
    this.Pi = paramContext.getScaledMaximumFlingVelocity();
    this.Pf = (i * i);
    this.Pg = (j * j);
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
          this.Pw = f2;
          this.Py = f2;
          this.Px = f1;
          this.Pz = f1;
          this.mHandler.removeMessages(1);
          this.mHandler.removeMessages(2);
          this.mHandler.removeMessages(3);
          this.Pv = false;
          this.Pr = false;
          this.Ps = false;
          this.Pp = false;
        } while (!this.Pq);
        this.Pq = false;
        return false;
        this.Pw = f2;
        this.Py = f2;
        this.Px = f1;
        this.Pz = f1;
        this.mVelocityTracker.computeCurrentVelocity(1000, this.Pi);
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
        if (this.Pn != null)
        {
          bool2 = this.mHandler.hasMessages(3);
          if (bool2) {
            this.mHandler.removeMessages(3);
          }
          if ((this.Pt != null) && (this.Pu != null) && (bool2))
          {
            localMotionEvent = this.Pt;
            localObject = this.Pu;
            if ((this.Ps) && (paramMotionEvent.getEventTime() - ((MotionEvent)localObject).getEventTime() <= Pl))
            {
              i = (int)localMotionEvent.getX() - (int)paramMotionEvent.getX();
              k = (int)localMotionEvent.getY() - (int)paramMotionEvent.getY();
              if (k * k + i * i < this.Pg)
              {
                i = 1;
                if (i == 0) {
                  break label757;
                }
                this.Pv = true;
              }
            }
          }
        }
        for (boolean bool1 = this.Pn.onDoubleTap(this.Pt) | false | this.Pn.onDoubleTapEvent(paramMotionEvent);; bool1 = false)
        {
          this.Pw = f2;
          this.Py = f2;
          this.Px = f1;
          this.Pz = f1;
          if (this.Pt != null) {
            this.Pt.recycle();
          }
          this.Pt = MotionEvent.obtain(paramMotionEvent);
          this.Pr = true;
          this.Ps = true;
          this.Po = true;
          this.Pq = false;
          this.Pp = false;
          if (this.PA)
          {
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageAtTime(2, this.Pt.getDownTime() + Pk + Pj);
          }
          this.mHandler.sendEmptyMessageAtTime(1, this.Pt.getDownTime() + Pk);
          return bool1 | this.Pm.onDown(paramMotionEvent);
          bool1 = false;
          break;
          this.mHandler.sendEmptyMessageDelayed(3, Pl);
        }
      } while (this.Pq);
      f3 = this.Pw - f2;
      f4 = this.Px - f1;
      if (this.Pv) {
        return this.Pn.onDoubleTapEvent(paramMotionEvent) | false;
      }
      if (this.Pr)
      {
        j = (int)(f2 - this.Py);
        k = (int)(f1 - this.Pz);
        j = j * j + k * k;
        if (j <= this.Pf) {
          break label1350;
        }
        bool2 = this.Pm.onScroll(this.Pt, paramMotionEvent, f3, f4);
        this.Pw = f2;
        this.Px = f1;
        this.Pr = false;
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
      }
      break;
    }
    for (;;)
    {
      if (j > this.Pf) {
        this.Ps = false;
      }
      return bool2;
      if ((Math.abs(f3) < 1.0F) && (Math.abs(f4) < 1.0F)) {
        break;
      }
      bool2 = this.Pm.onScroll(this.Pt, paramMotionEvent, f3, f4);
      this.Pw = f2;
      this.Px = f1;
      return bool2;
      this.Po = false;
      localMotionEvent = MotionEvent.obtain(paramMotionEvent);
      if (this.Pv) {
        bool2 = this.Pn.onDoubleTapEvent(paramMotionEvent) | false;
      }
      for (;;)
      {
        if (this.Pu != null) {
          this.Pu.recycle();
        }
        this.Pu = localMotionEvent;
        if (this.mVelocityTracker != null)
        {
          this.mVelocityTracker.recycle();
          this.mVelocityTracker = null;
        }
        this.Pv = false;
        this.Pp = false;
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        return bool2;
        if (this.Pq)
        {
          this.mHandler.removeMessages(3);
          this.Pq = false;
          bool2 = false;
        }
        else if (this.Pr)
        {
          boolean bool3 = this.Pm.onSingleTapUp(paramMotionEvent);
          bool2 = bool3;
          if (this.Pp)
          {
            bool2 = bool3;
            if (this.Pn != null)
            {
              this.Pn.onSingleTapConfirmed(paramMotionEvent);
              bool2 = bool3;
            }
          }
        }
        else
        {
          localObject = this.mVelocityTracker;
          j = paramMotionEvent.getPointerId(0);
          ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.Pi);
          f1 = ((VelocityTracker)localObject).getYVelocity(j);
          f2 = ((VelocityTracker)localObject).getXVelocity(j);
          if ((Math.abs(f1) > this.Ph) || (Math.abs(f2) > this.Ph))
          {
            bool2 = this.Pm.onFling(this.Pt, paramMotionEvent, f2, f1);
            continue;
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
            this.Pv = false;
            this.Po = false;
            this.Pr = false;
            this.Ps = false;
            this.Pp = false;
            if (!this.Pq) {
              break;
            }
            this.Pq = false;
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
        c.b.this.Pm.onShowPress(c.b.this.Pt);
      }
      do
      {
        return;
        paramMessage = c.b.this;
        paramMessage.mHandler.removeMessages(3);
        paramMessage.Pp = false;
        paramMessage.Pq = true;
        paramMessage.Pm.onLongPress(paramMessage.Pt);
        return;
      } while (c.b.this.Pn == null);
      if (!c.b.this.Po)
      {
        c.b.this.Pn.onSingleTapConfirmed(c.b.this.Pt);
        return;
      }
      c.b.this.Pp = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.view.c.b
 * JD-Core Version:    0.7.0.1
 */