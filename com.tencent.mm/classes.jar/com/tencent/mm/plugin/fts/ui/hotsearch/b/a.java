package com.tencent.mm.plugin.fts.ui.hotsearch.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.b.a;
import com.tencent.mm.am.c.a;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.plugin.websearch.webview.e;
import com.tencent.mm.plugin.websearch.webview.o;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.bbj;
import com.tencent.mm.protocal.protobuf.bbk;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.k.b;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.f;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.j;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fts/ui/hotsearch/webview/FTSHotSearchJSApi;", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchQueryJSApi;", "Lcom/tencent/mm/plugin/fts/ui/hotsearch/model/FTSMainState;", "activity", "Landroid/app/Activity;", "uiComponent", "Lcom/tencent/mm/plugin/fts/ui/hotsearch/webview/FTSHotSearchUIComponent;", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/fts/ui/hotsearch/webview/FTSHotSearchUIComponent;)V", "getActivity", "()Landroid/app/Activity;", "getFTSHotData", "", "params", "", "getTeachSearchData", "onActivityStateChanged", "state", "extData", "openSearchWebView", "safeEncode", "given", "Companion", "ui-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends o<com.tencent.mm.plugin.fts.ui.hotsearch.a.a>
{
  public static final a HzS;
  private final Activity activity;
  
  static
  {
    AppMethodBeat.i(265810);
    HzS = new a((byte)0);
    AppMethodBeat.o(265810);
  }
  
  public a(Activity paramActivity, b paramb)
  {
    super((e)paramb);
    AppMethodBeat.i(265796);
    this.activity = paramActivity;
    AppMethodBeat.o(265796);
  }
  
  private static String afS(String paramString)
  {
    AppMethodBeat.i(265804);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(265804);
      return "";
    }
    try
    {
      paramString = Util.nullAsNil(r.cg(paramString));
      s.s(paramString, "try {\n            Util.n…\n            \"\"\n        }");
      AppMethodBeat.o(265804);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = "";
      }
    }
  }
  
  @JavascriptInterface
  public final void getFTSHotData(final String paramString)
  {
    AppMethodBeat.i(265821);
    try
    {
      Object localObject1 = new JSONObject(paramString);
      Log.i("MicroMsg.FTS.FTSHotSearchJSApi", s.X("getFTSHotData params:", paramString));
      Object localObject2 = new bbj();
      paramString = ((JSONObject)localObject1).optString("requestId", "");
      ((bbj)localObject2).ZMb = ((JSONObject)localObject1).optString("json", "");
      localObject1 = new c.a();
      ((c.a)localObject1).funcId = 6289;
      ((c.a)localObject1).uri = "/cgi-bin/micromsg-bin/finderglobalsearchpage";
      ((c.a)localObject1).otE = ((com.tencent.mm.bx.a)localObject2);
      ((c.a)localObject1).otF = ((com.tencent.mm.bx.a)new bbk());
      localObject1 = ((c.a)localObject1).bEF();
      localObject2 = com.tencent.mm.ui.component.k.aeZF;
      localObject2 = ((com.tencent.mm.plugin.mvvmbase.a.a)com.tencent.mm.ui.component.k.nq((Context)this.activity).q(com.tencent.mm.plugin.mvvmbase.a.a.class)).gsu();
      LifecycleScope.launchDefault$default((LifecycleScope)localObject2, null, (kotlin.g.a.m)new b((com.tencent.mm.am.c)localObject1, paramString, (LifecycleScope)localObject2, this, null), 1, null);
      AppMethodBeat.o(265821);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(265821);
    }
  }
  
  @JavascriptInterface
  public final String getTeachSearchData(String paramString)
  {
    AppMethodBeat.i(265838);
    Log.i("MicroMsg.FTS.FTSHotSearchJSApi", "getTeachSearchData = %s.", new Object[] { paramString });
    paramString = getSearchData(paramString);
    AppMethodBeat.o(265838);
    return paramString;
  }
  
  public final void iF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(265831);
    s.u(paramString1, "state");
    s.u(paramString2, "extData");
    Log.i("MicroMsg.FTS.FTSHotSearchJSApi", "onActivityStateChanged, state %s, extData %s", new Object[] { paramString1, paramString2 });
    Object localObject1 = this.WrO;
    if (localObject1 == null) {
      localObject1 = null;
    }
    for (;;)
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("state", paramString1);
      ((JSONObject)localObject2).put("extData", paramString2);
      if (localObject1 != null) {
        j.a((aq)localObject1, (f)bg.kCh(), null, (kotlin.g.a.m)new c(this, (JSONObject)localObject2, null), 2);
      }
      AppMethodBeat.o(265831);
      return;
      localObject1 = ((com.tencent.mm.plugin.websearch.webview.c)localObject1).getWebView();
      if (localObject1 == null)
      {
        localObject1 = null;
      }
      else
      {
        localObject1 = ((WebSearchWebView)localObject1).getContext();
        if (localObject1 == null)
        {
          localObject1 = null;
        }
        else
        {
          localObject2 = com.tencent.mm.ui.component.k.aeZF;
          localObject1 = ((com.tencent.mm.plugin.mvvmbase.a.a)com.tencent.mm.ui.component.k.nq((Context)localObject1).q(com.tencent.mm.plugin.mvvmbase.a.a.class)).gsu();
        }
      }
    }
  }
  
  @JavascriptInterface
  public final String openSearchWebView(String paramString)
  {
    AppMethodBeat.i(265845);
    try
    {
      Log.i("MicroMsg.FTS.FTSHotSearchJSApi", "openSearchWebView %s", new Object[] { String.valueOf(paramString) });
      JSONObject localJSONObject = new JSONObject(paramString);
      int i = localJSONObject.optInt("type", 0);
      Object localObject = afS(new JSONObject((Map)new HashMap()).toString());
      String str1 = localJSONObject.optString("tagId", "");
      String str3 = localJSONObject.optString("sessionId", "");
      int j = localJSONObject.optInt("scene", 0);
      String str2 = localJSONObject.optString("query");
      String str4 = localJSONObject.optString("searchId", "");
      if ("1".equals(localJSONObject.optString("isHomePage", ""))) {}
      for (paramString = "1";; paramString = "0")
      {
        String str5 = localJSONObject.optString("isSug", "1");
        Intent localIntent = new Intent();
        localIntent.putExtra("hardcode_jspermission", (Parcelable)JsapiPermissionWrapper.YxF);
        localIntent.putExtra("hardcode_general_ctrl", (Parcelable)GeneralControlWrapper.YxA);
        localIntent.putExtra("neverGetA8Key", true);
        localIntent.putExtra("key_load_js_without_delay", true);
        localIntent.putExtra("ftsQuery", str2);
        localIntent.putExtra("ftsType", i);
        localIntent.putExtra("ftsbizscene", j);
        localObject = aj.a(j, "1".equals(paramString), i, (String)localObject);
        String str6 = afS(str2);
        s.s(localObject, "urlParams");
        ((Map)localObject).put("query", str6);
        ((Map)localObject).put("searchId", str4);
        ((Map)localObject).put("isHomePage", paramString);
        ((Map)localObject).put("isSug", str5);
        if (!TextUtils.isEmpty((CharSequence)str3))
        {
          ((Map)localObject).put("sessionId", str3);
          localIntent.putExtra("sessionId", str3);
        }
        paramString = localJSONObject.optString("subSessionId", "");
        ((Map)localObject).put("subSessionId", paramString);
        localIntent.putExtra("subSessionId", paramString);
        localIntent.putExtra("rawUrl", aj.bo((Map)localObject));
        localIntent.putExtra("ftsQuery", str2);
        localIntent.putExtra("tabId", str1);
        localIntent.putExtra("key_load_js_without_delay", true);
        localIntent.putExtra("ftsneedkeyboard", false);
        localIntent.putExtra("key_search_icon_and_hint_fix_default", true);
        localIntent.putExtra("ftsInitToSearch", true);
        localIntent.putExtra("hideSearchInput", false);
        com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", localIntent);
        paramString = iqR().toString();
        AppMethodBeat.o(265845);
        return paramString;
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = fqu().toString();
      AppMethodBeat.o(265845);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fts/ui/hotsearch/webview/FTSHotSearchJSApi$Companion;", "", "()V", "TAG", "", "ui-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    b(com.tencent.mm.am.c paramc, String paramString, LifecycleScope paramLifecycleScope, a parama, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(265823);
      paramObject = (kotlin.d.d)new b(this.HzT, paramString, this.HzV, jdField_this, paramd);
      AppMethodBeat.o(265823);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(265815);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(265815);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = com.tencent.mm.am.a.b.ovw;
        paramObject = this.HzT;
        s.s(paramObject, "commReqResp");
        paramObject = b.a.e(paramObject);
        h localh = (h)new b(paramString, this.HzV, jdField_this);
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (paramObject.a(localh, locald) == locala)
        {
          AppMethodBeat.o(265815);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(265815);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.d.b.a.k
      implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
    {
      int label;
      
      a(a parama, JSONObject paramJSONObject, kotlin.d.d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(265791);
        paramObject = (kotlin.d.d)new a(this.HzW, this.HzX, paramd);
        AppMethodBeat.o(265791);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(265785);
        Object localObject = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(265785);
          throw paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.HzW.WrO;
        if (paramObject != null)
        {
          paramObject = paramObject.getWebView();
          if (paramObject != null)
          {
            localObject = this.HzX;
            com.tencent.mm.plugin.websearch.webview.m localm = com.tencent.mm.plugin.websearch.webview.m.WrX;
            localObject = ((JSONObject)localObject).toString();
            s.s(localObject, "returnObj.toString()");
            com.tencent.mm.plugin.websearch.webview.m.a(paramObject, "onFTSHotDataReady", (String)localObject);
          }
        }
        paramObject = ah.aiuX;
        AppMethodBeat.o(265785);
        return paramObject;
      }
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements h<com.tencent.mm.am.a.a<bbk>>
    {
      public b(String paramString, LifecycleScope paramLifecycleScope, a parama) {}
      
      public final Object a(com.tencent.mm.am.a.a<bbk> parama, kotlin.d.d<? super ah> paramd)
      {
        AppMethodBeat.i(265787);
        paramd = (com.tencent.mm.am.a.a)parama;
        Object localObject;
        if (paramd.ovD == com.tencent.mm.am.b.b.ovB)
        {
          localObject = new StringBuilder("getFTSHotData SceneEnd: ").append(paramd.errType).append(' ').append(paramd.errCode).append(' ').append(paramd.errMsg).append(' ');
          parama = (bbk)paramd.ott;
          if (parama != null) {
            break label217;
          }
          parama = null;
          Log.i("MicroMsg.FTS.FTSHotSearchJSApi", parama);
          localObject = new JSONObject();
          ((JSONObject)localObject).put("ret", paramd.errCode);
          ((JSONObject)localObject).put("errMsg", paramd.errMsg);
          ((JSONObject)localObject).put("requestId", this.HzY);
          if ((paramd.errType == 0) && (paramd.errCode == 0))
          {
            parama = (bbk)paramd.ott;
            if (parama != null) {
              break label225;
            }
            parama = "{}";
          }
        }
        for (;;)
        {
          ((JSONObject)localObject).put("json", parama);
          j.a((aq)this.HzZ, (f)bg.kCh(), null, (kotlin.g.a.m)new a.b.a(this.HzW, (JSONObject)localObject, null), 2);
          parama = ah.aiuX;
          AppMethodBeat.o(265787);
          return parama;
          label217:
          parama = parama.ZJq;
          break;
          label225:
          paramd = parama.ZJq;
          parama = paramd;
          if (paramd == null) {
            parama = "{}";
          }
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    c(a parama, JSONObject paramJSONObject, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(265817);
      paramObject = (kotlin.d.d)new c(this.HzW, this.HzX, paramd);
      AppMethodBeat.o(265817);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(265811);
      Object localObject = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(265811);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.HzW.WrO;
      if (paramObject != null)
      {
        paramObject = paramObject.getWebView();
        if (paramObject != null)
        {
          localObject = this.HzX;
          com.tencent.mm.plugin.websearch.webview.m localm = com.tencent.mm.plugin.websearch.webview.m.WrX;
          localObject = ((JSONObject)localObject).toString();
          s.s(localObject, "returnObj.toString()");
          com.tencent.mm.plugin.websearch.webview.m.a(paramObject, "onActivityStateChanged", (String)localObject);
        }
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(265811);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.hotsearch.b.a
 * JD-Core Version:    0.7.0.1
 */