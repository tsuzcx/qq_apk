package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;

public final class t
{
  private static final Interpolator sInterpolator = new Interpolator()
  {
    public final float getInterpolation(float paramAnonymousFloat)
    {
      paramAnonymousFloat -= 1.0F;
      return paramAnonymousFloat * (paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat) + 1.0F;
    }
  };
  float[] MA;
  private int[] MC;
  private int[] MD;
  private int[] MF;
  private int MG;
  private float MH;
  float MI;
  int MJ;
  int MK;
  private final a ML;
  View MM;
  private boolean MN;
  private final ViewGroup MO;
  private final Runnable MP = new Runnable()
  {
    public final void run()
    {
      t.this.aL(0);
    }
  };
  int Mw;
  float[] Mx;
  float[] My;
  float[] Mz;
  private OverScroller jR;
  private int mActivePointerId = -1;
  public int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  
  private t(Context paramContext, ViewGroup paramViewGroup, a parama)
  {
    if (paramViewGroup == null) {
      throw new IllegalArgumentException("Parent view may not be null");
    }
    if (parama == null) {
      throw new IllegalArgumentException("Callback may not be null");
    }
    this.MO = paramViewGroup;
    this.ML = parama;
    paramViewGroup = ViewConfiguration.get(paramContext);
    this.MJ = ((int)(paramContext.getResources().getDisplayMetrics().density * 20.0F + 0.5F));
    this.mTouchSlop = paramViewGroup.getScaledTouchSlop();
    this.MH = paramViewGroup.getScaledMaximumFlingVelocity();
    this.MI = paramViewGroup.getScaledMinimumFlingVelocity();
    this.jR = new OverScroller(paramContext, sInterpolator);
  }
  
  public static t a(ViewGroup paramViewGroup, float paramFloat, a parama)
  {
    paramViewGroup = a(paramViewGroup, parama);
    paramViewGroup.mTouchSlop = ((int)(paramViewGroup.mTouchSlop * (1.0F / paramFloat)));
    return paramViewGroup;
  }
  
  public static t a(ViewGroup paramViewGroup, a parama)
  {
    return new t(paramViewGroup.getContext(), paramViewGroup, parama);
  }
  
  private void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    int j = 0;
    if ((this.Mx == null) || (this.Mx.length <= paramInt))
    {
      localObject = new float[paramInt + 1];
      float[] arrayOfFloat1 = new float[paramInt + 1];
      float[] arrayOfFloat2 = new float[paramInt + 1];
      float[] arrayOfFloat3 = new float[paramInt + 1];
      int[] arrayOfInt1 = new int[paramInt + 1];
      int[] arrayOfInt2 = new int[paramInt + 1];
      int[] arrayOfInt3 = new int[paramInt + 1];
      if (this.Mx != null)
      {
        System.arraycopy(this.Mx, 0, localObject, 0, this.Mx.length);
        System.arraycopy(this.My, 0, arrayOfFloat1, 0, this.My.length);
        System.arraycopy(this.Mz, 0, arrayOfFloat2, 0, this.Mz.length);
        System.arraycopy(this.MA, 0, arrayOfFloat3, 0, this.MA.length);
        System.arraycopy(this.MC, 0, arrayOfInt1, 0, this.MC.length);
        System.arraycopy(this.MD, 0, arrayOfInt2, 0, this.MD.length);
        System.arraycopy(this.MF, 0, arrayOfInt3, 0, this.MF.length);
      }
      this.Mx = ((float[])localObject);
      this.My = arrayOfFloat1;
      this.Mz = arrayOfFloat2;
      this.MA = arrayOfFloat3;
      this.MC = arrayOfInt1;
      this.MD = arrayOfInt2;
      this.MF = arrayOfInt3;
    }
    Object localObject = this.Mx;
    this.Mz[paramInt] = paramFloat1;
    localObject[paramInt] = paramFloat1;
    localObject = this.My;
    this.MA[paramInt] = paramFloat2;
    localObject[paramInt] = paramFloat2;
    localObject = this.MC;
    int m = (int)paramFloat1;
    int k = (int)paramFloat2;
    if (m < this.MO.getLeft() + this.MJ) {
      j = 1;
    }
    int i = j;
    if (k < this.MO.getTop() + this.MJ) {
      i = j | 0x4;
    }
    j = i;
    if (m > this.MO.getRight() - this.MJ) {
      j = i | 0x2;
    }
    i = j;
    if (k > this.MO.getBottom() - this.MJ) {
      i = j | 0x8;
    }
    localObject[paramInt] = i;
    this.MG |= 1 << paramInt;
  }
  
  private boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    if (((this.MC[paramInt1] & paramInt2) != paramInt2) || ((this.MK & paramInt2) == 0) || ((this.MF[paramInt1] & paramInt2) == paramInt2) || ((this.MD[paramInt1] & paramInt2) == paramInt2) || ((paramFloat1 <= this.mTouchSlop) && (paramFloat2 <= this.mTouchSlop))) {}
    while (((this.MD[paramInt1] & paramInt2) != 0) || (paramFloat1 <= this.mTouchSlop)) {
      return false;
    }
    return true;
  }
  
  private void aJ(int paramInt)
  {
    if ((this.Mx == null) || (!aK(paramInt))) {
      return;
    }
    this.Mx[paramInt] = 0.0F;
    this.My[paramInt] = 0.0F;
    this.Mz[paramInt] = 0.0F;
    this.MA[paramInt] = 0.0F;
    this.MC[paramInt] = 0;
    this.MD[paramInt] = 0;
    this.MF[paramInt] = 0;
    this.MG &= (1 << paramInt ^ 0xFFFFFFFF);
  }
  
  private boolean aM(int paramInt)
  {
    if (!aK(paramInt))
    {
      new StringBuilder("Ignoring pointerId=").append(paramInt).append(" because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
      return false;
    }
    return true;
  }
  
  private void b(float paramFloat1, float paramFloat2, int paramInt)
  {
    int j = 1;
    if (a(paramFloat1, paramFloat2, paramInt, 1)) {}
    for (;;)
    {
      int i = j;
      if (a(paramFloat2, paramFloat1, paramInt, 4)) {
        i = j | 0x4;
      }
      j = i;
      if (a(paramFloat1, paramFloat2, paramInt, 2)) {
        j = i | 0x2;
      }
      i = j;
      if (a(paramFloat2, paramFloat1, paramInt, 8)) {
        i = j | 0x8;
      }
      if (i != 0)
      {
        int[] arrayOfInt = this.MD;
        arrayOfInt[paramInt] |= i;
        this.ML.u(i, paramInt);
      }
      return;
      j = 0;
    }
  }
  
  private boolean c(View paramView, float paramFloat1, float paramFloat2)
  {
    if (paramView == null) {}
    label20:
    int j;
    label72:
    label78:
    do
    {
      do
      {
        return false;
        int i;
        if (this.ML.s(paramView) > 0)
        {
          i = 1;
          if (this.ML.aY() <= 0) {
            break label72;
          }
        }
        for (j = 1;; j = 0)
        {
          if ((i == 0) || (j == 0)) {
            break label78;
          }
          if (paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 <= this.mTouchSlop * this.mTouchSlop) {
            break;
          }
          return true;
          i = 0;
          break label20;
        }
        if (i == 0) {
          break;
        }
      } while (Math.abs(paramFloat1) <= this.mTouchSlop);
      return true;
    } while ((j == 0) || (Math.abs(paramFloat2) <= this.mTouchSlop));
    return true;
  }
  
  private static float distanceInfluenceForSnapDuration(float paramFloat)
  {
    return (float)Math.sin((paramFloat - 0.5F) * 0.4712389F);
  }
  
  private static float e(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f = Math.abs(paramFloat1);
    if (f < paramFloat2) {
      paramFloat2 = 0.0F;
    }
    do
    {
      return paramFloat2;
      if (f <= paramFloat3) {
        break;
      }
      paramFloat2 = paramFloat3;
    } while (paramFloat1 > 0.0F);
    return -paramFloat3;
    return paramFloat1;
  }
  
  private int e(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = h(paramInt3, (int)this.MI, (int)this.MH);
    paramInt4 = h(paramInt4, (int)this.MI, (int)this.MH);
    int i = Math.abs(paramInt1);
    int j = Math.abs(paramInt2);
    int k = Math.abs(paramInt3);
    int m = Math.abs(paramInt4);
    int n = k + m;
    int i1 = i + j;
    float f1;
    if (paramInt3 != 0)
    {
      f1 = k / n;
      if (paramInt4 == 0) {
        break label162;
      }
    }
    label162:
    for (float f2 = m / n;; f2 = j / i1)
    {
      paramInt1 = g(paramInt1, paramInt3, this.ML.s(paramView));
      paramInt2 = g(paramInt2, paramInt4, this.ML.aY());
      float f3 = paramInt1;
      return (int)(f2 * paramInt2 + f1 * f3);
      f1 = i / i1;
      break;
    }
  }
  
  private void e(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getPointerCount();
    int i = 0;
    while (i < j)
    {
      int k = paramMotionEvent.getPointerId(i);
      if (aM(k))
      {
        float f1 = paramMotionEvent.getX(i);
        float f2 = paramMotionEvent.getY(i);
        this.Mz[k] = f1;
        this.MA[k] = f2;
      }
      i += 1;
    }
  }
  
  private void eq()
  {
    if (this.Mx == null) {
      return;
    }
    Arrays.fill(this.Mx, 0.0F);
    Arrays.fill(this.My, 0.0F);
    Arrays.fill(this.Mz, 0.0F);
    Arrays.fill(this.MA, 0.0F);
    Arrays.fill(this.MC, 0);
    Arrays.fill(this.MD, 0);
    Arrays.fill(this.MF, 0);
    this.MG = 0;
  }
  
  private void er()
  {
    this.mVelocityTracker.computeCurrentVelocity(1000, this.MH);
    u(e(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.MI, this.MH), e(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.MI, this.MH));
  }
  
  private int g(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0) {
      return 0;
    }
    int i = this.MO.getWidth();
    int j = i / 2;
    float f3 = Math.min(1.0F, Math.abs(paramInt1) / i);
    float f1 = j;
    float f2 = j;
    f3 = distanceInfluenceForSnapDuration(f3);
    paramInt2 = Math.abs(paramInt2);
    if (paramInt2 > 0) {}
    for (paramInt1 = Math.round(Math.abs((f3 * f2 + f1) / paramInt2) * 1000.0F) * 4;; paramInt1 = (int)((Math.abs(paramInt1) / paramInt3 + 1.0F) * 256.0F)) {
      return Math.min(paramInt1, 600);
    }
  }
  
  private static int h(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = Math.abs(paramInt1);
    if (i < paramInt2) {
      paramInt2 = 0;
    }
    do
    {
      return paramInt2;
      if (i <= paramInt3) {
        break;
      }
      paramInt2 = paramInt3;
    } while (paramInt1 > 0);
    return -paramInt3;
    return paramInt1;
  }
  
  private boolean h(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = this.MM.getLeft();
    int j = this.MM.getTop();
    paramInt1 -= i;
    paramInt2 -= j;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.jR.abortAnimation();
      aL(0);
      return false;
    }
    paramInt3 = e(this.MM, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jR.startScroll(i, j, paramInt1, paramInt2, paramInt3);
    aL(2);
    return true;
  }
  
  private void i(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = this.MM.getLeft();
    int j = this.MM.getTop();
    int i = paramInt1;
    if (paramInt3 != 0)
    {
      i = this.ML.d(this.MM, paramInt1);
      android.support.v4.view.t.s(this.MM, i - k);
    }
    paramInt1 = paramInt2;
    if (paramInt4 != 0)
    {
      paramInt1 = this.ML.c(this.MM, paramInt2);
      android.support.v4.view.t.q(this.MM, paramInt1 - j);
    }
    if ((paramInt3 != 0) || (paramInt4 != 0)) {
      this.ML.b(this.MM, i, paramInt1);
    }
  }
  
  public static boolean j(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {}
    while ((paramInt1 < paramView.getLeft()) || (paramInt1 >= paramView.getRight()) || (paramInt2 < paramView.getTop()) || (paramInt2 >= paramView.getBottom())) {
      return false;
    }
    return true;
  }
  
  private void u(float paramFloat1, float paramFloat2)
  {
    this.MN = true;
    this.ML.a(this.MM, paramFloat1, paramFloat2);
    this.MN = false;
    if (this.Mw == 1) {
      aL(0);
    }
  }
  
  private boolean x(View paramView, int paramInt)
  {
    if ((paramView == this.MM) && (this.mActivePointerId == paramInt)) {
      return true;
    }
    if ((paramView != null) && (this.ML.b(paramView, paramInt)))
    {
      this.mActivePointerId = paramInt;
      w(paramView, paramInt);
      return true;
    }
    return false;
  }
  
  private boolean z(int paramInt1, int paramInt2)
  {
    return j(this.MM, paramInt1, paramInt2);
  }
  
  public final View A(int paramInt1, int paramInt2)
  {
    int i = this.MO.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.MO.getChildAt(i);
      if ((paramInt1 >= localView.getLeft()) && (paramInt1 < localView.getRight()) && (paramInt2 >= localView.getTop()) && (paramInt2 < localView.getBottom())) {
        return localView;
      }
      i -= 1;
    }
    return null;
  }
  
  public final boolean aK(int paramInt)
  {
    return (this.MG & 1 << paramInt) != 0;
  }
  
  final void aL(int paramInt)
  {
    this.MO.removeCallbacks(this.MP);
    if (this.Mw != paramInt)
    {
      this.Mw = paramInt;
      this.ML.w(paramInt);
      if (this.Mw == 0) {
        this.MM = null;
      }
    }
  }
  
  public final void abort()
  {
    cancel();
    if (this.Mw == 2)
    {
      this.jR.getCurrX();
      this.jR.getCurrY();
      this.jR.abortAnimation();
      int i = this.jR.getCurrX();
      int j = this.jR.getCurrY();
      this.ML.b(this.MM, i, j);
    }
    aL(0);
  }
  
  public final void cancel()
  {
    this.mActivePointerId = -1;
    eq();
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  public final boolean ep()
  {
    boolean bool2 = false;
    if (this.Mw == 2)
    {
      boolean bool3 = this.jR.computeScrollOffset();
      int i = this.jR.getCurrX();
      int j = this.jR.getCurrY();
      int k = i - this.MM.getLeft();
      int m = j - this.MM.getTop();
      if (k != 0) {
        android.support.v4.view.t.s(this.MM, k);
      }
      if (m != 0) {
        android.support.v4.view.t.q(this.MM, m);
      }
      if ((k != 0) || (m != 0)) {
        this.ML.b(this.MM, i, j);
      }
      bool1 = bool3;
      if (bool3)
      {
        bool1 = bool3;
        if (i == this.jR.getFinalX())
        {
          bool1 = bool3;
          if (j == this.jR.getFinalY())
          {
            this.jR.abortAnimation();
            bool1 = false;
          }
        }
      }
      if (!bool1) {
        this.MO.post(this.MP);
      }
    }
    boolean bool1 = bool2;
    if (this.Mw == 2) {
      bool1 = true;
    }
    return bool1;
  }
  
  public final boolean f(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getActionMasked();
    int i = paramMotionEvent.getActionIndex();
    if (j == 0) {
      cancel();
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    switch (j)
    {
    }
    while (this.Mw == 1)
    {
      return true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      i = paramMotionEvent.getPointerId(0);
      a(f1, f2, i);
      paramMotionEvent = A((int)f1, (int)f2);
      if ((paramMotionEvent == this.MM) && (this.Mw == 2)) {
        x(paramMotionEvent, i);
      }
      if ((this.MC[i] & this.MK) != 0)
      {
        this.ML.eb();
        continue;
        j = paramMotionEvent.getPointerId(i);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        a(f1, f2, j);
        if (this.Mw == 0)
        {
          if ((this.MC[j] & this.MK) != 0) {
            this.ML.eb();
          }
        }
        else if (this.Mw == 2)
        {
          paramMotionEvent = A((int)f1, (int)f2);
          if (paramMotionEvent == this.MM)
          {
            x(paramMotionEvent, j);
            continue;
            if ((this.Mx != null) && (this.My != null))
            {
              int k = paramMotionEvent.getPointerCount();
              i = 0;
              if (i < k)
              {
                int m = paramMotionEvent.getPointerId(i);
                float f3;
                float f4;
                View localView;
                if (aM(m))
                {
                  f1 = paramMotionEvent.getX(i);
                  f2 = paramMotionEvent.getY(i);
                  f3 = f1 - this.Mx[m];
                  f4 = f2 - this.My[m];
                  localView = A((int)f1, (int)f2);
                  if ((localView == null) || (!c(localView, f3, f4))) {
                    break label551;
                  }
                }
                label551:
                for (j = 1;; j = 0)
                {
                  if (j != 0)
                  {
                    int n = localView.getLeft();
                    int i1 = (int)f3;
                    i1 = this.ML.d(localView, i1 + n);
                    int i2 = localView.getTop();
                    int i3 = (int)f4;
                    i3 = this.ML.c(localView, i3 + i2);
                    int i4 = this.ML.s(localView);
                    int i5 = this.ML.aY();
                    if (((i4 == 0) || ((i4 > 0) && (i1 == n))) && ((i5 == 0) || ((i5 > 0) && (i3 == i2)))) {
                      break label557;
                    }
                  }
                  b(f3, f4, m);
                  if ((this.Mw == 1) || ((j != 0) && (x(localView, m)))) {
                    break label557;
                  }
                  i += 1;
                  break;
                }
              }
              label557:
              e(paramMotionEvent);
              continue;
              aJ(paramMotionEvent.getPointerId(i));
              continue;
              cancel();
            }
          }
        }
      }
    }
    return false;
  }
  
  public final void g(MotionEvent paramMotionEvent)
  {
    int i = 0;
    int j = 0;
    int m = paramMotionEvent.getActionMasked();
    int k = paramMotionEvent.getActionIndex();
    if (m == 0) {
      cancel();
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    float f1;
    float f2;
    switch (m)
    {
    case 4: 
    default: 
    case 0: 
    case 5: 
    case 2: 
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              f1 = paramMotionEvent.getX();
              f2 = paramMotionEvent.getY();
              i = paramMotionEvent.getPointerId(0);
              paramMotionEvent = A((int)f1, (int)f2);
              a(f1, f2, i);
              x(paramMotionEvent, i);
            } while ((this.MC[i] & this.MK) == 0);
            this.ML.eb();
            return;
            i = paramMotionEvent.getPointerId(k);
            f1 = paramMotionEvent.getX(k);
            f2 = paramMotionEvent.getY(k);
            a(f1, f2, i);
            if (this.Mw != 0) {
              break;
            }
            x(A((int)f1, (int)f2), i);
          } while ((this.MC[i] & this.MK) == 0);
          this.ML.eb();
          return;
        } while (!z((int)f1, (int)f2));
        x(this.MM, i);
        return;
        if (this.Mw != 1) {
          break;
        }
      } while (!aM(this.mActivePointerId));
      i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      f1 = paramMotionEvent.getX(i);
      f2 = paramMotionEvent.getY(i);
      i = (int)(f1 - this.Mz[this.mActivePointerId]);
      j = (int)(f2 - this.MA[this.mActivePointerId]);
      i(this.MM.getLeft() + i, this.MM.getTop() + j, i, j);
      e(paramMotionEvent);
      return;
      k = paramMotionEvent.getPointerCount();
      i = j;
      while (i < k)
      {
        j = paramMotionEvent.getPointerId(i);
        if (aM(j))
        {
          f1 = paramMotionEvent.getX(i);
          f2 = paramMotionEvent.getY(i);
          float f3 = f1 - this.Mx[j];
          float f4 = f2 - this.My[j];
          b(f3, f4, j);
          if (this.Mw == 1) {
            break;
          }
          View localView = A((int)f1, (int)f2);
          if ((c(localView, f3, f4)) && (x(localView, j))) {
            break;
          }
        }
        i += 1;
      }
      e(paramMotionEvent);
      return;
    case 6: 
      j = paramMotionEvent.getPointerId(k);
      if ((this.Mw == 1) && (j == this.mActivePointerId))
      {
        k = paramMotionEvent.getPointerCount();
        if (i >= k) {
          break label663;
        }
        m = paramMotionEvent.getPointerId(i);
        if (m == this.mActivePointerId) {
          break label618;
        }
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        if ((A((int)f1, (int)f2) != this.MM) || (!x(this.MM, m))) {
          break label618;
        }
      }
      break;
    }
    label663:
    for (i = this.mActivePointerId;; i = -1)
    {
      if (i == -1) {
        er();
      }
      aJ(j);
      return;
      label618:
      i += 1;
      break;
      if (this.Mw == 1) {
        er();
      }
      cancel();
      return;
      if (this.Mw == 1) {
        u(0.0F, 0.0F);
      }
      cancel();
      return;
    }
  }
  
  public final boolean i(View paramView, int paramInt1, int paramInt2)
  {
    this.MM = paramView;
    this.mActivePointerId = -1;
    boolean bool = h(paramInt1, paramInt2, 0, 0);
    if ((!bool) && (this.Mw == 0) && (this.MM != null)) {
      this.MM = null;
    }
    return bool;
  }
  
  public final void w(View paramView, int paramInt)
  {
    if (paramView.getParent() != this.MO) {
      throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.MO + ")");
    }
    this.MM = paramView;
    this.mActivePointerId = paramInt;
    this.ML.k(paramView, paramInt);
    aL(1);
  }
  
  public final boolean y(int paramInt1, int paramInt2)
  {
    if (!this.MN) {
      throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }
    return h(paramInt1, paramInt2, (int)this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int)this.mVelocityTracker.getYVelocity(this.mActivePointerId));
  }
  
  public static abstract class a
  {
    public void a(View paramView, float paramFloat1, float paramFloat2) {}
    
    public int aY()
    {
      return 0;
    }
    
    public void b(View paramView, int paramInt1, int paramInt2) {}
    
    public abstract boolean b(View paramView, int paramInt);
    
    public int c(View paramView, int paramInt)
    {
      return 0;
    }
    
    public int d(View paramView, int paramInt)
    {
      return 0;
    }
    
    public void eb() {}
    
    public void k(View paramView, int paramInt) {}
    
    public int s(View paramView)
    {
      return 0;
    }
    
    public void u(int paramInt1, int paramInt2) {}
    
    public void w(int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.widget.t
 * JD-Core Version:    0.7.0.1
 */