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
  private static final int Mv = ;
  private static final int Mw = ViewConfiguration.getTapTimeout();
  private static final int Mx = ViewConfiguration.getDoubleTapTimeout();
  boolean MA;
  boolean MC;
  boolean MD;
  private boolean MF;
  private boolean MG;
  MotionEvent MH;
  private MotionEvent MI;
  private boolean MJ;
  private float MK;
  private float ML;
  private float MM;
  private float MN;
  private boolean MO;
  private int Mr;
  private int Ms;
  private int Mt;
  private int Mu;
  final GestureDetector.OnGestureListener My;
  GestureDetector.OnDoubleTapListener Mz;
  final Handler mHandler = new a();
  private VelocityTracker mVelocityTracker;
  
  c$b(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
  {
    this.My = paramOnGestureListener;
    if ((paramOnGestureListener instanceof GestureDetector.OnDoubleTapListener)) {
      this.Mz = ((GestureDetector.OnDoubleTapListener)paramOnGestureListener);
    }
    if (paramContext == null) {
      throw new IllegalArgumentException("Context must not be null");
    }
    if (this.My == null) {
      throw new IllegalArgumentException("OnGestureListener must not be null");
    }
    this.MO = true;
    paramContext = ViewConfiguration.get(paramContext);
    int i = paramContext.getScaledTouchSlop();
    int j = paramContext.getScaledDoubleTapSlop();
    this.Mt = paramContext.getScaledMinimumFlingVelocity();
    this.Mu = paramContext.getScaledMaximumFlingVelocity();
    this.Mr = (i * i);
    this.Ms = (j * j);
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
          this.MK = f2;
          this.MM = f2;
          this.ML = f1;
          this.MN = f1;
          this.mHandler.removeMessages(1);
          this.mHandler.removeMessages(2);
          this.mHandler.removeMessages(3);
          this.MJ = false;
          this.MF = false;
          this.MG = false;
          this.MC = false;
        } while (!this.MD);
        this.MD = false;
        return false;
        this.MK = f2;
        this.MM = f2;
        this.ML = f1;
        this.MN = f1;
        this.mVelocityTracker.computeCurrentVelocity(1000, this.Mu);
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
        if (this.Mz != null)
        {
          bool2 = this.mHandler.hasMessages(3);
          if (bool2) {
            this.mHandler.removeMessages(3);
          }
          if ((this.MH != null) && (this.MI != null) && (bool2))
          {
            localMotionEvent = this.MH;
            localObject = this.MI;
            if ((this.MG) && (paramMotionEvent.getEventTime() - ((MotionEvent)localObject).getEventTime() <= Mx))
            {
              i = (int)localMotionEvent.getX() - (int)paramMotionEvent.getX();
              k = (int)localMotionEvent.getY() - (int)paramMotionEvent.getY();
              if (k * k + i * i < this.Ms)
              {
                i = 1;
                if (i == 0) {
                  break label757;
                }
                this.MJ = true;
              }
            }
          }
        }
        for (boolean bool1 = this.Mz.onDoubleTap(this.MH) | false | this.Mz.onDoubleTapEvent(paramMotionEvent);; bool1 = false)
        {
          this.MK = f2;
          this.MM = f2;
          this.ML = f1;
          this.MN = f1;
          if (this.MH != null) {
            this.MH.recycle();
          }
          this.MH = MotionEvent.obtain(paramMotionEvent);
          this.MF = true;
          this.MG = true;
          this.MA = true;
          this.MD = false;
          this.MC = false;
          if (this.MO)
          {
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageAtTime(2, this.MH.getDownTime() + Mw + Mv);
          }
          this.mHandler.sendEmptyMessageAtTime(1, this.MH.getDownTime() + Mw);
          return bool1 | this.My.onDown(paramMotionEvent);
          bool1 = false;
          break;
          this.mHandler.sendEmptyMessageDelayed(3, Mx);
        }
      } while (this.MD);
      f3 = this.MK - f2;
      f4 = this.ML - f1;
      if (this.MJ) {
        return this.Mz.onDoubleTapEvent(paramMotionEvent) | false;
      }
      if (this.MF)
      {
        j = (int)(f2 - this.MM);
        k = (int)(f1 - this.MN);
        j = j * j + k * k;
        if (j <= this.Mr) {
          break label1350;
        }
        bool2 = this.My.onScroll(this.MH, paramMotionEvent, f3, f4);
        this.MK = f2;
        this.ML = f1;
        this.MF = false;
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
      }
      break;
    }
    for (;;)
    {
      if (j > this.Mr) {
        this.MG = false;
      }
      return bool2;
      if ((Math.abs(f3) < 1.0F) && (Math.abs(f4) < 1.0F)) {
        break;
      }
      bool2 = this.My.onScroll(this.MH, paramMotionEvent, f3, f4);
      this.MK = f2;
      this.ML = f1;
      return bool2;
      this.MA = false;
      localMotionEvent = MotionEvent.obtain(paramMotionEvent);
      if (this.MJ) {
        bool2 = this.Mz.onDoubleTapEvent(paramMotionEvent) | false;
      }
      for (;;)
      {
        if (this.MI != null) {
          this.MI.recycle();
        }
        this.MI = localMotionEvent;
        if (this.mVelocityTracker != null)
        {
          this.mVelocityTracker.recycle();
          this.mVelocityTracker = null;
        }
        this.MJ = false;
        this.MC = false;
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        return bool2;
        if (this.MD)
        {
          this.mHandler.removeMessages(3);
          this.MD = false;
          bool2 = false;
        }
        else if (this.MF)
        {
          boolean bool3 = this.My.onSingleTapUp(paramMotionEvent);
          bool2 = bool3;
          if (this.MC)
          {
            bool2 = bool3;
            if (this.Mz != null)
            {
              this.Mz.onSingleTapConfirmed(paramMotionEvent);
              bool2 = bool3;
            }
          }
        }
        else
        {
          localObject = this.mVelocityTracker;
          j = paramMotionEvent.getPointerId(0);
          ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.Mu);
          f1 = ((VelocityTracker)localObject).getYVelocity(j);
          f2 = ((VelocityTracker)localObject).getXVelocity(j);
          if ((Math.abs(f1) > this.Mt) || (Math.abs(f2) > this.Mt))
          {
            bool2 = this.My.onFling(this.MH, paramMotionEvent, f2, f1);
            continue;
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
            this.MJ = false;
            this.MA = false;
            this.MF = false;
            this.MG = false;
            this.MC = false;
            if (!this.MD) {
              break;
            }
            this.MD = false;
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
        c.b.this.My.onShowPress(c.b.this.MH);
      }
      do
      {
        return;
        paramMessage = c.b.this;
        paramMessage.mHandler.removeMessages(3);
        paramMessage.MC = false;
        paramMessage.MD = true;
        paramMessage.My.onLongPress(paramMessage.MH);
        return;
      } while (c.b.this.Mz == null);
      if (!c.b.this.MA)
      {
        c.b.this.Mz.onSingleTapConfirmed(c.b.this.MH);
        return;
      }
      c.b.this.MC = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.view.c.b
 * JD-Core Version:    0.7.0.1
 */