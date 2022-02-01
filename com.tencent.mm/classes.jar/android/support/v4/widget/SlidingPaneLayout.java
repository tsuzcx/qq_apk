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
import android.support.v4.view.u;
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
  private final Rect Ui = new Rect();
  int Vg = -858993460;
  private int Vh;
  private Drawable Vi;
  private Drawable Vj;
  private final int Vk;
  View Vl;
  float Vm;
  private float Vn;
  int Vo;
  int Vp;
  private d Vq;
  final t Vr;
  boolean Vs;
  final ArrayList<b> Vt = new ArrayList();
  private Method Vu;
  private Field Vv;
  private boolean Vw;
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
    this.Vk = ((int)(32.0F * f + 0.5F));
    setWillNotDraw(false);
    u.a(this, new a());
    u.p(this, 1);
    this.Vr = t.a(this, 0.5F, new c());
    this.Vr.WH = (f * 400.0F);
  }
  
  private boolean H(float paramFloat)
  {
    if (!this.mCanSlide) {
      return false;
    }
    boolean bool = gh();
    LayoutParams localLayoutParams = (LayoutParams)this.Vl.getLayoutParams();
    int j;
    int k;
    if (bool)
    {
      i = getPaddingRight();
      j = localLayoutParams.rightMargin;
      k = this.Vl.getWidth();
    }
    for (int i = (int)(getWidth() - (j + i + this.Vo * paramFloat + k)); this.Vr.h(this.Vl, i, this.Vl.getTop()); i = (int)(localLayoutParams.leftMargin + i + this.Vo * paramFloat))
    {
      gf();
      u.X(this);
      return true;
      i = getPaddingLeft();
    }
    return false;
  }
  
  private boolean gg()
  {
    boolean bool = false;
    if ((this.mFirstLayout) || (H(0.0F)))
    {
      this.Vs = false;
      bool = true;
    }
    return bool;
  }
  
  final void I(float paramFloat)
  {
    boolean bool = gh();
    Object localObject = (LayoutParams)this.Vl.getLayoutParams();
    int i;
    label43:
    int j;
    if (((LayoutParams)localObject).VA) {
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
        if (localObject != this.Vl)
        {
          int k = (int)((1.0F - this.Vn) * this.Vp);
          this.Vn = paramFloat;
          int m = k - (int)((1.0F - paramFloat) * this.Vp);
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
    for (float f = this.Vn - 1.0F;; f = 1.0F - this.Vn)
    {
      a((View)localObject, f, this.Vh);
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
      if (localLayoutParams.VB == null) {
        localLayoutParams.VB = new Paint();
      }
      localLayoutParams.VB.setColorFilter(new PorterDuffColorFilter(i << 24 | 0xFFFFFF & paramInt, PorterDuff.Mode.SRC_OVER));
      if (paramView.getLayerType() != 2) {
        paramView.setLayerType(2, localLayoutParams.VB);
      }
      aW(paramView);
    }
    while (paramView.getLayerType() == 0)
    {
      int i;
      return;
    }
    if (localLayoutParams.VB != null) {
      localLayoutParams.VB.setColorFilter(null);
    }
    paramView = new b(paramView);
    this.Vt.add(paramView);
    u.b(this, paramView);
  }
  
  final void aV(View paramView)
  {
    boolean bool = gh();
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
  
  final void aW(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      u.a(paramView, ((LayoutParams)paramView.getLayoutParams()).VB);
      return;
    }
    if ((Build.VERSION.SDK_INT < 16) || (!this.Vw)) {}
    try
    {
      this.Vu = View.class.getDeclaredMethod("getDisplayList", null);
      try
      {
        label51:
        this.Vv = View.class.getDeclaredField("mRecreateDisplayList");
        this.Vv.setAccessible(true);
        label71:
        this.Vw = true;
        if ((this.Vu == null) || (this.Vv == null))
        {
          paramView.invalidate();
          return;
        }
        try
        {
          this.Vv.setBoolean(paramView, true);
          this.Vu.invoke(paramView, null);
          label114:
          u.c(this, paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
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
  
  final boolean aX(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    paramView = (LayoutParams)paramView.getLayoutParams();
    return (this.mCanSlide) && (paramView.VA) && (this.Vm > 0.0F);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    if (this.Vr.go())
    {
      if (!this.mCanSlide) {
        this.Vr.abort();
      }
    }
    else {
      return;
    }
    u.X(this);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Drawable localDrawable;
    if (gh())
    {
      localDrawable = this.Vj;
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
      localDrawable = this.Vi;
      break;
    }
    label59:
    int k = localView.getTop();
    int m = localView.getBottom();
    int n = localDrawable.getIntrinsicWidth();
    int j;
    int i;
    if (gh())
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
    if ((this.mCanSlide) && (!localLayoutParams.Vz) && (this.Vl != null))
    {
      paramCanvas.getClipBounds(this.Ui);
      if (!gh()) {
        break label104;
      }
      this.Ui.left = Math.max(this.Ui.left, this.Vl.getRight());
    }
    for (;;)
    {
      paramCanvas.clipRect(this.Ui);
      boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
      paramCanvas.restoreToCount(i);
      return bool;
      label104:
      this.Ui.right = Math.min(this.Ui.right, this.Vl.getLeft());
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
    return this.Vh;
  }
  
  public int getParallaxDistance()
  {
    return this.Vp;
  }
  
  public int getSliderFadeColor()
  {
    return this.Vg;
  }
  
  final void gf()
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
  
  final boolean gh()
  {
    return u.Z(this) == 1;
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
    int j = this.Vt.size();
    int i = 0;
    while (i < j)
    {
      ((b)this.Vt.get(i)).run();
      i += 1;
    }
    this.Vt.clear();
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
      this.Vs = bool1;
      if ((this.mCanSlide) && ((!this.mIsUnableToDrag) || (i == 0))) {
        break;
      }
      this.Vr.cancel();
      bool1 = super.onInterceptTouchEvent(paramMotionEvent);
      return bool1;
    }
    if ((i == 3) || (i == 1))
    {
      this.Vr.cancel();
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
        if (!this.Vr.j(paramMotionEvent))
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
        if ((!t.i(this.Vl, (int)f1, (int)f2)) || (!aX(this.Vl))) {
          break label160;
        }
      }
      f2 = paramMotionEvent.getX();
      f1 = paramMotionEvent.getY();
      f2 = Math.abs(f2 - this.mInitialMotionX);
      f1 = Math.abs(f1 - this.mInitialMotionY);
    } while ((f2 <= this.Vr.mTouchSlop) || (f1 <= f2));
    this.Vr.cancel();
    this.mIsUnableToDrag = true;
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = gh();
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
      this.Vr.WJ = 2;
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
        if ((!this.mCanSlide) || (!this.Vs)) {
          break label375;
        }
        f = 1.0F;
        this.Vm = f;
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
      if (!localLayoutParams.Vz) {
        break label396;
      }
      i = localLayoutParams.leftMargin;
      int i2 = localLayoutParams.rightMargin;
      i2 = Math.min(paramInt1, k - paramInt3 - this.Vk) - paramInt2 - (i + i2);
      this.Vo = i2;
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
      localLayoutParams.VA = paramBoolean;
      i2 = (int)(i2 * this.Vm);
      paramInt2 += i + i2;
      this.Vm = (i2 / this.Vo);
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
      this.Vr.WJ = 1;
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
      if ((this.mCanSlide) && (this.Vp != 0)) {}
      for (paramInt2 = (int)((1.0F - this.Vm) * this.Vp);; paramInt2 = 0)
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
          if (this.Vp != 0) {
            I(this.Vm);
          }
          if (((LayoutParams)this.Vl.getLayoutParams()).VA) {
            a(this.Vl, this.Vm, this.Vg);
          }
        }
        for (;;)
        {
          aV(this.Vl);
          this.mFirstLayout = false;
          return;
          label523:
          paramInt1 = 0;
          while (paramInt1 < m)
          {
            a(getChildAt(paramInt1), 0.0F, this.Vg);
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
        this.Vl = null;
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
          localLayoutParams.VA = false;
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
          localLayoutParams.Vz = bool2;
          if (localLayoutParams.Vz) {
            this.Vl = localView;
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
          i1 = i2 - this.Vk;
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
                if ((!bool1) || (localView == this.Vl)) {
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
        if ((this.Vr.Wx != 0) && (!bool1)) {
          this.Vr.abort();
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
    super.onRestoreInstanceState(paramParcelable.Pm);
    if (paramParcelable.VC) {
      if ((this.mFirstLayout) || (H(1.0F))) {
        this.Vs = true;
      }
    }
    for (;;)
    {
      this.Vs = paramParcelable.VC;
      return;
      gg();
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    boolean bool;
    if (this.mCanSlide) {
      if ((!this.mCanSlide) || (this.Vm == 1.0F)) {
        bool = true;
      }
    }
    for (;;)
    {
      localSavedState.VC = bool;
      return localSavedState;
      bool = false;
      continue;
      bool = this.Vs;
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
    this.Vr.k(paramMotionEvent);
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
      if (aX(this.Vl))
      {
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        float f3 = f1 - this.mInitialMotionX;
        float f4 = f2 - this.mInitialMotionY;
        int i = this.Vr.mTouchSlop;
        if ((f3 * f3 + f4 * f4 < i * i) && (t.i(this.Vl, (int)f1, (int)f2))) {
          gg();
        }
      }
    }
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    super.requestChildFocus(paramView1, paramView2);
    if ((!isInTouchMode()) && (!this.mCanSlide)) {
      if (paramView1 != this.Vl) {
        break label36;
      }
    }
    label36:
    for (boolean bool = true;; bool = false)
    {
      this.Vs = bool;
      return;
    }
  }
  
  public void setCoveredFadeColor(int paramInt)
  {
    this.Vh = paramInt;
  }
  
  public void setPanelSlideListener(d paramd)
  {
    this.Vq = paramd;
  }
  
  public void setParallaxDistance(int paramInt)
  {
    this.Vp = paramInt;
    requestLayout();
  }
  
  @Deprecated
  public void setShadowDrawable(Drawable paramDrawable)
  {
    setShadowDrawableLeft(paramDrawable);
  }
  
  public void setShadowDrawableLeft(Drawable paramDrawable)
  {
    this.Vi = paramDrawable;
  }
  
  public void setShadowDrawableRight(Drawable paramDrawable)
  {
    this.Vj = paramDrawable;
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
    this.Vg = paramInt;
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    private static final int[] QA = { 16843137 };
    boolean VA;
    Paint VB;
    boolean Vz;
    public float weight = 0.0F;
    
    public LayoutParams()
    {
      super(-1);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, QA);
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
    boolean VC;
    
    SavedState(Parcel paramParcel)
    {
      super(null);
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.VC = bool;
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
      if (this.VC) {}
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
    private final Rect Ui = new Rect();
    
    a() {}
    
    private boolean aY(View paramView)
    {
      return SlidingPaneLayout.this.aX(paramView);
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
      Rect localRect = this.Ui;
      localc.getBoundsInParent(localRect);
      paramc.setBoundsInParent(localRect);
      localc.getBoundsInScreen(localRect);
      paramc.setBoundsInScreen(localRect);
      paramc.setVisibleToUser(localc.isVisibleToUser());
      paramc.setPackageName(localc.Ro.getPackageName());
      paramc.setClassName(localc.Ro.getClassName());
      paramc.setContentDescription(localc.Ro.getContentDescription());
      paramc.setEnabled(localc.Ro.isEnabled());
      paramc.setClickable(localc.Ro.isClickable());
      paramc.setFocusable(localc.Ro.isFocusable());
      paramc.setFocused(localc.Ro.isFocused());
      paramc.setAccessibilityFocused(localc.isAccessibilityFocused());
      paramc.setSelected(localc.Ro.isSelected());
      paramc.setLongClickable(localc.Ro.isLongClickable());
      paramc.addAction(localc.Ro.getActions());
      if (Build.VERSION.SDK_INT >= 16) {}
      for (int i = localc.Ro.getMovementGranularities();; i = 0)
      {
        if (Build.VERSION.SDK_INT >= 16) {
          paramc.Ro.setMovementGranularities(i);
        }
        localc.Ro.recycle();
        paramc.setClassName(SlidingPaneLayout.class.getName());
        paramc.setSource(paramView);
        paramView = u.aa(paramView);
        if ((paramView instanceof View)) {
          paramc.setParent((View)paramView);
        }
        int k = SlidingPaneLayout.this.getChildCount();
        i = j;
        while (i < k)
        {
          paramView = SlidingPaneLayout.this.getChildAt(i);
          if ((!aY(paramView)) && (paramView.getVisibility() == 0))
          {
            u.p(paramView, 1);
            paramc.addChild(paramView);
          }
          i += 1;
        }
      }
    }
    
    public final boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      if (!aY(paramView)) {
        return super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
      }
      return false;
    }
  }
  
  final class b
    implements Runnable
  {
    final View Vy;
    
    b(View paramView)
    {
      this.Vy = paramView;
    }
    
    public final void run()
    {
      if (this.Vy.getParent() == SlidingPaneLayout.this)
      {
        this.Vy.setLayerType(0, null);
        SlidingPaneLayout.this.aW(this.Vy);
      }
      SlidingPaneLayout.this.Vt.remove(this);
    }
  }
  
  final class c
    extends t.a
  {
    c() {}
    
    public final void D(int paramInt1, int paramInt2)
    {
      SlidingPaneLayout.this.Vr.y(SlidingPaneLayout.this.Vl, paramInt2);
    }
    
    public final void L(int paramInt)
    {
      if (SlidingPaneLayout.this.Vr.Wx == 0)
      {
        if (SlidingPaneLayout.this.Vm == 0.0F)
        {
          SlidingPaneLayout.this.aV(SlidingPaneLayout.this.Vl);
          SlidingPaneLayout.this.sendAccessibilityEvent(32);
          SlidingPaneLayout.this.Vs = false;
        }
      }
      else {
        return;
      }
      SlidingPaneLayout.this.sendAccessibilityEvent(32);
      SlidingPaneLayout.this.Vs = true;
    }
    
    public final void a(View paramView, float paramFloat1, float paramFloat2)
    {
      SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)paramView.getLayoutParams();
      int i;
      int j;
      if (SlidingPaneLayout.this.gh())
      {
        i = SlidingPaneLayout.this.getPaddingRight();
        j = localLayoutParams.rightMargin + i;
        if (paramFloat1 >= 0.0F)
        {
          i = j;
          if (paramFloat1 == 0.0F)
          {
            i = j;
            if (SlidingPaneLayout.this.Vm <= 0.5F) {}
          }
        }
        else
        {
          i = j + SlidingPaneLayout.this.Vo;
        }
        j = SlidingPaneLayout.this.Vl.getWidth();
        i = SlidingPaneLayout.this.getWidth() - i - j;
      }
      for (;;)
      {
        SlidingPaneLayout.this.Vr.H(i, paramView.getTop());
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
            if (SlidingPaneLayout.this.Vm <= 0.5F) {}
          }
        }
        else
        {
          i = j + SlidingPaneLayout.this.Vo;
        }
      }
    }
    
    public final void b(View paramView, int paramInt1, int paramInt2)
    {
      paramView = SlidingPaneLayout.this;
      if (paramView.Vl == null)
      {
        paramView.Vm = 0.0F;
        SlidingPaneLayout.this.invalidate();
        return;
      }
      boolean bool = paramView.gh();
      SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)paramView.Vl.getLayoutParams();
      int i = paramView.Vl.getWidth();
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
        paramView.Vm = ((paramInt2 - (i + paramInt1)) / paramView.Vo);
        if (paramView.Vp != 0) {
          paramView.I(paramView.Vm);
        }
        if (!localLayoutParams.VA) {
          break;
        }
        paramView.a(paramView.Vl, paramView.Vm, paramView.Vg);
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
      return ((SlidingPaneLayout.LayoutParams)paramView.getLayoutParams()).Vz;
    }
    
    public final int d(View paramView, int paramInt)
    {
      return paramView.getTop();
    }
    
    public final int e(View paramView, int paramInt)
    {
      paramView = (SlidingPaneLayout.LayoutParams)SlidingPaneLayout.this.Vl.getLayoutParams();
      if (SlidingPaneLayout.this.gh())
      {
        i = SlidingPaneLayout.this.getWidth();
        j = SlidingPaneLayout.this.getPaddingRight();
        i -= paramView.rightMargin + j + SlidingPaneLayout.this.Vl.getWidth();
        j = SlidingPaneLayout.this.Vo;
        return Math.max(Math.min(paramInt, i), i - j);
      }
      int i = SlidingPaneLayout.this.getPaddingLeft();
      i = paramView.leftMargin + i;
      int j = SlidingPaneLayout.this.Vo;
      return Math.min(Math.max(paramInt, i), j + i);
    }
    
    public final void l(View paramView, int paramInt)
    {
      SlidingPaneLayout.this.gf();
    }
    
    public final int y(View paramView)
    {
      return SlidingPaneLayout.this.Vo;
    }
  }
  
  public static abstract interface d {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.widget.SlidingPaneLayout
 * JD-Core Version:    0.7.0.1
 */