package android.support.v4.widget;

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
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.a;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SlidingPaneLayout
  extends ViewGroup
{
  int Lf = -858993460;
  private int Lg;
  private Drawable Lh;
  private Drawable Li;
  private final int Lj;
  View Lk;
  float Ll;
  private float Lm;
  int Ln;
  int Lo;
  private d Lp;
  final t Lq;
  boolean Lr;
  final ArrayList<b> Ls = new ArrayList();
  private Method Lt;
  private Field Lu;
  private boolean Lv;
  private final Rect hV = new Rect();
  private boolean mCanSlide;
  private boolean mFirstLayout = true;
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
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.Lj = ((int)(32.0F * f + 0.5F));
    setWillNotDraw(false);
    android.support.v4.view.t.a(this, new a());
    android.support.v4.view.t.o(this, 1);
    this.Lq = t.a(this, 0.5F, new c());
    this.Lq.MI = (f * 400.0F);
  }
  
  private boolean F(float paramFloat)
  {
    if (!this.mCanSlide) {
      return false;
    }
    boolean bool = ei();
    LayoutParams localLayoutParams = (LayoutParams)this.Lk.getLayoutParams();
    int j;
    int k;
    if (bool)
    {
      i = getPaddingRight();
      j = localLayoutParams.rightMargin;
      k = this.Lk.getWidth();
    }
    for (int i = (int)(getWidth() - (j + i + this.Ln * paramFloat + k)); this.Lq.i(this.Lk, i, this.Lk.getTop()); i = (int)(localLayoutParams.leftMargin + i + this.Ln * paramFloat))
    {
      eg();
      android.support.v4.view.t.R(this);
      return true;
      i = getPaddingLeft();
    }
    return false;
  }
  
  private boolean eh()
  {
    boolean bool = false;
    if ((this.mFirstLayout) || (F(0.0F)))
    {
      this.Lr = false;
      bool = true;
    }
    return bool;
  }
  
  final void G(float paramFloat)
  {
    boolean bool = ei();
    Object localObject = (LayoutParams)this.Lk.getLayoutParams();
    int i;
    label43:
    int j;
    if (((LayoutParams)localObject).Lz) {
      if (bool)
      {
        i = ((LayoutParams)localObject).rightMargin;
        if (i > 0) {
          break label177;
        }
        i = 1;
        int n = getChildCount();
        j = 0;
        label52:
        if (j >= n) {
          return;
        }
        localObject = getChildAt(j);
        if (localObject != this.Lk)
        {
          int k = (int)((1.0F - this.Lm) * this.Lo);
          this.Lm = paramFloat;
          int m = k - (int)((1.0F - paramFloat) * this.Lo);
          k = m;
          if (bool) {
            k = -m;
          }
          ((View)localObject).offsetLeftAndRight(k);
          if (i != 0) {
            if (!bool) {
              break label182;
            }
          }
        }
      }
    }
    label177:
    label182:
    for (float f = this.Lm - 1.0F;; f = 1.0F - this.Lm)
    {
      a((View)localObject, f, this.Lg);
      j += 1;
      break label52;
      i = ((LayoutParams)localObject).leftMargin;
      break;
      i = 0;
      break label43;
    }
  }
  
  final void a(View paramView, float paramFloat, int paramInt)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if ((paramFloat > 0.0F) && (paramInt != 0))
    {
      i = (int)(((0xFF000000 & paramInt) >>> 24) * paramFloat);
      if (localLayoutParams.LA == null) {
        localLayoutParams.LA = new Paint();
      }
      localLayoutParams.LA.setColorFilter(new PorterDuffColorFilter(i << 24 | 0xFFFFFF & paramInt, PorterDuff.Mode.SRC_OVER));
      if (paramView.getLayerType() != 2) {
        paramView.setLayerType(2, localLayoutParams.LA);
      }
      aP(paramView);
    }
    while (paramView.getLayerType() == 0)
    {
      int i;
      return;
    }
    if (localLayoutParams.LA != null) {
      localLayoutParams.LA.setColorFilter(null);
    }
    paramView = new b(paramView);
    this.Ls.add(paramView);
    android.support.v4.view.t.b(this, paramView);
  }
  
  final void aO(View paramView)
  {
    boolean bool = ei();
    int i;
    int j;
    label31:
    int k;
    label63:
    int i1;
    int n;
    int m;
    label92:
    int i2;
    label101:
    Object localObject;
    if (bool)
    {
      i = getWidth() - getPaddingRight();
      if (!bool) {
        break label254;
      }
      j = getPaddingLeft();
      int i4 = getPaddingTop();
      int i5 = getHeight();
      int i6 = getPaddingBottom();
      if (paramView == null) {
        break label313;
      }
      if (!paramView.isOpaque()) {
        break label267;
      }
      k = 1;
      if (k == 0) {
        break label313;
      }
      i1 = paramView.getLeft();
      n = paramView.getRight();
      m = paramView.getTop();
      k = paramView.getBottom();
      int i7 = getChildCount();
      i2 = 0;
      if (i2 >= i7) {
        return;
      }
      localObject = getChildAt(i2);
      if (localObject == paramView) {
        return;
      }
      if (((View)localObject).getVisibility() != 8)
      {
        if (!bool) {
          break label328;
        }
        i3 = j;
        label140:
        int i8 = Math.max(i3, ((View)localObject).getLeft());
        int i9 = Math.max(i4, ((View)localObject).getTop());
        if (!bool) {
          break label334;
        }
        i3 = i;
        label172:
        i3 = Math.min(i3, ((View)localObject).getRight());
        int i10 = Math.min(i5 - i6, ((View)localObject).getBottom());
        if ((i8 < i1) || (i9 < m) || (i3 > n) || (i10 > k)) {
          break label340;
        }
      }
    }
    label267:
    label313:
    label328:
    label334:
    label340:
    for (int i3 = 4;; i3 = 0)
    {
      ((View)localObject).setVisibility(i3);
      i2 += 1;
      break label101;
      i = getPaddingLeft();
      break;
      label254:
      j = getWidth() - getPaddingRight();
      break label31;
      if (Build.VERSION.SDK_INT < 18)
      {
        localObject = paramView.getBackground();
        if (localObject != null)
        {
          if (((Drawable)localObject).getOpacity() == -1)
          {
            k = 1;
            break label63;
          }
          k = 0;
          break label63;
        }
      }
      k = 0;
      break label63;
      k = 0;
      m = 0;
      n = 0;
      i1 = 0;
      break label92;
      i3 = i;
      break label140;
      i3 = j;
      break label172;
    }
  }
  
  final void aP(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      android.support.v4.view.t.a(paramView, ((LayoutParams)paramView.getLayoutParams()).LA);
      return;
    }
    if ((Build.VERSION.SDK_INT < 16) || (!this.Lv)) {}
    try
    {
      this.Lt = View.class.getDeclaredMethod("getDisplayList", null);
      try
      {
        label51:
        this.Lu = View.class.getDeclaredField("mRecreateDisplayList");
        this.Lu.setAccessible(true);
        label71:
        this.Lv = true;
        if ((this.Lt == null) || (this.Lu == null))
        {
          paramView.invalidate();
          return;
        }
        try
        {
          this.Lu.setBoolean(paramView, true);
          this.Lt.invoke(paramView, null);
          label114:
          android.support.v4.view.t.c(this, paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
          return;
        }
        catch (Exception localException)
        {
          break label114;
        }
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        break label71;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label51;
    }
  }
  
  final boolean aQ(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    paramView = (LayoutParams)paramView.getLayoutParams();
    return (this.mCanSlide) && (paramView.Lz) && (this.Ll > 0.0F);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    if (this.Lq.ep())
    {
      if (!this.mCanSlide) {
        this.Lq.abort();
      }
    }
    else {
      return;
    }
    android.support.v4.view.t.R(this);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Drawable localDrawable;
    if (ei())
    {
      localDrawable = this.Li;
      if (getChildCount() <= 1) {
        break label53;
      }
    }
    label53:
    for (View localView = getChildAt(1);; localView = null)
    {
      if ((localView != null) && (localDrawable != null)) {
        break label59;
      }
      return;
      localDrawable = this.Lh;
      break;
    }
    label59:
    int k = localView.getTop();
    int m = localView.getBottom();
    int n = localDrawable.getIntrinsicWidth();
    int j;
    int i;
    if (ei())
    {
      j = localView.getRight();
      i = j + n;
    }
    for (;;)
    {
      localDrawable.setBounds(j, k, i, m);
      localDrawable.draw(paramCanvas);
      return;
      i = localView.getLeft();
      j = i - n;
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = paramCanvas.save();
    if ((this.mCanSlide) && (!localLayoutParams.Ly) && (this.Lk != null))
    {
      paramCanvas.getClipBounds(this.hV);
      if (!ei()) {
        break label104;
      }
      this.hV.left = Math.max(this.hV.left, this.Lk.getRight());
    }
    for (;;)
    {
      paramCanvas.clipRect(this.hV);
      boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
      paramCanvas.restoreToCount(i);
      return bool;
      label104:
      this.hV.right = Math.min(this.hV.right, this.Lk.getLeft());
    }
  }
  
  final void eg()
  {
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
  }
  
  final boolean ei()
  {
    return android.support.v4.view.t.T(this) == 1;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getCoveredFadeColor()
  {
    return this.Lg;
  }
  
  public int getParallaxDistance()
  {
    return this.Lo;
  }
  
  public int getSliderFadeColor()
  {
    return this.Lf;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mFirstLayout = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mFirstLayout = true;
    int j = this.Ls.size();
    int i = 0;
    while (i < j)
    {
      ((b)this.Ls.get(i)).run();
      i += 1;
    }
    this.Ls.clear();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    int i = paramMotionEvent.getActionMasked();
    if ((!this.mCanSlide) && (i == 0) && (getChildCount() > 1))
    {
      View localView = getChildAt(1);
      if (localView != null) {
        if (t.j(localView, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
          break label104;
        }
      }
    }
    label104:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.Lr = bool1;
      if ((this.mCanSlide) && ((!this.mIsUnableToDrag) || (i == 0))) {
        break;
      }
      this.Lq.cancel();
      bool1 = super.onInterceptTouchEvent(paramMotionEvent);
      return bool1;
    }
    if ((i == 3) || (i == 1))
    {
      this.Lq.cancel();
      return false;
    }
    switch (i)
    {
    }
    label160:
    float f1;
    float f2;
    do
    {
      for (i = 0;; i = 1)
      {
        if (!this.Lq.f(paramMotionEvent))
        {
          bool1 = bool2;
          if (i == 0) {
            break;
          }
        }
        return true;
        this.mIsUnableToDrag = false;
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        this.mInitialMotionX = f1;
        this.mInitialMotionY = f2;
        if ((!t.j(this.Lk, (int)f1, (int)f2)) || (!aQ(this.Lk))) {
          break label160;
        }
      }
      f2 = paramMotionEvent.getX();
      f1 = paramMotionEvent.getY();
      f2 = Math.abs(f2 - this.mInitialMotionX);
      f1 = Math.abs(f1 - this.mInitialMotionY);
    } while ((f2 <= this.Lq.mTouchSlop) || (f1 <= f2));
    this.Lq.cancel();
    this.mIsUnableToDrag = true;
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = ei();
    label35:
    label46:
    int m;
    float f;
    label82:
    int i;
    label99:
    LayoutParams localLayoutParams;
    int i1;
    int j;
    if (bool)
    {
      this.Lq.MK = 2;
      int k = paramInt3 - paramInt1;
      if (!bool) {
        break label358;
      }
      paramInt1 = getPaddingRight();
      if (!bool) {
        break label366;
      }
      paramInt3 = getPaddingLeft();
      int n = getPaddingTop();
      m = getChildCount();
      if (this.mFirstLayout)
      {
        if ((!this.mCanSlide) || (!this.Lr)) {
          break label375;
        }
        f = 1.0F;
        this.Ll = f;
      }
      paramInt4 = 0;
      i = paramInt1;
      paramInt2 = paramInt1;
      paramInt1 = i;
      if (paramInt4 >= m) {
        break label448;
      }
      View localView = getChildAt(paramInt4);
      if (localView.getVisibility() == 8) {
        break label557;
      }
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      i1 = localView.getMeasuredWidth();
      j = 0;
      if (!localLayoutParams.Ly) {
        break label396;
      }
      i = localLayoutParams.leftMargin;
      int i2 = localLayoutParams.rightMargin;
      i2 = Math.min(paramInt1, k - paramInt3 - this.Lj) - paramInt2 - (i + i2);
      this.Ln = i2;
      if (!bool) {
        break label381;
      }
      i = localLayoutParams.rightMargin;
      label208:
      if (paramInt2 + i + i2 + i1 / 2 <= k - paramInt3) {
        break label391;
      }
      paramBoolean = true;
      label230:
      localLayoutParams.Lz = paramBoolean;
      i2 = (int)(i2 * this.Ll);
      paramInt2 += i + i2;
      this.Ll = (i2 / this.Ln);
      i = j;
      if (!bool) {
        break label432;
      }
      j = k - paramInt2 + i;
      i = j - i1;
      label293:
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
      break label99;
      this.Lq.MK = 1;
      break;
      label358:
      paramInt1 = getPaddingLeft();
      break label35;
      label366:
      paramInt3 = getPaddingRight();
      break label46;
      label375:
      f = 0.0F;
      break label82;
      label381:
      i = localLayoutParams.leftMargin;
      break label208;
      label391:
      paramBoolean = false;
      break label230;
      label396:
      if ((this.mCanSlide) && (this.Lo != 0)) {}
      for (paramInt2 = (int)((1.0F - this.Ll) * this.Lo);; paramInt2 = 0)
      {
        i = paramInt2;
        paramInt2 = paramInt1;
        break;
        label432:
        i = paramInt2 - i;
        j = i + i1;
        break label293;
        label448:
        if (this.mFirstLayout)
        {
          if (!this.mCanSlide) {
            break label523;
          }
          if (this.Lo != 0) {
            G(this.Ll);
          }
          if (((LayoutParams)this.Lk.getLayoutParams()).Lz) {
            a(this.Lk, this.Ll, this.Lf);
          }
        }
        for (;;)
        {
          aO(this.Lk);
          this.mFirstLayout = false;
          return;
          label523:
          paramInt1 = 0;
          while (paramInt1 < m)
          {
            a(getChildAt(paramInt1), 0.0F, this.Lf);
            paramInt1 += 1;
          }
        }
      }
      label557:
      i = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = i;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int i = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt2);
    if (k != 1073741824) {
      if (isInEditMode())
      {
        if ((k == -2147483648) || (k != 0)) {
          break label1030;
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
      View localView;
      LayoutParams localLayoutParams;
      for (;;)
      {
        f = 0.0F;
        bool1 = false;
        i2 = i - getPaddingLeft() - getPaddingRight();
        i3 = getChildCount();
        this.Lk = null;
        i1 = 0;
        m = i2;
        k = paramInt1;
        paramInt1 = m;
        for (;;)
        {
          if (i1 >= i3) {
            break label553;
          }
          localView = getChildAt(i1);
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (localView.getVisibility() != 8) {
            break;
          }
          localLayoutParams.Lz = false;
          i1 += 1;
        }
        throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        if (i != 0) {
          break label1030;
        }
        if (isInEditMode())
        {
          if (i != 0) {
            break label1030;
          }
          j = 300;
          paramInt2 = -2147483648;
          i = paramInt1;
          paramInt1 = j;
          break;
        }
        throw new IllegalStateException("Height must not be UNSPECIFIED");
        paramInt1 = paramInt1 - getPaddingTop() - getPaddingBottom();
        j = paramInt1;
        continue;
        j = paramInt1 - getPaddingTop() - getPaddingBottom();
        paramInt1 = k;
      }
      if (localLayoutParams.weight > 0.0F)
      {
        f = localLayoutParams.weight + f;
        if (localLayoutParams.width == 0) {}
      }
      for (;;)
      {
        m = localLayoutParams.leftMargin + localLayoutParams.rightMargin;
        label347:
        int n;
        label367:
        int i4;
        if (localLayoutParams.width == -2)
        {
          m = View.MeasureSpec.makeMeasureSpec(i2 - m, -2147483648);
          if (localLayoutParams.height != -2) {
            break label509;
          }
          n = View.MeasureSpec.makeMeasureSpec(j, -2147483648);
          localView.measure(m, n);
          n = localView.getMeasuredWidth();
          i4 = localView.getMeasuredHeight();
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
            break label547;
          }
        }
        label547:
        for (boolean bool2 = true;; bool2 = false)
        {
          localLayoutParams.Ly = bool2;
          if (localLayoutParams.Ly) {
            this.Lk = localView;
          }
          bool1 = bool2 | bool1;
          k = m;
          break;
          if (localLayoutParams.width == -1)
          {
            m = View.MeasureSpec.makeMeasureSpec(i2 - m, 1073741824);
            break label347;
          }
          m = View.MeasureSpec.makeMeasureSpec(localLayoutParams.width, 1073741824);
          break label347;
          label509:
          if (localLayoutParams.height == -1)
          {
            n = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
            break label367;
          }
          n = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);
          break label367;
        }
        label553:
        if ((bool1) || (f > 0.0F))
        {
          i1 = i2 - this.Lj;
          m = 0;
          if (m < i3)
          {
            localView = getChildAt(m);
            if (localView.getVisibility() != 8)
            {
              localLayoutParams = (LayoutParams)localView.getLayoutParams();
              if (localView.getVisibility() != 8)
              {
                if ((localLayoutParams.width != 0) || (localLayoutParams.weight <= 0.0F)) {
                  break label733;
                }
                paramInt2 = 1;
                if (paramInt2 == 0) {
                  break label738;
                }
                n = 0;
                if ((!bool1) || (localView == this.Lk)) {
                  break label799;
                }
                if ((localLayoutParams.width < 0) && ((n > i1) || (localLayoutParams.weight > 0.0F)))
                {
                  if (paramInt2 == 0) {
                    break label784;
                  }
                  if (localLayoutParams.height != -2) {
                    break label748;
                  }
                  paramInt2 = View.MeasureSpec.makeMeasureSpec(j, -2147483648);
                  label710:
                  localView.measure(View.MeasureSpec.makeMeasureSpec(i1, 1073741824), paramInt2);
                }
              }
            }
            for (;;)
            {
              m += 1;
              break;
              label733:
              paramInt2 = 0;
              break label641;
              label738:
              n = localView.getMeasuredWidth();
              break label648;
              label748:
              if (localLayoutParams.height == -1)
              {
                paramInt2 = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
                break label710;
              }
              paramInt2 = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);
              break label710;
              paramInt2 = View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), 1073741824);
              break label710;
              if (localLayoutParams.weight > 0.0F)
              {
                if (localLayoutParams.width == 0) {
                  if (localLayoutParams.height == -2) {
                    paramInt2 = View.MeasureSpec.makeMeasureSpec(j, -2147483648);
                  }
                }
                for (;;)
                {
                  if (!bool1) {
                    break label940;
                  }
                  i4 = localLayoutParams.leftMargin;
                  i4 = i2 - (localLayoutParams.rightMargin + i4);
                  int i5 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                  if (n == i4) {
                    break;
                  }
                  localView.measure(i5, paramInt2);
                  break;
                  if (localLayoutParams.height == -1)
                  {
                    paramInt2 = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
                  }
                  else
                  {
                    paramInt2 = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);
                    continue;
                    paramInt2 = View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), 1073741824);
                  }
                }
                label940:
                i4 = Math.max(0, paramInt1);
                localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.weight * i4 / f) + n, 1073741824), paramInt2);
              }
            }
          }
        }
        label641:
        label648:
        label784:
        label799:
        setMeasuredDimension(i, getPaddingTop() + k + getPaddingBottom());
        this.mCanSlide = bool1;
        if ((this.Lq.Mw != 0) && (!bool1)) {
          this.Lq.abort();
        }
        return;
        break;
      }
      label1030:
      paramInt2 = i;
      i = paramInt1;
      paramInt1 = j;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.Fo);
    if (paramParcelable.LB) {
      if ((this.mFirstLayout) || (F(1.0F))) {
        this.Lr = true;
      }
    }
    for (;;)
    {
      this.Lr = paramParcelable.LB;
      return;
      eh();
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    boolean bool;
    if (this.mCanSlide) {
      if ((!this.mCanSlide) || (this.Ll == 1.0F)) {
        bool = true;
      }
    }
    for (;;)
    {
      localSavedState.LB = bool;
      return localSavedState;
      bool = false;
      continue;
      bool = this.Lr;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      this.mFirstLayout = true;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mCanSlide) {
      return super.onTouchEvent(paramMotionEvent);
    }
    this.Lq.g(paramMotionEvent);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      return true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.mInitialMotionX = f1;
      this.mInitialMotionY = f2;
      continue;
      if (aQ(this.Lk))
      {
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        float f3 = f1 - this.mInitialMotionX;
        float f4 = f2 - this.mInitialMotionY;
        int i = this.Lq.mTouchSlop;
        if ((f3 * f3 + f4 * f4 < i * i) && (t.j(this.Lk, (int)f1, (int)f2))) {
          eh();
        }
      }
    }
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    super.requestChildFocus(paramView1, paramView2);
    if ((!isInTouchMode()) && (!this.mCanSlide)) {
      if (paramView1 != this.Lk) {
        break label36;
      }
    }
    label36:
    for (boolean bool = true;; bool = false)
    {
      this.Lr = bool;
      return;
    }
  }
  
  public void setCoveredFadeColor(int paramInt)
  {
    this.Lg = paramInt;
  }
  
  public void setPanelSlideListener(d paramd)
  {
    this.Lp = paramd;
  }
  
  public void setParallaxDistance(int paramInt)
  {
    this.Lo = paramInt;
    requestLayout();
  }
  
  @Deprecated
  public void setShadowDrawable(Drawable paramDrawable)
  {
    setShadowDrawableLeft(paramDrawable);
  }
  
  public void setShadowDrawableLeft(Drawable paramDrawable)
  {
    this.Lh = paramDrawable;
  }
  
  public void setShadowDrawableRight(Drawable paramDrawable)
  {
    this.Li = paramDrawable;
  }
  
  @Deprecated
  public void setShadowResource(int paramInt)
  {
    setShadowDrawable(getResources().getDrawable(paramInt));
  }
  
  public void setShadowResourceLeft(int paramInt)
  {
    setShadowDrawableLeft(android.support.v4.content.b.k(getContext(), paramInt));
  }
  
  public void setShadowResourceRight(int paramInt)
  {
    setShadowDrawableRight(android.support.v4.content.b.k(getContext(), paramInt));
  }
  
  public void setSliderFadeColor(int paramInt)
  {
    this.Lf = paramInt;
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    private static final int[] GC = { 16843137 };
    Paint LA;
    boolean Ly;
    boolean Lz;
    public float weight = 0.0F;
    
    public LayoutParams()
    {
      super(-1);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, GC);
      this.weight = paramContext.getFloat(0, 0.0F);
      paramContext.recycle();
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
    boolean LB;
    
    SavedState(Parcel paramParcel)
    {
      super(null);
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.LB = bool;
        return;
      }
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      if (this.LB) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        return;
      }
    }
  }
  
  final class a
    extends a
  {
    private final Rect hV = new Rect();
    
    a() {}
    
    private boolean aR(View paramView)
    {
      return SlidingPaneLayout.this.aQ(paramView);
    }
    
    public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
    }
    
    public final void onInitializeAccessibilityNodeInfo(View paramView, android.support.v4.view.a.b paramb)
    {
      int j = 0;
      android.support.v4.view.a.b localb = android.support.v4.view.a.b.a(paramb);
      super.onInitializeAccessibilityNodeInfo(paramView, localb);
      Rect localRect = this.hV;
      localb.getBoundsInParent(localRect);
      paramb.setBoundsInParent(localRect);
      localb.getBoundsInScreen(localRect);
      paramb.setBoundsInScreen(localRect);
      paramb.setVisibleToUser(localb.isVisibleToUser());
      paramb.setPackageName(localb.Hq.getPackageName());
      paramb.setClassName(localb.Hq.getClassName());
      paramb.setContentDescription(localb.Hq.getContentDescription());
      paramb.setEnabled(localb.Hq.isEnabled());
      paramb.setClickable(localb.Hq.isClickable());
      paramb.setFocusable(localb.Hq.isFocusable());
      paramb.setFocused(localb.Hq.isFocused());
      paramb.setAccessibilityFocused(localb.isAccessibilityFocused());
      paramb.setSelected(localb.Hq.isSelected());
      paramb.setLongClickable(localb.Hq.isLongClickable());
      paramb.addAction(localb.Hq.getActions());
      if (Build.VERSION.SDK_INT >= 16) {}
      for (int i = localb.Hq.getMovementGranularities();; i = 0)
      {
        if (Build.VERSION.SDK_INT >= 16) {
          paramb.Hq.setMovementGranularities(i);
        }
        localb.Hq.recycle();
        paramb.setClassName(SlidingPaneLayout.class.getName());
        paramb.setSource(paramView);
        paramView = android.support.v4.view.t.U(paramView);
        if ((paramView instanceof View)) {
          paramb.setParent((View)paramView);
        }
        int k = SlidingPaneLayout.this.getChildCount();
        i = j;
        while (i < k)
        {
          paramView = SlidingPaneLayout.this.getChildAt(i);
          if ((!aR(paramView)) && (paramView.getVisibility() == 0))
          {
            android.support.v4.view.t.o(paramView, 1);
            paramb.addChild(paramView);
          }
          i += 1;
        }
      }
    }
    
    public final boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      if (!aR(paramView)) {
        return super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
      }
      return false;
    }
  }
  
  final class b
    implements Runnable
  {
    final View Lx;
    
    b(View paramView)
    {
      this.Lx = paramView;
    }
    
    public final void run()
    {
      if (this.Lx.getParent() == SlidingPaneLayout.this)
      {
        this.Lx.setLayerType(0, null);
        SlidingPaneLayout.this.aP(this.Lx);
      }
      SlidingPaneLayout.this.Ls.remove(this);
    }
  }
  
  final class c
    extends t.a
  {
    c() {}
    
    public final void a(View paramView, float paramFloat1, float paramFloat2)
    {
      SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)paramView.getLayoutParams();
      int i;
      int j;
      if (SlidingPaneLayout.this.ei())
      {
        i = SlidingPaneLayout.this.getPaddingRight();
        j = localLayoutParams.rightMargin + i;
        if (paramFloat1 >= 0.0F)
        {
          i = j;
          if (paramFloat1 == 0.0F)
          {
            i = j;
            if (SlidingPaneLayout.this.Ll <= 0.5F) {}
          }
        }
        else
        {
          i = j + SlidingPaneLayout.this.Ln;
        }
        j = SlidingPaneLayout.this.Lk.getWidth();
        i = SlidingPaneLayout.this.getWidth() - i - j;
      }
      for (;;)
      {
        SlidingPaneLayout.this.Lq.y(i, paramView.getTop());
        SlidingPaneLayout.this.invalidate();
        return;
        i = SlidingPaneLayout.this.getPaddingLeft();
        j = localLayoutParams.leftMargin + i;
        if (paramFloat1 <= 0.0F)
        {
          i = j;
          if (paramFloat1 == 0.0F)
          {
            i = j;
            if (SlidingPaneLayout.this.Ll <= 0.5F) {}
          }
        }
        else
        {
          i = j + SlidingPaneLayout.this.Ln;
        }
      }
    }
    
    public final void b(View paramView, int paramInt1, int paramInt2)
    {
      paramView = SlidingPaneLayout.this;
      if (paramView.Lk == null)
      {
        paramView.Ll = 0.0F;
        SlidingPaneLayout.this.invalidate();
        return;
      }
      boolean bool = paramView.ei();
      SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)paramView.Lk.getLayoutParams();
      int i = paramView.Lk.getWidth();
      paramInt2 = paramInt1;
      if (bool) {
        paramInt2 = paramView.getWidth() - paramInt1 - i;
      }
      if (bool)
      {
        paramInt1 = paramView.getPaddingRight();
        label79:
        if (!bool) {
          break label158;
        }
      }
      label158:
      for (i = localLayoutParams.rightMargin;; i = localLayoutParams.leftMargin)
      {
        paramView.Ll = ((paramInt2 - (i + paramInt1)) / paramView.Ln);
        if (paramView.Lo != 0) {
          paramView.G(paramView.Ll);
        }
        if (!localLayoutParams.Lz) {
          break;
        }
        paramView.a(paramView.Lk, paramView.Ll, paramView.Lf);
        break;
        paramInt1 = paramView.getPaddingLeft();
        break label79;
      }
    }
    
    public final boolean b(View paramView, int paramInt)
    {
      if (SlidingPaneLayout.this.mIsUnableToDrag) {
        return false;
      }
      return ((SlidingPaneLayout.LayoutParams)paramView.getLayoutParams()).Ly;
    }
    
    public final int c(View paramView, int paramInt)
    {
      return paramView.getTop();
    }
    
    public final int d(View paramView, int paramInt)
    {
      paramView = (SlidingPaneLayout.LayoutParams)SlidingPaneLayout.this.Lk.getLayoutParams();
      if (SlidingPaneLayout.this.ei())
      {
        i = SlidingPaneLayout.this.getWidth();
        j = SlidingPaneLayout.this.getPaddingRight();
        i -= paramView.rightMargin + j + SlidingPaneLayout.this.Lk.getWidth();
        j = SlidingPaneLayout.this.Ln;
        return Math.max(Math.min(paramInt, i), i - j);
      }
      int i = SlidingPaneLayout.this.getPaddingLeft();
      i = paramView.leftMargin + i;
      int j = SlidingPaneLayout.this.Ln;
      return Math.min(Math.max(paramInt, i), j + i);
    }
    
    public final void k(View paramView, int paramInt)
    {
      SlidingPaneLayout.this.eg();
    }
    
    public final int s(View paramView)
    {
      return SlidingPaneLayout.this.Ln;
    }
    
    public final void u(int paramInt1, int paramInt2)
    {
      SlidingPaneLayout.this.Lq.w(SlidingPaneLayout.this.Lk, paramInt2);
    }
    
    public final void w(int paramInt)
    {
      if (SlidingPaneLayout.this.Lq.Mw == 0)
      {
        if (SlidingPaneLayout.this.Ll == 0.0F)
        {
          SlidingPaneLayout.this.aO(SlidingPaneLayout.this.Lk);
          SlidingPaneLayout.this.sendAccessibilityEvent(32);
          SlidingPaneLayout.this.Lr = false;
        }
      }
      else {
        return;
      }
      SlidingPaneLayout.this.sendAccessibilityEvent(32);
      SlidingPaneLayout.this.Lr = true;
    }
  }
  
  public static abstract interface d {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.widget.SlidingPaneLayout
 * JD-Core Version:    0.7.0.1
 */