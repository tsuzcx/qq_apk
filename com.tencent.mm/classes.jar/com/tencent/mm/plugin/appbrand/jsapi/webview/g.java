package com.tencent.mm.plugin.appbrand.jsapi.webview;

import com.tencent.mm.plugin.appbrand.jsapi.s;

public abstract interface g
{
  public static abstract interface a
  {
    public abstract void acz(String paramString);
    
    public abstract void cleanup();
    
    public abstract int getBinderID();
    
    public abstract void onBackground();
    
    public abstract void onForeground();
    
    public abstract void t(boolean paramBoolean, int paramInt);
  }
  
  public static abstract interface c$a
  {
    public abstract void onVisibilityChanged(int paramInt);
  }
  
  public static final class d
    extends s
  {
    public static final int CTRL_INDEX = 505;
    public static final String NAME = "onWebviewFinishLoad";
  }
  
  public static final class e
    extends s
  {
    public static final int CTRL_INDEX = 504;
    public static final String NAME = "onWebviewStartLoad";
  }
  
  public static final class f
    extends s
  {
    public static final int CTRL_INDEX = 506;
    public static final String NAME = "onWebviewError";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.webview.g
 * JD-Core Version:    0.7.0.1
 */