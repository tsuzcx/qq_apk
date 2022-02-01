package com.tencent.mm.plugin.appbrand.n;

import android.arch.a.c.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;

public abstract interface e
{
  public abstract void a(a parama);
  
  public abstract void start();
  
  public static abstract interface a
  {
    public abstract void LD(String paramString);
    
    public abstract void a(c paramc);
  }
  
  public static abstract interface b
    extends e.a
  {
    public abstract void a(a<AppBrandRuntime, Boolean> parama);
  }
  
  public static abstract class c
  {
    public static volatile c lvw = null;
    
    public abstract e j(AppBrandRuntime paramAppBrandRuntime, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.e
 * JD-Core Version:    0.7.0.1
 */