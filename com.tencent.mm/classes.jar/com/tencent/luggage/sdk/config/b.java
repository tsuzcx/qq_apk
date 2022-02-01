package com.tencent.luggage.sdk.config;

import android.support.v4.e.a;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.config.ab;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.Map;

public class b
  implements MStorage.IOnStorageChange
{
  public static b cyi;
  private static String[] cyl = { "username", "appId", "versionInfo", "appInfo", "smallHeadURL", "nickname" };
  protected final Map<String, AppBrandInitConfigLU> cyj;
  private final Map<String, String> cyk;
  
  protected b()
  {
    AppMethodBeat.i(146685);
    this.cyj = new a();
    this.cyk = new a();
    AppMethodBeat.o(146685);
  }
  
  public static b Nw()
  {
    try
    {
      b localb = cyi;
      return localb;
    }
    finally {}
  }
  
  private AppBrandInitConfigLU dz(String paramString)
  {
    AppMethodBeat.i(146688);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(146688);
      return null;
    }
    Object localObject2;
    synchronized (this.cyk)
    {
      localObject2 = (String)this.cyk.get(paramString);
      if (Util.isNullOrNil((String)localObject2))
      {
        ab.bAu();
        localObject2 = a(ab.f(String.format("%s=?", new Object[] { "username" }), new String[] { paramString }));
        ??? = localObject2;
        if (localObject2 == null) {}
      }
    }
    for (;;)
    {
      synchronized (this.cyk)
      {
        this.cyk.put(paramString, ((AppBrandInitConfigLU)localObject2).appId);
        ??? = localObject2;
        AppMethodBeat.o(146688);
        return ???;
        paramString = finally;
        AppMethodBeat.o(146688);
        throw paramString;
      }
      ??? = dA((String)localObject2);
    }
  }
  
  public static void release()
  {
    try
    {
      cyi = null;
      return;
    }
    finally {}
  }
  
  public AppBrandInitConfigLU a(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(146689);
    AppBrandInitConfigLU localAppBrandInitConfigLU = null;
    if (paramWxaAttributes != null)
    {
      localAppBrandInitConfigLU = new AppBrandInitConfigLU();
      localAppBrandInitConfigLU.username = paramWxaAttributes.field_username;
      localAppBrandInitConfigLU.appId = paramWxaAttributes.field_appId;
      localAppBrandInitConfigLU.brandName = paramWxaAttributes.field_nickname;
      localAppBrandInitConfigLU.iconUrl = paramWxaAttributes.field_smallHeadURL;
      if (paramWxaAttributes.bAn() == null) {
        break label143;
      }
      localAppBrandInitConfigLU.cyo = paramWxaAttributes.bAn().serviceType;
      localAppBrandInitConfigLU.originalFlag = paramWxaAttributes.bAn().originalFlag;
      localAppBrandInitConfigLU.ldJ = paramWxaAttributes.bAn().ldJ;
      if (paramWxaAttributes.bAp() == null) {
        break label171;
      }
      localAppBrandInitConfigLU.cyu = paramWxaAttributes.bAp().cyu;
      localAppBrandInitConfigLU.appVersion = paramWxaAttributes.bAp().appVersion;
      localAppBrandInitConfigLU.cyv = paramWxaAttributes.bAp();
    }
    for (;;)
    {
      localAppBrandInitConfigLU.cyw = paramWxaAttributes.field_passThroughInfo;
      AppMethodBeat.o(146689);
      return localAppBrandInitConfigLU;
      label143:
      com.tencent.mm.sdk.platformtools.Log.e("Luggage.WXA.AppBrandInitConfigHelper", "assembleConfig username[%s] appId[%s], NULL appInfo", new Object[] { paramWxaAttributes.field_username, paramWxaAttributes.field_appId });
      break;
      label171:
      com.tencent.mm.sdk.platformtools.Log.e("Luggage.WXA.AppBrandInitConfigHelper", "assembleConfig username[%s] appId[%s], NULL versionInfo", new Object[] { paramWxaAttributes.field_username, paramWxaAttributes.field_appId });
    }
  }
  
  public final void a(String paramString, AppBrandInitConfigLU paramAppBrandInitConfigLU)
  {
    AppMethodBeat.i(229824);
    if ((paramAppBrandInitConfigLU == null) || (Util.isNullOrNil(paramAppBrandInitConfigLU.appId)))
    {
      AppMethodBeat.o(229824);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.i("Luggage.WXA.AppBrandInitConfigHelper", "stash username:%s, appId:%s, appVersion:%d, stack:%s", new Object[] { paramString, paramAppBrandInitConfigLU.appId, Integer.valueOf(paramAppBrandInitConfigLU.appVersion), android.util.Log.getStackTraceString(new Throwable()) });
    synchronized (this.cyj)
    {
      this.cyj.put(paramAppBrandInitConfigLU.appId, paramAppBrandInitConfigLU);
      if (Util.isNullOrNil(paramString)) {
        break label151;
      }
    }
    synchronized (this.cyk)
    {
      this.cyk.put(paramString, paramAppBrandInitConfigLU.appId);
      AppMethodBeat.o(229824);
      return;
      paramString = finally;
      AppMethodBeat.o(229824);
      throw paramString;
    }
    label151:
    AppMethodBeat.o(229824);
  }
  
  public AppBrandInitConfigLU dA(String paramString)
  {
    AppMethodBeat.i(146690);
    if (Util.isNullOrNil(paramString))
    {
      com.tencent.mm.sdk.platformtools.Log.w("Luggage.WXA.AppBrandInitConfigHelper", "obtainByAppId with EMPTY appId");
      AppMethodBeat.o(146690);
      return null;
    }
    for (;;)
    {
      AppBrandInitConfigLU localAppBrandInitConfigLU;
      synchronized (this.cyj)
      {
        localAppBrandInitConfigLU = (AppBrandInitConfigLU)this.cyj.remove(paramString);
        if (localAppBrandInitConfigLU != null) {
          break label128;
        }
        ab.bAu();
        localAppBrandInitConfigLU = a(ab.e(paramString, cyl));
        if (localAppBrandInitConfigLU == null)
        {
          i = -1;
          com.tencent.mm.sdk.platformtools.Log.i("Luggage.WXA.AppBrandInitConfigHelper", "obtainByAppId appId:%s, get from db, appVersion:%d", new Object[] { paramString, Integer.valueOf(i) });
          paramString = localAppBrandInitConfigLU;
          AppMethodBeat.o(146690);
          return paramString;
        }
      }
      int i = localAppBrandInitConfigLU.appVersion;
      continue;
      label128:
      com.tencent.mm.sdk.platformtools.Log.i("Luggage.WXA.AppBrandInitConfigHelper", "obtainByAppId appId:%s, get from memory, appVersion:%d", new Object[] { paramString, Integer.valueOf(localAppBrandInitConfigLU.appVersion) });
      paramString = localAppBrandInitConfigLU;
    }
  }
  
  public void onNotifyChange(String arg1, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(146686);
    if ("single".equals(???))
    {
      if (String.class.isInstance(paramMStorageEventData.obj))
      {
        paramMStorageEventData = String.valueOf(paramMStorageEventData.obj);
        if (!Util.isNullOrNil(paramMStorageEventData)) {
          try
          {
            dz(paramMStorageEventData);
            AppMethodBeat.o(146686);
            return;
          }
          catch (RuntimeException localRuntimeException)
          {
            com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("Luggage.WXA.AppBrandInitConfigHelper", localRuntimeException, "onNotifyChange event[%s] username[%s]", new Object[] { ???, paramMStorageEventData });
            synchronized (this.cyk)
            {
              paramMStorageEventData = (String)this.cyk.remove(paramMStorageEventData);
              if (TextUtils.isEmpty(paramMStorageEventData)) {
                break label150;
              }
            }
            synchronized (this.cyj)
            {
              this.cyj.remove(paramMStorageEventData);
              AppMethodBeat.o(146686);
              return;
              paramMStorageEventData = finally;
              AppMethodBeat.o(146686);
              throw paramMStorageEventData;
            }
          }
        }
      }
      label150:
      AppMethodBeat.o(146686);
      return;
    }
    if ("batch".equals(???)) {
      synchronized (this.cyj)
      {
        this.cyj.clear();
        AppMethodBeat.o(146686);
        return;
      }
    }
    AppMethodBeat.o(146686);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.config.b
 * JD-Core Version:    0.7.0.1
 */