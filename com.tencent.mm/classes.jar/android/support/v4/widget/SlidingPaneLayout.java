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
import android.support.v4.content.b;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.a;
import android.support.v4.view.a.c;
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
  private final Rect Rm = new Rect();
  int Si = -858993460;
  private int Sj;
  private Drawable Sk;
  private Drawable Sl;
  private final int Sm;
  View Sn;
  float So;
  private float Sp;
  int Sq;
  int Sr;
  private d Ss;
  final t St;
  boolean Su;
  final ArrayList<b> Sv = new ArrayList();
  private Method Sw;
  private Field Sx;
  private boolean Sy;
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
    this.Sm = ((int)(32.0F * f + 0.5F));
    setWillNotDraw(false);
    android.support.v4.view.t.a(this, new a());
    android.support.v4.view.t.p(this, 1);
    this.St = t.a(this, 0.5F, new c());
    this.St.TJ = (f * 400.0F);
  }
  
  private boolean F(float paramFloat)
  {
    if (!this.mCanSlide) {
      return false;
    }
    boolean bool = fA();
    LayoutParams localLayoutParams = (LayoutParams)this.Sn.getLayoutParams();
    int j;
    int k;
    if (bool)
    {
      i = getPaddingRight();
      j = localLayoutParams.rightMargin;
      k = this.Sn.getWidth();
    }
    for (int i = (int)(getWidth() - (j + i + this.Sq * paramFloat + k)); this.St.h(this.Sn, i, this.Sn.getTop()); i = (int)(localLayoutParams.leftMargin + i + this.Sq * paramFloat))
    {
      fy();
      android.support.v4.view.t.W(this);
      return true;
      i = getPaddingLeft();
    }
    return false;
  }
  
  private boolean fz()
  {
    boolean bool = false;
    if ((this.mFirstLayout) || (F(0.0F)))
    {
      this.Su = false;
      bool = true;
    }
    return bool;
  }
  
  final void G(float paramFloat)
  {
    boolean bool = fA();
    Object localObject = (LayoutParams)this.Sn.getLayoutParams();
    int i;
    label43:
    int j;
    if (((LayoutParams)localObject).SC) {
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
        if (localObject != this.Sn)
        {
          int k = (int)((1.0F - this.Sp) * this.Sr);
          this.Sp = paramFloat;
          int m = k - (int)((1.0F - paramFloat) * this.Sr);
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
    for (float f = this.Sp - 1.0F;; f = 1.0F - this.Sp)
    {
      a((View)localObject, f, this.Sj);
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
      if (localLayoutParams.SD == null) {
        localLayoutParams.SD = new Paint();
      }
      localLayoutParams.SD.setColorFilter(new PorterDuffColorFilter(i << 24 | 0xFFFFFF & paramInt, PorterDuff.Mode.SRC_OVER));
      if (paramView.getLayerType() != 2) {
        paramView.setLayerType(2, localLayoutParams.SD);
      }
      aV(paramView);
    }
    while (paramView.getLayerType() == 0)
    {
      int i;
      return;
    }
    if (localLayoutParams.SD != null) {
      localLayoutParams.SD.setColorFilter(null);
    }
    paramView = new b(paramView);
    this.Sv.add(paramView);
    android.support.v4.view.t.b(this, paramView);
  }
  
  final void aU(View paramView)
  {
    boolean bool = fA();
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
  
  final void aV(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      android.support.v4.view.t.a(paramView, ((LayoutParams)paramView.getLayoutParams()).SD);
      return;
    }
    if ((Build.VERSION.SDK_INT < 16) || (!this.Sy)) {}
    try
    {
      this.Sw = View.class.getDeclaredMethod("getDisplayList", null);
      try
      {
        label51:
        this.Sx = View.class.getDeclaredField("mRecreateDisplayList");
        this.Sx.setAccessible(true);
        label71:
        this.Sy = true;
        if ((this.Sw == null) || (this.Sx == null))
        {
          paramView.invalidate();
          return;
        }
        try
        {
          this.Sx.setBoolean(paramView, true);
          this.Sw.invoke(paramView, null);
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
  
  final boolean aW(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    paramView = (LayoutParams)paramView.getLayoutParams();
    return (this.mCanSlide) && (paramView.SC) && (this.So > 0.0F);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    if (this.St.fH())
    {
      if (!this.mCanSlide) {
        this.St.abort();
      }
    }
    else {
      return;
    }
    android.support.v4.view.t.W(this);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Drawable localDrawable;
    if (fA())
    {
      localDrawable = this.Sl;
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
      localDrawable = this.Sk;
      break;
    }
    label59:
    int k = localView.getTop();
    int m = localView.getBottom();
    int n = localDrawable.getIntrinsicWidth();
    int j;
    int i;
    if (fA())
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
    if ((this.mCanSlide) && (!localLayoutParams.SB) && (this.Sn != null))
    {
      paramCanvas.getClipBounds(this.Rm);
      if (!fA()) {
        break label104;
      }
      this.Rm.left = Math.max(this.Rm.left, this.Sn.getRight());
    }
    for (;;)
    {
      paramCanvas.clipRect(this.Rm);
      boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
      paramCanvas.restoreToCount(i);
      return bool;
      label104:
      this.Rm.right = Math.min(this.Rm.right, this.Sn.getLeft());
    }
  }
  
  final boolean fA()
  {
    return android.support.v4.view.t.Y(this) == 1;
  }
  
  final void fy()
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
    return this.Sj;
  }
  
  public int getParallaxDistance()
  {
    return this.Sr;
  }
  
  public int getSliderFadeColor()
  {
    return this.Si;
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
    int j = this.Sv.size();
    int i = 0;
    while (i < j)
    {
      ((b)this.Sv.get(i)).run();
      i += 1;
    }
    this.Sv.clear();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    int i = paramMotionEvent.getActionMasked();
    if ((!this.mCanSlide) && (i == 0) && (getChildCount() > 1))
    {
      View localView = getChildAt(1);
      if (localView != null) {
        if (t.i(localView, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
          break label104;
        }
      }
    }
    label104:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.Su = bool1;
      if ((this.mCanSlide) && ((!this.mIsUnableToDrag) || (i == 0))) {
        break;
      }
      this.St.cancel();
      bool1 = super.onInterceptTouchEvent(paramMotionEvent);
      return bool1;
    }
    if ((i == 3) || (i == 1))
    {
      this.St.cancel();
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
        if (!this.St.g(paramMotionEvent))
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
        if ((!t.i(this.Sn, (int)f1, (int)f2)) || (!aW(this.Sn))) {
          break label160;
        }
      }
      f2 = paramMotionEvent.getX();
      f1 = paramMotionEvent.getY();
      f2 = Math.abs(f2 - this.mInitialMotionX);
      f1 = Math.abs(f1 - this.mInitialMotionY);
    } while ((f2 <= this.St.mTouchSlop) || (f1 <= f2));
    this.St.cancel();
    this.mIsUnableToDrag = true;
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = fA();
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
      this.St.TL = 2;
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
        if ((!this.mCanSlide) || (!this.Su)) {
          break label375;
        }
        f = 1.0F;
        this.So = f;
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
      if (!localLayoutParams.SB) {
        break label396;
      }
      i = localLayoutParams.leftMargin;
      int i2 = localLayoutParams.rightMargin;
      i2 = Math.min(paramInt1, k - paramInt3 - this.Sm) - paramInt2 - (i + i2);
      this.Sq = i2;
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
      localLayoutParams.SC = paramBoolean;
      i2 = (int)(i2 * this.So);
      paramInt2 += i + i2;
      this.So = (i2 / this.Sq);
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
      this.St.TL = 1;
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
      if ((this.mCanSlide) && (this.Sr != 0)) {}
      for (paramInt2 = (int)((1.0F - this.So) * this.Sr);; paramInt2 = 0)
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
          if (this.Sr != 0) {
            G(this.So);
          }
          if (((LayoutParams)this.Sn.getLayoutParams()).SC) {
            a(this.Sn, this.So, this.Si);
          }
        }
        for (;;)
        {
          aU(this.Sn);
          this.mFirstLayout = false;
          return;
          label523:
          paramInt1 = 0;
          while (paramInt1 < m)
          {
            a(getChildAt(paramInt1), 0.0F, this.Si);
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
        this.Sn = null;
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
          localLayoutParams.SC = false;
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
          localLayoutParams.SB = bool2;
          if (localLayoutParams.SB) {
            this.Sn = localView;
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
          i1 = i2 - this.Sm;
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
                if ((!bool1) || (localView == this.Sn)) {
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
        if ((this.St.Tz != 0) && (!bool1)) {
          this.St.abort();
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
    super.onRestoreInstanceState(paramParcelable.Mm);
    if (paramParcelable.SE) {
      if ((this.mFirstLayout) || (F(1.0F))) {
        this.Su = true;
      }
    }
    for (;;)
    {
      this.Su = paramParcelable.SE;
      return;
      fz();
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    boolean bool;
    if (this.mCanSlide) {
      if ((!this.mCanSlide) || (this.So == 1.0F)) {
        bool = true;
      }
    }
    for (;;)
    {
      localSavedState.SE = bool;
      return localSavedState;
      bool = false;
      continue;
      bool = this.Su;
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
    this.St.h(paramMotionEvent);
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
      if (aW(this.Sn))
      {
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        float f3 = f1 - this.mInitialMotionX;
        float f4 = f2 - this.mInitialMotionY;
        int i = this.St.mTouchSlop;
        if ((f3 * f3 + f4 * f4 < i * i) && (t.i(this.Sn, (int)f1, (int)f2))) {
          fz();
        }
      }
    }
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    super.requestChildFocus(paramView1, paramView2);
    if ((!isInTouchMode()) && (!this.mCanSlide)) {
      if (paramView1 != this.Sn) {
        break label36;
      }
    }
    label36:
    for (boolean bool = true;; bool = false)
    {
      this.Su = bool;
      return;
    }
  }
  
  public void setCoveredFadeColor(int paramInt)
  {
    this.Sj = paramInt;
  }
  
  public void setPanelSlideListener(d paramd)
  {
    this.Ss = paramd;
  }
  
  public void setParallaxDistance(int paramInt)
  {
    this.Sr = paramInt;
    requestLayout();
  }
  
  @Deprecated
  public void setShadowDrawable(Drawable paramDrawable)
  {
    setShadowDrawableLeft(paramDrawable);
  }
  
  public void setShadowDrawableLeft(Drawable paramDrawable)
  {
    this.Sk = paramDrawable;
  }
  
  public void setShadowDrawableRight(Drawable paramDrawable)
  {
    this.Sl = paramDrawable;
  }
  
  @Deprecated
  public void setShadowResource(int paramInt)
  {
    setShadowDrawable(getResources().getDrawable(paramInt));
  }
  
  public void setShadowResourceLeft(int paramInt)
  {
    setShadowDrawableLeft(b.l(getContext(), paramInt));
  }
  
  public void setShadowResourceRight(int paramInt)
  {
    setShadowDrawableRight(b.l(getContext(), paramInt));
  }
  
  public void setSliderFadeColor(int paramInt)
  {
    this.Si = paramInt;
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    private static final int[] NC = { 16843137 };
    boolean SB;
    boolean SC;
    Paint SD;
    public float weight = 0.0F;
    
    public LayoutParams()
    {
      super(-1);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, NC);
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
    boolean SE;
    
    SavedState(Parcel paramParcel)
    {
      super(null);
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.SE = bool;
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
      if (this.SE) {}
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
    private final Rect Rm = new Rect();
    
    a() {}
    
    private boolean aX(View paramView)
    {
      return SlidingPaneLayout.this.aW(paramView);
    }
    
    public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
    }
    
    public final void onInitializeAccessibilityNodeInfo(View paramView, c paramc)
    {
      int j = 0;
      c localc = c.a(paramc);
      super.onInitializeAccessibilityNodeInfo(paramView, localc);
      Rect localRect = this.Rm;
      localc.getBoundsInParent(localRect);
      paramc.setBoundsInParent(localRect);
      localc.getBoundsInScreen(localRect);
      paramc.setBoundsInScreen(localRect);
      paramc.setVisibleToUser(localc.isVisibleToUser());
      paramc.setPackageName(localc.Op.getPackageName());
      paramc.setClassName(localc.Op.getClassName());
      paramc.setContentDescription(localc.Op.getContentDescription());
      paramc.setEnabled(localc.Op.isEnabled());
      paramc.setClickable(localc.Op.isClickable());
      paramc.setFocusable(localc.Op.isFocusable());
      paramc.setFocused(localc.Op.isFocused());
      paramc.setAccessibilityFocused(localc.isAccessibilityFocused());
      paramc.setSelected(localc.Op.isSelected());
      paramc.setLongClickable(localc.Op.isLongClickable());
      paramc.addAction(localc.Op.getActions());
      if (Build.VERSION.SDK_INT >= 16) {}
      for (int i = localc.Op.getMovementGranularities();; i = 0)
      {
        if (Build.VERSION.SDK_INT >= 16) {
          paramc.Op.setMovementGranularities(i);
        }
        localc.Op.recycle();
        paramc.setClassName(SlidingPaneLayout.class.getName());
        paramc.setSource(paramView);
        paramView = android.support.v4.view.t.Z(paramView);
        if ((paramView instanceof View)) {
          paramc.setParent((View)paramView);
        }
        int k = SlidingPaneLayout.this.getChildCount();
        i = j;
        while (i < k)
        {
          paramView = SlidingPaneLayout.this.getChildAt(i);
          if ((!aX(paramView)) && (paramView.getVisibility() == 0))
          {
            android.support.v4.view.t.p(paramView, 1);
            paramc.addChild(paramView);
          }
          i += 1;
        }
      }
    }
    
    public final boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      if (!aX(paramView)) {
        return super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
      }
      return false;
    }
  }
  
  final class b
    implements Runnable
  {
    final View SA;
    
    b(View paramView)
    {
      this.SA = paramView;
    }
    
    public final void run()
    {
      if (this.SA.getParent() == SlidingPaneLayout.this)
      {
        this.SA.setLayerType(0, null);
        SlidingPaneLayout.this.aV(this.SA);
      }
      SlidingPaneLayout.this.Sv.remove(this);
    }
  }
  
  final class c
    extends t.a
  {
    c() {}
    
    public final void M(int paramInt)
    {
      if (SlidingPaneLayout.this.St.Tz == 0)
      {
        if (SlidingPaneLayout.this.So == 0.0F)
        {
          SlidingPaneLayout.this.aU(SlidingPaneLayout.this.Sn);
          SlidingPaneLayout.this.sendAccessibilityEvent(32);
          SlidingPaneLayout.this.Su = false;
        }
      }
      else {
        return;
      }
      SlidingPaneLayout.this.sendAccessibilityEvent(32);
      SlidingPaneLayout.this.Su = true;
    }
    
    public final void a(View paramView, float paramFloat1, float paramFloat2)
    {
      SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)paramView.getLayoutParams();
      int i;
      int j;
      if (SlidingPaneLayout.this.fA())
      {
        i = SlidingPaneLayout.this.getPaddingRight();
        j = localLayoutParams.rightMargin + i;
        if (paramFloat1 >= 0.0F)
        {
          i = j;
          if (paramFloat1 == 0.0F)
          {
            i = j;
            if (SlidingPaneLayout.this.So <= 0.5F) {}
          }
        }
        else
        {
          i = j + SlidingPaneLayout.this.Sq;
        }
        j = SlidingPaneLayout.this.Sn.getWidth();
        i = SlidingPaneLayout.this.getWidth() - i - j;
      }
      for (;;)
      {
        SlidingPaneLayout.this.St.A(i, paramView.getTop());
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
            if (SlidingPaneLayout.this.So <= 0.5F) {}
          }
        }
        else
        {
          i = j + SlidingPaneLayout.this.Sq;
        }
      }
    }
    
    public final void b(View paramView, int paramInt1, int paramInt2)
    {
      paramView = SlidingPaneLayout.this;
      if (paramView.Sn == null)
      {
        paramView.So = 0.0F;
        SlidingPaneLayout.this.invalidate();
        return;
      }
      boolean bool = paramView.fA();
      SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)paramView.Sn.getLayoutParams();
      int i = paramView.Sn.getWidth();
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
        paramView.So = ((paramInt2 - (i + paramInt1)) / paramView.Sq);
        if (paramView.Sr != 0) {
          paramView.G(paramView.So);
        }
        if (!localLayoutParams.SC) {
          break;
        }
        paramView.a(paramView.Sn, paramView.So, paramView.Si);
        break;
        paramInt1 = paramView.getPaddingLeft();
        break label79;
      }
    }
    
    public final boolean c(View paramView, int paramInt)
    {
      if (SlidingPaneLayout.this.mIsUnableToDrag) {
        return false;
      }
      return ((SlidingPaneLayout.LayoutParams)paramView.getLayoutParams()).SB;
    }
    
    public final int d(View paramView, int paramInt)
    {
      return paramView.getTop();
    }
    
    public final int e(View paramView, int paramInt)
    {
      paramView = (SlidingPaneLayout.LayoutParams)SlidingPaneLayout.this.Sn.getLayoutParams();
      if (SlidingPaneLayout.this.fA())
      {
        i = SlidingPaneLayout.this.getWidth();
        j = SlidingPaneLayout.this.getPaddingRight();
        i -= paramView.rightMargin + j + SlidingPaneLayout.this.Sn.getWidth();
        j = SlidingPaneLayout.this.Sq;
        return Math.max(Math.min(paramInt, i), i - j);
      }
      int i = SlidingPaneLayout.this.getPaddingLeft();
      i = paramView.leftMargin + i;
      int j = SlidingPaneLayout.this.Sq;
      return Math.min(Math.max(paramInt, i), j + i);
    }
    
    public final void l(View paramView, int paramInt)
    {
      SlidingPaneLayout.this.fy();
    }
    
    public final void w(int paramInt1, int paramInt2)
    {
      SlidingPaneLayout.this.St.y(SlidingPaneLayout.this.Sn, paramInt2);
    }
    
    public final int x(View paramView)
    {
      return SlidingPaneLayout.this.Sq;
    }
  }
  
  public static abstract interface d {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.widget.SlidingPaneLayout
 * JD-Core Version:    0.7.0.1
 */