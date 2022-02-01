package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.app.NotificationManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ww;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.a;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bc.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class i
  implements b, h
{
  private static NotificationManager iYg = null;
  private LinkedHashMap<String, AppBrandBackgroundRunningApp> iYa;
  private final HashSet<h.a> iYb;
  private bc iYc;
  private bc.a iYd;
  private final AppBrandMainProcessService.a iYe;
  private com.tencent.mm.sdk.b.c<ww> iYf;
  
  public i()
  {
    AppMethodBeat.i(44795);
    this.iYb = new HashSet();
    this.iYd = new bc.a()
    {
      public final void kq(int paramAnonymousInt)
      {
        AppMethodBeat.i(195679);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(195679);
          return;
          AppMethodBeat.o(195679);
          return;
          ad.i("MicroMsg.MMBackgroundRunningManagerService", "onPhoneCall, kill voip, state:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          i.this.aSI();
          i.this.aSJ();
        }
      }
    };
    this.iYe = new AppBrandMainProcessService.a()
    {
      public final void Dh(String paramAnonymousString)
      {
        AppMethodBeat.i(195680);
        super.Dh(paramAnonymousString);
        ad.i("MicroMsg.MMBackgroundRunningManagerService", "onConnected, process:%s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(195680);
      }
      
      public final void onDisconnected(String paramAnonymousString)
      {
        AppMethodBeat.i(195681);
        super.onDisconnected(paramAnonymousString);
        ad.i("MicroMsg.MMBackgroundRunningManagerService", "onDisconnected, process:%s", new Object[] { paramAnonymousString });
        AppBrandBackgroundRunningOperationParcel localAppBrandBackgroundRunningOperationParcel = new AppBrandBackgroundRunningOperationParcel();
        localAppBrandBackgroundRunningOperationParcel.process = paramAnonymousString;
        localAppBrandBackgroundRunningOperationParcel.dbV = 3;
        i.this.c(localAppBrandBackgroundRunningOperationParcel);
        AppMethodBeat.o(195681);
      }
    };
    this.iYf = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(44795);
  }
  
  private static void c(MMBackgroundRunningOperationParcel paramMMBackgroundRunningOperationParcel)
  {
    AppMethodBeat.i(195686);
    if (!bt.isNullOrNil(paramMMBackgroundRunningOperationParcel.appId))
    {
      ad.i("MicroMsg.MMBackgroundRunningManagerService", "sendOperation from MM process, operation:%s", new Object[] { paramMMBackgroundRunningOperationParcel });
      com.tencent.mm.plugin.appbrand.ipc.e.b(paramMMBackgroundRunningOperationParcel.appId, paramMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(195686);
  }
  
  public final void a(h.a parama)
  {
    AppMethodBeat.i(44800);
    if (parama == null)
    {
      AppMethodBeat.o(44800);
      return;
    }
    synchronized (this.iYb)
    {
      this.iYb.add(parama);
      AppMethodBeat.o(44800);
      return;
    }
  }
  
  public final List<AppBrandBackgroundRunningApp> aSH()
  {
    AppMethodBeat.i(44799);
    ArrayList localArrayList = new ArrayList(this.iYa.values());
    AppMethodBeat.o(44799);
    return localArrayList;
  }
  
  public final void aSI()
  {
    AppMethodBeat.i(195684);
    Iterator localIterator = aSH().iterator();
    while (localIterator.hasNext())
    {
      AppBrandBackgroundRunningApp localAppBrandBackgroundRunningApp = (AppBrandBackgroundRunningApp)localIterator.next();
      MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
      localMMBackgroundRunningOperationParcel.appId = localAppBrandBackgroundRunningApp.appId;
      localMMBackgroundRunningOperationParcel.aTC = d.iXQ.aTC;
      localMMBackgroundRunningOperationParcel.dbV = 2;
      c(localMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(195684);
  }
  
  public final void aSJ()
  {
    AppMethodBeat.i(195685);
    Iterator localIterator = aSH().iterator();
    while (localIterator.hasNext())
    {
      AppBrandBackgroundRunningApp localAppBrandBackgroundRunningApp = (AppBrandBackgroundRunningApp)localIterator.next();
      MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
      localMMBackgroundRunningOperationParcel.appId = localAppBrandBackgroundRunningApp.appId;
      localMMBackgroundRunningOperationParcel.aTC = d.iXR.aTC;
      localMMBackgroundRunningOperationParcel.dbV = 2;
      c(localMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(195685);
  }
  
  public final void agv()
  {
    AppMethodBeat.i(44796);
    ad.i("MicroMsg.MMBackgroundRunningManagerService", "onRegister MMBackgroundRunningManagerService");
    this.iYc = new bc();
    this.iYc.iG(aj.getContext());
    this.iYc.a(this.iYd);
    this.iYa = new LinkedHashMap();
    ad.i("MicroMsg.AppBrandForegroundNotificationManager", "startListening");
    if (f.iXY == null) {
      f.iXY = new f.1();
    }
    if (g.ab(h.class) != null) {
      ((h)g.ab(h.class)).a(f.iXY);
    }
    AppBrandMainProcessService.a(this.iYe);
    a(com.tencent.mm.plugin.ball.service.d.bzH());
    this.iYf.alive();
    AppMethodBeat.o(44796);
  }
  
  public final void agw()
  {
    AppMethodBeat.i(44797);
    ad.i("MicroMsg.MMBackgroundRunningManagerService", "onUnregister MMBackgroundRunningManagerService");
    aSI();
    this.iYc.b(this.iYd);
    this.iYc.end();
    ad.i("MicroMsg.AppBrandForegroundNotificationManager", "stopListening");
    if (f.iXY != null)
    {
      if (g.ab(h.class) != null) {
        ((h)g.ab(h.class)).b(f.iXY);
      }
      f.iXY = null;
    }
    AppBrandMainProcessService.b(this.iYe);
    b(com.tencent.mm.plugin.ball.service.d.bzH());
    this.iYf.dead();
    this.iYb.clear();
    this.iYa.clear();
    this.iYa = null;
    AppMethodBeat.o(44797);
  }
  
  public final void b(h.a parama)
  {
    AppMethodBeat.i(44801);
    if (parama == null)
    {
      AppMethodBeat.o(44801);
      return;
    }
    synchronized (this.iYb)
    {
      this.iYb.remove(parama);
      AppMethodBeat.o(44801);
      return;
    }
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
      ad.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation in MM process, operation:%s", new Object[] { paramAppBrandBackgroundRunningOperationParcel });
      if ((!bt.isNullOrNil(paramAppBrandBackgroundRunningOperationParcel.iXE)) && (paramAppBrandBackgroundRunningOperationParcel.iXE.endsWith(AppBrandPluginUI.class.getSimpleName())))
      {
        ad.w("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, ignore fake native mini program");
        AppMethodBeat.o(44798);
        return;
      }
      if (paramAppBrandBackgroundRunningOperationParcel.dbV == 3)
      {
        ??? = paramAppBrandBackgroundRunningOperationParcel.process;
        if (!bt.isNullOrNil((String)???))
        {
          localObject2 = this.iYa.entrySet().iterator();
          i = 0;
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (AppBrandBackgroundRunningApp)((Map.Entry)((Iterator)localObject2).next()).getValue();
            if (!((String)???).equalsIgnoreCase(((AppBrandBackgroundRunningApp)localObject3).process)) {
              break label1091;
            }
            if (bt.isNullOrNil(paramAppBrandBackgroundRunningOperationParcel.iXE)) {
              paramAppBrandBackgroundRunningOperationParcel.iXE = ((AppBrandBackgroundRunningApp)localObject3).iXE;
            }
            paramAppBrandBackgroundRunningOperationParcel.aTC |= ((AppBrandBackgroundRunningApp)localObject3).aTC;
            paramAppBrandBackgroundRunningOperationParcel.appId = ((AppBrandBackgroundRunningApp)localObject3).appId;
            paramAppBrandBackgroundRunningOperationParcel.gXn = ((AppBrandBackgroundRunningApp)localObject3).gXn;
            this.iYa.remove(((AppBrandBackgroundRunningApp)localObject3).appId);
            ad.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, operation kill process:%s, app:%s", new Object[] { ???, ((AppBrandBackgroundRunningApp)localObject3).appId });
            if (!bt.isNullOrNil(((AppBrandBackgroundRunningApp)localObject3).iXF))
            {
              Object localObject4 = e.Fp(((AppBrandBackgroundRunningApp)localObject3).iXF);
              if (localObject4 == null)
              {
                ad.w("MicroMsg.MMBackgroundRunningManagerService", "cancelCustomNotificationFallback for %s, customNotificationLogicClass is null", new Object[] { ((AppBrandBackgroundRunningApp)localObject3).appId });
                i = 3;
              }
              else
              {
                o localo = a.CR(((AppBrandBackgroundRunningApp)localObject3).appId);
                if (localo == null)
                {
                  ad.w("MicroMsg.MMBackgroundRunningManagerService", "cancelCustomNotificationFallback for %s, runtime is null", new Object[] { ((AppBrandBackgroundRunningApp)localObject3).appId });
                  i = 3;
                }
                else
                {
                  localObject4 = (CustomBackgroundRunningNotificationLogic)localo.as((Class)localObject4);
                  if (localObject4 == null)
                  {
                    ad.w("MicroMsg.MMBackgroundRunningManagerService", "cancelCustomNotificationFallback for %s, customNotificationLogic is null", new Object[] { ((AppBrandBackgroundRunningApp)localObject3).appId });
                    i = 3;
                  }
                  else
                  {
                    if (iYg == null) {
                      iYg = (NotificationManager)aj.getContext().getSystemService("notification");
                    }
                    iYg.cancel(((CustomBackgroundRunningNotificationLogic)localObject4).aSy());
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
    label1091:
    for (;;)
    {
      break;
      for (;;)
      {
        if (i != 0)
        {
          synchronized (this.iYb)
          {
            localObject2 = aSH();
            localObject3 = this.iYb.iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break label928;
            }
            ((h.a)((Iterator)localObject3).next()).a((List)localObject2, paramAppBrandBackgroundRunningOperationParcel, i);
          }
          ad.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, operation kill, no process");
          i = j;
          continue;
          ??? = (AppBrandBackgroundRunningApp)this.iYa.get(paramAppBrandBackgroundRunningOperationParcel.appId);
          if (??? != null)
          {
            if (paramAppBrandBackgroundRunningOperationParcel.dbV == 1)
            {
              if (!d.contains(((AppBrandBackgroundRunningApp)???).aTC, paramAppBrandBackgroundRunningOperationParcel.aTC))
              {
                ((AppBrandBackgroundRunningApp)???).aTC = d.dD(((AppBrandBackgroundRunningApp)???).aTC, paramAppBrandBackgroundRunningOperationParcel.aTC);
                ad.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, app(%s) add new usage(%s)", new Object[] { paramAppBrandBackgroundRunningOperationParcel.appId, Integer.valueOf(paramAppBrandBackgroundRunningOperationParcel.aTC) });
                i = 2;
                continue;
              }
              ad.w("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, this app has been added before, but now it wants to add a same usage!!!");
              i = j;
              continue;
            }
            i = j;
            if (paramAppBrandBackgroundRunningOperationParcel.dbV != 2) {
              continue;
            }
            if (d.contains(((AppBrandBackgroundRunningApp)???).aTC, paramAppBrandBackgroundRunningOperationParcel.aTC))
            {
              paramAppBrandBackgroundRunningOperationParcel.gXn = ((AppBrandBackgroundRunningApp)???).gXn;
              ((AppBrandBackgroundRunningApp)???).aTC = d.dE(((AppBrandBackgroundRunningApp)???).aTC, paramAppBrandBackgroundRunningOperationParcel.aTC);
              ad.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, app(%s) remove usage(%s)", new Object[] { paramAppBrandBackgroundRunningOperationParcel.appId, Integer.valueOf(paramAppBrandBackgroundRunningOperationParcel.aTC) });
              if (((AppBrandBackgroundRunningApp)???).aTC == 0)
              {
                if (bt.isNullOrNil(paramAppBrandBackgroundRunningOperationParcel.iXE)) {
                  paramAppBrandBackgroundRunningOperationParcel.iXE = ((AppBrandBackgroundRunningApp)???).iXE;
                }
                this.iYa.remove(paramAppBrandBackgroundRunningOperationParcel.appId);
                ad.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, app(%s) has been removed", new Object[] { paramAppBrandBackgroundRunningOperationParcel.appId });
                i = 3;
              }
            }
            else
            {
              ad.w("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, this app has been added before, but now it wants to remove not added usage!!!");
              i = j;
            }
          }
          else
          {
            if (paramAppBrandBackgroundRunningOperationParcel.dbV == 1)
            {
              ??? = new AppBrandBackgroundRunningApp();
              ((AppBrandBackgroundRunningApp)???).appId = paramAppBrandBackgroundRunningOperationParcel.appId;
              ((AppBrandBackgroundRunningApp)???).gXn = paramAppBrandBackgroundRunningOperationParcel.gXn;
              ((AppBrandBackgroundRunningApp)???).aTC = paramAppBrandBackgroundRunningOperationParcel.aTC;
              ((AppBrandBackgroundRunningApp)???).name = paramAppBrandBackgroundRunningOperationParcel.name;
              ((AppBrandBackgroundRunningApp)???).dub = paramAppBrandBackgroundRunningOperationParcel.dub;
              ((AppBrandBackgroundRunningApp)???).username = paramAppBrandBackgroundRunningOperationParcel.username;
              ((AppBrandBackgroundRunningApp)???).iXE = paramAppBrandBackgroundRunningOperationParcel.iXE;
              ((AppBrandBackgroundRunningApp)???).process = paramAppBrandBackgroundRunningOperationParcel.process;
              ((AppBrandBackgroundRunningApp)???).iXF = paramAppBrandBackgroundRunningOperationParcel.iXF;
              this.iYa.put(((AppBrandBackgroundRunningApp)???).appId, ???);
              ad.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, add app(%s) with usage(%s)", new Object[] { paramAppBrandBackgroundRunningOperationParcel.appId, Integer.valueOf(paramAppBrandBackgroundRunningOperationParcel.aTC) });
              i = 1;
              continue;
            }
            i = j;
            if (paramAppBrandBackgroundRunningOperationParcel.dbV != 2) {
              continue;
            }
            ad.w("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, this app has not been added before, but now it wants to remove some usage!!!");
            i = j;
            continue;
            if (((List)localObject2).isEmpty()) {}
            for (paramAppBrandBackgroundRunningOperationParcel = null;; paramAppBrandBackgroundRunningOperationParcel = paramAppBrandBackgroundRunningOperationParcel.toString())
            {
              ad.i("MicroMsg.MMBackgroundRunningManagerService", "report background running app list changed, note:%s", new Object[] { paramAppBrandBackgroundRunningOperationParcel });
              c.a(null, 0, System.currentTimeMillis(), 6, paramAppBrandBackgroundRunningOperationParcel, 0);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.i
 * JD-Core Version:    0.7.0.1
 */