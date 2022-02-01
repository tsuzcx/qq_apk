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
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
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
  Rect Rm;
  public RecyclerView akA;
  private RecyclerView.d aqb = null;
  private int atV;
  private float axA;
  private float axB;
  public float axC;
  public float axD;
  float axE;
  float axF;
  public a axG;
  private int axH = 0;
  int axI;
  List<c> axJ = new ArrayList();
  final Runnable axK = new Runnable()
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
      if (a.this.axx != null)
      {
        locala = a.this;
        if (locala.axx == null) {
          break label550;
        }
        l2 = System.currentTimeMillis();
        if (locala.axS != -9223372036854775808L) {
          break label409;
        }
        l1 = 0L;
        localObject = locala.akA.getLayoutManager();
        if (locala.Rm == null) {
          locala.Rm = new Rect();
        }
        ((RecyclerView.i)localObject).f(locala.axx.arI, locala.Rm);
        if (!((RecyclerView.i)localObject).jE()) {
          break label479;
        }
        j = (int)(locala.axE + locala.axC);
        i = j - locala.Rm.left - locala.akA.getPaddingLeft();
        if ((locala.axC >= 0.0F) || (i >= 0)) {
          break label422;
        }
        if (!((RecyclerView.i)localObject).jF()) {
          break label545;
        }
        m = (int)(locala.axF + locala.axD);
        j = m - locala.Rm.top - locala.akA.getPaddingTop();
        if ((locala.axD >= 0.0F) || (j >= 0)) {
          break label484;
        }
        if (i == 0) {
          break label566;
        }
        localObject = locala.axG;
        localRecyclerView = locala.akA;
        m = locala.axx.arI.getWidth();
        locala.akA.getWidth();
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
          localObject = locala.axG;
          localRecyclerView = locala.akA;
          m = locala.axx.arI.getHeight();
          locala.akA.getHeight();
          j = ((a.a)localObject).a(localRecyclerView, m, j, l1);
        }
        for (;;)
        {
          if ((i != 0) || (j != 0))
          {
            if (locala.axS == -9223372036854775808L) {
              locala.axS = l2;
            }
            locala.akA.scrollBy(i, j);
          }
          for (i = 1;; i = k)
          {
            if (i != 0)
            {
              if (a.this.axx != null) {
                a.this.J(a.this.axx);
              }
              a.this.akA.removeCallbacks(a.this.axK);
              t.b(a.this.akA, this);
            }
            return;
            l1 = l2 - locala.axS;
            break;
            if (locala.axC > 0.0F)
            {
              j = j + locala.axx.arI.getWidth() + locala.Rm.right - (locala.akA.getWidth() - locala.akA.getPaddingRight());
              i = j;
              if (j > 0) {
                break label149;
              }
            }
            label479:
            i = 0;
            break label149;
            label484:
            if (locala.axD > 0.0F)
            {
              m = m + locala.axx.arI.getHeight() + locala.Rm.bottom - (locala.akA.getHeight() - locala.akA.getPaddingBottom());
              j = m;
              if (m > 0) {
                break label206;
              }
            }
            j = 0;
            break label206;
            locala.axS = -9223372036854775808L;
          }
        }
      }
    }
  };
  private List<RecyclerView.v> axL;
  private List<Integer> axM;
  View axN = null;
  int axO = -1;
  android.support.v4.view.c axP;
  private b axQ;
  private final RecyclerView.l axR = new RecyclerView.l()
  {
    public final boolean a(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
    {
      a.this.axP.onTouchEvent(paramAnonymousMotionEvent);
      int i = paramAnonymousMotionEvent.getActionMasked();
      if (i == 0)
      {
        a.this.mActivePointerId = paramAnonymousMotionEvent.getPointerId(0);
        a.this.axy = paramAnonymousMotionEvent.getX();
        a.this.axz = paramAnonymousMotionEvent.getY();
        a.this.mK();
        if (a.this.axx == null)
        {
          a locala = a.this;
          if (locala.axJ.isEmpty()) {
            break label315;
          }
          View localView = locala.l(paramAnonymousMotionEvent);
          i = locala.axJ.size() - 1;
          if (i < 0) {
            break label315;
          }
          paramAnonymousRecyclerView = (a.c)locala.axJ.get(i);
          if (paramAnonymousRecyclerView.aqL.arI != localView) {
            break label308;
          }
          label143:
          if (paramAnonymousRecyclerView != null)
          {
            locala = a.this;
            locala.axy -= paramAnonymousRecyclerView.mX;
            locala = a.this;
            locala.axz -= paramAnonymousRecyclerView.mY;
            a.this.b(paramAnonymousRecyclerView.aqL, true);
            if (a.this.axv.remove(paramAnonymousRecyclerView.aqL.arI)) {
              a.this.axG.d(a.this.akA, paramAnonymousRecyclerView.aqL);
            }
            a.this.e(paramAnonymousRecyclerView.aqL, paramAnonymousRecyclerView.axH);
            a.this.a(paramAnonymousMotionEvent, a.this.axI, 0);
          }
        }
      }
      for (;;)
      {
        if (a.this.mVelocityTracker != null) {
          a.this.mVelocityTracker.addMovement(paramAnonymousMotionEvent);
        }
        if (a.this.axx == null) {
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
      a.this.axP.onTouchEvent(paramAnonymousMotionEvent);
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
          paramAnonymousRecyclerView = a.this.axx;
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
            a.this.a(paramAnonymousMotionEvent, a.this.axI, k);
            a.this.J(paramAnonymousRecyclerView);
            a.this.akA.removeCallbacks(a.this.axK);
            a.this.axK.run();
            a.this.akA.invalidate();
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
      a.this.a(paramAnonymousMotionEvent, a.this.axI, j);
    }
  };
  long axS;
  final List<View> axv = new ArrayList();
  private final float[] axw = new float[2];
  RecyclerView.v axx = null;
  float axy;
  float axz;
  int mActivePointerId = -1;
  VelocityTracker mVelocityTracker;
  
  public a(a parama)
  {
    this.axG = parama;
  }
  
  private static boolean a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (paramFloat1 >= paramFloat3) && (paramFloat1 <= paramView.getWidth() + paramFloat3) && (paramFloat2 >= paramFloat4) && (paramFloat2 <= paramView.getHeight() + paramFloat4);
  }
  
  private int dg(int paramInt)
  {
    int j = 8;
    if ((paramInt & 0xC) != 0)
    {
      int i;
      float f2;
      if (this.axC > 0.0F)
      {
        i = 8;
        if ((this.mVelocityTracker == null) || (this.mActivePointerId < 0)) {
          break label140;
        }
        this.mVelocityTracker.computeCurrentVelocity(1000, a.N(this.axB));
        f2 = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
        f1 = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
        if (f2 <= 0.0F) {
          break label134;
        }
      }
      for (;;)
      {
        f2 = Math.abs(f2);
        if (((j & paramInt) == 0) || (i != j) || (f2 < a.M(this.axA)) || (f2 <= Math.abs(f1))) {
          break label140;
        }
        return j;
        i = 4;
        break;
        label134:
        j = 4;
      }
      label140:
      float f1 = this.akA.getWidth();
      if (((paramInt & i) != 0) && (Math.abs(this.axC) > f1 * 0.5F)) {
        return i;
      }
    }
    return 0;
  }
  
  private int dh(int paramInt)
  {
    int j = 2;
    if ((paramInt & 0x3) != 0)
    {
      int i;
      float f2;
      if (this.axD > 0.0F)
      {
        i = 2;
        if ((this.mVelocityTracker == null) || (this.mActivePointerId < 0)) {
          break label137;
        }
        this.mVelocityTracker.computeCurrentVelocity(1000, a.N(this.axB));
        f1 = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
        f2 = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
        if (f2 <= 0.0F) {
          break label131;
        }
      }
      for (;;)
      {
        f2 = Math.abs(f2);
        if (((j & paramInt) == 0) || (j != i) || (f2 < a.M(this.axA)) || (f2 <= Math.abs(f1))) {
          break label137;
        }
        return j;
        i = 1;
        break;
        label131:
        j = 1;
      }
      label137:
      float f1 = this.akA.getHeight();
      if (((paramInt & i) != 0) && (Math.abs(this.axD) > f1 * 0.5F)) {
        return i;
      }
    }
    return 0;
  }
  
  private void g(float[] paramArrayOfFloat)
  {
    if ((this.axI & 0xC) != 0) {
      paramArrayOfFloat[0] = (this.axE + this.axC - this.axx.arI.getLeft());
    }
    while ((this.axI & 0x3) != 0)
    {
      paramArrayOfFloat[1] = (this.axF + this.axD - this.axx.arI.getTop());
      return;
      paramArrayOfFloat[0] = this.axx.arI.getTranslationX();
    }
    paramArrayOfFloat[1] = this.axx.arI.getTranslationY();
  }
  
  private void mL()
  {
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  final void J(RecyclerView.v paramv)
  {
    if (this.akA.isLayoutRequested()) {}
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
          } while (this.axH != 2);
          f = this.axG.K(paramv);
          m = (int)(this.axE + this.axC);
          n = (int)(this.axF + this.axD);
        } while ((Math.abs(n - paramv.arI.getTop()) < paramv.arI.getHeight() * f) && (Math.abs(m - paramv.arI.getLeft()) < f * paramv.arI.getWidth()));
        int i1;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        if (this.axL == null)
        {
          this.axL = new ArrayList();
          this.axM = new ArrayList();
          i1 = Math.round(this.axE + this.axC) + 0;
          i2 = Math.round(this.axF + this.axD) + 0;
          i3 = paramv.arI.getWidth() + i1 + 0;
          i4 = paramv.arI.getHeight() + i2 + 0;
          i5 = (i1 + i3) / 2;
          i6 = (i2 + i4) / 2;
          localObject = this.akA.getLayoutManager();
          i7 = ((RecyclerView.i)localObject).getChildCount();
          i = 0;
        }
        for (;;)
        {
          if (i >= i7) {
            break label484;
          }
          View localView = ((RecyclerView.i)localObject).getChildAt(i);
          if ((localView != paramv.arI) && (localView.getBottom() >= i2) && (localView.getTop() <= i4) && (localView.getRight() >= i1) && (localView.getLeft() <= i3))
          {
            RecyclerView.v localv = this.akA.bh(localView);
            int j = Math.abs(i5 - (localView.getLeft() + localView.getRight()) / 2);
            int k = localView.getTop();
            k = Math.abs(i6 - (localView.getBottom() + k) / 2);
            int i8 = j * j + k * k;
            k = 0;
            int i9 = this.axL.size();
            j = 0;
            for (;;)
            {
              if ((j < i9) && (i8 > ((Integer)this.axM.get(j)).intValue()))
              {
                k += 1;
                j += 1;
                continue;
                this.axL.clear();
                this.axM.clear();
                break;
              }
            }
            this.axL.add(k, localv);
            this.axM.add(k, Integer.valueOf(i8));
          }
          i += 1;
        }
        localObject = this.axL;
      } while (((List)localObject).size() == 0);
      localObject = a.a(paramv, (List)localObject, m, n);
      if (localObject == null)
      {
        this.axL.clear();
        this.axM.clear();
        return;
      }
      i = ((RecyclerView.v)localObject).ln();
      paramv.ln();
    } while (!this.axG.a(this.akA, paramv, (RecyclerView.v)localObject));
    a.a(this.akA, paramv, (RecyclerView.v)localObject, i);
  }
  
  final void a(int paramInt1, MotionEvent paramMotionEvent, int paramInt2)
  {
    Object localObject2 = null;
    if ((this.axx != null) || (paramInt1 != 2) || (this.axH == 2) || (!this.axG.mN())) {}
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
          } while (this.akA.getScrollState() == 1);
          localObject3 = this.akA.getLayoutManager();
          if (this.mActivePointerId != -1) {
            break;
          }
          localObject1 = localObject2;
          if (localObject1 == null) {
            break label375;
          }
          paramInt1 = (this.axG.b(this.akA, (RecyclerView.v)localObject1) & 0xFF00) >> 8;
        } while (paramInt1 == 0);
        f1 = paramMotionEvent.getX(paramInt2);
        f2 = paramMotionEvent.getY(paramInt2);
        f1 -= this.axy;
        f2 -= this.axz;
        f3 = Math.abs(f1);
        f4 = Math.abs(f2);
      } while ((f3 < this.atV) && (f4 < this.atV));
      if (f3 <= f4) {
        break label377;
      }
    } while (((f1 < 0.0F) && ((paramInt1 & 0x4) == 0)) || ((f1 > 0.0F) && ((paramInt1 & 0x8) == 0)));
    label375:
    label377:
    do
    {
      this.axD = 0.0F;
      this.axC = 0.0F;
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      e((RecyclerView.v)localObject1, 1);
      return;
      paramInt1 = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      f3 = paramMotionEvent.getX(paramInt1);
      f4 = this.axy;
      f1 = paramMotionEvent.getY(paramInt1);
      f2 = this.axz;
      f3 = Math.abs(f3 - f4);
      f1 = Math.abs(f1 - f2);
      if (f3 < this.atV)
      {
        localObject1 = localObject2;
        if (f1 < this.atV) {
          break label66;
        }
      }
      if (f3 > f1)
      {
        localObject1 = localObject2;
        if (((RecyclerView.i)localObject3).jE()) {
          break label66;
        }
      }
      if (f1 > f3)
      {
        localObject1 = localObject2;
        if (((RecyclerView.i)localObject3).jF()) {
          break label66;
        }
      }
      localObject3 = l(paramMotionEvent);
      localObject1 = localObject2;
      if (localObject3 == null) {
        break label66;
      }
      localObject1 = this.akA.bh((View)localObject3);
      break label66;
      break label33;
      if ((f2 < 0.0F) && ((paramInt1 & 0x1) == 0)) {
        break;
      }
    } while ((f2 <= 0.0F) || ((paramInt1 & 0x2) != 0));
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    this.axO = -1;
    float f2;
    float f1;
    if (this.axx != null)
    {
      g(this.axw);
      f2 = this.axw[0];
      f1 = this.axw[1];
    }
    for (;;)
    {
      params = this.axG;
      RecyclerView.v localv = this.axx;
      List localList = this.axJ;
      int j = this.axH;
      int k = localList.size();
      int i = 0;
      if (i < k)
      {
        c localc = (c)localList.get(i);
        if (localc.ayb == localc.ayd)
        {
          localc.mX = localc.aqL.arI.getTranslationX();
          label122:
          if (localc.ayc != localc.aye) {
            break label231;
          }
        }
        label231:
        for (localc.mY = localc.aqL.arI.getTranslationY();; localc.mY = (localc.ayc + localc.ayj * (localc.aye - localc.ayc)))
        {
          int m = paramCanvas.save();
          params.a(paramCanvas, paramRecyclerView, localc.aqL, localc.mX, localc.mY, localc.axH, false);
          paramCanvas.restoreToCount(m);
          i += 1;
          break;
          localc.mX = (localc.ayb + localc.ayj * (localc.ayd - localc.ayb));
          break label122;
        }
      }
      if (localv != null)
      {
        i = paramCanvas.save();
        params.a(paramCanvas, paramRecyclerView, localv, f2, f1, j, true);
        paramCanvas.restoreToCount(i);
      }
      return;
      f1 = 0.0F;
      f2 = 0.0F;
    }
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    paramRect.setEmpty();
  }
  
  final void a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    float f1 = paramMotionEvent.getX(paramInt2);
    float f2 = paramMotionEvent.getY(paramInt2);
    this.axC = (f1 - this.axy);
    this.axD = (f2 - this.axz);
    if ((paramInt1 & 0x4) == 0) {
      this.axC = Math.max(0.0F, this.axC);
    }
    if ((paramInt1 & 0x8) == 0) {
      this.axC = Math.min(0.0F, this.axC);
    }
    if ((paramInt1 & 0x1) == 0) {
      this.axD = Math.max(0.0F, this.axD);
    }
    if ((paramInt1 & 0x2) == 0) {
      this.axD = Math.min(0.0F, this.axD);
    }
  }
  
  public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    int k = 0;
    if (this.axx != null) {
      g(this.axw);
    }
    RecyclerView.v localv = this.axx;
    params = this.axJ;
    int j = params.size();
    int i = 0;
    while (i < j)
    {
      params.get(i);
      int m = paramCanvas.save();
      a.mO();
      paramCanvas.restoreToCount(m);
      i += 1;
    }
    if (localv != null)
    {
      i = paramCanvas.save();
      a.mO();
      paramCanvas.restoreToCount(i);
    }
    j -= 1;
    i = k;
    if (j >= 0)
    {
      paramCanvas = (c)params.get(j);
      if ((paramCanvas.zF) && (!paramCanvas.ayh)) {
        params.remove(j);
      }
    }
    for (;;)
    {
      j -= 1;
      break;
      if (!paramCanvas.zF)
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
  
  final void b(RecyclerView.v paramv, boolean paramBoolean)
  {
    int i = this.axJ.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        c localc = (c)this.axJ.get(i);
        if (localc.aqL == paramv)
        {
          localc.ayi |= paramBoolean;
          if (!localc.zF) {
            localc.ayf.cancel();
          }
          this.axJ.remove(i);
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
    paramView = this.akA.bh(paramView);
    if (paramView == null) {}
    do
    {
      return;
      if ((this.axx != null) && (paramView == this.axx))
      {
        e(null, 0);
        return;
      }
      b(paramView, false);
    } while (!this.axv.remove(paramView.arI));
    this.axG.d(this.akA, paramView);
  }
  
  final void ch(View paramView)
  {
    if (paramView == this.axN)
    {
      this.axN = null;
      if (this.aqb != null) {
        this.akA.setChildDrawingOrderCallback(null);
      }
    }
  }
  
  public final void e(RecyclerView.v paramv, int paramInt)
  {
    if ((paramv == this.axx) && (paramInt == this.axH)) {
      return;
    }
    this.axS = -9223372036854775808L;
    int k = this.axH;
    b(paramv, true);
    this.axH = paramInt;
    if (paramInt == 2)
    {
      if (paramv == null) {
        throw new IllegalArgumentException("Must pass a ViewHolder when dragging");
      }
      this.axN = paramv.arI;
      if (Build.VERSION.SDK_INT < 21)
      {
        if (this.aqb == null) {
          this.aqb = new RecyclerView.d()
          {
            public final int av(int paramAnonymousInt1, int paramAnonymousInt2)
            {
              if (a.this.axN == null) {}
              int i;
              do
              {
                return paramAnonymousInt2;
                int j = a.this.axO;
                i = j;
                if (j == -1)
                {
                  i = a.this.akA.indexOfChild(a.this.axN);
                  a.this.axO = i;
                }
                if (paramAnonymousInt2 == paramAnonymousInt1 - 1) {
                  return i;
                }
              } while (paramAnonymousInt2 < i);
              return paramAnonymousInt2 + 1;
            }
          };
        }
        this.akA.setChildDrawingOrderCallback(this.aqb);
      }
    }
    final int i = 0;
    int j = 0;
    Object localObject;
    int m;
    int n;
    float f1;
    float f2;
    if (this.axx != null)
    {
      localObject = this.axx;
      if (((RecyclerView.v)localObject).arI.getParent() == null) {
        break label740;
      }
      if ((k == 2) || (this.axH == 2)) {
        break label612;
      }
      i = this.axG.a(this.akA, (RecyclerView.v)localObject);
      m = (a.aQ(i, t.Y(this.akA)) & 0xFF00) >> 8;
      if (m == 0) {
        break label612;
      }
      n = (i & 0xFF00) >> 8;
      if (Math.abs(this.axC) <= Math.abs(this.axD)) {
        break label618;
      }
      j = dg(m);
      if (j > 0)
      {
        i = j;
        if ((n & j) == 0) {
          i = a.aP(j, t.Y(this.akA));
        }
        mL();
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
          g(this.axw);
          localObject = new c((RecyclerView.v)localObject, j, k, this.axw[0], this.axw[1], f1, f2)
          {
            public final void onAnimationEnd(Animator paramAnonymousAnimator)
            {
              super.onAnimationEnd(paramAnonymousAnimator);
              if (this.ayi) {}
              for (;;)
              {
                return;
                if (i <= 0) {
                  a.this.axG.d(a.this.akA, this.axV);
                }
                while (a.this.axN == this.axV.arI)
                {
                  a.this.ch(this.axV.arI);
                  return;
                  a.this.axv.add(this.axV.arI);
                  this.ayh = true;
                  if (i > 0)
                  {
                    paramAnonymousAnimator = a.this;
                    int i = i;
                    paramAnonymousAnimator.akA.post(new a.4(paramAnonymousAnimator, this, i));
                  }
                }
              }
            }
          };
          long l = a.c(this.akA, j);
          ((c)localObject).ayf.setDuration(l);
          this.axJ.add(localObject);
          ((c)localObject).aqL.ax(false);
          ((c)localObject).ayf.start();
          i = 1;
          this.axx = null;
          if (paramv != null)
          {
            this.axI = ((this.axG.b(this.akA, paramv) & (1 << paramInt * 8 + 8) - 1) >> this.axH * 8);
            this.axE = paramv.arI.getLeft();
            this.axF = paramv.arI.getTop();
            this.axx = paramv;
            if (paramInt == 2) {
              this.axx.arI.performHapticFeedback(0);
            }
          }
          paramv = this.akA.getParent();
          if (paramv != null) {
            if (this.axx == null) {
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
      paramv.requestDisallowInterceptTouchEvent(bool);
      if (i == 0) {
        this.akA.getLayoutManager().la();
      }
      this.axG.f(this.axx, this.axH);
      this.akA.invalidate();
      return;
      j = dh(m);
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
        j = dh(m);
        i = j;
        if (j > 0) {
          break;
        }
        j = dg(m);
      } while (j <= 0);
      i = j;
      if ((n & j) != 0) {
        break;
      }
      i = a.aP(j, t.Y(this.akA));
      break;
      f2 = 0.0F;
      f1 = Math.signum(this.axC) * this.akA.getWidth();
      break label329;
      f1 = 0.0F;
      f2 = Math.signum(this.axD) * this.akA.getHeight();
      break label329;
      if (i > 0)
      {
        j = 2;
        break label339;
      }
      j = 4;
      break label339;
      label740:
      ch(((RecyclerView.v)localObject).arI);
      this.axG.d(this.akA, (RecyclerView.v)localObject);
      i = j;
      break label436;
    }
  }
  
  public final void j(RecyclerView paramRecyclerView)
  {
    if (this.akA == paramRecyclerView) {}
    do
    {
      return;
      if (this.akA != null)
      {
        this.akA.c(this);
        this.akA.b(this.axR);
        Object localObject = this.akA;
        if (((RecyclerView)localObject).apu != null) {
          ((RecyclerView)localObject).apu.remove(this);
        }
        int i = this.axJ.size() - 1;
        while (i >= 0)
        {
          localObject = (c)this.axJ.get(0);
          this.axG.d(this.akA, ((c)localObject).aqL);
          i -= 1;
        }
        this.axJ.clear();
        this.axN = null;
        this.axO = -1;
        mL();
        if (this.axQ != null)
        {
          this.axQ.aya = false;
          this.axQ = null;
        }
        if (this.axP != null) {
          this.axP = null;
        }
      }
      this.akA = paramRecyclerView;
    } while (paramRecyclerView == null);
    paramRecyclerView = paramRecyclerView.getResources();
    this.axA = paramRecyclerView.getDimension(2131166464);
    this.axB = paramRecyclerView.getDimension(2131166463);
    this.atV = ViewConfiguration.get(this.akA.getContext()).getScaledTouchSlop();
    this.akA.a(this);
    this.akA.a(this.axR);
    this.akA.a(this);
    this.axQ = new b();
    this.axP = new android.support.v4.view.c(this.akA.getContext(), this.axQ);
  }
  
  final View l(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.axx != null)
    {
      paramMotionEvent = this.axx.arI;
      if (a(paramMotionEvent, f1, f2, this.axE + this.axC, this.axF + this.axD)) {
        return paramMotionEvent;
      }
    }
    int i = this.axJ.size() - 1;
    while (i >= 0)
    {
      paramMotionEvent = (c)this.axJ.get(i);
      View localView = paramMotionEvent.aqL.arI;
      if (a(localView, f1, f2, paramMotionEvent.mX, paramMotionEvent.mY)) {
        return localView;
      }
      i -= 1;
    }
    return this.akA.o(f1, f2);
  }
  
  public final void mK()
  {
    if (this.mVelocityTracker != null) {
      this.mVelocityTracker.recycle();
    }
    this.mVelocityTracker = VelocityTracker.obtain();
  }
  
  public static abstract class a
  {
    private static final Interpolator axX = new Interpolator()
    {
      public final float getInterpolation(float paramAnonymousFloat)
      {
        return paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat;
      }
    };
    private static final Interpolator axY = new Interpolator()
    {
      public final float getInterpolation(float paramAnonymousFloat)
      {
        paramAnonymousFloat -= 1.0F;
        return paramAnonymousFloat * (paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat) + 1.0F;
      }
    };
    private int axZ = -1;
    
    public static float M(float paramFloat)
    {
      return paramFloat;
    }
    
    public static float N(float paramFloat)
    {
      return paramFloat;
    }
    
    public static RecyclerView.v a(RecyclerView.v paramv, List<RecyclerView.v> paramList, int paramInt1, int paramInt2)
    {
      int m = paramv.arI.getWidth();
      int n = paramv.arI.getHeight();
      int i = -1;
      int i1 = paramInt1 - paramv.arI.getLeft();
      int i2 = paramInt2 - paramv.arI.getTop();
      int i3 = paramList.size();
      int j = 0;
      Object localObject2 = null;
      Object localObject1;
      int k;
      if (j < i3)
      {
        localObject1 = (RecyclerView.v)paramList.get(j);
        if (i1 <= 0) {
          break label343;
        }
        k = ((RecyclerView.v)localObject1).arI.getRight() - (paramInt1 + m);
        if ((k >= 0) || (((RecyclerView.v)localObject1).arI.getRight() <= paramv.arI.getRight())) {
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
        k = ((RecyclerView.v)localObject1).arI.getLeft() - paramInt1;
        if ((k <= 0) || (((RecyclerView.v)localObject1).arI.getLeft() >= paramv.arI.getLeft())) {
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
          k = ((RecyclerView.v)localObject1).arI.getTop() - paramInt2;
          if ((k > 0) && (((RecyclerView.v)localObject1).arI.getTop() < paramv.arI.getTop()))
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
            k = ((RecyclerView.v)localObject1).arI.getBottom() - (paramInt2 + n);
            if ((k < 0) && (((RecyclerView.v)localObject1).arI.getBottom() > paramv.arI.getBottom()))
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
    
    public static void a(RecyclerView paramRecyclerView, RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt)
    {
      RecyclerView.i locali = paramRecyclerView.getLayoutManager();
      if ((locali instanceof a.d)) {
        ((a.d)locali).e(paramv1.arI, paramv2.arI);
      }
      do
      {
        do
        {
          return;
          if (locali.jE())
          {
            if (RecyclerView.i.bG(paramv2.arI) <= paramRecyclerView.getPaddingLeft())
            {
              paramv1 = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
              com.tencent.mm.hellhoundlib.a.a.a(paramRecyclerView, paramv1.adn(), "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
              paramRecyclerView.ca(((Integer)paramv1.lS(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.a(paramRecyclerView, "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
            }
            if (RecyclerView.i.bI(paramv2.arI) >= paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight())
            {
              paramv1 = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
              com.tencent.mm.hellhoundlib.a.a.a(paramRecyclerView, paramv1.adn(), "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
              paramRecyclerView.ca(((Integer)paramv1.lS(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.a(paramRecyclerView, "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
            }
          }
        } while (!locali.jF());
        if (RecyclerView.i.bH(paramv2.arI) <= paramRecyclerView.getPaddingTop())
        {
          paramv1 = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(paramRecyclerView, paramv1.adn(), "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
          paramRecyclerView.ca(((Integer)paramv1.lS(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(paramRecyclerView, "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
        }
      } while (RecyclerView.i.bJ(paramv2.arI) < paramRecyclerView.getHeight() - paramRecyclerView.getPaddingBottom());
      paramv1 = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(paramRecyclerView, paramv1.adn(), "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
      paramRecyclerView.ca(((Integer)paramv1.lS(0)).intValue());
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
        return paramRecyclerView.aqr;
      }
      return paramRecyclerView.kQ();
    }
    
    public static int di(int paramInt)
    {
      return (paramInt | 0x0) << 0 | 0x0 | paramInt << 16;
    }
    
    private int k(RecyclerView paramRecyclerView)
    {
      if (this.axZ == -1) {
        this.axZ = paramRecyclerView.getResources().getDimensionPixelSize(2131166462);
      }
      return this.axZ;
    }
    
    public static void mO()
    {
      b localb = c.ayl;
    }
    
    public float K(RecyclerView.v paramv)
    {
      return 0.5F;
    }
    
    public abstract void L(RecyclerView.v paramv);
    
    public final int a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, long paramLong)
    {
      float f1 = 1.0F;
      int i = k(paramRecyclerView);
      int j = Math.abs(paramInt2);
      int k = (int)Math.signum(paramInt2);
      float f2 = Math.min(1.0F, j * 1.0F / paramInt1);
      paramInt1 = (int)(i * k * axY.getInterpolation(f2));
      if (paramLong > 2000L) {}
      for (;;)
      {
        f2 = paramInt1;
        i = (int)(axX.getInterpolation(f1) * f2);
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
    
    public abstract int a(RecyclerView paramRecyclerView, RecyclerView.v paramv);
    
    public void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.v paramv, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
    {
      c.ayl.a(paramRecyclerView, paramv.arI, paramFloat1, paramFloat2, paramBoolean);
    }
    
    public abstract boolean a(RecyclerView paramRecyclerView, RecyclerView.v paramv1, RecyclerView.v paramv2);
    
    final int b(RecyclerView paramRecyclerView, RecyclerView.v paramv)
    {
      return aQ(a(paramRecyclerView, paramv), t.Y(paramRecyclerView));
    }
    
    public final boolean c(RecyclerView paramRecyclerView, RecyclerView.v paramv)
    {
      return (b(paramRecyclerView, paramv) & 0xFF0000) != 0;
    }
    
    public void d(RecyclerView paramRecyclerView, RecyclerView.v paramv)
    {
      c.ayl.ci(paramv.arI);
    }
    
    public void f(RecyclerView.v paramv, int paramInt)
    {
      if (paramv != null) {
        paramv = c.ayl;
      }
    }
    
    public boolean mM()
    {
      return true;
    }
    
    public boolean mN()
    {
      return true;
    }
  }
  
  final class b
    extends GestureDetector.SimpleOnGestureListener
  {
    boolean aya = true;
    
    b() {}
    
    public final boolean onDown(MotionEvent paramMotionEvent)
    {
      return true;
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      if (!this.aya) {}
      Object localObject;
      do
      {
        do
        {
          do
          {
            return;
            localObject = a.this.l(paramMotionEvent);
          } while (localObject == null);
          localObject = a.this.akA.bh((View)localObject);
        } while ((localObject == null) || (!a.this.axG.c(a.this.akA, (RecyclerView.v)localObject)) || (paramMotionEvent.getPointerId(0) != a.this.mActivePointerId));
        int i = paramMotionEvent.findPointerIndex(a.this.mActivePointerId);
        float f1 = paramMotionEvent.getX(i);
        float f2 = paramMotionEvent.getY(i);
        a.this.axy = f1;
        a.this.axz = f2;
        paramMotionEvent = a.this;
        a.this.axD = 0.0F;
        paramMotionEvent.axC = 0.0F;
      } while (!a.this.axG.mM());
      a.this.e((RecyclerView.v)localObject, 2);
    }
  }
  
  static class c
    implements Animator.AnimatorListener
  {
    final RecyclerView.v aqL;
    final int axH;
    final float ayb;
    final float ayc;
    final float ayd;
    final float aye;
    final ValueAnimator ayf;
    final int ayg;
    boolean ayh;
    boolean ayi = false;
    float ayj;
    float mX;
    float mY;
    boolean zF = false;
    
    c(RecyclerView.v paramv, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.axH = paramInt2;
      this.ayg = paramInt1;
      this.aqL = paramv;
      this.ayb = paramFloat1;
      this.ayc = paramFloat2;
      this.ayd = paramFloat3;
      this.aye = paramFloat4;
      this.ayf = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.ayf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          a.c.this.ayj = paramAnonymousValueAnimator.getAnimatedFraction();
        }
      });
      this.ayf.setTarget(paramv.arI);
      this.ayf.addListener(this);
      this.ayj = 0.0F;
    }
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      this.ayj = 1.0F;
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (!this.zF) {
        this.aqL.ax(true);
      }
      this.zF = true;
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.widget.a.a
 * JD-Core Version:    0.7.0.1
 */