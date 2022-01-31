package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.util.AttributeSet;
import java.util.List;

public abstract class AppBrandRecentView
  extends RecyclerView
{
  private AppBrandRecentView.e jhH;
  d.a jup;
  
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
    return this.jhH;
  }
  
  public d.a getSceneFactory()
  {
    return this.jup;
  }
  
  public abstract void refresh();
  
  public abstract void release();
  
  public abstract void setDataQuery(c paramc);
  
  public abstract void setOnItemClickListener(AppBrandRecentView.b paramb);
  
  public void setRefreshListener(AppBrandRecentView.e parame)
  {
    this.jhH = parame;
  }
  
  public void setSceneFactory(d.a parama)
  {
    this.jup = parama;
  }
  
  public static abstract interface c<T>
  {
    public abstract List<T> qi(int paramInt);
  }
  
  public static abstract interface d
  {
    public abstract void aQm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView
 * JD-Core Version:    0.7.0.1
 */