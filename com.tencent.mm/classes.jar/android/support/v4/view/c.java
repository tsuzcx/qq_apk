package android.support.v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public final class c
{
  private final a Nn;
  
  public c(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
  {
    this(paramContext, paramOnGestureListener, (byte)0);
  }
  
  private c(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, byte paramByte)
  {
    if (Build.VERSION.SDK_INT > 17)
    {
      this.Nn = new c(paramContext, paramOnGestureListener);
      return;
    }
    this.Nn = new b(paramContext, paramOnGestureListener);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.Nn.onTouchEvent(paramMotionEvent);
  }
  
  static abstract interface a
  {
    public abstract boolean onTouchEvent(MotionEvent paramMotionEvent);
  }
  
  static final class b
    implements c.a
  {
    private static final int Ns = ;
    private static final int Nt = ViewConfiguration.getTapTimeout();
    private static final int Nu = ViewConfiguration.getDoubleTapTimeout();
    private boolean NA;
    private boolean NB;
    MotionEvent NC;
    private MotionEvent ND;
    private boolean NE;
    private float NF;
    private float NG;
    private float NH;
    private float NI;
    private boolean NJ;
    private int No;
    private int Np;
    private int Nq;
    private int Nr;
    final GestureDetector.OnGestureListener Nv;
    GestureDetector.OnDoubleTapListener Nw;
    boolean Nx;
    boolean Ny;
    boolean Nz;
    final Handler mHandler = new a();
    private VelocityTracker mVelocityTracker;
    
    b(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
    {
      this.Nv = paramOnGestureListener;
      if ((paramOnGestureListener instanceof GestureDetector.OnDoubleTapListener)) {
        this.Nw = ((GestureDetector.OnDoubleTapListener)paramOnGestureListener);
      }
      if (paramContext == null) {
        throw new IllegalArgumentException("Context must not be null");
      }
      if (this.Nv == null) {
        throw new IllegalArgumentException("OnGestureListener must not be null");
      }
      this.NJ = true;
      paramContext = ViewConfiguration.get(paramContext);
      int i = paramContext.getScaledTouchSlop();
      int j = paramContext.getScaledDoubleTapSlop();
      this.Nq = paramContext.getScaledMinimumFlingVelocity();
      this.Nr = paramContext.getScaledMaximumFlingVelocity();
      this.No = (i * i);
      this.Np = (j * j);
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
            this.NF = f2;
            this.NH = f2;
            this.NG = f1;
            this.NI = f1;
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.NE = false;
            this.NA = false;
            this.NB = false;
            this.Ny = false;
          } while (!this.Nz);
          this.Nz = false;
          return false;
          this.NF = f2;
          this.NH = f2;
          this.NG = f1;
          this.NI = f1;
          this.mVelocityTracker.computeCurrentVelocity(1000, this.Nr);
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
          if (this.Nw != null)
          {
            bool2 = this.mHandler.hasMessages(3);
            if (bool2) {
              this.mHandler.removeMessages(3);
            }
            if ((this.NC != null) && (this.ND != null) && (bool2))
            {
              localMotionEvent = this.NC;
              localObject = this.ND;
              if ((this.NB) && (paramMotionEvent.getEventTime() - ((MotionEvent)localObject).getEventTime() <= Nu))
              {
                i = (int)localMotionEvent.getX() - (int)paramMotionEvent.getX();
                k = (int)localMotionEvent.getY() - (int)paramMotionEvent.getY();
                if (k * k + i * i < this.Np)
                {
                  i = 1;
                  if (i == 0) {
                    break label757;
                  }
                  this.NE = true;
                }
              }
            }
          }
          for (boolean bool1 = this.Nw.onDoubleTap(this.NC) | false | this.Nw.onDoubleTapEvent(paramMotionEvent);; bool1 = false)
          {
            this.NF = f2;
            this.NH = f2;
            this.NG = f1;
            this.NI = f1;
            if (this.NC != null) {
              this.NC.recycle();
            }
            this.NC = MotionEvent.obtain(paramMotionEvent);
            this.NA = true;
            this.NB = true;
            this.Nx = true;
            this.Nz = false;
            this.Ny = false;
            if (this.NJ)
            {
              this.mHandler.removeMessages(2);
              this.mHandler.sendEmptyMessageAtTime(2, this.NC.getDownTime() + Nt + Ns);
            }
            this.mHandler.sendEmptyMessageAtTime(1, this.NC.getDownTime() + Nt);
            return bool1 | this.Nv.onDown(paramMotionEvent);
            bool1 = false;
            break;
            this.mHandler.sendEmptyMessageDelayed(3, Nu);
          }
        } while (this.Nz);
        f3 = this.NF - f2;
        f4 = this.NG - f1;
        if (this.NE) {
          return this.Nw.onDoubleTapEvent(paramMotionEvent) | false;
        }
        if (this.NA)
        {
          j = (int)(f2 - this.NH);
          k = (int)(f1 - this.NI);
          j = j * j + k * k;
          if (j <= this.No) {
            break label1350;
          }
          bool2 = this.Nv.onScroll(this.NC, paramMotionEvent, f3, f4);
          this.NF = f2;
          this.NG = f1;
          this.NA = false;
          this.mHandler.removeMessages(3);
          this.mHandler.removeMessages(1);
          this.mHandler.removeMessages(2);
        }
        break;
      }
      for (;;)
      {
        if (j > this.No) {
          this.NB = false;
        }
        return bool2;
        if ((Math.abs(f3) < 1.0F) && (Math.abs(f4) < 1.0F)) {
          break;
        }
        bool2 = this.Nv.onScroll(this.NC, paramMotionEvent, f3, f4);
        this.NF = f2;
        this.NG = f1;
        return bool2;
        this.Nx = false;
        localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        if (this.NE) {
          bool2 = this.Nw.onDoubleTapEvent(paramMotionEvent) | false;
        }
        for (;;)
        {
          if (this.ND != null) {
            this.ND.recycle();
          }
          this.ND = localMotionEvent;
          if (this.mVelocityTracker != null)
          {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
          }
          this.NE = false;
          this.Ny = false;
          this.mHandler.removeMessages(1);
          this.mHandler.removeMessages(2);
          return bool2;
          if (this.Nz)
          {
            this.mHandler.removeMessages(3);
            this.Nz = false;
            bool2 = false;
          }
          else if (this.NA)
          {
            boolean bool3 = this.Nv.onSingleTapUp(paramMotionEvent);
            bool2 = bool3;
            if (this.Ny)
            {
              bool2 = bool3;
              if (this.Nw != null)
              {
                this.Nw.onSingleTapConfirmed(paramMotionEvent);
                bool2 = bool3;
              }
            }
          }
          else
          {
            localObject = this.mVelocityTracker;
            j = paramMotionEvent.getPointerId(0);
            ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.Nr);
            f1 = ((VelocityTracker)localObject).getYVelocity(j);
            f2 = ((VelocityTracker)localObject).getXVelocity(j);
            if ((Math.abs(f1) > this.Nq) || (Math.abs(f2) > this.Nq))
            {
              bool2 = this.Nv.onFling(this.NC, paramMotionEvent, f2, f1);
              continue;
              this.mHandler.removeMessages(1);
              this.mHandler.removeMessages(2);
              this.mHandler.removeMessages(3);
              this.mVelocityTracker.recycle();
              this.mVelocityTracker = null;
              this.NE = false;
              this.Nx = false;
              this.NA = false;
              this.NB = false;
              this.Ny = false;
              if (!this.Nz) {
                break;
              }
              this.Nz = false;
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
          c.b.this.Nv.onShowPress(c.b.this.NC);
        }
        do
        {
          return;
          paramMessage = c.b.this;
          paramMessage.mHandler.removeMessages(3);
          paramMessage.Ny = false;
          paramMessage.Nz = true;
          paramMessage.Nv.onLongPress(paramMessage.NC);
          return;
        } while (c.b.this.Nw == null);
        if (!c.b.this.Nx)
        {
          c.b.this.Nw.onSingleTapConfirmed(c.b.this.NC);
          return;
        }
        c.b.this.Ny = true;
      }
    }
  }
  
  static final class c
    implements c.a
  {
    private final GestureDetector NL;
    
    c(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
    {
      this.NL = new GestureDetector(paramContext, paramOnGestureListener, null);
    }
    
    public final boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      return this.NL.onTouchEvent(paramMotionEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.view.c
 * JD-Core Version:    0.7.0.1
 */