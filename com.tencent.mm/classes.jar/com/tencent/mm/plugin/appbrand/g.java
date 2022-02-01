package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.appcache.s;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.widget.dialog.r;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class g
  extends l
{
  public final <T extends com.tencent.luggage.a.b> T T(Class<T> paramClass)
  {
    Object localObject;
    if (ICommLibReader.class == paramClass) {
      localObject = super.T(paramClass);
    }
    com.tencent.luggage.a.b localb;
    do
    {
      return localObject;
      localObject = getRuntime();
      if (localObject == null) {
        break;
      }
      localb = (com.tencent.luggage.a.b)((AppBrandRuntime)localObject).ax(paramClass);
      localObject = localb;
    } while (localb != null);
    return super.T(paramClass);
  }
  
  public final boolean a(n paramn)
  {
    if ((!isRunning()) || (!getRuntime().a(paramn))) {
      return super.a(paramn);
    }
    return true;
  }
  
  public final <T extends m> T aN(Class<T> paramClass)
  {
    if (getRuntime() != null)
    {
      m localm = getRuntime().d(paramClass, false);
      if (localm != null) {
        return localm;
      }
    }
    return super.aN(paramClass);
  }
  
  public final <T extends n> T aO(Class<T> paramClass)
  {
    n localn1;
    if (isRunning())
    {
      n localn2 = getRuntime().aO(paramClass);
      localn1 = localn2;
      if (localn2 != null) {}
    }
    else
    {
      localn1 = super.aO(paramClass);
    }
    return localn1;
  }
  
  public final void b(ICommLibReader paramICommLibReader)
  {
    if (paramICommLibReader == null) {
      throw new NullPointerException();
    }
    super.a(ICommLibReader.class, paramICommLibReader);
  }
  
  public final s cbk()
  {
    AppBrandRuntime localAppBrandRuntime = getRuntime();
    if (localAppBrandRuntime == null) {
      return null;
    }
    return bl.R(localAppBrandRuntime);
  }
  
  public final ICommLibReader cbl()
  {
    return (ICommLibReader)T(ICommLibReader.class);
  }
  
  public String getAppId()
  {
    if (getRuntime() == null) {
      return null;
    }
    return getRuntime().mAppId;
  }
  
  public com.tencent.mm.plugin.appbrand.b.b getAppState()
  {
    if (!isRunning()) {
      return com.tencent.mm.plugin.appbrand.b.b.qKz;
    }
    return getRuntime().qsB.qKC.chD();
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
  
  public r getDialogContainer()
  {
    if (!isRunning()) {
      return super.getDialogContainer();
    }
    return getRuntime().pmu;
  }
  
  public w getFileSystem()
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
    return (localAppBrandRuntime != null) && (!localAppBrandRuntime.qsE.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g
 * JD-Core Version:    0.7.0.1
 */