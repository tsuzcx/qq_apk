package com.tencent.mm.plugin.appbrand.jsapi.pay;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.tencent.luggage.h.f.b;
import com.tencent.luggage.h.f.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils;", "", "()V", "TAG", "", "gProxyFunctionsMap", "Landroid/util/SparseArray;", "Lkotlin/Function1;", "Lcom/tencent/mm/ui/MMActivity;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/pay/ProxyForMMActivityResultCallback;", "customAppIdInWhitleList", "", "service", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "customAppId", "libSupportUseCustomAppId", "waitForMMActivityResult", "context", "Landroid/app/Activity;", "function", "activityResultCallback", "Lcom/tencent/luggage/util/LuggageActivityHelper$ActivityResultCallback;", "removeReturns", "T", "key", "", "(Landroid/util/SparseArray;I)Ljava/lang/Object;", "ProxyMMActivityResultRequest", "ProxyMMActivityResultResult", "ProxyMMActivityResultTask", "plugin-appbrand-integration_release"})
public final class AppBrandJsApiPayUtils
{
  private static final SparseArray<b<MMActivity, x>> mlY;
  public static final AppBrandJsApiPayUtils mlZ;
  
  static
  {
    AppMethodBeat.i(175184);
    mlZ = new AppBrandJsApiPayUtils();
    mlY = new SparseArray();
    AppMethodBeat.o(175184);
  }
  
  public static final boolean a(Activity paramActivity, b<? super MMActivity, x> paramb)
  {
    AppMethodBeat.i(175183);
    boolean bool = a(paramActivity, paramb, null);
    AppMethodBeat.o(175183);
    return bool;
  }
  
  public static final boolean a(Activity paramActivity, b<? super MMActivity, x> paramb, f.b paramb1)
  {
    AppMethodBeat.i(228437);
    p.h(paramActivity, "context");
    p.h(paramb, "function");
    if ((paramActivity instanceof MMActivity))
    {
      paramb.invoke(paramActivity);
      AppMethodBeat.o(228437);
      return true;
    }
    try
    {
      int i = paramb.hashCode();
      ProxyMMActivityResultRequest localProxyMMActivityResultRequest = new ProxyMMActivityResultRequest(i);
      int j = com.tencent.luggage.sdk.g.a.aK(localProxyMMActivityResultRequest);
      if (paramb1 != null) {
        com.tencent.luggage.h.f.aK((Context)paramActivity).b((f.c)new AppBrandJsApiPayUtils.a(j, paramb1));
      }
      mlY.put(i, paramb);
      com.tencent.mm.plugin.appbrand.ipc.a.b((Context)paramActivity, (AppBrandProxyUIProcessTask.ProcessRequest)localProxyMMActivityResultRequest, null);
      bool = true;
    }
    catch (Throwable paramActivity)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.AppBrandJsApiPayUtils", paramActivity, "waitForMMActivityResult startLogicProxy", new Object[0]);
        boolean bool = false;
      }
    }
    AppMethodBeat.o(228437);
    return bool;
  }
  
  public static boolean c(c paramc)
  {
    AppMethodBeat.i(228439);
    p.h(paramc, "service");
    paramc = paramc.bqZ();
    if (paramc != null) {}
    for (paramc = paramc.UN("paymentCustomAppid");; paramc = null)
    {
      boolean bool = Util.getBoolean(paramc, false);
      Log.i("MicroMsg.AppBrandJsApiPayUtils", "libSupportUseCustomAppId %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(228439);
      return bool;
    }
  }
  
  public static boolean c(c paramc, String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(228438);
    p.h(paramc, "service");
    p.h(paramString, "customAppId");
    paramc = paramc.getRuntime();
    p.g(paramc, "service.runtime");
    paramc = new i(paramc.bsC().cyv.lgZ).FI("call_plugin_info");
    if (paramc == null)
    {
      AppMethodBeat.o(228438);
      return false;
    }
    int j = paramc.length();
    int i = 0;
    if (i < j)
    {
      String str = paramc.pY(i).optString("plugin_id");
      Log.i("MicroMsg.AppBrandJsApiPayUtils", "canRequestPaymentUseCustomAppId pluginId:%s customAppId:%s", new Object[] { str, paramString });
      if (!p.j(str, paramString)) {}
    }
    for (;;)
    {
      AppMethodBeat.o(228438);
      return bool;
      i += 1;
      break;
      bool = false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils$ProxyMMActivityResultRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "requestId", "", "(I)V", "getRequestId", "()I", "component1", "copy", "describeContents", "equals", "", "other", "", "getStartActivityRequestCode", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "getUIAlias", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"})
  public static final class ProxyMMActivityResultRequest
    extends AppBrandProxyUIProcessTask.ProcessRequest
  {
    public static final a CREATOR;
    final int requestId;
    
    static
    {
      AppMethodBeat.i(175173);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(175173);
    }
    
    public ProxyMMActivityResultRequest(int paramInt)
    {
      this.requestId = paramInt;
    }
    
    public ProxyMMActivityResultRequest(Parcel paramParcel)
    {
      this(paramParcel.readInt());
      AppMethodBeat.i(175172);
      AppMethodBeat.o(175172);
    }
    
    public final Class<? extends AppBrandProxyUIProcessTask> bCJ()
    {
      return AppBrandJsApiPayUtils.ProxyMMActivityResultTask.class;
    }
    
    public final String bDO()
    {
      return "AppBrandJsApiPayUtils.waitForMMActivityResult";
    }
    
    public final int bDP()
    {
      AppMethodBeat.i(258368);
      int i = com.tencent.luggage.sdk.g.a.aK(this);
      AppMethodBeat.o(258368);
      return i;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof ProxyMMActivityResultRequest))
        {
          paramObject = (ProxyMMActivityResultRequest)paramObject;
          if (this.requestId != paramObject.requestId) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      return this.requestId;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(175174);
      String str = "ProxyMMActivityResultRequest(requestId=" + this.requestId + ")";
      AppMethodBeat.o(175174);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(175171);
      p.h(paramParcel, "parcel");
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.requestId);
      AppMethodBeat.o(175171);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils$ProxyMMActivityResultRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils$ProxyMMActivityResultRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils$ProxyMMActivityResultRequest;", "plugin-appbrand-integration_release"})
    public static final class a
      implements Parcelable.Creator<AppBrandJsApiPayUtils.ProxyMMActivityResultRequest>
    {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils$ProxyMMActivityResultTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "Landroid/arch/lifecycle/LifecycleObserver;", "()V", "mHasActivityResult", "", "requestId", "", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "onHostActivityDestroyed", "plugin-appbrand-integration_release"})
  public static final class ProxyMMActivityResultTask
    extends AppBrandProxyUIProcessTask
    implements LifecycleObserver
  {
    private boolean mma;
    private int requestId;
    
    public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
    {
      AppMethodBeat.i(175181);
      if (paramProcessRequest == null)
      {
        paramProcessRequest = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayUtils.ProxyMMActivityResultRequest");
        AppMethodBeat.o(175181);
        throw paramProcessRequest;
      }
      this.requestId = ((AppBrandJsApiPayUtils.ProxyMMActivityResultRequest)paramProcessRequest).requestId;
      paramProcessRequest = AppBrandJsApiPayUtils.mlZ;
      paramProcessRequest = (b)AppBrandJsApiPayUtils.a(AppBrandJsApiPayUtils.bIl(), this.requestId);
      if (paramProcessRequest == null)
      {
        ((kotlin.g.a.a)new a(this)).invoke();
        AppMethodBeat.o(175181);
        return;
      }
      com.tencent.luggage.h.f.aK((Context)bDF()).a((f.c)new b(this));
      MMActivity localMMActivity = bDF();
      p.g(localMMActivity, "activityContext");
      paramProcessRequest.invoke(localMMActivity);
      AppMethodBeat.o(175181);
    }
    
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onHostActivityDestroyed()
    {
      AppMethodBeat.i(228434);
      if (!this.mma)
      {
        bDF().setResult(0);
        bDF().finish();
      }
      AppMethodBeat.o(228434);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(AppBrandJsApiPayUtils.ProxyMMActivityResultTask paramProxyMMActivityResultTask)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onResult"})
    static final class b
      implements f.c
    {
      b(AppBrandJsApiPayUtils.ProxyMMActivityResultTask paramProxyMMActivityResultTask) {}
      
      public final boolean c(int paramInt1, int paramInt2, Intent paramIntent)
      {
        AppMethodBeat.i(175180);
        AppBrandJsApiPayUtils.ProxyMMActivityResultTask.b(this.mmb).setResult(paramInt2, paramIntent);
        AppBrandJsApiPayUtils.ProxyMMActivityResultTask.a(this.mmb);
        AppBrandJsApiPayUtils.ProxyMMActivityResultTask.c(this.mmb);
        AppMethodBeat.o(175180);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayUtils
 * JD-Core Version:    0.7.0.1
 */