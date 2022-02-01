package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.sdk.f.a;
import com.tencent.mm.sdk.platformtools.ak;

public abstract class d
  extends i
{
  public com.tencent.mm.plugin.appbrand.appstorage.q Fl()
  {
    if (!isRunning()) {
      return super.Fl();
    }
    return getRuntime().Fl();
  }
  
  public final <T extends com.tencent.luggage.a.b> T K(Class<T> paramClass)
  {
    Object localObject;
    if (ICommLibReader.class == paramClass) {
      localObject = super.K(paramClass);
    }
    com.tencent.luggage.a.b localb;
    do
    {
      return localObject;
      localObject = getRuntime();
      if (localObject == null) {
        break;
      }
      localb = (com.tencent.luggage.a.b)((AppBrandRuntime)localObject).ab(paramClass);
      localObject = localb;
    } while (localb != null);
    return super.K(paramClass);
  }
  
  public final void a(ICommLibReader paramICommLibReader)
  {
    if (paramICommLibReader == null) {
      throw new NullPointerException();
    }
    super.a(ICommLibReader.class, paramICommLibReader);
  }
  
  public final boolean a(k paramk)
  {
    if ((!isRunning()) || (!getRuntime().a(paramk))) {
      return super.a(paramk);
    }
    return true;
  }
  
  public final com.tencent.mm.plugin.appbrand.appcache.q aWb()
  {
    AppBrandRuntime localAppBrandRuntime = getRuntime();
    if (localAppBrandRuntime == null) {
      return null;
    }
    return bg.M(localAppBrandRuntime);
  }
  
  public final com.tencent.mm.plugin.appbrand.a.b aWc()
  {
    if (!isRunning()) {
      return com.tencent.mm.plugin.appbrand.a.b.jOd;
    }
    return getRuntime().jzQ.jOf.bbI();
  }
  
  public final m aWd()
  {
    if (!isRunning()) {
      return super.aWd();
    }
    return getRuntime().iGI;
  }
  
  public final ICommLibReader aWe()
  {
    return (ICommLibReader)K(ICommLibReader.class);
  }
  
  public final <T extends j> T ar(Class<T> paramClass)
  {
    if (getRuntime() != null)
    {
      j localj = getRuntime().c(paramClass, false);
      if (localj != null) {
        return localj;
      }
    }
    return super.ar(paramClass);
  }
  
  public final <T extends k> T as(Class<T> paramClass)
  {
    k localk1;
    if (isRunning())
    {
      k localk2 = getRuntime().as(paramClass);
      localk1 = localk2;
      if (localk2 != null) {}
    }
    else
    {
      localk1 = super.as(paramClass);
    }
    return localk1;
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
      localObject1 = ak.getContext();
    }
    Object localObject2;
    do
    {
      do
      {
        return localObject1;
        localObject2 = a.jw(getRuntime().mContext);
        localObject1 = localObject2;
      } while (localObject2 != null);
      localObject2 = getRuntime().mContext;
      localObject1 = localObject2;
    } while (localObject2 != null);
    return ak.getContext();
  }
  
  public abstract com.tencent.mm.plugin.appbrand.platform.window.c getWindowAndroid();
  
  public boolean isRunning()
  {
    AppBrandRuntime localAppBrandRuntime = getRuntime();
    return (localAppBrandRuntime != null) && (!localAppBrandRuntime.isDestroyed());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.d
 * JD-Core Version:    0.7.0.1
 */