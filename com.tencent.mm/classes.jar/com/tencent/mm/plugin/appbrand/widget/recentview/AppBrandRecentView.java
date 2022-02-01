package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.util.AttributeSet;

public abstract class AppBrandRecentView
  extends RecyclerView
{
  d.a mMw;
  private AppBrandRecentView.e myI;
  
  public AppBrandRecentView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AppBrandRecentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public abstract RecyclerView.a getAdapter();
  
  public abstract int getCount();
  
  public abstract AppBrandRecentView.b getOnItemClickListener();
  
  public AppBrandRecentView.e getRefreshListener()
  {
    return this.myI;
  }
  
  public d.a getSceneFactory()
  {
    return this.mMw;
  }
  
  public abstract void refresh();
  
  public abstract void release();
  
  public abstract void setDataQuery(AppBrandRecentView.c paramc);
  
  public abstract void setOnItemClickListener(AppBrandRecentView.b paramb);
  
  public void setRefreshListener(AppBrandRecentView.e parame)
  {
    this.myI = parame;
  }
  
  public void setSceneFactory(d.a parama)
  {
    this.mMw = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView
 * JD-Core Version:    0.7.0.1
 */