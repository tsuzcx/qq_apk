package com.tencent.mm.plugin.account.sdk.model;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import androidx.lifecycle.af;
import androidx.lifecycle.ah.b;
import androidx.lifecycle.ak;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.g.a;
import com.tencent.mm.app.f;
import com.tencent.mm.br.c;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.efd;
import com.tencent.mm.protocal.protobuf.efe;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.event.MvvmEventCenter;
import com.tencent.mm.sdk.event.MvvmEventCenter.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.g;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/account/sdk/model/AccountComplianceReceiver;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/mm/plugin/messenger/foundation/api/INewXmlReceived;", "()V", "currentObj", "Lcom/tencent/mm/plugin/account/sdk/model/AccountComplianceReceiver$ShowPolicyListObj;", "getCurrentObj", "()Lcom/tencent/mm/plugin/account/sdk/model/AccountComplianceReceiver$ShowPolicyListObj;", "setCurrentObj", "(Lcom/tencent/mm/plugin/account/sdk/model/AccountComplianceReceiver$ShowPolicyListObj;)V", "webviewUIDestroyListener", "com/tencent/mm/plugin/account/sdk/model/AccountComplianceReceiver$webviewUIDestroyListener$1", "Lcom/tencent/mm/plugin/account/sdk/model/AccountComplianceReceiver$webviewUIDestroyListener$1;", "doPolicyCgi", "", "isAgree", "", "customInfo", "", "ticket", "policyList", "from", "onCleared", "onNewXmlReceived", "subType", "values", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "Companion", "ShowPolicyListObj", "account-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends af
  implements t
{
  public static final a pXk;
  private final AccountComplianceReceiver.webviewUIDestroyListener.1 pXl;
  b pXm;
  
  static
  {
    AppMethodBeat.i(304722);
    pXk = new a((byte)0);
    AppMethodBeat.o(304722);
  }
  
  public a()
  {
    AppMethodBeat.i(304687);
    this.pXl = new AccountComplianceReceiver.webviewUIDestroyListener.1(this, f.hfK);
    com.tencent.mm.plugin.account.sdk.b.a locala = (com.tencent.mm.plugin.account.sdk.b.a)MvvmEventCenter.Companion.getEvent(com.tencent.mm.plugin.account.sdk.b.a.class);
    com.tencent.mm.kernel.a locala1 = com.tencent.mm.kernel.h.baC().mBP;
    s.s(locala1, "account().accountModelOwner");
    locala.observe((androidx.lifecycle.q)locala1, new a..ExternalSyntheticLambda0(this));
    this.pXl.alive();
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("showpolicylist", (t)this);
    AppMethodBeat.o(304687);
  }
  
  private static final void a(a parama, com.tencent.mm.plugin.account.sdk.b.b paramb)
  {
    AppMethodBeat.i(304703);
    s.u(parama, "this$0");
    s.u(paramb, "data");
    if (paramb.pXd == com.tencent.mm.plugin.account.sdk.b.b.a.pXh)
    {
      c(paramb.pXe, paramb.pXf, paramb.hFb, paramb.pXg, "AgreeEvent");
      b localb = parama.pXm;
      if (localb != null)
      {
        Log.i("MicroMsg.Account.AccountComplianceReceiver", "currentObj: " + localb.pXp + ' ' + localb.pXn);
        if (s.p(paramb.hFb, localb.pXp)) {
          parama.pXm = null;
        }
      }
    }
    AppMethodBeat.o(304703);
  }
  
  public static final a bXO()
  {
    AppMethodBeat.i(304711);
    com.tencent.mm.kernel.h.baC().aZJ();
    Object localObject = new androidx.lifecycle.ah((ak)com.tencent.mm.kernel.h.baC().mBP, (ah.b)new a.a.a()).q(a.class);
    s.s(localObject, "ViewModelProvider(MMKern…anceReceiver::class.java)");
    localObject = (a)localObject;
    AppMethodBeat.o(304711);
    return localObject;
  }
  
  private static void c(int paramInt, final String paramString1, final String paramString2, final String paramString3, final String paramString4)
  {
    AppMethodBeat.i(304696);
    LifecycleScope localLifecycleScope = com.tencent.mm.kernel.h.baC().mBP.mBB;
    if (localLifecycleScope != null) {
      LifecycleScope.launchDefault$default(localLifecycleScope, null, (m)new c(paramInt, paramString1, paramString2, paramString3, paramString4, null), 1, null);
    }
    AppMethodBeat.o(304696);
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(304738);
    this.pXl.dead();
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("showpolicylist", (t)this);
    AppMethodBeat.o(304738);
  }
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, g.a parama)
  {
    AppMethodBeat.i(304737);
    if (s.p(paramString, "showpolicylist"))
    {
      this.pXm = new b();
      if (paramMap != null)
      {
        paramString = this.pXm;
        if (paramString != null) {
          paramString.pXn = ((String)paramMap.get(s.X(".sysmsg.showpolicylist", ".policylist_url")));
        }
        paramString = this.pXm;
        if (paramString != null) {
          paramString.pXo = ((String)paramMap.get(s.X(".sysmsg.showpolicylist", ".policylist_list")));
        }
        paramString = this.pXm;
        if (paramString != null) {
          paramString.pXp = ((String)paramMap.get(s.X(".sysmsg.showpolicylist", ".policylist_ticket")));
        }
        paramString = this.pXm;
        if (paramString != null) {
          paramString.hEl = ((String)paramMap.get(s.X(".sysmsg.showpolicylist", ".deviceid")));
        }
        paramString = this.pXm;
        if (paramString != null) {
          paramString.pXq = ((String)paramMap.get(s.X(".sysmsg.showpolicylist", ".doublecheck_content")));
        }
        paramString = this.pXm;
        if (paramString != null) {
          paramString.pXr = ((String)paramMap.get(s.X(".sysmsg.showpolicylist", ".doublecheck_cancel")));
        }
        paramString = this.pXm;
        if (paramString != null) {
          paramString.pXs = ((String)paramMap.get(s.X(".sysmsg.showpolicylist", ".doublecheck_ok")));
        }
        paramString = this.pXm;
        if (paramString != null) {
          if (Util.getInt((String)paramMap.get(s.X(".sysmsg.showpolicylist", ".hideclosebtn")), 0) != 1) {
            break label743;
          }
        }
      }
    }
    label743:
    for (boolean bool = true;; bool = false)
    {
      paramString.pXt = bool;
      parama = this.pXm;
      if (parama != null)
      {
        paramString = com.tencent.mm.compatible.deviceinfo.q.aPg();
        s.s(paramString, "getMMGUID()");
        paramString = paramString.getBytes(kotlin.n.d.UTF_8);
        s.s(paramString, "(this as java.lang.String).getBytes(charset)");
        paramString = com.tencent.mm.bx.b.cX(paramString);
        paramString.axn(16);
        paramString = Base64.encodeToString(paramString.toByteArray(), 2);
        Log.i("MicroMsg.Account.AccountComplianceReceiver", "onNewXmlReceived url:" + parama.pXn + " list:" + parama.pXo + " ticket:" + parama.pXp + " deviceId::" + parama.hEl + " hideCloseBtn:" + parama.pXt);
        if ((!Util.isNullOrNil(parama.pXn)) && ((Util.isNullOrNil(parama.hEl)) || (s.p(parama.hEl, paramString))))
        {
          Object localObject = new Bundle();
          ((Bundle)localObject).putString("close_dialog_title", "");
          paramMap = parama.pXq;
          paramString = paramMap;
          if (paramMap == null) {
            paramString = "";
          }
          ((Bundle)localObject).putString("close_dialog_msg", paramString);
          paramMap = parama.pXs;
          paramString = paramMap;
          if (paramMap == null) {
            paramString = "";
          }
          ((Bundle)localObject).putString("close_dialog_ok", paramString);
          paramMap = parama.pXr;
          paramString = paramMap;
          if (paramMap == null) {
            paramString = "";
          }
          ((Bundle)localObject).putString("close_dialog_cancel", paramString);
          ((Bundle)localObject).putBoolean("close_dialog_ok_close", false);
          paramString = new Bundle();
          paramString.putInt("key_close_action", 1);
          paramString.putBoolean("hide_close_btn", parama.pXt);
          paramString.putBundle("key_close_data", (Bundle)localObject);
          paramString.putBoolean("hide_option_menu", true);
          paramString.putBoolean("KRightBtn", true);
          paramString.putBoolean("KPopUpTransition", true);
          paramString.putBoolean("open_custom_style_url", true);
          paramMap = MMApplicationContext.getContext();
          parama = parama.pXn;
          localObject = new Intent();
          ((Intent)localObject).putExtra("rawUrl", parama);
          ((Intent)localObject).putExtra("showShare", false);
          ((Intent)localObject).putExtra("show_bottom", false);
          ((Intent)localObject).putExtra("needRedirect", false);
          ((Intent)localObject).putExtra("neverGetA8Key", false);
          ((Intent)localObject).putExtra("hardcode_jspermission", JsapiPermissionWrapper.YxF);
          ((Intent)localObject).putExtra("hardcode_general_ctrl", GeneralControlWrapper.YxA);
          ((Intent)localObject).putExtras(paramString);
          c.b(paramMap, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
        }
      }
      AppMethodBeat.o(304737);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/account/sdk/model/AccountComplianceReceiver$Companion;", "", "()V", "TAG", "", "get", "Lcom/tencent/mm/plugin/account/sdk/model/AccountComplianceReceiver;", "account-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/account/sdk/model/AccountComplianceReceiver$Companion$get$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "account-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements ah.b
    {
      public final <T extends af> T create(Class<T> paramClass)
      {
        AppMethodBeat.i(304715);
        s.u(paramClass, "modelClass");
        paramClass = (af)paramClass.newInstance();
        AppMethodBeat.o(304715);
        return paramClass;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/account/sdk/model/AccountComplianceReceiver$ShowPolicyListObj;", "", "(Lcom/tencent/mm/plugin/account/sdk/model/AccountComplianceReceiver;)V", "deviceId", "", "getDeviceId", "()Ljava/lang/String;", "setDeviceId", "(Ljava/lang/String;)V", "doubleCheckCancel", "getDoubleCheckCancel", "setDoubleCheckCancel", "doubleCheckContent", "getDoubleCheckContent", "setDoubleCheckContent", "doubleCheckOk", "getDoubleCheckOk", "setDoubleCheckOk", "hideCloseBtn", "", "getHideCloseBtn", "()Z", "setHideCloseBtn", "(Z)V", "policyListList", "getPolicyListList", "setPolicyListList", "policyListTicket", "getPolicyListTicket", "setPolicyListTicket", "policyListUrl", "getPolicyListUrl", "setPolicyListUrl", "account-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
  {
    String hEl;
    String pXn;
    String pXo;
    String pXp;
    String pXq;
    String pXr;
    String pXs;
    boolean pXt;
    
    public b()
    {
      AppMethodBeat.i(304708);
      AppMethodBeat.o(304708);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends k
    implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    c(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(304726);
      paramObject = (kotlin.d.d)new c(this.pXv, paramString1, paramString2, paramString3, paramString4, paramd);
      AppMethodBeat.o(304726);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(304720);
      Object localObject = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(304720);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      Log.i("MicroMsg.Account.AccountComplianceReceiver", "doPolicyCgi isAgree:" + this.pXv + " customInfo:" + paramString1 + " ticket:" + paramString2 + " policyList:" + paramString3 + " from:" + paramString4);
      paramObject = new efd();
      if (this.pXv == 1) {}
      for (int i = 1;; i = 2)
      {
        paramObject.YIq = i;
        paramObject.IJG = 1;
        paramObject.abkz = paramString3;
        paramObject.abkA = paramString2;
        paramObject.abkB = paramString1;
        localObject = new c.a();
        ((c.a)localObject).funcId = 5280;
        ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/policyagreementop";
        ((c.a)localObject).otE = ((com.tencent.mm.bx.a)paramObject);
        ((c.a)localObject).otF = ((com.tencent.mm.bx.a)new efe());
        paramObject = ((c.a)localObject).bEF();
        localObject = com.tencent.mm.am.a.b.ovw;
        s.s(paramObject, "commReqResp");
        paramObject = com.tencent.mm.am.a.b.a.e(paramObject);
        localObject = com.tencent.mm.kernel.h.baC().mBP.mBB;
        if (localObject != null) {
          LifecycleScope.launchDefault$default((LifecycleScope)localObject, null, (m)new k(paramObject, this.pXv)
          {
            int label;
            
            public final kotlin.d.d<kotlin.ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
            {
              AppMethodBeat.i(304705);
              paramAnonymousObject = (kotlin.d.d)new 1(this.pXA, this.pXv, this.pXw, this.pXx, this.pXy, paramAnonymousd);
              AppMethodBeat.o(304705);
              return paramAnonymousObject;
            }
            
            public final Object invokeSuspend(Object paramAnonymousObject)
            {
              AppMethodBeat.i(304698);
              kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
              switch (this.label)
              {
              default: 
                paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                AppMethodBeat.o(304698);
                throw paramAnonymousObject;
              case 0: 
                ResultKt.throwOnFailure(paramAnonymousObject);
                paramAnonymousObject = this.pXA;
                kotlinx.coroutines.b.h localh = (kotlinx.coroutines.b.h)new a(this.pXv, this.pXw, this.pXx, this.pXy);
                kotlin.d.d locald = (kotlin.d.d)this;
                this.label = 1;
                if (paramAnonymousObject.a(localh, locald) == locala)
                {
                  AppMethodBeat.o(304698);
                  return locala;
                }
                break;
              case 1: 
                ResultKt.throwOnFailure(paramAnonymousObject);
              }
              paramAnonymousObject = kotlin.ah.aiuX;
              AppMethodBeat.o(304698);
              return paramAnonymousObject;
            }
            
            @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
            public static final class a
              implements kotlinx.coroutines.b.h<com.tencent.mm.am.a.a<efe>>
            {
              public a(int paramInt, String paramString1, String paramString2, String paramString3) {}
              
              public final Object a(com.tencent.mm.am.a.a<efe> parama, kotlin.d.d<? super kotlin.ah> paramd)
              {
                AppMethodBeat.i(304692);
                parama = (com.tencent.mm.am.a.a)parama;
                if (parama.ovD == com.tencent.mm.am.b.b.ovB)
                {
                  Log.i("MicroMsg.Account.AccountComplianceReceiver", "onSceneEnd " + parama.errType + ' ' + parama.errCode + ' ' + parama.errMsg);
                  ((com.tencent.mm.plugin.account.sdk.b.a)MvvmEventCenter.Companion.getEvent(com.tencent.mm.plugin.account.sdk.b.a.class)).publish(new com.tencent.mm.plugin.account.sdk.b.b(com.tencent.mm.plugin.account.sdk.b.b.a.pXi, this.pXB, this.pXC, this.pXD, this.pXE));
                }
                parama = kotlin.ah.aiuX;
                AppMethodBeat.o(304692);
                return parama;
              }
            }
          }, 1, null);
        }
        paramObject = kotlin.ah.aiuX;
        AppMethodBeat.o(304720);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.sdk.model.a
 * JD-Core Version:    0.7.0.1
 */