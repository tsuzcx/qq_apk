package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.os.Handler;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.appbrand.n.o;
import com.tencent.mm.plugin.appbrand.widget.dialog.r;

public abstract interface f
{
  public abstract <T extends com.tencent.luggage.a.b> T T(Class<T> paramClass);
  
  public abstract void V(Runnable paramRunnable);
  
  public abstract void a(bc parambc);
  
  public abstract void a(bc parambc, int[] paramArrayOfInt);
  
  public abstract boolean a(n paramn);
  
  public abstract boolean a(String paramString, o paramo);
  
  public abstract <T extends m> T aN(Class<T> paramClass);
  
  public abstract <T extends n> T aO(Class<T> paramClass);
  
  public abstract void b(String paramString1, String paramString2, int[] paramArrayOfInt);
  
  public abstract void cJ(String paramString1, String paramString2);
  
  public abstract void callback(int paramInt, String paramString);
  
  public abstract void f(String paramString1, String paramString2, int paramInt);
  
  public abstract String getAppId();
  
  public abstract com.tencent.mm.plugin.appbrand.b.b getAppState();
  
  public abstract Handler getAsyncHandler();
  
  public abstract int getComponentId();
  
  public abstract Context getContext();
  
  public abstract r getDialogContainer();
  
  public abstract w getFileSystem();
  
  public abstract c getInterceptor();
  
  public abstract i getJsRuntime();
  
  public abstract void i(Runnable paramRunnable, long paramLong);
  
  public abstract boolean isRunning();
  
  public static abstract interface a
  {
    public abstract boolean a(String paramString, o paramo);
  }
  
  public static abstract interface b
  {
    public abstract void ZJ(String paramString);
    
    public abstract void proceed();
  }
  
  public static abstract interface c
  {
    public abstract void a(bc parambc, o paramo, f.b paramb);
    
    public abstract void a(p paramp, String paramString1, String paramString2, int paramInt, String paramString3);
    
    public abstract boolean a(p paramp, String paramString1, String paramString2, int paramInt, f.b paramb);
    
    public abstract void af(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f
 * JD-Core Version:    0.7.0.1
 */