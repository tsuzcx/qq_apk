package com.tencent.mm.plugin.appbrand.jsapi;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.appbrand.page.bq;

public abstract interface e
  extends c, f
{
  public abstract a aUW();
  
  public abstract a fC(boolean paramBoolean);
  
  public abstract View getContentView();
  
  public static abstract interface a
  {
    public abstract y.b H(int paramInt, boolean paramBoolean);
    
    public abstract boolean a(int paramInt1, bq parambq, int paramInt2);
    
    public abstract boolean a(int paramInt1, float[] paramArrayOfFloat, int paramInt2, Boolean paramBoolean1, Boolean paramBoolean2);
    
    public abstract boolean a(View paramView, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
    
    public abstract ViewGroup beE();
    
    public abstract View getRootView();
    
    public abstract View getViewById(int paramInt);
    
    public abstract y.b sb(int paramInt);
    
    public abstract boolean sc(int paramInt);
    
    public abstract int sd(int paramInt);
    
    public abstract boolean se(int paramInt);
    
    public abstract boolean sf(int paramInt);
    
    public abstract boolean sg(int paramInt);
    
    public abstract boolean sh(int paramInt);
    
    public abstract int si(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e
 * JD-Core Version:    0.7.0.1
 */