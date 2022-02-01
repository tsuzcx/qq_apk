package com.tencent.luggage.sdk.config;

import android.text.TextUtils;
import androidx.b.a;
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
  public static b cwL;
  private static String[] cwO = { "username", "appId", "versionInfo", "appInfo", "smallHeadURL", "nickname" };
  private final Map<String, AppBrandInitConfigLU> cwM;
  private final Map<String, String> cwN;
  
  protected b()
  {
    AppMethodBeat.i(146685);
    this.cwM = new a();
    this.cwN = new a();
    AppMethodBeat.o(146685);
  }
  
  public static b Qr()
  {
    try
    {
      b localb = cwL;
      return localb;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private AppBrandInitConfigLU dS(String paramString)
  {
    AppMethodBeat.i(146688);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(146688);
      return null;
    }
    Object localObject2;
    synchronized (this.cwN)
    {
      localObject2 = (String)this.cwN.get(paramString);
      if (Util.isNullOrNil((String)localObject2))
      {
        ab.bLM();
        localObject2 = a(ab.e(String.format("%s=?", new Object[] { "username" }), new String[] { paramString }));
        ??? = localObject2;
        if (localObject2 == null) {}
      }
    }
    for (;;)
    {
      synchronized (this.cwN)
      {
        this.cwN.put(paramString, ((AppBrandInitConfigLU)localObject2).appId);
        ??? = localObject2;
        AppMethodBeat.o(146688);
        return ???;
        paramString = finally;
        AppMethodBeat.o(146688);
        throw paramString;
      }
      ??? = dT((String)localObject2);
    }
  }
  
  public static void release()
  {
    try
    {
      cwL = null;
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
      localAppBrandInitConfigLU.fzM = paramWxaAttributes.field_nickname;
      localAppBrandInitConfigLU.iconUrl = paramWxaAttributes.field_smallHeadURL;
      if (paramWxaAttributes.bLF() == null) {
        break label143;
      }
      localAppBrandInitConfigLU.cwR = paramWxaAttributes.bLF().serviceType;
      localAppBrandInitConfigLU.originalFlag = paramWxaAttributes.bLF().originalFlag;
      localAppBrandInitConfigLU.nXX = paramWxaAttributes.bLF().nXX;
      if (paramWxaAttributes.bLH() == null) {
        break label171;
      }
      localAppBrandInitConfigLU.cwX = paramWxaAttributes.bLH().cwX;
      localAppBrandInitConfigLU.appVersion = paramWxaAttributes.bLH().appVersion;
      localAppBrandInitConfigLU.cwY = paramWxaAttributes.bLH();
    }
    for (;;)
    {
      localAppBrandInitConfigLU.cwZ = paramWxaAttributes.field_passThroughInfo;
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
    AppMethodBeat.i(237518);
    if ((paramAppBrandInitConfigLU == null) || (Util.isNullOrNil(paramAppBrandInitConfigLU.appId)))
    {
      AppMethodBeat.o(237518);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.i("Luggage.WXA.AppBrandInitConfigHelper", "stash username:%s, appId:%s, appVersion:%d, stack:%s", new Object[] { paramString, paramAppBrandInitConfigLU.appId, Integer.valueOf(paramAppBrandInitConfigLU.appVersion), android.util.Log.getStackTraceString(new Throwable()) });
    synchronized (this.cwM)
    {
      this.cwM.put(paramAppBrandInitConfigLU.appId, paramAppBrandInitConfigLU);
      if (Util.isNullOrNil(paramString)) {
        break label151;
      }
    }
    synchronized (this.cwN)
    {
      this.cwN.put(paramString, paramAppBrandInitConfigLU.appId);
      AppMethodBeat.o(237518);
      return;
      paramString = finally;
      AppMethodBeat.o(237518);
      throw paramString;
    }
    label151:
    AppMethodBeat.o(237518);
  }
  
  public AppBrandInitConfigLU dT(String paramString)
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
      synchronized (this.cwM)
      {
        localAppBrandInitConfigLU = (AppBrandInitConfigLU)this.cwM.remove(paramString);
        if (localAppBrandInitConfigLU != null) {
          break label128;
        }
        ab.bLM();
        localAppBrandInitConfigLU = a(ab.d(paramString, cwO));
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
  
  protected final void dU(String paramString)
  {
    AppMethodBeat.i(237517);
    com.tencent.mm.sdk.platformtools.Log.i("Luggage.WXA.AppBrandInitConfigHelper", "clearByAppId %s", new Object[] { paramString });
    synchronized (this.cwM)
    {
      this.cwM.remove(paramString);
      AppMethodBeat.o(237517);
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
            dS(paramMStorageEventData);
            AppMethodBeat.o(146686);
            return;
          }
          catch (RuntimeException localRuntimeException)
          {
            com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("Luggage.WXA.AppBrandInitConfigHelper", localRuntimeException, "onNotifyChange event[%s] username[%s]", new Object[] { ???, paramMStorageEventData });
            synchronized (this.cwN)
            {
              paramMStorageEventData = (String)this.cwN.remove(paramMStorageEventData);
              if (TextUtils.isEmpty(paramMStorageEventData)) {
                break label151;
              }
            }
            synchronized (this.cwM)
            {
              this.cwM.remove(paramMStorageEventData);
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
      synchronized (this.cwM)
      {
        this.cwM.clear();
        AppMethodBeat.o(146686);
        return;
      }
    }
    AppMethodBeat.o(146686);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.config.b
 * JD-Core Version:    0.7.0.1
 */