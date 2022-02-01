package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.u;
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
  private OverScroller UD;
  float[] WA;
  float[] WB;
  private int[] WC;
  private int[] WD;
  private int[] WE;
  private int WF;
  private float WG;
  float WH;
  int WI;
  int WJ;
  private final a WK;
  View WL;
  private boolean WM;
  private final ViewGroup WN;
  private final Runnable WO = new Runnable()
  {
    public final void run()
    {
      t.this.bf(0);
    }
  };
  int Wx;
  float[] Wy;
  float[] Wz;
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
    this.WN = paramViewGroup;
    this.WK = parama;
    paramViewGroup = ViewConfiguration.get(paramContext);
    this.WI = ((int)(paramContext.getResources().getDisplayMetrics().density * 20.0F + 0.5F));
    this.mTouchSlop = paramViewGroup.getScaledTouchSlop();
    this.WG = paramViewGroup.getScaledMaximumFlingVelocity();
    this.WH = paramViewGroup.getScaledMinimumFlingVelocity();
    this.UD = new OverScroller(paramContext, sInterpolator);
  }
  
  private boolean I(int paramInt1, int paramInt2)
  {
    return i(this.WL, paramInt1, paramInt2);
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
    if ((this.Wy == null) || (this.Wy.length <= paramInt))
    {
      localObject = new float[paramInt + 1];
      float[] arrayOfFloat1 = new float[paramInt + 1];
      float[] arrayOfFloat2 = new float[paramInt + 1];
      float[] arrayOfFloat3 = new float[paramInt + 1];
      int[] arrayOfInt1 = new int[paramInt + 1];
      int[] arrayOfInt2 = new int[paramInt + 1];
      int[] arrayOfInt3 = new int[paramInt + 1];
      if (this.Wy != null)
      {
        System.arraycopy(this.Wy, 0, localObject, 0, this.Wy.length);
        System.arraycopy(this.Wz, 0, arrayOfFloat1, 0, this.Wz.length);
        System.arraycopy(this.WA, 0, arrayOfFloat2, 0, this.WA.length);
        System.arraycopy(this.WB, 0, arrayOfFloat3, 0, this.WB.length);
        System.arraycopy(this.WC, 0, arrayOfInt1, 0, this.WC.length);
        System.arraycopy(this.WD, 0, arrayOfInt2, 0, this.WD.length);
        System.arraycopy(this.WE, 0, arrayOfInt3, 0, this.WE.length);
      }
      this.Wy = ((float[])localObject);
      this.Wz = arrayOfFloat1;
      this.WA = arrayOfFloat2;
      this.WB = arrayOfFloat3;
      this.WC = arrayOfInt1;
      this.WD = arrayOfInt2;
      this.WE = arrayOfInt3;
    }
    Object localObject = this.Wy;
    this.WA[paramInt] = paramFloat1;
    localObject[paramInt] = paramFloat1;
    localObject = this.Wz;
    this.WB[paramInt] = paramFloat2;
    localObject[paramInt] = paramFloat2;
    localObject = this.WC;
    int m = (int)paramFloat1;
    int k = (int)paramFloat2;
    if (m < this.WN.getLeft() + this.WI) {
      j = 1;
    }
    int i = j;
    if (k < this.WN.getTop() + this.WI) {
      i = j | 0x4;
    }
    j = i;
    if (m > this.WN.getRight() - this.WI) {
      j = i | 0x2;
    }
    i = j;
    if (k > this.WN.getBottom() - this.WI) {
      i = j | 0x8;
    }
    localObject[paramInt] = i;
    this.WF |= 1 << paramInt;
  }
  
  private boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    if (((this.WC[paramInt1] & paramInt2) != paramInt2) || ((this.WJ & paramInt2) == 0) || ((this.WE[paramInt1] & paramInt2) == paramInt2) || ((this.WD[paramInt1] & paramInt2) == paramInt2) || ((paramFloat1 <= this.mTouchSlop) && (paramFloat2 <= this.mTouchSlop))) {}
    while (((this.WD[paramInt1] & paramInt2) != 0) || (paramFloat1 <= this.mTouchSlop)) {
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
        int[] arrayOfInt = this.WD;
        arrayOfInt[paramInt] |= i;
        this.WK.D(i, paramInt);
      }
      return;
      j = 0;
    }
  }
  
  private void bd(int paramInt)
  {
    if ((this.Wy == null) || (!be(paramInt))) {
      return;
    }
    this.Wy[paramInt] = 0.0F;
    this.Wz[paramInt] = 0.0F;
    this.WA[paramInt] = 0.0F;
    this.WB[paramInt] = 0.0F;
    this.WC[paramInt] = 0;
    this.WD[paramInt] = 0;
    this.WE[paramInt] = 0;
    this.WF &= (1 << paramInt ^ 0xFFFFFFFF);
  }
  
  private boolean bg(int paramInt)
  {
    if (!be(paramInt))
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
        if (this.WK.y(paramView) > 0)
        {
          i = 1;
          if (this.WK.cg() <= 0) {
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
    paramInt3 = i(paramInt3, (int)this.WH, (int)this.WG);
    paramInt4 = i(paramInt4, (int)this.WH, (int)this.WG);
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
      paramInt1 = h(paramInt1, paramInt3, this.WK.y(paramView));
      paramInt2 = h(paramInt2, paramInt4, this.WK.cg());
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
  
  private void gp()
  {
    if (this.Wy == null) {
      return;
    }
    Arrays.fill(this.Wy, 0.0F);
    Arrays.fill(this.Wz, 0.0F);
    Arrays.fill(this.WA, 0.0F);
    Arrays.fill(this.WB, 0.0F);
    Arrays.fill(this.WC, 0);
    Arrays.fill(this.WD, 0);
    Arrays.fill(this.WE, 0);
    this.WF = 0;
  }
  
  private void gq()
  {
    this.mVelocityTracker.computeCurrentVelocity(1000, this.WG);
    l(f(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.WH, this.WG), f(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.WH, this.WG));
  }
  
  private int h(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0) {
      return 0;
    }
    int i = this.WN.getWidth();
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
    int i = this.WL.getLeft();
    int j = this.WL.getTop();
    paramInt1 -= i;
    paramInt2 -= j;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.UD.abortAnimation();
      bf(0);
      return false;
    }
    paramInt3 = e(this.WL, paramInt1, paramInt2, paramInt3, paramInt4);
    this.UD.startScroll(i, j, paramInt1, paramInt2, paramInt3);
    bf(2);
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
    int k = this.WL.getLeft();
    int j = this.WL.getTop();
    int i = paramInt1;
    if (paramInt3 != 0)
    {
      i = this.WK.e(this.WL, paramInt1);
      u.u(this.WL, i - k);
    }
    paramInt1 = paramInt2;
    if (paramInt4 != 0)
    {
      paramInt1 = this.WK.d(this.WL, paramInt2);
      u.s(this.WL, paramInt1 - j);
    }
    if ((paramInt3 != 0) || (paramInt4 != 0)) {
      this.WK.b(this.WL, i, paramInt1);
    }
  }
  
  private void i(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getPointerCount();
    int i = 0;
    while (i < j)
    {
      int k = paramMotionEvent.getPointerId(i);
      if (bg(k))
      {
        float f1 = paramMotionEvent.getX(i);
        float f2 = paramMotionEvent.getY(i);
        this.WA[k] = f1;
        this.WB[k] = f2;
      }
      i += 1;
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
    this.WM = true;
    this.WK.a(this.WL, paramFloat1, paramFloat2);
    this.WM = false;
    if (this.Wx == 1) {
      bf(0);
    }
  }
  
  private boolean z(View paramView, int paramInt)
  {
    if ((paramView == this.WL) && (this.mActivePointerId == paramInt)) {
      return true;
    }
    if ((paramView != null) && (this.WK.c(paramView, paramInt)))
    {
      this.mActivePointerId = paramInt;
      y(paramView, paramInt);
      return true;
    }
    return false;
  }
  
  public final boolean H(int paramInt1, int paramInt2)
  {
    if (!this.WM) {
      throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }
    return h(paramInt1, paramInt2, (int)this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int)this.mVelocityTracker.getYVelocity(this.mActivePointerId));
  }
  
  public final View J(int paramInt1, int paramInt2)
  {
    int i = this.WN.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.WN.getChildAt(i);
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
    if (this.Wx == 2)
    {
      this.UD.getCurrX();
      this.UD.getCurrY();
      this.UD.abortAnimation();
      int i = this.UD.getCurrX();
      int j = this.UD.getCurrY();
      this.WK.b(this.WL, i, j);
    }
    bf(0);
  }
  
  public final boolean be(int paramInt)
  {
    return (this.WF & 1 << paramInt) != 0;
  }
  
  final void bf(int paramInt)
  {
    this.WN.removeCallbacks(this.WO);
    if (this.Wx != paramInt)
    {
      this.Wx = paramInt;
      this.WK.L(paramInt);
      if (this.Wx == 0) {
        this.WL = null;
      }
    }
  }
  
  public final void cancel()
  {
    this.mActivePointerId = -1;
    gp();
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  public final boolean go()
  {
    boolean bool2 = false;
    if (this.Wx == 2)
    {
      boolean bool3 = this.UD.computeScrollOffset();
      int i = this.UD.getCurrX();
      int j = this.UD.getCurrY();
      int k = i - this.WL.getLeft();
      int m = j - this.WL.getTop();
      if (k != 0) {
        u.u(this.WL, k);
      }
      if (m != 0) {
        u.s(this.WL, m);
      }
      if ((k != 0) || (m != 0)) {
        this.WK.b(this.WL, i, j);
      }
      bool1 = bool3;
      if (bool3)
      {
        bool1 = bool3;
        if (i == this.UD.getFinalX())
        {
          bool1 = bool3;
          if (j == this.UD.getFinalY())
          {
            this.UD.abortAnimation();
            bool1 = false;
          }
        }
      }
      if (!bool1) {
        this.WN.post(this.WO);
      }
    }
    boolean bool1 = bool2;
    if (this.Wx == 2) {
      bool1 = true;
    }
    return bool1;
  }
  
  public final boolean h(View paramView, int paramInt1, int paramInt2)
  {
    this.WL = paramView;
    this.mActivePointerId = -1;
    boolean bool = h(paramInt1, paramInt2, 0, 0);
    if ((!bool) && (this.Wx == 0) && (this.WL != null)) {
      this.WL = null;
    }
    return bool;
  }
  
  public final boolean j(MotionEvent paramMotionEvent)
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
    while (this.Wx == 1)
    {
      return true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      i = paramMotionEvent.getPointerId(0);
      a(f1, f2, i);
      paramMotionEvent = J((int)f1, (int)f2);
      if ((paramMotionEvent == this.WL) && (this.Wx == 2)) {
        z(paramMotionEvent, i);
      }
      if ((this.WC[i] & this.WJ) != 0)
      {
        this.WK.fZ();
        continue;
        j = paramMotionEvent.getPointerId(i);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        a(f1, f2, j);
        if (this.Wx == 0)
        {
          if ((this.WC[j] & this.WJ) != 0) {
            this.WK.fZ();
          }
        }
        else if (this.Wx == 2)
        {
          paramMotionEvent = J((int)f1, (int)f2);
          if (paramMotionEvent == this.WL)
          {
            z(paramMotionEvent, j);
            continue;
            if ((this.Wy != null) && (this.Wz != null))
            {
              int k = paramMotionEvent.getPointerCount();
              i = 0;
              if (i < k)
              {
                int m = paramMotionEvent.getPointerId(i);
                float f3;
                float f4;
                View localView;
                if (bg(m))
                {
                  f1 = paramMotionEvent.getX(i);
                  f2 = paramMotionEvent.getY(i);
                  f3 = f1 - this.Wy[m];
                  f4 = f2 - this.Wz[m];
                  localView = J((int)f1, (int)f2);
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
                    i1 = this.WK.e(localView, i1 + n);
                    int i2 = localView.getTop();
                    int i3 = (int)f4;
                    i3 = this.WK.d(localView, i3 + i2);
                    int i4 = this.WK.y(localView);
                    int i5 = this.WK.cg();
                    if (((i4 == 0) || ((i4 > 0) && (i1 == n))) && ((i5 == 0) || ((i5 > 0) && (i3 == i2)))) {
                      break label557;
                    }
                  }
                  b(f3, f4, m);
                  if ((this.Wx == 1) || ((j != 0) && (z(localView, m)))) {
                    break label557;
                  }
                  i += 1;
                  break;
                }
              }
              label557:
              i(paramMotionEvent);
              continue;
              bd(paramMotionEvent.getPointerId(i));
              continue;
              cancel();
            }
          }
        }
      }
    }
    return false;
  }
  
  public final void k(MotionEvent paramMotionEvent)
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
              paramMotionEvent = J((int)f1, (int)f2);
              a(f1, f2, i);
              z(paramMotionEvent, i);
            } while ((this.WC[i] & this.WJ) == 0);
            this.WK.fZ();
            return;
            i = paramMotionEvent.getPointerId(k);
            f1 = paramMotionEvent.getX(k);
            f2 = paramMotionEvent.getY(k);
            a(f1, f2, i);
            if (this.Wx != 0) {
              break;
            }
            z(J((int)f1, (int)f2), i);
          } while ((this.WC[i] & this.WJ) == 0);
          this.WK.fZ();
          return;
        } while (!I((int)f1, (int)f2));
        z(this.WL, i);
        return;
        if (this.Wx != 1) {
          break;
        }
      } while (!bg(this.mActivePointerId));
      i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      f1 = paramMotionEvent.getX(i);
      f2 = paramMotionEvent.getY(i);
      i = (int)(f1 - this.WA[this.mActivePointerId]);
      j = (int)(f2 - this.WB[this.mActivePointerId]);
      i(this.WL.getLeft() + i, this.WL.getTop() + j, i, j);
      i(paramMotionEvent);
      return;
      k = paramMotionEvent.getPointerCount();
      i = j;
      while (i < k)
      {
        j = paramMotionEvent.getPointerId(i);
        if (bg(j))
        {
          f1 = paramMotionEvent.getX(i);
          f2 = paramMotionEvent.getY(i);
          float f3 = f1 - this.Wy[j];
          float f4 = f2 - this.Wz[j];
          b(f3, f4, j);
          if (this.Wx == 1) {
            break;
          }
          View localView = J((int)f1, (int)f2);
          if ((c(localView, f3, f4)) && (z(localView, j))) {
            break;
          }
        }
        i += 1;
      }
      i(paramMotionEvent);
      return;
    case 6: 
      j = paramMotionEvent.getPointerId(k);
      if ((this.Wx == 1) && (j == this.mActivePointerId))
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
        if ((J((int)f1, (int)f2) != this.WL) || (!z(this.WL, m))) {
          break label618;
        }
      }
      break;
    }
    label663:
    for (i = this.mActivePointerId;; i = -1)
    {
      if (i == -1) {
        gq();
      }
      bd(j);
      return;
      label618:
      i += 1;
      break;
      if (this.Wx == 1) {
        gq();
      }
      cancel();
      return;
      if (this.Wx == 1) {
        l(0.0F, 0.0F);
      }
      cancel();
      return;
    }
  }
  
  public final void y(View paramView, int paramInt)
  {
    if (paramView.getParent() != this.WN) {
      throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.WN + ")");
    }
    this.WL = paramView;
    this.mActivePointerId = paramInt;
    this.WK.l(paramView, paramInt);
    bf(1);
  }
  
  public static abstract class a
  {
    public void D(int paramInt1, int paramInt2) {}
    
    public void L(int paramInt) {}
    
    public void a(View paramView, float paramFloat1, float paramFloat2) {}
    
    public void b(View paramView, int paramInt1, int paramInt2) {}
    
    public abstract boolean c(View paramView, int paramInt);
    
    public int cg()
    {
      return 0;
    }
    
    public int d(View paramView, int paramInt)
    {
      return 0;
    }
    
    public int e(View paramView, int paramInt)
    {
      return 0;
    }
    
    public void fZ() {}
    
    public void l(View paramView, int paramInt) {}
    
    public int y(View paramView)
    {
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.widget.t
 * JD-Core Version:    0.7.0.1
 */