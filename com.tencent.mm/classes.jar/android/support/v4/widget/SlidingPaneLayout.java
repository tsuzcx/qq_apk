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
import android.support.v4.view.q;
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
  static final e LK = new f();
  private float FH;
  private float FI;
  boolean GP;
  private boolean Hb = true;
  private boolean LA;
  View LB;
  float LC;
  private float LD;
  int LE;
  int LF;
  private d LG;
  final r LH;
  boolean LI;
  final ArrayList<b> LJ = new ArrayList();
  int Lv = -858993460;
  private int Lw;
  private Drawable Lx;
  private Drawable Ly;
  private final int Lz;
  private final Rect hc = new Rect();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      LK = new h();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      LK = new g();
      return;
    }
  }
  
  public SlidingPaneLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SlidingPaneLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.Lz = ((int)(32.0F * f + 0.5F));
    setWillNotDraw(false);
    q.a(this, new a());
    q.n(this, 1);
    this.LH = r.a(this, 0.5F, new c());
    this.LH.MS = (f * 400.0F);
  }
  
  private boolean E(float paramFloat)
  {
    if (!this.LA) {
      return false;
    }
    boolean bool = dS();
    LayoutParams localLayoutParams = (LayoutParams)this.LB.getLayoutParams();
    int j;
    int k;
    if (bool)
    {
      i = getPaddingRight();
      j = localLayoutParams.rightMargin;
      k = this.LB.getWidth();
    }
    for (int i = (int)(getWidth() - (j + i + this.LE * paramFloat + k)); this.LH.e(this.LB, i, this.LB.getTop()); i = (int)(localLayoutParams.leftMargin + i + this.LE * paramFloat))
    {
      dQ();
      q.O(this);
      return true;
      i = getPaddingLeft();
    }
    return false;
  }
  
  private boolean dR()
  {
    boolean bool = false;
    if ((this.Hb) || (E(0.0F)))
    {
      this.LI = false;
      bool = true;
    }
    return bool;
  }
  
  final void F(float paramFloat)
  {
    boolean bool = dS();
    Object localObject = (LayoutParams)this.LB.getLayoutParams();
    int i;
    label43:
    int j;
    if (((LayoutParams)localObject).LO) {
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
        if (localObject != this.LB)
        {
          int k = (int)((1.0F - this.LD) * this.LF);
          this.LD = paramFloat;
          int m = k - (int)((1.0F - paramFloat) * this.LF);
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
    for (float f = this.LD - 1.0F;; f = 1.0F - this.LD)
    {
      a((View)localObject, f, this.Lw);
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
      if (localLayoutParams.LP == null) {
        localLayoutParams.LP = new Paint();
      }
      localLayoutParams.LP.setColorFilter(new PorterDuffColorFilter(i << 24 | 0xFFFFFF & paramInt, PorterDuff.Mode.SRC_OVER));
      if (paramView.getLayerType() != 2) {
        paramView.setLayerType(2, localLayoutParams.LP);
      }
      aI(paramView);
    }
    while (paramView.getLayerType() == 0)
    {
      int i;
      return;
    }
    if (localLayoutParams.LP != null) {
      localLayoutParams.LP.setColorFilter(null);
    }
    paramView = new b(paramView);
    this.LJ.add(paramView);
    q.b(this, paramView);
  }
  
  final void aH(View paramView)
  {
    boolean bool = dS();
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
  
  final void aI(View paramView)
  {
    LK.a(this, paramView);
  }
  
  final boolean aJ(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    paramView = (LayoutParams)paramView.getLayoutParams();
    return (this.LA) && (paramView.LO) && (this.LC > 0.0F);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    if (this.LH.dW())
    {
      if (!this.LA) {
        this.LH.abort();
      }
    }
    else {
      return;
    }
    q.O(this);
  }
  
  final void dQ()
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
  
  final boolean dS()
  {
    return q.Q(this) == 1;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Drawable localDrawable;
    if (dS())
    {
      localDrawable = this.Ly;
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
      localDrawable = this.Lx;
      break;
    }
    label59:
    int k = localView.getTop();
    int m = localView.getBottom();
    int n = localDrawable.getIntrinsicWidth();
    int j;
    int i;
    if (dS())
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
    if ((this.LA) && (!localLayoutParams.LN) && (this.LB != null))
    {
      paramCanvas.getClipBounds(this.hc);
      if (!dS()) {
        break label104;
      }
      this.hc.left = Math.max(this.hc.left, this.LB.getRight());
    }
    for (;;)
    {
      paramCanvas.clipRect(this.hc);
      boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
      paramCanvas.restoreToCount(i);
      return bool;
      label104:
      this.hc.right = Math.min(this.hc.right, this.LB.getLeft());
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
    return this.Lw;
  }
  
  public int getParallaxDistance()
  {
    return this.LF;
  }
  
  public int getSliderFadeColor()
  {
    return this.Lv;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.Hb = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.Hb = true;
    int j = this.LJ.size();
    int i = 0;
    while (i < j)
    {
      ((b)this.LJ.get(i)).run();
      i += 1;
    }
    this.LJ.clear();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    int i = paramMotionEvent.getActionMasked();
    if ((!this.LA) && (i == 0) && (getChildCount() > 1))
    {
      View localView = getChildAt(1);
      if (localView != null) {
        if (r.f(localView, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
          break label104;
        }
      }
    }
    label104:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.LI = bool1;
      if ((this.LA) && ((!this.GP) || (i == 0))) {
        break;
      }
      this.LH.cancel();
      bool1 = super.onInterceptTouchEvent(paramMotionEvent);
      return bool1;
    }
    if ((i == 3) || (i == 1))
    {
      this.LH.cancel();
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
        if (!this.LH.f(paramMotionEvent))
        {
          bool1 = bool2;
          if (i == 0) {
            break;
          }
        }
        return true;
        this.GP = false;
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        this.FH = f1;
        this.FI = f2;
        if ((!r.f(this.LB, (int)f1, (int)f2)) || (!aJ(this.LB))) {
          break label160;
        }
      }
      f2 = paramMotionEvent.getX();
      f1 = paramMotionEvent.getY();
      f2 = Math.abs(f2 - this.FH);
      f1 = Math.abs(f1 - this.FI);
    } while ((f2 <= this.LH.jb) || (f1 <= f2));
    this.LH.cancel();
    this.GP = true;
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = dS();
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
      this.LH.MU = 2;
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
      if (this.Hb)
      {
        if ((!this.LA) || (!this.LI)) {
          break label375;
        }
        f = 1.0F;
        this.LC = f;
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
      if (!localLayoutParams.LN) {
        break label396;
      }
      i = localLayoutParams.leftMargin;
      int i2 = localLayoutParams.rightMargin;
      i2 = Math.min(paramInt1, k - paramInt3 - this.Lz) - paramInt2 - (i + i2);
      this.LE = i2;
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
      localLayoutParams.LO = paramBoolean;
      i2 = (int)(i2 * this.LC);
      paramInt2 += i + i2;
      this.LC = (i2 / this.LE);
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
      this.LH.MU = 1;
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
      if ((this.LA) && (this.LF != 0)) {}
      for (paramInt2 = (int)((1.0F - this.LC) * this.LF);; paramInt2 = 0)
      {
        i = paramInt2;
        paramInt2 = paramInt1;
        break;
        label432:
        i = paramInt2 - i;
        j = i + i1;
        break label293;
        label448:
        if (this.Hb)
        {
          if (!this.LA) {
            break label523;
          }
          if (this.LF != 0) {
            F(this.LC);
          }
          if (((LayoutParams)this.LB.getLayoutParams()).LO) {
            a(this.LB, this.LC, this.Lv);
          }
        }
        for (;;)
        {
          aH(this.LB);
          this.Hb = false;
          return;
          label523:
          paramInt1 = 0;
          while (paramInt1 < m)
          {
            a(getChildAt(paramInt1), 0.0F, this.Lv);
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
        this.LB = null;
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
          localLayoutParams.LO = false;
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
          localLayoutParams.LN = bool2;
          if (localLayoutParams.LN) {
            this.LB = localView;
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
          i1 = i2 - this.Lz;
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
                if ((!bool1) || (localView == this.LB)) {
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
        this.LA = bool1;
        if ((this.LH.MI != 0) && (!bool1)) {
          this.LH.abort();
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
    super.onRestoreInstanceState(paramParcelable.EA);
    if (paramParcelable.LQ) {
      if ((this.Hb) || (E(1.0F))) {
        this.LI = true;
      }
    }
    for (;;)
    {
      this.LI = paramParcelable.LQ;
      return;
      dR();
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    boolean bool;
    if (this.LA) {
      if ((!this.LA) || (this.LC == 1.0F)) {
        bool = true;
      }
    }
    for (;;)
    {
      localSavedState.LQ = bool;
      return localSavedState;
      bool = false;
      continue;
      bool = this.LI;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      this.Hb = true;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.LA) {
      return super.onTouchEvent(paramMotionEvent);
    }
    this.LH.g(paramMotionEvent);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      return true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.FH = f1;
      this.FI = f2;
      continue;
      if (aJ(this.LB))
      {
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        float f3 = f1 - this.FH;
        float f4 = f2 - this.FI;
        int i = this.LH.jb;
        if ((f3 * f3 + f4 * f4 < i * i) && (r.f(this.LB, (int)f1, (int)f2))) {
          dR();
        }
      }
    }
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    super.requestChildFocus(paramView1, paramView2);
    if ((!isInTouchMode()) && (!this.LA)) {
      if (paramView1 != this.LB) {
        break label36;
      }
    }
    label36:
    for (boolean bool = true;; bool = false)
    {
      this.LI = bool;
      return;
    }
  }
  
  public void setCoveredFadeColor(int paramInt)
  {
    this.Lw = paramInt;
  }
  
  public void setPanelSlideListener(d paramd)
  {
    this.LG = paramd;
  }
  
  public void setParallaxDistance(int paramInt)
  {
    this.LF = paramInt;
    requestLayout();
  }
  
  @Deprecated
  public void setShadowDrawable(Drawable paramDrawable)
  {
    setShadowDrawableLeft(paramDrawable);
  }
  
  public void setShadowDrawableLeft(Drawable paramDrawable)
  {
    this.Lx = paramDrawable;
  }
  
  public void setShadowDrawableRight(Drawable paramDrawable)
  {
    this.Ly = paramDrawable;
  }
  
  @Deprecated
  public void setShadowResource(int paramInt)
  {
    setShadowDrawable(getResources().getDrawable(paramInt));
  }
  
  public void setShadowResourceLeft(int paramInt)
  {
    setShadowDrawableLeft(b.g(getContext(), paramInt));
  }
  
  public void setShadowResourceRight(int paramInt)
  {
    setShadowDrawableRight(b.g(getContext(), paramInt));
  }
  
  public void setSliderFadeColor(int paramInt)
  {
    this.Lv = paramInt;
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    private static final int[] FV = { 16843137 };
    boolean LN;
    boolean LO;
    Paint LP;
    public float weight = 0.0F;
    
    public LayoutParams()
    {
      super(-1);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, FV);
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
    boolean LQ;
    
    SavedState(Parcel paramParcel)
    {
      super(null);
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.LQ = bool;
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
      if (this.LQ) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        return;
      }
    }
  }
  
  final class a
    extends android.support.v4.view.a
  {
    private final Rect hc = new Rect();
    
    a() {}
    
    private boolean aK(View paramView)
    {
      return SlidingPaneLayout.this.aJ(paramView);
    }
    
    public final void a(View paramView, android.support.v4.view.a.a parama)
    {
      int j = 0;
      android.support.v4.view.a.a locala = android.support.v4.view.a.a.a(parama);
      super.a(paramView, locala);
      Rect localRect = this.hc;
      locala.getBoundsInParent(localRect);
      parama.setBoundsInParent(localRect);
      locala.getBoundsInScreen(localRect);
      parama.setBoundsInScreen(localRect);
      parama.setVisibleToUser(locala.isVisibleToUser());
      parama.setPackageName(locala.HJ.getPackageName());
      parama.setClassName(locala.HJ.getClassName());
      parama.setContentDescription(locala.HJ.getContentDescription());
      parama.setEnabled(locala.HJ.isEnabled());
      parama.setClickable(locala.HJ.isClickable());
      parama.setFocusable(locala.HJ.isFocusable());
      parama.setFocused(locala.HJ.isFocused());
      parama.setAccessibilityFocused(locala.isAccessibilityFocused());
      parama.setSelected(locala.HJ.isSelected());
      parama.setLongClickable(locala.HJ.isLongClickable());
      parama.addAction(locala.HJ.getActions());
      if (Build.VERSION.SDK_INT >= 16) {}
      for (int i = locala.HJ.getMovementGranularities();; i = 0)
      {
        if (Build.VERSION.SDK_INT >= 16) {
          parama.HJ.setMovementGranularities(i);
        }
        locala.HJ.recycle();
        parama.setClassName(SlidingPaneLayout.class.getName());
        parama.setSource(paramView);
        paramView = q.R(paramView);
        if ((paramView instanceof View)) {
          parama.setParent((View)paramView);
        }
        int k = SlidingPaneLayout.this.getChildCount();
        i = j;
        while (i < k)
        {
          paramView = SlidingPaneLayout.this.getChildAt(i);
          if ((!aK(paramView)) && (paramView.getVisibility() == 0))
          {
            q.n(paramView, 1);
            parama.addChild(paramView);
          }
          i += 1;
        }
      }
    }
    
    public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
    }
    
    public final boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      if (!aK(paramView)) {
        return super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
      }
      return false;
    }
  }
  
  private final class b
    implements Runnable
  {
    final View LM;
    
    b(View paramView)
    {
      this.LM = paramView;
    }
    
    public final void run()
    {
      if (this.LM.getParent() == SlidingPaneLayout.this)
      {
        this.LM.setLayerType(0, null);
        SlidingPaneLayout.this.aI(this.LM);
      }
      SlidingPaneLayout.this.LJ.remove(this);
    }
  }
  
  private final class c
    extends r.a
  {
    c() {}
    
    public final void a(View paramView, float paramFloat1, float paramFloat2)
    {
      SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)paramView.getLayoutParams();
      int i;
      int j;
      if (SlidingPaneLayout.this.dS())
      {
        i = SlidingPaneLayout.this.getPaddingRight();
        j = localLayoutParams.rightMargin + i;
        if (paramFloat1 >= 0.0F)
        {
          i = j;
          if (paramFloat1 == 0.0F)
          {
            i = j;
            if (SlidingPaneLayout.this.LC <= 0.5F) {}
          }
        }
        else
        {
          i = j + SlidingPaneLayout.this.LE;
        }
        j = SlidingPaneLayout.this.LB.getWidth();
        i = SlidingPaneLayout.this.getWidth() - i - j;
      }
      for (;;)
      {
        SlidingPaneLayout.this.LH.x(i, paramView.getTop());
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
            if (SlidingPaneLayout.this.LC <= 0.5F) {}
          }
        }
        else
        {
          i = j + SlidingPaneLayout.this.LE;
        }
      }
    }
    
    public final void a(View paramView, int paramInt1, int paramInt2)
    {
      paramView = SlidingPaneLayout.this;
      if (paramView.LB == null)
      {
        paramView.LC = 0.0F;
        SlidingPaneLayout.this.invalidate();
        return;
      }
      boolean bool = paramView.dS();
      SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)paramView.LB.getLayoutParams();
      int i = paramView.LB.getWidth();
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
        paramView.LC = ((paramInt2 - (i + paramInt1)) / paramView.LE);
        if (paramView.LF != 0) {
          paramView.F(paramView.LC);
        }
        if (!localLayoutParams.LO) {
          break;
        }
        paramView.a(paramView.LB, paramView.LC, paramView.Lv);
        break;
        paramInt1 = paramView.getPaddingLeft();
        break label79;
      }
    }
    
    public final boolean b(View paramView, int paramInt)
    {
      if (SlidingPaneLayout.this.GP) {
        return false;
      }
      return ((SlidingPaneLayout.LayoutParams)paramView.getLayoutParams()).LN;
    }
    
    public final int c(View paramView, int paramInt)
    {
      return paramView.getTop();
    }
    
    public final int d(View paramView, int paramInt)
    {
      paramView = (SlidingPaneLayout.LayoutParams)SlidingPaneLayout.this.LB.getLayoutParams();
      if (SlidingPaneLayout.this.dS())
      {
        i = SlidingPaneLayout.this.getWidth();
        j = SlidingPaneLayout.this.getPaddingRight();
        i -= paramView.rightMargin + j + SlidingPaneLayout.this.LB.getWidth();
        j = SlidingPaneLayout.this.LE;
        return Math.max(Math.min(paramInt, i), i - j);
      }
      int i = SlidingPaneLayout.this.getPaddingLeft();
      i = paramView.leftMargin + i;
      int j = SlidingPaneLayout.this.LE;
      return Math.min(Math.max(paramInt, i), j + i);
    }
    
    public final void j(View paramView, int paramInt)
    {
      SlidingPaneLayout.this.dQ();
    }
    
    public final int q(View paramView)
    {
      return SlidingPaneLayout.this.LE;
    }
    
    public final void u(int paramInt1, int paramInt2)
    {
      SlidingPaneLayout.this.LH.t(SlidingPaneLayout.this.LB, paramInt2);
    }
    
    public final void x(int paramInt)
    {
      if (SlidingPaneLayout.this.LH.MI == 0)
      {
        if (SlidingPaneLayout.this.LC == 0.0F)
        {
          SlidingPaneLayout.this.aH(SlidingPaneLayout.this.LB);
          localSlidingPaneLayout = SlidingPaneLayout.this;
          localView = SlidingPaneLayout.this.LB;
          localSlidingPaneLayout.sendAccessibilityEvent(32);
          SlidingPaneLayout.this.LI = false;
        }
      }
      else {
        return;
      }
      SlidingPaneLayout localSlidingPaneLayout = SlidingPaneLayout.this;
      View localView = SlidingPaneLayout.this.LB;
      localSlidingPaneLayout.sendAccessibilityEvent(32);
      SlidingPaneLayout.this.LI = true;
    }
  }
  
  public static abstract interface d {}
  
  static abstract interface e
  {
    public abstract void a(SlidingPaneLayout paramSlidingPaneLayout, View paramView);
  }
  
  static class f
    implements SlidingPaneLayout.e
  {
    public void a(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
    {
      q.c(paramSlidingPaneLayout, paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
    }
  }
  
  static final class g
    extends SlidingPaneLayout.f
  {
    private Method LR;
    private Field LS;
    
    g()
    {
      try
      {
        this.LR = View.class.getDeclaredMethod("getDisplayList", null);
        try
        {
          label16:
          this.LS = View.class.getDeclaredField("mRecreateDisplayList");
          this.LS.setAccessible(true);
          return;
        }
        catch (NoSuchFieldException localNoSuchFieldException) {}
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        break label16;
      }
    }
    
    public final void a(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
    {
      if ((this.LR != null) && (this.LS != null)) {}
      try
      {
        this.LS.setBoolean(paramView, true);
        this.LR.invoke(paramView, null);
        label33:
        super.a(paramSlidingPaneLayout, paramView);
        return;
        paramView.invalidate();
        return;
      }
      catch (Exception localException)
      {
        break label33;
      }
    }
  }
  
  static final class h
    extends SlidingPaneLayout.f
  {
    public final void a(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
    {
      q.a(paramView, ((SlidingPaneLayout.LayoutParams)paramView.getLayoutParams()).LP);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.widget.SlidingPaneLayout
 * JD-Core Version:    0.7.0.1
 */