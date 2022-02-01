package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.os.Handler;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.m.i;

public abstract interface e
{
  public abstract <T extends com.tencent.luggage.a.b> T K(Class<T> paramClass);
  
  public abstract void P(Runnable paramRunnable);
  
  public abstract void a(az paramaz);
  
  public abstract void a(az paramaz, int[] paramArrayOfInt);
  
  public abstract boolean a(m paramm);
  
  public abstract boolean a(String paramString, com.tencent.mm.plugin.appbrand.m.o paramo);
  
  public abstract <T extends l> T au(Class<T> paramClass);
  
  public abstract <T extends m> T av(Class<T> paramClass);
  
  public abstract void b(String paramString1, String paramString2, int[] paramArrayOfInt);
  
  public abstract void c(String paramString1, String paramString2, int paramInt);
  
  public abstract void ct(String paramString1, String paramString2);
  
  public abstract String getAppId();
  
  public abstract com.tencent.mm.plugin.appbrand.a.b getAppState();
  
  public abstract Handler getAsyncHandler();
  
  public abstract int getComponentId();
  
  public abstract Context getContext();
  
  public abstract com.tencent.mm.plugin.appbrand.widget.dialog.l getDialogContainer();
  
  public abstract r getFileSystem();
  
  public abstract c getInterceptor();
  
  public abstract i getJsRuntime();
  
  public abstract void h(Runnable paramRunnable, long paramLong);
  
  public abstract boolean isRunning();
  
  public abstract void j(int paramInt, String paramString);
  
  public static abstract interface a
  {
    public abstract boolean a(String paramString, com.tencent.mm.plugin.appbrand.m.o paramo);
  }
  
  public static abstract interface c
  {
    public abstract void X(int paramInt, String paramString);
    
    public abstract void a(az paramaz, com.tencent.mm.plugin.appbrand.m.o paramo, e.b paramb);
    
    public abstract void a(o paramo, String paramString1, int paramInt, String paramString2);
    
    public abstract boolean a(o paramo, String paramString, int paramInt, e.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e
 * JD-Core Version:    0.7.0.1
 */