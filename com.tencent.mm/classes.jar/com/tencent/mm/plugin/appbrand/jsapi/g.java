package com.tencent.mm.plugin.appbrand.jsapi;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.page.bx;

public abstract interface g
  extends e, h
{
  public abstract boolean bEN();
  
  public abstract View getContentView();
  
  public abstract a getCustomViewContainer();
  
  public abstract a hl(boolean paramBoolean);
  
  public static abstract interface a
  {
    public abstract ad.b N(int paramInt, boolean paramBoolean);
    
    public abstract boolean a(int paramInt1, bx parambx, int paramInt2);
    
    public abstract boolean a(int paramInt1, float[] paramArrayOfFloat, int paramInt2, Boolean paramBoolean1, Boolean paramBoolean2);
    
    public abstract boolean a(View paramView, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
    
    public abstract ViewGroup bPF();
    
    public abstract View bg(int paramInt);
    
    public abstract View getRootView();
    
    public abstract ad.b zR(int paramInt);
    
    public abstract boolean zS(int paramInt);
    
    public abstract int zT(int paramInt);
    
    public abstract boolean zU(int paramInt);
    
    public abstract boolean zV(int paramInt);
    
    public abstract boolean zW(int paramInt);
    
    public abstract boolean zX(int paramInt);
    
    public abstract int zY(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g
 * JD-Core Version:    0.7.0.1
 */