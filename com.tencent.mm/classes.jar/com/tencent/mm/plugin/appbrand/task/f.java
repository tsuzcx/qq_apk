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
import com.tencent.mm.plugin.appbrand.ui.aa;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
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
  private static final LinkedList<i> myn;
  private static final LinkedList<i> myo;
  public static final i myp;
  private static final ConcurrentHashMap<String, String> myq;
  private static final ConcurrentSkipListSet<AppBrandRemoteTaskController> myr;
  
  static
  {
    AppMethodBeat.i(48471);
    if (!f.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      myq = new ConcurrentHashMap();
      myr = new ConcurrentSkipListSet(new Comparator() {});
      LinkedList localLinkedList = new LinkedList();
      myn = localLinkedList;
      localLinkedList.add(new i(AppBrandUI.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class, AppBrandForegroundNotificationService.class, AppBrandProcessTriggerService0.class, AppBrandPreLoadingUI.class));
      myn.add(new i(AppBrandUI1.class, AppBrandTaskPreloadReceiver1.class, AppBrandKeepAliveService1.class, AppBrandForegroundNotificationService1.class, AppBrandProcessTriggerService1.class, AppBrandPreLoadingUI1.class));
      myn.add(new i(AppBrandUI2.class, AppBrandTaskPreloadReceiver2.class, AppBrandKeepAliveService2.class, AppBrandForegroundNotificationService2.class, AppBrandProcessTriggerService2.class, AppBrandPreLoadingUI2.class));
      myn.add(new i(AppBrandUI3.class, AppBrandTaskPreloadReceiver3.class, AppBrandKeepAliveService3.class, AppBrandForegroundNotificationService3.class, AppBrandProcessTriggerService3.class, AppBrandPreLoadingUI3.class));
      myn.add(new i(AppBrandUI4.class, AppBrandTaskPreloadReceiver4.class, AppBrandKeepAliveService4.class, AppBrandForegroundNotificationService4.class, AppBrandProcessTriggerService4.class, AppBrandPreLoadingUI4.class));
      myp = new b();
      localLinkedList = new LinkedList();
      myo = localLinkedList;
      localLinkedList.addAll(myn);
      myo.add(myp);
      AppMethodBeat.o(48471);
      return;
    }
  }
  
  public static void UA(String paramString)
  {
    AppMethodBeat.i(48444);
    Iterator localIterator = byG().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if ((locali != null) && (locali.UK(paramString) != null))
      {
        ad.i("MicroMsg.AppBrandTaskManager", "clearDuplicatedApp task:%s, appId:%s", new Object[] { locali.myw, paramString });
        locali.UK(paramString).Ux(paramString);
      }
    }
    bX(paramString, -1);
    AppMethodBeat.o(48444);
  }
  
  public static Class UB(String paramString)
  {
    AppMethodBeat.i(48452);
    Iterator localIterator = byG().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (locali.myw.equals(paramString))
      {
        paramString = locali.myA;
        AppMethodBeat.o(48452);
        return paramString;
      }
    }
    AppMethodBeat.o(48452);
    return null;
  }
  
  public static Class UC(String paramString)
  {
    AppMethodBeat.i(48453);
    Iterator localIterator = byG().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (locali.myw.equals(paramString))
      {
        paramString = locali.myB;
        AppMethodBeat.o(48453);
        return paramString;
      }
    }
    AppMethodBeat.o(48453);
    return null;
  }
  
  private static i UD(String paramString)
  {
    AppMethodBeat.i(48458);
    Iterator localIterator = byG().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (locali.myE.keySet().contains(paramString))
      {
        AppMethodBeat.o(48458);
        return locali;
      }
    }
    AppMethodBeat.o(48458);
    return null;
  }
  
  static i UE(String paramString)
  {
    AppMethodBeat.i(48459);
    Iterator localIterator = byG().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (locali.myw.equals(paramString))
      {
        AppMethodBeat.o(48459);
        return locali;
      }
    }
    Assert.assertTrue(true);
    AppMethodBeat.o(48459);
    return null;
  }
  
  public static boolean UF(String paramString)
  {
    AppMethodBeat.i(221311);
    boolean bool = ca(paramString, -1);
    AppMethodBeat.o(221311);
    return bool;
  }
  
  public static Pair<String, Integer> UG(String paramString)
  {
    AppMethodBeat.i(160619);
    paramString = bZ(paramString, -1);
    if (paramString == null)
    {
      AppMethodBeat.o(160619);
      return null;
    }
    paramString = Pair.create(paramString.mAppId, Integer.valueOf(paramString.mDebugType));
    AppMethodBeat.o(160619);
    return paramString;
  }
  
  static void UH(String arg0)
  {
    AppMethodBeat.i(48468);
    i locali = UD(???);
    if (locali != null)
    {
      locali.myE.remove(???);
      locali.myF.remove(???);
      if (locali.myE.isEmpty()) {
        locali.myG = e.myi;
      }
      if (locali.myE.keySet().isEmpty())
      {
        synchronized (myo)
        {
          myo.remove(locali);
          myo.addFirst(locali);
        }
        synchronized (myn)
        {
          if (myn.contains(locali))
          {
            myn.remove(locali);
            myn.addFirst(locali);
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
      if (locali.myG == parame)
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
    if ((!com.tencent.mm.plugin.appbrand.appusage.i.bbR()) || (com.tencent.mm.plugin.appbrand.task.preload.d.byR()) || (parame == e.myi))
    {
      AppMethodBeat.o(48449);
      return;
    }
    int i = com.tencent.mm.plugin.appbrand.task.preload.d.a(d.b.m(parame));
    Object localObject = com.tencent.mm.plugin.appbrand.app.d.jDy;
    boolean bool = paramBoolean;
    if (com.tencent.mm.plugin.appbrand.app.d.Lv().getBoolean("is_pre_load_downgrade_env", false)) {
      if (!com.tencent.mm.sdk.platformtools.i.DEBUG)
      {
        bool = paramBoolean;
        if (!com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) {}
      }
      else
      {
        bool = false;
      }
    }
    if ((!bool) && (i == -1))
    {
      ad.w("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess %s, hit interval limit", new Object[] { parame });
      if (parame == e.myg)
      {
        g.yhR.dD(915, 22);
        AppMethodBeat.o(48449);
        return;
      }
      if (parame == e.myh) {
        g.yhR.dD(915, 23);
      }
      AppMethodBeat.o(48449);
      return;
    }
    if (bool) {
      i = 2;
    }
    switch (f.4.myu[parame.ordinal()])
    {
    default: 
      ad.i("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess serviceType = [%s], preload level = [%d]", new Object[] { parame, Integer.valueOf(i) });
      localObject = i(parame);
      if (localObject != null)
      {
        ((i)localObject).l(parame);
        ((i)localObject).vv(i);
        if (i != 2) {
          g.yhR.dD(915, 30);
        }
        switch (f.4.myu[parame.ordinal()])
        {
        }
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(48449);
      return;
      g.yhR.dD(1144, 0);
      break;
      g.yhR.dD(1144, 1);
      break;
      g.yhR.dD(1144, 3);
      AppMethodBeat.o(48449);
      return;
      g.yhR.dD(1144, 4);
    }
  }
  
  static void a(i parami)
  {
    AppMethodBeat.i(48469);
    synchronized (myo)
    {
      myo.remove(parami);
      myo.addLast(parami);
    }
    synchronized (myn)
    {
      if (myn.contains(parami))
      {
        myn.remove(parami);
        myn.addLast(parami);
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
    if (com.tencent.mm.plugin.appbrand.task.preload.d.byR())
    {
      AppMethodBeat.o(48448);
      return;
    }
    if ((!d.a.b(parama)) && (com.tencent.mm.plugin.appbrand.task.preload.d.a(d.b.mzj) == -1)) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.AppBrandTaskManager", "preloadPluginUIProcess, hitLimit[%b], scene[%s]", new Object[] { Boolean.valueOf(bool), parama.name() });
      if (!bool)
      {
        g.yhR.dD(1144, 2);
        myp.OE();
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
    myq.remove(paramString);
    if (paramAppBrandRemoteTaskController != null) {
      myr.remove(paramAppBrandRemoteTaskController);
    }
    AppMethodBeat.o(48439);
  }
  
  public static void a(String paramString, final e parame)
  {
    AppMethodBeat.i(188783);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(188783);
      return;
    }
    i locali = UE(paramString);
    paramString = locali;
    if (myp == locali) {
      paramString = UE(AppBrandUI.class.getName());
    }
    if (paramString == null)
    {
      AppMethodBeat.o(188783);
      return;
    }
    aq.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48435);
        if ((this.mys.myG == e.myi) && (parame != e.myi) && (f.k(parame) < parame.myj)) {
          this.mys.l(parame);
        }
        this.mys.OE();
        AppMethodBeat.o(48435);
      }
    }, 500L);
    AppMethodBeat.o(188783);
  }
  
  public static void a(String paramString1, String paramString2, AppBrandRemoteTaskController paramAppBrandRemoteTaskController)
  {
    AppMethodBeat.i(48438);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(48438);
      return;
    }
    myq.put(paramString1, paramString2);
    if (paramAppBrandRemoteTaskController != null) {
      myr.add(paramAppBrandRemoteTaskController);
    }
    AppMethodBeat.o(48438);
  }
  
  private static void bX(String paramString, int paramInt)
  {
    AppMethodBeat.i(48440);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(48440);
      return;
    }
    Object localObject = myr.iterator();
    LinkedList localLinkedList = new LinkedList();
    while (((Iterator)localObject).hasNext())
    {
      AppBrandRemoteTaskController localAppBrandRemoteTaskController = (AppBrandRemoteTaskController)((Iterator)localObject).next();
      if ((paramString.equals(localAppBrandRemoteTaskController.mAppId)) && ((paramInt == localAppBrandRemoteTaskController.mDebugType) || (paramInt < 0)))
      {
        localAppBrandRemoteTaskController.Ux(paramString);
        localLinkedList.add(localAppBrandRemoteTaskController);
      }
    }
    paramString = localLinkedList.iterator();
    while (paramString.hasNext())
    {
      localObject = (AppBrandRemoteTaskController)paramString.next();
      myr.remove(localObject);
    }
    AppMethodBeat.o(48440);
  }
  
  public static void bY(String paramString, int paramInt)
  {
    AppMethodBeat.i(48442);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(48442);
      return;
    }
    i locali = UD(paramString);
    if (locali == null)
    {
      bX(paramString, paramInt);
      AppMethodBeat.o(48442);
      return;
    }
    if ((locali.UJ(paramString).intValue() == paramInt) && (locali.UK(paramString) != null)) {
      locali.UK(paramString).Ux(paramString);
    }
    AppMethodBeat.o(48442);
  }
  
  private static AppBrandRemoteTaskController bZ(String paramString, final int paramInt)
  {
    AppMethodBeat.i(48461);
    paramString = (AppBrandRemoteTaskController)new android.arch.a.c.a() {}.apply(null);
    if ((paramString != null) && (paramString.byC()))
    {
      AppMethodBeat.o(48461);
      return paramString;
    }
    AppMethodBeat.o(48461);
    return null;
  }
  
  public static void byE()
  {
    AppMethodBeat.i(48447);
    a(d.a.myZ);
    AppMethodBeat.o(48447);
  }
  
  public static int[] byF()
  {
    AppMethodBeat.i(48465);
    Object localObject = byG();
    int[] arrayOfInt = new int[((LinkedList)localObject).size()];
    localObject = ((LinkedList)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      arrayOfInt[i] = ((i)((Iterator)localObject).next()).mxH;
      i += 1;
    }
    AppMethodBeat.o(48465);
    return arrayOfInt;
  }
  
  private static LinkedList<i> byG()
  {
    AppMethodBeat.i(48466);
    synchronized (myo)
    {
      LinkedList localLinkedList2 = new LinkedList(myo);
      AppMethodBeat.o(48466);
      return localLinkedList2;
    }
  }
  
  static LinkedList<i> byH()
  {
    AppMethodBeat.i(48467);
    synchronized (myo)
    {
      LinkedList localLinkedList2 = new LinkedList(myo);
      AppMethodBeat.o(48467);
      return localLinkedList2;
    }
  }
  
  public static boolean ca(String paramString, int paramInt)
  {
    AppMethodBeat.i(48462);
    if (bZ(paramString, paramInt) != null)
    {
      AppMethodBeat.o(48462);
      return true;
    }
    AppMethodBeat.o(48462);
    return false;
  }
  
  public static String cb(String paramString, int paramInt)
  {
    AppMethodBeat.i(48464);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(48464);
      return null;
    }
    try
    {
      paramString = bZ(paramString, paramInt);
      if (paramString != null)
      {
        paramString = paramString.mxO;
        AppMethodBeat.o(48464);
        return paramString;
      }
    }
    catch (NullPointerException paramString)
    {
      if (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED)
      {
        AppMethodBeat.o(48464);
        throw paramString;
      }
      ad.printErrStackTrace("MicroMsg.AppBrandTaskManager", paramString, "[NOT CRASH]getAliveInstanceId", new Object[0]);
      AppMethodBeat.o(48464);
    }
    return null;
  }
  
  public static int d(Context paramContext, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(48441);
    if ((!TextUtils.isEmpty(paramAppBrandStatObject.dkh)) && (paramAppBrandStatObject.dkh.length() >= 1024))
    {
      ad.i("MicroMsg.AppBrandTaskManager", "startApp, appId[%s], scene[%d], preScene[%d], sceneNote too long, strip it", new Object[] { paramAppBrandInitConfigWC.appId, Integer.valueOf(paramAppBrandStatObject.scene), Integer.valueOf(paramAppBrandStatObject.dJQ) });
      paramAppBrandStatObject.dkh = paramAppBrandStatObject.dkh.substring(0, 1024);
    }
    if ((!TextUtils.isEmpty(paramAppBrandStatObject.dJR)) && (paramAppBrandStatObject.dJR.length() >= 1024))
    {
      ad.i("MicroMsg.AppBrandTaskManager", "startApp, appId[%s], scene[%d], preScene[%d], preSceneNote too long, strip it", new Object[] { paramAppBrandInitConfigWC.appId, Integer.valueOf(paramAppBrandStatObject.scene), Integer.valueOf(paramAppBrandStatObject.dJQ) });
      paramAppBrandStatObject.dJR = paramAppBrandStatObject.dJR.substring(0, 1024);
    }
    Object localObject5 = com.tencent.mm.plugin.appbrand.report.model.e.msA;
    Object localObject3 = paramAppBrandInitConfigWC.appId;
    int j = paramAppBrandInitConfigWC.aDD;
    boolean bool = ca((String)localObject3, -1);
    Object localObject1 = (e.a)((com.tencent.mm.plugin.appbrand.report.model.e)localObject5).msB.get(localObject3);
    long l;
    label259:
    int i;
    if (localObject1 == null)
    {
      localObject1 = new e.a((byte)0);
      ((e.a)localObject1).msE = 1L;
      ((com.tencent.mm.plugin.appbrand.report.model.e)localObject5).msB.put(localObject3, localObject1);
      if (((e.a)localObject1).msD <= 0L) {
        break label1320;
      }
      l = bt.flT() - ((e.a)localObject1).msD;
      localObject5 = g.yhR;
      if (!bool) {
        break label1326;
      }
      i = 1;
      label271:
      ((g)localObject5).f(16064, new Object[] { Integer.valueOf(1), localObject3, Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(((e.a)localObject1).msE), Long.valueOf(l) });
      com.tencent.mm.plugin.appbrand.keylogger.c.a(paramAppBrandInitConfigWC.appId, KSProcessWeAppLaunch.stepContainerUILaunch);
      if ((!paramAppBrandInitConfigWC.jXu) && (!"wxfe02ecfe70800f46".equalsIgnoreCase(paramAppBrandInitConfigWC.appId)) && (paramAppBrandInitConfigWC.launchMode != 1)) {
        break label1342;
      }
      localObject1 = myp;
      ((i)localObject1).l(e.myg);
      localObject3 = myp.myy;
      if (!myq.containsKey(paramAppBrandInitConfigWC.appId)) {
        break label1331;
      }
      localObject5 = (String)myq.get(paramAppBrandInitConfigWC.appId);
      if (TextUtils.isEmpty((CharSequence)localObject5)) {
        break label1331;
      }
      bool = ((String)localObject5).equals(localObject3);
      label434:
      if (!bool) {
        break label1337;
      }
      a(paramAppBrandInitConfigWC.appId, bZ(paramAppBrandInitConfigWC.appId, paramAppBrandInitConfigWC.dPf));
      i = 2;
      label459:
      a((i)localObject1);
      label464:
      ((i)localObject1).a(paramAppBrandInitConfigWC.appId, paramAppBrandInitConfigWC.dPf, null);
      if (paramContext != null) {
        break label1701;
      }
      paramContext = aj.getContext();
      label486:
      localObject5 = new Intent(paramContext, ((i)localObject1).myx);
      ((Intent)localObject5).putExtra("key_appbrand_init_config", paramAppBrandInitConfigWC);
      ((Intent)localObject5).putExtra("key_appbrand_stat_object", paramAppBrandStatObject);
      ((Intent)localObject5).putExtra("key_app_id", paramAppBrandInitConfigWC.appId);
      if ((!com.tencent.mm.plugin.appbrand.utils.a.aI(((i)localObject1).myx)) && ((paramContext instanceof Activity))) {
        break label1532;
      }
      j = 268435456;
      ((Intent)localObject5).addFlags(j);
      if (!(paramContext instanceof Activity)) {}
    }
    for (;;)
    {
      try
      {
        localObject3 = bt.aJ(paramContext, ((Activity)paramContext).getTaskId());
        if ((localObject3 != null) && (((ActivityManager.RunningTaskInfo)localObject3).baseActivity != null) && (bt.nullAsNil(((ActivityManager.RunningTaskInfo)localObject3).baseActivity.getClassName()).equals(((i)localObject1).myw)))
        {
          ((Intent)localObject5).putExtra("key_appbrand_bring_ui_to_front_from_task_Base_by_task_top_ui", true);
          ((Intent)localObject5).addFlags(603979776);
        }
        ((Intent)localObject5).putExtra("key_from_activity_requested_orientation", ((Activity)paramContext).getRequestedOrientation());
        paramAppBrandInitConfigWC.jXv = bt.flT();
        paramAppBrandInitConfigWC.jXB = aj.aQt(((i)localObject1).myy);
        ((Intent)localObject5).putExtra("key_launch_app_client_version", com.tencent.mm.sdk.platformtools.i.Ics);
        j.byN();
        locala = new com.tencent.mm.plugin.appbrand.loading.a(paramContext, (Intent)localObject5, paramAppBrandInitConfigWC, (i)localObject1, paramAppBrandStatObject);
        try
        {
          if (!locala.bse()) {
            break label1589;
          }
          ad.i("MicroMsg.AppBrandTaskManager", "startTargetActivity: needPreLoadingUi");
          locala.lNK = com.tencent.mm.plugin.appbrand.loading.c.lNX.a(new com.tencent.mm.plugin.appbrand.loading.e(locala.ctx, locala.lNM, locala.jDG, locala.jDH));
          Class localClass = locala.lNN.myC;
          localObject1 = new StringBuilder("onNeedPreLoadingUI: triggerService = ");
          p.g(localClass, "processTriggerServiceClass");
          ad.i("MicroMsg.AppBrand.AppBrandPreLoadingLogic", localClass.getCanonicalName());
          String str = localClass.getCanonicalName();
          if (str == null) {
            p.gfZ();
          }
          localObject1 = locala.lNM.getComponent();
          if (localObject1 == null) {
            break label1704;
          }
          localObject3 = ((ComponentName)localObject1).getClassName();
          localObject1 = localObject3;
          if (localObject3 == null) {
            break label1704;
          }
          localObject3 = new Intent(locala.ctx, locala.lNN.myD);
          ad.i("MicroMsg.AppBrand.AppBrandPreLoadingLogic", "startPreLoadingActivity, ctx = " + locala.ctx);
          ((Intent)localObject3).putExtra("MicroMsg.AppBrandPreLoadingLogic.name", locala.jDG.doD);
          ((Intent)localObject3).putExtra("MicroMsg.AppBrandPreLoadingLogic.icon", locala.jDG.iconUrl);
          ((Intent)localObject3).putExtra("MicroMsg.AppBrandPreLoadingLogic.serviceName", str);
          ((Intent)localObject3).putExtra("MicroMsg.AppBrandPreLoadingLogic.intentKey", locala.lNK);
          ((Intent)localObject3).putExtra("MicroMsg.AppBrandPreLoadingLogic.targetActivityName", (String)localObject1);
          ((Intent)localObject3).putExtra("MicroMsg.AppBrandPreLoadingLogic.splashFlavor", locala.bsd());
          ((Intent)localObject3).putExtra("MicroMsg.AppBrandPreLoadingLogic.appId", locala.jDG.appId);
          ((Intent)localObject3).putExtra("MicroMsg.AppBrandPreLoadingLogic.scene", locala.jDH.scene);
          ((Intent)localObject3).putExtra("MicroMsg.AppBrandPreLoadingLogic.versionInfo", (Parcelable)locala.jDG.cmy);
          ((Intent)localObject3).addFlags(268435456);
          localObject1 = locala.ctx;
          localObject3 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject3);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject3).ahp(), "com/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingLogic", "startPreLoadingActivity", "(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject3).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingLogic", "startPreLoadingActivity", "(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          if ((locala.ctx instanceof Activity)) {
            localObject1 = (Activity)locala.ctx;
          }
          switch (locala.bsd())
          {
          case 4: 
            com.tencent.mm.ad.c.b("MicroMsg.AppBrand.AppBrandPreLoadingLogic:startService:".concat(String.valueOf(str)), (d.g.a.a)new a.c(locala, str));
            locala.jDG.jXA = localClass.getCanonicalName();
          }
        }
        catch (Throwable localThrowable1)
        {
          Object localObject4;
          ad.printErrStackTrace("MicroMsg.AppBrandTaskManager", localThrowable1, "onNeedPreLoadingUI", new Object[0]);
          paramAppBrandInitConfigWC.jXA = "";
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject5);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/appbrand/task/AppBrandTaskManager", "startTargetActivity", "(Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingLogic;Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/appbrand/task/AppBrandTaskManager", "startTargetActivity", "(Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingLogic;Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          if (!(paramContext instanceof Activity)) {
            continue;
          }
          ((aa)com.tencent.luggage.a.e.K(aa.class)).a((Activity)paramContext, paramAppBrandInitConfigWC);
          continue;
        }
        if (i == 1) {
          UA(paramAppBrandInitConfigWC.appId);
        }
        ad.i("MicroMsg.AppBrandTaskManager", "startApp appId[%s] type[%d] scene[%d] strategy[%d] targetProcessExists[%b]", new Object[] { paramAppBrandInitConfigWC.appId, Integer.valueOf(paramAppBrandInitConfigWC.dPf), Integer.valueOf(paramAppBrandStatObject.scene), Integer.valueOf(i), Boolean.valueOf(paramAppBrandInitConfigWC.jXB) });
        AppMethodBeat.o(48441);
        return i;
        ((e.a)localObject1).msE += 1L;
        break;
        label1320:
        l = 0L;
        break label259;
        label1326:
        i = 0;
        break label271;
        label1331:
        bool = false;
        break label434;
        label1337:
        i = 1;
        break label459;
        label1342:
        localObject1 = UD(paramAppBrandInitConfigWC.appId);
        if ((localObject1 == null) || (localObject1 == myp))
        {
          if (myq.containsKey(paramAppBrandInitConfigWC.appId))
          {
            localObject3 = (String)myq.get(paramAppBrandInitConfigWC.appId);
            if (!TextUtils.isEmpty((CharSequence)localObject3))
            {
              localObject5 = myn.iterator();
              if (((Iterator)localObject5).hasNext())
              {
                localObject1 = (i)((Iterator)localObject5).next();
                if (!((String)localObject3).equals(((i)localObject1).myy)) {
                  continue;
                }
                if (localObject1 == null) {
                  continue;
                }
                i = 2;
                a((i)localObject1);
                break label464;
              }
            }
          }
          localObject1 = null;
          continue;
          if (paramAppBrandInitConfigWC.Eb())
          {
            localObject1 = e.myh;
            localObject3 = j((e)localObject1);
            if (paramAppBrandInitConfigWC.Eb())
            {
              localObject1 = e.myh;
              ((i)localObject3).l((e)localObject1);
              i = 1;
              localObject1 = localObject3;
            }
          }
          else
          {
            localObject1 = e.myg;
            continue;
          }
          localObject1 = e.myg;
          continue;
        }
        i = 2;
        break label464;
        label1532:
        j = 0;
      }
      catch (Throwable localThrowable2)
      {
        com.tencent.mm.plugin.appbrand.loading.a locala;
        localObject4 = null;
        continue;
        ((aa)com.tencent.luggage.a.e.K(aa.class)).a((Activity)localObject1, (AppBrandInitConfig)locala.jDG);
        continue;
      }
      label1589:
      break label486;
      label1701:
      label1704:
      Object localObject2 = "";
    }
  }
  
  static i en(String paramString1, String paramString2)
  {
    AppMethodBeat.i(48460);
    Iterator localIterator = byG().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if ((locali.myE.keySet().contains(paramString1)) && (locali.myw.equals(paramString2)))
      {
        AppMethodBeat.o(48460);
        return locali;
      }
    }
    AppMethodBeat.o(48460);
    return null;
  }
  
  public static void f(e parame)
  {
    AppMethodBeat.i(48445);
    a(parame, d.a.myZ);
    AppMethodBeat.o(48445);
  }
  
  public static int g(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(188782);
    int i = d(null, paramAppBrandInitConfigWC, paramAppBrandStatObject);
    AppMethodBeat.o(188782);
    return i;
  }
  
  private static int g(e parame)
  {
    AppMethodBeat.i(188784);
    Iterator localIterator = myn.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (((i)localIterator.next()).myG != parame) {
        break label55;
      }
      i += 1;
    }
    label55:
    for (;;)
    {
      break;
      AppMethodBeat.o(188784);
      return i;
    }
  }
  
  private static boolean h(e parame)
  {
    AppMethodBeat.i(48455);
    int i = g(parame);
    if (i > parame.myj)
    {
      parame = new IllegalStateException(bt.x("TaskManager count the serviceType [%s] in TASK_LIST, count = [%d], but max limit = [%d]", new Object[] { parame.name(), Integer.valueOf(i), Integer.valueOf(parame.myj) }));
      AppMethodBeat.o(48455);
      throw parame;
    }
    if (i == parame.myj)
    {
      AppMethodBeat.o(48455);
      return true;
    }
    AppMethodBeat.o(48455);
    return false;
  }
  
  private static i i(e parame)
  {
    AppMethodBeat.i(48456);
    synchronized (myn)
    {
      if (h(parame))
      {
        ad.i("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess serviceType = [%s] reachedMaxLimit", new Object[] { parame });
        AppMethodBeat.o(48456);
        return null;
      }
      Object localObject = myn.iterator();
      while (((Iterator)localObject).hasNext())
      {
        locali = (i)((Iterator)localObject).next();
        if ((locali.myE.isEmpty()) && (locali.myG == parame))
        {
          ad.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup found empty task[%s], which can be used as [%s]", new Object[] { locali.myy, parame });
          AppMethodBeat.o(48456);
          return locali;
        }
      }
      i locali = a(myn, e.myi);
      if (locali == null)
      {
        localObject = "null";
        ad.i("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess serviceType = [%s] not reached max limit , got ui task = [%s]", new Object[] { parame, localObject });
        AppMethodBeat.o(48456);
        return locali;
      }
      localObject = locali.myw;
    }
  }
  
  private static i j(e parame)
  {
    AppMethodBeat.i(48457);
    for (;;)
    {
      synchronized (myn)
      {
        Iterator localIterator = myn.iterator();
        if (localIterator.hasNext())
        {
          locali = (i)localIterator.next();
          if ((!locali.myE.isEmpty()) || (locali.myG != parame)) {
            continue;
          }
          ad.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup found empty task, which can be used as [%s]", new Object[] { parame });
          parame = locali;
          AppMethodBeat.o(48457);
          return parame;
        }
        if (h(parame))
        {
          ad.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup [%s] task reached maxLimit", new Object[] { parame });
          locali = a(myn, parame);
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
      i locali = a(myn, e.myi);
      if (locali != null)
      {
        ad.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup found not used task, which can be used as [%s]", new Object[] { parame });
        parame = locali;
      }
      else
      {
        ad.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup all full for [%s]", new Object[] { parame });
        parame = (i)myn.getFirst();
      }
    }
  }
  
  public static void onNetworkChange()
  {
    AppMethodBeat.i(48451);
    Iterator localIterator1 = byG().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((i)localIterator1.next()).myF.values().iterator();
      while (localIterator2.hasNext())
      {
        AppBrandRemoteTaskController localAppBrandRemoteTaskController = (AppBrandRemoteTaskController)localIterator2.next();
        if (localAppBrandRemoteTaskController != null)
        {
          localAppBrandRemoteTaskController.mxJ = AppBrandRemoteTaskController.a.myb;
          localAppBrandRemoteTaskController.bhX();
        }
      }
    }
    AppMethodBeat.o(48451);
  }
  
  public static void vu(int paramInt)
  {
    AppMethodBeat.i(48443);
    Object localObject2;
    Object localObject3;
    if (2 == paramInt)
    {
      localObject1 = new HashMap();
      localObject2 = byG().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (i)((Iterator)localObject2).next();
        if (!TextUtils.isEmpty(((i)localObject3).myy)) {
          if (((i)localObject3).myE.isEmpty())
          {
            localObject3 = ((i)localObject3).myy;
            Boolean localBoolean = Boolean.TRUE;
            if (Build.VERSION.SDK_INT >= 24) {
              ((HashMap)localObject1).putIfAbsent(localObject3, localBoolean);
            } else if (((HashMap)localObject1).get(localObject3) == null) {
              ((HashMap)localObject1).put(localObject3, localBoolean);
            }
          }
          else
          {
            ((HashMap)localObject1).put(((i)localObject3).myy, Boolean.FALSE);
          }
        }
      }
      localObject1 = ((HashMap)localObject1).entrySet().iterator();
      label231:
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if ((((Map.Entry)localObject2).getValue() != null) && (((Boolean)((Map.Entry)localObject2).getValue()).booleanValue())) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label231;
          }
          localObject2 = (String)((Map.Entry)localObject2).getKey();
          ad.i("MicroMsg.AppBrandTaskManager", "killAll SILENT_IF_INACTIVE kill process(%s)", new Object[] { localObject2 });
          com.tencent.mm.modelappbrand.b.BZ((String)localObject2);
          com.tencent.mm.bw.a.bX(aj.getContext(), (String)localObject2);
          break;
        }
      }
      ad.i("MicroMsg.AppBrandTaskManager", "killAll SILENT_IF_INACTIVE tryPreloadNextTaskProcess(both waservice and wagame)");
      a(e.myg, true);
      a(e.myh, true);
      AppMethodBeat.o(48443);
      return;
    }
    Object localObject1 = byG().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((i)((Iterator)localObject1).next()).myF.values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (AppBrandRemoteTaskController)((Iterator)localObject2).next();
        if (localObject3 != null) {
          ((AppBrandRemoteTaskController)localObject3).vs(paramInt);
        }
      }
    }
    localObject1 = myr.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (AppBrandRemoteTaskController)((Iterator)localObject1).next();
      if (localObject2 != null) {
        ((AppBrandRemoteTaskController)localObject2).vs(paramInt);
      }
    }
    if (3 == paramInt) {
      myr.clear();
    }
    AppMethodBeat.o(48443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.f
 * JD-Core Version:    0.7.0.1
 */