package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.ipc.e;
import com.tencent.mm.plugin.appbrand.jsapi.EventLocationBackgroundStateChanged;
import com.tencent.mm.plugin.appbrand.jsapi.e.r;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AuthStateChangedByUserEvent;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class AppBrandBackgroundRunningMonitor
{
  private static MMToClientEvent.c iXK;
  private static g.a iXL;
  private static com.tencent.mm.sdk.b.c iXM;
  
  static
  {
    AppMethodBeat.i(195671);
    iXM = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(195671);
  }
  
  private static void Fo(String paramString)
  {
    AppMethodBeat.i(44783);
    if (aj.cbv())
    {
      ah(paramString, false);
      AppMethodBeat.o(44783);
      return;
    }
    XIPCInvoker.a("com.tencent.mm", new NotifyLocationBackgroundChanged(paramString), a.class, null);
    AppMethodBeat.o(44783);
  }
  
  public static void a(o paramo, AppBrandAuthorizeUI.AuthStateChangedByUserEvent paramAuthStateChangedByUserEvent)
  {
    AppMethodBeat.i(195660);
    Object localObject;
    boolean bool1;
    if (paramo != null)
    {
      localObject = (com.tencent.mm.plugin.appbrand.jsapi.e.q)paramo.as(com.tencent.mm.plugin.appbrand.jsapi.e.q.class);
      if (!(localObject instanceof r))
      {
        ad.w("MicroMsg.AppBrandBackgroundRunningMonitor", "handleUserAuthChanged, invalid location state manager");
        AppMethodBeat.o(195660);
        return;
      }
      localObject = (r)localObject;
      bool2 = paramAuthStateChangedByUserEvent.lyH;
      boolean bool3 = paramAuthStateChangedByUserEvent.lyI;
      if ((((com.tencent.mm.plugin.appbrand.jsapi.e.q)localObject).jSy) || (bool2)) {
        break label150;
      }
      bool1 = true;
      if ((!((com.tencent.mm.plugin.appbrand.jsapi.e.q)localObject).jSy) || ((bool3) && (bool2))) {
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
        ((r)localObject).bag();
        ((r)localObject).ad(paramo);
      }
      if (bool2) {
        z(paramo);
      }
      AppMethodBeat.o(195660);
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
    AppMethodBeat.i(195661);
    if (com.tencent.mm.kernel.g.ab(g.class) != null)
    {
      AppBrandBackgroundRunningOperationParcel localAppBrandBackgroundRunningOperationParcel = new AppBrandBackgroundRunningOperationParcel();
      localAppBrandBackgroundRunningOperationParcel.appId = paramq.getAppId();
      localAppBrandBackgroundRunningOperationParcel.gXn = paramq.getRuntime().iDx.iOP;
      localAppBrandBackgroundRunningOperationParcel.aTC = paramInt2;
      localAppBrandBackgroundRunningOperationParcel.dbV = paramInt1;
      localAppBrandBackgroundRunningOperationParcel.iXE = paramq.getContext().getClass().getName();
      localAppBrandBackgroundRunningOperationParcel.process = aj.getProcessName();
      localAppBrandBackgroundRunningOperationParcel.iXO = paramBoolean;
      if (paramInt2 == d.iXR.aTC) {
        localAppBrandBackgroundRunningOperationParcel.iXF = AppBrandAudioOfVideoBackgroundPlayNotificationLogic.class.getName();
      }
      if (((paramq instanceof com.tencent.mm.plugin.appbrand.service.c)) && (paramq.getRuntime() != null) && (paramq.getRuntime().Eg() != null))
      {
        paramq = (AppBrandInitConfigWC)paramq.getRuntime().Eg();
        localAppBrandBackgroundRunningOperationParcel.name = paramq.dfM;
        localAppBrandBackgroundRunningOperationParcel.dub = paramq.iconUrl;
        localAppBrandBackgroundRunningOperationParcel.username = paramq.username;
      }
      ((g)com.tencent.mm.kernel.g.ab(g.class)).a(localAppBrandBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(195661);
  }
  
  private static void ah(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(44784);
    e.b(paramString, new EventLocationBackgroundStateChanged(paramBoolean));
    AppMethodBeat.o(44784);
  }
  
  public static void y(o paramo)
  {
    AppMethodBeat.i(195662);
    ad.i("MicroMsg.AppBrandBackgroundRunningMonitor", "startRuntimeStateMonitor");
    ad.i("MicroMsg.AppBrandBackgroundRunningMonitor", "startListeningOperationReceived");
    if (iXL == null) {
      iXL = new g.a()
      {
        public final void b(MMBackgroundRunningOperationParcel paramAnonymousMMBackgroundRunningOperationParcel)
        {
          AppMethodBeat.i(195658);
          ad.i("MicroMsg.AppBrandBackgroundRunningMonitor", "onBackgroundRunningOperationReceived, operation:%s", new Object[] { paramAnonymousMMBackgroundRunningOperationParcel });
          o localo = com.tencent.mm.plugin.appbrand.a.CR(paramAnonymousMMBackgroundRunningOperationParcel.appId);
          if (localo == null)
          {
            ad.w("MicroMsg.AppBrandBackgroundRunningMonitor", "onBackgroundRunningOperationReceived, runtime is null");
            AppMethodBeat.o(195658);
            return;
          }
          if (paramAnonymousMMBackgroundRunningOperationParcel.dbV == 2)
          {
            AppBrandBackgroundRunningMonitor.a(paramAnonymousMMBackgroundRunningOperationParcel, localo);
            AppBrandBackgroundRunningMonitor.b(paramAnonymousMMBackgroundRunningOperationParcel, localo);
            AppBrandBackgroundRunningMonitor.c(paramAnonymousMMBackgroundRunningOperationParcel, localo);
          }
          AppMethodBeat.o(195658);
        }
      };
    }
    if (com.tencent.mm.kernel.g.ab(g.class) != null) {
      ((g)com.tencent.mm.kernel.g.ab(g.class)).a(iXL);
    }
    String str = paramo.mAppId;
    ad.i("MicroMsg.AppBrandBackgroundRunningMonitor", "startListeningOperationEvent, appId:%s", new Object[] { str });
    if (iXK == null) {
      iXK = new MMToClientEvent.c()
      {
        public final void ch(Object paramAnonymousObject)
        {
          AppMethodBeat.i(195659);
          if ((paramAnonymousObject instanceof MMBackgroundRunningOperationParcel))
          {
            ad.i("MicroMsg.AppBrandBackgroundRunningMonitor", "app received data, operation:%s", new Object[] { (MMBackgroundRunningOperationParcel)paramAnonymousObject });
            if (com.tencent.mm.kernel.g.ab(g.class) != null) {
              ((g)com.tencent.mm.kernel.g.ab(g.class)).a((MMBackgroundRunningOperationParcel)paramAnonymousObject);
            }
          }
          AppMethodBeat.o(195659);
        }
      };
    }
    MMToClientEvent.a(str, iXK);
    iXM.alive();
    paramo.iDK.a(new c.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.b.b paramAnonymousb)
      {
        AppMethodBeat.i(195657);
        if (paramAnonymousb == com.tencent.mm.plugin.appbrand.b.b.iQN)
        {
          ad.i("MicroMsg.AppBrandBackgroundRunningMonitor", "AppBrandRuntime state changed to destroyed");
          if (com.tencent.mm.kernel.g.ab(g.class) != null)
          {
            paramAnonymousb = new AppBrandBackgroundRunningOperationParcel();
            paramAnonymousb.appId = paramAnonymousString;
            paramAnonymousb.aTC = d.iXS.aTC;
            paramAnonymousb.dbV = 2;
            if (com.tencent.mm.plugin.appbrand.a.CR(paramAnonymousString) != null)
            {
              o localo = com.tencent.mm.plugin.appbrand.a.CR(paramAnonymousString);
              if (localo != null)
              {
                paramAnonymousb.gXn = localo.iDx.iOP;
                if (com.tencent.mm.sdk.f.a.iV(localo.mContext) != null) {
                  paramAnonymousb.iXE = com.tencent.mm.sdk.f.a.iV(localo.mContext).getClass().getName();
                }
              }
            }
            ((g)com.tencent.mm.kernel.g.ab(g.class)).a(paramAnonymousb);
          }
          AppBrandBackgroundRunningMonitor.access$200();
          AppBrandBackgroundRunningMonitor.et(paramAnonymousString);
          AppBrandBackgroundRunningMonitor.aSG().dead();
        }
        AppMethodBeat.o(195657);
      }
    });
    AppMethodBeat.o(195662);
  }
  
  private static void z(o paramo)
  {
    AppMethodBeat.i(44782);
    ad.i("MicroMsg.AppBrandBackgroundRunningMonitor", "sendRemoveLocationUsageOperation, runtime:%s", new Object[] { paramo.mAppId });
    if (com.tencent.mm.kernel.g.ab(g.class) != null)
    {
      AppBrandBackgroundRunningOperationParcel localAppBrandBackgroundRunningOperationParcel = new AppBrandBackgroundRunningOperationParcel();
      localAppBrandBackgroundRunningOperationParcel.appId = paramo.mAppId;
      localAppBrandBackgroundRunningOperationParcel.gXn = paramo.iDx.iOP;
      localAppBrandBackgroundRunningOperationParcel.aTC = d.iXP.aTC;
      localAppBrandBackgroundRunningOperationParcel.dbV = 2;
      if (com.tencent.mm.sdk.f.a.iV(paramo.mContext) != null) {
        localAppBrandBackgroundRunningOperationParcel.iXE = com.tencent.mm.sdk.f.a.iV(paramo.mContext).getClass().getName();
      }
      ((g)com.tencent.mm.kernel.g.ab(g.class)).a(localAppBrandBackgroundRunningOperationParcel);
    }
    Fo(paramo.mAppId);
    AppMethodBeat.o(44782);
  }
  
  static class NotifyLocationBackgroundChanged
    implements Parcelable
  {
    public static final Parcelable.Creator<NotifyLocationBackgroundChanged> CREATOR;
    public String appId;
    public boolean iXN;
    
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
        this.iXN = bool;
        AppMethodBeat.o(44778);
        return;
      }
    }
    
    public NotifyLocationBackgroundChanged(String paramString)
    {
      this.appId = paramString;
      this.iXN = false;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(44779);
      paramParcel.writeString(this.appId);
      if (this.iXN) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningMonitor
 * JD-Core Version:    0.7.0.1
 */