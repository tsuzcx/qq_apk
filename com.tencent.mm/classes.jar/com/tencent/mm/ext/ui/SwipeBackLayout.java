package com.tencent.mm.ext.ui;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.core.g.j;
import androidx.core.g.y;
import androidx.core.g.z;
import androidx.core.widget.i;
import com.tencent.liteapp.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ext.a.b.a;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SwipeBackLayout
  extends FrameLayout
{
  private float bxY;
  private Rect byy;
  private View mContentView;
  private boolean mEnable;
  private Handler mHandler;
  private boolean mInLayout;
  private boolean mqA;
  private b mqB;
  private Drawable mqC;
  private boolean mqD;
  private boolean mqE;
  private a mqF;
  private float mqp;
  private int mqq;
  private int mqr;
  private f mqs;
  private float mqt;
  private Drawable mqu;
  private boolean mqv;
  private boolean mqw;
  boolean mqx;
  private boolean mqy;
  boolean mqz;
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(235331);
    this.mqp = 0.3F;
    this.mEnable = true;
    this.byy = new Rect();
    this.mqv = true;
    this.mqw = false;
    this.mqx = false;
    this.mqy = false;
    this.mqz = false;
    this.mqA = false;
    this.mHandler = new Handler(Looper.getMainLooper());
    this.mqE = true;
    this.mqF = null;
    this.mqu = getResources().getDrawable(a.c.shadow_left);
    setFocusable(true);
    setDescendantFocusability(262144);
    init();
    AppMethodBeat.o(235331);
  }
  
  public final boolean aXg()
  {
    AppMethodBeat.i(235494);
    if (!this.mqz)
    {
      AppMethodBeat.o(235494);
      return false;
    }
    if (Float.compare(this.mContentView.getLeft(), 0.01F) <= 0)
    {
      this.mqz = false;
      AppMethodBeat.o(235494);
      return false;
    }
    AppMethodBeat.o(235494);
    return true;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(235543);
    this.bxY = Math.max(0.0F, 1.0F - this.mqt);
    f localf = this.mqs;
    if (localf.bxy == 2)
    {
      boolean bool2 = localf.mri.Fs();
      i = localf.mri.Fo();
      int j = localf.mri.Fp();
      int k = i - localf.bxM.getLeft();
      int m = j - localf.bxM.getTop();
      if (k != 0) {
        localf.bxM.offsetLeftAndRight(k);
      }
      if (m != 0) {
        localf.bxM.offsetTopAndBottom(m);
      }
      if ((k != 0) || (m != 0)) {
        localf.mrj.dS(i, j);
      }
      boolean bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (i == localf.mri.Fq())
        {
          bool1 = bool2;
          if (j == localf.mri.Fr())
          {
            localf.mri.Ft();
            bool1 = localf.mri.isFinished();
          }
        }
      }
      if (!bool1) {
        localf.bxO.post(localf.bxP);
      }
    }
    if (localf.bxy == 2) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        z.Q(this);
      }
      AppMethodBeat.o(235543);
      return;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(235518);
    boolean bool;
    if (!this.mEnable)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(235518);
      return bool;
    }
    if (paramMotionEvent.getAction() == 0) {
      this.mqD = false;
    }
    if (this.mqD)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(235518);
      return bool;
    }
    if (aXg())
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(235518);
      return bool;
    }
    float f1;
    float f2;
    int k;
    int m;
    int n;
    label615:
    float f3;
    label662:
    View localView;
    for (;;)
    {
      try
      {
        if (this.mqs.bxy != 1) {
          break;
        }
        localf = this.mqs;
        i = j.d(paramMotionEvent);
        j = j.e(paramMotionEvent);
        if (i == 0) {
          localf.cancel();
        }
        if (localf.mVelocityTracker == null) {
          localf.mVelocityTracker = VelocityTracker.obtain();
        }
        localf.mVelocityTracker.addMovement(paramMotionEvent);
        switch (i)
        {
        }
      }
      catch (NullPointerException paramMotionEvent)
      {
        com.tencent.liteapp.b.b.e("MicroMsg.SwipeBackLayout", "got an NullPointerException: %s", new Object[] { paramMotionEvent.toString() });
        AppMethodBeat.o(235518);
        return false;
        j = (int)f1;
        k = (int)f2;
        if (!f.g(localf.bxM, j, k)) {
          continue;
        }
        localf.C(localf.bxM, i);
        continue;
      }
      catch (IllegalArgumentException paramMotionEvent)
      {
        com.tencent.liteapp.b.b.e("MicroMsg.SwipeBackLayout", "got an IllegalArgumentException: %s", new Object[] { paramMotionEvent.toString() });
        AppMethodBeat.o(235518);
        return false;
        if (localf.bxy != 1) {
          continue;
        }
        i = j.d(paramMotionEvent, localf.mActivePointerId);
        f1 = j.f(paramMotionEvent, i);
        f2 = j.g(paramMotionEvent, i);
        m = (int)(f1 - localf.bxB[localf.mActivePointerId]);
        n = (int)(f2 - localf.bxC[localf.mActivePointerId]);
        k = localf.bxM.getLeft() + m;
        j = localf.bxM.getTop() + n;
        int i2 = localf.bxM.getLeft();
        int i1 = localf.bxM.getTop();
        i = k;
        if (m == 0) {
          continue;
        }
        i = localf.mrj.d(localf.bxM, k);
        localf.bxM.offsetLeftAndRight(i - i2);
        if (n == 0) {
          break label1477;
        }
        localf.bxM.offsetTopAndBottom(0 - i1);
        j = 0;
        break label1477;
        localf.mrj.dS(i, j);
        localf.h(paramMotionEvent);
        continue;
      }
      catch (ArrayIndexOutOfBoundsException paramMotionEvent)
      {
        com.tencent.liteapp.b.b.e("MicroMsg.SwipeBackLayout", "got an ArrayIndexOutOfBoundsException: %s", new Object[] { paramMotionEvent.toString() });
        AppMethodBeat.o(235518);
        return false;
        j = j.f(paramMotionEvent);
        i = 0;
        if (i >= j) {
          continue;
        }
        k = j.e(paramMotionEvent, i);
        f1 = j.f(paramMotionEvent, i);
        f2 = j.g(paramMotionEvent, i);
        f3 = f1 - localf.bxz[k];
        localf.b(f3, f2 - localf.bxA[k], k);
        if (localf.bxy == 1) {
          continue;
        }
        localView = localf.aF((int)f1, (int)f2);
        if ((!localf.s(localView, f3)) || (!localf.C(localView, k))) {
          break label1490;
        }
        localf.h(paramMotionEvent);
        continue;
      }
      catch (IllegalStateException paramMotionEvent)
      {
        com.tencent.liteapp.b.b.e("MicroMsg.SwipeBackLayout", "got an IllegalStateException: %s", new Object[] { paramMotionEvent.toString() });
        AppMethodBeat.o(235518);
        return false;
      }
      AppMethodBeat.o(235518);
      return true;
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      i = j.e(paramMotionEvent, 0);
      paramMotionEvent = localf.aF((int)f1, (int)f2);
      localf.a(f1, f2, i);
      localf.C(paramMotionEvent, i);
      i = localf.bxD[i];
      if ((localf.bxK & i) != 0)
      {
        continue;
        i = j.e(paramMotionEvent, j);
        f1 = j.f(paramMotionEvent, j);
        f2 = j.g(paramMotionEvent, j);
        localf.a(f1, f2, i);
        if (localf.bxy == 0)
        {
          localf.C(localf.aF((int)f1, (int)f2), i);
        }
        else
        {
          j = j.e(paramMotionEvent, j);
          if ((localf.bxy == 1) && (j == localf.mActivePointerId))
          {
            k = j.f(paramMotionEvent);
            i = 0;
            label843:
            if (i >= k) {
              break label1471;
            }
            m = j.e(paramMotionEvent, i);
            if (m == localf.mActivePointerId) {
              break label1499;
            }
            f1 = j.f(paramMotionEvent, i);
            f2 = j.g(paramMotionEvent, i);
            if ((localf.aF((int)f1, (int)f2) != localf.bxM) || (!localf.C(localf.bxM, m))) {
              break label1499;
            }
            i = localf.mActivePointerId;
            label921:
            if (i == -1) {
              localf.Fy();
            }
          }
          localf.eK(j);
          continue;
          if (localf.bxy == 1) {
            localf.Fy();
          }
          localf.cancel();
          continue;
          if (localf.bxy == 1) {
            localf.N(0.0F, 0.0F);
          }
          localf.cancel();
        }
      }
    }
    f localf = this.mqs;
    int j = j.d(paramMotionEvent);
    int i = j.e(paramMotionEvent);
    if (j == 0) {
      localf.cancel();
    }
    if (localf.mVelocityTracker == null) {
      localf.mVelocityTracker = VelocityTracker.obtain();
    }
    localf.mVelocityTracker.addMovement(paramMotionEvent);
    switch (j)
    {
    case 4: 
      label1084:
      if (localf.bxy != 1) {
        break;
      }
    }
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        com.tencent.liteapp.b.b.i("changelcai", "shouldInterceptTouchEvent %s", new Object[] { paramMotionEvent });
        paramMotionEvent.setAction(3);
        super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(235518);
        return true;
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        i = j.e(paramMotionEvent, 0);
        localf.a(f1, f2, i);
        localView = localf.aF((int)f1, (int)f2);
        if ((localView == localf.bxM) && (localf.bxy == 2)) {
          localf.C(localView, i);
        }
        if ((localf.bxD[i] & localf.bxK) == 0) {
          break label1084;
        }
        break label1084;
        j = j.e(paramMotionEvent, i);
        f1 = j.f(paramMotionEvent, i);
        f2 = j.g(paramMotionEvent, i);
        localf.a(f1, f2, j);
        if ((localf.bxy == 0) || (localf.bxy != 2)) {
          break label1084;
        }
        localView = localf.aF((int)f1, (int)f2);
        if (localView != localf.bxM) {
          break label1084;
        }
        localf.C(localView, j);
        break label1084;
        j = j.f(paramMotionEvent);
        i = 0;
      }
      for (;;)
      {
        if (i < j)
        {
          k = j.e(paramMotionEvent, i);
          f1 = j.f(paramMotionEvent, i);
          f2 = j.g(paramMotionEvent, i);
          f3 = f1 - localf.bxz[k];
          localf.b(f3, f2 - localf.bxA[k], k);
          if (localf.bxy != 1)
          {
            localView = localf.aF((int)f1, (int)f2);
            if ((localView == null) || (!localf.s(localView, f3)) || (!localf.C(localView, k))) {
              break label1511;
            }
          }
        }
        localf.h(paramMotionEvent);
        break label1084;
        localf.eK(j.e(paramMotionEvent, i));
        break label1084;
        localf.cancel();
        break label1084;
        super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(235518);
        return true;
        label1471:
        i = -1;
        break label921;
        label1477:
        if (m != 0) {
          break;
        }
        if (n == 0) {
          break label615;
        }
        break;
        label1490:
        i += 1;
        break label662;
        label1499:
        i += 1;
        break label843;
        break label1084;
        label1511:
        i += 1;
      }
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    AppMethodBeat.i(235535);
    if (paramView == this.mContentView) {}
    for (int i = 1;; i = 0)
    {
      boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
      if ((Float.compare(this.bxY, 0.0F) > 0) && (i != 0) && (this.mqs.bxy != 0))
      {
        Rect localRect = this.byy;
        paramView.getHitRect(localRect);
        this.mqu.setBounds(localRect.left - this.mqu.getIntrinsicWidth(), localRect.top, localRect.left, localRect.bottom);
        this.mqu.setAlpha((int)(this.bxY * 255.0F));
        this.mqu.draw(paramCanvas);
        com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "shadow left:%d top:%d right:%d bootom:%d", new Object[] { Integer.valueOf(this.mqu.getBounds().left), Integer.valueOf(this.mqu.getBounds().top), Integer.valueOf(this.mqu.getBounds().right), Integer.valueOf(this.mqu.getBounds().bottom) });
      }
      AppMethodBeat.o(235535);
      return bool;
    }
  }
  
  public View getTargetContentView()
  {
    return this.mContentView;
  }
  
  public final void init()
  {
    AppMethodBeat.i(235455);
    Interpolator localInterpolator = AnimationUtils.loadInterpolator(getContext(), com.tencent.liteapp.a.a.mm_decelerate_interpolator);
    this.mqs = f.a(this, new c((byte)0), localInterpolator);
    this.mqs.bxK = 1;
    float f = getResources().getDisplayMetrics().density;
    this.mqs.bxI = (100.0F * f);
    this.mqs.bxH = (f * 300.0F);
    this.mqq = 0;
    this.mqr = 0;
    AppMethodBeat.o(235455);
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(235477);
    super.onFinishInflate();
    this.mContentView = this;
    AppMethodBeat.o(235477);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(235524);
    this.mInLayout = true;
    if (this.mContentView != null) {
      this.mContentView.layout(this.mqq, this.mqr, this.mqq + this.mContentView.getMeasuredWidth(), this.mqr + this.mContentView.getMeasuredHeight());
    }
    this.mInLayout = false;
    AppMethodBeat.o(235524);
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(235529);
    if (!this.mInLayout) {
      super.requestLayout();
    }
    AppMethodBeat.o(235529);
  }
  
  public void setContentView(View paramView)
  {
    this.mContentView = paramView;
  }
  
  public void setEnableGesture(boolean paramBoolean)
  {
    this.mEnable = paramBoolean;
  }
  
  public void setNeedChangeWindowBackground(boolean paramBoolean)
  {
    this.mqE = paramBoolean;
  }
  
  public void setNeedRequestActivityTranslucent(boolean paramBoolean)
  {
    this.mqv = paramBoolean;
    if (this.mqv) {
      this.mqw = false;
    }
  }
  
  public void setOnceDisEnableGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(235487);
    com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "[setOnceDisEnableGesture] enable:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mqD = paramBoolean;
    AppMethodBeat.o(235487);
  }
  
  public void setSwipeBackListener(b paramb)
  {
    this.mqB = paramb;
  }
  
  public void setSwipeGestureDelegate(a parama)
  {
    this.mqF = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onCancel();
    
    public abstract void onDrag();
    
    public abstract void onSwipeBack();
  }
  
  public static abstract interface b
  {
    public abstract int aXh();
  }
  
  final class c
    extends f.a
    implements a.a
  {
    int mqG = 0;
    int mqH = 0;
    int mqI = 0;
    
    private c() {}
    
    public final void F(int paramInt)
    {
      Object localObject1 = null;
      AppMethodBeat.i(235425);
      com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "ashutest::onViewDragStateChanged state %d, requestedTranslucent %B fastRelease %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(SwipeBackLayout.m(SwipeBackLayout.this)), Boolean.valueOf(SwipeBackLayout.n(SwipeBackLayout.this)) });
      if (1 == paramInt)
      {
        com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "ashutest:: on drag", new Object[0]);
        if (((SwipeBackLayout.this.getContext() instanceof Activity)) && (SwipeBackLayout.i(SwipeBackLayout.this) == null))
        {
          SwipeBackLayout.a(SwipeBackLayout.this, ((Activity)SwipeBackLayout.this.getContext()).getWindow().getDecorView().getBackground());
          if (SwipeBackLayout.j(SwipeBackLayout.this)) {
            ((Activity)SwipeBackLayout.this.getContext()).getWindow().getDecorView().setBackgroundResource(17170445);
          }
        }
        if (SwipeBackLayout.h(SwipeBackLayout.this) != null) {
          SwipeBackLayout.h(SwipeBackLayout.this).onDrag();
        }
        SwipeBackLayout.a(SwipeBackLayout.this, false);
        if (SwipeBackLayout.b(SwipeBackLayout.this)) {
          d.bk(0.0F);
        }
      }
      if ((paramInt == 0) && (!SwipeBackLayout.n(SwipeBackLayout.this)))
      {
        com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "ashutest:: on cancel", new Object[0]);
        if (SwipeBackLayout.h(SwipeBackLayout.this) != null)
        {
          if (((SwipeBackLayout.this.getContext() instanceof Activity)) && (SwipeBackLayout.i(SwipeBackLayout.this) != null))
          {
            if (SwipeBackLayout.j(SwipeBackLayout.this)) {
              ((Activity)SwipeBackLayout.this.getContext()).getWindow().getDecorView().setBackground(SwipeBackLayout.i(SwipeBackLayout.this));
            }
            SwipeBackLayout.a(SwipeBackLayout.this, null);
          }
          SwipeBackLayout.h(SwipeBackLayout.this).onCancel();
        }
        d.bk(1.0F);
      }
      Activity localActivity;
      boolean bool;
      if ((1 == paramInt) && (SwipeBackLayout.o(SwipeBackLayout.this)) && ((SwipeBackLayout.this.getContext() instanceof Activity)) && (!SwipeBackLayout.b(SwipeBackLayout.this)) && (!SwipeBackLayout.m(SwipeBackLayout.this)))
      {
        com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "ashutest:: match dragging", new Object[0]);
        SwipeBackLayout.d(SwipeBackLayout.this, true);
        localActivity = (Activity)SwipeBackLayout.this.getContext();
        if (a.rc(16)) {
          com.tencent.liteapp.b.b.w("MicroMsg.ActivityUtil", "convertActivityToTranslucent::Android Version Error %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
        }
      }
      else
      {
        if (2 == paramInt)
        {
          com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "ashutest:: notify settle, mReleasedLeft %d", new Object[] { Integer.valueOf(this.mqH) });
          if (this.mqH <= 0) {
            break label689;
          }
          bool = true;
          label457:
          d.g(bool, this.mqH);
        }
        AppMethodBeat.o(235425);
        return;
      }
      for (;;)
      {
        int i;
        Object localObject3;
        try
        {
          Class[] arrayOfClass = Activity.class.getDeclaredClasses();
          int j = arrayOfClass.length;
          i = 0;
          if (i < j)
          {
            localObject3 = arrayOfClass[i];
            if (!((Class)localObject3).getSimpleName().contains("TranslucentConversionListener")) {
              break label695;
            }
            localObject1 = localObject3;
            break label695;
          }
          localObject3 = new a.b((byte)0);
          ((a.b)localObject3).mql = new WeakReference(this);
          localObject3 = Proxy.newProxyInstance(((Class)localObject1).getClassLoader(), new Class[] { localObject1 }, (InvocationHandler)localObject3);
          if (!a.rc(21)) {
            break label636;
          }
          localObject1 = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[] { localObject1 });
          ((Method)localObject1).setAccessible(true);
          ((Method)localObject1).invoke(localActivity, new Object[] { localObject3 });
          break;
        }
        finally
        {
          com.tencent.liteapp.b.b.e("MicroMsg.ActivityUtil", "call convertActivityToTranslucent Fail: %s", new Object[] { localObject2.getMessage() });
        }
        break;
        label636:
        Method localMethod = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[] { localObject2, ActivityOptions.class });
        localMethod.setAccessible(true);
        localMethod.invoke(localActivity, new Object[] { localObject3, null });
        break;
        label689:
        bool = false;
        break label457;
        label695:
        i += 1;
      }
    }
    
    public final int aXi()
    {
      return 1;
    }
    
    public final void b(View paramView, float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(235401);
      int i = paramView.getWidth();
      this.mqH = 0;
      this.mqI = 0;
      if ((paramFloat1 > 0.0F) || ((paramFloat1 == 0.0F) && (SwipeBackLayout.f(SwipeBackLayout.this) > SwipeBackLayout.l(SwipeBackLayout.this))))
      {
        i = i + SwipeBackLayout.d(SwipeBackLayout.this).getIntrinsicWidth() + 10;
        this.mqH = i;
        com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "ashutest::onViewReleased, xvel:%f yvel:%f, releaseLeft:%d, releaseTop:%d, translucent %B", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(this.mqH), Integer.valueOf(this.mqI), Boolean.valueOf(SwipeBackLayout.b(SwipeBackLayout.this)) });
        SwipeBackLayout.b(SwipeBackLayout.this, true);
        if (SwipeBackLayout.e(SwipeBackLayout.this) != null)
        {
          i = SwipeBackLayout.e(SwipeBackLayout.this).aXh();
          com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "intercepted by mSwipeBackListener.onViewReleased, result:%s", new Object[] { Integer.valueOf(i) });
          if (i != 2) {
            break label259;
          }
          this.mqH = 0;
        }
      }
      for (;;)
      {
        if (SwipeBackLayout.b(SwipeBackLayout.this))
        {
          paramView = SwipeBackLayout.a(SwipeBackLayout.this);
          int n = this.mqH;
          int i1 = this.mqI;
          if (!paramView.bxN)
          {
            paramView = new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
            AppMethodBeat.o(235401);
            throw paramView;
            i = 0;
            break;
            label259:
            if (i != 3) {
              continue;
            }
            AppMethodBeat.o(235401);
            return;
          }
          i = (int)y.a(paramView.mVelocityTracker, paramView.mActivePointerId);
          int j = (int)y.b(paramView.mVelocityTracker, paramView.mActivePointerId);
          int k = paramView.bxM.getLeft();
          int m = paramView.bxM.getTop();
          n -= k;
          i1 -= m;
          if ((n == 0) && (i1 == 0))
          {
            paramView.mri.Ft();
            paramView.eM(0);
            SwipeBackLayout.this.invalidate();
            AppMethodBeat.o(235401);
            return;
          }
          int i2;
          int i4;
          int i5;
          int i9;
          label461:
          label474:
          float f;
          if (0L == 0L)
          {
            int i3 = f.t(i, (int)paramView.bxI, (int)paramView.bxH);
            i2 = f.t(j, (int)paramView.bxI, (int)paramView.bxH);
            i4 = Math.abs(n);
            i5 = Math.abs(i1);
            int i6 = Math.abs(i3);
            int i7 = Math.abs(i2);
            int i8 = i6 + i7;
            i9 = i4 + i5;
            if (i3 != 0)
            {
              paramFloat1 = i6 / i8;
              if (i2 == 0) {
                break label611;
              }
              paramFloat2 = i7 / i8;
              i3 = paramView.s(n, i3, paramView.mrj.aXi());
              i2 = paramView.s(i1, i2, 0);
              f = i3;
            }
          }
          for (long l = (int)(paramFloat2 * i2 + paramFloat1 * f);; l = 0L)
          {
            com.tencent.liteapp.b.b.d("WxViewDragHelper", "ashutest:: xvel %d, yvel %d, dx %d, dy %d duration %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(i1), Long.valueOf(l) });
            paramView.mri.startScroll(k, m, n, i1, (int)l);
            paramView.eM(2);
            break;
            paramFloat1 = i4 / i9;
            break label461;
            label611:
            paramFloat2 = i5 / i9;
            break label474;
          }
        }
      }
      SwipeBackLayout.c(SwipeBackLayout.this, true);
      AppMethodBeat.o(235401);
    }
    
    public final int d(View paramView, int paramInt)
    {
      AppMethodBeat.i(235407);
      if (SwipeBackLayout.b(SwipeBackLayout.this))
      {
        paramInt = Math.max(this.mqG, paramInt);
        this.mqG = 0;
        paramInt = Math.min(paramView.getWidth(), Math.max(paramInt, 0));
        AppMethodBeat.o(235407);
        return paramInt;
      }
      this.mqG = Math.max(this.mqG, paramInt);
      AppMethodBeat.o(235407);
      return 0;
    }
    
    public final void dS(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(235386);
      if (!SwipeBackLayout.b(SwipeBackLayout.this))
      {
        com.tencent.liteapp.b.b.w("MicroMsg.SwipeBackLayout", "[onViewPositionChanged] mHasTranslucent is false", new Object[0]);
        AppMethodBeat.o(235386);
        return;
      }
      SwipeBackLayout.a(SwipeBackLayout.this, Math.abs(paramInt1 / (SwipeBackLayout.c(SwipeBackLayout.this).getWidth() + SwipeBackLayout.d(SwipeBackLayout.this).getIntrinsicWidth())));
      SwipeBackLayout.a(SwipeBackLayout.this, paramInt1);
      SwipeBackLayout.b(SwipeBackLayout.this, paramInt2);
      SwipeBackLayout.this.invalidate();
      if (SwipeBackLayout.e(SwipeBackLayout.this) != null)
      {
        SwipeBackLayout.e(SwipeBackLayout.this);
        SwipeBackLayout.f(SwipeBackLayout.this);
      }
      if ((Float.compare(SwipeBackLayout.f(SwipeBackLayout.this), 1.0F) >= 0) && (!SwipeBackLayout.g(SwipeBackLayout.this)))
      {
        SwipeBackLayout.a(SwipeBackLayout.this, true);
        SwipeBackLayout.k(SwipeBackLayout.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(235329);
            if (SwipeBackLayout.h(SwipeBackLayout.this) != null)
            {
              com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "ashutest:: on popOut", new Object[0]);
              if (((SwipeBackLayout.this.getContext() instanceof Activity)) && (SwipeBackLayout.i(SwipeBackLayout.this) != null))
              {
                if (SwipeBackLayout.j(SwipeBackLayout.this)) {
                  ((Activity)SwipeBackLayout.this.getContext()).getWindow().getDecorView().setBackground(SwipeBackLayout.i(SwipeBackLayout.this));
                }
                SwipeBackLayout.a(SwipeBackLayout.this, null);
              }
              SwipeBackLayout.h(SwipeBackLayout.this).onSwipeBack();
            }
            SwipeBackLayout.b(SwipeBackLayout.this, false);
            AppMethodBeat.o(235329);
          }
        });
      }
      for (;;)
      {
        if (SwipeBackLayout.a(SwipeBackLayout.this).bxy == 1) {
          d.bk(SwipeBackLayout.f(SwipeBackLayout.this));
        }
        AppMethodBeat.o(235386);
        return;
        if (Float.compare(SwipeBackLayout.f(SwipeBackLayout.this), 0.01F) <= 0)
        {
          SwipeBackLayout.b(SwipeBackLayout.this, false);
          com.tencent.liteapp.b.b.w("MicroMsg.SwipeBackLayout", "[onViewPositionChanged] mScrollPercent:%s mHasCallPopOut:%s", new Object[] { Float.valueOf(SwipeBackLayout.f(SwipeBackLayout.this)), Boolean.valueOf(SwipeBackLayout.g(SwipeBackLayout.this)) });
        }
      }
    }
    
    public final void onComplete(final boolean paramBoolean)
    {
      AppMethodBeat.i(235432);
      SwipeBackLayout.k(SwipeBackLayout.this).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(235327);
          com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "on Complete, result %B, releaseLeft %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(SwipeBackLayout.c.this.mqH) });
          SwipeBackLayout.d(SwipeBackLayout.this, paramBoolean);
          if (paramBoolean) {
            if (SwipeBackLayout.c.this.mqH > 0)
            {
              d.bk(0.0F);
              SwipeBackLayout localSwipeBackLayout = SwipeBackLayout.this;
              boolean bool = paramBoolean;
              com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "ashutest::markTranslucent %B", new Object[] { Boolean.valueOf(bool) });
              localSwipeBackLayout.mqx = bool;
              if ((paramBoolean) && (SwipeBackLayout.n(SwipeBackLayout.this)))
              {
                if (SwipeBackLayout.c.this.mqH != 0) {
                  break label206;
                }
                b.a(SwipeBackLayout.c(SwipeBackLayout.this), 200L, 0.0F, new b.a()
                {
                  public final void aXe()
                  {
                    AppMethodBeat.i(235325);
                    onAnimationEnd();
                    AppMethodBeat.o(235325);
                  }
                  
                  public final void onAnimationEnd()
                  {
                    AppMethodBeat.i(235319);
                    SwipeBackLayout.b(SwipeBackLayout.this, false);
                    AppMethodBeat.o(235319);
                  }
                });
              }
            }
          }
          for (;;)
          {
            SwipeBackLayout.c(SwipeBackLayout.this, false);
            AppMethodBeat.o(235327);
            return;
            d.bk(1.0F);
            break;
            SwipeBackLayout.b(SwipeBackLayout.this, false);
            break;
            label206:
            b.a(SwipeBackLayout.c(SwipeBackLayout.this), 200L, SwipeBackLayout.c.this.mqH, new b.a()
            {
              public final void aXe()
              {
                AppMethodBeat.i(235323);
                onAnimationEnd();
                AppMethodBeat.o(235323);
              }
              
              public final void onAnimationEnd()
              {
                AppMethodBeat.i(235318);
                SwipeBackLayout.a(SwipeBackLayout.this, true);
                new Handler().post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(235326);
                    if (SwipeBackLayout.h(SwipeBackLayout.this) != null)
                    {
                      if (((SwipeBackLayout.this.getContext() instanceof Activity)) && (SwipeBackLayout.i(SwipeBackLayout.this) != null))
                      {
                        if (SwipeBackLayout.j(SwipeBackLayout.this)) {
                          ((Activity)SwipeBackLayout.this.getContext()).getWindow().getDecorView().setBackground(SwipeBackLayout.i(SwipeBackLayout.this));
                        }
                        SwipeBackLayout.a(SwipeBackLayout.this, null);
                      }
                      SwipeBackLayout.h(SwipeBackLayout.this).onSwipeBack();
                      com.tencent.liteapp.b.b.d("MicroMsg.SwipeBackLayout", "ashutest:: on onSwipeBack", new Object[0]);
                    }
                    d.bk(1.0F);
                    SwipeBackLayout.b(SwipeBackLayout.this, false);
                    AppMethodBeat.o(235326);
                  }
                });
                AppMethodBeat.o(235318);
              }
            });
            d.g(true, SwipeBackLayout.c.this.mqH);
          }
        }
      });
      AppMethodBeat.o(235432);
    }
    
    public final boolean rT(int paramInt)
    {
      AppMethodBeat.i(235374);
      f localf = SwipeBackLayout.a(SwipeBackLayout.this);
      if ((localf.bxG & 1 << paramInt) != 0) {}
      for (int i = 1; (i != 0) && ((localf.bxD[paramInt] & 0x1) != 0); i = 0)
      {
        AppMethodBeat.o(235374);
        return true;
      }
      AppMethodBeat.o(235374);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ext.ui.SwipeBackLayout
 * JD-Core Version:    0.7.0.1
 */