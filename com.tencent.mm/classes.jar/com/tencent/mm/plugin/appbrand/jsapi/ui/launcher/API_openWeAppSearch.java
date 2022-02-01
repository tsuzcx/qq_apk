package com.tencent.mm.plugin.appbrand.jsapi.ui.launcher;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "IPC_AppBrandSearchUIParamsPrepareRequest", "IPC_AppBrandSearchUIParamsPrepareResult", "IPC_AppBrandSearchUIParamsPrepareTask", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class API_openWeAppSearch
  extends c<g>
{
  @Deprecated
  public static final int CTRL_INDEX = 647;
  @Deprecated
  public static final String NAME = "openWeAppSearch";
  private static final a syM;
  
  static
  {
    AppMethodBeat.i(50719);
    syM = new a((byte)0);
    AppMethodBeat.o(50719);
  }
  
  private static final void a(g paramg, int paramInt, API_openWeAppSearch paramAPI_openWeAppSearch, IPC_AppBrandSearchUIParamsPrepareResult paramIPC_AppBrandSearchUIParamsPrepareResult)
  {
    Object localObject = null;
    AppMethodBeat.i(326115);
    s.u(paramAPI_openWeAppSearch, "this$0");
    switch (paramIPC_AppBrandSearchUIParamsPrepareResult.resultCode)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(326115);
      return;
      Activity localActivity = AndroidContextUtil.castActivityOrNull(paramg.getContext());
      if (localActivity == null)
      {
        paramIPC_AppBrandSearchUIParamsPrepareResult = null;
        if (paramIPC_AppBrandSearchUIParamsPrepareResult == null)
        {
          s.u(paramAPI_openWeAppSearch, "this$0");
          paramg.callback(paramInt, paramAPI_openWeAppSearch.ZP("fail:internal error invalid android context"));
          AppMethodBeat.o(326115);
        }
      }
      else
      {
        paramIPC_AppBrandSearchUIParamsPrepareResult = paramIPC_AppBrandSearchUIParamsPrepareResult.intent;
        if (paramIPC_AppBrandSearchUIParamsPrepareResult == null) {}
        for (paramIPC_AppBrandSearchUIParamsPrepareResult = localObject;; paramIPC_AppBrandSearchUIParamsPrepareResult = ah.aiuX)
        {
          if (paramIPC_AppBrandSearchUIParamsPrepareResult == null)
          {
            s.u(paramAPI_openWeAppSearch, "this$0");
            paramg.callback(paramInt, paramAPI_openWeAppSearch.ZP("fail:internal error"));
          }
          paramIPC_AppBrandSearchUIParamsPrepareResult = ah.aiuX;
          break;
          paramIPC_AppBrandSearchUIParamsPrepareResult.setExtrasClassLoader(JsapiPermissionWrapper.class.getClassLoader());
          paramIPC_AppBrandSearchUIParamsPrepareResult = new com.tencent.mm.hellhoundlib.b.a().cG(paramIPC_AppBrandSearchUIParamsPrepareResult);
          com.tencent.mm.hellhoundlib.a.a.b(localActivity, paramIPC_AppBrandSearchUIParamsPrepareResult.aYi(), "com/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch", "invoke$lambda-5", "(Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;ILcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch;Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localActivity.startActivity((Intent)paramIPC_AppBrandSearchUIParamsPrepareResult.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localActivity, "com/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch", "invoke$lambda-5", "(Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;ILcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch;Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramg.callback(paramInt, paramAPI_openWeAppSearch.ZP("ok"));
        }
      }
      AppMethodBeat.o(326115);
      return;
      paramg.callback(paramInt, paramAPI_openWeAppSearch.ZP("fail:internal error"));
      AppMethodBeat.o(326115);
      return;
      paramg.callback(paramInt, paramAPI_openWeAppSearch.ZP("fail:auth denied"));
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "searchScene", "", "getSearchScene", "()I", "setSearchScene", "(I)V", "describeContents", "writeToParcel", "", "dest", "flags", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class IPC_AppBrandSearchUIParamsPrepareRequest
    implements Parcelable
  {
    public static final Parcelable.Creator<IPC_AppBrandSearchUIParamsPrepareRequest> CREATOR;
    public static final a syN;
    int syO;
    
    static
    {
      AppMethodBeat.i(50705);
      syN = new a((byte)0);
      CREATOR = (Parcelable.Creator)new b();
      AppMethodBeat.o(50705);
    }
    
    public IPC_AppBrandSearchUIParamsPrepareRequest() {}
    
    public IPC_AppBrandSearchUIParamsPrepareRequest(Parcel paramParcel)
    {
      this();
      AppMethodBeat.i(50704);
      this.syO = paramParcel.readInt();
      AppMethodBeat.o(50704);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(50703);
      s.u(paramParcel, "dest");
      paramParcel.writeInt(this.syO);
      AppMethodBeat.o(50703);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a {}
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements Parcelable.Creator<API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareRequest>
    {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "resultCode", "", "getResultCode", "()I", "setResultCode", "(I)V", "describeContents", "writeToParcel", "", "dest", "flags", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class IPC_AppBrandSearchUIParamsPrepareResult
    implements Parcelable
  {
    public static final Parcelable.Creator<IPC_AppBrandSearchUIParamsPrepareResult> CREATOR;
    public static final a syP;
    Intent intent;
    int resultCode;
    
    static
    {
      AppMethodBeat.i(50709);
      syP = new a((byte)0);
      CREATOR = (Parcelable.Creator)new b();
      AppMethodBeat.o(50709);
    }
    
    public IPC_AppBrandSearchUIParamsPrepareResult() {}
    
    public IPC_AppBrandSearchUIParamsPrepareResult(Parcel paramParcel)
    {
      this();
      AppMethodBeat.i(50708);
      this.resultCode = paramParcel.readInt();
      this.intent = ((Intent)paramParcel.readParcelable(Intent.class.getClassLoader()));
      AppMethodBeat.o(50708);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(50707);
      s.u(paramParcel, "dest");
      paramParcel.writeInt(this.resultCode);
      paramParcel.writeParcelable((Parcelable)this.intent, paramInt);
      AppMethodBeat.o(50707);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "RESULT_FATAL", "", "RESULT_OK", "RESULT_PRIVACY_DENIED", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a {}
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements Parcelable.Creator<API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult>
    {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
    implements d<API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareRequest, API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult>
  {
    private static final void a(PBool paramPBool, f paramf, int paramInt1, int paramInt2, String paramString, p paramp)
    {
      AppMethodBeat.i(326121);
      s.u(paramPBool, "$pHasCallback");
      if (paramPBool.value)
      {
        AppMethodBeat.o(326121);
        return;
      }
      if (!((i)h.ax(i.class)).ipA())
      {
        paramString = new API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult();
        paramString.resultCode = 1;
        paramp = ah.aiuX;
        a(paramPBool, paramf, paramString);
      }
      AppMethodBeat.o(326121);
    }
    
    private static final void a(PBool paramPBool, f<API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult> paramf, API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult paramIPC_AppBrandSearchUIParamsPrepareResult)
    {
      AppMethodBeat.i(326116);
      if (paramPBool.value)
      {
        AppMethodBeat.o(326116);
        return;
      }
      paramf.onCallback(paramIPC_AppBrandSearchUIParamsPrepareResult);
      paramPBool.value = true;
      AppMethodBeat.o(326116);
    }
    
    private static final void a(PBool paramPBool, API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareRequest paramIPC_AppBrandSearchUIParamsPrepareRequest, f paramf)
    {
      AppMethodBeat.i(326119);
      s.u(paramPBool, "$pHasCallback");
      if (paramPBool.value)
      {
        AppMethodBeat.o(326119);
        return;
      }
      Object localObject = com.tencent.mm.plugin.appbrand.d.a.qVk;
      localObject = com.tencent.mm.plugin.appbrand.d.a.U(MMApplicationContext.getContext(), paramIPC_AppBrandSearchUIParamsPrepareRequest.syO);
      paramIPC_AppBrandSearchUIParamsPrepareRequest = new API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult();
      ((Intent)localObject).setExtrasClassLoader(JsapiPermissionWrapper.class.getClassLoader());
      paramIPC_AppBrandSearchUIParamsPrepareRequest.resultCode = -1;
      paramIPC_AppBrandSearchUIParamsPrepareRequest.intent = ((Intent)localObject);
      localObject = ah.aiuX;
      a(paramPBool, paramf, paramIPC_AppBrandSearchUIParamsPrepareRequest);
      AppMethodBeat.o(326119);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ui.launcher.API_openWeAppSearch
 * JD-Core Version:    0.7.0.1
 */