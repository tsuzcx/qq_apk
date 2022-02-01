package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class g
  extends k
{
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
      localb = (com.tencent.luggage.a.b)((AppBrandRuntime)localObject).ae(paramClass);
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
  
  public final boolean a(m paramm)
  {
    if ((!isRunning()) || (!getRuntime().a(paramm))) {
      return super.a(paramm);
    }
    return true;
  }
  
  public final <T extends com.tencent.mm.plugin.appbrand.jsapi.l> T au(Class<T> paramClass)
  {
    if (getRuntime() != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.l locall = getRuntime().d(paramClass, false);
      if (locall != null) {
        return locall;
      }
    }
    return super.au(paramClass);
  }
  
  public final <T extends m> T av(Class<T> paramClass)
  {
    m localm1;
    if (isRunning())
    {
      m localm2 = getRuntime().av(paramClass);
      localm1 = localm2;
      if (localm2 != null) {}
    }
    else
    {
      localm1 = super.av(paramClass);
    }
    return localm1;
  }
  
  public final q bBO()
  {
    AppBrandRuntime localAppBrandRuntime = getRuntime();
    if (localAppBrandRuntime == null) {
      return null;
    }
    return bl.N(localAppBrandRuntime);
  }
  
  public final ICommLibReader bBP()
  {
    return (ICommLibReader)K(ICommLibReader.class);
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
      return com.tencent.mm.plugin.appbrand.a.b.nKS;
    }
    return getRuntime().ntR.nKU.bIg();
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
  
  public com.tencent.mm.plugin.appbrand.widget.dialog.l getDialogContainer()
  {
    if (!isRunning()) {
      return super.getDialogContainer();
    }
    return getRuntime().msX;
  }
  
  public r getFileSystem()
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
    return (localAppBrandRuntime != null) && (!localAppBrandRuntime.ntU.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g
 * JD-Core Version:    0.7.0.1
 */