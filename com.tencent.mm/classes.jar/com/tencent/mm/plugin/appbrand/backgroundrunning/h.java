package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.app.NotificationManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.a;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bd.a;
import com.tencent.mm.sdk.platformtools.bu;
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
  private static NotificationManager jVL = null;
  private LinkedHashMap<String, AppBrandBackgroundRunningApp> jVF;
  private final HashSet<g.a> jVG;
  private bd jVH;
  private bd.a jVI;
  private final AppBrandMainProcessService.a jVJ;
  private com.tencent.mm.sdk.b.c<yh> jVK;
  
  public h()
  {
    AppMethodBeat.i(44795);
    this.jVG = new HashSet();
    this.jVI = new bd.a()
    {
      public final void kM(int paramAnonymousInt)
      {
        AppMethodBeat.i(222211);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(222211);
          return;
          AppMethodBeat.o(222211);
          return;
          ae.i("MicroMsg.MMBackgroundRunningManagerService", "onPhoneCall, kill voip, state:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          h.this.bdJ();
          h.this.bdK();
        }
      }
    };
    this.jVJ = new AppBrandMainProcessService.a()
    {
      public final void KW(String paramAnonymousString)
      {
        AppMethodBeat.i(222212);
        super.KW(paramAnonymousString);
        ae.i("MicroMsg.MMBackgroundRunningManagerService", "onConnected, process:%s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(222212);
      }
      
      public final void onDisconnected(String paramAnonymousString)
      {
        AppMethodBeat.i(222213);
        super.onDisconnected(paramAnonymousString);
        ae.i("MicroMsg.MMBackgroundRunningManagerService", "onDisconnected, process:%s", new Object[] { paramAnonymousString });
        AppBrandBackgroundRunningOperationParcel localAppBrandBackgroundRunningOperationParcel = new AppBrandBackgroundRunningOperationParcel();
        localAppBrandBackgroundRunningOperationParcel.process = paramAnonymousString;
        localAppBrandBackgroundRunningOperationParcel.dlO = 3;
        h.this.c(localAppBrandBackgroundRunningOperationParcel);
        AppMethodBeat.o(222213);
      }
    };
    this.jVK = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(44795);
  }
  
  private static void c(MMBackgroundRunningOperationParcel paramMMBackgroundRunningOperationParcel)
  {
    AppMethodBeat.i(222218);
    if (!bu.isNullOrNil(paramMMBackgroundRunningOperationParcel.appId))
    {
      ae.i("MicroMsg.MMBackgroundRunningManagerService", "sendOperation from MM process, operation:%s", new Object[] { paramMMBackgroundRunningOperationParcel });
      com.tencent.mm.plugin.appbrand.ipc.e.b(paramMMBackgroundRunningOperationParcel.appId, paramMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(222218);
  }
  
  public final void a(g.a parama)
  {
    AppMethodBeat.i(44800);
    if (parama == null)
    {
      AppMethodBeat.o(44800);
      return;
    }
    synchronized (this.jVG)
    {
      this.jVG.add(parama);
      AppMethodBeat.o(44800);
      return;
    }
  }
  
  public final void akM()
  {
    AppMethodBeat.i(44796);
    ae.i("MicroMsg.MMBackgroundRunningManagerService", "onRegister MMBackgroundRunningManagerService");
    this.jVH = new bd();
    this.jVH.jg(ak.getContext());
    this.jVH.a(this.jVI);
    this.jVF = new LinkedHashMap();
    ae.i("MicroMsg.AppBrandForegroundNotificationManager", "startListening");
    if (e.jVD == null) {
      e.jVD = new e.1();
    }
    if (com.tencent.mm.kernel.g.ab(g.class) != null) {
      ((g)com.tencent.mm.kernel.g.ab(g.class)).a(e.jVD);
    }
    AppBrandMainProcessService.a(this.jVJ);
    a(com.tencent.mm.plugin.ball.service.d.bLK());
    this.jVK.alive();
    AppMethodBeat.o(44796);
  }
  
  public final void akN()
  {
    AppMethodBeat.i(44797);
    ae.i("MicroMsg.MMBackgroundRunningManagerService", "onUnregister MMBackgroundRunningManagerService");
    bdJ();
    this.jVH.b(this.jVI);
    this.jVH.end();
    ae.i("MicroMsg.AppBrandForegroundNotificationManager", "stopListening");
    if (e.jVD != null)
    {
      if (com.tencent.mm.kernel.g.ab(g.class) != null) {
        ((g)com.tencent.mm.kernel.g.ab(g.class)).b(e.jVD);
      }
      e.jVD = null;
    }
    AppBrandMainProcessService.b(this.jVJ);
    b(com.tencent.mm.plugin.ball.service.d.bLK());
    this.jVK.dead();
    this.jVG.clear();
    this.jVF.clear();
    this.jVF = null;
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
    synchronized (this.jVG)
    {
      this.jVG.remove(parama);
      AppMethodBeat.o(44801);
      return;
    }
  }
  
  public final List<AppBrandBackgroundRunningApp> bdI()
  {
    AppMethodBeat.i(44799);
    ArrayList localArrayList = new ArrayList(this.jVF.values());
    AppMethodBeat.o(44799);
    return localArrayList;
  }
  
  public final void bdJ()
  {
    AppMethodBeat.i(222216);
    Iterator localIterator = bdI().iterator();
    while (localIterator.hasNext())
    {
      AppBrandBackgroundRunningApp localAppBrandBackgroundRunningApp = (AppBrandBackgroundRunningApp)localIterator.next();
      MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
      localMMBackgroundRunningOperationParcel.appId = localAppBrandBackgroundRunningApp.appId;
      localMMBackgroundRunningOperationParcel.beO = c.dF(c.jVu.beO, c.jVw.beO);
      localMMBackgroundRunningOperationParcel.dlO = 2;
      c(localMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(222216);
  }
  
  public final void bdK()
  {
    AppMethodBeat.i(222217);
    Iterator localIterator = bdI().iterator();
    while (localIterator.hasNext())
    {
      AppBrandBackgroundRunningApp localAppBrandBackgroundRunningApp = (AppBrandBackgroundRunningApp)localIterator.next();
      MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
      localMMBackgroundRunningOperationParcel.appId = localAppBrandBackgroundRunningApp.appId;
      localMMBackgroundRunningOperationParcel.beO = c.jVv.beO;
      localMMBackgroundRunningOperationParcel.dlO = 2;
      c(localMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(222217);
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
      ae.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation in MM process, operation:%s", new Object[] { paramAppBrandBackgroundRunningOperationParcel });
      if ((!bu.isNullOrNil(paramAppBrandBackgroundRunningOperationParcel.jVi)) && (paramAppBrandBackgroundRunningOperationParcel.jVi.endsWith(AppBrandPluginUI.class.getSimpleName())))
      {
        ae.w("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, ignore fake native mini program");
        AppMethodBeat.o(44798);
        return;
      }
      if (paramAppBrandBackgroundRunningOperationParcel.dlO == 3)
      {
        ??? = paramAppBrandBackgroundRunningOperationParcel.process;
        if (!bu.isNullOrNil((String)???))
        {
          localObject2 = this.jVF.entrySet().iterator();
          i = 0;
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (AppBrandBackgroundRunningApp)((Map.Entry)((Iterator)localObject2).next()).getValue();
            if (!((String)???).equalsIgnoreCase(((AppBrandBackgroundRunningApp)localObject3).process)) {
              break label1090;
            }
            if (bu.isNullOrNil(paramAppBrandBackgroundRunningOperationParcel.jVi)) {
              paramAppBrandBackgroundRunningOperationParcel.jVi = ((AppBrandBackgroundRunningApp)localObject3).jVi;
            }
            paramAppBrandBackgroundRunningOperationParcel.beO |= ((AppBrandBackgroundRunningApp)localObject3).beO;
            paramAppBrandBackgroundRunningOperationParcel.appId = ((AppBrandBackgroundRunningApp)localObject3).appId;
            paramAppBrandBackgroundRunningOperationParcel.hSZ = ((AppBrandBackgroundRunningApp)localObject3).hSZ;
            this.jVF.remove(((AppBrandBackgroundRunningApp)localObject3).appId);
            ae.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, operation kill process:%s, app:%s", new Object[] { ???, ((AppBrandBackgroundRunningApp)localObject3).appId });
            if (!bu.isNullOrNil(((AppBrandBackgroundRunningApp)localObject3).jVj))
            {
              Object localObject4 = d.Nt(((AppBrandBackgroundRunningApp)localObject3).jVj);
              if (localObject4 == null)
              {
                ae.w("MicroMsg.MMBackgroundRunningManagerService", "cancelCustomNotificationFallback for %s, customNotificationLogicClass is null", new Object[] { ((AppBrandBackgroundRunningApp)localObject3).appId });
                i = 3;
              }
              else
              {
                p localp = a.KI(((AppBrandBackgroundRunningApp)localObject3).appId);
                if (localp == null)
                {
                  ae.w("MicroMsg.MMBackgroundRunningManagerService", "cancelCustomNotificationFallback for %s, runtime is null", new Object[] { ((AppBrandBackgroundRunningApp)localObject3).appId });
                  i = 3;
                }
                else
                {
                  localObject4 = (CustomBackgroundRunningNotificationLogic)localp.as((Class)localObject4);
                  if (localObject4 == null)
                  {
                    ae.w("MicroMsg.MMBackgroundRunningManagerService", "cancelCustomNotificationFallback for %s, customNotificationLogic is null", new Object[] { ((AppBrandBackgroundRunningApp)localObject3).appId });
                    i = 3;
                  }
                  else
                  {
                    if (jVL == null) {
                      jVL = (NotificationManager)ak.getContext().getSystemService("notification");
                    }
                    jVL.cancel(((CustomBackgroundRunningNotificationLogic)localObject4).bdy());
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
          synchronized (this.jVG)
          {
            localObject2 = bdI();
            localObject3 = this.jVG.iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break label928;
            }
            ((g.a)((Iterator)localObject3).next()).a((List)localObject2, paramAppBrandBackgroundRunningOperationParcel, i);
          }
          ae.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, operation kill, no process");
          i = j;
          continue;
          ??? = (AppBrandBackgroundRunningApp)this.jVF.get(paramAppBrandBackgroundRunningOperationParcel.appId);
          if (??? != null)
          {
            if (paramAppBrandBackgroundRunningOperationParcel.dlO == 1)
            {
              if (!c.contains(((AppBrandBackgroundRunningApp)???).beO, paramAppBrandBackgroundRunningOperationParcel.beO))
              {
                ((AppBrandBackgroundRunningApp)???).beO = c.dF(((AppBrandBackgroundRunningApp)???).beO, paramAppBrandBackgroundRunningOperationParcel.beO);
                ae.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, app(%s) add new usage(%s)", new Object[] { paramAppBrandBackgroundRunningOperationParcel.appId, Integer.valueOf(paramAppBrandBackgroundRunningOperationParcel.beO) });
                i = 2;
                continue;
              }
              ae.w("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, this app has been added before, but now it wants to add a same usage!!!");
              i = j;
              continue;
            }
            i = j;
            if (paramAppBrandBackgroundRunningOperationParcel.dlO != 2) {
              continue;
            }
            if (c.contains(((AppBrandBackgroundRunningApp)???).beO, paramAppBrandBackgroundRunningOperationParcel.beO))
            {
              paramAppBrandBackgroundRunningOperationParcel.hSZ = ((AppBrandBackgroundRunningApp)???).hSZ;
              ((AppBrandBackgroundRunningApp)???).beO = c.dG(((AppBrandBackgroundRunningApp)???).beO, paramAppBrandBackgroundRunningOperationParcel.beO);
              ae.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, app(%s) remove usage(%s)", new Object[] { paramAppBrandBackgroundRunningOperationParcel.appId, Integer.valueOf(paramAppBrandBackgroundRunningOperationParcel.beO) });
              if (((AppBrandBackgroundRunningApp)???).beO == 0)
              {
                if (bu.isNullOrNil(paramAppBrandBackgroundRunningOperationParcel.jVi)) {
                  paramAppBrandBackgroundRunningOperationParcel.jVi = ((AppBrandBackgroundRunningApp)???).jVi;
                }
                this.jVF.remove(paramAppBrandBackgroundRunningOperationParcel.appId);
                ae.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, app(%s) has been removed", new Object[] { paramAppBrandBackgroundRunningOperationParcel.appId });
                i = 3;
              }
            }
            else
            {
              ae.w("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, this app has been added before, but now it wants to remove not added usage!!!");
              i = j;
            }
          }
          else
          {
            if (paramAppBrandBackgroundRunningOperationParcel.dlO == 1)
            {
              ??? = new AppBrandBackgroundRunningApp();
              ((AppBrandBackgroundRunningApp)???).appId = paramAppBrandBackgroundRunningOperationParcel.appId;
              ((AppBrandBackgroundRunningApp)???).hSZ = paramAppBrandBackgroundRunningOperationParcel.hSZ;
              ((AppBrandBackgroundRunningApp)???).beO = paramAppBrandBackgroundRunningOperationParcel.beO;
              ((AppBrandBackgroundRunningApp)???).name = paramAppBrandBackgroundRunningOperationParcel.name;
              ((AppBrandBackgroundRunningApp)???).dEM = paramAppBrandBackgroundRunningOperationParcel.dEM;
              ((AppBrandBackgroundRunningApp)???).username = paramAppBrandBackgroundRunningOperationParcel.username;
              ((AppBrandBackgroundRunningApp)???).jVi = paramAppBrandBackgroundRunningOperationParcel.jVi;
              ((AppBrandBackgroundRunningApp)???).process = paramAppBrandBackgroundRunningOperationParcel.process;
              ((AppBrandBackgroundRunningApp)???).jVj = paramAppBrandBackgroundRunningOperationParcel.jVj;
              this.jVF.put(((AppBrandBackgroundRunningApp)???).appId, ???);
              ae.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, add app(%s) with usage(%s)", new Object[] { paramAppBrandBackgroundRunningOperationParcel.appId, Integer.valueOf(paramAppBrandBackgroundRunningOperationParcel.beO) });
              i = 1;
              continue;
            }
            i = j;
            if (paramAppBrandBackgroundRunningOperationParcel.dlO != 2) {
              continue;
            }
            ae.w("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, this app has not been added before, but now it wants to remove some usage!!!");
            i = j;
            continue;
            if (((List)localObject2).isEmpty()) {}
            for (paramAppBrandBackgroundRunningOperationParcel = null;; paramAppBrandBackgroundRunningOperationParcel = paramAppBrandBackgroundRunningOperationParcel.toString())
            {
              ae.i("MicroMsg.MMBackgroundRunningManagerService", "report background running app list changed, note:%s", new Object[] { paramAppBrandBackgroundRunningOperationParcel });
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.h
 * JD-Core Version:    0.7.0.1
 */