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
import android.widget.OverScroller;
import androidx.core.g.w;
import androidx.core.widget.h;
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
  private float RH;
  private Rect Si;
  private float jRf;
  private int jRg;
  private int jRh;
  private f jRi;
  private float jRj;
  private Drawable jRk;
  private boolean jRl;
  private boolean jRm;
  boolean jRn;
  private boolean jRo;
  boolean jRp;
  private boolean jRq;
  private b jRr;
  private Drawable jRs;
  private boolean jRt;
  private boolean jRu;
  private a jRv;
  private View mContentView;
  private boolean mEnable;
  private Handler mHandler;
  private boolean mInLayout;
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(258978);
    this.jRf = 0.3F;
    this.mEnable = true;
    this.Si = new Rect();
    this.jRl = true;
    this.jRm = false;
    this.jRn = false;
    this.jRo = false;
    this.jRp = false;
    this.jRq = false;
    this.mHandler = new Handler(Looper.getMainLooper());
    this.jRu = true;
    this.jRv = null;
    this.jRk = getResources().getDrawable(a.c.shadow_left);
    setFocusable(true);
    setDescendantFocusability(262144);
    init();
    AppMethodBeat.o(258978);
  }
  
  public final boolean aEc()
  {
    AppMethodBeat.i(258985);
    if (!this.jRp)
    {
      AppMethodBeat.o(258985);
      return false;
    }
    if (Float.compare(this.mContentView.getLeft(), 0.01F) <= 0)
    {
      this.jRp = false;
      AppMethodBeat.o(258985);
      return false;
    }
    AppMethodBeat.o(258985);
    return true;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(258994);
    this.RH = Math.max(0.0F, 1.0F - this.jRj);
    f localf = this.jRi;
    if (localf.Rh == 2)
    {
      boolean bool2 = localf.jRY.Qi.computeScrollOffset();
      i = localf.jRY.Qi.getCurrX();
      int j = localf.jRY.Qi.getCurrY();
      int k = i - localf.Rv.getLeft();
      int m = j - localf.Rv.getTop();
      if (k != 0) {
        localf.Rv.offsetLeftAndRight(k);
      }
      if (m != 0) {
        localf.Rv.offsetTopAndBottom(m);
      }
      if ((k != 0) || (m != 0)) {
        localf.jRZ.df(i, j);
      }
      boolean bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (i == localf.jRY.Qi.getFinalX())
        {
          bool1 = bool2;
          if (j == localf.jRY.Qi.getFinalY())
          {
            localf.jRY.Qi.abortAnimation();
            bool1 = localf.jRY.Qi.isFinished();
          }
        }
      }
      if (!bool1) {
        localf.Rx.post(localf.Ry);
      }
    }
    if (localf.Rh == 2) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        w.G(this);
      }
      AppMethodBeat.o(258994);
      return;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(258987);
    boolean bool;
    if (!this.mEnable)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(258987);
      return bool;
    }
    if (paramMotionEvent.getAction() == 0) {
      this.jRt = false;
    }
    if (this.jRt)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(258987);
      return bool;
    }
    if (aEc())
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(258987);
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
        if (this.jRi.Rh != 1) {
          break;
        }
        localf = this.jRi;
        i = paramMotionEvent.getActionMasked();
        j = paramMotionEvent.getActionIndex();
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
        AppMethodBeat.o(258987);
        return false;
        j = (int)f1;
        k = (int)f2;
        if (!f.g(localf.Rv, j, k)) {
          continue;
        }
        localf.y(localf.Rv, i);
        continue;
      }
      catch (IllegalArgumentException paramMotionEvent)
      {
        com.tencent.liteapp.b.b.e("MicroMsg.SwipeBackLayout", "got an IllegalArgumentException: %s", new Object[] { paramMotionEvent.toString() });
        AppMethodBeat.o(258987);
        return false;
        if (localf.Rh != 1) {
          continue;
        }
        i = paramMotionEvent.findPointerIndex(localf.mActivePointerId);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        m = (int)(f1 - localf.Rk[localf.mActivePointerId]);
        n = (int)(f2 - localf.Rl[localf.mActivePointerId]);
        k = localf.Rv.getLeft() + m;
        j = localf.Rv.getTop() + n;
        int i2 = localf.Rv.getLeft();
        int i1 = localf.Rv.getTop();
        i = k;
        if (m == 0) {
          continue;
        }
        i = localf.jRZ.d(localf.Rv, k);
        localf.Rv.offsetLeftAndRight(i - i2);
        if (n == 0) {
          break label1477;
        }
        localf.Rv.offsetTopAndBottom(0 - i1);
        j = 0;
        break label1477;
        localf.jRZ.df(i, j);
        localf.h(paramMotionEvent);
        continue;
      }
      catch (ArrayIndexOutOfBoundsException paramMotionEvent)
      {
        com.tencent.liteapp.b.b.e("MicroMsg.SwipeBackLayout", "got an ArrayIndexOutOfBoundsException: %s", new Object[] { paramMotionEvent.toString() });
        AppMethodBeat.o(258987);
        return false;
        j = paramMotionEvent.getPointerCount();
        i = 0;
        if (i >= j) {
          continue;
        }
        k = paramMotionEvent.getPointerId(i);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        f3 = f1 - localf.Ri[k];
        localf.b(f3, f2 - localf.Rj[k], k);
        if (localf.Rh == 1) {
          continue;
        }
        localView = localf.K((int)f1, (int)f2);
        if ((!localf.r(localView, f3)) || (!localf.y(localView, k))) {
          break label1490;
        }
        localf.h(paramMotionEvent);
        continue;
      }
      catch (IllegalStateException paramMotionEvent)
      {
        com.tencent.liteapp.b.b.e("MicroMsg.SwipeBackLayout", "got an IllegalStateException: %s", new Object[] { paramMotionEvent.toString() });
        AppMethodBeat.o(258987);
        return false;
      }
      AppMethodBeat.o(258987);
      return true;
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      i = paramMotionEvent.getPointerId(0);
      paramMotionEvent = localf.K((int)f1, (int)f2);
      localf.a(f1, f2, i);
      localf.y(paramMotionEvent, i);
      i = localf.Rm[i];
      if ((localf.Rt & i) != 0)
      {
        continue;
        i = paramMotionEvent.getPointerId(j);
        f1 = paramMotionEvent.getX(j);
        f2 = paramMotionEvent.getY(j);
        localf.a(f1, f2, i);
        if (localf.Rh == 0)
        {
          localf.y(localf.K((int)f1, (int)f2), i);
        }
        else
        {
          j = paramMotionEvent.getPointerId(j);
          if ((localf.Rh == 1) && (j == localf.mActivePointerId))
          {
            k = paramMotionEvent.getPointerCount();
            i = 0;
            label843:
            if (i >= k) {
              break label1471;
            }
            m = paramMotionEvent.getPointerId(i);
            if (m == localf.mActivePointerId) {
              break label1499;
            }
            f1 = paramMotionEvent.getX(i);
            f2 = paramMotionEvent.getY(i);
            if ((localf.K((int)f1, (int)f2) != localf.Rv) || (!localf.y(localf.Rv, m))) {
              break label1499;
            }
            i = localf.mActivePointerId;
            label921:
            if (i == -1) {
              localf.hN();
            }
          }
          localf.bP(j);
          continue;
          if (localf.Rh == 1) {
            localf.hN();
          }
          localf.cancel();
          continue;
          if (localf.Rh == 1) {
            localf.e(0.0F, 0.0F);
          }
          localf.cancel();
        }
      }
    }
    f localf = this.jRi;
    int j = paramMotionEvent.getActionMasked();
    int i = paramMotionEvent.getActionIndex();
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
      if (localf.Rh != 1) {
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
        AppMethodBeat.o(258987);
        return true;
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        i = paramMotionEvent.getPointerId(0);
        localf.a(f1, f2, i);
        localView = localf.K((int)f1, (int)f2);
        if ((localView == localf.Rv) && (localf.Rh == 2)) {
          localf.y(localView, i);
        }
        if ((localf.Rm[i] & localf.Rt) == 0) {
          break label1084;
        }
        break label1084;
        j = paramMotionEvent.getPointerId(i);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        localf.a(f1, f2, j);
        if ((localf.Rh == 0) || (localf.Rh != 2)) {
          break label1084;
        }
        localView = localf.K((int)f1, (int)f2);
        if (localView != localf.Rv) {
          break label1084;
        }
        localf.y(localView, j);
        break label1084;
        j = paramMotionEvent.getPointerCount();
        i = 0;
      }
      for (;;)
      {
        if (i < j)
        {
          k = paramMotionEvent.getPointerId(i);
          f1 = paramMotionEvent.getX(i);
          f2 = paramMotionEvent.getY(i);
          f3 = f1 - localf.Ri[k];
          localf.b(f3, f2 - localf.Rj[k], k);
          if (localf.Rh != 1)
          {
            localView = localf.K((int)f1, (int)f2);
            if ((localView == null) || (!localf.r(localView, f3)) || (!localf.y(localView, k))) {
              break label1511;
            }
          }
        }
        localf.h(paramMotionEvent);
        break label1084;
        localf.bP(paramMotionEvent.getPointerId(i));
        break label1084;
        localf.cancel();
        break label1084;
        super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(258987);
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
    AppMethodBeat.i(258992);
    if (paramView == this.mContentView) {}
    for (int i = 1;; i = 0)
    {
      boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
      if ((Float.compare(this.RH, 0.0F) > 0) && (i != 0) && (this.jRi.Rh != 0))
      {
        Rect localRect = this.Si;
        paramView.getHitRect(localRect);
        this.jRk.setBounds(localRect.left - this.jRk.getIntrinsicWidth(), localRect.top, localRect.left, localRect.bottom);
        this.jRk.setAlpha((int)(this.RH * 255.0F));
        this.jRk.draw(paramCanvas);
        com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "shadow left:%d top:%d right:%d bootom:%d", new Object[] { Integer.valueOf(this.jRk.getBounds().left), Integer.valueOf(this.jRk.getBounds().top), Integer.valueOf(this.jRk.getBounds().right), Integer.valueOf(this.jRk.getBounds().bottom) });
      }
      AppMethodBeat.o(258992);
      return bool;
    }
  }
  
  public View getTargetContentView()
  {
    return this.mContentView;
  }
  
  public final void init()
  {
    AppMethodBeat.i(258979);
    Interpolator localInterpolator = AnimationUtils.loadInterpolator(getContext(), com.tencent.liteapp.a.a.mm_decelerate_interpolator);
    this.jRi = f.a(this, new c((byte)0), localInterpolator);
    this.jRi.Rt = 1;
    float f = getResources().getDisplayMetrics().density;
    this.jRi.Rr = (100.0F * f);
    this.jRi.Rq = (f * 300.0F);
    this.jRg = 0;
    this.jRh = 0;
    AppMethodBeat.o(258979);
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(258981);
    super.onFinishInflate();
    this.mContentView = this;
    AppMethodBeat.o(258981);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(258988);
    this.mInLayout = true;
    if (this.mContentView != null) {
      this.mContentView.layout(this.jRg, this.jRh, this.jRg + this.mContentView.getMeasuredWidth(), this.jRh + this.mContentView.getMeasuredHeight());
    }
    this.mInLayout = false;
    AppMethodBeat.o(258988);
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(258991);
    if (!this.mInLayout) {
      super.requestLayout();
    }
    AppMethodBeat.o(258991);
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
    this.jRu = paramBoolean;
  }
  
  public void setNeedRequestActivityTranslucent(boolean paramBoolean)
  {
    this.jRl = paramBoolean;
    if (this.jRl) {
      this.jRm = false;
    }
  }
  
  public void setOnceDisEnableGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(258983);
    com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "[setOnceDisEnableGesture] enable:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.jRt = paramBoolean;
    AppMethodBeat.o(258983);
  }
  
  public void setSwipeBackListener(b paramb)
  {
    this.jRr = paramb;
  }
  
  public void setSwipeGestureDelegate(a parama)
  {
    this.jRv = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onCancel();
    
    public abstract void onDrag();
    
    public abstract void onSwipeBack();
  }
  
  public static abstract interface b
  {
    public abstract int aEd();
  }
  
  final class c
    extends f.a
    implements a.a
  {
    int jRw = 0;
    int jRx = 0;
    int jRy = 0;
    
    private c() {}
    
    public final void G(int paramInt)
    {
      Object localObject1 = null;
      AppMethodBeat.i(258973);
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
          d.ap(0.0F);
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
        d.ap(1.0F);
      }
      Activity localActivity;
      boolean bool;
      if ((1 == paramInt) && (SwipeBackLayout.o(SwipeBackLayout.this)) && ((SwipeBackLayout.this.getContext() instanceof Activity)) && (!SwipeBackLayout.b(SwipeBackLayout.this)) && (!SwipeBackLayout.m(SwipeBackLayout.this)))
      {
        com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "ashutest:: match dragging", new Object[0]);
        SwipeBackLayout.d(SwipeBackLayout.this, true);
        localActivity = (Activity)SwipeBackLayout.this.getContext();
        if (a.qW(16)) {
          com.tencent.liteapp.b.b.w("MicroMsg.ActivityUtil", "convertActivityToTranslucent::Android Version Error %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
        }
      }
      else
      {
        if (2 == paramInt)
        {
          com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "ashutest:: notify settle, mReleasedLeft %d", new Object[] { Integer.valueOf(this.jRx) });
          if (this.jRx <= 0) {
            break label689;
          }
          bool = true;
          label457:
          d.j(bool, this.jRx);
        }
        AppMethodBeat.o(258973);
        return;
      }
      for (;;)
      {
        int i;
        Object localObject2;
        try
        {
          Class[] arrayOfClass = Activity.class.getDeclaredClasses();
          int j = arrayOfClass.length;
          i = 0;
          if (i < j)
          {
            localObject2 = arrayOfClass[i];
            if (!((Class)localObject2).getSimpleName().contains("TranslucentConversionListener")) {
              break label695;
            }
            localObject1 = localObject2;
            break label695;
          }
          localObject2 = new a.b((byte)0);
          ((a.b)localObject2).jRb = new WeakReference(this);
          localObject2 = Proxy.newProxyInstance(((Class)localObject1).getClassLoader(), new Class[] { localObject1 }, (InvocationHandler)localObject2);
          if (!a.qW(21)) {
            break label636;
          }
          localObject1 = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[] { localObject1 });
          ((Method)localObject1).setAccessible(true);
          ((Method)localObject1).invoke(localActivity, new Object[] { localObject2 });
        }
        catch (Throwable localThrowable)
        {
          com.tencent.liteapp.b.b.e("MicroMsg.ActivityUtil", "call convertActivityToTranslucent Fail: %s", new Object[] { localThrowable.getMessage() });
        }
        break;
        label636:
        Method localMethod = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[] { localThrowable, ActivityOptions.class });
        localMethod.setAccessible(true);
        localMethod.invoke(localActivity, new Object[] { localObject2, null });
        break;
        label689:
        bool = false;
        break label457;
        label695:
        i += 1;
      }
    }
    
    public final void a(View paramView, float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(258971);
      int i = paramView.getWidth();
      this.jRx = 0;
      this.jRy = 0;
      if ((paramFloat1 > 0.0F) || ((paramFloat1 == 0.0F) && (SwipeBackLayout.f(SwipeBackLayout.this) > SwipeBackLayout.l(SwipeBackLayout.this))))
      {
        i = i + SwipeBackLayout.d(SwipeBackLayout.this).getIntrinsicWidth() + 10;
        this.jRx = i;
        com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "ashutest::onViewReleased, xvel:%f yvel:%f, releaseLeft:%d, releaseTop:%d, translucent %B", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(this.jRx), Integer.valueOf(this.jRy), Boolean.valueOf(SwipeBackLayout.b(SwipeBackLayout.this)) });
        SwipeBackLayout.b(SwipeBackLayout.this, true);
        if (SwipeBackLayout.e(SwipeBackLayout.this) != null)
        {
          i = SwipeBackLayout.e(SwipeBackLayout.this).aEd();
          com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "intercepted by mSwipeBackListener.onViewReleased, result:%s", new Object[] { Integer.valueOf(i) });
          if (i != 2) {
            break label259;
          }
          this.jRx = 0;
        }
      }
      for (;;)
      {
        if (SwipeBackLayout.b(SwipeBackLayout.this))
        {
          paramView = SwipeBackLayout.a(SwipeBackLayout.this);
          int n = this.jRx;
          int i1 = this.jRy;
          if (!paramView.Rw)
          {
            paramView = new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
            AppMethodBeat.o(258971);
            throw paramView;
            i = 0;
            break;
            label259:
            if (i != 3) {
              continue;
            }
            AppMethodBeat.o(258971);
            return;
          }
          i = (int)paramView.mVelocityTracker.getXVelocity(paramView.mActivePointerId);
          int j = (int)paramView.mVelocityTracker.getYVelocity(paramView.mActivePointerId);
          int k = paramView.Rv.getLeft();
          int m = paramView.Rv.getTop();
          n -= k;
          i1 -= m;
          if ((n == 0) && (i1 == 0))
          {
            paramView.jRY.Qi.abortAnimation();
            paramView.bR(0);
            SwipeBackLayout.this.invalidate();
            AppMethodBeat.o(258971);
            return;
          }
          int i2;
          int i4;
          int i5;
          int i9;
          label464:
          label477:
          float f;
          if (0L == 0L)
          {
            int i3 = f.f(i, (int)paramView.Rr, (int)paramView.Rq);
            i2 = f.f(j, (int)paramView.Rr, (int)paramView.Rq);
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
                break label614;
              }
              paramFloat2 = i7 / i8;
              i3 = paramView.e(n, i3, paramView.jRZ.aEe());
              i2 = paramView.e(i1, i2, 0);
              f = i3;
            }
          }
          for (long l = (int)(paramFloat2 * i2 + paramFloat1 * f);; l = 0L)
          {
            com.tencent.liteapp.b.b.d("WxViewDragHelper", "ashutest:: xvel %d, yvel %d, dx %d, dy %d duration %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(i1), Long.valueOf(l) });
            paramView.jRY.startScroll(k, m, n, i1, (int)l);
            paramView.bR(2);
            break;
            paramFloat1 = i4 / i9;
            break label464;
            label614:
            paramFloat2 = i5 / i9;
            break label477;
          }
        }
      }
      SwipeBackLayout.c(SwipeBackLayout.this, true);
      AppMethodBeat.o(258971);
    }
    
    public final int aEe()
    {
      return 1;
    }
    
    public final int d(View paramView, int paramInt)
    {
      AppMethodBeat.i(258972);
      if (SwipeBackLayout.b(SwipeBackLayout.this))
      {
        paramInt = Math.max(this.jRw, paramInt);
        this.jRw = 0;
        paramInt = Math.min(paramView.getWidth(), Math.max(paramInt, 0));
        AppMethodBeat.o(258972);
        return paramInt;
      }
      this.jRw = Math.max(this.jRw, paramInt);
      AppMethodBeat.o(258972);
      return 0;
    }
    
    public final void df(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(258970);
      if (!SwipeBackLayout.b(SwipeBackLayout.this))
      {
        com.tencent.liteapp.b.b.w("MicroMsg.SwipeBackLayout", "[onViewPositionChanged] mHasTranslucent is false", new Object[0]);
        AppMethodBeat.o(258970);
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
            AppMethodBeat.i(258948);
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
            AppMethodBeat.o(258948);
          }
        });
      }
      for (;;)
      {
        if (SwipeBackLayout.a(SwipeBackLayout.this).Rh == 1) {
          d.ap(SwipeBackLayout.f(SwipeBackLayout.this));
        }
        AppMethodBeat.o(258970);
        return;
        if (Float.compare(SwipeBackLayout.f(SwipeBackLayout.this), 0.01F) <= 0)
        {
          SwipeBackLayout.b(SwipeBackLayout.this, false);
          com.tencent.liteapp.b.b.w("MicroMsg.SwipeBackLayout", "[onViewPositionChanged] mScrollPercent:%s mHasCallPopOut:%s", new Object[] { Float.valueOf(SwipeBackLayout.f(SwipeBackLayout.this)), Boolean.valueOf(SwipeBackLayout.g(SwipeBackLayout.this)) });
        }
      }
    }
    
    public final void eG(final boolean paramBoolean)
    {
      AppMethodBeat.i(258974);
      SwipeBackLayout.k(SwipeBackLayout.this).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(258965);
          com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "on Complete, result %B, releaseLeft %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(SwipeBackLayout.c.this.jRx) });
          SwipeBackLayout.d(SwipeBackLayout.this, paramBoolean);
          if (paramBoolean) {
            if (SwipeBackLayout.c.this.jRx > 0)
            {
              d.ap(0.0F);
              SwipeBackLayout localSwipeBackLayout = SwipeBackLayout.this;
              boolean bool = paramBoolean;
              com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "ashutest::markTranslucent %B", new Object[] { Boolean.valueOf(bool) });
              localSwipeBackLayout.jRn = bool;
              if ((paramBoolean) && (SwipeBackLayout.n(SwipeBackLayout.this)))
              {
                if (SwipeBackLayout.c.this.jRx != 0) {
                  break label206;
                }
                b.a(SwipeBackLayout.c(SwipeBackLayout.this), 200L, 0.0F, new b.a()
                {
                  public final void aEa()
                  {
                    AppMethodBeat.i(258950);
                    onAnimationEnd();
                    AppMethodBeat.o(258950);
                  }
                  
                  public final void onAnimationEnd()
                  {
                    AppMethodBeat.i(258949);
                    SwipeBackLayout.b(SwipeBackLayout.this, false);
                    AppMethodBeat.o(258949);
                  }
                });
              }
            }
          }
          for (;;)
          {
            SwipeBackLayout.c(SwipeBackLayout.this, false);
            AppMethodBeat.o(258965);
            return;
            d.ap(1.0F);
            break;
            SwipeBackLayout.b(SwipeBackLayout.this, false);
            break;
            label206:
            b.a(SwipeBackLayout.c(SwipeBackLayout.this), 200L, SwipeBackLayout.c.this.jRx, new b.a()
            {
              public final void aEa()
              {
                AppMethodBeat.i(258960);
                onAnimationEnd();
                AppMethodBeat.o(258960);
              }
              
              public final void onAnimationEnd()
              {
                AppMethodBeat.i(258959);
                SwipeBackLayout.a(SwipeBackLayout.this, true);
                new Handler().post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(258958);
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
                    d.ap(1.0F);
                    SwipeBackLayout.b(SwipeBackLayout.this, false);
                    AppMethodBeat.o(258958);
                  }
                });
                AppMethodBeat.o(258959);
              }
            });
            d.j(true, SwipeBackLayout.c.this.jRx);
          }
        }
      });
      AppMethodBeat.o(258974);
    }
    
    public final boolean rS(int paramInt)
    {
      AppMethodBeat.i(258968);
      f localf = SwipeBackLayout.a(SwipeBackLayout.this);
      if ((localf.Rp & 1 << paramInt) != 0) {}
      for (int i = 1; (i != 0) && ((localf.Rm[paramInt] & 0x1) != 0); i = 0)
      {
        AppMethodBeat.o(258968);
        return true;
      }
      AppMethodBeat.o(258968);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ext.ui.SwipeBackLayout
 * JD-Core Version:    0.7.0.1
 */