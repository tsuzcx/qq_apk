package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.q;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;

public final class r
{
  private static final Interpolator Gu = new Interpolator()
  {
    public final float getInterpolation(float paramAnonymousFloat)
    {
      paramAnonymousFloat -= 1.0F;
      return paramAnonymousFloat * (paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat) + 1.0F;
    }
  };
  int MI;
  float[] MJ;
  float[] MK;
  float[] ML;
  float[] MM;
  private int[] MN;
  private int[] MO;
  private int[] MP;
  private int MQ;
  private float MR;
  float MS;
  int MT;
  int MU;
  private final a MV;
  View MW;
  private boolean MX;
  private final ViewGroup MY;
  private final Runnable MZ = new Runnable()
  {
    public final void run()
    {
      r.this.aP(0);
    }
  };
  private VelocityTracker fB;
  private int fC = -1;
  private OverScroller iY;
  public int jb;
  
  private r(Context paramContext, ViewGroup paramViewGroup, a parama)
  {
    if (paramViewGroup == null) {
      throw new IllegalArgumentException("Parent view may not be null");
    }
    if (parama == null) {
      throw new IllegalArgumentException("Callback may not be null");
    }
    this.MY = paramViewGroup;
    this.MV = parama;
    paramViewGroup = ViewConfiguration.get(paramContext);
    this.MT = ((int)(paramContext.getResources().getDisplayMetrics().density * 20.0F + 0.5F));
    this.jb = paramViewGroup.getScaledTouchSlop();
    this.MR = paramViewGroup.getScaledMaximumFlingVelocity();
    this.MS = paramViewGroup.getScaledMinimumFlingVelocity();
    this.iY = new OverScroller(paramContext, Gu);
  }
  
  public static r a(ViewGroup paramViewGroup, float paramFloat, a parama)
  {
    paramViewGroup = a(paramViewGroup, parama);
    paramViewGroup.jb = ((int)(paramViewGroup.jb * (1.0F / paramFloat)));
    return paramViewGroup;
  }
  
  public static r a(ViewGroup paramViewGroup, a parama)
  {
    return new r(paramViewGroup.getContext(), paramViewGroup, parama);
  }
  
  private void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    int j = 0;
    if ((this.MJ == null) || (this.MJ.length <= paramInt))
    {
      localObject = new float[paramInt + 1];
      float[] arrayOfFloat1 = new float[paramInt + 1];
      float[] arrayOfFloat2 = new float[paramInt + 1];
      float[] arrayOfFloat3 = new float[paramInt + 1];
      int[] arrayOfInt1 = new int[paramInt + 1];
      int[] arrayOfInt2 = new int[paramInt + 1];
      int[] arrayOfInt3 = new int[paramInt + 1];
      if (this.MJ != null)
      {
        System.arraycopy(this.MJ, 0, localObject, 0, this.MJ.length);
        System.arraycopy(this.MK, 0, arrayOfFloat1, 0, this.MK.length);
        System.arraycopy(this.ML, 0, arrayOfFloat2, 0, this.ML.length);
        System.arraycopy(this.MM, 0, arrayOfFloat3, 0, this.MM.length);
        System.arraycopy(this.MN, 0, arrayOfInt1, 0, this.MN.length);
        System.arraycopy(this.MO, 0, arrayOfInt2, 0, this.MO.length);
        System.arraycopy(this.MP, 0, arrayOfInt3, 0, this.MP.length);
      }
      this.MJ = ((float[])localObject);
      this.MK = arrayOfFloat1;
      this.ML = arrayOfFloat2;
      this.MM = arrayOfFloat3;
      this.MN = arrayOfInt1;
      this.MO = arrayOfInt2;
      this.MP = arrayOfInt3;
    }
    Object localObject = this.MJ;
    this.ML[paramInt] = paramFloat1;
    localObject[paramInt] = paramFloat1;
    localObject = this.MK;
    this.MM[paramInt] = paramFloat2;
    localObject[paramInt] = paramFloat2;
    localObject = this.MN;
    int m = (int)paramFloat1;
    int k = (int)paramFloat2;
    if (m < this.MY.getLeft() + this.MT) {
      j = 1;
    }
    int i = j;
    if (k < this.MY.getTop() + this.MT) {
      i = j | 0x4;
    }
    j = i;
    if (m > this.MY.getRight() - this.MT) {
      j = i | 0x2;
    }
    i = j;
    if (k > this.MY.getBottom() - this.MT) {
      i = j | 0x8;
    }
    localObject[paramInt] = i;
    this.MQ |= 1 << paramInt;
  }
  
  private boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    if (((this.MN[paramInt1] & paramInt2) != paramInt2) || ((this.MU & paramInt2) == 0) || ((this.MP[paramInt1] & paramInt2) == paramInt2) || ((this.MO[paramInt1] & paramInt2) == paramInt2) || ((paramFloat1 <= this.jb) && (paramFloat2 <= this.jb))) {}
    while (((this.MO[paramInt1] & paramInt2) != 0) || (paramFloat1 <= this.jb)) {
      return false;
    }
    return true;
  }
  
  private void aN(int paramInt)
  {
    if ((this.MJ == null) || (!aO(paramInt))) {
      return;
    }
    this.MJ[paramInt] = 0.0F;
    this.MK[paramInt] = 0.0F;
    this.ML[paramInt] = 0.0F;
    this.MM[paramInt] = 0.0F;
    this.MN[paramInt] = 0;
    this.MO[paramInt] = 0;
    this.MP[paramInt] = 0;
    this.MQ &= (1 << paramInt ^ 0xFFFFFFFF);
  }
  
  private boolean aQ(int paramInt)
  {
    if (!aO(paramInt))
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
        int[] arrayOfInt = this.MO;
        arrayOfInt[paramInt] |= i;
        this.MV.u(i, paramInt);
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
        if (this.MV.q(paramView) > 0)
        {
          i = 1;
          if (this.MV.au() <= 0) {
            break label72;
          }
        }
        for (j = 1;; j = 0)
        {
          if ((i == 0) || (j == 0)) {
            break label78;
          }
          if (paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 <= this.jb * this.jb) {
            break;
          }
          return true;
          i = 0;
          break label20;
        }
        if (i == 0) {
          break;
        }
      } while (Math.abs(paramFloat1) <= this.jb);
      return true;
    } while ((j == 0) || (Math.abs(paramFloat2) <= this.jb));
    return true;
  }
  
  private void dX()
  {
    this.fB.computeCurrentVelocity(1000, this.MR);
    v(e(this.fB.getXVelocity(this.fC), this.MS, this.MR), e(this.fB.getYVelocity(this.fC), this.MS, this.MR));
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
  
  private void e(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getPointerCount();
    int i = 0;
    while (i < j)
    {
      int k = paramMotionEvent.getPointerId(i);
      if (aQ(k))
      {
        float f1 = paramMotionEvent.getX(i);
        float f2 = paramMotionEvent.getY(i);
        this.ML[k] = f1;
        this.MM[k] = f2;
      }
      i += 1;
    }
  }
  
  public static boolean f(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {}
    while ((paramInt1 < paramView.getLeft()) || (paramInt1 >= paramView.getRight()) || (paramInt2 < paramView.getTop()) || (paramInt2 >= paramView.getBottom())) {
      return false;
    }
    return true;
  }
  
  private int g(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0) {
      return 0;
    }
    int i = this.MY.getWidth();
    int j = i / 2;
    float f3 = Math.min(1.0F, Math.abs(paramInt1) / i);
    float f1 = j;
    float f2 = j;
    f3 = (float)Math.sin((f3 - 0.5F) * 0.4712389F);
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
    int i = this.MW.getLeft();
    int j = this.MW.getTop();
    paramInt1 -= i;
    paramInt2 -= j;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.iY.abortAnimation();
      aP(0);
      return false;
    }
    View localView = this.MW;
    paramInt3 = h(paramInt3, (int)this.MS, (int)this.MR);
    paramInt4 = h(paramInt4, (int)this.MS, (int)this.MR);
    int k = Math.abs(paramInt1);
    int m = Math.abs(paramInt2);
    int n = Math.abs(paramInt3);
    int i1 = Math.abs(paramInt4);
    int i2 = n + i1;
    int i3 = k + m;
    float f1;
    if (paramInt3 != 0)
    {
      f1 = n / i2;
      if (paramInt4 == 0) {
        break label237;
      }
    }
    label237:
    for (float f2 = i1 / i2;; f2 = m / i3)
    {
      paramInt3 = g(paramInt1, paramInt3, this.MV.q(localView));
      paramInt4 = g(paramInt2, paramInt4, this.MV.au());
      float f3 = paramInt3;
      paramInt3 = (int)(f2 * paramInt4 + f1 * f3);
      this.iY.startScroll(i, j, paramInt1, paramInt2, paramInt3);
      aP(2);
      return true;
      f1 = k / i3;
      break;
    }
  }
  
  private boolean u(View paramView, int paramInt)
  {
    if ((paramView == this.MW) && (this.fC == paramInt)) {
      return true;
    }
    if ((paramView != null) && (this.MV.b(paramView, paramInt)))
    {
      this.fC = paramInt;
      t(paramView, paramInt);
      return true;
    }
    return false;
  }
  
  private void v(float paramFloat1, float paramFloat2)
  {
    this.MX = true;
    this.MV.a(this.MW, paramFloat1, paramFloat2);
    this.MX = false;
    if (this.MI == 1) {
      aP(0);
    }
  }
  
  public final boolean aO(int paramInt)
  {
    return (this.MQ & 1 << paramInt) != 0;
  }
  
  final void aP(int paramInt)
  {
    this.MY.removeCallbacks(this.MZ);
    if (this.MI != paramInt)
    {
      this.MI = paramInt;
      this.MV.x(paramInt);
      if (this.MI == 0) {
        this.MW = null;
      }
    }
  }
  
  public final void abort()
  {
    cancel();
    if (this.MI == 2)
    {
      this.iY.getCurrX();
      this.iY.getCurrY();
      this.iY.abortAnimation();
      int i = this.iY.getCurrX();
      int j = this.iY.getCurrY();
      this.MV.a(this.MW, i, j);
    }
    aP(0);
  }
  
  public final void cancel()
  {
    this.fC = -1;
    if (this.MJ != null)
    {
      Arrays.fill(this.MJ, 0.0F);
      Arrays.fill(this.MK, 0.0F);
      Arrays.fill(this.ML, 0.0F);
      Arrays.fill(this.MM, 0.0F);
      Arrays.fill(this.MN, 0);
      Arrays.fill(this.MO, 0);
      Arrays.fill(this.MP, 0);
      this.MQ = 0;
    }
    if (this.fB != null)
    {
      this.fB.recycle();
      this.fB = null;
    }
  }
  
  public final boolean dW()
  {
    boolean bool2 = false;
    if (this.MI == 2)
    {
      boolean bool3 = this.iY.computeScrollOffset();
      int i = this.iY.getCurrX();
      int j = this.iY.getCurrY();
      int k = i - this.MW.getLeft();
      int m = j - this.MW.getTop();
      if (k != 0) {
        q.q(this.MW, k);
      }
      if (m != 0) {
        q.p(this.MW, m);
      }
      if ((k != 0) || (m != 0)) {
        this.MV.a(this.MW, i, j);
      }
      bool1 = bool3;
      if (bool3)
      {
        bool1 = bool3;
        if (i == this.iY.getFinalX())
        {
          bool1 = bool3;
          if (j == this.iY.getFinalY())
          {
            this.iY.abortAnimation();
            bool1 = false;
          }
        }
      }
      if (!bool1) {
        this.MY.post(this.MZ);
      }
    }
    boolean bool1 = bool2;
    if (this.MI == 2) {
      bool1 = true;
    }
    return bool1;
  }
  
  public final boolean e(View paramView, int paramInt1, int paramInt2)
  {
    this.MW = paramView;
    this.fC = -1;
    boolean bool = h(paramInt1, paramInt2, 0, 0);
    if ((!bool) && (this.MI == 0) && (this.MW != null)) {
      this.MW = null;
    }
    return bool;
  }
  
  public final boolean f(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getActionMasked();
    int i = paramMotionEvent.getActionIndex();
    if (j == 0) {
      cancel();
    }
    if (this.fB == null) {
      this.fB = VelocityTracker.obtain();
    }
    this.fB.addMovement(paramMotionEvent);
    switch (j)
    {
    }
    while (this.MI == 1)
    {
      return true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      i = paramMotionEvent.getPointerId(0);
      a(f1, f2, i);
      paramMotionEvent = y((int)f1, (int)f2);
      if ((paramMotionEvent == this.MW) && (this.MI == 2)) {
        u(paramMotionEvent, i);
      }
      if ((this.MN[i] & this.MU) != 0)
      {
        this.MV.dK();
        continue;
        j = paramMotionEvent.getPointerId(i);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        a(f1, f2, j);
        if (this.MI == 0)
        {
          if ((this.MN[j] & this.MU) != 0) {
            this.MV.dK();
          }
        }
        else if (this.MI == 2)
        {
          paramMotionEvent = y((int)f1, (int)f2);
          if (paramMotionEvent == this.MW)
          {
            u(paramMotionEvent, j);
            continue;
            if ((this.MJ != null) && (this.MK != null))
            {
              int k = paramMotionEvent.getPointerCount();
              i = 0;
              if (i < k)
              {
                int m = paramMotionEvent.getPointerId(i);
                float f3;
                float f4;
                View localView;
                if (aQ(m))
                {
                  f1 = paramMotionEvent.getX(i);
                  f2 = paramMotionEvent.getY(i);
                  f3 = f1 - this.MJ[m];
                  f4 = f2 - this.MK[m];
                  localView = y((int)f1, (int)f2);
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
                    i1 = this.MV.d(localView, i1 + n);
                    int i2 = localView.getTop();
                    int i3 = (int)f4;
                    i3 = this.MV.c(localView, i3 + i2);
                    int i4 = this.MV.q(localView);
                    int i5 = this.MV.au();
                    if (((i4 == 0) || ((i4 > 0) && (i1 == n))) && ((i5 == 0) || ((i5 > 0) && (i3 == i2)))) {
                      break label557;
                    }
                  }
                  b(f3, f4, m);
                  if ((this.MI == 1) || ((j != 0) && (u(localView, m)))) {
                    break label557;
                  }
                  i += 1;
                  break;
                }
              }
              label557:
              e(paramMotionEvent);
              continue;
              aN(paramMotionEvent.getPointerId(i));
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
    if (this.fB == null) {
      this.fB = VelocityTracker.obtain();
    }
    this.fB.addMovement(paramMotionEvent);
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
              paramMotionEvent = y((int)f1, (int)f2);
              a(f1, f2, i);
              u(paramMotionEvent, i);
            } while ((this.MN[i] & this.MU) == 0);
            this.MV.dK();
            return;
            i = paramMotionEvent.getPointerId(k);
            f1 = paramMotionEvent.getX(k);
            f2 = paramMotionEvent.getY(k);
            a(f1, f2, i);
            if (this.MI != 0) {
              break;
            }
            u(y((int)f1, (int)f2), i);
          } while ((this.MN[i] & this.MU) == 0);
          this.MV.dK();
          return;
          j = (int)f1;
          k = (int)f2;
        } while (!f(this.MW, j, k));
        u(this.MW, i);
        return;
        if (this.MI != 1) {
          break;
        }
      } while (!aQ(this.fC));
      i = paramMotionEvent.findPointerIndex(this.fC);
      f1 = paramMotionEvent.getX(i);
      f2 = paramMotionEvent.getY(i);
      m = (int)(f1 - this.ML[this.fC]);
      int n = (int)(f2 - this.MM[this.fC]);
      j = this.MW.getLeft() + m;
      k = this.MW.getTop() + n;
      int i2 = this.MW.getLeft();
      int i1 = this.MW.getTop();
      i = j;
      if (m != 0)
      {
        i = this.MV.d(this.MW, j);
        q.q(this.MW, i - i2);
      }
      j = k;
      if (n != 0)
      {
        j = this.MV.c(this.MW, k);
        q.p(this.MW, j - i1);
      }
      if ((m != 0) || (n != 0)) {
        this.MV.a(this.MW, i, j);
      }
      e(paramMotionEvent);
      return;
      k = paramMotionEvent.getPointerCount();
      i = j;
      while (i < k)
      {
        j = paramMotionEvent.getPointerId(i);
        if (aQ(j))
        {
          f1 = paramMotionEvent.getX(i);
          f2 = paramMotionEvent.getY(i);
          float f3 = f1 - this.MJ[j];
          float f4 = f2 - this.MK[j];
          b(f3, f4, j);
          if (this.MI == 1) {
            break;
          }
          View localView = y((int)f1, (int)f2);
          if ((c(localView, f3, f4)) && (u(localView, j))) {
            break;
          }
        }
        i += 1;
      }
      e(paramMotionEvent);
      return;
    case 6: 
      j = paramMotionEvent.getPointerId(k);
      if ((this.MI == 1) && (j == this.fC))
      {
        k = paramMotionEvent.getPointerCount();
        if (i >= k) {
          break label785;
        }
        m = paramMotionEvent.getPointerId(i);
        if (m == this.fC) {
          break label740;
        }
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        if ((y((int)f1, (int)f2) != this.MW) || (!u(this.MW, m))) {
          break label740;
        }
      }
      break;
    }
    label785:
    for (i = this.fC;; i = -1)
    {
      if (i == -1) {
        dX();
      }
      aN(j);
      return;
      label740:
      i += 1;
      break;
      if (this.MI == 1) {
        dX();
      }
      cancel();
      return;
      if (this.MI == 1) {
        v(0.0F, 0.0F);
      }
      cancel();
      return;
    }
  }
  
  public final void t(View paramView, int paramInt)
  {
    if (paramView.getParent() != this.MY) {
      throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.MY + ")");
    }
    this.MW = paramView;
    this.fC = paramInt;
    this.MV.j(paramView, paramInt);
    aP(1);
  }
  
  public final boolean x(int paramInt1, int paramInt2)
  {
    if (!this.MX) {
      throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }
    return h(paramInt1, paramInt2, (int)this.fB.getXVelocity(this.fC), (int)this.fB.getYVelocity(this.fC));
  }
  
  public final View y(int paramInt1, int paramInt2)
  {
    int i = this.MY.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.MY.getChildAt(i);
      if ((paramInt1 >= localView.getLeft()) && (paramInt1 < localView.getRight()) && (paramInt2 >= localView.getTop()) && (paramInt2 < localView.getBottom())) {
        return localView;
      }
      i -= 1;
    }
    return null;
  }
  
  public static abstract class a
  {
    public void a(View paramView, float paramFloat1, float paramFloat2) {}
    
    public void a(View paramView, int paramInt1, int paramInt2) {}
    
    public int au()
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
    
    public void dK() {}
    
    public void j(View paramView, int paramInt) {}
    
    public int q(View paramView)
    {
      return 0;
    }
    
    public void u(int paramInt1, int paramInt2) {}
    
    public void x(int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.widget.r
 * JD-Core Version:    0.7.0.1
 */