package com.tencent.mm.plugin.appbrand.device_discovery.bluetooth;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.r;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.appbrand.task.i.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.k;
import kotlin.o;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/AppBrandMonitoredBluetoothDeviceServiceCore;", "", "()V", "INFO_OP_BLOCK_OR_UNBLOCK", "", "INFO_OP_DELETE", "INFO_OP_INSERT_OR_UPDATE", "TAG", "", "appId2DeviceId2HasConnectedMap", "", "", "gattConnectListener", "Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/IGattConnectListener;", "getGattConnectListener", "()Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/IGattConnectListener;", "gattConnectListener$delegate", "Lkotlin/Lazy;", "infoStorage", "Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/MonitoredBluetoothDeviceInfoStorage;", "getInfoStorage", "()Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/MonitoredBluetoothDeviceInfoStorage;", "isMonitor", "monitoredConnectedDeviceIds", "", "monitoredDeviceId2ConnectStrategyMap", "Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/IAutoConnectGattStrategy;", "monitoredDeviceId2InfoMap", "Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/MonitoredBluetoothDeviceInfo;", "pendingOnFounds", "startedWeApps", "Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/AppBrandMonitoredBluetoothDeviceServiceCore$WeApp;", "startingWeApp", "blockAppInfo", "appId", "deleteAppInfo", "versionType", "deleteInfo", "wechatToken", "disableMonitor", "", "doMonitor", "deviceInfo", "enableMonitor", "getAllInfo", "", "onInfoChange", "op", "deviceInfoList", "", "(I[Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/MonitoredBluetoothDeviceInfo;)V", "pauseConnect", "deviceId", "resumeConnect", "setInfo", "info", "startWeAppOnBluetoothDeviceFound", "isConnected", "statWeAppConnectGattSuccess", "statWeAppSuspend", "unblockAppInfo", "undoMonitor", "alsoIfTrue", "block", "Lkotlin/Function0;", "InfoOp", "WeApp", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a rgg;
  private static volatile boolean rgh;
  private static final Map<String, MonitoredBluetoothDeviceInfo> rgi;
  private static final Map<String, j> rgj;
  private static final Set<String> rgk;
  private static final Map<String, Map<String, Boolean>> rgl;
  private static final kotlin.j rgm;
  private static volatile a rgn;
  private static final Set<MonitoredBluetoothDeviceInfo> rgo;
  private static final Set<a> rgp;
  
  static
  {
    AppMethodBeat.i(321876);
    rgg = new a();
    rgi = (Map)new ConcurrentHashMap();
    rgj = (Map)new ConcurrentHashMap();
    Set localSet = Collections.newSetFromMap((Map)new ConcurrentHashMap());
    kotlin.g.b.s.s(localSet, "newSetFromMap(ConcurrentHashMap())");
    rgk = localSet;
    rgl = (Map)new ConcurrentHashMap();
    rgm = k.a(o.aiuH, (kotlin.g.a.a)c.rgs);
    rgo = (Set)new CopyOnWriteArraySet();
    rgp = (Set)new CopyOnWriteArraySet();
    new AppBrandMonitoredBluetoothDeviceServiceCore.1(com.tencent.mm.app.f.hfK).alive();
    new AppBrandMonitoredBluetoothDeviceServiceCore.2(com.tencent.mm.app.f.hfK).alive();
    AppMethodBeat.o(321876);
  }
  
  public static boolean YA(String paramString)
  {
    AppMethodBeat.i(321720);
    kotlin.g.b.s.u(paramString, "appId");
    n localn = cmn();
    if (localn == null) {
      paramString = null;
    }
    while (paramString == null)
    {
      paramString = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", "blockAppInfo, fail");
      AppMethodBeat.o(321720);
      return false;
      paramString = localn.YH(paramString);
      if (paramString == null)
      {
        paramString = null;
      }
      else
      {
        paramString = ((Collection)paramString).toArray(new MonitoredBluetoothDeviceInfo[0]);
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
          AppMethodBeat.o(321720);
          throw paramString;
        }
        paramString = (MonitoredBluetoothDeviceInfo[])paramString;
        a(3, (MonitoredBluetoothDeviceInfo[])Arrays.copyOf(paramString, paramString.length));
        paramString = Boolean.TRUE;
      }
    }
    boolean bool = paramString.booleanValue();
    AppMethodBeat.o(321720);
    return bool;
  }
  
  public static boolean YB(String paramString)
  {
    AppMethodBeat.i(321730);
    kotlin.g.b.s.u(paramString, "appId");
    n localn = cmn();
    if (localn == null) {
      paramString = null;
    }
    while (paramString == null)
    {
      paramString = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", "unblockAppInfo, fail");
      AppMethodBeat.o(321730);
      return false;
      paramString = localn.YI(paramString);
      if (paramString == null)
      {
        paramString = null;
      }
      else
      {
        paramString = ((Collection)paramString).toArray(new MonitoredBluetoothDeviceInfo[0]);
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
          AppMethodBeat.o(321730);
          throw paramString;
        }
        paramString = (MonitoredBluetoothDeviceInfo[])paramString;
        a(3, (MonitoredBluetoothDeviceInfo[])Arrays.copyOf(paramString, paramString.length));
        paramString = Boolean.TRUE;
      }
    }
    boolean bool = paramString.booleanValue();
    AppMethodBeat.o(321730);
    return bool;
  }
  
  public static boolean YC(String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(321737);
    kotlin.g.b.s.u(paramString, "wechatToken");
    Object localObject2 = cmn();
    if (localObject2 == null) {
      paramString = localObject1;
    }
    while (paramString == null)
    {
      paramString = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", "deleteInfo, fail");
      AppMethodBeat.o(321737);
      return false;
      localObject2 = ((n)localObject2).YJ(paramString);
      paramString = localObject1;
      if (localObject2 != null)
      {
        a(2, new MonitoredBluetoothDeviceInfo[] { localObject2 });
        paramString = Boolean.TRUE;
      }
    }
    boolean bool = paramString.booleanValue();
    AppMethodBeat.o(321737);
    return bool;
  }
  
  private static void YD(String paramString)
  {
    AppMethodBeat.i(321766);
    paramString = (Map)rgl.get(paramString);
    if (paramString == null)
    {
      paramString = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", "resumeConnect, deviceId2HasConnectedMap is null");
      AppMethodBeat.o(321766);
      return;
    }
    paramString = paramString.entrySet().iterator();
    while (paramString.hasNext())
    {
      Object localObject2 = (Map.Entry)paramString.next();
      Object localObject1 = (String)((Map.Entry)localObject2).getKey();
      boolean bool = ((Boolean)((Map.Entry)localObject2).getValue()).booleanValue();
      localObject2 = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      com.tencent.mm.plugin.appbrand.device_discovery.a.i("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", "resumeConnect, deviceId: " + (String)localObject1 + ", hasConnected: " + bool);
      localObject1 = (j)rgj.get(localObject1);
      if (localObject1 != null) {
        ((j)localObject1).iO(bool);
      }
    }
    AppMethodBeat.o(321766);
  }
  
  public static void Yz(String paramString)
  {
    AppMethodBeat.i(321673);
    kotlin.g.b.s.u(paramString, "appId");
    com.tencent.mm.plugin.appbrand.device_discovery.a locala = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
    com.tencent.mm.plugin.appbrand.device_discovery.a.i("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", kotlin.g.b.s.X("statWeAppSuspend, appId: ", paramString));
    com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new IPCString(paramString), a..ExternalSyntheticLambda0.INSTANCE, null);
    AppMethodBeat.o(321673);
  }
  
  private static void a(int paramInt, MonitoredBluetoothDeviceInfo... paramVarArgs)
  {
    int k = 0;
    int m = 0;
    int j = 0;
    AppMethodBeat.i(321758);
    Object localObject1;
    Object localObject2;
    if (g.DEBUG)
    {
      localObject1 = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      localObject1 = new StringBuilder("onInfoChange, op: ").append(paramInt).append(", deviceInfoList: ");
      localObject2 = Arrays.toString(paramVarArgs);
      kotlin.g.b.s.s(localObject2, "java.util.Arrays.toString(this)");
      com.tencent.mm.plugin.appbrand.device_discovery.a.d("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", (String)localObject2);
      if (paramVarArgs.length != 0) {
        break label129;
      }
    }
    label129:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label134;
      }
      paramVarArgs = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", "onInfoChange, deviceInfoList is empty");
      AppMethodBeat.o(321758);
      return;
      localObject1 = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      com.tencent.mm.plugin.appbrand.device_discovery.a.i("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", kotlin.g.b.s.X("onInfoChange, op: ", Integer.valueOf(paramInt)));
      break;
    }
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(321758);
      return;
    case 1: 
      label134:
      i = paramVarArgs.length;
      paramInt = j;
    }
    label571:
    while (paramInt < i)
    {
      localObject2 = paramVarArgs[paramInt];
      paramInt += 1;
      if (!((MonitoredBluetoothDeviceInfo)localObject2).isValid())
      {
        localObject1 = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
        com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", "onInfoChange, deviceInfo is invalid");
      }
      else
      {
        g.a((MonitoredBluetoothDeviceInfo)localObject2, s.rhu);
        localObject1 = ((MonitoredBluetoothDeviceInfo)localObject2).field_bluetoothDeviceId;
        kotlin.g.b.s.checkNotNull(localObject1);
        if (!rgi.containsKey(localObject1))
        {
          localObject1 = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
          com.tencent.mm.plugin.appbrand.device_discovery.a.i("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", "onInfoChange, is insert");
          if (!((MonitoredBluetoothDeviceInfo)localObject2).field_isBlocked) {
            a((MonitoredBluetoothDeviceInfo)localObject2);
          }
        }
        else
        {
          localObject1 = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
          com.tencent.mm.plugin.appbrand.device_discovery.a.i("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", "onInfoChange, is update");
          Object localObject3 = ((Iterable)rgi.values()).iterator();
          do
          {
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject1 = ((Iterator)localObject3).next();
          } while (!kotlin.g.b.s.p(((MonitoredBluetoothDeviceInfo)localObject1).field_wechatToken, ((MonitoredBluetoothDeviceInfo)localObject2).field_wechatToken));
          for (;;)
          {
            localObject1 = (MonitoredBluetoothDeviceInfo)localObject1;
            if (localObject1 != null) {
              b((MonitoredBluetoothDeviceInfo)localObject1);
            }
            if (((MonitoredBluetoothDeviceInfo)localObject2).field_isBlocked) {
              break label571;
            }
            a((MonitoredBluetoothDeviceInfo)localObject2);
            break;
            localObject1 = null;
          }
          i = paramVarArgs.length;
          paramInt = k;
          while (paramInt < i)
          {
            localObject1 = paramVarArgs[paramInt];
            paramInt += 1;
            if (!((MonitoredBluetoothDeviceInfo)localObject1).isValid())
            {
              localObject1 = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
              com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", "onInfoChange, deviceInfo is invalid");
            }
            else
            {
              g.a((MonitoredBluetoothDeviceInfo)localObject1, s.rhv);
              b((MonitoredBluetoothDeviceInfo)localObject1);
            }
          }
          j = paramVarArgs.length;
          paramInt = m;
          while (paramInt < j)
          {
            localObject1 = paramVarArgs[paramInt];
            i = paramInt + 1;
            if (!((MonitoredBluetoothDeviceInfo)localObject1).isValid())
            {
              localObject1 = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
              com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", "onInfoChange, deviceInfo is invalid");
              paramInt = i;
            }
            else if (!((MonitoredBluetoothDeviceInfo)localObject1).field_isBlocked)
            {
              localObject2 = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
              com.tencent.mm.plugin.appbrand.device_discovery.a.i("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", "onInfoChange, unblock");
              localObject2 = rgi;
              localObject3 = ((MonitoredBluetoothDeviceInfo)localObject1).field_bluetoothDeviceId;
              kotlin.g.b.s.checkNotNull(localObject3);
              paramInt = i;
              if (!((Map)localObject2).containsKey(localObject3))
              {
                a((MonitoredBluetoothDeviceInfo)localObject1);
                paramInt = i;
              }
            }
            else
            {
              localObject2 = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
              com.tencent.mm.plugin.appbrand.device_discovery.a.i("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", "onInfoChange, block");
              b((MonitoredBluetoothDeviceInfo)localObject1);
              paramInt = i;
            }
          }
          break;
        }
      }
    }
  }
  
  private static void a(MonitoredBluetoothDeviceInfo paramMonitoredBluetoothDeviceInfo)
  {
    AppMethodBeat.i(321695);
    if (!rgh)
    {
      paramMonitoredBluetoothDeviceInfo = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", "doMonitor, isMonitor is false");
      AppMethodBeat.o(321695);
      return;
    }
    com.tencent.mm.view.f.bt((kotlin.g.a.a)new b(paramMonitoredBluetoothDeviceInfo));
    AppMethodBeat.o(321695);
  }
  
  private static void b(MonitoredBluetoothDeviceInfo paramMonitoredBluetoothDeviceInfo)
  {
    AppMethodBeat.i(321698);
    if (!rgh)
    {
      paramMonitoredBluetoothDeviceInfo = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", "undoMonitor, isMonitor is false");
      AppMethodBeat.o(321698);
      return;
    }
    com.tencent.mm.view.f.bt((kotlin.g.a.a)new f(paramMonitoredBluetoothDeviceInfo));
    AppMethodBeat.o(321698);
  }
  
  public static boolean c(MonitoredBluetoothDeviceInfo paramMonitoredBluetoothDeviceInfo)
  {
    AppMethodBeat.i(321715);
    kotlin.g.b.s.u(paramMonitoredBluetoothDeviceInfo, "info");
    Object localObject = cmn();
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = Boolean.valueOf(((n)localObject).c(paramMonitoredBluetoothDeviceInfo)))
    {
      paramMonitoredBluetoothDeviceInfo = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", "setInfo, infoStorage is null");
      AppMethodBeat.o(321715);
      return false;
      paramMonitoredBluetoothDeviceInfo.field_updateTime = System.currentTimeMillis();
      ah localah = ah.aiuX;
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    if (bool) {
      a(1, new MonitoredBluetoothDeviceInfo[] { paramMonitoredBluetoothDeviceInfo });
    }
    AppMethodBeat.o(321715);
    return bool;
  }
  
  private static n cmn()
  {
    AppMethodBeat.i(321657);
    Object localObject = n.rhn;
    localObject = (n)com.tencent.mm.plugin.appbrand.app.n.ag(n.class);
    AppMethodBeat.o(321657);
    return localObject;
  }
  
  public static void cmo()
  {
    AppMethodBeat.i(321681);
    Object localObject = e.rgJ;
    if (!e.cmH())
    {
      localObject = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", "enableMonitor, isSupportLE is false");
      AppMethodBeat.o(321681);
      return;
    }
    boolean bool = rgh;
    localObject = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
    com.tencent.mm.plugin.appbrand.device_discovery.a.i("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", kotlin.g.b.s.X("enableMonitor, curIsMonitor: ", Boolean.valueOf(bool)));
    if (bool)
    {
      AppMethodBeat.o(321681);
      return;
    }
    rgh = true;
    localObject = e.rgJ;
    e.a(a..ExternalSyntheticLambda1.INSTANCE);
    AppMethodBeat.o(321681);
  }
  
  public static void cmp()
  {
    AppMethodBeat.i(321689);
    Object localObject = e.rgJ;
    if (!e.cmH())
    {
      localObject = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", "enableMonitor, isSupportLE is false");
      AppMethodBeat.o(321689);
      return;
    }
    boolean bool = rgh;
    localObject = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
    com.tencent.mm.plugin.appbrand.device_discovery.a.i("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", kotlin.g.b.s.X("disableMonitor, curIsMonitor: ", Boolean.valueOf(bool)));
    if (!bool)
    {
      AppMethodBeat.o(321689);
      return;
    }
    localObject = ((Iterable)rgi.values()).iterator();
    while (((Iterator)localObject).hasNext()) {
      b((MonitoredBluetoothDeviceInfo)((Iterator)localObject).next());
    }
    localObject = e.rgJ;
    e.a(null);
    rgh = false;
    AppMethodBeat.o(321689);
  }
  
  public static List<MonitoredBluetoothDeviceInfo> cmq()
  {
    AppMethodBeat.i(321707);
    Object localObject1 = cmn();
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
        com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", "getAllInfo, infoStorage is null");
        localObject2 = (List)ab.aivy;
      }
      localObject2 = (Iterable)localObject2;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
    }
    label156:
    for (;;)
    {
      label64:
      if (!((Iterator)localObject2).hasNext()) {
        break label158;
      }
      Object localObject3 = ((Iterator)localObject2).next();
      MonitoredBluetoothDeviceInfo localMonitoredBluetoothDeviceInfo = (MonitoredBluetoothDeviceInfo)localObject3;
      if (!localMonitoredBluetoothDeviceInfo.isValid())
      {
        com.tencent.mm.plugin.appbrand.device_discovery.a locala = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
        com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", "getAllInfo, deviceInfo: " + localMonitoredBluetoothDeviceInfo + " is invalid");
      }
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label156;
        }
        ((Collection)localObject1).add(localObject3);
        break label64;
        localObject1 = ((n)localObject1).cmq();
        break;
      }
    }
    label158:
    localObject1 = (List)localObject1;
    if (g.DEBUG)
    {
      localObject2 = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      localObject2 = ((Collection)localObject1).toArray(new MonitoredBluetoothDeviceInfo[0]);
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(321707);
        throw ((Throwable)localObject1);
      }
      localObject2 = Arrays.toString((Object[])localObject2);
      kotlin.g.b.s.s(localObject2, "java.util.Arrays.toString(this)");
      com.tencent.mm.plugin.appbrand.device_discovery.a.d("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", kotlin.g.b.s.X("getAllInfo, filteredAllInfo: ", localObject2));
    }
    AppMethodBeat.o(321707);
    return localObject1;
  }
  
  public static boolean ct(String paramString, int paramInt)
  {
    AppMethodBeat.i(321745);
    kotlin.g.b.s.u(paramString, "appId");
    n localn = cmn();
    if (localn == null) {
      paramString = null;
    }
    while (paramString == null)
    {
      paramString = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", "deleteAppInfo, fail");
      AppMethodBeat.o(321745);
      return false;
      paramString = localn.cu(paramString, paramInt);
      if (paramString == null)
      {
        paramString = null;
      }
      else
      {
        paramString = ((Collection)paramString).toArray(new MonitoredBluetoothDeviceInfo[0]);
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
          AppMethodBeat.o(321745);
          throw paramString;
        }
        paramString = (MonitoredBluetoothDeviceInfo[])paramString;
        a(2, (MonitoredBluetoothDeviceInfo[])Arrays.copyOf(paramString, paramString.length));
        paramString = Boolean.TRUE;
      }
    }
    boolean bool = paramString.booleanValue();
    AppMethodBeat.o(321745);
    return bool;
  }
  
  public static void dv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(321665);
    kotlin.g.b.s.u(paramString1, "appId");
    kotlin.g.b.s.u(paramString2, "deviceId");
    com.tencent.mm.plugin.appbrand.device_discovery.a locala = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
    com.tencent.mm.plugin.appbrand.device_discovery.a.i("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", "statWeAppConnectGattSuccess, appId: " + paramString1 + ", deviceId: " + paramString2);
    paramString1 = (Map)rgl.get(paramString1);
    if (paramString1 == null) {}
    for (paramString1 = null;; paramString1 = (Boolean)paramString1.put(paramString2, Boolean.TRUE))
    {
      if (paramString1 == null)
      {
        paramString1 = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
        com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", "statWeAppConnectGattSuccess, we dont care");
      }
      AppMethodBeat.o(321665);
      return;
    }
  }
  
  private static final void f(IPCString paramIPCString, com.tencent.mm.ipcinvoker.f paramf)
  {
    AppMethodBeat.i(321774);
    if (paramIPCString == null) {}
    for (paramIPCString = null; paramIPCString == null; paramIPCString = paramIPCString.value)
    {
      paramIPCString = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", "statWeAppSuspend, passedAppId is null");
      AppMethodBeat.o(321774);
      return;
    }
    YD(paramIPCString);
    AppMethodBeat.o(321774);
  }
  
  private static final void iN(boolean paramBoolean)
  {
    AppMethodBeat.i(321787);
    Object localObject1 = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
    com.tencent.mm.plugin.appbrand.device_discovery.a.i("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", kotlin.g.b.s.X("onBluetoothStateChange, isOn: ", Boolean.valueOf(paramBoolean)));
    if (!rgh)
    {
      localObject1 = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      com.tencent.mm.plugin.appbrand.device_discovery.a.i("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", "onBluetoothStateChange, isMonitor is false");
      AppMethodBeat.o(321787);
      return;
    }
    if (paramBoolean)
    {
      Object localObject2 = (Iterable)cmq();
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label128:
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if (!((MonitoredBluetoothDeviceInfo)localObject3).field_isBlocked) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label128;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        a((MonitoredBluetoothDeviceInfo)((Iterator)localObject2).next());
        ((Collection)localObject1).add(ah.aiuX);
      }
      AppMethodBeat.o(321787);
      return;
    }
    localObject1 = ((Iterable)rgi.values()).iterator();
    while (((Iterator)localObject1).hasNext()) {
      b((MonitoredBluetoothDeviceInfo)((Iterator)localObject1).next());
    }
    AppMethodBeat.o(321787);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/AppBrandMonitoredBluetoothDeviceServiceCore$WeApp;", "", "appId", "", "versionType", "", "(Ljava/lang/String;I)V", "getAppId", "()Ljava/lang/String;", "getVersionType", "()I", "component1", "component2", "copy", "equals", "", "other", "getRunningStateAsync", "", "onRunningStateGot", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/WeAppRunningState;", "hashCode", "isInBackgroundTemporary", "isRunning", "onBluetoothDeviceFound", "deviceInfo", "Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/MonitoredBluetoothDeviceInfo;", "(Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/MonitoredBluetoothDeviceInfo;)Lkotlin/Unit;", "toString", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
  {
    final String appId;
    final int euz;
    
    public a(String paramString, int paramInt)
    {
      AppMethodBeat.i(321716);
      this.appId = paramString;
      this.euz = paramInt;
      AppMethodBeat.o(321716);
    }
    
    private static final IPCBoolean b(IPCString paramIPCString)
    {
      Object localObject = null;
      boolean bool2 = false;
      AppMethodBeat.i(321724);
      if (paramIPCString == null) {}
      for (paramIPCString = null; paramIPCString == null; paramIPCString = paramIPCString.value)
      {
        paramIPCString = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
        com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", "isInBackgroundTemporary, passedAppId is null");
        paramIPCString = new IPCBoolean(false);
        AppMethodBeat.o(321724);
        return paramIPCString;
      }
      paramIPCString = com.tencent.mm.plugin.appbrand.d.Uc(paramIPCString);
      if (paramIPCString == null) {}
      for (paramIPCString = localObject; paramIPCString == null; paramIPCString = paramIPCString.qsB)
      {
        paramIPCString = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
        com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", "isInBackgroundTemporary, runningStateController is null");
        paramIPCString = new IPCBoolean(false);
        AppMethodBeat.o(321724);
        return paramIPCString;
      }
      boolean bool1 = bool2;
      if (com.tencent.mm.plugin.appbrand.b.b.qKx == paramIPCString.qKC.chD())
      {
        bool1 = bool2;
        if (!paramIPCString.qKC.chF()) {
          bool1 = true;
        }
      }
      paramIPCString = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      com.tencent.mm.plugin.appbrand.device_discovery.a.i("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", kotlin.g.b.s.X("isInBackgroundTemporary, isInBackgroundTemporary: ", Boolean.valueOf(bool1)));
      paramIPCString = new IPCBoolean(bool1);
      AppMethodBeat.o(321724);
      return paramIPCString;
    }
    
    private static final void b(MonitoredBluetoothDeviceInfo paramMonitoredBluetoothDeviceInfo, com.tencent.mm.ipcinvoker.f paramf)
    {
      int i = 1;
      AppMethodBeat.i(321741);
      if ((paramMonitoredBluetoothDeviceInfo != null) && (true == paramMonitoredBluetoothDeviceInfo.isValid())) {}
      while (i == 0)
      {
        paramf = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
        com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", "onBluetoothDeviceFound, passedInfo: " + paramMonitoredBluetoothDeviceInfo + " is invalid");
        AppMethodBeat.o(321741);
        return;
        i = 0;
      }
      kotlin.g.b.s.s(paramMonitoredBluetoothDeviceInfo, "passedInfo");
      r.a(new r(paramMonitoredBluetoothDeviceInfo));
      AppMethodBeat.o(321741);
    }
    
    private static final void g(IPCString paramIPCString, com.tencent.mm.ipcinvoker.f paramf)
    {
      com.tencent.mm.plugin.appbrand.device_discovery.a locala = null;
      AppMethodBeat.i(321734);
      if (paramIPCString == null) {}
      for (paramIPCString = null; paramIPCString == null; paramIPCString = paramIPCString.value)
      {
        paramIPCString = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
        com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", "getRunningStateAsync, passedAppId is null");
        paramf.onCallback(new IPCInteger(t.rhG.rht));
        AppMethodBeat.o(321734);
        return;
      }
      paramIPCString = com.tencent.mm.plugin.appbrand.d.Uc(paramIPCString);
      if (paramIPCString == null) {}
      for (paramIPCString = locala; paramIPCString == null; paramIPCString = paramIPCString.qsB)
      {
        paramIPCString = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
        com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", "getRunningStateAsync, runningStateController is null");
        paramf.onCallback(new IPCInteger(t.rhG.rht));
        AppMethodBeat.o(321734);
        return;
      }
      paramIPCString = paramIPCString.qKC.chD();
      if (paramIPCString == null)
      {
        paramIPCString = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
        com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", "getRunningStateAsync, curState is null");
        paramf.onCallback(new IPCInteger(t.rhG.rht));
        AppMethodBeat.o(321734);
        return;
      }
      switch (a.$EnumSwitchMapping$0[paramIPCString.ordinal()])
      {
      default: 
        paramIPCString = new kotlin.p();
        AppMethodBeat.o(321734);
        throw paramIPCString;
      case 1: 
        paramIPCString = t.rhD;
      }
      for (;;)
      {
        locala = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
        com.tencent.mm.plugin.appbrand.device_discovery.a.i("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", kotlin.g.b.s.X("getRunningStateAsync, runningState: ", paramIPCString));
        paramf.onCallback(new IPCInteger(paramIPCString.rht));
        AppMethodBeat.o(321734);
        return;
        paramIPCString = t.rhE;
        continue;
        paramIPCString = t.rhF;
        continue;
        paramIPCString = t.rhG;
      }
    }
    
    public final void P(kotlin.g.a.b<? super t, ah> paramb)
    {
      AppMethodBeat.i(321779);
      kotlin.g.b.s.u(paramb, "onRunningStateGot");
      Object localObject = i.tWq;
      localObject = i.a.cJV();
      com.tencent.luggage.sdk.processes.e locale = ((i)localObject).D(this.appId, this.euz);
      if (locale == null)
      {
        localObject = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
        com.tencent.mm.plugin.appbrand.device_discovery.a.i("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", "getRunningStateAsync, aliveAppRecord is null");
        paramb.invoke(t.rhG);
        AppMethodBeat.o(321779);
        return;
      }
      localObject = ((com.tencent.mm.plugin.appbrand.task.d)((i)localObject).b(locale)).getProcessName();
      if (localObject == null)
      {
        localObject = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
        com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", "getRunningStateAsync, processName is null");
        paramb.invoke(t.rhG);
        AppMethodBeat.o(321779);
        return;
      }
      com.tencent.mm.ipcinvoker.a.a((String)localObject, (Parcelable)new IPCString(this.appId), a.a..ExternalSyntheticLambda0.INSTANCE, (kotlin.g.a.b)new a.a.b(paramb));
      AppMethodBeat.o(321779);
    }
    
    public final boolean cmy()
    {
      AppMethodBeat.i(321769);
      Object localObject = i.tWq;
      localObject = i.a.cJV();
      com.tencent.luggage.sdk.processes.e locale = ((i)localObject).D(this.appId, this.euz);
      if (locale == null)
      {
        AppMethodBeat.o(321769);
        return false;
      }
      localObject = (com.tencent.mm.plugin.appbrand.task.d)((i)localObject).b(locale);
      if (localObject == null)
      {
        AppMethodBeat.o(321769);
        return false;
      }
      localObject = ((com.tencent.mm.plugin.appbrand.task.d)localObject).getProcessName();
      if (localObject == null)
      {
        AppMethodBeat.o(321769);
        return false;
      }
      localObject = (IPCBoolean)com.tencent.mm.ipcinvoker.a.a((String)localObject, (Parcelable)new IPCString(this.appId), a.a..ExternalSyntheticLambda2.INSTANCE);
      if (localObject == null) {}
      for (localObject = null; localObject == null; localObject = Boolean.valueOf(((IPCBoolean)localObject).value))
      {
        AppMethodBeat.o(321769);
        return false;
      }
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(321769);
      return bool;
    }
    
    public final ah d(MonitoredBluetoothDeviceInfo paramMonitoredBluetoothDeviceInfo)
    {
      AppMethodBeat.i(321789);
      kotlin.g.b.s.u(paramMonitoredBluetoothDeviceInfo, "deviceInfo");
      Object localObject = i.tWq;
      localObject = i.a.cJV();
      com.tencent.luggage.sdk.processes.e locale = ((i)localObject).D(this.appId, this.euz);
      if (locale == null)
      {
        AppMethodBeat.o(321789);
        return null;
      }
      localObject = (com.tencent.mm.plugin.appbrand.task.d)((i)localObject).b(locale);
      if (localObject == null)
      {
        AppMethodBeat.o(321789);
        return null;
      }
      localObject = ((com.tencent.mm.plugin.appbrand.task.d)localObject).getProcessName();
      if (localObject == null)
      {
        AppMethodBeat.o(321789);
        return null;
      }
      com.tencent.mm.ipcinvoker.a.a((String)localObject, (Parcelable)paramMonitoredBluetoothDeviceInfo, a.a..ExternalSyntheticLambda1.INSTANCE);
      paramMonitoredBluetoothDeviceInfo = ah.aiuX;
      AppMethodBeat.o(321789);
      return paramMonitoredBluetoothDeviceInfo;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(321806);
      if (this == paramObject)
      {
        AppMethodBeat.o(321806);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(321806);
        return false;
      }
      paramObject = (a)paramObject;
      if (!kotlin.g.b.s.p(this.appId, paramObject.appId))
      {
        AppMethodBeat.o(321806);
        return false;
      }
      if (this.euz != paramObject.euz)
      {
        AppMethodBeat.o(321806);
        return false;
      }
      AppMethodBeat.o(321806);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(321800);
      int i = this.appId.hashCode();
      int j = this.euz;
      AppMethodBeat.o(321800);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(321793);
      String str = "WeApp(appId=" + this.appId + ", versionType=" + this.euz + ')';
      AppMethodBeat.o(321793);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(MonitoredBluetoothDeviceInfo paramMonitoredBluetoothDeviceInfo)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/IGattConnectListener;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<l>
  {
    public static final c rgs;
    
    static
    {
      AppMethodBeat.i(321727);
      rgs = new c();
      AppMethodBeat.o(321727);
    }
    
    c()
    {
      super();
    }
    
    private static final void a(MonitoredBluetoothDeviceInfo paramMonitoredBluetoothDeviceInfo, boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(321714);
      g.a(paramMonitoredBluetoothDeviceInfo, s.rhw);
      a locala = a.rgg;
      if ((a.a(paramMonitoredBluetoothDeviceInfo, paramBoolean)) && (!paramBoolean))
      {
        locala = a.rgg;
        paramMonitoredBluetoothDeviceInfo = paramMonitoredBluetoothDeviceInfo.field_appId;
        kotlin.g.b.s.s(paramMonitoredBluetoothDeviceInfo, "deviceInfo.field_appId");
        a.dw(paramMonitoredBluetoothDeviceInfo, paramString);
      }
      AppMethodBeat.o(321714);
    }
    
    private static final void ay(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(321721);
      kotlin.g.b.s.u(paramString, "deviceId");
      Object localObject = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      com.tencent.mm.plugin.appbrand.device_discovery.a.i("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", "onConnectStateChange, deviceId: " + paramString + ", isConnected: " + paramBoolean);
      localObject = (MonitoredBluetoothDeviceInfo)a.cmu().get(paramString);
      if (localObject == null)
      {
        paramString = a.rgg;
        paramString = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
        com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", "onConnectStateChange, deviceInfo is null");
        AppMethodBeat.o(321721);
        return;
      }
      if (paramBoolean)
      {
        a.cmx().add(paramString);
        a((MonitoredBluetoothDeviceInfo)localObject, paramBoolean, paramString);
        AppMethodBeat.o(321721);
        return;
      }
      if (!a.cmx().remove(paramString))
      {
        a((MonitoredBluetoothDeviceInfo)localObject, paramBoolean, paramString);
        AppMethodBeat.o(321721);
        return;
      }
      paramString = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      com.tencent.mm.plugin.appbrand.device_discovery.a.i("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", "onConnectStateChange, maybe device away");
      AppMethodBeat.o(321721);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(MonitoredBluetoothDeviceInfo paramMonitoredBluetoothDeviceInfo)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.a
 * JD-Core Version:    0.7.0.1
 */