package com.tencent.mm.plugin.appbrand.jsapi;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.appbrand.page.bp;

public abstract interface e
  extends c, f
{
  public abstract a aYi();
  
  public abstract a fG(boolean paramBoolean);
  
  public abstract View getContentView();
  
  public static abstract interface a
  {
    public abstract y.b H(int paramInt, boolean paramBoolean);
    
    public abstract boolean a(int paramInt1, bp parambp, int paramInt2);
    
    public abstract boolean a(int paramInt1, float[] paramArrayOfFloat, int paramInt2, Boolean paramBoolean1, Boolean paramBoolean2);
    
    public abstract boolean a(View paramView, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
    
    public abstract ViewGroup bii();
    
    public abstract View getRootView();
    
    public abstract View getViewById(int paramInt);
    
    public abstract y.b sD(int paramInt);
    
    public abstract boolean sE(int paramInt);
    
    public abstract int sF(int paramInt);
    
    public abstract boolean sG(int paramInt);
    
    public abstract boolean sH(int paramInt);
    
    public abstract boolean sI(int paramInt);
    
    public abstract boolean sJ(int paramInt);
    
    public abstract int sK(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e
 * JD-Core Version:    0.7.0.1
 */