package com.tencent.luggage.sdk.config;

import android.text.TextUtils;
import androidx.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.config.ai;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.Map;

public class b
  implements MStorage.IOnStorageChange
{
  public static b eoL;
  private static String[] eoO = { "username", "appId", "versionInfo", "appInfo", "smallHeadURL", "nickname" };
  private final Map<String, AppBrandInitConfigLU> eoM;
  private final Map<String, String> eoN;
  
  protected b()
  {
    AppMethodBeat.i(146685);
    this.eoM = new a();
    this.eoN = new a();
    AppMethodBeat.o(146685);
  }
  
  public static b aqB()
  {
    try
    {
      b localb = eoL;
      return localb;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private AppBrandInitConfigLU fc(String paramString)
  {
    AppMethodBeat.i(146688);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(146688);
      return null;
    }
    Object localObject2;
    synchronized (this.eoN)
    {
      localObject2 = (String)this.eoN.get(paramString);
      if (Util.isNullOrNil((String)localObject2))
      {
        ai.clk();
        localObject2 = a(ai.a(null, String.format("%s=?", new Object[] { "username" }), new String[] { paramString }));
        ??? = localObject2;
        if (localObject2 == null) {}
      }
    }
    for (;;)
    {
      synchronized (this.eoN)
      {
        this.eoN.put(paramString, ((AppBrandInitConfigLU)localObject2).appId);
        ??? = localObject2;
        AppMethodBeat.o(146688);
        return ???;
        paramString = finally;
        AppMethodBeat.o(146688);
        throw paramString;
      }
      ??? = fd((String)localObject2);
    }
  }
  
  public static void release()
  {
    try
    {
      eoL = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
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
      localAppBrandInitConfigLU.hEy = paramWxaAttributes.field_nickname;
      localAppBrandInitConfigLU.iconUrl = paramWxaAttributes.field_smallHeadURL;
      if (paramWxaAttributes.cld() == null) {
        break label154;
      }
      localAppBrandInitConfigLU.appServiceType = paramWxaAttributes.cld().serviceType;
      localAppBrandInitConfigLU.originalFlag = paramWxaAttributes.cld().originalFlag;
      localAppBrandInitConfigLU.qXZ = paramWxaAttributes.cld().qXZ;
      localAppBrandInitConfigLU.qYa = paramWxaAttributes.cld().qYa;
      if (paramWxaAttributes.clf() == null) {
        break label182;
      }
      localAppBrandInitConfigLU.eoZ = paramWxaAttributes.clf().eoZ;
      localAppBrandInitConfigLU.appVersion = paramWxaAttributes.clf().appVersion;
      localAppBrandInitConfigLU.epa = paramWxaAttributes.clf();
    }
    for (;;)
    {
      localAppBrandInitConfigLU.epb = paramWxaAttributes.field_passThroughInfo;
      AppMethodBeat.o(146689);
      return localAppBrandInitConfigLU;
      label154:
      com.tencent.mm.sdk.platformtools.Log.e("Luggage.WXA.AppBrandInitConfigHelper", "assembleConfig username[%s] appId[%s], NULL appInfo", new Object[] { paramWxaAttributes.field_username, paramWxaAttributes.field_appId });
      break;
      label182:
      com.tencent.mm.sdk.platformtools.Log.e("Luggage.WXA.AppBrandInitConfigHelper", "assembleConfig username[%s] appId[%s], NULL versionInfo", new Object[] { paramWxaAttributes.field_username, paramWxaAttributes.field_appId });
    }
  }
  
  public final void a(String paramString, AppBrandInitConfigLU paramAppBrandInitConfigLU)
  {
    AppMethodBeat.i(220262);
    if ((paramAppBrandInitConfigLU == null) || (Util.isNullOrNil(paramAppBrandInitConfigLU.appId)))
    {
      AppMethodBeat.o(220262);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.i("Luggage.WXA.AppBrandInitConfigHelper", "stash username:%s, appId:%s, appVersion:%d, stack:%s", new Object[] { paramString, paramAppBrandInitConfigLU.appId, Integer.valueOf(paramAppBrandInitConfigLU.appVersion), android.util.Log.getStackTraceString(new Throwable()) });
    synchronized (this.eoM)
    {
      this.eoM.put(paramAppBrandInitConfigLU.appId, paramAppBrandInitConfigLU);
      if (Util.isNullOrNil(paramString)) {
        break label151;
      }
    }
    synchronized (this.eoN)
    {
      this.eoN.put(paramString, paramAppBrandInitConfigLU.appId);
      AppMethodBeat.o(220262);
      return;
      paramString = finally;
      AppMethodBeat.o(220262);
      throw paramString;
    }
    label151:
    AppMethodBeat.o(220262);
  }
  
  public AppBrandInitConfigLU fd(String paramString)
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
      synchronized (this.eoM)
      {
        localAppBrandInitConfigLU = (AppBrandInitConfigLU)this.eoM.remove(paramString);
        if (localAppBrandInitConfigLU != null) {
          break label128;
        }
        ai.clk();
        localAppBrandInitConfigLU = a(ai.e(paramString, eoO));
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
  
  protected final void fe(String paramString)
  {
    AppMethodBeat.i(220260);
    com.tencent.mm.sdk.platformtools.Log.i("Luggage.WXA.AppBrandInitConfigHelper", "clearByAppId %s", new Object[] { paramString });
    synchronized (this.eoM)
    {
      this.eoM.remove(paramString);
      AppMethodBeat.o(220260);
      return;
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
            fc(paramMStorageEventData);
            AppMethodBeat.o(146686);
            return;
          }
          catch (RuntimeException localRuntimeException)
          {
            com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("Luggage.WXA.AppBrandInitConfigHelper", localRuntimeException, "onNotifyChange event[%s] username[%s]", new Object[] { ???, paramMStorageEventData });
            synchronized (this.eoN)
            {
              paramMStorageEventData = (String)this.eoN.remove(paramMStorageEventData);
              if (TextUtils.isEmpty(paramMStorageEventData)) {
                break label151;
              }
            }
            synchronized (this.eoM)
            {
              this.eoM.remove(paramMStorageEventData);
              AppMethodBeat.o(146686);
              return;
              paramMStorageEventData = finally;
              AppMethodBeat.o(146686);
              throw paramMStorageEventData;
            }
          }
        }
      }
      label151:
      AppMethodBeat.o(146686);
      return;
    }
    if ("batch".equals(???)) {
      synchronized (this.eoM)
      {
        this.eoM.clear();
        AppMethodBeat.o(146686);
        return;
      }
    }
    AppMethodBeat.o(146686);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.config.b
 * JD-Core Version:    0.7.0.1
 */