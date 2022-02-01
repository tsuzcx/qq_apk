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
import com.tencent.mm.plugin.appbrand.ui.ab;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import java.util.ArrayList;
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
  private static final LinkedList<i> mDl;
  private static final LinkedList<i> mDm;
  public static final i mDn;
  private static final ConcurrentHashMap<String, String> mDo;
  private static final ConcurrentSkipListSet<AppBrandRemoteTaskController> mDp;
  
  static
  {
    AppMethodBeat.i(48471);
    if (!f.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      mDo = new ConcurrentHashMap();
      mDp = new ConcurrentSkipListSet(new Comparator() {});
      LinkedList localLinkedList = new LinkedList();
      mDl = localLinkedList;
      localLinkedList.add(new i(AppBrandUI.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class, AppBrandForegroundNotificationService.class, AppBrandProcessTriggerService0.class, AppBrandPreLoadingUI.class));
      mDl.add(new i(AppBrandUI1.class, AppBrandTaskPreloadReceiver1.class, AppBrandKeepAliveService1.class, AppBrandForegroundNotificationService1.class, AppBrandProcessTriggerService1.class, AppBrandPreLoadingUI1.class));
      mDl.add(new i(AppBrandUI2.class, AppBrandTaskPreloadReceiver2.class, AppBrandKeepAliveService2.class, AppBrandForegroundNotificationService2.class, AppBrandProcessTriggerService2.class, AppBrandPreLoadingUI2.class));
      mDl.add(new i(AppBrandUI3.class, AppBrandTaskPreloadReceiver3.class, AppBrandKeepAliveService3.class, AppBrandForegroundNotificationService3.class, AppBrandProcessTriggerService3.class, AppBrandPreLoadingUI3.class));
      mDl.add(new i(AppBrandUI4.class, AppBrandTaskPreloadReceiver4.class, AppBrandKeepAliveService4.class, AppBrandForegroundNotificationService4.class, AppBrandProcessTriggerService4.class, AppBrandPreLoadingUI4.class));
      mDn = new b();
      localLinkedList = new LinkedList();
      mDm = localLinkedList;
      localLinkedList.addAll(mDl);
      mDm.add(mDn);
      AppMethodBeat.o(48471);
      return;
    }
  }
  
  public static void Vl(String paramString)
  {
    AppMethodBeat.i(48444);
    Iterator localIterator = bzA().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if ((locali != null) && (locali.Vv(paramString) != null))
      {
        ae.i("MicroMsg.AppBrandTaskManager", "clearDuplicatedApp task:%s, appId:%s", new Object[] { locali.mDu, paramString });
        locali.Vv(paramString).Vi(paramString);
      }
    }
    cb(paramString, -1);
    AppMethodBeat.o(48444);
  }
  
  public static Class Vm(String paramString)
  {
    AppMethodBeat.i(48452);
    Iterator localIterator = bzA().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (locali.mDu.equals(paramString))
      {
        paramString = locali.mDy;
        AppMethodBeat.o(48452);
        return paramString;
      }
    }
    AppMethodBeat.o(48452);
    return null;
  }
  
  public static Class Vn(String paramString)
  {
    AppMethodBeat.i(48453);
    Iterator localIterator = bzA().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (locali.mDu.equals(paramString))
      {
        paramString = locali.mDz;
        AppMethodBeat.o(48453);
        return paramString;
      }
    }
    AppMethodBeat.o(48453);
    return null;
  }
  
  private static i Vo(String paramString)
  {
    AppMethodBeat.i(48458);
    Iterator localIterator = bzA().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (locali.mDD.keySet().contains(paramString))
      {
        AppMethodBeat.o(48458);
        return locali;
      }
    }
    AppMethodBeat.o(48458);
    return null;
  }
  
  static i Vp(String paramString)
  {
    AppMethodBeat.i(48459);
    Iterator localIterator = bzA().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (locali.mDu.equals(paramString))
      {
        AppMethodBeat.o(48459);
        return locali;
      }
    }
    Assert.assertTrue(true);
    AppMethodBeat.o(48459);
    return null;
  }
  
  public static boolean Vq(String paramString)
  {
    AppMethodBeat.i(224374);
    boolean bool = ce(paramString, -1);
    AppMethodBeat.o(224374);
    return bool;
  }
  
  public static Pair<String, Integer> Vr(String paramString)
  {
    AppMethodBeat.i(160619);
    paramString = cd(paramString, -1);
    if (paramString == null)
    {
      AppMethodBeat.o(160619);
      return null;
    }
    paramString = Pair.create(paramString.mAppId, Integer.valueOf(paramString.mDebugType));
    AppMethodBeat.o(160619);
    return paramString;
  }
  
  static void Vs(String arg0)
  {
    AppMethodBeat.i(48468);
    i locali = Vo(???);
    if (locali != null)
    {
      locali.mDD.remove(???);
      locali.mDE.remove(???);
      if (locali.mDD.isEmpty()) {
        locali.mDF = e.mDg;
      }
      if (locali.mDD.keySet().isEmpty())
      {
        synchronized (mDm)
        {
          mDm.remove(locali);
          mDm.addFirst(locali);
        }
        synchronized (mDl)
        {
          if (mDl.contains(locali))
          {
            mDl.remove(locali);
            mDl.addFirst(locali);
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
      if (locali.mDF == parame)
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
    if ((!com.tencent.mm.plugin.appbrand.appusage.i.bcv()) || (com.tencent.mm.plugin.appbrand.task.preload.d.bzM()) || (parame == e.mDg))
    {
      AppMethodBeat.o(48449);
      return;
    }
    int i = com.tencent.mm.plugin.appbrand.task.preload.d.a(d.b.m(parame));
    Object localObject = com.tencent.mm.plugin.appbrand.app.d.jGw;
    boolean bool = paramBoolean;
    if (com.tencent.mm.plugin.appbrand.app.d.LD().getBoolean("is_pre_load_downgrade_env", false)) {
      if (!com.tencent.mm.sdk.platformtools.j.DEBUG)
      {
        bool = paramBoolean;
        if (!com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) {}
      }
      else
      {
        bool = false;
      }
    }
    if ((!bool) && (i == -1))
    {
      ae.w("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess %s, hit interval limit", new Object[] { parame });
      if (parame == e.mDe)
      {
        g.yxI.dD(915, 22);
        AppMethodBeat.o(48449);
        return;
      }
      if (parame == e.mDf) {
        g.yxI.dD(915, 23);
      }
      AppMethodBeat.o(48449);
      return;
    }
    if (bool) {
      i = 2;
    }
    switch (4.mDs[parame.ordinal()])
    {
    default: 
      ae.i("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess serviceType = [%s], preload level = [%d]", new Object[] { parame, Integer.valueOf(i) });
      localObject = i(parame);
      if (localObject != null)
      {
        ((i)localObject).l(parame);
        ((i)localObject).vA(i);
        if (i != 2) {
          g.yxI.dD(915, 30);
        }
        switch (4.mDs[parame.ordinal()])
        {
        }
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(48449);
      return;
      g.yxI.dD(1144, 0);
      break;
      g.yxI.dD(1144, 1);
      break;
      g.yxI.dD(1144, 3);
      AppMethodBeat.o(48449);
      return;
      g.yxI.dD(1144, 4);
    }
  }
  
  static void a(i parami)
  {
    AppMethodBeat.i(48469);
    synchronized (mDm)
    {
      mDm.remove(parami);
      mDm.addLast(parami);
    }
    synchronized (mDl)
    {
      if (mDl.contains(parami))
      {
        mDl.remove(parami);
        mDl.addLast(parami);
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
    if (com.tencent.mm.plugin.appbrand.task.preload.d.bzM())
    {
      AppMethodBeat.o(48448);
      return;
    }
    if ((!d.a.b(parama)) && (com.tencent.mm.plugin.appbrand.task.preload.d.a(d.b.mEk) == -1)) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.AppBrandTaskManager", "preloadPluginUIProcess, hitLimit[%b], scene[%s]", new Object[] { Boolean.valueOf(bool), parama.name() });
      if (!bool)
      {
        g.yxI.dD(1144, 2);
        mDn.OC();
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
    mDo.remove(paramString);
    if (paramAppBrandRemoteTaskController != null) {
      mDp.remove(paramAppBrandRemoteTaskController);
    }
    AppMethodBeat.o(48439);
  }
  
  public static void a(String paramString, final e parame)
  {
    AppMethodBeat.i(223003);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(223003);
      return;
    }
    i locali = Vp(paramString);
    paramString = locali;
    if (mDn == locali) {
      paramString = Vp(AppBrandUI.class.getName());
    }
    if (paramString == null)
    {
      AppMethodBeat.o(223003);
      return;
    }
    ar.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48435);
        if ((this.mDq.mDF == e.mDg) && (parame != e.mDg) && (f.k(parame) < parame.mDh)) {
          this.mDq.l(parame);
        }
        this.mDq.OC();
        AppMethodBeat.o(48435);
      }
    }, 500L);
    AppMethodBeat.o(223003);
  }
  
  public static void a(String paramString1, String paramString2, AppBrandRemoteTaskController paramAppBrandRemoteTaskController)
  {
    AppMethodBeat.i(48438);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(48438);
      return;
    }
    mDo.put(paramString1, paramString2);
    if (paramAppBrandRemoteTaskController != null) {
      mDp.add(paramAppBrandRemoteTaskController);
    }
    AppMethodBeat.o(48438);
  }
  
  private static LinkedList<i> bzA()
  {
    AppMethodBeat.i(48466);
    synchronized (mDm)
    {
      LinkedList localLinkedList2 = new LinkedList(mDm);
      AppMethodBeat.o(48466);
      return localLinkedList2;
    }
  }
  
  public static List<String> bzB()
  {
    AppMethodBeat.i(223006);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = mDm.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (i)localIterator.next();
      if ((localObject != null) && (((i)localObject).mDD.keySet() != null) && (((i)localObject).mDD.keySet().size() > 0)) {
        localArrayList.addAll(((i)localObject).mDD.keySet());
      }
    }
    localIterator = mDp.iterator();
    while (localIterator.hasNext())
    {
      localObject = (AppBrandRemoteTaskController)localIterator.next();
      if ((localObject != null) && (((AppBrandRemoteTaskController)localObject).mAppId != null)) {
        localArrayList.add(((AppBrandRemoteTaskController)localObject).mAppId);
      }
    }
    AppMethodBeat.o(223006);
    return localArrayList;
  }
  
  static LinkedList<i> bzC()
  {
    AppMethodBeat.i(48467);
    synchronized (mDm)
    {
      LinkedList localLinkedList2 = new LinkedList(mDm);
      AppMethodBeat.o(48467);
      return localLinkedList2;
    }
  }
  
  public static void bzy()
  {
    AppMethodBeat.i(48447);
    a(d.a.mEa);
    AppMethodBeat.o(48447);
  }
  
  public static int[] bzz()
  {
    AppMethodBeat.i(48465);
    Object localObject = bzA();
    int[] arrayOfInt = new int[((LinkedList)localObject).size()];
    localObject = ((LinkedList)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      arrayOfInt[i] = ((i)((Iterator)localObject).next()).mCE;
      i += 1;
    }
    AppMethodBeat.o(48465);
    return arrayOfInt;
  }
  
  private static void cb(String paramString, int paramInt)
  {
    AppMethodBeat.i(48440);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(48440);
      return;
    }
    Object localObject = mDp.iterator();
    LinkedList localLinkedList = new LinkedList();
    while (((Iterator)localObject).hasNext())
    {
      AppBrandRemoteTaskController localAppBrandRemoteTaskController = (AppBrandRemoteTaskController)((Iterator)localObject).next();
      if ((paramString.equals(localAppBrandRemoteTaskController.mAppId)) && ((paramInt == localAppBrandRemoteTaskController.mDebugType) || (paramInt < 0)))
      {
        localAppBrandRemoteTaskController.Vi(paramString);
        localLinkedList.add(localAppBrandRemoteTaskController);
      }
    }
    paramString = localLinkedList.iterator();
    while (paramString.hasNext())
    {
      localObject = (AppBrandRemoteTaskController)paramString.next();
      mDp.remove(localObject);
    }
    AppMethodBeat.o(48440);
  }
  
  public static void cc(String paramString, int paramInt)
  {
    AppMethodBeat.i(48442);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(48442);
      return;
    }
    i locali = Vo(paramString);
    if (locali == null)
    {
      cb(paramString, paramInt);
      AppMethodBeat.o(48442);
      return;
    }
    if ((locali.Vu(paramString).intValue() == paramInt) && (locali.Vv(paramString) != null)) {
      locali.Vv(paramString).Vi(paramString);
    }
    AppMethodBeat.o(48442);
  }
  
  private static AppBrandRemoteTaskController cd(String paramString, final int paramInt)
  {
    AppMethodBeat.i(48461);
    paramString = (AppBrandRemoteTaskController)new android.arch.a.c.a() {}.apply(null);
    if ((paramString != null) && (paramString.bzw()))
    {
      AppMethodBeat.o(48461);
      return paramString;
    }
    AppMethodBeat.o(48461);
    return null;
  }
  
  public static boolean ce(String paramString, int paramInt)
  {
    AppMethodBeat.i(48462);
    if (cd(paramString, paramInt) != null)
    {
      AppMethodBeat.o(48462);
      return true;
    }
    AppMethodBeat.o(48462);
    return false;
  }
  
  public static String cf(String paramString, int paramInt)
  {
    AppMethodBeat.i(48464);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(48464);
      return null;
    }
    try
    {
      paramString = cd(paramString, paramInt);
      if (paramString != null)
      {
        paramString = paramString.mCL;
        AppMethodBeat.o(48464);
        return paramString;
      }
    }
    catch (NullPointerException paramString)
    {
      if (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED)
      {
        AppMethodBeat.o(48464);
        throw paramString;
      }
      ae.printErrStackTrace("MicroMsg.AppBrandTaskManager", paramString, "[NOT CRASH]getAliveInstanceId", new Object[0]);
      AppMethodBeat.o(48464);
    }
    return null;
  }
  
  public static int d(Context paramContext, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(48441);
    if ((!TextUtils.isEmpty(paramAppBrandStatObject.dlj)) && (paramAppBrandStatObject.dlj.length() >= 1024))
    {
      ae.i("MicroMsg.AppBrandTaskManager", "startApp, appId[%s], scene[%d], preScene[%d], sceneNote too long, strip it", new Object[] { paramAppBrandInitConfigWC.appId, Integer.valueOf(paramAppBrandStatObject.scene), Integer.valueOf(paramAppBrandStatObject.dLf) });
      paramAppBrandStatObject.dlj = paramAppBrandStatObject.dlj.substring(0, 1024);
    }
    if ((!TextUtils.isEmpty(paramAppBrandStatObject.dLg)) && (paramAppBrandStatObject.dLg.length() >= 1024))
    {
      ae.i("MicroMsg.AppBrandTaskManager", "startApp, appId[%s], scene[%d], preScene[%d], preSceneNote too long, strip it", new Object[] { paramAppBrandInitConfigWC.appId, Integer.valueOf(paramAppBrandStatObject.scene), Integer.valueOf(paramAppBrandStatObject.dLf) });
      paramAppBrandStatObject.dLg = paramAppBrandStatObject.dLg.substring(0, 1024);
    }
    Object localObject4 = com.tencent.mm.plugin.appbrand.report.model.e.mxx;
    Object localObject2 = paramAppBrandInitConfigWC.appId;
    int j = paramAppBrandInitConfigWC.aDD;
    boolean bool = ce((String)localObject2, -1);
    Object localObject1 = (e.a)((com.tencent.mm.plugin.appbrand.report.model.e)localObject4).mxy.get(localObject2);
    long l;
    label259:
    int i;
    label271:
    label434:
    label459:
    label464:
    label486:
    Intent localIntent;
    if (localObject1 == null)
    {
      localObject1 = new e.a((byte)0);
      ((e.a)localObject1).mxB = 1L;
      ((com.tencent.mm.plugin.appbrand.report.model.e)localObject4).mxy.put(localObject2, localObject1);
      if (((e.a)localObject1).mxA <= 0L) {
        break label1313;
      }
      l = bu.fpO() - ((e.a)localObject1).mxA;
      localObject4 = g.yxI;
      if (!bool) {
        break label1319;
      }
      i = 1;
      ((g)localObject4).f(16064, new Object[] { Integer.valueOf(1), localObject2, Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(((e.a)localObject1).mxB), Long.valueOf(l) });
      com.tencent.mm.plugin.appbrand.keylogger.c.a(paramAppBrandInitConfigWC.appId, KSProcessWeAppLaunch.stepContainerUILaunch);
      if ((!paramAppBrandInitConfigWC.kaJ) && (!"wxfe02ecfe70800f46".equalsIgnoreCase(paramAppBrandInitConfigWC.appId)) && (paramAppBrandInitConfigWC.launchMode != 1)) {
        break label1335;
      }
      localObject1 = mDn;
      ((i)localObject1).l(e.mDe);
      localObject2 = mDn.mDw;
      if (!mDo.containsKey(paramAppBrandInitConfigWC.appId)) {
        break label1324;
      }
      localObject4 = (String)mDo.get(paramAppBrandInitConfigWC.appId);
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        break label1324;
      }
      bool = ((String)localObject4).equals(localObject2);
      if (!bool) {
        break label1330;
      }
      a(paramAppBrandInitConfigWC.appId, cd(paramAppBrandInitConfigWC.appId, paramAppBrandInitConfigWC.dQv));
      i = 2;
      a((i)localObject1);
      ((i)localObject1).a(paramAppBrandInitConfigWC.appId, paramAppBrandInitConfigWC.dQv, null);
      if (paramContext != null) {
        break label1694;
      }
      paramContext = ak.getContext();
      localIntent = new Intent(paramContext, ((i)localObject1).mDv);
      localIntent.putExtra("key_appbrand_init_config", paramAppBrandInitConfigWC);
      localIntent.putExtra("key_appbrand_stat_object", paramAppBrandStatObject);
      localIntent.putExtra("key_app_id", paramAppBrandInitConfigWC.appId);
      if ((!com.tencent.mm.plugin.appbrand.utils.b.aI(((i)localObject1).mDv)) && ((paramContext instanceof Activity))) {
        break label1525;
      }
      j = 268435456;
      localIntent.addFlags(j);
      if (!(paramContext instanceof Activity)) {}
    }
    for (;;)
    {
      try
      {
        localObject2 = bu.aJ(paramContext, ((Activity)paramContext).getTaskId());
        if ((localObject2 != null) && (((ActivityManager.RunningTaskInfo)localObject2).baseActivity != null) && (bu.nullAsNil(((ActivityManager.RunningTaskInfo)localObject2).baseActivity.getClassName()).equals(((i)localObject1).mDu)))
        {
          localIntent.putExtra("key_appbrand_bring_ui_to_front_from_task_Base_by_task_top_ui", true);
          localIntent.addFlags(603979776);
        }
        paramAppBrandInitConfigWC.kaK = bu.fpO();
        paramAppBrandInitConfigWC.kaQ = ak.aRQ(((i)localObject1).mDw);
        localIntent.putExtra("key_launch_app_client_version", com.tencent.mm.sdk.platformtools.j.IwD);
        j.bzI();
        locala = new com.tencent.mm.plugin.appbrand.loading.a(paramContext, localIntent, paramAppBrandInitConfigWC, (i)localObject1, paramAppBrandStatObject);
        try
        {
          if (!locala.bsP()) {
            break label1582;
          }
          ae.i("MicroMsg.AppBrandTaskManager", "startTargetActivity: needPreLoadingUi");
          locala.lSl = com.tencent.mm.plugin.appbrand.loading.c.lSy.a(new com.tencent.mm.plugin.appbrand.loading.e(locala.ctx, locala.lSn, locala.jGE, locala.jGF));
          Class localClass = locala.lSo.mDA;
          localObject2 = new StringBuilder("onNeedPreLoadingUI: triggerService = ");
          p.g(localClass, "processTriggerServiceClass");
          ae.i("MicroMsg.AppBrand.AppBrandPreLoadingLogic", localClass.getCanonicalName());
          String str = localClass.getCanonicalName();
          if (str == null) {
            p.gkB();
          }
          localObject2 = locala.lSn.getComponent();
          if (localObject2 == null) {
            break label1697;
          }
          localObject4 = ((ComponentName)localObject2).getClassName();
          localObject2 = localObject4;
          if (localObject4 == null) {
            break label1697;
          }
          localObject4 = new Intent(locala.ctx, locala.lSo.mDC);
          ae.i("MicroMsg.AppBrand.AppBrandPreLoadingLogic", "startPreLoadingActivity, ctx = " + locala.ctx);
          ((Intent)localObject4).putExtra("MicroMsg.AppBrandPreLoadingLogic.name", locala.jGE.dpI);
          ((Intent)localObject4).putExtra("MicroMsg.AppBrandPreLoadingLogic.icon", locala.jGE.iconUrl);
          ((Intent)localObject4).putExtra("MicroMsg.AppBrandPreLoadingLogic.serviceName", str);
          ((Intent)localObject4).putExtra("MicroMsg.AppBrandPreLoadingLogic.intentKey", locala.lSl);
          ((Intent)localObject4).putExtra("MicroMsg.AppBrandPreLoadingLogic.targetActivityName", (String)localObject2);
          ((Intent)localObject4).putExtra("MicroMsg.AppBrandPreLoadingLogic.splashFlavor", locala.bsO());
          ((Intent)localObject4).putExtra("MicroMsg.AppBrandPreLoadingLogic.appId", locala.jGE.appId);
          ((Intent)localObject4).putExtra("MicroMsg.AppBrandPreLoadingLogic.scene", locala.jGF.scene);
          ((Intent)localObject4).putExtra("MicroMsg.AppBrandPreLoadingLogic.versionInfo", (Parcelable)locala.jGE.cmA);
          ((Intent)localObject4).addFlags(268435456);
          localObject2 = locala.ctx;
          localObject4 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject4);
          com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject4).ahE(), "com/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingLogic", "startPreLoadingActivity", "(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject4).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingLogic", "startPreLoadingActivity", "(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          if ((locala.ctx instanceof Activity)) {
            localObject2 = (Activity)locala.ctx;
          }
          switch (locala.bsO())
          {
          case 4: 
            com.tencent.mm.ac.c.b("MicroMsg.AppBrand.AppBrandPreLoadingLogic:startService:".concat(String.valueOf(str)), (d.g.a.a)new a.c(locala, str));
            locala.jGE.kaP = localClass.getCanonicalName();
          }
        }
        catch (Throwable localThrowable2)
        {
          Activity localActivity;
          ae.printErrStackTrace("MicroMsg.AppBrandTaskManager", localThrowable2, "onNeedPreLoadingUI", new Object[0]);
          paramAppBrandInitConfigWC.kaP = "";
          localObject3 = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject3).ahE(), "com/tencent/mm/plugin/appbrand/task/AppBrandTaskManager", "startTargetActivity", "(Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingLogic;Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject3).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/appbrand/task/AppBrandTaskManager", "startTargetActivity", "(Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingLogic;Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          if (!(paramContext instanceof Activity)) {
            continue;
          }
          ((ab)com.tencent.luggage.a.e.K(ab.class)).a((Activity)paramContext, paramAppBrandInitConfigWC);
          continue;
        }
        if (i == 1) {
          Vl(paramAppBrandInitConfigWC.appId);
        }
        ae.i("MicroMsg.AppBrandTaskManager", "startApp appId[%s] type[%d] scene[%d] strategy[%d] targetProcessExists[%b] targetTask[%s]", new Object[] { paramAppBrandInitConfigWC.appId, Integer.valueOf(paramAppBrandInitConfigWC.dQv), Integer.valueOf(paramAppBrandStatObject.scene), Integer.valueOf(i), Boolean.valueOf(paramAppBrandInitConfigWC.kaQ), ((i)localObject1).mDv });
        AppMethodBeat.o(48441);
        return i;
        ((e.a)localObject1).mxB += 1L;
        break;
        label1313:
        l = 0L;
        break label259;
        label1319:
        i = 0;
        break label271;
        label1324:
        bool = false;
        break label434;
        label1330:
        i = 1;
        break label459;
        label1335:
        localObject1 = Vo(paramAppBrandInitConfigWC.appId);
        if ((localObject1 == null) || (localObject1 == mDn))
        {
          if (mDo.containsKey(paramAppBrandInitConfigWC.appId))
          {
            localObject2 = (String)mDo.get(paramAppBrandInitConfigWC.appId);
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject4 = mDl.iterator();
              if (((Iterator)localObject4).hasNext())
              {
                localObject1 = (i)((Iterator)localObject4).next();
                if (!((String)localObject2).equals(((i)localObject1).mDw)) {
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
          if (paramAppBrandInitConfigWC.Ee())
          {
            localObject1 = e.mDf;
            localObject2 = j((e)localObject1);
            if (paramAppBrandInitConfigWC.Ee())
            {
              localObject1 = e.mDf;
              ((i)localObject2).l((e)localObject1);
              i = 1;
              localObject1 = localObject2;
            }
          }
          else
          {
            localObject1 = e.mDe;
            continue;
          }
          localObject1 = e.mDe;
          continue;
        }
        i = 2;
        break label464;
        label1525:
        j = 0;
      }
      catch (Throwable localThrowable1)
      {
        com.tencent.mm.plugin.appbrand.loading.a locala;
        localActivity = null;
        continue;
        ((ab)com.tencent.luggage.a.e.K(ab.class)).a(localActivity, (AppBrandInitConfig)locala.jGE);
        continue;
      }
      label1582:
      break label486;
      label1694:
      label1697:
      Object localObject3 = "";
    }
  }
  
  static i eq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(48460);
    Iterator localIterator = bzA().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if ((locali.mDD.keySet().contains(paramString1)) && (locali.mDu.equals(paramString2)))
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
    a(parame, d.a.mEa);
    AppMethodBeat.o(48445);
  }
  
  public static int g(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(223002);
    int i = d(null, paramAppBrandInitConfigWC, paramAppBrandStatObject);
    AppMethodBeat.o(223002);
    return i;
  }
  
  private static int g(e parame)
  {
    AppMethodBeat.i(223004);
    Iterator localIterator = mDl.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (((i)localIterator.next()).mDF != parame) {
        break label55;
      }
      i += 1;
    }
    label55:
    for (;;)
    {
      break;
      AppMethodBeat.o(223004);
      return i;
    }
  }
  
  private static boolean h(e parame)
  {
    AppMethodBeat.i(48455);
    int i = g(parame);
    if (i > parame.mDh)
    {
      parame = new IllegalStateException(bu.x("TaskManager count the serviceType [%s] in TASK_LIST, count = [%d], but max limit = [%d]", new Object[] { parame.name(), Integer.valueOf(i), Integer.valueOf(parame.mDh) }));
      AppMethodBeat.o(48455);
      throw parame;
    }
    if (i == parame.mDh)
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
    synchronized (mDl)
    {
      if (h(parame))
      {
        ae.i("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess serviceType = [%s] reachedMaxLimit", new Object[] { parame });
        AppMethodBeat.o(48456);
        return null;
      }
      Object localObject = mDl.iterator();
      while (((Iterator)localObject).hasNext())
      {
        locali = (i)((Iterator)localObject).next();
        if ((locali.mDD.isEmpty()) && (locali.mDF == parame))
        {
          ae.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup found empty task[%s], which can be used as [%s]", new Object[] { locali.mDw, parame });
          AppMethodBeat.o(48456);
          return locali;
        }
      }
      i locali = a(mDl, e.mDg);
      if (locali == null)
      {
        localObject = "null";
        ae.i("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess serviceType = [%s] not reached max limit , got ui task = [%s]", new Object[] { parame, localObject });
        AppMethodBeat.o(48456);
        return locali;
      }
      localObject = locali.mDu;
    }
  }
  
  private static i j(e parame)
  {
    AppMethodBeat.i(48457);
    for (;;)
    {
      synchronized (mDl)
      {
        Iterator localIterator = mDl.iterator();
        if (localIterator.hasNext())
        {
          locali = (i)localIterator.next();
          if ((!locali.mDD.isEmpty()) || (locali.mDF != parame)) {
            continue;
          }
          ae.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup found empty task, which can be used as [%s]", new Object[] { parame });
          parame = locali;
          AppMethodBeat.o(48457);
          return parame;
        }
        if (h(parame))
        {
          ae.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup [%s] task reached maxLimit", new Object[] { parame });
          locali = a(mDl, parame);
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
      i locali = a(mDl, e.mDg);
      if (locali != null)
      {
        ae.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup found not used task, which can be used as [%s]", new Object[] { parame });
        parame = locali;
      }
      else
      {
        ae.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup all full for [%s]", new Object[] { parame });
        parame = (i)mDl.getFirst();
      }
    }
  }
  
  public static void onNetworkChange()
  {
    AppMethodBeat.i(48451);
    Iterator localIterator1 = bzA().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((i)localIterator1.next()).mDE.values().iterator();
      while (localIterator2.hasNext())
      {
        AppBrandRemoteTaskController localAppBrandRemoteTaskController = (AppBrandRemoteTaskController)localIterator2.next();
        if (localAppBrandRemoteTaskController != null)
        {
          localAppBrandRemoteTaskController.mCG = AppBrandRemoteTaskController.a.mCY;
          localAppBrandRemoteTaskController.biG();
        }
      }
    }
    AppMethodBeat.o(48451);
  }
  
  public static void vz(int paramInt)
  {
    AppMethodBeat.i(48443);
    Object localObject2;
    Object localObject3;
    if (2 == paramInt)
    {
      localObject1 = new HashMap();
      localObject2 = bzA().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (i)((Iterator)localObject2).next();
        if (!TextUtils.isEmpty(((i)localObject3).mDw)) {
          if (((i)localObject3).mDD.isEmpty())
          {
            localObject3 = ((i)localObject3).mDw;
            Boolean localBoolean = Boolean.TRUE;
            if (Build.VERSION.SDK_INT >= 24) {
              ((HashMap)localObject1).putIfAbsent(localObject3, localBoolean);
            } else if (((HashMap)localObject1).get(localObject3) == null) {
              ((HashMap)localObject1).put(localObject3, localBoolean);
            }
          }
          else
          {
            ((HashMap)localObject1).put(((i)localObject3).mDw, Boolean.FALSE);
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
          ae.i("MicroMsg.AppBrandTaskManager", "killAll SILENT_IF_INACTIVE kill process(%s)", new Object[] { localObject2 });
          com.tencent.mm.modelappbrand.b.CB((String)localObject2);
          com.tencent.mm.bv.a.bY(ak.getContext(), (String)localObject2);
          break;
        }
      }
      ae.i("MicroMsg.AppBrandTaskManager", "killAll SILENT_IF_INACTIVE tryPreloadNextTaskProcess(both waservice and wagame)");
      a(e.mDe, true);
      a(e.mDf, true);
      AppMethodBeat.o(48443);
      return;
    }
    Object localObject1 = bzA().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((i)((Iterator)localObject1).next()).mDE.values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (AppBrandRemoteTaskController)((Iterator)localObject2).next();
        if (localObject3 != null) {
          ((AppBrandRemoteTaskController)localObject3).vx(paramInt);
        }
      }
    }
    localObject1 = mDp.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (AppBrandRemoteTaskController)((Iterator)localObject1).next();
      if (localObject2 != null) {
        ((AppBrandRemoteTaskController)localObject2).vx(paramInt);
      }
    }
    if (3 == paramInt) {
      mDp.clear();
    }
    AppMethodBeat.o(48443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.f
 * JD-Core Version:    0.7.0.1
 */