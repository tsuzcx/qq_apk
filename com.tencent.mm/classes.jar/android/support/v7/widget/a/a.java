package android.support.v7.widget.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.u;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.d;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.k;
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
  implements RecyclerView.i
{
  Rect Ui;
  private final RecyclerView.k aAA = new RecyclerView.k()
  {
    public final boolean a(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
    {
      a.this.aAy.onTouchEvent(paramAnonymousMotionEvent);
      int i = paramAnonymousMotionEvent.getActionMasked();
      if (i == 0)
      {
        a.this.mActivePointerId = paramAnonymousMotionEvent.getPointerId(0);
        a.this.aAh = paramAnonymousMotionEvent.getX();
        a.this.aAi = paramAnonymousMotionEvent.getY();
        a.this.no();
        if (a.this.aAg == null)
        {
          a locala = a.this;
          if (locala.aAs.isEmpty()) {
            break label315;
          }
          View localView = locala.m(paramAnonymousMotionEvent);
          i = locala.aAs.size() - 1;
          if (i < 0) {
            break label315;
          }
          paramAnonymousRecyclerView = (a.c)locala.aAs.get(i);
          if (paramAnonymousRecyclerView.atw.aus != localView) {
            break label308;
          }
          label143:
          if (paramAnonymousRecyclerView != null)
          {
            locala = a.this;
            locala.aAh -= paramAnonymousRecyclerView.mX;
            locala = a.this;
            locala.aAi -= paramAnonymousRecyclerView.mY;
            a.this.b(paramAnonymousRecyclerView.atw, true);
            if (a.this.aAe.remove(paramAnonymousRecyclerView.atw.aus)) {
              a.this.aAp.d(a.this.mRecyclerView, paramAnonymousRecyclerView.atw);
            }
            a.this.e(paramAnonymousRecyclerView.atw, paramAnonymousRecyclerView.aAq);
            a.this.a(paramAnonymousMotionEvent, a.this.aAr, 0);
          }
        }
      }
      for (;;)
      {
        if (a.this.mVelocityTracker != null) {
          a.this.mVelocityTracker.addMovement(paramAnonymousMotionEvent);
        }
        if (a.this.aAg == null) {
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
    
    public final void ah(boolean paramAnonymousBoolean)
    {
      if (!paramAnonymousBoolean) {
        return;
      }
      a.this.e(null, 0);
    }
    
    public final void b(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
    {
      int i = 0;
      a.this.aAy.onTouchEvent(paramAnonymousMotionEvent);
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
          paramAnonymousRecyclerView = a.this.aAg;
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
            a.this.a(paramAnonymousMotionEvent, a.this.aAr, k);
            a.this.L(paramAnonymousRecyclerView);
            a.this.mRecyclerView.removeCallbacks(a.this.aAt);
            a.this.aAt.run();
            a.this.mRecyclerView.invalidate();
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
      a.this.a(paramAnonymousMotionEvent, a.this.aAr, j);
    }
  };
  long aAB;
  final List<View> aAe = new ArrayList();
  private final float[] aAf = new float[2];
  RecyclerView.v aAg = null;
  float aAh;
  float aAi;
  private float aAj;
  private float aAk;
  public float aAl;
  public float aAm;
  float aAn;
  float aAo;
  public a aAp;
  private int aAq = 0;
  int aAr;
  List<c> aAs = new ArrayList();
  final Runnable aAt = new Runnable()
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
      if (a.this.aAg != null)
      {
        locala = a.this;
        if (locala.aAg == null) {
          break label550;
        }
        l2 = System.currentTimeMillis();
        if (locala.aAB != -9223372036854775808L) {
          break label409;
        }
        l1 = 0L;
        localObject = locala.mRecyclerView.getLayoutManager();
        if (locala.Ui == null) {
          locala.Ui = new Rect();
        }
        ((RecyclerView.LayoutManager)localObject).calculateItemDecorationsForChild(locala.aAg.aus, locala.Ui);
        if (!((RecyclerView.LayoutManager)localObject).canScrollHorizontally()) {
          break label479;
        }
        j = (int)(locala.aAn + locala.aAl);
        i = j - locala.Ui.left - locala.mRecyclerView.getPaddingLeft();
        if ((locala.aAl >= 0.0F) || (i >= 0)) {
          break label422;
        }
        if (!((RecyclerView.LayoutManager)localObject).canScrollVertically()) {
          break label545;
        }
        m = (int)(locala.aAo + locala.aAm);
        j = m - locala.Ui.top - locala.mRecyclerView.getPaddingTop();
        if ((locala.aAm >= 0.0F) || (j >= 0)) {
          break label484;
        }
        if (i == 0) {
          break label566;
        }
        localObject = locala.aAp;
        localRecyclerView = locala.mRecyclerView;
        m = locala.aAg.aus.getWidth();
        locala.mRecyclerView.getWidth();
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
          localObject = locala.aAp;
          localRecyclerView = locala.mRecyclerView;
          m = locala.aAg.aus.getHeight();
          locala.mRecyclerView.getHeight();
          j = ((a.a)localObject).a(localRecyclerView, m, j, l1);
        }
        for (;;)
        {
          if ((i != 0) || (j != 0))
          {
            if (locala.aAB == -9223372036854775808L) {
              locala.aAB = l2;
            }
            locala.mRecyclerView.scrollBy(i, j);
          }
          for (i = 1;; i = k)
          {
            if (i != 0)
            {
              if (a.this.aAg != null) {
                a.this.L(a.this.aAg);
              }
              a.this.mRecyclerView.removeCallbacks(a.this.aAt);
              u.b(a.this.mRecyclerView, this);
            }
            return;
            l1 = l2 - locala.aAB;
            break;
            if (locala.aAl > 0.0F)
            {
              j = j + locala.aAg.aus.getWidth() + locala.Ui.right - (locala.mRecyclerView.getWidth() - locala.mRecyclerView.getPaddingRight());
              i = j;
              if (j > 0) {
                break label149;
              }
            }
            label479:
            i = 0;
            break label149;
            label484:
            if (locala.aAm > 0.0F)
            {
              m = m + locala.aAg.aus.getHeight() + locala.Ui.bottom - (locala.mRecyclerView.getHeight() - locala.mRecyclerView.getPaddingBottom());
              j = m;
              if (m > 0) {
                break label206;
              }
            }
            j = 0;
            break label206;
            locala.aAB = -9223372036854775808L;
          }
        }
      }
    }
  };
  private List<RecyclerView.v> aAu;
  private List<Integer> aAv;
  View aAw = null;
  int aAx = -1;
  android.support.v4.view.c aAy;
  private b aAz;
  private RecyclerView.d asZ = null;
  private int awG;
  int mActivePointerId = -1;
  public RecyclerView mRecyclerView;
  VelocityTracker mVelocityTracker;
  
  public a(a parama)
  {
    this.aAp = parama;
  }
  
  private static boolean a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (paramFloat1 >= paramFloat3) && (paramFloat1 <= paramView.getWidth() + paramFloat3) && (paramFloat2 >= paramFloat4) && (paramFloat2 <= paramView.getHeight() + paramFloat4);
  }
  
  private int cZ(int paramInt)
  {
    int j = 8;
    if ((paramInt & 0xC) != 0)
    {
      int i;
      float f2;
      if (this.aAl > 0.0F)
      {
        i = 8;
        if ((this.mVelocityTracker == null) || (this.mActivePointerId < 0)) {
          break label140;
        }
        this.mVelocityTracker.computeCurrentVelocity(1000, a.P(this.aAk));
        f2 = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
        f1 = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
        if (f2 <= 0.0F) {
          break label134;
        }
      }
      for (;;)
      {
        f2 = Math.abs(f2);
        if (((j & paramInt) == 0) || (i != j) || (f2 < a.O(this.aAj)) || (f2 <= Math.abs(f1))) {
          break label140;
        }
        return j;
        i = 4;
        break;
        label134:
        j = 4;
      }
      label140:
      float f1 = this.mRecyclerView.getWidth();
      if (((paramInt & i) != 0) && (Math.abs(this.aAl) > f1 * 0.5F)) {
        return i;
      }
    }
    return 0;
  }
  
  private int da(int paramInt)
  {
    int j = 2;
    if ((paramInt & 0x3) != 0)
    {
      int i;
      float f2;
      if (this.aAm > 0.0F)
      {
        i = 2;
        if ((this.mVelocityTracker == null) || (this.mActivePointerId < 0)) {
          break label137;
        }
        this.mVelocityTracker.computeCurrentVelocity(1000, a.P(this.aAk));
        f1 = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
        f2 = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
        if (f2 <= 0.0F) {
          break label131;
        }
      }
      for (;;)
      {
        f2 = Math.abs(f2);
        if (((j & paramInt) == 0) || (j != i) || (f2 < a.O(this.aAj)) || (f2 <= Math.abs(f1))) {
          break label137;
        }
        return j;
        i = 1;
        break;
        label131:
        j = 1;
      }
      label137:
      float f1 = this.mRecyclerView.getHeight();
      if (((paramInt & i) != 0) && (Math.abs(this.aAm) > f1 * 0.5F)) {
        return i;
      }
    }
    return 0;
  }
  
  private void g(float[] paramArrayOfFloat)
  {
    if ((this.aAr & 0xC) != 0) {
      paramArrayOfFloat[0] = (this.aAn + this.aAl - this.aAg.aus.getLeft());
    }
    while ((this.aAr & 0x3) != 0)
    {
      paramArrayOfFloat[1] = (this.aAo + this.aAm - this.aAg.aus.getTop());
      return;
      paramArrayOfFloat[0] = this.aAg.aus.getTranslationX();
    }
    paramArrayOfFloat[1] = this.aAg.aus.getTranslationY();
  }
  
  private void np()
  {
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  final void L(RecyclerView.v paramv)
  {
    if (this.mRecyclerView.isLayoutRequested()) {}
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
          } while (this.aAq != 2);
          f = this.aAp.M(paramv);
          m = (int)(this.aAn + this.aAl);
          n = (int)(this.aAo + this.aAm);
        } while ((Math.abs(n - paramv.aus.getTop()) < paramv.aus.getHeight() * f) && (Math.abs(m - paramv.aus.getLeft()) < f * paramv.aus.getWidth()));
        int i1;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        if (this.aAu == null)
        {
          this.aAu = new ArrayList();
          this.aAv = new ArrayList();
          i1 = Math.round(this.aAn + this.aAl) + 0;
          i2 = Math.round(this.aAo + this.aAm) + 0;
          i3 = paramv.aus.getWidth() + i1 + 0;
          i4 = paramv.aus.getHeight() + i2 + 0;
          i5 = (i1 + i3) / 2;
          i6 = (i2 + i4) / 2;
          localObject = this.mRecyclerView.getLayoutManager();
          i7 = ((RecyclerView.LayoutManager)localObject).getChildCount();
          i = 0;
        }
        for (;;)
        {
          if (i >= i7) {
            break label484;
          }
          View localView = ((RecyclerView.LayoutManager)localObject).getChildAt(i);
          if ((localView != paramv.aus) && (localView.getBottom() >= i2) && (localView.getTop() <= i4) && (localView.getRight() >= i1) && (localView.getLeft() <= i3))
          {
            RecyclerView.v localv = this.mRecyclerView.bi(localView);
            int j = Math.abs(i5 - (localView.getLeft() + localView.getRight()) / 2);
            int k = localView.getTop();
            k = Math.abs(i6 - (localView.getBottom() + k) / 2);
            int i8 = j * j + k * k;
            k = 0;
            int i9 = this.aAu.size();
            j = 0;
            for (;;)
            {
              if ((j < i9) && (i8 > ((Integer)this.aAv.get(j)).intValue()))
              {
                k += 1;
                j += 1;
                continue;
                this.aAu.clear();
                this.aAv.clear();
                break;
              }
            }
            this.aAu.add(k, localv);
            this.aAv.add(k, Integer.valueOf(i8));
          }
          i += 1;
        }
        localObject = this.aAu;
      } while (((List)localObject).size() == 0);
      localObject = a.a(paramv, (List)localObject, m, n);
      if (localObject == null)
      {
        this.aAu.clear();
        this.aAv.clear();
        return;
      }
      i = ((RecyclerView.v)localObject).lR();
      paramv.lR();
    } while (!this.aAp.a(this.mRecyclerView, paramv, (RecyclerView.v)localObject));
    a.a(this.mRecyclerView, paramv, (RecyclerView.v)localObject, i);
  }
  
  final void a(int paramInt1, MotionEvent paramMotionEvent, int paramInt2)
  {
    Object localObject2 = null;
    if ((this.aAg != null) || (paramInt1 != 2) || (this.aAq == 2) || (!this.aAp.nr())) {}
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
          } while (this.mRecyclerView.getScrollState() == 1);
          localObject3 = this.mRecyclerView.getLayoutManager();
          if (this.mActivePointerId != -1) {
            break;
          }
          localObject1 = localObject2;
          if (localObject1 == null) {
            break label375;
          }
          paramInt1 = (this.aAp.b(this.mRecyclerView, (RecyclerView.v)localObject1) & 0xFF00) >> 8;
        } while (paramInt1 == 0);
        f1 = paramMotionEvent.getX(paramInt2);
        f2 = paramMotionEvent.getY(paramInt2);
        f1 -= this.aAh;
        f2 -= this.aAi;
        f3 = Math.abs(f1);
        f4 = Math.abs(f2);
      } while ((f3 < this.awG) && (f4 < this.awG));
      if (f3 <= f4) {
        break label377;
      }
    } while (((f1 < 0.0F) && ((paramInt1 & 0x4) == 0)) || ((f1 > 0.0F) && ((paramInt1 & 0x8) == 0)));
    label375:
    label377:
    do
    {
      this.aAm = 0.0F;
      this.aAl = 0.0F;
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      e((RecyclerView.v)localObject1, 1);
      return;
      paramInt1 = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      f3 = paramMotionEvent.getX(paramInt1);
      f4 = this.aAh;
      f1 = paramMotionEvent.getY(paramInt1);
      f2 = this.aAi;
      f3 = Math.abs(f3 - f4);
      f1 = Math.abs(f1 - f2);
      if (f3 < this.awG)
      {
        localObject1 = localObject2;
        if (f1 < this.awG) {
          break label66;
        }
      }
      if (f3 > f1)
      {
        localObject1 = localObject2;
        if (((RecyclerView.LayoutManager)localObject3).canScrollHorizontally()) {
          break label66;
        }
      }
      if (f1 > f3)
      {
        localObject1 = localObject2;
        if (((RecyclerView.LayoutManager)localObject3).canScrollVertically()) {
          break label66;
        }
      }
      localObject3 = m(paramMotionEvent);
      localObject1 = localObject2;
      if (localObject3 == null) {
        break label66;
      }
      localObject1 = this.mRecyclerView.bi((View)localObject3);
      break label66;
      break label33;
      if ((f2 < 0.0F) && ((paramInt1 & 0x1) == 0)) {
        break;
      }
    } while ((f2 <= 0.0F) || ((paramInt1 & 0x2) != 0));
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    this.aAx = -1;
    float f2;
    float f1;
    if (this.aAg != null)
    {
      g(this.aAf);
      f2 = this.aAf[0];
      f1 = this.aAf[1];
    }
    for (;;)
    {
      params = this.aAp;
      RecyclerView.v localv = this.aAg;
      List localList = this.aAs;
      int j = this.aAq;
      int k = localList.size();
      int i = 0;
      if (i < k)
      {
        c localc = (c)localList.get(i);
        if (localc.aAK == localc.aAM)
        {
          localc.mX = localc.atw.aus.getTranslationX();
          label122:
          if (localc.aAL != localc.aAN) {
            break label231;
          }
        }
        label231:
        for (localc.mY = localc.atw.aus.getTranslationY();; localc.mY = (localc.aAL + localc.aAS * (localc.aAN - localc.aAL)))
        {
          int m = paramCanvas.save();
          params.a(paramCanvas, paramRecyclerView, localc.atw, localc.mX, localc.mY, localc.aAq, false);
          paramCanvas.restoreToCount(m);
          i += 1;
          break;
          localc.mX = (localc.aAK + localc.aAS * (localc.aAM - localc.aAK));
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
    this.aAl = (f1 - this.aAh);
    this.aAm = (f2 - this.aAi);
    if ((paramInt1 & 0x4) == 0) {
      this.aAl = Math.max(0.0F, this.aAl);
    }
    if ((paramInt1 & 0x8) == 0) {
      this.aAl = Math.min(0.0F, this.aAl);
    }
    if ((paramInt1 & 0x1) == 0) {
      this.aAm = Math.max(0.0F, this.aAm);
    }
    if ((paramInt1 & 0x2) == 0) {
      this.aAm = Math.min(0.0F, this.aAm);
    }
  }
  
  public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    int k = 0;
    if (this.aAg != null) {
      g(this.aAf);
    }
    RecyclerView.v localv = this.aAg;
    params = this.aAs;
    int j = params.size();
    int i = 0;
    while (i < j)
    {
      params.get(i);
      int m = paramCanvas.save();
      a.ns();
      paramCanvas.restoreToCount(m);
      i += 1;
    }
    if (localv != null)
    {
      i = paramCanvas.save();
      a.ns();
      paramCanvas.restoreToCount(i);
    }
    j -= 1;
    i = k;
    if (j >= 0)
    {
      paramCanvas = (c)params.get(j);
      if ((paramCanvas.CB) && (!paramCanvas.aAQ)) {
        params.remove(j);
      }
    }
    for (;;)
    {
      j -= 1;
      break;
      if (!paramCanvas.CB)
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
    int i = this.aAs.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        c localc = (c)this.aAs.get(i);
        if (localc.atw == paramv)
        {
          localc.aAR |= paramBoolean;
          if (!localc.CB) {
            localc.aAO.cancel();
          }
          this.aAs.remove(i);
        }
      }
      else
      {
        return;
      }
      i -= 1;
    }
  }
  
  public final void bD(View paramView) {}
  
  public final void bE(View paramView)
  {
    bT(paramView);
    paramView = this.mRecyclerView.bi(paramView);
    if (paramView == null) {}
    do
    {
      return;
      if ((this.aAg != null) && (paramView == this.aAg))
      {
        e(null, 0);
        return;
      }
      b(paramView, false);
    } while (!this.aAe.remove(paramView.aus));
    this.aAp.d(this.mRecyclerView, paramView);
  }
  
  final void bT(View paramView)
  {
    if (paramView == this.aAw)
    {
      this.aAw = null;
      if (this.asZ != null) {
        this.mRecyclerView.setChildDrawingOrderCallback(null);
      }
    }
  }
  
  public final void e(RecyclerView.v paramv, int paramInt)
  {
    if ((paramv == this.aAg) && (paramInt == this.aAq)) {
      return;
    }
    this.aAB = -9223372036854775808L;
    int k = this.aAq;
    b(paramv, true);
    this.aAq = paramInt;
    if (paramInt == 2)
    {
      if (paramv == null) {
        throw new IllegalArgumentException("Must pass a ViewHolder when dragging");
      }
      this.aAw = paramv.aus;
      if (Build.VERSION.SDK_INT < 21)
      {
        if (this.asZ == null) {
          this.asZ = new RecyclerView.d()
          {
            public final int au(int paramAnonymousInt1, int paramAnonymousInt2)
            {
              if (a.this.aAw == null) {}
              int i;
              do
              {
                return paramAnonymousInt2;
                int j = a.this.aAx;
                i = j;
                if (j == -1)
                {
                  i = a.this.mRecyclerView.indexOfChild(a.this.aAw);
                  a.this.aAx = i;
                }
                if (paramAnonymousInt2 == paramAnonymousInt1 - 1) {
                  return i;
                }
              } while (paramAnonymousInt2 < i);
              return paramAnonymousInt2 + 1;
            }
          };
        }
        this.mRecyclerView.setChildDrawingOrderCallback(this.asZ);
      }
    }
    final int i = 0;
    int j = 0;
    Object localObject;
    int m;
    int n;
    float f1;
    float f2;
    if (this.aAg != null)
    {
      localObject = this.aAg;
      if (((RecyclerView.v)localObject).aus.getParent() == null) {
        break label740;
      }
      if ((k == 2) || (this.aAq == 2)) {
        break label612;
      }
      i = this.aAp.a(this.mRecyclerView, (RecyclerView.v)localObject);
      m = (a.aL(i, u.Z(this.mRecyclerView)) & 0xFF00) >> 8;
      if (m == 0) {
        break label612;
      }
      n = (i & 0xFF00) >> 8;
      if (Math.abs(this.aAl) <= Math.abs(this.aAm)) {
        break label618;
      }
      j = cZ(m);
      if (j > 0)
      {
        i = j;
        if ((n & j) == 0) {
          i = a.aK(j, u.Z(this.mRecyclerView));
        }
        np();
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
          g(this.aAf);
          localObject = new c((RecyclerView.v)localObject, j, k, this.aAf[0], this.aAf[1], f1, f2)
          {
            public final void onAnimationEnd(Animator paramAnonymousAnimator)
            {
              super.onAnimationEnd(paramAnonymousAnimator);
              if (this.aAR) {}
              for (;;)
              {
                return;
                if (i <= 0) {
                  a.this.aAp.d(a.this.mRecyclerView, this.aAE);
                }
                while (a.this.aAw == this.aAE.aus)
                {
                  a.this.bT(this.aAE.aus);
                  return;
                  a.this.aAe.add(this.aAE.aus);
                  this.aAQ = true;
                  if (i > 0)
                  {
                    paramAnonymousAnimator = a.this;
                    int i = i;
                    paramAnonymousAnimator.mRecyclerView.post(new a.4(paramAnonymousAnimator, this, i));
                  }
                }
              }
            }
          };
          long l = a.b(this.mRecyclerView, j);
          ((c)localObject).aAO.setDuration(l);
          this.aAs.add(localObject);
          ((c)localObject).atw.av(false);
          ((c)localObject).aAO.start();
          i = 1;
          this.aAg = null;
          if (paramv != null)
          {
            this.aAr = ((this.aAp.b(this.mRecyclerView, paramv) & (1 << paramInt * 8 + 8) - 1) >> this.aAq * 8);
            this.aAn = paramv.aus.getLeft();
            this.aAo = paramv.aus.getTop();
            this.aAg = paramv;
            if (paramInt == 2) {
              this.aAg.aus.performHapticFeedback(0);
            }
          }
          paramv = this.mRecyclerView.getParent();
          if (paramv != null) {
            if (this.aAg == null) {
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
        this.mRecyclerView.getLayoutManager().requestSimpleAnimationsInNextLayout();
      }
      this.aAp.f(this.aAg, this.aAq);
      this.mRecyclerView.invalidate();
      return;
      j = da(m);
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
        j = da(m);
        i = j;
        if (j > 0) {
          break;
        }
        j = cZ(m);
      } while (j <= 0);
      i = j;
      if ((n & j) != 0) {
        break;
      }
      i = a.aK(j, u.Z(this.mRecyclerView));
      break;
      f2 = 0.0F;
      f1 = Math.signum(this.aAl) * this.mRecyclerView.getWidth();
      break label329;
      f1 = 0.0F;
      f2 = Math.signum(this.aAm) * this.mRecyclerView.getHeight();
      break label329;
      if (i > 0)
      {
        j = 2;
        break label339;
      }
      j = 4;
      break label339;
      label740:
      bT(((RecyclerView.v)localObject).aus);
      this.aAp.d(this.mRecyclerView, (RecyclerView.v)localObject);
      i = j;
      break label436;
    }
  }
  
  public final void f(RecyclerView paramRecyclerView)
  {
    if (this.mRecyclerView == paramRecyclerView) {}
    do
    {
      return;
      if (this.mRecyclerView != null)
      {
        this.mRecyclerView.c(this);
        this.mRecyclerView.b(this.aAA);
        Object localObject = this.mRecyclerView;
        if (((RecyclerView)localObject).ass != null) {
          ((RecyclerView)localObject).ass.remove(this);
        }
        int i = this.aAs.size() - 1;
        while (i >= 0)
        {
          localObject = (c)this.aAs.get(0);
          this.aAp.d(this.mRecyclerView, ((c)localObject).atw);
          i -= 1;
        }
        this.aAs.clear();
        this.aAw = null;
        this.aAx = -1;
        np();
        if (this.aAz != null)
        {
          this.aAz.aAJ = false;
          this.aAz = null;
        }
        if (this.aAy != null) {
          this.aAy = null;
        }
      }
      this.mRecyclerView = paramRecyclerView;
    } while (paramRecyclerView == null);
    paramRecyclerView = paramRecyclerView.getResources();
    this.aAj = paramRecyclerView.getDimension(2131166557);
    this.aAk = paramRecyclerView.getDimension(2131166556);
    this.awG = ViewConfiguration.get(this.mRecyclerView.getContext()).getScaledTouchSlop();
    this.mRecyclerView.a(this);
    this.mRecyclerView.a(this.aAA);
    this.mRecyclerView.a(this);
    this.aAz = new b();
    this.aAy = new android.support.v4.view.c(this.mRecyclerView.getContext(), this.aAz);
  }
  
  final View m(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.aAg != null)
    {
      paramMotionEvent = this.aAg.aus;
      if (a(paramMotionEvent, f1, f2, this.aAn + this.aAl, this.aAo + this.aAm)) {
        return paramMotionEvent;
      }
    }
    int i = this.aAs.size() - 1;
    while (i >= 0)
    {
      paramMotionEvent = (c)this.aAs.get(i);
      View localView = paramMotionEvent.atw.aus;
      if (a(localView, f1, f2, paramMotionEvent.mX, paramMotionEvent.mY)) {
        return localView;
      }
      i -= 1;
    }
    return this.mRecyclerView.o(f1, f2);
  }
  
  public final void no()
  {
    if (this.mVelocityTracker != null) {
      this.mVelocityTracker.recycle();
    }
    this.mVelocityTracker = VelocityTracker.obtain();
  }
  
  public static abstract class a
  {
    private static final Interpolator aAG = new Interpolator()
    {
      public final float getInterpolation(float paramAnonymousFloat)
      {
        return paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat;
      }
    };
    private static final Interpolator aAH = new Interpolator()
    {
      public final float getInterpolation(float paramAnonymousFloat)
      {
        paramAnonymousFloat -= 1.0F;
        return paramAnonymousFloat * (paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat) + 1.0F;
      }
    };
    private int aAI = -1;
    
    public static float O(float paramFloat)
    {
      return paramFloat;
    }
    
    public static float P(float paramFloat)
    {
      return paramFloat;
    }
    
    public static RecyclerView.v a(RecyclerView.v paramv, List<RecyclerView.v> paramList, int paramInt1, int paramInt2)
    {
      int m = paramv.aus.getWidth();
      int n = paramv.aus.getHeight();
      int i = -1;
      int i1 = paramInt1 - paramv.aus.getLeft();
      int i2 = paramInt2 - paramv.aus.getTop();
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
        k = ((RecyclerView.v)localObject1).aus.getRight() - (paramInt1 + m);
        if ((k >= 0) || (((RecyclerView.v)localObject1).aus.getRight() <= paramv.aus.getRight())) {
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
        k = ((RecyclerView.v)localObject1).aus.getLeft() - paramInt1;
        if ((k <= 0) || (((RecyclerView.v)localObject1).aus.getLeft() >= paramv.aus.getLeft())) {
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
          k = ((RecyclerView.v)localObject1).aus.getTop() - paramInt2;
          if ((k > 0) && (((RecyclerView.v)localObject1).aus.getTop() < paramv.aus.getTop()))
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
            k = ((RecyclerView.v)localObject1).aus.getBottom() - (paramInt2 + n);
            if ((k < 0) && (((RecyclerView.v)localObject1).aus.getBottom() > paramv.aus.getBottom()))
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
      RecyclerView.LayoutManager localLayoutManager = paramRecyclerView.getLayoutManager();
      if ((localLayoutManager instanceof a.d)) {
        ((a.d)localLayoutManager).e(paramv1.aus, paramv2.aus);
      }
      do
      {
        do
        {
          return;
          if (localLayoutManager.canScrollHorizontally())
          {
            if (localLayoutManager.getDecoratedLeft(paramv2.aus) <= paramRecyclerView.getPaddingLeft())
            {
              paramv1 = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
              com.tencent.mm.hellhoundlib.a.a.a(paramRecyclerView, paramv1.axQ(), "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
              paramRecyclerView.scrollToPosition(((Integer)paramv1.pG(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.a(paramRecyclerView, "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
            }
            if (localLayoutManager.getDecoratedRight(paramv2.aus) >= paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight())
            {
              paramv1 = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
              com.tencent.mm.hellhoundlib.a.a.a(paramRecyclerView, paramv1.axQ(), "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
              paramRecyclerView.scrollToPosition(((Integer)paramv1.pG(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.a(paramRecyclerView, "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
            }
          }
        } while (!localLayoutManager.canScrollVertically());
        if (localLayoutManager.getDecoratedTop(paramv2.aus) <= paramRecyclerView.getPaddingTop())
        {
          paramv1 = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(paramRecyclerView, paramv1.axQ(), "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
          paramRecyclerView.scrollToPosition(((Integer)paramv1.pG(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(paramRecyclerView, "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
        }
      } while (localLayoutManager.getDecoratedBottom(paramv2.aus) < paramRecyclerView.getHeight() - paramRecyclerView.getPaddingBottom());
      paramv1 = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(paramRecyclerView, paramv1.axQ(), "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
      paramRecyclerView.scrollToPosition(((Integer)paramv1.pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramRecyclerView, "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
    }
    
    public static int aK(int paramInt1, int paramInt2)
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
    
    public static int aL(int paramInt1, int paramInt2)
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
    
    public static long b(RecyclerView paramRecyclerView, int paramInt)
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
        return paramRecyclerView.atp;
      }
      return paramRecyclerView.ly();
    }
    
    public static int db(int paramInt)
    {
      return (paramInt | 0x0) << 0 | 0x0 | paramInt << 16;
    }
    
    private int g(RecyclerView paramRecyclerView)
    {
      if (this.aAI == -1) {
        this.aAI = paramRecyclerView.getResources().getDimensionPixelSize(2131166555);
      }
      return this.aAI;
    }
    
    public static void ns()
    {
      b localb = c.aAU;
    }
    
    public float M(RecyclerView.v paramv)
    {
      return 0.5F;
    }
    
    public abstract void N(RecyclerView.v paramv);
    
    public final int a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, long paramLong)
    {
      float f1 = 1.0F;
      int i = g(paramRecyclerView);
      int j = Math.abs(paramInt2);
      int k = (int)Math.signum(paramInt2);
      float f2 = Math.min(1.0F, j * 1.0F / paramInt1);
      paramInt1 = (int)(i * k * aAH.getInterpolation(f2));
      if (paramLong > 2000L) {}
      for (;;)
      {
        f2 = paramInt1;
        i = (int)(aAG.getInterpolation(f1) * f2);
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
      c.aAU.a(paramRecyclerView, paramv.aus, paramFloat1, paramFloat2, paramBoolean);
    }
    
    public abstract boolean a(RecyclerView paramRecyclerView, RecyclerView.v paramv1, RecyclerView.v paramv2);
    
    final int b(RecyclerView paramRecyclerView, RecyclerView.v paramv)
    {
      return aL(a(paramRecyclerView, paramv), u.Z(paramRecyclerView));
    }
    
    public final boolean c(RecyclerView paramRecyclerView, RecyclerView.v paramv)
    {
      return (b(paramRecyclerView, paramv) & 0xFF0000) != 0;
    }
    
    public void d(RecyclerView paramRecyclerView, RecyclerView.v paramv)
    {
      c.aAU.bU(paramv.aus);
    }
    
    public void f(RecyclerView.v paramv, int paramInt)
    {
      if (paramv != null) {
        paramv = c.aAU;
      }
    }
    
    public boolean nq()
    {
      return true;
    }
    
    public boolean nr()
    {
      return true;
    }
  }
  
  final class b
    extends GestureDetector.SimpleOnGestureListener
  {
    boolean aAJ = true;
    
    b() {}
    
    public final boolean onDown(MotionEvent paramMotionEvent)
    {
      return true;
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      if (!this.aAJ) {}
      Object localObject;
      do
      {
        do
        {
          do
          {
            return;
            localObject = a.this.m(paramMotionEvent);
          } while (localObject == null);
          localObject = a.this.mRecyclerView.bi((View)localObject);
        } while ((localObject == null) || (!a.this.aAp.c(a.this.mRecyclerView, (RecyclerView.v)localObject)) || (paramMotionEvent.getPointerId(0) != a.this.mActivePointerId));
        int i = paramMotionEvent.findPointerIndex(a.this.mActivePointerId);
        float f1 = paramMotionEvent.getX(i);
        float f2 = paramMotionEvent.getY(i);
        a.this.aAh = f1;
        a.this.aAi = f2;
        paramMotionEvent = a.this;
        a.this.aAm = 0.0F;
        paramMotionEvent.aAl = 0.0F;
      } while (!a.this.aAp.nq());
      a.this.e((RecyclerView.v)localObject, 2);
    }
  }
  
  static class c
    implements Animator.AnimatorListener
  {
    boolean CB = false;
    final float aAK;
    final float aAL;
    final float aAM;
    final float aAN;
    final ValueAnimator aAO;
    final int aAP;
    boolean aAQ;
    boolean aAR = false;
    float aAS;
    final int aAq;
    final RecyclerView.v atw;
    float mX;
    float mY;
    
    c(RecyclerView.v paramv, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.aAq = paramInt2;
      this.aAP = paramInt1;
      this.atw = paramv;
      this.aAK = paramFloat1;
      this.aAL = paramFloat2;
      this.aAM = paramFloat3;
      this.aAN = paramFloat4;
      this.aAO = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.aAO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          a.c.this.aAS = paramAnonymousValueAnimator.getAnimatedFraction();
        }
      });
      this.aAO.setTarget(paramv.aus);
      this.aAO.addListener(this);
      this.aAS = 0.0F;
    }
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      this.aAS = 1.0F;
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (!this.CB) {
        this.atw.av(true);
      }
      this.CB = true;
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.widget.a.a
 * JD-Core Version:    0.7.0.1
 */