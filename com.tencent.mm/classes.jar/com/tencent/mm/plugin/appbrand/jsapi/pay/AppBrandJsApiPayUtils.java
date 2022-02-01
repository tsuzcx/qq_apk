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
import com.tencent.luggage.h.e;
import com.tencent.luggage.h.e.a;
import com.tencent.luggage.h.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import d.g.a.b;
import d.g.b.k;
import d.v;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils;", "", "()V", "TAG", "", "gProxyFunctionsMap", "Landroid/util/SparseArray;", "Lkotlin/Function1;", "Lcom/tencent/mm/ui/MMActivity;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/pay/ProxyForMMActivityResultCallback;", "waitForMMActivityResult", "", "context", "Landroid/app/Activity;", "function", "activityResultCallback", "Lcom/tencent/luggage/util/LuggageActivityHelper$ActivityResultCallback;", "removeReturns", "T", "key", "", "(Landroid/util/SparseArray;I)Ljava/lang/Object;", "ProxyMMActivityResultRequest", "ProxyMMActivityResultResult", "ProxyMMActivityResultTask", "plugin-appbrand-integration_release"})
public final class AppBrandJsApiPayUtils
{
  private static final SparseArray<b<MMActivity, y>> kGx;
  public static final AppBrandJsApiPayUtils kGy;
  
  static
  {
    AppMethodBeat.i(175184);
    kGy = new AppBrandJsApiPayUtils();
    kGx = new SparseArray();
    AppMethodBeat.o(175184);
  }
  
  public static final boolean a(Activity paramActivity, b<? super MMActivity, y> paramb)
  {
    AppMethodBeat.i(175183);
    boolean bool = a(paramActivity, paramb, null);
    AppMethodBeat.o(175183);
    return bool;
  }
  
  public static final boolean a(Activity paramActivity, b<? super MMActivity, y> paramb, final e.a parama)
  {
    AppMethodBeat.i(187223);
    k.h(paramActivity, "context");
    k.h(paramb, "function");
    if ((paramActivity instanceof MMActivity))
    {
      paramb.ay(paramActivity);
      AppMethodBeat.o(187223);
      return true;
    }
    try
    {
      int i = paramb.hashCode();
      ProxyMMActivityResultRequest localProxyMMActivityResultRequest = new ProxyMMActivityResultRequest(i);
      int j = com.tencent.luggage.sdk.g.a.aA(localProxyMMActivityResultRequest);
      if (parama != null) {
        e.aA((Context)paramActivity).b((e.b)new a(j, parama));
      }
      kGx.put(i, paramb);
      com.tencent.mm.plugin.appbrand.ipc.a.b((Context)paramActivity, (AppBrandProxyUIProcessTask.ProcessRequest)localProxyMMActivityResultRequest, null);
      bool = true;
    }
    catch (Throwable paramActivity)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.AppBrandJsApiPayUtils", paramActivity, "waitForMMActivityResult startLogicProxy", new Object[0]);
        boolean bool = false;
      }
    }
    AppMethodBeat.o(187223);
    return bool;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils$ProxyMMActivityResultRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "requestId", "", "(I)V", "getRequestId", "()I", "component1", "copy", "describeContents", "equals", "", "other", "", "getStartActivityRequestCode", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "getUIAlias", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"})
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
    
    public final Class<? extends AppBrandProxyUIProcessTask> bdj()
    {
      return AppBrandJsApiPayUtils.ProxyMMActivityResultTask.class;
    }
    
    public final String beo()
    {
      return "AppBrandJsApiPayUtils.waitForMMActivityResult";
    }
    
    public final int bep()
    {
      AppMethodBeat.i(210163);
      int i = com.tencent.luggage.sdk.g.a.aA(this);
      AppMethodBeat.o(210163);
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
      k.h(paramParcel, "parcel");
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.requestId);
      AppMethodBeat.o(175171);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils$ProxyMMActivityResultRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils$ProxyMMActivityResultRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils$ProxyMMActivityResultRequest;", "plugin-appbrand-integration_release"})
    public static final class a
      implements Parcelable.Creator<AppBrandJsApiPayUtils.ProxyMMActivityResultRequest>
    {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils$ProxyMMActivityResultResult;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessResult;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "describeContents", "", "readParcel", "", "in", "writeToParcel", "flags", "CREATOR", "plugin-appbrand-integration_release"})
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
    
    public final void j(Parcel paramParcel) {}
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(175176);
      k.h(paramParcel, "parcel");
      AppMethodBeat.o(175176);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils$ProxyMMActivityResultResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils$ProxyMMActivityResultResult;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils$ProxyMMActivityResultResult;", "plugin-appbrand-integration_release"})
    public static final class a
      implements Parcelable.Creator<AppBrandJsApiPayUtils.ProxyMMActivityResultResult>
    {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils$ProxyMMActivityResultTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "Landroid/arch/lifecycle/LifecycleObserver;", "()V", "mHasActivityResult", "", "requestId", "", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "onHostActivityDestroyed", "plugin-appbrand-integration_release"})
  public static final class ProxyMMActivityResultTask
    extends AppBrandProxyUIProcessTask
    implements LifecycleObserver
  {
    private boolean kGz;
    private int requestId;
    
    public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
    {
      AppMethodBeat.i(175181);
      if (paramProcessRequest == null)
      {
        paramProcessRequest = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayUtils.ProxyMMActivityResultRequest");
        AppMethodBeat.o(175181);
        throw paramProcessRequest;
      }
      this.requestId = ((AppBrandJsApiPayUtils.ProxyMMActivityResultRequest)paramProcessRequest).requestId;
      paramProcessRequest = AppBrandJsApiPayUtils.kGy;
      paramProcessRequest = (b)AppBrandJsApiPayUtils.a(AppBrandJsApiPayUtils.bir(), this.requestId);
      if (paramProcessRequest == null)
      {
        ((d.g.a.a)new a(this)).invoke();
        AppMethodBeat.o(175181);
        return;
      }
      e.aA((Context)bef()).a((e.b)new b(this));
      MMActivity localMMActivity = bef();
      k.g(localMMActivity, "activityContext");
      paramProcessRequest.ay(localMMActivity);
      AppMethodBeat.o(175181);
    }
    
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onHostActivityDestroyed()
    {
      AppMethodBeat.i(187220);
      if (!this.kGz)
      {
        bef().setResult(0);
        bef().finish();
      }
      AppMethodBeat.o(187220);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(AppBrandJsApiPayUtils.ProxyMMActivityResultTask paramProxyMMActivityResultTask)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "<anonymous parameter 0>", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onResult"})
    static final class b
      implements e.b
    {
      b(AppBrandJsApiPayUtils.ProxyMMActivityResultTask paramProxyMMActivityResultTask) {}
      
      public final boolean b(int paramInt1, int paramInt2, Intent paramIntent)
      {
        AppMethodBeat.i(175180);
        AppBrandJsApiPayUtils.ProxyMMActivityResultTask.b(this.kGA).setResult(paramInt2, paramIntent);
        AppBrandJsApiPayUtils.ProxyMMActivityResultTask.a(this.kGA);
        AppBrandJsApiPayUtils.ProxyMMActivityResultTask.c(this.kGA);
        AppMethodBeat.o(175180);
        return true;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onResult"})
  static final class a
    implements e.b
  {
    a(int paramInt, e.a parama) {}
    
    public final boolean b(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(187222);
      if (this.kGB == paramInt1)
      {
        parama.a(paramInt2, paramIntent);
        AppMethodBeat.o(187222);
        return true;
      }
      AppMethodBeat.o(187222);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayUtils
 * JD-Core Version:    0.7.0.1
 */