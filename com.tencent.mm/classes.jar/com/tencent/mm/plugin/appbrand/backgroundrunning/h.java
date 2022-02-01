package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.app.NotificationManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.a;
import com.tencent.mm.plugin.appbrand.q;
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
  private static NotificationManager kYH = null;
  private LinkedHashMap<String, AppBrandBackgroundRunningApp> kYB;
  private final HashSet<g.a> kYC;
  private PhoneStatusWatcher kYD;
  private PhoneStatusWatcher.PhoneCallListener kYE;
  private final AppBrandMainProcessService.a kYF;
  private IListener<zj> kYG;
  
  public h()
  {
    AppMethodBeat.i(44795);
    this.kYC = new HashSet();
    this.kYE = new PhoneStatusWatcher.PhoneCallListener()
    {
      public final void onPhoneCall(int paramAnonymousInt)
      {
        AppMethodBeat.i(226452);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(226452);
          return;
          AppMethodBeat.o(226452);
          return;
          Log.i("MicroMsg.MMBackgroundRunningManagerService", "onPhoneCall, kill voip, state:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          h.this.bza();
          h.this.bzb();
        }
      }
    };
    this.kYF = new AppBrandMainProcessService.a()
    {
      public final void Uf(String paramAnonymousString)
      {
        AppMethodBeat.i(226453);
        super.Uf(paramAnonymousString);
        Log.i("MicroMsg.MMBackgroundRunningManagerService", "onConnected, process:%s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(226453);
      }
      
      public final void onDisconnected(String paramAnonymousString)
      {
        AppMethodBeat.i(226454);
        super.onDisconnected(paramAnonymousString);
        Log.i("MicroMsg.MMBackgroundRunningManagerService", "onDisconnected, process:%s", new Object[] { paramAnonymousString });
        AppBrandBackgroundRunningOperationParcel localAppBrandBackgroundRunningOperationParcel = new AppBrandBackgroundRunningOperationParcel();
        localAppBrandBackgroundRunningOperationParcel.process = paramAnonymousString;
        localAppBrandBackgroundRunningOperationParcel.dDe = 3;
        h.this.c(localAppBrandBackgroundRunningOperationParcel);
        AppMethodBeat.o(226454);
      }
    };
    this.kYG = new IListener() {};
    AppMethodBeat.o(44795);
  }
  
  private static void c(MMBackgroundRunningOperationParcel paramMMBackgroundRunningOperationParcel)
  {
    AppMethodBeat.i(226459);
    if (!Util.isNullOrNil(paramMMBackgroundRunningOperationParcel.appId))
    {
      Log.i("MicroMsg.MMBackgroundRunningManagerService", "sendOperation from MM process, operation:%s", new Object[] { paramMMBackgroundRunningOperationParcel });
      com.tencent.mm.plugin.appbrand.ipc.e.b(paramMMBackgroundRunningOperationParcel.appId, paramMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(226459);
  }
  
  public final void a(g.a parama)
  {
    AppMethodBeat.i(44800);
    if (parama == null)
    {
      AppMethodBeat.o(44800);
      return;
    }
    synchronized (this.kYC)
    {
      this.kYC.add(parama);
      AppMethodBeat.o(44800);
      return;
    }
  }
  
  public final void aBc()
  {
    AppMethodBeat.i(44796);
    Log.i("MicroMsg.MMBackgroundRunningManagerService", "onRegister MMBackgroundRunningManagerService");
    this.kYD = new PhoneStatusWatcher();
    this.kYD.begin(MMApplicationContext.getContext());
    this.kYD.addPhoneCallListener(this.kYE);
    this.kYB = new LinkedHashMap();
    Log.i("MicroMsg.AppBrandForegroundNotificationManager", "startListening");
    if (e.kYz == null) {
      e.kYz = new e.1();
    }
    if (com.tencent.mm.kernel.g.af(g.class) != null) {
      ((g)com.tencent.mm.kernel.g.af(g.class)).a(e.kYz);
    }
    AppBrandMainProcessService.a(this.kYF);
    a(com.tencent.mm.plugin.ball.service.d.ciB());
    this.kYG.alive();
    AppMethodBeat.o(44796);
  }
  
  public final void aBd()
  {
    AppMethodBeat.i(44797);
    Log.i("MicroMsg.MMBackgroundRunningManagerService", "onUnregister MMBackgroundRunningManagerService");
    bza();
    this.kYD.removePhoneCallListener(this.kYE);
    this.kYD.end();
    Log.i("MicroMsg.AppBrandForegroundNotificationManager", "stopListening");
    if (e.kYz != null)
    {
      if (com.tencent.mm.kernel.g.af(g.class) != null) {
        ((g)com.tencent.mm.kernel.g.af(g.class)).b(e.kYz);
      }
      e.kYz = null;
    }
    AppBrandMainProcessService.b(this.kYF);
    b(com.tencent.mm.plugin.ball.service.d.ciB());
    this.kYG.dead();
    this.kYC.clear();
    this.kYB.clear();
    this.kYB = null;
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
    synchronized (this.kYC)
    {
      this.kYC.remove(parama);
      AppMethodBeat.o(44801);
      return;
    }
  }
  
  public final List<AppBrandBackgroundRunningApp> byZ()
  {
    AppMethodBeat.i(44799);
    ArrayList localArrayList = new ArrayList(this.kYB.values());
    AppMethodBeat.o(44799);
    return localArrayList;
  }
  
  public final void bza()
  {
    AppMethodBeat.i(226457);
    Iterator localIterator = byZ().iterator();
    while (localIterator.hasNext())
    {
      AppBrandBackgroundRunningApp localAppBrandBackgroundRunningApp = (AppBrandBackgroundRunningApp)localIterator.next();
      MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
      localMMBackgroundRunningOperationParcel.appId = localAppBrandBackgroundRunningApp.appId;
      localMMBackgroundRunningOperationParcel.beL = c.dQ(c.kYq.beL, c.kYs.beL);
      localMMBackgroundRunningOperationParcel.dDe = 2;
      c(localMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(226457);
  }
  
  public final void bzb()
  {
    AppMethodBeat.i(226458);
    Iterator localIterator = byZ().iterator();
    while (localIterator.hasNext())
    {
      AppBrandBackgroundRunningApp localAppBrandBackgroundRunningApp = (AppBrandBackgroundRunningApp)localIterator.next();
      MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
      localMMBackgroundRunningOperationParcel.appId = localAppBrandBackgroundRunningApp.appId;
      localMMBackgroundRunningOperationParcel.beL = c.kYr.beL;
      localMMBackgroundRunningOperationParcel.dDe = 2;
      c(localMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(226458);
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
      if ((!Util.isNullOrNil(paramAppBrandBackgroundRunningOperationParcel.kYe)) && (paramAppBrandBackgroundRunningOperationParcel.kYe.endsWith(AppBrandPluginUI.class.getSimpleName())))
      {
        Log.w("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, ignore fake native mini program");
        AppMethodBeat.o(44798);
        return;
      }
      if (paramAppBrandBackgroundRunningOperationParcel.dDe == 3)
      {
        ??? = paramAppBrandBackgroundRunningOperationParcel.process;
        if (!Util.isNullOrNil((String)???))
        {
          localObject2 = this.kYB.entrySet().iterator();
          i = 0;
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (AppBrandBackgroundRunningApp)((Map.Entry)((Iterator)localObject2).next()).getValue();
            if (!((String)???).equalsIgnoreCase(((AppBrandBackgroundRunningApp)localObject3).process)) {
              break label1090;
            }
            if (Util.isNullOrNil(paramAppBrandBackgroundRunningOperationParcel.kYe)) {
              paramAppBrandBackgroundRunningOperationParcel.kYe = ((AppBrandBackgroundRunningApp)localObject3).kYe;
            }
            paramAppBrandBackgroundRunningOperationParcel.beL |= ((AppBrandBackgroundRunningApp)localObject3).beL;
            paramAppBrandBackgroundRunningOperationParcel.appId = ((AppBrandBackgroundRunningApp)localObject3).appId;
            paramAppBrandBackgroundRunningOperationParcel.iOo = ((AppBrandBackgroundRunningApp)localObject3).iOo;
            this.kYB.remove(((AppBrandBackgroundRunningApp)localObject3).appId);
            Log.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, operation kill process:%s, app:%s", new Object[] { ???, ((AppBrandBackgroundRunningApp)localObject3).appId });
            if (!Util.isNullOrNil(((AppBrandBackgroundRunningApp)localObject3).kYf))
            {
              Object localObject4 = d.WB(((AppBrandBackgroundRunningApp)localObject3).kYf);
              if (localObject4 == null)
              {
                Log.w("MicroMsg.MMBackgroundRunningManagerService", "cancelCustomNotificationFallback for %s, customNotificationLogicClass is null", new Object[] { ((AppBrandBackgroundRunningApp)localObject3).appId });
                i = 3;
              }
              else
              {
                q localq = a.TQ(((AppBrandBackgroundRunningApp)localObject3).appId);
                if (localq == null)
                {
                  Log.w("MicroMsg.MMBackgroundRunningManagerService", "cancelCustomNotificationFallback for %s, runtime is null", new Object[] { ((AppBrandBackgroundRunningApp)localObject3).appId });
                  i = 3;
                }
                else
                {
                  localObject4 = (CustomBackgroundRunningNotificationLogic)localq.aw((Class)localObject4);
                  if (localObject4 == null)
                  {
                    Log.w("MicroMsg.MMBackgroundRunningManagerService", "cancelCustomNotificationFallback for %s, customNotificationLogic is null", new Object[] { ((AppBrandBackgroundRunningApp)localObject3).appId });
                    i = 3;
                  }
                  else
                  {
                    if (kYH == null) {
                      kYH = (NotificationManager)MMApplicationContext.getContext().getSystemService("notification");
                    }
                    kYH.cancel(((CustomBackgroundRunningNotificationLogic)localObject4).getNotificationId());
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
          synchronized (this.kYC)
          {
            localObject2 = byZ();
            localObject3 = this.kYC.iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break label928;
            }
            ((g.a)((Iterator)localObject3).next()).a((List)localObject2, paramAppBrandBackgroundRunningOperationParcel, i);
          }
          Log.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, operation kill, no process");
          i = j;
          continue;
          ??? = (AppBrandBackgroundRunningApp)this.kYB.get(paramAppBrandBackgroundRunningOperationParcel.appId);
          if (??? != null)
          {
            if (paramAppBrandBackgroundRunningOperationParcel.dDe == 1)
            {
              if (!c.contains(((AppBrandBackgroundRunningApp)???).beL, paramAppBrandBackgroundRunningOperationParcel.beL))
              {
                ((AppBrandBackgroundRunningApp)???).beL = c.dQ(((AppBrandBackgroundRunningApp)???).beL, paramAppBrandBackgroundRunningOperationParcel.beL);
                Log.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, app(%s) add new usage(%s)", new Object[] { paramAppBrandBackgroundRunningOperationParcel.appId, Integer.valueOf(paramAppBrandBackgroundRunningOperationParcel.beL) });
                i = 2;
                continue;
              }
              Log.w("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, this app has been added before, but now it wants to add a same usage!!!");
              i = j;
              continue;
            }
            i = j;
            if (paramAppBrandBackgroundRunningOperationParcel.dDe != 2) {
              continue;
            }
            if (c.contains(((AppBrandBackgroundRunningApp)???).beL, paramAppBrandBackgroundRunningOperationParcel.beL))
            {
              paramAppBrandBackgroundRunningOperationParcel.iOo = ((AppBrandBackgroundRunningApp)???).iOo;
              ((AppBrandBackgroundRunningApp)???).beL = c.dR(((AppBrandBackgroundRunningApp)???).beL, paramAppBrandBackgroundRunningOperationParcel.beL);
              Log.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, app(%s) remove usage(%s)", new Object[] { paramAppBrandBackgroundRunningOperationParcel.appId, Integer.valueOf(paramAppBrandBackgroundRunningOperationParcel.beL) });
              if (((AppBrandBackgroundRunningApp)???).beL == 0)
              {
                if (Util.isNullOrNil(paramAppBrandBackgroundRunningOperationParcel.kYe)) {
                  paramAppBrandBackgroundRunningOperationParcel.kYe = ((AppBrandBackgroundRunningApp)???).kYe;
                }
                this.kYB.remove(paramAppBrandBackgroundRunningOperationParcel.appId);
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
            if (paramAppBrandBackgroundRunningOperationParcel.dDe == 1)
            {
              ??? = new AppBrandBackgroundRunningApp();
              ((AppBrandBackgroundRunningApp)???).appId = paramAppBrandBackgroundRunningOperationParcel.appId;
              ((AppBrandBackgroundRunningApp)???).iOo = paramAppBrandBackgroundRunningOperationParcel.iOo;
              ((AppBrandBackgroundRunningApp)???).beL = paramAppBrandBackgroundRunningOperationParcel.beL;
              ((AppBrandBackgroundRunningApp)???).name = paramAppBrandBackgroundRunningOperationParcel.name;
              ((AppBrandBackgroundRunningApp)???).icon = paramAppBrandBackgroundRunningOperationParcel.icon;
              ((AppBrandBackgroundRunningApp)???).username = paramAppBrandBackgroundRunningOperationParcel.username;
              ((AppBrandBackgroundRunningApp)???).kYe = paramAppBrandBackgroundRunningOperationParcel.kYe;
              ((AppBrandBackgroundRunningApp)???).process = paramAppBrandBackgroundRunningOperationParcel.process;
              ((AppBrandBackgroundRunningApp)???).kYf = paramAppBrandBackgroundRunningOperationParcel.kYf;
              this.kYB.put(((AppBrandBackgroundRunningApp)???).appId, ???);
              Log.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, add app(%s) with usage(%s)", new Object[] { paramAppBrandBackgroundRunningOperationParcel.appId, Integer.valueOf(paramAppBrandBackgroundRunningOperationParcel.beL) });
              i = 1;
              continue;
            }
            i = j;
            if (paramAppBrandBackgroundRunningOperationParcel.dDe != 2) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.h
 * JD-Core Version:    0.7.0.1
 */