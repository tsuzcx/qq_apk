package android.support.v7.widget.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.t;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.d;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.j;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.RecyclerView.w;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends RecyclerView.h
  implements RecyclerView.j
{
  Rect Sh;
  public RecyclerView alu;
  private RecyclerView.d aqW = null;
  private int auQ;
  public a ayA;
  private int ayB = 0;
  int ayC;
  List<c> ayD = new ArrayList();
  final Runnable ayE = new Runnable()
  {
    public final void run()
    {
      int k = 0;
      a locala;
      long l2;
      long l1;
      Object localObject;
      int j;
      int i;
      label149:
      int m;
      label206:
      RecyclerView localRecyclerView;
      if (a.this.ayr != null)
      {
        locala = a.this;
        if (locala.ayr == null) {
          break label550;
        }
        l2 = System.currentTimeMillis();
        if (locala.ayM != -9223372036854775808L) {
          break label409;
        }
        l1 = 0L;
        localObject = locala.alu.getLayoutManager();
        if (locala.Sh == null) {
          locala.Sh = new Rect();
        }
        ((RecyclerView.i)localObject).f(locala.ayr.asD, locala.Sh);
        if (!((RecyclerView.i)localObject).jM()) {
          break label479;
        }
        j = (int)(locala.ayy + locala.ayw);
        i = j - locala.Sh.left - locala.alu.getPaddingLeft();
        if ((locala.ayw >= 0.0F) || (i >= 0)) {
          break label422;
        }
        if (!((RecyclerView.i)localObject).jN()) {
          break label545;
        }
        m = (int)(locala.ayz + locala.ayx);
        j = m - locala.Sh.top - locala.alu.getPaddingTop();
        if ((locala.ayx >= 0.0F) || (j >= 0)) {
          break label484;
        }
        if (i == 0) {
          break label566;
        }
        localObject = locala.ayA;
        localRecyclerView = locala.alu;
        m = locala.ayr.asD.getWidth();
        locala.alu.getWidth();
        i = ((a.a)localObject).a(localRecyclerView, m, i, l1);
      }
      label409:
      label422:
      label550:
      label566:
      for (;;)
      {
        if (j != 0)
        {
          localObject = locala.ayA;
          localRecyclerView = locala.alu;
          m = locala.ayr.asD.getHeight();
          locala.alu.getHeight();
          j = ((a.a)localObject).a(localRecyclerView, m, j, l1);
        }
        for (;;)
        {
          if ((i != 0) || (j != 0))
          {
            if (locala.ayM == -9223372036854775808L) {
              locala.ayM = l2;
            }
            locala.alu.scrollBy(i, j);
          }
          for (i = 1;; i = k)
          {
            if (i != 0)
            {
              if (a.this.ayr != null) {
                a.this.J(a.this.ayr);
              }
              a.this.alu.removeCallbacks(a.this.ayE);
              t.b(a.this.alu, this);
            }
            return;
            l1 = l2 - locala.ayM;
            break;
            if (locala.ayw > 0.0F)
            {
              j = j + locala.ayr.asD.getWidth() + locala.Sh.right - (locala.alu.getWidth() - locala.alu.getPaddingRight());
              i = j;
              if (j > 0) {
                break label149;
              }
            }
            label479:
            i = 0;
            break label149;
            label484:
            if (locala.ayx > 0.0F)
            {
              m = m + locala.ayr.asD.getHeight() + locala.Sh.bottom - (locala.alu.getHeight() - locala.alu.getPaddingBottom());
              j = m;
              if (m > 0) {
                break label206;
              }
            }
            j = 0;
            break label206;
            locala.ayM = -9223372036854775808L;
          }
        }
      }
    }
  };
  private List<RecyclerView.w> ayF;
  private List<Integer> ayG;
  View ayH = null;
  int ayI = -1;
  android.support.v4.view.c ayJ;
  private b ayK;
  private final RecyclerView.l ayL = new RecyclerView.l()
  {
    public final boolean a(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
    {
      a.this.ayJ.onTouchEvent(paramAnonymousMotionEvent);
      int i = paramAnonymousMotionEvent.getActionMasked();
      if (i == 0)
      {
        a.this.mActivePointerId = paramAnonymousMotionEvent.getPointerId(0);
        a.this.ays = paramAnonymousMotionEvent.getX();
        a.this.ayt = paramAnonymousMotionEvent.getY();
        a.this.mU();
        if (a.this.ayr == null)
        {
          a locala = a.this;
          if (locala.ayD.isEmpty()) {
            break label315;
          }
          View localView = locala.j(paramAnonymousMotionEvent);
          i = locala.ayD.size() - 1;
          if (i < 0) {
            break label315;
          }
          paramAnonymousRecyclerView = (a.c)locala.ayD.get(i);
          if (paramAnonymousRecyclerView.arH.asD != localView) {
            break label308;
          }
          label143:
          if (paramAnonymousRecyclerView != null)
          {
            locala = a.this;
            locala.ays -= paramAnonymousRecyclerView.mX;
            locala = a.this;
            locala.ayt -= paramAnonymousRecyclerView.mY;
            a.this.b(paramAnonymousRecyclerView.arH, true);
            if (a.this.ayp.remove(paramAnonymousRecyclerView.arH.asD)) {
              a.this.ayA.d(a.this.alu, paramAnonymousRecyclerView.arH);
            }
            a.this.e(paramAnonymousRecyclerView.arH, paramAnonymousRecyclerView.ayB);
            a.this.a(paramAnonymousMotionEvent, a.this.ayC, 0);
          }
        }
      }
      for (;;)
      {
        if (a.this.mVelocityTracker != null) {
          a.this.mVelocityTracker.addMovement(paramAnonymousMotionEvent);
        }
        if (a.this.ayr == null) {
          break label393;
        }
        return true;
        label308:
        i -= 1;
        break;
        label315:
        paramAnonymousRecyclerView = null;
        break label143;
        if ((i == 3) || (i == 1))
        {
          a.this.mActivePointerId = -1;
          a.this.e(null, 0);
        }
        else if (a.this.mActivePointerId != -1)
        {
          int j = paramAnonymousMotionEvent.findPointerIndex(a.this.mActivePointerId);
          if (j >= 0) {
            a.this.a(i, paramAnonymousMotionEvent, j);
          }
        }
      }
      label393:
      return false;
    }
    
    public final void ai(boolean paramAnonymousBoolean)
    {
      if (!paramAnonymousBoolean) {
        return;
      }
      a.this.e(null, 0);
    }
    
    public final void b(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
    {
      int i = 0;
      a.this.ayJ.onTouchEvent(paramAnonymousMotionEvent);
      if (a.this.mVelocityTracker != null) {
        a.this.mVelocityTracker.addMovement(paramAnonymousMotionEvent);
      }
      if (a.this.mActivePointerId == -1) {}
      int j;
      do
      {
        int k;
        do
        {
          return;
          j = paramAnonymousMotionEvent.getActionMasked();
          k = paramAnonymousMotionEvent.findPointerIndex(a.this.mActivePointerId);
          if (k >= 0) {
            a.this.a(j, paramAnonymousMotionEvent, k);
          }
          paramAnonymousRecyclerView = a.this.ayr;
        } while (paramAnonymousRecyclerView == null);
        switch (j)
        {
        case 4: 
        case 5: 
        default: 
          return;
        case 1: 
        case 2: 
        case 3: 
          for (;;)
          {
            a.this.e(null, 0);
            a.this.mActivePointerId = -1;
            return;
            if (k < 0) {
              break;
            }
            a.this.a(paramAnonymousMotionEvent, a.this.ayC, k);
            a.this.J(paramAnonymousRecyclerView);
            a.this.alu.removeCallbacks(a.this.ayE);
            a.this.ayE.run();
            a.this.alu.invalidate();
            return;
            if (a.this.mVelocityTracker != null) {
              a.this.mVelocityTracker.clear();
            }
          }
        }
        j = paramAnonymousMotionEvent.getActionIndex();
      } while (paramAnonymousMotionEvent.getPointerId(j) != a.this.mActivePointerId);
      if (j == 0) {
        i = 1;
      }
      a.this.mActivePointerId = paramAnonymousMotionEvent.getPointerId(i);
      a.this.a(paramAnonymousMotionEvent, a.this.ayC, j);
    }
  };
  long ayM;
  final List<View> ayp = new ArrayList();
  private final float[] ayq = new float[2];
  RecyclerView.w ayr = null;
  float ays;
  float ayt;
  private float ayu;
  private float ayv;
  public float ayw;
  public float ayx;
  float ayy;
  float ayz;
  int mActivePointerId = -1;
  VelocityTracker mVelocityTracker;
  
  public a(a parama)
  {
    this.ayA = parama;
  }
  
  private static boolean a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (paramFloat1 >= paramFloat3) && (paramFloat1 <= paramView.getWidth() + paramFloat3) && (paramFloat2 >= paramFloat4) && (paramFloat2 <= paramView.getHeight() + paramFloat4);
  }
  
  private int df(int paramInt)
  {
    int j = 8;
    if ((paramInt & 0xC) != 0)
    {
      int i;
      float f2;
      if (this.ayw > 0.0F)
      {
        i = 8;
        if ((this.mVelocityTracker == null) || (this.mActivePointerId < 0)) {
          break label140;
        }
        this.mVelocityTracker.computeCurrentVelocity(1000, a.R(this.ayv));
        f2 = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
        f1 = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
        if (f2 <= 0.0F) {
          break label134;
        }
      }
      for (;;)
      {
        f2 = Math.abs(f2);
        if (((j & paramInt) == 0) || (i != j) || (f2 < a.Q(this.ayu)) || (f2 <= Math.abs(f1))) {
          break label140;
        }
        return j;
        i = 4;
        break;
        label134:
        j = 4;
      }
      label140:
      float f1 = this.alu.getWidth();
      if (((paramInt & i) != 0) && (Math.abs(this.ayw) > f1 * 0.5F)) {
        return i;
      }
    }
    return 0;
  }
  
  private int dg(int paramInt)
  {
    int j = 2;
    if ((paramInt & 0x3) != 0)
    {
      int i;
      float f2;
      if (this.ayx > 0.0F)
      {
        i = 2;
        if ((this.mVelocityTracker == null) || (this.mActivePointerId < 0)) {
          break label137;
        }
        this.mVelocityTracker.computeCurrentVelocity(1000, a.R(this.ayv));
        f1 = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
        f2 = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
        if (f2 <= 0.0F) {
          break label131;
        }
      }
      for (;;)
      {
        f2 = Math.abs(f2);
        if (((j & paramInt) == 0) || (j != i) || (f2 < a.Q(this.ayu)) || (f2 <= Math.abs(f1))) {
          break label137;
        }
        return j;
        i = 1;
        break;
        label131:
        j = 1;
      }
      label137:
      float f1 = this.alu.getHeight();
      if (((paramInt & i) != 0) && (Math.abs(this.ayx) > f1 * 0.5F)) {
        return i;
      }
    }
    return 0;
  }
  
  private void g(float[] paramArrayOfFloat)
  {
    if ((this.ayC & 0xC) != 0) {
      paramArrayOfFloat[0] = (this.ayy + this.ayw - this.ayr.asD.getLeft());
    }
    while ((this.ayC & 0x3) != 0)
    {
      paramArrayOfFloat[1] = (this.ayz + this.ayx - this.ayr.asD.getTop());
      return;
      paramArrayOfFloat[0] = this.ayr.asD.getTranslationX();
    }
    paramArrayOfFloat[1] = this.ayr.asD.getTranslationY();
  }
  
  private void mV()
  {
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  final void J(RecyclerView.w paramw)
  {
    if (this.alu.isLayoutRequested()) {}
    label10:
    Object localObject;
    int i;
    label484:
    do
    {
      int m;
      int n;
      do
      {
        float f;
        do
        {
          break label10;
          do
          {
            return;
          } while (this.ayB != 2);
          f = this.ayA.K(paramw);
          m = (int)(this.ayy + this.ayw);
          n = (int)(this.ayz + this.ayx);
        } while ((Math.abs(n - paramw.asD.getTop()) < paramw.asD.getHeight() * f) && (Math.abs(m - paramw.asD.getLeft()) < f * paramw.asD.getWidth()));
        int i1;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        if (this.ayF == null)
        {
          this.ayF = new ArrayList();
          this.ayG = new ArrayList();
          i1 = Math.round(this.ayy + this.ayw) + 0;
          i2 = Math.round(this.ayz + this.ayx) + 0;
          i3 = paramw.asD.getWidth() + i1 + 0;
          i4 = paramw.asD.getHeight() + i2 + 0;
          i5 = (i1 + i3) / 2;
          i6 = (i2 + i4) / 2;
          localObject = this.alu.getLayoutManager();
          i7 = ((RecyclerView.i)localObject).getChildCount();
          i = 0;
        }
        for (;;)
        {
          if (i >= i7) {
            break label484;
          }
          View localView = ((RecyclerView.i)localObject).getChildAt(i);
          if ((localView != paramw.asD) && (localView.getBottom() >= i2) && (localView.getTop() <= i4) && (localView.getRight() >= i1) && (localView.getLeft() <= i3))
          {
            RecyclerView.w localw = this.alu.bh(localView);
            int j = Math.abs(i5 - (localView.getLeft() + localView.getRight()) / 2);
            int k = localView.getTop();
            k = Math.abs(i6 - (localView.getBottom() + k) / 2);
            int i8 = j * j + k * k;
            k = 0;
            int i9 = this.ayF.size();
            j = 0;
            for (;;)
            {
              if ((j < i9) && (i8 > ((Integer)this.ayG.get(j)).intValue()))
              {
                k += 1;
                j += 1;
                continue;
                this.ayF.clear();
                this.ayG.clear();
                break;
              }
            }
            this.ayF.add(k, localw);
            this.ayG.add(k, Integer.valueOf(i8));
          }
          i += 1;
        }
        localObject = this.ayF;
      } while (((List)localObject).size() == 0);
      localObject = a.a(paramw, (List)localObject, m, n);
      if (localObject == null)
      {
        this.ayF.clear();
        this.ayG.clear();
        return;
      }
      i = ((RecyclerView.w)localObject).lv();
      paramw.lv();
    } while (!this.ayA.a(this.alu, paramw, (RecyclerView.w)localObject));
    a.a(this.alu, paramw, (RecyclerView.w)localObject, i);
  }
  
  final void a(int paramInt1, MotionEvent paramMotionEvent, int paramInt2)
  {
    Object localObject2 = null;
    if ((this.ayr != null) || (paramInt1 != 2) || (this.ayB == 2) || (!this.ayA.mX())) {}
    label33:
    Object localObject3;
    Object localObject1;
    label66:
    float f1;
    float f2;
    float f3;
    float f4;
    do
    {
      do
      {
        do
        {
          break label33;
          break label33;
          do
          {
            return;
          } while (this.alu.getScrollState() == 1);
          localObject3 = this.alu.getLayoutManager();
          if (this.mActivePointerId != -1) {
            break;
          }
          localObject1 = localObject2;
          if (localObject1 == null) {
            break label375;
          }
          paramInt1 = (this.ayA.b(this.alu, (RecyclerView.w)localObject1) & 0xFF00) >> 8;
        } while (paramInt1 == 0);
        f1 = paramMotionEvent.getX(paramInt2);
        f2 = paramMotionEvent.getY(paramInt2);
        f1 -= this.ays;
        f2 -= this.ayt;
        f3 = Math.abs(f1);
        f4 = Math.abs(f2);
      } while ((f3 < this.auQ) && (f4 < this.auQ));
      if (f3 <= f4) {
        break label377;
      }
    } while (((f1 < 0.0F) && ((paramInt1 & 0x4) == 0)) || ((f1 > 0.0F) && ((paramInt1 & 0x8) == 0)));
    label375:
    label377:
    do
    {
      this.ayx = 0.0F;
      this.ayw = 0.0F;
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      e((RecyclerView.w)localObject1, 1);
      return;
      paramInt1 = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      f3 = paramMotionEvent.getX(paramInt1);
      f4 = this.ays;
      f1 = paramMotionEvent.getY(paramInt1);
      f2 = this.ayt;
      f3 = Math.abs(f3 - f4);
      f1 = Math.abs(f1 - f2);
      if (f3 < this.auQ)
      {
        localObject1 = localObject2;
        if (f1 < this.auQ) {
          break label66;
        }
      }
      if (f3 > f1)
      {
        localObject1 = localObject2;
        if (((RecyclerView.i)localObject3).jM()) {
          break label66;
        }
      }
      if (f1 > f3)
      {
        localObject1 = localObject2;
        if (((RecyclerView.i)localObject3).jN()) {
          break label66;
        }
      }
      localObject3 = j(paramMotionEvent);
      localObject1 = localObject2;
      if (localObject3 == null) {
        break label66;
      }
      localObject1 = this.alu.bh((View)localObject3);
      break label66;
      break label33;
      if ((f2 < 0.0F) && ((paramInt1 & 0x1) == 0)) {
        break;
      }
    } while ((f2 <= 0.0F) || ((paramInt1 & 0x2) != 0));
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.t paramt)
  {
    this.ayI = -1;
    float f2;
    float f1;
    if (this.ayr != null)
    {
      g(this.ayq);
      f2 = this.ayq[0];
      f1 = this.ayq[1];
    }
    for (;;)
    {
      paramt = this.ayA;
      RecyclerView.w localw = this.ayr;
      List localList = this.ayD;
      int j = this.ayB;
      int k = localList.size();
      int i = 0;
      if (i < k)
      {
        c localc = (c)localList.get(i);
        if (localc.ayV == localc.ayX)
        {
          localc.mX = localc.arH.asD.getTranslationX();
          label122:
          if (localc.ayW != localc.ayY) {
            break label231;
          }
        }
        label231:
        for (localc.mY = localc.arH.asD.getTranslationY();; localc.mY = (localc.ayW + localc.azd * (localc.ayY - localc.ayW)))
        {
          int m = paramCanvas.save();
          paramt.a(paramCanvas, paramRecyclerView, localc.arH, localc.mX, localc.mY, localc.ayB, false);
          paramCanvas.restoreToCount(m);
          i += 1;
          break;
          localc.mX = (localc.ayV + localc.azd * (localc.ayX - localc.ayV));
          break label122;
        }
      }
      if (localw != null)
      {
        i = paramCanvas.save();
        paramt.a(paramCanvas, paramRecyclerView, localw, f2, f1, j, true);
        paramCanvas.restoreToCount(i);
      }
      return;
      f1 = 0.0F;
      f2 = 0.0F;
    }
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
  {
    paramRect.setEmpty();
  }
  
  final void a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    float f1 = paramMotionEvent.getX(paramInt2);
    float f2 = paramMotionEvent.getY(paramInt2);
    this.ayw = (f1 - this.ays);
    this.ayx = (f2 - this.ayt);
    if ((paramInt1 & 0x4) == 0) {
      this.ayw = Math.max(0.0F, this.ayw);
    }
    if ((paramInt1 & 0x8) == 0) {
      this.ayw = Math.min(0.0F, this.ayw);
    }
    if ((paramInt1 & 0x1) == 0) {
      this.ayx = Math.max(0.0F, this.ayx);
    }
    if ((paramInt1 & 0x2) == 0) {
      this.ayx = Math.min(0.0F, this.ayx);
    }
  }
  
  public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.t paramt)
  {
    int k = 0;
    if (this.ayr != null) {
      g(this.ayq);
    }
    RecyclerView.w localw = this.ayr;
    paramt = this.ayD;
    int j = paramt.size();
    int i = 0;
    while (i < j)
    {
      paramt.get(i);
      int m = paramCanvas.save();
      a.mY();
      paramCanvas.restoreToCount(m);
      i += 1;
    }
    if (localw != null)
    {
      i = paramCanvas.save();
      a.mY();
      paramCanvas.restoreToCount(i);
    }
    j -= 1;
    i = k;
    if (j >= 0)
    {
      paramCanvas = (c)paramt.get(j);
      if ((paramCanvas.AD) && (!paramCanvas.azb)) {
        paramt.remove(j);
      }
    }
    for (;;)
    {
      j -= 1;
      break;
      if (!paramCanvas.AD)
      {
        i = 1;
        continue;
        if (i != 0) {
          paramRecyclerView.invalidate();
        }
        return;
      }
    }
  }
  
  final void b(RecyclerView.w paramw, boolean paramBoolean)
  {
    int i = this.ayD.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        c localc = (c)this.ayD.get(i);
        if (localc.arH == paramw)
        {
          localc.azc |= paramBoolean;
          if (!localc.AD) {
            localc.ayZ.cancel();
          }
          this.ayD.remove(i);
        }
      }
      else
      {
        return;
      }
      i -= 1;
    }
  }
  
  public final void bQ(View paramView) {}
  
  public final void bR(View paramView)
  {
    ch(paramView);
    paramView = this.alu.bh(paramView);
    if (paramView == null) {}
    do
    {
      return;
      if ((this.ayr != null) && (paramView == this.ayr))
      {
        e(null, 0);
        return;
      }
      b(paramView, false);
    } while (!this.ayp.remove(paramView.asD));
    this.ayA.d(this.alu, paramView);
  }
  
  final void ch(View paramView)
  {
    if (paramView == this.ayH)
    {
      this.ayH = null;
      if (this.aqW != null) {
        this.alu.setChildDrawingOrderCallback(null);
      }
    }
  }
  
  public final void e(RecyclerView.w paramw, int paramInt)
  {
    if ((paramw == this.ayr) && (paramInt == this.ayB)) {
      return;
    }
    this.ayM = -9223372036854775808L;
    int k = this.ayB;
    b(paramw, true);
    this.ayB = paramInt;
    if (paramInt == 2)
    {
      if (paramw == null) {
        throw new IllegalArgumentException("Must pass a ViewHolder when dragging");
      }
      this.ayH = paramw.asD;
      if (Build.VERSION.SDK_INT < 21)
      {
        if (this.aqW == null) {
          this.aqW = new RecyclerView.d()
          {
            public final int av(int paramAnonymousInt1, int paramAnonymousInt2)
            {
              if (a.this.ayH == null) {}
              int i;
              do
              {
                return paramAnonymousInt2;
                int j = a.this.ayI;
                i = j;
                if (j == -1)
                {
                  i = a.this.alu.indexOfChild(a.this.ayH);
                  a.this.ayI = i;
                }
                if (paramAnonymousInt2 == paramAnonymousInt1 - 1) {
                  return i;
                }
              } while (paramAnonymousInt2 < i);
              return paramAnonymousInt2 + 1;
            }
          };
        }
        this.alu.setChildDrawingOrderCallback(this.aqW);
      }
    }
    final int i = 0;
    int j = 0;
    Object localObject;
    int m;
    int n;
    float f1;
    float f2;
    if (this.ayr != null)
    {
      localObject = this.ayr;
      if (((RecyclerView.w)localObject).asD.getParent() == null) {
        break label740;
      }
      if ((k == 2) || (this.ayB == 2)) {
        break label612;
      }
      i = this.ayA.a(this.alu, (RecyclerView.w)localObject);
      m = (a.aQ(i, t.Y(this.alu)) & 0xFF00) >> 8;
      if (m == 0) {
        break label612;
      }
      n = (i & 0xFF00) >> 8;
      if (Math.abs(this.ayw) <= Math.abs(this.ayx)) {
        break label618;
      }
      j = df(m);
      if (j > 0)
      {
        i = j;
        if ((n & j) == 0) {
          i = a.aP(j, t.Y(this.alu));
        }
        mV();
      }
    }
    else
    {
      switch (i)
      {
      default: 
        f1 = 0.0F;
        f2 = 0.0F;
        label329:
        if (k == 2)
        {
          j = 8;
          label339:
          g(this.ayq);
          localObject = new c((RecyclerView.w)localObject, j, k, this.ayq[0], this.ayq[1], f1, f2)
          {
            public final void onAnimationEnd(Animator paramAnonymousAnimator)
            {
              super.onAnimationEnd(paramAnonymousAnimator);
              if (this.azc) {}
              for (;;)
              {
                return;
                if (i <= 0) {
                  a.this.ayA.d(a.this.alu, this.ayP);
                }
                while (a.this.ayH == this.ayP.asD)
                {
                  a.this.ch(this.ayP.asD);
                  return;
                  a.this.ayp.add(this.ayP.asD);
                  this.azb = true;
                  if (i > 0)
                  {
                    paramAnonymousAnimator = a.this;
                    int i = i;
                    paramAnonymousAnimator.alu.post(new a.4(paramAnonymousAnimator, this, i));
                  }
                }
              }
            }
          };
          long l = a.c(this.alu, j);
          ((c)localObject).ayZ.setDuration(l);
          this.ayD.add(localObject);
          ((c)localObject).arH.ax(false);
          ((c)localObject).ayZ.start();
          i = 1;
          this.ayr = null;
          if (paramw != null)
          {
            this.ayC = ((this.ayA.b(this.alu, paramw) & (1 << paramInt * 8 + 8) - 1) >> this.ayB * 8);
            this.ayy = paramw.asD.getLeft();
            this.ayz = paramw.asD.getTop();
            this.ayr = paramw;
            if (paramInt == 2) {
              this.ayr.asD.performHapticFeedback(0);
            }
          }
          paramw = this.alu.getParent();
          if (paramw != null) {
            if (this.ayr == null) {
              break label769;
            }
          }
        }
        label436:
        break;
      }
    }
    label769:
    for (boolean bool = true;; bool = false)
    {
      paramw.requestDisallowInterceptTouchEvent(bool);
      if (i == 0) {
        this.alu.getLayoutManager().li();
      }
      this.ayA.f(this.ayr, this.ayB);
      this.alu.invalidate();
      return;
      j = dg(m);
      i = j;
      if (j > 0) {
        break;
      }
      label612:
      label618:
      do
      {
        i = 0;
        break;
        j = dg(m);
        i = j;
        if (j > 0) {
          break;
        }
        j = df(m);
      } while (j <= 0);
      i = j;
      if ((n & j) != 0) {
        break;
      }
      i = a.aP(j, t.Y(this.alu));
      break;
      f2 = 0.0F;
      f1 = Math.signum(this.ayw) * this.alu.getWidth();
      break label329;
      f1 = 0.0F;
      f2 = Math.signum(this.ayx) * this.alu.getHeight();
      break label329;
      if (i > 0)
      {
        j = 2;
        break label339;
      }
      j = 4;
      break label339;
      label740:
      ch(((RecyclerView.w)localObject).asD);
      this.ayA.d(this.alu, (RecyclerView.w)localObject);
      i = j;
      break label436;
    }
  }
  
  final View j(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.ayr != null)
    {
      paramMotionEvent = this.ayr.asD;
      if (a(paramMotionEvent, f1, f2, this.ayy + this.ayw, this.ayz + this.ayx)) {
        return paramMotionEvent;
      }
    }
    int i = this.ayD.size() - 1;
    while (i >= 0)
    {
      paramMotionEvent = (c)this.ayD.get(i);
      View localView = paramMotionEvent.arH.asD;
      if (a(localView, f1, f2, paramMotionEvent.mX, paramMotionEvent.mY)) {
        return localView;
      }
      i -= 1;
    }
    return this.alu.o(f1, f2);
  }
  
  public final void j(RecyclerView paramRecyclerView)
  {
    if (this.alu == paramRecyclerView) {}
    do
    {
      return;
      if (this.alu != null)
      {
        this.alu.c(this);
        this.alu.b(this.ayL);
        Object localObject = this.alu;
        if (((RecyclerView)localObject).aqp != null) {
          ((RecyclerView)localObject).aqp.remove(this);
        }
        int i = this.ayD.size() - 1;
        while (i >= 0)
        {
          localObject = (c)this.ayD.get(0);
          this.ayA.d(this.alu, ((c)localObject).arH);
          i -= 1;
        }
        this.ayD.clear();
        this.ayH = null;
        this.ayI = -1;
        mV();
        if (this.ayK != null)
        {
          this.ayK.ayU = false;
          this.ayK = null;
        }
        if (this.ayJ != null) {
          this.ayJ = null;
        }
      }
      this.alu = paramRecyclerView;
    } while (paramRecyclerView == null);
    paramRecyclerView = paramRecyclerView.getResources();
    this.ayu = paramRecyclerView.getDimension(2131166464);
    this.ayv = paramRecyclerView.getDimension(2131166463);
    this.auQ = ViewConfiguration.get(this.alu.getContext()).getScaledTouchSlop();
    this.alu.a(this);
    this.alu.a(this.ayL);
    this.alu.a(this);
    this.ayK = new b();
    this.ayJ = new android.support.v4.view.c(this.alu.getContext(), this.ayK);
  }
  
  public final void mU()
  {
    if (this.mVelocityTracker != null) {
      this.mVelocityTracker.recycle();
    }
    this.mVelocityTracker = VelocityTracker.obtain();
  }
  
  public static abstract class a
  {
    private static final Interpolator ayR = new a.a.1();
    private static final Interpolator ayS = new a.a.2();
    private int ayT = -1;
    
    public static float Q(float paramFloat)
    {
      return paramFloat;
    }
    
    public static float R(float paramFloat)
    {
      return paramFloat;
    }
    
    public static RecyclerView.w a(RecyclerView.w paramw, List<RecyclerView.w> paramList, int paramInt1, int paramInt2)
    {
      int m = paramw.asD.getWidth();
      int n = paramw.asD.getHeight();
      int i = -1;
      int i1 = paramInt1 - paramw.asD.getLeft();
      int i2 = paramInt2 - paramw.asD.getTop();
      int i3 = paramList.size();
      int j = 0;
      Object localObject2 = null;
      Object localObject1;
      int k;
      if (j < i3)
      {
        localObject1 = (RecyclerView.w)paramList.get(j);
        if (i1 <= 0) {
          break label343;
        }
        k = ((RecyclerView.w)localObject1).asD.getRight() - (paramInt1 + m);
        if ((k >= 0) || (((RecyclerView.w)localObject1).asD.getRight() <= paramw.asD.getRight())) {
          break label343;
        }
        k = Math.abs(k);
        if (k <= i) {
          break label343;
        }
        localObject2 = localObject1;
        i = k;
        label142:
        if (i1 >= 0) {
          break label356;
        }
        k = ((RecyclerView.w)localObject1).asD.getLeft() - paramInt1;
        if ((k <= 0) || (((RecyclerView.w)localObject1).asD.getLeft() >= paramw.asD.getLeft())) {
          break label356;
        }
        k = Math.abs(k);
        if (k <= i) {
          break label356;
        }
        localObject2 = localObject1;
        i = k;
      }
      label343:
      label356:
      for (;;)
      {
        if (i2 < 0)
        {
          k = ((RecyclerView.w)localObject1).asD.getTop() - paramInt2;
          if ((k > 0) && (((RecyclerView.w)localObject1).asD.getTop() < paramw.asD.getTop()))
          {
            k = Math.abs(k);
            if (k > i)
            {
              localObject2 = localObject1;
              i = k;
            }
          }
        }
        for (;;)
        {
          if (i2 > 0)
          {
            k = ((RecyclerView.w)localObject1).asD.getBottom() - (paramInt2 + n);
            if ((k < 0) && (((RecyclerView.w)localObject1).asD.getBottom() > paramw.asD.getBottom()))
            {
              k = Math.abs(k);
              if (k > i) {
                i = k;
              }
            }
          }
          for (;;)
          {
            j += 1;
            localObject2 = localObject1;
            break;
            return localObject2;
            break label142;
            localObject1 = localObject2;
          }
        }
      }
    }
    
    public static void a(RecyclerView paramRecyclerView, RecyclerView.w paramw1, RecyclerView.w paramw2, int paramInt)
    {
      RecyclerView.i locali = paramRecyclerView.getLayoutManager();
      if ((locali instanceof a.d)) {
        ((a.d)locali).e(paramw1.asD, paramw2.asD);
      }
      do
      {
        do
        {
          return;
          if (locali.jM())
          {
            if (RecyclerView.i.bG(paramw2.asD) <= paramRecyclerView.getPaddingLeft())
            {
              paramw1 = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
              com.tencent.mm.hellhoundlib.a.a.a(paramRecyclerView, paramw1.aeD(), "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
              paramRecyclerView.ca(((Integer)paramw1.lR(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.a(paramRecyclerView, "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
            }
            if (RecyclerView.i.bI(paramw2.asD) >= paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight())
            {
              paramw1 = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
              com.tencent.mm.hellhoundlib.a.a.a(paramRecyclerView, paramw1.aeD(), "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
              paramRecyclerView.ca(((Integer)paramw1.lR(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.a(paramRecyclerView, "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
            }
          }
        } while (!locali.jN());
        if (RecyclerView.i.bH(paramw2.asD) <= paramRecyclerView.getPaddingTop())
        {
          paramw1 = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(paramRecyclerView, paramw1.aeD(), "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
          paramRecyclerView.ca(((Integer)paramw1.lR(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(paramRecyclerView, "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
        }
      } while (RecyclerView.i.bJ(paramw2.asD) < paramRecyclerView.getHeight() - paramRecyclerView.getPaddingBottom());
      paramw1 = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(paramRecyclerView, paramw1.aeD(), "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
      paramRecyclerView.ca(((Integer)paramw1.lR(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramRecyclerView, "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
    }
    
    public static int aP(int paramInt1, int paramInt2)
    {
      int i = paramInt1 & 0xC0C0C;
      if (i == 0) {
        return paramInt1;
      }
      paramInt1 = (i ^ 0xFFFFFFFF) & paramInt1;
      if (paramInt2 == 0) {
        return paramInt1 | i << 2;
      }
      return paramInt1 | i << 1 & 0xFFF3F3F3 | (i << 1 & 0xC0C0C) << 2;
    }
    
    public static int aQ(int paramInt1, int paramInt2)
    {
      int i = paramInt1 & 0x303030;
      if (i == 0) {
        return paramInt1;
      }
      paramInt1 = (i ^ 0xFFFFFFFF) & paramInt1;
      if (paramInt2 == 0) {
        return paramInt1 | i >> 2;
      }
      return paramInt1 | i >> 1 & 0xFFCFCFCF | (i >> 1 & 0x303030) >> 2;
    }
    
    public static long c(RecyclerView paramRecyclerView, int paramInt)
    {
      paramRecyclerView = paramRecyclerView.getItemAnimator();
      if (paramRecyclerView == null)
      {
        if (paramInt == 8) {
          return 200L;
        }
        return 250L;
      }
      if (paramInt == 8) {
        return paramRecyclerView.arm;
      }
      return paramRecyclerView.kY();
    }
    
    public static int dh(int paramInt)
    {
      return (paramInt | 0x0) << 0 | 0x0 | paramInt << 16;
    }
    
    private int k(RecyclerView paramRecyclerView)
    {
      if (this.ayT == -1) {
        this.ayT = paramRecyclerView.getResources().getDimensionPixelSize(2131166462);
      }
      return this.ayT;
    }
    
    public static void mY()
    {
      b localb = c.azf;
    }
    
    public float K(RecyclerView.w paramw)
    {
      return 0.5F;
    }
    
    public abstract void L(RecyclerView.w paramw);
    
    public final int a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, long paramLong)
    {
      float f1 = 1.0F;
      int i = k(paramRecyclerView);
      int j = Math.abs(paramInt2);
      int k = (int)Math.signum(paramInt2);
      float f2 = Math.min(1.0F, j * 1.0F / paramInt1);
      paramInt1 = (int)(i * k * ayS.getInterpolation(f2));
      if (paramLong > 2000L) {}
      for (;;)
      {
        f2 = paramInt1;
        i = (int)(ayR.getInterpolation(f1) * f2);
        paramInt1 = i;
        if (i == 0)
        {
          if (paramInt2 <= 0) {
            break;
          }
          paramInt1 = 1;
        }
        return paramInt1;
        f1 = (float)paramLong / 2000.0F;
      }
      return -1;
    }
    
    public abstract int a(RecyclerView paramRecyclerView, RecyclerView.w paramw);
    
    public void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.w paramw, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
    {
      c.azf.a(paramRecyclerView, paramw.asD, paramFloat1, paramFloat2, paramBoolean);
    }
    
    public abstract boolean a(RecyclerView paramRecyclerView, RecyclerView.w paramw1, RecyclerView.w paramw2);
    
    final int b(RecyclerView paramRecyclerView, RecyclerView.w paramw)
    {
      return aQ(a(paramRecyclerView, paramw), t.Y(paramRecyclerView));
    }
    
    public final boolean c(RecyclerView paramRecyclerView, RecyclerView.w paramw)
    {
      return (b(paramRecyclerView, paramw) & 0xFF0000) != 0;
    }
    
    public void d(RecyclerView paramRecyclerView, RecyclerView.w paramw)
    {
      c.azf.ci(paramw.asD);
    }
    
    public void f(RecyclerView.w paramw, int paramInt)
    {
      if (paramw != null) {
        paramw = c.azf;
      }
    }
    
    public boolean mW()
    {
      return true;
    }
    
    public boolean mX()
    {
      return true;
    }
  }
  
  final class b
    extends GestureDetector.SimpleOnGestureListener
  {
    boolean ayU = true;
    
    b() {}
    
    public final boolean onDown(MotionEvent paramMotionEvent)
    {
      return true;
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      if (!this.ayU) {}
      Object localObject;
      do
      {
        do
        {
          do
          {
            return;
            localObject = a.this.j(paramMotionEvent);
          } while (localObject == null);
          localObject = a.this.alu.bh((View)localObject);
        } while ((localObject == null) || (!a.this.ayA.c(a.this.alu, (RecyclerView.w)localObject)) || (paramMotionEvent.getPointerId(0) != a.this.mActivePointerId));
        int i = paramMotionEvent.findPointerIndex(a.this.mActivePointerId);
        float f1 = paramMotionEvent.getX(i);
        float f2 = paramMotionEvent.getY(i);
        a.this.ays = f1;
        a.this.ayt = f2;
        paramMotionEvent = a.this;
        a.this.ayx = 0.0F;
        paramMotionEvent.ayw = 0.0F;
      } while (!a.this.ayA.mW());
      a.this.e((RecyclerView.w)localObject, 2);
    }
  }
  
  static class c
    implements Animator.AnimatorListener
  {
    boolean AD = false;
    final RecyclerView.w arH;
    final int ayB;
    final float ayV;
    final float ayW;
    final float ayX;
    final float ayY;
    final ValueAnimator ayZ;
    final int aza;
    boolean azb;
    boolean azc = false;
    float azd;
    float mX;
    float mY;
    
    c(RecyclerView.w paramw, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.ayB = paramInt2;
      this.aza = paramInt1;
      this.arH = paramw;
      this.ayV = paramFloat1;
      this.ayW = paramFloat2;
      this.ayX = paramFloat3;
      this.ayY = paramFloat4;
      this.ayZ = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.ayZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          a.c.this.azd = paramAnonymousValueAnimator.getAnimatedFraction();
        }
      });
      this.ayZ.setTarget(paramw.asD);
      this.ayZ.addListener(this);
      this.azd = 0.0F;
    }
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      this.azd = 1.0F;
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (!this.AD) {
        this.arH.ax(true);
      }
      this.AD = true;
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.a.a
 * JD-Core Version:    0.7.0.1
 */