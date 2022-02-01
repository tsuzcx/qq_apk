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
import com.tencent.mm.plugin.appbrand.jsapi.d.r;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AuthStateChangedByUserEvent;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class AppBrandBackgroundRunningMonitor
{
  private static MMToClientEvent.c jya;
  private static g.a jyb;
  private static com.tencent.mm.sdk.b.c jyc;
  
  static
  {
    AppMethodBeat.i(186390);
    jyc = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(186390);
  }
  
  private static void Js(String paramString)
  {
    AppMethodBeat.i(44783);
    if (ai.ciE())
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
    AppMethodBeat.i(186378);
    Object localObject;
    boolean bool1;
    if (paramo != null)
    {
      localObject = (com.tencent.mm.plugin.appbrand.jsapi.d.q)paramo.as(com.tencent.mm.plugin.appbrand.jsapi.d.q.class);
      if (!(localObject instanceof r))
      {
        ac.w("MicroMsg.AppBrandBackgroundRunningMonitor", "handleUserAuthChanged, invalid location state manager");
        AppMethodBeat.o(186378);
        return;
      }
      localObject = (r)localObject;
      bool2 = paramAuthStateChangedByUserEvent.maE;
      boolean bool3 = paramAuthStateChangedByUserEvent.maF;
      if ((((com.tencent.mm.plugin.appbrand.jsapi.d.q)localObject).ktk) || (bool2)) {
        break label150;
      }
      bool1 = true;
      if ((!((com.tencent.mm.plugin.appbrand.jsapi.d.q)localObject).ktk) || ((bool3) && (bool2))) {
        break label155;
      }
    }
    label150:
    label155:
    for (boolean bool2 = true;; bool2 = false)
    {
      ac.i("MicroMsg.AppBrandBackgroundRunningMonitor", "handleUserAuthChanged, should stop location foreground:%s, should stop location background:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) || (bool2))
      {
        ((r)localObject).bgZ();
        ((r)localObject).ad(paramo);
      }
      if (bool2) {
        z(paramo);
      }
      AppMethodBeat.o(186378);
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
    AppMethodBeat.i(186379);
    if (com.tencent.mm.kernel.g.ab(g.class) != null)
    {
      AppBrandBackgroundRunningOperationParcel localAppBrandBackgroundRunningOperationParcel = new AppBrandBackgroundRunningOperationParcel();
      localAppBrandBackgroundRunningOperationParcel.appId = paramq.getAppId();
      localAppBrandBackgroundRunningOperationParcel.hxM = paramq.getRuntime().jdx.joY;
      localAppBrandBackgroundRunningOperationParcel.aUu = paramInt2;
      localAppBrandBackgroundRunningOperationParcel.cZu = paramInt1;
      localAppBrandBackgroundRunningOperationParcel.jxU = paramq.getContext().getClass().getName();
      localAppBrandBackgroundRunningOperationParcel.process = ai.getProcessName();
      localAppBrandBackgroundRunningOperationParcel.jye = paramBoolean;
      if (paramInt2 == d.jyh.aUu) {
        localAppBrandBackgroundRunningOperationParcel.jxV = AppBrandAudioOfVideoBackgroundPlayNotificationLogic.class.getName();
      }
      if (((paramq instanceof com.tencent.mm.plugin.appbrand.service.c)) && (paramq.getRuntime() != null) && (paramq.getRuntime().DJ() != null))
      {
        paramq = (AppBrandInitConfigWC)paramq.getRuntime().DJ();
        localAppBrandBackgroundRunningOperationParcel.name = paramq.ddh;
        localAppBrandBackgroundRunningOperationParcel.drM = paramq.iconUrl;
        localAppBrandBackgroundRunningOperationParcel.username = paramq.username;
      }
      ((g)com.tencent.mm.kernel.g.ab(g.class)).a(localAppBrandBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(186379);
  }
  
  private static void ai(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(44784);
    e.b(paramString, new EventLocationBackgroundStateChanged(paramBoolean));
    AppMethodBeat.o(44784);
  }
  
  public static void y(o paramo)
  {
    AppMethodBeat.i(186380);
    ac.i("MicroMsg.AppBrandBackgroundRunningMonitor", "startRuntimeStateMonitor");
    ac.i("MicroMsg.AppBrandBackgroundRunningMonitor", "startListeningOperationReceived");
    if (jyb == null) {
      jyb = new g.a()
      {
        public final void b(MMBackgroundRunningOperationParcel paramAnonymousMMBackgroundRunningOperationParcel)
        {
          AppMethodBeat.i(186376);
          ac.i("MicroMsg.AppBrandBackgroundRunningMonitor", "onBackgroundRunningOperationReceived, operation:%s", new Object[] { paramAnonymousMMBackgroundRunningOperationParcel });
          o localo = com.tencent.mm.plugin.appbrand.a.GU(paramAnonymousMMBackgroundRunningOperationParcel.appId);
          if (localo == null)
          {
            ac.w("MicroMsg.AppBrandBackgroundRunningMonitor", "onBackgroundRunningOperationReceived, runtime is null");
            AppMethodBeat.o(186376);
            return;
          }
          if (paramAnonymousMMBackgroundRunningOperationParcel.cZu == 2)
          {
            AppBrandBackgroundRunningMonitor.a(paramAnonymousMMBackgroundRunningOperationParcel, localo);
            AppBrandBackgroundRunningMonitor.b(paramAnonymousMMBackgroundRunningOperationParcel, localo);
            AppBrandBackgroundRunningMonitor.c(paramAnonymousMMBackgroundRunningOperationParcel, localo);
            AppBrandBackgroundRunningMonitor.d(paramAnonymousMMBackgroundRunningOperationParcel, localo);
          }
          AppMethodBeat.o(186376);
        }
      };
    }
    if (com.tencent.mm.kernel.g.ab(g.class) != null) {
      ((g)com.tencent.mm.kernel.g.ab(g.class)).a(jyb);
    }
    String str = paramo.mAppId;
    ac.i("MicroMsg.AppBrandBackgroundRunningMonitor", "startListeningOperationEvent, appId:%s", new Object[] { str });
    if (jya == null) {
      jya = new MMToClientEvent.c()
      {
        public final void cf(Object paramAnonymousObject)
        {
          AppMethodBeat.i(186377);
          if ((paramAnonymousObject instanceof MMBackgroundRunningOperationParcel))
          {
            ac.i("MicroMsg.AppBrandBackgroundRunningMonitor", "app received data, operation:%s", new Object[] { (MMBackgroundRunningOperationParcel)paramAnonymousObject });
            if (com.tencent.mm.kernel.g.ab(g.class) != null) {
              ((g)com.tencent.mm.kernel.g.ab(g.class)).a((MMBackgroundRunningOperationParcel)paramAnonymousObject);
            }
          }
          AppMethodBeat.o(186377);
        }
      };
    }
    MMToClientEvent.a(str, jya);
    jyc.alive();
    paramo.jdK.a(new c.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.b.b paramAnonymousb)
      {
        AppMethodBeat.i(186375);
        if (paramAnonymousb == com.tencent.mm.plugin.appbrand.b.b.jqX)
        {
          ac.i("MicroMsg.AppBrandBackgroundRunningMonitor", "AppBrandRuntime state changed to destroyed");
          if (com.tencent.mm.kernel.g.ab(g.class) != null)
          {
            paramAnonymousb = new AppBrandBackgroundRunningOperationParcel();
            paramAnonymousb.appId = paramAnonymousString;
            paramAnonymousb.aUu = d.jyj.aUu;
            paramAnonymousb.cZu = 2;
            if (com.tencent.mm.plugin.appbrand.a.GU(paramAnonymousString) != null)
            {
              o localo = com.tencent.mm.plugin.appbrand.a.GU(paramAnonymousString);
              if (localo != null)
              {
                paramAnonymousb.hxM = localo.jdx.joY;
                if (com.tencent.mm.sdk.f.a.jg(localo.mContext) != null) {
                  paramAnonymousb.jxU = com.tencent.mm.sdk.f.a.jg(localo.mContext).getClass().getName();
                }
              }
            }
            ((g)com.tencent.mm.kernel.g.ab(g.class)).a(paramAnonymousb);
          }
          AppBrandBackgroundRunningMonitor.access$200();
          AppBrandBackgroundRunningMonitor.ei(paramAnonymousString);
          AppBrandBackgroundRunningMonitor.aZD().dead();
        }
        AppMethodBeat.o(186375);
      }
    });
    AppMethodBeat.o(186380);
  }
  
  private static void z(o paramo)
  {
    AppMethodBeat.i(44782);
    ac.i("MicroMsg.AppBrandBackgroundRunningMonitor", "sendRemoveLocationUsageOperation, runtime:%s", new Object[] { paramo.mAppId });
    if (com.tencent.mm.kernel.g.ab(g.class) != null)
    {
      AppBrandBackgroundRunningOperationParcel localAppBrandBackgroundRunningOperationParcel = new AppBrandBackgroundRunningOperationParcel();
      localAppBrandBackgroundRunningOperationParcel.appId = paramo.mAppId;
      localAppBrandBackgroundRunningOperationParcel.hxM = paramo.jdx.joY;
      localAppBrandBackgroundRunningOperationParcel.aUu = d.jyf.aUu;
      localAppBrandBackgroundRunningOperationParcel.cZu = 2;
      if (com.tencent.mm.sdk.f.a.jg(paramo.mContext) != null) {
        localAppBrandBackgroundRunningOperationParcel.jxU = com.tencent.mm.sdk.f.a.jg(paramo.mContext).getClass().getName();
      }
      ((g)com.tencent.mm.kernel.g.ab(g.class)).a(localAppBrandBackgroundRunningOperationParcel);
    }
    Js(paramo.mAppId);
    AppMethodBeat.o(44782);
  }
  
  static class NotifyLocationBackgroundChanged
    implements Parcelable
  {
    public static final Parcelable.Creator<NotifyLocationBackgroundChanged> CREATOR;
    public String appId;
    public boolean jyd;
    
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
        this.jyd = bool;
        AppMethodBeat.o(44778);
        return;
      }
    }
    
    public NotifyLocationBackgroundChanged(String paramString)
    {
      this.appId = paramString;
      this.jyd = false;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(44779);
      paramParcel.writeString(this.appId);
      if (this.jyd) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningMonitor
 * JD-Core Version:    0.7.0.1
 */