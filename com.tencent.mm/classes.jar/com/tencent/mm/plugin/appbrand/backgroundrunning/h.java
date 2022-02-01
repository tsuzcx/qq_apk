package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.app.NotificationManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.aaq;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher.PhoneCallListener;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class h
  implements com.tencent.mm.kernel.c.b, g
{
  private static NotificationManager nSS = null;
  private LinkedHashMap<String, AppBrandBackgroundRunningApp> nSM;
  private final HashSet<g.a> nSN;
  private PhoneStatusWatcher nSO;
  private List<a> nSP;
  private PhoneStatusWatcher.PhoneCallListener nSQ;
  private IListener<aaq> nSR;
  
  public h()
  {
    AppMethodBeat.i(44795);
    this.nSN = new HashSet();
    this.nSQ = new PhoneStatusWatcher.PhoneCallListener()
    {
      public final void onPhoneCall(int paramAnonymousInt)
      {
        AppMethodBeat.i(277419);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(277419);
          return;
          AppMethodBeat.o(277419);
          return;
          Log.i("MicroMsg.MMBackgroundRunningManagerService", "onPhoneCall, kill voip, state:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          h.this.bKp();
          h.this.bKq();
        }
      }
    };
    this.nSR = new IListener() {};
    AppMethodBeat.o(44795);
  }
  
  private static void c(MMBackgroundRunningOperationParcel paramMMBackgroundRunningOperationParcel)
  {
    AppMethodBeat.i(277447);
    if (!Util.isNullOrNil(paramMMBackgroundRunningOperationParcel.appId))
    {
      Log.i("MicroMsg.MMBackgroundRunningManagerService", "sendOperation from MM process, operation:%s", new Object[] { paramMMBackgroundRunningOperationParcel });
      com.tencent.mm.plugin.appbrand.ipc.e.b(paramMMBackgroundRunningOperationParcel.appId, paramMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(277447);
  }
  
  public final void a(g.a parama)
  {
    AppMethodBeat.i(44800);
    if (parama == null)
    {
      AppMethodBeat.o(44800);
      return;
    }
    synchronized (this.nSN)
    {
      this.nSN.add(parama);
      AppMethodBeat.o(44800);
      return;
    }
  }
  
  public final void aIF()
  {
    AppMethodBeat.i(44796);
    Log.i("MicroMsg.MMBackgroundRunningManagerService", "onRegister MMBackgroundRunningManagerService");
    this.nSO = new PhoneStatusWatcher();
    this.nSO.begin(MMApplicationContext.getContext());
    this.nSO.addPhoneCallListener(this.nSQ);
    this.nSM = new LinkedHashMap();
    Log.i("MicroMsg.AppBrandForegroundNotificationManager", "startListening");
    if (e.nSK == null) {
      e.nSK = new e.1();
    }
    if (com.tencent.mm.kernel.h.ae(g.class) != null) {
      ((g)com.tencent.mm.kernel.h.ae(g.class)).a(e.nSK);
    }
    Object localObject2;
    if (this.nSP == null)
    {
      this.nSP = new ArrayList();
      localObject1 = i.cjc();
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        localObject2 = localObject1[i];
        this.nSP.add(new a((String)localObject2));
        i += 1;
      }
    }
    Object localObject1 = this.nSP.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (a)((Iterator)localObject1).next();
      j.b(((a)localObject2).jZi, (p)localObject2);
    }
    a(com.tencent.mm.plugin.ball.service.c.cvT());
    this.nSR.alive();
    AppMethodBeat.o(44796);
  }
  
  public final void aIG()
  {
    AppMethodBeat.i(44797);
    Log.i("MicroMsg.MMBackgroundRunningManagerService", "onUnregister MMBackgroundRunningManagerService");
    bKp();
    this.nSO.removePhoneCallListener(this.nSQ);
    this.nSO.end();
    Log.i("MicroMsg.AppBrandForegroundNotificationManager", "stopListening");
    if (e.nSK != null)
    {
      if (com.tencent.mm.kernel.h.ae(g.class) != null) {
        ((g)com.tencent.mm.kernel.h.ae(g.class)).b(e.nSK);
      }
      e.nSK = null;
    }
    Iterator localIterator = this.nSP.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      j.c(MMApplicationContext.getMainProcessName(), locala);
    }
    this.nSP = null;
    b(com.tencent.mm.plugin.ball.service.c.cvT());
    this.nSR.dead();
    this.nSN.clear();
    this.nSM.clear();
    this.nSM = null;
    AppMethodBeat.o(44797);
  }
  
  public final void b(g.a parama)
  {
    AppMethodBeat.i(44801);
    if (parama == null)
    {
      AppMethodBeat.o(44801);
      return;
    }
    synchronized (this.nSN)
    {
      this.nSN.remove(parama);
      AppMethodBeat.o(44801);
      return;
    }
  }
  
  public final List<AppBrandBackgroundRunningApp> bKo()
  {
    AppMethodBeat.i(44799);
    ArrayList localArrayList = new ArrayList(this.nSM.values());
    AppMethodBeat.o(44799);
    return localArrayList;
  }
  
  public final void bKp()
  {
    AppMethodBeat.i(277444);
    Iterator localIterator = bKo().iterator();
    while (localIterator.hasNext())
    {
      AppBrandBackgroundRunningApp localAppBrandBackgroundRunningApp = (AppBrandBackgroundRunningApp)localIterator.next();
      MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
      localMMBackgroundRunningOperationParcel.appId = localAppBrandBackgroundRunningApp.appId;
      localMMBackgroundRunningOperationParcel.aOm = c.ep(c.nSC.aOm, c.nSE.aOm);
      localMMBackgroundRunningOperationParcel.fvK = 2;
      c(localMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(277444);
  }
  
  public final void bKq()
  {
    AppMethodBeat.i(277445);
    Iterator localIterator = bKo().iterator();
    while (localIterator.hasNext())
    {
      AppBrandBackgroundRunningApp localAppBrandBackgroundRunningApp = (AppBrandBackgroundRunningApp)localIterator.next();
      MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
      localMMBackgroundRunningOperationParcel.appId = localAppBrandBackgroundRunningApp.appId;
      localMMBackgroundRunningOperationParcel.aOm = c.nSD.aOm;
      localMMBackgroundRunningOperationParcel.fvK = 2;
      c(localMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(277445);
  }
  
  public final void c(AppBrandBackgroundRunningOperationParcel paramAppBrandBackgroundRunningOperationParcel)
  {
    int j = 0;
    AppMethodBeat.i(44798);
    Object localObject2;
    int i;
    Object localObject3;
    if (paramAppBrandBackgroundRunningOperationParcel != null)
    {
      Log.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation in MM process, operation:%s", new Object[] { paramAppBrandBackgroundRunningOperationParcel });
      if ((!Util.isNullOrNil(paramAppBrandBackgroundRunningOperationParcel.nSq)) && (paramAppBrandBackgroundRunningOperationParcel.nSq.endsWith(AppBrandPluginUI.class.getSimpleName())))
      {
        Log.w("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, ignore fake native mini program");
        AppMethodBeat.o(44798);
        return;
      }
      if (paramAppBrandBackgroundRunningOperationParcel.fvK == 3)
      {
        ??? = paramAppBrandBackgroundRunningOperationParcel.jZi;
        if (!Util.isNullOrNil((String)???))
        {
          localObject2 = this.nSM.entrySet().iterator();
          i = 0;
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (AppBrandBackgroundRunningApp)((Map.Entry)((Iterator)localObject2).next()).getValue();
            if (!((String)???).equalsIgnoreCase(((AppBrandBackgroundRunningApp)localObject3).jZi)) {
              break label1090;
            }
            if (Util.isNullOrNil(paramAppBrandBackgroundRunningOperationParcel.nSq)) {
              paramAppBrandBackgroundRunningOperationParcel.nSq = ((AppBrandBackgroundRunningApp)localObject3).nSq;
            }
            paramAppBrandBackgroundRunningOperationParcel.aOm |= ((AppBrandBackgroundRunningApp)localObject3).aOm;
            paramAppBrandBackgroundRunningOperationParcel.appId = ((AppBrandBackgroundRunningApp)localObject3).appId;
            paramAppBrandBackgroundRunningOperationParcel.cBU = ((AppBrandBackgroundRunningApp)localObject3).cBU;
            this.nSM.remove(((AppBrandBackgroundRunningApp)localObject3).appId);
            Log.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, operation kill process:%s, app:%s", new Object[] { ???, ((AppBrandBackgroundRunningApp)localObject3).appId });
            if (!Util.isNullOrNil(((AppBrandBackgroundRunningApp)localObject3).nSr))
            {
              Object localObject4 = d.aem(((AppBrandBackgroundRunningApp)localObject3).nSr);
              if (localObject4 == null)
              {
                Log.w("MicroMsg.MMBackgroundRunningManagerService", "cancelCustomNotificationFallback for %s, customNotificationLogicClass is null", new Object[] { ((AppBrandBackgroundRunningApp)localObject3).appId });
                i = 3;
              }
              else
              {
                t localt = com.tencent.mm.plugin.appbrand.d.abA(((AppBrandBackgroundRunningApp)localObject3).appId);
                if (localt == null)
                {
                  Log.w("MicroMsg.MMBackgroundRunningManagerService", "cancelCustomNotificationFallback for %s, runtime is null", new Object[] { ((AppBrandBackgroundRunningApp)localObject3).appId });
                  i = 3;
                }
                else
                {
                  localObject4 = (CustomBackgroundRunningNotificationLogic)localt.av((Class)localObject4);
                  if (localObject4 == null)
                  {
                    Log.w("MicroMsg.MMBackgroundRunningManagerService", "cancelCustomNotificationFallback for %s, customNotificationLogic is null", new Object[] { ((AppBrandBackgroundRunningApp)localObject3).appId });
                    i = 3;
                  }
                  else
                  {
                    if (nSS == null) {
                      nSS = (NotificationManager)MMApplicationContext.getContext().getSystemService("notification");
                    }
                    nSS.cancel(((CustomBackgroundRunningNotificationLogic)localObject4).bKe());
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
    }
    label928:
    label1090:
    for (;;)
    {
      break;
      for (;;)
      {
        if (i != 0)
        {
          synchronized (this.nSN)
          {
            localObject2 = bKo();
            localObject3 = this.nSN.iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break label928;
            }
            ((g.a)((Iterator)localObject3).next()).a((List)localObject2, paramAppBrandBackgroundRunningOperationParcel, i);
          }
          Log.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, operation kill, no process");
          i = j;
          continue;
          ??? = (AppBrandBackgroundRunningApp)this.nSM.get(paramAppBrandBackgroundRunningOperationParcel.appId);
          if (??? != null)
          {
            if (paramAppBrandBackgroundRunningOperationParcel.fvK == 1)
            {
              if (!c.eo(((AppBrandBackgroundRunningApp)???).aOm, paramAppBrandBackgroundRunningOperationParcel.aOm))
              {
                ((AppBrandBackgroundRunningApp)???).aOm = c.ep(((AppBrandBackgroundRunningApp)???).aOm, paramAppBrandBackgroundRunningOperationParcel.aOm);
                Log.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, app(%s) add new usage(%s)", new Object[] { paramAppBrandBackgroundRunningOperationParcel.appId, Integer.valueOf(paramAppBrandBackgroundRunningOperationParcel.aOm) });
                i = 2;
                continue;
              }
              Log.w("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, this app has been added before, but now it wants to add a same usage!!!");
              i = j;
              continue;
            }
            i = j;
            if (paramAppBrandBackgroundRunningOperationParcel.fvK != 2) {
              continue;
            }
            if (c.eo(((AppBrandBackgroundRunningApp)???).aOm, paramAppBrandBackgroundRunningOperationParcel.aOm))
            {
              paramAppBrandBackgroundRunningOperationParcel.cBU = ((AppBrandBackgroundRunningApp)???).cBU;
              ((AppBrandBackgroundRunningApp)???).aOm = c.eq(((AppBrandBackgroundRunningApp)???).aOm, paramAppBrandBackgroundRunningOperationParcel.aOm);
              Log.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, app(%s) remove usage(%s)", new Object[] { paramAppBrandBackgroundRunningOperationParcel.appId, Integer.valueOf(paramAppBrandBackgroundRunningOperationParcel.aOm) });
              if (((AppBrandBackgroundRunningApp)???).aOm == 0)
              {
                if (Util.isNullOrNil(paramAppBrandBackgroundRunningOperationParcel.nSq)) {
                  paramAppBrandBackgroundRunningOperationParcel.nSq = ((AppBrandBackgroundRunningApp)???).nSq;
                }
                this.nSM.remove(paramAppBrandBackgroundRunningOperationParcel.appId);
                Log.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, app(%s) has been removed", new Object[] { paramAppBrandBackgroundRunningOperationParcel.appId });
                i = 3;
              }
            }
            else
            {
              Log.w("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, this app has been added before, but now it wants to remove not added usage!!!");
              i = j;
            }
          }
          else
          {
            if (paramAppBrandBackgroundRunningOperationParcel.fvK == 1)
            {
              ??? = new AppBrandBackgroundRunningApp();
              ((AppBrandBackgroundRunningApp)???).appId = paramAppBrandBackgroundRunningOperationParcel.appId;
              ((AppBrandBackgroundRunningApp)???).cBU = paramAppBrandBackgroundRunningOperationParcel.cBU;
              ((AppBrandBackgroundRunningApp)???).aOm = paramAppBrandBackgroundRunningOperationParcel.aOm;
              ((AppBrandBackgroundRunningApp)???).name = paramAppBrandBackgroundRunningOperationParcel.name;
              ((AppBrandBackgroundRunningApp)???).icon = paramAppBrandBackgroundRunningOperationParcel.icon;
              ((AppBrandBackgroundRunningApp)???).username = paramAppBrandBackgroundRunningOperationParcel.username;
              ((AppBrandBackgroundRunningApp)???).nSq = paramAppBrandBackgroundRunningOperationParcel.nSq;
              ((AppBrandBackgroundRunningApp)???).jZi = paramAppBrandBackgroundRunningOperationParcel.jZi;
              ((AppBrandBackgroundRunningApp)???).nSr = paramAppBrandBackgroundRunningOperationParcel.nSr;
              this.nSM.put(((AppBrandBackgroundRunningApp)???).appId, ???);
              Log.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, add app(%s) with usage(%s)", new Object[] { paramAppBrandBackgroundRunningOperationParcel.appId, Integer.valueOf(paramAppBrandBackgroundRunningOperationParcel.aOm) });
              i = 1;
              continue;
            }
            i = j;
            if (paramAppBrandBackgroundRunningOperationParcel.fvK != 2) {
              continue;
            }
            Log.w("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, this app has not been added before, but now it wants to remove some usage!!!");
            i = j;
            continue;
            if (((List)localObject2).isEmpty()) {}
            for (paramAppBrandBackgroundRunningOperationParcel = null;; paramAppBrandBackgroundRunningOperationParcel = paramAppBrandBackgroundRunningOperationParcel.toString())
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
            }
          }
        }
        else
        {
          AppMethodBeat.o(44798);
          return;
        }
        i = 4;
      }
    }
  }
  
  final class a
    implements p
  {
    final String jZi;
    
    public a(String paramString)
    {
      this.jZi = paramString;
    }
    
    public final void aFw()
    {
      AppMethodBeat.i(242644);
      Log.i("MicroMsg.MMBackgroundRunningManagerService", "onDisconnected, process:%s", new Object[] { this.jZi });
      AppBrandBackgroundRunningOperationParcel localAppBrandBackgroundRunningOperationParcel = new AppBrandBackgroundRunningOperationParcel();
      localAppBrandBackgroundRunningOperationParcel.jZi = this.jZi;
      localAppBrandBackgroundRunningOperationParcel.fvK = 3;
      h.this.c(localAppBrandBackgroundRunningOperationParcel);
      AppMethodBeat.o(242644);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.h
 * JD-Core Version:    0.7.0.1
 */