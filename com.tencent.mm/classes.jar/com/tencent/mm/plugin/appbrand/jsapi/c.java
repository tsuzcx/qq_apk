package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.os.Handler;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.o;
import java.util.Map;

public abstract interface c
{
  public abstract i EM();
  
  public abstract Map<String, m> EN();
  
  public abstract q Fl();
  
  public abstract <T extends com.tencent.luggage.a.b> T K(Class<T> paramClass);
  
  public abstract void K(Runnable paramRunnable);
  
  public abstract void a(at paramat);
  
  public abstract void a(at paramat, o paramo);
  
  public abstract boolean a(k paramk);
  
  public abstract com.tencent.mm.plugin.appbrand.a.b aWc();
  
  public abstract com.tencent.mm.plugin.appbrand.widget.dialog.m aWd();
  
  public abstract boolean aXO();
  
  public abstract int aXX();
  
  public abstract Handler aYA();
  
  public abstract i aYB();
  
  public abstract <T extends j> T ar(Class<T> paramClass);
  
  public abstract <T extends k> T as(Class<T> paramClass);
  
  public abstract void b(at paramat);
  
  public abstract void b(String paramString1, String paramString2, int[] paramArrayOfInt);
  
  public abstract void cb(String paramString1, String paramString2);
  
  public abstract String getAppId();
  
  public abstract Context getContext();
  
  public abstract void h(int paramInt, String paramString);
  
  public abstract boolean isRunning();
  
  public abstract void j(Runnable paramRunnable, long paramLong);
  
  public static abstract interface a
  {
    public abstract void PL(String paramString);
    
    public abstract void proceed();
  }
  
  public static abstract interface b
  {
    public abstract void S(int paramInt, String paramString);
    
    public abstract void a(at paramat, c.a parama);
    
    public abstract void a(m paramm, String paramString1, int paramInt, String paramString2);
    
    public abstract boolean a(m paramm, String paramString, int paramInt, c.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.c
 * JD-Core Version:    0.7.0.1
 */