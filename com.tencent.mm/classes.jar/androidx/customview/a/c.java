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
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class c
{
  private static final Interpolator sInterpolator;
  private OverScroller bwz;
  public float[] bxA;
  public float[] bxB;
  public float[] bxC;
  private int[] bxD;
  private int[] bxE;
  private int[] bxF;
  private int bxG;
  private float bxH;
  public float bxI;
  public int bxJ;
  public int bxK;
  private final a bxL;
  public View bxM;
  private boolean bxN;
  private final ViewGroup bxO;
  private final Runnable bxP;
  public int bxy;
  public float[] bxz;
  private int mActivePointerId;
  public int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  
  static
  {
    AppMethodBeat.i(192675);
    sInterpolator = new c.1();
    AppMethodBeat.o(192675);
  }
  
  private c(Context paramContext, ViewGroup paramViewGroup, a parama)
  {
    AppMethodBeat.i(192459);
    this.mActivePointerId = -1;
    this.bxP = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(192461);
        c.this.eM(0);
        AppMethodBeat.o(192461);
      }
    };
    if (paramViewGroup == null)
    {
      paramContext = new IllegalArgumentException("Parent view may not be null");
      AppMethodBeat.o(192459);
      throw paramContext;
    }
    if (parama == null)
    {
      paramContext = new IllegalArgumentException("Callback may not be null");
      AppMethodBeat.o(192459);
      throw paramContext;
    }
    this.bxO = paramViewGroup;
    this.bxL = parama;
    paramViewGroup = ViewConfiguration.get(paramContext);
    this.bxJ = ((int)(paramContext.getResources().getDisplayMetrics().density * 20.0F + 0.5F));
    this.mTouchSlop = paramViewGroup.getScaledTouchSlop();
    this.bxH = paramViewGroup.getScaledMaximumFlingVelocity();
    this.bxI = paramViewGroup.getScaledMinimumFlingVelocity();
    this.bwz = new OverScroller(paramContext, sInterpolator);
    AppMethodBeat.o(192459);
  }
  
  private boolean C(View paramView, int paramInt)
  {
    AppMethodBeat.i(192589);
    if ((paramView == this.bxM) && (this.mActivePointerId == paramInt))
    {
      AppMethodBeat.o(192589);
      return true;
    }
    if ((paramView != null) && (this.bxL.b(paramView, paramInt)))
    {
      this.mActivePointerId = paramInt;
      B(paramView, paramInt);
      AppMethodBeat.o(192589);
      return true;
    }
    AppMethodBeat.o(192589);
    return false;
  }
  
  private void Fy()
  {
    AppMethodBeat.i(192618);
    this.mVelocityTracker.computeCurrentVelocity(1000, this.bxH);
    N(i(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.bxI, this.bxH), i(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.bxI, this.bxH));
    AppMethodBeat.o(192618);
  }
  
  private void N(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(192541);
    this.bxN = true;
    this.bxL.b(this.bxM, paramFloat1, paramFloat2);
    this.bxN = false;
    if (this.bxy == 1) {
      eM(0);
    }
    AppMethodBeat.o(192541);
  }
  
  public static c a(ViewGroup paramViewGroup, float paramFloat, a parama)
  {
    AppMethodBeat.i(192452);
    paramViewGroup = a(paramViewGroup, parama);
    paramViewGroup.mTouchSlop = ((int)(paramViewGroup.mTouchSlop * (1.0F / paramFloat)));
    AppMethodBeat.o(192452);
    return paramViewGroup;
  }
  
  public static c a(ViewGroup paramViewGroup, a parama)
  {
    AppMethodBeat.i(192442);
    paramViewGroup = new c(paramViewGroup.getContext(), paramViewGroup, parama);
    AppMethodBeat.o(192442);
    return paramViewGroup;
  }
  
  private void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(192570);
    if ((this.bxz == null) || (this.bxz.length <= paramInt))
    {
      localObject = new float[paramInt + 1];
      float[] arrayOfFloat1 = new float[paramInt + 1];
      float[] arrayOfFloat2 = new float[paramInt + 1];
      float[] arrayOfFloat3 = new float[paramInt + 1];
      int[] arrayOfInt1 = new int[paramInt + 1];
      int[] arrayOfInt2 = new int[paramInt + 1];
      int[] arrayOfInt3 = new int[paramInt + 1];
      if (this.bxz != null)
      {
        System.arraycopy(this.bxz, 0, localObject, 0, this.bxz.length);
        System.arraycopy(this.bxA, 0, arrayOfFloat1, 0, this.bxA.length);
        System.arraycopy(this.bxB, 0, arrayOfFloat2, 0, this.bxB.length);
        System.arraycopy(this.bxC, 0, arrayOfFloat3, 0, this.bxC.length);
        System.arraycopy(this.bxD, 0, arrayOfInt1, 0, this.bxD.length);
        System.arraycopy(this.bxE, 0, arrayOfInt2, 0, this.bxE.length);
        System.arraycopy(this.bxF, 0, arrayOfInt3, 0, this.bxF.length);
      }
      this.bxz = ((float[])localObject);
      this.bxA = arrayOfFloat1;
      this.bxB = arrayOfFloat2;
      this.bxC = arrayOfFloat3;
      this.bxD = arrayOfInt1;
      this.bxE = arrayOfInt2;
      this.bxF = arrayOfInt3;
    }
    Object localObject = this.bxz;
    this.bxB[paramInt] = paramFloat1;
    localObject[paramInt] = paramFloat1;
    localObject = this.bxA;
    this.bxC[paramInt] = paramFloat2;
    localObject[paramInt] = paramFloat2;
    localObject = this.bxD;
    int m = (int)paramFloat1;
    int k = (int)paramFloat2;
    if (m < this.bxO.getLeft() + this.bxJ) {
      j = 1;
    }
    int i = j;
    if (k < this.bxO.getTop() + this.bxJ) {
      i = j | 0x4;
    }
    j = i;
    if (m > this.bxO.getRight() - this.bxJ) {
      j = i | 0x2;
    }
    i = j;
    if (k > this.bxO.getBottom() - this.bxJ) {
      i = j | 0x8;
    }
    localObject[paramInt] = i;
    this.bxG |= 1 << paramInt;
    AppMethodBeat.o(192570);
  }
  
  private boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192601);
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    if (((this.bxD[paramInt1] & paramInt2) != paramInt2) || ((this.bxK & paramInt2) == 0) || ((this.bxF[paramInt1] & paramInt2) == paramInt2) || ((this.bxE[paramInt1] & paramInt2) == paramInt2) || ((paramFloat1 <= this.mTouchSlop) && (paramFloat2 <= this.mTouchSlop)))
    {
      AppMethodBeat.o(192601);
      return false;
    }
    if ((paramFloat1 < paramFloat2 * 0.5F) && (this.bxL.FA()))
    {
      int[] arrayOfInt = this.bxF;
      arrayOfInt[paramInt1] |= paramInt2;
      AppMethodBeat.o(192601);
      return false;
    }
    if (((this.bxE[paramInt1] & paramInt2) == 0) && (paramFloat1 > this.mTouchSlop))
    {
      AppMethodBeat.o(192601);
      return true;
    }
    AppMethodBeat.o(192601);
    return false;
  }
  
  private boolean aE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192645);
    boolean bool = g(this.bxM, paramInt1, paramInt2);
    AppMethodBeat.o(192645);
    return bool;
  }
  
  private void b(float paramFloat1, float paramFloat2, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(192597);
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
        int[] arrayOfInt = this.bxE;
        arrayOfInt[paramInt] |= i;
        this.bxL.aG(i, paramInt);
      }
      AppMethodBeat.o(192597);
      return;
      j = 0;
    }
  }
  
  private boolean c(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(192608);
    if (paramView == null)
    {
      AppMethodBeat.o(192608);
      return false;
    }
    int i;
    int j;
    if (this.bxL.aQ(paramView) > 0)
    {
      i = 1;
      if (this.bxL.aM() <= 0) {
        break label90;
      }
      j = 1;
    }
    for (;;)
    {
      if ((i != 0) && (j != 0))
      {
        if (paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 > this.mTouchSlop * this.mTouchSlop)
        {
          AppMethodBeat.o(192608);
          return true;
          i = 0;
          break;
          label90:
          j = 0;
          continue;
        }
        AppMethodBeat.o(192608);
        return false;
      }
    }
    if (i != 0)
    {
      if (Math.abs(paramFloat1) > this.mTouchSlop)
      {
        AppMethodBeat.o(192608);
        return true;
      }
      AppMethodBeat.o(192608);
      return false;
    }
    if (j != 0)
    {
      if (Math.abs(paramFloat2) > this.mTouchSlop)
      {
        AppMethodBeat.o(192608);
        return true;
      }
      AppMethodBeat.o(192608);
      return false;
    }
    AppMethodBeat.o(192608);
    return false;
  }
  
  private static float distanceInfluenceForSnapDuration(float paramFloat)
  {
    AppMethodBeat.i(192528);
    paramFloat = (float)Math.sin((paramFloat - 0.5F) * 0.4712389F);
    AppMethodBeat.o(192528);
    return paramFloat;
  }
  
  private void eK(int paramInt)
  {
    AppMethodBeat.i(192553);
    if ((this.bxz == null) || (!eL(paramInt)))
    {
      AppMethodBeat.o(192553);
      return;
    }
    this.bxz[paramInt] = 0.0F;
    this.bxA[paramInt] = 0.0F;
    this.bxB[paramInt] = 0.0F;
    this.bxC[paramInt] = 0.0F;
    this.bxD[paramInt] = 0;
    this.bxE[paramInt] = 0;
    this.bxF[paramInt] = 0;
    this.bxG &= (1 << paramInt ^ 0xFFFFFFFF);
    AppMethodBeat.o(192553);
  }
  
  private boolean eN(int paramInt)
  {
    AppMethodBeat.i(192667);
    if (!eL(paramInt))
    {
      new StringBuilder("Ignoring pointerId=").append(paramInt).append(" because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
      AppMethodBeat.o(192667);
      return false;
    }
    AppMethodBeat.o(192667);
    return true;
  }
  
  public static boolean g(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192657);
    if (paramView == null)
    {
      AppMethodBeat.o(192657);
      return false;
    }
    if ((paramInt1 >= paramView.getLeft()) && (paramInt1 < paramView.getRight()) && (paramInt2 >= paramView.getTop()) && (paramInt2 < paramView.getBottom()))
    {
      AppMethodBeat.o(192657);
      return true;
    }
    AppMethodBeat.o(192657);
    return false;
  }
  
  private int h(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(192478);
    paramInt3 = t(paramInt3, (int)this.bxI, (int)this.bxH);
    paramInt4 = t(paramInt4, (int)this.bxI, (int)this.bxH);
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
      paramInt1 = s(paramInt1, paramInt3, this.bxL.aQ(paramView));
      paramInt2 = s(paramInt2, paramInt4, this.bxL.aM());
      float f3 = paramInt1;
      paramInt1 = (int)(f2 * paramInt2 + f1 * f3);
      AppMethodBeat.o(192478);
      return paramInt1;
      f1 = i / i1;
      break;
    }
  }
  
  private void h(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(192582);
    int j = paramMotionEvent.getPointerCount();
    int i = 0;
    while (i < j)
    {
      int k = paramMotionEvent.getPointerId(i);
      if (eN(k))
      {
        float f1 = paramMotionEvent.getX(i);
        float f2 = paramMotionEvent.getY(i);
        this.bxB[k] = f1;
        this.bxC[k] = f2;
      }
      i += 1;
    }
    AppMethodBeat.o(192582);
  }
  
  private static float i(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(192514);
    float f = Math.abs(paramFloat1);
    if (f < paramFloat2)
    {
      AppMethodBeat.o(192514);
      return 0.0F;
    }
    if (f > paramFloat3)
    {
      if (paramFloat1 > 0.0F)
      {
        AppMethodBeat.o(192514);
        return paramFloat3;
      }
      paramFloat1 = -paramFloat3;
      AppMethodBeat.o(192514);
      return paramFloat1;
    }
    AppMethodBeat.o(192514);
    return paramFloat1;
  }
  
  private boolean p(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(192467);
    int i = this.bxM.getLeft();
    int j = this.bxM.getTop();
    paramInt1 -= i;
    paramInt2 -= j;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.bwz.abortAnimation();
      eM(0);
      AppMethodBeat.o(192467);
      return false;
    }
    paramInt3 = h(this.bxM, paramInt1, paramInt2, paramInt3, paramInt4);
    this.bwz.startScroll(i, j, paramInt1, paramInt2, paramInt3);
    eM(2);
    AppMethodBeat.o(192467);
    return true;
  }
  
  private void q(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(192631);
    int k = this.bxM.getLeft();
    int j = this.bxM.getTop();
    int i = paramInt1;
    if (paramInt3 != 0)
    {
      i = this.bxL.d(this.bxM, paramInt1);
      z.u(this.bxM, i - k);
    }
    paramInt1 = paramInt2;
    if (paramInt4 != 0)
    {
      paramInt1 = this.bxL.c(this.bxM, paramInt2);
      z.s(this.bxM, paramInt1 - j);
    }
    if ((paramInt3 != 0) || (paramInt4 != 0)) {
      this.bxL.a(this.bxM, i, paramInt1);
    }
    AppMethodBeat.o(192631);
  }
  
  private int s(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(192490);
    if (paramInt1 == 0)
    {
      AppMethodBeat.o(192490);
      return 0;
    }
    int i = this.bxO.getWidth();
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
      AppMethodBeat.o(192490);
      return paramInt1;
    }
  }
  
  private static int t(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(192502);
    int i = Math.abs(paramInt1);
    if (i < paramInt2)
    {
      AppMethodBeat.o(192502);
      return 0;
    }
    if (i > paramInt3)
    {
      if (paramInt1 > 0)
      {
        AppMethodBeat.o(192502);
        return paramInt3;
      }
      paramInt1 = -paramInt3;
      AppMethodBeat.o(192502);
      return paramInt1;
    }
    AppMethodBeat.o(192502);
    return paramInt1;
  }
  
  public final void B(View paramView, int paramInt)
  {
    AppMethodBeat.i(192684);
    if (paramView.getParent() != this.bxO)
    {
      paramView = new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.bxO + ")");
      AppMethodBeat.o(192684);
      throw paramView;
    }
    this.bxM = paramView;
    this.mActivePointerId = paramInt;
    this.bxL.D(paramView, paramInt);
    eM(1);
    AppMethodBeat.o(192684);
  }
  
  public final void Fw()
  {
    AppMethodBeat.i(192707);
    cancel();
    if (this.bxy == 2)
    {
      this.bwz.getCurrX();
      this.bwz.getCurrY();
      this.bwz.abortAnimation();
      int i = this.bwz.getCurrX();
      int j = this.bwz.getCurrY();
      this.bxL.a(this.bxM, i, j);
    }
    eM(0);
    AppMethodBeat.o(192707);
  }
  
  public final boolean Fx()
  {
    AppMethodBeat.i(192745);
    if (this.bxy == 2)
    {
      boolean bool2 = this.bwz.computeScrollOffset();
      int i = this.bwz.getCurrX();
      int j = this.bwz.getCurrY();
      int k = i - this.bxM.getLeft();
      int m = j - this.bxM.getTop();
      if (k != 0) {
        z.u(this.bxM, k);
      }
      if (m != 0) {
        z.s(this.bxM, m);
      }
      if ((k != 0) || (m != 0)) {
        this.bxL.a(this.bxM, i, j);
      }
      boolean bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (i == this.bwz.getFinalX())
        {
          bool1 = bool2;
          if (j == this.bwz.getFinalY())
          {
            this.bwz.abortAnimation();
            bool1 = false;
          }
        }
      }
      if (!bool1) {
        this.bxO.post(this.bxP);
      }
    }
    if (this.bxy == 2)
    {
      AppMethodBeat.o(192745);
      return true;
    }
    AppMethodBeat.o(192745);
    return false;
  }
  
  public final boolean aD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192730);
    if (!this.bxN)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
      AppMethodBeat.o(192730);
      throw localIllegalStateException;
    }
    boolean bool = p(paramInt1, paramInt2, (int)this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int)this.mVelocityTracker.getYVelocity(this.mActivePointerId));
    AppMethodBeat.o(192730);
    return bool;
  }
  
  public final View aF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192801);
    int i = this.bxO.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.bxO.getChildAt(i);
      if ((paramInt1 >= localView.getLeft()) && (paramInt1 < localView.getRight()) && (paramInt2 >= localView.getTop()) && (paramInt2 < localView.getBottom()))
      {
        AppMethodBeat.o(192801);
        return localView;
      }
      i -= 1;
    }
    AppMethodBeat.o(192801);
    return null;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(192695);
    this.mActivePointerId = -1;
    if (this.bxz != null)
    {
      Arrays.fill(this.bxz, 0.0F);
      Arrays.fill(this.bxA, 0.0F);
      Arrays.fill(this.bxB, 0.0F);
      Arrays.fill(this.bxC, 0.0F);
      Arrays.fill(this.bxD, 0);
      Arrays.fill(this.bxE, 0);
      Arrays.fill(this.bxF, 0);
      this.bxG = 0;
    }
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
    AppMethodBeat.o(192695);
  }
  
  public final boolean eL(int paramInt)
  {
    return (this.bxG & 1 << paramInt) != 0;
  }
  
  final void eM(int paramInt)
  {
    AppMethodBeat.i(192770);
    this.bxO.removeCallbacks(this.bxP);
    if (this.bxy != paramInt)
    {
      this.bxy = paramInt;
      this.bxL.F(paramInt);
      if (this.bxy == 0) {
        this.bxM = null;
      }
    }
    AppMethodBeat.o(192770);
  }
  
  public final boolean f(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192721);
    this.bxM = paramView;
    this.mActivePointerId = -1;
    boolean bool = p(paramInt1, paramInt2, 0, 0);
    if ((!bool) && (this.bxy == 0) && (this.bxM != null)) {
      this.bxM = null;
    }
    AppMethodBeat.o(192721);
    return bool;
  }
  
  public final boolean i(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(192780);
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
    while (this.bxy == 1)
    {
      AppMethodBeat.o(192780);
      return true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      i = paramMotionEvent.getPointerId(0);
      a(f1, f2, i);
      paramMotionEvent = aF((int)f1, (int)f2);
      if ((paramMotionEvent == this.bxM) && (this.bxy == 2)) {
        C(paramMotionEvent, i);
      }
      if ((this.bxD[i] & this.bxK) != 0)
      {
        this.bxL.Fz();
        continue;
        j = paramMotionEvent.getPointerId(i);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        a(f1, f2, j);
        if (this.bxy == 0)
        {
          if ((this.bxD[j] & this.bxK) != 0) {
            this.bxL.Fz();
          }
        }
        else if (this.bxy == 2)
        {
          paramMotionEvent = aF((int)f1, (int)f2);
          if (paramMotionEvent == this.bxM)
          {
            C(paramMotionEvent, j);
            continue;
            if ((this.bxz != null) && (this.bxA != null))
            {
              int k = paramMotionEvent.getPointerCount();
              i = 0;
              if (i < k)
              {
                int m = paramMotionEvent.getPointerId(i);
                float f3;
                float f4;
                View localView;
                if (eN(m))
                {
                  f1 = paramMotionEvent.getX(i);
                  f2 = paramMotionEvent.getY(i);
                  f3 = f1 - this.bxz[m];
                  f4 = f2 - this.bxA[m];
                  localView = aF((int)f1, (int)f2);
                  if ((localView == null) || (!c(localView, f3, f4))) {
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
                    i1 = this.bxL.d(localView, i1 + n);
                    int i2 = localView.getTop();
                    int i3 = (int)f4;
                    i3 = this.bxL.c(localView, i3 + i2);
                    int i4 = this.bxL.aQ(localView);
                    int i5 = this.bxL.aM();
                    if (((i4 == 0) || ((i4 > 0) && (i1 == n))) && ((i5 == 0) || ((i5 > 0) && (i3 == i2)))) {
                      break label567;
                    }
                  }
                  b(f3, f4, m);
                  if ((this.bxy == 1) || ((j != 0) && (C(localView, m)))) {
                    break label567;
                  }
                  i += 1;
                  break;
                }
              }
              label567:
              h(paramMotionEvent);
              continue;
              eK(paramMotionEvent.getPointerId(i));
              continue;
              cancel();
            }
          }
        }
      }
    }
    AppMethodBeat.o(192780);
    return false;
  }
  
  public final void j(MotionEvent paramMotionEvent)
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(192793);
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
            AppMethodBeat.o(192793);
            return;
            f1 = paramMotionEvent.getX();
            f2 = paramMotionEvent.getY();
            i = paramMotionEvent.getPointerId(0);
            paramMotionEvent = aF((int)f1, (int)f2);
            a(f1, f2, i);
            C(paramMotionEvent, i);
          } while ((this.bxD[i] & this.bxK) == 0);
          this.bxL.Fz();
          AppMethodBeat.o(192793);
          return;
          i = paramMotionEvent.getPointerId(k);
          f1 = paramMotionEvent.getX(k);
          f2 = paramMotionEvent.getY(k);
          a(f1, f2, i);
          if (this.bxy == 0)
          {
            C(aF((int)f1, (int)f2), i);
            if ((this.bxD[i] & this.bxK) != 0) {
              this.bxL.Fz();
            }
            AppMethodBeat.o(192793);
            return;
          }
        } while (!aE((int)f1, (int)f2));
        C(this.bxM, i);
        AppMethodBeat.o(192793);
        return;
        if (this.bxy != 1) {
          break;
        }
      } while (!eN(this.mActivePointerId));
      i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      f1 = paramMotionEvent.getX(i);
      f2 = paramMotionEvent.getY(i);
      i = (int)(f1 - this.bxB[this.mActivePointerId]);
      j = (int)(f2 - this.bxC[this.mActivePointerId]);
      q(this.bxM.getLeft() + i, this.bxM.getTop() + j, i, j);
      h(paramMotionEvent);
      AppMethodBeat.o(192793);
      return;
      k = paramMotionEvent.getPointerCount();
      i = j;
      while (i < k)
      {
        j = paramMotionEvent.getPointerId(i);
        if (eN(j))
        {
          f1 = paramMotionEvent.getX(i);
          f2 = paramMotionEvent.getY(i);
          float f3 = f1 - this.bxz[j];
          float f4 = f2 - this.bxA[j];
          b(f3, f4, j);
          if (this.bxy == 1) {
            break;
          }
          View localView = aF((int)f1, (int)f2);
          if ((c(localView, f3, f4)) && (C(localView, j))) {
            break;
          }
        }
        i += 1;
      }
      h(paramMotionEvent);
      AppMethodBeat.o(192793);
      return;
    case 6: 
      j = paramMotionEvent.getPointerId(k);
      if ((this.bxy == 1) && (j == this.mActivePointerId))
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
        if ((aF((int)f1, (int)f2) != this.bxM) || (!C(this.bxM, m))) {
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
        Fy();
      }
      eK(j);
      AppMethodBeat.o(192793);
      return;
      i += 1;
      break label573;
      if (this.bxy == 1) {
        Fy();
      }
      cancel();
      AppMethodBeat.o(192793);
      return;
      if (this.bxy == 1) {
        N(0.0F, 0.0F);
      }
      cancel();
      break;
    }
  }
  
  public static abstract class a
  {
    public void D(View paramView, int paramInt) {}
    
    public void F(int paramInt) {}
    
    public boolean FA()
    {
      return false;
    }
    
    public void Fz() {}
    
    public void a(View paramView, int paramInt1, int paramInt2) {}
    
    public void aG(int paramInt1, int paramInt2) {}
    
    public int aM()
    {
      return 0;
    }
    
    public int aQ(View paramView)
    {
      return 0;
    }
    
    public void b(View paramView, float paramFloat1, float paramFloat2) {}
    
    public abstract boolean b(View paramView, int paramInt);
    
    public int c(View paramView, int paramInt)
    {
      return 0;
    }
    
    public int d(View paramView, int paramInt)
    {
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.customview.a.c
 * JD-Core Version:    0.7.0.1
 */