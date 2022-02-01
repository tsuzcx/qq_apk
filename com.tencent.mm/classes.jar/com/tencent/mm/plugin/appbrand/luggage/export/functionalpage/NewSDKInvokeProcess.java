package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Resp;
import com.tencent.mm.plugin.appbrand.ah.a.a.a;
import com.tencent.mm.plugin.appbrand.permission.a.a.c;
import com.tencent.mm.protocal.protobuf.fek;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import kotlin.t;
import org.json.JSONObject;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/NewSDKInvokeProcess;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalAPIInvokeProcess;", "runtime", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "(Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;)V", "CALLBACK_ID", "", "newSdkInvokeArgs", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "navigateBack", "", "transitiveData", "", "invokeResult", "onCallback", "component", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalComponent;", "callbackId", "data", "onPayAheadCallback", "callbackStr", "performInvoke", "invokeData", "Companion", "NewSdkInvokeBackData", "plugin-appbrand-integration_release"})
final class NewSDKInvokeProcess
  implements o
{
  @Deprecated
  public static final a naN;
  private WechatNativeExtraDataInvokeFunctionalPage naL;
  private final int naM;
  final l nas;
  
  static
  {
    AppMethodBeat.i(228875);
    naN = new a((byte)0);
    AppMethodBeat.o(228875);
  }
  
  public NewSDKInvokeProcess(l paraml)
  {
    AppMethodBeat.i(228874);
    this.nas = paraml;
    this.naM = (hashCode() & 0xFFFF);
    AppMethodBeat.o(228874);
  }
  
  private final void acw(String paramString)
  {
    AppMethodBeat.i(228872);
    Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.NewSDKInvokeProcess", "navigateBack, instance(" + hashCode() + ", invokeResult(" + paramString + ')');
    com.tencent.f.h.RTc.aV((Runnable)new b(this));
    WechatNativeExtraDataInvokeFunctionalPage localWechatNativeExtraDataInvokeFunctionalPage = this.naL;
    if (localWechatNativeExtraDataInvokeFunctionalPage == null) {
      kotlin.g.b.p.btv("newSdkInvokeArgs");
    }
    com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new NewSdkInvokeBackData(localWechatNativeExtraDataInvokeFunctionalPage, paramString), (com.tencent.mm.ipcinvoker.b)c.naR, (com.tencent.mm.ipcinvoker.d)new d(this));
    AppMethodBeat.o(228872);
  }
  
  public final void a(p paramp, int paramInt, String paramString)
  {
    AppMethodBeat.i(228871);
    kotlin.g.b.p.h(paramp, "component");
    kotlin.g.b.p.h(paramString, "data");
    Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.NewSDKInvokeProcess", "onCallback, instance(" + hashCode() + ", callbackId(" + paramInt + "), data(" + paramString + ')');
    if (this.naM == paramInt)
    {
      if (this.naL == null) {
        kotlin.g.b.p.btv("newSdkInvokeArgs");
      }
      acw(paramString);
    }
    AppMethodBeat.o(228871);
  }
  
  public final void acv(final String paramString)
  {
    AppMethodBeat.i(228870);
    kotlin.g.b.p.h(paramString, "invokeData");
    Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.NewSDKInvokeProcess", "performInvoke with instance(" + hashCode() + ") callbackId(" + this.naM + ") appId(" + this.nas.getAppId() + ") data(" + paramString + ')');
    Object localObject1 = new WechatNativeExtraDataInvokeFunctionalPage();
    ((WechatNativeExtraDataInvokeFunctionalPage)localObject1).am(new JSONObject(paramString));
    this.naL = ((WechatNativeExtraDataInvokeFunctionalPage)localObject1);
    paramString = this.naL;
    if (paramString == null) {
      kotlin.g.b.p.btv("newSdkInvokeArgs");
    }
    localObject1 = paramString.nbb;
    paramString = this.naL;
    if (paramString == null) {
      kotlin.g.b.p.btv("newSdkInvokeArgs");
    }
    Object localObject2 = paramString.nbc;
    paramString = this.naL;
    if (paramString == null) {
      kotlin.g.b.p.btv("newSdkInvokeArgs");
    }
    final String str = paramString.les;
    paramString = this.naL;
    if (paramString == null) {
      kotlin.g.b.p.btv("newSdkInvokeArgs");
    }
    paramString = paramString.nbg;
    Object localObject3;
    if (paramString != null)
    {
      localObject3 = this.nas.bOH();
      if (localObject3 == null) {
        kotlin.g.b.p.hyc();
      }
      kotlin.g.b.p.g(localObject3, "runtime.currentPageView!!");
      ((k)localObject3).YO(paramString);
    }
    paramString = this.naL;
    if (paramString == null) {
      kotlin.g.b.p.btv("newSdkInvokeArgs");
    }
    paramString = paramString.nbh;
    if (paramString != null)
    {
      localObject3 = this.nas.bOH();
      if (localObject3 == null) {
        kotlin.g.b.p.hyc();
      }
      kotlin.g.b.p.g(localObject3, "runtime.currentPageView!!");
      ((k)localObject3).acu(paramString);
    }
    paramString = (CharSequence)localObject1;
    if ((paramString == null) || (paramString.length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        paramString = (CharSequence)localObject2;
        if ((paramString != null) && (paramString.length() != 0)) {
          break label333;
        }
      }
    }
    label333:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label338;
      }
      acw("fail invalid args");
      AppMethodBeat.o(228870);
      return;
      i = 0;
      break;
    }
    label338:
    paramString = this.naL;
    if (paramString == null) {
      kotlin.g.b.p.btv("newSdkInvokeArgs");
    }
    if (paramString.cuy) {
      if (this.nas.bsE().Ze((String)localObject1) != null)
      {
        paramString = this.nas.bsE();
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalAppService");
          AppMethodBeat.o(228870);
          throw paramString;
        }
        paramString = (p)paramString;
      }
    }
    for (;;)
    {
      localObject2 = (kotlin.g.a.a)new g(this, paramString, (String)localObject1, (String)localObject2);
      localObject3 = this.naL;
      if (localObject3 == null) {
        kotlin.g.b.p.btv("newSdkInvokeArgs");
      }
      if (3 != ((WechatNativeExtraDataInvokeFunctionalPage)localObject3).nbe) {
        break label819;
      }
      if (paramString != null) {
        break;
      }
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.AppBrandComponentWxaShared");
      AppMethodBeat.o(228870);
      throw paramString;
      paramString = this.nas.bOH();
      if (paramString == null) {
        kotlin.g.b.p.hyc();
      }
      if (paramString.Ze((String)localObject1) != null)
      {
        paramString = this.nas.bOH();
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalPageView");
          AppMethodBeat.o(228870);
          throw paramString;
        }
        paramString = (p)paramString;
      }
      else
      {
        paramString = this.nas.bsE();
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalAppService");
          AppMethodBeat.o(228870);
          throw paramString;
        }
        paramString = (p)paramString;
        continue;
        paramString = this.naL;
        if (paramString == null) {
          kotlin.g.b.p.btv("newSdkInvokeArgs");
        }
        paramString = paramString.nbd;
        if (paramString == null) {}
        do
        {
          do
          {
            for (;;)
            {
              acw(d.en("fail invalid jsapiType", (String)localObject1));
              paramString = (Throwable)new RuntimeException();
              AppMethodBeat.o(228870);
              throw paramString;
              switch (paramString.hashCode())
              {
              }
            }
          } while (!paramString.equals("webview"));
          paramString = this.nas.bsD();
          kotlin.g.b.p.g(paramString, "runtime.pageContainer");
          paramString = paramString.getPageView();
          if (paramString != null) {
            break;
          }
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalPageView");
          AppMethodBeat.o(228870);
          throw paramString;
        } while (!paramString.equals("appservice"));
        paramString = this.nas.bsE();
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalAppService");
          AppMethodBeat.o(228870);
          throw paramString;
        }
        paramString = (p)paramString;
        continue;
        paramString = (p)paramString;
      }
    }
    com.tencent.mm.plugin.appbrand.permission.a.a.a(new com.tencent.mm.plugin.appbrand.permission.a.c((com.tencent.mm.plugin.appbrand.d)paramString, (String)localObject1, null, this.naM), (a.c)new f(this, (kotlin.g.a.a)localObject2, str, (String)localObject1));
    AppMethodBeat.o(228870);
    return;
    label819:
    ((kotlin.g.a.a)localObject2).invoke();
    AppMethodBeat.o(228870);
  }
  
  public final void b(p paramp, int paramInt, String paramString)
  {
    AppMethodBeat.i(228873);
    kotlin.g.b.p.h(paramp, "component");
    kotlin.g.b.p.h(paramString, "callbackStr");
    Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.NewSDKInvokeProcess", "onPayAheadCallback, instance(" + hashCode() + ", callbackId(" + paramInt + "), callbackStr(" + paramString + ')');
    paramp = this.naL;
    if (paramp == null) {
      kotlin.g.b.p.btv("newSdkInvokeArgs");
    }
    com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new NewSdkInvokeBackData(paramp, paramString), (com.tencent.mm.ipcinvoker.b)e.naU, null);
    AppMethodBeat.o(228873);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/NewSDKInvokeProcess$NewSdkInvokeBackData;", "Landroid/os/Parcelable;", "invokeReq", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "backData", "", "(Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;Ljava/lang/String;)V", "getBackData", "()Ljava/lang/String;", "getInvokeReq", "()Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
  static final class NewSdkInvokeBackData
    implements Parcelable
  {
    public static final Parcelable.Creator CREATOR;
    final WechatNativeExtraDataInvokeFunctionalPage naO;
    final String naP;
    
    static
    {
      AppMethodBeat.i(228854);
      CREATOR = new a();
      AppMethodBeat.o(228854);
    }
    
    public NewSdkInvokeBackData(WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, String paramString)
    {
      AppMethodBeat.i(228849);
      this.naO = paramWechatNativeExtraDataInvokeFunctionalPage;
      this.naP = paramString;
      AppMethodBeat.o(228849);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(228852);
      if (this != paramObject)
      {
        if ((paramObject instanceof NewSdkInvokeBackData))
        {
          paramObject = (NewSdkInvokeBackData)paramObject;
          if ((!kotlin.g.b.p.j(this.naO, paramObject.naO)) || (!kotlin.g.b.p.j(this.naP, paramObject.naP))) {}
        }
      }
      else
      {
        AppMethodBeat.o(228852);
        return true;
      }
      AppMethodBeat.o(228852);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(228851);
      Object localObject = this.naO;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.naP;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(228851);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(228850);
      String str = "NewSdkInvokeBackData(invokeReq=" + this.naO + ", backData=" + this.naP + ")";
      AppMethodBeat.o(228850);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(228853);
      kotlin.g.b.p.h(paramParcel, "parcel");
      this.naO.writeToParcel(paramParcel, 0);
      paramParcel.writeString(this.naP);
      AppMethodBeat.o(228853);
    }
    
    @kotlin.l(hxD={1, 1, 16})
    public static final class a
      implements Parcelable.Creator
    {
      public final Object createFromParcel(Parcel paramParcel)
      {
        AppMethodBeat.i(228848);
        kotlin.g.b.p.h(paramParcel, "in");
        paramParcel = new NewSDKInvokeProcess.NewSdkInvokeBackData((WechatNativeExtraDataInvokeFunctionalPage)WechatNativeExtraDataInvokeFunctionalPage.CREATOR.createFromParcel(paramParcel), paramParcel.readString());
        AppMethodBeat.o(228848);
        return paramParcel;
      }
      
      public final Object[] newArray(int paramInt)
      {
        return new NewSDKInvokeProcess.NewSdkInvokeBackData[paramInt];
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/NewSDKInvokeProcess$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(NewSDKInvokeProcess paramNewSDKInvokeProcess) {}
    
    public final void run()
    {
      AppMethodBeat.i(228855);
      Object localObject = this.naQ.nas.getContext();
      if (localObject != null)
      {
        localObject = (Context)localObject;
        MMApplicationContext.getContext().getString(2131755998);
        com.tencent.mm.ui.base.h.a((Context)localObject, MMApplicationContext.getContext().getString(2131768817), false, null);
        AppMethodBeat.o(228855);
        return;
      }
      AppMethodBeat.o(228855);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "data", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/NewSDKInvokeProcess$NewSdkInvokeBackData;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class c<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.b<NewSDKInvokeProcess.NewSdkInvokeBackData, IPCVoid>
  {
    public static final c naR;
    
    static
    {
      AppMethodBeat.i(228862);
      naR = new c();
      AppMethodBeat.o(228862);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class d<T>
    implements com.tencent.mm.ipcinvoker.d<IPCVoid>
  {
    d(NewSDKInvokeProcess paramNewSDKInvokeProcess) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "data", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/NewSDKInvokeProcess$NewSdkInvokeBackData;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class e<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.b<NewSDKInvokeProcess.NewSdkInvokeBackData, IPCVoid>
  {
    public static final e naU;
    
    static
    {
      AppMethodBeat.i(228865);
      naU = new e();
      AppMethodBeat.o(228865);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/NewSDKInvokeProcess$performInvoke$4", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/AppBrandJsApiUserAuth$OnUserAuthResultListener;", "onCancel", "", "onConfirm", "onDeny", "reason", "", "plugin-appbrand-integration_release"})
  public static final class f
    implements a.c
  {
    f(kotlin.g.a.a parama, String paramString1, String paramString2) {}
    
    public final void acx(String paramString)
    {
      AppMethodBeat.i(228867);
      NewSDKInvokeProcess localNewSDKInvokeProcess = this.naQ;
      StringBuilder localStringBuilder = new StringBuilder("fail ");
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      NewSDKInvokeProcess.a(localNewSDKInvokeProcess, d.en(str, this.naX));
      AppMethodBeat.o(228867);
    }
    
    public final void bOI()
    {
      AppMethodBeat.i(228866);
      this.naV.invoke();
      AppMethodBeat.o(228866);
    }
    
    public final void onCancel()
    {
      AppMethodBeat.i(228868);
      NewSDKInvokeProcess.a(this.naQ, d.en("fail:auth canceled", this.naX));
      AppMethodBeat.o(228868);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    g(NewSDKInvokeProcess paramNewSDKInvokeProcess, p paramp, String paramString1, String paramString2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.NewSDKInvokeProcess
 * JD-Core Version:    0.7.0.1
 */