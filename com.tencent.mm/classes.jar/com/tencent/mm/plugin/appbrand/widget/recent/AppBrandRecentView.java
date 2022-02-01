package com.tencent.mm.plugin.appbrand.widget.recent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import java.util.List;

public abstract class AppBrandRecentView
  extends RecyclerView
{
  private d uPQ;
  k.a uPR;
  
  public AppBrandRecentView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AppBrandRecentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public abstract void bDL();
  
  public abstract RecyclerView.a getAdapter();
  
  public abstract int getCount();
  
  public abstract a getOnItemClickListener();
  
  public d getRefreshListener()
  {
    return this.uPQ;
  }
  
  public k.a getSceneFactory()
  {
    return this.uPR;
  }
  
  public abstract void release();
  
  public abstract void setDataQuery(b paramb);
  
  public abstract void setOnItemClickListener(a parama);
  
  public void setRefreshListener(d paramd)
  {
    this.uPQ = paramd;
  }
  
  public void setSceneFactory(k.a parama)
  {
    this.uPR = parama;
  }
  
  public static abstract interface a
  {
    public abstract boolean a(View paramView, e parame, float paramFloat1, float paramFloat2);
    
    public abstract boolean b(View paramView, e parame, float paramFloat1, float paramFloat2);
  }
  
  public static abstract interface b<T>
  {
    public abstract List<T> EJ(int paramInt);
  }
  
  public static abstract interface c {}
  
  public static abstract interface d
  {
    public abstract void cFn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView
 * JD-Core Version:    0.7.0.1
 */