package com.tencent.mm.plugin.appbrand.widget.header.a;

import android.content.res.Configuration;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.b;

public abstract interface a
{
  public abstract void bsp();
  
  public abstract void bsq();
  
  public abstract void bsr();
  
  public abstract void e(Configuration paramConfiguration);
  
  public abstract int getRecentAppBrandCount();
  
  public abstract int getStarAppBrandCount();
  
  public abstract void refresh();
  
  public abstract void setCollectionRefreshListener(AppBrandRecentView.e parame);
  
  public abstract void setIOnLaunchUIListener(b paramb);
  
  public abstract void setOnEmptyViewListener(a parama);
  
  public abstract void setReporter(b paramb);
  
  public abstract void setUsageRefreshListener(AppBrandRecentView.e parame);
  
  public abstract void uM(int paramInt);
  
  public static abstract interface a
  {
    public abstract void hz(boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract void bsC();
    
    public abstract void bsD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.header.a.a
 * JD-Core Version:    0.7.0.1
 */