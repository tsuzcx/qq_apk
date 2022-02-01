package androidx.customview.a;

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
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class c
{
  private static final Interpolator sInterpolator;
  private OverScroller Qi;
  public int Rh;
  public float[] Ri;
  public float[] Rj;
  public float[] Rk;
  public float[] Rl;
  private int[] Rm;
  private int[] Rn;
  private int[] Ro;
  private int Rp;
  private float Rq;
  public float Rr;
  public int Rs;
  public int Rt;
  private final a Ru;
  public View Rv;
  private boolean Rw;
  private final ViewGroup Rx;
  private final Runnable Ry;
  private int mActivePointerId;
  public int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  
  static
  {
    AppMethodBeat.i(197857);
    sInterpolator = new Interpolator()
    {
      public final float getInterpolation(float paramAnonymousFloat)
      {
        paramAnonymousFloat -= 1.0F;
        return paramAnonymousFloat * (paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat) + 1.0F;
      }
    };
    AppMethodBeat.o(197857);
  }
  
  private c(Context paramContext, ViewGroup paramViewGroup, a parama)
  {
    AppMethodBeat.i(197772);
    this.mActivePointerId = -1;
    this.Ry = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197764);
        c.this.bR(0);
        AppMethodBeat.o(197764);
      }
    };
    if (paramViewGroup == null)
    {
      paramContext = new IllegalArgumentException("Parent view may not be null");
      AppMethodBeat.o(197772);
      throw paramContext;
    }
    if (parama == null)
    {
      paramContext = new IllegalArgumentException("Callback may not be null");
      AppMethodBeat.o(197772);
      throw paramContext;
    }
    this.Rx = paramViewGroup;
    this.Ru = parama;
    paramViewGroup = ViewConfiguration.get(paramContext);
    this.Rs = ((int)(paramContext.getResources().getDisplayMetrics().density * 20.0F + 0.5F));
    this.mTouchSlop = paramViewGroup.getScaledTouchSlop();
    this.Rq = paramViewGroup.getScaledMaximumFlingVelocity();
    this.Rr = paramViewGroup.getScaledMinimumFlingVelocity();
    this.Qi = new OverScroller(paramContext, sInterpolator);
    AppMethodBeat.o(197772);
  }
  
  private boolean J(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(197851);
    boolean bool = g(this.Rv, paramInt1, paramInt2);
    AppMethodBeat.o(197851);
    return bool;
  }
  
  public static c a(ViewGroup paramViewGroup, float paramFloat, a parama)
  {
    AppMethodBeat.i(197770);
    paramViewGroup = a(paramViewGroup, parama);
    paramViewGroup.mTouchSlop = ((int)(paramViewGroup.mTouchSlop * (1.0F / paramFloat)));
    AppMethodBeat.o(197770);
    return paramViewGroup;
  }
  
  public static c a(ViewGroup paramViewGroup, a parama)
  {
    AppMethodBeat.i(197768);
    paramViewGroup = new c(paramViewGroup.getContext(), paramViewGroup, parama);
    AppMethodBeat.o(197768);
    return paramViewGroup;
  }
  
  private void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(197814);
    if ((this.Ri == null) || (this.Ri.length <= paramInt))
    {
      localObject = new float[paramInt + 1];
      float[] arrayOfFloat1 = new float[paramInt + 1];
      float[] arrayOfFloat2 = new float[paramInt + 1];
      float[] arrayOfFloat3 = new float[paramInt + 1];
      int[] arrayOfInt1 = new int[paramInt + 1];
      int[] arrayOfInt2 = new int[paramInt + 1];
      int[] arrayOfInt3 = new int[paramInt + 1];
      if (this.Ri != null)
      {
        System.arraycopy(this.Ri, 0, localObject, 0, this.Ri.length);
        System.arraycopy(this.Rj, 0, arrayOfFloat1, 0, this.Rj.length);
        System.arraycopy(this.Rk, 0, arrayOfFloat2, 0, this.Rk.length);
        System.arraycopy(this.Rl, 0, arrayOfFloat3, 0, this.Rl.length);
        System.arraycopy(this.Rm, 0, arrayOfInt1, 0, this.Rm.length);
        System.arraycopy(this.Rn, 0, arrayOfInt2, 0, this.Rn.length);
        System.arraycopy(this.Ro, 0, arrayOfInt3, 0, this.Ro.length);
      }
      this.Ri = ((float[])localObject);
      this.Rj = arrayOfFloat1;
      this.Rk = arrayOfFloat2;
      this.Rl = arrayOfFloat3;
      this.Rm = arrayOfInt1;
      this.Rn = arrayOfInt2;
      this.Ro = arrayOfInt3;
    }
    Object localObject = this.Ri;
    this.Rk[paramInt] = paramFloat1;
    localObject[paramInt] = paramFloat1;
    localObject = this.Rj;
    this.Rl[paramInt] = paramFloat2;
    localObject[paramInt] = paramFloat2;
    localObject = this.Rm;
    int m = (int)paramFloat1;
    int k = (int)paramFloat2;
    if (m < this.Rx.getLeft() + this.Rs) {
      j = 1;
    }
    int i = j;
    if (k < this.Rx.getTop() + this.Rs) {
      i = j | 0x4;
    }
    j = i;
    if (m > this.Rx.getRight() - this.Rs) {
      j = i | 0x2;
    }
    i = j;
    if (k > this.Rx.getBottom() - this.Rs) {
      i = j | 0x8;
    }
    localObject[paramInt] = i;
    this.Rp |= 1 << paramInt;
    AppMethodBeat.o(197814);
  }
  
  private boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(197839);
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    if (((this.Rm[paramInt1] & paramInt2) != paramInt2) || ((this.Rt & paramInt2) == 0) || ((this.Ro[paramInt1] & paramInt2) == paramInt2) || ((this.Rn[paramInt1] & paramInt2) == paramInt2) || ((paramFloat1 <= this.mTouchSlop) && (paramFloat2 <= this.mTouchSlop)))
    {
      AppMethodBeat.o(197839);
      return false;
    }
    if (((this.Rn[paramInt1] & paramInt2) == 0) && (paramFloat1 > this.mTouchSlop))
    {
      AppMethodBeat.o(197839);
      return true;
    }
    AppMethodBeat.o(197839);
    return false;
  }
  
  private void b(float paramFloat1, float paramFloat2, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(197834);
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
        int[] arrayOfInt = this.Rn;
        arrayOfInt[paramInt] |= i;
        this.Ru.L(i, paramInt);
      }
      AppMethodBeat.o(197834);
      return;
      j = 0;
    }
  }
  
  private boolean b(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(197841);
    if (paramView == null)
    {
      AppMethodBeat.o(197841);
      return false;
    }
    int i;
    int j;
    if (this.Ru.aC(paramView) > 0)
    {
      i = 1;
      if (this.Ru.U() <= 0) {
        break label87;
      }
      j = 1;
    }
    for (;;)
    {
      if ((i != 0) && (j != 0))
      {
        if (paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 > this.mTouchSlop * this.mTouchSlop)
        {
          AppMethodBeat.o(197841);
          return true;
          i = 0;
          break;
          label87:
          j = 0;
          continue;
        }
        AppMethodBeat.o(197841);
        return false;
      }
    }
    if (i != 0)
    {
      if (Math.abs(paramFloat1) > this.mTouchSlop)
      {
        AppMethodBeat.o(197841);
        return true;
      }
      AppMethodBeat.o(197841);
      return false;
    }
    if (j != 0)
    {
      if (Math.abs(paramFloat2) > this.mTouchSlop)
      {
        AppMethodBeat.o(197841);
        return true;
      }
      AppMethodBeat.o(197841);
      return false;
    }
    AppMethodBeat.o(197841);
    return false;
  }
  
  private void bP(int paramInt)
  {
    AppMethodBeat.i(197802);
    if ((this.Ri == null) || (!bQ(paramInt)))
    {
      AppMethodBeat.o(197802);
      return;
    }
    this.Ri[paramInt] = 0.0F;
    this.Rj[paramInt] = 0.0F;
    this.Rk[paramInt] = 0.0F;
    this.Rl[paramInt] = 0.0F;
    this.Rm[paramInt] = 0;
    this.Rn[paramInt] = 0;
    this.Ro[paramInt] = 0;
    this.Rp &= (1 << paramInt ^ 0xFFFFFFFF);
    AppMethodBeat.o(197802);
  }
  
  private boolean bS(int paramInt)
  {
    AppMethodBeat.i(197856);
    if (!bQ(paramInt))
    {
      new StringBuilder("Ignoring pointerId=").append(paramInt).append(" because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
      AppMethodBeat.o(197856);
      return false;
    }
    AppMethodBeat.o(197856);
    return true;
  }
  
  private static float distanceInfluenceForSnapDuration(float paramFloat)
  {
    AppMethodBeat.i(197791);
    paramFloat = (float)Math.sin((paramFloat - 0.5F) * 0.4712389F);
    AppMethodBeat.o(197791);
    return paramFloat;
  }
  
  private static float e(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(197790);
    float f = Math.abs(paramFloat1);
    if (f < paramFloat2)
    {
      AppMethodBeat.o(197790);
      return 0.0F;
    }
    if (f > paramFloat3)
    {
      if (paramFloat1 > 0.0F)
      {
        AppMethodBeat.o(197790);
        return paramFloat3;
      }
      paramFloat1 = -paramFloat3;
      AppMethodBeat.o(197790);
      return paramFloat1;
    }
    AppMethodBeat.o(197790);
    return paramFloat1;
  }
  
  private int e(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(197787);
    if (paramInt1 == 0)
    {
      AppMethodBeat.o(197787);
      return 0;
    }
    int i = this.Rx.getWidth();
    int j = i / 2;
    float f3 = Math.min(1.0F, Math.abs(paramInt1) / i);
    float f1 = j;
    float f2 = j;
    f3 = distanceInfluenceForSnapDuration(f3);
    paramInt2 = Math.abs(paramInt2);
    if (paramInt2 > 0) {}
    for (paramInt1 = Math.round(Math.abs((f3 * f2 + f1) / paramInt2) * 1000.0F) * 4;; paramInt1 = (int)((Math.abs(paramInt1) / paramInt3 + 1.0F) * 256.0F))
    {
      paramInt1 = Math.min(paramInt1, 600);
      AppMethodBeat.o(197787);
      return paramInt1;
    }
  }
  
  private void e(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(197800);
    this.Rw = true;
    this.Ru.a(this.Rv, paramFloat1, paramFloat2);
    this.Rw = false;
    if (this.Rh == 1) {
      bR(0);
    }
    AppMethodBeat.o(197800);
  }
  
  private static int f(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(197788);
    int i = Math.abs(paramInt1);
    if (i < paramInt2)
    {
      AppMethodBeat.o(197788);
      return 0;
    }
    if (i > paramInt3)
    {
      if (paramInt1 > 0)
      {
        AppMethodBeat.o(197788);
        return paramInt3;
      }
      paramInt1 = -paramInt3;
      AppMethodBeat.o(197788);
      return paramInt1;
    }
    AppMethodBeat.o(197788);
    return paramInt1;
  }
  
  public static boolean g(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(197852);
    if (paramView == null)
    {
      AppMethodBeat.o(197852);
      return false;
    }
    if ((paramInt1 >= paramView.getLeft()) && (paramInt1 < paramView.getRight()) && (paramInt2 >= paramView.getTop()) && (paramInt2 < paramView.getBottom()))
    {
      AppMethodBeat.o(197852);
      return true;
    }
    AppMethodBeat.o(197852);
    return false;
  }
  
  private int h(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(197786);
    paramInt3 = f(paramInt3, (int)this.Rr, (int)this.Rq);
    paramInt4 = f(paramInt4, (int)this.Rr, (int)this.Rq);
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
        break label176;
      }
    }
    label176:
    for (float f2 = m / n;; f2 = j / i1)
    {
      paramInt1 = e(paramInt1, paramInt3, this.Ru.aC(paramView));
      paramInt2 = e(paramInt2, paramInt4, this.Ru.U());
      float f3 = paramInt1;
      paramInt1 = (int)(f2 * paramInt2 + f1 * f3);
      AppMethodBeat.o(197786);
      return paramInt1;
      f1 = i / i1;
      break;
    }
  }
  
  private void h(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(197815);
    int j = paramMotionEvent.getPointerCount();
    int i = 0;
    while (i < j)
    {
      int k = paramMotionEvent.getPointerId(i);
      if (bS(k))
      {
        float f1 = paramMotionEvent.getX(i);
        float f2 = paramMotionEvent.getY(i);
        this.Rk[k] = f1;
        this.Rl[k] = f2;
      }
      i += 1;
    }
    AppMethodBeat.o(197815);
  }
  
  private boolean h(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(197782);
    int i = this.Rv.getLeft();
    int j = this.Rv.getTop();
    paramInt1 -= i;
    paramInt2 -= j;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.Qi.abortAnimation();
      bR(0);
      AppMethodBeat.o(197782);
      return false;
    }
    paramInt3 = h(this.Rv, paramInt1, paramInt2, paramInt3, paramInt4);
    this.Qi.startScroll(i, j, paramInt1, paramInt2, paramInt3);
    bR(2);
    AppMethodBeat.o(197782);
    return true;
  }
  
  private void hN()
  {
    AppMethodBeat.i(197845);
    this.mVelocityTracker.computeCurrentVelocity(1000, this.Rq);
    e(e(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.Rr, this.Rq), e(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.Rr, this.Rq));
    AppMethodBeat.o(197845);
  }
  
  private void i(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(197850);
    int k = this.Rv.getLeft();
    int j = this.Rv.getTop();
    int i = paramInt1;
    if (paramInt3 != 0)
    {
      i = this.Ru.d(this.Rv, paramInt1);
      w.u(this.Rv, i - k);
    }
    paramInt1 = paramInt2;
    if (paramInt4 != 0)
    {
      paramInt1 = this.Ru.c(this.Rv, paramInt2);
      w.s(this.Rv, paramInt1 - j);
    }
    if ((paramInt3 != 0) || (paramInt4 != 0)) {
      this.Ru.a(this.Rv, i, paramInt1);
    }
    AppMethodBeat.o(197850);
  }
  
  private boolean y(View paramView, int paramInt)
  {
    AppMethodBeat.i(197822);
    if ((paramView == this.Rv) && (this.mActivePointerId == paramInt))
    {
      AppMethodBeat.o(197822);
      return true;
    }
    if ((paramView != null) && (this.Ru.b(paramView, paramInt)))
    {
      this.mActivePointerId = paramInt;
      x(paramView, paramInt);
      AppMethodBeat.o(197822);
      return true;
    }
    AppMethodBeat.o(197822);
    return false;
  }
  
  public final boolean I(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(197780);
    if (!this.Rw)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
      AppMethodBeat.o(197780);
      throw localIllegalStateException;
    }
    boolean bool = h(paramInt1, paramInt2, (int)this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int)this.mVelocityTracker.getYVelocity(this.mActivePointerId));
    AppMethodBeat.o(197780);
    return bool;
  }
  
  public final View K(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(197854);
    int i = this.Rx.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.Rx.getChildAt(i);
      if ((paramInt1 >= localView.getLeft()) && (paramInt1 < localView.getRight()) && (paramInt2 >= localView.getTop()) && (paramInt2 < localView.getBottom()))
      {
        AppMethodBeat.o(197854);
        return localView;
      }
      i -= 1;
    }
    AppMethodBeat.o(197854);
    return null;
  }
  
  public final boolean bQ(int paramInt)
  {
    return (this.Rp & 1 << paramInt) != 0;
  }
  
  final void bR(int paramInt)
  {
    AppMethodBeat.i(197819);
    this.Rx.removeCallbacks(this.Ry);
    if (this.Rh != paramInt)
    {
      this.Rh = paramInt;
      this.Ru.G(paramInt);
      if (this.Rh == 0) {
        this.Rv = null;
      }
    }
    AppMethodBeat.o(197819);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(197774);
    this.mActivePointerId = -1;
    if (this.Ri != null)
    {
      Arrays.fill(this.Ri, 0.0F);
      Arrays.fill(this.Rj, 0.0F);
      Arrays.fill(this.Rk, 0.0F);
      Arrays.fill(this.Rl, 0.0F);
      Arrays.fill(this.Rm, 0);
      Arrays.fill(this.Rn, 0);
      Arrays.fill(this.Ro, 0);
      this.Rp = 0;
    }
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
    AppMethodBeat.o(197774);
  }
  
  public final boolean f(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(197777);
    this.Rv = paramView;
    this.mActivePointerId = -1;
    boolean bool = h(paramInt1, paramInt2, 0, 0);
    if ((!bool) && (this.Rh == 0) && (this.Rv != null)) {
      this.Rv = null;
    }
    AppMethodBeat.o(197777);
    return bool;
  }
  
  public final void hL()
  {
    AppMethodBeat.i(197776);
    cancel();
    if (this.Rh == 2)
    {
      this.Qi.getCurrX();
      this.Qi.getCurrY();
      this.Qi.abortAnimation();
      int i = this.Qi.getCurrX();
      int j = this.Qi.getCurrY();
      this.Ru.a(this.Rv, i, j);
    }
    bR(0);
    AppMethodBeat.o(197776);
  }
  
  public final boolean hM()
  {
    AppMethodBeat.i(197799);
    if (this.Rh == 2)
    {
      boolean bool2 = this.Qi.computeScrollOffset();
      int i = this.Qi.getCurrX();
      int j = this.Qi.getCurrY();
      int k = i - this.Rv.getLeft();
      int m = j - this.Rv.getTop();
      if (k != 0) {
        w.u(this.Rv, k);
      }
      if (m != 0) {
        w.s(this.Rv, m);
      }
      if ((k != 0) || (m != 0)) {
        this.Ru.a(this.Rv, i, j);
      }
      boolean bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (i == this.Qi.getFinalX())
        {
          bool1 = bool2;
          if (j == this.Qi.getFinalY())
          {
            this.Qi.abortAnimation();
            bool1 = false;
          }
        }
      }
      if (!bool1) {
        this.Rx.post(this.Ry);
      }
    }
    if (this.Rh == 2)
    {
      AppMethodBeat.o(197799);
      return true;
    }
    AppMethodBeat.o(197799);
    return false;
  }
  
  public final boolean i(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(197825);
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
    while (this.Rh == 1)
    {
      AppMethodBeat.o(197825);
      return true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      i = paramMotionEvent.getPointerId(0);
      a(f1, f2, i);
      paramMotionEvent = K((int)f1, (int)f2);
      if ((paramMotionEvent == this.Rv) && (this.Rh == 2)) {
        y(paramMotionEvent, i);
      }
      if ((this.Rm[i] & this.Rt) != 0)
      {
        this.Ru.hO();
        continue;
        j = paramMotionEvent.getPointerId(i);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        a(f1, f2, j);
        if (this.Rh == 0)
        {
          if ((this.Rm[j] & this.Rt) != 0) {
            this.Ru.hO();
          }
        }
        else if (this.Rh == 2)
        {
          paramMotionEvent = K((int)f1, (int)f2);
          if (paramMotionEvent == this.Rv)
          {
            y(paramMotionEvent, j);
            continue;
            if ((this.Ri != null) && (this.Rj != null))
            {
              int k = paramMotionEvent.getPointerCount();
              i = 0;
              if (i < k)
              {
                int m = paramMotionEvent.getPointerId(i);
                float f3;
                float f4;
                View localView;
                if (bS(m))
                {
                  f1 = paramMotionEvent.getX(i);
                  f2 = paramMotionEvent.getY(i);
                  f3 = f1 - this.Ri[m];
                  f4 = f2 - this.Rj[m];
                  localView = K((int)f1, (int)f2);
                  if ((localView == null) || (!b(localView, f3, f4))) {
                    break label561;
                  }
                }
                label561:
                for (j = 1;; j = 0)
                {
                  if (j != 0)
                  {
                    int n = localView.getLeft();
                    int i1 = (int)f3;
                    i1 = this.Ru.d(localView, i1 + n);
                    int i2 = localView.getTop();
                    int i3 = (int)f4;
                    i3 = this.Ru.c(localView, i3 + i2);
                    int i4 = this.Ru.aC(localView);
                    int i5 = this.Ru.U();
                    if (((i4 == 0) || ((i4 > 0) && (i1 == n))) && ((i5 == 0) || ((i5 > 0) && (i3 == i2)))) {
                      break label567;
                    }
                  }
                  b(f3, f4, m);
                  if ((this.Rh == 1) || ((j != 0) && (y(localView, m)))) {
                    break label567;
                  }
                  i += 1;
                  break;
                }
              }
              label567:
              h(paramMotionEvent);
              continue;
              bP(paramMotionEvent.getPointerId(i));
              continue;
              cancel();
            }
          }
        }
      }
    }
    AppMethodBeat.o(197825);
    return false;
  }
  
  public final void j(MotionEvent paramMotionEvent)
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(197829);
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
            AppMethodBeat.o(197829);
            return;
            f1 = paramMotionEvent.getX();
            f2 = paramMotionEvent.getY();
            i = paramMotionEvent.getPointerId(0);
            paramMotionEvent = K((int)f1, (int)f2);
            a(f1, f2, i);
            y(paramMotionEvent, i);
          } while ((this.Rm[i] & this.Rt) == 0);
          this.Ru.hO();
          AppMethodBeat.o(197829);
          return;
          i = paramMotionEvent.getPointerId(k);
          f1 = paramMotionEvent.getX(k);
          f2 = paramMotionEvent.getY(k);
          a(f1, f2, i);
          if (this.Rh == 0)
          {
            y(K((int)f1, (int)f2), i);
            if ((this.Rm[i] & this.Rt) != 0) {
              this.Ru.hO();
            }
            AppMethodBeat.o(197829);
            return;
          }
        } while (!J((int)f1, (int)f2));
        y(this.Rv, i);
        AppMethodBeat.o(197829);
        return;
        if (this.Rh != 1) {
          break;
        }
      } while (!bS(this.mActivePointerId));
      i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      f1 = paramMotionEvent.getX(i);
      f2 = paramMotionEvent.getY(i);
      i = (int)(f1 - this.Rk[this.mActivePointerId]);
      j = (int)(f2 - this.Rl[this.mActivePointerId]);
      i(this.Rv.getLeft() + i, this.Rv.getTop() + j, i, j);
      h(paramMotionEvent);
      AppMethodBeat.o(197829);
      return;
      k = paramMotionEvent.getPointerCount();
      i = j;
      while (i < k)
      {
        j = paramMotionEvent.getPointerId(i);
        if (bS(j))
        {
          f1 = paramMotionEvent.getX(i);
          f2 = paramMotionEvent.getY(i);
          float f3 = f1 - this.Ri[j];
          float f4 = f2 - this.Rj[j];
          b(f3, f4, j);
          if (this.Rh == 1) {
            break;
          }
          View localView = K((int)f1, (int)f2);
          if ((b(localView, f3, f4)) && (y(localView, j))) {
            break;
          }
        }
        i += 1;
      }
      h(paramMotionEvent);
      AppMethodBeat.o(197829);
      return;
    case 6: 
      j = paramMotionEvent.getPointerId(k);
      if ((this.Rh == 1) && (j == this.mActivePointerId))
      {
        k = paramMotionEvent.getPointerCount();
        label573:
        if (i >= k) {
          break label721;
        }
        m = paramMotionEvent.getPointerId(i);
        if (m == this.mActivePointerId) {
          break label668;
        }
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        if ((K((int)f1, (int)f2) != this.Rv) || (!y(this.Rv, m))) {
          break label668;
        }
      }
      break;
    }
    label668:
    label721:
    for (i = this.mActivePointerId;; i = -1)
    {
      if (i == -1) {
        hN();
      }
      bP(j);
      AppMethodBeat.o(197829);
      return;
      i += 1;
      break label573;
      if (this.Rh == 1) {
        hN();
      }
      cancel();
      AppMethodBeat.o(197829);
      return;
      if (this.Rh == 1) {
        e(0.0F, 0.0F);
      }
      cancel();
      break;
    }
  }
  
  public final void x(View paramView, int paramInt)
  {
    AppMethodBeat.i(197773);
    if (paramView.getParent() != this.Rx)
    {
      paramView = new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.Rx + ")");
      AppMethodBeat.o(197773);
      throw paramView;
    }
    this.Rv = paramView;
    this.mActivePointerId = paramInt;
    this.Ru.z(paramView, paramInt);
    bR(1);
    AppMethodBeat.o(197773);
  }
  
  public static abstract class a
  {
    public void G(int paramInt) {}
    
    public void L(int paramInt1, int paramInt2) {}
    
    public int U()
    {
      return 0;
    }
    
    public void a(View paramView, float paramFloat1, float paramFloat2) {}
    
    public void a(View paramView, int paramInt1, int paramInt2) {}
    
    public int aC(View paramView)
    {
      return 0;
    }
    
    public abstract boolean b(View paramView, int paramInt);
    
    public int c(View paramView, int paramInt)
    {
      return 0;
    }
    
    public int d(View paramView, int paramInt)
    {
      return 0;
    }
    
    public void hO() {}
    
    public void z(View paramView, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.customview.a.c
 * JD-Core Version:    0.7.0.1
 */