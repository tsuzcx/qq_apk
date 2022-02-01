package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.ipc.e;
import com.tencent.mm.plugin.appbrand.jsapi.EventLocationBackgroundStateChanged;
import com.tencent.mm.plugin.appbrand.jsapi.g.s;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AuthStateChangedByUserEvent;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashSet;
import java.util.Set;

public final class AppBrandBackgroundRunningMonitor
{
  private static MMToClientEvent.c jVn;
  private static f.a jVo;
  private static com.tencent.mm.sdk.b.c jVp;
  private static Set<String> jVq;
  
  static
  {
    AppMethodBeat.i(222202);
    jVp = new com.tencent.mm.sdk.b.c() {};
    jVq = new HashSet();
    AppMethodBeat.o(222202);
  }
  
  private static void Ns(String paramString)
  {
    AppMethodBeat.i(44783);
    if (ak.cpe())
    {
      ai(paramString, false);
      AppMethodBeat.o(44783);
      return;
    }
    XIPCInvoker.a("com.tencent.mm", new NotifyLocationBackgroundChanged(paramString), a.class, null);
    AppMethodBeat.o(44783);
  }
  
  public static void a(p paramp, AppBrandAuthorizeUI.AuthStateChangedByUserEvent paramAuthStateChangedByUserEvent)
  {
    AppMethodBeat.i(222190);
    Object localObject;
    boolean bool1;
    if (paramp != null)
    {
      localObject = (com.tencent.mm.plugin.appbrand.jsapi.g.r)paramp.as(com.tencent.mm.plugin.appbrand.jsapi.g.r.class);
      if (!(localObject instanceof s))
      {
        ae.w("MicroMsg.AppBrandBackgroundRunningMonitor", "handleUserAuthChanged, invalid location state manager");
        AppMethodBeat.o(222190);
        return;
      }
      localObject = (s)localObject;
      bool2 = paramAuthStateChangedByUserEvent.mFx;
      boolean bool3 = paramAuthStateChangedByUserEvent.mFy;
      if ((((com.tencent.mm.plugin.appbrand.jsapi.g.r)localObject).kSo) || (bool2)) {
        break label150;
      }
      bool1 = true;
      if ((!((com.tencent.mm.plugin.appbrand.jsapi.g.r)localObject).kSo) || ((bool3) && (bool2))) {
        break label155;
      }
    }
    label150:
    label155:
    for (boolean bool2 = true;; bool2 = false)
    {
      ae.i("MicroMsg.AppBrandBackgroundRunningMonitor", "handleUserAuthChanged, should stop location foreground:%s, should stop location background:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) || (bool2))
      {
        ((s)localObject).blo();
        ((s)localObject).W(paramp);
      }
      if (bool2) {
        r(paramp);
      }
      AppMethodBeat.o(222190);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.r paramr, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44781);
    a(paramr, paramInt1, paramInt2, false);
    AppMethodBeat.o(44781);
  }
  
  private static void a(com.tencent.mm.plugin.appbrand.r paramr, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(222191);
    if (g.ab(f.class) != null)
    {
      AppBrandBackgroundRunningOperationParcel localAppBrandBackgroundRunningOperationParcel = new AppBrandBackgroundRunningOperationParcel();
      localAppBrandBackgroundRunningOperationParcel.appId = paramr.getAppId();
      localAppBrandBackgroundRunningOperationParcel.hSZ = paramr.getRuntime().jzC.dQv;
      localAppBrandBackgroundRunningOperationParcel.beO = paramInt2;
      localAppBrandBackgroundRunningOperationParcel.dlO = paramInt1;
      localAppBrandBackgroundRunningOperationParcel.jVi = paramr.getContext().getClass().getName();
      localAppBrandBackgroundRunningOperationParcel.process = ak.getProcessName();
      localAppBrandBackgroundRunningOperationParcel.jVs = paramBoolean;
      if (paramInt2 == c.jVv.beO) {
        localAppBrandBackgroundRunningOperationParcel.jVj = AppBrandAudioOfVideoBackgroundPlayNotificationLogic.class.getName();
      }
      if (((paramr instanceof com.tencent.mm.plugin.appbrand.service.c)) && (paramr.getRuntime() != null) && (paramr.getRuntime().Fn() != null))
      {
        paramr = (AppBrandInitConfigWC)paramr.getRuntime().Fn();
        localAppBrandBackgroundRunningOperationParcel.name = paramr.dpI;
        localAppBrandBackgroundRunningOperationParcel.dEM = paramr.iconUrl;
        localAppBrandBackgroundRunningOperationParcel.username = paramr.username;
      }
      ((f)g.ab(f.class)).a(localAppBrandBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(222191);
  }
  
  private static void ai(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(44784);
    e.b(paramString, new EventLocationBackgroundStateChanged(paramBoolean));
    AppMethodBeat.o(44784);
  }
  
  public static void q(p paramp)
  {
    AppMethodBeat.i(222192);
    ae.i("MicroMsg.AppBrandBackgroundRunningMonitor", "startRuntimeStateMonitor");
    if (!jVq.add(paramp.mAppId))
    {
      ae.i("MicroMsg.AppBrandBackgroundRunningMonitor", "startRuntimeStateMonitor, already start, return");
      AppMethodBeat.o(222192);
      return;
    }
    ae.i("MicroMsg.AppBrandBackgroundRunningMonitor", "startListeningOperationReceivedIfNeed");
    if (jVo == null)
    {
      jVo = new f.a()
      {
        public final void b(MMBackgroundRunningOperationParcel paramAnonymousMMBackgroundRunningOperationParcel)
        {
          AppMethodBeat.i(222188);
          ae.i("MicroMsg.AppBrandBackgroundRunningMonitor", "onBackgroundRunningOperationReceived, operation:%s", new Object[] { paramAnonymousMMBackgroundRunningOperationParcel });
          p localp = com.tencent.mm.plugin.appbrand.a.KI(paramAnonymousMMBackgroundRunningOperationParcel.appId);
          if (localp == null)
          {
            ae.w("MicroMsg.AppBrandBackgroundRunningMonitor", "onBackgroundRunningOperationReceived, runtime is null");
            AppMethodBeat.o(222188);
            return;
          }
          if (paramAnonymousMMBackgroundRunningOperationParcel.dlO == 2)
          {
            AppBrandBackgroundRunningMonitor.a(paramAnonymousMMBackgroundRunningOperationParcel, localp);
            AppBrandBackgroundRunningMonitor.b(paramAnonymousMMBackgroundRunningOperationParcel, localp);
            AppBrandBackgroundRunningMonitor.c(paramAnonymousMMBackgroundRunningOperationParcel, localp);
            AppBrandBackgroundRunningMonitor.d(paramAnonymousMMBackgroundRunningOperationParcel, localp);
          }
          AppMethodBeat.o(222188);
        }
      };
      if (g.ab(f.class) != null) {
        ((f)g.ab(f.class)).a(jVo);
      }
    }
    String str = paramp.mAppId;
    ae.i("MicroMsg.AppBrandBackgroundRunningMonitor", "startListeningOperationEvent, appId:%s", new Object[] { str });
    if (jVn == null) {
      jVn = new AppBrandBackgroundRunningMonitor.4();
    }
    MMToClientEvent.a(str, jVn);
    if (1 == jVq.size())
    {
      ae.i("MicroMsg.AppBrandBackgroundRunningMonitor", "startRuntimeStateMonitor, first start, alive listener");
      jVp.alive();
    }
    paramp.jzQ.a(new c.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.a.b paramAnonymousb)
      {
        AppMethodBeat.i(222187);
        if (paramAnonymousb == com.tencent.mm.plugin.appbrand.a.b.jOd)
        {
          ae.i("MicroMsg.AppBrandBackgroundRunningMonitor", "AppBrandRuntime state changed to destroyed");
          if (g.ab(f.class) != null)
          {
            paramAnonymousb = new AppBrandBackgroundRunningOperationParcel();
            paramAnonymousb.appId = paramAnonymousString;
            paramAnonymousb.beO = c.jVx.beO;
            paramAnonymousb.dlO = 2;
            if (com.tencent.mm.plugin.appbrand.a.KI(paramAnonymousString) != null)
            {
              p localp = com.tencent.mm.plugin.appbrand.a.KI(paramAnonymousString);
              if (localp != null)
              {
                paramAnonymousb.hSZ = localp.jzC.dQv;
                if (com.tencent.mm.sdk.f.a.jw(localp.mContext) != null) {
                  paramAnonymousb.jVi = com.tencent.mm.sdk.f.a.jw(localp.mContext).getClass().getName();
                }
              }
            }
            ((f)g.ab(f.class)).a(paramAnonymousb);
          }
          if (!AppBrandBackgroundRunningMonitor.bdG().remove(paramAnonymousString))
          {
            ae.w("MicroMsg.AppBrandBackgroundRunningMonitor", "onRunningStateChanged, not start, return");
            AppMethodBeat.o(222187);
            return;
          }
          boolean bool = AppBrandBackgroundRunningMonitor.bdG().isEmpty();
          if (bool) {
            AppBrandBackgroundRunningMonitor.access$300();
          }
          AppBrandBackgroundRunningMonitor.aj(paramAnonymousString, bool);
          if (bool)
          {
            ae.i("MicroMsg.AppBrandBackgroundRunningMonitor", "onRunningStateChanged, last stop, dead listener");
            AppBrandBackgroundRunningMonitor.bdH().dead();
          }
        }
        AppMethodBeat.o(222187);
      }
    });
    AppMethodBeat.o(222192);
  }
  
  private static void r(p paramp)
  {
    AppMethodBeat.i(44782);
    ae.i("MicroMsg.AppBrandBackgroundRunningMonitor", "sendRemoveLocationUsageOperation, runtime:%s", new Object[] { paramp.mAppId });
    if (g.ab(f.class) != null)
    {
      AppBrandBackgroundRunningOperationParcel localAppBrandBackgroundRunningOperationParcel = new AppBrandBackgroundRunningOperationParcel();
      localAppBrandBackgroundRunningOperationParcel.appId = paramp.mAppId;
      localAppBrandBackgroundRunningOperationParcel.hSZ = paramp.jzC.dQv;
      localAppBrandBackgroundRunningOperationParcel.beO = c.jVt.beO;
      localAppBrandBackgroundRunningOperationParcel.dlO = 2;
      if (com.tencent.mm.sdk.f.a.jw(paramp.mContext) != null) {
        localAppBrandBackgroundRunningOperationParcel.jVi = com.tencent.mm.sdk.f.a.jw(paramp.mContext).getClass().getName();
      }
      ((f)g.ab(f.class)).a(localAppBrandBackgroundRunningOperationParcel);
    }
    Ns(paramp.mAppId);
    AppMethodBeat.o(44782);
  }
  
  static class NotifyLocationBackgroundChanged
    implements Parcelable
  {
    public static final Parcelable.Creator<NotifyLocationBackgroundChanged> CREATOR;
    public String appId;
    public boolean jVr;
    
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
        this.jVr = bool;
        AppMethodBeat.o(44778);
        return;
      }
    }
    
    public NotifyLocationBackgroundChanged(String paramString)
    {
      this.appId = paramString;
      this.jVr = false;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(44779);
      paramParcel.writeString(this.appId);
      if (this.jVr) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningMonitor
 * JD-Core Version:    0.7.0.1
 */