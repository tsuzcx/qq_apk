package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.os.Handler;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.i.i;
import com.tencent.mm.plugin.appbrand.widget.b.l;
import java.util.Map;

public abstract interface c
{
  public abstract void A(Runnable paramRunnable);
  
  public abstract <T extends j> T U(Class<T> paramClass);
  
  public abstract <T extends k> T V(Class<T> paramClass);
  
  public abstract void a(ai paramai);
  
  public abstract int aAN();
  
  public abstract i aAO();
  
  public abstract Handler aAP();
  
  public abstract com.tencent.mm.plugin.appbrand.b.b asW();
  
  public abstract l asX();
  
  public abstract void b(ai paramai);
  
  public abstract void b(String paramString1, String paramString2, int[] paramArrayOfInt);
  
  public abstract void bY(String paramString1, String paramString2);
  
  public abstract String getAppId();
  
  public abstract Context getContext();
  
  public abstract void h(int paramInt, String paramString);
  
  public abstract boolean isRunning();
  
  public abstract <T extends com.tencent.luggage.a.b> T q(Class<T> paramClass);
  
  public abstract i wB();
  
  public abstract Map<String, m> wC();
  
  public abstract o wX();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.c
 * JD-Core Version:    0.7.0.1
 */