package com.tencent.mm.plugin.appbrand.jsapi;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.page.by;

public abstract interface h
  extends f, i
{
  public abstract boolean cdZ();
  
  public abstract View getContentView();
  
  public abstract a getCustomViewContainer();
  
  public abstract a ic(boolean paramBoolean);
  
  public static abstract interface a
  {
    public abstract ad.b Aj(int paramInt);
    
    public abstract boolean Ak(int paramInt);
    
    public abstract int Al(int paramInt);
    
    public abstract boolean Am(int paramInt);
    
    public abstract boolean An(int paramInt);
    
    public abstract boolean Ao(int paramInt);
    
    public abstract boolean Ap(int paramInt);
    
    public abstract int Aq(int paramInt);
    
    public abstract boolean a(int paramInt1, by paramby, int paramInt2);
    
    public abstract boolean a(int paramInt1, float[] paramArrayOfFloat, int paramInt2, Boolean paramBoolean1, Boolean paramBoolean2);
    
    public abstract boolean a(View paramView, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
    
    public abstract ad.b ac(int paramInt, boolean paramBoolean);
    
    public abstract ViewGroup cpL();
    
    public abstract View dU(int paramInt);
    
    public abstract View getRootView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.h
 * JD-Core Version:    0.7.0.1
 */