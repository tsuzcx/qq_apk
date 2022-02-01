package androidx.slidingpanelayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.g.a.d;
import androidx.core.g.z;
import androidx.customview.a.c;
import androidx.customview.a.c.a;
import androidx.customview.view.AbsSavedState;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SlidingPaneLayout
  extends ViewGroup
{
  private final Rect byy;
  private boolean ccA;
  int cck;
  private int ccl;
  private Drawable ccm;
  private Drawable ccn;
  private final int cco;
  View ccp;
  float ccq;
  private float ccr;
  int ccs;
  int cct;
  private d ccu;
  final c ccv;
  boolean ccw;
  final ArrayList<b> ccx;
  private Method ccy;
  private Field ccz;
  private boolean mCanSlide;
  private boolean mFirstLayout;
  private float mInitialMotionX;
  private float mInitialMotionY;
  boolean mIsUnableToDrag;
  
  public SlidingPaneLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SlidingPaneLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(192788);
    this.cck = -858993460;
    this.mFirstLayout = true;
    this.byy = new Rect();
    this.ccx = new ArrayList();
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.cco = ((int)(32.0F * f + 0.5F));
    setWillNotDraw(false);
    z.a(this, new a());
    z.p(this, 1);
    this.ccv = c.a(this, 0.5F, new c());
    this.ccv.bxI = (f * 400.0F);
    AppMethodBeat.o(192788);
  }
  
  private boolean Lv()
  {
    AppMethodBeat.i(192797);
    if ((this.mFirstLayout) || (aA(0.0F)))
    {
      this.ccw = false;
      AppMethodBeat.o(192797);
      return true;
    }
    AppMethodBeat.o(192797);
    return false;
  }
  
  private boolean aA(float paramFloat)
  {
    AppMethodBeat.i(192809);
    if (!this.mCanSlide)
    {
      AppMethodBeat.o(192809);
      return false;
    }
    boolean bool = Lw();
    LayoutParams localLayoutParams = (LayoutParams)this.ccp.getLayoutParams();
    int j;
    int k;
    if (bool)
    {
      i = getPaddingRight();
      j = localLayoutParams.rightMargin;
      k = this.ccp.getWidth();
    }
    for (int i = (int)(getWidth() - (j + i + this.ccs * paramFloat + k)); this.ccv.f(this.ccp, i, this.ccp.getTop()); i = (int)(localLayoutParams.leftMargin + i + this.ccs * paramFloat))
    {
      Lu();
      z.Q(this);
      AppMethodBeat.o(192809);
      return true;
      i = getPaddingLeft();
    }
    AppMethodBeat.o(192809);
    return false;
  }
  
  final void Lu()
  {
    AppMethodBeat.i(192875);
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 4) {
        localView.setVisibility(0);
      }
      i += 1;
    }
    AppMethodBeat.o(192875);
  }
  
  final boolean Lw()
  {
    AppMethodBeat.i(193132);
    if (z.U(this) == 1)
    {
      AppMethodBeat.o(193132);
      return true;
    }
    AppMethodBeat.o(193132);
    return false;
  }
  
  final void a(View paramView, float paramFloat, int paramInt)
  {
    AppMethodBeat.i(192950);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if ((paramFloat > 0.0F) && (paramInt != 0))
    {
      int i = (int)(((0xFF000000 & paramInt) >>> 24) * paramFloat);
      if (localLayoutParams.ccF == null) {
        localLayoutParams.ccF = new Paint();
      }
      localLayoutParams.ccF.setColorFilter(new PorterDuffColorFilter(i << 24 | 0xFFFFFF & paramInt, PorterDuff.Mode.SRC_OVER));
      if (paramView.getLayerType() != 2) {
        paramView.setLayerType(2, localLayoutParams.ccF);
      }
      bR(paramView);
      AppMethodBeat.o(192950);
      return;
    }
    if (paramView.getLayerType() != 0)
    {
      if (localLayoutParams.ccF != null) {
        localLayoutParams.ccF.setColorFilter(null);
      }
      paramView = new b(paramView);
      this.ccx.add(paramView);
      z.b(this, paramView);
    }
    AppMethodBeat.o(192950);
  }
  
  final void aB(float paramFloat)
  {
    AppMethodBeat.i(193076);
    boolean bool = Lw();
    Object localObject = (LayoutParams)this.ccp.getLayoutParams();
    int i;
    label49:
    int j;
    if (((LayoutParams)localObject).ccE) {
      if (bool)
      {
        i = ((LayoutParams)localObject).rightMargin;
        if (i > 0) {
          break label183;
        }
        i = 1;
        int n = getChildCount();
        j = 0;
        label58:
        if (j >= n) {
          break label198;
        }
        localObject = getChildAt(j);
        if (localObject != this.ccp)
        {
          int k = (int)((1.0F - this.ccr) * this.cct);
          this.ccr = paramFloat;
          int m = k - (int)((1.0F - paramFloat) * this.cct);
          k = m;
          if (bool) {
            k = -m;
          }
          ((View)localObject).offsetLeftAndRight(k);
          if (i != 0) {
            if (!bool) {
              break label188;
            }
          }
        }
      }
    }
    label183:
    label188:
    for (float f = this.ccr - 1.0F;; f = 1.0F - this.ccr)
    {
      a((View)localObject, f, this.ccl);
      j += 1;
      break label58;
      i = ((LayoutParams)localObject).leftMargin;
      break;
      i = 0;
      break label49;
    }
    label198:
    AppMethodBeat.o(193076);
  }
  
  final void bQ(View paramView)
  {
    AppMethodBeat.i(192868);
    boolean bool = Lw();
    int i;
    int j;
    label37:
    int k;
    label69:
    int i1;
    int n;
    int m;
    label98:
    int i2;
    label107:
    Object localObject;
    if (bool)
    {
      i = getWidth() - getPaddingRight();
      if (!bool) {
        break label260;
      }
      j = getPaddingLeft();
      int i4 = getPaddingTop();
      int i5 = getHeight();
      int i6 = getPaddingBottom();
      if (paramView == null) {
        break label319;
      }
      if (!paramView.isOpaque()) {
        break label273;
      }
      k = 1;
      if (k == 0) {
        break label319;
      }
      i1 = paramView.getLeft();
      n = paramView.getRight();
      m = paramView.getTop();
      k = paramView.getBottom();
      int i7 = getChildCount();
      i2 = 0;
      if (i2 >= i7) {
        break label352;
      }
      localObject = getChildAt(i2);
      if (localObject == paramView) {
        break label352;
      }
      if (((View)localObject).getVisibility() != 8)
      {
        if (!bool) {
          break label334;
        }
        i3 = j;
        label146:
        int i8 = Math.max(i3, ((View)localObject).getLeft());
        int i9 = Math.max(i4, ((View)localObject).getTop());
        if (!bool) {
          break label340;
        }
        i3 = i;
        label178:
        i3 = Math.min(i3, ((View)localObject).getRight());
        int i10 = Math.min(i5 - i6, ((View)localObject).getBottom());
        if ((i8 < i1) || (i9 < m) || (i3 > n) || (i10 > k)) {
          break label346;
        }
      }
    }
    label260:
    label273:
    label319:
    label334:
    label340:
    label346:
    for (int i3 = 4;; i3 = 0)
    {
      ((View)localObject).setVisibility(i3);
      i2 += 1;
      break label107;
      i = getPaddingLeft();
      break;
      j = getWidth() - getPaddingRight();
      break label37;
      if (Build.VERSION.SDK_INT < 18)
      {
        localObject = paramView.getBackground();
        if (localObject != null)
        {
          if (((Drawable)localObject).getOpacity() == -1)
          {
            k = 1;
            break label69;
          }
          k = 0;
          break label69;
        }
      }
      k = 0;
      break label69;
      k = 0;
      m = 0;
      n = 0;
      i1 = 0;
      break label98;
      i3 = i;
      break label146;
      i3 = j;
      break label178;
    }
    label352:
    AppMethodBeat.o(192868);
  }
  
  final void bR(View paramView)
  {
    AppMethodBeat.i(192968);
    if (Build.VERSION.SDK_INT >= 17)
    {
      z.a(paramView, ((LayoutParams)paramView.getLayoutParams()).ccF);
      AppMethodBeat.o(192968);
      return;
    }
    if ((Build.VERSION.SDK_INT < 16) || (!this.ccA)) {}
    try
    {
      this.ccy = View.class.getDeclaredMethod("getDisplayList", null);
      try
      {
        label63:
        this.ccz = View.class.getDeclaredField("mRecreateDisplayList");
        this.ccz.setAccessible(true);
        label83:
        this.ccA = true;
        if ((this.ccy == null) || (this.ccz == null))
        {
          paramView.invalidate();
          AppMethodBeat.o(192968);
          return;
        }
        try
        {
          this.ccz.setBoolean(paramView, true);
          this.ccy.invoke(paramView, null);
          label132:
          z.f(this, paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
          AppMethodBeat.o(192968);
          return;
        }
        catch (Exception localException)
        {
          break label132;
        }
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        break label83;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label63;
    }
  }
  
  final boolean bS(View paramView)
  {
    AppMethodBeat.i(193085);
    if (paramView == null)
    {
      AppMethodBeat.o(193085);
      return false;
    }
    paramView = (LayoutParams)paramView.getLayoutParams();
    if ((this.mCanSlide) && (paramView.ccE) && (this.ccq > 0.0F))
    {
      AppMethodBeat.o(193085);
      return true;
    }
    AppMethodBeat.o(193085);
    return false;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(193109);
    if (((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams)))
    {
      AppMethodBeat.o(193109);
      return true;
    }
    AppMethodBeat.o(193109);
    return false;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(192976);
    if (this.ccv.Fx())
    {
      if (!this.mCanSlide)
      {
        this.ccv.Fw();
        AppMethodBeat.o(192976);
        return;
      }
      z.Q(this);
    }
    AppMethodBeat.o(192976);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(193064);
    super.draw(paramCanvas);
    Drawable localDrawable;
    if (Lw())
    {
      localDrawable = this.ccn;
      if (getChildCount() <= 1) {
        break label65;
      }
    }
    label65:
    for (View localView = getChildAt(1);; localView = null)
    {
      if ((localView != null) && (localDrawable != null)) {
        break label71;
      }
      AppMethodBeat.o(193064);
      return;
      localDrawable = this.ccm;
      break;
    }
    label71:
    int k = localView.getTop();
    int m = localView.getBottom();
    int n = localDrawable.getIntrinsicWidth();
    int j;
    int i;
    if (Lw())
    {
      j = localView.getRight();
      i = j + n;
    }
    for (;;)
    {
      localDrawable.setBounds(j, k, i, m);
      localDrawable.draw(paramCanvas);
      AppMethodBeat.o(193064);
      return;
      i = localView.getLeft();
      j = i - n;
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    AppMethodBeat.i(192957);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = paramCanvas.save();
    if ((this.mCanSlide) && (!localLayoutParams.ccD) && (this.ccp != null))
    {
      paramCanvas.getClipBounds(this.byy);
      if (!Lw()) {
        break label116;
      }
      this.byy.left = Math.max(this.byy.left, this.ccp.getRight());
    }
    for (;;)
    {
      paramCanvas.clipRect(this.byy);
      boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
      paramCanvas.restoreToCount(i);
      AppMethodBeat.o(192957);
      return bool;
      label116:
      this.byy.right = Math.min(this.byy.right, this.ccp.getLeft());
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(193095);
    LayoutParams localLayoutParams = new LayoutParams();
    AppMethodBeat.o(193095);
    return localLayoutParams;
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(193113);
    paramAttributeSet = new LayoutParams(getContext(), paramAttributeSet);
    AppMethodBeat.o(193113);
    return paramAttributeSet;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(193104);
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      paramLayoutParams = new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
      AppMethodBeat.o(193104);
      return paramLayoutParams;
    }
    paramLayoutParams = new LayoutParams(paramLayoutParams);
    AppMethodBeat.o(193104);
    return paramLayoutParams;
  }
  
  public int getCoveredFadeColor()
  {
    return this.ccl;
  }
  
  public int getParallaxDistance()
  {
    return this.cct;
  }
  
  public int getSliderFadeColor()
  {
    return this.cck;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(192883);
    super.onAttachedToWindow();
    this.mFirstLayout = true;
    AppMethodBeat.o(192883);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(192892);
    super.onDetachedFromWindow();
    this.mFirstLayout = true;
    int j = this.ccx.size();
    int i = 0;
    while (i < j)
    {
      ((b)this.ccx.get(i)).run();
      i += 1;
    }
    this.ccx.clear();
    AppMethodBeat.o(192892);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(192934);
    int i = paramMotionEvent.getActionMasked();
    if ((!this.mCanSlide) && (i == 0) && (getChildCount() > 1))
    {
      View localView = getChildAt(1);
      if (localView != null) {
        if (c.g(localView, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
          break label113;
        }
      }
    }
    label113:
    for (boolean bool = true;; bool = false)
    {
      this.ccw = bool;
      if ((this.mCanSlide) && ((!this.mIsUnableToDrag) || (i == 0))) {
        break;
      }
      this.ccv.cancel();
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(192934);
      return bool;
    }
    if ((i == 3) || (i == 1))
    {
      this.ccv.cancel();
      AppMethodBeat.o(192934);
      return false;
    }
    switch (i)
    {
    }
    float f1;
    float f2;
    do
    {
      for (i = 0;; i = 1)
      {
        if ((!this.ccv.i(paramMotionEvent)) && (i == 0)) {
          break label328;
        }
        AppMethodBeat.o(192934);
        return true;
        this.mIsUnableToDrag = false;
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        this.mInitialMotionX = f1;
        this.mInitialMotionY = f2;
        if ((!c.g(this.ccp, (int)f1, (int)f2)) || (!bS(this.ccp))) {
          break;
        }
      }
      f2 = paramMotionEvent.getX();
      f1 = paramMotionEvent.getY();
      f2 = Math.abs(f2 - this.mInitialMotionX);
      f1 = Math.abs(f1 - this.mInitialMotionY);
    } while ((f2 <= this.ccv.mTouchSlop) || (f1 <= f2));
    this.ccv.cancel();
    this.mIsUnableToDrag = true;
    AppMethodBeat.o(192934);
    return false;
    label328:
    AppMethodBeat.o(192934);
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(192911);
    boolean bool = Lw();
    label41:
    label52:
    int m;
    float f;
    label88:
    int i;
    label105:
    LayoutParams localLayoutParams;
    int i1;
    int j;
    if (bool)
    {
      this.ccv.bxK = 2;
      int k = paramInt3 - paramInt1;
      if (!bool) {
        break label364;
      }
      paramInt1 = getPaddingRight();
      if (!bool) {
        break label372;
      }
      paramInt3 = getPaddingLeft();
      int n = getPaddingTop();
      m = getChildCount();
      if (this.mFirstLayout)
      {
        if ((!this.mCanSlide) || (!this.ccw)) {
          break label381;
        }
        f = 1.0F;
        this.ccq = f;
      }
      paramInt4 = 0;
      i = paramInt1;
      paramInt2 = paramInt1;
      paramInt1 = i;
      if (paramInt4 >= m) {
        break label454;
      }
      View localView = getChildAt(paramInt4);
      if (localView.getVisibility() == 8) {
        break label569;
      }
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      i1 = localView.getMeasuredWidth();
      j = 0;
      if (!localLayoutParams.ccD) {
        break label402;
      }
      i = localLayoutParams.leftMargin;
      int i2 = localLayoutParams.rightMargin;
      i2 = Math.min(paramInt1, k - paramInt3 - this.cco) - paramInt2 - (i + i2);
      this.ccs = i2;
      if (!bool) {
        break label387;
      }
      i = localLayoutParams.rightMargin;
      label214:
      if (paramInt2 + i + i2 + i1 / 2 <= k - paramInt3) {
        break label397;
      }
      paramBoolean = true;
      label236:
      localLayoutParams.ccE = paramBoolean;
      i2 = (int)(i2 * this.ccq);
      paramInt2 += i + i2;
      this.ccq = (i2 / this.ccs);
      i = j;
      if (!bool) {
        break label438;
      }
      j = k - paramInt2 + i;
      i = j - i1;
      label299:
      localView.layout(i, n, j, localView.getMeasuredHeight() + n);
      i = localView.getWidth() + paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = i;
    }
    for (;;)
    {
      i = paramInt4 + 1;
      paramInt4 = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = paramInt4;
      paramInt4 = i;
      break label105;
      this.ccv.bxK = 1;
      break;
      label364:
      paramInt1 = getPaddingLeft();
      break label41;
      label372:
      paramInt3 = getPaddingRight();
      break label52;
      label381:
      f = 0.0F;
      break label88;
      label387:
      i = localLayoutParams.leftMargin;
      break label214;
      label397:
      paramBoolean = false;
      break label236;
      label402:
      if ((this.mCanSlide) && (this.cct != 0)) {}
      for (paramInt2 = (int)((1.0F - this.ccq) * this.cct);; paramInt2 = 0)
      {
        i = paramInt2;
        paramInt2 = paramInt1;
        break;
        label438:
        i = paramInt2 - i;
        j = i + i1;
        break label299;
        label454:
        if (this.mFirstLayout)
        {
          if (!this.mCanSlide) {
            break label535;
          }
          if (this.cct != 0) {
            aB(this.ccq);
          }
          if (((LayoutParams)this.ccp.getLayoutParams()).ccE) {
            a(this.ccp, this.ccq, this.cck);
          }
        }
        for (;;)
        {
          bQ(this.ccp);
          this.mFirstLayout = false;
          AppMethodBeat.o(192911);
          return;
          label535:
          paramInt1 = 0;
          while (paramInt1 < m)
          {
            a(getChildAt(paramInt1), 0.0F, this.cck);
            paramInt1 += 1;
          }
        }
      }
      label569:
      i = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = i;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192903);
    int k = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int i = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt2);
    if (k != 1073741824) {
      if (isInEditMode())
      {
        if ((k == -2147483648) || (k != 0)) {
          break label1064;
        }
        paramInt2 = i;
        i = 300;
        paramInt1 = j;
      }
    }
    for (;;)
    {
      k = 0;
      switch (paramInt2)
      {
      default: 
        j = 0;
        paramInt1 = k;
      }
      float f;
      boolean bool1;
      int i2;
      int i3;
      int i1;
      int m;
      Object localObject;
      LayoutParams localLayoutParams;
      for (;;)
      {
        f = 0.0F;
        bool1 = false;
        i2 = i - getPaddingLeft() - getPaddingRight();
        i3 = getChildCount();
        this.ccp = null;
        i1 = 0;
        m = i2;
        k = paramInt1;
        paramInt1 = m;
        for (;;)
        {
          if (i1 >= i3) {
            break label581;
          }
          localObject = getChildAt(i1);
          localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
          if (((View)localObject).getVisibility() != 8) {
            break;
          }
          localLayoutParams.ccE = false;
          i1 += 1;
        }
        localObject = new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        AppMethodBeat.o(192903);
        throw ((Throwable)localObject);
        if (i != 0) {
          break label1064;
        }
        if (isInEditMode())
        {
          if (i != 0) {
            break label1064;
          }
          j = 300;
          paramInt2 = -2147483648;
          i = paramInt1;
          paramInt1 = j;
          break;
        }
        localObject = new IllegalStateException("Height must not be UNSPECIFIED");
        AppMethodBeat.o(192903);
        throw ((Throwable)localObject);
        paramInt1 = paramInt1 - getPaddingTop() - getPaddingBottom();
        j = paramInt1;
        continue;
        j = paramInt1 - getPaddingTop() - getPaddingBottom();
        paramInt1 = k;
      }
      if (localLayoutParams.qL > 0.0F)
      {
        f = localLayoutParams.qL + f;
        if (localLayoutParams.width == 0) {}
      }
      for (;;)
      {
        m = localLayoutParams.leftMargin + localLayoutParams.rightMargin;
        label375:
        int n;
        label395:
        int i4;
        if (localLayoutParams.width == -2)
        {
          m = View.MeasureSpec.makeMeasureSpec(i2 - m, -2147483648);
          if (localLayoutParams.height != -2) {
            break label537;
          }
          n = View.MeasureSpec.makeMeasureSpec(j, -2147483648);
          ((View)localObject).measure(m, n);
          n = ((View)localObject).getMeasuredWidth();
          i4 = ((View)localObject).getMeasuredHeight();
          m = k;
          if (paramInt2 == -2147483648)
          {
            m = k;
            if (i4 > k) {
              m = Math.min(i4, j);
            }
          }
          paramInt1 -= n;
          if (paramInt1 >= 0) {
            break label575;
          }
        }
        label537:
        label575:
        for (boolean bool2 = true;; bool2 = false)
        {
          localLayoutParams.ccD = bool2;
          if (localLayoutParams.ccD) {
            this.ccp = ((View)localObject);
          }
          bool1 = bool2 | bool1;
          k = m;
          break;
          if (localLayoutParams.width == -1)
          {
            m = View.MeasureSpec.makeMeasureSpec(i2 - m, 1073741824);
            break label375;
          }
          m = View.MeasureSpec.makeMeasureSpec(localLayoutParams.width, 1073741824);
          break label375;
          if (localLayoutParams.height == -1)
          {
            n = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
            break label395;
          }
          n = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);
          break label395;
        }
        label581:
        if ((bool1) || (f > 0.0F))
        {
          i1 = i2 - this.cco;
          m = 0;
          if (m < i3)
          {
            localObject = getChildAt(m);
            if (((View)localObject).getVisibility() != 8)
            {
              localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
              if (((View)localObject).getVisibility() != 8)
              {
                if ((localLayoutParams.width != 0) || (localLayoutParams.qL <= 0.0F)) {
                  break label761;
                }
                paramInt2 = 1;
                if (paramInt2 == 0) {
                  break label766;
                }
                n = 0;
                if ((!bool1) || (localObject == this.ccp)) {
                  break label827;
                }
                if ((localLayoutParams.width < 0) && ((n > i1) || (localLayoutParams.qL > 0.0F)))
                {
                  if (paramInt2 == 0) {
                    break label812;
                  }
                  if (localLayoutParams.height != -2) {
                    break label776;
                  }
                  paramInt2 = View.MeasureSpec.makeMeasureSpec(j, -2147483648);
                  label738:
                  ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(i1, 1073741824), paramInt2);
                }
              }
            }
            for (;;)
            {
              m += 1;
              break;
              label761:
              paramInt2 = 0;
              break label669;
              label766:
              n = ((View)localObject).getMeasuredWidth();
              break label676;
              if (localLayoutParams.height == -1)
              {
                paramInt2 = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
                break label738;
              }
              paramInt2 = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);
              break label738;
              paramInt2 = View.MeasureSpec.makeMeasureSpec(((View)localObject).getMeasuredHeight(), 1073741824);
              break label738;
              if (localLayoutParams.qL > 0.0F)
              {
                if (localLayoutParams.width == 0) {
                  if (localLayoutParams.height == -2) {
                    paramInt2 = View.MeasureSpec.makeMeasureSpec(j, -2147483648);
                  }
                }
                for (;;)
                {
                  if (!bool1) {
                    break label968;
                  }
                  i4 = localLayoutParams.leftMargin;
                  i4 = i2 - (localLayoutParams.rightMargin + i4);
                  int i5 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                  if (n == i4) {
                    break;
                  }
                  ((View)localObject).measure(i5, paramInt2);
                  break;
                  if (localLayoutParams.height == -1)
                  {
                    paramInt2 = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
                  }
                  else
                  {
                    paramInt2 = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);
                    continue;
                    paramInt2 = View.MeasureSpec.makeMeasureSpec(((View)localObject).getMeasuredHeight(), 1073741824);
                  }
                }
                label968:
                i4 = Math.max(0, paramInt1);
                ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.qL * i4 / f) + n, 1073741824), paramInt2);
              }
            }
          }
        }
        label669:
        label676:
        label812:
        label827:
        setMeasuredDimension(i, getPaddingTop() + k + getPaddingBottom());
        label776:
        this.mCanSlide = bool1;
        if ((this.ccv.bxy != 0) && (!bool1)) {
          this.ccv.Fw();
        }
        AppMethodBeat.o(192903);
        return;
        break;
      }
      label1064:
      paramInt2 = i;
      i = paramInt1;
      paramInt1 = j;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(193125);
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(193125);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.bxs);
    if (paramParcelable.hU) {
      if ((this.mFirstLayout) || (aA(1.0F))) {
        this.ccw = true;
      }
    }
    for (;;)
    {
      this.ccw = paramParcelable.hU;
      AppMethodBeat.o(193125);
      return;
      Lv();
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(193118);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    boolean bool;
    if (this.mCanSlide) {
      if ((!this.mCanSlide) || (this.ccq == 1.0F)) {
        bool = true;
      }
    }
    for (;;)
    {
      localSavedState.hU = bool;
      AppMethodBeat.o(193118);
      return localSavedState;
      bool = false;
      continue;
      bool = this.ccw;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(192915);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      this.mFirstLayout = true;
    }
    AppMethodBeat.o(192915);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(192944);
    if (!this.mCanSlide)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(192944);
      return bool;
    }
    this.ccv.j(paramMotionEvent);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(192944);
      return true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.mInitialMotionX = f1;
      this.mInitialMotionY = f2;
      continue;
      if (bS(this.ccp))
      {
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        float f3 = f1 - this.mInitialMotionX;
        float f4 = f2 - this.mInitialMotionY;
        int i = this.ccv.mTouchSlop;
        if ((f3 * f3 + f4 * f4 < i * i) && (c.g(this.ccp, (int)f1, (int)f2))) {
          Lv();
        }
      }
    }
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    AppMethodBeat.i(192923);
    super.requestChildFocus(paramView1, paramView2);
    if ((!isInTouchMode()) && (!this.mCanSlide)) {
      if (paramView1 != this.ccp) {
        break label48;
      }
    }
    label48:
    for (boolean bool = true;; bool = false)
    {
      this.ccw = bool;
      AppMethodBeat.o(192923);
      return;
    }
  }
  
  public void setCoveredFadeColor(int paramInt)
  {
    this.ccl = paramInt;
  }
  
  public void setPanelSlideListener(d paramd)
  {
    this.ccu = paramd;
  }
  
  public void setParallaxDistance(int paramInt)
  {
    AppMethodBeat.i(192816);
    this.cct = paramInt;
    requestLayout();
    AppMethodBeat.o(192816);
  }
  
  @Deprecated
  public void setShadowDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(192985);
    setShadowDrawableLeft(paramDrawable);
    AppMethodBeat.o(192985);
  }
  
  public void setShadowDrawableLeft(Drawable paramDrawable)
  {
    this.ccm = paramDrawable;
  }
  
  public void setShadowDrawableRight(Drawable paramDrawable)
  {
    this.ccn = paramDrawable;
  }
  
  @Deprecated
  public void setShadowResource(int paramInt)
  {
    AppMethodBeat.i(193040);
    setShadowDrawable(getResources().getDrawable(paramInt));
    AppMethodBeat.o(193040);
  }
  
  public void setShadowResourceLeft(int paramInt)
  {
    AppMethodBeat.i(193047);
    setShadowDrawableLeft(androidx.core.content.a.m(getContext(), paramInt));
    AppMethodBeat.o(193047);
  }
  
  public void setShadowResourceRight(int paramInt)
  {
    AppMethodBeat.i(193053);
    setShadowDrawableRight(androidx.core.content.a.m(getContext(), paramInt));
    AppMethodBeat.o(193053);
  }
  
  public void setSliderFadeColor(int paramInt)
  {
    this.cck = paramInt;
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    private static final int[] pD = { 16843137 };
    boolean ccD;
    boolean ccE;
    Paint ccF;
    public float qL;
    
    public LayoutParams()
    {
      super(-1);
      this.qL = 0.0F;
    }
    
    public LayoutParams(byte paramByte)
    {
      super(-1);
      this.qL = 0.0F;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(192820);
      this.qL = 0.0F;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, pD);
      this.qL = paramContext.getFloat(0, 0.0F);
      paramContext.recycle();
      AppMethodBeat.o(192820);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
      this.qL = 0.0F;
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
      this.qL = 0.0F;
    }
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    boolean hU;
    
    static
    {
      AppMethodBeat.i(192817);
      CREATOR = new Parcelable.ClassLoaderCreator() {};
      AppMethodBeat.o(192817);
    }
    
    SavedState(Parcel paramParcel)
    {
      super(null);
      AppMethodBeat.i(192807);
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.hU = bool;
        AppMethodBeat.o(192807);
        return;
      }
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(192829);
      super.writeToParcel(paramParcel, paramInt);
      if (this.hU) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(192829);
        return;
      }
    }
  }
  
  final class a
    extends androidx.core.g.a
  {
    private final Rect byy;
    
    a()
    {
      AppMethodBeat.i(192790);
      this.byy = new Rect();
      AppMethodBeat.o(192790);
    }
    
    private boolean bT(View paramView)
    {
      AppMethodBeat.i(192802);
      boolean bool = SlidingPaneLayout.this.bS(paramView);
      AppMethodBeat.o(192802);
      return bool;
    }
    
    public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(192827);
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
      AppMethodBeat.o(192827);
    }
    
    public final void onInitializeAccessibilityNodeInfo(View paramView, d paramd)
    {
      AppMethodBeat.i(192815);
      d locald = d.a(paramd);
      super.onInitializeAccessibilityNodeInfo(paramView, locald);
      Rect localRect = this.byy;
      locald.j(localRect);
      paramd.k(localRect);
      locald.l(localRect);
      paramd.m(localRect);
      paramd.aF(locald.EL());
      paramd.u(locald.EQ());
      paramd.v(locald.ER());
      paramd.setContentDescription(locald.getContentDescription());
      paramd.setEnabled(locald.isEnabled());
      paramd.setClickable(locald.isClickable());
      paramd.setFocusable(locald.isFocusable());
      paramd.aE(locald.isFocused());
      paramd.aG(locald.EM());
      paramd.setSelected(locald.isSelected());
      paramd.setLongClickable(locald.EN());
      paramd.eu(locald.EJ());
      paramd.ev(locald.EK());
      locald.recycle();
      paramd.v(SlidingPaneLayout.class.getName());
      paramd.aL(paramView);
      paramView = z.V(paramView);
      if ((paramView instanceof View)) {
        paramd.setParent((View)paramView);
      }
      int j = SlidingPaneLayout.this.getChildCount();
      int i = 0;
      while (i < j)
      {
        paramView = SlidingPaneLayout.this.getChildAt(i);
        if ((!bT(paramView)) && (paramView.getVisibility() == 0))
        {
          z.p(paramView, 1);
          paramd.aM(paramView);
        }
        i += 1;
      }
      AppMethodBeat.o(192815);
    }
    
    public final boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(192839);
      if (!bT(paramView))
      {
        boolean bool = super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
        AppMethodBeat.o(192839);
        return bool;
      }
      AppMethodBeat.o(192839);
      return false;
    }
  }
  
  final class b
    implements Runnable
  {
    final View ccC;
    
    b(View paramView)
    {
      this.ccC = paramView;
    }
    
    public final void run()
    {
      AppMethodBeat.i(192811);
      if (this.ccC.getParent() == SlidingPaneLayout.this)
      {
        this.ccC.setLayerType(0, null);
        SlidingPaneLayout.this.bR(this.ccC);
      }
      SlidingPaneLayout.this.ccx.remove(this);
      AppMethodBeat.o(192811);
    }
  }
  
  final class c
    extends c.a
  {
    c() {}
    
    public final void D(View paramView, int paramInt)
    {
      AppMethodBeat.i(192831);
      SlidingPaneLayout.this.Lu();
      AppMethodBeat.o(192831);
    }
    
    public final void F(int paramInt)
    {
      AppMethodBeat.i(192819);
      if (SlidingPaneLayout.this.ccv.bxy == 0)
      {
        if (SlidingPaneLayout.this.ccq == 0.0F)
        {
          SlidingPaneLayout.this.bQ(SlidingPaneLayout.this.ccp);
          SlidingPaneLayout.this.sendAccessibilityEvent(32);
          SlidingPaneLayout.this.ccw = false;
          AppMethodBeat.o(192819);
          return;
        }
        SlidingPaneLayout.this.sendAccessibilityEvent(32);
        SlidingPaneLayout.this.ccw = true;
      }
      AppMethodBeat.o(192819);
    }
    
    public final void a(View paramView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(192840);
      paramView = SlidingPaneLayout.this;
      if (paramView.ccp == null)
      {
        paramView.ccq = 0.0F;
        SlidingPaneLayout.this.invalidate();
        AppMethodBeat.o(192840);
        return;
      }
      boolean bool = paramView.Lw();
      SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)paramView.ccp.getLayoutParams();
      int i = paramView.ccp.getWidth();
      paramInt2 = paramInt1;
      if (bool) {
        paramInt2 = paramView.getWidth() - paramInt1 - i;
      }
      if (bool)
      {
        paramInt1 = paramView.getPaddingRight();
        label89:
        if (!bool) {
          break label168;
        }
      }
      label168:
      for (i = localLayoutParams.rightMargin;; i = localLayoutParams.leftMargin)
      {
        paramView.ccq = ((paramInt2 - (i + paramInt1)) / paramView.ccs);
        if (paramView.cct != 0) {
          paramView.aB(paramView.ccq);
        }
        if (!localLayoutParams.ccE) {
          break;
        }
        paramView.a(paramView.ccp, paramView.ccq, paramView.cck);
        break;
        paramInt1 = paramView.getPaddingLeft();
        break label89;
      }
    }
    
    public final void aG(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(192878);
      SlidingPaneLayout.this.ccv.B(SlidingPaneLayout.this.ccp, paramInt2);
      AppMethodBeat.o(192878);
    }
    
    public final int aQ(View paramView)
    {
      return SlidingPaneLayout.this.ccs;
    }
    
    public final void b(View paramView, float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(192848);
      SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)paramView.getLayoutParams();
      int i;
      int j;
      if (SlidingPaneLayout.this.Lw())
      {
        i = SlidingPaneLayout.this.getPaddingRight();
        j = localLayoutParams.rightMargin + i;
        if (paramFloat1 >= 0.0F)
        {
          i = j;
          if (paramFloat1 == 0.0F)
          {
            i = j;
            if (SlidingPaneLayout.this.ccq <= 0.5F) {}
          }
        }
        else
        {
          i = j + SlidingPaneLayout.this.ccs;
        }
        j = SlidingPaneLayout.this.ccp.getWidth();
        i = SlidingPaneLayout.this.getWidth() - i - j;
      }
      for (;;)
      {
        SlidingPaneLayout.this.ccv.aD(i, paramView.getTop());
        SlidingPaneLayout.this.invalidate();
        AppMethodBeat.o(192848);
        return;
        i = SlidingPaneLayout.this.getPaddingLeft();
        j = localLayoutParams.leftMargin + i;
        if (paramFloat1 <= 0.0F)
        {
          i = j;
          if (paramFloat1 == 0.0F)
          {
            i = j;
            if (SlidingPaneLayout.this.ccq <= 0.5F) {}
          }
        }
        else
        {
          i = j + SlidingPaneLayout.this.ccs;
        }
      }
    }
    
    public final boolean b(View paramView, int paramInt)
    {
      AppMethodBeat.i(192810);
      if (SlidingPaneLayout.this.mIsUnableToDrag)
      {
        AppMethodBeat.o(192810);
        return false;
      }
      boolean bool = ((SlidingPaneLayout.LayoutParams)paramView.getLayoutParams()).ccD;
      AppMethodBeat.o(192810);
      return bool;
    }
    
    public final int c(View paramView, int paramInt)
    {
      AppMethodBeat.i(192871);
      paramInt = paramView.getTop();
      AppMethodBeat.o(192871);
      return paramInt;
    }
    
    public final int d(View paramView, int paramInt)
    {
      AppMethodBeat.i(192862);
      paramView = (SlidingPaneLayout.LayoutParams)SlidingPaneLayout.this.ccp.getLayoutParams();
      int i;
      int j;
      if (SlidingPaneLayout.this.Lw())
      {
        i = SlidingPaneLayout.this.getWidth();
        j = SlidingPaneLayout.this.getPaddingRight();
        i -= paramView.rightMargin + j + SlidingPaneLayout.this.ccp.getWidth();
        j = SlidingPaneLayout.this.ccs;
      }
      for (paramInt = Math.max(Math.min(paramInt, i), i - j);; paramInt = Math.min(Math.max(paramInt, i), j + i))
      {
        AppMethodBeat.o(192862);
        return paramInt;
        i = SlidingPaneLayout.this.getPaddingLeft();
        i = paramView.leftMargin + i;
        j = SlidingPaneLayout.this.ccs;
      }
    }
  }
  
  public static abstract interface d {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.slidingpanelayout.widget.SlidingPaneLayout
 * JD-Core Version:    0.7.0.1
 */