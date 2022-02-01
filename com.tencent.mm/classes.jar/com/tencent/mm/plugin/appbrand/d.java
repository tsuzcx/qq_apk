package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidContextUtil;

public abstract class d
  extends l
{
  public final <T extends com.tencent.luggage.a.b> T M(Class<T> paramClass)
  {
    Object localObject;
    if (ICommLibReader.class == paramClass) {
      localObject = super.M(paramClass);
    }
    com.tencent.luggage.a.b localb;
    do
    {
      return localObject;
      localObject = getRuntime();
      if (localObject == null) {
        break;
      }
      localb = (com.tencent.luggage.a.b)((AppBrandRuntime)localObject).af(paramClass);
      localObject = localb;
    } while (localb != null);
    return super.M(paramClass);
  }
  
  public final void a(ICommLibReader paramICommLibReader)
  {
    if (paramICommLibReader == null) {
      throw new NullPointerException();
    }
    super.a(ICommLibReader.class, paramICommLibReader);
  }
  
  public final boolean a(n paramn)
  {
    if ((!isRunning()) || (!getRuntime().a(paramn))) {
      return super.a(paramn);
    }
    return true;
  }
  
  public final <T extends com.tencent.mm.plugin.appbrand.jsapi.m> T av(Class<T> paramClass)
  {
    if (getRuntime() != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.m localm = getRuntime().d(paramClass, false);
      if (localm != null) {
        return localm;
      }
    }
    return super.av(paramClass);
  }
  
  public final <T extends n> T aw(Class<T> paramClass)
  {
    n localn1;
    if (isRunning())
    {
      n localn2 = getRuntime().aw(paramClass);
      localn1 = localn2;
      if (localn2 != null) {}
    }
    else
    {
      localn1 = super.aw(paramClass);
    }
    return localn1;
  }
  
  public final com.tencent.mm.plugin.appbrand.appcache.q bqY()
  {
    AppBrandRuntime localAppBrandRuntime = getRuntime();
    if (localAppBrandRuntime == null) {
      return null;
    }
    return bg.M(localAppBrandRuntime);
  }
  
  public final ICommLibReader bqZ()
  {
    return (ICommLibReader)M(ICommLibReader.class);
  }
  
  public String getAppId()
  {
    if (getRuntime() == null) {
      return null;
    }
    return getRuntime().mAppId;
  }
  
  public com.tencent.mm.plugin.appbrand.a.b getAppState()
  {
    if (!isRunning()) {
      return com.tencent.mm.plugin.appbrand.a.b.kQK;
    }
    return getRuntime().kAH.kQM.bwY();
  }
  
  public final Context getContext()
  {
    Object localObject1;
    if (getRuntime() == null) {
      localObject1 = MMApplicationContext.getContext();
    }
    Object localObject2;
    do
    {
      do
      {
        return localObject1;
        localObject2 = AndroidContextUtil.castActivityOrNull(getRuntime().mContext);
        localObject1 = localObject2;
      } while (localObject2 != null);
      localObject2 = getRuntime().mContext;
      localObject1 = localObject2;
    } while (localObject2 != null);
    return MMApplicationContext.getContext();
  }
  
  public com.tencent.mm.plugin.appbrand.widget.dialog.m getDialogContainer()
  {
    if (!isRunning()) {
      return super.getDialogContainer();
    }
    return getRuntime().jCK;
  }
  
  public com.tencent.mm.plugin.appbrand.appstorage.q getFileSystem()
  {
    if (!isRunning()) {
      return super.getFileSystem();
    }
    return getRuntime().getFileSystem();
  }
  
  public abstract com.tencent.mm.plugin.appbrand.platform.window.c getWindowAndroid();
  
  public boolean isRunning()
  {
    AppBrandRuntime localAppBrandRuntime = getRuntime();
    return (localAppBrandRuntime != null) && (!localAppBrandRuntime.isDestroyed());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.d
 * JD-Core Version:    0.7.0.1
 */