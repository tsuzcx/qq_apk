package com.tencent.mm.plugin.appbrand.jsapi.pay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.z;
import com.tencent.luggage.l.e;
import com.tencent.luggage.l.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.f;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils;", "", "()V", "TAG", "", "gProxyFunctionsMap", "Landroid/util/SparseArray;", "Lkotlin/Function1;", "Lcom/tencent/mm/ui/MMActivity;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/pay/ProxyForMMActivityResultCallback;", "customAppIdInWhitleList", "", "service", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "customAppId", "libSupportUseCustomAppId", "waitForMMActivityResult", "context", "Landroid/app/Activity;", "function", "activityResultCallback", "Lcom/tencent/luggage/util/LuggageActivityHelper$ActivityResultCallback;", "removeReturns", "T", "key", "", "(Landroid/util/SparseArray;I)Ljava/lang/Object;", "ProxyMMActivityResultRequest", "ProxyMMActivityResultResult", "ProxyMMActivityResultTask", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandJsApiPayUtils
{
  public static final AppBrandJsApiPayUtils sph;
  private static final SparseArray<b<MMActivity, ah>> spi;
  
  static
  {
    AppMethodBeat.i(175184);
    sph = new AppBrandJsApiPayUtils();
    spi = new SparseArray();
    AppMethodBeat.o(175184);
  }
  
  private static final boolean a(int paramInt1, e.b paramb, int paramInt2, int paramInt3, Intent paramIntent)
  {
    AppMethodBeat.i(327853);
    if (paramInt1 == paramInt2)
    {
      paramb.onResult(paramInt3, paramIntent);
      AppMethodBeat.o(327853);
      return true;
    }
    AppMethodBeat.o(327853);
    return false;
  }
  
  public static final boolean a(Activity paramActivity, b<? super MMActivity, ah> paramb)
  {
    AppMethodBeat.i(175183);
    s.u(paramActivity, "context");
    s.u(paramb, "function");
    boolean bool = a(paramActivity, paramb, null);
    AppMethodBeat.o(175183);
    return bool;
  }
  
  public static final boolean a(Activity paramActivity, b<? super MMActivity, ah> paramb, e.b paramb1)
  {
    AppMethodBeat.i(327834);
    s.u(paramActivity, "context");
    s.u(paramb, "function");
    if ((paramActivity instanceof MMActivity))
    {
      paramb.invoke(paramActivity);
      AppMethodBeat.o(327834);
      return true;
    }
    try
    {
      int i = paramb.hashCode();
      ProxyMMActivityResultRequest localProxyMMActivityResultRequest = new ProxyMMActivityResultRequest(i);
      int j = localProxyMMActivityResultRequest.getStartActivityRequestCode();
      if (paramb1 != null) {
        e.bt((Context)paramActivity).b(new AppBrandJsApiPayUtils..ExternalSyntheticLambda0(j, paramb1));
      }
      spi.put(i, paramb);
      com.tencent.mm.plugin.appbrand.ipc.a.b((Context)paramActivity, (AppBrandProxyUIProcessTask.ProcessRequest)localProxyMMActivityResultRequest, null);
      bool = true;
    }
    finally
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.AppBrandJsApiPayUtils", paramActivity, "waitForMMActivityResult startLogicProxy", new Object[0]);
        boolean bool = false;
      }
    }
    AppMethodBeat.o(327834);
    return bool;
  }
  
  public static boolean c(c paramc, String paramString)
  {
    boolean bool2 = false;
    AppMethodBeat.i(327841);
    s.u(paramc, "service");
    s.u(paramString, "customAppId");
    paramc = new i(paramc.getRuntime().getInitConfig().epa.rcs).Fr("call_plugin_info");
    if (paramc == null)
    {
      AppMethodBeat.o(327841);
      return false;
    }
    int k = paramc.length();
    boolean bool1 = bool2;
    if (k > 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      String str = paramc.st(i).optString("plugin_id");
      Log.i("MicroMsg.AppBrandJsApiPayUtils", "canRequestPaymentUseCustomAppId pluginId:%s customAppId:%s", new Object[] { str, paramString });
      if (s.p(str, paramString)) {
        bool1 = true;
      }
      do
      {
        AppMethodBeat.o(327841);
        return bool1;
        bool1 = bool2;
      } while (j >= k);
    }
  }
  
  public static boolean d(c paramc)
  {
    AppMethodBeat.i(327844);
    s.u(paramc, "service");
    paramc = paramc.cbl();
    if (paramc == null) {}
    for (paramc = null;; paramc = paramc.UX("paymentCustomAppid"))
    {
      boolean bool = Util.getBoolean(paramc, false);
      Log.i("MicroMsg.AppBrandJsApiPayUtils", "libSupportUseCustomAppId %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(327844);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils$ProxyMMActivityResultRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "requestId", "", "(I)V", "getRequestId", "()I", "component1", "copy", "describeContents", "equals", "", "other", "", "getStartActivityRequestCode", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "getUIAlias", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
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
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof ProxyMMActivityResultRequest)) {
          return false;
        }
        paramObject = (ProxyMMActivityResultRequest)paramObject;
      } while (this.requestId == paramObject.requestId);
      return false;
    }
    
    public final int getStartActivityRequestCode()
    {
      AppMethodBeat.i(327812);
      int i = com.tencent.luggage.sdk.h.a.ce(this);
      AppMethodBeat.o(327812);
      return i;
    }
    
    public final Class<? extends AppBrandProxyUIProcessTask> getTaskClass()
    {
      return AppBrandJsApiPayUtils.ProxyMMActivityResultTask.class;
    }
    
    public final String getUIAlias()
    {
      return "AppBrandJsApiPayUtils.waitForMMActivityResult";
    }
    
    public final int hashCode()
    {
      return this.requestId;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(175174);
      String str = "ProxyMMActivityResultRequest(requestId=" + this.requestId + ')';
      AppMethodBeat.o(175174);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(175171);
      s.u(paramParcel, "parcel");
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.requestId);
      AppMethodBeat.o(175171);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils$ProxyMMActivityResultRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils$ProxyMMActivityResultRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils$ProxyMMActivityResultRequest;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Parcelable.Creator<AppBrandJsApiPayUtils.ProxyMMActivityResultRequest>
    {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils$ProxyMMActivityResultResult;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessResult;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "describeContents", "", "readParcel", "", "in", "writeToParcel", "flags", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class ProxyMMActivityResultResult
    extends AppBrandProxyUIProcessTask.ProcessResult
  {
    public static final a CREATOR;
    
    static
    {
      AppMethodBeat.i(175178);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(175178);
    }
    
    public ProxyMMActivityResultResult() {}
    
    public ProxyMMActivityResultResult(Parcel paramParcel)
    {
      this();
      AppMethodBeat.i(175177);
      AppMethodBeat.o(175177);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void readParcel(Parcel paramParcel) {}
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(175176);
      s.u(paramParcel, "parcel");
      AppMethodBeat.o(175176);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils$ProxyMMActivityResultResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils$ProxyMMActivityResultResult;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils$ProxyMMActivityResultResult;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Parcelable.Creator<AppBrandJsApiPayUtils.ProxyMMActivityResultResult>
    {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils$ProxyMMActivityResultTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "Landroidx/lifecycle/LifecycleObserver;", "()V", "mHasActivityResult", "", "requestId", "", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "onHostActivityDestroyed", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class ProxyMMActivityResultTask
    extends AppBrandProxyUIProcessTask
    implements p
  {
    private int requestId;
    private boolean spj;
    
    private static final boolean a(ProxyMMActivityResultTask paramProxyMMActivityResultTask, int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(327827);
      s.u(paramProxyMMActivityResultTask, "this$0");
      paramProxyMMActivityResultTask.getActivityContext().setResult(paramInt2, paramIntent);
      paramProxyMMActivityResultTask.finishProcess(null);
      paramProxyMMActivityResultTask.spj = true;
      AppMethodBeat.o(327827);
      return true;
    }
    
    public final void handleRequest(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
    {
      AppMethodBeat.i(175181);
      if (paramProcessRequest == null)
      {
        paramProcessRequest = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayUtils.ProxyMMActivityResultRequest");
        AppMethodBeat.o(175181);
        throw paramProcessRequest;
      }
      this.requestId = ((AppBrandJsApiPayUtils.ProxyMMActivityResultRequest)paramProcessRequest).requestId;
      paramProcessRequest = AppBrandJsApiPayUtils.sph;
      paramProcessRequest = (b)AppBrandJsApiPayUtils.a(AppBrandJsApiPayUtils.cuh(), this.requestId);
      if (paramProcessRequest == null)
      {
        s.u(this, "this$0");
        finishProcess(null);
        AppMethodBeat.o(175181);
        return;
      }
      e.bt((Context)getActivityContext()).a(new AppBrandJsApiPayUtils.ProxyMMActivityResultTask..ExternalSyntheticLambda0(this));
      MMActivity localMMActivity = getActivityContext();
      s.s(localMMActivity, "activityContext");
      paramProcessRequest.invoke(localMMActivity);
      AppMethodBeat.o(175181);
    }
    
    @z(Ho=j.a.ON_DESTROY)
    public final void onHostActivityDestroyed()
    {
      AppMethodBeat.i(327835);
      if (!this.spj)
      {
        getActivityContext().setResult(0);
        getActivityContext().finish();
      }
      AppMethodBeat.o(327835);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayUtils
 * JD-Core Version:    0.7.0.1
 */