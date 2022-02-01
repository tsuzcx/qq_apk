package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import androidx.core.g.d;
import androidx.core.g.w;
import androidx.recyclerview.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import java.util.ArrayList;
import java.util.List;

public final class l
  extends RecyclerView.h
  implements RecyclerView.i
{
  Rect Si;
  final List<View> ahQ;
  private final float[] ahR;
  RecyclerView.v ahS;
  float ahT;
  float ahU;
  private float ahV;
  private float ahW;
  public float ahX;
  public float ahY;
  float ahZ;
  float aia;
  public a aib;
  private int aic;
  int aie;
  List<c> aif;
  final Runnable aig;
  private List<RecyclerView.v> aih;
  private List<Integer> aii;
  private RecyclerView.d aij;
  View aik;
  int ail;
  d aim;
  private b ain;
  private final RecyclerView.k aio;
  long aip;
  int mActivePointerId;
  public RecyclerView mRecyclerView;
  VelocityTracker mVelocityTracker;
  private int vm;
  
  public l(a parama)
  {
    AppMethodBeat.i(261493);
    this.ahQ = new ArrayList();
    this.ahR = new float[2];
    this.ahS = null;
    this.mActivePointerId = -1;
    this.aic = 0;
    this.aif = new ArrayList();
    this.aig = new Runnable()
    {
      public final void run()
      {
        int k = 0;
        AppMethodBeat.i(261381);
        l locall;
        long l2;
        long l1;
        Object localObject;
        int j;
        int i;
        label154:
        int m;
        label211:
        RecyclerView localRecyclerView;
        if (l.this.ahS != null)
        {
          locall = l.this;
          if (locall.ahS == null) {
            break label560;
          }
          l2 = System.currentTimeMillis();
          if (locall.aip != -9223372036854775808L) {
            break label419;
          }
          l1 = 0L;
          localObject = locall.mRecyclerView.getLayoutManager();
          if (locall.Si == null) {
            locall.Si = new Rect();
          }
          ((RecyclerView.LayoutManager)localObject).calculateItemDecorationsForChild(locall.ahS.amk, locall.Si);
          if (!((RecyclerView.LayoutManager)localObject).canScrollHorizontally()) {
            break label489;
          }
          j = (int)(locall.ahZ + locall.ahX);
          i = j - locall.Si.left - locall.mRecyclerView.getPaddingLeft();
          if ((locall.ahX >= 0.0F) || (i >= 0)) {
            break label432;
          }
          if (!((RecyclerView.LayoutManager)localObject).canScrollVertically()) {
            break label555;
          }
          m = (int)(locall.aia + locall.ahY);
          j = m - locall.Si.top - locall.mRecyclerView.getPaddingTop();
          if ((locall.ahY >= 0.0F) || (j >= 0)) {
            break label494;
          }
          if (i == 0) {
            break label576;
          }
          localObject = locall.aib;
          localRecyclerView = locall.mRecyclerView;
          m = locall.ahS.amk.getWidth();
          locall.mRecyclerView.getWidth();
          i = ((l.a)localObject).a(localRecyclerView, m, i, l1);
        }
        label419:
        label432:
        label560:
        label576:
        for (;;)
        {
          if (j != 0)
          {
            localObject = locall.aib;
            localRecyclerView = locall.mRecyclerView;
            m = locall.ahS.amk.getHeight();
            locall.mRecyclerView.getHeight();
            j = ((l.a)localObject).a(localRecyclerView, m, j, l1);
          }
          for (;;)
          {
            if ((i != 0) || (j != 0))
            {
              if (locall.aip == -9223372036854775808L) {
                locall.aip = l2;
              }
              locall.mRecyclerView.scrollBy(i, j);
            }
            for (i = 1;; i = k)
            {
              if (i != 0)
              {
                if (l.this.ahS != null) {
                  l.this.e(l.this.ahS);
                }
                l.this.mRecyclerView.removeCallbacks(l.this.aig);
                w.a(l.this.mRecyclerView, this);
              }
              AppMethodBeat.o(261381);
              return;
              l1 = l2 - locall.aip;
              break;
              if (locall.ahX > 0.0F)
              {
                j = j + locall.ahS.amk.getWidth() + locall.Si.right - (locall.mRecyclerView.getWidth() - locall.mRecyclerView.getPaddingRight());
                i = j;
                if (j > 0) {
                  break label154;
                }
              }
              label489:
              i = 0;
              break label154;
              label494:
              if (locall.ahY > 0.0F)
              {
                m = m + locall.ahS.amk.getHeight() + locall.Si.bottom - (locall.mRecyclerView.getHeight() - locall.mRecyclerView.getPaddingBottom());
                j = m;
                if (m > 0) {
                  break label211;
                }
              }
              j = 0;
              break label211;
              locall.aip = -9223372036854775808L;
            }
          }
        }
      }
    };
    this.aij = null;
    this.aik = null;
    this.ail = -1;
    this.aio = new RecyclerView.k()
    {
      public final boolean a(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(261388);
        l.this.aim.onTouchEvent(paramAnonymousMotionEvent);
        int i = paramAnonymousMotionEvent.getActionMasked();
        if (i == 0)
        {
          l.this.mActivePointerId = paramAnonymousMotionEvent.getPointerId(0);
          l.this.ahT = paramAnonymousMotionEvent.getX();
          l.this.ahU = paramAnonymousMotionEvent.getY();
          l.this.kx();
          if (l.this.ahS == null)
          {
            l locall = l.this;
            if (locall.aif.isEmpty()) {
              break label325;
            }
            View localView = locall.k(paramAnonymousMotionEvent);
            i = locall.aif.size() - 1;
            if (i < 0) {
              break label325;
            }
            paramAnonymousRecyclerView = (l.c)locall.aif.get(i);
            if (paramAnonymousRecyclerView.aiC.amk != localView) {
              break label318;
            }
            label148:
            if (paramAnonymousRecyclerView != null)
            {
              locall = l.this;
              locall.ahT -= paramAnonymousRecyclerView.mX;
              locall = l.this;
              locall.ahU -= paramAnonymousRecyclerView.mY;
              l.this.a(paramAnonymousRecyclerView.aiC, true);
              if (l.this.ahQ.remove(paramAnonymousRecyclerView.aiC.amk)) {
                l.this.aib.d(l.this.mRecyclerView, paramAnonymousRecyclerView.aiC);
              }
              l.this.a(paramAnonymousRecyclerView.aiC, paramAnonymousRecyclerView.aic);
              l.this.a(paramAnonymousMotionEvent, l.this.aie, 0);
            }
          }
        }
        for (;;)
        {
          if (l.this.mVelocityTracker != null) {
            l.this.mVelocityTracker.addMovement(paramAnonymousMotionEvent);
          }
          if (l.this.ahS == null) {
            break label403;
          }
          AppMethodBeat.o(261388);
          return true;
          label318:
          i -= 1;
          break;
          label325:
          paramAnonymousRecyclerView = null;
          break label148;
          if ((i == 3) || (i == 1))
          {
            l.this.mActivePointerId = -1;
            l.this.a(null, 0);
          }
          else if (l.this.mActivePointerId != -1)
          {
            int j = paramAnonymousMotionEvent.findPointerIndex(l.this.mActivePointerId);
            if (j >= 0) {
              l.this.a(i, paramAnonymousMotionEvent, j);
            }
          }
        }
        label403:
        AppMethodBeat.o(261388);
        return false;
      }
      
      public final void ao(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(261390);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(261390);
          return;
        }
        l.this.a(null, 0);
        AppMethodBeat.o(261390);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
      {
        int i = 0;
        AppMethodBeat.i(261389);
        l.this.aim.onTouchEvent(paramAnonymousMotionEvent);
        if (l.this.mVelocityTracker != null) {
          l.this.mVelocityTracker.addMovement(paramAnonymousMotionEvent);
        }
        if (l.this.mActivePointerId == -1)
        {
          AppMethodBeat.o(261389);
          return;
        }
        int j = paramAnonymousMotionEvent.getActionMasked();
        int k = paramAnonymousMotionEvent.findPointerIndex(l.this.mActivePointerId);
        if (k >= 0) {
          l.this.a(j, paramAnonymousMotionEvent, k);
        }
        paramAnonymousRecyclerView = l.this.ahS;
        if (paramAnonymousRecyclerView == null)
        {
          AppMethodBeat.o(261389);
          return;
        }
        switch (j)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(261389);
          return;
          if (k >= 0)
          {
            l.this.a(paramAnonymousMotionEvent, l.this.aie, k);
            l.this.e(paramAnonymousRecyclerView);
            l.this.mRecyclerView.removeCallbacks(l.this.aig);
            l.this.aig.run();
            l.this.mRecyclerView.invalidate();
            AppMethodBeat.o(261389);
            return;
            if (l.this.mVelocityTracker != null) {
              l.this.mVelocityTracker.clear();
            }
            l.this.a(null, 0);
            l.this.mActivePointerId = -1;
            AppMethodBeat.o(261389);
            return;
            j = paramAnonymousMotionEvent.getActionIndex();
            if (paramAnonymousMotionEvent.getPointerId(j) == l.this.mActivePointerId)
            {
              if (j == 0) {
                i = 1;
              }
              l.this.mActivePointerId = paramAnonymousMotionEvent.getPointerId(i);
              l.this.a(paramAnonymousMotionEvent, l.this.aie, j);
            }
          }
        }
      }
    };
    this.aib = parama;
    AppMethodBeat.o(261493);
  }
  
  private static boolean a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(261494);
    if ((paramFloat1 >= paramFloat3) && (paramFloat1 <= paramView.getWidth() + paramFloat3) && (paramFloat2 >= paramFloat4) && (paramFloat2 <= paramView.getHeight() + paramFloat4))
    {
      AppMethodBeat.o(261494);
      return true;
    }
    AppMethodBeat.o(261494);
    return false;
  }
  
  private int cy(int paramInt)
  {
    int j = 8;
    AppMethodBeat.i(261543);
    if ((paramInt & 0xC) != 0)
    {
      int i;
      float f2;
      if (this.ahX > 0.0F)
      {
        i = 8;
        if ((this.mVelocityTracker == null) || (this.mActivePointerId < 0)) {
          break label150;
        }
        this.mVelocityTracker.computeCurrentVelocity(1000, a.s(this.ahW));
        f2 = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
        f1 = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
        if (f2 <= 0.0F) {
          break label144;
        }
      }
      for (;;)
      {
        f2 = Math.abs(f2);
        if (((j & paramInt) == 0) || (i != j) || (f2 < a.r(this.ahV)) || (f2 <= Math.abs(f1))) {
          break label150;
        }
        AppMethodBeat.o(261543);
        return j;
        i = 4;
        break;
        label144:
        j = 4;
      }
      label150:
      float f1 = this.mRecyclerView.getWidth();
      if (((paramInt & i) != 0) && (Math.abs(this.ahX) > f1 * 0.5F))
      {
        AppMethodBeat.o(261543);
        return i;
      }
    }
    AppMethodBeat.o(261543);
    return 0;
  }
  
  private int cz(int paramInt)
  {
    int j = 2;
    AppMethodBeat.i(261545);
    if ((paramInt & 0x3) != 0)
    {
      int i;
      float f2;
      if (this.ahY > 0.0F)
      {
        i = 2;
        if ((this.mVelocityTracker == null) || (this.mActivePointerId < 0)) {
          break label147;
        }
        this.mVelocityTracker.computeCurrentVelocity(1000, a.s(this.ahW));
        f1 = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
        f2 = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
        if (f2 <= 0.0F) {
          break label141;
        }
      }
      for (;;)
      {
        f2 = Math.abs(f2);
        if (((j & paramInt) == 0) || (j != i) || (f2 < a.r(this.ahV)) || (f2 <= Math.abs(f1))) {
          break label147;
        }
        AppMethodBeat.o(261545);
        return j;
        i = 1;
        break;
        label141:
        j = 1;
      }
      label147:
      float f1 = this.mRecyclerView.getHeight();
      if (((paramInt & i) != 0) && (Math.abs(this.ahY) > f1 * 0.5F))
      {
        AppMethodBeat.o(261545);
        return i;
      }
    }
    AppMethodBeat.o(261545);
    return 0;
  }
  
  private void g(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(261501);
    if ((this.aie & 0xC) != 0) {
      paramArrayOfFloat[0] = (this.ahZ + this.ahX - this.ahS.amk.getLeft());
    }
    while ((this.aie & 0x3) != 0)
    {
      paramArrayOfFloat[1] = (this.aia + this.ahY - this.ahS.amk.getTop());
      AppMethodBeat.o(261501);
      return;
      paramArrayOfFloat[0] = this.ahS.amk.getTranslationX();
    }
    paramArrayOfFloat[1] = this.ahS.amk.getTranslationY();
    AppMethodBeat.o(261501);
  }
  
  private void ky()
  {
    AppMethodBeat.i(261531);
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
    AppMethodBeat.o(261531);
  }
  
  final void a(int paramInt1, MotionEvent paramMotionEvent, int paramInt2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(261536);
    if ((this.ahS != null) || (paramInt1 != 2) || (this.aic == 2) || (!this.aib.kA()))
    {
      AppMethodBeat.o(261536);
      return;
    }
    if (this.mRecyclerView.getScrollState() == 1)
    {
      AppMethodBeat.o(261536);
      return;
    }
    Object localObject3 = this.mRecyclerView.getLayoutManager();
    Object localObject1;
    if (this.mActivePointerId == -1) {
      localObject1 = localObject2;
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(261536);
      return;
      paramInt1 = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      f3 = paramMotionEvent.getX(paramInt1);
      f4 = this.ahT;
      f1 = paramMotionEvent.getY(paramInt1);
      f2 = this.ahU;
      f3 = Math.abs(f3 - f4);
      f1 = Math.abs(f1 - f2);
      if (f3 < this.vm)
      {
        localObject1 = localObject2;
        if (f1 < this.vm) {}
      }
      else if (f3 > f1)
      {
        localObject1 = localObject2;
        if (((RecyclerView.LayoutManager)localObject3).canScrollHorizontally()) {}
      }
      else if (f1 > f3)
      {
        localObject1 = localObject2;
        if (((RecyclerView.LayoutManager)localObject3).canScrollVertically()) {}
      }
      else
      {
        localObject3 = k(paramMotionEvent);
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = this.mRecyclerView.aQ((View)localObject3);
        }
      }
    }
    paramInt1 = (this.aib.b(this.mRecyclerView, (RecyclerView.v)localObject1) & 0xFF00) >> 8;
    if (paramInt1 == 0)
    {
      AppMethodBeat.o(261536);
      return;
    }
    float f1 = paramMotionEvent.getX(paramInt2);
    float f2 = paramMotionEvent.getY(paramInt2);
    f1 -= this.ahT;
    f2 -= this.ahU;
    float f3 = Math.abs(f1);
    float f4 = Math.abs(f2);
    if ((f3 < this.vm) && (f4 < this.vm))
    {
      AppMethodBeat.o(261536);
      return;
    }
    if (f3 > f4)
    {
      if ((f1 < 0.0F) && ((paramInt1 & 0x4) == 0))
      {
        AppMethodBeat.o(261536);
        return;
      }
      if ((f1 > 0.0F) && ((paramInt1 & 0x8) == 0)) {
        AppMethodBeat.o(261536);
      }
    }
    else
    {
      if ((f2 < 0.0F) && ((paramInt1 & 0x1) == 0))
      {
        AppMethodBeat.o(261536);
        return;
      }
      if ((f2 > 0.0F) && ((paramInt1 & 0x2) == 0))
      {
        AppMethodBeat.o(261536);
        return;
      }
    }
    this.ahY = 0.0F;
    this.ahX = 0.0F;
    this.mActivePointerId = paramMotionEvent.getPointerId(0);
    a((RecyclerView.v)localObject1, 1);
    AppMethodBeat.o(261536);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(261504);
    this.ail = -1;
    float f2;
    float f1;
    if (this.ahS != null)
    {
      g(this.ahR);
      f2 = this.ahR[0];
      f1 = this.ahR[1];
    }
    for (;;)
    {
      params = this.aib;
      RecyclerView.v localv = this.ahS;
      List localList = this.aif;
      int j = this.aic;
      int k = localList.size();
      int i = 0;
      if (i < k)
      {
        c localc = (c)localList.get(i);
        if (localc.aiy == localc.aiA)
        {
          localc.mX = localc.aiC.amk.getTranslationX();
          label128:
          if (localc.aiz != localc.aiB) {
            break label237;
          }
        }
        label237:
        for (localc.mY = localc.aiC.amk.getTranslationY();; localc.mY = (localc.aiz + localc.aiH * (localc.aiB - localc.aiz)))
        {
          int m = paramCanvas.save();
          params.a(paramCanvas, paramRecyclerView, localc.aiC, localc.mX, localc.mY, localc.aic, false);
          paramCanvas.restoreToCount(m);
          i += 1;
          break;
          localc.mX = (localc.aiy + localc.aiH * (localc.aiA - localc.aiy));
          break label128;
        }
      }
      if (localv != null)
      {
        i = paramCanvas.save();
        params.a(paramCanvas, paramRecyclerView, localv, f2, f1, j, true);
        paramCanvas.restoreToCount(i);
      }
      AppMethodBeat.o(261504);
      return;
      f1 = 0.0F;
      f2 = 0.0F;
    }
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(261527);
    paramRect.setEmpty();
    AppMethodBeat.o(261527);
  }
  
  final void a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(261540);
    float f1 = paramMotionEvent.getX(paramInt2);
    float f2 = paramMotionEvent.getY(paramInt2);
    this.ahX = (f1 - this.ahT);
    this.ahY = (f2 - this.ahU);
    if ((paramInt1 & 0x4) == 0) {
      this.ahX = Math.max(0.0F, this.ahX);
    }
    if ((paramInt1 & 0x8) == 0) {
      this.ahX = Math.min(0.0F, this.ahX);
    }
    if ((paramInt1 & 0x1) == 0) {
      this.ahY = Math.max(0.0F, this.ahY);
    }
    if ((paramInt1 & 0x2) == 0) {
      this.ahY = Math.min(0.0F, this.ahY);
    }
    AppMethodBeat.o(261540);
  }
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(261506);
    if ((paramv == this.ahS) && (paramInt == this.aic))
    {
      AppMethodBeat.o(261506);
      return;
    }
    this.aip = -9223372036854775808L;
    int k = this.aic;
    a(paramv, true);
    this.aic = paramInt;
    if (paramInt == 2)
    {
      if (paramv == null)
      {
        paramv = new IllegalArgumentException("Must pass a ViewHolder when dragging");
        AppMethodBeat.o(261506);
        throw paramv;
      }
      this.aik = paramv.amk;
      if (Build.VERSION.SDK_INT < 21)
      {
        if (this.aij == null) {
          this.aij = new RecyclerView.d()
          {
            public final int ap(int paramAnonymousInt1, int paramAnonymousInt2)
            {
              AppMethodBeat.i(261405);
              if (l.this.aik == null)
              {
                AppMethodBeat.o(261405);
                return paramAnonymousInt2;
              }
              int j = l.this.ail;
              int i = j;
              if (j == -1)
              {
                i = l.this.mRecyclerView.indexOfChild(l.this.aik);
                l.this.ail = i;
              }
              if (paramAnonymousInt2 == paramAnonymousInt1 - 1)
              {
                AppMethodBeat.o(261405);
                return i;
              }
              if (paramAnonymousInt2 < i)
              {
                AppMethodBeat.o(261405);
                return paramAnonymousInt2;
              }
              AppMethodBeat.o(261405);
              return paramAnonymousInt2 + 1;
            }
          };
        }
        this.mRecyclerView.setChildDrawingOrderCallback(this.aij);
      }
    }
    final int i = 0;
    int j = 0;
    Object localObject;
    int m;
    int n;
    float f1;
    float f2;
    if (this.ahS != null)
    {
      localObject = this.ahS;
      if (((RecyclerView.v)localObject).amk.getParent() == null) {
        break label766;
      }
      if ((k == 2) || (this.aic == 2)) {
        break label638;
      }
      i = this.aib.a(this.mRecyclerView, (RecyclerView.v)localObject);
      m = (a.ar(i, w.I(this.mRecyclerView)) & 0xFF00) >> 8;
      if (m == 0) {
        break label638;
      }
      n = (i & 0xFF00) >> 8;
      if (Math.abs(this.ahX) <= Math.abs(this.ahY)) {
        break label644;
      }
      j = cy(m);
      if (j > 0)
      {
        i = j;
        if ((n & j) == 0) {
          i = a.aq(j, w.I(this.mRecyclerView));
        }
        ky();
      }
    }
    else
    {
      switch (i)
      {
      default: 
        f1 = 0.0F;
        f2 = 0.0F;
        label349:
        if (k == 2)
        {
          j = 8;
          label359:
          g(this.ahR);
          localObject = new c((RecyclerView.v)localObject, j, k, this.ahR[0], this.ahR[1], f1, f2)
          {
            public final void onAnimationEnd(Animator paramAnonymousAnimator)
            {
              AppMethodBeat.i(261394);
              super.onAnimationEnd(paramAnonymousAnimator);
              if (this.aiG)
              {
                AppMethodBeat.o(261394);
                return;
              }
              if (i <= 0) {
                l.this.aib.d(l.this.mRecyclerView, this.ais);
              }
              for (;;)
              {
                if (l.this.aik == this.ais.amk) {
                  l.this.aV(this.ais.amk);
                }
                AppMethodBeat.o(261394);
                return;
                l.this.ahQ.add(this.ais.amk);
                this.aiF = true;
                if (i > 0)
                {
                  paramAnonymousAnimator = l.this;
                  int i = i;
                  paramAnonymousAnimator.mRecyclerView.post(new l.4(paramAnonymousAnimator, this, i));
                }
              }
            }
          };
          long l = a.a(this.mRecyclerView, j);
          ((c)localObject).aiD.setDuration(l);
          this.aif.add(localObject);
          ((c)localObject).aiC.ax(false);
          ((c)localObject).aiD.start();
          i = 1;
          this.ahS = null;
          if (paramv != null)
          {
            this.aie = ((this.aib.b(this.mRecyclerView, paramv) & (1 << paramInt * 8 + 8) - 1) >> this.aic * 8);
            this.ahZ = paramv.amk.getLeft();
            this.aia = paramv.amk.getTop();
            this.ahS = paramv;
            if (paramInt == 2) {
              this.ahS.amk.performHapticFeedback(0);
            }
          }
          paramv = this.mRecyclerView.getParent();
          if (paramv != null) {
            if (this.ahS == null) {
              break label795;
            }
          }
        }
        label456:
        break;
      }
    }
    label644:
    label795:
    for (boolean bool = true;; bool = false)
    {
      paramv.requestDisallowInterceptTouchEvent(bool);
      if (i == 0) {
        this.mRecyclerView.getLayoutManager().requestSimpleAnimationsInNextLayout();
      }
      this.aib.b(this.ahS, this.aic);
      this.mRecyclerView.invalidate();
      AppMethodBeat.o(261506);
      return;
      j = cz(m);
      i = j;
      if (j > 0) {
        break;
      }
      label638:
      do
      {
        i = 0;
        break;
        j = cz(m);
        i = j;
        if (j > 0) {
          break;
        }
        j = cy(m);
      } while (j <= 0);
      i = j;
      if ((n & j) != 0) {
        break;
      }
      i = a.aq(j, w.I(this.mRecyclerView));
      break;
      f2 = 0.0F;
      f1 = Math.signum(this.ahX) * this.mRecyclerView.getWidth();
      break label349;
      f1 = 0.0F;
      f2 = Math.signum(this.ahY) * this.mRecyclerView.getHeight();
      break label349;
      if (i > 0)
      {
        j = 2;
        break label359;
      }
      j = 4;
      break label359;
      label766:
      aV(((RecyclerView.v)localObject).amk);
      this.aib.d(this.mRecyclerView, (RecyclerView.v)localObject);
      i = j;
      break label456;
    }
  }
  
  final void a(RecyclerView.v paramv, boolean paramBoolean)
  {
    AppMethodBeat.i(261524);
    int i = this.aif.size() - 1;
    while (i >= 0)
    {
      c localc = (c)this.aif.get(i);
      if (localc.aiC == paramv)
      {
        localc.aiG |= paramBoolean;
        if (!localc.VX) {
          localc.aiD.cancel();
        }
        this.aif.remove(i);
        AppMethodBeat.o(261524);
        return;
      }
      i -= 1;
    }
    AppMethodBeat.o(261524);
  }
  
  public final void a(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(261498);
    if (this.mRecyclerView == paramRecyclerView)
    {
      AppMethodBeat.o(261498);
      return;
    }
    if (this.mRecyclerView != null)
    {
      this.mRecyclerView.c(this);
      this.mRecyclerView.b(this.aio);
      Object localObject = this.mRecyclerView;
      if (((RecyclerView)localObject).akn != null) {
        ((RecyclerView)localObject).akn.remove(this);
      }
      int i = this.aif.size() - 1;
      while (i >= 0)
      {
        localObject = (c)this.aif.get(0);
        this.aib.d(this.mRecyclerView, ((c)localObject).aiC);
        i -= 1;
      }
      this.aif.clear();
      this.aik = null;
      this.ail = -1;
      ky();
      if (this.ain != null)
      {
        this.ain.aix = false;
        this.ain = null;
      }
      if (this.aim != null) {
        this.aim = null;
      }
    }
    this.mRecyclerView = paramRecyclerView;
    if (paramRecyclerView != null)
    {
      paramRecyclerView = paramRecyclerView.getResources();
      this.ahV = paramRecyclerView.getDimension(a.a.item_touch_helper_swipe_escape_velocity);
      this.ahW = paramRecyclerView.getDimension(a.a.item_touch_helper_swipe_escape_max_velocity);
      this.vm = ViewConfiguration.get(this.mRecyclerView.getContext()).getScaledTouchSlop();
      this.mRecyclerView.a(this);
      this.mRecyclerView.a(this.aio);
      this.mRecyclerView.a(this);
      this.ain = new b();
      this.aim = new d(this.mRecyclerView.getContext(), this.ain);
    }
    AppMethodBeat.o(261498);
  }
  
  public final void aT(View paramView) {}
  
  public final void aU(View paramView)
  {
    AppMethodBeat.i(261519);
    aV(paramView);
    paramView = this.mRecyclerView.aQ(paramView);
    if (paramView == null)
    {
      AppMethodBeat.o(261519);
      return;
    }
    if ((this.ahS != null) && (paramView == this.ahS))
    {
      a(null, 0);
      AppMethodBeat.o(261519);
      return;
    }
    a(paramView, false);
    if (this.ahQ.remove(paramView.amk)) {
      this.aib.d(this.mRecyclerView, paramView);
    }
    AppMethodBeat.o(261519);
  }
  
  final void aV(View paramView)
  {
    AppMethodBeat.i(261547);
    if (paramView == this.aik)
    {
      this.aik = null;
      if (this.aij != null) {
        this.mRecyclerView.setChildDrawingOrderCallback(null);
      }
    }
    AppMethodBeat.o(261547);
  }
  
  public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    int k = 0;
    AppMethodBeat.i(261503);
    if (this.ahS != null) {
      g(this.ahR);
    }
    RecyclerView.v localv = this.ahS;
    params = this.aif;
    int j = params.size();
    int i = 0;
    while (i < j)
    {
      params.get(i);
      int m = paramCanvas.save();
      a.kB();
      paramCanvas.restoreToCount(m);
      i += 1;
    }
    if (localv != null)
    {
      i = paramCanvas.save();
      a.kB();
      paramCanvas.restoreToCount(i);
    }
    j -= 1;
    i = k;
    if (j >= 0)
    {
      paramCanvas = (c)params.get(j);
      if ((paramCanvas.VX) && (!paramCanvas.aiF)) {
        params.remove(j);
      }
    }
    for (;;)
    {
      j -= 1;
      break;
      if (!paramCanvas.VX)
      {
        i = 1;
        continue;
        if (i != 0) {
          paramRecyclerView.invalidate();
        }
        AppMethodBeat.o(261503);
        return;
      }
    }
  }
  
  final void e(RecyclerView.v paramv)
  {
    AppMethodBeat.i(261512);
    if (this.mRecyclerView.isLayoutRequested())
    {
      AppMethodBeat.o(261512);
      return;
    }
    if (this.aic != 2)
    {
      AppMethodBeat.o(261512);
      return;
    }
    float f = this.aib.f(paramv);
    int m = (int)(this.ahZ + this.ahX);
    int n = (int)(this.aia + this.ahY);
    if ((Math.abs(n - paramv.amk.getTop()) < paramv.amk.getHeight() * f) && (Math.abs(m - paramv.amk.getLeft()) < f * paramv.amk.getWidth()))
    {
      AppMethodBeat.o(261512);
      return;
    }
    int i1;
    int i2;
    int i3;
    int i4;
    int i5;
    int i6;
    int i7;
    if (this.aih == null)
    {
      this.aih = new ArrayList();
      this.aii = new ArrayList();
      i1 = Math.round(this.ahZ + this.ahX) + 0;
      i2 = Math.round(this.aia + this.ahY) + 0;
      i3 = paramv.amk.getWidth() + i1 + 0;
      i4 = paramv.amk.getHeight() + i2 + 0;
      i5 = (i1 + i3) / 2;
      i6 = (i2 + i4) / 2;
      localObject = this.mRecyclerView.getLayoutManager();
      i7 = ((RecyclerView.LayoutManager)localObject).getChildCount();
      i = 0;
    }
    for (;;)
    {
      if (i >= i7) {
        break label510;
      }
      View localView = ((RecyclerView.LayoutManager)localObject).getChildAt(i);
      if ((localView != paramv.amk) && (localView.getBottom() >= i2) && (localView.getTop() <= i4) && (localView.getRight() >= i1) && (localView.getLeft() <= i3))
      {
        RecyclerView.v localv = this.mRecyclerView.aQ(localView);
        int j = Math.abs(i5 - (localView.getLeft() + localView.getRight()) / 2);
        int k = localView.getTop();
        k = Math.abs(i6 - (localView.getBottom() + k) / 2);
        int i8 = j * j + k * k;
        k = 0;
        int i9 = this.aih.size();
        j = 0;
        for (;;)
        {
          if ((j < i9) && (i8 > ((Integer)this.aii.get(j)).intValue()))
          {
            k += 1;
            j += 1;
            continue;
            this.aih.clear();
            this.aii.clear();
            break;
          }
        }
        this.aih.add(k, localv);
        this.aii.add(k, Integer.valueOf(i8));
      }
      i += 1;
    }
    label510:
    Object localObject = this.aih;
    if (((List)localObject).size() == 0)
    {
      AppMethodBeat.o(261512);
      return;
    }
    localObject = a.a(paramv, (List)localObject, m, n);
    if (localObject == null)
    {
      this.aih.clear();
      this.aii.clear();
      AppMethodBeat.o(261512);
      return;
    }
    int i = ((RecyclerView.v)localObject).md();
    paramv.md();
    if (this.aib.a(this.mRecyclerView, paramv, (RecyclerView.v)localObject)) {
      a.a(this.mRecyclerView, paramv, (RecyclerView.v)localObject, i);
    }
    AppMethodBeat.o(261512);
  }
  
  final View k(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(261538);
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.ahS != null)
    {
      paramMotionEvent = this.ahS.amk;
      if (a(paramMotionEvent, f1, f2, this.ahZ + this.ahX, this.aia + this.ahY))
      {
        AppMethodBeat.o(261538);
        return paramMotionEvent;
      }
    }
    int i = this.aif.size() - 1;
    while (i >= 0)
    {
      paramMotionEvent = (c)this.aif.get(i);
      View localView = paramMotionEvent.aiC.amk;
      if (a(localView, f1, f2, paramMotionEvent.mX, paramMotionEvent.mY))
      {
        AppMethodBeat.o(261538);
        return localView;
      }
      i -= 1;
    }
    paramMotionEvent = this.mRecyclerView.h(f1, f2);
    AppMethodBeat.o(261538);
    return paramMotionEvent;
  }
  
  public final void kx()
  {
    AppMethodBeat.i(261529);
    if (this.mVelocityTracker != null) {
      this.mVelocityTracker.recycle();
    }
    this.mVelocityTracker = VelocityTracker.obtain();
    AppMethodBeat.o(261529);
  }
  
  public static abstract class a
  {
    private static final Interpolator aiu = new Interpolator()
    {
      public final float getInterpolation(float paramAnonymousFloat)
      {
        return paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat;
      }
    };
    private static final Interpolator aiv = new Interpolator()
    {
      public final float getInterpolation(float paramAnonymousFloat)
      {
        paramAnonymousFloat -= 1.0F;
        return paramAnonymousFloat * (paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat) + 1.0F;
      }
    };
    private int aiw = -1;
    
    public static long a(RecyclerView paramRecyclerView, int paramInt)
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
        return paramRecyclerView.ali;
      }
      return paramRecyclerView.lK();
    }
    
    public static RecyclerView.v a(RecyclerView.v paramv, List<RecyclerView.v> paramList, int paramInt1, int paramInt2)
    {
      int m = paramv.amk.getWidth();
      int n = paramv.amk.getHeight();
      int i = -1;
      int i1 = paramInt1 - paramv.amk.getLeft();
      int i2 = paramInt2 - paramv.amk.getTop();
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
        k = ((RecyclerView.v)localObject1).amk.getRight() - (paramInt1 + m);
        if ((k >= 0) || (((RecyclerView.v)localObject1).amk.getRight() <= paramv.amk.getRight())) {
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
        k = ((RecyclerView.v)localObject1).amk.getLeft() - paramInt1;
        if ((k <= 0) || (((RecyclerView.v)localObject1).amk.getLeft() >= paramv.amk.getLeft())) {
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
          k = ((RecyclerView.v)localObject1).amk.getTop() - paramInt2;
          if ((k > 0) && (((RecyclerView.v)localObject1).amk.getTop() < paramv.amk.getTop()))
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
            k = ((RecyclerView.v)localObject1).amk.getBottom() - (paramInt2 + n);
            if ((k < 0) && (((RecyclerView.v)localObject1).amk.getBottom() > paramv.amk.getBottom()))
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
      if ((localLayoutManager instanceof l.d)) {
        ((l.d)localLayoutManager).d(paramv1.amk, paramv2.amk);
      }
      do
      {
        do
        {
          return;
          if (localLayoutManager.canScrollHorizontally())
          {
            if (localLayoutManager.getDecoratedLeft(paramv2.amk) <= paramRecyclerView.getPaddingLeft())
            {
              paramv1 = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
              com.tencent.mm.hellhoundlib.a.a.b(paramRecyclerView, paramv1.aFh(), "androidx/recyclerview/widget/ItemTouchHelper$Callback", "onMoved", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILandroidx/recyclerview/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
              paramRecyclerView.scrollToPosition(((Integer)paramv1.sf(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.c(paramRecyclerView, "androidx/recyclerview/widget/ItemTouchHelper$Callback", "onMoved", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILandroidx/recyclerview/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
            }
            if (localLayoutManager.getDecoratedRight(paramv2.amk) >= paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight())
            {
              paramv1 = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
              com.tencent.mm.hellhoundlib.a.a.b(paramRecyclerView, paramv1.aFh(), "androidx/recyclerview/widget/ItemTouchHelper$Callback", "onMoved", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILandroidx/recyclerview/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
              paramRecyclerView.scrollToPosition(((Integer)paramv1.sf(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.c(paramRecyclerView, "androidx/recyclerview/widget/ItemTouchHelper$Callback", "onMoved", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILandroidx/recyclerview/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
            }
          }
        } while (!localLayoutManager.canScrollVertically());
        if (localLayoutManager.getDecoratedTop(paramv2.amk) <= paramRecyclerView.getPaddingTop())
        {
          paramv1 = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.b(paramRecyclerView, paramv1.aFh(), "androidx/recyclerview/widget/ItemTouchHelper$Callback", "onMoved", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILandroidx/recyclerview/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
          paramRecyclerView.scrollToPosition(((Integer)paramv1.sf(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(paramRecyclerView, "androidx/recyclerview/widget/ItemTouchHelper$Callback", "onMoved", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILandroidx/recyclerview/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
        }
      } while (localLayoutManager.getDecoratedBottom(paramv2.amk) < paramRecyclerView.getHeight() - paramRecyclerView.getPaddingBottom());
      paramv1 = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramRecyclerView, paramv1.aFh(), "androidx/recyclerview/widget/ItemTouchHelper$Callback", "onMoved", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILandroidx/recyclerview/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
      paramRecyclerView.scrollToPosition(((Integer)paramv1.sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramRecyclerView, "androidx/recyclerview/widget/ItemTouchHelper$Callback", "onMoved", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILandroidx/recyclerview/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
    }
    
    public static int aq(int paramInt1, int paramInt2)
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
    
    public static int ar(int paramInt1, int paramInt2)
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
    
    private int b(RecyclerView paramRecyclerView)
    {
      if (this.aiw == -1) {
        this.aiw = paramRecyclerView.getResources().getDimensionPixelSize(a.a.item_touch_helper_max_drag_scroll_per_frame);
      }
      return this.aiw;
    }
    
    public static int cA(int paramInt)
    {
      return (paramInt | 0x0) << 0 | 0x0 | paramInt << 16;
    }
    
    public static void kB()
    {
      m localm = n.aiJ;
    }
    
    public static float r(float paramFloat)
    {
      return paramFloat;
    }
    
    public static float s(float paramFloat)
    {
      return paramFloat;
    }
    
    public final int a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, long paramLong)
    {
      float f1 = 1.0F;
      int i = b(paramRecyclerView);
      int j = Math.abs(paramInt2);
      int k = (int)Math.signum(paramInt2);
      float f2 = Math.min(1.0F, j * 1.0F / paramInt1);
      paramInt1 = (int)(i * k * aiv.getInterpolation(f2));
      if (paramLong > 2000L) {}
      for (;;)
      {
        f2 = paramInt1;
        i = (int)(aiu.getInterpolation(f1) * f2);
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
      n.aiJ.a(paramRecyclerView, paramv.amk, paramFloat1, paramFloat2, paramBoolean);
    }
    
    public abstract boolean a(RecyclerView paramRecyclerView, RecyclerView.v paramv1, RecyclerView.v paramv2);
    
    final int b(RecyclerView paramRecyclerView, RecyclerView.v paramv)
    {
      return ar(a(paramRecyclerView, paramv), w.I(paramRecyclerView));
    }
    
    public void b(RecyclerView.v paramv, int paramInt)
    {
      if (paramv != null) {
        paramv = n.aiJ;
      }
    }
    
    public final boolean c(RecyclerView paramRecyclerView, RecyclerView.v paramv)
    {
      return (b(paramRecyclerView, paramv) & 0xFF0000) != 0;
    }
    
    public void d(RecyclerView paramRecyclerView, RecyclerView.v paramv)
    {
      n.aiJ.aW(paramv.amk);
    }
    
    public float f(RecyclerView.v paramv)
    {
      return 0.5F;
    }
    
    public abstract void g(RecyclerView.v paramv);
    
    public boolean kA()
    {
      return true;
    }
    
    public boolean kz()
    {
      return true;
    }
  }
  
  final class b
    extends GestureDetector.SimpleOnGestureListener
  {
    boolean aix = true;
    
    b() {}
    
    public final boolean onDown(MotionEvent paramMotionEvent)
    {
      return true;
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(261457);
      if (!this.aix)
      {
        AppMethodBeat.o(261457);
        return;
      }
      Object localObject = l.this.k(paramMotionEvent);
      if (localObject != null)
      {
        localObject = l.this.mRecyclerView.aQ((View)localObject);
        if (localObject != null)
        {
          if (!l.this.aib.c(l.this.mRecyclerView, (RecyclerView.v)localObject))
          {
            AppMethodBeat.o(261457);
            return;
          }
          if (paramMotionEvent.getPointerId(0) == l.this.mActivePointerId)
          {
            int i = paramMotionEvent.findPointerIndex(l.this.mActivePointerId);
            float f1 = paramMotionEvent.getX(i);
            float f2 = paramMotionEvent.getY(i);
            l.this.ahT = f1;
            l.this.ahU = f2;
            paramMotionEvent = l.this;
            l.this.ahY = 0.0F;
            paramMotionEvent.ahX = 0.0F;
            if (l.this.aib.kz()) {
              l.this.a((RecyclerView.v)localObject, 2);
            }
          }
        }
      }
      AppMethodBeat.o(261457);
    }
  }
  
  static class c
    implements Animator.AnimatorListener
  {
    boolean VX;
    final float aiA;
    final float aiB;
    final RecyclerView.v aiC;
    final ValueAnimator aiD;
    final int aiE;
    boolean aiF;
    boolean aiG;
    float aiH;
    final int aic;
    final float aiy;
    final float aiz;
    float mX;
    float mY;
    
    c(RecyclerView.v paramv, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(261472);
      this.aiG = false;
      this.VX = false;
      this.aic = paramInt2;
      this.aiE = paramInt1;
      this.aiC = paramv;
      this.aiy = paramFloat1;
      this.aiz = paramFloat2;
      this.aiA = paramFloat3;
      this.aiB = paramFloat4;
      this.aiD = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.aiD.addUpdateListener(new l.c.1(this));
      this.aiD.setTarget(paramv.amk);
      this.aiD.addListener(this);
      this.aiH = 0.0F;
      AppMethodBeat.o(261472);
    }
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      this.aiH = 1.0F;
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(261476);
      if (!this.VX) {
        this.aiC.ax(true);
      }
      this.VX = true;
      AppMethodBeat.o(261476);
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator) {}
  }
  
  public static abstract interface d
  {
    public abstract void d(View paramView1, View paramView2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.recyclerview.widget.l
 * JD-Core Version:    0.7.0.1
 */