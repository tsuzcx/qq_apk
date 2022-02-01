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
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.g.a.d;
import androidx.core.g.w;
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
  private final Rect Si;
  int anE;
  private int anF;
  private Drawable anG;
  private Drawable anH;
  private final int anI;
  View anJ;
  float anK;
  private float anL;
  int anM;
  int anN;
  private d anO;
  final c anP;
  boolean anQ;
  final ArrayList<b> anR;
  private Method anS;
  private Field anT;
  private boolean anU;
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
    AppMethodBeat.i(204678);
    this.anE = -858993460;
    this.mFirstLayout = true;
    this.Si = new Rect();
    this.anR = new ArrayList();
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.anI = ((int)(32.0F * f + 0.5F));
    setWillNotDraw(false);
    w.a(this, new a());
    w.p(this, 1);
    this.anP = c.a(this, 0.5F, new c());
    this.anP.Rr = (f * 400.0F);
    AppMethodBeat.o(204678);
  }
  
  private boolean mT()
  {
    AppMethodBeat.i(204701);
    if ((this.mFirstLayout) || (t(0.0F)))
    {
      this.anQ = false;
      AppMethodBeat.o(204701);
      return true;
    }
    AppMethodBeat.o(204701);
    return false;
  }
  
  private boolean t(float paramFloat)
  {
    AppMethodBeat.i(204706);
    if (!this.mCanSlide)
    {
      AppMethodBeat.o(204706);
      return false;
    }
    boolean bool = mU();
    LayoutParams localLayoutParams = (LayoutParams)this.anJ.getLayoutParams();
    int j;
    int k;
    if (bool)
    {
      i = getPaddingRight();
      j = localLayoutParams.rightMargin;
      k = this.anJ.getWidth();
    }
    for (int i = (int)(getWidth() - (j + i + this.anM * paramFloat + k)); this.anP.f(this.anJ, i, this.anJ.getTop()); i = (int)(localLayoutParams.leftMargin + i + this.anM * paramFloat))
    {
      mS();
      w.G(this);
      AppMethodBeat.o(204706);
      return true;
      i = getPaddingLeft();
    }
    AppMethodBeat.o(204706);
    return false;
  }
  
  final void a(View paramView, float paramFloat, int paramInt)
  {
    AppMethodBeat.i(204702);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if ((paramFloat > 0.0F) && (paramInt != 0))
    {
      int i = (int)(((0xFF000000 & paramInt) >>> 24) * paramFloat);
      if (localLayoutParams.anZ == null) {
        localLayoutParams.anZ = new Paint();
      }
      localLayoutParams.anZ.setColorFilter(new PorterDuffColorFilter(i << 24 | 0xFFFFFF & paramInt, PorterDuff.Mode.SRC_OVER));
      if (paramView.getLayerType() != 2) {
        paramView.setLayerType(2, localLayoutParams.anZ);
      }
      bx(paramView);
      AppMethodBeat.o(204702);
      return;
    }
    if (paramView.getLayerType() != 0)
    {
      if (localLayoutParams.anZ != null) {
        localLayoutParams.anZ.setColorFilter(null);
      }
      paramView = new b(paramView);
      this.anR.add(paramView);
      w.a(this, paramView);
    }
    AppMethodBeat.o(204702);
  }
  
  final void bw(View paramView)
  {
    AppMethodBeat.i(204682);
    boolean bool = mU();
    int i;
    int j;
    label36:
    int k;
    label68:
    int i1;
    int n;
    int m;
    label97:
    int i2;
    label106:
    Object localObject;
    if (bool)
    {
      i = getWidth() - getPaddingRight();
      if (!bool) {
        break label259;
      }
      j = getPaddingLeft();
      int i4 = getPaddingTop();
      int i5 = getHeight();
      int i6 = getPaddingBottom();
      if (paramView == null) {
        break label318;
      }
      if (!paramView.isOpaque()) {
        break label272;
      }
      k = 1;
      if (k == 0) {
        break label318;
      }
      i1 = paramView.getLeft();
      n = paramView.getRight();
      m = paramView.getTop();
      k = paramView.getBottom();
      int i7 = getChildCount();
      i2 = 0;
      if (i2 >= i7) {
        break label351;
      }
      localObject = getChildAt(i2);
      if (localObject == paramView) {
        break label351;
      }
      if (((View)localObject).getVisibility() != 8)
      {
        if (!bool) {
          break label333;
        }
        i3 = j;
        label145:
        int i8 = Math.max(i3, ((View)localObject).getLeft());
        int i9 = Math.max(i4, ((View)localObject).getTop());
        if (!bool) {
          break label339;
        }
        i3 = i;
        label177:
        i3 = Math.min(i3, ((View)localObject).getRight());
        int i10 = Math.min(i5 - i6, ((View)localObject).getBottom());
        if ((i8 < i1) || (i9 < m) || (i3 > n) || (i10 > k)) {
          break label345;
        }
      }
    }
    label259:
    label272:
    label318:
    label333:
    label339:
    label345:
    for (int i3 = 4;; i3 = 0)
    {
      ((View)localObject).setVisibility(i3);
      i2 += 1;
      break label106;
      i = getPaddingLeft();
      break;
      j = getWidth() - getPaddingRight();
      break label36;
      if (Build.VERSION.SDK_INT < 18)
      {
        localObject = paramView.getBackground();
        if (localObject != null)
        {
          if (((Drawable)localObject).getOpacity() == -1)
          {
            k = 1;
            break label68;
          }
          k = 0;
          break label68;
        }
      }
      k = 0;
      break label68;
      k = 0;
      m = 0;
      n = 0;
      i1 = 0;
      break label97;
      i3 = i;
      break label145;
      i3 = j;
      break label177;
    }
    label351:
    AppMethodBeat.o(204682);
  }
  
  final void bx(View paramView)
  {
    AppMethodBeat.i(204705);
    if (Build.VERSION.SDK_INT >= 17)
    {
      w.a(paramView, ((LayoutParams)paramView.getLayoutParams()).anZ);
      AppMethodBeat.o(204705);
      return;
    }
    if ((Build.VERSION.SDK_INT < 16) || (!this.anU)) {}
    try
    {
      this.anS = View.class.getDeclaredMethod("getDisplayList", null);
      try
      {
        label63:
        this.anT = View.class.getDeclaredField("mRecreateDisplayList");
        this.anT.setAccessible(true);
        label83:
        this.anU = true;
        if ((this.anS == null) || (this.anT == null))
        {
          paramView.invalidate();
          AppMethodBeat.o(204705);
          return;
        }
        try
        {
          this.anT.setBoolean(paramView, true);
          this.anS.invoke(paramView, null);
          label132:
          w.f(this, paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
          AppMethodBeat.o(204705);
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
  
  final boolean by(View paramView)
  {
    AppMethodBeat.i(204716);
    if (paramView == null)
    {
      AppMethodBeat.o(204716);
      return false;
    }
    paramView = (LayoutParams)paramView.getLayoutParams();
    if ((this.mCanSlide) && (paramView.anY) && (this.anK > 0.0F))
    {
      AppMethodBeat.o(204716);
      return true;
    }
    AppMethodBeat.o(204716);
    return false;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(204719);
    if (((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams)))
    {
      AppMethodBeat.o(204719);
      return true;
    }
    AppMethodBeat.o(204719);
    return false;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(204707);
    if (this.anP.hM())
    {
      if (!this.mCanSlide)
      {
        this.anP.hL();
        AppMethodBeat.o(204707);
        return;
      }
      w.G(this);
    }
    AppMethodBeat.o(204707);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(204714);
    super.draw(paramCanvas);
    Drawable localDrawable;
    if (mU())
    {
      localDrawable = this.anH;
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
      AppMethodBeat.o(204714);
      return;
      localDrawable = this.anG;
      break;
    }
    label71:
    int k = localView.getTop();
    int m = localView.getBottom();
    int n = localDrawable.getIntrinsicWidth();
    int j;
    int i;
    if (mU())
    {
      j = localView.getRight();
      i = j + n;
    }
    for (;;)
    {
      localDrawable.setBounds(j, k, i, m);
      localDrawable.draw(paramCanvas);
      AppMethodBeat.o(204714);
      return;
      i = localView.getLeft();
      j = i - n;
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    AppMethodBeat.i(204703);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = paramCanvas.save();
    if ((this.mCanSlide) && (!localLayoutParams.anX) && (this.anJ != null))
    {
      paramCanvas.getClipBounds(this.Si);
      if (!mU()) {
        break label116;
      }
      this.Si.left = Math.max(this.Si.left, this.anJ.getRight());
    }
    for (;;)
    {
      paramCanvas.clipRect(this.Si);
      boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
      paramCanvas.restoreToCount(i);
      AppMethodBeat.o(204703);
      return bool;
      label116:
      this.Si.right = Math.min(this.Si.right, this.anJ.getLeft());
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(204717);
    LayoutParams localLayoutParams = new LayoutParams();
    AppMethodBeat.o(204717);
    return localLayoutParams;
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(204720);
    paramAttributeSet = new LayoutParams(getContext(), paramAttributeSet);
    AppMethodBeat.o(204720);
    return paramAttributeSet;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(204718);
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      paramLayoutParams = new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
      AppMethodBeat.o(204718);
      return paramLayoutParams;
    }
    paramLayoutParams = new LayoutParams(paramLayoutParams);
    AppMethodBeat.o(204718);
    return paramLayoutParams;
  }
  
  public int getCoveredFadeColor()
  {
    return this.anF;
  }
  
  public int getParallaxDistance()
  {
    return this.anN;
  }
  
  public int getSliderFadeColor()
  {
    return this.anE;
  }
  
  final void mS()
  {
    AppMethodBeat.i(204685);
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
    AppMethodBeat.o(204685);
  }
  
  final boolean mU()
  {
    AppMethodBeat.i(204724);
    if (w.I(this) == 1)
    {
      AppMethodBeat.o(204724);
      return true;
    }
    AppMethodBeat.o(204724);
    return false;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(204686);
    super.onAttachedToWindow();
    this.mFirstLayout = true;
    AppMethodBeat.o(204686);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(204688);
    super.onDetachedFromWindow();
    this.mFirstLayout = true;
    int j = this.anR.size();
    int i = 0;
    while (i < j)
    {
      ((b)this.anR.get(i)).run();
      i += 1;
    }
    this.anR.clear();
    AppMethodBeat.o(204688);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(204699);
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
      this.anQ = bool;
      if ((this.mCanSlide) && ((!this.mIsUnableToDrag) || (i == 0))) {
        break;
      }
      this.anP.cancel();
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(204699);
      return bool;
    }
    if ((i == 3) || (i == 1))
    {
      this.anP.cancel();
      AppMethodBeat.o(204699);
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
        if ((!this.anP.i(paramMotionEvent)) && (i == 0)) {
          break label328;
        }
        AppMethodBeat.o(204699);
        return true;
        this.mIsUnableToDrag = false;
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        this.mInitialMotionX = f1;
        this.mInitialMotionY = f2;
        if ((!c.g(this.anJ, (int)f1, (int)f2)) || (!by(this.anJ))) {
          break;
        }
      }
      f2 = paramMotionEvent.getX();
      f1 = paramMotionEvent.getY();
      f2 = Math.abs(f2 - this.mInitialMotionX);
      f1 = Math.abs(f1 - this.mInitialMotionY);
    } while ((f2 <= this.anP.mTouchSlop) || (f1 <= f2));
    this.anP.cancel();
    this.mIsUnableToDrag = true;
    AppMethodBeat.o(204699);
    return false;
    label328:
    AppMethodBeat.o(204699);
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(204696);
    boolean bool = mU();
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
      this.anP.Rt = 2;
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
        if ((!this.mCanSlide) || (!this.anQ)) {
          break label381;
        }
        f = 1.0F;
        this.anK = f;
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
      if (!localLayoutParams.anX) {
        break label402;
      }
      i = localLayoutParams.leftMargin;
      int i2 = localLayoutParams.rightMargin;
      i2 = Math.min(paramInt1, k - paramInt3 - this.anI) - paramInt2 - (i + i2);
      this.anM = i2;
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
      localLayoutParams.anY = paramBoolean;
      i2 = (int)(i2 * this.anK);
      paramInt2 += i + i2;
      this.anK = (i2 / this.anM);
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
      this.anP.Rt = 1;
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
      if ((this.mCanSlide) && (this.anN != 0)) {}
      for (paramInt2 = (int)((1.0F - this.anK) * this.anN);; paramInt2 = 0)
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
          if (this.anN != 0) {
            u(this.anK);
          }
          if (((LayoutParams)this.anJ.getLayoutParams()).anY) {
            a(this.anJ, this.anK, this.anE);
          }
        }
        for (;;)
        {
          bw(this.anJ);
          this.mFirstLayout = false;
          AppMethodBeat.o(204696);
          return;
          label535:
          paramInt1 = 0;
          while (paramInt1 < m)
          {
            a(getChildAt(paramInt1), 0.0F, this.anE);
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
    AppMethodBeat.i(204695);
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
        this.anJ = null;
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
          localLayoutParams.anY = false;
          i1 += 1;
        }
        localObject = new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        AppMethodBeat.o(204695);
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
        AppMethodBeat.o(204695);
        throw ((Throwable)localObject);
        paramInt1 = paramInt1 - getPaddingTop() - getPaddingBottom();
        j = paramInt1;
        continue;
        j = paramInt1 - getPaddingTop() - getPaddingBottom();
        paramInt1 = k;
      }
      if (localLayoutParams.pO > 0.0F)
      {
        f = localLayoutParams.pO + f;
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
          localLayoutParams.anX = bool2;
          if (localLayoutParams.anX) {
            this.anJ = ((View)localObject);
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
          i1 = i2 - this.anI;
          m = 0;
          if (m < i3)
          {
            localObject = getChildAt(m);
            if (((View)localObject).getVisibility() != 8)
            {
              localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
              if (((View)localObject).getVisibility() != 8)
              {
                if ((localLayoutParams.width != 0) || (localLayoutParams.pO <= 0.0F)) {
                  break label761;
                }
                paramInt2 = 1;
                if (paramInt2 == 0) {
                  break label766;
                }
                n = 0;
                if ((!bool1) || (localObject == this.anJ)) {
                  break label827;
                }
                if ((localLayoutParams.width < 0) && ((n > i1) || (localLayoutParams.pO > 0.0F)))
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
              if (localLayoutParams.pO > 0.0F)
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
                ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.pO * i4 / f) + n, 1073741824), paramInt2);
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
        if ((this.anP.Rh != 0) && (!bool1)) {
          this.anP.hL();
        }
        AppMethodBeat.o(204695);
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
    AppMethodBeat.i(204723);
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(204723);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.Rb);
    if (paramParcelable.gZ) {
      if ((this.mFirstLayout) || (t(1.0F))) {
        this.anQ = true;
      }
    }
    for (;;)
    {
      this.anQ = paramParcelable.gZ;
      AppMethodBeat.o(204723);
      return;
      mT();
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(204722);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    boolean bool;
    if (this.mCanSlide) {
      if ((!this.mCanSlide) || (this.anK == 1.0F)) {
        bool = true;
      }
    }
    for (;;)
    {
      localSavedState.gZ = bool;
      AppMethodBeat.o(204722);
      return localSavedState;
      bool = false;
      continue;
      bool = this.anQ;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(204697);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      this.mFirstLayout = true;
    }
    AppMethodBeat.o(204697);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(204700);
    if (!this.mCanSlide)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(204700);
      return bool;
    }
    this.anP.j(paramMotionEvent);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(204700);
      return true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.mInitialMotionX = f1;
      this.mInitialMotionY = f2;
      continue;
      if (by(this.anJ))
      {
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        float f3 = f1 - this.mInitialMotionX;
        float f4 = f2 - this.mInitialMotionY;
        int i = this.anP.mTouchSlop;
        if ((f3 * f3 + f4 * f4 < i * i) && (c.g(this.anJ, (int)f1, (int)f2))) {
          mT();
        }
      }
    }
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    AppMethodBeat.i(204698);
    super.requestChildFocus(paramView1, paramView2);
    if ((!isInTouchMode()) && (!this.mCanSlide)) {
      if (paramView1 != this.anJ) {
        break label48;
      }
    }
    label48:
    for (boolean bool = true;; bool = false)
    {
      this.anQ = bool;
      AppMethodBeat.o(204698);
      return;
    }
  }
  
  public void setCoveredFadeColor(int paramInt)
  {
    this.anF = paramInt;
  }
  
  public void setPanelSlideListener(d paramd)
  {
    this.anO = paramd;
  }
  
  public void setParallaxDistance(int paramInt)
  {
    AppMethodBeat.i(204679);
    this.anN = paramInt;
    requestLayout();
    AppMethodBeat.o(204679);
  }
  
  @Deprecated
  public void setShadowDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(204708);
    setShadowDrawableLeft(paramDrawable);
    AppMethodBeat.o(204708);
  }
  
  public void setShadowDrawableLeft(Drawable paramDrawable)
  {
    this.anG = paramDrawable;
  }
  
  public void setShadowDrawableRight(Drawable paramDrawable)
  {
    this.anH = paramDrawable;
  }
  
  @Deprecated
  public void setShadowResource(int paramInt)
  {
    AppMethodBeat.i(204710);
    setShadowDrawable(getResources().getDrawable(paramInt));
    AppMethodBeat.o(204710);
  }
  
  public void setShadowResourceLeft(int paramInt)
  {
    AppMethodBeat.i(204711);
    setShadowDrawableLeft(androidx.core.content.a.m(getContext(), paramInt));
    AppMethodBeat.o(204711);
  }
  
  public void setShadowResourceRight(int paramInt)
  {
    AppMethodBeat.i(204712);
    setShadowDrawableRight(androidx.core.content.a.m(getContext(), paramInt));
    AppMethodBeat.o(204712);
  }
  
  public void setSliderFadeColor(int paramInt)
  {
    this.anE = paramInt;
  }
  
  final void u(float paramFloat)
  {
    AppMethodBeat.i(204715);
    boolean bool = mU();
    Object localObject = (LayoutParams)this.anJ.getLayoutParams();
    int i;
    label49:
    int j;
    if (((LayoutParams)localObject).anY) {
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
        if (localObject != this.anJ)
        {
          int k = (int)((1.0F - this.anL) * this.anN);
          this.anL = paramFloat;
          int m = k - (int)((1.0F - paramFloat) * this.anN);
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
    for (float f = this.anL - 1.0F;; f = 1.0F - this.anL)
    {
      a((View)localObject, f, this.anF);
      j += 1;
      break label58;
      i = ((LayoutParams)localObject).leftMargin;
      break;
      i = 0;
      break label49;
    }
    label198:
    AppMethodBeat.o(204715);
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    private static final int[] oG = { 16843137 };
    boolean anX;
    boolean anY;
    Paint anZ;
    public float pO;
    
    public LayoutParams()
    {
      super(-1);
      this.pO = 0.0F;
    }
    
    public LayoutParams(byte paramByte)
    {
      super(-1);
      this.pO = 0.0F;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(204640);
      this.pO = 0.0F;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, oG);
      this.pO = paramContext.getFloat(0, 0.0F);
      paramContext.recycle();
      AppMethodBeat.o(204640);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
      this.pO = 0.0F;
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
      this.pO = 0.0F;
    }
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    boolean gZ;
    
    static
    {
      AppMethodBeat.i(204662);
      CREATOR = new Parcelable.ClassLoaderCreator() {};
      AppMethodBeat.o(204662);
    }
    
    SavedState(Parcel paramParcel)
    {
      super(null);
      AppMethodBeat.i(204660);
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.gZ = bool;
        AppMethodBeat.o(204660);
        return;
      }
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(204661);
      super.writeToParcel(paramParcel, paramInt);
      if (this.gZ) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(204661);
        return;
      }
    }
  }
  
  final class a
    extends androidx.core.g.a
  {
    private final Rect Si;
    
    a()
    {
      AppMethodBeat.i(204587);
      this.Si = new Rect();
      AppMethodBeat.o(204587);
    }
    
    private boolean bz(View paramView)
    {
      AppMethodBeat.i(204593);
      boolean bool = SlidingPaneLayout.this.by(paramView);
      AppMethodBeat.o(204593);
      return bool;
    }
    
    public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(204591);
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
      AppMethodBeat.o(204591);
    }
    
    public final void onInitializeAccessibilityNodeInfo(View paramView, d paramd)
    {
      int j = 0;
      AppMethodBeat.i(204590);
      d locald = d.a(paramd);
      super.onInitializeAccessibilityNodeInfo(paramView, locald);
      Rect localRect = this.Si;
      locald.e(localRect);
      paramd.f(localRect);
      locald.g(localRect);
      paramd.h(localRect);
      paramd.Z(locald.hs());
      paramd.s(locald.Ov.getPackageName());
      paramd.t(locald.Ov.getClassName());
      paramd.setContentDescription(locald.Ov.getContentDescription());
      paramd.setEnabled(locald.Ov.isEnabled());
      paramd.setClickable(locald.Ov.isClickable());
      paramd.setFocusable(locald.Ov.isFocusable());
      paramd.Y(locald.Ov.isFocused());
      paramd.aa(locald.ht());
      paramd.setSelected(locald.Ov.isSelected());
      paramd.setLongClickable(locald.Ov.isLongClickable());
      paramd.bA(locald.Ov.getActions());
      if (Build.VERSION.SDK_INT >= 16) {}
      for (int i = locald.Ov.getMovementGranularities();; i = 0)
      {
        if (Build.VERSION.SDK_INT >= 16) {
          paramd.Ov.setMovementGranularities(i);
        }
        locald.Ov.recycle();
        paramd.t(SlidingPaneLayout.class.getName());
        paramd.ax(paramView);
        paramView = w.J(paramView);
        if ((paramView instanceof View)) {
          paramd.setParent((View)paramView);
        }
        int k = SlidingPaneLayout.this.getChildCount();
        i = j;
        while (i < k)
        {
          paramView = SlidingPaneLayout.this.getChildAt(i);
          if ((!bz(paramView)) && (paramView.getVisibility() == 0))
          {
            w.p(paramView, 1);
            paramd.ay(paramView);
          }
          i += 1;
        }
      }
      AppMethodBeat.o(204590);
    }
    
    public final boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(204592);
      if (!bz(paramView))
      {
        boolean bool = super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
        AppMethodBeat.o(204592);
        return bool;
      }
      AppMethodBeat.o(204592);
      return false;
    }
  }
  
  final class b
    implements Runnable
  {
    final View anW;
    
    b(View paramView)
    {
      this.anW = paramView;
    }
    
    public final void run()
    {
      AppMethodBeat.i(204604);
      if (this.anW.getParent() == SlidingPaneLayout.this)
      {
        this.anW.setLayerType(0, null);
        SlidingPaneLayout.this.bx(this.anW);
      }
      SlidingPaneLayout.this.anR.remove(this);
      AppMethodBeat.o(204604);
    }
  }
  
  final class c
    extends c.a
  {
    c() {}
    
    public final void G(int paramInt)
    {
      AppMethodBeat.i(204611);
      if (SlidingPaneLayout.this.anP.Rh == 0)
      {
        if (SlidingPaneLayout.this.anK == 0.0F)
        {
          SlidingPaneLayout.this.bw(SlidingPaneLayout.this.anJ);
          SlidingPaneLayout.this.sendAccessibilityEvent(32);
          SlidingPaneLayout.this.anQ = false;
          AppMethodBeat.o(204611);
          return;
        }
        SlidingPaneLayout.this.sendAccessibilityEvent(32);
        SlidingPaneLayout.this.anQ = true;
      }
      AppMethodBeat.o(204611);
    }
    
    public final void L(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(204620);
      SlidingPaneLayout.this.anP.x(SlidingPaneLayout.this.anJ, paramInt2);
      AppMethodBeat.o(204620);
    }
    
    public final void a(View paramView, float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(204614);
      SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)paramView.getLayoutParams();
      int i;
      int j;
      if (SlidingPaneLayout.this.mU())
      {
        i = SlidingPaneLayout.this.getPaddingRight();
        j = localLayoutParams.rightMargin + i;
        if (paramFloat1 >= 0.0F)
        {
          i = j;
          if (paramFloat1 == 0.0F)
          {
            i = j;
            if (SlidingPaneLayout.this.anK <= 0.5F) {}
          }
        }
        else
        {
          i = j + SlidingPaneLayout.this.anM;
        }
        j = SlidingPaneLayout.this.anJ.getWidth();
        i = SlidingPaneLayout.this.getWidth() - i - j;
      }
      for (;;)
      {
        SlidingPaneLayout.this.anP.I(i, paramView.getTop());
        SlidingPaneLayout.this.invalidate();
        AppMethodBeat.o(204614);
        return;
        i = SlidingPaneLayout.this.getPaddingLeft();
        j = localLayoutParams.leftMargin + i;
        if (paramFloat1 <= 0.0F)
        {
          i = j;
          if (paramFloat1 == 0.0F)
          {
            i = j;
            if (SlidingPaneLayout.this.anK <= 0.5F) {}
          }
        }
        else
        {
          i = j + SlidingPaneLayout.this.anM;
        }
      }
    }
    
    public final void a(View paramView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(204613);
      paramView = SlidingPaneLayout.this;
      if (paramView.anJ == null)
      {
        paramView.anK = 0.0F;
        SlidingPaneLayout.this.invalidate();
        AppMethodBeat.o(204613);
        return;
      }
      boolean bool = paramView.mU();
      SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)paramView.anJ.getLayoutParams();
      int i = paramView.anJ.getWidth();
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
        paramView.anK = ((paramInt2 - (i + paramInt1)) / paramView.anM);
        if (paramView.anN != 0) {
          paramView.u(paramView.anK);
        }
        if (!localLayoutParams.anY) {
          break;
        }
        paramView.a(paramView.anJ, paramView.anK, paramView.anE);
        break;
        paramInt1 = paramView.getPaddingLeft();
        break label89;
      }
    }
    
    public final int aC(View paramView)
    {
      return SlidingPaneLayout.this.anM;
    }
    
    public final boolean b(View paramView, int paramInt)
    {
      AppMethodBeat.i(204610);
      if (SlidingPaneLayout.this.mIsUnableToDrag)
      {
        AppMethodBeat.o(204610);
        return false;
      }
      boolean bool = ((SlidingPaneLayout.LayoutParams)paramView.getLayoutParams()).anX;
      AppMethodBeat.o(204610);
      return bool;
    }
    
    public final int c(View paramView, int paramInt)
    {
      AppMethodBeat.i(204619);
      paramInt = paramView.getTop();
      AppMethodBeat.o(204619);
      return paramInt;
    }
    
    public final int d(View paramView, int paramInt)
    {
      AppMethodBeat.i(204617);
      paramView = (SlidingPaneLayout.LayoutParams)SlidingPaneLayout.this.anJ.getLayoutParams();
      int i;
      int j;
      if (SlidingPaneLayout.this.mU())
      {
        i = SlidingPaneLayout.this.getWidth();
        j = SlidingPaneLayout.this.getPaddingRight();
        i -= paramView.rightMargin + j + SlidingPaneLayout.this.anJ.getWidth();
        j = SlidingPaneLayout.this.anM;
      }
      for (paramInt = Math.max(Math.min(paramInt, i), i - j);; paramInt = Math.min(Math.max(paramInt, i), j + i))
      {
        AppMethodBeat.o(204617);
        return paramInt;
        i = SlidingPaneLayout.this.getPaddingLeft();
        i = paramView.leftMargin + i;
        j = SlidingPaneLayout.this.anM;
      }
    }
    
    public final void z(View paramView, int paramInt)
    {
      AppMethodBeat.i(204612);
      SlidingPaneLayout.this.mS();
      AppMethodBeat.o(204612);
    }
  }
  
  public static abstract interface d {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.slidingpanelayout.widget.SlidingPaneLayout
 * JD-Core Version:    0.7.0.1
 */