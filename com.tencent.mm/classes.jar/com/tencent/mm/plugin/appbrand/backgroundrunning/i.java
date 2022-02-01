package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.app.NotificationManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.a;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bb.a;
import com.tencent.mm.sdk.platformtools.bs;
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
  private static NotificationManager jyx = null;
  private LinkedHashMap<String, AppBrandBackgroundRunningApp> jyr;
  private final HashSet<h.a> jys;
  private bb jyt;
  private bb.a jyu;
  private final AppBrandMainProcessService.a jyv;
  private com.tencent.mm.sdk.b.c<xh> jyw;
  
  public i()
  {
    AppMethodBeat.i(44795);
    this.jys = new HashSet();
    this.jyu = new bb.a()
    {
      public final void kn(int paramAnonymousInt)
      {
        AppMethodBeat.i(186398);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(186398);
          return;
          AppMethodBeat.o(186398);
          return;
          ac.i("MicroMsg.MMBackgroundRunningManagerService", "onPhoneCall, kill voip, state:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          i.this.aZF();
          i.this.aZG();
        }
      }
    };
    this.jyv = new AppBrandMainProcessService.a()
    {
      public final void Hk(String paramAnonymousString)
      {
        AppMethodBeat.i(186399);
        super.Hk(paramAnonymousString);
        ac.i("MicroMsg.MMBackgroundRunningManagerService", "onConnected, process:%s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(186399);
      }
      
      public final void onDisconnected(String paramAnonymousString)
      {
        AppMethodBeat.i(186400);
        super.onDisconnected(paramAnonymousString);
        ac.i("MicroMsg.MMBackgroundRunningManagerService", "onDisconnected, process:%s", new Object[] { paramAnonymousString });
        AppBrandBackgroundRunningOperationParcel localAppBrandBackgroundRunningOperationParcel = new AppBrandBackgroundRunningOperationParcel();
        localAppBrandBackgroundRunningOperationParcel.process = paramAnonymousString;
        localAppBrandBackgroundRunningOperationParcel.cZu = 3;
        i.this.c(localAppBrandBackgroundRunningOperationParcel);
        AppMethodBeat.o(186400);
      }
    };
    this.jyw = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(44795);
  }
  
  private static void c(MMBackgroundRunningOperationParcel paramMMBackgroundRunningOperationParcel)
  {
    AppMethodBeat.i(186405);
    if (!bs.isNullOrNil(paramMMBackgroundRunningOperationParcel.appId))
    {
      ac.i("MicroMsg.MMBackgroundRunningManagerService", "sendOperation from MM process, operation:%s", new Object[] { paramMMBackgroundRunningOperationParcel });
      com.tencent.mm.plugin.appbrand.ipc.e.b(paramMMBackgroundRunningOperationParcel.appId, paramMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(186405);
  }
  
  public final void a(h.a parama)
  {
    AppMethodBeat.i(44800);
    if (parama == null)
    {
      AppMethodBeat.o(44800);
      return;
    }
    synchronized (this.jys)
    {
      this.jys.add(parama);
      AppMethodBeat.o(44800);
      return;
    }
  }
  
  public final List<AppBrandBackgroundRunningApp> aZE()
  {
    AppMethodBeat.i(44799);
    ArrayList localArrayList = new ArrayList(this.jyr.values());
    AppMethodBeat.o(44799);
    return localArrayList;
  }
  
  public final void aZF()
  {
    AppMethodBeat.i(186403);
    Iterator localIterator = aZE().iterator();
    while (localIterator.hasNext())
    {
      AppBrandBackgroundRunningApp localAppBrandBackgroundRunningApp = (AppBrandBackgroundRunningApp)localIterator.next();
      MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
      localMMBackgroundRunningOperationParcel.appId = localAppBrandBackgroundRunningApp.appId;
      localMMBackgroundRunningOperationParcel.aUu = d.dD(d.jyg.aUu, d.jyi.aUu);
      localMMBackgroundRunningOperationParcel.cZu = 2;
      c(localMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(186403);
  }
  
  public final void aZG()
  {
    AppMethodBeat.i(186404);
    Iterator localIterator = aZE().iterator();
    while (localIterator.hasNext())
    {
      AppBrandBackgroundRunningApp localAppBrandBackgroundRunningApp = (AppBrandBackgroundRunningApp)localIterator.next();
      MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
      localMMBackgroundRunningOperationParcel.appId = localAppBrandBackgroundRunningApp.appId;
      localMMBackgroundRunningOperationParcel.aUu = d.jyh.aUu;
      localMMBackgroundRunningOperationParcel.cZu = 2;
      c(localMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(186404);
  }
  
  public final void ahM()
  {
    AppMethodBeat.i(44796);
    ac.i("MicroMsg.MMBackgroundRunningManagerService", "onRegister MMBackgroundRunningManagerService");
    this.jyt = new bb();
    this.jyt.iR(ai.getContext());
    this.jyt.a(this.jyu);
    this.jyr = new LinkedHashMap();
    ac.i("MicroMsg.AppBrandForegroundNotificationManager", "startListening");
    if (f.jyp == null) {
      f.jyp = new f.1();
    }
    if (g.ab(h.class) != null) {
      ((h)g.ab(h.class)).a(f.jyp);
    }
    AppBrandMainProcessService.a(this.jyv);
    a(com.tencent.mm.plugin.ball.service.d.bGD());
    this.jyw.alive();
    AppMethodBeat.o(44796);
  }
  
  public final void ahN()
  {
    AppMethodBeat.i(44797);
    ac.i("MicroMsg.MMBackgroundRunningManagerService", "onUnregister MMBackgroundRunningManagerService");
    aZF();
    this.jyt.b(this.jyu);
    this.jyt.end();
    ac.i("MicroMsg.AppBrandForegroundNotificationManager", "stopListening");
    if (f.jyp != null)
    {
      if (g.ab(h.class) != null) {
        ((h)g.ab(h.class)).b(f.jyp);
      }
      f.jyp = null;
    }
    AppBrandMainProcessService.b(this.jyv);
    b(com.tencent.mm.plugin.ball.service.d.bGD());
    this.jyw.dead();
    this.jys.clear();
    this.jyr.clear();
    this.jyr = null;
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
    synchronized (this.jys)
    {
      this.jys.remove(parama);
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
      ac.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation in MM process, operation:%s", new Object[] { paramAppBrandBackgroundRunningOperationParcel });
      if ((!bs.isNullOrNil(paramAppBrandBackgroundRunningOperationParcel.jxU)) && (paramAppBrandBackgroundRunningOperationParcel.jxU.endsWith(AppBrandPluginUI.class.getSimpleName())))
      {
        ac.w("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, ignore fake native mini program");
        AppMethodBeat.o(44798);
        return;
      }
      if (paramAppBrandBackgroundRunningOperationParcel.cZu == 3)
      {
        ??? = paramAppBrandBackgroundRunningOperationParcel.process;
        if (!bs.isNullOrNil((String)???))
        {
          localObject2 = this.jyr.entrySet().iterator();
          i = 0;
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (AppBrandBackgroundRunningApp)((Map.Entry)((Iterator)localObject2).next()).getValue();
            if (!((String)???).equalsIgnoreCase(((AppBrandBackgroundRunningApp)localObject3).process)) {
              break label1091;
            }
            if (bs.isNullOrNil(paramAppBrandBackgroundRunningOperationParcel.jxU)) {
              paramAppBrandBackgroundRunningOperationParcel.jxU = ((AppBrandBackgroundRunningApp)localObject3).jxU;
            }
            paramAppBrandBackgroundRunningOperationParcel.aUu |= ((AppBrandBackgroundRunningApp)localObject3).aUu;
            paramAppBrandBackgroundRunningOperationParcel.appId = ((AppBrandBackgroundRunningApp)localObject3).appId;
            paramAppBrandBackgroundRunningOperationParcel.hxM = ((AppBrandBackgroundRunningApp)localObject3).hxM;
            this.jyr.remove(((AppBrandBackgroundRunningApp)localObject3).appId);
            ac.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, operation kill process:%s, app:%s", new Object[] { ???, ((AppBrandBackgroundRunningApp)localObject3).appId });
            if (!bs.isNullOrNil(((AppBrandBackgroundRunningApp)localObject3).jxV))
            {
              Object localObject4 = e.Jt(((AppBrandBackgroundRunningApp)localObject3).jxV);
              if (localObject4 == null)
              {
                ac.w("MicroMsg.MMBackgroundRunningManagerService", "cancelCustomNotificationFallback for %s, customNotificationLogicClass is null", new Object[] { ((AppBrandBackgroundRunningApp)localObject3).appId });
                i = 3;
              }
              else
              {
                o localo = a.GU(((AppBrandBackgroundRunningApp)localObject3).appId);
                if (localo == null)
                {
                  ac.w("MicroMsg.MMBackgroundRunningManagerService", "cancelCustomNotificationFallback for %s, runtime is null", new Object[] { ((AppBrandBackgroundRunningApp)localObject3).appId });
                  i = 3;
                }
                else
                {
                  localObject4 = (CustomBackgroundRunningNotificationLogic)localo.as((Class)localObject4);
                  if (localObject4 == null)
                  {
                    ac.w("MicroMsg.MMBackgroundRunningManagerService", "cancelCustomNotificationFallback for %s, customNotificationLogic is null", new Object[] { ((AppBrandBackgroundRunningApp)localObject3).appId });
                    i = 3;
                  }
                  else
                  {
                    if (jyx == null) {
                      jyx = (NotificationManager)ai.getContext().getSystemService("notification");
                    }
                    jyx.cancel(((CustomBackgroundRunningNotificationLogic)localObject4).aZv());
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
          synchronized (this.jys)
          {
            localObject2 = aZE();
            localObject3 = this.jys.iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break label928;
            }
            ((h.a)((Iterator)localObject3).next()).a((List)localObject2, paramAppBrandBackgroundRunningOperationParcel, i);
          }
          ac.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, operation kill, no process");
          i = j;
          continue;
          ??? = (AppBrandBackgroundRunningApp)this.jyr.get(paramAppBrandBackgroundRunningOperationParcel.appId);
          if (??? != null)
          {
            if (paramAppBrandBackgroundRunningOperationParcel.cZu == 1)
            {
              if (!d.contains(((AppBrandBackgroundRunningApp)???).aUu, paramAppBrandBackgroundRunningOperationParcel.aUu))
              {
                ((AppBrandBackgroundRunningApp)???).aUu = d.dD(((AppBrandBackgroundRunningApp)???).aUu, paramAppBrandBackgroundRunningOperationParcel.aUu);
                ac.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, app(%s) add new usage(%s)", new Object[] { paramAppBrandBackgroundRunningOperationParcel.appId, Integer.valueOf(paramAppBrandBackgroundRunningOperationParcel.aUu) });
                i = 2;
                continue;
              }
              ac.w("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, this app has been added before, but now it wants to add a same usage!!!");
              i = j;
              continue;
            }
            i = j;
            if (paramAppBrandBackgroundRunningOperationParcel.cZu != 2) {
              continue;
            }
            if (d.contains(((AppBrandBackgroundRunningApp)???).aUu, paramAppBrandBackgroundRunningOperationParcel.aUu))
            {
              paramAppBrandBackgroundRunningOperationParcel.hxM = ((AppBrandBackgroundRunningApp)???).hxM;
              ((AppBrandBackgroundRunningApp)???).aUu = d.dE(((AppBrandBackgroundRunningApp)???).aUu, paramAppBrandBackgroundRunningOperationParcel.aUu);
              ac.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, app(%s) remove usage(%s)", new Object[] { paramAppBrandBackgroundRunningOperationParcel.appId, Integer.valueOf(paramAppBrandBackgroundRunningOperationParcel.aUu) });
              if (((AppBrandBackgroundRunningApp)???).aUu == 0)
              {
                if (bs.isNullOrNil(paramAppBrandBackgroundRunningOperationParcel.jxU)) {
                  paramAppBrandBackgroundRunningOperationParcel.jxU = ((AppBrandBackgroundRunningApp)???).jxU;
                }
                this.jyr.remove(paramAppBrandBackgroundRunningOperationParcel.appId);
                ac.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, app(%s) has been removed", new Object[] { paramAppBrandBackgroundRunningOperationParcel.appId });
                i = 3;
              }
            }
            else
            {
              ac.w("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, this app has been added before, but now it wants to remove not added usage!!!");
              i = j;
            }
          }
          else
          {
            if (paramAppBrandBackgroundRunningOperationParcel.cZu == 1)
            {
              ??? = new AppBrandBackgroundRunningApp();
              ((AppBrandBackgroundRunningApp)???).appId = paramAppBrandBackgroundRunningOperationParcel.appId;
              ((AppBrandBackgroundRunningApp)???).hxM = paramAppBrandBackgroundRunningOperationParcel.hxM;
              ((AppBrandBackgroundRunningApp)???).aUu = paramAppBrandBackgroundRunningOperationParcel.aUu;
              ((AppBrandBackgroundRunningApp)???).name = paramAppBrandBackgroundRunningOperationParcel.name;
              ((AppBrandBackgroundRunningApp)???).drM = paramAppBrandBackgroundRunningOperationParcel.drM;
              ((AppBrandBackgroundRunningApp)???).username = paramAppBrandBackgroundRunningOperationParcel.username;
              ((AppBrandBackgroundRunningApp)???).jxU = paramAppBrandBackgroundRunningOperationParcel.jxU;
              ((AppBrandBackgroundRunningApp)???).process = paramAppBrandBackgroundRunningOperationParcel.process;
              ((AppBrandBackgroundRunningApp)???).jxV = paramAppBrandBackgroundRunningOperationParcel.jxV;
              this.jyr.put(((AppBrandBackgroundRunningApp)???).appId, ???);
              ac.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, add app(%s) with usage(%s)", new Object[] { paramAppBrandBackgroundRunningOperationParcel.appId, Integer.valueOf(paramAppBrandBackgroundRunningOperationParcel.aUu) });
              i = 1;
              continue;
            }
            i = j;
            if (paramAppBrandBackgroundRunningOperationParcel.cZu != 2) {
              continue;
            }
            ac.w("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, this app has not been added before, but now it wants to remove some usage!!!");
            i = j;
            continue;
            if (((List)localObject2).isEmpty()) {}
            for (paramAppBrandBackgroundRunningOperationParcel = null;; paramAppBrandBackgroundRunningOperationParcel = paramAppBrandBackgroundRunningOperationParcel.toString())
            {
              ac.i("MicroMsg.MMBackgroundRunningManagerService", "report background running app list changed, note:%s", new Object[] { paramAppBrandBackgroundRunningOperationParcel });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.i
 * JD-Core Version:    0.7.0.1
 */