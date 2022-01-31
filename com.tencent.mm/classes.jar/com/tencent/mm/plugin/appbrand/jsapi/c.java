package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.os.Handler;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.i.f;
import com.tencent.mm.plugin.appbrand.widget.b.i;

public abstract interface c
{
  public abstract void C(int paramInt, String paramString);
  
  public abstract <T extends g> T D(Class<T> paramClass);
  
  public abstract com.tencent.mm.plugin.appbrand.b.b Zk();
  
  public abstract k Zl();
  
  public abstract i Zm();
  
  public abstract void a(ac paramac);
  
  public abstract void a(String paramString1, String paramString2, int[] paramArrayOfInt);
  
  public abstract int ahJ();
  
  public abstract f ahK();
  
  public abstract Handler ahL();
  
  public abstract void b(ac paramac);
  
  public abstract void bw(String paramString1, String paramString2);
  
  public abstract String getAppId();
  
  public abstract Context getContext();
  
  public abstract <T extends com.tencent.luggage.b.b> T i(Class<T> paramClass);
  
  public abstract boolean isRunning();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.c
 * JD-Core Version:    0.7.0.1
 */