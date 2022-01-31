package com.tencent.mm.plugin.appbrand.task;

import android.app.Activity;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService1;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService2;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService3;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService4;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.e;
import com.tencent.mm.plugin.appbrand.report.model.e.a;
import com.tencent.mm.plugin.appbrand.task.a.a.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI1;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI2;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI3;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI4;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import junit.framework.Assert;

public class h
{
  private static final LinkedList<j> iKX;
  private static final LinkedList<j> iKY;
  private static final j iKZ;
  private static final j iLa;
  private static final j iLb;
  private static final ConcurrentHashMap<String, String> iLc;
  private static final ConcurrentSkipListSet<AppBrandRemoteTaskController> iLd;
  
  static
  {
    AppMethodBeat.i(132872);
    if (!h.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      iLc = new ConcurrentHashMap();
      iLd = new ConcurrentSkipListSet(new h.1());
      LinkedList localLinkedList = new LinkedList();
      iKX = localLinkedList;
      localLinkedList.add(new j(AppBrandUI.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class));
      iKX.add(new j(AppBrandUI1.class, AppBrandTaskPreloadReceiver1.class, AppBrandKeepAliveService1.class));
      iKX.add(new j(AppBrandUI2.class, AppBrandTaskPreloadReceiver2.class, AppBrandKeepAliveService2.class));
      iKX.add(new j(AppBrandUI3.class, AppBrandTaskPreloadReceiver3.class, AppBrandKeepAliveService3.class));
      iKX.add(new j(AppBrandUI4.class, AppBrandTaskPreloadReceiver4.class, AppBrandKeepAliveService4.class));
      iKZ = new d();
      iLa = new c();
      iLb = new k();
      localLinkedList = new LinkedList();
      iKY = localLinkedList;
      localLinkedList.addAll(iKX);
      iKY.add(iKZ);
      iKY.add(iLa);
      iKY.add(iLb);
      AppMethodBeat.o(132872);
      return;
    }
  }
  
  static void EN(String arg0)
  {
    AppMethodBeat.i(132870);
    j localj = EX(???);
    if (localj != null)
    {
      localj.EN(???);
      if (localj.iLj.keySet().isEmpty())
      {
        if ((localj instanceof a)) {
          synchronized (iKY)
          {
            iKY.remove(localj);
            AppMethodBeat.o(132870);
            return;
          }
        }
        synchronized (iKY)
        {
          iKY.remove(localObject1);
          iKY.addFirst(localObject1);
        }
        synchronized (iKX)
        {
          if (iKX.contains(localObject1))
          {
            iKX.remove(localObject1);
            iKX.addFirst(localObject1);
          }
          AppMethodBeat.o(132870);
          return;
          localObject2 = finally;
          AppMethodBeat.o(132870);
          throw localObject2;
        }
      }
    }
    AppMethodBeat.o(132870);
  }
  
  public static void EU(String paramString)
  {
    AppMethodBeat.i(132852);
    j localj = EX(paramString);
    if ((localj != null) && (localj.Fc(paramString) != null)) {
      localj.Fc(paramString).ES(paramString);
    }
    bs(paramString, -1);
    AppMethodBeat.o(132852);
  }
  
  public static void EV(String paramString)
  {
    AppMethodBeat.i(132855);
    paramString = EY(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(132855);
      return;
    }
    al.p(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143579);
        this.iLe.Do();
        AppMethodBeat.o(143579);
      }
    }, 500L);
    AppMethodBeat.o(132855);
  }
  
  public static Class EW(String paramString)
  {
    AppMethodBeat.i(132857);
    int i = 0;
    while (i < iKY.size())
    {
      j localj = (j)iKY.get(i);
      if (localj.iLf.equals(paramString))
      {
        paramString = localj.ijw;
        AppMethodBeat.o(132857);
        return paramString;
      }
      i += 1;
    }
    AppMethodBeat.o(132857);
    return null;
  }
  
  private static j EX(String paramString)
  {
    AppMethodBeat.i(132862);
    Iterator localIterator = aLU().iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      if (localj.iLj.keySet().contains(paramString))
      {
        AppMethodBeat.o(132862);
        return localj;
      }
    }
    AppMethodBeat.o(132862);
    return null;
  }
  
  static j EY(String paramString)
  {
    AppMethodBeat.i(132863);
    Iterator localIterator = aLU().iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      if (localj.iLf.equals(paramString))
      {
        AppMethodBeat.o(132863);
        return localj;
      }
    }
    Assert.assertTrue(true);
    AppMethodBeat.o(132863);
    return null;
  }
  
  public static boolean EZ(String paramString)
  {
    AppMethodBeat.i(156896);
    boolean bool = bv(paramString, -1);
    AppMethodBeat.o(156896);
    return bool;
  }
  
  static j a(h.a parama)
  {
    AppMethodBeat.i(132864);
    Iterator localIterator = aLU().iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      if (parama.a(localj))
      {
        AppMethodBeat.o(132864);
        return localj;
      }
    }
    AppMethodBeat.o(132864);
    return null;
  }
  
  private static j a(List<j> paramList, g paramg)
  {
    AppMethodBeat.i(132858);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      j localj = (j)paramList.next();
      if (localj.iLl == paramg)
      {
        AppMethodBeat.o(132858);
        return localj;
      }
    }
    AppMethodBeat.o(132858);
    return null;
  }
  
  static void a(g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(132854);
    if (!i.awU())
    {
      AppMethodBeat.o(132854);
      return;
    }
    if (paramg == g.iKU)
    {
      AppMethodBeat.o(132854);
      return;
    }
    if ((!paramBoolean) && (com.tencent.mm.plugin.appbrand.task.a.a.a(a.a.g(paramg))))
    {
      ab.w("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess %s, hit interval limit", new Object[] { paramg });
      if (paramg == g.iKS)
      {
        com.tencent.mm.plugin.report.service.h.qsU.cT(915, 22);
        AppMethodBeat.o(132854);
        return;
      }
      if (paramg == g.iKT) {
        com.tencent.mm.plugin.report.service.h.qsU.cT(915, 23);
      }
      AppMethodBeat.o(132854);
      return;
    }
    ab.i("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess serviceType = [%s]", new Object[] { paramg });
    j localj = d(paramg);
    if (localj != null)
    {
      localj.f(paramg);
      localj.Do();
    }
    AppMethodBeat.o(132854);
  }
  
  public static void a(String paramString, AppBrandRemoteTaskController paramAppBrandRemoteTaskController)
  {
    AppMethodBeat.i(143581);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(143581);
      return;
    }
    iLc.remove(paramString);
    if (paramAppBrandRemoteTaskController != null) {
      iLd.remove(paramAppBrandRemoteTaskController);
    }
    AppMethodBeat.o(143581);
  }
  
  public static void a(String paramString1, String paramString2, AppBrandRemoteTaskController paramAppBrandRemoteTaskController)
  {
    AppMethodBeat.i(143580);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(143580);
      return;
    }
    iLc.put(paramString1, paramString2);
    if (paramAppBrandRemoteTaskController != null) {
      iLd.add(paramAppBrandRemoteTaskController);
    }
    AppMethodBeat.o(143580);
  }
  
  private static boolean a(AppBrandInitConfigWC paramAppBrandInitConfigWC, String paramString)
  {
    AppMethodBeat.i(143583);
    if (iLc.containsKey(paramAppBrandInitConfigWC.appId))
    {
      paramAppBrandInitConfigWC = (String)iLc.get(paramAppBrandInitConfigWC.appId);
      if (TextUtils.isEmpty(paramAppBrandInitConfigWC))
      {
        AppMethodBeat.o(143583);
        return false;
      }
      boolean bool = paramAppBrandInitConfigWC.equals(paramString);
      AppMethodBeat.o(143583);
      return bool;
    }
    AppMethodBeat.o(143583);
    return false;
  }
  
  public static void aLT()
  {
    AppMethodBeat.i(143585);
    boolean bool = com.tencent.mm.plugin.appbrand.task.a.a.a(a.a.iLq);
    ab.i("MicroMsg.AppBrandTaskManager", "preloadPluginUIProcess, hitLimit[%b]", new Object[] { Boolean.valueOf(bool) });
    if (!bool) {
      iKZ.Do();
    }
    AppMethodBeat.o(143585);
  }
  
  private static LinkedList<j> aLU()
  {
    AppMethodBeat.i(132869);
    synchronized (iKY)
    {
      LinkedList localLinkedList2 = new LinkedList(iKY);
      AppMethodBeat.o(132869);
      return localLinkedList2;
    }
  }
  
  public static void b(g paramg)
  {
    AppMethodBeat.i(156895);
    a(paramg, false);
    AppMethodBeat.o(156895);
  }
  
  static void b(j paramj)
  {
    AppMethodBeat.i(132871);
    synchronized (iKY)
    {
      iKY.remove(paramj);
      iKY.addLast(paramj);
    }
    synchronized (iKX)
    {
      if (iKX.contains(paramj))
      {
        iKX.remove(paramj);
        iKX.addLast(paramj);
      }
      AppMethodBeat.o(132871);
      return;
      paramj = finally;
      AppMethodBeat.o(132871);
      throw paramj;
    }
  }
  
  private static void bs(String paramString, int paramInt)
  {
    AppMethodBeat.i(143582);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(143582);
      return;
    }
    Object localObject = iLd.iterator();
    LinkedList localLinkedList = new LinkedList();
    while (((Iterator)localObject).hasNext())
    {
      AppBrandRemoteTaskController localAppBrandRemoteTaskController = (AppBrandRemoteTaskController)((Iterator)localObject).next();
      if ((paramString.equals(localAppBrandRemoteTaskController.mAppId)) && ((paramInt == localAppBrandRemoteTaskController.ikk) || (paramInt < 0)))
      {
        localAppBrandRemoteTaskController.ES(paramString);
        localLinkedList.add(localAppBrandRemoteTaskController);
      }
    }
    paramString = localLinkedList.iterator();
    while (paramString.hasNext())
    {
      localObject = (AppBrandRemoteTaskController)paramString.next();
      iLd.remove(localObject);
    }
    AppMethodBeat.o(143582);
  }
  
  public static void bt(String paramString, int paramInt)
  {
    AppMethodBeat.i(132850);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(132850);
      return;
    }
    j localj = EX(paramString);
    if (localj == null)
    {
      bs(paramString, paramInt);
      AppMethodBeat.o(132850);
      return;
    }
    if ((localj.Fb(paramString).intValue() == paramInt) && (localj.Fc(paramString) != null)) {
      localj.Fc(paramString).ES(paramString);
    }
    AppMethodBeat.o(132850);
  }
  
  private static AppBrandRemoteTaskController bu(String paramString, int paramInt)
  {
    AppMethodBeat.i(154859);
    paramString = (AppBrandRemoteTaskController)new h.3(paramString, paramInt).apply(null);
    if ((paramString != null) && (paramString.aLQ()))
    {
      AppMethodBeat.o(154859);
      return paramString;
    }
    AppMethodBeat.o(154859);
    return null;
  }
  
  public static boolean bv(String paramString, int paramInt)
  {
    AppMethodBeat.i(132866);
    if (bu(paramString, paramInt) != null)
    {
      AppMethodBeat.o(132866);
      return true;
    }
    AppMethodBeat.o(132866);
    return false;
  }
  
  public static String bw(String paramString, int paramInt)
  {
    AppMethodBeat.i(132868);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(132868);
      return null;
    }
    try
    {
      paramString = bu(paramString, paramInt);
      if (paramString != null)
      {
        paramString = paramString.iKA;
        AppMethodBeat.o(132868);
        return paramString;
      }
    }
    catch (NullPointerException paramString)
    {
      if (f.IS_FLAVOR_RED)
      {
        AppMethodBeat.o(132868);
        throw paramString;
      }
      ab.printErrStackTrace("MicroMsg.AppBrandTaskManager", paramString, "[NOT CRASH]getAliveInstanceId", new Object[0]);
      AppMethodBeat.o(132868);
    }
    return null;
  }
  
  private static boolean c(g paramg)
  {
    AppMethodBeat.i(132859);
    Iterator localIterator = iKX.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (((j)localIterator.next()).iLl != paramg) {
        break label129;
      }
      i += 1;
    }
    label129:
    for (;;)
    {
      break;
      if (i > paramg.iKV)
      {
        paramg = new IllegalStateException(bo.p("TaskManager count the serviceType [%s] in TASK_LIST, count = [%d], but max limit = [%d]", new Object[] { paramg.name(), Integer.valueOf(i), Integer.valueOf(paramg.iKV) }));
        AppMethodBeat.o(132859);
        throw paramg;
      }
      if (i == paramg.iKV)
      {
        AppMethodBeat.o(132859);
        return true;
      }
      AppMethodBeat.o(132859);
      return false;
    }
  }
  
  static j cS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(132865);
    Iterator localIterator = aLU().iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      if ((localj.iLj.keySet().contains(paramString1)) && (localj.iLf.equals(paramString2)))
      {
        AppMethodBeat.o(132865);
        return localj;
      }
    }
    AppMethodBeat.o(132865);
    return null;
  }
  
  public static int d(Context paramContext, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(132849);
    if ((!TextUtils.isEmpty(paramAppBrandStatObject.cmF)) && (paramAppBrandStatObject.cmF.length() >= 1024))
    {
      ab.i("MicroMsg.AppBrandTaskManager", "startApp, appId[%s], scene[%d], preScene[%d], sceneNote too long, strip it", new Object[] { paramAppBrandInitConfigWC.appId, Integer.valueOf(paramAppBrandStatObject.scene), Integer.valueOf(paramAppBrandStatObject.cJb) });
      paramAppBrandStatObject.cmF = paramAppBrandStatObject.cmF.substring(0, 1024);
    }
    if ((!TextUtils.isEmpty(paramAppBrandStatObject.cJc)) && (paramAppBrandStatObject.cJc.length() >= 1024))
    {
      ab.i("MicroMsg.AppBrandTaskManager", "startApp, appId[%s], scene[%d], preScene[%d], preSceneNote too long, strip it", new Object[] { paramAppBrandInitConfigWC.appId, Integer.valueOf(paramAppBrandStatObject.scene), Integer.valueOf(paramAppBrandStatObject.cJb) });
      paramAppBrandStatObject.cJc = paramAppBrandStatObject.cJc.substring(0, 1024);
    }
    Object localObject3 = e.iGL;
    Object localObject2 = paramAppBrandInitConfigWC.appId;
    int j = paramAppBrandInitConfigWC.bDc;
    boolean bool = bv((String)localObject2, -1);
    Object localObject1 = (e.a)((e)localObject3).iGM.get(localObject2);
    long l;
    label261:
    int i;
    if (localObject1 == null)
    {
      localObject1 = new e.a((byte)0);
      ((e.a)localObject1).iGP = 1L;
      ((e)localObject3).iGM.put(localObject2, localObject1);
      if (((e.a)localObject1).iGO <= 0L) {
        break label690;
      }
      l = bo.aoy() - ((e.a)localObject1).iGO;
      localObject3 = com.tencent.mm.plugin.report.service.h.qsU;
      if (!bool) {
        break label696;
      }
      i = 1;
      label273:
      ((com.tencent.mm.plugin.report.service.h)localObject3).e(16064, new Object[] { Integer.valueOf(1), localObject2, Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(((e.a)localObject1).iGP), Long.valueOf(l) });
      if (!"wxfe02ecfe70800f46".equalsIgnoreCase(paramAppBrandInitConfigWC.appId)) {
        break label706;
      }
      localObject1 = iLb;
      if (!a(paramAppBrandInitConfigWC, iLb.iLh)) {
        break label701;
      }
      a(paramAppBrandInitConfigWC.appId, bu(paramAppBrandInitConfigWC.appId, paramAppBrandInitConfigWC.gXd));
      label381:
      i = 2;
      label383:
      ((j)localObject1).a(paramAppBrandInitConfigWC.appId, paramAppBrandInitConfigWC.gXd, null);
      if (paramContext != null) {
        break label975;
      }
      paramContext = ah.getContext();
    }
    label690:
    label696:
    label701:
    label706:
    label975:
    for (;;)
    {
      localObject2 = new Intent(paramContext, ((j)localObject1).iLg);
      ((Intent)localObject2).putExtra("key_appbrand_init_config", paramAppBrandInitConfigWC);
      ((Intent)localObject2).putExtra("key_appbrand_stat_object", paramAppBrandStatObject);
      if ((com.tencent.mm.plugin.appbrand.t.a.af(((j)localObject1).iLg)) || (!(paramContext instanceof Activity))) {}
      for (j = 268435456;; j = 0)
      {
        ((Intent)localObject2).addFlags(j);
        if ((paramContext instanceof Activity))
        {
          localObject3 = bo.ay(paramContext, ((Activity)paramContext).getTaskId());
          if ((localObject3 != null) && (((ActivityManager.RunningTaskInfo)localObject3).baseActivity != null) && (bo.nullAsNil(((ActivityManager.RunningTaskInfo)localObject3).baseActivity.getClassName()).equals(((j)localObject1).iLf)))
          {
            ((Intent)localObject2).putExtra("key_appbrand_bring_ui_to_front_from_task_Base_by_task_top_ui", true);
            ((Intent)localObject2).addFlags(603979776);
          }
          ((Intent)localObject2).putExtra("key_from_activity_requested_orientation", ((Activity)paramContext).getRequestedOrientation());
        }
        paramAppBrandInitConfigWC.hiE = bo.aoy();
        paramAppBrandInitConfigWC.hiH = ah.apj(((j)localObject1).iLh);
        ((Intent)localObject2).putExtra("key_launch_app_client_version", f.ymG);
        paramContext.startActivity((Intent)localObject2);
        if (i == 1) {
          EU(paramAppBrandInitConfigWC.appId);
        }
        ab.i("MicroMsg.AppBrandTaskManager", "startApp appId[%s] type[%d] scene[%d] strategy[%d] targetProcessExists[%b]", new Object[] { paramAppBrandInitConfigWC.appId, Integer.valueOf(paramAppBrandInitConfigWC.gXd), Integer.valueOf(paramAppBrandStatObject.scene), Integer.valueOf(i), Boolean.valueOf(paramAppBrandInitConfigWC.hiH) });
        AppMethodBeat.o(132849);
        return i;
        ((e.a)localObject1).iGP += 1L;
        break;
        l = 0L;
        break label261;
        i = 0;
        break label273;
        i = 1;
        break label383;
        if (paramAppBrandInitConfigWC.hiD)
        {
          localObject1 = iKZ;
          if (a(paramAppBrandInitConfigWC, iKZ.iLh))
          {
            a(paramAppBrandInitConfigWC.appId, bu(paramAppBrandInitConfigWC.appId, paramAppBrandInitConfigWC.gXd));
            break label381;
          }
          i = 1;
          break label383;
        }
        localObject2 = EX(paramAppBrandInitConfigWC.appId);
        if ((localObject2 != null) && (localObject2 != iKZ))
        {
          localObject1 = localObject2;
          if (!(localObject2 instanceof a)) {
            break label381;
          }
        }
        if (iLc.containsKey(paramAppBrandInitConfigWC.appId))
        {
          localObject2 = (String)iLc.get(paramAppBrandInitConfigWC.appId);
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject3 = iKX.iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject1 = (j)((Iterator)localObject3).next();
              if (((String)localObject2).equals(((j)localObject1).iLh)) {
                label870:
                if (localObject1 == null) {
                  break label891;
                }
              }
            }
          }
        }
        for (i = 2;; i = 1)
        {
          b((j)localObject1);
          break;
          localObject1 = null;
          break label870;
          label891:
          if (!paramAppBrandInitConfigWC.hiC) {
            break label908;
          }
          localObject1 = iLa;
        }
        if (paramAppBrandInitConfigWC.vY())
        {
          localObject1 = g.iKT;
          localObject2 = e((g)localObject1);
          if (!paramAppBrandInitConfigWC.vY()) {
            break label961;
          }
        }
        for (localObject1 = g.iKT;; localObject1 = g.iKS)
        {
          ((j)localObject2).f((g)localObject1);
          localObject1 = localObject2;
          break;
          localObject1 = g.iKS;
          break label920;
        }
      }
    }
  }
  
  private static j d(g paramg)
  {
    AppMethodBeat.i(132860);
    synchronized (iKX)
    {
      if (c(paramg))
      {
        ab.i("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess serviceType = [%s] reachedMaxLimit", new Object[] { paramg });
        AppMethodBeat.o(132860);
        return null;
      }
      Object localObject = iKX.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localj = (j)((Iterator)localObject).next();
        if ((localj.iLj.isEmpty()) && (localj.iLl == paramg))
        {
          ab.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup found empty task, which can be used as [%s]", new Object[] { paramg });
          AppMethodBeat.o(132860);
          return localj;
        }
      }
      j localj = a(iKX, g.iKU);
      if (localj == null)
      {
        localObject = "null";
        ab.i("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess serviceType = [%s] not reached max limit , got ui task = [%s]", new Object[] { paramg, localObject });
        AppMethodBeat.o(132860);
        return localj;
      }
      localObject = localj.iLf;
    }
  }
  
  private static j e(g paramg)
  {
    AppMethodBeat.i(132861);
    for (;;)
    {
      synchronized (iKX)
      {
        Iterator localIterator = iKX.iterator();
        if (localIterator.hasNext())
        {
          localj = (j)localIterator.next();
          if ((!localj.iLj.isEmpty()) || (localj.iLl != paramg)) {
            continue;
          }
          ab.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup found empty task, which can be used as [%s]", new Object[] { paramg });
          paramg = localj;
          AppMethodBeat.o(132861);
          return paramg;
        }
        if (c(paramg))
        {
          ab.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup [%s] task reached maxLimit", new Object[] { paramg });
          localj = a(iKX, paramg);
          paramg = localj;
          if ($assertionsDisabled) {
            continue;
          }
          paramg = localj;
          if (localj != null) {
            continue;
          }
          paramg = new AssertionError();
          AppMethodBeat.o(132861);
          throw paramg;
        }
      }
      j localj = a(iKX, g.iKU);
      if (localj != null)
      {
        ab.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup found not used task, which can be used as [%s]", new Object[] { paramg });
        paramg = localj;
      }
      else
      {
        ab.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup all full for [%s]", new Object[] { paramg });
        paramg = (j)iKX.getFirst();
      }
    }
  }
  
  public static void onNetworkChange()
  {
    AppMethodBeat.i(132856);
    Iterator localIterator1 = aLU().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((j)localIterator1.next()).iLk.values().iterator();
      while (localIterator2.hasNext())
      {
        AppBrandRemoteTaskController localAppBrandRemoteTaskController = (AppBrandRemoteTaskController)localIterator2.next();
        if (localAppBrandRemoteTaskController != null)
        {
          localAppBrandRemoteTaskController.iKw = AppBrandRemoteTaskController.a.iKN;
          localAppBrandRemoteTaskController.aBp();
        }
      }
    }
    AppMethodBeat.o(132856);
  }
  
  public static void pA(int paramInt)
  {
    AppMethodBeat.i(132851);
    if (2 == paramInt)
    {
      localIterator = aLU().iterator();
      while (localIterator.hasNext()) {
        ((j)localIterator.next()).aLF();
      }
      ab.i("MicroMsg.AppBrandTaskManager", "killAll SILENT_IF_INACTIVE tryPreloadNextTaskProcess(both waservice and wagame)");
      a(g.iKS, false);
      a(g.iKT, false);
      AppMethodBeat.o(132851);
      return;
    }
    Iterator localIterator = aLU().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (j)localIterator.next();
      ((j)localObject).aLF();
      localObject = ((j)localObject).iLk.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        AppBrandRemoteTaskController localAppBrandRemoteTaskController = (AppBrandRemoteTaskController)((Iterator)localObject).next();
        if (localAppBrandRemoteTaskController != null)
        {
          localAppBrandRemoteTaskController.iKw = AppBrandRemoteTaskController.a.iKJ;
          localAppBrandRemoteTaskController.iKx = paramInt;
          localAppBrandRemoteTaskController.aBp();
        }
      }
    }
    AppMethodBeat.o(132851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.h
 * JD-Core Version:    0.7.0.1
 */