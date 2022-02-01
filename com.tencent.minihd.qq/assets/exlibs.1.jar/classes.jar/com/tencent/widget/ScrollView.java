package com.tencent.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.StrictMode;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ScrollView
  extends FrameLayout
{
  private static final int[] jdField_a_of_type_ArrayOfInt = a("ScrollView");
  static final float jdField_b_of_type_Float = 0.5F;
  public static boolean b = false;
  public static final int c = 0;
  public static final int d = 1;
  static final int jdField_e_of_type_Int = 250;
  private static final int l = -1;
  private static final int m = a("ScrollView_fillViewport");
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View jdField_a_of_type_AndroidViewView = null;
  private EdgeEffect jdField_a_of_type_ComTencentWidgetEdgeEffect;
  private OverScroller jdField_a_of_type_ComTencentWidgetOverScroller;
  private Object jdField_a_of_type_JavaLangObject = null;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private EdgeEffect jdField_b_of_type_ComTencentWidgetEdgeEffect;
  private Object jdField_b_of_type_JavaLangObject = null;
  private Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_c_of_type_Boolean = true;
  private boolean d = false;
  @ViewDebug.ExportedProperty(category="layout")
  private boolean jdField_e_of_type_Boolean;
  protected int f;
  private boolean f;
  protected int g;
  public int h = 0;
  private int i;
  private int j;
  private int k = -1;
  
  static
  {
    jdField_b_of_type_Boolean = false;
  }
  
  public ScrollView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842880);
  }
  
  public ScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_f_of_type_Boolean = true;
    b();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, jdField_a_of_type_ArrayOfInt, paramInt, 0);
    setFillViewport(paramContext.getBoolean(m, false));
    paramContext.recycle();
    setEdgeEffectEnabled(false);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int i1 = this.mScrollY;
    int n = i1;
    if (this.mScrollY > 0)
    {
      n = i1;
      if (this.mScrollY > paramInt2) {
        n = this.mScrollY - paramInt2;
      }
    }
    if (paramInt1 * n < 0) {
      return paramInt1;
    }
    return (getHeight() - Math.abs(n)) * paramInt1 / getHeight() / 2;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int n;
    if ((paramInt2 >= paramInt3) || (paramInt1 < 0)) {
      n = 0;
    }
    do
    {
      return n;
      n = paramInt1;
    } while (paramInt2 + paramInt1 <= paramInt3);
    return paramInt3 - paramInt2;
  }
  
  protected static int a(String paramString)
  {
    try
    {
      int n = Class.forName("com.android.internal.R$styleable").getField(paramString).getInt(null);
      return n;
    }
    catch (Exception paramString) {}
    return -1;
  }
  
  private View a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = getFocusables(2);
    Object localObject2 = null;
    int n = 0;
    int i4 = localArrayList.size();
    int i2 = 0;
    Object localObject1;
    int i3;
    int i5;
    int i1;
    if (i2 < i4)
    {
      localObject1 = (View)localArrayList.get(i2);
      i3 = ((View)localObject1).getTop();
      i5 = ((View)localObject1).getBottom();
      if ((paramInt1 >= i5) || (i3 >= paramInt2)) {
        break label192;
      }
      if ((paramInt1 < i3) && (i5 < paramInt2))
      {
        i1 = 1;
        label87:
        if (localObject2 != null) {
          break label115;
        }
        n = i1;
      }
    }
    for (;;)
    {
      i2 += 1;
      localObject2 = localObject1;
      break;
      i1 = 0;
      break label87;
      label115:
      if (((paramBoolean) && (i3 < localObject2.getTop())) || ((!paramBoolean) && (i5 > localObject2.getBottom()))) {}
      for (i3 = 1;; i3 = 0)
      {
        if (n == 0) {
          break label170;
        }
        if ((i1 == 0) || (i3 == 0)) {
          break label192;
        }
        break;
      }
      label170:
      if (i1 != 0)
      {
        n = 1;
      }
      else if (i3 != 0)
      {
        continue;
        return localObject2;
      }
      else
      {
        label192:
        localObject1 = localObject2;
      }
    }
  }
  
  private View a(boolean paramBoolean, int paramInt, View paramView)
  {
    int i1 = getVerticalFadingEdgeLength() / 2;
    int n = paramInt + i1;
    paramInt = getHeight() + paramInt - i1;
    if ((paramView != null) && (paramView.getTop() < paramInt) && (paramView.getBottom() > n)) {
      return paramView;
    }
    return a(paramBoolean, n, paramInt);
  }
  
  @TargetApi(9)
  private Object a(Object paramObject)
  {
    if (jdField_b_of_type_Boolean) {}
    try
    {
      paramObject.getClass().getMethod("finish", new Class[0]).invoke(paramObject, new Object[0]);
      label28:
      return null;
    }
    catch (Exception paramObject)
    {
      break label28;
    }
  }
  
  @TargetApi(9)
  private Object a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (jdField_b_of_type_Boolean) {
      localObject1 = localObject2;
    }
    try
    {
      if (VersionUtils.c()) {
        localObject1 = StrictMode.class.getMethod("enterCriticalSpan", new Class[] { String.class }).invoke(null, new Object[] { paramString });
      }
      return localObject1;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int n = (paramMotionEvent.getAction() & 0xFF00) >> 8;
    if (paramMotionEvent.getPointerId(n) == this.k) {
      if (n != 0) {
        break label62;
      }
    }
    label62:
    for (n = 1;; n = 0)
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getY(n);
      this.k = paramMotionEvent.getPointerId(n);
      if (this.jdField_a_of_type_AndroidViewVelocityTracker != null) {
        this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
      }
      return;
    }
  }
  
  private void a(View paramView)
  {
    paramView.getDrawingRect(this.jdField_a_of_type_AndroidGraphicsRect);
    offsetDescendantRectToMyCoords(paramView, this.jdField_a_of_type_AndroidGraphicsRect);
    int n = a(this.jdField_a_of_type_AndroidGraphicsRect);
    if (n != 0) {
      scrollBy(0, n);
    }
  }
  
  private boolean a()
  {
    boolean bool2 = false;
    View localView = getChildAt(0);
    boolean bool1 = bool2;
    if (localView != null)
    {
      int n = localView.getHeight();
      bool1 = bool2;
      if (getHeight() < n + this.mPaddingTop + this.mPaddingBottom) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (getChildCount() > 0)
    {
      int n = this.mScrollY;
      View localView = getChildAt(0);
      bool1 = bool2;
      if (paramInt2 >= localView.getTop() - n)
      {
        bool1 = bool2;
        if (paramInt2 < localView.getBottom() - n)
        {
          bool1 = bool2;
          if (paramInt1 >= localView.getLeft())
          {
            bool1 = bool2;
            if (paramInt1 < localView.getRight()) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = false;
    int i1 = getHeight();
    int n = getScrollY();
    i1 = n + i1;
    if (paramInt1 == 33) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      View localView = a(bool1, paramInt2, paramInt3);
      Object localObject = localView;
      if (localView == null) {
        localObject = this;
      }
      if ((paramInt2 < n) || (paramInt3 > i1)) {
        break;
      }
      bool1 = bool2;
      if (localObject != findFocus()) {
        ((View)localObject).requestFocus(paramInt1);
      }
      return bool1;
    }
    if (bool1) {
      paramInt2 -= n;
    }
    for (;;)
    {
      b(paramInt2);
      bool1 = true;
      break;
      paramInt2 = paramInt3 - i1;
    }
  }
  
  private boolean a(Rect paramRect, boolean paramBoolean)
  {
    int n = a(paramRect);
    if (n != 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        if (!paramBoolean) {
          break;
        }
        scrollBy(0, n);
      }
      return bool;
    }
    a(0, n);
    return bool;
  }
  
  private boolean a(View paramView)
  {
    boolean bool = false;
    if (!a(paramView, 0, getHeight())) {
      bool = true;
    }
    return bool;
  }
  
  private boolean a(View paramView, int paramInt1, int paramInt2)
  {
    paramView.getDrawingRect(this.jdField_a_of_type_AndroidGraphicsRect);
    offsetDescendantRectToMyCoords(paramView, this.jdField_a_of_type_AndroidGraphicsRect);
    return (this.jdField_a_of_type_AndroidGraphicsRect.bottom + paramInt1 >= getScrollY()) && (this.jdField_a_of_type_AndroidGraphicsRect.top - paramInt1 <= getScrollY() + paramInt2);
  }
  
  private boolean a(View paramView1, View paramView2)
  {
    if (paramView1 == paramView2) {
      return true;
    }
    paramView1 = paramView1.getParent();
    if (((paramView1 instanceof ViewGroup)) && (a((View)paramView1, paramView2))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected static int[] a(String paramString)
  {
    try
    {
      paramString = (int[])Class.forName("com.android.internal.R$styleable").getField(paramString).get(null);
      return paramString;
    }
    catch (Exception paramString) {}
    return new int[0];
  }
  
  private int b()
  {
    int n = 0;
    if (getChildCount() > 0) {
      n = Math.max(0, getChildAt(0).getHeight() - (getHeight() - this.mPaddingBottom - this.mPaddingTop));
    }
    return n;
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentWidgetOverScroller = new OverScroller(getContext());
    setFocusable(true);
    setDescendantFocusability(262144);
    setWillNotDraw(false);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    this.jdField_b_of_type_Int = localViewConfiguration.getScaledTouchSlop();
    this.i = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.j = localViewConfiguration.getScaledMaximumFlingVelocity();
    int n = (int)(getResources().getDisplayMetrics().density * 0.0F + 0.5F);
    this.g = n;
    this.jdField_f_of_type_Int = n;
    setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentWidgetOverScroller.a(0.005F);
  }
  
  private void b(int paramInt)
  {
    if (paramInt != 0)
    {
      if (this.jdField_f_of_type_Boolean) {
        a(0, paramInt);
      }
    }
    else {
      return;
    }
    scrollBy(0, paramInt);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
      return;
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  private void f()
  {
    this.d = false;
    e();
    if (this.jdField_a_of_type_ComTencentWidgetEdgeEffect != null)
    {
      this.jdField_a_of_type_ComTencentWidgetEdgeEffect.b();
      this.jdField_b_of_type_ComTencentWidgetEdgeEffect.b();
    }
    if (this.jdField_a_of_type_JavaLangObject != null) {
      a(this.jdField_a_of_type_JavaLangObject);
    }
  }
  
  public int a()
  {
    return (int)(0.5F * (this.mBottom - this.mTop));
  }
  
  protected int a(Rect paramRect)
  {
    if (getChildCount() == 0) {
      return 0;
    }
    int i3 = getHeight();
    int n = getScrollY();
    int i2 = n + i3;
    int i4 = getVerticalFadingEdgeLength();
    int i1 = n;
    if (paramRect.top > 0) {
      i1 = n + i4;
    }
    n = i2;
    if (paramRect.bottom < getChildAt(0).getHeight()) {
      n = i2 - i4;
    }
    if ((paramRect.bottom > n) && (paramRect.top > i1)) {
      if (paramRect.height() > i3)
      {
        i1 = paramRect.top - i1 + 0;
        n = Math.min(i1, getChildAt(0).getBottom() - n);
      }
    }
    for (;;)
    {
      return n;
      i1 = paramRect.bottom - n + 0;
      break;
      if ((paramRect.top < i1) && (paramRect.bottom < n))
      {
        if (paramRect.height() > i3) {}
        for (n = 0 - (n - paramRect.bottom);; n = 0 - (i1 - paramRect.top))
        {
          n = Math.max(n, -getScrollY());
          break;
        }
      }
      n = 0;
    }
  }
  
  @TargetApi(11)
  protected void a()
  {
    if ((VersionUtils.e()) && (isHardwareAccelerated()) && ((this.mParent instanceof View))) {
      ((View)this.mParent).invalidate();
    }
  }
  
  public void a(int paramInt)
  {
    if (getChildCount() > 0)
    {
      int n = getHeight() - this.mPaddingBottom - this.mPaddingTop;
      int i1 = getChildAt(0).getHeight();
      this.jdField_a_of_type_ComTencentWidgetOverScroller.a(this.mScrollX, this.mScrollY, 0, paramInt, 0, 0, 0, Math.max(0, i1 - n), 0, n / 4);
      if ((paramInt <= 0) || (this.jdField_b_of_type_JavaLangObject == null)) {
        this.jdField_b_of_type_JavaLangObject = a("ScrollView-fling");
      }
      invalidate();
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    if (getChildCount() == 0) {
      return;
    }
    if (AnimationUtils.currentAnimationTimeMillis() - this.jdField_a_of_type_Long > 250L)
    {
      paramInt1 = getHeight();
      int n = this.mPaddingBottom;
      int i1 = this.mPaddingTop;
      n = Math.max(0, getChildAt(0).getHeight() - (paramInt1 - n - i1));
      paramInt1 = this.mScrollY;
      paramInt2 = Math.max(0, Math.min(paramInt1 + paramInt2, n));
      this.jdField_a_of_type_ComTencentWidgetOverScroller.a(this.mScrollX, paramInt1, 0, paramInt2 - paramInt1);
      invalidate();
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
      return;
      if (!this.jdField_a_of_type_ComTencentWidgetOverScroller.a())
      {
        this.jdField_a_of_type_ComTencentWidgetOverScroller.a();
        if (this.jdField_b_of_type_JavaLangObject != null) {
          a(this.jdField_b_of_type_JavaLangObject);
        }
      }
      scrollBy(paramInt1, paramInt2);
    }
  }
  
  public boolean a(int paramInt)
  {
    int n;
    int i1;
    if (paramInt == 130)
    {
      n = 1;
      i1 = getHeight();
      if (n == 0) {
        break label121;
      }
      this.jdField_a_of_type_AndroidGraphicsRect.top = (getScrollY() + i1);
      n = getChildCount();
      if (n > 0)
      {
        View localView = getChildAt(n - 1);
        if (this.jdField_a_of_type_AndroidGraphicsRect.top + i1 > localView.getBottom()) {
          this.jdField_a_of_type_AndroidGraphicsRect.top = (localView.getBottom() - i1);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsRect.bottom = (this.jdField_a_of_type_AndroidGraphicsRect.top + i1);
      return a(paramInt, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
      n = 0;
      break;
      label121:
      this.jdField_a_of_type_AndroidGraphicsRect.top = (getScrollY() - i1);
      if (this.jdField_a_of_type_AndroidGraphicsRect.top < 0) {
        this.jdField_a_of_type_AndroidGraphicsRect.top = 0;
      }
    }
  }
  
  public boolean a(KeyEvent paramKeyEvent)
  {
    int n = 33;
    boolean bool2 = false;
    this.jdField_a_of_type_AndroidGraphicsRect.setEmpty();
    boolean bool1;
    if (!a())
    {
      bool1 = bool2;
      if (isFocused())
      {
        bool1 = bool2;
        if (paramKeyEvent.getKeyCode() != 4)
        {
          View localView = findFocus();
          paramKeyEvent = localView;
          if (localView == this) {
            paramKeyEvent = null;
          }
          paramKeyEvent = FocusFinder.getInstance().findNextFocus(this, paramKeyEvent, 130);
          if ((paramKeyEvent == null) || (paramKeyEvent == this) || (!paramKeyEvent.requestFocus(130))) {
            break label93;
          }
          bool1 = true;
        }
      }
    }
    label93:
    do
    {
      for (;;)
      {
        return bool1;
        bool1 = false;
      }
      bool1 = bool2;
    } while (paramKeyEvent.getAction() != 0);
    switch (paramKeyEvent.getKeyCode())
    {
    default: 
      return false;
    case 19: 
      if (!paramKeyEvent.isAltPressed()) {
        return c(33);
      }
      return b(33);
    case 20: 
      if (!paramKeyEvent.isAltPressed()) {
        return c(130);
      }
      return b(130);
    }
    if (paramKeyEvent.isShiftPressed()) {}
    for (;;)
    {
      a(n);
      return false;
      n = 130;
    }
  }
  
  public void addView(View paramView)
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("ScrollView can host only one direct child");
    }
    super.addView(paramView);
  }
  
  public void addView(View paramView, int paramInt)
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("ScrollView can host only one direct child");
    }
    super.addView(paramView, paramInt);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("ScrollView can host only one direct child");
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("ScrollView can host only one direct child");
    }
    super.addView(paramView, paramLayoutParams);
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    a(paramInt1 - this.mScrollX, paramInt2 - this.mScrollY);
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentWidgetOverScroller != null) {
      return this.jdField_a_of_type_ComTencentWidgetOverScroller.a();
    }
    return true;
  }
  
  public boolean b(int paramInt)
  {
    if (paramInt == 130) {}
    for (int n = 1;; n = 0)
    {
      int i1 = getHeight();
      this.jdField_a_of_type_AndroidGraphicsRect.top = 0;
      this.jdField_a_of_type_AndroidGraphicsRect.bottom = i1;
      if (n != 0)
      {
        n = getChildCount();
        if (n > 0)
        {
          View localView = getChildAt(n - 1);
          this.jdField_a_of_type_AndroidGraphicsRect.bottom = (localView.getBottom() + this.mPaddingBottom);
          this.jdField_a_of_type_AndroidGraphicsRect.top = (this.jdField_a_of_type_AndroidGraphicsRect.bottom - i1);
        }
      }
      return a(paramInt, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    }
  }
  
  public boolean c()
  {
    return this.e;
  }
  
  public boolean c(int paramInt)
  {
    View localView2 = findFocus();
    View localView1 = localView2;
    if (localView2 == this) {
      localView1 = null;
    }
    localView2 = FocusFinder.getInstance().findNextFocus(this, localView1, paramInt);
    int i1 = a();
    if ((localView2 != null) && (a(localView2, i1, getHeight())))
    {
      localView2.getDrawingRect(this.jdField_a_of_type_AndroidGraphicsRect);
      offsetDescendantRectToMyCoords(localView2, this.jdField_a_of_type_AndroidGraphicsRect);
      b(a(this.jdField_a_of_type_AndroidGraphicsRect));
      localView2.requestFocus(paramInt);
      if ((localView1 != null) && (localView1.isFocused()) && (a(localView1)))
      {
        paramInt = getDescendantFocusability();
        setDescendantFocusability(131072);
        requestFocus();
        setDescendantFocusability(paramInt);
      }
      return true;
    }
    int n;
    if ((paramInt == 33) && (getScrollY() < i1)) {
      n = getScrollY();
    }
    while (n == 0)
    {
      return false;
      n = i1;
      if (paramInt == 130)
      {
        n = i1;
        if (getChildCount() > 0)
        {
          int i2 = getChildAt(0).getBottom();
          int i3 = getScrollY() + getHeight() - this.mPaddingBottom;
          n = i1;
          if (i2 - i3 < i1) {
            n = i2 - i3;
          }
        }
      }
    }
    if (paramInt == 130) {}
    for (;;)
    {
      b(n);
      break;
      n = -n;
    }
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_ComTencentWidgetOverScroller.b())
    {
      i1 = this.mScrollX;
      i2 = this.mScrollY;
      i3 = this.jdField_a_of_type_ComTencentWidgetOverScroller.a();
      i4 = this.jdField_a_of_type_ComTencentWidgetOverScroller.b();
      if ((i1 != i3) || (i2 != i4))
      {
        i5 = b();
        n = getOverScrollMode();
        if ((n != 0) && ((n != 1) || (i5 <= 0))) {
          break label176;
        }
        n = 1;
        if ((i4 >= 0) && (i4 <= i5)) {
          break label208;
        }
        if (n == 0) {
          break label181;
        }
        overScrollBy(i3 - i1, i4 - i2, i1, i2, 0, i5, 0, this.g, false);
        onScrollChanged(this.mScrollX, this.mScrollY, i1, i2);
        if (n != 0)
        {
          if ((this.jdField_a_of_type_ComTencentWidgetEdgeEffect == null) || (i4 >= 0) || (i2 < 0)) {
            break label219;
          }
          this.jdField_a_of_type_ComTencentWidgetEdgeEffect.a((int)this.jdField_a_of_type_ComTencentWidgetOverScroller.a());
        }
      }
      awakenScrollBars();
      postInvalidate();
    }
    label176:
    label181:
    label208:
    label219:
    while (this.jdField_b_of_type_JavaLangObject == null) {
      for (;;)
      {
        int i1;
        int i2;
        int i3;
        int i4;
        int i5;
        return;
        int n = 0;
        continue;
        overScrollBy(i3 - i1, i4 - i2, i1, i2, 0, i5, 0, this.g, false);
        continue;
        scrollTo(i3, i4);
        continue;
        if ((this.jdField_a_of_type_ComTencentWidgetEdgeEffect != null) && (i4 > i5) && (i2 <= i5)) {
          this.jdField_b_of_type_ComTencentWidgetEdgeEffect.a((int)this.jdField_a_of_type_ComTencentWidgetOverScroller.a());
        }
      }
    }
    a(this.jdField_b_of_type_JavaLangObject);
  }
  
  protected int computeVerticalScrollOffset()
  {
    return Math.max(0, super.computeVerticalScrollOffset());
  }
  
  protected int computeVerticalScrollRange()
  {
    int i1 = getChildCount();
    int n = getHeight() - this.mPaddingBottom - this.mPaddingTop;
    if (i1 == 0) {}
    int i2;
    int i3;
    do
    {
      return n;
      i1 = getChildAt(0).getBottom();
      i2 = this.mScrollY;
      i3 = Math.max(0, i1 - n);
      if (i2 < 0) {
        return i1 - i2;
      }
      n = i1;
    } while (i2 <= i3);
    return i1 + (i2 - i3);
  }
  
  public boolean d()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    Drawable localDrawable;
    int i2;
    int n;
    int i1;
    if (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      localDrawable = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
      i2 = this.mScrollX;
      n = this.mScrollY;
      i1 = getWidth();
      localDrawable.setBounds(0, 0, getWidth(), getHeight());
      if ((i2 | n) != 0) {
        break label63;
      }
      localDrawable.draw(paramCanvas);
    }
    for (;;)
    {
      super.dispatchDraw(paramCanvas);
      return;
      label63:
      if (n < 0)
      {
        paramCanvas.translate(i2, 0.0F);
        localDrawable.draw(paramCanvas);
        paramCanvas.translate(-i2, 0.0F);
        localDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
        if (localDrawable != null)
        {
          i2 = localDrawable.getIntrinsicHeight();
          if (i2 < -n) {
            localDrawable.setBounds(new Rect(0, -i2, i1, 0));
          }
          for (;;)
          {
            localDrawable.draw(paramCanvas);
            break;
            localDrawable.setBounds(new Rect(0, n, i1, 0));
          }
        }
      }
      else
      {
        paramCanvas.translate(i2, n);
        localDrawable.draw(paramCanvas);
        paramCanvas.translate(-i2, -n);
      }
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyEvent(paramKeyEvent)) || (a(paramKeyEvent));
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.jdField_a_of_type_ComTencentWidgetEdgeEffect != null)
    {
      int n = this.mScrollY;
      int i1;
      int i2;
      int i3;
      if (!this.jdField_a_of_type_ComTencentWidgetEdgeEffect.a())
      {
        i1 = paramCanvas.save();
        i2 = getWidth();
        i3 = this.mPaddingLeft;
        int i4 = this.mPaddingRight;
        paramCanvas.translate(this.mPaddingLeft, Math.min(0, n));
        this.jdField_a_of_type_ComTencentWidgetEdgeEffect.a(i2 - i3 - i4, getHeight());
        if (this.jdField_a_of_type_ComTencentWidgetEdgeEffect.a(paramCanvas)) {
          invalidate();
        }
        paramCanvas.restoreToCount(i1);
      }
      if (!this.jdField_b_of_type_ComTencentWidgetEdgeEffect.a())
      {
        i1 = paramCanvas.save();
        i2 = getWidth() - this.mPaddingLeft - this.mPaddingRight;
        i3 = getHeight();
        paramCanvas.translate(-i2 + this.mPaddingLeft, Math.max(b(), n) + i3);
        paramCanvas.rotate(180.0F, i2, 0.0F);
        this.jdField_b_of_type_ComTencentWidgetEdgeEffect.a(i2, i3);
        if (this.jdField_b_of_type_ComTencentWidgetEdgeEffect.a(paramCanvas)) {
          invalidate();
        }
        paramCanvas.restoreToCount(i1);
      }
    }
  }
  
  protected float getBottomFadingEdgeStrength()
  {
    return 0.0F;
  }
  
  public int getOverScrollMode()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected float getTopFadingEdgeStrength()
  {
    return 0.0F;
  }
  
  protected void measureChild(View paramView, int paramInt1, int paramInt2)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    paramView.measure(getChildMeasureSpec(paramInt1, this.mPaddingLeft + this.mPaddingRight, localLayoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
  }
  
  protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    paramInt1 = getChildMeasureSpec(paramInt1, this.mPaddingLeft + this.mPaddingRight + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin + paramInt2, localMarginLayoutParams.width);
    paramInt2 = localMarginLayoutParams.topMargin;
    paramView.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(localMarginLayoutParams.bottomMargin + paramInt2, 0));
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_JavaLangObject != null) {
      a(this.jdField_b_of_type_JavaLangObject);
    }
    if (this.jdField_b_of_type_JavaLangObject != null) {
      a(this.jdField_b_of_type_JavaLangObject);
    }
  }
  
  @TargetApi(12)
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getSource() & 0x2) != 0) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      return super.onGenericMotionEvent(paramMotionEvent);
      if (!this.d)
      {
        float f1 = paramMotionEvent.getAxisValue(9);
        if (f1 != 0.0F)
        {
          int n = (int)(f1 * getVerticalScrollFactor());
          int i1 = b();
          int i3 = this.mScrollY;
          int i2 = i3 - n;
          if (i2 < 0) {
            n = 0;
          }
          while (n != i3)
          {
            super.scrollTo(this.mScrollX, n);
            return true;
            n = i1;
            if (i2 <= i1) {
              n = i2;
            }
          }
        }
      }
    }
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (b() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramAccessibilityEvent.setScrollable(bool);
      paramAccessibilityEvent.setScrollX(this.mScrollX);
      paramAccessibilityEvent.setScrollY(this.mScrollY);
      return;
    }
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    if (b() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramAccessibilityNodeInfo.setScrollable(bool);
      return;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    int n = paramMotionEvent.getAction();
    if ((n == 2) && (this.d)) {
      return true;
    }
    switch (n & 0xFF)
    {
    }
    for (;;)
    {
      return this.d;
      n = this.k;
      if (n != -1)
      {
        float f1 = paramMotionEvent.getY(paramMotionEvent.findPointerIndex(n));
        if ((int)Math.abs(f1 - this.jdField_a_of_type_Float) > this.jdField_b_of_type_Int)
        {
          this.d = true;
          this.jdField_a_of_type_Float = f1;
          d();
          this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
          if (this.jdField_a_of_type_JavaLangObject == null) {
            this.jdField_a_of_type_JavaLangObject = a("ScrollView-scroll");
          }
          paramMotionEvent = getParent();
          if (paramMotionEvent != null)
          {
            paramMotionEvent.requestDisallowInterceptTouchEvent(true);
            continue;
            f1 = paramMotionEvent.getY();
            if (!a((int)paramMotionEvent.getX(), (int)f1))
            {
              this.d = false;
              e();
            }
            else
            {
              this.jdField_a_of_type_Float = f1;
              this.k = paramMotionEvent.getPointerId(0);
              c();
              this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
              if (!this.jdField_a_of_type_ComTencentWidgetOverScroller.a()) {
                bool = true;
              }
              this.d = bool;
              if ((this.d) && (this.jdField_a_of_type_JavaLangObject == null))
              {
                this.jdField_a_of_type_JavaLangObject = a("ScrollView-scroll");
                continue;
                this.d = false;
                this.k = -1;
                e();
                if (this.jdField_a_of_type_ComTencentWidgetOverScroller.a(this.mScrollX, this.mScrollY, 0, 0, 0, b()))
                {
                  invalidate();
                  continue;
                  a(paramMotionEvent);
                }
              }
            }
          }
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_c_of_type_Boolean = false;
    if ((this.jdField_a_of_type_AndroidViewView != null) && (a(this.jdField_a_of_type_AndroidViewView, this))) {
      a(this.jdField_a_of_type_AndroidViewView);
    }
    this.jdField_a_of_type_AndroidViewView = null;
    scrollTo(this.mScrollX, this.mScrollY);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!this.e) {}
    View localView;
    do
    {
      do
      {
        return;
      } while ((View.MeasureSpec.getMode(paramInt2) == 0) || (getChildCount() <= 0));
      localView = getChildAt(0);
      paramInt2 = getMeasuredHeight();
    } while (localView.getMeasuredHeight() >= paramInt2);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
    localView.measure(getChildMeasureSpec(paramInt1, this.mPaddingLeft + this.mPaddingRight, localLayoutParams.width), View.MeasureSpec.makeMeasureSpec(paramInt2 - this.mPaddingTop - this.mPaddingBottom, 1073741824));
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.scrollTo(paramInt1, paramInt2);
    awakenScrollBars();
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int n;
    View localView;
    if (paramInt == 2)
    {
      n = 130;
      if (paramRect != null) {
        break label44;
      }
      localView = FocusFinder.getInstance().findNextFocus(this, null, n);
      label24:
      if (localView != null) {
        break label58;
      }
    }
    label44:
    label58:
    while (a(localView))
    {
      return false;
      n = paramInt;
      if (paramInt != 1) {
        break;
      }
      n = 33;
      break;
      localView = FocusFinder.getInstance().findNextFocusFromRect(this, paramRect, n);
      break label24;
    }
    return localView.requestFocus(n, paramRect);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = findFocus();
    if ((localView == null) || (this == localView)) {}
    while (!a(localView, 0, paramInt4)) {
      return;
    }
    localView.getDrawingRect(this.jdField_a_of_type_AndroidGraphicsRect);
    offsetDescendantRectToMyCoords(localView, this.jdField_a_of_type_AndroidGraphicsRect);
    b(a(this.jdField_a_of_type_AndroidGraphicsRect));
  }
  
  @TargetApi(8)
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    d();
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    int n;
    float f1;
    int i1;
    label267:
    int i3;
    int i4;
    int i2;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 4: 
    default: 
    case 0: 
    case 2: 
      do
      {
        do
        {
          bool = true;
          do
          {
            return bool;
          } while (getChildCount() == 0);
          if (!this.jdField_a_of_type_ComTencentWidgetOverScroller.a()) {}
          for (bool = true;; bool = false)
          {
            this.d = bool;
            if (bool)
            {
              ViewParent localViewParent = getParent();
              if (localViewParent != null) {
                localViewParent.requestDisallowInterceptTouchEvent(true);
              }
            }
            if (!this.jdField_a_of_type_ComTencentWidgetOverScroller.a())
            {
              this.jdField_a_of_type_ComTencentWidgetOverScroller.a();
              if (this.jdField_b_of_type_JavaLangObject != null) {
                a(this.jdField_b_of_type_JavaLangObject);
              }
            }
            this.jdField_a_of_type_Float = paramMotionEvent.getY();
            this.k = paramMotionEvent.getPointerId(0);
            break;
          }
          n = paramMotionEvent.findPointerIndex(this.k);
        } while (n == -1);
        f1 = paramMotionEvent.getY(n);
        i1 = (int)(this.jdField_a_of_type_Float - f1);
        n = i1;
        if (!this.d)
        {
          n = i1;
          if (Math.abs(i1) > this.jdField_b_of_type_Int)
          {
            paramMotionEvent = getParent();
            if (paramMotionEvent != null) {
              paramMotionEvent.requestDisallowInterceptTouchEvent(true);
            }
            this.d = true;
            if (i1 <= 0) {
              break;
            }
            n = i1 - this.jdField_b_of_type_Int;
          }
        }
      } while (!this.d);
      this.jdField_a_of_type_Float = f1;
      i3 = this.mScrollX;
      i4 = this.mScrollY;
      i2 = b();
      i1 = getOverScrollMode();
      if ((i1 == 0) || ((i1 == 1) && (i2 > 0)))
      {
        i1 = 1;
        label322:
        if ((this.mScrollY >= 0) && (this.mScrollY <= i2)) {
          break label866;
        }
        n = a(n, i2);
      }
      break;
    }
    label392:
    label548:
    label866:
    for (;;)
    {
      int i5 = this.mScrollY + n;
      if ((i5 < 0) || (i5 > i2)) {
        if (i1 != 0)
        {
          overScrollBy(0, n, 0, this.mScrollY, 0, i2, 0, this.jdField_f_of_type_Int, true);
          onScrollChanged(this.mScrollX, this.mScrollY, i3, i4);
          if ((i1 == 0) || (this.jdField_a_of_type_ComTencentWidgetEdgeEffect == null)) {
            break;
          }
          i1 = i4 + n;
          if (i1 >= 0) {
            break label548;
          }
          this.jdField_a_of_type_ComTencentWidgetEdgeEffect.a(n / getHeight());
          if (!this.jdField_b_of_type_ComTencentWidgetEdgeEffect.a()) {
            this.jdField_b_of_type_ComTencentWidgetEdgeEffect.b();
          }
        }
      }
      while ((this.jdField_a_of_type_ComTencentWidgetEdgeEffect != null) && ((!this.jdField_a_of_type_ComTencentWidgetEdgeEffect.a()) || (!this.jdField_b_of_type_ComTencentWidgetEdgeEffect.a())))
      {
        invalidate();
        break;
        n = i1 + this.jdField_b_of_type_Int;
        break label267;
        i1 = 0;
        break label322;
        overScrollBy(0, n, 0, this.mScrollY, 0, i2, 0, this.jdField_f_of_type_Int, true);
        break label392;
        scrollTo(0, i5);
        break label392;
        if (i1 > i2)
        {
          this.jdField_b_of_type_ComTencentWidgetEdgeEffect.a(n / getHeight());
          if (!this.jdField_a_of_type_ComTencentWidgetEdgeEffect.a()) {
            this.jdField_a_of_type_ComTencentWidgetEdgeEffect.b();
          }
        }
      }
      if (!this.d) {
        break;
      }
      paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
      paramMotionEvent.computeCurrentVelocity(1000, this.j);
      if (VersionUtils.b())
      {
        f1 = paramMotionEvent.getYVelocity(this.k);
        label629:
        n = (int)f1;
        if (getChildCount() > 0)
        {
          if (Math.abs(n) <= this.i) {
            break label676;
          }
          a(-n);
        }
      }
      for (;;)
      {
        this.k = -1;
        f();
        break;
        f1 = paramMotionEvent.getYVelocity();
        break label629;
        if (this.jdField_a_of_type_ComTencentWidgetOverScroller.a(this.mScrollX, this.mScrollY, 0, 0, 0, b())) {
          invalidate();
        }
      }
      if ((!this.d) || (getChildCount() <= 0)) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentWidgetOverScroller.a(this.mScrollX, this.mScrollY, 0, 0, 0, this.jdField_f_of_type_Int)) {
        invalidate();
      }
      this.k = -1;
      f();
      break;
      n = (paramMotionEvent.getAction() & 0xFF00) >> 8;
      this.jdField_a_of_type_Float = paramMotionEvent.getY(n);
      this.k = paramMotionEvent.getPointerId(n);
      break;
      a(paramMotionEvent);
      n = paramMotionEvent.findPointerIndex(this.k);
      if ((n < paramMotionEvent.getPointerCount()) && (-1 != n))
      {
        this.jdField_a_of_type_Float = paramMotionEvent.getY(n);
        break;
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("ScrollView", 4, String.format("Pointer Index %d out of range!", new Object[] { Integer.valueOf(n) }));
      break;
    }
  }
  
  protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    int i2 = this.jdField_a_of_type_Int;
    int n;
    int i1;
    if (computeHorizontalScrollRange() > computeHorizontalScrollExtent())
    {
      n = 1;
      if (computeVerticalScrollRange() <= computeVerticalScrollExtent()) {
        break label188;
      }
      i1 = 1;
      label34:
      if ((i2 != 0) && ((i2 != 1) || (n == 0))) {
        break label194;
      }
      n = 1;
      label53:
      if ((i2 != 0) && ((i2 != 1) || (i1 == 0))) {
        break label200;
      }
      i1 = 1;
      label72:
      i2 = paramInt3 + paramInt1;
      if (n == 0) {
        paramInt7 = 0;
      }
      paramInt4 += paramInt2;
      if (i1 == 0) {
        paramInt8 = 0;
      }
      n = -paramInt7;
      if (paramInt7 != 2147483647) {
        break label206;
      }
      paramInt1 = 2147483647;
      label116:
      paramInt3 = -paramInt8;
      if (paramInt8 != 2147483647) {
        break label215;
      }
      paramInt2 = 2147483647;
      label132:
      if (this.h == 1) {
        paramInt3 = 0;
      }
      if (i2 <= paramInt1) {
        break label224;
      }
      paramBoolean = true;
    }
    for (;;)
    {
      label151:
      boolean bool;
      if (paramInt4 > paramInt2) {
        bool = true;
      }
      for (;;)
      {
        onOverScrolled(paramInt1, paramInt2, paramBoolean, bool);
        if ((paramBoolean) || (bool))
        {
          return true;
          n = 0;
          break;
          label188:
          i1 = 0;
          break label34;
          label194:
          n = 0;
          break label53;
          label200:
          i1 = 0;
          break label72;
          label206:
          paramInt1 = paramInt7 + paramInt5;
          break label116;
          label215:
          paramInt2 = paramInt8 + paramInt6;
          break label132;
          label224:
          if (i2 >= n) {
            break label265;
          }
          paramBoolean = true;
          paramInt1 = n;
          break label151;
          if (paramInt4 >= paramInt3) {
            break label256;
          }
          bool = true;
          paramInt2 = paramInt3;
          continue;
        }
        return false;
        label256:
        bool = false;
        paramInt2 = paramInt4;
      }
      label265:
      paramBoolean = false;
      paramInt1 = i2;
    }
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    if (!this.jdField_c_of_type_Boolean) {
      a(paramView2);
    }
    for (;;)
    {
      super.requestChildFocus(paramView1, paramView2);
      return;
      this.jdField_a_of_type_AndroidViewView = paramView2;
    }
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    paramRect.offset(paramView.getLeft() - paramView.getScrollX(), paramView.getTop() - paramView.getScrollY());
    return a(paramRect, paramBoolean);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (paramBoolean) {
      e();
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    this.jdField_c_of_type_Boolean = true;
    super.requestLayout();
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      paramInt1 = a(paramInt1, getWidth() - this.mPaddingRight - this.mPaddingLeft, localView.getWidth());
      paramInt2 = a(paramInt2, getHeight() - this.mPaddingBottom - this.mPaddingTop, localView.getHeight());
      if ((paramInt1 != this.mScrollX) || (paramInt2 != this.mScrollY)) {
        super.scrollTo(paramInt1, paramInt2);
      }
    }
  }
  
  public void setContentBackground(Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
      return;
    }
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838521);
  }
  
  public void setEdgeEffectEnabled(boolean paramBoolean)
  {
    Context localContext;
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      if (!paramBoolean) {
        break label62;
      }
      if ((this.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_ComTencentWidgetEdgeEffect == null))
      {
        localContext = getContext();
        this.jdField_a_of_type_ComTencentWidgetEdgeEffect = new EdgeEffect(localContext);
      }
    }
    for (this.jdField_b_of_type_ComTencentWidgetEdgeEffect = new EdgeEffect(localContext);; this.jdField_b_of_type_ComTencentWidgetEdgeEffect = null)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
      label62:
      this.jdField_a_of_type_ComTencentWidgetEdgeEffect = null;
    }
  }
  
  public void setFillViewport(boolean paramBoolean)
  {
    if (paramBoolean != this.e)
    {
      this.e = paramBoolean;
      requestLayout();
    }
  }
  
  public void setForeground(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != paramDrawable)
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(null);
        unscheduleDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      if (paramDrawable == null) {
        break label75;
      }
      setWillNotDraw(false);
      paramDrawable.setCallback(this);
      if (paramDrawable.isStateful()) {
        paramDrawable.setState(getDrawableState());
      }
    }
    for (;;)
    {
      requestLayout();
      invalidate();
      return;
      label75:
      setWillNotDraw(true);
    }
  }
  
  public void setOverScrollMode(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2)) {
      throw new IllegalArgumentException("Invalid overscroll mode " + paramInt);
    }
    Context localContext;
    if (paramInt != 2) {
      if ((this.jdField_a_of_type_ComTencentWidgetEdgeEffect == null) && (this.jdField_a_of_type_Boolean)) {
        localContext = getContext();
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentWidgetEdgeEffect = new EdgeEffect(localContext);
      this.jdField_b_of_type_ComTencentWidgetEdgeEffect = new EdgeEffect(localContext);
      label90:
      this.g = 2147483647;
      this.jdField_f_of_type_Int = 2147483647;
      for (;;)
      {
        this.jdField_a_of_type_Int = paramInt;
        return;
        this.jdField_a_of_type_ComTencentWidgetEdgeEffect = null;
        this.jdField_b_of_type_ComTencentWidgetEdgeEffect = null;
      }
    }
    catch (Throwable localThrowable)
    {
      break label90;
    }
  }
  
  public void setSmoothScrollingEnabled(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.ScrollView
 * JD-Core Version:    0.7.0.1
 */