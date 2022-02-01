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
import android.support.v4.view.u;
import android.support.v4.widget.p;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ext.a.b.a;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SwipeBackLayout
  extends FrameLayout
{
  private float TH;
  private Rect Ui;
  private Drawable hfA;
  private boolean hfB;
  private boolean hfC;
  private a hfD;
  private float hfn;
  private int hfo;
  private int hfp;
  private f hfq;
  private float hfr;
  private Drawable hfs;
  private boolean hft;
  private boolean hfu;
  boolean hfv;
  private boolean hfw;
  boolean hfx;
  private boolean hfy;
  private b hfz;
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
    AppMethodBeat.i(197854);
    this.hfn = 0.3F;
    this.mEnable = true;
    this.Ui = new Rect();
    this.hft = true;
    this.hfu = false;
    this.hfv = false;
    this.hfw = false;
    this.hfx = false;
    this.hfy = false;
    this.mHandler = new Handler(Looper.getMainLooper());
    this.hfC = true;
    this.hfD = null;
    this.hfs = getResources().getDrawable(2131234799);
    setFocusable(true);
    setDescendantFocusability(262144);
    init();
    AppMethodBeat.o(197854);
  }
  
  public final boolean awK()
  {
    AppMethodBeat.i(197858);
    if (!this.hfx)
    {
      AppMethodBeat.o(197858);
      return false;
    }
    if (Float.compare(this.mContentView.getLeft(), 0.01F) <= 0)
    {
      this.hfx = false;
      AppMethodBeat.o(197858);
      return false;
    }
    AppMethodBeat.o(197858);
    return true;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(197863);
    this.TH = Math.max(0.0F, 1.0F - this.hfr);
    f localf = this.hfq;
    if (localf.Wx == 2)
    {
      boolean bool2 = localf.hgg.UD.computeScrollOffset();
      i = localf.hgg.UD.getCurrX();
      int j = localf.hgg.UD.getCurrY();
      int k = i - localf.WL.getLeft();
      int m = j - localf.WL.getTop();
      if (k != 0) {
        localf.WL.offsetLeftAndRight(k);
      }
      if (m != 0) {
        localf.WL.offsetTopAndBottom(m);
      }
      if ((k != 0) || (m != 0)) {
        localf.hgh.cL(i, j);
      }
      boolean bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (i == localf.hgg.UD.getFinalX())
        {
          bool1 = bool2;
          if (j == localf.hgg.UD.getFinalY())
          {
            localf.hgg.UD.abortAnimation();
            bool1 = localf.hgg.UD.isFinished();
          }
        }
      }
      if (!bool1) {
        localf.WN.post(localf.WO);
      }
    }
    if (localf.Wx == 2) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        u.X(this);
      }
      AppMethodBeat.o(197863);
      return;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(197859);
    boolean bool;
    if (!this.mEnable)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(197859);
      return bool;
    }
    if (paramMotionEvent.getAction() == 0) {
      this.hfB = false;
    }
    if (this.hfB)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(197859);
      return bool;
    }
    if (awK())
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(197859);
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
        if (this.hfq.Wx != 1) {
          break;
        }
        localf = this.hfq;
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
        AppMethodBeat.o(197859);
        return false;
        j = (int)f1;
        k = (int)f2;
        if (!f.i(localf.WL, j, k)) {
          continue;
        }
        localf.z(localf.WL, i);
        continue;
      }
      catch (IllegalArgumentException paramMotionEvent)
      {
        com.tencent.liteapp.b.b.e("MicroMsg.SwipeBackLayout", "got an IllegalArgumentException: %s", new Object[] { paramMotionEvent.toString() });
        AppMethodBeat.o(197859);
        return false;
        if (localf.Wx != 1) {
          continue;
        }
        i = paramMotionEvent.findPointerIndex(localf.mActivePointerId);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        m = (int)(f1 - localf.WA[localf.mActivePointerId]);
        n = (int)(f2 - localf.WB[localf.mActivePointerId]);
        k = localf.WL.getLeft() + m;
        j = localf.WL.getTop() + n;
        int i2 = localf.WL.getLeft();
        int i1 = localf.WL.getTop();
        i = k;
        if (m == 0) {
          continue;
        }
        i = localf.hgh.e(localf.WL, k);
        localf.WL.offsetLeftAndRight(i - i2);
        if (n == 0) {
          break label1477;
        }
        localf.WL.offsetTopAndBottom(0 - i1);
        j = 0;
        break label1477;
        localf.hgh.cL(i, j);
        localf.i(paramMotionEvent);
        continue;
      }
      catch (ArrayIndexOutOfBoundsException paramMotionEvent)
      {
        com.tencent.liteapp.b.b.e("MicroMsg.SwipeBackLayout", "got an ArrayIndexOutOfBoundsException: %s", new Object[] { paramMotionEvent.toString() });
        AppMethodBeat.o(197859);
        return false;
        j = paramMotionEvent.getPointerCount();
        i = 0;
        if (i >= j) {
          continue;
        }
        k = paramMotionEvent.getPointerId(i);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        f3 = f1 - localf.Wy[k];
        localf.b(f3, f2 - localf.Wz[k], k);
        if (localf.Wx == 1) {
          continue;
        }
        localView = localf.J((int)f1, (int)f2);
        if ((!localf.r(localView, f3)) || (!localf.z(localView, k))) {
          break label1490;
        }
        localf.i(paramMotionEvent);
        continue;
      }
      catch (IllegalStateException paramMotionEvent)
      {
        com.tencent.liteapp.b.b.e("MicroMsg.SwipeBackLayout", "got an IllegalStateException: %s", new Object[] { paramMotionEvent.toString() });
        AppMethodBeat.o(197859);
        return false;
      }
      AppMethodBeat.o(197859);
      return true;
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      i = paramMotionEvent.getPointerId(0);
      paramMotionEvent = localf.J((int)f1, (int)f2);
      localf.a(f1, f2, i);
      localf.z(paramMotionEvent, i);
      i = localf.WC[i];
      if ((localf.WJ & i) != 0)
      {
        continue;
        i = paramMotionEvent.getPointerId(j);
        f1 = paramMotionEvent.getX(j);
        f2 = paramMotionEvent.getY(j);
        localf.a(f1, f2, i);
        if (localf.Wx == 0)
        {
          localf.z(localf.J((int)f1, (int)f2), i);
        }
        else
        {
          j = paramMotionEvent.getPointerId(j);
          if ((localf.Wx == 1) && (j == localf.mActivePointerId))
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
            if ((localf.J((int)f1, (int)f2) != localf.WL) || (!localf.z(localf.WL, m))) {
              break label1499;
            }
            i = localf.mActivePointerId;
            label921:
            if (i == -1) {
              localf.gq();
            }
          }
          localf.bd(j);
          continue;
          if (localf.Wx == 1) {
            localf.gq();
          }
          localf.cancel();
          continue;
          if (localf.Wx == 1) {
            localf.l(0.0F, 0.0F);
          }
          localf.cancel();
        }
      }
    }
    f localf = this.hfq;
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
      if (localf.Wx != 1) {
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
        AppMethodBeat.o(197859);
        return true;
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        i = paramMotionEvent.getPointerId(0);
        localf.a(f1, f2, i);
        localView = localf.J((int)f1, (int)f2);
        if ((localView == localf.WL) && (localf.Wx == 2)) {
          localf.z(localView, i);
        }
        if ((localf.WC[i] & localf.WJ) == 0) {
          break label1084;
        }
        break label1084;
        j = paramMotionEvent.getPointerId(i);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        localf.a(f1, f2, j);
        if ((localf.Wx == 0) || (localf.Wx != 2)) {
          break label1084;
        }
        localView = localf.J((int)f1, (int)f2);
        if (localView != localf.WL) {
          break label1084;
        }
        localf.z(localView, j);
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
          f3 = f1 - localf.Wy[k];
          localf.b(f3, f2 - localf.Wz[k], k);
          if (localf.Wx != 1)
          {
            localView = localf.J((int)f1, (int)f2);
            if ((localView == null) || (!localf.r(localView, f3)) || (!localf.z(localView, k))) {
              break label1511;
            }
          }
        }
        localf.i(paramMotionEvent);
        break label1084;
        localf.bd(paramMotionEvent.getPointerId(i));
        break label1084;
        localf.cancel();
        break label1084;
        super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(197859);
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
    AppMethodBeat.i(197862);
    if (paramView == this.mContentView) {}
    for (int i = 1;; i = 0)
    {
      boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
      if ((Float.compare(this.TH, 0.0F) > 0) && (i != 0) && (this.hfq.Wx != 0))
      {
        Rect localRect = this.Ui;
        paramView.getHitRect(localRect);
        this.hfs.setBounds(localRect.left - this.hfs.getIntrinsicWidth(), localRect.top, localRect.left, localRect.bottom);
        this.hfs.setAlpha((int)(this.TH * 255.0F));
        this.hfs.draw(paramCanvas);
        com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "shadow left:%d top:%d right:%d bootom:%d", new Object[] { Integer.valueOf(this.hfs.getBounds().left), Integer.valueOf(this.hfs.getBounds().top), Integer.valueOf(this.hfs.getBounds().right), Integer.valueOf(this.hfs.getBounds().bottom) });
      }
      AppMethodBeat.o(197862);
      return bool;
    }
  }
  
  public View getTargetContentView()
  {
    return this.mContentView;
  }
  
  public final void init()
  {
    AppMethodBeat.i(197855);
    Interpolator localInterpolator = AnimationUtils.loadInterpolator(getContext(), 2130772093);
    this.hfq = f.a(this, new c((byte)0), localInterpolator);
    this.hfq.WJ = 1;
    float f = getResources().getDisplayMetrics().density;
    this.hfq.WH = (100.0F * f);
    this.hfq.WG = (f * 300.0F);
    this.hfo = 0;
    this.hfp = 0;
    AppMethodBeat.o(197855);
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(197856);
    super.onFinishInflate();
    this.mContentView = this;
    AppMethodBeat.o(197856);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(197860);
    this.mInLayout = true;
    if (this.mContentView != null) {
      this.mContentView.layout(this.hfo, this.hfp, this.hfo + this.mContentView.getMeasuredWidth(), this.hfp + this.mContentView.getMeasuredHeight());
    }
    this.mInLayout = false;
    AppMethodBeat.o(197860);
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(197861);
    if (!this.mInLayout) {
      super.requestLayout();
    }
    AppMethodBeat.o(197861);
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
    this.hfC = paramBoolean;
  }
  
  public void setNeedRequestActivityTranslucent(boolean paramBoolean)
  {
    this.hft = paramBoolean;
    if (this.hft) {
      this.hfu = false;
    }
  }
  
  public void setOnceDisEnableGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(197857);
    com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "[setOnceDisEnableGesture] enable:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.hfB = paramBoolean;
    AppMethodBeat.o(197857);
  }
  
  public void setSwipeBackListener(b paramb)
  {
    this.hfz = paramb;
  }
  
  public void setSwipeGestureDelegate(a parama)
  {
    this.hfD = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onCancel();
    
    public abstract void onDrag();
    
    public abstract void onSwipeBack();
  }
  
  public static abstract interface b
  {
    public abstract int awL();
  }
  
  final class c
    extends f.a
    implements a.a
  {
    int hfE = 0;
    int hfF = 0;
    int hfG = 0;
    
    private c() {}
    
    public final void L(int paramInt)
    {
      Object localObject1 = null;
      AppMethodBeat.i(197852);
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
          d.aq(0.0F);
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
        d.aq(1.0F);
      }
      Activity localActivity;
      boolean bool;
      if ((1 == paramInt) && (SwipeBackLayout.o(SwipeBackLayout.this)) && ((SwipeBackLayout.this.getContext() instanceof Activity)) && (!SwipeBackLayout.b(SwipeBackLayout.this)) && (!SwipeBackLayout.m(SwipeBackLayout.this)))
      {
        com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "ashutest:: match dragging", new Object[0]);
        SwipeBackLayout.d(SwipeBackLayout.this, true);
        localActivity = (Activity)SwipeBackLayout.this.getContext();
        if (a.oE(16)) {
          com.tencent.liteapp.b.b.w("MicroMsg.ActivityUtil", "convertActivityToTranslucent::Android Version Error %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
        }
      }
      else
      {
        if (2 == paramInt)
        {
          com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "ashutest:: notify settle, mReleasedLeft %d", new Object[] { Integer.valueOf(this.hfF) });
          if (this.hfF <= 0) {
            break label689;
          }
          bool = true;
          label457:
          d.h(bool, this.hfF);
        }
        AppMethodBeat.o(197852);
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
          ((a.b)localObject2).hfj = new WeakReference(this);
          localObject2 = Proxy.newProxyInstance(((Class)localObject1).getClassLoader(), new Class[] { localObject1 }, (InvocationHandler)localObject2);
          if (!a.oE(21)) {
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
      AppMethodBeat.i(197850);
      int i = paramView.getWidth();
      this.hfF = 0;
      this.hfG = 0;
      if ((paramFloat1 > 0.0F) || ((paramFloat1 == 0.0F) && (SwipeBackLayout.f(SwipeBackLayout.this) > SwipeBackLayout.l(SwipeBackLayout.this))))
      {
        i = i + SwipeBackLayout.d(SwipeBackLayout.this).getIntrinsicWidth() + 10;
        this.hfF = i;
        com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "ashutest::onViewReleased, xvel:%f yvel:%f, releaseLeft:%d, releaseTop:%d, translucent %B", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(this.hfF), Integer.valueOf(this.hfG), Boolean.valueOf(SwipeBackLayout.b(SwipeBackLayout.this)) });
        SwipeBackLayout.b(SwipeBackLayout.this, true);
        if (SwipeBackLayout.e(SwipeBackLayout.this) != null)
        {
          i = SwipeBackLayout.e(SwipeBackLayout.this).awL();
          com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "intercepted by mSwipeBackListener.onViewReleased, result:%s", new Object[] { Integer.valueOf(i) });
          if (i != 2) {
            break label259;
          }
          this.hfF = 0;
        }
      }
      for (;;)
      {
        if (SwipeBackLayout.b(SwipeBackLayout.this))
        {
          paramView = SwipeBackLayout.a(SwipeBackLayout.this);
          int n = this.hfF;
          int i1 = this.hfG;
          if (!paramView.WM)
          {
            paramView = new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
            AppMethodBeat.o(197850);
            throw paramView;
            i = 0;
            break;
            label259:
            if (i != 3) {
              continue;
            }
            AppMethodBeat.o(197850);
            return;
          }
          i = (int)paramView.mVelocityTracker.getXVelocity(paramView.mActivePointerId);
          int j = (int)paramView.mVelocityTracker.getYVelocity(paramView.mActivePointerId);
          int k = paramView.WL.getLeft();
          int m = paramView.WL.getTop();
          n -= k;
          i1 -= m;
          if ((n == 0) && (i1 == 0))
          {
            paramView.hgg.UD.abortAnimation();
            paramView.bf(0);
            SwipeBackLayout.this.invalidate();
            AppMethodBeat.o(197850);
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
            int i3 = f.i(i, (int)paramView.WH, (int)paramView.WG);
            i2 = f.i(j, (int)paramView.WH, (int)paramView.WG);
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
              i3 = paramView.h(n, i3, paramView.hgh.awM());
              i2 = paramView.h(i1, i2, 0);
              f = i3;
            }
          }
          for (long l = (int)(paramFloat2 * i2 + paramFloat1 * f);; l = 0L)
          {
            com.tencent.liteapp.b.b.d("WxViewDragHelper", "ashutest:: xvel %d, yvel %d, dx %d, dy %d duration %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(i1), Long.valueOf(l) });
            paramView.hgg.startScroll(k, m, n, i1, (int)l);
            paramView.bf(2);
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
      AppMethodBeat.o(197850);
    }
    
    public final int awM()
    {
      return 1;
    }
    
    public final void cL(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(197849);
      if (!SwipeBackLayout.b(SwipeBackLayout.this))
      {
        com.tencent.liteapp.b.b.w("MicroMsg.SwipeBackLayout", "[onViewPositionChanged] mHasTranslucent is false", new Object[0]);
        AppMethodBeat.o(197849);
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
            AppMethodBeat.i(197841);
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
            AppMethodBeat.o(197841);
          }
        });
      }
      for (;;)
      {
        if (SwipeBackLayout.a(SwipeBackLayout.this).Wx == 1) {
          d.aq(SwipeBackLayout.f(SwipeBackLayout.this));
        }
        AppMethodBeat.o(197849);
        return;
        if (Float.compare(SwipeBackLayout.f(SwipeBackLayout.this), 0.01F) <= 0)
        {
          SwipeBackLayout.b(SwipeBackLayout.this, false);
          com.tencent.liteapp.b.b.w("MicroMsg.SwipeBackLayout", "[onViewPositionChanged] mScrollPercent:%s mHasCallPopOut:%s", new Object[] { Float.valueOf(SwipeBackLayout.f(SwipeBackLayout.this)), Boolean.valueOf(SwipeBackLayout.g(SwipeBackLayout.this)) });
        }
      }
    }
    
    public final int e(View paramView, int paramInt)
    {
      AppMethodBeat.i(197851);
      if (SwipeBackLayout.b(SwipeBackLayout.this))
      {
        paramInt = Math.max(this.hfE, paramInt);
        this.hfE = 0;
        paramInt = Math.min(paramView.getWidth(), Math.max(paramInt, 0));
        AppMethodBeat.o(197851);
        return paramInt;
      }
      this.hfE = Math.max(this.hfE, paramInt);
      AppMethodBeat.o(197851);
      return 0;
    }
    
    public final void ei(final boolean paramBoolean)
    {
      AppMethodBeat.i(197853);
      SwipeBackLayout.k(SwipeBackLayout.this).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(197847);
          com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "on Complete, result %B, releaseLeft %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(SwipeBackLayout.c.this.hfF) });
          SwipeBackLayout.d(SwipeBackLayout.this, paramBoolean);
          if (paramBoolean) {
            if (SwipeBackLayout.c.this.hfF > 0)
            {
              d.aq(0.0F);
              SwipeBackLayout localSwipeBackLayout = SwipeBackLayout.this;
              boolean bool = paramBoolean;
              com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "ashutest::markTranslucent %B", new Object[] { Boolean.valueOf(bool) });
              localSwipeBackLayout.hfv = bool;
              if ((paramBoolean) && (SwipeBackLayout.n(SwipeBackLayout.this)))
              {
                if (SwipeBackLayout.c.this.hfF != 0) {
                  break label206;
                }
                b.a(SwipeBackLayout.c(SwipeBackLayout.this), 200L, 0.0F, new b.a()
                {
                  public final void awJ()
                  {
                    AppMethodBeat.i(197843);
                    onAnimationEnd();
                    AppMethodBeat.o(197843);
                  }
                  
                  public final void onAnimationEnd()
                  {
                    AppMethodBeat.i(197842);
                    SwipeBackLayout.b(SwipeBackLayout.this, false);
                    AppMethodBeat.o(197842);
                  }
                });
              }
            }
          }
          for (;;)
          {
            SwipeBackLayout.c(SwipeBackLayout.this, false);
            AppMethodBeat.o(197847);
            return;
            d.aq(1.0F);
            break;
            SwipeBackLayout.b(SwipeBackLayout.this, false);
            break;
            label206:
            b.a(SwipeBackLayout.c(SwipeBackLayout.this), 200L, SwipeBackLayout.c.this.hfF, new b.a()
            {
              public final void awJ()
              {
                AppMethodBeat.i(197846);
                onAnimationEnd();
                AppMethodBeat.o(197846);
              }
              
              public final void onAnimationEnd()
              {
                AppMethodBeat.i(197845);
                SwipeBackLayout.a(SwipeBackLayout.this, true);
                new Handler().post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(197844);
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
                    d.aq(1.0F);
                    SwipeBackLayout.b(SwipeBackLayout.this, false);
                    AppMethodBeat.o(197844);
                  }
                });
                AppMethodBeat.o(197845);
              }
            });
            d.h(true, SwipeBackLayout.c.this.hfF);
          }
        }
      });
      AppMethodBeat.o(197853);
    }
    
    public final boolean pv(int paramInt)
    {
      AppMethodBeat.i(197848);
      f localf = SwipeBackLayout.a(SwipeBackLayout.this);
      if ((localf.WF & 1 << paramInt) != 0) {}
      for (int i = 1; (i != 0) && ((localf.WC[paramInt] & 0x1) != 0); i = 0)
      {
        AppMethodBeat.o(197848);
        return true;
      }
      AppMethodBeat.o(197848);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ext.ui.SwipeBackLayout
 * JD-Core Version:    0.7.0.1
 */