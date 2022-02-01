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
  Rect TW;
  android.support.v4.view.c aAA;
  private b aAB;
  private final RecyclerView.l aAC = new RecyclerView.l()
  {
    public final boolean a(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
    {
      a.this.aAA.onTouchEvent(paramAnonymousMotionEvent);
      int i = paramAnonymousMotionEvent.getActionMasked();
      if (i == 0)
      {
        a.this.mActivePointerId = paramAnonymousMotionEvent.getPointerId(0);
        a.this.aAj = paramAnonymousMotionEvent.getX();
        a.this.aAk = paramAnonymousMotionEvent.getY();
        a.this.nm();
        if (a.this.aAi == null)
        {
          a locala = a.this;
          if (locala.aAu.isEmpty()) {
            break label315;
          }
          View localView = locala.j(paramAnonymousMotionEvent);
          i = locala.aAu.size() - 1;
          if (i < 0) {
            break label315;
          }
          paramAnonymousRecyclerView = (a.c)locala.aAu.get(i);
          if (paramAnonymousRecyclerView.aty.auu != localView) {
            break label308;
          }
          label143:
          if (paramAnonymousRecyclerView != null)
          {
            locala = a.this;
            locala.aAj -= paramAnonymousRecyclerView.mX;
            locala = a.this;
            locala.aAk -= paramAnonymousRecyclerView.mY;
            a.this.b(paramAnonymousRecyclerView.aty, true);
            if (a.this.aAg.remove(paramAnonymousRecyclerView.aty.auu)) {
              a.this.aAr.d(a.this.anl, paramAnonymousRecyclerView.aty);
            }
            a.this.e(paramAnonymousRecyclerView.aty, paramAnonymousRecyclerView.aAs);
            a.this.a(paramAnonymousMotionEvent, a.this.aAt, 0);
          }
        }
      }
      for (;;)
      {
        if (a.this.mVelocityTracker != null) {
          a.this.mVelocityTracker.addMovement(paramAnonymousMotionEvent);
        }
        if (a.this.aAi == null) {
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
      a.this.aAA.onTouchEvent(paramAnonymousMotionEvent);
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
          paramAnonymousRecyclerView = a.this.aAi;
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
            a.this.a(paramAnonymousMotionEvent, a.this.aAt, k);
            a.this.J(paramAnonymousRecyclerView);
            a.this.anl.removeCallbacks(a.this.aAv);
            a.this.aAv.run();
            a.this.anl.invalidate();
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
      a.this.a(paramAnonymousMotionEvent, a.this.aAt, j);
    }
  };
  long aAD;
  final List<View> aAg = new ArrayList();
  private final float[] aAh = new float[2];
  RecyclerView.w aAi = null;
  float aAj;
  float aAk;
  private float aAl;
  private float aAm;
  public float aAn;
  public float aAo;
  float aAp;
  float aAq;
  public a aAr;
  private int aAs = 0;
  int aAt;
  List<c> aAu = new ArrayList();
  final Runnable aAv = new Runnable()
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
      if (a.this.aAi != null)
      {
        locala = a.this;
        if (locala.aAi == null) {
          break label550;
        }
        l2 = System.currentTimeMillis();
        if (locala.aAD != -9223372036854775808L) {
          break label409;
        }
        l1 = 0L;
        localObject = locala.anl.getLayoutManager();
        if (locala.TW == null) {
          locala.TW = new Rect();
        }
        ((RecyclerView.i)localObject).f(locala.aAi.auu, locala.TW);
        if (!((RecyclerView.i)localObject).kc()) {
          break label479;
        }
        j = (int)(locala.aAp + locala.aAn);
        i = j - locala.TW.left - locala.anl.getPaddingLeft();
        if ((locala.aAn >= 0.0F) || (i >= 0)) {
          break label422;
        }
        if (!((RecyclerView.i)localObject).kd()) {
          break label545;
        }
        m = (int)(locala.aAq + locala.aAo);
        j = m - locala.TW.top - locala.anl.getPaddingTop();
        if ((locala.aAo >= 0.0F) || (j >= 0)) {
          break label484;
        }
        if (i == 0) {
          break label566;
        }
        localObject = locala.aAr;
        localRecyclerView = locala.anl;
        m = locala.aAi.auu.getWidth();
        locala.anl.getWidth();
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
          localObject = locala.aAr;
          localRecyclerView = locala.anl;
          m = locala.aAi.auu.getHeight();
          locala.anl.getHeight();
          j = ((a.a)localObject).a(localRecyclerView, m, j, l1);
        }
        for (;;)
        {
          if ((i != 0) || (j != 0))
          {
            if (locala.aAD == -9223372036854775808L) {
              locala.aAD = l2;
            }
            locala.anl.scrollBy(i, j);
          }
          for (i = 1;; i = k)
          {
            if (i != 0)
            {
              if (a.this.aAi != null) {
                a.this.J(a.this.aAi);
              }
              a.this.anl.removeCallbacks(a.this.aAv);
              t.b(a.this.anl, this);
            }
            return;
            l1 = l2 - locala.aAD;
            break;
            if (locala.aAn > 0.0F)
            {
              j = j + locala.aAi.auu.getWidth() + locala.TW.right - (locala.anl.getWidth() - locala.anl.getPaddingRight());
              i = j;
              if (j > 0) {
                break label149;
              }
            }
            label479:
            i = 0;
            break label149;
            label484:
            if (locala.aAo > 0.0F)
            {
              m = m + locala.aAi.auu.getHeight() + locala.TW.bottom - (locala.anl.getHeight() - locala.anl.getPaddingBottom());
              j = m;
              if (m > 0) {
                break label206;
              }
            }
            j = 0;
            break label206;
            locala.aAD = -9223372036854775808L;
          }
        }
      }
    }
  };
  private List<RecyclerView.w> aAw;
  private List<Integer> aAx;
  View aAy = null;
  int aAz = -1;
  public RecyclerView anl;
  private RecyclerView.d asO = null;
  private int awI;
  int mActivePointerId = -1;
  VelocityTracker mVelocityTracker;
  
  public a(a parama)
  {
    this.aAr = parama;
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
      if (this.aAn > 0.0F)
      {
        i = 8;
        if ((this.mVelocityTracker == null) || (this.mActivePointerId < 0)) {
          break label140;
        }
        this.mVelocityTracker.computeCurrentVelocity(1000, a.P(this.aAm));
        f2 = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
        f1 = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
        if (f2 <= 0.0F) {
          break label134;
        }
      }
      for (;;)
      {
        f2 = Math.abs(f2);
        if (((j & paramInt) == 0) || (i != j) || (f2 < a.O(this.aAl)) || (f2 <= Math.abs(f1))) {
          break label140;
        }
        return j;
        i = 4;
        break;
        label134:
        j = 4;
      }
      label140:
      float f1 = this.anl.getWidth();
      if (((paramInt & i) != 0) && (Math.abs(this.aAn) > f1 * 0.5F)) {
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
      if (this.aAo > 0.0F)
      {
        i = 2;
        if ((this.mVelocityTracker == null) || (this.mActivePointerId < 0)) {
          break label137;
        }
        this.mVelocityTracker.computeCurrentVelocity(1000, a.P(this.aAm));
        f1 = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
        f2 = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
        if (f2 <= 0.0F) {
          break label131;
        }
      }
      for (;;)
      {
        f2 = Math.abs(f2);
        if (((j & paramInt) == 0) || (j != i) || (f2 < a.O(this.aAl)) || (f2 <= Math.abs(f1))) {
          break label137;
        }
        return j;
        i = 1;
        break;
        label131:
        j = 1;
      }
      label137:
      float f1 = this.anl.getHeight();
      if (((paramInt & i) != 0) && (Math.abs(this.aAo) > f1 * 0.5F)) {
        return i;
      }
    }
    return 0;
  }
  
  private void g(float[] paramArrayOfFloat)
  {
    if ((this.aAt & 0xC) != 0) {
      paramArrayOfFloat[0] = (this.aAp + this.aAn - this.aAi.auu.getLeft());
    }
    while ((this.aAt & 0x3) != 0)
    {
      paramArrayOfFloat[1] = (this.aAq + this.aAo - this.aAi.auu.getTop());
      return;
      paramArrayOfFloat[0] = this.aAi.auu.getTranslationX();
    }
    paramArrayOfFloat[1] = this.aAi.auu.getTranslationY();
  }
  
  private void nn()
  {
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  final void J(RecyclerView.w paramw)
  {
    if (this.anl.isLayoutRequested()) {}
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
          } while (this.aAs != 2);
          f = this.aAr.K(paramw);
          m = (int)(this.aAp + this.aAn);
          n = (int)(this.aAq + this.aAo);
        } while ((Math.abs(n - paramw.auu.getTop()) < paramw.auu.getHeight() * f) && (Math.abs(m - paramw.auu.getLeft()) < f * paramw.auu.getWidth()));
        int i1;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        if (this.aAw == null)
        {
          this.aAw = new ArrayList();
          this.aAx = new ArrayList();
          i1 = Math.round(this.aAp + this.aAn) + 0;
          i2 = Math.round(this.aAq + this.aAo) + 0;
          i3 = paramw.auu.getWidth() + i1 + 0;
          i4 = paramw.auu.getHeight() + i2 + 0;
          i5 = (i1 + i3) / 2;
          i6 = (i2 + i4) / 2;
          localObject = this.anl.getLayoutManager();
          i7 = ((RecyclerView.i)localObject).getChildCount();
          i = 0;
        }
        for (;;)
        {
          if (i >= i7) {
            break label484;
          }
          View localView = ((RecyclerView.i)localObject).getChildAt(i);
          if ((localView != paramw.auu) && (localView.getBottom() >= i2) && (localView.getTop() <= i4) && (localView.getRight() >= i1) && (localView.getLeft() <= i3))
          {
            RecyclerView.w localw = this.anl.bh(localView);
            int j = Math.abs(i5 - (localView.getLeft() + localView.getRight()) / 2);
            int k = localView.getTop();
            k = Math.abs(i6 - (localView.getBottom() + k) / 2);
            int i8 = j * j + k * k;
            k = 0;
            int i9 = this.aAw.size();
            j = 0;
            for (;;)
            {
              if ((j < i9) && (i8 > ((Integer)this.aAx.get(j)).intValue()))
              {
                k += 1;
                j += 1;
                continue;
                this.aAw.clear();
                this.aAx.clear();
                break;
              }
            }
            this.aAw.add(k, localw);
            this.aAx.add(k, Integer.valueOf(i8));
          }
          i += 1;
        }
        localObject = this.aAw;
      } while (((List)localObject).size() == 0);
      localObject = a.a(paramw, (List)localObject, m, n);
      if (localObject == null)
      {
        this.aAw.clear();
        this.aAx.clear();
        return;
      }
      i = ((RecyclerView.w)localObject).lN();
      paramw.lN();
    } while (!this.aAr.a(this.anl, paramw, (RecyclerView.w)localObject));
    a.a(this.anl, paramw, (RecyclerView.w)localObject, i);
  }
  
  final void a(int paramInt1, MotionEvent paramMotionEvent, int paramInt2)
  {
    Object localObject2 = null;
    if ((this.aAi != null) || (paramInt1 != 2) || (this.aAs == 2) || (!this.aAr.np())) {}
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
          } while (this.anl.getScrollState() == 1);
          localObject3 = this.anl.getLayoutManager();
          if (this.mActivePointerId != -1) {
            break;
          }
          localObject1 = localObject2;
          if (localObject1 == null) {
            break label375;
          }
          paramInt1 = (this.aAr.b(this.anl, (RecyclerView.w)localObject1) & 0xFF00) >> 8;
        } while (paramInt1 == 0);
        f1 = paramMotionEvent.getX(paramInt2);
        f2 = paramMotionEvent.getY(paramInt2);
        f1 -= this.aAj;
        f2 -= this.aAk;
        f3 = Math.abs(f1);
        f4 = Math.abs(f2);
      } while ((f3 < this.awI) && (f4 < this.awI));
      if (f3 <= f4) {
        break label377;
      }
    } while (((f1 < 0.0F) && ((paramInt1 & 0x4) == 0)) || ((f1 > 0.0F) && ((paramInt1 & 0x8) == 0)));
    label375:
    label377:
    do
    {
      this.aAo = 0.0F;
      this.aAn = 0.0F;
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      e((RecyclerView.w)localObject1, 1);
      return;
      paramInt1 = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      f3 = paramMotionEvent.getX(paramInt1);
      f4 = this.aAj;
      f1 = paramMotionEvent.getY(paramInt1);
      f2 = this.aAk;
      f3 = Math.abs(f3 - f4);
      f1 = Math.abs(f1 - f2);
      if (f3 < this.awI)
      {
        localObject1 = localObject2;
        if (f1 < this.awI) {
          break label66;
        }
      }
      if (f3 > f1)
      {
        localObject1 = localObject2;
        if (((RecyclerView.i)localObject3).kc()) {
          break label66;
        }
      }
      if (f1 > f3)
      {
        localObject1 = localObject2;
        if (((RecyclerView.i)localObject3).kd()) {
          break label66;
        }
      }
      localObject3 = j(paramMotionEvent);
      localObject1 = localObject2;
      if (localObject3 == null) {
        break label66;
      }
      localObject1 = this.anl.bh((View)localObject3);
      break label66;
      break label33;
      if ((f2 < 0.0F) && ((paramInt1 & 0x1) == 0)) {
        break;
      }
    } while ((f2 <= 0.0F) || ((paramInt1 & 0x2) != 0));
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.t paramt)
  {
    this.aAz = -1;
    float f2;
    float f1;
    if (this.aAi != null)
    {
      g(this.aAh);
      f2 = this.aAh[0];
      f1 = this.aAh[1];
    }
    for (;;)
    {
      paramt = this.aAr;
      RecyclerView.w localw = this.aAi;
      List localList = this.aAu;
      int j = this.aAs;
      int k = localList.size();
      int i = 0;
      if (i < k)
      {
        c localc = (c)localList.get(i);
        if (localc.aAM == localc.aAO)
        {
          localc.mX = localc.aty.auu.getTranslationX();
          label122:
          if (localc.aAN != localc.aAP) {
            break label231;
          }
        }
        label231:
        for (localc.mY = localc.aty.auu.getTranslationY();; localc.mY = (localc.aAN + localc.aAU * (localc.aAP - localc.aAN)))
        {
          int m = paramCanvas.save();
          paramt.a(paramCanvas, paramRecyclerView, localc.aty, localc.mX, localc.mY, localc.aAs, false);
          paramCanvas.restoreToCount(m);
          i += 1;
          break;
          localc.mX = (localc.aAM + localc.aAU * (localc.aAO - localc.aAM));
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
    this.aAn = (f1 - this.aAj);
    this.aAo = (f2 - this.aAk);
    if ((paramInt1 & 0x4) == 0) {
      this.aAn = Math.max(0.0F, this.aAn);
    }
    if ((paramInt1 & 0x8) == 0) {
      this.aAn = Math.min(0.0F, this.aAn);
    }
    if ((paramInt1 & 0x1) == 0) {
      this.aAo = Math.max(0.0F, this.aAo);
    }
    if ((paramInt1 & 0x2) == 0) {
      this.aAo = Math.min(0.0F, this.aAo);
    }
  }
  
  public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.t paramt)
  {
    int k = 0;
    if (this.aAi != null) {
      g(this.aAh);
    }
    RecyclerView.w localw = this.aAi;
    paramt = this.aAu;
    int j = paramt.size();
    int i = 0;
    while (i < j)
    {
      paramt.get(i);
      int m = paramCanvas.save();
      a.nq();
      paramCanvas.restoreToCount(m);
      i += 1;
    }
    if (localw != null)
    {
      i = paramCanvas.save();
      a.nq();
      paramCanvas.restoreToCount(i);
    }
    j -= 1;
    i = k;
    if (j >= 0)
    {
      paramCanvas = (c)paramt.get(j);
      if ((paramCanvas.Cu) && (!paramCanvas.aAS)) {
        paramt.remove(j);
      }
    }
    for (;;)
    {
      j -= 1;
      break;
      if (!paramCanvas.Cu)
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
    int i = this.aAu.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        c localc = (c)this.aAu.get(i);
        if (localc.aty == paramw)
        {
          localc.aAT |= paramBoolean;
          if (!localc.Cu) {
            localc.aAQ.cancel();
          }
          this.aAu.remove(i);
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
    paramView = this.anl.bh(paramView);
    if (paramView == null) {}
    do
    {
      return;
      if ((this.aAi != null) && (paramView == this.aAi))
      {
        e(null, 0);
        return;
      }
      b(paramView, false);
    } while (!this.aAg.remove(paramView.auu));
    this.aAr.d(this.anl, paramView);
  }
  
  final void ch(View paramView)
  {
    if (paramView == this.aAy)
    {
      this.aAy = null;
      if (this.asO != null) {
        this.anl.setChildDrawingOrderCallback(null);
      }
    }
  }
  
  public final void e(RecyclerView.w paramw, int paramInt)
  {
    if ((paramw == this.aAi) && (paramInt == this.aAs)) {
      return;
    }
    this.aAD = -9223372036854775808L;
    int k = this.aAs;
    b(paramw, true);
    this.aAs = paramInt;
    if (paramInt == 2)
    {
      if (paramw == null) {
        throw new IllegalArgumentException("Must pass a ViewHolder when dragging");
      }
      this.aAy = paramw.auu;
      if (Build.VERSION.SDK_INT < 21)
      {
        if (this.asO == null) {
          this.asO = new RecyclerView.d()
          {
            public final int aw(int paramAnonymousInt1, int paramAnonymousInt2)
            {
              if (a.this.aAy == null) {}
              int i;
              do
              {
                return paramAnonymousInt2;
                int j = a.this.aAz;
                i = j;
                if (j == -1)
                {
                  i = a.this.anl.indexOfChild(a.this.aAy);
                  a.this.aAz = i;
                }
                if (paramAnonymousInt2 == paramAnonymousInt1 - 1) {
                  return i;
                }
              } while (paramAnonymousInt2 < i);
              return paramAnonymousInt2 + 1;
            }
          };
        }
        this.anl.setChildDrawingOrderCallback(this.asO);
      }
    }
    final int i = 0;
    int j = 0;
    Object localObject;
    int m;
    int n;
    float f1;
    float f2;
    if (this.aAi != null)
    {
      localObject = this.aAi;
      if (((RecyclerView.w)localObject).auu.getParent() == null) {
        break label740;
      }
      if ((k == 2) || (this.aAs == 2)) {
        break label612;
      }
      i = this.aAr.a(this.anl, (RecyclerView.w)localObject);
      m = (a.aR(i, t.Y(this.anl)) & 0xFF00) >> 8;
      if (m == 0) {
        break label612;
      }
      n = (i & 0xFF00) >> 8;
      if (Math.abs(this.aAn) <= Math.abs(this.aAo)) {
        break label618;
      }
      j = df(m);
      if (j > 0)
      {
        i = j;
        if ((n & j) == 0) {
          i = a.aQ(j, t.Y(this.anl));
        }
        nn();
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
          g(this.aAh);
          localObject = new c((RecyclerView.w)localObject, j, k, this.aAh[0], this.aAh[1], f1, f2)
          {
            public final void onAnimationEnd(Animator paramAnonymousAnimator)
            {
              super.onAnimationEnd(paramAnonymousAnimator);
              if (this.aAT) {}
              for (;;)
              {
                return;
                if (i <= 0) {
                  a.this.aAr.d(a.this.anl, this.aAG);
                }
                while (a.this.aAy == this.aAG.auu)
                {
                  a.this.ch(this.aAG.auu);
                  return;
                  a.this.aAg.add(this.aAG.auu);
                  this.aAS = true;
                  if (i > 0)
                  {
                    paramAnonymousAnimator = a.this;
                    int i = i;
                    paramAnonymousAnimator.anl.post(new a.4(paramAnonymousAnimator, this, i));
                  }
                }
              }
            }
          };
          long l = a.c(this.anl, j);
          ((c)localObject).aAQ.setDuration(l);
          this.aAu.add(localObject);
          ((c)localObject).aty.ax(false);
          ((c)localObject).aAQ.start();
          i = 1;
          this.aAi = null;
          if (paramw != null)
          {
            this.aAt = ((this.aAr.b(this.anl, paramw) & (1 << paramInt * 8 + 8) - 1) >> this.aAs * 8);
            this.aAp = paramw.auu.getLeft();
            this.aAq = paramw.auu.getTop();
            this.aAi = paramw;
            if (paramInt == 2) {
              this.aAi.auu.performHapticFeedback(0);
            }
          }
          paramw = this.anl.getParent();
          if (paramw != null) {
            if (this.aAi == null) {
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
        this.anl.getLayoutManager().lA();
      }
      this.aAr.f(this.aAi, this.aAs);
      this.anl.invalidate();
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
      i = a.aQ(j, t.Y(this.anl));
      break;
      f2 = 0.0F;
      f1 = Math.signum(this.aAn) * this.anl.getWidth();
      break label329;
      f1 = 0.0F;
      f2 = Math.signum(this.aAo) * this.anl.getHeight();
      break label329;
      if (i > 0)
      {
        j = 2;
        break label339;
      }
      j = 4;
      break label339;
      label740:
      ch(((RecyclerView.w)localObject).auu);
      this.aAr.d(this.anl, (RecyclerView.w)localObject);
      i = j;
      break label436;
    }
  }
  
  final View j(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.aAi != null)
    {
      paramMotionEvent = this.aAi.auu;
      if (a(paramMotionEvent, f1, f2, this.aAp + this.aAn, this.aAq + this.aAo)) {
        return paramMotionEvent;
      }
    }
    int i = this.aAu.size() - 1;
    while (i >= 0)
    {
      paramMotionEvent = (c)this.aAu.get(i);
      View localView = paramMotionEvent.aty.auu;
      if (a(localView, f1, f2, paramMotionEvent.mX, paramMotionEvent.mY)) {
        return localView;
      }
      i -= 1;
    }
    return this.anl.o(f1, f2);
  }
  
  public final void j(RecyclerView paramRecyclerView)
  {
    if (this.anl == paramRecyclerView) {}
    do
    {
      return;
      if (this.anl != null)
      {
        this.anl.c(this);
        this.anl.b(this.aAC);
        Object localObject = this.anl;
        if (((RecyclerView)localObject).ash != null) {
          ((RecyclerView)localObject).ash.remove(this);
        }
        int i = this.aAu.size() - 1;
        while (i >= 0)
        {
          localObject = (c)this.aAu.get(0);
          this.aAr.d(this.anl, ((c)localObject).aty);
          i -= 1;
        }
        this.aAu.clear();
        this.aAy = null;
        this.aAz = -1;
        nn();
        if (this.aAB != null)
        {
          this.aAB.aAL = false;
          this.aAB = null;
        }
        if (this.aAA != null) {
          this.aAA = null;
        }
      }
      this.anl = paramRecyclerView;
    } while (paramRecyclerView == null);
    paramRecyclerView = paramRecyclerView.getResources();
    this.aAl = paramRecyclerView.getDimension(2131166464);
    this.aAm = paramRecyclerView.getDimension(2131166463);
    this.awI = ViewConfiguration.get(this.anl.getContext()).getScaledTouchSlop();
    this.anl.a(this);
    this.anl.a(this.aAC);
    this.anl.a(this);
    this.aAB = new b();
    this.aAA = new android.support.v4.view.c(this.anl.getContext(), this.aAB);
  }
  
  public final void nm()
  {
    if (this.mVelocityTracker != null) {
      this.mVelocityTracker.recycle();
    }
    this.mVelocityTracker = VelocityTracker.obtain();
  }
  
  public static abstract class a
  {
    private static final Interpolator aAI = new a.a.1();
    private static final Interpolator aAJ = new a.a.2();
    private int aAK = -1;
    
    public static float O(float paramFloat)
    {
      return paramFloat;
    }
    
    public static float P(float paramFloat)
    {
      return paramFloat;
    }
    
    public static RecyclerView.w a(RecyclerView.w paramw, List<RecyclerView.w> paramList, int paramInt1, int paramInt2)
    {
      int m = paramw.auu.getWidth();
      int n = paramw.auu.getHeight();
      int i = -1;
      int i1 = paramInt1 - paramw.auu.getLeft();
      int i2 = paramInt2 - paramw.auu.getTop();
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
        k = ((RecyclerView.w)localObject1).auu.getRight() - (paramInt1 + m);
        if ((k >= 0) || (((RecyclerView.w)localObject1).auu.getRight() <= paramw.auu.getRight())) {
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
        k = ((RecyclerView.w)localObject1).auu.getLeft() - paramInt1;
        if ((k <= 0) || (((RecyclerView.w)localObject1).auu.getLeft() >= paramw.auu.getLeft())) {
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
          k = ((RecyclerView.w)localObject1).auu.getTop() - paramInt2;
          if ((k > 0) && (((RecyclerView.w)localObject1).auu.getTop() < paramw.auu.getTop()))
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
            k = ((RecyclerView.w)localObject1).auu.getBottom() - (paramInt2 + n);
            if ((k < 0) && (((RecyclerView.w)localObject1).auu.getBottom() > paramw.auu.getBottom()))
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
        ((a.d)locali).e(paramw1.auu, paramw2.auu);
      }
      do
      {
        do
        {
          return;
          if (locali.kc())
          {
            if (RecyclerView.i.bG(paramw2.auu) <= paramRecyclerView.getPaddingLeft())
            {
              paramw1 = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
              com.tencent.mm.hellhoundlib.a.a.a(paramRecyclerView, paramw1.ahE(), "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
              paramRecyclerView.ca(((Integer)paramw1.mt(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.a(paramRecyclerView, "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
            }
            if (RecyclerView.i.bI(paramw2.auu) >= paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight())
            {
              paramw1 = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
              com.tencent.mm.hellhoundlib.a.a.a(paramRecyclerView, paramw1.ahE(), "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
              paramRecyclerView.ca(((Integer)paramw1.mt(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.a(paramRecyclerView, "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
            }
          }
        } while (!locali.kd());
        if (RecyclerView.i.bH(paramw2.auu) <= paramRecyclerView.getPaddingTop())
        {
          paramw1 = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(paramRecyclerView, paramw1.ahE(), "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
          paramRecyclerView.ca(((Integer)paramw1.mt(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(paramRecyclerView, "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
        }
      } while (RecyclerView.i.bJ(paramw2.auu) < paramRecyclerView.getHeight() - paramRecyclerView.getPaddingBottom());
      paramw1 = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(paramRecyclerView, paramw1.ahE(), "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
      paramRecyclerView.ca(((Integer)paramw1.mt(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramRecyclerView, "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
    }
    
    public static int aQ(int paramInt1, int paramInt2)
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
    
    public static int aR(int paramInt1, int paramInt2)
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
        return paramRecyclerView.ate;
      }
      return paramRecyclerView.lq();
    }
    
    public static int dh(int paramInt)
    {
      return (paramInt | 0x0) << 0 | 0x0 | paramInt << 16;
    }
    
    private int k(RecyclerView paramRecyclerView)
    {
      if (this.aAK == -1) {
        this.aAK = paramRecyclerView.getResources().getDimensionPixelSize(2131166462);
      }
      return this.aAK;
    }
    
    public static void nq()
    {
      b localb = c.aAW;
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
      paramInt1 = (int)(i * k * aAJ.getInterpolation(f2));
      if (paramLong > 2000L) {}
      for (;;)
      {
        f2 = paramInt1;
        i = (int)(aAI.getInterpolation(f1) * f2);
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
      c.aAW.a(paramRecyclerView, paramw.auu, paramFloat1, paramFloat2, paramBoolean);
    }
    
    public abstract boolean a(RecyclerView paramRecyclerView, RecyclerView.w paramw1, RecyclerView.w paramw2);
    
    final int b(RecyclerView paramRecyclerView, RecyclerView.w paramw)
    {
      return aR(a(paramRecyclerView, paramw), t.Y(paramRecyclerView));
    }
    
    public final boolean c(RecyclerView paramRecyclerView, RecyclerView.w paramw)
    {
      return (b(paramRecyclerView, paramw) & 0xFF0000) != 0;
    }
    
    public void d(RecyclerView paramRecyclerView, RecyclerView.w paramw)
    {
      c.aAW.ci(paramw.auu);
    }
    
    public void f(RecyclerView.w paramw, int paramInt)
    {
      if (paramw != null) {
        paramw = c.aAW;
      }
    }
    
    public boolean no()
    {
      return true;
    }
    
    public boolean np()
    {
      return true;
    }
  }
  
  final class b
    extends GestureDetector.SimpleOnGestureListener
  {
    boolean aAL = true;
    
    b() {}
    
    public final boolean onDown(MotionEvent paramMotionEvent)
    {
      return true;
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      if (!this.aAL) {}
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
          localObject = a.this.anl.bh((View)localObject);
        } while ((localObject == null) || (!a.this.aAr.c(a.this.anl, (RecyclerView.w)localObject)) || (paramMotionEvent.getPointerId(0) != a.this.mActivePointerId));
        int i = paramMotionEvent.findPointerIndex(a.this.mActivePointerId);
        float f1 = paramMotionEvent.getX(i);
        float f2 = paramMotionEvent.getY(i);
        a.this.aAj = f1;
        a.this.aAk = f2;
        paramMotionEvent = a.this;
        a.this.aAo = 0.0F;
        paramMotionEvent.aAn = 0.0F;
      } while (!a.this.aAr.no());
      a.this.e((RecyclerView.w)localObject, 2);
    }
  }
  
  static class c
    implements Animator.AnimatorListener
  {
    boolean Cu = false;
    final float aAM;
    final float aAN;
    final float aAO;
    final float aAP;
    final ValueAnimator aAQ;
    final int aAR;
    boolean aAS;
    boolean aAT = false;
    float aAU;
    final int aAs;
    final RecyclerView.w aty;
    float mX;
    float mY;
    
    c(RecyclerView.w paramw, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.aAs = paramInt2;
      this.aAR = paramInt1;
      this.aty = paramw;
      this.aAM = paramFloat1;
      this.aAN = paramFloat2;
      this.aAO = paramFloat3;
      this.aAP = paramFloat4;
      this.aAQ = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.aAQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          a.c.this.aAU = paramAnonymousValueAnimator.getAnimatedFraction();
        }
      });
      this.aAQ.setTarget(paramw.auu);
      this.aAQ.addListener(this);
      this.aAU = 0.0F;
    }
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      this.aAU = 1.0F;
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (!this.Cu) {
        this.aty.ax(true);
      }
      this.Cu = true;
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.a.a
 * JD-Core Version:    0.7.0.1
 */