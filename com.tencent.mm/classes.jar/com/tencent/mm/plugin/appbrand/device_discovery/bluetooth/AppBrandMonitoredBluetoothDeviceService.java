package com.tencent.mm.plugin.appbrand.device_discovery.bluetooth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/AppBrandMonitoredBluetoothDeviceService;", "", "()V", "BUNDLE_KEY_INFO_LIST", "", "TAG", "isMainProcess", "", "statApps", "", "deleteAppInfoAsync", "", "appId", "versionType", "", "deleteInfoAsync", "wechatToken", "callback", "Lkotlin/Function1;", "Lkotlin/Result;", "Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/OpCallback;", "disableMonitorAsync", "enableMonitorAsync", "getAllInfoAsync", "", "Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/MonitoredBluetoothDeviceInfo;", "preventMonitorAppPkgClean", "setInfoAsync", "info", "startStatWeApp", "statWeAppConnectGattSuccess", "deviceId", "stopStatWeApp", "WeAppConnectGattSuccessInfo", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandMonitoredBluetoothDeviceService
{
  public static final AppBrandMonitoredBluetoothDeviceService rgb;
  private static final boolean rgc;
  private static final Set<String> rgd;
  
  static
  {
    AppMethodBeat.i(321869);
    rgb = new AppBrandMonitoredBluetoothDeviceService();
    rgc = MMApplicationContext.isMainProcess();
    Set localSet = Collections.newSetFromMap((Map)new ConcurrentHashMap());
    s.s(localSet, "newSetFromMap(ConcurrentHashMap())");
    rgd = localSet;
    AppMethodBeat.o(321869);
  }
  
  public static void O(b<? super Result<? extends List<MonitoredBluetoothDeviceInfo>>, ah> paramb)
  {
    AppMethodBeat.i(321792);
    s.u(paramb, "callback");
    com.tencent.mm.plugin.appbrand.device_discovery.a locala = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
    com.tencent.mm.plugin.appbrand.device_discovery.a.i("MicroMsg.AppBrandMonitoredBluetoothDeviceService", "getAllInfoAsync");
    if (rgc)
    {
      com.tencent.threadpool.h.ahAA.i((Runnable)new AppBrandMonitoredBluetoothDeviceService.e(paramb), "MicroMsg.AppBrandMonitoredBluetoothDeviceService");
      AppMethodBeat.o(321792);
      return;
    }
    com.tencent.mm.ipcinvoker.wx_extension.b.a.a(IPCVoid.mzv, AppBrandMonitoredBluetoothDeviceService..ExternalSyntheticLambda1.INSTANCE, new AppBrandMonitoredBluetoothDeviceService..ExternalSyntheticLambda4(paramb));
    AppMethodBeat.o(321792);
  }
  
  public static boolean Yx(String paramString)
  {
    AppMethodBeat.i(321767);
    s.u(paramString, "appId");
    com.tencent.mm.plugin.appbrand.device_discovery.a locala = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
    com.tencent.mm.plugin.appbrand.device_discovery.a.i("MicroMsg.AppBrandMonitoredBluetoothDeviceService", s.X("startStatWeApp， appId: ", paramString));
    boolean bool = rgd.add(paramString);
    AppMethodBeat.o(321767);
    return bool;
  }
  
  public static void Yy(String paramString)
  {
    AppMethodBeat.i(321775);
    s.u(paramString, "appId");
    com.tencent.mm.plugin.appbrand.device_discovery.a locala = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
    com.tencent.mm.plugin.appbrand.device_discovery.a.i("MicroMsg.AppBrandMonitoredBluetoothDeviceService", s.X("stopStatWeApp， appId: ", paramString));
    rgd.remove(paramString);
    AppMethodBeat.o(321775);
  }
  
  private static final void a(WeAppConnectGattSuccessInfo paramWeAppConnectGattSuccessInfo, f paramf)
  {
    Object localObject = null;
    AppMethodBeat.i(321819);
    if (paramWeAppConnectGattSuccessInfo == null)
    {
      paramf = null;
      if (paramWeAppConnectGattSuccessInfo != null) {
        break label115;
      }
      paramWeAppConnectGattSuccessInfo = (WeAppConnectGattSuccessInfo)localObject;
      label19:
      localObject = (CharSequence)paramf;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label123;
      }
      i = 1;
      label39:
      if (i == 0)
      {
        localObject = (CharSequence)paramWeAppConnectGattSuccessInfo;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label128;
        }
      }
    }
    label128:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label133;
      }
      localObject = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrandMonitoredBluetoothDeviceService", "statWeAppConnectGattSuccess, passedAppId: " + paramf + ", passedDeviceId: " + paramWeAppConnectGattSuccessInfo);
      AppMethodBeat.o(321819);
      return;
      paramf = paramWeAppConnectGattSuccessInfo.appId;
      break;
      label115:
      paramWeAppConnectGattSuccessInfo = paramWeAppConnectGattSuccessInfo.hEl;
      break label19;
      label123:
      i = 0;
      break label39;
    }
    label133:
    localObject = a.rgg;
    a.dv(paramf, paramWeAppConnectGattSuccessInfo);
    AppMethodBeat.o(321819);
  }
  
  private static final void a(MonitoredBluetoothDeviceInfo paramMonitoredBluetoothDeviceInfo, f paramf)
  {
    int i = 1;
    AppMethodBeat.i(321847);
    if ((paramMonitoredBluetoothDeviceInfo != null) && (true == paramMonitoredBluetoothDeviceInfo.isValid())) {}
    while (i == 0)
    {
      localObject = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrandMonitoredBluetoothDeviceService", "setInfoAsync, passedInfo: " + paramMonitoredBluetoothDeviceInfo + " is invalid");
      paramf.onCallback(new IPCBoolean(false));
      AppMethodBeat.o(321847);
      return;
      i = 0;
    }
    Object localObject = a.rgg;
    s.s(paramMonitoredBluetoothDeviceInfo, "passedInfo");
    paramf.onCallback(new IPCBoolean(a.c(paramMonitoredBluetoothDeviceInfo)));
    AppMethodBeat.o(321847);
  }
  
  public static void a(final MonitoredBluetoothDeviceInfo paramMonitoredBluetoothDeviceInfo, b<? super Result<ah>, ah> paramb)
  {
    AppMethodBeat.i(321799);
    s.u(paramMonitoredBluetoothDeviceInfo, "info");
    s.u(paramb, "callback");
    com.tencent.mm.plugin.appbrand.device_discovery.a locala;
    if (g.DEBUG)
    {
      locala = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      com.tencent.mm.plugin.appbrand.device_discovery.a.i("MicroMsg.AppBrandMonitoredBluetoothDeviceService", s.X("setInfoAsync, info: ", paramMonitoredBluetoothDeviceInfo));
    }
    while (rgc)
    {
      com.tencent.threadpool.h.ahAA.i((Runnable)new f(paramb, paramMonitoredBluetoothDeviceInfo), "MicroMsg.AppBrandMonitoredBluetoothDeviceService");
      AppMethodBeat.o(321799);
      return;
      locala = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      com.tencent.mm.plugin.appbrand.device_discovery.a.d("MicroMsg.AppBrandMonitoredBluetoothDeviceService", "setInfoAsync");
    }
    com.tencent.mm.ipcinvoker.wx_extension.b.a.a(paramMonitoredBluetoothDeviceInfo, AppBrandMonitoredBluetoothDeviceService..ExternalSyntheticLambda3.INSTANCE, new AppBrandMonitoredBluetoothDeviceService..ExternalSyntheticLambda5(paramb));
    AppMethodBeat.o(321799);
  }
  
  private static final void a(b paramb, Bundle paramBundle)
  {
    AppMethodBeat.i(321837);
    s.u(paramb, "$callback");
    if (paramBundle == null)
    {
      paramBundle = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrandMonitoredBluetoothDeviceService", "getAllInfoAsync, data is null");
      paramBundle = Result.Companion;
      paramb.invoke(Result.box-impl(Result.constructor-impl((List)ab.aivy)));
      AppMethodBeat.o(321837);
      return;
    }
    s.s(paramBundle, "data");
    paramBundle.setClassLoader(MonitoredBluetoothDeviceInfo.class.getClassLoader());
    paramBundle = paramBundle.getParcelableArrayList("List_MonitoredBluetoothDeviceInfo");
    if (paramBundle == null)
    {
      paramBundle = (List)ab.aivy;
      localObject1 = (Iterable)paramBundle;
      paramBundle = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
    }
    label213:
    for (;;)
    {
      label118:
      if (!((Iterator)localObject1).hasNext()) {
        break label215;
      }
      Object localObject2 = ((Iterator)localObject1).next();
      MonitoredBluetoothDeviceInfo localMonitoredBluetoothDeviceInfo = (MonitoredBluetoothDeviceInfo)localObject2;
      if (!localMonitoredBluetoothDeviceInfo.isValid())
      {
        com.tencent.mm.plugin.appbrand.device_discovery.a locala = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
        com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrandMonitoredBluetoothDeviceService", "getAllInfoAsync, deviceInfo: " + localMonitoredBluetoothDeviceInfo + " is invalid");
      }
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label213;
        }
        paramBundle.add(localObject2);
        break label118;
        paramBundle = (List)paramBundle;
        break;
      }
    }
    label215:
    paramBundle = (List)paramBundle;
    if (g.DEBUG)
    {
      localObject1 = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      localObject1 = ((Collection)paramBundle).toArray(new MonitoredBluetoothDeviceInfo[0]);
      if (localObject1 == null)
      {
        paramb = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(321837);
        throw paramb;
      }
      localObject1 = Arrays.toString((Object[])localObject1);
      s.s(localObject1, "java.util.Arrays.toString(this)");
      com.tencent.mm.plugin.appbrand.device_discovery.a.d("MicroMsg.AppBrandMonitoredBluetoothDeviceService", s.X("getAllInfo, filteredAllInfo: ", localObject1));
    }
    Object localObject1 = Result.Companion;
    paramb.invoke(Result.box-impl(Result.constructor-impl(paramBundle)));
    AppMethodBeat.o(321837);
  }
  
  private static final void a(b paramb, IPCBoolean paramIPCBoolean)
  {
    AppMethodBeat.i(321852);
    s.u(paramb, "$callback");
    if (paramIPCBoolean == null)
    {
      paramIPCBoolean = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrandMonitoredBluetoothDeviceService", "setInfoAsync, data is null");
      paramIPCBoolean = Result.Companion;
      paramb.invoke(Result.box-impl(Result.constructor-impl(ResultKt.createFailure((Throwable)new p((byte)0)))));
      AppMethodBeat.o(321852);
      return;
    }
    if (paramIPCBoolean.value) {
      paramIPCBoolean = Result.Companion;
    }
    for (paramIPCBoolean = Result.constructor-impl(ah.aiuX);; paramIPCBoolean = Result.constructor-impl(ResultKt.createFailure((Throwable)new p((byte)0))))
    {
      paramb.invoke(Result.box-impl(paramIPCBoolean));
      AppMethodBeat.o(321852);
      return;
      paramIPCBoolean = Result.Companion;
    }
  }
  
  private static final void b(b paramb, IPCBoolean paramIPCBoolean)
  {
    AppMethodBeat.i(321866);
    s.u(paramb, "$callback");
    if (paramIPCBoolean == null)
    {
      paramIPCBoolean = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrandMonitoredBluetoothDeviceService", "deleteInfoAsync, data is null");
      paramIPCBoolean = Result.Companion;
      paramb.invoke(Result.box-impl(Result.constructor-impl(ResultKt.createFailure((Throwable)new p((byte)0)))));
      AppMethodBeat.o(321866);
      return;
    }
    if (paramIPCBoolean.value) {
      paramIPCBoolean = Result.Companion;
    }
    for (paramIPCBoolean = Result.constructor-impl(ah.aiuX);; paramIPCBoolean = Result.constructor-impl(ResultKt.createFailure((Throwable)new p((byte)0))))
    {
      paramb.invoke(Result.box-impl(paramIPCBoolean));
      AppMethodBeat.o(321866);
      return;
      paramIPCBoolean = Result.Companion;
    }
  }
  
  private static final void c(IPCVoid paramIPCVoid, f paramf)
  {
    AppMethodBeat.i(321826);
    paramIPCVoid = new Bundle();
    paramIPCVoid.setClassLoader(MonitoredBluetoothDeviceInfo.class.getClassLoader());
    Object localObject = a.rgg;
    paramIPCVoid.putParcelableArrayList("List_MonitoredBluetoothDeviceInfo", new ArrayList((Collection)a.cmq()));
    localObject = ah.aiuX;
    paramf.onCallback(paramIPCVoid);
    AppMethodBeat.o(321826);
  }
  
  public static void cml()
  {
    AppMethodBeat.i(321747);
    com.tencent.mm.plugin.appbrand.device_discovery.a locala = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
    com.tencent.mm.plugin.appbrand.device_discovery.a.i("MicroMsg.AppBrandMonitoredBluetoothDeviceService", "enableMonitorAsync");
    if (!rgc)
    {
      locala = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrandMonitoredBluetoothDeviceService", "enableMonitorAsync, not in main process");
      AppMethodBeat.o(321747);
      return;
    }
    com.tencent.threadpool.h.ahAA.i((Runnable)new AppBrandMonitoredBluetoothDeviceService.d(), "MicroMsg.AppBrandMonitoredBluetoothDeviceService");
    AppMethodBeat.o(321747);
  }
  
  public static void cmm()
  {
    AppMethodBeat.i(321752);
    com.tencent.mm.plugin.appbrand.device_discovery.a locala = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
    com.tencent.mm.plugin.appbrand.device_discovery.a.i("MicroMsg.AppBrandMonitoredBluetoothDeviceService", "disableMonitorAsync");
    if (!rgc)
    {
      locala = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrandMonitoredBluetoothDeviceService", "disableMonitorAsync, not in main process");
      AppMethodBeat.o(321752);
      return;
    }
    com.tencent.threadpool.h.ahAA.i((Runnable)new AppBrandMonitoredBluetoothDeviceService.c(), "MicroMsg.AppBrandMonitoredBluetoothDeviceService");
    AppMethodBeat.o(321752);
  }
  
  public static void cs(String paramString, int paramInt)
  {
    AppMethodBeat.i(321760);
    s.u(paramString, "appId");
    com.tencent.mm.plugin.appbrand.device_discovery.a locala = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
    com.tencent.mm.plugin.appbrand.device_discovery.a.i("MicroMsg.AppBrandMonitoredBluetoothDeviceService", "deleteAppInfoAsync, appId: " + paramString + ", versionType: " + paramInt);
    if (!rgc)
    {
      paramString = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrandMonitoredBluetoothDeviceService", "deleteAppInfoAsync, not in main process");
      AppMethodBeat.o(321760);
      return;
    }
    com.tencent.threadpool.h.ahAA.i((Runnable)new AppBrandMonitoredBluetoothDeviceService.a(paramString, paramInt), "MicroMsg.AppBrandMonitoredBluetoothDeviceService");
    AppMethodBeat.o(321760);
  }
  
  public static void dv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(321784);
    s.u(paramString1, "appId");
    s.u(paramString2, "deviceId");
    Object localObject = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
    com.tencent.mm.plugin.appbrand.device_discovery.a.i("MicroMsg.AppBrandMonitoredBluetoothDeviceService", "statWeAppConnectGattSuccess, appId: " + paramString1 + ", deviceId: " + paramString2);
    if (!rgd.contains(paramString1))
    {
      paramString1 = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      com.tencent.mm.plugin.appbrand.device_discovery.a.i("MicroMsg.AppBrandMonitoredBluetoothDeviceService", "statWeAppConnectGattSuccess, we dont care");
      AppMethodBeat.o(321784);
      return;
    }
    if (rgc)
    {
      localObject = a.rgg;
      a.dv(paramString1, paramString2);
      AppMethodBeat.o(321784);
      return;
    }
    com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new WeAppConnectGattSuccessInfo(paramString1, paramString2), AppBrandMonitoredBluetoothDeviceService..ExternalSyntheticLambda2.INSTANCE);
    AppMethodBeat.o(321784);
  }
  
  private static final void e(IPCString paramIPCString, f paramf)
  {
    AppMethodBeat.i(321856);
    if (paramIPCString == null)
    {
      paramIPCString = null;
      localObject = (CharSequence)paramIPCString;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label77;
      }
    }
    label77:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label82;
      }
      paramIPCString = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrandMonitoredBluetoothDeviceService", "deleteInfoAsync, passedWechatToken is empty");
      paramf.onCallback(new IPCBoolean(false));
      AppMethodBeat.o(321856);
      return;
      paramIPCString = paramIPCString.value;
      break;
    }
    label82:
    Object localObject = a.rgg;
    paramf.onCallback(new IPCBoolean(a.YC(paramIPCString)));
    AppMethodBeat.o(321856);
  }
  
  public static void e(final String paramString, b<? super Result<ah>, ah> paramb)
  {
    AppMethodBeat.i(321807);
    s.u(paramString, "wechatToken");
    s.u(paramb, "callback");
    com.tencent.mm.plugin.appbrand.device_discovery.a locala = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
    com.tencent.mm.plugin.appbrand.device_discovery.a.i("MicroMsg.AppBrandMonitoredBluetoothDeviceService", s.X("deleteInfoAsync, wechatToken: ", paramString));
    if (rgc)
    {
      com.tencent.threadpool.h.ahAA.i((Runnable)new b(paramb, paramString), "MicroMsg.AppBrandMonitoredBluetoothDeviceService");
      AppMethodBeat.o(321807);
      return;
    }
    com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new IPCString(paramString), AppBrandMonitoredBluetoothDeviceService..ExternalSyntheticLambda0.INSTANCE, new AppBrandMonitoredBluetoothDeviceService..ExternalSyntheticLambda6(paramb));
    AppMethodBeat.o(321807);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/AppBrandMonitoredBluetoothDeviceService$WeAppConnectGattSuccessInfo;", "Landroid/os/Parcelable;", "appId", "", "deviceId", "(Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getDeviceId", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class WeAppConnectGattSuccessInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<WeAppConnectGattSuccessInfo> CREATOR;
    final String appId;
    final String hEl;
    
    static
    {
      AppMethodBeat.i(321664);
      CREATOR = (Parcelable.Creator)new a();
      AppMethodBeat.o(321664);
    }
    
    public WeAppConnectGattSuccessInfo(String paramString1, String paramString2)
    {
      AppMethodBeat.i(321658);
      this.appId = paramString1;
      this.hEl = paramString2;
      AppMethodBeat.o(321658);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(321686);
      s.u(paramParcel, "out");
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.hEl);
      AppMethodBeat.o(321686);
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Parcelable.Creator<AppBrandMonitoredBluetoothDeviceService.WeAppConnectGattSuccessInfo>
    {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/AppBrandMonitoredBluetoothDeviceService$deleteInfoAsync$1", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "getKey", "", "run", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.threadpool.i.h
  {
    b(b<? super Result<ah>, ah> paramb, String paramString) {}
    
    public final String getKey()
    {
      AppMethodBeat.i(321672);
      String str = s.X("DeleteMonitoredBluetoothDeviceInfo#", Integer.valueOf(hashCode()));
      AppMethodBeat.o(321672);
      return str;
    }
    
    public final void run()
    {
      AppMethodBeat.i(321682);
      b localb = this.$callback;
      Object localObject = a.rgg;
      if (a.YC(paramString)) {
        localObject = Result.Companion;
      }
      for (localObject = Result.constructor-impl(ah.aiuX);; localObject = Result.constructor-impl(ResultKt.createFailure((Throwable)new p((byte)0))))
      {
        localb.invoke(Result.box-impl(localObject));
        AppMethodBeat.o(321682);
        return;
        localObject = Result.Companion;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/AppBrandMonitoredBluetoothDeviceService$setInfoAsync$1", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "getKey", "", "run", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements com.tencent.threadpool.i.h
  {
    f(b<? super Result<ah>, ah> paramb, MonitoredBluetoothDeviceInfo paramMonitoredBluetoothDeviceInfo) {}
    
    public final String getKey()
    {
      AppMethodBeat.i(321702);
      String str = s.X("SetMonitoredBluetoothDeviceInfo#", Integer.valueOf(hashCode()));
      AppMethodBeat.o(321702);
      return str;
    }
    
    public final void run()
    {
      AppMethodBeat.i(321711);
      b localb = this.$callback;
      Object localObject = a.rgg;
      if (a.c(paramMonitoredBluetoothDeviceInfo)) {
        localObject = Result.Companion;
      }
      for (localObject = Result.constructor-impl(ah.aiuX);; localObject = Result.constructor-impl(ResultKt.createFailure((Throwable)new p((byte)0))))
      {
        localb.invoke(Result.box-impl(localObject));
        AppMethodBeat.o(321711);
        return;
        localObject = Result.Companion;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.AppBrandMonitoredBluetoothDeviceService
 * JD-Core Version:    0.7.0.1
 */