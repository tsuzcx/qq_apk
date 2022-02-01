package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.app.NotificationManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yb;
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
  private static NotificationManager jSu = null;
  private LinkedHashMap<String, AppBrandBackgroundRunningApp> jSo;
  private final HashSet<h.a> jSp;
  private bc jSq;
  private bc.a jSr;
  private final AppBrandMainProcessService.a jSs;
  private com.tencent.mm.sdk.b.c<yb> jSt;
  
  public i()
  {
    AppMethodBeat.i(44795);
    this.jSp = new HashSet();
    this.jSr = new bc.a()
    {
      public final void kK(int paramAnonymousInt)
      {
        AppMethodBeat.i(188091);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(188091);
          return;
          AppMethodBeat.o(188091);
          return;
          ad.i("MicroMsg.MMBackgroundRunningManagerService", "onPhoneCall, kill voip, state:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          i.this.bde();
          i.this.bdf();
        }
      }
    };
    this.jSs = new AppBrandMainProcessService.a()
    {
      public final void Ky(String paramAnonymousString)
      {
        AppMethodBeat.i(188092);
        super.Ky(paramAnonymousString);
        ad.i("MicroMsg.MMBackgroundRunningManagerService", "onConnected, process:%s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(188092);
      }
      
      public final void onDisconnected(String paramAnonymousString)
      {
        AppMethodBeat.i(188093);
        super.onDisconnected(paramAnonymousString);
        ad.i("MicroMsg.MMBackgroundRunningManagerService", "onDisconnected, process:%s", new Object[] { paramAnonymousString });
        AppBrandBackgroundRunningOperationParcel localAppBrandBackgroundRunningOperationParcel = new AppBrandBackgroundRunningOperationParcel();
        localAppBrandBackgroundRunningOperationParcel.process = paramAnonymousString;
        localAppBrandBackgroundRunningOperationParcel.dkM = 3;
        i.this.c(localAppBrandBackgroundRunningOperationParcel);
        AppMethodBeat.o(188093);
      }
    };
    this.jSt = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(44795);
  }
  
  private static void c(MMBackgroundRunningOperationParcel paramMMBackgroundRunningOperationParcel)
  {
    AppMethodBeat.i(188098);
    if (!bt.isNullOrNil(paramMMBackgroundRunningOperationParcel.appId))
    {
      ad.i("MicroMsg.MMBackgroundRunningManagerService", "sendOperation from MM process, operation:%s", new Object[] { paramMMBackgroundRunningOperationParcel });
      com.tencent.mm.plugin.appbrand.ipc.e.b(paramMMBackgroundRunningOperationParcel.appId, paramMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(188098);
  }
  
  public final void a(h.a parama)
  {
    AppMethodBeat.i(44800);
    if (parama == null)
    {
      AppMethodBeat.o(44800);
      return;
    }
    synchronized (this.jSp)
    {
      this.jSp.add(parama);
      AppMethodBeat.o(44800);
      return;
    }
  }
  
  public final void akx()
  {
    AppMethodBeat.i(44796);
    ad.i("MicroMsg.MMBackgroundRunningManagerService", "onRegister MMBackgroundRunningManagerService");
    this.jSq = new bc();
    this.jSq.jb(aj.getContext());
    this.jSq.a(this.jSr);
    this.jSo = new LinkedHashMap();
    ad.i("MicroMsg.AppBrandForegroundNotificationManager", "startListening");
    if (f.jSm == null) {
      f.jSm = new f.1();
    }
    if (g.ab(h.class) != null) {
      ((h)g.ab(h.class)).a(f.jSm);
    }
    AppBrandMainProcessService.a(this.jSs);
    a(com.tencent.mm.plugin.ball.service.d.bKN());
    this.jSt.alive();
    AppMethodBeat.o(44796);
  }
  
  public final void aky()
  {
    AppMethodBeat.i(44797);
    ad.i("MicroMsg.MMBackgroundRunningManagerService", "onUnregister MMBackgroundRunningManagerService");
    bde();
    this.jSq.b(this.jSr);
    this.jSq.end();
    ad.i("MicroMsg.AppBrandForegroundNotificationManager", "stopListening");
    if (f.jSm != null)
    {
      if (g.ab(h.class) != null) {
        ((h)g.ab(h.class)).b(f.jSm);
      }
      f.jSm = null;
    }
    AppBrandMainProcessService.b(this.jSs);
    b(com.tencent.mm.plugin.ball.service.d.bKN());
    this.jSt.dead();
    this.jSp.clear();
    this.jSo.clear();
    this.jSo = null;
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
    synchronized (this.jSp)
    {
      this.jSp.remove(parama);
      AppMethodBeat.o(44801);
      return;
    }
  }
  
  public final List<AppBrandBackgroundRunningApp> bdd()
  {
    AppMethodBeat.i(44799);
    ArrayList localArrayList = new ArrayList(this.jSo.values());
    AppMethodBeat.o(44799);
    return localArrayList;
  }
  
  public final void bde()
  {
    AppMethodBeat.i(188096);
    Iterator localIterator = bdd().iterator();
    while (localIterator.hasNext())
    {
      AppBrandBackgroundRunningApp localAppBrandBackgroundRunningApp = (AppBrandBackgroundRunningApp)localIterator.next();
      MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
      localMMBackgroundRunningOperationParcel.appId = localAppBrandBackgroundRunningApp.appId;
      localMMBackgroundRunningOperationParcel.beO = d.dF(d.jSd.beO, d.jSf.beO);
      localMMBackgroundRunningOperationParcel.dkM = 2;
      c(localMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(188096);
  }
  
  public final void bdf()
  {
    AppMethodBeat.i(188097);
    Iterator localIterator = bdd().iterator();
    while (localIterator.hasNext())
    {
      AppBrandBackgroundRunningApp localAppBrandBackgroundRunningApp = (AppBrandBackgroundRunningApp)localIterator.next();
      MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
      localMMBackgroundRunningOperationParcel.appId = localAppBrandBackgroundRunningApp.appId;
      localMMBackgroundRunningOperationParcel.beO = d.jSe.beO;
      localMMBackgroundRunningOperationParcel.dkM = 2;
      c(localMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(188097);
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
      if ((!bt.isNullOrNil(paramAppBrandBackgroundRunningOperationParcel.jRQ)) && (paramAppBrandBackgroundRunningOperationParcel.jRQ.endsWith(AppBrandPluginUI.class.getSimpleName())))
      {
        ad.w("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, ignore fake native mini program");
        AppMethodBeat.o(44798);
        return;
      }
      if (paramAppBrandBackgroundRunningOperationParcel.dkM == 3)
      {
        ??? = paramAppBrandBackgroundRunningOperationParcel.process;
        if (!bt.isNullOrNil((String)???))
        {
          localObject2 = this.jSo.entrySet().iterator();
          i = 0;
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (AppBrandBackgroundRunningApp)((Map.Entry)((Iterator)localObject2).next()).getValue();
            if (!((String)???).equalsIgnoreCase(((AppBrandBackgroundRunningApp)localObject3).process)) {
              break label1091;
            }
            if (bt.isNullOrNil(paramAppBrandBackgroundRunningOperationParcel.jRQ)) {
              paramAppBrandBackgroundRunningOperationParcel.jRQ = ((AppBrandBackgroundRunningApp)localObject3).jRQ;
            }
            paramAppBrandBackgroundRunningOperationParcel.beO |= ((AppBrandBackgroundRunningApp)localObject3).beO;
            paramAppBrandBackgroundRunningOperationParcel.appId = ((AppBrandBackgroundRunningApp)localObject3).appId;
            paramAppBrandBackgroundRunningOperationParcel.hQh = ((AppBrandBackgroundRunningApp)localObject3).hQh;
            this.jSo.remove(((AppBrandBackgroundRunningApp)localObject3).appId);
            ad.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, operation kill process:%s, app:%s", new Object[] { ???, ((AppBrandBackgroundRunningApp)localObject3).appId });
            if (!bt.isNullOrNil(((AppBrandBackgroundRunningApp)localObject3).jRR))
            {
              Object localObject4 = e.MM(((AppBrandBackgroundRunningApp)localObject3).jRR);
              if (localObject4 == null)
              {
                ad.w("MicroMsg.MMBackgroundRunningManagerService", "cancelCustomNotificationFallback for %s, customNotificationLogicClass is null", new Object[] { ((AppBrandBackgroundRunningApp)localObject3).appId });
                i = 3;
              }
              else
              {
                o localo = a.Kj(((AppBrandBackgroundRunningApp)localObject3).appId);
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
                    if (jSu == null) {
                      jSu = (NotificationManager)aj.getContext().getSystemService("notification");
                    }
                    jSu.cancel(((CustomBackgroundRunningNotificationLogic)localObject4).bcT());
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
          synchronized (this.jSp)
          {
            localObject2 = bdd();
            localObject3 = this.jSp.iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break label928;
            }
            ((h.a)((Iterator)localObject3).next()).a((List)localObject2, paramAppBrandBackgroundRunningOperationParcel, i);
          }
          ad.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, operation kill, no process");
          i = j;
          continue;
          ??? = (AppBrandBackgroundRunningApp)this.jSo.get(paramAppBrandBackgroundRunningOperationParcel.appId);
          if (??? != null)
          {
            if (paramAppBrandBackgroundRunningOperationParcel.dkM == 1)
            {
              if (!d.contains(((AppBrandBackgroundRunningApp)???).beO, paramAppBrandBackgroundRunningOperationParcel.beO))
              {
                ((AppBrandBackgroundRunningApp)???).beO = d.dF(((AppBrandBackgroundRunningApp)???).beO, paramAppBrandBackgroundRunningOperationParcel.beO);
                ad.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, app(%s) add new usage(%s)", new Object[] { paramAppBrandBackgroundRunningOperationParcel.appId, Integer.valueOf(paramAppBrandBackgroundRunningOperationParcel.beO) });
                i = 2;
                continue;
              }
              ad.w("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, this app has been added before, but now it wants to add a same usage!!!");
              i = j;
              continue;
            }
            i = j;
            if (paramAppBrandBackgroundRunningOperationParcel.dkM != 2) {
              continue;
            }
            if (d.contains(((AppBrandBackgroundRunningApp)???).beO, paramAppBrandBackgroundRunningOperationParcel.beO))
            {
              paramAppBrandBackgroundRunningOperationParcel.hQh = ((AppBrandBackgroundRunningApp)???).hQh;
              ((AppBrandBackgroundRunningApp)???).beO = d.dG(((AppBrandBackgroundRunningApp)???).beO, paramAppBrandBackgroundRunningOperationParcel.beO);
              ad.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, app(%s) remove usage(%s)", new Object[] { paramAppBrandBackgroundRunningOperationParcel.appId, Integer.valueOf(paramAppBrandBackgroundRunningOperationParcel.beO) });
              if (((AppBrandBackgroundRunningApp)???).beO == 0)
              {
                if (bt.isNullOrNil(paramAppBrandBackgroundRunningOperationParcel.jRQ)) {
                  paramAppBrandBackgroundRunningOperationParcel.jRQ = ((AppBrandBackgroundRunningApp)???).jRQ;
                }
                this.jSo.remove(paramAppBrandBackgroundRunningOperationParcel.appId);
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
            if (paramAppBrandBackgroundRunningOperationParcel.dkM == 1)
            {
              ??? = new AppBrandBackgroundRunningApp();
              ((AppBrandBackgroundRunningApp)???).appId = paramAppBrandBackgroundRunningOperationParcel.appId;
              ((AppBrandBackgroundRunningApp)???).hQh = paramAppBrandBackgroundRunningOperationParcel.hQh;
              ((AppBrandBackgroundRunningApp)???).beO = paramAppBrandBackgroundRunningOperationParcel.beO;
              ((AppBrandBackgroundRunningApp)???).name = paramAppBrandBackgroundRunningOperationParcel.name;
              ((AppBrandBackgroundRunningApp)???).dDH = paramAppBrandBackgroundRunningOperationParcel.dDH;
              ((AppBrandBackgroundRunningApp)???).username = paramAppBrandBackgroundRunningOperationParcel.username;
              ((AppBrandBackgroundRunningApp)???).jRQ = paramAppBrandBackgroundRunningOperationParcel.jRQ;
              ((AppBrandBackgroundRunningApp)???).process = paramAppBrandBackgroundRunningOperationParcel.process;
              ((AppBrandBackgroundRunningApp)???).jRR = paramAppBrandBackgroundRunningOperationParcel.jRR;
              this.jSo.put(((AppBrandBackgroundRunningApp)???).appId, ???);
              ad.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, add app(%s) with usage(%s)", new Object[] { paramAppBrandBackgroundRunningOperationParcel.appId, Integer.valueOf(paramAppBrandBackgroundRunningOperationParcel.beO) });
              i = 1;
              continue;
            }
            i = j;
            if (paramAppBrandBackgroundRunningOperationParcel.dkM != 2) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.i
 * JD-Core Version:    0.7.0.1
 */