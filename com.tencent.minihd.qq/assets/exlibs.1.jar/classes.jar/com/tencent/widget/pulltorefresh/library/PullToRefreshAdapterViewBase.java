package com.tencent.widget.pulltorefresh.library;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import com.tencent.widget.pulltorefresh.library.internal.EmptyViewMethodAccessor;
import com.tencent.widget.pulltorefresh.library.internal.IndicatorLayout;

public abstract class PullToRefreshAdapterViewBase
  extends PullToRefreshBase
  implements AbsListView.OnScrollListener
{
  private AbsListView.OnScrollListener jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener;
  private PullToRefreshBase.OnLastItemVisibleListener jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$OnLastItemVisibleListener;
  private IndicatorLayout jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalIndicatorLayout;
  private View jdField_b_of_type_AndroidViewView;
  private IndicatorLayout jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryInternalIndicatorLayout;
  private boolean c;
  private boolean d;
  private boolean e = true;
  
  public PullToRefreshAdapterViewBase(Context paramContext)
  {
    super(paramContext);
    ((AbsListView)this.jdField_a_of_type_AndroidViewView).setOnScrollListener(this);
  }
  
  public PullToRefreshAdapterViewBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ((AbsListView)this.jdField_a_of_type_AndroidViewView).setOnScrollListener(this);
  }
  
  public PullToRefreshAdapterViewBase(Context paramContext, PullToRefreshBase.Mode paramMode)
  {
    super(paramContext, paramMode);
    ((AbsListView)this.jdField_a_of_type_AndroidViewView).setOnScrollListener(this);
  }
  
  public PullToRefreshAdapterViewBase(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.AnimationStyle paramAnimationStyle)
  {
    super(paramContext, paramMode, paramAnimationStyle);
    ((AbsListView)this.jdField_a_of_type_AndroidViewView).setOnScrollListener(this);
  }
  
  private static FrameLayout.LayoutParams a(ViewGroup.LayoutParams paramLayoutParams)
  {
    FrameLayout.LayoutParams localLayoutParams = null;
    if (paramLayoutParams != null)
    {
      localLayoutParams = new FrameLayout.LayoutParams(paramLayoutParams);
      if ((paramLayoutParams instanceof LinearLayout.LayoutParams)) {
        localLayoutParams.gravity = ((LinearLayout.LayoutParams)paramLayoutParams).gravity;
      }
    }
    else
    {
      return localLayoutParams;
    }
    localLayoutParams.gravity = 17;
    return localLayoutParams;
  }
  
  private void h()
  {
    Object localObject = b();
    FrameLayout localFrameLayout = a();
    if ((((PullToRefreshBase.Mode)localObject).showHeaderLoadingLayout()) && (this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalIndicatorLayout == null))
    {
      this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalIndicatorLayout = new IndicatorLayout(getContext(), PullToRefreshBase.Mode.PULL_FROM_START);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.rightMargin = getResources().getDimensionPixelSize(2131493510);
      localLayoutParams.gravity = 53;
      localFrameLayout.addView(this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalIndicatorLayout, localLayoutParams);
    }
    do
    {
      while ((((PullToRefreshBase.Mode)localObject).showFooterLoadingLayout()) && (this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryInternalIndicatorLayout == null))
      {
        this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryInternalIndicatorLayout = new IndicatorLayout(getContext(), PullToRefreshBase.Mode.PULL_FROM_END);
        localObject = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject).rightMargin = getResources().getDimensionPixelSize(2131493510);
        ((FrameLayout.LayoutParams)localObject).gravity = 85;
        localFrameLayout.addView(this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryInternalIndicatorLayout, (ViewGroup.LayoutParams)localObject);
        return;
        if ((!((PullToRefreshBase.Mode)localObject).showHeaderLoadingLayout()) && (this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalIndicatorLayout != null))
        {
          localFrameLayout.removeView(this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalIndicatorLayout);
          this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalIndicatorLayout = null;
        }
      }
    } while ((((PullToRefreshBase.Mode)localObject).showFooterLoadingLayout()) || (this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryInternalIndicatorLayout == null));
    localFrameLayout.removeView(this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryInternalIndicatorLayout);
    this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryInternalIndicatorLayout = null;
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalIndicatorLayout != null)
    {
      a().removeView(this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalIndicatorLayout);
      this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalIndicatorLayout = null;
    }
    if (this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryInternalIndicatorLayout != null)
    {
      a().removeView(this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryInternalIndicatorLayout);
      this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryInternalIndicatorLayout = null;
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalIndicatorLayout != null)
    {
      if ((f()) || (!i())) {
        break label77;
      }
      if (!this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalIndicatorLayout.a()) {
        this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalIndicatorLayout.b();
      }
    }
    label77:
    do
    {
      for (;;)
      {
        if (this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryInternalIndicatorLayout != null)
        {
          if ((f()) || (!j())) {
            break;
          }
          if (!this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryInternalIndicatorLayout.a()) {
            this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryInternalIndicatorLayout.b();
          }
        }
        return;
        if (this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalIndicatorLayout.a()) {
          this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalIndicatorLayout.a();
        }
      }
    } while (!this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryInternalIndicatorLayout.a());
    this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryInternalIndicatorLayout.a();
  }
  
  private boolean l()
  {
    return (this.d) && (d());
  }
  
  private boolean m()
  {
    Object localObject = ((AbsListView)this.jdField_a_of_type_AndroidViewView).getAdapter();
    if ((localObject == null) || (((Adapter)localObject).isEmpty()))
    {
      Log.d("PullToRefresh", "isFirstItemVisible. Empty View.");
      return true;
    }
    if (((AbsListView)this.jdField_a_of_type_AndroidViewView).getFirstVisiblePosition() <= 1)
    {
      localObject = ((AbsListView)this.jdField_a_of_type_AndroidViewView).getChildAt(0);
      if (localObject != null) {
        return ((View)localObject).getTop() >= ((AbsListView)this.jdField_a_of_type_AndroidViewView).getTop();
      }
    }
    return false;
  }
  
  private boolean n()
  {
    Object localObject = ((AbsListView)this.jdField_a_of_type_AndroidViewView).getAdapter();
    if ((localObject == null) || (((Adapter)localObject).isEmpty()))
    {
      Log.d("PullToRefresh", "isLastItemVisible. Empty View.");
      return true;
    }
    int j = ((AbsListView)this.jdField_a_of_type_AndroidViewView).getCount() - 1;
    int i = ((AbsListView)this.jdField_a_of_type_AndroidViewView).getLastVisiblePosition();
    Log.d("PullToRefresh", "isLastItemVisible. Last Item Position: " + j + " Last Visible Pos: " + i);
    if (i >= j - 1)
    {
      j = ((AbsListView)this.jdField_a_of_type_AndroidViewView).getFirstVisiblePosition();
      localObject = ((AbsListView)this.jdField_a_of_type_AndroidViewView).getChildAt(i - j);
      if (localObject != null) {
        return ((View)localObject).getBottom() <= ((AbsListView)this.jdField_a_of_type_AndroidViewView).getBottom();
      }
    }
    return false;
  }
  
  protected void a(TypedArray paramTypedArray)
  {
    if (!e()) {}
    for (boolean bool = true;; bool = false)
    {
      this.d = paramTypedArray.getBoolean(5, bool);
      return;
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (l()) {
      j();
    }
  }
  
  protected void b()
  {
    super.b();
    if (l()) {}
    switch (ltm.a[a().ordinal()])
    {
    default: 
      return;
    case 1: 
      this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryInternalIndicatorLayout.d();
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalIndicatorLayout.d();
  }
  
  protected void c()
  {
    super.c();
    if (l()) {}
    switch (ltm.a[a().ordinal()])
    {
    default: 
      return;
    case 1: 
      this.jdField_b_of_type_ComTencentWidgetPulltorefreshLibraryInternalIndicatorLayout.c();
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalIndicatorLayout.c();
  }
  
  protected void d()
  {
    super.d();
    if (l()) {
      j();
    }
  }
  
  protected void e()
  {
    super.e();
    if (l())
    {
      h();
      return;
    }
    i();
  }
  
  public boolean h()
  {
    return this.d;
  }
  
  protected boolean i()
  {
    return m();
  }
  
  protected boolean j()
  {
    return n();
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    Log.d("PullToRefresh", "First Visible: " + paramInt1 + ". Visible Count: " + paramInt2 + ". Total Items:" + paramInt3);
    if (this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$OnLastItemVisibleListener != null) {
      if ((paramInt3 <= 0) || (paramInt1 + paramInt2 < paramInt3 - 1)) {
        break label108;
      }
    }
    label108:
    for (boolean bool = true;; bool = false)
    {
      this.c = bool;
      if (l()) {
        j();
      }
      if (this.jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener != null) {
        this.jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      }
      return;
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.jdField_b_of_type_AndroidViewView != null) && (!this.e)) {
      this.jdField_b_of_type_AndroidViewView.scrollTo(-paramInt1, -paramInt2);
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$OnLastItemVisibleListener != null) && (this.c)) {
      this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$OnLastItemVisibleListener.a();
    }
    if (this.jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    ((AdapterView)this.jdField_a_of_type_AndroidViewView).setAdapter(paramListAdapter);
  }
  
  public final void setEmptyView(View paramView)
  {
    FrameLayout localFrameLayout = a();
    if (paramView != null)
    {
      paramView.setClickable(true);
      Object localObject = paramView.getParent();
      if ((localObject != null) && ((localObject instanceof ViewGroup))) {
        ((ViewGroup)localObject).removeView(paramView);
      }
      localObject = a(paramView.getLayoutParams());
      if (localObject != null) {
        localFrameLayout.addView(paramView, (ViewGroup.LayoutParams)localObject);
      }
    }
    else
    {
      if (!(this.jdField_a_of_type_AndroidViewView instanceof EmptyViewMethodAccessor)) {
        break label93;
      }
      ((EmptyViewMethodAccessor)this.jdField_a_of_type_AndroidViewView).setEmptyViewInternal(paramView);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView = paramView;
      return;
      localFrameLayout.addView(paramView);
      break;
      label93:
      ((AbsListView)this.jdField_a_of_type_AndroidViewView).setEmptyView(paramView);
    }
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    ((AbsListView)this.jdField_a_of_type_AndroidViewView).setOnItemClickListener(paramOnItemClickListener);
  }
  
  public final void setOnLastItemVisibleListener(PullToRefreshBase.OnLastItemVisibleListener paramOnLastItemVisibleListener)
  {
    this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$OnLastItemVisibleListener = paramOnLastItemVisibleListener;
  }
  
  public final void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener = paramOnScrollListener;
  }
  
  public final void setScrollEmptyView(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void setShowIndicator(boolean paramBoolean)
  {
    this.d = paramBoolean;
    if (l())
    {
      h();
      return;
    }
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.pulltorefresh.library.PullToRefreshAdapterViewBase
 * JD-Core Version:    0.7.0.1
 */