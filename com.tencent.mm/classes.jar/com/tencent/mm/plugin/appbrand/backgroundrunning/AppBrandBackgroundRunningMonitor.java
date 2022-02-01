package com.tencent.mm.plugin.appbrand.backgroundrunning;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.ipc.e;
import com.tencent.mm.plugin.appbrand.jsapi.EventLocationBackgroundStateChanged;
import com.tencent.mm.plugin.appbrand.jsapi.i.t;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AuthStateChangedByUserEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.HashSet;
import java.util.Set;

public final class AppBrandBackgroundRunningMonitor
{
  private static MMToClientEvent.c kYj;
  private static f.a kYk;
  private static IListener kYl;
  private static Set<String> kYm;
  
  static
  {
    AppMethodBeat.i(226443);
    kYl = new IListener() {};
    kYm = new HashSet();
    AppMethodBeat.o(226443);
  }
  
  private static void WA(String paramString)
  {
    AppMethodBeat.i(44783);
    if (MMApplicationContext.isMMProcess())
    {
      ak(paramString, false);
      AppMethodBeat.o(44783);
      return;
    }
    XIPCInvoker.a(MainProcessIPCService.dkO, new AppBrandBackgroundRunningMonitor.NotifyLocationBackgroundChanged(paramString), AppBrandBackgroundRunningMonitor.a.class, null);
    AppMethodBeat.o(44783);
  }
  
  public static void a(q paramq, AppBrandAuthorizeUI.AuthStateChangedByUserEvent paramAuthStateChangedByUserEvent)
  {
    AppMethodBeat.i(226431);
    Object localObject;
    boolean bool1;
    if (paramq != null)
    {
      localObject = (com.tencent.mm.plugin.appbrand.jsapi.i.s)paramq.aw(com.tencent.mm.plugin.appbrand.jsapi.i.s.class);
      if (!(localObject instanceof t))
      {
        Log.w("MicroMsg.AppBrandBackgroundRunningMonitor", "handleUserAuthChanged, invalid location state manager");
        AppMethodBeat.o(226431);
        return;
      }
      localObject = (t)localObject;
      bool2 = paramAuthStateChangedByUserEvent.nSk;
      boolean bool3 = paramAuthStateChangedByUserEvent.nSl;
      if ((((com.tencent.mm.plugin.appbrand.jsapi.i.s)localObject).lXu) || (bool2)) {
        break label150;
      }
      bool1 = true;
      if ((!((com.tencent.mm.plugin.appbrand.jsapi.i.s)localObject).lXu) || ((bool3) && (bool2))) {
        break label155;
      }
    }
    label150:
    label155:
    for (boolean bool2 = true;; bool2 = false)
    {
      Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "handleUserAuthChanged, should stop location foreground:%s, should stop location background:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) || (bool2))
      {
        ((t)localObject).bGK();
        ((t)localObject).X(paramq);
      }
      if (bool2) {
        u(paramq);
      }
      AppMethodBeat.o(226431);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.s params, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44781);
    a(params, paramInt1, paramInt2, false);
    AppMethodBeat.o(44781);
  }
  
  private static void a(com.tencent.mm.plugin.appbrand.s params, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(226432);
    if (g.af(f.class) != null)
    {
      AppBrandBackgroundRunningOperationParcel localAppBrandBackgroundRunningOperationParcel = new AppBrandBackgroundRunningOperationParcel();
      localAppBrandBackgroundRunningOperationParcel.appId = params.getAppId();
      localAppBrandBackgroundRunningOperationParcel.iOo = params.getRuntime().kAq.eix;
      localAppBrandBackgroundRunningOperationParcel.beL = paramInt2;
      localAppBrandBackgroundRunningOperationParcel.dDe = paramInt1;
      localAppBrandBackgroundRunningOperationParcel.kYe = params.getContext().getClass().getName();
      localAppBrandBackgroundRunningOperationParcel.process = MMApplicationContext.getProcessName();
      localAppBrandBackgroundRunningOperationParcel.kYo = paramBoolean;
      if (paramInt2 == c.kYr.beL) {
        localAppBrandBackgroundRunningOperationParcel.kYf = AppBrandAudioOfVideoBackgroundPlayNotificationLogic.class.getName();
      }
      if (((params instanceof com.tencent.mm.plugin.appbrand.service.c)) && (params.getRuntime() != null) && (params.getRuntime().OU() != null))
      {
        params = (AppBrandInitConfigWC)params.getRuntime().OU();
        localAppBrandBackgroundRunningOperationParcel.name = params.brandName;
        localAppBrandBackgroundRunningOperationParcel.icon = params.iconUrl;
        localAppBrandBackgroundRunningOperationParcel.username = params.username;
      }
      ((f)g.af(f.class)).a(localAppBrandBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(226432);
  }
  
  private static void ak(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(44784);
    e.b(paramString, new EventLocationBackgroundStateChanged(paramBoolean));
    AppMethodBeat.o(44784);
  }
  
  public static void t(q paramq)
  {
    AppMethodBeat.i(226433);
    Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "startRuntimeStateMonitor");
    if (!kYm.add(paramq.mAppId))
    {
      Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "startRuntimeStateMonitor, already start, return");
      AppMethodBeat.o(226433);
      return;
    }
    Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "startListeningOperationReceivedIfNeed");
    if (kYk == null)
    {
      kYk = new f.a()
      {
        public final void b(MMBackgroundRunningOperationParcel paramAnonymousMMBackgroundRunningOperationParcel)
        {
          AppMethodBeat.i(226429);
          Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "onBackgroundRunningOperationReceived, operation:%s", new Object[] { paramAnonymousMMBackgroundRunningOperationParcel });
          q localq = com.tencent.mm.plugin.appbrand.a.TQ(paramAnonymousMMBackgroundRunningOperationParcel.appId);
          if (localq == null)
          {
            Log.w("MicroMsg.AppBrandBackgroundRunningMonitor", "onBackgroundRunningOperationReceived, runtime is null");
            AppMethodBeat.o(226429);
            return;
          }
          if (paramAnonymousMMBackgroundRunningOperationParcel.dDe == 2)
          {
            AppBrandBackgroundRunningMonitor.a(paramAnonymousMMBackgroundRunningOperationParcel, localq);
            AppBrandBackgroundRunningMonitor.b(paramAnonymousMMBackgroundRunningOperationParcel, localq);
            AppBrandBackgroundRunningMonitor.c(paramAnonymousMMBackgroundRunningOperationParcel, localq);
            AppBrandBackgroundRunningMonitor.d(paramAnonymousMMBackgroundRunningOperationParcel, localq);
          }
          AppMethodBeat.o(226429);
        }
      };
      if (g.af(f.class) != null) {
        ((f)g.af(f.class)).a(kYk);
      }
    }
    String str = paramq.mAppId;
    Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "startListeningOperationEvent, appId:%s", new Object[] { str });
    if (kYj == null) {
      kYj = new MMToClientEvent.c()
      {
        public final void cq(Object paramAnonymousObject)
        {
          AppMethodBeat.i(226430);
          if ((paramAnonymousObject instanceof MMBackgroundRunningOperationParcel))
          {
            Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "app received data, operation:%s", new Object[] { (MMBackgroundRunningOperationParcel)paramAnonymousObject });
            if (g.af(f.class) != null) {
              ((f)g.af(f.class)).a((MMBackgroundRunningOperationParcel)paramAnonymousObject);
            }
          }
          AppMethodBeat.o(226430);
        }
      };
    }
    MMToClientEvent.a(str, kYj);
    if (1 == kYm.size())
    {
      Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "startRuntimeStateMonitor, first start, alive listener");
      kYl.alive();
    }
    paramq.kAH.a(new c.a()
    {
      public final void a(String paramAnonymousString, b paramAnonymousb)
      {
        AppMethodBeat.i(226428);
        if (paramAnonymousb == b.kQK)
        {
          Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "AppBrandRuntime state changed to destroyed");
          if (g.af(f.class) != null)
          {
            paramAnonymousb = new AppBrandBackgroundRunningOperationParcel();
            paramAnonymousb.appId = paramAnonymousString;
            paramAnonymousb.beL = c.kYt.beL;
            paramAnonymousb.dDe = 2;
            if (com.tencent.mm.plugin.appbrand.a.TQ(paramAnonymousString) != null)
            {
              q localq = com.tencent.mm.plugin.appbrand.a.TQ(paramAnonymousString);
              if (localq != null)
              {
                paramAnonymousb.iOo = localq.kAq.eix;
                if (AndroidContextUtil.castActivityOrNull(localq.mContext) != null) {
                  paramAnonymousb.kYe = AndroidContextUtil.castActivityOrNull(localq.mContext).getClass().getName();
                }
              }
            }
            ((f)g.af(f.class)).a(paramAnonymousb);
          }
          if (!AppBrandBackgroundRunningMonitor.byX().remove(paramAnonymousString))
          {
            Log.w("MicroMsg.AppBrandBackgroundRunningMonitor", "onRunningStateChanged, not start, return");
            AppMethodBeat.o(226428);
            return;
          }
          boolean bool = AppBrandBackgroundRunningMonitor.byX().isEmpty();
          if (bool) {
            AppBrandBackgroundRunningMonitor.access$300();
          }
          AppBrandBackgroundRunningMonitor.al(paramAnonymousString, bool);
          if (bool)
          {
            Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "onRunningStateChanged, last stop, dead listener");
            AppBrandBackgroundRunningMonitor.byY().dead();
          }
        }
        AppMethodBeat.o(226428);
      }
    });
    AppMethodBeat.o(226433);
  }
  
  private static void u(q paramq)
  {
    AppMethodBeat.i(44782);
    Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "sendRemoveLocationUsageOperation, runtime:%s", new Object[] { paramq.mAppId });
    if (g.af(f.class) != null)
    {
      AppBrandBackgroundRunningOperationParcel localAppBrandBackgroundRunningOperationParcel = new AppBrandBackgroundRunningOperationParcel();
      localAppBrandBackgroundRunningOperationParcel.appId = paramq.mAppId;
      localAppBrandBackgroundRunningOperationParcel.iOo = paramq.kAq.eix;
      localAppBrandBackgroundRunningOperationParcel.beL = c.kYp.beL;
      localAppBrandBackgroundRunningOperationParcel.dDe = 2;
      if (AndroidContextUtil.castActivityOrNull(paramq.mContext) != null) {
        localAppBrandBackgroundRunningOperationParcel.kYe = AndroidContextUtil.castActivityOrNull(paramq.mContext).getClass().getName();
      }
      ((f)g.af(f.class)).a(localAppBrandBackgroundRunningOperationParcel);
    }
    WA(paramq.mAppId);
    AppMethodBeat.o(44782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningMonitor
 * JD-Core Version:    0.7.0.1
 */