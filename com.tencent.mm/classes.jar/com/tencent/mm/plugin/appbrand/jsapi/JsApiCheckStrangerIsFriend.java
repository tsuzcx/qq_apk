package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiCheckStrangerIsFriend;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "service", "data", "Lorg/json/JSONObject;", "callbackId", "", "CheckStrangerRequest", "CheckStrangerResult", "CheckStrangerTask", "Companion", "plugin-appbrand-integration_release"})
public final class JsApiCheckStrangerIsFriend
  extends c<e>
{
  private static final int CTRL_INDEX = 983;
  private static final String NAME = "checkStrangerContactListIsFriend";
  public static final JsApiCheckStrangerIsFriend.b oun;
  
  static
  {
    AppMethodBeat.i(281820);
    oun = new JsApiCheckStrangerIsFriend.b((byte)0);
    NAME = "checkStrangerContactListIsFriend";
    CTRL_INDEX = 983;
    AppMethodBeat.o(281820);
  }
  
  public final void a(final e parame, JSONObject paramJSONObject, final int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(281819);
    p.k(paramJSONObject, "data");
    Log.i("MicroMsg.JsApiCheckStrangerIsFriend", "invoke JsApiCheckStrangerIsFriend! ".concat(String.valueOf(paramJSONObject)));
    if (parame != null) {}
    for (Object localObject1 = parame.getContext(); localObject1 == null; localObject1 = null)
    {
      AppMethodBeat.o(281819);
      return;
    }
    localObject1 = new CheckStrangerRequest();
    JSONObject localJSONObject = paramJSONObject.optJSONObject("data");
    paramJSONObject = localObject2;
    if (localJSONObject != null) {
      paramJSONObject = localJSONObject.toString();
    }
    ((CheckStrangerRequest)localObject1).ouo = paramJSONObject;
    paramJSONObject = (AppBrandProxyUIProcessTask.b)new c(this, parame, paramInt);
    com.tencent.mm.plugin.appbrand.ipc.a.a(parame.getContext(), (AppBrandProxyUIProcessTask.ProcessRequest)localObject1, paramJSONObject);
    AppMethodBeat.o(281819);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiCheckStrangerIsFriend$CheckStrangerRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "reqData", "", "getReqData$plugin_appbrand_integration_release", "()Ljava/lang/String;", "setReqData$plugin_appbrand_integration_release", "(Ljava/lang/String;)V", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "readParcel", "", "writeToParcel", "dest", "flags", "", "CREATOR", "plugin-appbrand-integration_release"})
  public static final class CheckStrangerRequest
    extends AppBrandProxyUIProcessTask.ProcessRequest
  {
    public static final a CREATOR;
    String ouo;
    
    static
    {
      AppMethodBeat.i(267643);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(267643);
    }
    
    public CheckStrangerRequest() {}
    
    public CheckStrangerRequest(Parcel paramParcel)
    {
      AppMethodBeat.i(267642);
      k(paramParcel);
      AppMethodBeat.o(267642);
    }
    
    public final Class<? extends AppBrandProxyUIProcessTask> bOe()
    {
      return JsApiCheckStrangerIsFriend.a.class;
    }
    
    public final void k(Parcel paramParcel)
    {
      AppMethodBeat.i(267640);
      p.k(paramParcel, "parcel");
      this.ouo = paramParcel.readString();
      AppMethodBeat.o(267640);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(267641);
      p.k(paramParcel, "dest");
      paramParcel.writeString(this.ouo);
      AppMethodBeat.o(267641);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiCheckStrangerIsFriend$CheckStrangerRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiCheckStrangerIsFriend$CheckStrangerRequest;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiCheckStrangerIsFriend$CheckStrangerRequest;", "plugin-appbrand-integration_release"})
    public static final class a
      implements Parcelable.Creator<JsApiCheckStrangerIsFriend.CheckStrangerRequest>
    {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiCheckStrangerIsFriend$CheckStrangerResult;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessResult;", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "resultData", "", "getResultData$plugin_appbrand_integration_release", "()Ljava/lang/String;", "setResultData$plugin_appbrand_integration_release", "(Ljava/lang/String;)V", "describeContents", "", "readParcel", "", "writeToParcel", "dest", "flags", "CREATOR", "plugin-appbrand-integration_release"})
  public static final class CheckStrangerResult
    extends AppBrandProxyUIProcessTask.ProcessResult
  {
    public static final a CREATOR;
    String oup;
    
    static
    {
      AppMethodBeat.i(278876);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(278876);
    }
    
    public CheckStrangerResult() {}
    
    public CheckStrangerResult(Parcel paramParcel)
    {
      AppMethodBeat.i(278875);
      k(paramParcel);
      AppMethodBeat.o(278875);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void k(Parcel paramParcel)
    {
      AppMethodBeat.i(278872);
      p.k(paramParcel, "parcel");
      this.oup = paramParcel.readString();
      AppMethodBeat.o(278872);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(278873);
      p.k(paramParcel, "dest");
      paramParcel.writeString(this.oup);
      AppMethodBeat.o(278873);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiCheckStrangerIsFriend$CheckStrangerResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiCheckStrangerIsFriend$CheckStrangerResult;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiCheckStrangerIsFriend$CheckStrangerResult;", "plugin-appbrand-integration_release"})
    public static final class a
      implements Parcelable.Creator<JsApiCheckStrangerIsFriend.CheckStrangerResult>
    {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiCheckStrangerIsFriend$CheckStrangerTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "Companion", "plugin-appbrand-integration_release"})
  public static final class a
    extends AppBrandProxyUIProcessTask
  {
    public static final JsApiCheckStrangerIsFriend.a.a ouq;
    
    static
    {
      AppMethodBeat.i(270407);
      ouq = new JsApiCheckStrangerIsFriend.a.a((byte)0);
      AppMethodBeat.o(270407);
    }
    
    public final void a(final AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
    {
      AppMethodBeat.i(270406);
      p.k(paramProcessRequest, "request");
      final JsApiCheckStrangerIsFriend.CheckStrangerResult localCheckStrangerResult = new JsApiCheckStrangerIsFriend.CheckStrangerResult();
      if (!(paramProcessRequest instanceof JsApiCheckStrangerIsFriend.CheckStrangerRequest))
      {
        Log.w("CheckStrangerTask", "handleRequest, request not instance of ProfileRequest");
        b((AppBrandProxyUIProcessTask.ProcessResult)localCheckStrangerResult);
        AppMethodBeat.o(270406);
        return;
      }
      h.aHE();
      if (!b.aGL())
      {
        Log.e("CheckStrangerTask", "handleRequest, MMKernel.account().hasLogin() is false");
        b((AppBrandProxyUIProcessTask.ProcessResult)localCheckStrangerResult);
        AppMethodBeat.o(270406);
        return;
      }
      paramProcessRequest = ((JsApiCheckStrangerIsFriend.CheckStrangerRequest)paramProcessRequest).ouo;
      try
      {
        paramProcessRequest = new JSONObject(paramProcessRequest);
        d.b("CheckStrangerTask", (kotlin.g.a.a)new b(this, paramProcessRequest, localCheckStrangerResult));
        AppMethodBeat.o(270406);
        return;
      }
      catch (Throwable paramProcessRequest)
      {
        for (;;)
        {
          paramProcessRequest = null;
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<x>
    {
      b(JsApiCheckStrangerIsFriend.a parama, JSONObject paramJSONObject, JsApiCheckStrangerIsFriend.CheckStrangerResult paramCheckStrangerResult)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiCheckStrangerIsFriend$CheckStrangerResult;", "kotlin.jvm.PlatformType", "onReceiveResult"})
  static final class c<R extends AppBrandProxyUIProcessTask.ProcessResult>
    implements AppBrandProxyUIProcessTask.b<JsApiCheckStrangerIsFriend.CheckStrangerResult>
  {
    c(JsApiCheckStrangerIsFriend paramJsApiCheckStrangerIsFriend, e parame, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiCheckStrangerIsFriend
 * JD-Core Version:    0.7.0.1
 */