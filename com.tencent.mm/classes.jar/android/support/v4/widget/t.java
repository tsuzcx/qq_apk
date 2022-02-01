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
  private OverScroller SC;
  private int[] UA;
  private int[] UB;
  private int UC;
  private float UD;
  float UE;
  int UF;
  int UG;
  private final a UH;
  View UI;
  private boolean UJ;
  private final ViewGroup UK;
  private final Runnable UL = new Runnable()
  {
    public final void run()
    {
      t.this.be(0);
    }
  };
  int Uu;
  float[] Uv;
  float[] Uw;
  float[] Ux;
  float[] Uy;
  private int[] Uz;
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
    this.UK = paramViewGroup;
    this.UH = parama;
    paramViewGroup = ViewConfiguration.get(paramContext);
    this.UF = ((int)(paramContext.getResources().getDisplayMetrics().density * 20.0F + 0.5F));
    this.mTouchSlop = paramViewGroup.getScaledTouchSlop();
    this.UD = paramViewGroup.getScaledMaximumFlingVelocity();
    this.UE = paramViewGroup.getScaledMinimumFlingVelocity();
    this.SC = new OverScroller(paramContext, sInterpolator);
  }
  
  private boolean B(int paramInt1, int paramInt2)
  {
    return i(this.UI, paramInt1, paramInt2);
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
    if ((this.Uv == null) || (this.Uv.length <= paramInt))
    {
      localObject = new float[paramInt + 1];
      float[] arrayOfFloat1 = new float[paramInt + 1];
      float[] arrayOfFloat2 = new float[paramInt + 1];
      float[] arrayOfFloat3 = new float[paramInt + 1];
      int[] arrayOfInt1 = new int[paramInt + 1];
      int[] arrayOfInt2 = new int[paramInt + 1];
      int[] arrayOfInt3 = new int[paramInt + 1];
      if (this.Uv != null)
      {
        System.arraycopy(this.Uv, 0, localObject, 0, this.Uv.length);
        System.arraycopy(this.Uw, 0, arrayOfFloat1, 0, this.Uw.length);
        System.arraycopy(this.Ux, 0, arrayOfFloat2, 0, this.Ux.length);
        System.arraycopy(this.Uy, 0, arrayOfFloat3, 0, this.Uy.length);
        System.arraycopy(this.Uz, 0, arrayOfInt1, 0, this.Uz.length);
        System.arraycopy(this.UA, 0, arrayOfInt2, 0, this.UA.length);
        System.arraycopy(this.UB, 0, arrayOfInt3, 0, this.UB.length);
      }
      this.Uv = ((float[])localObject);
      this.Uw = arrayOfFloat1;
      this.Ux = arrayOfFloat2;
      this.Uy = arrayOfFloat3;
      this.Uz = arrayOfInt1;
      this.UA = arrayOfInt2;
      this.UB = arrayOfInt3;
    }
    Object localObject = this.Uv;
    this.Ux[paramInt] = paramFloat1;
    localObject[paramInt] = paramFloat1;
    localObject = this.Uw;
    this.Uy[paramInt] = paramFloat2;
    localObject[paramInt] = paramFloat2;
    localObject = this.Uz;
    int m = (int)paramFloat1;
    int k = (int)paramFloat2;
    if (m < this.UK.getLeft() + this.UF) {
      j = 1;
    }
    int i = j;
    if (k < this.UK.getTop() + this.UF) {
      i = j | 0x4;
    }
    j = i;
    if (m > this.UK.getRight() - this.UF) {
      j = i | 0x2;
    }
    i = j;
    if (k > this.UK.getBottom() - this.UF) {
      i = j | 0x8;
    }
    localObject[paramInt] = i;
    this.UC |= 1 << paramInt;
  }
  
  private boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    if (((this.Uz[paramInt1] & paramInt2) != paramInt2) || ((this.UG & paramInt2) == 0) || ((this.UB[paramInt1] & paramInt2) == paramInt2) || ((this.UA[paramInt1] & paramInt2) == paramInt2) || ((paramFloat1 <= this.mTouchSlop) && (paramFloat2 <= this.mTouchSlop))) {}
    while (((this.UA[paramInt1] & paramInt2) != 0) || (paramFloat1 <= this.mTouchSlop)) {
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
        int[] arrayOfInt = this.UA;
        arrayOfInt[paramInt] |= i;
        this.UH.w(i, paramInt);
      }
      return;
      j = 0;
    }
  }
  
  private void bc(int paramInt)
  {
    if ((this.Uv == null) || (!bd(paramInt))) {
      return;
    }
    this.Uv[paramInt] = 0.0F;
    this.Uw[paramInt] = 0.0F;
    this.Ux[paramInt] = 0.0F;
    this.Uy[paramInt] = 0.0F;
    this.Uz[paramInt] = 0;
    this.UA[paramInt] = 0;
    this.UB[paramInt] = 0;
    this.UC &= (1 << paramInt ^ 0xFFFFFFFF);
  }
  
  private boolean bf(int paramInt)
  {
    if (!bd(paramInt))
    {
      new StringBuilder("Ignoring pointerId=").append(paramInt).append(" because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
      return false;
    }
    return true;
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
        if (this.UH.x(paramView) > 0)
        {
          i = 1;
          if (this.UH.bO() <= 0) {
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
  
  private int e(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = i(paramInt3, (int)this.UE, (int)this.UD);
    paramInt4 = i(paramInt4, (int)this.UE, (int)this.UD);
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
      paramInt1 = h(paramInt1, paramInt3, this.UH.x(paramView));
      paramInt2 = h(paramInt2, paramInt4, this.UH.bO());
      float f3 = paramInt1;
      return (int)(f2 * paramInt2 + f1 * f3);
      f1 = i / i1;
      break;
    }
  }
  
  private static float f(float paramFloat1, float paramFloat2, float paramFloat3)
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
  
  private void f(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getPointerCount();
    int i = 0;
    while (i < j)
    {
      int k = paramMotionEvent.getPointerId(i);
      if (bf(k))
      {
        float f1 = paramMotionEvent.getX(i);
        float f2 = paramMotionEvent.getY(i);
        this.Ux[k] = f1;
        this.Uy[k] = f2;
      }
      i += 1;
    }
  }
  
  private void fQ()
  {
    if (this.Uv == null) {
      return;
    }
    Arrays.fill(this.Uv, 0.0F);
    Arrays.fill(this.Uw, 0.0F);
    Arrays.fill(this.Ux, 0.0F);
    Arrays.fill(this.Uy, 0.0F);
    Arrays.fill(this.Uz, 0);
    Arrays.fill(this.UA, 0);
    Arrays.fill(this.UB, 0);
    this.UC = 0;
  }
  
  private void fR()
  {
    this.mVelocityTracker.computeCurrentVelocity(1000, this.UD);
    l(f(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.UE, this.UD), f(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.UE, this.UD));
  }
  
  private int h(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0) {
      return 0;
    }
    int i = this.UK.getWidth();
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
  
  private boolean h(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = this.UI.getLeft();
    int j = this.UI.getTop();
    paramInt1 -= i;
    paramInt2 -= j;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.SC.abortAnimation();
      be(0);
      return false;
    }
    paramInt3 = e(this.UI, paramInt1, paramInt2, paramInt3, paramInt4);
    this.SC.startScroll(i, j, paramInt1, paramInt2, paramInt3);
    be(2);
    return true;
  }
  
  private static int i(int paramInt1, int paramInt2, int paramInt3)
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
  
  private void i(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = this.UI.getLeft();
    int j = this.UI.getTop();
    int i = paramInt1;
    if (paramInt3 != 0)
    {
      i = this.UH.e(this.UI, paramInt1);
      android.support.v4.view.t.u(this.UI, i - k);
    }
    paramInt1 = paramInt2;
    if (paramInt4 != 0)
    {
      paramInt1 = this.UH.d(this.UI, paramInt2);
      android.support.v4.view.t.s(this.UI, paramInt1 - j);
    }
    if ((paramInt3 != 0) || (paramInt4 != 0)) {
      this.UH.b(this.UI, i, paramInt1);
    }
  }
  
  public static boolean i(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {}
    while ((paramInt1 < paramView.getLeft()) || (paramInt1 >= paramView.getRight()) || (paramInt2 < paramView.getTop()) || (paramInt2 >= paramView.getBottom())) {
      return false;
    }
    return true;
  }
  
  private void l(float paramFloat1, float paramFloat2)
  {
    this.UJ = true;
    this.UH.a(this.UI, paramFloat1, paramFloat2);
    this.UJ = false;
    if (this.Uu == 1) {
      be(0);
    }
  }
  
  private boolean z(View paramView, int paramInt)
  {
    if ((paramView == this.UI) && (this.mActivePointerId == paramInt)) {
      return true;
    }
    if ((paramView != null) && (this.UH.c(paramView, paramInt)))
    {
      this.mActivePointerId = paramInt;
      y(paramView, paramInt);
      return true;
    }
    return false;
  }
  
  public final boolean A(int paramInt1, int paramInt2)
  {
    if (!this.UJ) {
      throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }
    return h(paramInt1, paramInt2, (int)this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int)this.mVelocityTracker.getYVelocity(this.mActivePointerId));
  }
  
  public final View C(int paramInt1, int paramInt2)
  {
    int i = this.UK.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.UK.getChildAt(i);
      if ((paramInt1 >= localView.getLeft()) && (paramInt1 < localView.getRight()) && (paramInt2 >= localView.getTop()) && (paramInt2 < localView.getBottom())) {
        return localView;
      }
      i -= 1;
    }
    return null;
  }
  
  public final void abort()
  {
    cancel();
    if (this.Uu == 2)
    {
      this.SC.getCurrX();
      this.SC.getCurrY();
      this.SC.abortAnimation();
      int i = this.SC.getCurrX();
      int j = this.SC.getCurrY();
      this.UH.b(this.UI, i, j);
    }
    be(0);
  }
  
  public final boolean bd(int paramInt)
  {
    return (this.UC & 1 << paramInt) != 0;
  }
  
  final void be(int paramInt)
  {
    this.UK.removeCallbacks(this.UL);
    if (this.Uu != paramInt)
    {
      this.Uu = paramInt;
      this.UH.M(paramInt);
      if (this.Uu == 0) {
        this.UI = null;
      }
    }
  }
  
  public final void cancel()
  {
    this.mActivePointerId = -1;
    fQ();
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  public final boolean fP()
  {
    boolean bool2 = false;
    if (this.Uu == 2)
    {
      boolean bool3 = this.SC.computeScrollOffset();
      int i = this.SC.getCurrX();
      int j = this.SC.getCurrY();
      int k = i - this.UI.getLeft();
      int m = j - this.UI.getTop();
      if (k != 0) {
        android.support.v4.view.t.u(this.UI, k);
      }
      if (m != 0) {
        android.support.v4.view.t.s(this.UI, m);
      }
      if ((k != 0) || (m != 0)) {
        this.UH.b(this.UI, i, j);
      }
      bool1 = bool3;
      if (bool3)
      {
        bool1 = bool3;
        if (i == this.SC.getFinalX())
        {
          bool1 = bool3;
          if (j == this.SC.getFinalY())
          {
            this.SC.abortAnimation();
            bool1 = false;
          }
        }
      }
      if (!bool1) {
        this.UK.post(this.UL);
      }
    }
    boolean bool1 = bool2;
    if (this.Uu == 2) {
      bool1 = true;
    }
    return bool1;
  }
  
  public final boolean g(MotionEvent paramMotionEvent)
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
    while (this.Uu == 1)
    {
      return true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      i = paramMotionEvent.getPointerId(0);
      a(f1, f2, i);
      paramMotionEvent = C((int)f1, (int)f2);
      if ((paramMotionEvent == this.UI) && (this.Uu == 2)) {
        z(paramMotionEvent, i);
      }
      if ((this.Uz[i] & this.UG) != 0)
      {
        this.UH.fB();
        continue;
        j = paramMotionEvent.getPointerId(i);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        a(f1, f2, j);
        if (this.Uu == 0)
        {
          if ((this.Uz[j] & this.UG) != 0) {
            this.UH.fB();
          }
        }
        else if (this.Uu == 2)
        {
          paramMotionEvent = C((int)f1, (int)f2);
          if (paramMotionEvent == this.UI)
          {
            z(paramMotionEvent, j);
            continue;
            if ((this.Uv != null) && (this.Uw != null))
            {
              int k = paramMotionEvent.getPointerCount();
              i = 0;
              if (i < k)
              {
                int m = paramMotionEvent.getPointerId(i);
                float f3;
                float f4;
                View localView;
                if (bf(m))
                {
                  f1 = paramMotionEvent.getX(i);
                  f2 = paramMotionEvent.getY(i);
                  f3 = f1 - this.Uv[m];
                  f4 = f2 - this.Uw[m];
                  localView = C((int)f1, (int)f2);
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
                    i1 = this.UH.e(localView, i1 + n);
                    int i2 = localView.getTop();
                    int i3 = (int)f4;
                    i3 = this.UH.d(localView, i3 + i2);
                    int i4 = this.UH.x(localView);
                    int i5 = this.UH.bO();
                    if (((i4 == 0) || ((i4 > 0) && (i1 == n))) && ((i5 == 0) || ((i5 > 0) && (i3 == i2)))) {
                      break label557;
                    }
                  }
                  b(f3, f4, m);
                  if ((this.Uu == 1) || ((j != 0) && (z(localView, m)))) {
                    break label557;
                  }
                  i += 1;
                  break;
                }
              }
              label557:
              f(paramMotionEvent);
              continue;
              bc(paramMotionEvent.getPointerId(i));
              continue;
              cancel();
            }
          }
        }
      }
    }
    return false;
  }
  
  public final void h(MotionEvent paramMotionEvent)
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
              paramMotionEvent = C((int)f1, (int)f2);
              a(f1, f2, i);
              z(paramMotionEvent, i);
            } while ((this.Uz[i] & this.UG) == 0);
            this.UH.fB();
            return;
            i = paramMotionEvent.getPointerId(k);
            f1 = paramMotionEvent.getX(k);
            f2 = paramMotionEvent.getY(k);
            a(f1, f2, i);
            if (this.Uu != 0) {
              break;
            }
            z(C((int)f1, (int)f2), i);
          } while ((this.Uz[i] & this.UG) == 0);
          this.UH.fB();
          return;
        } while (!B((int)f1, (int)f2));
        z(this.UI, i);
        return;
        if (this.Uu != 1) {
          break;
        }
      } while (!bf(this.mActivePointerId));
      i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      f1 = paramMotionEvent.getX(i);
      f2 = paramMotionEvent.getY(i);
      i = (int)(f1 - this.Ux[this.mActivePointerId]);
      j = (int)(f2 - this.Uy[this.mActivePointerId]);
      i(this.UI.getLeft() + i, this.UI.getTop() + j, i, j);
      f(paramMotionEvent);
      return;
      k = paramMotionEvent.getPointerCount();
      i = j;
      while (i < k)
      {
        j = paramMotionEvent.getPointerId(i);
        if (bf(j))
        {
          f1 = paramMotionEvent.getX(i);
          f2 = paramMotionEvent.getY(i);
          float f3 = f1 - this.Uv[j];
          float f4 = f2 - this.Uw[j];
          b(f3, f4, j);
          if (this.Uu == 1) {
            break;
          }
          View localView = C((int)f1, (int)f2);
          if ((c(localView, f3, f4)) && (z(localView, j))) {
            break;
          }
        }
        i += 1;
      }
      f(paramMotionEvent);
      return;
    case 6: 
      j = paramMotionEvent.getPointerId(k);
      if ((this.Uu == 1) && (j == this.mActivePointerId))
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
        if ((C((int)f1, (int)f2) != this.UI) || (!z(this.UI, m))) {
          break label618;
        }
      }
      break;
    }
    label663:
    for (i = this.mActivePointerId;; i = -1)
    {
      if (i == -1) {
        fR();
      }
      bc(j);
      return;
      label618:
      i += 1;
      break;
      if (this.Uu == 1) {
        fR();
      }
      cancel();
      return;
      if (this.Uu == 1) {
        l(0.0F, 0.0F);
      }
      cancel();
      return;
    }
  }
  
  public final boolean h(View paramView, int paramInt1, int paramInt2)
  {
    this.UI = paramView;
    this.mActivePointerId = -1;
    boolean bool = h(paramInt1, paramInt2, 0, 0);
    if ((!bool) && (this.Uu == 0) && (this.UI != null)) {
      this.UI = null;
    }
    return bool;
  }
  
  public final void y(View paramView, int paramInt)
  {
    if (paramView.getParent() != this.UK) {
      throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.UK + ")");
    }
    this.UI = paramView;
    this.mActivePointerId = paramInt;
    this.UH.l(paramView, paramInt);
    be(1);
  }
  
  public static abstract class a
  {
    public void M(int paramInt) {}
    
    public void a(View paramView, float paramFloat1, float paramFloat2) {}
    
    public void b(View paramView, int paramInt1, int paramInt2) {}
    
    public int bO()
    {
      return 0;
    }
    
    public abstract boolean c(View paramView, int paramInt);
    
    public int d(View paramView, int paramInt)
    {
      return 0;
    }
    
    public int e(View paramView, int paramInt)
    {
      return 0;
    }
    
    public void fB() {}
    
    public void l(View paramView, int paramInt) {}
    
    public void w(int paramInt1, int paramInt2) {}
    
    public int x(View paramView)
    {
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.widget.t
 * JD-Core Version:    0.7.0.1
 */