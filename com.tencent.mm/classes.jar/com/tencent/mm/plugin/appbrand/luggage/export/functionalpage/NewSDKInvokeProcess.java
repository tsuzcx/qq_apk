package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.content.Context;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.f;
import com.tencent.mm.plugin.appbrand.permission.a.a.c;
import com.tencent.mm.plugin.appbrand.permission.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.q;
import org.json.JSONObject;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/NewSDKInvokeProcess;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalAPIInvokeProcess;", "runtime", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "(Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;)V", "CALLBACK_ID", "", "newSdkInvokeArgs", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "navigateBack", "", "transitiveData", "", "invokeResult", "onCallback", "component", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalComponent;", "callbackId", "data", "onPayAheadCallback", "callbackStr", "performInvoke", "invokeData", "Companion", "NewSdkInvokeBackData", "plugin-appbrand-integration_release"})
final class NewSDKInvokeProcess
  implements o
{
  @Deprecated
  public static final NewSDKInvokeProcess.a lOJ;
  private WechatNativeExtraDataInvokeFunctionalPage lOH;
  private final int lOI;
  final l lOq;
  
  static
  {
    AppMethodBeat.i(189396);
    lOJ = new NewSDKInvokeProcess.a((byte)0);
    AppMethodBeat.o(189396);
  }
  
  public NewSDKInvokeProcess(l paraml)
  {
    AppMethodBeat.i(189395);
    this.lOq = paraml;
    this.lOI = (hashCode() & 0xFFFF);
    AppMethodBeat.o(189395);
  }
  
  private final void Sf(String paramString)
  {
    AppMethodBeat.i(189393);
    ad.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.NewSDKInvokeProcess", "navigateBack, instance(" + hashCode() + ", invokeResult(" + paramString + ')');
    com.tencent.e.h.LTJ.aP((Runnable)new b(this));
    WechatNativeExtraDataInvokeFunctionalPage localWechatNativeExtraDataInvokeFunctionalPage = this.lOH;
    if (localWechatNativeExtraDataInvokeFunctionalPage == null) {
      d.g.b.p.bcb("newSdkInvokeArgs");
    }
    f.a(new NewSDKInvokeProcess.NewSdkInvokeBackData(localWechatNativeExtraDataInvokeFunctionalPage, paramString), (b)NewSDKInvokeProcess.c.lON, (com.tencent.mm.ipcinvoker.d)new d(this));
    AppMethodBeat.o(189393);
  }
  
  public final void Se(final String paramString)
  {
    AppMethodBeat.i(189391);
    d.g.b.p.h(paramString, "invokeData");
    ad.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.NewSDKInvokeProcess", "performInvoke with instance(" + hashCode() + ") callbackId(" + this.lOI + ") appId(" + this.lOq.getAppId() + ") data(" + paramString + ')');
    Object localObject1 = new WechatNativeExtraDataInvokeFunctionalPage();
    ((WechatNativeExtraDataInvokeFunctionalPage)localObject1).Z(new JSONObject(paramString));
    this.lOH = ((WechatNativeExtraDataInvokeFunctionalPage)localObject1);
    paramString = this.lOH;
    if (paramString == null) {
      d.g.b.p.bcb("newSdkInvokeArgs");
    }
    localObject1 = paramString.lOX;
    paramString = this.lOH;
    if (paramString == null) {
      d.g.b.p.bcb("newSdkInvokeArgs");
    }
    Object localObject2 = paramString.lOY;
    paramString = this.lOH;
    if (paramString == null) {
      d.g.b.p.bcb("newSdkInvokeArgs");
    }
    final String str = paramString.jXV;
    paramString = (CharSequence)localObject1;
    if ((paramString == null) || (paramString.length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        paramString = (CharSequence)localObject2;
        if ((paramString != null) && (paramString.length() != 0)) {
          break label226;
        }
      }
    }
    label226:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label231;
      }
      Sf("fail invalid args");
      AppMethodBeat.o(189391);
      return;
      i = 0;
      break;
    }
    label231:
    paramString = this.lOH;
    if (paramString == null) {
      d.g.b.p.bcb("newSdkInvokeArgs");
    }
    paramString = paramString.lOZ;
    if (paramString == null) {}
    do
    {
      do
      {
        for (;;)
        {
          Sf(d.dU("fail invalid jsapiType", (String)localObject1));
          paramString = (Throwable)new RuntimeException();
          AppMethodBeat.o(189391);
          throw paramString;
          switch (paramString.hashCode())
          {
          }
        }
      } while (!paramString.equals("webview"));
      paramString = this.lOq.aXd();
      d.g.b.p.g(paramString, "runtime.pageContainer");
      paramString = paramString.getPageView();
      if (paramString != null) {
        break;
      }
      paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalPageView");
      AppMethodBeat.o(189391);
      throw paramString;
    } while (!paramString.equals("appservice"));
    paramString = this.lOq.aXe();
    if (paramString == null)
    {
      paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalAppService");
      AppMethodBeat.o(189391);
      throw paramString;
    }
    for (paramString = (p)paramString;; paramString = (p)paramString)
    {
      localObject2 = (d.g.a.a)new g(this, paramString, (String)localObject1, (String)localObject2);
      WechatNativeExtraDataInvokeFunctionalPage localWechatNativeExtraDataInvokeFunctionalPage = this.lOH;
      if (localWechatNativeExtraDataInvokeFunctionalPage == null) {
        d.g.b.p.bcb("newSdkInvokeArgs");
      }
      if (3 != localWechatNativeExtraDataInvokeFunctionalPage.lPa) {
        break label530;
      }
      if (paramString != null) {
        break;
      }
      paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.AppBrandComponentWxaShared");
      AppMethodBeat.o(189391);
      throw paramString;
    }
    com.tencent.mm.plugin.appbrand.permission.a.a.a(new c((com.tencent.mm.plugin.appbrand.d)paramString, (String)localObject1, null, this.lOI), (a.c)new f(this, (d.g.a.a)localObject2, str, (String)localObject1));
    AppMethodBeat.o(189391);
    return;
    label530:
    ((d.g.a.a)localObject2).invoke();
    AppMethodBeat.o(189391);
  }
  
  public final void a(p paramp, int paramInt, String paramString)
  {
    AppMethodBeat.i(189392);
    d.g.b.p.h(paramp, "component");
    d.g.b.p.h(paramString, "data");
    ad.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.NewSDKInvokeProcess", "onCallback, instance(" + hashCode() + ", callbackId(" + paramInt + "), data(" + paramString + ')');
    if (this.lOI == paramInt)
    {
      if (this.lOH == null) {
        d.g.b.p.bcb("newSdkInvokeArgs");
      }
      Sf(paramString);
    }
    AppMethodBeat.o(189392);
  }
  
  public final void b(p paramp, int paramInt, String paramString)
  {
    AppMethodBeat.i(189394);
    d.g.b.p.h(paramp, "component");
    d.g.b.p.h(paramString, "callbackStr");
    ad.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.NewSDKInvokeProcess", "onPayAheadCallback, instance(" + hashCode() + ", callbackId(" + paramInt + "), callbackStr(" + paramString + ')');
    paramp = this.lOH;
    if (paramp == null) {
      d.g.b.p.bcb("newSdkInvokeArgs");
    }
    f.a(new NewSDKInvokeProcess.NewSdkInvokeBackData(paramp, paramString), (b)NewSDKInvokeProcess.e.lOQ, null);
    AppMethodBeat.o(189394);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(NewSDKInvokeProcess paramNewSDKInvokeProcess) {}
    
    public final void run()
    {
      AppMethodBeat.i(189376);
      Object localObject = this.lOM.lOq.getContext();
      if (localObject != null)
      {
        localObject = (Context)localObject;
        aj.getContext().getString(2131755906);
        com.tencent.mm.ui.base.h.b((Context)localObject, aj.getContext().getString(2131767049), false, null);
        AppMethodBeat.o(189376);
        return;
      }
      AppMethodBeat.o(189376);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class d<T>
    implements com.tencent.mm.ipcinvoker.d<IPCVoid>
  {
    d(NewSDKInvokeProcess paramNewSDKInvokeProcess) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/NewSDKInvokeProcess$performInvoke$2", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/AppBrandJsApiUserAuth$OnUserAuthResultListener;", "onCancel", "", "onConfirm", "onDeny", "reason", "", "plugin-appbrand-integration_release"})
  public static final class f
    implements a.c
  {
    f(d.g.a.a parama, String paramString1, String paramString2) {}
    
    public final void Sg(String paramString)
    {
      AppMethodBeat.i(189388);
      NewSDKInvokeProcess localNewSDKInvokeProcess = this.lOM;
      StringBuilder localStringBuilder = new StringBuilder("fail ");
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      NewSDKInvokeProcess.a(localNewSDKInvokeProcess, d.dU(str, this.lOT));
      AppMethodBeat.o(189388);
    }
    
    public final void bsq()
    {
      AppMethodBeat.i(189387);
      this.lOR.invoke();
      AppMethodBeat.o(189387);
    }
    
    public final void onCancel()
    {
      AppMethodBeat.i(189389);
      NewSDKInvokeProcess.a(this.lOM, d.dU("fail:auth canceled", this.lOT));
      AppMethodBeat.o(189389);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<String>
  {
    g(NewSDKInvokeProcess paramNewSDKInvokeProcess, p paramp, String paramString1, String paramString2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.NewSDKInvokeProcess
 * JD-Core Version:    0.7.0.1
 */