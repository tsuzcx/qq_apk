package com.tencent.mobileqq.activity.recent;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Scroller;
import com.tencent.qphone.base.util.QLog;
import guw;
import gux;

public class DrawerFrame
  extends FrameLayout
{
  public static final int a = 0;
  public static final String a = "DrawerFrame";
  public static final int b = 1;
  public static final int c = 0;
  public static final int d = 1;
  public static final int e = 2;
  public static int f = 0;
  public static final int g = 1;
  public static final int h = 2;
  public static final int i = 3;
  public static final int j = 4;
  private static final int k = 300;
  private static final int l = 1;
  private static final int m = 2;
  private static final int n = 3;
  private static final int o = 4;
  private static final int p = 0;
  private static final int q = 1;
  private static final int r = 2;
  private int A;
  private int B;
  private int C;
  private int D;
  private int E;
  private int F;
  private int G;
  private int H;
  private int I = 0;
  private final float jdField_a_of_type_Float = 0.8F;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private DrawerFrame.IDrawerCallbacks jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks;
  private boolean jdField_a_of_type_Boolean = true;
  private final float jdField_b_of_type_Float = 0.7F;
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private boolean jdField_b_of_type_Boolean = false;
  private final float jdField_c_of_type_Float = 0.4F;
  private View jdField_c_of_type_AndroidViewView;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private boolean jdField_c_of_type_Boolean = false;
  private ViewGroup jdField_d_of_type_AndroidViewViewGroup;
  private boolean jdField_d_of_type_Boolean = false;
  private boolean e = true;
  private boolean f;
  private int s = 0;
  private int t;
  private int u;
  private int v;
  private int w;
  private int x;
  private int y;
  private int z;
  
  static
  {
    jdField_f_of_type_Int = 0;
  }
  
  public DrawerFrame(Context paramContext, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, View paramView, ViewGroup paramViewGroup3)
  {
    super(paramContext);
    this.jdField_f_of_type_Boolean = false;
    if (paramContext == null) {
      throw new NullPointerException("context is null");
    }
    Resources localResources = paramContext.getResources();
    DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
    this.F = 0;
    this.z = ((int)(localDisplayMetrics.density * 100.0F + 0.5D));
    this.B = localResources.getDimensionPixelSize(2131493278);
    this.u = localResources.getDimensionPixelSize(2131493329);
    this.A = 0;
    if (Build.VERSION.SDK_INT >= 11) {
      bool = true;
    }
    this.e = bool;
    this.jdField_a_of_type_AndroidOsHandler = new gux(this, Looper.getMainLooper());
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext, new DrawerFrame.SmoothInterpolator());
    a(paramViewGroup1, paramViewGroup2, paramView, paramViewGroup3);
    b(this.I, 1);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    this.F = 2;
    if (!this.jdField_b_of_type_Boolean)
    {
      b(paramInt, paramBoolean);
      return;
    }
    a(paramBoolean);
  }
  
  private void a(boolean paramBoolean)
  {
    if (!d()) {
      return;
    }
    Scroller localScroller;
    int i2;
    int i3;
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      this.jdField_c_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks.a(this.I);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks.a(this.I, false);
      }
      localScroller = this.jdField_a_of_type_AndroidWidgetScroller;
      i2 = this.s;
      i3 = -this.s;
      if (!paramBoolean) {
        break label148;
      }
    }
    label148:
    for (int i1 = 300;; i1 = 0)
    {
      localScroller.startScroll(i2, 0, i3, 0, i1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      return;
      if (this.jdField_b_of_type_Boolean) {
        break;
      }
      return;
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    int i2 = 0;
    int i1;
    if (paramInt2 == 1)
    {
      i1 = 8;
      if ((this.jdField_d_of_type_AndroidViewViewGroup != null) && (this.jdField_d_of_type_AndroidViewViewGroup.getVisibility() != i1)) {
        this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(i1);
      }
      if ((paramInt2 != 1) && (paramInt1 != 1)) {
        break label186;
      }
      i1 = 8;
      label50:
      if ((this.jdField_c_of_type_AndroidViewViewGroup != null) && (this.jdField_c_of_type_AndroidViewViewGroup.getVisibility() != i1)) {
        this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(i1);
      }
      if ((paramInt2 != 1) && (paramInt1 != 0)) {
        break label191;
      }
      paramInt1 = 8;
      label88:
      if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() != paramInt1)) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(paramInt1);
      }
      if (paramInt2 != 2) {
        break label196;
      }
      paramInt1 = 0;
      label121:
      if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() != paramInt1)) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(paramInt1);
      }
      if (paramInt2 != 0) {
        break label202;
      }
    }
    label186:
    label191:
    label196:
    label202:
    for (paramInt1 = i2;; paramInt1 = 8)
    {
      if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() != paramInt1)) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(paramInt1);
      }
      return;
      i1 = 0;
      break;
      i1 = 0;
      break label50;
      paramInt1 = 0;
      break label88;
      paramInt1 = 8;
      break label121;
    }
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    int i1 = 300;
    if (!d()) {
      return;
    }
    this.I = paramInt;
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      label56:
      if (this.I != 0) {
        break label156;
      }
      this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks.a(this.I);
      }
      switch (paramInt)
      {
      default: 
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks.a(paramInt, true);
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        return;
        if (!this.jdField_b_of_type_Boolean) {
          break label56;
        }
        return;
        label156:
        if (this.I == 1) {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
        break;
      }
    }
    Scroller localScroller = this.jdField_a_of_type_AndroidWidgetScroller;
    int i2 = this.s;
    int i3 = this.t;
    int i4 = this.s;
    if (paramBoolean) {}
    for (;;)
    {
      localScroller.startScroll(i2, 0, i3 - i4, 0, i1);
      break;
      i1 = 0;
    }
    localScroller = this.jdField_a_of_type_AndroidWidgetScroller;
    i2 = this.s;
    i3 = -this.u;
    i4 = this.s;
    if (paramBoolean) {}
    for (;;)
    {
      localScroller.startScroll(i2, 0, i3 - i4, 0, i1);
      break;
      i1 = 0;
    }
  }
  
  private boolean d()
  {
    return (this.jdField_a_of_type_Boolean) && (this.jdField_c_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup != null);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public DrawerFrame.IDrawerCallbacks a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks;
  }
  
  public void a()
  {
    a(0, true);
  }
  
  @TargetApi(11)
  public void a(int paramInt1, int paramInt2)
  {
    b(paramInt1, 2);
    float f1;
    float f5;
    float f2;
    label59:
    float f3;
    if (Build.VERSION.SDK_INT >= 11)
    {
      if (paramInt1 != 0) {
        break label249;
      }
      f1 = paramInt2 / this.t;
      float f4 = 1.0F - 0.2F * f1;
      f5 = 0.7F + 0.3F * f1;
      if (paramInt1 != 0) {
        break label262;
      }
      f2 = this.z * (f1 - 1.0F);
      if (paramInt1 != 0) {
        break label277;
      }
      f3 = 0.0F;
      label66:
      this.jdField_a_of_type_AndroidViewViewGroup.setPivotX(f3);
      this.jdField_a_of_type_AndroidViewViewGroup.setPivotY(this.jdField_a_of_type_AndroidViewViewGroup.getHeight() / 2.0F);
      if (this.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        this.jdField_a_of_type_AndroidViewViewGroup.setScaleX(f4);
        this.jdField_a_of_type_AndroidViewViewGroup.setScaleY(f4);
      }
      if (paramInt1 != 0) {
        break label290;
      }
    }
    label262:
    label277:
    label290:
    for (Object localObject = this.jdField_c_of_type_AndroidViewViewGroup;; localObject = this.jdField_a_of_type_AndroidViewView)
    {
      if (localObject != null)
      {
        ((View)localObject).setPivotX(((View)localObject).getWidth() / 2.0F);
        ((View)localObject).setPivotY(((View)localObject).getHeight() / 2.0F);
        ((View)localObject).setScaleX(f5);
        ((View)localObject).setScaleY(f5);
        ((View)localObject).setAlpha(0.4F + 0.6F * f1);
        ((View)localObject).setTranslationX(f2);
      }
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        if (this.jdField_b_of_type_AndroidViewView.getVisibility() != 0) {
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        }
        this.jdField_b_of_type_AndroidViewView.setAlpha(1.0F - f1);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks.a(this.I, f1);
      }
      return;
      label249:
      f1 = -paramInt2 / this.u;
      break;
      f2 = -this.z * (f1 - 1.0F);
      break label59;
      f3 = this.jdField_a_of_type_AndroidViewViewGroup.getWidth();
      break label66;
    }
  }
  
  public void a(ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, View paramView, ViewGroup paramViewGroup3)
  {
    if (paramViewGroup3 != this.jdField_d_of_type_AndroidViewViewGroup)
    {
      if (this.jdField_d_of_type_AndroidViewViewGroup != null) {
        removeView(this.jdField_d_of_type_AndroidViewViewGroup);
      }
      this.jdField_d_of_type_AndroidViewViewGroup = paramViewGroup3;
      if (this.jdField_d_of_type_AndroidViewViewGroup != null)
      {
        paramViewGroup3 = new FrameLayout.LayoutParams(-1, -1);
        addView(this.jdField_d_of_type_AndroidViewViewGroup, paramViewGroup3);
      }
    }
    if (paramViewGroup2 != this.jdField_c_of_type_AndroidViewViewGroup)
    {
      if (this.jdField_c_of_type_AndroidViewViewGroup != null) {
        removeView(this.jdField_c_of_type_AndroidViewViewGroup);
      }
      this.jdField_c_of_type_AndroidViewViewGroup = paramViewGroup2;
      if (this.jdField_c_of_type_AndroidViewViewGroup != null)
      {
        paramViewGroup2 = new FrameLayout.LayoutParams(-1, -1, 19);
        addView(this.jdField_c_of_type_AndroidViewViewGroup, paramViewGroup2);
      }
    }
    if (paramView != this.jdField_a_of_type_AndroidViewView)
    {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        removeView(this.jdField_a_of_type_AndroidViewView);
      }
      this.jdField_a_of_type_AndroidViewView = paramView;
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        paramViewGroup2 = new FrameLayout.LayoutParams(-2, -1, 21);
        addView(this.jdField_a_of_type_AndroidViewView, paramViewGroup2);
      }
    }
    if ((this.jdField_c_of_type_AndroidViewViewGroup != null) && (this.e))
    {
      if (this.jdField_b_of_type_AndroidViewView == null)
      {
        this.jdField_b_of_type_AndroidViewView = new View(getContext());
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130840563);
      }
      paramViewGroup2 = new FrameLayout.LayoutParams(-1, -1);
      addView(this.jdField_b_of_type_AndroidViewView, paramViewGroup2);
      if (paramViewGroup1 != this.jdField_a_of_type_AndroidViewViewGroup)
      {
        if (this.jdField_a_of_type_AndroidViewViewGroup != null)
        {
          removeView(this.jdField_a_of_type_AndroidViewViewGroup);
          if (this.jdField_b_of_type_AndroidViewViewGroup != null)
          {
            this.jdField_b_of_type_AndroidViewViewGroup.removeView(this);
            this.jdField_b_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidViewViewGroup);
            this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(null);
            this.jdField_b_of_type_AndroidViewViewGroup = null;
          }
        }
        this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup1;
        if (this.jdField_a_of_type_AndroidViewViewGroup != null)
        {
          paramViewGroup1 = this.jdField_a_of_type_AndroidViewViewGroup.getParent();
          if (!(paramViewGroup1 instanceof ViewGroup)) {
            break label526;
          }
          this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup1);
          this.jdField_b_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidViewViewGroup);
        }
      }
    }
    for (;;)
    {
      paramViewGroup1 = new FrameLayout.LayoutParams(-1, -1);
      addView(this.jdField_a_of_type_AndroidViewViewGroup, paramViewGroup1);
      if (this.jdField_b_of_type_AndroidViewViewGroup != null)
      {
        this.jdField_b_of_type_AndroidViewViewGroup.addView(this);
        this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(new guw(this));
      }
      if ((this.jdField_c_of_type_AndroidViewViewGroup != null) && (this.jdField_c_of_type_AndroidViewView == null))
      {
        this.jdField_c_of_type_AndroidViewView = new View(getContext());
        this.jdField_c_of_type_AndroidViewView.setFocusable(true);
        this.jdField_c_of_type_AndroidViewView.setFocusableInTouchMode(true);
        this.jdField_c_of_type_AndroidViewView.setClickable(true);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setBackgroundResource(17170445);
        this.jdField_c_of_type_AndroidViewView.setContentDescription("返回消息页面 双击返回");
        paramViewGroup1 = new FrameLayout.LayoutParams(this.t, this.C, 21);
        addView(this.jdField_c_of_type_AndroidViewView, paramViewGroup1);
      }
      this.jdField_f_of_type_Boolean = false;
      return;
      if (this.jdField_b_of_type_AndroidViewView == null) {
        break;
      }
      removeView(this.jdField_b_of_type_AndroidViewView);
      break;
      label526:
      this.jdField_b_of_type_AndroidViewViewGroup = null;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    a(1, true);
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void c()
  {
    b(0, true);
  }
  
  public boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void d()
  {
    b(1, true);
  }
  
  public void e()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DrawerFrame", 4, "resetDrawer()");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_c_of_type_Boolean = false;
    this.I = 0;
    this.s = 0;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.offsetLeftAndRight(0 - this.jdField_a_of_type_AndroidViewViewGroup.getLeft());
    }
    a(this.I, this.s);
    postInvalidate();
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
    }
    b(this.I, 1);
    jdField_f_of_type_Int = 0;
  }
  
  public void f()
  {
    a(true);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2;
    if (!d()) {
      bool2 = bool1;
    }
    int i1;
    do
    {
      do
      {
        do
        {
          do
          {
            return bool2;
            i1 = ViewConfiguration.get(getContext()).getScaledTouchSlop();
            i2 = (int)(paramMotionEvent.getX() + 0.5F);
            i3 = (int)(paramMotionEvent.getY() + 0.5F);
            switch (paramMotionEvent.getAction())
            {
            default: 
              return false;
            case 0: 
              this.w = i2;
              this.v = i2;
              this.y = i3;
              this.x = i3;
              if ((!this.jdField_b_of_type_Boolean) || (this.v > this.A)) {
                this.jdField_d_of_type_Boolean = true;
              }
              bool2 = bool1;
            }
          } while (!this.jdField_c_of_type_Boolean);
          if ((this.I == 0) && (this.v > this.s)) {
            break;
          }
          bool2 = bool1;
        } while (this.I != 1);
        bool2 = bool1;
      } while (this.v >= this.G + this.s);
      this.jdField_d_of_type_Boolean = true;
      return true;
      bool2 = bool1;
    } while (!this.jdField_d_of_type_Boolean);
    if ((!this.jdField_b_of_type_Boolean) && ((i2 < this.w) || (i2 < this.v)))
    {
      this.jdField_d_of_type_Boolean = false;
      return false;
    }
    this.w = i2;
    this.y = i3;
    int i2 = Math.abs(this.w - this.v);
    int i3 = Math.abs(this.y - this.x);
    if (this.jdField_b_of_type_Boolean)
    {
      bool1 = bool3;
      if (i2 > i1) {
        bool1 = true;
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      bool2 = bool1;
      if (!this.jdField_c_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      return bool1;
      bool1 = bool3;
      if (i2 > i1)
      {
        bool1 = bool3;
        if ((i3 + 0.0F) / i2 < 0.6F) {
          bool1 = true;
        }
      }
    }
    this.jdField_d_of_type_Boolean = false;
    if (((this.jdField_b_of_type_Boolean) && (this.I == 0) && (this.v > this.t)) || ((this.I == 1) && (this.v < this.G - this.u)))
    {
      this.F = 3;
      if ((this.x >= this.D) && (this.x <= this.E)) {
        this.F = 4;
      }
      f();
      this.w = -1;
      this.v = -1;
      this.y = -1;
      this.x = -1;
      return true;
    }
    this.w = -1;
    this.v = -1;
    this.y = -1;
    this.x = -1;
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.jdField_d_of_type_AndroidViewViewGroup != null) && (this.jdField_d_of_type_AndroidViewViewGroup.getVisibility() != 8)) {
      this.jdField_d_of_type_AndroidViewViewGroup.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    if ((this.jdField_c_of_type_AndroidViewViewGroup != null) && (this.jdField_c_of_type_AndroidViewViewGroup.getVisibility() != 8)) {
      this.jdField_c_of_type_AndroidViewViewGroup.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() != 8)) {
      this.jdField_a_of_type_AndroidViewView.layout(paramInt3 - this.u, this.D, paramInt3, this.E);
    }
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() != 8)) {
      this.jdField_b_of_type_AndroidViewView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() != 8)) {
      this.jdField_a_of_type_AndroidViewViewGroup.layout(this.jdField_a_of_type_AndroidViewViewGroup.getLeft(), this.jdField_a_of_type_AndroidViewViewGroup.getTop(), this.jdField_a_of_type_AndroidViewViewGroup.getLeft() + paramInt3, paramInt4);
    }
    if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() != 8))
    {
      if (this.I != 0) {
        break label246;
      }
      this.jdField_c_of_type_AndroidViewView.layout(this.t, this.D, this.t + this.B, this.E);
    }
    label246:
    while (this.I != 1) {
      return;
    }
    this.jdField_c_of_type_AndroidViewView.layout(0, this.D, paramInt3 - this.u, this.E);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.G = getMeasuredWidth();
    this.H = getMeasuredHeight();
    this.t = (this.G - this.B);
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.C = ((int)(this.H * 0.8F + 0.5D));
      this.D = ((int)(this.H * 0.2F / 2.0F));
    }
    for (this.E = (this.D + this.C);; this.E = (this.D + this.C))
    {
      this.jdField_a_of_type_AndroidViewView.getLayoutParams().height = this.C;
      return;
      this.C = this.H;
      this.D = 0;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!d()) {
      return false;
    }
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    int i1 = (int)(paramMotionEvent.getX() + 0.5F);
    int i2 = (int)(paramMotionEvent.getY() + 0.5F);
    int i3 = i1 - this.w;
    int i4 = this.y;
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    this.w = i1;
    this.y = i2;
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    case 0: 
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      }
    case 2: 
      this.jdField_c_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks.a(this.I);
      }
      this.F = 1;
      if ((this.I == 0) && (this.s + i3 > this.t)) {
        if (this.s != this.t)
        {
          this.jdField_b_of_type_Boolean = true;
          this.jdField_a_of_type_AndroidViewViewGroup.offsetLeftAndRight(this.t - this.s);
          this.s = this.t;
          a(this.I, this.s);
          invalidate();
        }
      }
      for (;;)
      {
        return true;
        if ((this.I == 0) && (this.s + i3 < 0))
        {
          if (this.s != 0)
          {
            this.jdField_b_of_type_Boolean = false;
            this.jdField_a_of_type_AndroidViewViewGroup.offsetLeftAndRight(0 - this.jdField_a_of_type_AndroidViewViewGroup.getLeft());
            this.s = 0;
            a(this.I, this.s);
            invalidate();
          }
        }
        else if ((this.I == 1) && (this.s + i3 < -this.u))
        {
          if (this.s != -this.u)
          {
            this.jdField_b_of_type_Boolean = true;
            this.jdField_a_of_type_AndroidViewViewGroup.offsetLeftAndRight(-this.u - this.s);
            this.s = (-this.u);
            a(this.I, this.s);
            invalidate();
          }
        }
        else if ((this.I == 1) && (this.s + i3 > 0))
        {
          if (this.s != 0)
          {
            this.jdField_b_of_type_Boolean = false;
            this.jdField_a_of_type_AndroidViewViewGroup.offsetLeftAndRight(0 - this.jdField_a_of_type_AndroidViewViewGroup.getLeft());
            this.s = 0;
            a(this.I, this.s);
            invalidate();
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidViewViewGroup.offsetLeftAndRight(i3);
          this.s += i3;
          a(this.I, this.s);
          invalidate();
        }
      }
    }
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
    if (Math.abs(this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity()) > localViewConfiguration.getScaledMinimumFlingVelocity()) {
      if (this.I == 0) {
        if (this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity() > 0.0F)
        {
          this.jdField_b_of_type_Boolean = false;
          c();
        }
      }
    }
    for (;;)
    {
      return true;
      this.jdField_b_of_type_Boolean = true;
      f();
      continue;
      if (this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity() < 0.0F)
      {
        this.jdField_b_of_type_Boolean = false;
        d();
      }
      else
      {
        this.jdField_b_of_type_Boolean = true;
        f();
        continue;
        if (this.I == 0)
        {
          if (this.s > this.G / 2.0D)
          {
            this.jdField_b_of_type_Boolean = false;
            c();
          }
          else
          {
            this.jdField_b_of_type_Boolean = true;
            f();
          }
        }
        else if (this.s < -(this.u / 3.0D * 2.0D))
        {
          this.jdField_b_of_type_Boolean = false;
          d();
        }
        else
        {
          this.jdField_b_of_type_Boolean = true;
          f();
        }
      }
    }
  }
  
  public void setDrawerCallbacks(DrawerFrame.IDrawerCallbacks paramIDrawerCallbacks)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks = paramIDrawerCallbacks;
  }
  
  public void setDrawerEnabled(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.DrawerFrame
 * JD-Core Version:    0.7.0.1
 */