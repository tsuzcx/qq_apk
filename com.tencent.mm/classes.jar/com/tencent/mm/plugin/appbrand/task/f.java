package com.tencent.mm.plugin.appbrand.task;

import android.app.Activity;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
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
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService1;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService2;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService3;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService4;
import com.tencent.mm.plugin.appbrand.loading.AppBrandProcessTriggerService0;
import com.tencent.mm.plugin.appbrand.loading.AppBrandProcessTriggerService1;
import com.tencent.mm.plugin.appbrand.loading.AppBrandProcessTriggerService2;
import com.tencent.mm.plugin.appbrand.loading.AppBrandProcessTriggerService3;
import com.tencent.mm.plugin.appbrand.loading.AppBrandProcessTriggerService4;
import com.tencent.mm.plugin.appbrand.loading.a.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.e.a;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.task.preload.d.a;
import com.tencent.mm.plugin.appbrand.task.preload.d.b;
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
import com.tencent.mm.plugin.appbrand.ui.z;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import junit.framework.Assert;

public class f
{
  private static final LinkedList<i> lwE;
  private static final LinkedList<i> lwF;
  public static final i lwG;
  private static final ConcurrentHashMap<String, String> lwH;
  private static final ConcurrentSkipListSet<AppBrandRemoteTaskController> lwI;
  
  static
  {
    AppMethodBeat.i(48471);
    if (!f.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      lwH = new ConcurrentHashMap();
      lwI = new ConcurrentSkipListSet(new Comparator() {});
      LinkedList localLinkedList = new LinkedList();
      lwE = localLinkedList;
      localLinkedList.add(new i(AppBrandUI.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class, AppBrandForegroundNotificationService.class, AppBrandProcessTriggerService0.class, AppBrandPreLoadingUI.class));
      lwE.add(new i(AppBrandUI1.class, AppBrandTaskPreloadReceiver1.class, AppBrandKeepAliveService1.class, AppBrandForegroundNotificationService1.class, AppBrandProcessTriggerService1.class, AppBrandPreLoadingUI1.class));
      lwE.add(new i(AppBrandUI2.class, AppBrandTaskPreloadReceiver2.class, AppBrandKeepAliveService2.class, AppBrandForegroundNotificationService2.class, AppBrandProcessTriggerService2.class, AppBrandPreLoadingUI2.class));
      lwE.add(new i(AppBrandUI3.class, AppBrandTaskPreloadReceiver3.class, AppBrandKeepAliveService3.class, AppBrandForegroundNotificationService3.class, AppBrandProcessTriggerService3.class, AppBrandPreLoadingUI3.class));
      lwE.add(new i(AppBrandUI4.class, AppBrandTaskPreloadReceiver4.class, AppBrandKeepAliveService4.class, AppBrandForegroundNotificationService4.class, AppBrandProcessTriggerService4.class, AppBrandPreLoadingUI4.class));
      lwG = new b();
      localLinkedList = new LinkedList();
      lwF = localLinkedList;
      localLinkedList.addAll(lwE);
      lwF.add(lwG);
      AppMethodBeat.o(48471);
      return;
    }
  }
  
  public static void MK(String paramString)
  {
    AppMethodBeat.i(48444);
    i locali = MO(paramString);
    if ((locali != null) && (locali.MV(paramString) != null)) {
      locali.MV(paramString).MI(paramString);
    }
    bP(paramString, -1);
    AppMethodBeat.o(48444);
  }
  
  public static void ML(String paramString)
  {
    AppMethodBeat.i(48450);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(48450);
      return;
    }
    paramString = MP(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(48450);
      return;
    }
    aq.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48435);
        this.lwJ.MX();
        AppMethodBeat.o(48435);
      }
    }, 500L);
    AppMethodBeat.o(48450);
  }
  
  public static Class MM(String paramString)
  {
    AppMethodBeat.i(48452);
    Iterator localIterator = bnG().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (locali.lwM.equals(paramString))
      {
        paramString = locali.lwQ;
        AppMethodBeat.o(48452);
        return paramString;
      }
    }
    AppMethodBeat.o(48452);
    return null;
  }
  
  public static Class MN(String paramString)
  {
    AppMethodBeat.i(48453);
    Iterator localIterator = bnG().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (locali.lwM.equals(paramString))
      {
        paramString = locali.lwR;
        AppMethodBeat.o(48453);
        return paramString;
      }
    }
    AppMethodBeat.o(48453);
    return null;
  }
  
  private static i MO(String paramString)
  {
    AppMethodBeat.i(48458);
    Iterator localIterator = bnG().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (locali.lwU.keySet().contains(paramString))
      {
        AppMethodBeat.o(48458);
        return locali;
      }
    }
    AppMethodBeat.o(48458);
    return null;
  }
  
  static i MP(String paramString)
  {
    AppMethodBeat.i(48459);
    Iterator localIterator = bnG().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (locali.lwM.equals(paramString))
      {
        AppMethodBeat.o(48459);
        return locali;
      }
    }
    Assert.assertTrue(true);
    AppMethodBeat.o(48459);
    return null;
  }
  
  public static boolean MQ(String paramString)
  {
    AppMethodBeat.i(205046);
    boolean bool = bS(paramString, -1);
    AppMethodBeat.o(205046);
    return bool;
  }
  
  public static Pair<String, Integer> MR(String paramString)
  {
    AppMethodBeat.i(160619);
    paramString = bR(paramString, -1);
    if (paramString == null)
    {
      AppMethodBeat.o(160619);
      return null;
    }
    paramString = Pair.create(paramString.mAppId, Integer.valueOf(paramString.mDebugType));
    AppMethodBeat.o(160619);
    return paramString;
  }
  
  static void MS(String arg0)
  {
    AppMethodBeat.i(48468);
    i locali = MO(???);
    if (locali != null)
    {
      locali.lwU.remove(???);
      locali.lwV.remove(???);
      if (locali.lwU.isEmpty()) {
        locali.lwW = e.lwz;
      }
      if (locali.lwU.keySet().isEmpty())
      {
        synchronized (lwF)
        {
          lwF.remove(locali);
          lwF.addFirst(locali);
        }
        synchronized (lwE)
        {
          if (lwE.contains(locali))
          {
            lwE.remove(locali);
            lwE.addFirst(locali);
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
  
  private static i a(List<i> paramList, e parame)
  {
    AppMethodBeat.i(48454);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      i locali = (i)paramList.next();
      if (locali.lwW == parame)
      {
        AppMethodBeat.o(48454);
        return locali;
      }
    }
    AppMethodBeat.o(48454);
    return null;
  }
  
  public static void a(e parame, d.a parama)
  {
    AppMethodBeat.i(48446);
    a(parame, d.a.b(parama));
    AppMethodBeat.o(48446);
  }
  
  static void a(e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(48449);
    if ((!com.tencent.mm.plugin.appbrand.appusage.i.aRy()) || (com.tencent.mm.plugin.appbrand.task.preload.d.bnR()) || (parame == e.lwz))
    {
      AppMethodBeat.o(48449);
      return;
    }
    int i = com.tencent.mm.plugin.appbrand.task.preload.d.a(d.b.j(parame));
    Object localObject = com.tencent.mm.plugin.appbrand.app.d.iJD;
    boolean bool = paramBoolean;
    if (com.tencent.mm.plugin.appbrand.app.d.Km().getBoolean("is_pre_load_downgrade_env", false)) {
      if (!com.tencent.mm.sdk.platformtools.h.DEBUG)
      {
        bool = paramBoolean;
        if (!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) {}
      }
      else
      {
        bool = false;
      }
    }
    if ((!bool) && (i == -1))
    {
      ad.w("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess %s, hit interval limit", new Object[] { parame });
      if (parame == e.lwx)
      {
        com.tencent.mm.plugin.report.service.h.vKh.dB(915, 22);
        AppMethodBeat.o(48449);
        return;
      }
      if (parame == e.lwy) {
        com.tencent.mm.plugin.report.service.h.vKh.dB(915, 23);
      }
      AppMethodBeat.o(48449);
      return;
    }
    if (bool) {
      i = 2;
    }
    switch (4.lwK[parame.ordinal()])
    {
    default: 
      ad.i("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess serviceType = [%s], preload level = [%d]", new Object[] { parame, Integer.valueOf(i) });
      localObject = g(parame);
      if (localObject != null)
      {
        ((i)localObject).i(parame);
        ((i)localObject).tY(i);
        if (i != 2) {
          com.tencent.mm.plugin.report.service.h.vKh.dB(915, 30);
        }
        switch (4.lwK[parame.ordinal()])
        {
        }
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(48449);
      return;
      com.tencent.mm.plugin.report.service.h.vKh.dB(1144, 0);
      break;
      com.tencent.mm.plugin.report.service.h.vKh.dB(1144, 1);
      break;
      com.tencent.mm.plugin.report.service.h.vKh.dB(1144, 3);
      AppMethodBeat.o(48449);
      return;
      com.tencent.mm.plugin.report.service.h.vKh.dB(1144, 4);
    }
  }
  
  static void a(i parami)
  {
    AppMethodBeat.i(48469);
    synchronized (lwF)
    {
      lwF.remove(parami);
      lwF.addLast(parami);
    }
    synchronized (lwE)
    {
      if (lwE.contains(parami))
      {
        lwE.remove(parami);
        lwE.addLast(parami);
      }
      AppMethodBeat.o(48469);
      return;
      parami = finally;
      AppMethodBeat.o(48469);
      throw parami;
    }
  }
  
  public static void a(d.a parama)
  {
    AppMethodBeat.i(48448);
    if (com.tencent.mm.plugin.appbrand.task.preload.d.bnR())
    {
      AppMethodBeat.o(48448);
      return;
    }
    if ((!d.a.b(parama)) && (com.tencent.mm.plugin.appbrand.task.preload.d.a(d.b.lxz) == -1)) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.AppBrandTaskManager", "preloadPluginUIProcess, hitLimit[%b], scene[%s]", new Object[] { Boolean.valueOf(bool), parama.name() });
      if (!bool)
      {
        com.tencent.mm.plugin.report.service.h.vKh.dB(1144, 2);
        lwG.MX();
      }
      AppMethodBeat.o(48448);
      return;
    }
  }
  
  public static void a(String paramString, AppBrandRemoteTaskController paramAppBrandRemoteTaskController)
  {
    AppMethodBeat.i(48439);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(48439);
      return;
    }
    lwH.remove(paramString);
    if (paramAppBrandRemoteTaskController != null) {
      lwI.remove(paramAppBrandRemoteTaskController);
    }
    AppMethodBeat.o(48439);
  }
  
  public static void a(String paramString1, String paramString2, AppBrandRemoteTaskController paramAppBrandRemoteTaskController)
  {
    AppMethodBeat.i(48438);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(48438);
      return;
    }
    lwH.put(paramString1, paramString2);
    if (paramAppBrandRemoteTaskController != null) {
      lwI.add(paramAppBrandRemoteTaskController);
    }
    AppMethodBeat.o(48438);
  }
  
  private static void bP(String paramString, int paramInt)
  {
    AppMethodBeat.i(48440);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(48440);
      return;
    }
    Object localObject = lwI.iterator();
    LinkedList localLinkedList = new LinkedList();
    while (((Iterator)localObject).hasNext())
    {
      AppBrandRemoteTaskController localAppBrandRemoteTaskController = (AppBrandRemoteTaskController)((Iterator)localObject).next();
      if ((paramString.equals(localAppBrandRemoteTaskController.mAppId)) && ((paramInt == localAppBrandRemoteTaskController.mDebugType) || (paramInt < 0)))
      {
        localAppBrandRemoteTaskController.MI(paramString);
        localLinkedList.add(localAppBrandRemoteTaskController);
      }
    }
    paramString = localLinkedList.iterator();
    while (paramString.hasNext())
    {
      localObject = (AppBrandRemoteTaskController)paramString.next();
      lwI.remove(localObject);
    }
    AppMethodBeat.o(48440);
  }
  
  public static void bQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(48442);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(48442);
      return;
    }
    i locali = MO(paramString);
    if (locali == null)
    {
      bP(paramString, paramInt);
      AppMethodBeat.o(48442);
      return;
    }
    if ((locali.MU(paramString).intValue() == paramInt) && (locali.MV(paramString) != null)) {
      locali.MV(paramString).MI(paramString);
    }
    AppMethodBeat.o(48442);
  }
  
  private static AppBrandRemoteTaskController bR(String paramString, final int paramInt)
  {
    AppMethodBeat.i(48461);
    paramString = (AppBrandRemoteTaskController)new android.arch.a.c.a() {}.apply(null);
    if ((paramString != null) && (paramString.bnB()))
    {
      AppMethodBeat.o(48461);
      return paramString;
    }
    AppMethodBeat.o(48461);
    return null;
  }
  
  public static boolean bS(String paramString, int paramInt)
  {
    AppMethodBeat.i(48462);
    if (bR(paramString, paramInt) != null)
    {
      AppMethodBeat.o(48462);
      return true;
    }
    AppMethodBeat.o(48462);
    return false;
  }
  
  public static String bT(String paramString, int paramInt)
  {
    AppMethodBeat.i(48464);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(48464);
      return null;
    }
    try
    {
      paramString = bR(paramString, paramInt);
      if (paramString != null)
      {
        paramString = paramString.lwf;
        AppMethodBeat.o(48464);
        return paramString;
      }
    }
    catch (NullPointerException paramString)
    {
      if (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED)
      {
        AppMethodBeat.o(48464);
        throw paramString;
      }
      ad.printErrStackTrace("MicroMsg.AppBrandTaskManager", paramString, "[NOT CRASH]getAliveInstanceId", new Object[0]);
      AppMethodBeat.o(48464);
    }
    return null;
  }
  
  public static void bnE()
  {
    AppMethodBeat.i(48447);
    a(d.a.lxp);
    AppMethodBeat.o(48447);
  }
  
  public static int[] bnF()
  {
    AppMethodBeat.i(48465);
    Object localObject = bnG();
    int[] arrayOfInt = new int[((LinkedList)localObject).size()];
    localObject = ((LinkedList)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      arrayOfInt[i] = ((i)((Iterator)localObject).next()).lvY;
      i += 1;
    }
    AppMethodBeat.o(48465);
    return arrayOfInt;
  }
  
  private static LinkedList<i> bnG()
  {
    AppMethodBeat.i(48466);
    synchronized (lwF)
    {
      LinkedList localLinkedList2 = new LinkedList(lwF);
      AppMethodBeat.o(48466);
      return localLinkedList2;
    }
  }
  
  static LinkedList<i> bnH()
  {
    AppMethodBeat.i(48467);
    synchronized (lwF)
    {
      LinkedList localLinkedList2 = new LinkedList(lwF);
      AppMethodBeat.o(48467);
      return localLinkedList2;
    }
  }
  
  public static int d(Context paramContext, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(48441);
    if ((!TextUtils.isEmpty(paramAppBrandStatObject.dbt)) && (paramAppBrandStatObject.dbt.length() >= 1024))
    {
      ad.i("MicroMsg.AppBrandTaskManager", "startApp, appId[%s], scene[%d], preScene[%d], sceneNote too long, strip it", new Object[] { paramAppBrandInitConfigWC.appId, Integer.valueOf(paramAppBrandStatObject.scene), Integer.valueOf(paramAppBrandStatObject.dzS) });
      paramAppBrandStatObject.dbt = paramAppBrandStatObject.dbt.substring(0, 1024);
    }
    if ((!TextUtils.isEmpty(paramAppBrandStatObject.dzT)) && (paramAppBrandStatObject.dzT.length() >= 1024))
    {
      ad.i("MicroMsg.AppBrandTaskManager", "startApp, appId[%s], scene[%d], preScene[%d], preSceneNote too long, strip it", new Object[] { paramAppBrandInitConfigWC.appId, Integer.valueOf(paramAppBrandStatObject.scene), Integer.valueOf(paramAppBrandStatObject.dzS) });
      paramAppBrandStatObject.dzT = paramAppBrandStatObject.dzT.substring(0, 1024);
    }
    Object localObject5 = com.tencent.mm.plugin.appbrand.report.model.e.lqO;
    Object localObject3 = paramAppBrandInitConfigWC.appId;
    int j = paramAppBrandInitConfigWC.aAS;
    boolean bool = bS((String)localObject3, -1);
    Object localObject1 = (e.a)((com.tencent.mm.plugin.appbrand.report.model.e)localObject5).lqP.get(localObject3);
    long l;
    label261:
    int i;
    if (localObject1 == null)
    {
      localObject1 = new e.a((byte)0);
      ((e.a)localObject1).lqS = 1L;
      ((com.tencent.mm.plugin.appbrand.report.model.e)localObject5).lqP.put(localObject3, localObject1);
      if (((e.a)localObject1).lqR <= 0L) {
        break label1317;
      }
      l = bt.eGO() - ((e.a)localObject1).lqR;
      localObject5 = com.tencent.mm.plugin.report.service.h.vKh;
      if (!bool) {
        break label1323;
      }
      i = 1;
      label273:
      ((com.tencent.mm.plugin.report.service.h)localObject5).f(16064, new Object[] { Integer.valueOf(1), localObject3, Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(((e.a)localObject1).lqS), Long.valueOf(l) });
      com.tencent.mm.plugin.appbrand.keylogger.c.a(paramAppBrandInitConfigWC.appId, KSProcessWeAppLaunch.stepContainerUILaunch);
      if ((!paramAppBrandInitConfigWC.jdl) && (!"wxfe02ecfe70800f46".equalsIgnoreCase(paramAppBrandInitConfigWC.appId)) && (paramAppBrandInitConfigWC.launchMode != 1)) {
        break label1339;
      }
      localObject1 = lwG;
      ((i)localObject1).i(e.lwx);
      localObject3 = lwG.lwO;
      if (!lwH.containsKey(paramAppBrandInitConfigWC.appId)) {
        break label1328;
      }
      localObject5 = (String)lwH.get(paramAppBrandInitConfigWC.appId);
      if (TextUtils.isEmpty((CharSequence)localObject5)) {
        break label1328;
      }
      bool = ((String)localObject5).equals(localObject3);
      label436:
      if (!bool) {
        break label1334;
      }
      a(paramAppBrandInitConfigWC.appId, bR(paramAppBrandInitConfigWC.appId, paramAppBrandInitConfigWC.iOP));
      label459:
      i = 2;
      label461:
      ((i)localObject1).a(paramAppBrandInitConfigWC.appId, paramAppBrandInitConfigWC.iOP, null);
      if (paramContext != null) {
        break label1698;
      }
      paramContext = aj.getContext();
      label483:
      localObject5 = new Intent(paramContext, ((i)localObject1).lwN);
      ((Intent)localObject5).putExtra("key_appbrand_init_config", paramAppBrandInitConfigWC);
      ((Intent)localObject5).putExtra("key_appbrand_stat_object", paramAppBrandStatObject);
      ((Intent)localObject5).putExtra("key_app_id", paramAppBrandInitConfigWC.appId);
      if ((!com.tencent.mm.plugin.appbrand.utils.a.aI(((i)localObject1).lwN)) && ((paramContext instanceof Activity))) {
        break label1528;
      }
      j = 268435456;
      ((Intent)localObject5).addFlags(j);
      if (!(paramContext instanceof Activity)) {}
    }
    for (;;)
    {
      try
      {
        localObject3 = bt.aA(paramContext, ((Activity)paramContext).getTaskId());
        if ((localObject3 != null) && (((ActivityManager.RunningTaskInfo)localObject3).baseActivity != null) && (bt.nullAsNil(((ActivityManager.RunningTaskInfo)localObject3).baseActivity.getClassName()).equals(((i)localObject1).lwM)))
        {
          ((Intent)localObject5).putExtra("key_appbrand_bring_ui_to_front_from_task_Base_by_task_top_ui", true);
          ((Intent)localObject5).addFlags(603979776);
        }
        ((Intent)localObject5).putExtra("key_from_activity_requested_orientation", ((Activity)paramContext).getRequestedOrientation());
        paramAppBrandInitConfigWC.jdm = bt.eGO();
        paramAppBrandInitConfigWC.jds = aj.aFw(((i)localObject1).lwO);
        ((Intent)localObject5).putExtra("key_launch_app_client_version", com.tencent.mm.sdk.platformtools.h.ETr);
        j.bnN();
        locala = new com.tencent.mm.plugin.appbrand.loading.a(paramContext, (Intent)localObject5, paramAppBrandInitConfigWC, (i)localObject1, paramAppBrandStatObject);
        try
        {
          if (!locala.bhr()) {
            break label1586;
          }
          ad.i("MicroMsg.AppBrandTaskManager", "startTargetActivity: needPreLoadingUi");
          locala.kON = com.tencent.mm.plugin.appbrand.loading.c.kPa.a(new com.tencent.mm.plugin.appbrand.loading.e(locala.ctx, locala.kOP, locala.iJK, locala.iJL));
          Class localClass = locala.kOQ.lwS;
          localObject1 = new StringBuilder("onNeedPreLoadingUI: triggerService = ");
          k.g(localClass, "processTriggerServiceClass");
          ad.i("MicroMsg.AppBrand.AppBrandPreLoadingLogic", localClass.getCanonicalName());
          String str = localClass.getCanonicalName();
          if (str == null) {
            k.fvU();
          }
          localObject1 = locala.kOP.getComponent();
          if (localObject1 == null) {
            break label1701;
          }
          localObject3 = ((ComponentName)localObject1).getClassName();
          localObject1 = localObject3;
          if (localObject3 == null) {
            break label1701;
          }
          localObject3 = new Intent(locala.ctx, locala.kOQ.lwT);
          ad.i("MicroMsg.AppBrand.AppBrandPreLoadingLogic", "startPreLoadingActivity, ctx = " + locala.ctx);
          ((Intent)localObject3).putExtra("MicroMsg.AppBrandPreLoadingLogic.name", locala.iJK.dfM);
          ((Intent)localObject3).putExtra("MicroMsg.AppBrandPreLoadingLogic.icon", locala.iJK.iconUrl);
          ((Intent)localObject3).putExtra("MicroMsg.AppBrandPreLoadingLogic.serviceName", str);
          ((Intent)localObject3).putExtra("MicroMsg.AppBrandPreLoadingLogic.intentKey", locala.kON);
          ((Intent)localObject3).putExtra("MicroMsg.AppBrandPreLoadingLogic.targetActivityName", (String)localObject1);
          ((Intent)localObject3).putExtra("MicroMsg.AppBrandPreLoadingLogic.splashFlavor", locala.bhq());
          ((Intent)localObject3).putExtra("MicroMsg.AppBrandPreLoadingLogic.appId", locala.iJK.appId);
          ((Intent)localObject3).putExtra("MicroMsg.AppBrandPreLoadingLogic.scene", locala.iJL.scene);
          ((Intent)localObject3).putExtra("MicroMsg.AppBrandPreLoadingLogic.versionInfo", (Parcelable)locala.iJK.cfl);
          ((Intent)localObject3).addFlags(268435456);
          localObject1 = locala.ctx;
          localObject3 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject3);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject3).adn(), "com/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingLogic", "startPreLoadingActivity", "(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject3).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingLogic", "startPreLoadingActivity", "(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          if ((locala.ctx instanceof Activity)) {
            localObject1 = (Activity)locala.ctx;
          }
          switch (locala.bhq())
          {
          case 4: 
            com.tencent.mm.ad.c.b("MicroMsg.AppBrand.AppBrandPreLoadingLogic:startService:".concat(String.valueOf(str)), (d.g.a.a)new a.c(locala, str));
            locala.iJK.jdr = localClass.getCanonicalName();
          }
        }
        catch (Throwable localThrowable1)
        {
          Object localObject4;
          ad.printErrStackTrace("MicroMsg.AppBrandTaskManager", localThrowable1, "onNeedPreLoadingUI", new Object[0]);
          paramAppBrandInitConfigWC.jdr = "";
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject5);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/appbrand/task/AppBrandTaskManager", "startTargetActivity", "(Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingLogic;Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/appbrand/task/AppBrandTaskManager", "startTargetActivity", "(Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingLogic;Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          if (!(paramContext instanceof Activity)) {
            continue;
          }
          ((z)com.tencent.luggage.a.e.K(z.class)).a((Activity)paramContext, paramAppBrandInitConfigWC);
          continue;
        }
        if (i == 1) {
          MK(paramAppBrandInitConfigWC.appId);
        }
        ad.i("MicroMsg.AppBrandTaskManager", "startApp appId[%s] type[%d] scene[%d] strategy[%d] targetProcessExists[%b]", new Object[] { paramAppBrandInitConfigWC.appId, Integer.valueOf(paramAppBrandInitConfigWC.iOP), Integer.valueOf(paramAppBrandStatObject.scene), Integer.valueOf(i), Boolean.valueOf(paramAppBrandInitConfigWC.jds) });
        AppMethodBeat.o(48441);
        return i;
        ((e.a)localObject1).lqS += 1L;
        break;
        label1317:
        l = 0L;
        break label261;
        label1323:
        i = 0;
        break label273;
        label1328:
        bool = false;
        break label436;
        label1334:
        i = 1;
        break label461;
        label1339:
        localObject3 = MO(paramAppBrandInitConfigWC.appId);
        if (localObject3 != null)
        {
          localObject1 = localObject3;
          if (localObject3 != lwG) {
            break label459;
          }
        }
        if (lwH.containsKey(paramAppBrandInitConfigWC.appId))
        {
          localObject3 = (String)lwH.get(paramAppBrandInitConfigWC.appId);
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject5 = lwE.iterator();
            if (((Iterator)localObject5).hasNext())
            {
              localObject1 = (i)((Iterator)localObject5).next();
              if (!((String)localObject3).equals(((i)localObject1).lwO)) {
                continue;
              }
              if (localObject1 == null) {
                continue;
              }
              i = 2;
              a((i)localObject1);
              break label461;
            }
          }
        }
        localObject1 = null;
        continue;
        if (paramAppBrandInitConfigWC.CZ())
        {
          localObject1 = e.lwy;
          localObject3 = h((e)localObject1);
          if (paramAppBrandInitConfigWC.CZ())
          {
            localObject1 = e.lwy;
            ((i)localObject3).i((e)localObject1);
            i = 1;
            localObject1 = localObject3;
          }
        }
        else
        {
          localObject1 = e.lwx;
          continue;
        }
        localObject1 = e.lwx;
        continue;
        label1528:
        j = 0;
      }
      catch (Throwable localThrowable2)
      {
        com.tencent.mm.plugin.appbrand.loading.a locala;
        localObject4 = null;
        continue;
        ((z)com.tencent.luggage.a.e.K(z.class)).a((Activity)localObject1, (AppBrandInitConfig)locala.iJK);
        continue;
      }
      label1586:
      break label483;
      label1698:
      label1701:
      Object localObject2 = "";
    }
  }
  
  static i dS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(48460);
    Iterator localIterator = bnG().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if ((locali.lwU.keySet().contains(paramString1)) && (locali.lwM.equals(paramString2)))
      {
        AppMethodBeat.o(48460);
        return locali;
      }
    }
    AppMethodBeat.o(48460);
    return null;
  }
  
  public static void e(e parame)
  {
    AppMethodBeat.i(48445);
    a(parame, d.a.lxp);
    AppMethodBeat.o(48445);
  }
  
  public static int f(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(196130);
    int i = d(null, paramAppBrandInitConfigWC, paramAppBrandStatObject);
    AppMethodBeat.o(196130);
    return i;
  }
  
  private static boolean f(e parame)
  {
    AppMethodBeat.i(48455);
    Iterator localIterator = lwE.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (((i)localIterator.next()).lwW != parame) {
        break label129;
      }
      i += 1;
    }
    label129:
    for (;;)
    {
      break;
      if (i > parame.lwA)
      {
        parame = new IllegalStateException(bt.u("TaskManager count the serviceType [%s] in TASK_LIST, count = [%d], but max limit = [%d]", new Object[] { parame.name(), Integer.valueOf(i), Integer.valueOf(parame.lwA) }));
        AppMethodBeat.o(48455);
        throw parame;
      }
      if (i == parame.lwA)
      {
        AppMethodBeat.o(48455);
        return true;
      }
      AppMethodBeat.o(48455);
      return false;
    }
  }
  
  private static i g(e parame)
  {
    AppMethodBeat.i(48456);
    synchronized (lwE)
    {
      if (f(parame))
      {
        ad.i("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess serviceType = [%s] reachedMaxLimit", new Object[] { parame });
        AppMethodBeat.o(48456);
        return null;
      }
      Object localObject = lwE.iterator();
      while (((Iterator)localObject).hasNext())
      {
        locali = (i)((Iterator)localObject).next();
        if ((locali.lwU.isEmpty()) && (locali.lwW == parame))
        {
          ad.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup found empty task[%s], which can be used as [%s]", new Object[] { locali.lwO, parame });
          AppMethodBeat.o(48456);
          return locali;
        }
      }
      i locali = a(lwE, e.lwz);
      if (locali == null)
      {
        localObject = "null";
        ad.i("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess serviceType = [%s] not reached max limit , got ui task = [%s]", new Object[] { parame, localObject });
        AppMethodBeat.o(48456);
        return locali;
      }
      localObject = locali.lwM;
    }
  }
  
  private static i h(e parame)
  {
    AppMethodBeat.i(48457);
    for (;;)
    {
      synchronized (lwE)
      {
        Iterator localIterator = lwE.iterator();
        if (localIterator.hasNext())
        {
          locali = (i)localIterator.next();
          if ((!locali.lwU.isEmpty()) || (locali.lwW != parame)) {
            continue;
          }
          ad.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup found empty task, which can be used as [%s]", new Object[] { parame });
          parame = locali;
          AppMethodBeat.o(48457);
          return parame;
        }
        if (f(parame))
        {
          ad.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup [%s] task reached maxLimit", new Object[] { parame });
          locali = a(lwE, parame);
          parame = locali;
          if ($assertionsDisabled) {
            continue;
          }
          parame = locali;
          if (locali != null) {
            continue;
          }
          parame = new AssertionError();
          AppMethodBeat.o(48457);
          throw parame;
        }
      }
      i locali = a(lwE, e.lwz);
      if (locali != null)
      {
        ad.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup found not used task, which can be used as [%s]", new Object[] { parame });
        parame = locali;
      }
      else
      {
        ad.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup all full for [%s]", new Object[] { parame });
        parame = (i)lwE.getFirst();
      }
    }
  }
  
  public static void onNetworkChange()
  {
    AppMethodBeat.i(48451);
    Iterator localIterator1 = bnG().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((i)localIterator1.next()).lwV.values().iterator();
      while (localIterator2.hasNext())
      {
        AppBrandRemoteTaskController localAppBrandRemoteTaskController = (AppBrandRemoteTaskController)localIterator2.next();
        if (localAppBrandRemoteTaskController != null)
        {
          localAppBrandRemoteTaskController.lwa = AppBrandRemoteTaskController.a.lws;
          localAppBrandRemoteTaskController.aXw();
        }
      }
    }
    AppMethodBeat.o(48451);
  }
  
  public static void tX(int paramInt)
  {
    AppMethodBeat.i(48443);
    Object localObject2;
    Object localObject3;
    if (2 == paramInt)
    {
      localObject1 = new HashMap();
      localObject2 = bnG().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (i)((Iterator)localObject2).next();
        if (!TextUtils.isEmpty(((i)localObject3).lwO)) {
          if (((i)localObject3).lwU.isEmpty())
          {
            localObject3 = ((i)localObject3).lwO;
            Boolean localBoolean = Boolean.TRUE;
            if (Build.VERSION.SDK_INT >= 24) {
              ((HashMap)localObject1).putIfAbsent(localObject3, localBoolean);
            } else if (((HashMap)localObject1).get(localObject3) == null) {
              ((HashMap)localObject1).put(localObject3, localBoolean);
            }
          }
          else
          {
            ((HashMap)localObject1).put(((i)localObject3).lwO, Boolean.FALSE);
          }
        }
      }
      localObject1 = ((HashMap)localObject1).entrySet().iterator();
      label232:
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if ((((Map.Entry)localObject2).getValue() != null) && (((Boolean)((Map.Entry)localObject2).getValue()).booleanValue())) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label232;
          }
          localObject2 = (String)((Map.Entry)localObject2).getKey();
          ad.i("MicroMsg.AppBrandTaskManager", "killAll SILENT_IF_INACTIVE kill process(%s)", new Object[] { localObject2 });
          com.tencent.mm.modelappbrand.b.uU((String)localObject2);
          com.tencent.mm.bw.a.bS(aj.getContext(), (String)localObject2);
          break;
        }
      }
      ad.i("MicroMsg.AppBrandTaskManager", "killAll SILENT_IF_INACTIVE tryPreloadNextTaskProcess(both waservice and wagame)");
      a(e.lwx, true);
      a(e.lwy, true);
      AppMethodBeat.o(48443);
      return;
    }
    Object localObject1 = bnG().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((i)((Iterator)localObject1).next()).lwV.values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (AppBrandRemoteTaskController)((Iterator)localObject2).next();
        if (localObject3 != null) {
          ((AppBrandRemoteTaskController)localObject3).tW(paramInt);
        }
      }
    }
    localObject1 = lwI.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (AppBrandRemoteTaskController)((Iterator)localObject1).next();
      if (localObject2 != null) {
        ((AppBrandRemoteTaskController)localObject2).tW(paramInt);
      }
    }
    if (3 == paramInt) {
      lwI.clear();
    }
    AppMethodBeat.o(48443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.f
 * JD-Core Version:    0.7.0.1
 */