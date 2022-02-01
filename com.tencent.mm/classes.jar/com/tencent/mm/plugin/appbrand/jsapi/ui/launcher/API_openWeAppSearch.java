package com.tencent.mm.plugin.appbrand.jsapi.ui.launcher;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.k;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "IPC_AppBrandSearchUIParamsPrepareRequest", "IPC_AppBrandSearchUIParamsPrepareResult", "IPC_AppBrandSearchUIParamsPrepareTask", "plugin-appbrand-integration_release"})
final class API_openWeAppSearch
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.d>
{
  public static final int CTRL_INDEX = 647;
  public static final String NAME = "openWeAppSearch";
  @Deprecated
  public static final a kmd;
  
  static
  {
    AppMethodBeat.i(50719);
    kmd = new a((byte)0);
    AppMethodBeat.o(50719);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "searchScene", "", "getSearchScene", "()I", "setSearchScene", "(I)V", "describeContents", "writeToParcel", "", "dest", "flags", "Companion", "plugin-appbrand-integration_release"})
  static final class IPC_AppBrandSearchUIParamsPrepareRequest
    implements Parcelable
  {
    public static final Parcelable.Creator<IPC_AppBrandSearchUIParamsPrepareRequest> CREATOR;
    public static final a kmf;
    int kme;
    
    static
    {
      AppMethodBeat.i(50705);
      kmf = new a((byte)0);
      CREATOR = (Parcelable.Creator)new b();
      AppMethodBeat.o(50705);
    }
    
    public IPC_AppBrandSearchUIParamsPrepareRequest() {}
    
    public IPC_AppBrandSearchUIParamsPrepareRequest(Parcel paramParcel)
    {
      this();
      AppMethodBeat.i(50704);
      this.kme = paramParcel.readInt();
      AppMethodBeat.o(50704);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(50703);
      k.h(paramParcel, "dest");
      paramParcel.writeInt(this.kme);
      AppMethodBeat.o(50703);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest;", "plugin-appbrand-integration_release"})
    public static final class a {}
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest;", "plugin-appbrand-integration_release"})
    public static final class b
      implements Parcelable.Creator<API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareRequest>
    {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "resultCode", "", "getResultCode", "()I", "setResultCode", "(I)V", "describeContents", "writeToParcel", "", "dest", "flags", "Companion", "plugin-appbrand-integration_release"})
  static final class IPC_AppBrandSearchUIParamsPrepareResult
    implements Parcelable
  {
    public static final Parcelable.Creator<IPC_AppBrandSearchUIParamsPrepareResult> CREATOR;
    public static final a kmg;
    int bRZ;
    Intent intent;
    
    static
    {
      AppMethodBeat.i(50709);
      kmg = new a((byte)0);
      CREATOR = (Parcelable.Creator)new b();
      AppMethodBeat.o(50709);
    }
    
    public IPC_AppBrandSearchUIParamsPrepareResult() {}
    
    public IPC_AppBrandSearchUIParamsPrepareResult(Parcel paramParcel)
    {
      this();
      AppMethodBeat.i(50708);
      this.bRZ = paramParcel.readInt();
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
      k.h(paramParcel, "dest");
      paramParcel.writeInt(this.bRZ);
      paramParcel.writeParcelable((Parcelable)this.intent, paramInt);
      AppMethodBeat.o(50707);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "RESULT_FATAL", "", "RESULT_OK", "RESULT_PRIVACY_DENIED", "plugin-appbrand-integration_release"})
    public static final class a {}
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "plugin-appbrand-integration_release"})
    public static final class b
      implements Parcelable.Creator<API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult>
    {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
  static final class b
    implements com.tencent.mm.ipcinvoker.b<API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareRequest, API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult>
  {
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"performCallback", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.b<API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult, y>
    {
      a(PBool paramPBool, com.tencent.mm.ipcinvoker.d paramd)
      {
        super();
      }
      
      public final void a(API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult paramIPC_AppBrandSearchUIParamsPrepareResult)
      {
        AppMethodBeat.i(50711);
        k.h(paramIPC_AppBrandSearchUIParamsPrepareResult, "result");
        if (this.kmh.value)
        {
          AppMethodBeat.o(50711);
          return;
        }
        this.iJO.bf(paramIPC_AppBrandSearchUIParamsPrepareResult);
        this.kmh.value = true;
        AppMethodBeat.o(50711);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(PBool paramPBool, API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareRequest paramIPC_AppBrandSearchUIParamsPrepareRequest, API_openWeAppSearch.b.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(50712);
        if (this.kmh.value)
        {
          AppMethodBeat.o(50712);
          return;
        }
        Object localObject = com.tencent.mm.plugin.appbrand.d.a.jaU;
        localObject = com.tencent.mm.plugin.appbrand.d.a.E(aj.getContext(), this.kmi.kme);
        API_openWeAppSearch.b.a locala = this.kmj;
        API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult localIPC_AppBrandSearchUIParamsPrepareResult = new API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult();
        ((Intent)localObject).setExtrasClassLoader(JsapiPermissionWrapper.class.getClassLoader());
        localIPC_AppBrandSearchUIParamsPrepareResult.bRZ = -1;
        localIPC_AppBrandSearchUIParamsPrepareResult.intent = ((Intent)localObject);
        locala.a(localIPC_AppBrandSearchUIParamsPrepareResult);
        AppMethodBeat.o(50712);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "<anonymous parameter 2>", "", "kotlin.jvm.PlatformType", "<anonymous parameter 3>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
    static final class c
      implements com.tencent.mm.al.g
    {
      c(PBool paramPBool, API_openWeAppSearch.b.a parama) {}
      
      public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
      {
        AppMethodBeat.i(50713);
        if (this.kmh.value)
        {
          AppMethodBeat.o(50713);
          return;
        }
        paramString = com.tencent.mm.kernel.g.ab(i.class);
        k.g(paramString, "MMKernel.service(IWebSearchPrivacyMgr::class.java)");
        if (!((i)paramString).ehz())
        {
          paramString = this.kmj;
          paramn = new API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult();
          paramn.bRZ = 1;
          paramString.a(paramn);
        }
        AppMethodBeat.o(50713);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class c<T>
    implements com.tencent.mm.ipcinvoker.d<API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult>
  {
    c(API_openWeAppSearch paramAPI_openWeAppSearch, com.tencent.mm.plugin.appbrand.d paramd, int paramInt) {}
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$invoke$1$1$2"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
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