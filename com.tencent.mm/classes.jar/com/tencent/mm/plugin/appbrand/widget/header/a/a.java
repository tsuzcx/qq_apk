package com.tencent.mm.plugin.appbrand.widget.header.a;

import android.content.res.Configuration;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.b;

public abstract interface a
{
  public abstract void aQi();
  
  public abstract void aQj();
  
  public abstract void aQk();
  
  public abstract void b(Configuration paramConfiguration);
  
  public abstract int getRecentAppBrandCount();
  
  public abstract int getStarAppBrandCount();
  
  public abstract void ql(int paramInt);
  
  public abstract void refresh();
  
  public abstract void setCollectionRefreshListener(AppBrandRecentView.e parame);
  
  public abstract void setIOnLaunchUIListener(a.b paramb);
  
  public abstract void setOnEmptyViewListener(a.a parama);
  
  public abstract void setReporter(b paramb);
  
  public abstract void setUsageRefreshListener(AppBrandRecentView.e parame);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.header.a.a
 * JD-Core Version:    0.7.0.1
 */