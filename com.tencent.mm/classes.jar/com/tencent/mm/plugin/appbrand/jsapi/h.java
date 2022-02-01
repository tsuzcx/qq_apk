package com.tencent.mm.plugin.appbrand.jsapi;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.page.bu;

public abstract interface h
  extends f, i
{
  public abstract boolean btO();
  
  public abstract a gA(boolean paramBoolean);
  
  public abstract View getContentView();
  
  public abstract a getCustomViewContainer();
  
  public static abstract interface a
  {
    public abstract ad.b L(int paramInt, boolean paramBoolean);
    
    public abstract boolean a(int paramInt1, bu parambu, int paramInt2);
    
    public abstract boolean a(int paramInt1, float[] paramArrayOfFloat, int paramInt2, Boolean paramBoolean1, Boolean paramBoolean2);
    
    public abstract boolean a(View paramView, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
    
    public abstract ViewGroup bEh();
    
    public abstract View getRootView();
    
    public abstract View getViewById(int paramInt);
    
    public abstract ad.b wC(int paramInt);
    
    public abstract boolean wD(int paramInt);
    
    public abstract int wE(int paramInt);
    
    public abstract boolean wF(int paramInt);
    
    public abstract boolean wG(int paramInt);
    
    public abstract boolean wH(int paramInt);
    
    public abstract boolean wI(int paramInt);
    
    public abstract int wJ(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.h
 * JD-Core Version:    0.7.0.1
 */