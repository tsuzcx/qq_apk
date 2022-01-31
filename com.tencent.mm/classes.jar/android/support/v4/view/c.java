package android.support.v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public final class c
{
  private final c.a EJ;
  
  public c(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
  {
    this(paramContext, paramOnGestureListener, (byte)0);
  }
  
  private c(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, byte paramByte)
  {
    if (Build.VERSION.SDK_INT > 17)
    {
      this.EJ = new c.c(paramContext, paramOnGestureListener);
      return;
    }
    this.EJ = new b(paramContext, paramOnGestureListener);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.EJ.onTouchEvent(paramMotionEvent);
  }
  
  static final class b
    implements c.a
  {
    private static final int EO = ;
    private static final int EP = ViewConfiguration.getTapTimeout();
    private static final int EQ = ViewConfiguration.getDoubleTapTimeout();
    private int EK;
    private int EL;
    private int EM;
    private int EN;
    final GestureDetector.OnGestureListener ER;
    GestureDetector.OnDoubleTapListener ES;
    boolean ET;
    boolean EU;
    boolean EV;
    private boolean EW;
    private boolean EX;
    MotionEvent EY;
    private MotionEvent EZ;
    private boolean Fa;
    private float Fb;
    private float Fc;
    private float Fd;
    private float Fe;
    private boolean Ff;
    private VelocityTracker fB;
    final Handler mHandler = new c.b.a(this);
    
    b(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
    {
      this.ER = paramOnGestureListener;
      if ((paramOnGestureListener instanceof GestureDetector.OnDoubleTapListener)) {
        this.ES = ((GestureDetector.OnDoubleTapListener)paramOnGestureListener);
      }
      if (paramContext == null) {
        throw new IllegalArgumentException("Context must not be null");
      }
      if (this.ER == null) {
        throw new IllegalArgumentException("OnGestureListener must not be null");
      }
      this.Ff = true;
      paramContext = ViewConfiguration.get(paramContext);
      int i = paramContext.getScaledTouchSlop();
      int j = paramContext.getScaledDoubleTapSlop();
      this.EM = paramContext.getScaledMinimumFlingVelocity();
      this.EN = paramContext.getScaledMaximumFlingVelocity();
      this.EK = (i * i);
      this.EL = (j * j);
    }
    
    public final boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      int i1 = paramMotionEvent.getAction();
      if (this.fB == null) {
        this.fB = VelocityTracker.obtain();
      }
      this.fB.addMovement(paramMotionEvent);
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
            this.Fb = f2;
            this.Fd = f2;
            this.Fc = f1;
            this.Fe = f1;
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.Fa = false;
            this.EW = false;
            this.EX = false;
            this.EU = false;
          } while (!this.EV);
          this.EV = false;
          return false;
          this.Fb = f2;
          this.Fd = f2;
          this.Fc = f1;
          this.Fe = f1;
          this.fB.computeCurrentVelocity(1000, this.EN);
          k = paramMotionEvent.getActionIndex();
          i = paramMotionEvent.getPointerId(k);
          f1 = this.fB.getXVelocity(i);
          f2 = this.fB.getYVelocity(i);
          i = 0;
          while (i < n)
          {
            if (i != k)
            {
              m = paramMotionEvent.getPointerId(i);
              f3 = this.fB.getXVelocity(m);
              if (this.fB.getYVelocity(m) * f2 + f3 * f1 < 0.0F)
              {
                this.fB.clear();
                return false;
              }
            }
            i += 1;
          }
          if (this.ES != null)
          {
            bool2 = this.mHandler.hasMessages(3);
            if (bool2) {
              this.mHandler.removeMessages(3);
            }
            if ((this.EY != null) && (this.EZ != null) && (bool2))
            {
              localMotionEvent = this.EY;
              localObject = this.EZ;
              if ((this.EX) && (paramMotionEvent.getEventTime() - ((MotionEvent)localObject).getEventTime() <= EQ))
              {
                i = (int)localMotionEvent.getX() - (int)paramMotionEvent.getX();
                k = (int)localMotionEvent.getY() - (int)paramMotionEvent.getY();
                if (k * k + i * i < this.EL)
                {
                  i = 1;
                  if (i == 0) {
                    break label757;
                  }
                  this.Fa = true;
                }
              }
            }
          }
          for (boolean bool1 = this.ES.onDoubleTap(this.EY) | false | this.ES.onDoubleTapEvent(paramMotionEvent);; bool1 = false)
          {
            this.Fb = f2;
            this.Fd = f2;
            this.Fc = f1;
            this.Fe = f1;
            if (this.EY != null) {
              this.EY.recycle();
            }
            this.EY = MotionEvent.obtain(paramMotionEvent);
            this.EW = true;
            this.EX = true;
            this.ET = true;
            this.EV = false;
            this.EU = false;
            if (this.Ff)
            {
              this.mHandler.removeMessages(2);
              this.mHandler.sendEmptyMessageAtTime(2, this.EY.getDownTime() + EP + EO);
            }
            this.mHandler.sendEmptyMessageAtTime(1, this.EY.getDownTime() + EP);
            return bool1 | this.ER.onDown(paramMotionEvent);
            bool1 = false;
            break;
            this.mHandler.sendEmptyMessageDelayed(3, EQ);
          }
        } while (this.EV);
        f3 = this.Fb - f2;
        f4 = this.Fc - f1;
        if (this.Fa) {
          return this.ES.onDoubleTapEvent(paramMotionEvent) | false;
        }
        if (this.EW)
        {
          j = (int)(f2 - this.Fd);
          k = (int)(f1 - this.Fe);
          j = j * j + k * k;
          if (j <= this.EK) {
            break label1350;
          }
          bool2 = this.ER.onScroll(this.EY, paramMotionEvent, f3, f4);
          this.Fb = f2;
          this.Fc = f1;
          this.EW = false;
          this.mHandler.removeMessages(3);
          this.mHandler.removeMessages(1);
          this.mHandler.removeMessages(2);
        }
        break;
      }
      for (;;)
      {
        if (j > this.EK) {
          this.EX = false;
        }
        return bool2;
        if ((Math.abs(f3) < 1.0F) && (Math.abs(f4) < 1.0F)) {
          break;
        }
        bool2 = this.ER.onScroll(this.EY, paramMotionEvent, f3, f4);
        this.Fb = f2;
        this.Fc = f1;
        return bool2;
        this.ET = false;
        localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        if (this.Fa) {
          bool2 = this.ES.onDoubleTapEvent(paramMotionEvent) | false;
        }
        for (;;)
        {
          if (this.EZ != null) {
            this.EZ.recycle();
          }
          this.EZ = localMotionEvent;
          if (this.fB != null)
          {
            this.fB.recycle();
            this.fB = null;
          }
          this.Fa = false;
          this.EU = false;
          this.mHandler.removeMessages(1);
          this.mHandler.removeMessages(2);
          return bool2;
          if (this.EV)
          {
            this.mHandler.removeMessages(3);
            this.EV = false;
            bool2 = false;
          }
          else if (this.EW)
          {
            boolean bool3 = this.ER.onSingleTapUp(paramMotionEvent);
            bool2 = bool3;
            if (this.EU)
            {
              bool2 = bool3;
              if (this.ES != null)
              {
                this.ES.onSingleTapConfirmed(paramMotionEvent);
                bool2 = bool3;
              }
            }
          }
          else
          {
            localObject = this.fB;
            j = paramMotionEvent.getPointerId(0);
            ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.EN);
            f1 = ((VelocityTracker)localObject).getYVelocity(j);
            f2 = ((VelocityTracker)localObject).getXVelocity(j);
            if ((Math.abs(f1) > this.EM) || (Math.abs(f2) > this.EM))
            {
              bool2 = this.ER.onFling(this.EY, paramMotionEvent, f2, f1);
              continue;
              this.mHandler.removeMessages(1);
              this.mHandler.removeMessages(2);
              this.mHandler.removeMessages(3);
              this.fB.recycle();
              this.fB = null;
              this.Fa = false;
              this.ET = false;
              this.EW = false;
              this.EX = false;
              this.EU = false;
              if (!this.EV) {
                break;
              }
              this.EV = false;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.view.c
 * JD-Core Version:    0.7.0.1
 */