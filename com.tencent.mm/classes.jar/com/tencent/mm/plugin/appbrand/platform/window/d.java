package com.tencent.mm.plugin.appbrand.platform.window;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient.CustomViewCallback;

public abstract interface d
{
  public abstract void N(View paramView, int paramInt);
  
  public abstract void a(WebChromeClient.CustomViewCallback paramCustomViewCallback);
  
  public abstract void a(b paramb);
  
  public abstract void b(b paramb);
  
  public abstract boolean bTK();
  
  public abstract boolean btC();
  
  public abstract void release();
  
  public abstract void vH(int paramInt);
  
  public static abstract interface b
  {
    public abstract ViewGroup cB(View paramView);
  }
  
  @Deprecated
  public static abstract interface c
  {
    public abstract void a(e.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.d
 * JD-Core Version:    0.7.0.1
 */