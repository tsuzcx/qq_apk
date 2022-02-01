package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c.a;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Resp;
import com.tencent.mm.plugin.appbrand.ai.a.a.a;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.permission.a.a.c;
import com.tencent.mm.protocal.protobuf.fpl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import kotlin.g.a.b;
import kotlin.t;
import kotlin.x;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/NewSDKInvokeProcess;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalAPIInvokeProcess;", "runtime", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "(Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;)V", "CALLBACK_ID", "", "newSdkInvokeArgs", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "navigateBack", "", "transitiveData", "", "invokeResult", "onCallback", "component", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalComponent;", "callbackId", "data", "onPayAheadCallback", "callbackStr", "performInvoke", "invokeData", "Companion", "NewSdkInvokeBackData", "plugin-appbrand-integration_release"})
final class NewSDKInvokeProcess
  implements o
{
  @Deprecated
  public static final a qbc;
  final l qaH;
  private WechatNativeExtraDataInvokeFunctionalPage qba;
  private final int qbb;
  
  static
  {
    AppMethodBeat.i(275982);
    qbc = new a((byte)0);
    AppMethodBeat.o(275982);
  }
  
  public NewSDKInvokeProcess(l paraml)
  {
    AppMethodBeat.i(275981);
    this.qaH = paraml;
    this.qbb = (hashCode() & 0xFFFF);
    AppMethodBeat.o(275981);
  }
  
  private final void akq(String paramString)
  {
    AppMethodBeat.i(275979);
    Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.NewSDKInvokeProcess", "navigateBack, instance(" + hashCode() + ", invokeResult(" + paramString + ')');
    com.tencent.e.h.ZvG.bc((Runnable)new b(this));
    WechatNativeExtraDataInvokeFunctionalPage localWechatNativeExtraDataInvokeFunctionalPage = this.qba;
    if (localWechatNativeExtraDataInvokeFunctionalPage == null) {
      kotlin.g.b.p.bGy("newSdkInvokeArgs");
    }
    com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new NewSdkInvokeBackData(localWechatNativeExtraDataInvokeFunctionalPage, paramString), (com.tencent.mm.ipcinvoker.d)c.qbg, (f)new d(this));
    AppMethodBeat.o(275979);
  }
  
  public final void a(p paramp, int paramInt, String paramString)
  {
    AppMethodBeat.i(275978);
    kotlin.g.b.p.k(paramp, "component");
    kotlin.g.b.p.k(paramString, "data");
    Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.NewSDKInvokeProcess", "onCallback, instance(" + hashCode() + ", callbackId(" + paramInt + "), data(" + paramString + ')');
    if (this.qbb == paramInt)
    {
      if (this.qba == null) {
        kotlin.g.b.p.bGy("newSdkInvokeArgs");
      }
      akq(paramString);
    }
    AppMethodBeat.o(275978);
  }
  
  public final void akp(final String paramString)
  {
    AppMethodBeat.i(275976);
    kotlin.g.b.p.k(paramString, "invokeData");
    Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.NewSDKInvokeProcess", "performInvoke with instance(" + hashCode() + ") callbackId(" + this.qbb + ") appId(" + this.qaH.getAppId() + ") data(" + paramString + ')');
    Object localObject1 = new WechatNativeExtraDataInvokeFunctionalPage();
    ((WechatNativeExtraDataInvokeFunctionalPage)localObject1).aq(new JSONObject(paramString));
    this.qba = ((WechatNativeExtraDataInvokeFunctionalPage)localObject1);
    paramString = this.qba;
    if (paramString == null) {
      kotlin.g.b.p.bGy("newSdkInvokeArgs");
    }
    localObject1 = paramString.qbq;
    paramString = this.qba;
    if (paramString == null) {
      kotlin.g.b.p.bGy("newSdkInvokeArgs");
    }
    Object localObject2 = paramString.qbr;
    paramString = this.qba;
    if (paramString == null) {
      kotlin.g.b.p.bGy("newSdkInvokeArgs");
    }
    final String str = paramString.nYF;
    paramString = this.qba;
    if (paramString == null) {
      kotlin.g.b.p.bGy("newSdkInvokeArgs");
    }
    paramString = paramString.qbv;
    Object localObject3;
    if (paramString != null)
    {
      localObject3 = this.qaH.caX();
      if (localObject3 == null) {
        kotlin.g.b.p.iCn();
      }
      kotlin.g.b.p.j(localObject3, "runtime.currentPageView!!");
      ((k)localObject3).agC(paramString);
    }
    paramString = this.qba;
    if (paramString == null) {
      kotlin.g.b.p.bGy("newSdkInvokeArgs");
    }
    paramString = paramString.qbw;
    if (paramString != null)
    {
      localObject3 = this.qaH.caX();
      if (localObject3 == null) {
        kotlin.g.b.p.iCn();
      }
      kotlin.g.b.p.j(localObject3, "runtime.currentPageView!!");
      ((k)localObject3).ako(paramString);
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
      akq("fail invalid args");
      AppMethodBeat.o(275976);
      return;
      i = 0;
      break;
    }
    label338:
    paramString = this.qba;
    if (paramString == null) {
      kotlin.g.b.p.bGy("newSdkInvokeArgs");
    }
    if (paramString.csz) {
      if (this.qaH.bDA().agR((String)localObject1) != null)
      {
        paramString = this.qaH.bDA();
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalAppService");
          AppMethodBeat.o(275976);
          throw paramString;
        }
        paramString = (p)paramString;
      }
    }
    for (;;)
    {
      localObject2 = (kotlin.g.a.a)new g(this, paramString, (String)localObject1, (String)localObject2);
      localObject3 = this.qba;
      if (localObject3 == null) {
        kotlin.g.b.p.bGy("newSdkInvokeArgs");
      }
      if (3 != ((WechatNativeExtraDataInvokeFunctionalPage)localObject3).qbt) {
        break label819;
      }
      if (paramString != null) {
        break;
      }
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.AppBrandComponentWxaShared");
      AppMethodBeat.o(275976);
      throw paramString;
      paramString = this.qaH.caX();
      if (paramString == null) {
        kotlin.g.b.p.iCn();
      }
      if (paramString.agR((String)localObject1) != null)
      {
        paramString = this.qaH.caX();
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalPageView");
          AppMethodBeat.o(275976);
          throw paramString;
        }
        paramString = (p)paramString;
      }
      else
      {
        paramString = this.qaH.bDA();
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalAppService");
          AppMethodBeat.o(275976);
          throw paramString;
        }
        paramString = (p)paramString;
        continue;
        paramString = this.qba;
        if (paramString == null) {
          kotlin.g.b.p.bGy("newSdkInvokeArgs");
        }
        paramString = paramString.qbs;
        if (paramString == null) {}
        do
        {
          do
          {
            for (;;)
            {
              akq(d.eB("fail invalid jsapiType", (String)localObject1));
              paramString = (Throwable)new RuntimeException();
              AppMethodBeat.o(275976);
              throw paramString;
              switch (paramString.hashCode())
              {
              }
            }
          } while (!paramString.equals("webview"));
          paramString = this.qaH.bDz();
          kotlin.g.b.p.j(paramString, "runtime.pageContainer");
          paramString = paramString.getPageView();
          if (paramString != null) {
            break;
          }
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalPageView");
          AppMethodBeat.o(275976);
          throw paramString;
        } while (!paramString.equals("appservice"));
        paramString = this.qaH.bDA();
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalAppService");
          AppMethodBeat.o(275976);
          throw paramString;
        }
        paramString = (p)paramString;
        continue;
        paramString = (p)paramString;
      }
    }
    com.tencent.mm.plugin.appbrand.permission.a.a.a(new com.tencent.mm.plugin.appbrand.permission.a.c((g)paramString, (String)localObject1, null, this.qbb), (a.c)new f(this, (kotlin.g.a.a)localObject2, str, (String)localObject1));
    AppMethodBeat.o(275976);
    return;
    label819:
    ((kotlin.g.a.a)localObject2).invoke();
    AppMethodBeat.o(275976);
  }
  
  public final void b(p paramp, int paramInt, String paramString)
  {
    AppMethodBeat.i(275980);
    kotlin.g.b.p.k(paramp, "component");
    kotlin.g.b.p.k(paramString, "callbackStr");
    Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.NewSDKInvokeProcess", "onPayAheadCallback, instance(" + hashCode() + ", callbackId(" + paramInt + "), callbackStr(" + paramString + ')');
    paramp = this.qba;
    if (paramp == null) {
      kotlin.g.b.p.bGy("newSdkInvokeArgs");
    }
    com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new NewSdkInvokeBackData(paramp, paramString), (com.tencent.mm.ipcinvoker.d)e.qbj, null);
    AppMethodBeat.o(275980);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/NewSDKInvokeProcess$NewSdkInvokeBackData;", "Landroid/os/Parcelable;", "invokeReq", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "backData", "", "(Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;Ljava/lang/String;)V", "getBackData", "()Ljava/lang/String;", "getInvokeReq", "()Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
  static final class NewSdkInvokeBackData
    implements Parcelable
  {
    public static final Parcelable.Creator CREATOR;
    final WechatNativeExtraDataInvokeFunctionalPage qbd;
    final String qbe;
    
    static
    {
      AppMethodBeat.i(275402);
      CREATOR = new a();
      AppMethodBeat.o(275402);
    }
    
    public NewSdkInvokeBackData(WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, String paramString)
    {
      AppMethodBeat.i(275396);
      this.qbd = paramWechatNativeExtraDataInvokeFunctionalPage;
      this.qbe = paramString;
      AppMethodBeat.o(275396);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(275399);
      if (this != paramObject)
      {
        if ((paramObject instanceof NewSdkInvokeBackData))
        {
          paramObject = (NewSdkInvokeBackData)paramObject;
          if ((!kotlin.g.b.p.h(this.qbd, paramObject.qbd)) || (!kotlin.g.b.p.h(this.qbe, paramObject.qbe))) {}
        }
      }
      else
      {
        AppMethodBeat.o(275399);
        return true;
      }
      AppMethodBeat.o(275399);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(275398);
      Object localObject = this.qbd;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.qbe;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(275398);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(275397);
      String str = "NewSdkInvokeBackData(invokeReq=" + this.qbd + ", backData=" + this.qbe + ")";
      AppMethodBeat.o(275397);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(275401);
      kotlin.g.b.p.k(paramParcel, "parcel");
      this.qbd.writeToParcel(paramParcel, 0);
      paramParcel.writeString(this.qbe);
      AppMethodBeat.o(275401);
    }
    
    @kotlin.l(iBK={1, 1, 16})
    public static final class a
      implements Parcelable.Creator
    {
      public final Object createFromParcel(Parcel paramParcel)
      {
        AppMethodBeat.i(273407);
        kotlin.g.b.p.k(paramParcel, "in");
        paramParcel = new NewSDKInvokeProcess.NewSdkInvokeBackData((WechatNativeExtraDataInvokeFunctionalPage)WechatNativeExtraDataInvokeFunctionalPage.CREATOR.createFromParcel(paramParcel), paramParcel.readString());
        AppMethodBeat.o(273407);
        return paramParcel;
      }
      
      public final Object[] newArray(int paramInt)
      {
        return new NewSDKInvokeProcess.NewSdkInvokeBackData[paramInt];
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/NewSDKInvokeProcess$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(NewSDKInvokeProcess paramNewSDKInvokeProcess) {}
    
    public final void run()
    {
      AppMethodBeat.i(252819);
      Object localObject = this.qbf.qaH.getContext();
      if (localObject != null)
      {
        localObject = (Context)localObject;
        MMApplicationContext.getContext().getString(au.i.app_tip);
        com.tencent.mm.ui.base.h.a((Context)localObject, MMApplicationContext.getContext().getString(au.i.wxa_redirecting_page_before_navigate_back_app), false, null);
        AppMethodBeat.o(252819);
        return;
      }
      AppMethodBeat.o(252819);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "data", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/NewSDKInvokeProcess$NewSdkInvokeBackData;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class c<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.d<NewSDKInvokeProcess.NewSdkInvokeBackData, IPCVoid>
  {
    public static final c qbg;
    
    static
    {
      AppMethodBeat.i(280528);
      qbg = new c();
      AppMethodBeat.o(280528);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class d<T>
    implements f<IPCVoid>
  {
    d(NewSDKInvokeProcess paramNewSDKInvokeProcess) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "data", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/NewSDKInvokeProcess$NewSdkInvokeBackData;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class e<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.d<NewSDKInvokeProcess.NewSdkInvokeBackData, IPCVoid>
  {
    public static final e qbj;
    
    static
    {
      AppMethodBeat.i(276117);
      qbj = new e();
      AppMethodBeat.o(276117);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/NewSDKInvokeProcess$performInvoke$4", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/AppBrandJsApiUserAuth$OnUserAuthResultListener;", "onCancel", "", "onConfirm", "onDeny", "reason", "", "plugin-appbrand-integration_release"})
  public static final class f
    implements a.c
  {
    f(kotlin.g.a.a parama, String paramString1, String paramString2) {}
    
    public final void akr(String paramString)
    {
      AppMethodBeat.i(272078);
      NewSDKInvokeProcess localNewSDKInvokeProcess = this.qbf;
      StringBuilder localStringBuilder = new StringBuilder("fail ");
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      NewSDKInvokeProcess.a(localNewSDKInvokeProcess, d.eB(str, this.qbm));
      AppMethodBeat.o(272078);
    }
    
    public final void caY()
    {
      AppMethodBeat.i(272077);
      this.qbk.invoke();
      AppMethodBeat.o(272077);
    }
    
    public final void onCancel()
    {
      AppMethodBeat.i(272079);
      NewSDKInvokeProcess.a(this.qbf, d.eB("fail:auth canceled", this.qbm));
      AppMethodBeat.o(272079);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.NewSDKInvokeProcess
 * JD-Core Version:    0.7.0.1
 */