package com.tencent.mm.plugin.appbrand.task.ipc;

import android.app.Activity;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.e.i;
import com.tencent.luggage.sdk.processes.client.LuggageClientProcessMessage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.ui.o;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.xweb.WebView;
import com.tencent.xweb.aj;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/task/ipc/AppBrandKillByClientMessage;", "Lcom/tencent/luggage/sdk/processes/client/LuggageClientProcessMessage;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "appId", "", "killTypeOrdinal", "", "(Ljava/lang/String;I)V", "getAppId", "()Ljava/lang/String;", "killType", "Lcom/tencent/luggage/sdk/processes/KillType;", "autoStartAccountExpiredUI", "", "describeContents", "runInLuggageProcess", "", "runtime", "silentKill", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandKillByClientMessage
  extends LuggageClientProcessMessage<t>
{
  public static final Parcelable.Creator CREATOR;
  @Deprecated
  public static final AppBrandKillByClientMessage.a qSg;
  private final String appId;
  private final com.tencent.luggage.sdk.processes.b qSe;
  private final int qSf;
  
  static
  {
    AppMethodBeat.i(269401);
    qSg = new AppBrandKillByClientMessage.a((byte)0);
    CREATOR = new b();
    AppMethodBeat.o(269401);
  }
  
  public AppBrandKillByClientMessage(String paramString, int paramInt)
  {
    super(paramString);
    AppMethodBeat.i(269400);
    this.appId = paramString;
    this.qSf = paramInt;
    this.qSe = com.tencent.luggage.sdk.processes.b.values()[this.qSf];
    AppMethodBeat.o(269400);
  }
  
  private static void O(t paramt)
  {
    AppMethodBeat.i(269397);
    Log.i("MicroMsg.AppBrandKillByClientMessage", "silentKill runtime:" + paramt.getAppId());
    paramt.S((Runnable)AppBrandKillByClientMessage.d.qSi);
    AppMethodBeat.o(269397);
  }
  
  public final void N(final t paramt)
  {
    AppMethodBeat.i(269393);
    p.k(paramt, "runtime");
    if ((p.h(Looper.getMainLooper(), Looper.myLooper()) ^ true))
    {
      com.tencent.e.h.ZvG.bc((Runnable)new c(this, paramt));
      AppMethodBeat.o(269393);
      return;
    }
    Log.i("MicroMsg.AppBrandKillByClientMessage", "runInLuggageProcess killType:" + this.qSe + ", web-kernel:" + WebView.getCurWebType());
    Object localObject = this.qSe;
    switch (a.$EnumSwitchMapping$0[localObject.ordinal()])
    {
    default: 
    case 1: 
    case 2: 
      do
      {
        for (;;)
        {
          O(paramt);
          AppMethodBeat.o(269393);
          return;
          aj.clearAllWebViewCache(MMApplicationContext.getContext(), true);
        }
        aj.clearAllWebViewCache(MMApplicationContext.getContext(), true);
      } while (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.waf, false));
      localObject = paramt.getContext();
      if (localObject != null)
      {
        paramt = o.qYS;
        p.j(localObject, "this");
        o.H((Activity)localObject);
        AppMethodBeat.o(269393);
        return;
      }
      O(paramt);
      AppMethodBeat.o(269393);
      return;
    }
    paramt = paramt.getContext();
    if (paramt != null)
    {
      paramt.finish();
      AppMethodBeat.o(269393);
      return;
    }
    AppMethodBeat.o(269393);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String getAppId()
  {
    return this.appId;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(269402);
    p.k(paramParcel, "parcel");
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.qSf);
    AppMethodBeat.o(269402);
  }
  
  @l(iBK={1, 1, 16})
  public static final class b
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(272439);
      p.k(paramParcel, "in");
      paramParcel = new AppBrandKillByClientMessage(paramParcel.readString(), paramParcel.readInt());
      AppMethodBeat.o(272439);
      return paramParcel;
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new AppBrandKillByClientMessage[paramInt];
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(AppBrandKillByClientMessage paramAppBrandKillByClientMessage, t paramt) {}
    
    public final void run()
    {
      AppMethodBeat.i(271093);
      this.qSh.N(paramt);
      AppMethodBeat.o(271093);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.ipc.AppBrandKillByClientMessage
 * JD-Core Version:    0.7.0.1
 */