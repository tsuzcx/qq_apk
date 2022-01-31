package com.tencent.mm.plugin.appbrand.task;

import android.app.Activity;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService1;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService2;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService3;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService4;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.f.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI1;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI2;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI3;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI4;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class g
{
  private static final LinkedList<i> hbZ;
  private static final LinkedList<i> hca;
  private static final i hcb;
  private static final i hcc;
  
  static
  {
    if (!g.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      LinkedList localLinkedList = new LinkedList();
      hbZ = localLinkedList;
      localLinkedList.add(new i(AppBrandUI.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class));
      hbZ.add(new i(AppBrandUI1.class, AppBrandTaskPreloadReceiver1.class, AppBrandKeepAliveService1.class));
      hbZ.add(new i(AppBrandUI2.class, AppBrandTaskPreloadReceiver2.class, AppBrandKeepAliveService2.class));
      hbZ.add(new i(AppBrandUI3.class, AppBrandTaskPreloadReceiver3.class, AppBrandKeepAliveService3.class));
      hbZ.add(new i(AppBrandUI4.class, AppBrandTaskPreloadReceiver4.class, AppBrandKeepAliveService4.class));
      hcb = new c();
      hcc = new b();
      localLinkedList = new LinkedList();
      hca = localLinkedList;
      localLinkedList.addAll(hbZ);
      hca.add(hcb);
      hca.add(hcc);
      return;
    }
  }
  
  static i a(g.a parama)
  {
    Iterator localIterator = aoM().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (parama.a(locali)) {
        return locali;
      }
    }
    return null;
  }
  
  private static i a(List<i> paramList, f paramf)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      i locali = (i)paramList.next();
      if (locali.hcj == paramf) {
        return locali;
      }
    }
    return null;
  }
  
  public static void aZ(String paramString, int paramInt)
  {
    i locali = wp(paramString);
    if (locali == null) {}
    while ((locali.ws(paramString).intValue() != paramInt) || (locali.wt(paramString) == null)) {
      return;
    }
    locali.wt(paramString).wl(paramString);
  }
  
  private static LinkedList<i> aoM()
  {
    synchronized (hca)
    {
      LinkedList localLinkedList2 = new LinkedList(hca);
      return localLinkedList2;
    }
  }
  
  public static int b(Context paramContext, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    Object localObject3 = com.tencent.mm.plugin.appbrand.report.model.f.gYu;
    Object localObject2 = paramAppBrandInitConfigWC.appId;
    int j = paramAppBrandInitConfigWC.cau;
    boolean bool = ba((String)localObject2, -1);
    Object localObject1 = (f.a)((com.tencent.mm.plugin.appbrand.report.model.f)localObject3).gYv.get(localObject2);
    long l;
    label99:
    int i;
    if (localObject1 == null)
    {
      localObject1 = new f.a((byte)0);
      ((f.a)localObject1).gYy = 1L;
      ((com.tencent.mm.plugin.appbrand.report.model.f)localObject3).gYv.put(localObject2, localObject1);
      if (((f.a)localObject1).gYx <= 0L) {
        break label354;
      }
      l = bk.UY() - ((f.a)localObject1).gYx;
      localObject3 = h.nFQ;
      if (!bool) {
        break label360;
      }
      i = 1;
      label111:
      ((h)localObject3).f(16064, new Object[] { Integer.valueOf(1), localObject2, Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(((f.a)localObject1).gYy), Long.valueOf(l) });
      if (!paramAppBrandInitConfigWC.fPs) {
        break label365;
      }
      localObject1 = hcb;
      i = 1;
      label184:
      ((i)localObject1).a(paramAppBrandInitConfigWC.appId, paramAppBrandInitConfigWC.fEL, null);
      if (paramContext != null) {
        break label483;
      }
      paramContext = ae.getContext();
    }
    label354:
    label483:
    for (;;)
    {
      localObject2 = new Intent(paramContext, ((i)localObject1).hcf);
      ((Intent)localObject2).putExtra("key_appbrand_init_config", paramAppBrandInitConfigWC);
      ((Intent)localObject2).putExtra("key_appbrand_stat_object", paramAppBrandStatObject);
      ((Intent)localObject2).addFlags(268435456);
      if ((paramContext instanceof Activity))
      {
        paramAppBrandStatObject = bk.al(paramContext, ((Activity)paramContext).getTaskId());
        if ((paramAppBrandStatObject != null) && (paramAppBrandStatObject.baseActivity != null) && (bk.pm(paramAppBrandStatObject.baseActivity.getClassName()).equals(((i)localObject1).hce)))
        {
          ((Intent)localObject2).putExtra("key_appbrand_bring_ui_to_front_from_task_Base_by_task_top_ui", true);
          ((Intent)localObject2).addFlags(603979776);
        }
      }
      paramContext.startActivity((Intent)localObject2);
      if (i == 1) {
        wm(paramAppBrandInitConfigWC.appId);
      }
      return i;
      ((f.a)localObject1).gYy += 1L;
      break;
      l = 0L;
      break label99;
      label360:
      i = 0;
      break label111;
      label365:
      localObject1 = wp(paramAppBrandInitConfigWC.appId);
      if ((localObject1 == null) || (localObject1 == hcb) || ((localObject1 instanceof a)))
      {
        if (paramAppBrandInitConfigWC.fPy)
        {
          localObject1 = hcc;
          b((i)localObject1);
          i = 1;
          break label184;
        }
        if (paramAppBrandInitConfigWC.ZH())
        {
          localObject1 = f.hbV;
          localObject2 = e((f)localObject1);
          if (!paramAppBrandInitConfigWC.ZH()) {
            break label470;
          }
        }
        for (localObject1 = f.hbV;; localObject1 = f.hbU)
        {
          ((i)localObject2).f((f)localObject1);
          localObject1 = localObject2;
          break;
          localObject1 = f.hbU;
          break label429;
        }
      }
      i = 2;
      break label184;
    }
  }
  
  public static void b(f paramf)
  {
    if (!com.tencent.mm.plugin.appbrand.appusage.i.acO()) {}
    i locali;
    do
    {
      return;
      if (paramf == f.hbW) {
        throw new IllegalStateException("serviceType == nil");
      }
      y.i("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess serviceType = [%s]", new Object[] { paramf });
      locali = d(paramf);
    } while (locali == null);
    locali.f(paramf);
    locali.EV();
  }
  
  static void b(i parami)
  {
    synchronized (hca)
    {
      hca.remove(parami);
      hca.addLast(parami);
    }
    synchronized (hbZ)
    {
      if (hbZ.contains(parami))
      {
        hbZ.remove(parami);
        hbZ.addLast(parami);
      }
      return;
      parami = finally;
      throw parami;
    }
  }
  
  public static boolean ba(String paramString, int paramInt)
  {
    i locali = wp(paramString);
    if ((locali != null) && ((paramInt < 0) || (bk.a(locali.ws(paramString), -1) == paramInt)) && (locali.wt(paramString) != null))
    {
      paramString = locali.wt(paramString);
      paramString.hbB = AppBrandRemoteTaskController.a.hbO;
      if (paramString.ahI()) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean c(f paramf)
  {
    boolean bool = false;
    Iterator localIterator = hbZ.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (((i)localIterator.next()).hcj != paramf) {
        break label105;
      }
      i += 1;
    }
    label105:
    for (;;)
    {
      break;
      if (i > paramf.hbX) {
        throw new IllegalStateException(bk.q("TaskManager count the serviceType [%s] in TASK_LIST, count = [%d], but max limit = [%d]", new Object[] { paramf.name(), Integer.valueOf(i), Integer.valueOf(paramf.hbX) }));
      }
      if (i == paramf.hbX) {
        bool = true;
      }
      return bool;
    }
  }
  
  static i cc(String paramString1, String paramString2)
  {
    Iterator localIterator = aoM().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if ((locali.hch.keySet().contains(paramString1)) && (locali.hce.equals(paramString2))) {
        return locali;
      }
    }
    return null;
  }
  
  private static i d(f paramf)
  {
    synchronized (hbZ)
    {
      if (c(paramf))
      {
        y.i("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess serviceType = [%s] reachedMaxLimit", new Object[] { paramf });
        return null;
      }
      localObject = hbZ.iterator();
      while (((Iterator)localObject).hasNext())
      {
        locali = (i)((Iterator)localObject).next();
        if ((locali.hch.isEmpty()) && (locali.hcj == paramf))
        {
          y.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup found empty task, which can be used as [%s]", new Object[] { paramf });
          return locali;
        }
      }
    }
    i locali = a(hbZ, f.hbW);
    if (locali == null) {}
    for (Object localObject = "null";; localObject = locali.hce)
    {
      y.i("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess serviceType = [%s] not reached max limit , got ui task = [%s]", new Object[] { paramf, localObject });
      return locali;
    }
  }
  
  private static i e(f paramf)
  {
    for (;;)
    {
      synchronized (hbZ)
      {
        Iterator localIterator = hbZ.iterator();
        if (localIterator.hasNext())
        {
          locali = (i)localIterator.next();
          if ((!locali.hch.isEmpty()) || (locali.hcj != paramf)) {
            continue;
          }
          y.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup found empty task, which can be used as [%s]", new Object[] { paramf });
          paramf = locali;
          return paramf;
        }
        if (c(paramf))
        {
          y.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup [%s] task reached maxLimit", new Object[] { paramf });
          locali = a(hbZ, paramf);
          paramf = locali;
          if ($assertionsDisabled) {
            continue;
          }
          paramf = locali;
          if (locali != null) {
            continue;
          }
          throw new AssertionError();
        }
      }
      i locali = a(hbZ, f.hbW);
      if (locali != null)
      {
        y.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup found not used task, which can be used as [%s]", new Object[] { paramf });
        paramf = locali;
      }
      else
      {
        y.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup all full for [%s]", new Object[] { paramf });
        paramf = (i)hbZ.getFirst();
      }
    }
  }
  
  public static void mo(int paramInt)
  {
    if (2 == paramInt)
    {
      localIterator = aoM().iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).aoC();
      }
      y.i("MicroMsg.AppBrandTaskManager", "killAll SILENT_IF_INACTIVE tryPreloadNextTaskProcess(both waservice and wagame)");
      b(f.hbU);
      b(f.hbV);
      return;
    }
    Iterator localIterator = aoM().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (i)localIterator.next();
      ((i)localObject).aoC();
      localObject = ((i)localObject).hci.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        AppBrandRemoteTaskController localAppBrandRemoteTaskController = (AppBrandRemoteTaskController)((Iterator)localObject).next();
        if (localAppBrandRemoteTaskController != null)
        {
          localAppBrandRemoteTaskController.hbB = AppBrandRemoteTaskController.a.hbL;
          localAppBrandRemoteTaskController.hbC = paramInt;
          localAppBrandRemoteTaskController.ahI();
        }
      }
    }
  }
  
  public static void onNetworkChange()
  {
    Iterator localIterator1 = aoM().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((i)localIterator1.next()).hci.values().iterator();
      while (localIterator2.hasNext())
      {
        AppBrandRemoteTaskController localAppBrandRemoteTaskController = (AppBrandRemoteTaskController)localIterator2.next();
        if (localAppBrandRemoteTaskController != null)
        {
          localAppBrandRemoteTaskController.hbB = AppBrandRemoteTaskController.a.hbP;
          localAppBrandRemoteTaskController.ahI();
        }
      }
    }
  }
  
  static void wi(String arg0)
  {
    i locali = wp(???);
    if (locali != null)
    {
      locali.wi(???);
      if (locali.hch.keySet().isEmpty())
      {
        if ((locali instanceof a)) {
          synchronized (hca)
          {
            hca.remove(locali);
            return;
          }
        }
        synchronized (hca)
        {
          hca.remove(localObject1);
          hca.addFirst(localObject1);
          synchronized (hbZ)
          {
            if (hbZ.contains(localObject1))
            {
              hbZ.remove(localObject1);
              hbZ.addFirst(localObject1);
            }
            return;
          }
        }
      }
    }
  }
  
  public static void wm(String paramString)
  {
    i locali = wp(paramString);
    if ((locali != null) && (locali.wt(paramString) != null)) {
      locali.wt(paramString).wl(paramString);
    }
  }
  
  public static void wn(String paramString)
  {
    paramString = wq(paramString);
    if (paramString == null) {
      return;
    }
    ai.l(new Runnable()
    {
      public final void run()
      {
        this.hcd.EV();
      }
    }, 500L);
  }
  
  public static Class wo(String paramString)
  {
    int i = 0;
    while (i < hca.size())
    {
      i locali = (i)hca.get(i);
      if (locali.hce.equals(paramString)) {
        return locali.gIM;
      }
      i += 1;
    }
    return null;
  }
  
  private static i wp(String paramString)
  {
    Iterator localIterator = aoM().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (locali.hch.keySet().contains(paramString)) {
        return locali;
      }
    }
    return null;
  }
  
  static i wq(String paramString)
  {
    Iterator localIterator = aoM().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (locali.hce.equals(paramString)) {
        return locali;
      }
    }
    Assert.assertTrue(true);
    return null;
  }
  
  public static boolean wr(String paramString)
  {
    return ba(paramString, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.g
 * JD-Core Version:    0.7.0.1
 */