package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
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
import androidx.core.g.z;
import androidx.recyclerview.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import java.util.ArrayList;
import java.util.List;

public class k
  extends RecyclerView.h
  implements RecyclerView.i
{
  float bWA;
  private float bWB;
  private float bWC;
  float bWD;
  float bWE;
  float bWF;
  float bWG;
  a bWH;
  private int bWI;
  int bWJ;
  List<c> bWK;
  final Runnable bWL;
  private List<RecyclerView.v> bWM;
  private List<Integer> bWN;
  private RecyclerView.d bWO;
  View bWP;
  int bWQ;
  d bWR;
  private b bWS;
  private final RecyclerView.k bWT;
  long bWU;
  final List<View> bWw;
  private final float[] bWx;
  RecyclerView.v bWy;
  float bWz;
  Rect byy;
  int mActivePointerId;
  RecyclerView mRecyclerView;
  VelocityTracker mVelocityTracker;
  private int wi;
  
  public k(a parama)
  {
    AppMethodBeat.i(194768);
    this.bWw = new ArrayList();
    this.bWx = new float[2];
    this.bWy = null;
    this.mActivePointerId = -1;
    this.bWI = 0;
    this.bWK = new ArrayList();
    this.bWL = new Runnable()
    {
      public final void run()
      {
        int k = 0;
        AppMethodBeat.i(194999);
        k localk;
        long l2;
        long l1;
        Object localObject;
        int j;
        int i;
        label154:
        int m;
        label211:
        RecyclerView localRecyclerView;
        if (k.this.bWy != null)
        {
          localk = k.this;
          if (localk.bWy == null) {
            break label560;
          }
          l2 = System.currentTimeMillis();
          if (localk.bWU != -9223372036854775808L) {
            break label419;
          }
          l1 = 0L;
          localObject = localk.mRecyclerView.getLayoutManager();
          if (localk.byy == null) {
            localk.byy = new Rect();
          }
          ((RecyclerView.LayoutManager)localObject).calculateItemDecorationsForChild(localk.bWy.caK, localk.byy);
          if (!((RecyclerView.LayoutManager)localObject).canScrollHorizontally()) {
            break label489;
          }
          j = (int)(localk.bWF + localk.bWD);
          i = j - localk.byy.left - localk.mRecyclerView.getPaddingLeft();
          if ((localk.bWD >= 0.0F) || (i >= 0)) {
            break label432;
          }
          if (!((RecyclerView.LayoutManager)localObject).canScrollVertically()) {
            break label555;
          }
          m = (int)(localk.bWG + localk.bWE);
          j = m - localk.byy.top - localk.mRecyclerView.getPaddingTop();
          if ((localk.bWE >= 0.0F) || (j >= 0)) {
            break label494;
          }
          if (i == 0) {
            break label576;
          }
          localObject = localk.bWH;
          localRecyclerView = localk.mRecyclerView;
          m = localk.bWy.caK.getWidth();
          localk.mRecyclerView.getWidth();
          i = ((k.a)localObject).a(localRecyclerView, m, i, l1);
        }
        label419:
        label432:
        label560:
        label576:
        for (;;)
        {
          if (j != 0)
          {
            localObject = localk.bWH;
            localRecyclerView = localk.mRecyclerView;
            m = localk.bWy.caK.getHeight();
            localk.mRecyclerView.getHeight();
            j = ((k.a)localObject).a(localRecyclerView, m, j, l1);
          }
          for (;;)
          {
            if ((i != 0) || (j != 0))
            {
              if (localk.bWU == -9223372036854775808L) {
                localk.bWU = l2;
              }
              localk.mRecyclerView.scrollBy(i, j);
            }
            for (i = 1;; i = k)
            {
              if (i != 0)
              {
                if (k.this.bWy != null) {
                  k.this.e(k.this.bWy);
                }
                k.this.mRecyclerView.removeCallbacks(k.this.bWL);
                z.b(k.this.mRecyclerView, this);
              }
              AppMethodBeat.o(194999);
              return;
              l1 = l2 - localk.bWU;
              break;
              if (localk.bWD > 0.0F)
              {
                j = j + localk.bWy.caK.getWidth() + localk.byy.right - (localk.mRecyclerView.getWidth() - localk.mRecyclerView.getPaddingRight());
                i = j;
                if (j > 0) {
                  break label154;
                }
              }
              label489:
              i = 0;
              break label154;
              label494:
              if (localk.bWE > 0.0F)
              {
                m = m + localk.bWy.caK.getHeight() + localk.byy.bottom - (localk.mRecyclerView.getHeight() - localk.mRecyclerView.getPaddingBottom());
                j = m;
                if (m > 0) {
                  break label211;
                }
              }
              j = 0;
              break label211;
              localk.bWU = -9223372036854775808L;
            }
          }
        }
      }
    };
    this.bWO = null;
    this.bWP = null;
    this.bWQ = -1;
    this.bWT = new RecyclerView.k()
    {
      public final boolean a(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(194998);
        k.this.bWR.onTouchEvent(paramAnonymousMotionEvent);
        int i = paramAnonymousMotionEvent.getActionMasked();
        if (i == 0)
        {
          k.this.mActivePointerId = paramAnonymousMotionEvent.getPointerId(0);
          k.this.bWz = paramAnonymousMotionEvent.getX();
          k.this.bWA = paramAnonymousMotionEvent.getY();
          k.this.Jf();
          if (k.this.bWy == null)
          {
            k localk = k.this;
            if (localk.bWK.isEmpty()) {
              break label325;
            }
            View localView = localk.k(paramAnonymousMotionEvent);
            i = localk.bWK.size() - 1;
            if (i < 0) {
              break label325;
            }
            paramAnonymousRecyclerView = (k.c)localk.bWK.get(i);
            if (paramAnonymousRecyclerView.bXh.caK != localView) {
              break label318;
            }
            label148:
            if (paramAnonymousRecyclerView != null)
            {
              localk = k.this;
              localk.bWz -= paramAnonymousRecyclerView.mX;
              localk = k.this;
              localk.bWA -= paramAnonymousRecyclerView.mY;
              k.this.a(paramAnonymousRecyclerView.bXh, true);
              if (k.this.bWw.remove(paramAnonymousRecyclerView.bXh.caK)) {
                k.this.bWH.d(k.this.mRecyclerView, paramAnonymousRecyclerView.bXh);
              }
              k.this.a(paramAnonymousRecyclerView.bXh, paramAnonymousRecyclerView.bWI);
              k.this.a(paramAnonymousMotionEvent, k.this.bWJ, 0);
            }
          }
        }
        for (;;)
        {
          if (k.this.mVelocityTracker != null) {
            k.this.mVelocityTracker.addMovement(paramAnonymousMotionEvent);
          }
          if (k.this.bWy == null) {
            break label403;
          }
          AppMethodBeat.o(194998);
          return true;
          label318:
          i -= 1;
          break;
          label325:
          paramAnonymousRecyclerView = null;
          break label148;
          if ((i == 3) || (i == 1))
          {
            k.this.mActivePointerId = -1;
            k.this.a(null, 0);
          }
          else if (k.this.mActivePointerId != -1)
          {
            int j = paramAnonymousMotionEvent.findPointerIndex(k.this.mActivePointerId);
            if (j >= 0) {
              k.this.a(i, paramAnonymousMotionEvent, j);
            }
          }
        }
        label403:
        AppMethodBeat.o(194998);
        return false;
      }
      
      public final void aX(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(195023);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(195023);
          return;
        }
        k.this.a(null, 0);
        AppMethodBeat.o(195023);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
      {
        int i = 0;
        AppMethodBeat.i(195016);
        k.this.bWR.onTouchEvent(paramAnonymousMotionEvent);
        if (k.this.mVelocityTracker != null) {
          k.this.mVelocityTracker.addMovement(paramAnonymousMotionEvent);
        }
        if (k.this.mActivePointerId == -1)
        {
          AppMethodBeat.o(195016);
          return;
        }
        int j = paramAnonymousMotionEvent.getActionMasked();
        int k = paramAnonymousMotionEvent.findPointerIndex(k.this.mActivePointerId);
        if (k >= 0) {
          k.this.a(j, paramAnonymousMotionEvent, k);
        }
        paramAnonymousRecyclerView = k.this.bWy;
        if (paramAnonymousRecyclerView == null)
        {
          AppMethodBeat.o(195016);
          return;
        }
        switch (j)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(195016);
          return;
          if (k >= 0)
          {
            k.this.a(paramAnonymousMotionEvent, k.this.bWJ, k);
            k.this.e(paramAnonymousRecyclerView);
            k.this.mRecyclerView.removeCallbacks(k.this.bWL);
            k.this.bWL.run();
            k.this.mRecyclerView.invalidate();
            AppMethodBeat.o(195016);
            return;
            if (k.this.mVelocityTracker != null) {
              k.this.mVelocityTracker.clear();
            }
            k.this.a(null, 0);
            k.this.mActivePointerId = -1;
            AppMethodBeat.o(195016);
            return;
            j = paramAnonymousMotionEvent.getActionIndex();
            if (paramAnonymousMotionEvent.getPointerId(j) == k.this.mActivePointerId)
            {
              if (j == 0) {
                i = 1;
              }
              k.this.mActivePointerId = paramAnonymousMotionEvent.getPointerId(i);
              k.this.a(paramAnonymousMotionEvent, k.this.bWJ, j);
            }
          }
        }
      }
    };
    this.bWH = parama;
    AppMethodBeat.o(194768);
  }
  
  private void Jg()
  {
    AppMethodBeat.i(194790);
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
    AppMethodBeat.o(194790);
  }
  
  private static boolean a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(194773);
    if ((paramFloat1 >= paramFloat3) && (paramFloat1 <= paramView.getWidth() + paramFloat3) && (paramFloat2 >= paramFloat4) && (paramFloat2 <= paramView.getHeight() + paramFloat4))
    {
      AppMethodBeat.o(194773);
      return true;
    }
    AppMethodBeat.o(194773);
    return false;
  }
  
  private int fK(int paramInt)
  {
    int j = 8;
    AppMethodBeat.i(194805);
    if ((paramInt & 0xC) != 0)
    {
      int i;
      if (this.bWD > 0.0F)
      {
        i = 8;
        if ((this.mVelocityTracker == null) || (this.mActivePointerId < 0)) {
          break label150;
        }
        this.mVelocityTracker.computeCurrentVelocity(1000, a.az(this.bWC));
        f2 = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
        f1 = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
        if (f2 <= 0.0F) {
          break label144;
        }
      }
      for (;;)
      {
        f2 = Math.abs(f2);
        if (((j & paramInt) == 0) || (i != j) || (f2 < a.ay(this.bWB)) || (f2 <= Math.abs(f1))) {
          break label150;
        }
        AppMethodBeat.o(194805);
        return j;
        i = 4;
        break;
        label144:
        j = 4;
      }
      label150:
      float f1 = this.mRecyclerView.getWidth();
      float f2 = a.Jl();
      if (((paramInt & i) != 0) && (Math.abs(this.bWD) > f1 * f2))
      {
        AppMethodBeat.o(194805);
        return i;
      }
    }
    AppMethodBeat.o(194805);
    return 0;
  }
  
  private int fL(int paramInt)
  {
    int j = 2;
    AppMethodBeat.i(194814);
    if ((paramInt & 0x3) != 0)
    {
      int i;
      if (this.bWE > 0.0F)
      {
        i = 2;
        if ((this.mVelocityTracker == null) || (this.mActivePointerId < 0)) {
          break label147;
        }
        this.mVelocityTracker.computeCurrentVelocity(1000, a.az(this.bWC));
        f1 = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
        f2 = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
        if (f2 <= 0.0F) {
          break label141;
        }
      }
      for (;;)
      {
        f2 = Math.abs(f2);
        if (((j & paramInt) == 0) || (j != i) || (f2 < a.ay(this.bWB)) || (f2 <= Math.abs(f1))) {
          break label147;
        }
        AppMethodBeat.o(194814);
        return j;
        i = 1;
        break;
        label141:
        j = 1;
      }
      label147:
      float f1 = this.mRecyclerView.getHeight();
      float f2 = a.Jl();
      if (((paramInt & i) != 0) && (Math.abs(this.bWE) > f1 * f2))
      {
        AppMethodBeat.o(194814);
        return i;
      }
    }
    AppMethodBeat.o(194814);
    return 0;
  }
  
  private void p(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(194782);
    if ((this.bWJ & 0xC) != 0) {
      paramArrayOfFloat[0] = (this.bWF + this.bWD - this.bWy.caK.getLeft());
    }
    while ((this.bWJ & 0x3) != 0)
    {
      paramArrayOfFloat[1] = (this.bWG + this.bWE - this.bWy.caK.getTop());
      AppMethodBeat.o(194782);
      return;
      paramArrayOfFloat[0] = this.bWy.caK.getTranslationX();
    }
    paramArrayOfFloat[1] = this.bWy.caK.getTranslationY();
    AppMethodBeat.o(194782);
  }
  
  final void Jf()
  {
    AppMethodBeat.i(194927);
    if (this.mVelocityTracker != null) {
      this.mVelocityTracker.recycle();
    }
    this.mVelocityTracker = VelocityTracker.obtain();
    AppMethodBeat.o(194927);
  }
  
  final void a(int paramInt1, MotionEvent paramMotionEvent, int paramInt2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(194944);
    if ((this.bWy != null) || (paramInt1 != 2) || (this.bWI == 2) || (!this.bWH.Jj()))
    {
      AppMethodBeat.o(194944);
      return;
    }
    if (this.mRecyclerView.getScrollState() == 1)
    {
      AppMethodBeat.o(194944);
      return;
    }
    Object localObject3 = this.mRecyclerView.getLayoutManager();
    Object localObject1;
    if (this.mActivePointerId == -1) {
      localObject1 = localObject2;
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(194944);
      return;
      paramInt1 = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      f3 = paramMotionEvent.getX(paramInt1);
      f4 = this.bWz;
      f1 = paramMotionEvent.getY(paramInt1);
      f2 = this.bWA;
      f3 = Math.abs(f3 - f4);
      f1 = Math.abs(f1 - f2);
      if (f3 < this.wi)
      {
        localObject1 = localObject2;
        if (f1 < this.wi) {}
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
          localObject1 = this.mRecyclerView.bj((View)localObject3);
        }
      }
    }
    paramInt1 = (this.bWH.b(this.mRecyclerView, (RecyclerView.v)localObject1) & 0xFF00) >> 8;
    if (paramInt1 == 0)
    {
      AppMethodBeat.o(194944);
      return;
    }
    float f1 = paramMotionEvent.getX(paramInt2);
    float f2 = paramMotionEvent.getY(paramInt2);
    f1 -= this.bWz;
    f2 -= this.bWA;
    float f3 = Math.abs(f1);
    float f4 = Math.abs(f2);
    if ((f3 < this.wi) && (f4 < this.wi))
    {
      AppMethodBeat.o(194944);
      return;
    }
    if (f3 > f4)
    {
      if ((f1 < 0.0F) && ((paramInt1 & 0x4) == 0))
      {
        AppMethodBeat.o(194944);
        return;
      }
      if ((f1 > 0.0F) && ((paramInt1 & 0x8) == 0)) {
        AppMethodBeat.o(194944);
      }
    }
    else
    {
      if ((f2 < 0.0F) && ((paramInt1 & 0x1) == 0))
      {
        AppMethodBeat.o(194944);
        return;
      }
      if ((f2 > 0.0F) && ((paramInt1 & 0x2) == 0))
      {
        AppMethodBeat.o(194944);
        return;
      }
    }
    this.bWE = 0.0F;
    this.bWD = 0.0F;
    this.mActivePointerId = paramMotionEvent.getPointerId(0);
    a((RecyclerView.v)localObject1, 1);
    AppMethodBeat.o(194944);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(194854);
    this.bWQ = -1;
    float f2;
    float f1;
    if (this.bWy != null)
    {
      p(this.bWx);
      f2 = this.bWx[0];
      f1 = this.bWx[1];
    }
    for (;;)
    {
      params = this.bWH;
      RecyclerView.v localv = this.bWy;
      List localList = this.bWK;
      int j = this.bWI;
      int k = localList.size();
      int i = 0;
      if (i < k)
      {
        c localc = (c)localList.get(i);
        if (localc.bXd == localc.bXf)
        {
          localc.mX = localc.bXh.caK.getTranslationX();
          label128:
          if (localc.bXe != localc.bXg) {
            break label237;
          }
        }
        label237:
        for (localc.mY = localc.bXh.caK.getTranslationY();; localc.mY = (localc.bXe + localc.bXm * (localc.bXg - localc.bXe)))
        {
          int m = paramCanvas.save();
          params.a(paramCanvas, paramRecyclerView, localc.bXh, localc.mX, localc.mY, localc.bWI, false);
          paramCanvas.restoreToCount(m);
          i += 1;
          break;
          localc.mX = (localc.bXd + localc.bXm * (localc.bXf - localc.bXd));
          break label128;
        }
      }
      if (localv != null)
      {
        i = paramCanvas.save();
        params.a(paramCanvas, paramRecyclerView, localv, f2, f1, j, true);
        paramCanvas.restoreToCount(i);
      }
      AppMethodBeat.o(194854);
      return;
      f1 = 0.0F;
      f2 = 0.0F;
    }
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(194920);
    paramRect.setEmpty();
    AppMethodBeat.o(194920);
  }
  
  final void a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194972);
    float f1 = paramMotionEvent.getX(paramInt2);
    float f2 = paramMotionEvent.getY(paramInt2);
    this.bWD = (f1 - this.bWz);
    this.bWE = (f2 - this.bWA);
    if ((paramInt1 & 0x4) == 0) {
      this.bWD = Math.max(0.0F, this.bWD);
    }
    if ((paramInt1 & 0x8) == 0) {
      this.bWD = Math.min(0.0F, this.bWD);
    }
    if ((paramInt1 & 0x1) == 0) {
      this.bWE = Math.max(0.0F, this.bWE);
    }
    if ((paramInt1 & 0x2) == 0) {
      this.bWE = Math.min(0.0F, this.bWE);
    }
    AppMethodBeat.o(194972);
  }
  
  final void a(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(194876);
    if ((paramv == this.bWy) && (paramInt == this.bWI))
    {
      AppMethodBeat.o(194876);
      return;
    }
    this.bWU = -9223372036854775808L;
    int k = this.bWI;
    a(paramv, true);
    this.bWI = paramInt;
    if (paramInt == 2)
    {
      if (paramv == null)
      {
        paramv = new IllegalArgumentException("Must pass a ViewHolder when dragging");
        AppMethodBeat.o(194876);
        throw paramv;
      }
      this.bWP = paramv.caK;
      if (Build.VERSION.SDK_INT < 21)
      {
        if (this.bWO == null) {
          this.bWO = new RecyclerView.d()
          {
            public final int bi(int paramAnonymousInt1, int paramAnonymousInt2)
            {
              AppMethodBeat.i(194970);
              if (k.this.bWP == null)
              {
                AppMethodBeat.o(194970);
                return paramAnonymousInt2;
              }
              int j = k.this.bWQ;
              int i = j;
              if (j == -1)
              {
                i = k.this.mRecyclerView.indexOfChild(k.this.bWP);
                k.this.bWQ = i;
              }
              if (paramAnonymousInt2 == paramAnonymousInt1 - 1)
              {
                AppMethodBeat.o(194970);
                return i;
              }
              if (paramAnonymousInt2 < i)
              {
                AppMethodBeat.o(194970);
                return paramAnonymousInt2;
              }
              AppMethodBeat.o(194970);
              return paramAnonymousInt2 + 1;
            }
          };
        }
        this.mRecyclerView.setChildDrawingOrderCallback(this.bWO);
      }
    }
    final int i = 0;
    int j = 0;
    Object localObject;
    int m;
    int n;
    float f1;
    float f2;
    if (this.bWy != null)
    {
      localObject = this.bWy;
      if (((RecyclerView.v)localObject).caK.getParent() == null) {
        break label766;
      }
      if ((k == 2) || (this.bWI == 2)) {
        break label638;
      }
      i = this.bWH.a(this.mRecyclerView, (RecyclerView.v)localObject);
      m = (a.bl(i, z.U(this.mRecyclerView)) & 0xFF00) >> 8;
      if (m == 0) {
        break label638;
      }
      n = (i & 0xFF00) >> 8;
      if (Math.abs(this.bWD) <= Math.abs(this.bWE)) {
        break label644;
      }
      j = fK(m);
      if (j > 0)
      {
        i = j;
        if ((n & j) == 0) {
          i = a.bj(j, z.U(this.mRecyclerView));
        }
        Jg();
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
          p(this.bWx);
          localObject = new c((RecyclerView.v)localObject, j, k, this.bWx[0], this.bWx[1], f1, f2)
          {
            public final void onAnimationEnd(Animator paramAnonymousAnimator)
            {
              AppMethodBeat.i(194985);
              super.onAnimationEnd(paramAnonymousAnimator);
              if (this.bXl)
              {
                AppMethodBeat.o(194985);
                return;
              }
              if (i <= 0) {
                k.this.bWH.d(k.this.mRecyclerView, this.bWX);
              }
              for (;;)
              {
                if (k.this.bWP == this.bWX.caK) {
                  k.this.bo(this.bWX.caK);
                }
                AppMethodBeat.o(194985);
                return;
                k.this.bWw.add(this.bWX.caK);
                this.bXk = true;
                if (i > 0)
                {
                  paramAnonymousAnimator = k.this;
                  int i = i;
                  paramAnonymousAnimator.mRecyclerView.post(new k.4(paramAnonymousAnimator, this, i));
                }
              }
            }
          };
          long l = a.a(this.mRecyclerView, j);
          ((c)localObject).bXi.setDuration(l);
          this.bWK.add(localObject);
          ((c)localObject).bXh.bg(false);
          ((c)localObject).bXi.start();
          i = 1;
          this.bWy = null;
          if (paramv != null)
          {
            this.bWJ = ((this.bWH.b(this.mRecyclerView, paramv) & (1 << paramInt * 8 + 8) - 1) >> this.bWI * 8);
            this.bWF = paramv.caK.getLeft();
            this.bWG = paramv.caK.getTop();
            this.bWy = paramv;
            if (paramInt == 2) {
              this.bWy.caK.performHapticFeedback(0);
            }
          }
          paramv = this.mRecyclerView.getParent();
          if (paramv != null) {
            if (this.bWy == null) {
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
      this.bWH.b(this.bWy, this.bWI);
      this.mRecyclerView.invalidate();
      AppMethodBeat.o(194876);
      return;
      j = fL(m);
      i = j;
      if (j > 0) {
        break;
      }
      label638:
      do
      {
        i = 0;
        break;
        j = fL(m);
        i = j;
        if (j > 0) {
          break;
        }
        j = fK(m);
      } while (j <= 0);
      i = j;
      if ((n & j) != 0) {
        break;
      }
      i = a.bj(j, z.U(this.mRecyclerView));
      break;
      f2 = 0.0F;
      f1 = Math.signum(this.bWD) * this.mRecyclerView.getWidth();
      break label349;
      f1 = 0.0F;
      f2 = Math.signum(this.bWE) * this.mRecyclerView.getHeight();
      break label349;
      if (i > 0)
      {
        j = 2;
        break label359;
      }
      j = 4;
      break label359;
      label766:
      bo(((RecyclerView.v)localObject).caK);
      this.bWH.d(this.mRecyclerView, (RecyclerView.v)localObject);
      i = j;
      break label456;
    }
  }
  
  final void a(RecyclerView.v paramv, boolean paramBoolean)
  {
    AppMethodBeat.i(194912);
    int i = this.bWK.size() - 1;
    while (i >= 0)
    {
      c localc = (c)this.bWK.get(i);
      if (localc.bXh == paramv)
      {
        localc.bXl |= paramBoolean;
        if (!localc.bCD) {
          localc.bXi.cancel();
        }
        this.bWK.remove(i);
        AppMethodBeat.o(194912);
        return;
      }
      i -= 1;
    }
    AppMethodBeat.o(194912);
  }
  
  public final void a(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(194830);
    if (this.mRecyclerView == paramRecyclerView)
    {
      AppMethodBeat.o(194830);
      return;
    }
    if (this.mRecyclerView != null)
    {
      this.mRecyclerView.b(this);
      this.mRecyclerView.b(this.bWT);
      Object localObject = this.mRecyclerView;
      if (((RecyclerView)localObject).bYP != null) {
        ((RecyclerView)localObject).bYP.remove(this);
      }
      int i = this.bWK.size() - 1;
      while (i >= 0)
      {
        localObject = (c)this.bWK.get(0);
        this.bWH.d(this.mRecyclerView, ((c)localObject).bXh);
        i -= 1;
      }
      this.bWK.clear();
      this.bWP = null;
      this.bWQ = -1;
      Jg();
      if (this.bWS != null)
      {
        this.bWS.bXc = false;
        this.bWS = null;
      }
      if (this.bWR != null) {
        this.bWR = null;
      }
    }
    this.mRecyclerView = paramRecyclerView;
    if (paramRecyclerView != null)
    {
      paramRecyclerView = paramRecyclerView.getResources();
      this.bWB = paramRecyclerView.getDimension(a.a.item_touch_helper_swipe_escape_velocity);
      this.bWC = paramRecyclerView.getDimension(a.a.item_touch_helper_swipe_escape_max_velocity);
      this.wi = ViewConfiguration.get(this.mRecyclerView.getContext()).getScaledTouchSlop();
      this.mRecyclerView.a(this);
      this.mRecyclerView.a(this.bWT);
      this.mRecyclerView.a(this);
      this.bWS = new b();
      this.bWR = new d(this.mRecyclerView.getContext(), this.bWS);
    }
    AppMethodBeat.o(194830);
  }
  
  public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    int k = 0;
    AppMethodBeat.i(194842);
    if (this.bWy != null) {
      p(this.bWx);
    }
    RecyclerView.v localv = this.bWy;
    params = this.bWK;
    int j = params.size();
    int i = 0;
    while (i < j)
    {
      params.get(i);
      int m = paramCanvas.save();
      a.Jm();
      paramCanvas.restoreToCount(m);
      i += 1;
    }
    if (localv != null)
    {
      i = paramCanvas.save();
      a.Jm();
      paramCanvas.restoreToCount(i);
    }
    j -= 1;
    i = k;
    if (j >= 0)
    {
      paramCanvas = (c)params.get(j);
      if ((paramCanvas.bCD) && (!paramCanvas.bXk)) {
        params.remove(j);
      }
    }
    for (;;)
    {
      j -= 1;
      break;
      if (!paramCanvas.bCD)
      {
        i = 1;
        continue;
        if (i != 0) {
          paramRecyclerView.invalidate();
        }
        AppMethodBeat.o(194842);
        return;
      }
    }
  }
  
  public final void bm(View paramView) {}
  
  public final void bn(View paramView)
  {
    AppMethodBeat.i(194903);
    bo(paramView);
    paramView = this.mRecyclerView.bj(paramView);
    if (paramView == null)
    {
      AppMethodBeat.o(194903);
      return;
    }
    if ((this.bWy != null) && (paramView == this.bWy))
    {
      a(null, 0);
      AppMethodBeat.o(194903);
      return;
    }
    a(paramView, false);
    if (this.bWw.remove(paramView.caK)) {
      this.bWH.d(this.mRecyclerView, paramView);
    }
    AppMethodBeat.o(194903);
  }
  
  final void bo(View paramView)
  {
    AppMethodBeat.i(194978);
    if (paramView == this.bWP)
    {
      this.bWP = null;
      if (this.bWO != null) {
        this.mRecyclerView.setChildDrawingOrderCallback(null);
      }
    }
    AppMethodBeat.o(194978);
  }
  
  final void e(RecyclerView.v paramv)
  {
    AppMethodBeat.i(194891);
    if (this.mRecyclerView.isLayoutRequested())
    {
      AppMethodBeat.o(194891);
      return;
    }
    if (this.bWI != 2)
    {
      AppMethodBeat.o(194891);
      return;
    }
    float f = this.bWH.g(paramv);
    int m = (int)(this.bWF + this.bWD);
    int n = (int)(this.bWG + this.bWE);
    if ((Math.abs(n - paramv.caK.getTop()) < paramv.caK.getHeight() * f) && (Math.abs(m - paramv.caK.getLeft()) < f * paramv.caK.getWidth()))
    {
      AppMethodBeat.o(194891);
      return;
    }
    int i1;
    int i2;
    int i3;
    int i4;
    int i5;
    int i6;
    int i7;
    if (this.bWM == null)
    {
      this.bWM = new ArrayList();
      this.bWN = new ArrayList();
      i = a.Jk();
      i1 = Math.round(this.bWF + this.bWD) - i;
      i2 = Math.round(this.bWG + this.bWE) - i;
      i3 = paramv.caK.getWidth() + i1 + i * 2;
      i4 = paramv.caK.getHeight() + i2 + i * 2;
      i5 = (i1 + i3) / 2;
      i6 = (i2 + i4) / 2;
      localObject = this.mRecyclerView.getLayoutManager();
      i7 = ((RecyclerView.LayoutManager)localObject).getChildCount();
      i = 0;
    }
    for (;;)
    {
      if (i >= i7) {
        break label524;
      }
      View localView = ((RecyclerView.LayoutManager)localObject).getChildAt(i);
      if ((localView != paramv.caK) && (localView.getBottom() >= i2) && (localView.getTop() <= i4) && (localView.getRight() >= i1) && (localView.getLeft() <= i3))
      {
        RecyclerView.v localv = this.mRecyclerView.bj(localView);
        if (a.Jh())
        {
          int j = Math.abs(i5 - (localView.getLeft() + localView.getRight()) / 2);
          int k = localView.getTop();
          k = Math.abs(i6 - (localView.getBottom() + k) / 2);
          int i8 = j * j + k * k;
          k = 0;
          int i9 = this.bWM.size();
          j = 0;
          for (;;)
          {
            if ((j < i9) && (i8 > ((Integer)this.bWN.get(j)).intValue()))
            {
              k += 1;
              j += 1;
              continue;
              this.bWM.clear();
              this.bWN.clear();
              break;
            }
          }
          this.bWM.add(k, localv);
          this.bWN.add(k, Integer.valueOf(i8));
        }
      }
      i += 1;
    }
    label524:
    Object localObject = this.bWM;
    if (((List)localObject).size() == 0)
    {
      AppMethodBeat.o(194891);
      return;
    }
    localObject = a.a(paramv, (List)localObject, m, n);
    if (localObject == null)
    {
      this.bWM.clear();
      this.bWN.clear();
      AppMethodBeat.o(194891);
      return;
    }
    int i = ((RecyclerView.v)localObject).KJ();
    paramv.KJ();
    if (this.bWH.a(this.mRecyclerView, paramv, (RecyclerView.v)localObject)) {
      a.a(this.mRecyclerView, paramv, (RecyclerView.v)localObject, i);
    }
    AppMethodBeat.o(194891);
  }
  
  public final void f(RecyclerView.v paramv)
  {
    AppMethodBeat.i(194962);
    if (!this.bWH.c(this.mRecyclerView, paramv))
    {
      AppMethodBeat.o(194962);
      return;
    }
    if (paramv.caK.getParent() != this.mRecyclerView)
    {
      AppMethodBeat.o(194962);
      return;
    }
    Jf();
    this.bWE = 0.0F;
    this.bWD = 0.0F;
    a(paramv, 2);
    AppMethodBeat.o(194962);
  }
  
  final View k(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(194953);
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.bWy != null)
    {
      paramMotionEvent = this.bWy.caK;
      if (a(paramMotionEvent, f1, f2, this.bWF + this.bWD, this.bWG + this.bWE))
      {
        AppMethodBeat.o(194953);
        return paramMotionEvent;
      }
    }
    int i = this.bWK.size() - 1;
    while (i >= 0)
    {
      paramMotionEvent = (c)this.bWK.get(i);
      View localView = paramMotionEvent.bXh.caK;
      if (a(localView, f1, f2, paramMotionEvent.mX, paramMotionEvent.mY))
      {
        AppMethodBeat.o(194953);
        return localView;
      }
      i -= 1;
    }
    paramMotionEvent = this.mRecyclerView.Q(f1, f2);
    AppMethodBeat.o(194953);
    return paramMotionEvent;
  }
  
  public static abstract class a
  {
    private static final Interpolator bWZ = new k.a.1();
    private static final Interpolator bXa = new k.a.2();
    private int bXb = -1;
    
    public static boolean Jh()
    {
      return true;
    }
    
    public static int Jk()
    {
      return 0;
    }
    
    public static float Jl()
    {
      return 0.5F;
    }
    
    public static void Jm()
    {
      l locall = m.bXo;
    }
    
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
        return paramRecyclerView.bZK;
      }
      return paramRecyclerView.Ku();
    }
    
    public static RecyclerView.v a(RecyclerView.v paramv, List<RecyclerView.v> paramList, int paramInt1, int paramInt2)
    {
      int m = paramv.caK.getWidth();
      int n = paramv.caK.getHeight();
      int i = -1;
      int i1 = paramInt1 - paramv.caK.getLeft();
      int i2 = paramInt2 - paramv.caK.getTop();
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
        k = ((RecyclerView.v)localObject1).caK.getRight() - (paramInt1 + m);
        if ((k >= 0) || (((RecyclerView.v)localObject1).caK.getRight() <= paramv.caK.getRight())) {
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
        k = ((RecyclerView.v)localObject1).caK.getLeft() - paramInt1;
        if ((k <= 0) || (((RecyclerView.v)localObject1).caK.getLeft() >= paramv.caK.getLeft())) {
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
          k = ((RecyclerView.v)localObject1).caK.getTop() - paramInt2;
          if ((k > 0) && (((RecyclerView.v)localObject1).caK.getTop() < paramv.caK.getTop()))
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
            k = ((RecyclerView.v)localObject1).caK.getBottom() - (paramInt2 + n);
            if ((k < 0) && (((RecyclerView.v)localObject1).caK.getBottom() > paramv.caK.getBottom()))
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
      if ((localLayoutManager instanceof k.d)) {
        ((k.d)localLayoutManager).d(paramv1.caK, paramv2.caK);
      }
      do
      {
        do
        {
          return;
          if (localLayoutManager.canScrollHorizontally())
          {
            if (localLayoutManager.getDecoratedLeft(paramv2.caK) <= paramRecyclerView.getPaddingLeft())
            {
              paramv1 = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
              com.tencent.mm.hellhoundlib.a.a.b(paramRecyclerView, paramv1.aYi(), "androidx/recyclerview/widget/ItemTouchHelper$Callback", "onMoved", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILandroidx/recyclerview/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
              paramRecyclerView.scrollToPosition(((Integer)paramv1.sb(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.c(paramRecyclerView, "androidx/recyclerview/widget/ItemTouchHelper$Callback", "onMoved", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILandroidx/recyclerview/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
            }
            if (localLayoutManager.getDecoratedRight(paramv2.caK) >= paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight())
            {
              paramv1 = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
              com.tencent.mm.hellhoundlib.a.a.b(paramRecyclerView, paramv1.aYi(), "androidx/recyclerview/widget/ItemTouchHelper$Callback", "onMoved", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILandroidx/recyclerview/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
              paramRecyclerView.scrollToPosition(((Integer)paramv1.sb(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.c(paramRecyclerView, "androidx/recyclerview/widget/ItemTouchHelper$Callback", "onMoved", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILandroidx/recyclerview/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
            }
          }
        } while (!localLayoutManager.canScrollVertically());
        if (localLayoutManager.getDecoratedTop(paramv2.caK) <= paramRecyclerView.getPaddingTop())
        {
          paramv1 = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.b(paramRecyclerView, paramv1.aYi(), "androidx/recyclerview/widget/ItemTouchHelper$Callback", "onMoved", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILandroidx/recyclerview/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
          paramRecyclerView.scrollToPosition(((Integer)paramv1.sb(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(paramRecyclerView, "androidx/recyclerview/widget/ItemTouchHelper$Callback", "onMoved", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILandroidx/recyclerview/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
        }
      } while (localLayoutManager.getDecoratedBottom(paramv2.caK) < paramRecyclerView.getHeight() - paramRecyclerView.getPaddingBottom());
      paramv1 = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramRecyclerView, paramv1.aYi(), "androidx/recyclerview/widget/ItemTouchHelper$Callback", "onMoved", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILandroidx/recyclerview/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
      paramRecyclerView.scrollToPosition(((Integer)paramv1.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramRecyclerView, "androidx/recyclerview/widget/ItemTouchHelper$Callback", "onMoved", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILandroidx/recyclerview/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
    }
    
    public static float ay(float paramFloat)
    {
      return paramFloat;
    }
    
    public static float az(float paramFloat)
    {
      return paramFloat;
    }
    
    private int b(RecyclerView paramRecyclerView)
    {
      if (this.bXb == -1) {
        this.bXb = paramRecyclerView.getResources().getDimensionPixelSize(a.a.item_touch_helper_max_drag_scroll_per_frame);
      }
      return this.bXb;
    }
    
    public static int bj(int paramInt1, int paramInt2)
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
    
    public static int bk(int paramInt1, int paramInt2)
    {
      return (paramInt2 | paramInt1) << 0 | paramInt2 << 8 | paramInt1 << 16;
    }
    
    public static int bl(int paramInt1, int paramInt2)
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
    
    public boolean Ji()
    {
      return true;
    }
    
    public boolean Jj()
    {
      return true;
    }
    
    public final int a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, long paramLong)
    {
      float f1 = 1.0F;
      int i = b(paramRecyclerView);
      int j = Math.abs(paramInt2);
      int k = (int)Math.signum(paramInt2);
      float f2 = Math.min(1.0F, j * 1.0F / paramInt1);
      paramInt1 = (int)(i * k * bXa.getInterpolation(f2));
      if (paramLong > 2000L) {}
      for (;;)
      {
        f2 = paramInt1;
        i = (int)(bWZ.getInterpolation(f1) * f2);
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
      m.bXo.a(paramRecyclerView, paramv.caK, paramFloat1, paramFloat2, paramBoolean);
    }
    
    public abstract boolean a(RecyclerView paramRecyclerView, RecyclerView.v paramv1, RecyclerView.v paramv2);
    
    final int b(RecyclerView paramRecyclerView, RecyclerView.v paramv)
    {
      return bl(a(paramRecyclerView, paramv), z.U(paramRecyclerView));
    }
    
    public void b(RecyclerView.v paramv, int paramInt)
    {
      if (paramv != null) {
        paramv = m.bXo;
      }
    }
    
    final boolean c(RecyclerView paramRecyclerView, RecyclerView.v paramv)
    {
      return (b(paramRecyclerView, paramv) & 0xFF0000) != 0;
    }
    
    public void d(RecyclerView paramRecyclerView, RecyclerView.v paramv)
    {
      m.bXo.bp(paramv.caK);
    }
    
    public float g(RecyclerView.v paramv)
    {
      return 0.5F;
    }
    
    public abstract void h(RecyclerView.v paramv);
  }
  
  final class b
    extends GestureDetector.SimpleOnGestureListener
  {
    boolean bXc = true;
    
    b() {}
    
    public final boolean onDown(MotionEvent paramMotionEvent)
    {
      return true;
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(194757);
      if (!this.bXc)
      {
        AppMethodBeat.o(194757);
        return;
      }
      Object localObject = k.this.k(paramMotionEvent);
      if (localObject != null)
      {
        localObject = k.this.mRecyclerView.bj((View)localObject);
        if (localObject != null)
        {
          if (!k.this.bWH.c(k.this.mRecyclerView, (RecyclerView.v)localObject))
          {
            AppMethodBeat.o(194757);
            return;
          }
          if (paramMotionEvent.getPointerId(0) == k.this.mActivePointerId)
          {
            int i = paramMotionEvent.findPointerIndex(k.this.mActivePointerId);
            float f1 = paramMotionEvent.getX(i);
            float f2 = paramMotionEvent.getY(i);
            k.this.bWz = f1;
            k.this.bWA = f2;
            paramMotionEvent = k.this;
            k.this.bWE = 0.0F;
            paramMotionEvent.bWD = 0.0F;
            if (k.this.bWH.Ji()) {
              k.this.a((RecyclerView.v)localObject, 2);
            }
          }
        }
      }
      AppMethodBeat.o(194757);
    }
  }
  
  static class c
    implements Animator.AnimatorListener
  {
    boolean bCD;
    final int bWI;
    final float bXd;
    final float bXe;
    final float bXf;
    final float bXg;
    final RecyclerView.v bXh;
    final ValueAnimator bXi;
    final int bXj;
    boolean bXk;
    boolean bXl;
    float bXm;
    float mX;
    float mY;
    
    c(RecyclerView.v paramv, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(194683);
      this.bXl = false;
      this.bCD = false;
      this.bWI = paramInt2;
      this.bXj = paramInt1;
      this.bXh = paramv;
      this.bXd = paramFloat1;
      this.bXe = paramFloat2;
      this.bXf = paramFloat3;
      this.bXg = paramFloat4;
      this.bXi = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.bXi.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(195206);
          k.c.this.bXm = paramAnonymousValueAnimator.getAnimatedFraction();
          AppMethodBeat.o(195206);
        }
      });
      this.bXi.setTarget(paramv.caK);
      this.bXi.addListener(this);
      this.bXm = 0.0F;
      AppMethodBeat.o(194683);
    }
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      this.bXm = 1.0F;
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(194703);
      if (!this.bCD) {
        this.bXh.bg(true);
      }
      this.bCD = true;
      AppMethodBeat.o(194703);
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator) {}
  }
  
  public static abstract interface d
  {
    public abstract void d(View paramView1, View paramView2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.recyclerview.widget.k
 * JD-Core Version:    0.7.0.1
 */