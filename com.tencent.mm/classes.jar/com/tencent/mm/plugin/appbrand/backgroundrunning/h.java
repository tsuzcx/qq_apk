package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.app.NotificationManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher.PhoneCallListener;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class h
  implements com.tencent.mm.kernel.c.b, g
{
  private static NotificationManager qSE = null;
  private PhoneStatusWatcher qSA;
  private List<a> qSB;
  private PhoneStatusWatcher.PhoneCallListener qSC;
  private IListener<acn> qSD;
  private LinkedHashMap<String, AppBrandBackgroundRunningApp> qSy;
  private final HashSet<g.a> qSz;
  
  public h()
  {
    AppMethodBeat.i(44795);
    this.qSz = new HashSet();
    this.qSC = new PhoneStatusWatcher.PhoneCallListener()
    {
      public final void onPhoneCall(int paramAnonymousInt)
      {
        AppMethodBeat.i(318141);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(318141);
          return;
          AppMethodBeat.o(318141);
          return;
          Log.i("MicroMsg.MMBackgroundRunningManagerService", "onPhoneCall, kill voip, state:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          h.this.cjP();
          h.this.cjQ();
        }
      }
    };
    this.qSD = new MMBackgroundRunningManagerService.2(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(44795);
  }
  
  private static void b(MMBackgroundRunningOperationParcel paramMMBackgroundRunningOperationParcel)
  {
    AppMethodBeat.i(318163);
    if (!Util.isNullOrNil(paramMMBackgroundRunningOperationParcel.appId))
    {
      Log.i("MicroMsg.MMBackgroundRunningManagerService", "sendOperation from MM process, operation:%s", new Object[] { paramMMBackgroundRunningOperationParcel });
      com.tencent.mm.plugin.appbrand.ipc.f.b(paramMMBackgroundRunningOperationParcel.appId, paramMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(318163);
  }
  
  public final void a(g.a parama)
  {
    AppMethodBeat.i(44800);
    if (parama == null)
    {
      AppMethodBeat.o(44800);
      return;
    }
    synchronized (this.qSz)
    {
      this.qSz.add(parama);
      AppMethodBeat.o(44800);
      return;
    }
  }
  
  public final void b(g.a parama)
  {
    AppMethodBeat.i(44801);
    if (parama == null)
    {
      AppMethodBeat.o(44801);
      return;
    }
    synchronized (this.qSz)
    {
      this.qSz.remove(parama);
      AppMethodBeat.o(44801);
      return;
    }
  }
  
  public final void bbB()
  {
    AppMethodBeat.i(44796);
    Log.i("MicroMsg.MMBackgroundRunningManagerService", "onRegister MMBackgroundRunningManagerService");
    this.qSA = new PhoneStatusWatcher();
    this.qSA.begin(MMApplicationContext.getContext());
    this.qSA.addPhoneCallListener(this.qSC);
    this.qSy = new LinkedHashMap();
    Log.i("MicroMsg.AppBrandForegroundNotificationManager", "startListening");
    if (e.qSw == null) {
      e.qSw = new e.1();
    }
    if (com.tencent.mm.kernel.h.ax(g.class) != null) {
      ((g)com.tencent.mm.kernel.h.ax(g.class)).a(e.qSw);
    }
    Object localObject2;
    if (this.qSB == null)
    {
      this.qSB = new ArrayList();
      localObject1 = i.cJW();
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        localObject2 = localObject1[i];
        this.qSB.add(new a((String)localObject2));
        i += 1;
      }
    }
    Object localObject1 = this.qSB.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (a)((Iterator)localObject1).next();
      j.b(a.a((a)localObject2), (p)localObject2);
    }
    a(com.tencent.mm.plugin.ball.service.c.cYC());
    this.qSD.alive();
    AppMethodBeat.o(44796);
  }
  
  public final void bbC()
  {
    AppMethodBeat.i(44797);
    Log.i("MicroMsg.MMBackgroundRunningManagerService", "onUnregister MMBackgroundRunningManagerService");
    cjP();
    this.qSA.removePhoneCallListener(this.qSC);
    this.qSA.end();
    Log.i("MicroMsg.AppBrandForegroundNotificationManager", "stopListening");
    if (e.qSw != null)
    {
      if (com.tencent.mm.kernel.h.ax(g.class) != null) {
        ((g)com.tencent.mm.kernel.h.ax(g.class)).b(e.qSw);
      }
      e.qSw = null;
    }
    Iterator localIterator = this.qSB.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      j.c(MMApplicationContext.getMainProcessName(), locala);
    }
    this.qSB = null;
    b(com.tencent.mm.plugin.ball.service.c.cYC());
    this.qSD.dead();
    this.qSz.clear();
    try
    {
      this.qSy.clear();
      label147:
      this.qSy = null;
      AppMethodBeat.o(44797);
      return;
    }
    catch (ConcurrentModificationException localConcurrentModificationException)
    {
      break label147;
    }
  }
  
  public final void c(AppBrandBackgroundRunningOperationParcel paramAppBrandBackgroundRunningOperationParcel)
  {
    int j = 0;
    AppMethodBeat.i(44798);
    Object localObject2;
    int i;
    if (paramAppBrandBackgroundRunningOperationParcel != null)
    {
      Log.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation in MM process, operation:%s", new Object[] { paramAppBrandBackgroundRunningOperationParcel });
      ??? = this.qSy;
      if (??? == null)
      {
        Log.e("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation in MM process, operation:%s, mBackgroundRunningApps==null", new Object[] { paramAppBrandBackgroundRunningOperationParcel });
        AppMethodBeat.o(44798);
        return;
      }
      if ((!Util.isNullOrNil(paramAppBrandBackgroundRunningOperationParcel.qSb)) && (paramAppBrandBackgroundRunningOperationParcel.qSb.endsWith(AppBrandPluginUI.class.getSimpleName())))
      {
        Log.w("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, ignore fake native mini program");
        AppMethodBeat.o(44798);
        return;
      }
      Iterator localIterator;
      if (paramAppBrandBackgroundRunningOperationParcel.hAf == 3)
      {
        localObject2 = paramAppBrandBackgroundRunningOperationParcel.mzg;
        if (!Util.isNullOrNil((String)localObject2))
        {
          localIterator = ((LinkedHashMap)???).entrySet().iterator();
          i = 0;
          while (localIterator.hasNext())
          {
            AppBrandBackgroundRunningApp localAppBrandBackgroundRunningApp = (AppBrandBackgroundRunningApp)((Map.Entry)localIterator.next()).getValue();
            if (!((String)localObject2).equalsIgnoreCase(localAppBrandBackgroundRunningApp.mzg)) {
              break label1112;
            }
            if (Util.isNullOrNil(paramAppBrandBackgroundRunningOperationParcel.qSb)) {
              paramAppBrandBackgroundRunningOperationParcel.qSb = localAppBrandBackgroundRunningApp.qSb;
            }
            paramAppBrandBackgroundRunningOperationParcel.cIi |= localAppBrandBackgroundRunningApp.cIi;
            paramAppBrandBackgroundRunningOperationParcel.appId = localAppBrandBackgroundRunningApp.appId;
            paramAppBrandBackgroundRunningOperationParcel.euz = localAppBrandBackgroundRunningApp.euz;
            ((LinkedHashMap)???).remove(localAppBrandBackgroundRunningApp.appId);
            Log.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, operation kill process:%s, app:%s", new Object[] { localObject2, localAppBrandBackgroundRunningApp.appId });
            if (!Util.isNullOrNil(localAppBrandBackgroundRunningApp.qSc))
            {
              Object localObject3 = d.WP(localAppBrandBackgroundRunningApp.qSc);
              if (localObject3 == null)
              {
                Log.w("MicroMsg.MMBackgroundRunningManagerService", "cancelCustomNotificationFallback for %s, customNotificationLogicClass is null", new Object[] { localAppBrandBackgroundRunningApp.appId });
                i = 3;
              }
              else
              {
                w localw = com.tencent.mm.plugin.appbrand.d.Uc(localAppBrandBackgroundRunningApp.appId);
                if (localw == null)
                {
                  Log.w("MicroMsg.MMBackgroundRunningManagerService", "cancelCustomNotificationFallback for %s, runtime is null", new Object[] { localAppBrandBackgroundRunningApp.appId });
                  i = 3;
                }
                else
                {
                  localObject3 = (CustomBackgroundRunningNotificationLogic)localw.aO((Class)localObject3);
                  if (localObject3 == null)
                  {
                    Log.w("MicroMsg.MMBackgroundRunningManagerService", "cancelCustomNotificationFallback for %s, customNotificationLogic is null", new Object[] { localAppBrandBackgroundRunningApp.appId });
                    i = 3;
                  }
                  else
                  {
                    if (qSE == null) {
                      qSE = (NotificationManager)MMApplicationContext.getContext().getSystemService("notification");
                    }
                    qSE.cancel(((CustomBackgroundRunningNotificationLogic)localObject3).cjF());
                  }
                }
              }
            }
            else
            {
              i = 3;
            }
          }
        }
      }
      label946:
      for (;;)
      {
        label434:
        if (i != 0)
        {
          synchronized (this.qSz)
          {
            localObject2 = cjO();
            localIterator = this.qSz.iterator();
            if (!localIterator.hasNext()) {
              break label946;
            }
            ((g.a)localIterator.next()).a((List)localObject2, paramAppBrandBackgroundRunningOperationParcel, i);
          }
          Log.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, operation kill, no process");
          i = j;
          continue;
          localObject2 = (AppBrandBackgroundRunningApp)((LinkedHashMap)???).get(paramAppBrandBackgroundRunningOperationParcel.appId);
          if (localObject2 != null)
          {
            if (paramAppBrandBackgroundRunningOperationParcel.hAf == 1)
            {
              if (!c.fh(((AppBrandBackgroundRunningApp)localObject2).cIi, paramAppBrandBackgroundRunningOperationParcel.cIi))
              {
                ((AppBrandBackgroundRunningApp)localObject2).cIi = c.fi(((AppBrandBackgroundRunningApp)localObject2).cIi, paramAppBrandBackgroundRunningOperationParcel.cIi);
                Log.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, app(%s) add new usage(%s)", new Object[] { paramAppBrandBackgroundRunningOperationParcel.appId, Integer.valueOf(paramAppBrandBackgroundRunningOperationParcel.cIi) });
                i = 2;
              }
              else
              {
                Log.w("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, this app has been added before, but now it wants to add a same usage!!!");
                i = j;
              }
            }
            else
            {
              i = j;
              if (paramAppBrandBackgroundRunningOperationParcel.hAf == 2) {
                if (c.fh(((AppBrandBackgroundRunningApp)localObject2).cIi, paramAppBrandBackgroundRunningOperationParcel.cIi))
                {
                  paramAppBrandBackgroundRunningOperationParcel.euz = ((AppBrandBackgroundRunningApp)localObject2).euz;
                  ((AppBrandBackgroundRunningApp)localObject2).cIi = c.fj(((AppBrandBackgroundRunningApp)localObject2).cIi, paramAppBrandBackgroundRunningOperationParcel.cIi);
                  Log.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, app(%s) remove usage(%s)", new Object[] { paramAppBrandBackgroundRunningOperationParcel.appId, Integer.valueOf(paramAppBrandBackgroundRunningOperationParcel.cIi) });
                  if (((AppBrandBackgroundRunningApp)localObject2).cIi != 0) {
                    break label1107;
                  }
                  if (Util.isNullOrNil(paramAppBrandBackgroundRunningOperationParcel.qSb)) {
                    paramAppBrandBackgroundRunningOperationParcel.qSb = ((AppBrandBackgroundRunningApp)localObject2).qSb;
                  }
                  ((LinkedHashMap)???).remove(paramAppBrandBackgroundRunningOperationParcel.appId);
                  Log.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, app(%s) has been removed", new Object[] { paramAppBrandBackgroundRunningOperationParcel.appId });
                  i = 3;
                }
                else
                {
                  Log.w("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, this app has been added before, but now it wants to remove not added usage!!!");
                  i = j;
                }
              }
            }
          }
          else if (paramAppBrandBackgroundRunningOperationParcel.hAf == 1)
          {
            localObject2 = new AppBrandBackgroundRunningApp();
            ((AppBrandBackgroundRunningApp)localObject2).appId = paramAppBrandBackgroundRunningOperationParcel.appId;
            ((AppBrandBackgroundRunningApp)localObject2).euz = paramAppBrandBackgroundRunningOperationParcel.euz;
            ((AppBrandBackgroundRunningApp)localObject2).cIi = paramAppBrandBackgroundRunningOperationParcel.cIi;
            ((AppBrandBackgroundRunningApp)localObject2).name = paramAppBrandBackgroundRunningOperationParcel.name;
            ((AppBrandBackgroundRunningApp)localObject2).icon = paramAppBrandBackgroundRunningOperationParcel.icon;
            ((AppBrandBackgroundRunningApp)localObject2).username = paramAppBrandBackgroundRunningOperationParcel.username;
            ((AppBrandBackgroundRunningApp)localObject2).qSb = paramAppBrandBackgroundRunningOperationParcel.qSb;
            ((AppBrandBackgroundRunningApp)localObject2).mzg = paramAppBrandBackgroundRunningOperationParcel.mzg;
            ((AppBrandBackgroundRunningApp)localObject2).qSc = paramAppBrandBackgroundRunningOperationParcel.qSc;
            ((LinkedHashMap)???).put(((AppBrandBackgroundRunningApp)localObject2).appId, localObject2);
            Log.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, add app(%s) with usage(%s)", new Object[] { paramAppBrandBackgroundRunningOperationParcel.appId, Integer.valueOf(paramAppBrandBackgroundRunningOperationParcel.cIi) });
            i = 1;
          }
          else
          {
            i = j;
            if (paramAppBrandBackgroundRunningOperationParcel.hAf == 2)
            {
              Log.w("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, this app has not been added before, but now it wants to remove some usage!!!");
              i = j;
              continue;
              if (localObject2 == null) {
                break label1115;
              }
              if (((List)localObject2).isEmpty()) {
                break label1115;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.MMBackgroundRunningManagerService", "report background running app list changed, note:%s", new Object[] { paramAppBrandBackgroundRunningOperationParcel });
      b.a(null, 0, System.currentTimeMillis(), 6, paramAppBrandBackgroundRunningOperationParcel);
      AppMethodBeat.o(44798);
      return;
      paramAppBrandBackgroundRunningOperationParcel = new StringBuilder();
      paramAppBrandBackgroundRunningOperationParcel.append(String.valueOf(((List)localObject2).size())).append("|");
      localObject2 = ((List)localObject2).iterator();
      paramAppBrandBackgroundRunningOperationParcel.append(((AppBrandBackgroundRunningApp)((Iterator)localObject2).next()).appId);
      while (((Iterator)localObject2).hasNext()) {
        paramAppBrandBackgroundRunningOperationParcel.append("#").append(((AppBrandBackgroundRunningApp)((Iterator)localObject2).next()).appId);
      }
      paramAppBrandBackgroundRunningOperationParcel = paramAppBrandBackgroundRunningOperationParcel.toString();
      continue;
      AppMethodBeat.o(44798);
      return;
      label1107:
      i = 4;
      break label434;
      label1112:
      break;
      label1115:
      paramAppBrandBackgroundRunningOperationParcel = null;
    }
  }
  
  public final List<AppBrandBackgroundRunningApp> cjO()
  {
    AppMethodBeat.i(44799);
    ArrayList localArrayList = new ArrayList(this.qSy.values());
    AppMethodBeat.o(44799);
    return localArrayList;
  }
  
  public final void cjP()
  {
    AppMethodBeat.i(318171);
    Iterator localIterator = cjO().iterator();
    while (localIterator.hasNext())
    {
      AppBrandBackgroundRunningApp localAppBrandBackgroundRunningApp = (AppBrandBackgroundRunningApp)localIterator.next();
      MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
      localMMBackgroundRunningOperationParcel.appId = localAppBrandBackgroundRunningApp.appId;
      localMMBackgroundRunningOperationParcel.cIi = c.fi(c.qSn.cIi, c.qSp.cIi);
      localMMBackgroundRunningOperationParcel.hAf = 2;
      b(localMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(318171);
  }
  
  public final void cjQ()
  {
    AppMethodBeat.i(318175);
    Iterator localIterator = cjO().iterator();
    while (localIterator.hasNext())
    {
      AppBrandBackgroundRunningApp localAppBrandBackgroundRunningApp = (AppBrandBackgroundRunningApp)localIterator.next();
      MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
      localMMBackgroundRunningOperationParcel.appId = localAppBrandBackgroundRunningApp.appId;
      localMMBackgroundRunningOperationParcel.cIi = c.qSo.cIi;
      localMMBackgroundRunningOperationParcel.hAf = 2;
      b(localMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(318175);
  }
  
  final class a
    implements p
  {
    private final String mzg;
    
    public a(String paramString)
    {
      this.mzg = paramString;
    }
    
    public final void onDisconnect()
    {
      AppMethodBeat.i(318120);
      Log.i("MicroMsg.MMBackgroundRunningManagerService", "onDisconnected, process:%s", new Object[] { this.mzg });
      AppBrandBackgroundRunningOperationParcel localAppBrandBackgroundRunningOperationParcel = new AppBrandBackgroundRunningOperationParcel();
      localAppBrandBackgroundRunningOperationParcel.mzg = this.mzg;
      localAppBrandBackgroundRunningOperationParcel.hAf = 3;
      h.this.c(localAppBrandBackgroundRunningOperationParcel);
      AppMethodBeat.o(318120);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.h
 * JD-Core Version:    0.7.0.1
 */