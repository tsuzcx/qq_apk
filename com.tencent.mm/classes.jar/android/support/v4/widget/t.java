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
  private OverScroller RH;
  float[] TA;
  float[] TB;
  float[] TC;
  float[] TD;
  private int[] TE;
  private int[] TF;
  private int[] TG;
  private int TH;
  private float TI;
  float TJ;
  int TK;
  int TL;
  private final a TM;
  View TN;
  private boolean TO;
  private final ViewGroup TP;
  private final Runnable TQ = new Runnable()
  {
    public final void run()
    {
      t.this.be(0);
    }
  };
  int Tz;
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
    this.TP = paramViewGroup;
    this.TM = parama;
    paramViewGroup = ViewConfiguration.get(paramContext);
    this.TK = ((int)(paramContext.getResources().getDisplayMetrics().density * 20.0F + 0.5F));
    this.mTouchSlop = paramViewGroup.getScaledTouchSlop();
    this.TI = paramViewGroup.getScaledMaximumFlingVelocity();
    this.TJ = paramViewGroup.getScaledMinimumFlingVelocity();
    this.RH = new OverScroller(paramContext, sInterpolator);
  }
  
  private boolean B(int paramInt1, int paramInt2)
  {
    return i(this.TN, paramInt1, paramInt2);
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
    if ((this.TA == null) || (this.TA.length <= paramInt))
    {
      localObject = new float[paramInt + 1];
      float[] arrayOfFloat1 = new float[paramInt + 1];
      float[] arrayOfFloat2 = new float[paramInt + 1];
      float[] arrayOfFloat3 = new float[paramInt + 1];
      int[] arrayOfInt1 = new int[paramInt + 1];
      int[] arrayOfInt2 = new int[paramInt + 1];
      int[] arrayOfInt3 = new int[paramInt + 1];
      if (this.TA != null)
      {
        System.arraycopy(this.TA, 0, localObject, 0, this.TA.length);
        System.arraycopy(this.TB, 0, arrayOfFloat1, 0, this.TB.length);
        System.arraycopy(this.TC, 0, arrayOfFloat2, 0, this.TC.length);
        System.arraycopy(this.TD, 0, arrayOfFloat3, 0, this.TD.length);
        System.arraycopy(this.TE, 0, arrayOfInt1, 0, this.TE.length);
        System.arraycopy(this.TF, 0, arrayOfInt2, 0, this.TF.length);
        System.arraycopy(this.TG, 0, arrayOfInt3, 0, this.TG.length);
      }
      this.TA = ((float[])localObject);
      this.TB = arrayOfFloat1;
      this.TC = arrayOfFloat2;
      this.TD = arrayOfFloat3;
      this.TE = arrayOfInt1;
      this.TF = arrayOfInt2;
      this.TG = arrayOfInt3;
    }
    Object localObject = this.TA;
    this.TC[paramInt] = paramFloat1;
    localObject[paramInt] = paramFloat1;
    localObject = this.TB;
    this.TD[paramInt] = paramFloat2;
    localObject[paramInt] = paramFloat2;
    localObject = this.TE;
    int m = (int)paramFloat1;
    int k = (int)paramFloat2;
    if (m < this.TP.getLeft() + this.TK) {
      j = 1;
    }
    int i = j;
    if (k < this.TP.getTop() + this.TK) {
      i = j | 0x4;
    }
    j = i;
    if (m > this.TP.getRight() - this.TK) {
      j = i | 0x2;
    }
    i = j;
    if (k > this.TP.getBottom() - this.TK) {
      i = j | 0x8;
    }
    localObject[paramInt] = i;
    this.TH |= 1 << paramInt;
  }
  
  private boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    if (((this.TE[paramInt1] & paramInt2) != paramInt2) || ((this.TL & paramInt2) == 0) || ((this.TG[paramInt1] & paramInt2) == paramInt2) || ((this.TF[paramInt1] & paramInt2) == paramInt2) || ((paramFloat1 <= this.mTouchSlop) && (paramFloat2 <= this.mTouchSlop))) {}
    while (((this.TF[paramInt1] & paramInt2) != 0) || (paramFloat1 <= this.mTouchSlop)) {
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
        int[] arrayOfInt = this.TF;
        arrayOfInt[paramInt] |= i;
        this.TM.w(i, paramInt);
      }
      return;
      j = 0;
    }
  }
  
  private void bc(int paramInt)
  {
    if ((this.TA == null) || (!bd(paramInt))) {
      return;
    }
    this.TA[paramInt] = 0.0F;
    this.TB[paramInt] = 0.0F;
    this.TC[paramInt] = 0.0F;
    this.TD[paramInt] = 0.0F;
    this.TE[paramInt] = 0;
    this.TF[paramInt] = 0;
    this.TG[paramInt] = 0;
    this.TH &= (1 << paramInt ^ 0xFFFFFFFF);
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
        if (this.TM.x(paramView) > 0)
        {
          i = 1;
          if (this.TM.bH() <= 0) {
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
    paramInt3 = i(paramInt3, (int)this.TJ, (int)this.TI);
    paramInt4 = i(paramInt4, (int)this.TJ, (int)this.TI);
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
      paramInt1 = h(paramInt1, paramInt3, this.TM.x(paramView));
      paramInt2 = h(paramInt2, paramInt4, this.TM.bH());
      float f3 = paramInt1;
      return (int)(f2 * paramInt2 + f1 * f3);
      f1 = i / i1;
      break;
    }
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
        this.TC[k] = f1;
        this.TD[k] = f2;
      }
      i += 1;
    }
  }
  
  private void fI()
  {
    if (this.TA == null) {
      return;
    }
    Arrays.fill(this.TA, 0.0F);
    Arrays.fill(this.TB, 0.0F);
    Arrays.fill(this.TC, 0.0F);
    Arrays.fill(this.TD, 0.0F);
    Arrays.fill(this.TE, 0);
    Arrays.fill(this.TF, 0);
    Arrays.fill(this.TG, 0);
    this.TH = 0;
  }
  
  private void fJ()
  {
    this.mVelocityTracker.computeCurrentVelocity(1000, this.TI);
    l(g(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.TJ, this.TI), g(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.TJ, this.TI));
  }
  
  private static float g(float paramFloat1, float paramFloat2, float paramFloat3)
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
  
  private int h(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0) {
      return 0;
    }
    int i = this.TP.getWidth();
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
    int i = this.TN.getLeft();
    int j = this.TN.getTop();
    paramInt1 -= i;
    paramInt2 -= j;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.RH.abortAnimation();
      be(0);
      return false;
    }
    paramInt3 = e(this.TN, paramInt1, paramInt2, paramInt3, paramInt4);
    this.RH.startScroll(i, j, paramInt1, paramInt2, paramInt3);
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
    int k = this.TN.getLeft();
    int j = this.TN.getTop();
    int i = paramInt1;
    if (paramInt3 != 0)
    {
      i = this.TM.e(this.TN, paramInt1);
      android.support.v4.view.t.u(this.TN, i - k);
    }
    paramInt1 = paramInt2;
    if (paramInt4 != 0)
    {
      paramInt1 = this.TM.d(this.TN, paramInt2);
      android.support.v4.view.t.s(this.TN, paramInt1 - j);
    }
    if ((paramInt3 != 0) || (paramInt4 != 0)) {
      this.TM.b(this.TN, i, paramInt1);
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
    this.TO = true;
    this.TM.a(this.TN, paramFloat1, paramFloat2);
    this.TO = false;
    if (this.Tz == 1) {
      be(0);
    }
  }
  
  private boolean z(View paramView, int paramInt)
  {
    if ((paramView == this.TN) && (this.mActivePointerId == paramInt)) {
      return true;
    }
    if ((paramView != null) && (this.TM.c(paramView, paramInt)))
    {
      this.mActivePointerId = paramInt;
      y(paramView, paramInt);
      return true;
    }
    return false;
  }
  
  public final boolean A(int paramInt1, int paramInt2)
  {
    if (!this.TO) {
      throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }
    return h(paramInt1, paramInt2, (int)this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int)this.mVelocityTracker.getYVelocity(this.mActivePointerId));
  }
  
  public final View C(int paramInt1, int paramInt2)
  {
    int i = this.TP.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.TP.getChildAt(i);
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
    if (this.Tz == 2)
    {
      this.RH.getCurrX();
      this.RH.getCurrY();
      this.RH.abortAnimation();
      int i = this.RH.getCurrX();
      int j = this.RH.getCurrY();
      this.TM.b(this.TN, i, j);
    }
    be(0);
  }
  
  public final boolean bd(int paramInt)
  {
    return (this.TH & 1 << paramInt) != 0;
  }
  
  final void be(int paramInt)
  {
    this.TP.removeCallbacks(this.TQ);
    if (this.Tz != paramInt)
    {
      this.Tz = paramInt;
      this.TM.M(paramInt);
      if (this.Tz == 0) {
        this.TN = null;
      }
    }
  }
  
  public final void cancel()
  {
    this.mActivePointerId = -1;
    fI();
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  public final boolean fH()
  {
    boolean bool2 = false;
    if (this.Tz == 2)
    {
      boolean bool3 = this.RH.computeScrollOffset();
      int i = this.RH.getCurrX();
      int j = this.RH.getCurrY();
      int k = i - this.TN.getLeft();
      int m = j - this.TN.getTop();
      if (k != 0) {
        android.support.v4.view.t.u(this.TN, k);
      }
      if (m != 0) {
        android.support.v4.view.t.s(this.TN, m);
      }
      if ((k != 0) || (m != 0)) {
        this.TM.b(this.TN, i, j);
      }
      bool1 = bool3;
      if (bool3)
      {
        bool1 = bool3;
        if (i == this.RH.getFinalX())
        {
          bool1 = bool3;
          if (j == this.RH.getFinalY())
          {
            this.RH.abortAnimation();
            bool1 = false;
          }
        }
      }
      if (!bool1) {
        this.TP.post(this.TQ);
      }
    }
    boolean bool1 = bool2;
    if (this.Tz == 2) {
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
    while (this.Tz == 1)
    {
      return true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      i = paramMotionEvent.getPointerId(0);
      a(f1, f2, i);
      paramMotionEvent = C((int)f1, (int)f2);
      if ((paramMotionEvent == this.TN) && (this.Tz == 2)) {
        z(paramMotionEvent, i);
      }
      if ((this.TE[i] & this.TL) != 0)
      {
        this.TM.ft();
        continue;
        j = paramMotionEvent.getPointerId(i);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        a(f1, f2, j);
        if (this.Tz == 0)
        {
          if ((this.TE[j] & this.TL) != 0) {
            this.TM.ft();
          }
        }
        else if (this.Tz == 2)
        {
          paramMotionEvent = C((int)f1, (int)f2);
          if (paramMotionEvent == this.TN)
          {
            z(paramMotionEvent, j);
            continue;
            if ((this.TA != null) && (this.TB != null))
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
                  f3 = f1 - this.TA[m];
                  f4 = f2 - this.TB[m];
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
                    i1 = this.TM.e(localView, i1 + n);
                    int i2 = localView.getTop();
                    int i3 = (int)f4;
                    i3 = this.TM.d(localView, i3 + i2);
                    int i4 = this.TM.x(localView);
                    int i5 = this.TM.bH();
                    if (((i4 == 0) || ((i4 > 0) && (i1 == n))) && ((i5 == 0) || ((i5 > 0) && (i3 == i2)))) {
                      break label557;
                    }
                  }
                  b(f3, f4, m);
                  if ((this.Tz == 1) || ((j != 0) && (z(localView, m)))) {
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
            } while ((this.TE[i] & this.TL) == 0);
            this.TM.ft();
            return;
            i = paramMotionEvent.getPointerId(k);
            f1 = paramMotionEvent.getX(k);
            f2 = paramMotionEvent.getY(k);
            a(f1, f2, i);
            if (this.Tz != 0) {
              break;
            }
            z(C((int)f1, (int)f2), i);
          } while ((this.TE[i] & this.TL) == 0);
          this.TM.ft();
          return;
        } while (!B((int)f1, (int)f2));
        z(this.TN, i);
        return;
        if (this.Tz != 1) {
          break;
        }
      } while (!bf(this.mActivePointerId));
      i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      f1 = paramMotionEvent.getX(i);
      f2 = paramMotionEvent.getY(i);
      i = (int)(f1 - this.TC[this.mActivePointerId]);
      j = (int)(f2 - this.TD[this.mActivePointerId]);
      i(this.TN.getLeft() + i, this.TN.getTop() + j, i, j);
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
          float f3 = f1 - this.TA[j];
          float f4 = f2 - this.TB[j];
          b(f3, f4, j);
          if (this.Tz == 1) {
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
      if ((this.Tz == 1) && (j == this.mActivePointerId))
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
        if ((C((int)f1, (int)f2) != this.TN) || (!z(this.TN, m))) {
          break label618;
        }
      }
      break;
    }
    label663:
    for (i = this.mActivePointerId;; i = -1)
    {
      if (i == -1) {
        fJ();
      }
      bc(j);
      return;
      label618:
      i += 1;
      break;
      if (this.Tz == 1) {
        fJ();
      }
      cancel();
      return;
      if (this.Tz == 1) {
        l(0.0F, 0.0F);
      }
      cancel();
      return;
    }
  }
  
  public final boolean h(View paramView, int paramInt1, int paramInt2)
  {
    this.TN = paramView;
    this.mActivePointerId = -1;
    boolean bool = h(paramInt1, paramInt2, 0, 0);
    if ((!bool) && (this.Tz == 0) && (this.TN != null)) {
      this.TN = null;
    }
    return bool;
  }
  
  public final void y(View paramView, int paramInt)
  {
    if (paramView.getParent() != this.TP) {
      throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.TP + ")");
    }
    this.TN = paramView;
    this.mActivePointerId = paramInt;
    this.TM.l(paramView, paramInt);
    be(1);
  }
  
  public static abstract class a
  {
    public void M(int paramInt) {}
    
    public void a(View paramView, float paramFloat1, float paramFloat2) {}
    
    public void b(View paramView, int paramInt1, int paramInt2) {}
    
    public int bH()
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
    
    public void ft() {}
    
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