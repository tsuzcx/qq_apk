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
  private static final int MM;
  private static final int MN;
  private static final int MO;
  private int MI;
  private int MJ;
  private int MK;
  private int ML;
  final GestureDetector.OnGestureListener MP;
  GestureDetector.OnDoubleTapListener MQ;
  boolean MR;
  boolean MS;
  boolean MT;
  private boolean MU;
  private boolean MV;
  MotionEvent MW;
  private MotionEvent MX;
  private boolean MY;
  private float MZ;
  private float Na;
  private float Nb;
  private float Nc;
  private boolean Nd;
  final Handler mHandler;
  private VelocityTracker mVelocityTracker;
  
  static
  {
    AppMethodBeat.i(251427);
    MM = ViewConfiguration.getLongPressTimeout();
    MN = ViewConfiguration.getTapTimeout();
    MO = ViewConfiguration.getDoubleTapTimeout();
    AppMethodBeat.o(251427);
  }
  
  d$b(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
  {
    AppMethodBeat.i(251421);
    this.mHandler = new a();
    this.MP = paramOnGestureListener;
    if ((paramOnGestureListener instanceof GestureDetector.OnDoubleTapListener)) {
      this.MQ = ((GestureDetector.OnDoubleTapListener)paramOnGestureListener);
    }
    if (paramContext == null)
    {
      paramContext = new IllegalArgumentException("Context must not be null");
      AppMethodBeat.o(251421);
      throw paramContext;
    }
    if (this.MP == null)
    {
      paramContext = new IllegalArgumentException("OnGestureListener must not be null");
      AppMethodBeat.o(251421);
      throw paramContext;
    }
    this.Nd = true;
    paramContext = ViewConfiguration.get(paramContext);
    int i = paramContext.getScaledTouchSlop();
    int j = paramContext.getScaledDoubleTapSlop();
    this.MK = paramContext.getScaledMinimumFlingVelocity();
    this.ML = paramContext.getScaledMaximumFlingVelocity();
    this.MI = (i * i);
    this.MJ = (j * j);
    AppMethodBeat.o(251421);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    AppMethodBeat.i(251424);
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
        AppMethodBeat.o(251424);
        return bool2;
        i = n;
        break;
        this.MZ = f2;
        this.Nb = f2;
        this.Na = f1;
        this.Nc = f1;
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
        this.MY = false;
        this.MU = false;
        this.MV = false;
        this.MS = false;
        bool2 = bool3;
        if (this.MT)
        {
          this.MT = false;
          bool2 = bool3;
          continue;
          this.MZ = f2;
          this.Nb = f2;
          this.Na = f1;
          this.Nc = f1;
          this.mVelocityTracker.computeCurrentVelocity(1000, this.ML);
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
          if (this.MQ != null)
          {
            bool2 = this.mHandler.hasMessages(3);
            if (bool2) {
              this.mHandler.removeMessages(3);
            }
            if ((this.MW != null) && (this.MX != null) && (bool2))
            {
              localMotionEvent = this.MW;
              localObject = this.MX;
              if ((this.MV) && (paramMotionEvent.getEventTime() - ((MotionEvent)localObject).getEventTime() <= MO))
              {
                i = (int)localMotionEvent.getX() - (int)paramMotionEvent.getX();
                k = (int)localMotionEvent.getY() - (int)paramMotionEvent.getY();
                if (k * k + i * i < this.MJ)
                {
                  i = 1;
                  if (i == 0) {
                    break label801;
                  }
                  this.MY = true;
                }
              }
            }
          }
          for (boolean bool1 = this.MQ.onDoubleTap(this.MW) | false | this.MQ.onDoubleTapEvent(paramMotionEvent);; bool1 = false)
          {
            this.MZ = f2;
            this.Nb = f2;
            this.Na = f1;
            this.Nc = f1;
            if (this.MW != null) {
              this.MW.recycle();
            }
            this.MW = MotionEvent.obtain(paramMotionEvent);
            this.MU = true;
            this.MV = true;
            this.MR = true;
            this.MT = false;
            this.MS = false;
            if (this.Nd)
            {
              this.mHandler.removeMessages(2);
              this.mHandler.sendEmptyMessageAtTime(2, this.MW.getDownTime() + MN + MM);
            }
            this.mHandler.sendEmptyMessageAtTime(1, this.MW.getDownTime() + MN);
            bool2 = bool1 | this.MP.onDown(paramMotionEvent);
            break;
            bool1 = false;
            break label610;
            label801:
            this.mHandler.sendEmptyMessageDelayed(3, MO);
          }
          bool2 = bool3;
          if (!this.MT)
          {
            f3 = this.MZ - f2;
            f4 = this.Na - f1;
            if (!this.MY) {
              break label871;
            }
            bool2 = this.MQ.onDoubleTapEvent(paramMotionEvent) | false;
          }
        }
      }
      if (this.MU)
      {
        j = (int)(f2 - this.Nb);
        k = (int)(f1 - this.Nc);
        j = j * j + k * k;
        if (j <= this.MI) {
          break label1415;
        }
        bool2 = this.MP.onScroll(this.MW, paramMotionEvent, f3, f4);
        this.MZ = f2;
        this.Na = f1;
        this.MU = false;
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
      }
      break;
    }
    for (;;)
    {
      if (j > this.MI) {
        this.MV = false;
      }
      break;
      if (Math.abs(f3) < 1.0F)
      {
        bool2 = bool3;
        if (Math.abs(f4) < 1.0F) {
          break;
        }
      }
      bool2 = this.MP.onScroll(this.MW, paramMotionEvent, f3, f4);
      this.MZ = f2;
      this.Na = f1;
      break;
      this.MR = false;
      localMotionEvent = MotionEvent.obtain(paramMotionEvent);
      if (this.MY) {
        bool2 = this.MQ.onDoubleTapEvent(paramMotionEvent) | false;
      }
      for (;;)
      {
        if (this.MX != null) {
          this.MX.recycle();
        }
        this.MX = localMotionEvent;
        if (this.mVelocityTracker != null)
        {
          this.mVelocityTracker.recycle();
          this.mVelocityTracker = null;
        }
        this.MY = false;
        this.MS = false;
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        break;
        if (this.MT)
        {
          this.mHandler.removeMessages(3);
          this.MT = false;
          bool2 = false;
        }
        else if (this.MU)
        {
          bool3 = this.MP.onSingleTapUp(paramMotionEvent);
          bool2 = bool3;
          if (this.MS)
          {
            bool2 = bool3;
            if (this.MQ != null)
            {
              this.MQ.onSingleTapConfirmed(paramMotionEvent);
              bool2 = bool3;
            }
          }
        }
        else
        {
          localObject = this.mVelocityTracker;
          j = paramMotionEvent.getPointerId(0);
          ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.ML);
          f1 = ((VelocityTracker)localObject).getYVelocity(j);
          f2 = ((VelocityTracker)localObject).getXVelocity(j);
          if ((Math.abs(f1) > this.MK) || (Math.abs(f2) > this.MK))
          {
            bool2 = this.MP.onFling(this.MW, paramMotionEvent, f2, f1);
            continue;
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
            this.MY = false;
            this.MR = false;
            this.MU = false;
            this.MV = false;
            this.MS = false;
            bool2 = bool3;
            if (!this.MT) {
              break;
            }
            this.MT = false;
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
      AppMethodBeat.i(251405);
      switch (paramMessage.what)
      {
      default: 
        paramMessage = new RuntimeException("Unknown message ".concat(String.valueOf(paramMessage)));
        AppMethodBeat.o(251405);
        throw paramMessage;
      case 1: 
        d.b.this.MP.onShowPress(d.b.this.MW);
        AppMethodBeat.o(251405);
        return;
      case 2: 
        paramMessage = d.b.this;
        paramMessage.mHandler.removeMessages(3);
        paramMessage.MS = false;
        paramMessage.MT = true;
        paramMessage.MP.onLongPress(paramMessage.MW);
        AppMethodBeat.o(251405);
        return;
      }
      if (d.b.this.MQ != null)
      {
        if (!d.b.this.MR)
        {
          d.b.this.MQ.onSingleTapConfirmed(d.b.this.MW);
          AppMethodBeat.o(251405);
          return;
        }
        d.b.this.MS = true;
        AppMethodBeat.o(251405);
        return;
      }
      AppMethodBeat.o(251405);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.g.d.b
 * JD-Core Version:    0.7.0.1
 */