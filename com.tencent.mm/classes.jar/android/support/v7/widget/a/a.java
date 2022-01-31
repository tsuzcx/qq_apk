package android.support.v7.widget.a;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.c;
import android.support.v4.view.q;
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
  RecyclerView acI;
  private RecyclerView.d agC = null;
  private int akg;
  final List<View> anC = new ArrayList();
  private final float[] anD = new float[2];
  RecyclerView.v anE = null;
  float anF;
  float anG;
  float anH;
  float anI;
  float anJ;
  float anK;
  float anL;
  float anM;
  a.a anN;
  int anO = 0;
  int anP;
  List<a.c> anQ = new ArrayList();
  final Runnable anR = new a.1(this);
  private List<RecyclerView.v> anS;
  private List<Integer> anT;
  View anU = null;
  int anV = -1;
  c anW;
  private a.b anX;
  private final RecyclerView.l anY = new a.2(this);
  long anZ;
  VelocityTracker fB;
  int fC = -1;
  Rect hc;
  
  public a(a.a parama)
  {
    this.anN = parama;
  }
  
  private static boolean a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (paramFloat1 >= paramFloat3) && (paramFloat1 <= paramView.getWidth() + paramFloat3) && (paramFloat2 >= paramFloat4) && (paramFloat2 <= paramView.getHeight() + paramFloat4);
  }
  
  private int ct(int paramInt)
  {
    int j = 8;
    if ((paramInt & 0xC) != 0)
    {
      int i;
      if (this.anJ > 0.0F)
      {
        i = 8;
        if ((this.fB == null) || (this.fC < 0)) {
          break label140;
        }
        this.fB.computeCurrentVelocity(1000, a.a.M(this.anI));
        f2 = this.fB.getXVelocity(this.fC);
        f1 = this.fB.getYVelocity(this.fC);
        if (f2 <= 0.0F) {
          break label134;
        }
      }
      for (;;)
      {
        f2 = Math.abs(f2);
        if (((j & paramInt) == 0) || (i != j) || (f2 < a.a.L(this.anH)) || (f2 <= Math.abs(f1))) {
          break label140;
        }
        return j;
        i = 4;
        break;
        label134:
        j = 4;
      }
      label140:
      float f1 = this.acI.getWidth();
      float f2 = a.a.jo();
      if (((paramInt & i) != 0) && (Math.abs(this.anJ) > f1 * f2)) {
        return i;
      }
    }
    return 0;
  }
  
  private int cu(int paramInt)
  {
    int j = 2;
    if ((paramInt & 0x3) != 0)
    {
      int i;
      if (this.anK > 0.0F)
      {
        i = 2;
        if ((this.fB == null) || (this.fC < 0)) {
          break label137;
        }
        this.fB.computeCurrentVelocity(1000, a.a.M(this.anI));
        f1 = this.fB.getXVelocity(this.fC);
        f2 = this.fB.getYVelocity(this.fC);
        if (f2 <= 0.0F) {
          break label131;
        }
      }
      for (;;)
      {
        f2 = Math.abs(f2);
        if (((j & paramInt) == 0) || (j != i) || (f2 < a.a.L(this.anH)) || (f2 <= Math.abs(f1))) {
          break label137;
        }
        return j;
        i = 1;
        break;
        label131:
        j = 1;
      }
      label137:
      float f1 = this.acI.getHeight();
      float f2 = a.a.jo();
      if (((paramInt & i) != 0) && (Math.abs(this.anK) > f1 * f2)) {
        return i;
      }
    }
    return 0;
  }
  
  private void f(float[] paramArrayOfFloat)
  {
    if ((this.anP & 0xC) != 0) {
      paramArrayOfFloat[0] = (this.anL + this.anJ - this.anE.aie.getLeft());
    }
    while ((this.anP & 0x3) != 0)
    {
      paramArrayOfFloat[1] = (this.anM + this.anK - this.anE.aie.getTop());
      return;
      paramArrayOfFloat[0] = this.anE.aie.getTranslationX();
    }
    paramArrayOfFloat[1] = this.anE.aie.getTranslationY();
  }
  
  private void ji()
  {
    if (this.fB != null)
    {
      this.fB.recycle();
      this.fB = null;
    }
  }
  
  final void G(RecyclerView.v paramv)
  {
    if (this.acI.isLayoutRequested()) {}
    int m;
    int n;
    label491:
    do
    {
      float f;
      do
      {
        do
        {
          return;
        } while (this.anO != 2);
        f = this.anN.jp();
        m = (int)(this.anL + this.anJ);
        n = (int)(this.anM + this.anK);
      } while ((Math.abs(n - paramv.aie.getTop()) < paramv.aie.getHeight() * f) && (Math.abs(m - paramv.aie.getLeft()) < f * paramv.aie.getWidth()));
      int i1;
      int i2;
      int i3;
      int i4;
      int i5;
      int i6;
      int i7;
      int i;
      if (this.anS == null)
      {
        this.anS = new ArrayList();
        this.anT = new ArrayList();
        a.a.jn();
        i1 = Math.round(this.anL + this.anJ) + 0;
        i2 = Math.round(this.anM + this.anK) + 0;
        i3 = paramv.aie.getWidth() + i1 + 0;
        i4 = paramv.aie.getHeight() + i2 + 0;
        i5 = (i1 + i3) / 2;
        i6 = (i2 + i4) / 2;
        localObject = this.acI.getLayoutManager();
        i7 = ((RecyclerView.i)localObject).getChildCount();
        i = 0;
      }
      for (;;)
      {
        if (i >= i7) {
          break label491;
        }
        View localView = ((RecyclerView.i)localObject).getChildAt(i);
        if ((localView != paramv.aie) && (localView.getBottom() >= i2) && (localView.getTop() <= i4) && (localView.getRight() >= i1) && (localView.getLeft() <= i3))
        {
          RecyclerView.v localv = this.acI.aT(localView);
          a.a.jk();
          int j = Math.abs(i5 - (localView.getLeft() + localView.getRight()) / 2);
          int k = localView.getTop();
          k = Math.abs(i6 - (localView.getBottom() + k) / 2);
          int i8 = j * j + k * k;
          k = 0;
          int i9 = this.anS.size();
          j = 0;
          for (;;)
          {
            if ((j < i9) && (i8 > ((Integer)this.anT.get(j)).intValue()))
            {
              k += 1;
              j += 1;
              continue;
              this.anS.clear();
              this.anT.clear();
              break;
            }
          }
          this.anS.add(k, localv);
          this.anT.add(k, Integer.valueOf(i8));
        }
        i += 1;
      }
      localObject = this.anS;
    } while (((List)localObject).size() == 0);
    Object localObject = a.a.a(paramv, (List)localObject, m, n);
    if (localObject == null)
    {
      this.anS.clear();
      this.anT.clear();
      return;
    }
    ((RecyclerView.v)localObject).id();
    paramv.id();
    this.anN.a(paramv, (RecyclerView.v)localObject);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    int k = 0;
    if (this.anE != null) {
      f(this.anD);
    }
    RecyclerView.v localv = this.anE;
    List localList = this.anQ;
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      a.c localc = (a.c)localList.get(i);
      int m = paramCanvas.save();
      a.a.H(localc.ahi);
      paramCanvas.restoreToCount(m);
      i += 1;
    }
    if (localv != null)
    {
      i = paramCanvas.save();
      a.a.H(localv);
      paramCanvas.restoreToCount(i);
    }
    j -= 1;
    i = k;
    if (j >= 0)
    {
      paramCanvas = (a.c)localList.get(j);
      if ((paramCanvas.so) && (!paramCanvas.aop)) {
        localList.remove(j);
      }
    }
    for (;;)
    {
      j -= 1;
      break;
      if (!paramCanvas.so)
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
    this.anV = -1;
    float f2;
    float f1;
    if (this.anE != null)
    {
      f(this.anD);
      f2 = this.anD[0];
      f1 = this.anD[1];
    }
    for (;;)
    {
      params = this.anN;
      RecyclerView.v localv = this.anE;
      List localList = this.anQ;
      int j = this.anO;
      int k = localList.size();
      int i = 0;
      if (i < k)
      {
        a.c localc = (a.c)localList.get(i);
        if (localc.aoj == localc.aol)
        {
          localc.aoq = localc.ahi.aie.getTranslationX();
          label122:
          if (localc.aok != localc.aom) {
            break label231;
          }
        }
        label231:
        for (localc.aor = localc.ahi.aie.getTranslationY();; localc.aor = (localc.aok + localc.aot * (localc.aom - localc.aok)))
        {
          int m = paramCanvas.save();
          params.a(paramCanvas, paramRecyclerView, localc.ahi, localc.aoq, localc.aor, localc.anO, false);
          paramCanvas.restoreToCount(m);
          i += 1;
          break;
          localc.aoq = (localc.aoj + localc.aot * (localc.aol - localc.aoj));
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
    this.anJ = (f1 - this.anF);
    this.anK = (f2 - this.anG);
    if ((paramInt1 & 0x4) == 0) {
      this.anJ = Math.max(0.0F, this.anJ);
    }
    if ((paramInt1 & 0x8) == 0) {
      this.anJ = Math.min(0.0F, this.anJ);
    }
    if ((paramInt1 & 0x1) == 0) {
      this.anK = Math.max(0.0F, this.anK);
    }
    if ((paramInt1 & 0x2) == 0) {
      this.anK = Math.min(0.0F, this.anK);
    }
  }
  
  final boolean a(int paramInt1, MotionEvent paramMotionEvent, int paramInt2)
  {
    Object localObject2 = null;
    if ((this.anE != null) || (paramInt1 != 2) || (this.anO == 2) || (!this.anN.jm())) {}
    Object localObject3;
    Object localObject1;
    label67:
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
          do
          {
            return false;
          } while (this.acI.getScrollState() == 1);
          localObject3 = this.acI.getLayoutManager();
          if (this.fC != -1) {
            break;
          }
          localObject1 = localObject2;
          if (localObject1 == null) {
            break label371;
          }
          paramInt1 = (a.a.g(this.acI) & 0xFF00) >> 8;
        } while (paramInt1 == 0);
        f1 = paramMotionEvent.getX(paramInt2);
        f2 = paramMotionEvent.getY(paramInt2);
        f1 -= this.anF;
        f2 -= this.anG;
        f3 = Math.abs(f1);
        f4 = Math.abs(f2);
      } while ((f3 < this.akg) && (f4 < this.akg));
      if (f3 <= f4) {
        break label373;
      }
    } while (((f1 < 0.0F) && ((paramInt1 & 0x4) == 0)) || ((f1 > 0.0F) && ((paramInt1 & 0x8) == 0)));
    label371:
    label373:
    do
    {
      this.anK = 0.0F;
      this.anJ = 0.0F;
      this.fC = paramMotionEvent.getPointerId(0);
      e((RecyclerView.v)localObject1, 1);
      return true;
      paramInt1 = paramMotionEvent.findPointerIndex(this.fC);
      f3 = paramMotionEvent.getX(paramInt1);
      f4 = this.anF;
      f1 = paramMotionEvent.getY(paramInt1);
      f2 = this.anG;
      f3 = Math.abs(f3 - f4);
      f1 = Math.abs(f1 - f2);
      if (f3 < this.akg)
      {
        localObject1 = localObject2;
        if (f1 < this.akg) {
          break label67;
        }
      }
      if (f3 > f1)
      {
        localObject1 = localObject2;
        if (((RecyclerView.i)localObject3).gO()) {
          break label67;
        }
      }
      if (f1 > f3)
      {
        localObject1 = localObject2;
        if (((RecyclerView.i)localObject3).gP()) {
          break label67;
        }
      }
      localObject3 = k(paramMotionEvent);
      localObject1 = localObject2;
      if (localObject3 == null) {
        break label67;
      }
      localObject1 = this.acI.aT((View)localObject3);
      break label67;
      break;
      if ((f2 < 0.0F) && ((paramInt1 & 0x1) == 0)) {
        break;
      }
    } while ((f2 <= 0.0F) || ((paramInt1 & 0x2) != 0));
    return false;
  }
  
  final int b(RecyclerView.v paramv, boolean paramBoolean)
  {
    int i = this.anQ.size() - 1;
    while (i >= 0)
    {
      a.c localc = (a.c)this.anQ.get(i);
      if (localc.ahi == paramv)
      {
        localc.aos |= paramBoolean;
        if (!localc.so) {
          localc.aon.cancel();
        }
        this.anQ.remove(i);
        return localc.aoo;
      }
      i -= 1;
    }
    return 0;
  }
  
  final void bH(View paramView)
  {
    if (paramView == this.anU)
    {
      this.anU = null;
      if (this.agC != null) {
        this.acI.setChildDrawingOrderCallback(null);
      }
    }
  }
  
  public final void bu(View paramView)
  {
    bH(paramView);
    paramView = this.acI.aT(paramView);
    if (paramView == null) {}
    do
    {
      return;
      if ((this.anE != null) && (paramView == this.anE))
      {
        e(null, 0);
        return;
      }
      b(paramView, false);
    } while (!this.anC.remove(paramView.aie));
    this.anN.a(this.acI, paramView);
  }
  
  final void e(RecyclerView.v paramv, int paramInt)
  {
    if ((paramv == this.anE) && (paramInt == this.anO)) {
      return;
    }
    this.anZ = -9223372036854775808L;
    int k = this.anO;
    b(paramv, true);
    this.anO = paramInt;
    if (paramInt == 2)
    {
      this.anU = paramv.aie;
      if (Build.VERSION.SDK_INT < 21)
      {
        if (this.agC == null) {
          this.agC = new a.5(this);
        }
        this.acI.setChildDrawingOrderCallback(this.agC);
      }
    }
    int i = 0;
    int j = 0;
    Object localObject;
    int m;
    float f1;
    float f2;
    if (this.anE != null)
    {
      localObject = this.anE;
      if (((RecyclerView.v)localObject).aie.getParent() == null) {
        break label699;
      }
      if ((k == 2) || (this.anO == 2)) {
        break label572;
      }
      m = (a.a.aC(this.anN.jj(), q.Q(this.acI)) & 0xFF00) >> 8;
      if (m == 0) {
        break label572;
      }
      if (Math.abs(this.anJ) <= Math.abs(this.anK)) {
        break label578;
      }
      j = ct(m);
      if (j > 0)
      {
        i = j;
        if ((j & 0x0) == 0) {
          i = a.a.aB(j, q.Q(this.acI));
        }
        ji();
      }
    }
    else
    {
      switch (i)
      {
      default: 
        f1 = 0.0F;
        f2 = 0.0F;
        label293:
        if (k == 2)
        {
          j = 8;
          label303:
          f(this.anD);
          localObject = new a.3(this, (RecyclerView.v)localObject, j, k, this.anD[0], this.anD[1], f1, f2, i, (RecyclerView.v)localObject);
          long l = a.a.d(this.acI, j);
          ((a.c)localObject).aon.setDuration(l);
          this.anQ.add(localObject);
          ((a.c)localObject).ahi.ag(false);
          ((a.c)localObject).aon.start();
          i = 1;
          this.anE = null;
          if (paramv != null)
          {
            this.anP = ((a.a.g(this.acI) & (1 << paramInt * 8 + 8) - 1) >> this.anO * 8);
            this.anL = paramv.aie.getLeft();
            this.anM = paramv.aie.getTop();
            this.anE = paramv;
            if (paramInt == 2) {
              this.anE.aie.performHapticFeedback(0);
            }
          }
          paramv = this.acI.getParent();
          if (paramv != null) {
            if (this.anE == null) {
              break label728;
            }
          }
        }
        label400:
        break;
      }
    }
    label572:
    label578:
    label728:
    for (boolean bool = true;; bool = false)
    {
      paramv.requestDisallowInterceptTouchEvent(bool);
      if (i == 0) {
        this.acI.getLayoutManager().agZ = true;
      }
      this.anN.f(this.anE, this.anO);
      this.acI.invalidate();
      return;
      j = cu(m);
      i = j;
      if (j > 0) {
        break;
      }
      do
      {
        i = 0;
        break;
        j = cu(m);
        i = j;
        if (j > 0) {
          break;
        }
        j = ct(m);
      } while (j <= 0);
      i = j;
      if ((j & 0x0) != 0) {
        break;
      }
      i = a.a.aB(j, q.Q(this.acI));
      break;
      f2 = 0.0F;
      f1 = Math.signum(this.anJ) * this.acI.getWidth();
      break label293;
      f1 = 0.0F;
      f2 = Math.signum(this.anK) * this.acI.getHeight();
      break label293;
      if (i > 0)
      {
        j = 2;
        break label303;
      }
      j = 4;
      break label303;
      bH(((RecyclerView.v)localObject).aie);
      this.anN.a(this.acI, (RecyclerView.v)localObject);
      i = j;
      break label400;
    }
  }
  
  public final void f(RecyclerView paramRecyclerView)
  {
    if (this.acI == paramRecyclerView) {}
    do
    {
      return;
      if (this.acI != null)
      {
        this.acI.b(this);
        this.acI.b(this.anY);
        Object localObject = this.acI;
        if (((RecyclerView)localObject).afV != null) {
          ((RecyclerView)localObject).afV.remove(this);
        }
        int i = this.anQ.size() - 1;
        while (i >= 0)
        {
          localObject = (a.c)this.anQ.get(0);
          this.anN.a(this.acI, ((a.c)localObject).ahi);
          i -= 1;
        }
        this.anQ.clear();
        this.anU = null;
        this.anV = -1;
        ji();
        if (this.anX != null)
        {
          this.anX.aoi = false;
          this.anX = null;
        }
        if (this.anW != null) {
          this.anW = null;
        }
      }
      this.acI = paramRecyclerView;
    } while (paramRecyclerView == null);
    paramRecyclerView = paramRecyclerView.getResources();
    this.anH = paramRecyclerView.getDimension(android.support.v7.e.a.a.item_touch_helper_swipe_escape_velocity);
    this.anI = paramRecyclerView.getDimension(android.support.v7.e.a.a.item_touch_helper_swipe_escape_max_velocity);
    this.akg = ViewConfiguration.get(this.acI.getContext()).getScaledTouchSlop();
    this.acI.a(this);
    this.acI.a(this.anY);
    paramRecyclerView = this.acI;
    if (paramRecyclerView.afV == null) {
      paramRecyclerView.afV = new ArrayList();
    }
    paramRecyclerView.afV.add(this);
    this.anX = new a.b(this);
    this.anW = new c(this.acI.getContext(), this.anX);
  }
  
  final View k(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.anE != null)
    {
      paramMotionEvent = this.anE.aie;
      if (a(paramMotionEvent, f1, f2, this.anL + this.anJ, this.anM + this.anK)) {
        return paramMotionEvent;
      }
    }
    int i = this.anQ.size() - 1;
    while (i >= 0)
    {
      paramMotionEvent = (a.c)this.anQ.get(i);
      View localView = paramMotionEvent.ahi.aie;
      if (a(localView, f1, f2, paramMotionEvent.aoq, paramMotionEvent.aor)) {
        return localView;
      }
      i -= 1;
    }
    return this.acI.y(f1, f2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v7.widget.a.a
 * JD-Core Version:    0.7.0.1
 */