package com.tencent.widget.pulltorefresh.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.widget.pulltorefresh.library.internal.LoadingLayout;
import lua;

public class PullToRefreshListView
  extends PullToRefreshAdapterViewBase
{
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private LoadingLayout jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout;
  private LoadingLayout b;
  private boolean c;
  
  public PullToRefreshListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PullToRefreshListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PullToRefreshListView(Context paramContext, PullToRefreshBase.Mode paramMode)
  {
    super(paramContext, paramMode);
  }
  
  public PullToRefreshListView(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.AnimationStyle paramAnimationStyle)
  {
    super(paramContext, paramMode, paramAnimationStyle);
  }
  
  protected ListView a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return new lua(this, paramContext, paramAttributeSet);
    }
    return new PullToRefreshListView.InternalListView(this, paramContext, paramAttributeSet);
  }
  
  protected LoadingLayoutProxy a(boolean paramBoolean1, boolean paramBoolean2)
  {
    LoadingLayoutProxy localLoadingLayoutProxy = super.a(paramBoolean1, paramBoolean2);
    if (this.c)
    {
      PullToRefreshBase.Mode localMode = b();
      if ((paramBoolean1) && (localMode.showHeaderLoadingLayout())) {
        localLoadingLayoutProxy.a(this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout);
      }
      if ((paramBoolean2) && (localMode.showFooterLoadingLayout())) {
        localLoadingLayoutProxy.a(this.b);
      }
    }
    return localLoadingLayoutProxy;
  }
  
  public final PullToRefreshBase.Orientation a()
  {
    return PullToRefreshBase.Orientation.VERTICAL;
  }
  
  protected void a(TypedArray paramTypedArray)
  {
    super.a(paramTypedArray);
    this.c = paramTypedArray.getBoolean(14, true);
    if (this.c)
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2, 1);
      FrameLayout localFrameLayout = new FrameLayout(getContext());
      this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout = a(getContext(), PullToRefreshBase.Mode.PULL_FROM_START, paramTypedArray);
      this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout.setVisibility(8);
      localFrameLayout.addView(this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout, localLayoutParams);
      ((ListView)this.jdField_a_of_type_AndroidViewView).addHeaderView(localFrameLayout, null, false);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(getContext());
      this.b = a(getContext(), PullToRefreshBase.Mode.PULL_FROM_END, paramTypedArray);
      this.b.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.b, localLayoutParams);
      if (!paramTypedArray.hasValue(13)) {
        setScrollingWhileRefreshingEnabled(true);
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    Object localObject = ((ListView)this.jdField_a_of_type_AndroidViewView).getAdapter();
    if ((!this.c) || (!c()) || (localObject == null) || (((ListAdapter)localObject).isEmpty()))
    {
      super.a(paramBoolean);
      return;
    }
    super.a(false);
    LoadingLayout localLoadingLayout1;
    LoadingLayout localLoadingLayout2;
    int i;
    int j;
    switch (ltz.a[a().ordinal()])
    {
    default: 
      localObject = b();
      localLoadingLayout1 = this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout;
      localLoadingLayout2 = this.b;
      i = getScrollY() + b();
      j = 0;
    }
    for (;;)
    {
      ((LoadingLayout)localObject).i();
      ((LoadingLayout)localObject).e();
      localLoadingLayout2.setVisibility(8);
      localLoadingLayout1.setVisibility(0);
      localLoadingLayout1.g();
      if (!paramBoolean) {
        break;
      }
      f();
      c(i);
      ((ListView)this.jdField_a_of_type_AndroidViewView).setSelection(j);
      d(0);
      return;
      localObject = a();
      localLoadingLayout1 = this.b;
      localLoadingLayout2 = this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout;
      j = ((ListView)this.jdField_a_of_type_AndroidViewView).getCount() - 1;
      i = getScrollY() - a();
    }
  }
  
  protected ListView b(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = a(paramContext, paramAttributeSet);
    paramContext.setId(16908298);
    return paramContext;
  }
  
  protected void d()
  {
    int j = 0;
    int i = 1;
    if (!this.c)
    {
      super.d();
      return;
    }
    LoadingLayout localLoadingLayout2;
    LoadingLayout localLoadingLayout1;
    int k;
    switch (ltz.a[a().ordinal()])
    {
    default: 
      localLoadingLayout2 = b();
      localLoadingLayout1 = this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryInternalLoadingLayout;
      k = -b();
      if (Math.abs(((ListView)this.jdField_a_of_type_AndroidViewView).getFirstVisiblePosition() - 0) > 1) {
        break;
      }
    }
    for (;;)
    {
      if (localLoadingLayout1.getVisibility() == 0)
      {
        localLoadingLayout2.j();
        localLoadingLayout1.setVisibility(8);
        if ((i != 0) && (a() != PullToRefreshBase.State.MANUAL_REFRESHING))
        {
          ((ListView)this.jdField_a_of_type_AndroidViewView).setSelection(j);
          c(k);
        }
      }
      super.d();
      return;
      localLoadingLayout2 = a();
      localLoadingLayout1 = this.b;
      j = ((ListView)this.jdField_a_of_type_AndroidViewView).getCount() - 1;
      k = a();
      if (Math.abs(((ListView)this.jdField_a_of_type_AndroidViewView).getLastVisiblePosition() - j) <= 1) {}
      for (i = 1;; i = 0) {
        break;
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.pulltorefresh.library.PullToRefreshListView
 * JD-Core Version:    0.7.0.1
 */