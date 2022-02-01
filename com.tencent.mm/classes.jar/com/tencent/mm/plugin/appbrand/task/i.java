package com.tencent.mm.plugin.appbrand.task;

import android.app.Activity;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.backgroundrunning.service.AppBrandForegroundNotificationService;
import com.tencent.mm.plugin.appbrand.backgroundrunning.service.AppBrandForegroundNotificationService1;
import com.tencent.mm.plugin.appbrand.backgroundrunning.service.AppBrandForegroundNotificationService2;
import com.tencent.mm.plugin.appbrand.backgroundrunning.service.AppBrandForegroundNotificationService3;
import com.tencent.mm.plugin.appbrand.backgroundrunning.service.AppBrandForegroundNotificationService4;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService1;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService2;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService3;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService4;
import com.tencent.mm.plugin.appbrand.launching.WeAppOpenUICallbackIPCProxy.c;
import com.tencent.mm.plugin.appbrand.loading.AppBrandProcessTriggerService0;
import com.tencent.mm.plugin.appbrand.loading.AppBrandProcessTriggerService1;
import com.tencent.mm.plugin.appbrand.loading.AppBrandProcessTriggerService2;
import com.tencent.mm.plugin.appbrand.loading.AppBrandProcessTriggerService3;
import com.tencent.mm.plugin.appbrand.loading.AppBrandProcessTriggerService4;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.appbrand.service.z.a;
import com.tencent.mm.plugin.appbrand.task.preload.e.a;
import com.tencent.mm.plugin.appbrand.task.preload.e.a.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI1;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI2;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI3;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI4;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingUI1;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingUI2;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingUI3;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingUI4;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI00;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI01;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI02;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI03;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI04;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI1;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI2;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI3;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI4;
import com.tencent.mm.plugin.appbrand.ui.ah;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.a.j;
import kotlin.g.b.af;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/task/AppBrandTaskManagerV2;", "Lcom/tencent/mm/plugin/appbrand/task/IAppBrandTaskManager;", "Lcom/tencent/mm/plugin/appbrand/task/IAppBrandTaskManager$InternalFunctions;", "()V", "clearDuplicatedApp", "", "appId", "", "closeTaskByAppId", "versionType", "", "findForegroundServiceClassByUIClassName", "Ljava/lang/Class;", "uiClassName", "findKeepAliveServiceClassByUIClassName", "findPersistentAppTask", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandUIProcess;", "cfg", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "findTaskByAppIdAndClassName", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandUITask;", "cls", "type", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;", "findTaskByClassName", "findTaskByClassNameWithType", "serviceType", "finishAllTask", "finishByPersistentTaskController", "finishTaskByAppId", "debugType", "getAliveInstanceId", "getAliveTaskIndentity", "Landroid/util/Pair;", "getAliveTaskRemoteController", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandRemoteTaskController;", "getAllTaskUsingCommLibVersion", "", "getAvailableTaskToStartup", "getAvailableTaskToStartupImpl", "getPluginTaskToStartup", "isWeishiApp", "", "getStartStrategyAndTask", "isPluginTask", "startAsHalfScreen", "getTaskInfoList", "", "()[Ljava/lang/String;", "getWeishiTask", "interceptTargetTaskForPersistentApp", "isProcessMatchPersistentUsage", "task", "processName", "killAll", "killEmptyProcess", "moveToRear", "onNetworkChange", "onRuntimeFinish", "popPersistentApp", "controller", "preloadDelayedByClassName", "preloadType", "preloadPluginUIProcess", "scene", "Lcom/tencent/mm/plugin/appbrand/service/PRELOAD_SCENE;", "removeApp", "startApp", "ctx", "Landroid/content/Context;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "startTargetActivity", "preLoadingLogic", "Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingLogic;", "intent", "Landroid/content/Intent;", "stashPersistentApp", "stripSceneNote", "taskAlive", "tryPreloadNextTaskProcess", "ignoreFrequencyLimit", "AppBrandTaskManagerFactory", "Companion", "plugin-appbrand-integration_release"})
public final class i
  implements p, p.a
{
  private static LinkedList<m> nPK;
  private static final ConcurrentHashMap<String, String> nPN;
  private static final LinkedList<m> nPW;
  private static final HashSet<String> nPX;
  private static final c nPY;
  public static final b nPZ;
  
  static
  {
    AppMethodBeat.i(229444);
    nPZ = new b((byte)0);
    nPK = new LinkedList();
    nPN = new ConcurrentHashMap();
    nPX = new HashSet();
    nPY = new c((Comparator)d.nQd);
    if (com.tencent.mm.plugin.appbrand.ui.p.bXw())
    {
      nPK.add(new m(AppBrandUI.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class, AppBrandForegroundNotificationService.class, AppBrandProcessTriggerService0.class, AppBrandPreLoadingUI.class, AppBrandPluginUI.class));
      nPK.add(new m(AppBrandUI3.class, AppBrandTaskPreloadReceiver3.class, AppBrandKeepAliveService3.class, AppBrandForegroundNotificationService3.class, AppBrandProcessTriggerService3.class, AppBrandPreLoadingUI3.class, AppBrandPluginUI3.class));
      nPK.add(new m(AppBrandUI4.class, AppBrandTaskPreloadReceiver4.class, AppBrandKeepAliveService4.class, AppBrandForegroundNotificationService4.class, AppBrandProcessTriggerService4.class, AppBrandPreLoadingUI4.class, AppBrandPluginUI4.class));
      nPK.add(new m(AppBrandUI03.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class, AppBrandForegroundNotificationService.class, AppBrandProcessTriggerService0.class, AppBrandPreLoadingUI.class, AppBrandPluginUI.class));
      nPK.add(new m(AppBrandUI04.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class, AppBrandForegroundNotificationService.class, AppBrandProcessTriggerService0.class, AppBrandPreLoadingUI.class, AppBrandPluginUI.class));
    }
    for (;;)
    {
      Object localObject = new LinkedList();
      nPW = (LinkedList)localObject;
      ((LinkedList)localObject).addAll((Collection)nPK);
      AppMethodBeat.o(229444);
      return;
      if (com.tencent.mm.plugin.appbrand.ui.p.bXv())
      {
        nPK.add(new m(AppBrandUI00.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class, AppBrandForegroundNotificationService.class, AppBrandProcessTriggerService0.class, AppBrandPreLoadingUI.class, AppBrandPluginUI.class));
        nPK.add(new m(AppBrandUI01.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class, AppBrandForegroundNotificationService.class, AppBrandProcessTriggerService0.class, AppBrandPreLoadingUI.class, AppBrandPluginUI.class));
        nPK.add(new m(AppBrandUI02.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class, AppBrandForegroundNotificationService.class, AppBrandProcessTriggerService0.class, AppBrandPreLoadingUI.class, AppBrandPluginUI.class));
        nPK.add(new m(AppBrandUI03.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class, AppBrandForegroundNotificationService.class, AppBrandProcessTriggerService0.class, AppBrandPreLoadingUI.class, AppBrandPluginUI.class));
        nPK.add(new m(AppBrandUI04.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class, AppBrandForegroundNotificationService.class, AppBrandProcessTriggerService0.class, AppBrandPreLoadingUI.class, AppBrandPluginUI.class));
        localObject = new m(AppBrandUI.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class, AppBrandForegroundNotificationService.class, AppBrandProcessTriggerService0.class, AppBrandPreLoadingUI.class, AppBrandPluginUI.class);
        m localm1 = new m(AppBrandUI1.class, AppBrandTaskPreloadReceiver1.class, AppBrandKeepAliveService1.class, AppBrandForegroundNotificationService1.class, AppBrandProcessTriggerService1.class, AppBrandPreLoadingUI1.class, AppBrandPluginUI1.class);
        m localm2 = new m(AppBrandUI2.class, AppBrandTaskPreloadReceiver2.class, AppBrandKeepAliveService2.class, AppBrandForegroundNotificationService2.class, AppBrandProcessTriggerService2.class, AppBrandPreLoadingUI2.class, AppBrandPluginUI2.class);
        m localm3 = new m(AppBrandUI3.class, AppBrandTaskPreloadReceiver3.class, AppBrandKeepAliveService3.class, AppBrandForegroundNotificationService3.class, AppBrandProcessTriggerService3.class, AppBrandPreLoadingUI3.class, AppBrandPluginUI3.class);
        m localm4 = new m(AppBrandUI4.class, AppBrandTaskPreloadReceiver4.class, AppBrandKeepAliveService4.class, AppBrandForegroundNotificationService4.class, AppBrandProcessTriggerService4.class, AppBrandPreLoadingUI4.class, AppBrandPluginUI4.class);
        ((m)localObject).y(g.nPE);
        localm1.y(g.nPE);
        localm2.y(g.nPE);
        localm3.y(g.nPE);
        localm4.y(g.nPE);
        int i = g.bVW();
        if (i > 0) {
          nPK.add(localObject);
        }
        if (i >= 2) {
          nPK.add(localm1);
        }
        if (i >= 3) {
          nPK.add(localm2);
        }
        if (i >= 4) {
          nPK.add(localm3);
        }
        if (i >= 5) {
          nPK.add(localm4);
        }
      }
      else
      {
        nPK.add(new m(AppBrandUI.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class, AppBrandForegroundNotificationService.class, AppBrandProcessTriggerService0.class, AppBrandPreLoadingUI.class, AppBrandPluginUI.class));
        nPK.add(new m(AppBrandUI1.class, AppBrandTaskPreloadReceiver1.class, AppBrandKeepAliveService1.class, AppBrandForegroundNotificationService1.class, AppBrandProcessTriggerService1.class, AppBrandPreLoadingUI1.class, AppBrandPluginUI1.class));
        nPK.add(new m(AppBrandUI2.class, AppBrandTaskPreloadReceiver2.class, AppBrandKeepAliveService2.class, AppBrandForegroundNotificationService2.class, AppBrandProcessTriggerService2.class, AppBrandPreLoadingUI2.class, AppBrandPluginUI2.class));
        nPK.add(new m(AppBrandUI3.class, AppBrandTaskPreloadReceiver3.class, AppBrandKeepAliveService3.class, AppBrandForegroundNotificationService3.class, AppBrandProcessTriggerService3.class, AppBrandPreLoadingUI3.class, AppBrandPluginUI3.class));
        nPK.add(new m(AppBrandUI4.class, AppBrandTaskPreloadReceiver4.class, AppBrandKeepAliveService4.class, AppBrandForegroundNotificationService4.class, AppBrandProcessTriggerService4.class, AppBrandPreLoadingUI4.class, AppBrandPluginUI4.class));
      }
    }
  }
  
  private i()
  {
    AppMethodBeat.i(229443);
    if ((BuildInfo.DEBUG) || ((int)System.currentTimeMillis() % 10 == 0))
    {
      c localc = c.nOr;
      c.c((kotlin.g.a.m)1.nQa);
    }
    AppMethodBeat.o(229443);
  }
  
  private static boolean a(m paramm, g paramg, String paramString)
  {
    AppMethodBeat.i(229415);
    if ((kotlin.g.b.p.j(paramm.bWo(), paramString)) && ((paramm.bWq() == paramg) || (paramm.bWq() == g.nPF)) && (paramm.c(paramg)))
    {
      AppMethodBeat.o(229415);
      return true;
    }
    AppMethodBeat.o(229415);
    return false;
  }
  
  private static m bWg()
  {
    AppMethodBeat.i(229429);
    for (;;)
    {
      int i;
      synchronized (nPK)
      {
        Iterator localIterator = ((Iterable)nPK).iterator();
        Object localObject1;
        if (localIterator.hasNext())
        {
          localObject1 = localIterator.next();
          m localm = (m)localObject1;
          Object localObject3 = localm.bWo();
          kotlin.g.b.p.g(localObject3, "it.uiProcessName");
          localObject3 = (CharSequence)localObject3;
          String str = com.tencent.mm.plugin.appbrand.af.g.bZR();
          kotlin.g.b.p.g(str, "AppBrandWeishiUtil.getWeishiProcessName()");
          if ((kotlin.n.n.a((CharSequence)localObject3, (CharSequence)str, true)) && (localm.c(g.nPD)))
          {
            i = 1;
            break label154;
            if (localObject1 == null) {
              kotlin.g.b.p.hyc();
            }
            localObject1 = (m)localObject1;
            AppMethodBeat.o(229429);
            return localObject1;
          }
          else
          {
            i = 0;
          }
        }
        else
        {
          localObject1 = null;
        }
      }
      label154:
      if (i == 0) {}
    }
  }
  
  public static final LinkedList<m> bWj()
  {
    AppMethodBeat.i(229445);
    LinkedList localLinkedList = b.bWj();
    AppMethodBeat.o(229445);
    return localLinkedList;
  }
  
  private static n c(String paramString, g paramg)
  {
    AppMethodBeat.i(229439);
    Iterator localIterator = b.bWj().iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      kotlin.g.b.p.g(localm, "task");
      if (!kotlin.g.b.p.j(localm.bWr(), paramString))
      {
        Class localClass = localm.bWm();
        kotlin.g.b.p.g(localClass, "task.pluginUiClass");
        if (!kotlin.g.b.p.j(localClass.getName(), paramString)) {
          break;
        }
      }
      else if (localm.c(paramg))
      {
        paramString = (n)localm;
        AppMethodBeat.o(229439);
        return paramString;
      }
    }
    if (BuildInfo.DEBUG)
    {
      paramString = (Throwable)new IllegalStateException("cls = [" + paramString + "],serviceType=[" + paramg.name() + ']');
      AppMethodBeat.o(229439);
      throw paramString;
    }
    AppMethodBeat.o(229439);
    return null;
  }
  
  private static void ck(String paramString, int paramInt)
  {
    AppMethodBeat.i(229413);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(229413);
      return;
    }
    if (paramString == null) {
      kotlin.g.b.p.hyc();
    }
    Object localObject = nPY.iterator();
    kotlin.g.b.p.g(localObject, "PERSISTENT_TASK_CONTROLLERS.iterator()");
    List localList = (List)new LinkedList();
    while (((Iterator)localObject).hasNext())
    {
      AppBrandRemoteTaskController localAppBrandRemoteTaskController = (AppBrandRemoteTaskController)((Iterator)localObject).next();
      if ((kotlin.g.b.p.j(paramString, localAppBrandRemoteTaskController.getAppId())) && ((paramInt == localAppBrandRemoteTaskController.brf()) || (paramInt < 0)))
      {
        localAppBrandRemoteTaskController.afa(paramString);
        localList.add(localAppBrandRemoteTaskController);
      }
    }
    paramString = localList.iterator();
    while (paramString.hasNext())
    {
      localObject = (AppBrandRemoteTaskController)paramString.next();
      nPY.remove(localObject);
    }
    AppMethodBeat.o(229413);
  }
  
  private static AppBrandRemoteTaskController cm(String paramString, int paramInt)
  {
    AppMethodBeat.i(229430);
    int i;
    Object localObject3;
    Object localObject1;
    label55:
    label68:
    int j;
    if (paramInt < 0)
    {
      i = 1;
      localObject3 = b.afm(paramString);
      if (localObject3 != null)
      {
        if (i != 0) {
          break label175;
        }
        localObject2 = ((m)localObject3).afo(paramString);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = Integer.valueOf(-1);
        }
        if (localObject1 != null) {
          break label166;
        }
      }
      Object localObject2 = ((Iterable)nPY).iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label190;
      }
      localObject1 = ((Iterator)localObject2).next();
      localObject3 = (AppBrandRemoteTaskController)localObject1;
      kotlin.g.b.p.g(localObject3, "controller");
      if ((!kotlin.g.b.p.j(((AppBrandRemoteTaskController)localObject3).getAppId(), paramString)) || ((i == 0) && (((AppBrandRemoteTaskController)localObject3).brf() != paramInt))) {
        break label185;
      }
      j = 1;
      label129:
      if (j == 0) {
        break label188;
      }
    }
    label166:
    label175:
    label185:
    label188:
    label190:
    for (paramString = (String)localObject1;; paramString = null)
    {
      for (paramString = (AppBrandRemoteTaskController)paramString;; paramString = ((m)localObject3).afq(paramString))
      {
        if ((paramString == null) || (paramString.bVS() != true)) {
          break label195;
        }
        AppMethodBeat.o(229430);
        return paramString;
        i = 0;
        break;
        if (((Integer)localObject1).intValue() != paramInt) {
          break label55;
        }
      }
      j = 0;
      break label129;
      break label68;
    }
    label195:
    AppMethodBeat.o(229430);
    return null;
  }
  
  private static m k(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(229414);
    g localg = g.j(paramAppBrandInitConfigWC);
    if (nPN.containsKey(paramAppBrandInitConfigWC.appId))
    {
      paramAppBrandInitConfigWC = (String)nPN.get(paramAppBrandInitConfigWC.appId);
      if (TextUtils.isEmpty((CharSequence)paramAppBrandInitConfigWC))
      {
        AppMethodBeat.o(229414);
        return null;
      }
      Iterator localIterator = nPK.iterator();
      while (localIterator.hasNext())
      {
        m localm = (m)localIterator.next();
        kotlin.g.b.p.g(localm, "task");
        kotlin.g.b.p.g(localg, "type");
        if (paramAppBrandInitConfigWC == null) {
          kotlin.g.b.p.hyc();
        }
        if (a(localm, localg, paramAppBrandInitConfigWC))
        {
          AppMethodBeat.o(229414);
          return localm;
        }
      }
    }
    AppMethodBeat.o(229414);
    return null;
  }
  
  private static m x(g paramg)
  {
    AppMethodBeat.i(229428);
    Object localObject1;
    m localm;
    int i;
    for (;;)
    {
      synchronized (nPK)
      {
        Iterator localIterator = nPK.iterator();
        localObject1 = null;
        if (!localIterator.hasNext()) {
          break label534;
        }
        localm = (m)localIterator.next();
        kotlin.g.b.p.g(localm, "uiTask");
        localObject2 = localObject1;
        if (localm.bWp())
        {
          localObject2 = localObject1;
          if (localm.bWq() == paramg)
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = localm;
            }
            if (localm.bWA())
            {
              if (localm.bWn() == null) {
                break label537;
              }
              if (localm.bWn() == paramg)
              {
                break label537;
                if (localObject1 == null) {
                  continue;
                }
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManagerV2", "getAvailableTaskToStartup found empty task, which can be used as [%s], info [%s]", new Object[] { paramg, localObject1 });
                paramg = (g)localObject1;
                AppMethodBeat.o(229428);
                return paramg;
              }
            }
            i = 0;
            break label539;
          }
        }
        label155:
        localObject1 = localObject2;
        continue;
        if (b.t(paramg))
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManagerV2", "getAvailableTaskToStartup [%s] task reached maxLimit", new Object[] { paramg });
          localObject2 = ((Iterable)nPK).iterator();
          label196:
          if (!((Iterator)localObject2).hasNext()) {
            break label563;
          }
          localObject1 = ((Iterator)localObject2).next();
          if (((m)localObject1).bWq() != paramg) {
            break label558;
          }
          i = 1;
          break label549;
          label228:
          if (paramg == null) {
            kotlin.g.b.p.hyc();
          }
          paramg = (m)paramg;
          continue;
        }
        if ((paramg != g.nPE) || (!com.tencent.mm.plugin.appbrand.ui.p.bXv())) {
          break;
        }
        localObject2 = ((Iterable)nPK).iterator();
        label268:
        if (!((Iterator)localObject2).hasNext()) {
          break label365;
        }
        localObject1 = ((Iterator)localObject2).next();
        localm = (m)localObject1;
        if ((localm.bWq() == g.nPF) && (localm.bWn() == g.nPE))
        {
          i = 1;
          break label568;
          label317:
          localObject1 = (m)localObject1;
          label322:
          if (localObject1 == null) {
            break label456;
          }
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManagerV2", "getAvailableTaskToStartup found not used task, which can be used as [%s]", new Object[] { paramg });
          paramg = (g)localObject1;
        }
      }
      i = 0;
      break label568;
      label365:
      localObject1 = null;
    }
    Object localObject2 = ((Iterable)nPK).iterator();
    label382:
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      localm = (m)localObject1;
      if (localm.bWq() == g.nPF) {
        if ((localm.bWn() != null) && (localm.bWn() != g.nPD)) {
          if (localm.bWn() != g.nPF) {
            break label584;
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = (m)localObject1;
      break label322;
      label456:
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManagerV2", "getAvailableTaskToStartup all full for [%s]", new Object[] { paramg });
      localObject2 = ((Iterable)nPK).iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = ((Iterator)localObject2).next();
      } while (!((m)localObject1).c(paramg));
      for (paramg = (g)localObject1;; paramg = null)
      {
        if (paramg == null) {
          kotlin.g.b.p.hyc();
        }
        paramg = (m)paramg;
        break;
      }
      label534:
      break;
      label537:
      i = 1;
      label539:
      if (i == 0) {
        break label155;
      }
      localObject1 = localm;
      break;
      for (;;)
      {
        label549:
        if (i == 0) {
          break label561;
        }
        paramg = (g)localObject1;
        break;
        label558:
        i = 0;
      }
      label561:
      break label196;
      label563:
      paramg = null;
      break label228;
      label568:
      if (i == 0) {
        break label268;
      }
      break label317;
      label584:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label587;
        }
        break;
      }
      label587:
      break label382;
      localObject1 = null;
    }
  }
  
  public final void Ue(String paramString)
  {
    AppMethodBeat.i(229442);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManagerV2", "onRuntimeFinish appId=".concat(String.valueOf(paramString)));
    Collection localCollection = (Collection)nPX;
    if (localCollection == null)
    {
      paramString = new t("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
      AppMethodBeat.o(229442);
      throw paramString;
    }
    af.eV(localCollection).remove(paramString);
    AppMethodBeat.o(229442);
  }
  
  public final n a(String paramString1, String paramString2, g paramg)
  {
    AppMethodBeat.i(229438);
    kotlin.g.b.p.h(paramg, "type");
    paramg = b.bWj().iterator();
    while (paramg.hasNext())
    {
      m localm = (m)paramg.next();
      if (localm == null)
      {
        paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.task.AppBrandUIProcess");
        AppMethodBeat.o(229438);
        throw paramString1;
      }
      if (localm.bWw().contains(paramString1)) {
        if (!kotlin.g.b.p.j(localm.bWr(), paramString2))
        {
          Class localClass = localm.bWm();
          kotlin.g.b.p.g(localClass, "task.pluginUiClass");
          if (!kotlin.g.b.p.j(localClass.getName(), paramString2)) {
            break;
          }
        }
        else
        {
          paramString1 = (n)localm;
          AppMethodBeat.o(229438);
          return paramString1;
        }
      }
    }
    AppMethodBeat.o(229438);
    return null;
  }
  
  public final void a(g paramg, z paramz)
  {
    AppMethodBeat.i(229422);
    kotlin.g.b.p.h(paramg, "serviceType");
    kotlin.g.b.p.h(paramz, "scene");
    z.a locala = z.nMV;
    a(paramg, paramz, z.a.d(paramz));
    AppMethodBeat.o(229422);
  }
  
  public final void a(final g paramg, z paramz, boolean paramBoolean)
  {
    AppMethodBeat.i(229441);
    kotlin.g.b.p.h(paramg, "serviceType");
    kotlin.g.b.p.h(paramz, "scene");
    if ((!com.tencent.mm.plugin.appbrand.appusage.i.bxK()) || (com.tencent.mm.plugin.appbrand.task.preload.e.bWG()) || (paramg == g.nPF))
    {
      AppMethodBeat.o(229441);
      return;
    }
    if (g.nPE == paramg) {}
    int j;
    Object localObject;
    int i;
    for (boolean bool = true;; bool = false)
    {
      j = com.tencent.mm.plugin.appbrand.task.preload.e.iF(bool);
      com.tencent.mm.plugin.report.service.h.CyF.dN(j, paramz.nMT);
      localObject = e.a.nRc;
      i = com.tencent.mm.plugin.appbrand.task.preload.e.a(e.a.a.A(paramg), (kotlin.g.a.m)new f(paramBoolean, paramg));
      if ((paramBoolean) || (i != -1)) {
        break;
      }
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandTaskManagerV2", "tryPreloadNextTaskProcess type[%s] scene[%s] hit interval limit", new Object[] { paramg, paramz });
      AppMethodBeat.o(229441);
      return;
    }
    com.tencent.mm.plugin.report.service.h.CyF.dN(j, paramz.nMU);
    if (paramBoolean)
    {
      localObject = com.tencent.mm.plugin.appbrand.task.preload.a.nQO;
      i = com.tencent.mm.plugin.appbrand.task.preload.a.bWD();
      if (i == -2) {
        break label230;
      }
    }
    for (;;)
    {
      switch (j.$EnumSwitchMapping$0[paramg.ordinal()])
      {
      default: 
        paramg = (Throwable)new IllegalStateException("unknown service type");
        AppMethodBeat.o(229441);
        throw paramg;
        label230:
        i = 2;
      }
    }
    com.tencent.mm.plugin.report.service.h.CyF.dN(1144, 0);
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManagerV2", "tryPreloadNextTaskProcess serviceType[%s], scene[%s] preload level[%d]", new Object[] { paramg, paramz, Integer.valueOf(i) });
      paramz = b.u(paramg);
      if (paramz == null) {
        break;
      }
      paramz.z(paramg);
      paramz.R(i, com.tencent.mm.plugin.appbrand.ui.p.bXv());
      if (i != 2) {
        com.tencent.mm.plugin.report.service.h.CyF.dN(915, 30);
      }
      switch (j.haE[paramg.ordinal()])
      {
      default: 
        paramg = (Throwable)new IllegalStateException("unknown service type");
        AppMethodBeat.o(229441);
        throw paramg;
        com.tencent.mm.plugin.report.service.h.CyF.dN(1144, 1);
      }
    }
    com.tencent.mm.plugin.report.service.h.CyF.dN(1144, 3);
    AppMethodBeat.o(229441);
    return;
    com.tencent.mm.plugin.report.service.h.CyF.dN(1144, 4);
    AppMethodBeat.o(229441);
    return;
    AppMethodBeat.o(229441);
  }
  
  public final void a(String paramString, AppBrandRemoteTaskController paramAppBrandRemoteTaskController)
  {
    AppMethodBeat.i(229412);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(229412);
      return;
    }
    if (paramString == null) {
      kotlin.g.b.p.hyc();
    }
    nPN.remove(paramString);
    if (paramAppBrandRemoteTaskController != null)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManagerV2", "popPersistentApp appId:" + paramString + " controller:" + paramAppBrandRemoteTaskController + " stack:" + android.util.Log.getStackTraceString(new Throwable()));
      nPY.remove(paramAppBrandRemoteTaskController);
    }
    AppMethodBeat.o(229412);
  }
  
  public final void a(String paramString, final g paramg)
  {
    AppMethodBeat.i(229424);
    kotlin.g.b.p.h(paramg, "preloadType");
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(229424);
      return;
    }
    if (paramString == null) {
      kotlin.g.b.p.hyc();
    }
    paramString = c(paramString, paramg);
    if (paramString == null)
    {
      AppMethodBeat.o(229424);
      return;
    }
    com.tencent.f.h.RTc.n((Runnable)new e(paramString, paramg), 500L);
    AppMethodBeat.o(229424);
  }
  
  public final void a(String paramString1, String paramString2, AppBrandRemoteTaskController paramAppBrandRemoteTaskController)
  {
    AppMethodBeat.i(229411);
    if ((TextUtils.isEmpty((CharSequence)paramString1)) || (TextUtils.isEmpty((CharSequence)paramString2)))
    {
      AppMethodBeat.o(229411);
      return;
    }
    if (paramString1 == null) {
      kotlin.g.b.p.hyc();
    }
    if (paramString2 == null) {
      kotlin.g.b.p.hyc();
    }
    ((Map)nPN).put(paramString1, paramString2);
    if (paramAppBrandRemoteTaskController != null)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManagerV2", "stashPersistentApp, appId:" + paramString1 + ", processName:" + paramString2 + ", controller.id:" + paramAppBrandRemoteTaskController.bjl());
      nPY.remove(paramAppBrandRemoteTaskController);
      nPY.b(paramAppBrandRemoteTaskController);
    }
    AppMethodBeat.o(229411);
  }
  
  public final void afe(String paramString)
  {
    AppMethodBeat.i(229421);
    kotlin.g.b.p.h(paramString, "appId");
    Iterator localIterator = b.bWj().iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (localm.afq(paramString) != null)
      {
        kotlin.g.b.p.g(localm, "task");
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManagerV2", "clearDuplicatedApp task:%s, appId:%s", new Object[] { localm.bWr(), paramString });
        localm.afq(paramString).afa(paramString);
      }
    }
    ck(paramString, -1);
    AppMethodBeat.o(229421);
  }
  
  public final Class<?> aff(String paramString)
  {
    AppMethodBeat.i(229426);
    kotlin.g.b.p.h(paramString, "uiClassName");
    Iterator localIterator = b.bWj().iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      kotlin.g.b.p.g(localm, "task");
      if (!kotlin.g.b.p.j(localm.bWr(), paramString))
      {
        Class localClass = localm.bWm();
        kotlin.g.b.p.g(localClass, "task.pluginUiClass");
        if (!kotlin.g.b.p.j(localClass.getName(), paramString)) {
          break;
        }
      }
      else
      {
        paramString = localm.bWt();
        AppMethodBeat.o(229426);
        return paramString;
      }
    }
    AppMethodBeat.o(229426);
    return null;
  }
  
  public final Class<?> afg(String paramString)
  {
    AppMethodBeat.i(229427);
    kotlin.g.b.p.h(paramString, "uiClassName");
    Iterator localIterator = b.bWj().iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      kotlin.g.b.p.g(localm, "task");
      if (!kotlin.g.b.p.j(localm.bWr(), paramString))
      {
        Class localClass = localm.bWm();
        kotlin.g.b.p.g(localClass, "task.pluginUiClass");
        if (!kotlin.g.b.p.j(localClass.getName(), paramString)) {
          break;
        }
      }
      else
      {
        paramString = localm.bWu();
        AppMethodBeat.o(229427);
        return paramString;
      }
    }
    AppMethodBeat.o(229427);
    return null;
  }
  
  public final boolean afi(String paramString)
  {
    AppMethodBeat.i(229432);
    kotlin.g.b.p.h(paramString, "appId");
    boolean bool = cn(paramString, -1);
    AppMethodBeat.o(229432);
    return bool;
  }
  
  public final Pair<String, Integer> afj(String paramString)
  {
    AppMethodBeat.i(229433);
    kotlin.g.b.p.h(paramString, "appId");
    paramString = cm(paramString, -1);
    if (paramString == null)
    {
      AppMethodBeat.o(229433);
      return null;
    }
    paramString = Pair.create(paramString.getAppId(), Integer.valueOf(paramString.brf()));
    AppMethodBeat.o(229433);
    return paramString;
  }
  
  public final void afk(String arg1)
  {
    AppMethodBeat.i(229437);
    kotlin.g.b.p.h(???, "appId");
    Object localObject1 = b.afm(???);
    if (localObject1 != null)
    {
      ((m)localObject1).afk(???);
      if (((m)localObject1).bWw().isEmpty())
      {
        synchronized (nPW)
        {
          nPW.remove(localObject1);
          nPW.addFirst(localObject1);
          x localx = x.SXb;
        }
        synchronized (nPK)
        {
          if (nPK.contains(localObject1))
          {
            nPK.remove(localObject1);
            nPK.addFirst(localObject1);
          }
          localObject1 = x.SXb;
          AppMethodBeat.o(229437);
          return;
          localObject2 = finally;
          AppMethodBeat.o(229437);
          throw localObject2;
        }
      }
    }
    AppMethodBeat.o(229437);
  }
  
  public final n b(String paramString, g paramg)
  {
    AppMethodBeat.i(229440);
    kotlin.g.b.p.h(paramg, "type");
    paramString = c(paramString, paramg);
    AppMethodBeat.o(229440);
    return paramString;
  }
  
  public final void b(n paramn)
  {
    AppMethodBeat.i(229436);
    kotlin.g.b.p.h(paramn, "task");
    synchronized (nPW)
    {
      localObject = (Collection)nPW;
      if (localObject == null)
      {
        paramn = new t("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        AppMethodBeat.o(229436);
        throw paramn;
      }
    }
    af.eV(localObject).remove(paramn);
    nPW.addLast((m)paramn);
    Object localObject = x.SXb;
    synchronized (nPK)
    {
      if (!j.a((Iterable)nPK, paramn)) {
        break label168;
      }
      localObject = (Collection)nPK;
      if (localObject == null)
      {
        paramn = new t("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        AppMethodBeat.o(229436);
        throw paramn;
      }
    }
    af.eV(localObject).remove(paramn);
    nPK.addLast((m)paramn);
    label168:
    paramn = x.SXb;
    AppMethodBeat.o(229436);
  }
  
  public final void bVX()
  {
    AppMethodBeat.i(229419);
    Iterator localIterator = b.bWj().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (m)localIterator.next();
      kotlin.g.b.p.g(localObject, "task");
      localObject = ((m)localObject).bWx().iterator();
      while (((Iterator)localObject).hasNext())
      {
        AppBrandRemoteTaskController localAppBrandRemoteTaskController = (AppBrandRemoteTaskController)((Iterator)localObject).next();
        if (localAppBrandRemoteTaskController != null) {
          localAppBrandRemoteTaskController.zl(4);
        }
      }
    }
    AppMethodBeat.o(229419);
  }
  
  public final int[] bVY()
  {
    AppMethodBeat.i(229435);
    Object localObject = b.bWj();
    int[] arrayOfInt = new int[((LinkedList)localObject).size()];
    localObject = ((LinkedList)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      m localm = (m)((Iterator)localObject).next();
      kotlin.g.b.p.g(localm, "task");
      arrayOfInt[i] = localm.bWv();
      i += 1;
    }
    AppMethodBeat.o(229435);
    return arrayOfInt;
  }
  
  public final void cl(String paramString, int paramInt)
  {
    AppMethodBeat.i(229418);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(229418);
      return;
    }
    if (paramString == null) {
      kotlin.g.b.p.hyc();
    }
    m localm = b.afm(paramString);
    if (localm == null)
    {
      ck(paramString, paramInt);
      AppMethodBeat.o(229418);
      return;
    }
    if (paramInt >= 0)
    {
      Integer localInteger = localm.afo(paramString);
      if (localInteger == null)
      {
        AppMethodBeat.o(229418);
        return;
      }
      if (localInteger.intValue() != paramInt) {}
    }
    else if (localm.afq(paramString) != null)
    {
      localm.afq(paramString).afa(paramString);
    }
    AppMethodBeat.o(229418);
  }
  
  public final boolean cn(String paramString, int paramInt)
  {
    AppMethodBeat.i(229431);
    kotlin.g.b.p.h(paramString, "appId");
    if (cm(paramString, paramInt) != null)
    {
      AppMethodBeat.o(229431);
      return true;
    }
    AppMethodBeat.o(229431);
    return false;
  }
  
  public final String co(String paramString, int paramInt)
  {
    AppMethodBeat.i(229434);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(229434);
      return null;
    }
    if (paramString == null) {
      kotlin.g.b.p.hyc();
    }
    try
    {
      paramString = cm(paramString, paramInt);
      if (paramString != null)
      {
        paramString = paramString.aiv();
        AppMethodBeat.o(229434);
        return paramString;
      }
    }
    catch (NullPointerException paramString)
    {
      if (BuildInfo.IS_FLAVOR_RED)
      {
        paramString = (Throwable)paramString;
        AppMethodBeat.o(229434);
        throw paramString;
      }
      com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrandTaskManagerV2", (Throwable)paramString, "[NOT CRASH]getAliveInstanceId", new Object[0]);
      AppMethodBeat.o(229434);
    }
    return null;
  }
  
  public final int d(Context paramContext, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(229417);
    kotlin.g.b.p.h(paramContext, "ctx");
    kotlin.g.b.p.h(paramAppBrandInitConfigWC, "cfg");
    kotlin.g.b.p.h(paramAppBrandStatObject, "stat");
    Object localObject1;
    if ((!TextUtils.isEmpty((CharSequence)paramAppBrandStatObject.dCw)) && (paramAppBrandStatObject.dCw.length() >= 1024))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManagerV2", "startApp, appId[%s], scene[%d], preScene[%d], sceneNote too long, strip it", new Object[] { paramAppBrandInitConfigWC.appId, Integer.valueOf(paramAppBrandStatObject.scene), Integer.valueOf(paramAppBrandStatObject.ecU) });
      localObject1 = paramAppBrandStatObject.dCw;
      kotlin.g.b.p.g(localObject1, "stat.sceneNote");
      if (localObject1 == null)
      {
        paramContext = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(229417);
        throw paramContext;
      }
      localObject1 = ((String)localObject1).substring(0, 1024);
      kotlin.g.b.p.g(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      paramAppBrandStatObject.dCw = ((String)localObject1);
    }
    if ((!TextUtils.isEmpty((CharSequence)paramAppBrandStatObject.ecV)) && (paramAppBrandStatObject.ecV.length() >= 1024))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManagerV2", "startApp, appId[%s], scene[%d], preScene[%d], preSceneNote too long, strip it", new Object[] { paramAppBrandInitConfigWC.appId, Integer.valueOf(paramAppBrandStatObject.scene), Integer.valueOf(paramAppBrandStatObject.ecU) });
      localObject1 = paramAppBrandStatObject.ecV;
      kotlin.g.b.p.g(localObject1, "stat.preSceneNote");
      if (localObject1 == null)
      {
        paramContext = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(229417);
        throw paramContext;
      }
      localObject1 = ((String)localObject1).substring(0, 1024);
      kotlin.g.b.p.g(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      paramAppBrandStatObject.ecV = ((String)localObject1);
    }
    com.tencent.mm.plugin.appbrand.report.model.e.nIB.ch(paramAppBrandInitConfigWC.appId, paramAppBrandInitConfigWC.appVersion);
    h.afd(paramAppBrandInitConfigWC.appId);
    boolean bool1;
    boolean bool2;
    label393:
    label405:
    Object localObject2;
    Object localObject3;
    int i;
    label456:
    Object localObject4;
    Object localObject5;
    if ((paramAppBrandInitConfigWC.kHL.isEnable()) || (nPX.contains(paramAppBrandInitConfigWC.appId)))
    {
      bool1 = true;
      if (bool1)
      {
        nPX.add(paramAppBrandInitConfigWC.appId);
        paramAppBrandInitConfigWC.leg = true;
      }
      if ((!paramAppBrandInitConfigWC.ldN) && (!com.tencent.mm.plugin.appbrand.af.g.afU(paramAppBrandInitConfigWC.appId)) && (paramAppBrandInitConfigWC.launchMode != 1) && (!bool1) && (!paramAppBrandInitConfigWC.lei)) {
        break label739;
      }
      bool2 = true;
      if (!paramAppBrandInitConfigWC.NA()) {
        break label745;
      }
      localObject1 = g.nPE;
      if (!bool2) {
        break label862;
      }
      localObject2 = g.j(paramAppBrandInitConfigWC);
      localObject3 = (String)nPN.get(paramAppBrandInitConfigWC.appId);
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label753;
      }
      i = 1;
      if (i != 0) {
        break label765;
      }
      localObject4 = ((Iterable)b.bWj()).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject1 = ((Iterator)localObject4).next();
        localObject5 = (m)localObject1;
        kotlin.g.b.p.g(localObject2, "type");
        if (localObject3 == null) {
          kotlin.g.b.p.hyc();
        }
        if (a((m)localObject5, (g)localObject2, (String)localObject3))
        {
          label528:
          localObject1 = (m)localObject1;
          label535:
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManagerV2", "getStartStrategyAndTask findPersistentAppTask return " + localObject1 + ", appId:" + paramAppBrandInitConfigWC.appId);
          if (localObject1 == null) {
            break label771;
          }
          localObject2 = paramAppBrandInitConfigWC.appId;
          localObject3 = paramAppBrandInitConfigWC.appId;
          kotlin.g.b.p.g(localObject3, "cfg.appId");
          a((String)localObject2, cm((String)localObject3, paramAppBrandInitConfigWC.eix));
          i = 2;
          ((m)localObject1).z(g.nPD);
          label623:
          b((n)localObject1);
        }
      }
    }
    int j;
    for (;;)
    {
      localObject1 = new Pair(Integer.valueOf(i), localObject1);
      localObject2 = ((Pair)localObject1).first;
      kotlin.g.b.p.g(localObject2, "pair.first");
      j = ((Number)localObject2).intValue();
      localObject1 = ((Pair)localObject1).second;
      kotlin.g.b.p.g(localObject1, "pair.second");
      localObject4 = (n)localObject1;
      ((n)localObject4).a(paramAppBrandInitConfigWC.appId, paramAppBrandInitConfigWC.eix, null);
      if (localObject4 != null) {
        break label979;
      }
      paramContext = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.task.AppBrandUIProcess");
      AppMethodBeat.o(229417);
      throw paramContext;
      bool1 = false;
      break;
      label739:
      bool2 = false;
      break label393;
      label745:
      localObject1 = g.nPD;
      break label405;
      label753:
      i = 0;
      break label456;
      localObject1 = null;
      break label528;
      label765:
      localObject1 = null;
      break label535;
      label771:
      if (com.tencent.mm.plugin.appbrand.af.g.afU(paramAppBrandInitConfigWC.appId)) {
        localObject1 = bWg();
      }
      for (;;)
      {
        if (bool1)
        {
          localObject2 = paramAppBrandInitConfigWC.appId;
          kotlin.g.b.p.g(localObject2, "cfg.appId");
          localObject2 = b.afn((String)localObject2);
          if ((localObject2 != null) && (kotlin.g.b.p.j(((m)localObject2).bWo(), ((m)localObject1).bWo())))
          {
            i = 2;
            break;
            localObject1 = x(g.nPD);
            continue;
          }
          i = 1;
          break;
        }
      }
      i = 1;
      break label623;
      label862:
      localObject2 = paramAppBrandInitConfigWC.appId;
      kotlin.g.b.p.g(localObject2, "cfg.appId");
      localObject2 = b.afn((String)localObject2);
      if (localObject2 == null)
      {
        localObject2 = k(paramAppBrandInitConfigWC);
        if (localObject2 != null) {
          if (paramAppBrandInitConfigWC.NA())
          {
            localObject1 = g.nPE;
            label911:
            ((m)localObject2).z((g)localObject1);
            i = 2;
          }
        }
        for (localObject1 = localObject2;; localObject1 = localObject2)
        {
          b((n)localObject1);
          break;
          localObject1 = g.nPD;
          break label911;
          localObject2 = x((g)localObject1);
          ((m)localObject2).z((g)localObject1);
          i = 1;
        }
      }
      i = 2;
      localObject1 = localObject2;
    }
    label979:
    if (bool2)
    {
      localObject1 = ((m)localObject4).bWm();
      localObject5 = new Intent(paramContext, (Class)localObject1);
      ((Intent)localObject5).putExtra("key_appbrand_init_config", (Parcelable)paramAppBrandInitConfigWC);
      ((Intent)localObject5).putExtra("key_appbrand_stat_object", (Parcelable)paramAppBrandStatObject);
      ((Intent)localObject5).putExtra("key_app_id", paramAppBrandInitConfigWC.appId);
      kotlin.g.b.p.g(localObject1, "uiClass");
      if ((!com.tencent.mm.plugin.appbrand.utils.b.aI((Class)localObject1)) && ((paramContext instanceof Activity))) {
        break label1407;
      }
      i = 268435456;
      ((Intent)localObject5).addFlags(i);
      if ((paramContext instanceof Activity)) {
        localObject2 = null;
      }
    }
    label1073:
    label1108:
    label1241:
    try
    {
      localObject3 = Util.getCurrentTaskInfo(paramContext, ((Activity)paramContext).getTaskId());
      localObject2 = localObject3;
    }
    catch (Throwable localThrowable2)
    {
      label1120:
      label1407:
      break label1108;
    }
    if (localObject2 != null)
    {
      localObject3 = ((ActivityManager.RunningTaskInfo)localObject2).baseActivity;
      if (localObject3 != null)
      {
        localObject2 = ((ActivityManager.RunningTaskInfo)localObject2).baseActivity;
        if (localObject2 == null) {
          kotlin.g.b.p.hyc();
        }
        kotlin.g.b.p.g(localObject2, "taskInfo.baseActivity!!");
        if (kotlin.g.b.p.j(Util.nullAsNil(((ComponentName)localObject2).getClassName()), ((Class)localObject1).getName()))
        {
          ((Intent)localObject5).putExtra("key_appbrand_bring_ui_to_front_from_task_Base_by_task_top_ui", true);
          ((Intent)localObject5).addFlags(603979776);
        }
      }
      paramAppBrandInitConfigWC.ldO = Util.nowMilliSecond();
      paramAppBrandInitConfigWC.ldU = MMApplicationContext.isProcessExist(((m)localObject4).bWo());
      ((Intent)localObject5).putExtra("key_launch_app_client_version", BuildInfo.CLIENT_VERSION_INT);
      q.bWC();
      WeAppOpenUICallbackIPCProxy.c.a(paramAppBrandInitConfigWC, ((n)localObject4).bWo());
      if (j != 2) {
        break label1419;
      }
      localObject1 = null;
      ((n)localObject4).iE(false);
      if (localObject1 == null) {
        break label1455;
      }
    }
    for (;;)
    {
      try
      {
        if (!((com.tencent.mm.plugin.appbrand.loading.a)localObject1).bOt()) {
          break label1455;
        }
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManagerV2", "startTargetActivity: needPreLoadingUi");
        ((com.tencent.mm.plugin.appbrand.loading.a)localObject1).bOr();
        if (j == 1)
        {
          paramContext = paramAppBrandInitConfigWC.appId;
          kotlin.g.b.p.g(paramContext, "cfg.appId");
          afe(paramContext);
        }
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManagerV2", "startApp appId[%s] type[%d] scene[%d] strategy[%d] targetProcessExists[%b] targetTask[%s] isPluginTask[%b] startAsHalfScreen[%b]", new Object[] { paramAppBrandInitConfigWC.appId, Integer.valueOf(paramAppBrandInitConfigWC.eix), Integer.valueOf(paramAppBrandStatObject.scene), Integer.valueOf(j), Boolean.valueOf(paramAppBrandInitConfigWC.ldU), ((m)localObject4).bWo(), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        AppMethodBeat.o(229417);
        return j;
      }
      catch (Throwable localThrowable1)
      {
        label1419:
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrandTaskManagerV2", localThrowable1, "onNeedPreLoadingUI", new Object[0]);
      }
      localObject1 = ((m)localObject4).bWs();
      break;
      i = 0;
      break label1073;
      localObject3 = null;
      break label1120;
      localObject1 = new com.tencent.mm.plugin.appbrand.loading.a(paramContext, (Intent)localObject5, paramAppBrandInitConfigWC, (n)localObject4, paramAppBrandStatObject);
      break label1241;
      label1455:
      paramAppBrandInitConfigWC.ldT = "";
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bl(localObject5);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, locala.axQ(), "com/tencent/mm/plugin/appbrand/task/AppBrandTaskManagerV2", "startTargetActivity", "(Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingLogic;Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)locala.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/appbrand/task/AppBrandTaskManagerV2", "startTargetActivity", "(Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingLogic;Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      if ((paramContext instanceof Activity)) {
        ((ah)com.tencent.luggage.a.e.M(ah.class)).a((Activity)paramContext, (AppBrandInitConfig)paramAppBrandInitConfigWC);
      }
    }
  }
  
  public final void e(z paramz)
  {
    AppMethodBeat.i(229423);
    kotlin.g.b.p.h(paramz, "scene");
    a(g.nPD, paramz);
    AppMethodBeat.o(229423);
  }
  
  public final int g(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(229416);
    kotlin.g.b.p.h(paramAppBrandInitConfigWC, "cfg");
    kotlin.g.b.p.h(paramAppBrandStatObject, "stat");
    Context localContext = MMApplicationContext.getContext();
    kotlin.g.b.p.g(localContext, "MMApplicationContext.getContext()");
    int i = d(localContext, paramAppBrandInitConfigWC, paramAppBrandStatObject);
    AppMethodBeat.o(229416);
    return i;
  }
  
  public final void onNetworkChange()
  {
    AppMethodBeat.i(229425);
    Iterator localIterator = b.bWj().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (m)localIterator.next();
      kotlin.g.b.p.g(localObject, "task");
      localObject = ((m)localObject).bWx().iterator();
      while (((Iterator)localObject).hasNext())
      {
        AppBrandRemoteTaskController localAppBrandRemoteTaskController = (AppBrandRemoteTaskController)((Iterator)localObject).next();
        if (localAppBrandRemoteTaskController != null) {
          localAppBrandRemoteTaskController.bVT();
        }
      }
    }
    AppMethodBeat.o(229425);
  }
  
  public final void zn(int paramInt)
  {
    AppMethodBeat.i(229420);
    Object localObject2;
    Object localObject3;
    if (2 == paramInt)
    {
      localObject1 = new ConcurrentHashMap();
      localObject2 = b.bWj().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject4 = (m)((Iterator)localObject2).next();
        kotlin.g.b.p.g(localObject4, "task");
        if (!TextUtils.isEmpty((CharSequence)((m)localObject4).bWo())) {
          if (((m)localObject4).bWp())
          {
            ((ConcurrentHashMap)localObject1).putIfAbsent(((m)localObject4).bWo(), Boolean.TRUE);
          }
          else
          {
            localObject3 = (Map)localObject1;
            localObject4 = ((m)localObject4).bWo();
            kotlin.g.b.p.g(localObject4, "task.uiProcessName");
            Boolean localBoolean = Boolean.FALSE;
            kotlin.g.b.p.g(localBoolean, "java.lang.Boolean.FALSE");
            ((Map)localObject3).put(localObject4, localBoolean);
          }
        }
      }
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localObject3 = (String)((Map.Entry)localObject2).getKey();
        if (((Boolean)((Map.Entry)localObject2).getValue()).booleanValue())
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManagerV2", "killAll SILENT_IF_INACTIVE kill process(%s)", new Object[] { localObject3 });
          com.tencent.mm.modelappbrand.b.Lm((String)localObject3);
          com.tencent.mm.bv.a.cs(MMApplicationContext.getContext(), (String)localObject3);
        }
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManagerV2", "killAll SILENT_IF_INACTIVE tryPreloadNextTaskProcess(both waservice and wagame)");
      a(g.nPD, z.nMz, true);
      a(g.nPE, z.nMz, true);
      AppMethodBeat.o(229420);
      return;
    }
    Object localObject1 = b.bWj().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (m)((Iterator)localObject1).next();
      kotlin.g.b.p.g(localObject2, "task");
      localObject2 = ((m)localObject2).bWx().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (AppBrandRemoteTaskController)((Iterator)localObject2).next();
        if (localObject3 != null) {
          ((AppBrandRemoteTaskController)localObject3).zl(paramInt);
        }
      }
    }
    localObject1 = nPY.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (AppBrandRemoteTaskController)((Iterator)localObject1).next();
      if (localObject2 != null) {
        ((AppBrandRemoteTaskController)localObject2).zl(paramInt);
      }
    }
    if (3 == paramInt) {
      nPY.clear();
    }
    AppMethodBeat.o(229420);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/task/AppBrandTaskManagerV2$AppBrandTaskManagerFactory;", "", "()V", "INSTANCE", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandTaskManagerV2;", "getINSTANCE", "()Lcom/tencent/mm/plugin/appbrand/task/AppBrandTaskManagerV2;", "plugin-appbrand-integration_release"})
  static final class a
  {
    private static final i nQb;
    public static final a nQc;
    
    static
    {
      AppMethodBeat.i(229394);
      nQc = new a();
      nQb = new i((byte)0);
      AppMethodBeat.o(229394);
    }
    
    public static i bWk()
    {
      return nQb;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/task/AppBrandTaskManagerV2$Companion;", "", "()V", "PERSISTENT_APPIDS_MAP", "Ljava/util/concurrent/ConcurrentHashMap;", "", "PERSISTENT_TASK_CONTROLLERS", "com/tencent/mm/plugin/appbrand/task/AppBrandTaskManagerV2$Companion$PERSISTENT_TASK_CONTROLLERS$1", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandTaskManagerV2$Companion$PERSISTENT_TASK_CONTROLLERS$1;", "START_AS_HALF_SCREEN_APPS", "Ljava/util/HashSet;", "TAG", "TASK_LIST", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandUIProcess;", "getTASK_LIST", "()Ljava/util/LinkedList;", "setTASK_LIST", "(Ljava/util/LinkedList;)V", "UNKNOWN_TYPE_EXCEPTION", "allRunningTask", "allRunningTask$annotations", "getAllRunningTask", "instance", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandTaskManagerV2;", "getInstance", "()Lcom/tencent/mm/plugin/appbrand/task/AppBrandTaskManagerV2;", "runningTaskList", "runningTaskList$annotations", "findTaskByAppId", "appId", "getAmountOfTasksUsedAs", "", "serviceType", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;", "getAvailableTaskToPreload", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandUITask;", "isReachedServiceTypeMaxLimit", "", "moveToFront", "", "task", "plugin-appbrand-integration_release"})
  public static final class b
  {
    static m afm(String paramString)
    {
      AppMethodBeat.i(229405);
      Iterator localIterator = bWj().iterator();
      while (localIterator.hasNext())
      {
        m localm = (m)localIterator.next();
        kotlin.g.b.p.g(localm, "task");
        if (localm.bWw().contains(paramString))
        {
          AppMethodBeat.o(229405);
          return localm;
        }
      }
      AppMethodBeat.o(229405);
      return null;
    }
    
    public static LinkedList<m> bWj()
    {
      AppMethodBeat.i(229406);
      synchronized (i.bWh())
      {
        LinkedList localLinkedList2 = new LinkedList((Collection)i.bWh());
        AppMethodBeat.o(229406);
        return localLinkedList2;
      }
    }
    
    static int s(g paramg)
    {
      AppMethodBeat.i(229402);
      Iterator localIterator = i.bWi().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        m localm = (m)localIterator.next();
        kotlin.g.b.p.g(localm, "uiTask");
        if (localm.bWq() != paramg) {
          break label61;
        }
        i += 1;
      }
      label61:
      for (;;)
      {
        break;
        AppMethodBeat.o(229402);
        return i;
      }
    }
    
    static boolean t(g paramg)
    {
      AppMethodBeat.i(229403);
      int j = s(paramg);
      if (j <= paramg.nPG) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramg = Util.safeFormatString("TaskManager count the serviceType [%s] in TASK_LIST, count = [%d], but max limit = [%d]", new Object[] { paramg.name(), Integer.valueOf(j), Integer.valueOf(paramg.nPG) });
        kotlin.g.b.p.g(paramg, "Util.safeFormatString(\"T…nt, serviceType.maxLimit)");
        paramg = (Throwable)new IllegalStateException(paramg.toString());
        AppMethodBeat.o(229403);
        throw paramg;
      }
      if (j == paramg.nPG)
      {
        AppMethodBeat.o(229403);
        return true;
      }
      AppMethodBeat.o(229403);
      return false;
    }
    
    static n u(g paramg)
    {
      AppMethodBeat.i(229404);
      int i;
      for (;;)
      {
        synchronized (i.bWi())
        {
          localObject1 = i.nPZ;
          if (t(paramg))
          {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManagerV2", "tryPreloadNextTaskProcess serviceType = [%s] reachedMaxLimit", new Object[] { paramg });
            AppMethodBeat.o(229404);
            return null;
          }
          localObject1 = i.nPZ;
          localObject1 = i.bWi().iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (m)((Iterator)localObject1).next();
            kotlin.g.b.p.g(localObject2, "uiTask");
            if ((!((m)localObject2).bWp()) || (((m)localObject2).bWq() != paramg)) {
              continue;
            }
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManagerV2", "getAvailableTaskToPreload found empty task[%s], which can be used as [%s]", new Object[] { ((m)localObject2).bWo(), paramg });
            paramg = (n)localObject2;
            AppMethodBeat.o(229404);
            return paramg;
          }
          if ((paramg != g.nPE) || (!com.tencent.mm.plugin.appbrand.ui.p.bXv())) {
            break label352;
          }
          paramg = i.nPZ;
          localObject1 = (Iterable)i.bWi();
          paramg = (Collection)new ArrayList();
          localObject1 = ((Iterable)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = ((Iterator)localObject1).next();
          if (((m)localObject2).bWn() == g.nPE)
          {
            i = 1;
            if (i == 0) {
              continue;
            }
            paramg.add(localObject2);
          }
        }
        i = 0;
      }
      Object localObject2 = (List)paramg;
      Object localObject1 = ((Iterable)localObject2).iterator();
      m localm;
      if (((Iterator)localObject1).hasNext())
      {
        paramg = ((Iterator)localObject1).next();
        localm = (m)paramg;
        if ((MMApplicationContext.isProcessExist(localm.bWo())) && (localm.bWp()))
        {
          i = 1;
          break label504;
        }
      }
      for (;;)
      {
        label308:
        localObject1 = (m)paramg;
        paramg = (g)localObject1;
        if (localObject1 == null) {
          paramg = (m)j.ks((List)localObject2);
        }
        paramg = (n)paramg;
        AppMethodBeat.o(229404);
        return paramg;
        i = 0;
        break;
        paramg = null;
      }
      label352:
      localObject1 = i.nPZ;
      localObject2 = ((Iterable)i.bWi()).iterator();
      label369:
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = ((Iterator)localObject2).next();
        localm = (m)localObject1;
        if (localm.bWq() == g.nPF)
        {
          if ((localm.bWn() == null) || (localm.bWn() == g.nPD)) {
            break label511;
          }
          if (localm.bWn() == g.nPF) {
            break label511;
          }
        }
      }
      for (;;)
      {
        localObject2 = (m)localObject1;
        if (localObject2 == null) {}
        for (localObject1 = "null";; localObject1 = ((m)localObject2).bWr())
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManagerV2", "tryPreloadNextTaskProcess serviceType = [%s] not reached max limit , got ui task = [%s]", new Object[] { paramg, localObject1 });
          paramg = (n)localObject2;
          AppMethodBeat.o(229404);
          return paramg;
          i = 0;
          break label513;
          localObject1 = null;
          break;
        }
        label504:
        if (i == 0) {
          break;
        }
        break label308;
        label511:
        i = 1;
        label513:
        if (i == 0) {
          break label369;
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/task/AppBrandTaskManagerV2$Companion$PERSISTENT_TASK_CONTROLLERS$1", "Ljava/util/concurrent/ConcurrentSkipListSet;", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandRemoteTaskController;", "add", "", "element", "plugin-appbrand-integration_release"})
  public static final class c
    extends ConcurrentSkipListSet<AppBrandRemoteTaskController>
  {
    c(Comparator paramComparator)
    {
      super();
    }
    
    public final boolean b(AppBrandRemoteTaskController paramAppBrandRemoteTaskController)
    {
      AppMethodBeat.i(229395);
      Object localObject;
      int i;
      if (paramAppBrandRemoteTaskController != null)
      {
        localObject = (CharSequence)paramAppBrandRemoteTaskController.getAppId();
        if ((localObject == null) || (((CharSequence)localObject).length() == 0))
        {
          i = 1;
          if (i == 0) {
            break label108;
          }
        }
      }
      else
      {
        localObject = new StringBuilder("PERSISTENT_TASK_CONTROLLERS.add get invalid element, appId:");
        if (paramAppBrandRemoteTaskController == null) {
          break label103;
        }
      }
      label103:
      for (paramAppBrandRemoteTaskController = paramAppBrandRemoteTaskController.getAppId();; paramAppBrandRemoteTaskController = null)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandTaskManagerV2", paramAppBrandRemoteTaskController + ", stack:" + android.util.Log.getStackTraceString(new Throwable()));
        AppMethodBeat.o(229395);
        return false;
        i = 0;
        break;
      }
      label108:
      boolean bool = super.add(paramAppBrandRemoteTaskController);
      AppMethodBeat.o(229395);
      return bool;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "o1", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandRemoteTaskController;", "kotlin.jvm.PlatformType", "o2", "compare"})
  static final class d<T>
    implements Comparator<AppBrandRemoteTaskController>
  {
    public static final d nQd;
    
    static
    {
      AppMethodBeat.i(229401);
      nQd = new d();
      AppMethodBeat.o(229401);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(n paramn, g paramg) {}
    
    public final void run()
    {
      AppMethodBeat.i(229409);
      if ((this.nQe.bWq() == g.nPF) && (paramg != g.nPF))
      {
        i.b localb = i.nPZ;
        if (i.b.s(paramg) < paramg.nPG) {
          this.nQe.z(paramg);
        }
      }
      this.nQe.iB(com.tencent.mm.plugin.appbrand.ui.p.bXv());
      AppMethodBeat.o(229409);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "hitLimitByCounter", "", "hitLimitByMemoryPressure", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.m<Boolean, Boolean, x>
  {
    f(boolean paramBoolean, g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.i
 * JD-Core Version:    0.7.0.1
 */