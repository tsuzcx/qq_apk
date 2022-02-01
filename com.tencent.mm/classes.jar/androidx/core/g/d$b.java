package androidx.core.g;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$b
  implements d.a
{
  private static final int bsP;
  private static final int bsQ;
  private int bsL;
  private int bsM;
  private int bsN;
  private int bsO;
  final GestureDetector.OnGestureListener bsR;
  GestureDetector.OnDoubleTapListener bsS;
  boolean bsT;
  boolean bsU;
  boolean bsV;
  private boolean bsW;
  private boolean bsX;
  MotionEvent bsY;
  private MotionEvent bsZ;
  private boolean bta;
  private float btb;
  private float btc;
  private float btd;
  private float bte;
  private boolean btf;
  final Handler mHandler;
  private VelocityTracker mVelocityTracker;
  
  static
  {
    AppMethodBeat.i(195680);
    bsP = ViewConfiguration.getTapTimeout();
    bsQ = ViewConfiguration.getDoubleTapTimeout();
    AppMethodBeat.o(195680);
  }
  
  d$b(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
  {
    AppMethodBeat.i(195675);
    this.mHandler = new a();
    this.bsR = paramOnGestureListener;
    if ((paramOnGestureListener instanceof GestureDetector.OnDoubleTapListener)) {
      this.bsS = ((GestureDetector.OnDoubleTapListener)paramOnGestureListener);
    }
    if (paramContext == null)
    {
      paramContext = new IllegalArgumentException("Context must not be null");
      AppMethodBeat.o(195675);
      throw paramContext;
    }
    if (this.bsR == null)
    {
      paramContext = new IllegalArgumentException("OnGestureListener must not be null");
      AppMethodBeat.o(195675);
      throw paramContext;
    }
    this.btf = true;
    paramContext = ViewConfiguration.get(paramContext);
    int i = paramContext.getScaledTouchSlop();
    int j = paramContext.getScaledDoubleTapSlop();
    this.bsN = paramContext.getScaledMinimumFlingVelocity();
    this.bsO = paramContext.getScaledMaximumFlingVelocity();
    this.bsL = (i * i);
    this.bsM = (j * j);
    AppMethodBeat.o(195675);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    AppMethodBeat.i(195700);
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
        break label135;
      }
    }
    int n;
    int m;
    float f1;
    float f2;
    float f4;
    float f3;
    label135:
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
    boolean bool2;
    if (i != 0)
    {
      i = n - 1;
      f2 /= i;
      f1 /= i;
      bool2 = bool3;
    }
    MotionEvent localMotionEvent;
    Object localObject;
    label610:
    label871:
    int j;
    switch (i1 & 0xFF)
    {
    default: 
      bool2 = bool3;
    case 4: 
    case 5: 
    case 6: 
    case 0: 
    case 2: 
      for (;;)
      {
        AppMethodBeat.o(195700);
        return bool2;
        i = n;
        break;
        this.btb = f2;
        this.btd = f2;
        this.btc = f1;
        this.bte = f1;
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
        this.bta = false;
        this.bsW = false;
        this.bsX = false;
        this.bsU = false;
        bool2 = bool3;
        if (this.bsV)
        {
          this.bsV = false;
          bool2 = bool3;
          continue;
          this.btb = f2;
          this.btd = f2;
          this.btc = f1;
          this.bte = f1;
          this.mVelocityTracker.computeCurrentVelocity(1000, this.bsO);
          k = paramMotionEvent.getActionIndex();
          i = paramMotionEvent.getPointerId(k);
          f1 = this.mVelocityTracker.getXVelocity(i);
          f2 = this.mVelocityTracker.getYVelocity(i);
          i = 0;
          for (;;)
          {
            bool2 = bool3;
            if (i >= n) {
              break;
            }
            if (i != k)
            {
              m = paramMotionEvent.getPointerId(i);
              f3 = this.mVelocityTracker.getXVelocity(m);
              if (this.mVelocityTracker.getYVelocity(m) * f2 + f3 * f1 < 0.0F)
              {
                this.mVelocityTracker.clear();
                bool2 = bool3;
                break;
              }
            }
            i += 1;
          }
          if (this.bsS != null)
          {
            bool2 = this.mHandler.hasMessages(3);
            if (bool2) {
              this.mHandler.removeMessages(3);
            }
            if ((this.bsY != null) && (this.bsZ != null) && (bool2))
            {
              localMotionEvent = this.bsY;
              localObject = this.bsZ;
              if ((this.bsX) && (paramMotionEvent.getEventTime() - ((MotionEvent)localObject).getEventTime() <= bsQ))
              {
                i = (int)localMotionEvent.getX() - (int)paramMotionEvent.getX();
                k = (int)localMotionEvent.getY() - (int)paramMotionEvent.getY();
                if (k * k + i * i < this.bsM)
                {
                  i = 1;
                  if (i == 0) {
                    break label801;
                  }
                  this.bta = true;
                }
              }
            }
          }
          for (boolean bool1 = this.bsS.onDoubleTap(this.bsY) | false | this.bsS.onDoubleTapEvent(paramMotionEvent);; bool1 = false)
          {
            this.btb = f2;
            this.btd = f2;
            this.btc = f1;
            this.bte = f1;
            if (this.bsY != null) {
              this.bsY.recycle();
            }
            this.bsY = MotionEvent.obtain(paramMotionEvent);
            this.bsW = true;
            this.bsX = true;
            this.bsT = true;
            this.bsV = false;
            this.bsU = false;
            if (this.btf)
            {
              this.mHandler.removeMessages(2);
              this.mHandler.sendEmptyMessageAtTime(2, this.bsY.getDownTime() + bsP + ViewConfiguration.getLongPressTimeout());
            }
            this.mHandler.sendEmptyMessageAtTime(1, this.bsY.getDownTime() + bsP);
            bool2 = bool1 | this.bsR.onDown(paramMotionEvent);
            break;
            bool1 = false;
            break label610;
            label801:
            this.mHandler.sendEmptyMessageDelayed(3, bsQ);
          }
          bool2 = bool3;
          if (!this.bsV)
          {
            f3 = this.btb - f2;
            f4 = this.btc - f1;
            if (!this.bta) {
              break label871;
            }
            bool2 = this.bsS.onDoubleTapEvent(paramMotionEvent) | false;
          }
        }
      }
      if (this.bsW)
      {
        j = (int)(f2 - this.btd);
        k = (int)(f1 - this.bte);
        j = j * j + k * k;
        if (j <= this.bsL) {
          break label1415;
        }
        bool2 = this.bsR.onScroll(this.bsY, paramMotionEvent, f3, f4);
        this.btb = f2;
        this.btc = f1;
        this.bsW = false;
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
      }
      break;
    }
    for (;;)
    {
      if (j > this.bsL) {
        this.bsX = false;
      }
      break;
      if (Math.abs(f3) < 1.0F)
      {
        bool2 = bool3;
        if (Math.abs(f4) < 1.0F) {
          break;
        }
      }
      bool2 = this.bsR.onScroll(this.bsY, paramMotionEvent, f3, f4);
      this.btb = f2;
      this.btc = f1;
      break;
      this.bsT = false;
      localMotionEvent = MotionEvent.obtain(paramMotionEvent);
      if (this.bta) {
        bool2 = this.bsS.onDoubleTapEvent(paramMotionEvent) | false;
      }
      for (;;)
      {
        if (this.bsZ != null) {
          this.bsZ.recycle();
        }
        this.bsZ = localMotionEvent;
        if (this.mVelocityTracker != null)
        {
          this.mVelocityTracker.recycle();
          this.mVelocityTracker = null;
        }
        this.bta = false;
        this.bsU = false;
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        break;
        if (this.bsV)
        {
          this.mHandler.removeMessages(3);
          this.bsV = false;
          bool2 = false;
        }
        else if (this.bsW)
        {
          bool3 = this.bsR.onSingleTapUp(paramMotionEvent);
          bool2 = bool3;
          if (this.bsU)
          {
            bool2 = bool3;
            if (this.bsS != null)
            {
              this.bsS.onSingleTapConfirmed(paramMotionEvent);
              bool2 = bool3;
            }
          }
        }
        else
        {
          localObject = this.mVelocityTracker;
          j = paramMotionEvent.getPointerId(0);
          ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.bsO);
          f1 = ((VelocityTracker)localObject).getYVelocity(j);
          f2 = ((VelocityTracker)localObject).getXVelocity(j);
          if ((Math.abs(f1) > this.bsN) || (Math.abs(f2) > this.bsN))
          {
            bool2 = this.bsR.onFling(this.bsY, paramMotionEvent, f2, f1);
            continue;
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
            this.bta = false;
            this.bsT = false;
            this.bsW = false;
            this.bsX = false;
            this.bsU = false;
            bool2 = bool3;
            if (!this.bsV) {
              break;
            }
            this.bsV = false;
            bool2 = bool3;
            break;
          }
          bool2 = false;
        }
      }
      label1415:
      bool2 = false;
    }
  }
  
  final class a
    extends Handler
  {
    a() {}
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(195788);
      switch (paramMessage.what)
      {
      default: 
        paramMessage = new RuntimeException("Unknown message ".concat(String.valueOf(paramMessage)));
        AppMethodBeat.o(195788);
        throw paramMessage;
      case 1: 
        d.b.this.bsR.onShowPress(d.b.this.bsY);
        AppMethodBeat.o(195788);
        return;
      case 2: 
        paramMessage = d.b.this;
        paramMessage.mHandler.removeMessages(3);
        paramMessage.bsU = false;
        paramMessage.bsV = true;
        paramMessage.bsR.onLongPress(paramMessage.bsY);
        AppMethodBeat.o(195788);
        return;
      }
      if (d.b.this.bsS != null)
      {
        if (!d.b.this.bsT)
        {
          d.b.this.bsS.onSingleTapConfirmed(d.b.this.bsY);
          AppMethodBeat.o(195788);
          return;
        }
        d.b.this.bsU = true;
        AppMethodBeat.o(195788);
        return;
      }
      AppMethodBeat.o(195788);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.core.g.d.b
 * JD-Core Version:    0.7.0.1
 */