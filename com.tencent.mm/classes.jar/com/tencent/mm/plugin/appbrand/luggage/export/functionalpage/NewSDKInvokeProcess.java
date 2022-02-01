package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.permission.a.a.c;
import com.tencent.mm.plugin.appbrand.permission.a.c;
import com.tencent.mm.protocal.protobuf.ejr;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import d.g.b.q;
import d.v;
import org.json.JSONObject;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/NewSDKInvokeProcess;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalAPIInvokeProcess;", "runtime", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "(Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;)V", "CALLBACK_ID", "", "newSdkInvokeArgs", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "navigateBack", "", "transitiveData", "", "invokeResult", "onCallback", "component", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalComponent;", "callbackId", "data", "onPayAheadCallback", "callbackStr", "performInvoke", "invokeData", "Companion", "NewSdkInvokeBackData", "plugin-appbrand-integration_release"})
final class NewSDKInvokeProcess
  implements o
{
  @Deprecated
  public static final a lTk;
  final l lSR;
  private WechatNativeExtraDataInvokeFunctionalPage lTi;
  private final int lTj;
  
  static
  {
    AppMethodBeat.i(223656);
    lTk = new a((byte)0);
    AppMethodBeat.o(223656);
  }
  
  public NewSDKInvokeProcess(l paraml)
  {
    AppMethodBeat.i(223655);
    this.lSR = paraml;
    this.lTj = (hashCode() & 0xFFFF);
    AppMethodBeat.o(223655);
  }
  
  private final void SO(String paramString)
  {
    AppMethodBeat.i(223653);
    ae.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.NewSDKInvokeProcess", "navigateBack, instance(" + hashCode() + ", invokeResult(" + paramString + ')');
    com.tencent.e.h.MqF.aM((Runnable)new b(this));
    WechatNativeExtraDataInvokeFunctionalPage localWechatNativeExtraDataInvokeFunctionalPage = this.lTi;
    if (localWechatNativeExtraDataInvokeFunctionalPage == null) {
      d.g.b.p.bdF("newSdkInvokeArgs");
    }
    com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new NewSdkInvokeBackData(localWechatNativeExtraDataInvokeFunctionalPage, paramString), (b)c.lTo, (com.tencent.mm.ipcinvoker.d)new d(this));
    AppMethodBeat.o(223653);
  }
  
  public final void SN(final String paramString)
  {
    AppMethodBeat.i(223651);
    d.g.b.p.h(paramString, "invokeData");
    ae.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.NewSDKInvokeProcess", "performInvoke with instance(" + hashCode() + ") callbackId(" + this.lTj + ") appId(" + this.lSR.getAppId() + ") data(" + paramString + ')');
    Object localObject1 = new WechatNativeExtraDataInvokeFunctionalPage();
    ((WechatNativeExtraDataInvokeFunctionalPage)localObject1).Z(new JSONObject(paramString));
    this.lTi = ((WechatNativeExtraDataInvokeFunctionalPage)localObject1);
    paramString = this.lTi;
    if (paramString == null) {
      d.g.b.p.bdF("newSdkInvokeArgs");
    }
    localObject1 = paramString.lTy;
    paramString = this.lTi;
    if (paramString == null) {
      d.g.b.p.bdF("newSdkInvokeArgs");
    }
    Object localObject2 = paramString.lTz;
    paramString = this.lTi;
    if (paramString == null) {
      d.g.b.p.bdF("newSdkInvokeArgs");
    }
    final String str = paramString.kbk;
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
      SO("fail invalid args");
      AppMethodBeat.o(223651);
      return;
      i = 0;
      break;
    }
    label231:
    paramString = this.lTi;
    if (paramString == null) {
      d.g.b.p.bdF("newSdkInvokeArgs");
    }
    paramString = paramString.lTA;
    if (paramString == null) {}
    do
    {
      do
      {
        for (;;)
        {
          SO(d.dW("fail invalid jsapiType", (String)localObject1));
          paramString = (Throwable)new RuntimeException();
          AppMethodBeat.o(223651);
          throw paramString;
          switch (paramString.hashCode())
          {
          }
        }
      } while (!paramString.equals("webview"));
      paramString = this.lSR.aXy();
      d.g.b.p.g(paramString, "runtime.pageContainer");
      paramString = paramString.getPageView();
      if (paramString != null) {
        break;
      }
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalPageView");
      AppMethodBeat.o(223651);
      throw paramString;
    } while (!paramString.equals("appservice"));
    paramString = this.lSR.aXz();
    if (paramString == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalAppService");
      AppMethodBeat.o(223651);
      throw paramString;
    }
    for (paramString = (p)paramString;; paramString = (p)paramString)
    {
      localObject2 = (d.g.a.a)new g(this, paramString, (String)localObject1, (String)localObject2);
      WechatNativeExtraDataInvokeFunctionalPage localWechatNativeExtraDataInvokeFunctionalPage = this.lTi;
      if (localWechatNativeExtraDataInvokeFunctionalPage == null) {
        d.g.b.p.bdF("newSdkInvokeArgs");
      }
      if (3 != localWechatNativeExtraDataInvokeFunctionalPage.lTB) {
        break label531;
      }
      if (paramString != null) {
        break;
      }
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.AppBrandComponentWxaShared");
      AppMethodBeat.o(223651);
      throw paramString;
    }
    com.tencent.mm.plugin.appbrand.permission.a.a.a(new c((com.tencent.mm.plugin.appbrand.d)paramString, (String)localObject1, null, this.lTj), (a.c)new f(this, (d.g.a.a)localObject2, str, (String)localObject1));
    AppMethodBeat.o(223651);
    return;
    label531:
    ((d.g.a.a)localObject2).invoke();
    AppMethodBeat.o(223651);
  }
  
  public final void a(p paramp, int paramInt, String paramString)
  {
    AppMethodBeat.i(223652);
    d.g.b.p.h(paramp, "component");
    d.g.b.p.h(paramString, "data");
    ae.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.NewSDKInvokeProcess", "onCallback, instance(" + hashCode() + ", callbackId(" + paramInt + "), data(" + paramString + ')');
    if (this.lTj == paramInt)
    {
      if (this.lTi == null) {
        d.g.b.p.bdF("newSdkInvokeArgs");
      }
      SO(paramString);
    }
    AppMethodBeat.o(223652);
  }
  
  public final void b(p paramp, int paramInt, String paramString)
  {
    AppMethodBeat.i(223654);
    d.g.b.p.h(paramp, "component");
    d.g.b.p.h(paramString, "callbackStr");
    ae.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.NewSDKInvokeProcess", "onPayAheadCallback, instance(" + hashCode() + ", callbackId(" + paramInt + "), callbackStr(" + paramString + ')');
    paramp = this.lTi;
    if (paramp == null) {
      d.g.b.p.bdF("newSdkInvokeArgs");
    }
    com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new NewSdkInvokeBackData(paramp, paramString), (b)e.lTr, null);
    AppMethodBeat.o(223654);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/NewSDKInvokeProcess$NewSdkInvokeBackData;", "Landroid/os/Parcelable;", "invokeReq", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "backData", "", "(Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;Ljava/lang/String;)V", "getBackData", "()Ljava/lang/String;", "getInvokeReq", "()Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
  static final class NewSdkInvokeBackData
    implements Parcelable
  {
    public static final Parcelable.Creator CREATOR;
    final WechatNativeExtraDataInvokeFunctionalPage lTl;
    final String lTm;
    
    static
    {
      AppMethodBeat.i(223635);
      CREATOR = new a();
      AppMethodBeat.o(223635);
    }
    
    public NewSdkInvokeBackData(WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, String paramString)
    {
      AppMethodBeat.i(223630);
      this.lTl = paramWechatNativeExtraDataInvokeFunctionalPage;
      this.lTm = paramString;
      AppMethodBeat.o(223630);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(223633);
      if (this != paramObject)
      {
        if ((paramObject instanceof NewSdkInvokeBackData))
        {
          paramObject = (NewSdkInvokeBackData)paramObject;
          if ((!d.g.b.p.i(this.lTl, paramObject.lTl)) || (!d.g.b.p.i(this.lTm, paramObject.lTm))) {}
        }
      }
      else
      {
        AppMethodBeat.o(223633);
        return true;
      }
      AppMethodBeat.o(223633);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(223632);
      Object localObject = this.lTl;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.lTm;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(223632);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(223631);
      String str = "NewSdkInvokeBackData(invokeReq=" + this.lTl + ", backData=" + this.lTm + ")";
      AppMethodBeat.o(223631);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(223634);
      d.g.b.p.h(paramParcel, "parcel");
      this.lTl.writeToParcel(paramParcel, 0);
      paramParcel.writeString(this.lTm);
      AppMethodBeat.o(223634);
    }
    
    @d.l(gjZ={1, 1, 16})
    public static final class a
      implements Parcelable.Creator
    {
      public final Object createFromParcel(Parcel paramParcel)
      {
        AppMethodBeat.i(223629);
        d.g.b.p.h(paramParcel, "in");
        paramParcel = new NewSDKInvokeProcess.NewSdkInvokeBackData((WechatNativeExtraDataInvokeFunctionalPage)WechatNativeExtraDataInvokeFunctionalPage.CREATOR.createFromParcel(paramParcel), paramParcel.readString());
        AppMethodBeat.o(223629);
        return paramParcel;
      }
      
      public final Object[] newArray(int paramInt)
      {
        return new NewSDKInvokeProcess.NewSdkInvokeBackData[paramInt];
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/NewSDKInvokeProcess$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(NewSDKInvokeProcess paramNewSDKInvokeProcess) {}
    
    public final void run()
    {
      AppMethodBeat.i(223636);
      Object localObject = this.lTn.lSR.getContext();
      if (localObject != null)
      {
        localObject = (Context)localObject;
        ak.getContext().getString(2131755906);
        com.tencent.mm.ui.base.h.b((Context)localObject, ak.getContext().getString(2131767049), false, null);
        AppMethodBeat.o(223636);
        return;
      }
      AppMethodBeat.o(223636);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "data", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/NewSDKInvokeProcess$NewSdkInvokeBackData;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class c<InputType, ResultType>
    implements b<NewSDKInvokeProcess.NewSdkInvokeBackData, IPCVoid>
  {
    public static final c lTo;
    
    static
    {
      AppMethodBeat.i(223643);
      lTo = new c();
      AppMethodBeat.o(223643);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class d<T>
    implements com.tencent.mm.ipcinvoker.d<IPCVoid>
  {
    d(NewSDKInvokeProcess paramNewSDKInvokeProcess) {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "data", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/NewSDKInvokeProcess$NewSdkInvokeBackData;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class e<InputType, ResultType>
    implements b<NewSDKInvokeProcess.NewSdkInvokeBackData, IPCVoid>
  {
    public static final e lTr;
    
    static
    {
      AppMethodBeat.i(223646);
      lTr = new e();
      AppMethodBeat.o(223646);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/NewSDKInvokeProcess$performInvoke$2", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/AppBrandJsApiUserAuth$OnUserAuthResultListener;", "onCancel", "", "onConfirm", "onDeny", "reason", "", "plugin-appbrand-integration_release"})
  public static final class f
    implements a.c
  {
    f(d.g.a.a parama, String paramString1, String paramString2) {}
    
    public final void SP(String paramString)
    {
      AppMethodBeat.i(223648);
      NewSDKInvokeProcess localNewSDKInvokeProcess = this.lTn;
      StringBuilder localStringBuilder = new StringBuilder("fail ");
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      NewSDKInvokeProcess.a(localNewSDKInvokeProcess, d.dW(str, this.lTu));
      AppMethodBeat.o(223648);
    }
    
    public final void btb()
    {
      AppMethodBeat.i(223647);
      this.lTs.invoke();
      AppMethodBeat.o(223647);
    }
    
    public final void onCancel()
    {
      AppMethodBeat.i(223649);
      NewSDKInvokeProcess.a(this.lTn, d.dW("fail:auth canceled", this.lTu));
      AppMethodBeat.o(223649);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.NewSDKInvokeProcess
 * JD-Core Version:    0.7.0.1
 */