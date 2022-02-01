package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.lifecycle.q;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.jsapi.EventLocationBackgroundStateChanged;
import com.tencent.mm.plugin.appbrand.jsapi.al.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.m.u;
import com.tencent.mm.plugin.appbrand.jsapi.m.v;
import com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AuthStateChangedByUserEvent;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.HashSet;
import java.util.Set;

public final class AppBrandBackgroundRunningMonitor
{
  private static MMToClientEvent.c qSg;
  private static f.a qSh;
  private static IListener qSi;
  private static Set<String> qSj;
  
  static
  {
    AppMethodBeat.i(318295);
    qSi = new IListener(com.tencent.mm.app.f.hfK) {};
    qSj = new HashSet();
    AppMethodBeat.o(318295);
  }
  
  public static void A(w paramw)
  {
    AppMethodBeat.i(318184);
    Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "startRuntimeStateMonitor");
    if (!qSj.add(paramw.mAppId))
    {
      Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "startRuntimeStateMonitor, already start, return");
      AppMethodBeat.o(318184);
      return;
    }
    Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "startListeningOperationReceivedIfNeed");
    if (qSh == null)
    {
      qSh = new f.a()
      {
        public final void onBackgroundRunningOperationReceived(MMBackgroundRunningOperationParcel paramAnonymousMMBackgroundRunningOperationParcel)
        {
          AppMethodBeat.i(318109);
          Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "onBackgroundRunningOperationReceived, operation:%s", new Object[] { paramAnonymousMMBackgroundRunningOperationParcel });
          w localw = com.tencent.mm.plugin.appbrand.d.Uc(paramAnonymousMMBackgroundRunningOperationParcel.appId);
          if (localw == null)
          {
            Log.w("MicroMsg.AppBrandBackgroundRunningMonitor", "onBackgroundRunningOperationReceived, runtime is null");
            AppMethodBeat.o(318109);
            return;
          }
          if (paramAnonymousMMBackgroundRunningOperationParcel.hAf == 2)
          {
            AppBrandBackgroundRunningMonitor.a(paramAnonymousMMBackgroundRunningOperationParcel, localw);
            AppBrandBackgroundRunningMonitor.b(paramAnonymousMMBackgroundRunningOperationParcel, localw);
            AppBrandBackgroundRunningMonitor.c(paramAnonymousMMBackgroundRunningOperationParcel, localw);
            AppBrandBackgroundRunningMonitor.d(paramAnonymousMMBackgroundRunningOperationParcel, localw);
          }
          AppMethodBeat.o(318109);
        }
      };
      if (h.ax(f.class) != null) {
        ((f)h.ax(f.class)).a(qSh);
      }
    }
    String str = paramw.mAppId;
    Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "startListeningOperationEvent, appId:%s", new Object[] { str });
    if (qSg == null) {
      qSg = new MMToClientEvent.c()
      {
        public final void dL(Object paramAnonymousObject)
        {
          AppMethodBeat.i(318110);
          if ((paramAnonymousObject instanceof MMBackgroundRunningOperationParcel))
          {
            Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "app received data, operation:%s", new Object[] { (MMBackgroundRunningOperationParcel)paramAnonymousObject });
            if (h.ax(f.class) != null) {
              ((f)h.ax(f.class)).a((MMBackgroundRunningOperationParcel)paramAnonymousObject);
            }
          }
          AppMethodBeat.o(318110);
        }
      };
    }
    MMToClientEvent.a(str, qSg);
    if (1 == qSj.size())
    {
      Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "startRuntimeStateMonitor, first start, alive listener");
      qSi.alive();
    }
    paramw.qsB.a(new c.a()
    {
      public final void onRunningStateChanged(String paramAnonymousString, b paramAnonymousb)
      {
        AppMethodBeat.i(318123);
        if (paramAnonymousb == b.qKz)
        {
          Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "AppBrandRuntime state changed to destroyed");
          if (h.ax(f.class) != null)
          {
            paramAnonymousb = new AppBrandBackgroundRunningOperationParcel();
            paramAnonymousb.appId = paramAnonymousString;
            paramAnonymousb.cIi = c.qSr.cIi;
            paramAnonymousb.hAf = 2;
            if (com.tencent.mm.plugin.appbrand.d.Uc(paramAnonymousString) != null)
            {
              w localw = com.tencent.mm.plugin.appbrand.d.Uc(paramAnonymousString);
              if (localw != null)
              {
                paramAnonymousb.epc = localw.asA().epc;
                paramAnonymousb.euz = localw.qsh.eul;
                if (AndroidContextUtil.castActivityOrNull(localw.mContext) != null) {
                  paramAnonymousb.qSb = AndroidContextUtil.castActivityOrNull(localw.mContext).getClass().getName();
                }
              }
            }
            ((f)h.ax(f.class)).a(paramAnonymousb);
          }
          if (!AppBrandBackgroundRunningMonitor.cjM().remove(paramAnonymousString))
          {
            Log.w("MicroMsg.AppBrandBackgroundRunningMonitor", "onRunningStateChanged, not start, return");
            AppMethodBeat.o(318123);
            return;
          }
          boolean bool = AppBrandBackgroundRunningMonitor.cjM().isEmpty();
          if (bool) {
            AppBrandBackgroundRunningMonitor.access$300();
          }
          AppBrandBackgroundRunningMonitor.au(paramAnonymousString, bool);
          if (bool)
          {
            Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "onRunningStateChanged, last stop, dead listener");
            AppBrandBackgroundRunningMonitor.cjN().dead();
          }
        }
        AppMethodBeat.o(318123);
      }
    });
    AppMethodBeat.o(318184);
  }
  
  private static void B(w paramw)
  {
    AppMethodBeat.i(44782);
    Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "sendRemoveLocationUsageOperation, runtime:%s", new Object[] { paramw.mAppId });
    if (h.ax(f.class) != null)
    {
      AppBrandBackgroundRunningOperationParcel localAppBrandBackgroundRunningOperationParcel = new AppBrandBackgroundRunningOperationParcel();
      localAppBrandBackgroundRunningOperationParcel.appId = paramw.mAppId;
      localAppBrandBackgroundRunningOperationParcel.euz = paramw.qsh.eul;
      localAppBrandBackgroundRunningOperationParcel.cIi = c.qSm.cIi;
      localAppBrandBackgroundRunningOperationParcel.hAf = 2;
      localAppBrandBackgroundRunningOperationParcel.epc = paramw.asA().epc;
      if (AndroidContextUtil.castActivityOrNull(paramw.mContext) != null) {
        localAppBrandBackgroundRunningOperationParcel.qSb = AndroidContextUtil.castActivityOrNull(paramw.mContext).getClass().getName();
      }
      ((f)h.ax(f.class)).a(localAppBrandBackgroundRunningOperationParcel);
    }
    WO(paramw.mAppId);
    AppMethodBeat.o(44782);
  }
  
  private static void WO(String paramString)
  {
    AppMethodBeat.i(44783);
    if (MMApplicationContext.isMMProcess())
    {
      at(paramString, false);
      AppMethodBeat.o(44783);
      return;
    }
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new NotifyLocationBackgroundChanged(paramString), a.class, null);
    AppMethodBeat.o(44783);
  }
  
  public static void a(w paramw, AppBrandAuthorizeUI.AuthStateChangedByUserEvent paramAuthStateChangedByUserEvent)
  {
    AppMethodBeat.i(318166);
    Object localObject;
    boolean bool1;
    if (paramw != null)
    {
      localObject = (u)paramw.aO(u.class);
      if (!(localObject instanceof v))
      {
        Log.w("MicroMsg.AppBrandBackgroundRunningMonitor", "handleUserAuthChanged, invalid location state manager");
        AppMethodBeat.o(318166);
        return;
      }
      localObject = (v)localObject;
      bool2 = paramAuthStateChangedByUserEvent.tYI;
      boolean bool3 = paramAuthStateChangedByUserEvent.tYJ;
      if ((((u)localObject).sax) || (bool2)) {
        break label155;
      }
      bool1 = true;
      if ((!((u)localObject).sax) || ((bool3) && (bool2))) {
        break label160;
      }
    }
    label155:
    label160:
    for (boolean bool2 = true;; bool2 = false)
    {
      Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "handleUserAuthChanged, should stop location foreground:%s, should stop location background:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) || (bool2))
      {
        ((v)localObject).csw();
        ((v)localObject).am(paramw);
      }
      if (bool2) {
        B(paramw);
      }
      AppMethodBeat.o(318166);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static void a(y paramy, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44781);
    a(paramy, paramInt1, paramInt2, false);
    AppMethodBeat.o(44781);
  }
  
  private static void a(y paramy, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(318178);
    if (h.ax(f.class) != null)
    {
      AppBrandBackgroundRunningOperationParcel localAppBrandBackgroundRunningOperationParcel = new AppBrandBackgroundRunningOperationParcel();
      localAppBrandBackgroundRunningOperationParcel.appId = paramy.getAppId();
      localAppBrandBackgroundRunningOperationParcel.euz = paramy.getRuntime().qsh.eul;
      localAppBrandBackgroundRunningOperationParcel.cIi = paramInt2;
      localAppBrandBackgroundRunningOperationParcel.hAf = paramInt1;
      localAppBrandBackgroundRunningOperationParcel.qSb = paramy.getContext().getClass().getName();
      localAppBrandBackgroundRunningOperationParcel.mzg = MMApplicationContext.getProcessName();
      localAppBrandBackgroundRunningOperationParcel.qSl = paramBoolean;
      localAppBrandBackgroundRunningOperationParcel.epc = ((AppBrandInitConfigLU)paramy.getRuntime().asH()).epc;
      if (paramInt2 == c.qSo.cIi) {
        localAppBrandBackgroundRunningOperationParcel.qSc = AppBrandAudioOfVideoBackgroundPlayNotificationLogic.class.getName();
      }
      if (((paramy instanceof com.tencent.mm.plugin.appbrand.service.c)) && (paramy.getRuntime() != null) && (paramy.getRuntime().asH() != null))
      {
        paramy = (AppBrandInitConfigWC)paramy.getRuntime().asH();
        localAppBrandBackgroundRunningOperationParcel.name = paramy.hEy;
        localAppBrandBackgroundRunningOperationParcel.icon = paramy.iconUrl;
        localAppBrandBackgroundRunningOperationParcel.username = paramy.username;
      }
      ((f)h.ax(f.class)).a(localAppBrandBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(318178);
  }
  
  private static void at(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(44784);
    com.tencent.mm.plugin.appbrand.ipc.f.b(paramString, new EventLocationBackgroundStateChanged(paramBoolean));
    AppMethodBeat.o(44784);
  }
  
  static class NotifyLocationBackgroundChanged
    implements Parcelable
  {
    public static final Parcelable.Creator<NotifyLocationBackgroundChanged> CREATOR;
    public String appId;
    public boolean qSk;
    
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
        this.qSk = bool;
        AppMethodBeat.o(44778);
        return;
      }
    }
    
    public NotifyLocationBackgroundChanged(String paramString)
    {
      this.appId = paramString;
      this.qSk = false;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(44779);
      paramParcel.writeString(this.appId);
      if (this.qSk) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningMonitor
 * JD-Core Version:    0.7.0.1
 */