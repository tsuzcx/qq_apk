package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.util.AttributeSet;

public abstract class AppBrandRecentView
  extends RecyclerView
{
  d.a hBW;
  private AppBrandRecentView.e hri;
  
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
    return this.hri;
  }
  
  public d.a getSceneFactory()
  {
    return this.hBW;
  }
  
  public abstract void refresh();
  
  public abstract void release();
  
  public abstract void setDataQuery(AppBrandRecentView.c paramc);
  
  public abstract void setOnItemClickListener(AppBrandRecentView.b paramb);
  
  public void setRefreshListener(AppBrandRecentView.e parame)
  {
    this.hri = parame;
  }
  
  public void setSceneFactory(d.a parama)
  {
    this.hBW = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView
 * JD-Core Version:    0.7.0.1
 */