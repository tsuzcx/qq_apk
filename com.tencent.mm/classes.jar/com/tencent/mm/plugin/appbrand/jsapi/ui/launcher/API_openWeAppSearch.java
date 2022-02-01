package com.tencent.mm.plugin.appbrand.jsapi.ui.launcher;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "IPC_AppBrandSearchUIParamsPrepareRequest", "IPC_AppBrandSearchUIParamsPrepareResult", "IPC_AppBrandSearchUIParamsPrepareTask", "plugin-appbrand-integration_release"})
final class API_openWeAppSearch
  extends com.tencent.mm.plugin.appbrand.jsapi.d<com.tencent.mm.plugin.appbrand.d>
{
  public static final int CTRL_INDEX = 647;
  public static final String NAME = "openWeAppSearch";
  @Deprecated
  public static final a mvd;
  
  static
  {
    AppMethodBeat.i(50719);
    mvd = new a((byte)0);
    AppMethodBeat.o(50719);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "searchScene", "", "getSearchScene", "()I", "setSearchScene", "(I)V", "describeContents", "writeToParcel", "", "dest", "flags", "Companion", "plugin-appbrand-integration_release"})
  static final class IPC_AppBrandSearchUIParamsPrepareRequest
    implements Parcelable
  {
    public static final Parcelable.Creator<IPC_AppBrandSearchUIParamsPrepareRequest> CREATOR;
    public static final a mvf;
    int mve;
    
    static
    {
      AppMethodBeat.i(50705);
      mvf = new a((byte)0);
      CREATOR = (Parcelable.Creator)new b();
      AppMethodBeat.o(50705);
    }
    
    public IPC_AppBrandSearchUIParamsPrepareRequest() {}
    
    public IPC_AppBrandSearchUIParamsPrepareRequest(Parcel paramParcel)
    {
      this();
      AppMethodBeat.i(50704);
      this.mve = paramParcel.readInt();
      AppMethodBeat.o(50704);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(50703);
      p.h(paramParcel, "dest");
      paramParcel.writeInt(this.mve);
      AppMethodBeat.o(50703);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest;", "plugin-appbrand-integration_release"})
    public static final class a {}
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest;", "plugin-appbrand-integration_release"})
    public static final class b
      implements Parcelable.Creator<API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareRequest>
    {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "resultCode", "", "getResultCode", "()I", "setResultCode", "(I)V", "describeContents", "writeToParcel", "", "dest", "flags", "Companion", "plugin-appbrand-integration_release"})
  static final class IPC_AppBrandSearchUIParamsPrepareResult
    implements Parcelable
  {
    public static final Parcelable.Creator<IPC_AppBrandSearchUIParamsPrepareResult> CREATOR;
    public static final a mvg;
    Intent intent;
    int resultCode;
    
    static
    {
      AppMethodBeat.i(50709);
      mvg = new a((byte)0);
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
      p.h(paramParcel, "dest");
      paramParcel.writeInt(this.resultCode);
      paramParcel.writeParcelable((Parcelable)this.intent, paramInt);
      AppMethodBeat.o(50707);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "RESULT_FATAL", "", "RESULT_OK", "RESULT_PRIVACY_DENIED", "plugin-appbrand-integration_release"})
    public static final class a {}
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "plugin-appbrand-integration_release"})
    public static final class b
      implements Parcelable.Creator<API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult>
    {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
  static final class b
    implements com.tencent.mm.ipcinvoker.b<API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareRequest, API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult>
  {
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"performCallback", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.b<API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult, x>
    {
      a(PBool paramPBool, com.tencent.mm.ipcinvoker.d paramd)
      {
        super();
      }
      
      public final void a(API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult paramIPC_AppBrandSearchUIParamsPrepareResult)
      {
        AppMethodBeat.i(50711);
        p.h(paramIPC_AppBrandSearchUIParamsPrepareResult, "result");
        if (this.mvh.value)
        {
          AppMethodBeat.o(50711);
          return;
        }
        this.kFf.bn(paramIPC_AppBrandSearchUIParamsPrepareResult);
        this.mvh.value = true;
        AppMethodBeat.o(50711);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(PBool paramPBool, API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareRequest paramIPC_AppBrandSearchUIParamsPrepareRequest, API_openWeAppSearch.b.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(50712);
        if (this.mvh.value)
        {
          AppMethodBeat.o(50712);
          return;
        }
        Object localObject = com.tencent.mm.plugin.appbrand.c.a.lbr;
        localObject = com.tencent.mm.plugin.appbrand.c.a.M(MMApplicationContext.getContext(), this.mvi.mve);
        API_openWeAppSearch.b.a locala = this.mvj;
        API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult localIPC_AppBrandSearchUIParamsPrepareResult = new API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult();
        ((Intent)localObject).setExtrasClassLoader(JsapiPermissionWrapper.class.getClassLoader());
        localIPC_AppBrandSearchUIParamsPrepareResult.resultCode = -1;
        localIPC_AppBrandSearchUIParamsPrepareResult.intent = ((Intent)localObject);
        locala.a(localIPC_AppBrandSearchUIParamsPrepareResult);
        AppMethodBeat.o(50712);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "<anonymous parameter 2>", "", "kotlin.jvm.PlatformType", "<anonymous parameter 3>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
    static final class c
      implements com.tencent.mm.ak.i
    {
      c(PBool paramPBool, API_openWeAppSearch.b.a parama) {}
      
      public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
      {
        AppMethodBeat.i(50713);
        if (this.mvh.value)
        {
          AppMethodBeat.o(50713);
          return;
        }
        paramString = g.af(com.tencent.mm.plugin.websearch.api.i.class);
        p.g(paramString, "MMKernel.service(IWebSearchPrivacyMgr::class.java)");
        if (!((com.tencent.mm.plugin.websearch.api.i)paramString).fXw())
        {
          paramString = this.mvj;
          paramq = new API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult();
          paramq.resultCode = 1;
          paramString.a(paramq);
        }
        AppMethodBeat.o(50713);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class c<T>
    implements com.tencent.mm.ipcinvoker.d<API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult>
  {
    c(API_openWeAppSearch paramAPI_openWeAppSearch, com.tencent.mm.plugin.appbrand.d paramd, int paramInt) {}
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$invoke$1$1$2"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(API_openWeAppSearch.c paramc, API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult paramIPC_AppBrandSearchUIParamsPrepareResult)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ui.launcher.API_openWeAppSearch
 * JD-Core Version:    0.7.0.1
 */