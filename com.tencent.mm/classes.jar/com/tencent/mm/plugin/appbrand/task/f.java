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
import com.tencent.mm.plugin.appbrand.ui.y;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
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
  public static final i lYA;
  private static final ConcurrentHashMap<String, String> lYB;
  private static final ConcurrentSkipListSet<AppBrandRemoteTaskController> lYC;
  private static final LinkedList<i> lYy;
  private static final LinkedList<i> lYz;
  
  static
  {
    AppMethodBeat.i(48471);
    if (!f.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      lYB = new ConcurrentHashMap();
      lYC = new ConcurrentSkipListSet(new Comparator() {});
      LinkedList localLinkedList = new LinkedList();
      lYy = localLinkedList;
      localLinkedList.add(new i(AppBrandUI.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class, AppBrandForegroundNotificationService.class, AppBrandProcessTriggerService0.class, AppBrandPreLoadingUI.class));
      lYy.add(new i(AppBrandUI1.class, AppBrandTaskPreloadReceiver1.class, AppBrandKeepAliveService1.class, AppBrandForegroundNotificationService1.class, AppBrandProcessTriggerService1.class, AppBrandPreLoadingUI1.class));
      lYy.add(new i(AppBrandUI2.class, AppBrandTaskPreloadReceiver2.class, AppBrandKeepAliveService2.class, AppBrandForegroundNotificationService2.class, AppBrandProcessTriggerService2.class, AppBrandPreLoadingUI2.class));
      lYy.add(new i(AppBrandUI3.class, AppBrandTaskPreloadReceiver3.class, AppBrandKeepAliveService3.class, AppBrandForegroundNotificationService3.class, AppBrandProcessTriggerService3.class, AppBrandPreLoadingUI3.class));
      lYy.add(new i(AppBrandUI4.class, AppBrandTaskPreloadReceiver4.class, AppBrandKeepAliveService4.class, AppBrandForegroundNotificationService4.class, AppBrandProcessTriggerService4.class, AppBrandPreLoadingUI4.class));
      lYA = new b();
      localLinkedList = new LinkedList();
      lYz = localLinkedList;
      localLinkedList.addAll(lYy);
      lYz.add(lYA);
      AppMethodBeat.o(48471);
      return;
    }
  }
  
  public static void QT(String paramString)
  {
    AppMethodBeat.i(48444);
    i locali = QX(paramString);
    if ((locali != null) && (locali.Re(paramString) != null)) {
      locali.Re(paramString).QR(paramString);
    }
    bU(paramString, -1);
    AppMethodBeat.o(48444);
  }
  
  public static void QU(String paramString)
  {
    AppMethodBeat.i(48450);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(48450);
      return;
    }
    paramString = QY(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(48450);
      return;
    }
    ap.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48435);
        this.lYD.MV();
        AppMethodBeat.o(48435);
      }
    }, 500L);
    AppMethodBeat.o(48450);
  }
  
  public static Class QV(String paramString)
  {
    AppMethodBeat.i(48452);
    Iterator localIterator = buC().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (locali.lYG.equals(paramString))
      {
        paramString = locali.lYK;
        AppMethodBeat.o(48452);
        return paramString;
      }
    }
    AppMethodBeat.o(48452);
    return null;
  }
  
  public static Class QW(String paramString)
  {
    AppMethodBeat.i(48453);
    Iterator localIterator = buC().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (locali.lYG.equals(paramString))
      {
        paramString = locali.lYL;
        AppMethodBeat.o(48453);
        return paramString;
      }
    }
    AppMethodBeat.o(48453);
    return null;
  }
  
  private static i QX(String paramString)
  {
    AppMethodBeat.i(48458);
    Iterator localIterator = buC().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (locali.lYO.keySet().contains(paramString))
      {
        AppMethodBeat.o(48458);
        return locali;
      }
    }
    AppMethodBeat.o(48458);
    return null;
  }
  
  static i QY(String paramString)
  {
    AppMethodBeat.i(48459);
    Iterator localIterator = buC().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (locali.lYG.equals(paramString))
      {
        AppMethodBeat.o(48459);
        return locali;
      }
    }
    Assert.assertTrue(true);
    AppMethodBeat.o(48459);
    return null;
  }
  
  public static boolean QZ(String paramString)
  {
    AppMethodBeat.i(210161);
    boolean bool = bX(paramString, -1);
    AppMethodBeat.o(210161);
    return bool;
  }
  
  public static Pair<String, Integer> Ra(String paramString)
  {
    AppMethodBeat.i(160619);
    paramString = bW(paramString, -1);
    if (paramString == null)
    {
      AppMethodBeat.o(160619);
      return null;
    }
    paramString = Pair.create(paramString.mAppId, Integer.valueOf(paramString.mDebugType));
    AppMethodBeat.o(160619);
    return paramString;
  }
  
  static void Rb(String arg0)
  {
    AppMethodBeat.i(48468);
    i locali = QX(???);
    if (locali != null)
    {
      locali.lYO.remove(???);
      locali.lYP.remove(???);
      if (locali.lYO.isEmpty()) {
        locali.lYQ = e.lYt;
      }
      if (locali.lYO.keySet().isEmpty())
      {
        synchronized (lYz)
        {
          lYz.remove(locali);
          lYz.addFirst(locali);
        }
        synchronized (lYy)
        {
          if (lYy.contains(locali))
          {
            lYy.remove(locali);
            lYy.addFirst(locali);
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
      if (locali.lYQ == parame)
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
    if ((!com.tencent.mm.plugin.appbrand.appusage.i.aYt()) || (com.tencent.mm.plugin.appbrand.task.preload.d.buN()) || (parame == e.lYt))
    {
      AppMethodBeat.o(48449);
      return;
    }
    int i = com.tencent.mm.plugin.appbrand.task.preload.d.a(d.b.j(parame));
    Object localObject = com.tencent.mm.plugin.appbrand.app.d.jjJ;
    boolean bool = paramBoolean;
    if (com.tencent.mm.plugin.appbrand.app.d.JW().getBoolean("is_pre_load_downgrade_env", false)) {
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
      ac.w("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess %s, hit interval limit", new Object[] { parame });
      if (parame == e.lYr)
      {
        com.tencent.mm.plugin.report.service.h.wUl.dB(915, 22);
        AppMethodBeat.o(48449);
        return;
      }
      if (parame == e.lYs) {
        com.tencent.mm.plugin.report.service.h.wUl.dB(915, 23);
      }
      AppMethodBeat.o(48449);
      return;
    }
    if (bool) {
      i = 2;
    }
    switch (4.lYE[parame.ordinal()])
    {
    default: 
      ac.i("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess serviceType = [%s], preload level = [%d]", new Object[] { parame, Integer.valueOf(i) });
      localObject = g(parame);
      if (localObject != null)
      {
        ((i)localObject).i(parame);
        ((i)localObject).uQ(i);
        if (i != 2) {
          com.tencent.mm.plugin.report.service.h.wUl.dB(915, 30);
        }
        switch (4.lYE[parame.ordinal()])
        {
        }
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(48449);
      return;
      com.tencent.mm.plugin.report.service.h.wUl.dB(1144, 0);
      break;
      com.tencent.mm.plugin.report.service.h.wUl.dB(1144, 1);
      break;
      com.tencent.mm.plugin.report.service.h.wUl.dB(1144, 3);
      AppMethodBeat.o(48449);
      return;
      com.tencent.mm.plugin.report.service.h.wUl.dB(1144, 4);
    }
  }
  
  static void a(i parami)
  {
    AppMethodBeat.i(48469);
    synchronized (lYz)
    {
      lYz.remove(parami);
      lYz.addLast(parami);
    }
    synchronized (lYy)
    {
      if (lYy.contains(parami))
      {
        lYy.remove(parami);
        lYy.addLast(parami);
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
    if (com.tencent.mm.plugin.appbrand.task.preload.d.buN())
    {
      AppMethodBeat.o(48448);
      return;
    }
    if ((!d.a.b(parama)) && (com.tencent.mm.plugin.appbrand.task.preload.d.a(d.b.lZt) == -1)) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.AppBrandTaskManager", "preloadPluginUIProcess, hitLimit[%b], scene[%s]", new Object[] { Boolean.valueOf(bool), parama.name() });
      if (!bool)
      {
        com.tencent.mm.plugin.report.service.h.wUl.dB(1144, 2);
        lYA.MV();
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
    lYB.remove(paramString);
    if (paramAppBrandRemoteTaskController != null) {
      lYC.remove(paramAppBrandRemoteTaskController);
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
    lYB.put(paramString1, paramString2);
    if (paramAppBrandRemoteTaskController != null) {
      lYC.add(paramAppBrandRemoteTaskController);
    }
    AppMethodBeat.o(48438);
  }
  
  private static void bU(String paramString, int paramInt)
  {
    AppMethodBeat.i(48440);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(48440);
      return;
    }
    Object localObject = lYC.iterator();
    LinkedList localLinkedList = new LinkedList();
    while (((Iterator)localObject).hasNext())
    {
      AppBrandRemoteTaskController localAppBrandRemoteTaskController = (AppBrandRemoteTaskController)((Iterator)localObject).next();
      if ((paramString.equals(localAppBrandRemoteTaskController.mAppId)) && ((paramInt == localAppBrandRemoteTaskController.mDebugType) || (paramInt < 0)))
      {
        localAppBrandRemoteTaskController.QR(paramString);
        localLinkedList.add(localAppBrandRemoteTaskController);
      }
    }
    paramString = localLinkedList.iterator();
    while (paramString.hasNext())
    {
      localObject = (AppBrandRemoteTaskController)paramString.next();
      lYC.remove(localObject);
    }
    AppMethodBeat.o(48440);
  }
  
  public static void bV(String paramString, int paramInt)
  {
    AppMethodBeat.i(48442);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(48442);
      return;
    }
    i locali = QX(paramString);
    if (locali == null)
    {
      bU(paramString, paramInt);
      AppMethodBeat.o(48442);
      return;
    }
    if ((locali.Rd(paramString).intValue() == paramInt) && (locali.Re(paramString) != null)) {
      locali.Re(paramString).QR(paramString);
    }
    AppMethodBeat.o(48442);
  }
  
  private static AppBrandRemoteTaskController bW(String paramString, final int paramInt)
  {
    AppMethodBeat.i(48461);
    paramString = (AppBrandRemoteTaskController)new android.arch.a.c.a() {}.apply(null);
    if ((paramString != null) && (paramString.bux()))
    {
      AppMethodBeat.o(48461);
      return paramString;
    }
    AppMethodBeat.o(48461);
    return null;
  }
  
  public static boolean bX(String paramString, int paramInt)
  {
    AppMethodBeat.i(48462);
    if (bW(paramString, paramInt) != null)
    {
      AppMethodBeat.o(48462);
      return true;
    }
    AppMethodBeat.o(48462);
    return false;
  }
  
  public static String bY(String paramString, int paramInt)
  {
    AppMethodBeat.i(48464);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(48464);
      return null;
    }
    try
    {
      paramString = bW(paramString, paramInt);
      if (paramString != null)
      {
        paramString = paramString.lXZ;
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
      ac.printErrStackTrace("MicroMsg.AppBrandTaskManager", paramString, "[NOT CRASH]getAliveInstanceId", new Object[0]);
      AppMethodBeat.o(48464);
    }
    return null;
  }
  
  public static void buA()
  {
    AppMethodBeat.i(48447);
    a(d.a.lZj);
    AppMethodBeat.o(48447);
  }
  
  public static int[] buB()
  {
    AppMethodBeat.i(48465);
    Object localObject = buC();
    int[] arrayOfInt = new int[((LinkedList)localObject).size()];
    localObject = ((LinkedList)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      arrayOfInt[i] = ((i)((Iterator)localObject).next()).lXS;
      i += 1;
    }
    AppMethodBeat.o(48465);
    return arrayOfInt;
  }
  
  private static LinkedList<i> buC()
  {
    AppMethodBeat.i(48466);
    synchronized (lYz)
    {
      LinkedList localLinkedList2 = new LinkedList(lYz);
      AppMethodBeat.o(48466);
      return localLinkedList2;
    }
  }
  
  static LinkedList<i> buD()
  {
    AppMethodBeat.i(48467);
    synchronized (lYz)
    {
      LinkedList localLinkedList2 = new LinkedList(lYz);
      AppMethodBeat.o(48467);
      return localLinkedList2;
    }
  }
  
  public static int d(Context paramContext, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(48441);
    if ((!TextUtils.isEmpty(paramAppBrandStatObject.cYP)) && (paramAppBrandStatObject.cYP.length() >= 1024))
    {
      ac.i("MicroMsg.AppBrandTaskManager", "startApp, appId[%s], scene[%d], preScene[%d], sceneNote too long, strip it", new Object[] { paramAppBrandInitConfigWC.appId, Integer.valueOf(paramAppBrandStatObject.scene), Integer.valueOf(paramAppBrandStatObject.dxE) });
      paramAppBrandStatObject.cYP = paramAppBrandStatObject.cYP.substring(0, 1024);
    }
    if ((!TextUtils.isEmpty(paramAppBrandStatObject.dxF)) && (paramAppBrandStatObject.dxF.length() >= 1024))
    {
      ac.i("MicroMsg.AppBrandTaskManager", "startApp, appId[%s], scene[%d], preScene[%d], preSceneNote too long, strip it", new Object[] { paramAppBrandInitConfigWC.appId, Integer.valueOf(paramAppBrandStatObject.scene), Integer.valueOf(paramAppBrandStatObject.dxE) });
      paramAppBrandStatObject.dxF = paramAppBrandStatObject.dxF.substring(0, 1024);
    }
    Object localObject5 = com.tencent.mm.plugin.appbrand.report.model.e.lSJ;
    Object localObject3 = paramAppBrandInitConfigWC.appId;
    int j = paramAppBrandInitConfigWC.aBM;
    boolean bool = bX((String)localObject3, -1);
    Object localObject1 = (e.a)((com.tencent.mm.plugin.appbrand.report.model.e)localObject5).lSK.get(localObject3);
    long l;
    label261:
    int i;
    if (localObject1 == null)
    {
      localObject1 = new e.a((byte)0);
      ((e.a)localObject1).lSN = 1L;
      ((com.tencent.mm.plugin.appbrand.report.model.e)localObject5).lSK.put(localObject3, localObject1);
      if (((e.a)localObject1).lSM <= 0L) {
        break label1317;
      }
      l = bs.eWj() - ((e.a)localObject1).lSM;
      localObject5 = com.tencent.mm.plugin.report.service.h.wUl;
      if (!bool) {
        break label1323;
      }
      i = 1;
      label273:
      ((com.tencent.mm.plugin.report.service.h)localObject5).f(16064, new Object[] { Integer.valueOf(1), localObject3, Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(((e.a)localObject1).lSN), Long.valueOf(l) });
      com.tencent.mm.plugin.appbrand.keylogger.c.a(paramAppBrandInitConfigWC.appId, KSProcessWeAppLaunch.stepContainerUILaunch);
      if ((!paramAppBrandInitConfigWC.jDy) && (!"wxfe02ecfe70800f46".equalsIgnoreCase(paramAppBrandInitConfigWC.appId)) && (paramAppBrandInitConfigWC.launchMode != 1)) {
        break label1339;
      }
      localObject1 = lYA;
      ((i)localObject1).i(e.lYr);
      localObject3 = lYA.lYI;
      if (!lYB.containsKey(paramAppBrandInitConfigWC.appId)) {
        break label1328;
      }
      localObject5 = (String)lYB.get(paramAppBrandInitConfigWC.appId);
      if (TextUtils.isEmpty((CharSequence)localObject5)) {
        break label1328;
      }
      bool = ((String)localObject5).equals(localObject3);
      label436:
      if (!bool) {
        break label1334;
      }
      a(paramAppBrandInitConfigWC.appId, bW(paramAppBrandInitConfigWC.appId, paramAppBrandInitConfigWC.joY));
      label459:
      i = 2;
      label461:
      ((i)localObject1).a(paramAppBrandInitConfigWC.appId, paramAppBrandInitConfigWC.joY, null);
      if (paramContext != null) {
        break label1698;
      }
      paramContext = ai.getContext();
      label483:
      localObject5 = new Intent(paramContext, ((i)localObject1).lYH);
      ((Intent)localObject5).putExtra("key_appbrand_init_config", paramAppBrandInitConfigWC);
      ((Intent)localObject5).putExtra("key_appbrand_stat_object", paramAppBrandStatObject);
      ((Intent)localObject5).putExtra("key_app_id", paramAppBrandInitConfigWC.appId);
      if ((!com.tencent.mm.plugin.appbrand.utils.a.aI(((i)localObject1).lYH)) && ((paramContext instanceof Activity))) {
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
        localObject3 = bs.aG(paramContext, ((Activity)paramContext).getTaskId());
        if ((localObject3 != null) && (((ActivityManager.RunningTaskInfo)localObject3).baseActivity != null) && (bs.nullAsNil(((ActivityManager.RunningTaskInfo)localObject3).baseActivity.getClassName()).equals(((i)localObject1).lYG)))
        {
          ((Intent)localObject5).putExtra("key_appbrand_bring_ui_to_front_from_task_Base_by_task_top_ui", true);
          ((Intent)localObject5).addFlags(603979776);
        }
        ((Intent)localObject5).putExtra("key_from_activity_requested_orientation", ((Activity)paramContext).getRequestedOrientation());
        paramAppBrandInitConfigWC.jDz = bs.eWj();
        paramAppBrandInitConfigWC.jDF = ai.aKN(((i)localObject1).lYI);
        ((Intent)localObject5).putExtra("key_launch_app_client_version", com.tencent.mm.sdk.platformtools.h.GqE);
        j.buJ();
        locala = new com.tencent.mm.plugin.appbrand.loading.a(paramContext, (Intent)localObject5, paramAppBrandInitConfigWC, (i)localObject1, paramAppBrandStatObject);
        try
        {
          if (!locala.bol()) {
            break label1586;
          }
          ac.i("MicroMsg.AppBrandTaskManager", "startTargetActivity: needPreLoadingUi");
          locala.lqm = com.tencent.mm.plugin.appbrand.loading.c.lqz.a(new com.tencent.mm.plugin.appbrand.loading.e(locala.ctx, locala.lqo, locala.jjQ, locala.jjR));
          Class localClass = locala.lqp.lYM;
          localObject1 = new StringBuilder("onNeedPreLoadingUI: triggerService = ");
          k.g(localClass, "processTriggerServiceClass");
          ac.i("MicroMsg.AppBrand.AppBrandPreLoadingLogic", localClass.getCanonicalName());
          String str = localClass.getCanonicalName();
          if (str == null) {
            k.fOy();
          }
          localObject1 = locala.lqo.getComponent();
          if (localObject1 == null) {
            break label1701;
          }
          localObject3 = ((ComponentName)localObject1).getClassName();
          localObject1 = localObject3;
          if (localObject3 == null) {
            break label1701;
          }
          localObject3 = new Intent(locala.ctx, locala.lqp.lYN);
          ac.i("MicroMsg.AppBrand.AppBrandPreLoadingLogic", "startPreLoadingActivity, ctx = " + locala.ctx);
          ((Intent)localObject3).putExtra("MicroMsg.AppBrandPreLoadingLogic.name", locala.jjQ.ddh);
          ((Intent)localObject3).putExtra("MicroMsg.AppBrandPreLoadingLogic.icon", locala.jjQ.iconUrl);
          ((Intent)localObject3).putExtra("MicroMsg.AppBrandPreLoadingLogic.serviceName", str);
          ((Intent)localObject3).putExtra("MicroMsg.AppBrandPreLoadingLogic.intentKey", locala.lqm);
          ((Intent)localObject3).putExtra("MicroMsg.AppBrandPreLoadingLogic.targetActivityName", (String)localObject1);
          ((Intent)localObject3).putExtra("MicroMsg.AppBrandPreLoadingLogic.splashFlavor", locala.bok());
          ((Intent)localObject3).putExtra("MicroMsg.AppBrandPreLoadingLogic.appId", locala.jjQ.appId);
          ((Intent)localObject3).putExtra("MicroMsg.AppBrandPreLoadingLogic.scene", locala.jjR.scene);
          ((Intent)localObject3).putExtra("MicroMsg.AppBrandPreLoadingLogic.versionInfo", (Parcelable)locala.jjQ.cch);
          ((Intent)localObject3).addFlags(268435456);
          localObject1 = locala.ctx;
          localObject3 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject3);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject3).aeD(), "com/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingLogic", "startPreLoadingActivity", "(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject3).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingLogic", "startPreLoadingActivity", "(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          if ((locala.ctx instanceof Activity)) {
            localObject1 = (Activity)locala.ctx;
          }
          switch (locala.bok())
          {
          case 4: 
            com.tencent.mm.ac.c.b("MicroMsg.AppBrand.AppBrandPreLoadingLogic:startService:".concat(String.valueOf(str)), (d.g.a.a)new a.c(locala, str));
            locala.jjQ.jDE = localClass.getCanonicalName();
          }
        }
        catch (Throwable localThrowable1)
        {
          Object localObject4;
          ac.printErrStackTrace("MicroMsg.AppBrandTaskManager", localThrowable1, "onNeedPreLoadingUI", new Object[0]);
          paramAppBrandInitConfigWC.jDE = "";
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject5);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/appbrand/task/AppBrandTaskManager", "startTargetActivity", "(Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingLogic;Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/appbrand/task/AppBrandTaskManager", "startTargetActivity", "(Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingLogic;Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          if (!(paramContext instanceof Activity)) {
            continue;
          }
          ((y)com.tencent.luggage.a.e.K(y.class)).a((Activity)paramContext, paramAppBrandInitConfigWC);
          continue;
        }
        if (i == 1) {
          QT(paramAppBrandInitConfigWC.appId);
        }
        ac.i("MicroMsg.AppBrandTaskManager", "startApp appId[%s] type[%d] scene[%d] strategy[%d] targetProcessExists[%b]", new Object[] { paramAppBrandInitConfigWC.appId, Integer.valueOf(paramAppBrandInitConfigWC.joY), Integer.valueOf(paramAppBrandStatObject.scene), Integer.valueOf(i), Boolean.valueOf(paramAppBrandInitConfigWC.jDF) });
        AppMethodBeat.o(48441);
        return i;
        ((e.a)localObject1).lSN += 1L;
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
        localObject3 = QX(paramAppBrandInitConfigWC.appId);
        if (localObject3 != null)
        {
          localObject1 = localObject3;
          if (localObject3 != lYA) {
            break label459;
          }
        }
        if (lYB.containsKey(paramAppBrandInitConfigWC.appId))
        {
          localObject3 = (String)lYB.get(paramAppBrandInitConfigWC.appId);
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject5 = lYy.iterator();
            if (((Iterator)localObject5).hasNext())
            {
              localObject1 = (i)((Iterator)localObject5).next();
              if (!((String)localObject3).equals(((i)localObject1).lYI)) {
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
        if (paramAppBrandInitConfigWC.CC())
        {
          localObject1 = e.lYs;
          localObject3 = h((e)localObject1);
          if (paramAppBrandInitConfigWC.CC())
          {
            localObject1 = e.lYs;
            ((i)localObject3).i((e)localObject1);
            i = 1;
            localObject1 = localObject3;
          }
        }
        else
        {
          localObject1 = e.lYr;
          continue;
        }
        localObject1 = e.lYr;
        continue;
        label1528:
        j = 0;
      }
      catch (Throwable localThrowable2)
      {
        com.tencent.mm.plugin.appbrand.loading.a locala;
        localObject4 = null;
        continue;
        ((y)com.tencent.luggage.a.e.K(y.class)).a((Activity)localObject1, (AppBrandInitConfig)locala.jjQ);
        continue;
      }
      label1586:
      break label483;
      label1698:
      label1701:
      Object localObject2 = "";
    }
  }
  
  public static void e(e parame)
  {
    AppMethodBeat.i(48445);
    a(parame, d.a.lZj);
    AppMethodBeat.o(48445);
  }
  
  static i ee(String paramString1, String paramString2)
  {
    AppMethodBeat.i(48460);
    Iterator localIterator = buC().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if ((locali.lYO.keySet().contains(paramString1)) && (locali.lYG.equals(paramString2)))
      {
        AppMethodBeat.o(48460);
        return locali;
      }
    }
    AppMethodBeat.o(48460);
    return null;
  }
  
  public static int f(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(186975);
    int i = d(null, paramAppBrandInitConfigWC, paramAppBrandStatObject);
    AppMethodBeat.o(186975);
    return i;
  }
  
  private static boolean f(e parame)
  {
    AppMethodBeat.i(48455);
    Iterator localIterator = lYy.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (((i)localIterator.next()).lYQ != parame) {
        break label129;
      }
      i += 1;
    }
    label129:
    for (;;)
    {
      break;
      if (i > parame.lYu)
      {
        parame = new IllegalStateException(bs.u("TaskManager count the serviceType [%s] in TASK_LIST, count = [%d], but max limit = [%d]", new Object[] { parame.name(), Integer.valueOf(i), Integer.valueOf(parame.lYu) }));
        AppMethodBeat.o(48455);
        throw parame;
      }
      if (i == parame.lYu)
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
    synchronized (lYy)
    {
      if (f(parame))
      {
        ac.i("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess serviceType = [%s] reachedMaxLimit", new Object[] { parame });
        AppMethodBeat.o(48456);
        return null;
      }
      Object localObject = lYy.iterator();
      while (((Iterator)localObject).hasNext())
      {
        locali = (i)((Iterator)localObject).next();
        if ((locali.lYO.isEmpty()) && (locali.lYQ == parame))
        {
          ac.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup found empty task[%s], which can be used as [%s]", new Object[] { locali.lYI, parame });
          AppMethodBeat.o(48456);
          return locali;
        }
      }
      i locali = a(lYy, e.lYt);
      if (locali == null)
      {
        localObject = "null";
        ac.i("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess serviceType = [%s] not reached max limit , got ui task = [%s]", new Object[] { parame, localObject });
        AppMethodBeat.o(48456);
        return locali;
      }
      localObject = locali.lYG;
    }
  }
  
  private static i h(e parame)
  {
    AppMethodBeat.i(48457);
    for (;;)
    {
      synchronized (lYy)
      {
        Iterator localIterator = lYy.iterator();
        if (localIterator.hasNext())
        {
          locali = (i)localIterator.next();
          if ((!locali.lYO.isEmpty()) || (locali.lYQ != parame)) {
            continue;
          }
          ac.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup found empty task, which can be used as [%s]", new Object[] { parame });
          parame = locali;
          AppMethodBeat.o(48457);
          return parame;
        }
        if (f(parame))
        {
          ac.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup [%s] task reached maxLimit", new Object[] { parame });
          locali = a(lYy, parame);
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
      i locali = a(lYy, e.lYt);
      if (locali != null)
      {
        ac.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup found not used task, which can be used as [%s]", new Object[] { parame });
        parame = locali;
      }
      else
      {
        ac.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup all full for [%s]", new Object[] { parame });
        parame = (i)lYy.getFirst();
      }
    }
  }
  
  public static void onNetworkChange()
  {
    AppMethodBeat.i(48451);
    Iterator localIterator1 = buC().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((i)localIterator1.next()).lYP.values().iterator();
      while (localIterator2.hasNext())
      {
        AppBrandRemoteTaskController localAppBrandRemoteTaskController = (AppBrandRemoteTaskController)localIterator2.next();
        if (localAppBrandRemoteTaskController != null)
        {
          localAppBrandRemoteTaskController.lXU = AppBrandRemoteTaskController.a.lYm;
          localAppBrandRemoteTaskController.bet();
        }
      }
    }
    AppMethodBeat.o(48451);
  }
  
  public static void uP(int paramInt)
  {
    AppMethodBeat.i(48443);
    Object localObject2;
    Object localObject3;
    if (2 == paramInt)
    {
      localObject1 = new HashMap();
      localObject2 = buC().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (i)((Iterator)localObject2).next();
        if (!TextUtils.isEmpty(((i)localObject3).lYI)) {
          if (((i)localObject3).lYO.isEmpty())
          {
            localObject3 = ((i)localObject3).lYI;
            Boolean localBoolean = Boolean.TRUE;
            if (Build.VERSION.SDK_INT >= 24) {
              ((HashMap)localObject1).putIfAbsent(localObject3, localBoolean);
            } else if (((HashMap)localObject1).get(localObject3) == null) {
              ((HashMap)localObject1).put(localObject3, localBoolean);
            }
          }
          else
          {
            ((HashMap)localObject1).put(((i)localObject3).lYI, Boolean.FALSE);
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
          ac.i("MicroMsg.AppBrandTaskManager", "killAll SILENT_IF_INACTIVE kill process(%s)", new Object[] { localObject2 });
          com.tencent.mm.modelappbrand.b.za((String)localObject2);
          com.tencent.mm.bv.a.bT(ai.getContext(), (String)localObject2);
          break;
        }
      }
      ac.i("MicroMsg.AppBrandTaskManager", "killAll SILENT_IF_INACTIVE tryPreloadNextTaskProcess(both waservice and wagame)");
      a(e.lYr, true);
      a(e.lYs, true);
      AppMethodBeat.o(48443);
      return;
    }
    Object localObject1 = buC().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((i)((Iterator)localObject1).next()).lYP.values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (AppBrandRemoteTaskController)((Iterator)localObject2).next();
        if (localObject3 != null) {
          ((AppBrandRemoteTaskController)localObject3).uO(paramInt);
        }
      }
    }
    localObject1 = lYC.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (AppBrandRemoteTaskController)((Iterator)localObject1).next();
      if (localObject2 != null) {
        ((AppBrandRemoteTaskController)localObject2).uO(paramInt);
      }
    }
    if (3 == paramInt) {
      lYC.clear();
    }
    AppMethodBeat.o(48443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.f
 * JD-Core Version:    0.7.0.1
 */