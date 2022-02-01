package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.ipc.e;
import com.tencent.mm.plugin.appbrand.jsapi.EventLocationBackgroundStateChanged;
import com.tencent.mm.plugin.appbrand.jsapi.g.r;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AuthStateChangedByUserEvent;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.HashSet;
import java.util.Set;

public final class AppBrandBackgroundRunningMonitor
{
  private static MMToClientEvent.c jRW;
  private static g.a jRX;
  private static com.tencent.mm.sdk.b.c jRY;
  private static Set<String> jRZ;
  
  static
  {
    AppMethodBeat.i(188083);
    jRY = new com.tencent.mm.sdk.b.c() {};
    jRZ = new HashSet();
    AppMethodBeat.o(188083);
  }
  
  private static void ML(String paramString)
  {
    AppMethodBeat.i(44783);
    if (aj.cnC())
    {
      ai(paramString, false);
      AppMethodBeat.o(44783);
      return;
    }
    XIPCInvoker.a("com.tencent.mm", new NotifyLocationBackgroundChanged(paramString), a.class, null);
    AppMethodBeat.o(44783);
  }
  
  public static void a(o paramo, AppBrandAuthorizeUI.AuthStateChangedByUserEvent paramAuthStateChangedByUserEvent)
  {
    AppMethodBeat.i(188071);
    Object localObject;
    boolean bool1;
    if (paramo != null)
    {
      localObject = (com.tencent.mm.plugin.appbrand.jsapi.g.q)paramo.as(com.tencent.mm.plugin.appbrand.jsapi.g.q.class);
      if (!(localObject instanceof r))
      {
        ad.w("MicroMsg.AppBrandBackgroundRunningMonitor", "handleUserAuthChanged, invalid location state manager");
        AppMethodBeat.o(188071);
        return;
      }
      localObject = (r)localObject;
      bool2 = paramAuthStateChangedByUserEvent.mAw;
      boolean bool3 = paramAuthStateChangedByUserEvent.mAx;
      if ((((com.tencent.mm.plugin.appbrand.jsapi.g.q)localObject).kOG) || (bool2)) {
        break label150;
      }
      bool1 = true;
      if ((!((com.tencent.mm.plugin.appbrand.jsapi.g.q)localObject).kOG) || ((bool3) && (bool2))) {
        break label155;
      }
    }
    label150:
    label155:
    for (boolean bool2 = true;; bool2 = false)
    {
      ad.i("MicroMsg.AppBrandBackgroundRunningMonitor", "handleUserAuthChanged, should stop location foreground:%s, should stop location background:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) || (bool2))
      {
        ((r)localObject).bkE();
        ((r)localObject).X(paramo);
      }
      if (bool2) {
        q(paramo);
      }
      AppMethodBeat.o(188071);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.q paramq, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44781);
    a(paramq, paramInt1, paramInt2, false);
    AppMethodBeat.o(44781);
  }
  
  private static void a(com.tencent.mm.plugin.appbrand.q paramq, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(188072);
    if (com.tencent.mm.kernel.g.ab(g.class) != null)
    {
      AppBrandBackgroundRunningOperationParcel localAppBrandBackgroundRunningOperationParcel = new AppBrandBackgroundRunningOperationParcel();
      localAppBrandBackgroundRunningOperationParcel.appId = paramq.getAppId();
      localAppBrandBackgroundRunningOperationParcel.hQh = paramq.getRuntime().jwG.dPf;
      localAppBrandBackgroundRunningOperationParcel.beO = paramInt2;
      localAppBrandBackgroundRunningOperationParcel.dkM = paramInt1;
      localAppBrandBackgroundRunningOperationParcel.jRQ = paramq.getContext().getClass().getName();
      localAppBrandBackgroundRunningOperationParcel.process = aj.getProcessName();
      localAppBrandBackgroundRunningOperationParcel.jSb = paramBoolean;
      if (paramInt2 == d.jSe.beO) {
        localAppBrandBackgroundRunningOperationParcel.jRR = AppBrandAudioOfVideoBackgroundPlayNotificationLogic.class.getName();
      }
      if (((paramq instanceof com.tencent.mm.plugin.appbrand.service.c)) && (paramq.getRuntime() != null) && (paramq.getRuntime().Fi() != null))
      {
        paramq = (AppBrandInitConfigWC)paramq.getRuntime().Fi();
        localAppBrandBackgroundRunningOperationParcel.name = paramq.doD;
        localAppBrandBackgroundRunningOperationParcel.dDH = paramq.iconUrl;
        localAppBrandBackgroundRunningOperationParcel.username = paramq.username;
      }
      ((g)com.tencent.mm.kernel.g.ab(g.class)).a(localAppBrandBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(188072);
  }
  
  private static void ai(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(44784);
    e.b(paramString, new EventLocationBackgroundStateChanged(paramBoolean));
    AppMethodBeat.o(44784);
  }
  
  public static void p(o paramo)
  {
    AppMethodBeat.i(188073);
    ad.i("MicroMsg.AppBrandBackgroundRunningMonitor", "startRuntimeStateMonitor");
    if (!jRZ.add(paramo.mAppId))
    {
      ad.i("MicroMsg.AppBrandBackgroundRunningMonitor", "startRuntimeStateMonitor, already start, return");
      AppMethodBeat.o(188073);
      return;
    }
    ad.i("MicroMsg.AppBrandBackgroundRunningMonitor", "startListeningOperationReceivedIfNeed");
    if (jRX == null)
    {
      jRX = new g.a()
      {
        public final void b(MMBackgroundRunningOperationParcel paramAnonymousMMBackgroundRunningOperationParcel)
        {
          AppMethodBeat.i(188069);
          ad.i("MicroMsg.AppBrandBackgroundRunningMonitor", "onBackgroundRunningOperationReceived, operation:%s", new Object[] { paramAnonymousMMBackgroundRunningOperationParcel });
          o localo = com.tencent.mm.plugin.appbrand.a.Kj(paramAnonymousMMBackgroundRunningOperationParcel.appId);
          if (localo == null)
          {
            ad.w("MicroMsg.AppBrandBackgroundRunningMonitor", "onBackgroundRunningOperationReceived, runtime is null");
            AppMethodBeat.o(188069);
            return;
          }
          if (paramAnonymousMMBackgroundRunningOperationParcel.dkM == 2)
          {
            AppBrandBackgroundRunningMonitor.a(paramAnonymousMMBackgroundRunningOperationParcel, localo);
            AppBrandBackgroundRunningMonitor.b(paramAnonymousMMBackgroundRunningOperationParcel, localo);
            AppBrandBackgroundRunningMonitor.c(paramAnonymousMMBackgroundRunningOperationParcel, localo);
            AppBrandBackgroundRunningMonitor.d(paramAnonymousMMBackgroundRunningOperationParcel, localo);
          }
          AppMethodBeat.o(188069);
        }
      };
      if (com.tencent.mm.kernel.g.ab(g.class) != null) {
        ((g)com.tencent.mm.kernel.g.ab(g.class)).a(jRX);
      }
    }
    String str = paramo.mAppId;
    ad.i("MicroMsg.AppBrandBackgroundRunningMonitor", "startListeningOperationEvent, appId:%s", new Object[] { str });
    if (jRW == null) {
      jRW = new MMToClientEvent.c()
      {
        public final void ch(Object paramAnonymousObject)
        {
          AppMethodBeat.i(188070);
          if ((paramAnonymousObject instanceof MMBackgroundRunningOperationParcel))
          {
            ad.i("MicroMsg.AppBrandBackgroundRunningMonitor", "app received data, operation:%s", new Object[] { (MMBackgroundRunningOperationParcel)paramAnonymousObject });
            if (com.tencent.mm.kernel.g.ab(g.class) != null) {
              ((g)com.tencent.mm.kernel.g.ab(g.class)).a((MMBackgroundRunningOperationParcel)paramAnonymousObject);
            }
          }
          AppMethodBeat.o(188070);
        }
      };
    }
    MMToClientEvent.a(str, jRW);
    if (1 == jRZ.size())
    {
      ad.i("MicroMsg.AppBrandBackgroundRunningMonitor", "startRuntimeStateMonitor, first start, alive listener");
      jRY.alive();
    }
    paramo.jwS.a(new c.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.a.b paramAnonymousb)
      {
        AppMethodBeat.i(188068);
        if (paramAnonymousb == com.tencent.mm.plugin.appbrand.a.b.jKR)
        {
          ad.i("MicroMsg.AppBrandBackgroundRunningMonitor", "AppBrandRuntime state changed to destroyed");
          if (com.tencent.mm.kernel.g.ab(g.class) != null)
          {
            paramAnonymousb = new AppBrandBackgroundRunningOperationParcel();
            paramAnonymousb.appId = paramAnonymousString;
            paramAnonymousb.beO = d.jSg.beO;
            paramAnonymousb.dkM = 2;
            if (com.tencent.mm.plugin.appbrand.a.Kj(paramAnonymousString) != null)
            {
              o localo = com.tencent.mm.plugin.appbrand.a.Kj(paramAnonymousString);
              if (localo != null)
              {
                paramAnonymousb.hQh = localo.jwG.dPf;
                if (com.tencent.mm.sdk.f.a.jq(localo.mContext) != null) {
                  paramAnonymousb.jRQ = com.tencent.mm.sdk.f.a.jq(localo.mContext).getClass().getName();
                }
              }
            }
            ((g)com.tencent.mm.kernel.g.ab(g.class)).a(paramAnonymousb);
          }
          if (!AppBrandBackgroundRunningMonitor.bdb().remove(paramAnonymousString))
          {
            ad.w("MicroMsg.AppBrandBackgroundRunningMonitor", "onRunningStateChanged, not start, return");
            AppMethodBeat.o(188068);
            return;
          }
          boolean bool = AppBrandBackgroundRunningMonitor.bdb().isEmpty();
          if (bool) {
            AppBrandBackgroundRunningMonitor.access$300();
          }
          AppBrandBackgroundRunningMonitor.aj(paramAnonymousString, bool);
          if (bool)
          {
            ad.i("MicroMsg.AppBrandBackgroundRunningMonitor", "onRunningStateChanged, last stop, dead listener");
            AppBrandBackgroundRunningMonitor.bdc().dead();
          }
        }
        AppMethodBeat.o(188068);
      }
    });
    AppMethodBeat.o(188073);
  }
  
  private static void q(o paramo)
  {
    AppMethodBeat.i(44782);
    ad.i("MicroMsg.AppBrandBackgroundRunningMonitor", "sendRemoveLocationUsageOperation, runtime:%s", new Object[] { paramo.mAppId });
    if (com.tencent.mm.kernel.g.ab(g.class) != null)
    {
      AppBrandBackgroundRunningOperationParcel localAppBrandBackgroundRunningOperationParcel = new AppBrandBackgroundRunningOperationParcel();
      localAppBrandBackgroundRunningOperationParcel.appId = paramo.mAppId;
      localAppBrandBackgroundRunningOperationParcel.hQh = paramo.jwG.dPf;
      localAppBrandBackgroundRunningOperationParcel.beO = d.jSc.beO;
      localAppBrandBackgroundRunningOperationParcel.dkM = 2;
      if (com.tencent.mm.sdk.f.a.jq(paramo.mContext) != null) {
        localAppBrandBackgroundRunningOperationParcel.jRQ = com.tencent.mm.sdk.f.a.jq(paramo.mContext).getClass().getName();
      }
      ((g)com.tencent.mm.kernel.g.ab(g.class)).a(localAppBrandBackgroundRunningOperationParcel);
    }
    ML(paramo.mAppId);
    AppMethodBeat.o(44782);
  }
  
  static class NotifyLocationBackgroundChanged
    implements Parcelable
  {
    public static final Parcelable.Creator<NotifyLocationBackgroundChanged> CREATOR;
    public String appId;
    public boolean jSa;
    
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
        this.jSa = bool;
        AppMethodBeat.o(44778);
        return;
      }
    }
    
    public NotifyLocationBackgroundChanged(String paramString)
    {
      this.appId = paramString;
      this.jSa = false;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(44779);
      paramParcel.writeString(this.appId);
      if (this.jSa) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        AppMethodBeat.o(44779);
        return;
      }
    }
  }
  
  static final class a
    implements com.tencent.mm.ipcinvoker.b<AppBrandBackgroundRunningMonitor.NotifyLocationBackgroundChanged, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningMonitor
 * JD-Core Version:    0.7.0.1
 */