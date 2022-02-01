package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import java.util.List;

public abstract class AppBrandRecentView
  extends RecyclerView
{
  private e mZq;
  d.a nmS;
  
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
  
  public abstract b getOnItemClickListener();
  
  public e getRefreshListener()
  {
    return this.mZq;
  }
  
  public d.a getSceneFactory()
  {
    return this.nmS;
  }
  
  public abstract void refresh();
  
  public abstract void release();
  
  public abstract void setDataQuery(c paramc);
  
  public abstract void setOnItemClickListener(b paramb);
  
  public void setRefreshListener(e parame)
  {
    this.mZq = parame;
  }
  
  public void setSceneFactory(d.a parama)
  {
    this.nmS = parama;
  }
  
  public static abstract interface a<T>
  {
    public abstract void a(MenuItem paramMenuItem, int paramInt, T paramT);
  }
  
  public static abstract interface b
  {
    public abstract boolean a(View paramView, a parama, float paramFloat1, float paramFloat2);
    
    public abstract boolean b(View paramView, a parama, float paramFloat1, float paramFloat2);
  }
  
  public static abstract interface c<T>
  {
    public abstract List<T> wh(int paramInt);
  }
  
  public static abstract interface d
  {
    public abstract void bDx();
  }
  
  public static abstract interface e
  {
    public abstract void uP(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView
 * JD-Core Version:    0.7.0.1
 */