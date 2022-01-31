package android.support.v7.widget.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.c;
import android.support.v4.view.t;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.d;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.j;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends RecyclerView.h
  implements RecyclerView.j
{
  RecyclerView adt;
  private RecyclerView.d aiS = null;
  private int amw;
  final List<View> apT = new ArrayList();
  private final float[] apU = new float[2];
  RecyclerView.v apV = null;
  float apW;
  float apX;
  float apY;
  float apZ;
  float aqa;
  float aqb;
  float aqc;
  float aqd;
  a.a aqe;
  int aqf = 0;
  int aqg;
  List<c> aqh = new ArrayList();
  final Runnable aqi = new a.1(this);
  private List<RecyclerView.v> aqj;
  private List<Integer> aqk;
  View aql = null;
  int aqm = -1;
  c aqn;
  private a.b aqo;
  private final RecyclerView.l aqp = new a.2(this);
  long aqq;
  Rect hV;
  int mActivePointerId = -1;
  VelocityTracker mVelocityTracker;
  
  public a(a.a parama)
  {
    this.aqe = parama;
  }
  
  private static boolean a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (paramFloat1 >= paramFloat3) && (paramFloat1 <= paramView.getWidth() + paramFloat3) && (paramFloat2 >= paramFloat4) && (paramFloat2 <= paramView.getHeight() + paramFloat4);
  }
  
  private void f(float[] paramArrayOfFloat)
  {
    if ((this.aqg & 0xC) != 0) {
      paramArrayOfFloat[0] = (this.aqc + this.aqa - this.apV.aku.getLeft());
    }
    while ((this.aqg & 0x3) != 0)
    {
      paramArrayOfFloat[1] = (this.aqd + this.aqb - this.apV.aku.getTop());
      return;
      paramArrayOfFloat[0] = this.apV.aku.getTranslationX();
    }
    paramArrayOfFloat[1] = this.apV.aku.getTranslationY();
  }
  
  private void ld()
  {
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  final void M(RecyclerView.v paramv)
  {
    if (this.adt.isLayoutRequested()) {}
    int m;
    int n;
    label483:
    do
    {
      float f;
      do
      {
        do
        {
          return;
        } while (this.aqf != 2);
        f = this.aqe.lf();
        m = (int)(this.aqc + this.aqa);
        n = (int)(this.aqd + this.aqb);
      } while ((Math.abs(n - paramv.aku.getTop()) < paramv.aku.getHeight() * f) && (Math.abs(m - paramv.aku.getLeft()) < f * paramv.aku.getWidth()));
      int i1;
      int i2;
      int i3;
      int i4;
      int i5;
      int i6;
      int i7;
      int i;
      if (this.aqj == null)
      {
        this.aqj = new ArrayList();
        this.aqk = new ArrayList();
        i1 = Math.round(this.aqc + this.aqa) + 0;
        i2 = Math.round(this.aqd + this.aqb) + 0;
        i3 = paramv.aku.getWidth() + i1 + 0;
        i4 = paramv.aku.getHeight() + i2 + 0;
        i5 = (i1 + i3) / 2;
        i6 = (i2 + i4) / 2;
        localObject = this.adt.getLayoutManager();
        i7 = ((RecyclerView.i)localObject).getChildCount();
        i = 0;
      }
      for (;;)
      {
        if (i >= i7) {
          break label483;
        }
        View localView = ((RecyclerView.i)localObject).getChildAt(i);
        if ((localView != paramv.aku) && (localView.getBottom() >= i2) && (localView.getTop() <= i4) && (localView.getRight() >= i1) && (localView.getLeft() <= i3))
        {
          RecyclerView.v localv = this.adt.bb(localView);
          int j = Math.abs(i5 - (localView.getLeft() + localView.getRight()) / 2);
          int k = localView.getTop();
          k = Math.abs(i6 - (localView.getBottom() + k) / 2);
          int i8 = j * j + k * k;
          k = 0;
          int i9 = this.aqj.size();
          j = 0;
          for (;;)
          {
            if ((j < i9) && (i8 > ((Integer)this.aqk.get(j)).intValue()))
            {
              k += 1;
              j += 1;
              continue;
              this.aqj.clear();
              this.aqk.clear();
              break;
            }
          }
          this.aqj.add(k, localv);
          this.aqk.add(k, Integer.valueOf(i8));
        }
        i += 1;
      }
      localObject = this.aqj;
    } while (((List)localObject).size() == 0);
    Object localObject = a.a.a(paramv, (List)localObject, m, n);
    if (localObject == null)
    {
      this.aqj.clear();
      this.aqk.clear();
      return;
    }
    ((RecyclerView.v)localObject).jN();
    paramv.jN();
    this.aqe.a(paramv, (RecyclerView.v)localObject);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    int k = 0;
    if (this.apV != null) {
      f(this.apU);
    }
    RecyclerView.v localv = this.apV;
    List localList = this.aqh;
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      localList.get(i);
      paramCanvas.restoreToCount(paramCanvas.save());
      i += 1;
    }
    if (localv != null) {
      paramCanvas.restoreToCount(paramCanvas.save());
    }
    j -= 1;
    i = k;
    if (j >= 0)
    {
      paramCanvas = (c)localList.get(j);
      if ((paramCanvas.tn) && (!paramCanvas.aqG)) {
        localList.remove(j);
      }
    }
    for (;;)
    {
      j -= 1;
      break;
      if (!paramCanvas.tn)
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
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    this.aqm = -1;
    float f2;
    float f1;
    if (this.apV != null)
    {
      f(this.apU);
      f2 = this.apU[0];
      f1 = this.apU[1];
    }
    for (;;)
    {
      params = this.aqe;
      RecyclerView.v localv = this.apV;
      List localList = this.aqh;
      int j = this.aqf;
      int k = localList.size();
      int i = 0;
      if (i < k)
      {
        c localc = (c)localList.get(i);
        if (localc.aqA == localc.aqC)
        {
          localc.mX = localc.ajy.aku.getTranslationX();
          label122:
          if (localc.aqB != localc.aqD) {
            break label231;
          }
        }
        label231:
        for (localc.mY = localc.ajy.aku.getTranslationY();; localc.mY = (localc.aqB + localc.aqI * (localc.aqD - localc.aqB)))
        {
          int m = paramCanvas.save();
          params.a(paramCanvas, paramRecyclerView, localc.ajy, localc.mX, localc.mY, localc.aqf, false);
          paramCanvas.restoreToCount(m);
          i += 1;
          break;
          localc.mX = (localc.aqA + localc.aqI * (localc.aqC - localc.aqA));
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
    this.aqa = (f1 - this.apW);
    this.aqb = (f2 - this.apX);
    if ((paramInt1 & 0x4) == 0) {
      this.aqa = Math.max(0.0F, this.aqa);
    }
    if ((paramInt1 & 0x8) == 0) {
      this.aqa = Math.min(0.0F, this.aqa);
    }
    if ((paramInt1 & 0x1) == 0) {
      this.aqb = Math.max(0.0F, this.aqb);
    }
    if ((paramInt1 & 0x2) == 0) {
      this.aqb = Math.min(0.0F, this.aqb);
    }
  }
  
  final boolean a(int paramInt1, MotionEvent paramMotionEvent, int paramInt2)
  {
    Object localObject2 = null;
    if ((this.apV != null) || (paramInt1 != 2) || (this.aqf == 2) || (!this.aqe.le())) {}
    for (;;)
    {
      return false;
      if (this.adt.getScrollState() != 1)
      {
        RecyclerView.i locali = this.adt.getLayoutManager();
        Object localObject1;
        if (this.mActivePointerId == -1) {
          localObject1 = localObject2;
        }
        while (localObject1 != null)
        {
          a.a.j(this.adt);
          return false;
          paramInt1 = paramMotionEvent.findPointerIndex(this.mActivePointerId);
          float f3 = paramMotionEvent.getX(paramInt1);
          float f4 = this.apW;
          float f1 = paramMotionEvent.getY(paramInt1);
          float f2 = this.apX;
          f3 = Math.abs(f3 - f4);
          f1 = Math.abs(f1 - f2);
          if (f3 < this.amw)
          {
            localObject1 = localObject2;
            if (f1 < this.amw) {}
          }
          else if (f3 > f1)
          {
            localObject1 = localObject2;
            if (locali.ij()) {}
          }
          else if (f1 > f3)
          {
            localObject1 = localObject2;
            if (locali.ik()) {}
          }
          else
          {
            paramMotionEvent = k(paramMotionEvent);
            localObject1 = localObject2;
            if (paramMotionEvent != null) {
              localObject1 = this.adt.bb(paramMotionEvent);
            }
          }
        }
      }
    }
  }
  
  final int b(RecyclerView.v paramv, boolean paramBoolean)
  {
    int i = this.aqh.size() - 1;
    while (i >= 0)
    {
      c localc = (c)this.aqh.get(i);
      if (localc.ajy == paramv)
      {
        localc.aqH |= paramBoolean;
        if (!localc.tn) {
          localc.aqE.cancel();
        }
        this.aqh.remove(i);
        return localc.aqF;
      }
      i -= 1;
    }
    return 0;
  }
  
  public final void bJ(View paramView)
  {
    ca(paramView);
    paramView = this.adt.bb(paramView);
    if (paramView == null) {}
    do
    {
      return;
      if ((this.apV != null) && (paramView == this.apV))
      {
        e(null, 0);
        return;
      }
      b(paramView, false);
    } while (!this.apT.remove(paramView.aku));
    this.aqe.a(this.adt, paramView);
  }
  
  final void ca(View paramView)
  {
    if (paramView == this.aql)
    {
      this.aql = null;
      if (this.aiS != null) {
        this.adt.setChildDrawingOrderCallback(null);
      }
    }
  }
  
  final void e(RecyclerView.v paramv, int paramInt)
  {
    if ((paramv == this.apV) && (paramInt == this.aqf)) {
      return;
    }
    this.aqq = -9223372036854775808L;
    int k = this.aqf;
    b(paramv, true);
    this.aqf = paramInt;
    if (paramInt == 2)
    {
      this.aql = paramv.aku;
      if (Build.VERSION.SDK_INT < 21)
      {
        if (this.aiS == null) {
          this.aiS = new a.5(this);
        }
        this.adt.setChildDrawingOrderCallback(this.aiS);
      }
    }
    int i = 0;
    int j = 0;
    Object localObject;
    if (this.apV != null)
    {
      localObject = this.apV;
      if (((RecyclerView.v)localObject).aku.getParent() == null) {
        break label411;
      }
      if ((k != 2) && (this.aqf != 2)) {
        a.a.cL(t.T(this.adt));
      }
      ld();
      if (k == 2)
      {
        i = 8;
        f(this.apU);
        localObject = new a.3(this, (RecyclerView.v)localObject, i, k, this.apU[0], this.apU[1], 0.0F, 0.0F, 0, (RecyclerView.v)localObject);
        long l = a.a.d(this.adt, i);
        ((c)localObject).aqE.setDuration(l);
        this.aqh.add(localObject);
        ((c)localObject).ajy.ap(false);
        ((c)localObject).aqE.start();
        i = 1;
        label252:
        this.apV = null;
      }
    }
    else
    {
      if (paramv != null)
      {
        this.aqg = ((a.a.j(this.adt) & (1 << paramInt * 8 + 8) - 1) >> this.aqf * 8);
        this.aqc = paramv.aku.getLeft();
        this.aqd = paramv.aku.getTop();
        this.apV = paramv;
        if (paramInt == 2) {
          this.apV.aku.performHapticFeedback(0);
        }
      }
      paramv = this.adt.getParent();
      if (paramv != null) {
        if (this.apV == null) {
          break label439;
        }
      }
    }
    label411:
    label439:
    for (boolean bool = true;; bool = false)
    {
      paramv.requestDisallowInterceptTouchEvent(bool);
      if (i == 0) {
        this.adt.getLayoutManager().ajp = true;
      }
      this.aqe.f(this.apV, this.aqf);
      this.adt.invalidate();
      return;
      i = 4;
      break;
      ca(((RecyclerView.v)localObject).aku);
      this.aqe.a(this.adt, (RecyclerView.v)localObject);
      i = j;
      break label252;
    }
  }
  
  public final void i(RecyclerView paramRecyclerView)
  {
    if (this.adt == paramRecyclerView) {}
    do
    {
      return;
      if (this.adt != null)
      {
        this.adt.c(this);
        this.adt.b(this.aqp);
        Object localObject = this.adt;
        if (((RecyclerView)localObject).ail != null) {
          ((RecyclerView)localObject).ail.remove(this);
        }
        int i = this.aqh.size() - 1;
        while (i >= 0)
        {
          localObject = (c)this.aqh.get(0);
          this.aqe.a(this.adt, ((c)localObject).ajy);
          i -= 1;
        }
        this.aqh.clear();
        this.aql = null;
        this.aqm = -1;
        ld();
        if (this.aqo != null)
        {
          this.aqo.aqz = false;
          this.aqo = null;
        }
        if (this.aqn != null) {
          this.aqn = null;
        }
      }
      this.adt = paramRecyclerView;
    } while (paramRecyclerView == null);
    paramRecyclerView = paramRecyclerView.getResources();
    this.apY = paramRecyclerView.getDimension(2131428480);
    this.apZ = paramRecyclerView.getDimension(2131428479);
    this.amw = ViewConfiguration.get(this.adt.getContext()).getScaledTouchSlop();
    this.adt.a(this);
    this.adt.a(this.aqp);
    paramRecyclerView = this.adt;
    if (paramRecyclerView.ail == null) {
      paramRecyclerView.ail = new ArrayList();
    }
    paramRecyclerView.ail.add(this);
    this.aqo = new a.b(this);
    this.aqn = new c(this.adt.getContext(), this.aqo);
  }
  
  final View k(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.apV != null)
    {
      paramMotionEvent = this.apV.aku;
      if (a(paramMotionEvent, f1, f2, this.aqc + this.aqa, this.aqd + this.aqb)) {
        return paramMotionEvent;
      }
    }
    int i = this.aqh.size() - 1;
    while (i >= 0)
    {
      paramMotionEvent = (c)this.aqh.get(i);
      View localView = paramMotionEvent.ajy.aku;
      if (a(localView, f1, f2, paramMotionEvent.mX, paramMotionEvent.mY)) {
        return localView;
      }
      i -= 1;
    }
    return this.adt.x(f1, f2);
  }
  
  static class c
    implements Animator.AnimatorListener
  {
    final RecyclerView.v ajy;
    final float aqA;
    final float aqB;
    final float aqC;
    final float aqD;
    final ValueAnimator aqE;
    final int aqF;
    public boolean aqG;
    boolean aqH = false;
    float aqI;
    final int aqf;
    float mX;
    float mY;
    boolean tn = false;
    
    c(RecyclerView.v paramv, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.aqf = paramInt2;
      this.aqF = paramInt1;
      this.ajy = paramv;
      this.aqA = paramFloat1;
      this.aqB = paramFloat2;
      this.aqC = paramFloat3;
      this.aqD = paramFloat4;
      this.aqE = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.aqE.addUpdateListener(new a.c.1(this));
      this.aqE.setTarget(paramv.aku);
      this.aqE.addListener(this);
      this.aqI = 0.0F;
    }
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      this.aqI = 1.0F;
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (!this.tn) {
        this.ajy.ap(true);
      }
      this.tn = true;
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v7.widget.a.a
 * JD-Core Version:    0.7.0.1
 */