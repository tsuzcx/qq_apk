package com.tencent.mm.plugin.appbrand.task;

import android.app.Activity;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
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
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService1;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService2;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService3;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService4;
import com.tencent.mm.plugin.appbrand.keylogger.c;
import com.tencent.mm.plugin.appbrand.launching.WeAppOpenUICallbackIPCProxy.c;
import com.tencent.mm.plugin.appbrand.loading.AppBrandProcessTriggerService0;
import com.tencent.mm.plugin.appbrand.loading.AppBrandProcessTriggerService1;
import com.tencent.mm.plugin.appbrand.loading.AppBrandProcessTriggerService2;
import com.tencent.mm.plugin.appbrand.loading.AppBrandProcessTriggerService3;
import com.tencent.mm.plugin.appbrand.loading.AppBrandProcessTriggerService4;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.task.preload.e.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingUI1;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingUI2;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingUI3;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingUI4;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI1;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI2;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI3;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI4;
import com.tencent.mm.plugin.appbrand.ui.ah;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;
import kotlin.g.a.m;
import kotlin.x;

public class h
  implements p, p.a
{
  private static final LinkedList<n> nPK;
  private static final LinkedList<n> nPL;
  public static final n nPM;
  private static final ConcurrentHashMap<String, String> nPN;
  private static final Set<String> nPO;
  private static final ConcurrentSkipListSet<AppBrandRemoteTaskController> nPP;
  
  static
  {
    AppMethodBeat.i(48471);
    if (!h.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      nPN = new ConcurrentHashMap();
      nPO = new HashSet();
      nPP = new ConcurrentSkipListSet(new Comparator() {}) {};
      LinkedList localLinkedList = new LinkedList();
      nPK = localLinkedList;
      localLinkedList.add(new n(AppBrandUI.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class, AppBrandForegroundNotificationService.class, AppBrandProcessTriggerService0.class, AppBrandPreLoadingUI.class));
      nPK.add(new n(AppBrandUI1.class, AppBrandTaskPreloadReceiver1.class, AppBrandKeepAliveService1.class, AppBrandForegroundNotificationService1.class, AppBrandProcessTriggerService1.class, AppBrandPreLoadingUI1.class));
      nPK.add(new n(AppBrandUI2.class, AppBrandTaskPreloadReceiver2.class, AppBrandKeepAliveService2.class, AppBrandForegroundNotificationService2.class, AppBrandProcessTriggerService2.class, AppBrandPreLoadingUI2.class));
      nPK.add(new n(AppBrandUI3.class, AppBrandTaskPreloadReceiver3.class, AppBrandKeepAliveService3.class, AppBrandForegroundNotificationService3.class, AppBrandProcessTriggerService3.class, AppBrandPreLoadingUI3.class));
      nPK.add(new n(AppBrandUI4.class, AppBrandTaskPreloadReceiver4.class, AppBrandKeepAliveService4.class, AppBrandForegroundNotificationService4.class, AppBrandProcessTriggerService4.class, AppBrandPreLoadingUI4.class));
      nPM = new d();
      localLinkedList = new LinkedList();
      nPL = localLinkedList;
      localLinkedList.addAll(nPK);
      nPL.add(nPM);
      AppMethodBeat.o(48471);
      return;
    }
  }
  
  private static n a(List<n> paramList, g paramg)
  {
    AppMethodBeat.i(48454);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      n localn = (n)paramList.next();
      if (localn.nQv == paramg)
      {
        AppMethodBeat.o(48454);
        return localn;
      }
    }
    AppMethodBeat.o(48454);
    return null;
  }
  
  private static boolean a(n paramn)
  {
    AppMethodBeat.i(227500);
    boolean bool = paramn.nQk.endsWith(AppBrandPluginUI.class.getSimpleName());
    AppMethodBeat.o(227500);
    return bool;
  }
  
  public static void afd(String paramString)
  {
    AppMethodBeat.i(227495);
    c.a(paramString, KSProcessWeAppLaunch.stepContainerUILaunch);
    AppMethodBeat.o(227495);
  }
  
  private static n afh(String paramString)
  {
    AppMethodBeat.i(48458);
    Iterator localIterator = bVZ().iterator();
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      if (localn.bWw().contains(paramString))
      {
        AppMethodBeat.o(48458);
        return localn;
      }
    }
    AppMethodBeat.o(48458);
    return null;
  }
  
  private static LinkedList<n> bVZ()
  {
    AppMethodBeat.i(48466);
    synchronized (nPL)
    {
      LinkedList localLinkedList2 = new LinkedList(nPL);
      AppMethodBeat.o(48466);
      return localLinkedList2;
    }
  }
  
  public static List<String> bWa()
  {
    AppMethodBeat.i(227505);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = nPL.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (n)localIterator.next();
      if (localObject != null)
      {
        ((n)localObject).bWw();
        if (((n)localObject).bWw().size() > 0) {
          localArrayList.addAll(((n)localObject).bWw());
        }
      }
    }
    localIterator = nPP.iterator();
    while (localIterator.hasNext())
    {
      localObject = (AppBrandRemoteTaskController)localIterator.next();
      if ((localObject != null) && (((AppBrandRemoteTaskController)localObject).mAppId != null)) {
        localArrayList.add(((AppBrandRemoteTaskController)localObject).mAppId);
      }
    }
    AppMethodBeat.o(227505);
    return localArrayList;
  }
  
  public static p bWb()
  {
    AppMethodBeat.i(227506);
    if (!MMApplicationContext.isMainProcess()) {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandTaskManager", "getInstance: only getInstance from main process:", new Object[] { android.util.Log.getStackTraceString(new Throwable()) });
    }
    if (com.tencent.mm.plugin.appbrand.ui.p.bXu())
    {
      localObject = i.nPZ;
      localObject = i.a.nQc;
      localObject = i.a.bWk();
      AppMethodBeat.o(227506);
      return localObject;
    }
    Object localObject = a.bWf();
    AppMethodBeat.o(227506);
    return localObject;
  }
  
  static p.a bWc()
  {
    AppMethodBeat.i(227507);
    if (com.tencent.mm.plugin.appbrand.ui.p.bXu())
    {
      localObject = i.nPZ;
      localObject = i.a.nQc;
      localObject = i.a.bWk();
      AppMethodBeat.o(227507);
      return localObject;
    }
    Object localObject = a.bWf();
    AppMethodBeat.o(227507);
    return localObject;
  }
  
  static LinkedList<n> bWd()
  {
    AppMethodBeat.i(48467);
    if (com.tencent.mm.plugin.appbrand.ui.p.bXu())
    {
      ??? = new LinkedList();
      ???.addAll(i.bWj());
      AppMethodBeat.o(48467);
      return ???;
    }
    synchronized (nPL)
    {
      LinkedList localLinkedList2 = new LinkedList(nPL);
      AppMethodBeat.o(48467);
      return localLinkedList2;
    }
  }
  
  private static void ck(String paramString, int paramInt)
  {
    AppMethodBeat.i(48440);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(48440);
      return;
    }
    Object localObject = nPP.iterator();
    LinkedList localLinkedList = new LinkedList();
    while (((Iterator)localObject).hasNext())
    {
      AppBrandRemoteTaskController localAppBrandRemoteTaskController = (AppBrandRemoteTaskController)((Iterator)localObject).next();
      if ((paramString.equals(localAppBrandRemoteTaskController.mAppId)) && ((paramInt == localAppBrandRemoteTaskController.mDebugType) || (paramInt < 0)))
      {
        localAppBrandRemoteTaskController.afa(paramString);
        localLinkedList.add(localAppBrandRemoteTaskController);
      }
    }
    paramString = localLinkedList.iterator();
    while (paramString.hasNext())
    {
      localObject = (AppBrandRemoteTaskController)paramString.next();
      nPP.remove(localObject);
    }
    AppMethodBeat.o(48440);
  }
  
  private AppBrandRemoteTaskController cm(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(48461);
    paramString = (AppBrandRemoteTaskController)new android.arch.a.c.a() {}.apply(null);
    if ((paramString != null) && (paramString.bVS()))
    {
      AppMethodBeat.o(48461);
      return paramString;
    }
    AppMethodBeat.o(48461);
    return null;
  }
  
  private static int s(g paramg)
  {
    AppMethodBeat.i(227502);
    Iterator localIterator = nPK.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (((n)localIterator.next()).nQv != paramg) {
        break label55;
      }
      i += 1;
    }
    label55:
    for (;;)
    {
      break;
      AppMethodBeat.o(227502);
      return i;
    }
  }
  
  private static boolean t(g paramg)
  {
    AppMethodBeat.i(48455);
    int i = s(paramg);
    if (i > paramg.nPG)
    {
      paramg = new IllegalStateException(Util.safeFormatString("TaskManager count the serviceType [%s] in TASK_LIST, count = [%d], but max limit = [%d]", new Object[] { paramg.name(), Integer.valueOf(i), Integer.valueOf(paramg.nPG) }));
      AppMethodBeat.o(48455);
      throw paramg;
    }
    if (i == paramg.nPG)
    {
      AppMethodBeat.o(48455);
      return true;
    }
    AppMethodBeat.o(48455);
    return false;
  }
  
  private static n u(g paramg)
  {
    AppMethodBeat.i(48456);
    synchronized (nPK)
    {
      if (t(paramg))
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess serviceType = [%s] reachedMaxLimit", new Object[] { paramg });
        AppMethodBeat.o(48456);
        return null;
      }
      Object localObject = nPK.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localn = (n)((Iterator)localObject).next();
        if ((localn.bWp()) && (localn.nQv == paramg))
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup found empty task[%s], which can be used as [%s]", new Object[] { localn.nQm, paramg });
          AppMethodBeat.o(48456);
          return localn;
        }
      }
      n localn = a(nPK, g.nPF);
      if (localn == null)
      {
        localObject = "null";
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess serviceType = [%s] not reached max limit , got ui task = [%s]", new Object[] { paramg, localObject });
        AppMethodBeat.o(48456);
        return localn;
      }
      localObject = localn.nQk;
    }
  }
  
  private static n v(g paramg)
  {
    AppMethodBeat.i(48457);
    LinkedList localLinkedList = nPK;
    Object localObject1 = null;
    label267:
    for (;;)
    {
      try
      {
        Iterator localIterator = nPK.iterator();
        if (!localIterator.hasNext()) {
          break label267;
        }
        n localn = (n)localIterator.next();
        Object localObject2 = localObject1;
        if (localn.bWp())
        {
          localObject2 = localObject1;
          if (localn.nQv == paramg)
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = localn;
            }
            if (localn.nQw.get())
            {
              localObject1 = localn;
              if (localObject1 == null) {
                continue;
              }
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup found empty task, which can be used as [%s], info [%s]", new Object[] { paramg, localObject1 });
              paramg = (g)localObject1;
              return paramg;
            }
          }
        }
        localObject1 = localObject2;
        continue;
        if (t(paramg))
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup [%s] task reached maxLimit", new Object[] { paramg });
          localObject1 = a(nPK, paramg);
          paramg = (g)localObject1;
          if ($assertionsDisabled) {
            continue;
          }
          paramg = (g)localObject1;
          if (localObject1 != null) {
            continue;
          }
          paramg = new AssertionError();
          AppMethodBeat.o(48457);
          throw paramg;
        }
      }
      finally
      {
        AppMethodBeat.o(48457);
      }
      localObject1 = a(nPK, g.nPF);
      if (localObject1 != null)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup found not used task, which can be used as [%s]", new Object[] { paramg });
        paramg = (g)localObject1;
      }
      else
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup all full for [%s]", new Object[] { paramg });
        paramg = (n)nPK.getFirst();
      }
    }
  }
  
  public final void Ue(String paramString)
  {
    AppMethodBeat.i(227508);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManager", "onRuntimeFinish appId=".concat(String.valueOf(paramString)));
    nPO.remove(paramString);
    AppMethodBeat.o(227508);
  }
  
  public final n a(String paramString1, String paramString2, g paramg)
  {
    AppMethodBeat.i(227504);
    paramg = bVZ().iterator();
    while (paramg.hasNext())
    {
      n localn = (n)paramg.next();
      if ((localn.bWw().contains(paramString1)) && (localn.nQk.equals(paramString2)))
      {
        AppMethodBeat.o(227504);
        return localn;
      }
    }
    AppMethodBeat.o(227504);
    return null;
  }
  
  public final void a(g paramg, z paramz)
  {
    AppMethodBeat.i(227497);
    a(paramg, paramz, z.d(paramz));
    AppMethodBeat.o(227497);
  }
  
  public final void a(g paramg, z paramz, final boolean paramBoolean)
  {
    AppMethodBeat.i(227499);
    if ((!com.tencent.mm.plugin.appbrand.appusage.i.bxK()) || (com.tencent.mm.plugin.appbrand.task.preload.e.bWG()) || (paramg == g.nPF))
    {
      AppMethodBeat.o(227499);
      return;
    }
    if (g.nPE == paramg) {}
    int j;
    int i;
    for (boolean bool = true;; bool = false)
    {
      j = com.tencent.mm.plugin.appbrand.task.preload.e.iF(bool);
      com.tencent.mm.plugin.report.service.h.CyF.dN(j, paramz.nMT);
      i = com.tencent.mm.plugin.appbrand.task.preload.e.a(e.a.A(paramg), new m() {});
      if ((paramBoolean) || (i != -1)) {
        break;
      }
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess type[%s] scene[%s] hit interval limit", new Object[] { paramg, paramz });
      AppMethodBeat.o(227499);
      return;
    }
    com.tencent.mm.plugin.report.service.h.CyF.dN(j, paramz.nMU);
    if (paramBoolean) {
      i = 2;
    }
    switch (7.nPU[paramg.ordinal()])
    {
    default: 
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess serviceType[%s] scene[%s] preload level[%d]", new Object[] { paramg, paramz, Integer.valueOf(i) });
      paramz = u(paramg);
      if (paramz != null)
      {
        paramz.z(paramg);
        paramz.R(i, a(paramz));
        if (i != 2) {
          com.tencent.mm.plugin.report.service.h.CyF.dN(915, 30);
        }
        switch (7.nPU[paramg.ordinal()])
        {
        }
      }
      break;
    case 1: 
    case 2: 
      for (;;)
      {
        AppMethodBeat.o(227499);
        return;
        com.tencent.mm.plugin.report.service.h.CyF.dN(1144, 0);
        break;
        com.tencent.mm.plugin.report.service.h.CyF.dN(1144, 1);
        break;
        com.tencent.mm.plugin.report.service.h.CyF.dN(1144, 3);
        AppMethodBeat.o(227499);
        return;
        com.tencent.mm.plugin.report.service.h.CyF.dN(1144, 4);
      }
    }
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess serviceType = [%s], preload level = [%d] has no AppBrandUITask", new Object[] { paramg, Integer.valueOf(i) });
    com.tencent.mm.plugin.report.service.h.CyF.dN(915, 33);
    AppMethodBeat.o(227499);
  }
  
  public final void a(String paramString, AppBrandRemoteTaskController paramAppBrandRemoteTaskController)
  {
    AppMethodBeat.i(48439);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(48439);
      return;
    }
    nPN.remove(paramString);
    if (paramAppBrandRemoteTaskController != null) {
      nPP.remove(paramAppBrandRemoteTaskController);
    }
    AppMethodBeat.o(48439);
  }
  
  public final void a(final String paramString, final g paramg)
  {
    AppMethodBeat.i(227501);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(227501);
      return;
    }
    n localn = b(paramString, null);
    paramString = localn;
    if (nPM == localn) {
      paramString = b(AppBrandUI.class.getName(), null);
    }
    if (paramString == null)
    {
      AppMethodBeat.o(227501);
      return;
    }
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(227490);
        if ((paramString.nQv == g.nPF) && (paramg != g.nPF) && (h.w(paramg) < paramg.nPG)) {
          paramString.z(paramg);
        }
        paramString.iB(h.c(paramString));
        AppMethodBeat.o(227490);
      }
    }, 500L);
    AppMethodBeat.o(227501);
  }
  
  public final void a(String paramString1, String paramString2, AppBrandRemoteTaskController paramAppBrandRemoteTaskController)
  {
    AppMethodBeat.i(48438);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(48438);
      return;
    }
    nPN.put(paramString1, paramString2);
    if (paramAppBrandRemoteTaskController != null)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManager", "stashPersistentApp appId:%s, processName:%s, controller.id:%s", new Object[] { paramString1, paramString2, paramAppBrandRemoteTaskController.jEY });
      nPP.remove(paramAppBrandRemoteTaskController);
      nPP.add(paramAppBrandRemoteTaskController);
    }
    AppMethodBeat.o(48438);
  }
  
  public final void afe(String paramString)
  {
    AppMethodBeat.i(48444);
    Iterator localIterator = bVZ().iterator();
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      if ((localn != null) && (localn.afq(paramString) != null))
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManager", "clearDuplicatedApp task:%s, appId:%s", new Object[] { localn.nQk, paramString });
        localn.afq(paramString).afa(paramString);
      }
    }
    ck(paramString, -1);
    AppMethodBeat.o(48444);
  }
  
  public final Class aff(String paramString)
  {
    AppMethodBeat.i(48452);
    Iterator localIterator = bVZ().iterator();
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      if (localn.nQk.equals(paramString))
      {
        paramString = localn.nQo;
        AppMethodBeat.o(48452);
        return paramString;
      }
    }
    AppMethodBeat.o(48452);
    return null;
  }
  
  public final Class afg(String paramString)
  {
    AppMethodBeat.i(48453);
    Iterator localIterator = bVZ().iterator();
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      if (localn.nQk.equals(paramString))
      {
        paramString = localn.nQp;
        AppMethodBeat.o(48453);
        return paramString;
      }
    }
    AppMethodBeat.o(48453);
    return null;
  }
  
  public final boolean afi(String paramString)
  {
    AppMethodBeat.i(185914);
    boolean bool = cn(paramString, -1);
    AppMethodBeat.o(185914);
    return bool;
  }
  
  public final Pair<String, Integer> afj(String paramString)
  {
    AppMethodBeat.i(160619);
    paramString = cm(paramString, -1);
    if (paramString == null)
    {
      AppMethodBeat.o(160619);
      return null;
    }
    paramString = Pair.create(paramString.mAppId, Integer.valueOf(paramString.mDebugType));
    AppMethodBeat.o(160619);
    return paramString;
  }
  
  public final void afk(String arg1)
  {
    AppMethodBeat.i(48468);
    n localn = afh(???);
    if (localn != null)
    {
      localn.afk(???);
      if (localn.bWw().isEmpty())
      {
        synchronized (nPL)
        {
          nPL.remove(localn);
          nPL.addFirst(localn);
        }
        synchronized (nPK)
        {
          if (nPK.contains(localn))
          {
            nPK.remove(localn);
            nPK.addFirst(localn);
          }
          AppMethodBeat.o(48468);
          return;
          localObject1 = finally;
          AppMethodBeat.o(48468);
          throw localObject1;
        }
      }
    }
    AppMethodBeat.o(48468);
  }
  
  public final n b(String paramString, g paramg)
  {
    AppMethodBeat.i(227503);
    paramg = bVZ().iterator();
    while (paramg.hasNext())
    {
      n localn = (n)paramg.next();
      if (localn.nQk.equals(paramString))
      {
        AppMethodBeat.o(227503);
        return localn;
      }
    }
    Assert.assertTrue(true);
    AppMethodBeat.o(227503);
    return null;
  }
  
  public final void b(n paramn)
  {
    AppMethodBeat.i(48469);
    synchronized (nPL)
    {
      nPL.remove(paramn);
      nPL.addLast(paramn);
    }
    synchronized (nPK)
    {
      if (nPK.contains(paramn))
      {
        nPK.remove(paramn);
        nPK.addLast(paramn);
      }
      AppMethodBeat.o(48469);
      return;
      paramn = finally;
      AppMethodBeat.o(48469);
      throw paramn;
    }
  }
  
  public final void bVX()
  {
    AppMethodBeat.i(227496);
    Iterator localIterator1 = bVZ().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((n)localIterator1.next()).bWx().iterator();
      while (localIterator2.hasNext()) {
        ((AppBrandRemoteTaskController)localIterator2.next()).zl(4);
      }
    }
    AppMethodBeat.o(227496);
  }
  
  public final int[] bVY()
  {
    AppMethodBeat.i(48465);
    Object localObject = bVZ();
    int[] arrayOfInt = new int[((LinkedList)localObject).size()];
    localObject = ((LinkedList)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      arrayOfInt[i] = ((n)((Iterator)localObject).next()).nPc;
      i += 1;
    }
    AppMethodBeat.o(48465);
    return arrayOfInt;
  }
  
  public final void cl(String paramString, int paramInt)
  {
    AppMethodBeat.i(48442);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(48442);
      return;
    }
    n localn = afh(paramString);
    if (localn == null)
    {
      ck(paramString, paramInt);
      AppMethodBeat.o(48442);
      return;
    }
    if (((paramInt < 0) || (localn.afo(paramString).intValue() == paramInt)) && (localn.afq(paramString) != null)) {
      localn.afq(paramString).afa(paramString);
    }
    AppMethodBeat.o(48442);
  }
  
  public final boolean cn(String paramString, int paramInt)
  {
    AppMethodBeat.i(48462);
    if (cm(paramString, paramInt) != null)
    {
      AppMethodBeat.o(48462);
      return true;
    }
    AppMethodBeat.o(48462);
    return false;
  }
  
  public final String co(String paramString, int paramInt)
  {
    AppMethodBeat.i(48464);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(48464);
      return null;
    }
    try
    {
      paramString = cm(paramString, paramInt);
      if (paramString != null)
      {
        paramString = paramString.nPi;
        AppMethodBeat.o(48464);
        return paramString;
      }
    }
    catch (NullPointerException paramString)
    {
      if (BuildInfo.IS_FLAVOR_RED)
      {
        AppMethodBeat.o(48464);
        throw paramString;
      }
      com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrandTaskManager", paramString, "[NOT CRASH]getAliveInstanceId", new Object[0]);
      AppMethodBeat.o(48464);
    }
    return null;
  }
  
  public final int d(Context paramContext, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(48441);
    if ((!TextUtils.isEmpty(paramAppBrandStatObject.dCw)) && (paramAppBrandStatObject.dCw.length() >= 1024))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManager", "startApp, appId[%s], scene[%d], preScene[%d], sceneNote too long, strip it", new Object[] { paramAppBrandInitConfigWC.appId, Integer.valueOf(paramAppBrandStatObject.scene), Integer.valueOf(paramAppBrandStatObject.ecU) });
      paramAppBrandStatObject.dCw = paramAppBrandStatObject.dCw.substring(0, 1024);
    }
    if ((!TextUtils.isEmpty(paramAppBrandStatObject.ecV)) && (paramAppBrandStatObject.ecV.length() >= 1024))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManager", "startApp, appId[%s], scene[%d], preScene[%d], preSceneNote too long, strip it", new Object[] { paramAppBrandInitConfigWC.appId, Integer.valueOf(paramAppBrandStatObject.scene), Integer.valueOf(paramAppBrandStatObject.ecU) });
      paramAppBrandStatObject.ecV = paramAppBrandStatObject.ecV.substring(0, 1024);
    }
    com.tencent.mm.plugin.appbrand.report.model.e.nIB.ch(paramAppBrandInitConfigWC.appId, paramAppBrandInitConfigWC.appVersion);
    c.a(paramAppBrandInitConfigWC.appId, KSProcessWeAppLaunch.stepContainerUILaunch);
    boolean bool1;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    boolean bool2;
    label343:
    int i;
    label371:
    label377:
    int j;
    if ((paramAppBrandInitConfigWC.kHL.isEnable()) || (nPO.contains(paramAppBrandInitConfigWC.appId)))
    {
      bool1 = true;
      if (bool1)
      {
        nPO.add(paramAppBrandInitConfigWC.appId);
        paramAppBrandInitConfigWC.leg = true;
      }
      if ((!paramAppBrandInitConfigWC.ldN) && (!"wxfe02ecfe70800f46".equalsIgnoreCase(paramAppBrandInitConfigWC.appId)) && (!bool1) && (paramAppBrandInitConfigWC.launchMode != 1) && (!paramAppBrandInitConfigWC.lei)) {
        break label801;
      }
      localObject1 = nPM;
      ((n)localObject1).z(g.nPD);
      localObject2 = nPM.nQm;
      if (!nPN.containsKey(paramAppBrandInitConfigWC.appId)) {
        break label742;
      }
      localObject3 = (String)nPN.get(paramAppBrandInitConfigWC.appId);
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        break label742;
      }
      bool2 = ((String)localObject3).equals(localObject2);
      if (!bool2) {
        break label748;
      }
      a(paramAppBrandInitConfigWC.appId, cm(paramAppBrandInitConfigWC.appId, paramAppBrandInitConfigWC.eix));
      i = 2;
      b((n)localObject1);
      ((n)localObject1).a(paramAppBrandInitConfigWC.appId, paramAppBrandInitConfigWC.eix, null);
      if (paramContext != null) {
        break label1356;
      }
      paramContext = MMApplicationContext.getContext();
      label399:
      localObject3 = new Intent(paramContext, ((n)localObject1).nQl);
      ((Intent)localObject3).putExtra("key_appbrand_init_config", paramAppBrandInitConfigWC);
      ((Intent)localObject3).putExtra("key_appbrand_stat_object", paramAppBrandStatObject);
      ((Intent)localObject3).putExtra("key_app_id", paramAppBrandInitConfigWC.appId);
      if ((!com.tencent.mm.plugin.appbrand.utils.b.aI(((n)localObject1).nQl)) && ((paramContext instanceof Activity))) {
        break label1194;
      }
      j = 268435456;
      ((Intent)localObject3).addFlags(j);
      if (!(paramContext instanceof Activity)) {}
    }
    label801:
    label1194:
    label1356:
    label1359:
    for (;;)
    {
      try
      {
        localObject2 = Util.getCurrentTaskInfo(paramContext, ((Activity)paramContext).getTaskId());
        if ((localObject2 != null) && (((ActivityManager.RunningTaskInfo)localObject2).baseActivity != null) && (Util.nullAsNil(((ActivityManager.RunningTaskInfo)localObject2).baseActivity.getClassName()).equals(((n)localObject1).nQk)))
        {
          ((Intent)localObject3).putExtra("key_appbrand_bring_ui_to_front_from_task_Base_by_task_top_ui", true);
          ((Intent)localObject3).addFlags(603979776);
        }
        paramAppBrandInitConfigWC.ldO = Util.nowMilliSecond();
        paramAppBrandInitConfigWC.ldU = MMApplicationContext.isProcessExist(((n)localObject1).nQm);
        ((Intent)localObject3).putExtra("key_launch_app_client_version", BuildInfo.CLIENT_VERSION_INT);
        q.bWC();
        WeAppOpenUICallbackIPCProxy.c.a(paramAppBrandInitConfigWC, ((n)localObject1).nQm);
        if (i == 2)
        {
          localObject2 = null;
          ((n)localObject1).iE(false);
          if (localObject2 == null) {}
        }
        else
        {
          try
          {
            if (!((com.tencent.mm.plugin.appbrand.loading.a)localObject2).bOt()) {
              continue;
            }
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManager", "startTargetActivity: needPreLoadingUi");
            ((com.tencent.mm.plugin.appbrand.loading.a)localObject2).bOr();
            if (i == 1) {
              afe(paramAppBrandInitConfigWC.appId);
            }
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManager", "startApp appId[%s] type[%d] scene[%d] strategy[%d] targetProcessExists[%b], startAsHalfScreen[%b] targetTask[%s]", new Object[] { paramAppBrandInitConfigWC.appId, Integer.valueOf(paramAppBrandInitConfigWC.eix), Integer.valueOf(paramAppBrandStatObject.scene), Integer.valueOf(i), Boolean.valueOf(paramAppBrandInitConfigWC.ldU), Boolean.valueOf(bool1), ((n)localObject1).nQl });
            AppMethodBeat.o(48441);
            return i;
          }
          catch (Throwable localThrowable2)
          {
            label742:
            label748:
            com.tencent.mm.plugin.appbrand.loading.a locala;
            com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrandTaskManager", localThrowable2, "onNeedPreLoadingUI", new Object[0]);
          }
          bool1 = false;
          break;
          bool2 = false;
          break label343;
          if (bool1)
          {
            localObject2 = afh(paramAppBrandInitConfigWC.appId);
            if ((localObject2 != null) && (((n)localObject2).nQm.equals(((n)localObject1).nQm)))
            {
              i = 2;
              break label371;
            }
            i = 1;
            break label371;
          }
          i = 1;
          break label371;
          localObject1 = afh(paramAppBrandInitConfigWC.appId);
          if ((localObject1 == null) || (localObject1 == nPM))
          {
            if ((!TextUtils.isEmpty(paramAppBrandInitConfigWC.ldP)) && (localObject1 == nPM))
            {
              localObject3 = bVZ().iterator();
              if (!((Iterator)localObject3).hasNext()) {
                break label1359;
              }
              localObject2 = (n)((Iterator)localObject3).next();
              if ((!paramAppBrandInitConfigWC.ldP.equals(((n)localObject2).nQm)) || (localObject2 == nPM)) {
                continue;
              }
              localObject1 = localObject2;
              if ((localObject1 != null) && ((((n)localObject1).nQv != g.nPE) || (!paramAppBrandInitConfigWC.NA())))
              {
                if (paramAppBrandInitConfigWC.NA())
                {
                  localObject2 = g.nPE;
                  ((n)localObject1).z((g)localObject2);
                  localObject2 = cm(paramAppBrandInitConfigWC.appId, paramAppBrandInitConfigWC.eix);
                  if ((localObject2 == null) || (!((n)localObject1).nQm.equals(((AppBrandRemoteTaskController)localObject2).mProcessName))) {
                    continue;
                  }
                  i = 2;
                  b((n)localObject1);
                  break label377;
                }
                localObject2 = g.nPD;
                continue;
                i = 1;
                continue;
              }
            }
            if (nPN.containsKey(paramAppBrandInitConfigWC.appId))
            {
              localObject2 = (String)nPN.get(paramAppBrandInitConfigWC.appId);
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                localObject3 = nPK.iterator();
                if (((Iterator)localObject3).hasNext())
                {
                  localObject1 = (n)((Iterator)localObject3).next();
                  if (!((String)localObject2).equals(((n)localObject1).nQm)) {
                    continue;
                  }
                  if (localObject1 == null) {
                    continue;
                  }
                  if (!paramAppBrandInitConfigWC.NA()) {
                    continue;
                  }
                  localObject2 = g.nPE;
                  ((n)localObject1).z((g)localObject2);
                  i = 2;
                  continue;
                }
              }
            }
            localObject1 = null;
            continue;
            localObject2 = g.nPD;
            continue;
            if (paramAppBrandInitConfigWC.NA())
            {
              localObject1 = g.nPE;
              localObject2 = v((g)localObject1);
              if (paramAppBrandInitConfigWC.NA())
              {
                localObject1 = g.nPE;
                ((n)localObject2).z((g)localObject1);
                i = 1;
                localObject1 = localObject2;
              }
            }
            else
            {
              localObject1 = g.nPD;
              continue;
            }
            localObject1 = g.nPD;
            continue;
          }
          i = 2;
          break label377;
          j = 0;
        }
      }
      catch (Throwable localThrowable1)
      {
        locala = null;
        continue;
        locala = new com.tencent.mm.plugin.appbrand.loading.a(paramContext, (Intent)localObject3, paramAppBrandInitConfigWC, (n)localObject1, paramAppBrandStatObject);
        continue;
        paramAppBrandInitConfigWC.ldT = "";
        com.tencent.mm.hellhoundlib.b.a locala1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject3);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, locala1.axQ(), "com/tencent/mm/plugin/appbrand/task/AppBrandTaskManager", "startTargetActivity", "(Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingLogic;Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)locala1.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/appbrand/task/AppBrandTaskManager", "startTargetActivity", "(Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingLogic;Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if (!(paramContext instanceof Activity)) {
          continue;
        }
        ((ah)com.tencent.luggage.a.e.M(ah.class)).a((Activity)paramContext, paramAppBrandInitConfigWC);
        continue;
      }
      break label399;
    }
  }
  
  public final void e(z paramz)
  {
    AppMethodBeat.i(227498);
    if (com.tencent.mm.plugin.appbrand.task.preload.e.bWG())
    {
      AppMethodBeat.o(227498);
      return;
    }
    com.tencent.mm.plugin.report.service.h.CyF.dN(1144, paramz.nMT);
    if ((!z.d(paramz)) && (com.tencent.mm.plugin.appbrand.task.preload.e.a(e.a.nQZ, new m() {}) == -1)) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManager", "preloadPluginUIProcess, hitLimit[%b], scene[%s]", new Object[] { Boolean.valueOf(bool), paramz.name() });
      if (!bool)
      {
        com.tencent.mm.plugin.report.service.h.CyF.dN(1144, 2);
        com.tencent.mm.plugin.report.service.h.CyF.dN(1144, paramz.nMU);
        paramz = nPM;
        paramz.iB(a(paramz));
      }
      AppMethodBeat.o(227498);
      return;
    }
  }
  
  public final int g(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(227494);
    int i = d(null, paramAppBrandInitConfigWC, paramAppBrandStatObject);
    AppMethodBeat.o(227494);
    return i;
  }
  
  public final void onNetworkChange()
  {
    AppMethodBeat.i(48451);
    Iterator localIterator1 = bVZ().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((n)localIterator1.next()).bWx().iterator();
      while (localIterator2.hasNext())
      {
        AppBrandRemoteTaskController localAppBrandRemoteTaskController = (AppBrandRemoteTaskController)localIterator2.next();
        if (localAppBrandRemoteTaskController != null) {
          localAppBrandRemoteTaskController.bVT();
        }
      }
    }
    AppMethodBeat.o(48451);
  }
  
  public final void zn(int paramInt)
  {
    AppMethodBeat.i(48443);
    Object localObject2;
    Object localObject3;
    if (2 == paramInt)
    {
      localObject1 = new HashMap();
      localObject2 = bVZ().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (n)((Iterator)localObject2).next();
        if (!TextUtils.isEmpty(((n)localObject3).nQm)) {
          if (((n)localObject3).bWp())
          {
            localObject3 = ((n)localObject3).nQm;
            Boolean localBoolean = Boolean.TRUE;
            if (Build.VERSION.SDK_INT >= 24) {
              ((HashMap)localObject1).putIfAbsent(localObject3, localBoolean);
            } else if (((HashMap)localObject1).get(localObject3) == null) {
              ((HashMap)localObject1).put(localObject3, localBoolean);
            }
          }
          else
          {
            ((HashMap)localObject1).put(((n)localObject3).nQm, Boolean.FALSE);
          }
        }
      }
      localObject1 = ((HashMap)localObject1).entrySet().iterator();
      label238:
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if ((((Map.Entry)localObject2).getValue() != null) && (((Boolean)((Map.Entry)localObject2).getValue()).booleanValue())) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label238;
          }
          localObject2 = (String)((Map.Entry)localObject2).getKey();
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManager", "killAll SILENT_IF_INACTIVE kill process(%s)", new Object[] { localObject2 });
          com.tencent.mm.modelappbrand.b.Lm((String)localObject2);
          com.tencent.mm.bv.a.cs(MMApplicationContext.getContext(), (String)localObject2);
          break;
        }
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManager", "killAll SILENT_IF_INACTIVE tryPreloadNextTaskProcess(both waservice and wagame)");
      a(g.nPD, z.nMz, true);
      a(g.nPE, z.nMz, true);
      AppMethodBeat.o(48443);
      return;
    }
    Object localObject1 = bVZ().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((n)((Iterator)localObject1).next()).bWx().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (AppBrandRemoteTaskController)((Iterator)localObject2).next();
        if (localObject3 != null) {
          ((AppBrandRemoteTaskController)localObject3).zl(paramInt);
        }
      }
    }
    localObject1 = nPP.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (AppBrandRemoteTaskController)((Iterator)localObject1).next();
      if (localObject2 != null) {
        ((AppBrandRemoteTaskController)localObject2).zl(paramInt);
      }
    }
    if (3 == paramInt) {
      nPP.clear();
    }
    AppMethodBeat.o(48443);
  }
  
  static final class a
  {
    private static final h nPV;
    
    static
    {
      AppMethodBeat.i(227493);
      nPV = new h((byte)0);
      AppMethodBeat.o(227493);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.h
 * JD-Core Version:    0.7.0.1
 */