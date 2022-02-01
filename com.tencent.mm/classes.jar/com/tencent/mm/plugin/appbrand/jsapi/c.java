package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.os.Handler;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.o;
import java.util.Map;

public abstract interface c
{
  public abstract i DI();
  
  public abstract Map<String, m> DJ();
  
  public abstract p Ee();
  
  public abstract <T extends com.tencent.luggage.a.b> T K(Class<T> paramClass);
  
  public abstract void L(Runnable paramRunnable);
  
  public abstract void a(ar paramar);
  
  public abstract void a(ar paramar, o paramo);
  
  public abstract boolean a(k paramk);
  
  public abstract com.tencent.mm.plugin.appbrand.b.b aLA();
  
  public abstract com.tencent.mm.plugin.appbrand.widget.dialog.m aLB();
  
  public abstract boolean aNu();
  
  public abstract int aOd();
  
  public abstract Handler aOe();
  
  public abstract i aOf();
  
  public abstract <T extends j> T ar(Class<T> paramClass);
  
  public abstract <T extends k> T as(Class<T> paramClass);
  
  public abstract void b(ar paramar);
  
  public abstract void b(String paramString1, String paramString2, int[] paramArrayOfInt);
  
  public abstract void bR(String paramString1, String paramString2);
  
  public abstract String getAppId();
  
  public abstract Context getContext();
  
  public abstract void h(int paramInt, String paramString);
  
  public abstract boolean isRunning();
  
  public static abstract interface a
  {
    public abstract void HF(String paramString);
    
    public abstract void proceed();
  }
  
  public static abstract interface b
  {
    public abstract void P(int paramInt, String paramString);
    
    public abstract void a(ar paramar, c.a parama);
    
    public abstract void a(m paramm, String paramString1, int paramInt, String paramString2);
    
    public abstract boolean a(m paramm, String paramString, int paramInt, c.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.c
 * JD-Core Version:    0.7.0.1
 */