package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.os.Handler;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.o;
import java.util.Map;

public abstract interface f
{
  public abstract <T extends com.tencent.luggage.a.b> T M(Class<T> paramClass);
  
  public abstract i Oo();
  
  public abstract Map<String, p> Op();
  
  public abstract void P(Runnable paramRunnable);
  
  public abstract void a(bc parambc);
  
  public abstract void a(bc parambc, o paramo);
  
  public abstract void a(bc parambc, int[] paramArrayOfInt);
  
  public abstract boolean a(n paramn);
  
  public abstract <T extends m> T av(Class<T> paramClass);
  
  public abstract <T extends n> T aw(Class<T> paramClass);
  
  public abstract void b(String paramString1, String paramString2, int[] paramArrayOfInt);
  
  public abstract boolean bsV();
  
  public abstract void co(String paramString1, String paramString2);
  
  public abstract String getAppId();
  
  public abstract com.tencent.mm.plugin.appbrand.a.b getAppState();
  
  public abstract Handler getAsyncHandler();
  
  public abstract int getComponentId();
  
  public abstract Context getContext();
  
  public abstract com.tencent.mm.plugin.appbrand.widget.dialog.m getDialogContainer();
  
  public abstract q getFileSystem();
  
  public abstract i getJsRuntime();
  
  public abstract void i(int paramInt, String paramString);
  
  public abstract void i(Runnable paramRunnable, long paramLong);
  
  public abstract boolean isRunning();
  
  public static abstract interface a
  {
    public abstract void Zb(String paramString);
    
    public abstract void proceed();
  }
  
  public static abstract interface b
  {
    public abstract void V(int paramInt, String paramString);
    
    public abstract void a(bc parambc, f.a parama);
    
    public abstract void a(p paramp, String paramString1, int paramInt, String paramString2);
    
    public abstract boolean a(p paramp, String paramString, int paramInt, f.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f
 * JD-Core Version:    0.7.0.1
 */