package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.ipc.e;
import com.tencent.mm.plugin.appbrand.jsapi.EventLocationBackgroundStateChanged;
import com.tencent.mm.plugin.appbrand.jsapi.ai.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.j.u;
import com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AuthStateChangedByUserEvent;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.HashSet;
import java.util.Set;

public final class AppBrandBackgroundRunningMonitor
{
  private static MMToClientEvent.c nSv;
  private static f.a nSw;
  private static IListener nSx;
  private static Set<String> nSy;
  
  static
  {
    AppMethodBeat.i(270847);
    nSx = new IListener() {};
    nSy = new HashSet();
    AppMethodBeat.o(270847);
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.t paramt, AppBrandAuthorizeUI.AuthStateChangedByUserEvent paramAuthStateChangedByUserEvent)
  {
    AppMethodBeat.i(270830);
    Object localObject;
    boolean bool1;
    if (paramt != null)
    {
      localObject = (com.tencent.mm.plugin.appbrand.jsapi.j.t)paramt.av(com.tencent.mm.plugin.appbrand.jsapi.j.t.class);
      if (!(localObject instanceof u))
      {
        Log.w("MicroMsg.AppBrandBackgroundRunningMonitor", "handleUserAuthChanged, invalid location state manager");
        AppMethodBeat.o(270830);
        return;
      }
      localObject = (u)localObject;
      bool2 = paramAuthStateChangedByUserEvent.qTN;
      boolean bool3 = paramAuthStateChangedByUserEvent.qTO;
      if ((((com.tencent.mm.plugin.appbrand.jsapi.j.t)localObject).oVh) || (bool2)) {
        break label150;
      }
      bool1 = true;
      if ((!((com.tencent.mm.plugin.appbrand.jsapi.j.t)localObject).oVh) || ((bool3) && (bool2))) {
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
        ((u)localObject).bSr();
        ((u)localObject).Y(paramt);
      }
      if (bool2) {
        v(paramt);
      }
      AppMethodBeat.o(270830);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static void a(v paramv, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44781);
    a(paramv, paramInt1, paramInt2, false);
    AppMethodBeat.o(44781);
  }
  
  private static void a(v paramv, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(270831);
    if (h.ae(f.class) != null)
    {
      AppBrandBackgroundRunningOperationParcel localAppBrandBackgroundRunningOperationParcel = new AppBrandBackgroundRunningOperationParcel();
      localAppBrandBackgroundRunningOperationParcel.appId = paramv.getAppId();
      localAppBrandBackgroundRunningOperationParcel.cBU = paramv.getRuntime().ntz.cBI;
      localAppBrandBackgroundRunningOperationParcel.aOm = paramInt2;
      localAppBrandBackgroundRunningOperationParcel.fvK = paramInt1;
      localAppBrandBackgroundRunningOperationParcel.nSq = paramv.getContext().getClass().getName();
      localAppBrandBackgroundRunningOperationParcel.jZi = MMApplicationContext.getProcessName();
      localAppBrandBackgroundRunningOperationParcel.nSA = paramBoolean;
      localAppBrandBackgroundRunningOperationParcel.cxa = ((AppBrandInitConfigLU)paramv.getRuntime().Sq()).cxa;
      if (paramInt2 == c.nSD.aOm) {
        localAppBrandBackgroundRunningOperationParcel.nSr = AppBrandAudioOfVideoBackgroundPlayNotificationLogic.class.getName();
      }
      if (((paramv instanceof com.tencent.mm.plugin.appbrand.service.c)) && (paramv.getRuntime() != null) && (paramv.getRuntime().Sq() != null))
      {
        paramv = (AppBrandInitConfigWC)paramv.getRuntime().Sq();
        localAppBrandBackgroundRunningOperationParcel.name = paramv.fzM;
        localAppBrandBackgroundRunningOperationParcel.icon = paramv.iconUrl;
        localAppBrandBackgroundRunningOperationParcel.username = paramv.username;
      }
      ((f)h.ae(f.class)).a(localAppBrandBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(270831);
  }
  
  private static void ael(String paramString)
  {
    AppMethodBeat.i(44783);
    if (MMApplicationContext.isMMProcess())
    {
      al(paramString, false);
      AppMethodBeat.o(44783);
      return;
    }
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new NotifyLocationBackgroundChanged(paramString), a.class, null);
    AppMethodBeat.o(44783);
  }
  
  private static void al(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(44784);
    e.b(paramString, new EventLocationBackgroundStateChanged(paramBoolean));
    AppMethodBeat.o(44784);
  }
  
  public static void u(com.tencent.mm.plugin.appbrand.t paramt)
  {
    AppMethodBeat.i(270833);
    Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "startRuntimeStateMonitor");
    if (!nSy.add(paramt.mAppId))
    {
      Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "startRuntimeStateMonitor, already start, return");
      AppMethodBeat.o(270833);
      return;
    }
    Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "startListeningOperationReceivedIfNeed");
    if (nSw == null)
    {
      nSw = new f.a()
      {
        public final void b(MMBackgroundRunningOperationParcel paramAnonymousMMBackgroundRunningOperationParcel)
        {
          AppMethodBeat.i(282969);
          Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "onBackgroundRunningOperationReceived, operation:%s", new Object[] { paramAnonymousMMBackgroundRunningOperationParcel });
          com.tencent.mm.plugin.appbrand.t localt = com.tencent.mm.plugin.appbrand.d.abA(paramAnonymousMMBackgroundRunningOperationParcel.appId);
          if (localt == null)
          {
            Log.w("MicroMsg.AppBrandBackgroundRunningMonitor", "onBackgroundRunningOperationReceived, runtime is null");
            AppMethodBeat.o(282969);
            return;
          }
          if (paramAnonymousMMBackgroundRunningOperationParcel.fvK == 2)
          {
            AppBrandBackgroundRunningMonitor.a(paramAnonymousMMBackgroundRunningOperationParcel, localt);
            AppBrandBackgroundRunningMonitor.b(paramAnonymousMMBackgroundRunningOperationParcel, localt);
            AppBrandBackgroundRunningMonitor.c(paramAnonymousMMBackgroundRunningOperationParcel, localt);
            AppBrandBackgroundRunningMonitor.d(paramAnonymousMMBackgroundRunningOperationParcel, localt);
          }
          AppMethodBeat.o(282969);
        }
      };
      if (h.ae(f.class) != null) {
        ((f)h.ae(f.class)).a(nSw);
      }
    }
    String str = paramt.mAppId;
    Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "startListeningOperationEvent, appId:%s", new Object[] { str });
    if (nSv == null) {
      nSv = new MMToClientEvent.c()
      {
        public final void cq(Object paramAnonymousObject)
        {
          AppMethodBeat.i(270261);
          if ((paramAnonymousObject instanceof MMBackgroundRunningOperationParcel))
          {
            Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "app received data, operation:%s", new Object[] { (MMBackgroundRunningOperationParcel)paramAnonymousObject });
            if (h.ae(f.class) != null) {
              ((f)h.ae(f.class)).a((MMBackgroundRunningOperationParcel)paramAnonymousObject);
            }
          }
          AppMethodBeat.o(270261);
        }
      };
    }
    MMToClientEvent.a(str, nSv);
    if (1 == nSy.size())
    {
      Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "startRuntimeStateMonitor, first start, alive listener");
      nSx.alive();
    }
    paramt.ntR.a(new c.a()
    {
      public final void a(String paramAnonymousString, b paramAnonymousb)
      {
        AppMethodBeat.i(273278);
        if (paramAnonymousb == b.nKS)
        {
          Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "AppBrandRuntime state changed to destroyed");
          if (h.ae(f.class) != null)
          {
            paramAnonymousb = new AppBrandBackgroundRunningOperationParcel();
            paramAnonymousb.appId = paramAnonymousString;
            paramAnonymousb.aOm = c.nSF.aOm;
            paramAnonymousb.fvK = 2;
            if (com.tencent.mm.plugin.appbrand.d.abA(paramAnonymousString) != null)
            {
              com.tencent.mm.plugin.appbrand.t localt = com.tencent.mm.plugin.appbrand.d.abA(paramAnonymousString);
              if (localt != null)
              {
                paramAnonymousb.cxa = localt.Sk().cxa;
                paramAnonymousb.cBU = localt.ntz.cBI;
                if (AndroidContextUtil.castActivityOrNull(localt.mContext) != null) {
                  paramAnonymousb.nSq = AndroidContextUtil.castActivityOrNull(localt.mContext).getClass().getName();
                }
              }
            }
            ((f)h.ae(f.class)).a(paramAnonymousb);
          }
          if (!AppBrandBackgroundRunningMonitor.bKm().remove(paramAnonymousString))
          {
            Log.w("MicroMsg.AppBrandBackgroundRunningMonitor", "onRunningStateChanged, not start, return");
            AppMethodBeat.o(273278);
            return;
          }
          boolean bool = AppBrandBackgroundRunningMonitor.bKm().isEmpty();
          if (bool) {
            AppBrandBackgroundRunningMonitor.access$300();
          }
          AppBrandBackgroundRunningMonitor.am(paramAnonymousString, bool);
          if (bool)
          {
            Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "onRunningStateChanged, last stop, dead listener");
            AppBrandBackgroundRunningMonitor.bKn().dead();
          }
        }
        AppMethodBeat.o(273278);
      }
    });
    AppMethodBeat.o(270833);
  }
  
  private static void v(com.tencent.mm.plugin.appbrand.t paramt)
  {
    AppMethodBeat.i(44782);
    Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "sendRemoveLocationUsageOperation, runtime:%s", new Object[] { paramt.mAppId });
    if (h.ae(f.class) != null)
    {
      AppBrandBackgroundRunningOperationParcel localAppBrandBackgroundRunningOperationParcel = new AppBrandBackgroundRunningOperationParcel();
      localAppBrandBackgroundRunningOperationParcel.appId = paramt.mAppId;
      localAppBrandBackgroundRunningOperationParcel.cBU = paramt.ntz.cBI;
      localAppBrandBackgroundRunningOperationParcel.aOm = c.nSB.aOm;
      localAppBrandBackgroundRunningOperationParcel.fvK = 2;
      localAppBrandBackgroundRunningOperationParcel.cxa = paramt.Sk().cxa;
      if (AndroidContextUtil.castActivityOrNull(paramt.mContext) != null) {
        localAppBrandBackgroundRunningOperationParcel.nSq = AndroidContextUtil.castActivityOrNull(paramt.mContext).getClass().getName();
      }
      ((f)h.ae(f.class)).a(localAppBrandBackgroundRunningOperationParcel);
    }
    ael(paramt.mAppId);
    AppMethodBeat.o(44782);
  }
  
  static class NotifyLocationBackgroundChanged
    implements Parcelable
  {
    public static final Parcelable.Creator<NotifyLocationBackgroundChanged> CREATOR;
    public String appId;
    public boolean nSz;
    
    static
    {
      AppMethodBeat.i(44780);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(44780);
    }
    
    protected NotifyLocationBackgroundChanged(Parcel paramParcel)
    {
      AppMethodBeat.i(44778);
      this.appId = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.nSz = bool;
        AppMethodBeat.o(44778);
        return;
      }
    }
    
    public NotifyLocationBackgroundChanged(String paramString)
    {
      this.appId = paramString;
      this.nSz = false;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(44779);
      paramParcel.writeString(this.appId);
      if (this.nSz) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        AppMethodBeat.o(44779);
        return;
      }
    }
  }
  
  static final class a
    implements com.tencent.mm.ipcinvoker.d<AppBrandBackgroundRunningMonitor.NotifyLocationBackgroundChanged, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningMonitor
 * JD-Core Version:    0.7.0.1
 */