package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.permission.a.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/NewSDKInvokeProcess;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalAPIInvokeProcess;", "runtime", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "(Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;)V", "CALLBACK_ID", "", "newSdkInvokeArgs", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "navigateBack", "", "transitiveData", "", "invokeResult", "onCallback", "component", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalComponent;", "callbackId", "data", "onPayAheadCallback", "callbackStr", "performInvoke", "invokeData", "Companion", "NewSdkInvokeBackData", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class NewSDKInvokeProcess
  implements o
{
  private static final NewSDKInvokeProcess.a tgg;
  private final l tfN;
  private WechatNativeExtraDataInvokeFunctionalPage tgh;
  private final int tgi;
  
  static
  {
    AppMethodBeat.i(320077);
    tgg = new NewSDKInvokeProcess.a((byte)0);
    AppMethodBeat.o(320077);
  }
  
  public NewSDKInvokeProcess(l paraml)
  {
    AppMethodBeat.i(320007);
    this.tfN = paraml;
    this.tgi = (hashCode() & 0xFFFF);
    AppMethodBeat.o(320007);
  }
  
  private static final void a(NewSdkInvokeBackData paramNewSdkInvokeBackData, com.tencent.mm.ipcinvoker.f paramf, b.a parama)
  {
    AppMethodBeat.i(320037);
    a(paramNewSdkInvokeBackData, paramf);
    AppMethodBeat.o(320037);
  }
  
  private static final void a(NewSdkInvokeBackData paramNewSdkInvokeBackData, com.tencent.mm.ipcinvoker.f paramf, Object paramObject)
  {
    AppMethodBeat.i(320040);
    a(paramNewSdkInvokeBackData, paramf);
    AppMethodBeat.o(320040);
  }
  
  private static final void a(NewSDKInvokeProcess paramNewSDKInvokeProcess)
  {
    AppMethodBeat.i(320021);
    s.u(paramNewSDKInvokeProcess, "this$0");
    paramNewSDKInvokeProcess = AndroidContextUtil.castActivityOrNull(paramNewSDKInvokeProcess.tfN.mContext);
    if (paramNewSDKInvokeProcess != null)
    {
      paramNewSDKInvokeProcess = (Context)paramNewSDKInvokeProcess;
      MMApplicationContext.getContext().getString(ba.i.app_tip);
      com.tencent.mm.ui.base.k.a(paramNewSDKInvokeProcess, MMApplicationContext.getContext().getString(ba.i.wxa_redirecting_page_before_navigate_back_app), false, null);
    }
    AppMethodBeat.o(320021);
  }
  
  private static final void a(NewSDKInvokeProcess paramNewSDKInvokeProcess, IPCVoid paramIPCVoid)
  {
    AppMethodBeat.i(320053);
    s.u(paramNewSDKInvokeProcess, "this$0");
    paramNewSDKInvokeProcess.tfN.cBq();
    AppMethodBeat.o(320053);
  }
  
  private final void adw(String paramString)
  {
    AppMethodBeat.i(320014);
    Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.NewSDKInvokeProcess", "navigateBack, instance(" + hashCode() + ", invokeResult(" + paramString + ')');
    h.ahAA.bk(new NewSDKInvokeProcess..ExternalSyntheticLambda5(this));
    WechatNativeExtraDataInvokeFunctionalPage localWechatNativeExtraDataInvokeFunctionalPage2 = this.tgh;
    WechatNativeExtraDataInvokeFunctionalPage localWechatNativeExtraDataInvokeFunctionalPage1 = localWechatNativeExtraDataInvokeFunctionalPage2;
    if (localWechatNativeExtraDataInvokeFunctionalPage2 == null)
    {
      s.bIx("newSdkInvokeArgs");
      localWechatNativeExtraDataInvokeFunctionalPage1 = null;
    }
    com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new NewSdkInvokeBackData(localWechatNativeExtraDataInvokeFunctionalPage1, paramString), (com.tencent.mm.ipcinvoker.d)NewSDKInvokeProcess..ExternalSyntheticLambda0.INSTANCE, new NewSDKInvokeProcess..ExternalSyntheticLambda2(this));
    AppMethodBeat.o(320014);
  }
  
  private static final void b(NewSdkInvokeBackData paramNewSdkInvokeBackData, com.tencent.mm.ipcinvoker.f paramf)
  {
    AppMethodBeat.i(320047);
    Object localObject = a.tfJ;
    localObject = paramNewSdkInvokeBackData.tgj.invokeTicket;
    s.checkNotNull(localObject);
    a.a.eQ((String)localObject, paramNewSdkInvokeBackData.tgk).bFJ().a(new NewSDKInvokeProcess..ExternalSyntheticLambda4(paramNewSdkInvokeBackData, paramf)).a(new NewSDKInvokeProcess..ExternalSyntheticLambda3(paramNewSdkInvokeBackData, paramf));
    AppMethodBeat.o(320047);
  }
  
  private static final void c(NewSdkInvokeBackData paramNewSdkInvokeBackData, com.tencent.mm.ipcinvoker.f paramf)
  {
    AppMethodBeat.i(320059);
    Object localObject = a.tfJ;
    localObject = paramNewSdkInvokeBackData.tgj.invokeTicket;
    s.checkNotNull(localObject);
    a.a.eQ((String)localObject, paramNewSdkInvokeBackData.tgk).bFJ();
    if (paramf != null) {
      com.tencent.mm.ipcinvoker.wx_extension.b.a.b(paramf);
    }
    AppMethodBeat.o(320059);
  }
  
  public final void a(p paramp, int paramInt, String paramString)
  {
    AppMethodBeat.i(320142);
    s.u(paramp, "component");
    s.u(paramString, "data");
    Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.NewSDKInvokeProcess", "onCallback, instance(" + hashCode() + ", callbackId(" + paramInt + "), data(" + paramString + ')');
    if (this.tgi == paramInt)
    {
      if (this.tgh == null) {
        s.bIx("newSdkInvokeArgs");
      }
      adw(paramString);
    }
    AppMethodBeat.o(320142);
  }
  
  public final void adv(String paramString)
  {
    AppMethodBeat.i(320137);
    s.u(paramString, "invokeData");
    Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.NewSDKInvokeProcess", "performInvoke with instance(" + hashCode() + ") callbackId(" + this.tgi + ") appId(" + this.tfN.mAppId + ") data(" + paramString + ')');
    Object localObject1 = new WechatNativeExtraDataInvokeFunctionalPage();
    ((WechatNativeExtraDataInvokeFunctionalPage)localObject1).aA(new JSONObject(paramString));
    paramString = ah.aiuX;
    this.tgh = ((WechatNativeExtraDataInvokeFunctionalPage)localObject1);
    localObject1 = this.tgh;
    paramString = (String)localObject1;
    if (localObject1 == null)
    {
      s.bIx("newSdkInvokeArgs");
      paramString = null;
    }
    final String str1 = paramString.efV;
    localObject1 = this.tgh;
    paramString = (String)localObject1;
    if (localObject1 == null)
    {
      s.bIx("newSdkInvokeArgs");
      paramString = null;
    }
    Object localObject2 = paramString.tgs;
    localObject1 = this.tgh;
    paramString = (String)localObject1;
    if (localObject1 == null)
    {
      s.bIx("newSdkInvokeArgs");
      paramString = null;
    }
    final String str2 = paramString.qYI;
    localObject1 = this.tgh;
    paramString = (String)localObject1;
    if (localObject1 == null)
    {
      s.bIx("newSdkInvokeArgs");
      paramString = null;
    }
    paramString = paramString.tgw;
    if (paramString != null)
    {
      localObject1 = this.tfN.cBr();
      s.checkNotNull(localObject1);
      ((k)localObject1).Zy(paramString);
    }
    localObject1 = this.tgh;
    paramString = (String)localObject1;
    if (localObject1 == null)
    {
      s.bIx("newSdkInvokeArgs");
      paramString = null;
    }
    paramString = paramString.tgx;
    if (paramString != null)
    {
      localObject1 = this.tfN.cBr();
      s.checkNotNull(localObject1);
      ((k)localObject1).tfV = paramString;
    }
    paramString = (CharSequence)str1;
    if ((paramString == null) || (paramString.length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        paramString = (CharSequence)localObject2;
        if ((paramString != null) && (paramString.length() != 0)) {
          break label346;
        }
      }
    }
    label346:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label351;
      }
      adw("fail invalid args");
      AppMethodBeat.o(320137);
      return;
      i = 0;
      break;
    }
    label351:
    localObject1 = this.tgh;
    paramString = (String)localObject1;
    if (localObject1 == null)
    {
      s.bIx("newSdkInvokeArgs");
      paramString = null;
    }
    kotlin.g.a.a locala;
    if (paramString.ekt)
    {
      if (this.tfN.ccO().ZO(str1) != null)
      {
        paramString = this.tfN.ccO();
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalAppService");
          AppMethodBeat.o(320137);
          throw paramString;
        }
        paramString = (e)paramString;
      }
      for (;;)
      {
        paramString = (p)paramString;
        locala = (kotlin.g.a.a)new c(paramString, str1, (String)localObject2, this);
        localObject2 = this.tgh;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("newSdkInvokeArgs");
          localObject1 = null;
        }
        if (3 != ((WechatNativeExtraDataInvokeFunctionalPage)localObject1).tgu) {
          break;
        }
        com.tencent.mm.plugin.appbrand.permission.a.a.a(new com.tencent.mm.plugin.appbrand.permission.a.c((g)paramString, str1, null, null, this.tgi), (a.d)new b(locala, this, str2, str1));
        AppMethodBeat.o(320137);
        return;
        paramString = this.tfN.cBr();
        s.checkNotNull(paramString);
        if (paramString.ZO(str1) != null)
        {
          localObject1 = this.tfN.cBr();
          paramString = (String)localObject1;
          if (localObject1 == null)
          {
            paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalPageView");
            AppMethodBeat.o(320137);
            throw paramString;
          }
        }
        else
        {
          paramString = this.tfN.ccO();
          if (paramString == null)
          {
            paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalAppService");
            AppMethodBeat.o(320137);
            throw paramString;
          }
          paramString = (e)paramString;
        }
      }
    }
    localObject1 = this.tgh;
    paramString = (String)localObject1;
    if (localObject1 == null)
    {
      s.bIx("newSdkInvokeArgs");
      paramString = null;
    }
    paramString = paramString.tgt;
    if (s.p(paramString, "appservice"))
    {
      paramString = this.tfN.ccO();
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalAppService");
        AppMethodBeat.o(320137);
        throw paramString;
      }
    }
    for (paramString = (e)paramString;; paramString = (k)paramString)
    {
      paramString = (p)paramString;
      break;
      if (!s.p(paramString, "webview")) {
        break label750;
      }
      paramString = this.tfN.ccN().getPageView();
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalPageView");
        AppMethodBeat.o(320137);
        throw paramString;
      }
    }
    label750:
    adw(d.eS("fail invalid jsapiType", str1));
    paramString = new RuntimeException();
    AppMethodBeat.o(320137);
    throw paramString;
    locala.invoke();
    AppMethodBeat.o(320137);
  }
  
  public final void b(p paramp, int paramInt, String paramString)
  {
    AppMethodBeat.i(320147);
    s.u(paramp, "component");
    s.u(paramString, "callbackStr");
    Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.NewSDKInvokeProcess", "onPayAheadCallback, instance(" + hashCode() + ", callbackId(" + paramInt + "), callbackStr(" + paramString + ')');
    WechatNativeExtraDataInvokeFunctionalPage localWechatNativeExtraDataInvokeFunctionalPage = this.tgh;
    paramp = localWechatNativeExtraDataInvokeFunctionalPage;
    if (localWechatNativeExtraDataInvokeFunctionalPage == null)
    {
      s.bIx("newSdkInvokeArgs");
      paramp = null;
    }
    com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new NewSdkInvokeBackData(paramp, paramString), (com.tencent.mm.ipcinvoker.d)NewSDKInvokeProcess..ExternalSyntheticLambda1.INSTANCE);
    AppMethodBeat.o(320147);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/NewSDKInvokeProcess$NewSdkInvokeBackData;", "Landroid/os/Parcelable;", "invokeReq", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "backData", "", "(Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;Ljava/lang/String;)V", "getBackData", "()Ljava/lang/String;", "getInvokeReq", "()Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class NewSdkInvokeBackData
    implements Parcelable
  {
    public static final Parcelable.Creator<NewSdkInvokeBackData> CREATOR;
    final WechatNativeExtraDataInvokeFunctionalPage tgj;
    final String tgk;
    
    static
    {
      AppMethodBeat.i(319920);
      CREATOR = (Parcelable.Creator)new a();
      AppMethodBeat.o(319920);
    }
    
    public NewSdkInvokeBackData(WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, String paramString)
    {
      AppMethodBeat.i(319911);
      this.tgj = paramWechatNativeExtraDataInvokeFunctionalPage;
      this.tgk = paramString;
      AppMethodBeat.o(319911);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(319945);
      if (this == paramObject)
      {
        AppMethodBeat.o(319945);
        return true;
      }
      if (!(paramObject instanceof NewSdkInvokeBackData))
      {
        AppMethodBeat.o(319945);
        return false;
      }
      paramObject = (NewSdkInvokeBackData)paramObject;
      if (!s.p(this.tgj, paramObject.tgj))
      {
        AppMethodBeat.o(319945);
        return false;
      }
      if (!s.p(this.tgk, paramObject.tgk))
      {
        AppMethodBeat.o(319945);
        return false;
      }
      AppMethodBeat.o(319945);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(319940);
      int j = this.tgj.hashCode();
      if (this.tgk == null) {}
      for (int i = 0;; i = this.tgk.hashCode())
      {
        AppMethodBeat.o(319940);
        return i + j * 31;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(319927);
      String str = "NewSdkInvokeBackData(invokeReq=" + this.tgj + ", backData=" + this.tgk + ')';
      AppMethodBeat.o(319927);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(319959);
      s.u(paramParcel, "out");
      this.tgj.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.tgk);
      AppMethodBeat.o(319959);
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Parcelable.Creator<NewSDKInvokeProcess.NewSdkInvokeBackData>
    {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/NewSDKInvokeProcess$performInvoke$4", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/AppBrandJsApiUserAuth$OnUserAuthResultListener;", "onCancel", "", "onConfirm", "onDeny", "reason", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements a.d
  {
    b(kotlin.g.a.a<String> parama, NewSDKInvokeProcess paramNewSDKInvokeProcess, String paramString1, String paramString2) {}
    
    public final void adx(String paramString)
    {
      AppMethodBeat.i(320004);
      NewSDKInvokeProcess localNewSDKInvokeProcess = jdField_this;
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      NewSDKInvokeProcess.a(localNewSDKInvokeProcess, d.eS(s.X("fail ", str), str1));
      AppMethodBeat.o(320004);
    }
    
    public final void bSs()
    {
      AppMethodBeat.i(319995);
      this.tgl.invoke();
      AppMethodBeat.o(319995);
    }
    
    public final void onCancel()
    {
      AppMethodBeat.i(320010);
      NewSDKInvokeProcess.a(jdField_this, d.eS("fail:auth canceled", str1));
      AppMethodBeat.o(320010);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<String>
  {
    c(p paramp, String paramString1, String paramString2, NewSDKInvokeProcess paramNewSDKInvokeProcess)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.NewSDKInvokeProcess
 * JD-Core Version:    0.7.0.1
 */