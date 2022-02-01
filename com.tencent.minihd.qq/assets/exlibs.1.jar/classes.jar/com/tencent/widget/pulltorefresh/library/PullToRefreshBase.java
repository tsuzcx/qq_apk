package com.tencent.widget.pulltorefresh.library;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.minihd.qq.R.styleable;
import com.tencent.widget.pulltorefresh.library.internal.LoadingLayout;
import com.tencent.widget.pulltorefresh.library.internal.Utils;
import ltn;
import lto;
import ltp;
import ltq;
import lts;
import ltt;

public abstract class PullToRefreshBase
  extends LinearLayout
  implements IPullToRefresh
{
  static final float jdField_a_of_type_Float = 2.0F;
  public static final int a = 200;
  static final String jdField_a_of_type_JavaLangString = "PullToRefresh";
  static final boolean jdField_a_of_type_Boolean = true;
  public static final int b = 325;
  static final String jdField_b_of_type_JavaLangString = "ptr_state";
  static final boolean jdField_b_of_type_Boolean = false;
  static final int jdField_c_of_type_Int = 225;
  static final String jdField_c_of_type_JavaLangString = "ptr_mode";
  static final String jdField_d_of_type_JavaLangString = "ptr_current_mode";
  static final String jdField_e_of_type_JavaLangString = "ptr_disable_scrolling";
  static final String jdField_f_of_type_JavaLangString = "ptr_show_refreshing_view";
  static final String jdField_g_of_type_JavaLangString = "ptr_super";
  public View a;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private PullToRefreshBase.AnimationStyle jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$AnimationStyle = PullToRefreshBase.AnimationStyle.getDefault();
  private PullToRefreshBase.Mode jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode = PullToRefreshBase.Mode.getDefault();
  private PullToRefreshBase.OnPullEventListener jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$OnPullEventListener;
  private PullToRefreshBase.OnRefreshListener2 jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$OnRefreshListener2;
  private PullToRefreshBase.OnRefreshListener jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$OnRefreshListener;
  private PullToRefreshBase.State jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$State = PullToRefreshBase.State.RESET;
  private LoadingLayout jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout;
  private ltt jdField_a_of_type_Ltt;
  private float jdField_b_of_type_Float;
  private PullToRefreshBase.Mode jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode;
  private LoadingLayout jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout;
  private float jdField_c_of_type_Float;
  private boolean jdField_c_of_type_Boolean = false;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = true;
  private float jdField_e_of_type_Float;
  private boolean jdField_e_of_type_Boolean = false;
  private boolean jdField_f_of_type_Boolean;
  private boolean jdField_g_of_type_Boolean;
  private boolean h = true;
  
  public PullToRefreshBase(Context paramContext)
  {
    super(paramContext);
    this.f = true;
    this.g = true;
    a(paramContext, null);
  }
  
  public PullToRefreshBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.f = true;
    this.g = true;
    a(paramContext, paramAttributeSet);
  }
  
  public PullToRefreshBase(Context paramContext, PullToRefreshBase.Mode paramMode)
  {
    super(paramContext);
    this.f = true;
    this.g = true;
    this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode = paramMode;
    a(paramContext, null);
  }
  
  public PullToRefreshBase(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.AnimationStyle paramAnimationStyle)
  {
    super(paramContext);
    this.f = true;
    this.g = true;
    this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode = paramMode;
    this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$AnimationStyle = paramAnimationStyle;
    a(paramContext, null);
  }
  
  private LinearLayout.LayoutParams a()
  {
    switch (ltr.a[a().ordinal()])
    {
    default: 
      return new LinearLayout.LayoutParams(-1, -2);
    }
    return new LinearLayout.LayoutParams(-2, -1);
  }
  
  private final void a(int paramInt, long paramLong)
  {
    a(paramInt, paramLong, 0L, null);
  }
  
  private final void a(int paramInt, long paramLong1, long paramLong2, lts paramlts)
  {
    if (this.jdField_a_of_type_Ltt != null) {
      this.jdField_a_of_type_Ltt.a();
    }
    switch (ltr.a[a().ordinal()])
    {
    }
    for (int i = getScrollY();; i = getScrollX())
    {
      if (i != paramInt)
      {
        if (this.jdField_a_of_type_AndroidViewAnimationInterpolator == null) {
          this.jdField_a_of_type_AndroidViewAnimationInterpolator = new DecelerateInterpolator();
        }
        this.jdField_a_of_type_Ltt = new ltt(this, i, paramInt, paramLong1, paramlts);
        if (paramLong2 <= 0L) {
          break;
        }
        postDelayed(this.jdField_a_of_type_Ltt, paramLong2);
      }
      return;
    }
    post(this.jdField_a_of_type_Ltt);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray;
    switch (ltr.a[a().ordinal()])
    {
    default: 
      setOrientation(1);
      setGravity(17);
      this.jdField_d_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
      localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.L);
      if (localTypedArray.hasValue(4)) {
        this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode = PullToRefreshBase.Mode.mapIntToValue(localTypedArray.getInteger(4, 0));
      }
      if (localTypedArray.hasValue(12)) {
        this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$AnimationStyle = PullToRefreshBase.AnimationStyle.mapIntToValue(localTypedArray.getInteger(12, 0));
      }
      this.jdField_a_of_type_AndroidViewView = a(paramContext, paramAttributeSet);
      a(paramContext, this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout = a(paramContext, PullToRefreshBase.Mode.PULL_FROM_START, localTypedArray);
      this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout = a(paramContext, PullToRefreshBase.Mode.PULL_FROM_END, localTypedArray);
      if (localTypedArray.hasValue(0))
      {
        paramContext = localTypedArray.getDrawable(0);
        if (paramContext != null) {
          this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(paramContext);
        }
      }
      break;
    }
    for (;;)
    {
      if (localTypedArray.hasValue(9)) {
        this.g = localTypedArray.getBoolean(9, true);
      }
      if (localTypedArray.hasValue(13)) {
        this.jdField_e_of_type_Boolean = localTypedArray.getBoolean(13, false);
      }
      a(localTypedArray);
      localTypedArray.recycle();
      e();
      return;
      setOrientation(0);
      break;
      if (localTypedArray.hasValue(16))
      {
        Utils.a("ptrAdapterViewBackground", "ptrRefreshableViewBackground");
        paramContext = localTypedArray.getDrawable(16);
        if (paramContext != null) {
          this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(paramContext);
        }
      }
    }
  }
  
  private void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramView, -1, -1);
    a(this.jdField_a_of_type_AndroidWidgetFrameLayout, new LinearLayout.LayoutParams(-1, -1));
  }
  
  private int e()
  {
    switch (ltr.a[a().ordinal()])
    {
    default: 
      return Math.round(getHeight() / 2.0F);
    }
    return Math.round(getWidth() / 2.0F);
  }
  
  private final void f(int paramInt)
  {
    a(paramInt, 200L, 0L, new ltq(this));
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$OnRefreshListener != null) {
      this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$OnRefreshListener.a(this);
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$OnRefreshListener2 == null);
      if (this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode == PullToRefreshBase.Mode.PULL_FROM_START)
      {
        this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$OnRefreshListener2.a(this);
        return;
      }
    } while (this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode != PullToRefreshBase.Mode.PULL_FROM_END);
    this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$OnRefreshListener2.b(this);
  }
  
  private boolean h()
  {
    switch (ltr.c[this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode.ordinal()])
    {
    }
    do
    {
      return false;
      return i();
      return j();
    } while ((!j()) && (!i()));
    return true;
  }
  
  private void i()
  {
    float f2;
    float f1;
    int j;
    int i;
    switch (ltr.a[a().ordinal()])
    {
    default: 
      f2 = this.jdField_e_of_type_Float;
      f1 = this.jdField_c_of_type_Float;
      switch (ltr.c[this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode.ordinal()])
      {
      default: 
        j = Math.round(Math.min(f2 - f1, 0.0F) / 2.0F);
        i = b();
        label87:
        c(j);
        if ((j != 0) && (!f()))
        {
          f1 = Math.abs(j) / i;
          switch (ltr.c[this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode.ordinal()])
          {
          default: 
            this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout.b(f1);
            label152:
            if ((this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$State != PullToRefreshBase.State.PULL_TO_REFRESH) && (i >= Math.abs(j))) {
              a(PullToRefreshBase.State.PULL_TO_REFRESH, new boolean[0]);
            }
            break;
          }
        }
        break;
      }
      break;
    }
    while ((this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$State != PullToRefreshBase.State.PULL_TO_REFRESH) || (i >= Math.abs(j)))
    {
      return;
      f2 = this.jdField_d_of_type_Float;
      f1 = this.jdField_b_of_type_Float;
      break;
      j = Math.round(Math.max(f2 - f1, 0.0F) / 2.0F);
      i = a();
      break label87;
      this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout.b(f1);
      break label152;
    }
    a(PullToRefreshBase.State.RELEASE_TO_REFRESH, new boolean[0]);
  }
  
  protected final int a()
  {
    return this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout.b();
  }
  
  public final View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  protected abstract View a(Context paramContext, AttributeSet paramAttributeSet);
  
  protected FrameLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetFrameLayout;
  }
  
  public final ILoadingLayout a()
  {
    return a(true, true);
  }
  
  public final ILoadingLayout a(boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramBoolean1, paramBoolean2);
  }
  
  protected LoadingLayoutProxy a(boolean paramBoolean1, boolean paramBoolean2)
  {
    LoadingLayoutProxy localLoadingLayoutProxy = new LoadingLayoutProxy();
    if ((paramBoolean1) && (this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode.showHeaderLoadingLayout())) {
      localLoadingLayoutProxy.a(this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout);
    }
    if ((paramBoolean2) && (this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode.showFooterLoadingLayout())) {
      localLoadingLayoutProxy.a(this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout);
    }
    return localLoadingLayoutProxy;
  }
  
  public final PullToRefreshBase.Mode a()
  {
    return this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode;
  }
  
  public abstract PullToRefreshBase.Orientation a();
  
  public final PullToRefreshBase.State a()
  {
    return this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$State;
  }
  
  protected final LoadingLayout a()
  {
    return this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout;
  }
  
  protected LoadingLayout a(Context paramContext, PullToRefreshBase.Mode paramMode, TypedArray paramTypedArray)
  {
    paramContext = this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$AnimationStyle.createLoadingLayout(paramContext, paramMode, a(), paramTypedArray);
    paramContext.setVisibility(4);
    return paramContext;
  }
  
  public final void a()
  {
    if (f()) {
      a(PullToRefreshBase.State.RESET, new boolean[0]);
    }
  }
  
  public final void a(int paramInt)
  {
    if (f()) {
      b(paramInt);
    }
  }
  
  protected final void a(int paramInt1, int paramInt2)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    switch (ltr.a[a().ordinal()])
    {
    }
    do
    {
      do
      {
        return;
      } while (localLayoutParams.width == paramInt1);
      localLayoutParams.width = paramInt1;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.requestLayout();
      return;
    } while (localLayoutParams.height == paramInt2);
    localLayoutParams.height = paramInt2;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.requestLayout();
  }
  
  protected final void a(int paramInt, lts paramlts)
  {
    a(paramInt, c(), 0L, paramlts);
  }
  
  protected void a(TypedArray paramTypedArray) {}
  
  protected void a(Bundle paramBundle) {}
  
  protected final void a(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  protected final void a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, -1, paramLayoutParams);
  }
  
  public final void a(PullToRefreshBase.State paramState, boolean... paramVarArgs)
  {
    this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$State = paramState;
    Log.d("PullToRefresh", "State: " + this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$State.name());
    switch (ltr.b[this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$State.ordinal()])
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$OnPullEventListener != null) {
        this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$OnPullEventListener.a(this, this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$State, this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode);
      }
      return;
      d();
      continue;
      b();
      continue;
      c();
      continue;
      a(paramVarArgs[0]);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode.showHeaderLoadingLayout()) {
      this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout.g();
    }
    if (this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode.showFooterLoadingLayout()) {
      this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout.g();
    }
    if (paramBoolean)
    {
      if (this.jdField_d_of_type_Boolean)
      {
        ltn localltn = new ltn(this);
        switch (ltr.c[this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode.ordinal()])
        {
        case 2: 
        default: 
          a(-b(), localltn);
          return;
        }
        a(a(), localltn);
        return;
      }
      d(0);
      return;
    }
    h();
  }
  
  public final boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode.showHeaderLoadingLayout()) && (i()))
    {
      f(-b() * 2);
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode.showFooterLoadingLayout()) && (j()))
    {
      f(a() * 2);
      return true;
    }
    return false;
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    Log.d("PullToRefresh", "addView: " + paramView.getClass().getSimpleName());
    View localView = a();
    if ((localView instanceof ViewGroup))
    {
      ((ViewGroup)localView).addView(paramView, paramInt, paramLayoutParams);
      return;
    }
    throw new UnsupportedOperationException("Refreshable View is not a ViewGroup so can't addView");
  }
  
  protected final int b()
  {
    return this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout.b();
  }
  
  public final PullToRefreshBase.Mode b()
  {
    return this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode;
  }
  
  protected final LoadingLayout b()
  {
    return this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout;
  }
  
  protected void b()
  {
    switch (ltr.c[this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode.ordinal()])
    {
    default: 
      return;
    case 1: 
      this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout.f();
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout.f();
  }
  
  protected void b(int paramInt)
  {
    int i = 0;
    this.jdField_c_of_type_Boolean = false;
    this.h = true;
    String str = "";
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout.a(str, paramInt);
      this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout.a(str, paramInt);
      postDelayed(new lto(this), 1000L);
      return;
      paramInt = 2130841568;
      str = getResources().getString(2131366942);
      continue;
      paramInt = 2130841566;
      str = getResources().getString(2131366939);
      continue;
      paramInt = 2130841567;
      str = getResources().getString(2131366939);
    }
  }
  
  protected void b(Bundle paramBundle) {}
  
  public final boolean b()
  {
    return this.f;
  }
  
  protected int c()
  {
    return 200;
  }
  
  protected void c()
  {
    switch (ltr.c[this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode.ordinal()])
    {
    default: 
      return;
    case 1: 
      this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout.h();
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout.h();
  }
  
  public final void c(int paramInt)
  {
    Log.d("PullToRefresh", "setHeaderScroll: " + paramInt);
    int i = e();
    paramInt = Math.min(i, Math.max(-i, paramInt));
    if (this.h)
    {
      if (paramInt >= 0) {
        break label97;
      }
      this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout.setVisibility(0);
    }
    for (;;)
    {
      switch (ltr.a[a().ordinal()])
      {
      default: 
        return;
        label97:
        if (paramInt > 0)
        {
          this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout.setVisibility(0);
        }
        else
        {
          this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout.setVisibility(4);
          this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout.setVisibility(4);
        }
        break;
      }
    }
    scrollTo(0, paramInt);
    return;
    scrollTo(paramInt, 0);
  }
  
  public final boolean c()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  protected int d()
  {
    return 325;
  }
  
  protected void d()
  {
    this.jdField_c_of_type_Boolean = false;
    this.h = true;
    this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout.i();
    this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout.i();
    d(0);
  }
  
  protected final void d(int paramInt)
  {
    a(paramInt, c());
  }
  
  public final boolean d()
  {
    return this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode.permitsPullToRefresh();
  }
  
  protected void e()
  {
    Object localObject = a();
    if (this == this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout.getParent()) {
      removeView(this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout);
    }
    if (this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode.showHeaderLoadingLayout()) {
      a(this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout, 0, (ViewGroup.LayoutParams)localObject);
    }
    if (this == this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout.getParent()) {
      removeView(this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout);
    }
    if (this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode.showFooterLoadingLayout()) {
      a(this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout, (ViewGroup.LayoutParams)localObject);
    }
    g();
    if (this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode != PullToRefreshBase.Mode.BOTH) {}
    for (localObject = this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode;; localObject = PullToRefreshBase.Mode.PULL_FROM_START)
    {
      this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode = ((PullToRefreshBase.Mode)localObject);
      return;
    }
  }
  
  protected final void e(int paramInt)
  {
    a(paramInt, d());
  }
  
  public final boolean e()
  {
    return (Build.VERSION.SDK_INT >= 9) && (this.g) && (OverscrollHelper.a(this.jdField_a_of_type_AndroidViewView));
  }
  
  protected final void f()
  {
    this.h = false;
  }
  
  public final boolean f()
  {
    return (this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$State == PullToRefreshBase.State.REFRESHING) || (this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$State == PullToRefreshBase.State.MANUAL_REFRESHING);
  }
  
  protected final void g()
  {
    int i1 = (int)(e() * 1.2F);
    int j = getPaddingLeft();
    int n = getPaddingTop();
    int k = getPaddingRight();
    int m = getPaddingBottom();
    int i;
    switch (ltr.a[a().ordinal()])
    {
    default: 
      i = m;
      i1 = k;
      k = n;
      m = j;
      j = i1;
    }
    for (;;)
    {
      Log.d("PullToRefresh", String.format("Setting Padding. L: %d, T: %d, R: %d, B: %d", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i) }));
      setPadding(m, k, j, i);
      return;
      if (this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode.showHeaderLoadingLayout()) {
        this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout.setWidth(i1);
      }
      for (i = -i1;; i = 0)
      {
        if (!this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode.showFooterLoadingLayout()) {
          break label205;
        }
        this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout.setWidth(i1);
        j = -i1;
        k = n;
        n = i;
        i = m;
        m = n;
        break;
      }
      label205:
      k = n;
      n = i;
      i = m;
      j = 0;
      m = n;
      continue;
      if (this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode.showHeaderLoadingLayout()) {
        this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout.setHeight(i1);
      }
      for (i = -i1;; i = 0)
      {
        if (!this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode.showFooterLoadingLayout()) {
          break label292;
        }
        this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout.setHeight(i1);
        i1 = -i1;
        m = j;
        n = i;
        i = i1;
        j = k;
        k = n;
        break;
      }
      label292:
      m = j;
      n = i;
      i = 0;
      j = k;
      k = n;
    }
  }
  
  public final boolean g()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  protected abstract boolean i();
  
  protected abstract boolean j();
  
  public final boolean k()
  {
    return !g();
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!d()) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 3) || (i == 1))
    {
      this.jdField_c_of_type_Boolean = false;
      return false;
    }
    if ((i != 0) && (this.jdField_c_of_type_Boolean)) {
      return true;
    }
    switch (i)
    {
    }
    for (;;)
    {
      return this.jdField_c_of_type_Boolean;
      if ((!this.jdField_e_of_type_Boolean) && (f())) {
        return true;
      }
      if (h())
      {
        float f3 = paramMotionEvent.getY();
        float f4 = paramMotionEvent.getX();
        float f2;
        switch (ltr.a[a().ordinal()])
        {
        default: 
          f2 = f3 - this.jdField_c_of_type_Float;
        }
        for (float f1 = f4 - this.jdField_b_of_type_Float;; f1 = f3 - this.jdField_c_of_type_Float)
        {
          float f5 = Math.abs(f2);
          if ((f5 <= this.jdField_d_of_type_Int) || ((this.f) && (f5 <= Math.abs(f1)))) {
            break;
          }
          if ((!this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode.showHeaderLoadingLayout()) || (f2 < 1.0F) || (!i())) {
            break label273;
          }
          this.jdField_c_of_type_Float = f3;
          this.jdField_b_of_type_Float = f4;
          this.jdField_c_of_type_Boolean = true;
          if (this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode != PullToRefreshBase.Mode.BOTH) {
            break;
          }
          this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode = PullToRefreshBase.Mode.PULL_FROM_START;
          break;
          f2 = f4 - this.jdField_b_of_type_Float;
        }
        label273:
        if ((this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode.showFooterLoadingLayout()) && (f2 <= -1.0F) && (j()))
        {
          this.jdField_c_of_type_Float = f3;
          this.jdField_b_of_type_Float = f4;
          this.jdField_c_of_type_Boolean = true;
          if (this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode == PullToRefreshBase.Mode.BOTH)
          {
            this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode = PullToRefreshBase.Mode.PULL_FROM_END;
            continue;
            if (h())
            {
              f1 = paramMotionEvent.getY();
              this.jdField_e_of_type_Float = f1;
              this.jdField_c_of_type_Float = f1;
              f1 = paramMotionEvent.getX();
              this.jdField_d_of_type_Float = f1;
              this.jdField_b_of_type_Float = f1;
              this.jdField_c_of_type_Boolean = false;
            }
          }
        }
      }
    }
  }
  
  protected final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      setMode(PullToRefreshBase.Mode.mapIntToValue(paramParcelable.getInt("ptr_mode", 0)));
      this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode = PullToRefreshBase.Mode.mapIntToValue(paramParcelable.getInt("ptr_current_mode", 0));
      this.jdField_e_of_type_Boolean = paramParcelable.getBoolean("ptr_disable_scrolling", false);
      this.jdField_d_of_type_Boolean = paramParcelable.getBoolean("ptr_show_refreshing_view", true);
      super.onRestoreInstanceState(paramParcelable.getParcelable("ptr_super"));
      PullToRefreshBase.State localState = PullToRefreshBase.State.mapIntToValue(paramParcelable.getInt("ptr_state", 0));
      if ((localState == PullToRefreshBase.State.REFRESHING) || (localState == PullToRefreshBase.State.MANUAL_REFRESHING)) {
        a(localState, new boolean[] { true });
      }
      a(paramParcelable);
      return;
    }
    super.onRestoreInstanceState(paramParcelable);
  }
  
  protected final Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    b(localBundle);
    localBundle.putInt("ptr_state", this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$State.getIntValue());
    localBundle.putInt("ptr_mode", this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode.getIntValue());
    localBundle.putInt("ptr_current_mode", this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode.getIntValue());
    localBundle.putBoolean("ptr_disable_scrolling", this.jdField_e_of_type_Boolean);
    localBundle.putBoolean("ptr_show_refreshing_view", this.jdField_d_of_type_Boolean);
    localBundle.putParcelable("ptr_super", super.onSaveInstanceState());
    return localBundle;
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Log.d("PullToRefresh", String.format("onSizeChanged. W: %d, H: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    g();
    a(paramInt1, paramInt2);
    post(new ltp(this));
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!d()) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
            if ((!this.jdField_e_of_type_Boolean) && (f())) {
              return true;
            }
          } while ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0));
          switch (paramMotionEvent.getAction())
          {
          default: 
            return false;
          }
        } while (!h());
        float f1 = paramMotionEvent.getY();
        this.jdField_e_of_type_Float = f1;
        this.jdField_c_of_type_Float = f1;
        f1 = paramMotionEvent.getX();
        this.jdField_d_of_type_Float = f1;
        this.jdField_b_of_type_Float = f1;
        return true;
      } while (!this.jdField_c_of_type_Boolean);
      this.jdField_c_of_type_Float = paramMotionEvent.getY();
      this.jdField_b_of_type_Float = paramMotionEvent.getX();
      i();
      return true;
    } while (!this.jdField_c_of_type_Boolean);
    this.jdField_c_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$State == PullToRefreshBase.State.RELEASE_TO_REFRESH) && ((this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$OnRefreshListener != null) || (this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$OnRefreshListener2 != null)))
    {
      a(PullToRefreshBase.State.REFRESHING, new boolean[] { true });
      return true;
    }
    if (f())
    {
      d(0);
      return true;
    }
    a(PullToRefreshBase.State.RESET, new boolean[0]);
    return true;
  }
  
  public void setDisableScrollingWhileRefreshing(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      setScrollingWhileRefreshingEnabled(paramBoolean);
      return;
    }
  }
  
  public final void setFilterTouchEvents(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void setLastUpdatedLabel(CharSequence paramCharSequence)
  {
    a().setLastUpdatedLabel(paramCharSequence);
  }
  
  public void setLoadingDrawable(Drawable paramDrawable)
  {
    a().setLoadingDrawable(paramDrawable);
  }
  
  public void setLoadingDrawable(Drawable paramDrawable, PullToRefreshBase.Mode paramMode)
  {
    a(paramMode.showHeaderLoadingLayout(), paramMode.showFooterLoadingLayout()).setLoadingDrawable(paramDrawable);
  }
  
  public void setLongClickable(boolean paramBoolean)
  {
    a().setLongClickable(paramBoolean);
  }
  
  public final void setMode(PullToRefreshBase.Mode paramMode)
  {
    if (paramMode != this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode)
    {
      Log.d("PullToRefresh", "Setting mode to: " + paramMode);
      this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode = paramMode;
      e();
    }
  }
  
  public void setOnPullEventListener(PullToRefreshBase.OnPullEventListener paramOnPullEventListener)
  {
    this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$OnPullEventListener = paramOnPullEventListener;
  }
  
  public final void setOnRefreshListener(PullToRefreshBase.OnRefreshListener2 paramOnRefreshListener2)
  {
    this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$OnRefreshListener2 = paramOnRefreshListener2;
    this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$OnRefreshListener = null;
  }
  
  public final void setOnRefreshListener(PullToRefreshBase.OnRefreshListener paramOnRefreshListener)
  {
    this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$OnRefreshListener = paramOnRefreshListener;
    this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$OnRefreshListener2 = null;
  }
  
  public void setPullLabel(CharSequence paramCharSequence)
  {
    a().setPullLabel(paramCharSequence);
  }
  
  public void setPullLabel(CharSequence paramCharSequence, PullToRefreshBase.Mode paramMode)
  {
    a(paramMode.showHeaderLoadingLayout(), paramMode.showFooterLoadingLayout()).setPullLabel(paramCharSequence);
  }
  
  public final void setPullToRefreshEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (PullToRefreshBase.Mode localMode = PullToRefreshBase.Mode.getDefault();; localMode = PullToRefreshBase.Mode.DISABLED)
    {
      setMode(localMode);
      return;
    }
  }
  
  public final void setPullToRefreshOverScrollEnabled(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public final void setRefreshing()
  {
    setRefreshing(true);
  }
  
  public final void setRefreshing(boolean paramBoolean)
  {
    if (!f()) {
      a(PullToRefreshBase.State.MANUAL_REFRESHING, new boolean[] { paramBoolean });
    }
  }
  
  public void setRefreshingLabel(CharSequence paramCharSequence)
  {
    a().setRefreshingLabel(paramCharSequence);
  }
  
  public void setRefreshingLabel(CharSequence paramCharSequence, PullToRefreshBase.Mode paramMode)
  {
    a(paramMode.showHeaderLoadingLayout(), paramMode.showFooterLoadingLayout()).setRefreshingLabel(paramCharSequence);
  }
  
  public void setReleaseLabel(CharSequence paramCharSequence)
  {
    setReleaseLabel(paramCharSequence, PullToRefreshBase.Mode.BOTH);
  }
  
  public void setReleaseLabel(CharSequence paramCharSequence, PullToRefreshBase.Mode paramMode)
  {
    a(paramMode.showHeaderLoadingLayout(), paramMode.showFooterLoadingLayout()).setReleaseLabel(paramCharSequence);
  }
  
  public void setScrollAnimationInterpolator(Interpolator paramInterpolator)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
  }
  
  public final void setScrollingWhileRefreshingEnabled(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public final void setShowViewWhileRefreshing(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.pulltorefresh.library.PullToRefreshBase
 * JD-Core Version:    0.7.0.1
 */