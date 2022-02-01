package com.tencent.mm.plugin.appbrand.jsapi.ui.launcher;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "IPC_AppBrandSearchUIParamsPrepareRequest", "IPC_AppBrandSearchUIParamsPrepareResult", "IPC_AppBrandSearchUIParamsPrepareTask", "plugin-appbrand-integration_release"})
final class API_openWeAppSearch
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.d>
{
  public static final int CTRL_INDEX = 647;
  public static final String NAME = "openWeAppSearch";
  @Deprecated
  public static final a low;
  
  static
  {
    AppMethodBeat.i(50719);
    low = new a((byte)0);
    AppMethodBeat.o(50719);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "searchScene", "", "getSearchScene", "()I", "setSearchScene", "(I)V", "describeContents", "writeToParcel", "", "dest", "flags", "Companion", "plugin-appbrand-integration_release"})
  static final class IPC_AppBrandSearchUIParamsPrepareRequest
    implements Parcelable
  {
    public static final Parcelable.Creator<IPC_AppBrandSearchUIParamsPrepareRequest> CREATOR;
    public static final a loy;
    int lox;
    
    static
    {
      AppMethodBeat.i(50705);
      loy = new a((byte)0);
      CREATOR = (Parcelable.Creator)new b();
      AppMethodBeat.o(50705);
    }
    
    public IPC_AppBrandSearchUIParamsPrepareRequest() {}
    
    public IPC_AppBrandSearchUIParamsPrepareRequest(Parcel paramParcel)
    {
      this();
      AppMethodBeat.i(50704);
      this.lox = paramParcel.readInt();
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
      paramParcel.writeInt(this.lox);
      AppMethodBeat.o(50703);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest;", "plugin-appbrand-integration_release"})
    public static final class a {}
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest;", "plugin-appbrand-integration_release"})
    public static final class b
      implements Parcelable.Creator<API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareRequest>
    {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "resultCode", "", "getResultCode", "()I", "setResultCode", "(I)V", "describeContents", "writeToParcel", "", "dest", "flags", "Companion", "plugin-appbrand-integration_release"})
  static final class IPC_AppBrandSearchUIParamsPrepareResult
    implements Parcelable
  {
    public static final Parcelable.Creator<IPC_AppBrandSearchUIParamsPrepareResult> CREATOR;
    public static final a loz;
    int bZU;
    Intent intent;
    
    static
    {
      AppMethodBeat.i(50709);
      loz = new a((byte)0);
      CREATOR = (Parcelable.Creator)new b();
      AppMethodBeat.o(50709);
    }
    
    public IPC_AppBrandSearchUIParamsPrepareResult() {}
    
    public IPC_AppBrandSearchUIParamsPrepareResult(Parcel paramParcel)
    {
      this();
      AppMethodBeat.i(50708);
      this.bZU = paramParcel.readInt();
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
      paramParcel.writeInt(this.bZU);
      paramParcel.writeParcelable((Parcelable)this.intent, paramInt);
      AppMethodBeat.o(50707);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "RESULT_FATAL", "", "RESULT_OK", "RESULT_PRIVACY_DENIED", "plugin-appbrand-integration_release"})
    public static final class a {}
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "plugin-appbrand-integration_release"})
    public static final class b
      implements Parcelable.Creator<API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult>
    {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
  static final class b
    implements com.tencent.mm.ipcinvoker.b<API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareRequest, API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult>
  {
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"performCallback", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "invoke"})
    static final class a
      extends q
      implements d.g.a.b<API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult, z>
    {
      a(PBool paramPBool, com.tencent.mm.ipcinvoker.d paramd)
      {
        super();
      }
      
      public final void a(API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult paramIPC_AppBrandSearchUIParamsPrepareResult)
      {
        AppMethodBeat.i(50711);
        p.h(paramIPC_AppBrandSearchUIParamsPrepareResult, "result");
        if (this.loA.value)
        {
          AppMethodBeat.o(50711);
          return;
        }
        this.jGI.be(paramIPC_AppBrandSearchUIParamsPrepareResult);
        this.loA.value = true;
        AppMethodBeat.o(50711);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(PBool paramPBool, API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareRequest paramIPC_AppBrandSearchUIParamsPrepareRequest, API_openWeAppSearch.b.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(50712);
        if (this.loA.value)
        {
          AppMethodBeat.o(50712);
          return;
        }
        Object localObject = com.tencent.mm.plugin.appbrand.c.a.jYt;
        localObject = com.tencent.mm.plugin.appbrand.c.a.I(ak.getContext(), this.loB.lox);
        API_openWeAppSearch.b.a locala = this.loC;
        API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult localIPC_AppBrandSearchUIParamsPrepareResult = new API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult();
        ((Intent)localObject).setExtrasClassLoader(JsapiPermissionWrapper.class.getClassLoader());
        localIPC_AppBrandSearchUIParamsPrepareResult.bZU = -1;
        localIPC_AppBrandSearchUIParamsPrepareResult.intent = ((Intent)localObject);
        locala.a(localIPC_AppBrandSearchUIParamsPrepareResult);
        AppMethodBeat.o(50712);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "<anonymous parameter 2>", "", "kotlin.jvm.PlatformType", "<anonymous parameter 3>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
    static final class c
      implements f
    {
      c(PBool paramPBool, API_openWeAppSearch.b.a parama) {}
      
      public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
      {
        AppMethodBeat.i(50713);
        if (this.loA.value)
        {
          AppMethodBeat.o(50713);
          return;
        }
        paramString = g.ab(i.class);
        p.g(paramString, "MMKernel.service(IWebSearchPrivacyMgr::class.java)");
        if (!((i)paramString).ePq())
        {
          paramString = this.loC;
          paramn = new API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult();
          paramn.bZU = 1;
          paramString.a(paramn);
        }
        AppMethodBeat.o(50713);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class c<T>
    implements com.tencent.mm.ipcinvoker.d<API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult>
  {
    c(API_openWeAppSearch paramAPI_openWeAppSearch, com.tencent.mm.plugin.appbrand.d paramd, int paramInt) {}
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$invoke$1$1$2"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(API_openWeAppSearch.c paramc, API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult paramIPC_AppBrandSearchUIParamsPrepareResult)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ui.launcher.API_openWeAppSearch
 * JD-Core Version:    0.7.0.1
 */