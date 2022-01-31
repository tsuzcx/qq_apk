package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.widget.b.l;
import com.tencent.mm.sdk.platformtools.ah;

public abstract class d
  extends com.tencent.mm.plugin.appbrand.jsapi.i
{
  public final <T extends j> T U(Class<T> paramClass)
  {
    if (isRunning())
    {
      j localj = getRuntime().d(paramClass, false);
      if (localj != null) {
        return localj;
      }
    }
    return super.U(paramClass);
  }
  
  public final <T extends k> T V(Class<T> paramClass)
  {
    k localk1;
    if (isRunning())
    {
      k localk2 = getRuntime().V(paramClass);
      localk1 = localk2;
      if (localk2 != null) {}
    }
    else
    {
      localk1 = super.V(paramClass);
    }
    return localk1;
  }
  
  public final com.tencent.mm.plugin.appbrand.b.b asW()
  {
    if (!isRunning()) {
      return com.tencent.mm.plugin.appbrand.b.b.gYh;
    }
    return getRuntime().gPL.gYj.awr();
  }
  
  public final l asX()
  {
    if (!isRunning()) {
      return super.asX();
    }
    return getRuntime().gPE;
  }
  
  public final n asY()
  {
    return (n)q(n.class);
  }
  
  public final String getAppId()
  {
    if (getRuntime() == null) {
      return null;
    }
    return getRuntime().mAppId;
  }
  
  public final Context getContext()
  {
    Object localObject1;
    if (getRuntime() == null) {
      localObject1 = ah.getContext();
    }
    Object localObject2;
    do
    {
      do
      {
        return localObject1;
        localObject2 = getRuntime().getContext();
        localObject1 = localObject2;
      } while (localObject2 != null);
      localObject2 = getRuntime().mContext;
      localObject1 = localObject2;
    } while (localObject2 != null);
    return ah.getContext();
  }
  
  public boolean isRunning()
  {
    i locali = getRuntime();
    return (locali != null) && (!locali.mFinished);
  }
  
  public final <T extends com.tencent.luggage.a.b> T q(Class<T> paramClass)
  {
    Object localObject = getRuntime();
    if (localObject != null)
    {
      com.tencent.luggage.a.b localb = (com.tencent.luggage.a.b)((i)localObject).E(paramClass);
      localObject = localb;
      if (localb != null) {}
    }
    else
    {
      localObject = super.q(paramClass);
    }
    return localObject;
  }
  
  public final o wX()
  {
    if (!isRunning()) {
      return super.wX();
    }
    return getRuntime().wX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.d
 * JD-Core Version:    0.7.0.1
 */