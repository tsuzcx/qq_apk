package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOpenTextStateMessage;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "service", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "OpenTextStateRequest", "OpenTextStateResult", "OpenTextStateTask", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class JsApiOpenTextStateMessage
  extends c<f>
{
  private static final int CTRL_INDEX;
  private static final String NAME;
  public static final a rzP;
  
  static
  {
    AppMethodBeat.i(325482);
    rzP = new a((byte)0);
    NAME = "openTextStateMessage";
    CTRL_INDEX = 1028;
    AppMethodBeat.o(325482);
  }
  
  private static final void a(f paramf, int paramInt, JsApiOpenTextStateMessage paramJsApiOpenTextStateMessage, OpenTextStateResult paramOpenTextStateResult)
  {
    AppMethodBeat.i(325480);
    s.u(paramJsApiOpenTextStateMessage, "this$0");
    Log.i("MicroMsg.TextStatus.JsApiOpenTextStateMessage", s.X("onReceiveResult result:", paramOpenTextStateResult.rzR));
    try
    {
      paramOpenTextStateResult = new JSONObject(paramOpenTextStateResult.rzR);
      paramf.callback(paramInt, paramJsApiOpenTextStateMessage.h("ok", paramOpenTextStateResult));
      AppMethodBeat.o(325480);
      return;
    }
    finally
    {
      for (;;)
      {
        paramOpenTextStateResult = null;
      }
    }
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(325491);
    s.u(paramJSONObject, "data");
    Log.i("MicroMsg.TextStatus.JsApiOpenTextStateMessage", s.X("invoke JsApiOpenTextStateMessage! ", paramJSONObject));
    if (paramf == null) {}
    for (Object localObject1 = null; localObject1 == null; localObject1 = paramf.getContext())
    {
      AppMethodBeat.o(325491);
      return;
    }
    localObject1 = new OpenTextStateRequest();
    paramJSONObject = paramJSONObject.optJSONObject("data");
    if (paramJSONObject == null) {}
    for (paramJSONObject = localObject2;; paramJSONObject = paramJSONObject.toString())
    {
      ((OpenTextStateRequest)localObject1).rzQ = paramJSONObject;
      paramJSONObject = new JsApiOpenTextStateMessage..ExternalSyntheticLambda0(paramf, paramInt, this);
      a.a(paramf.getContext(), (AppBrandProxyUIProcessTask.ProcessRequest)localObject1, paramJSONObject);
      AppMethodBeat.o(325491);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOpenTextStateMessage$OpenTextStateRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "reqData", "", "getReqData$plugin_appbrand_integration_release", "()Ljava/lang/String;", "setReqData$plugin_appbrand_integration_release", "(Ljava/lang/String;)V", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "readParcel", "", "writeToParcel", "dest", "flags", "", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class OpenTextStateRequest
    extends AppBrandProxyUIProcessTask.ProcessRequest
  {
    public static final a CREATOR;
    String rzQ;
    
    static
    {
      AppMethodBeat.i(325901);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(325901);
    }
    
    public OpenTextStateRequest() {}
    
    public OpenTextStateRequest(Parcel paramParcel)
    {
      AppMethodBeat.i(325899);
      readParcel(paramParcel);
      AppMethodBeat.o(325899);
    }
    
    public final Class<? extends AppBrandProxyUIProcessTask> getTaskClass()
    {
      return JsApiOpenTextStateMessage.b.class;
    }
    
    public final void readParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(325904);
      s.u(paramParcel, "parcel");
      this.rzQ = paramParcel.readString();
      AppMethodBeat.o(325904);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(325905);
      s.u(paramParcel, "dest");
      paramParcel.writeString(this.rzQ);
      AppMethodBeat.o(325905);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOpenTextStateMessage$OpenTextStateRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOpenTextStateMessage$OpenTextStateRequest;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOpenTextStateMessage$OpenTextStateRequest;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Parcelable.Creator<JsApiOpenTextStateMessage.OpenTextStateRequest>
    {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOpenTextStateMessage$OpenTextStateResult;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessResult;", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "resultData", "", "getResultData$plugin_appbrand_integration_release", "()Ljava/lang/String;", "setResultData$plugin_appbrand_integration_release", "(Ljava/lang/String;)V", "describeContents", "", "readParcel", "", "writeToParcel", "dest", "flags", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class OpenTextStateResult
    extends AppBrandProxyUIProcessTask.ProcessResult
  {
    public static final a CREATOR;
    String rzR;
    
    static
    {
      AppMethodBeat.i(325674);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(325674);
    }
    
    public OpenTextStateResult() {}
    
    public OpenTextStateResult(Parcel paramParcel)
    {
      AppMethodBeat.i(325670);
      readParcel(paramParcel);
      AppMethodBeat.o(325670);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void readParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(325676);
      s.u(paramParcel, "parcel");
      this.rzR = paramParcel.readString();
      AppMethodBeat.o(325676);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(325680);
      s.u(paramParcel, "dest");
      paramParcel.writeString(this.rzR);
      AppMethodBeat.o(325680);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOpenTextStateMessage$OpenTextStateResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOpenTextStateMessage$OpenTextStateResult;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOpenTextStateMessage$OpenTextStateResult;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Parcelable.Creator<JsApiOpenTextStateMessage.OpenTextStateResult>
    {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOpenTextStateMessage$Companion;", "", "()V", "ACTION_OPEN_CHAT", "", "ACTION_REPLY_GREETING", "CTRL_INDEX", "", "getCTRL_INDEX$annotations", "getCTRL_INDEX", "()I", "NAME", "getNAME$annotations", "getNAME", "()Ljava/lang/String;", "TAG", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOpenTextStateMessage$OpenTextStateTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends AppBrandProxyUIProcessTask
  {
    public static final a rzS;
    
    static
    {
      AppMethodBeat.i(325623);
      rzS = new a((byte)0);
      AppMethodBeat.o(325623);
    }
    
    public final void handleRequest(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
    {
      AppMethodBeat.i(325626);
      s.u(paramProcessRequest, "request");
      JsApiOpenTextStateMessage.OpenTextStateResult localOpenTextStateResult = new JsApiOpenTextStateMessage.OpenTextStateResult();
      if (!(paramProcessRequest instanceof JsApiOpenTextStateMessage.OpenTextStateRequest))
      {
        Log.w("CheckStrangerTask", "handleRequest, request not instance of ProfileRequest");
        finishProcess((AppBrandProxyUIProcessTask.ProcessResult)localOpenTextStateResult);
        AppMethodBeat.o(325626);
        return;
      }
      h.baC();
      if (!b.aZM())
      {
        Log.e("CheckStrangerTask", "handleRequest, MMKernel.account().hasLogin() is false");
        finishProcess((AppBrandProxyUIProcessTask.ProcessResult)localOpenTextStateResult);
        AppMethodBeat.o(325626);
        return;
      }
      Object localObject = ((JsApiOpenTextStateMessage.OpenTextStateRequest)paramProcessRequest).rzQ;
      paramProcessRequest = (AppBrandProxyUIProcessTask.ProcessRequest)localObject;
      if (localObject == null) {
        paramProcessRequest = "";
      }
      try
      {
        localObject = new JSONObject(paramProcessRequest);
        if (localObject == null)
        {
          paramProcessRequest = null;
          if (localObject != null) {
            break label184;
          }
          localObject = null;
          if (s.p(localObject, "openChat"))
          {
            localObject = getActivityContext();
            if (localObject != null) {
              break label194;
            }
            localObject = MMApplicationContext.getContext();
            ((com.tencent.mm.plugin.textstatus.a.f)h.az(com.tencent.mm.plugin.textstatus.a.f.class)).openTextStateChatting((Context)localObject, paramProcessRequest);
            finishProcess((AppBrandProxyUIProcessTask.ProcessResult)localOpenTextStateResult);
          }
          AppMethodBeat.o(325626);
        }
      }
      finally
      {
        for (;;)
        {
          localObject = null;
          continue;
          paramProcessRequest = ((JSONObject)localObject).optJSONObject("param");
          continue;
          label184:
          localObject = ((JSONObject)localObject).optString("action");
          continue;
          label194:
          localObject = (Context)localObject;
        }
      }
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOpenTextStateMessage$OpenTextStateTask$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenTextStateMessage
 * JD-Core Version:    0.7.0.1
 */