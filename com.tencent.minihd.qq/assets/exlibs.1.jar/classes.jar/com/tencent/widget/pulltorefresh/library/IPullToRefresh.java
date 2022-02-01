package com.tencent.widget.pulltorefresh.library;

import android.view.View;
import android.view.animation.Interpolator;

public abstract interface IPullToRefresh
{
  public abstract View a();
  
  public abstract ILoadingLayout a();
  
  public abstract ILoadingLayout a(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract PullToRefreshBase.Mode a();
  
  public abstract PullToRefreshBase.State a();
  
  public abstract void a();
  
  public abstract boolean a();
  
  public abstract PullToRefreshBase.Mode b();
  
  public abstract boolean b();
  
  public abstract boolean c();
  
  public abstract boolean d();
  
  public abstract boolean e();
  
  public abstract boolean f();
  
  public abstract boolean g();
  
  public abstract void setFilterTouchEvents(boolean paramBoolean);
  
  public abstract void setMode(PullToRefreshBase.Mode paramMode);
  
  public abstract void setOnPullEventListener(PullToRefreshBase.OnPullEventListener paramOnPullEventListener);
  
  public abstract void setOnRefreshListener(PullToRefreshBase.OnRefreshListener2 paramOnRefreshListener2);
  
  public abstract void setOnRefreshListener(PullToRefreshBase.OnRefreshListener paramOnRefreshListener);
  
  public abstract void setPullToRefreshOverScrollEnabled(boolean paramBoolean);
  
  public abstract void setRefreshing();
  
  public abstract void setRefreshing(boolean paramBoolean);
  
  public abstract void setScrollAnimationInterpolator(Interpolator paramInterpolator);
  
  public abstract void setScrollingWhileRefreshingEnabled(boolean paramBoolean);
  
  public abstract void setShowViewWhileRefreshing(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.pulltorefresh.library.IPullToRefresh
 * JD-Core Version:    0.7.0.1
 */