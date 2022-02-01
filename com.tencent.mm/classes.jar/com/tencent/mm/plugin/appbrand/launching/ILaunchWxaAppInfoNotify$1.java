package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcelable;
import com.tencent.luggage.sdk.config.LaunchWxaAppInfoParcelized;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.appbrand.ipc.e;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.permission.appidABTest.AppRuntimeAppidABTestPermissionBundle;
import com.tencent.mm.protocal.protobuf.yw;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Locale;

final class ILaunchWxaAppInfoNotify$1
  implements ILaunchWxaAppInfoNotify
{
  private final String TAG = "MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]";
  
  private static String a(aj paramaj)
  {
    AppMethodBeat.i(47171);
    if (paramaj == null)
    {
      AppMethodBeat.o(47171);
      return "NULL";
    }
    try
    {
      paramaj = String.format(Locale.US, "bytes[%d]", new Object[] { Integer.valueOf(paramaj.field_jsapiInfo.SkZ.UH.length) });
      AppMethodBeat.o(47171);
      return paramaj;
    }
    catch (Exception paramaj)
    {
      paramaj = String.format(Locale.US, "Exception[%s]", new Object[] { paramaj });
      AppMethodBeat.o(47171);
    }
    return paramaj;
  }
  
  public final void a(String paramString1, int paramInt, String paramString2, aj paramaj, boolean paramBoolean)
  {
    AppMethodBeat.i(269182);
    Object localObject = j.ajU(paramString2);
    if (localObject != null)
    {
      Log.i("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", "notifyLaunchInfoUpdate [update deferred process] appId[%s], type[%d], sessionId[%s], %s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, a(paramaj) });
      ((j)localObject).a(paramString1, paramInt, paramString2, paramaj, paramBoolean);
    }
    try
    {
      Log.i("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", "notifyLaunchInfoUpdate [update remote] appId[%s], type[%d], sessionId[%s], %s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, a(paramaj) });
      localObject = new ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper();
      ((ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper)localObject).appId = paramString1;
      ((ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper)localObject).cBU = paramInt;
      AppRuntimeApiPermissionBundle localAppRuntimeApiPermissionBundle = new AppRuntimeApiPermissionBundle(paramaj.field_jsapiInfo);
      AppBrandLaunchErrorAction.a locala = AppBrandLaunchErrorAction.CREATOR;
      ((ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper)localObject).cxk = new LaunchWxaAppInfoParcelized(localAppRuntimeApiPermissionBundle, AppBrandLaunchErrorAction.a.a(paramString1, paramInt, paramaj), paramaj.field_opConfig, paramBoolean);
      e.b(paramString1, (Parcelable)localObject);
      AppMethodBeat.o(269182);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", localThrowable, "notifyLaunchInfoUpdate [update remote] appId[%s], type[%d], sessionId[%s], %s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, a(paramaj) });
      AppMethodBeat.o(269182);
    }
  }
  
  public final void a(String paramString1, int paramInt, String paramString2, HashMap<String, AppRuntimeApiPermissionBundle> paramHashMap)
  {
    int j = 0;
    AppMethodBeat.i(269183);
    Object localObject = j.ajU(paramString2);
    if (localObject != null)
    {
      if (paramHashMap == null)
      {
        i = 0;
        Log.i("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", "notifyPluginPermissionInfoUpdate [update deferred process] appId[%s], type[%d], sessionId[%s], pluginMapSize:[%d]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, Integer.valueOf(i) });
        ((j)localObject).a(paramString1, paramInt, paramString2, paramHashMap);
      }
    }
    else {
      if (paramHashMap != null) {
        break label163;
      }
    }
    for (int i = 0;; i = paramHashMap.size())
    {
      try
      {
        Log.i("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", "notifyPluginPermissionInfoUpdate [update remote] appId[%s], type[%d], sessionId[%s], pluginMapSize:[%d]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, Integer.valueOf(i) });
        localObject = new ILaunchWxaAppInfoNotify.PluginIpcWrapper();
        ((ILaunchWxaAppInfoNotify.PluginIpcWrapper)localObject).appId = paramString1;
        ((ILaunchWxaAppInfoNotify.PluginIpcWrapper)localObject).cBU = paramInt;
        ((ILaunchWxaAppInfoNotify.PluginIpcWrapper)localObject).pVz = paramHashMap;
        e.b(paramString1, (Parcelable)localObject);
        AppMethodBeat.o(269183);
        return;
      }
      catch (Throwable localThrowable)
      {
        label163:
        if (paramHashMap != null) {
          break label226;
        }
      }
      i = paramHashMap.size();
      break;
    }
    label226:
    for (i = j;; i = paramHashMap.size())
    {
      Log.printErrStackTrace("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", localThrowable, "notifyPluginPermissionInfoUpdate [update remote] appId[%s], type[%d], sessionId[%s], pluginMapSize:[%d]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, Integer.valueOf(i) });
      AppMethodBeat.o(269183);
      return;
    }
  }
  
  public final void b(String paramString1, int paramInt, String paramString2, HashMap<String, AppRuntimeAppidABTestPermissionBundle> paramHashMap)
  {
    int j = 0;
    AppMethodBeat.i(269184);
    Object localObject = j.ajU(paramString2);
    if (localObject != null)
    {
      if (paramHashMap == null)
      {
        i = 0;
        Log.i("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", "notifyAppidABTestPermissionInfoUpdate [update deferred process] appId[%s], type[%d], sessionId[%s], appidABTestMapSize:[%d]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, Integer.valueOf(i) });
        ((j)localObject).b(paramString1, paramInt, paramString2, paramHashMap);
      }
    }
    else {
      if (paramHashMap != null) {
        break label163;
      }
    }
    for (int i = 0;; i = paramHashMap.size())
    {
      try
      {
        Log.i("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", "notifyAppidABTestPermissionInfoUpdate [update remote] appId[%s], type[%d], sessionId[%s], appidABTestMapSize:[%d]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, Integer.valueOf(i) });
        localObject = new ILaunchWxaAppInfoNotify.AppidABTestIpcWrapper();
        ((ILaunchWxaAppInfoNotify.AppidABTestIpcWrapper)localObject).appId = paramString1;
        ((ILaunchWxaAppInfoNotify.AppidABTestIpcWrapper)localObject).cBU = paramInt;
        ((ILaunchWxaAppInfoNotify.AppidABTestIpcWrapper)localObject).pVy = paramHashMap;
        e.b(paramString1, (Parcelable)localObject);
        AppMethodBeat.o(269184);
        return;
      }
      catch (Throwable localThrowable)
      {
        label163:
        if (paramHashMap != null) {
          break label226;
        }
      }
      i = paramHashMap.size();
      break;
    }
    label226:
    for (i = j;; i = paramHashMap.size())
    {
      Log.printErrStackTrace("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", localThrowable, "notifyAppidABTestPermissionInfoUpdate [update remote] appId[%s], type[%d], sessionId[%s], appidABTestMapSize:[%d]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, Integer.valueOf(i) });
      AppMethodBeat.o(269184);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify.1
 * JD-Core Version:    0.7.0.1
 */