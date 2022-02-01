package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.processes.client.LuggageClientProcessMessage;
import com.tencent.luggage.sdk.processes.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ag.b;
import com.tencent.mm.plugin.appbrand.task.i.a;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPluginUpdateStatusChangeIPCMessage;", "Lcom/tencent/luggage/sdk/processes/client/LuggageClientProcessMessage;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "appId", "", "instanceId", "state", "Lcom/tencent/mm/plugin/appbrand/jsapi/version/UpdateState;", "pluginAppId", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/version/UpdateState;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getInstanceId", "getPluginAppId", "getState", "()Lcom/tencent/mm/plugin/appbrand/jsapi/version/UpdateState;", "describeContents", "", "runInLuggageProcess", "", "runtime", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandPluginUpdateStatusChangeIPCMessage
  extends LuggageClientProcessMessage<w>
{
  public static final Parcelable.Creator<AppBrandPluginUpdateStatusChangeIPCMessage> CREATOR;
  public static final a sVX;
  private final String appId;
  private final String eup;
  private final com.tencent.mm.plugin.appbrand.jsapi.ag.c sVY;
  private final String sVZ;
  
  static
  {
    AppMethodBeat.i(321077);
    sVX = new a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(321077);
  }
  
  public AppBrandPluginUpdateStatusChangeIPCMessage(String paramString1, String paramString2, com.tencent.mm.plugin.appbrand.jsapi.ag.c paramc, String paramString3)
  {
    super(paramString1);
    AppMethodBeat.i(321065);
    this.appId = paramString1;
    this.eup = paramString2;
    this.sVY = paramc;
    this.sVZ = paramString3;
    AppMethodBeat.o(321065);
  }
  
  private static final void a(w paramw, AppBrandPluginUpdateStatusChangeIPCMessage paramAppBrandPluginUpdateStatusChangeIPCMessage)
  {
    AppMethodBeat.i(321069);
    s.u(paramw, "$runtime");
    s.u(paramAppBrandPluginUpdateStatusChangeIPCMessage, "this$0");
    b.a((y)paramw.ccO(), paramAppBrandPluginUpdateStatusChangeIPCMessage.sVY, paramAppBrandPluginUpdateStatusChangeIPCMessage.sVZ);
    AppMethodBeat.o(321069);
  }
  
  public static final boolean a(String paramString1, com.tencent.mm.plugin.appbrand.jsapi.ag.c paramc, String paramString2)
  {
    AppMethodBeat.i(321074);
    boolean bool = a.a(paramString1, paramc, paramString2);
    AppMethodBeat.o(321074);
    return bool;
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
    AppMethodBeat.i(321089);
    s.u(paramParcel, "out");
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.eup);
    bg localbg = bg.tcy;
    bg.a(this.sVY, paramParcel);
    paramParcel.writeString(this.sVZ);
    AppMethodBeat.o(321089);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPluginUpdateStatusChangeIPCMessage$Companion;", "", "()V", "TAG", "", "sendMessage", "", "instanceId", "state", "Lcom/tencent/mm/plugin/appbrand/jsapi/version/UpdateState;", "pluginAppId", "sendMessageImplByProcessesManager", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static boolean a(String paramString1, com.tencent.mm.plugin.appbrand.jsapi.ag.c paramc, String paramString2)
    {
      AppMethodBeat.i(321052);
      s.u(paramString1, "instanceId");
      s.u(paramc, "state");
      s.u(paramString2, "pluginAppId");
      if (!MMApplicationContext.isMainProcess())
      {
        paramString1 = (Throwable)new IllegalStateException("Must be invoked in mm process!".toString());
        AppMethodBeat.o(321052);
        throw paramString1;
      }
      for (;;)
      {
        try
        {
          Object localObject1 = com.tencent.mm.plugin.appbrand.task.i.tWq;
          com.tencent.mm.plugin.appbrand.task.i locali = i.a.cJV();
          Iterator localIterator = ((Iterable)locali.asj()).iterator();
          if (localIterator.hasNext())
          {
            localObject1 = localIterator.next();
            if (!s.p(paramString1, ((e)localObject1).eup)) {
              continue;
            }
            localObject1 = (e)localObject1;
            if (localObject1 == null) {
              break;
            }
            com.tencent.luggage.sdk.processes.c.a(locali.b((e)localObject1), (LuggageClientProcessMessage)new AppBrandPluginUpdateStatusChangeIPCMessage(((e)localObject1).appId, paramString1, paramc, paramString2));
            Log.i("MicroMsg.AppBrandPluginUpdateStatusChangeIPCMessage", "dispatch onPluginUpdateStatusChange(state:" + paramc + ", pluginAppId:" + paramString2 + "), instanceId:" + paramString1 + ", by ProcessesManager");
            AppMethodBeat.o(321052);
            return true;
          }
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.AppBrandPluginUpdateStatusChangeIPCMessage", "dispatch onPluginUpdateStatusChange(state:" + paramc + ", pluginAppId:" + paramString2 + "), instanceId:" + paramString1 + ", get exception:" + localException);
          AppMethodBeat.o(321052);
          return false;
        }
        Object localObject2 = null;
      }
      Log.e("MicroMsg.AppBrandPluginUpdateStatusChangeIPCMessage", "dispatch onPluginUpdateStatusChange(state:" + paramc + ", pluginAppId:" + paramString2 + "), instanceId:" + paramString1 + ", no app records found");
      AppMethodBeat.o(321052);
      return false;
    }
    
    public static boolean b(String paramString1, com.tencent.mm.plugin.appbrand.jsapi.ag.c paramc, String paramString2)
    {
      AppMethodBeat.i(321047);
      s.u(paramString1, "instanceId");
      s.u(paramc, "state");
      s.u(paramString2, "pluginAppId");
      if (!MMApplicationContext.isMainProcess())
      {
        paramString1 = (Throwable)new IllegalStateException("Must be invoked in mm process!".toString());
        AppMethodBeat.o(321047);
        throw paramString1;
      }
      Log.i("MicroMsg.AppBrandPluginUpdateStatusChangeIPCMessage", "dispatch onPluginUpdateStatusChange(state:" + paramc + ", pluginAppId:" + paramString2 + "), instanceId:" + paramString1 + ", invoke");
      k localk = k.acW(paramString1);
      if (localk != null)
      {
        if ((paramc == null) || (org.apache.commons.c.i.hm(paramString2))) {}
        for (;;)
        {
          Log.i("MicroMsg.AppBrandPluginUpdateStatusChangeIPCMessage", "dispatch onPluginUpdateStatusChange(state:" + paramc + ", pluginAppId:" + paramString2 + "), instanceId:" + paramString1 + ", stash in AppLaunchPrepareProcess");
          AppMethodBeat.o(321047);
          return true;
          synchronized (localk.sYe)
          {
            localk.sYe.addLast(new ar(paramc, paramString2));
          }
        }
      }
      boolean bool = a(paramString1, paramc, paramString2);
      AppMethodBeat.o(321047);
      return bool;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<AppBrandPluginUpdateStatusChangeIPCMessage>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPluginUpdateStatusChangeIPCMessage
 * JD-Core Version:    0.7.0.1
 */