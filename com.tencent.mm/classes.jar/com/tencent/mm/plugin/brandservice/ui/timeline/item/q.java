package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.app.Service;
import android.content.Context;
import android.webkit.JavascriptInterface;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x.a;
import com.tencent.mm.am.ag;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.bx.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.plugin.webcanvas.b.l;
import com.tencent.mm.plugin.webview.stub.WebViewStubService;
import com.tencent.mm.protocal.protobuf.dms;
import com.tencent.mm.protocal.protobuf.dmt;
import com.tencent.mm.protocal.protobuf.or;
import com.tencent.mm.protocal.protobuf.os;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import d.v;
import java.util.HashMap;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext$plugin_brandservice_release", "()Landroid/content/Context;", "setContext$plugin_brandservice_release", "(Landroid/content/Context;)V", "msgIds", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getMsgIds$plugin_brandservice_release", "()Ljava/util/HashMap;", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "getStubService", "()Ljava/lang/Class;", "createClientJsApi", "", "canvasId", "data", "WebCanvasJsApiInterfaceRecCard", "plugin-brandservice_release"})
public final class q
  extends com.tencent.mm.plugin.webcanvas.b
{
  private final String appId;
  Context context;
  final HashMap<String, Long> oej;
  
  public q()
  {
    AppMethodBeat.i(209788);
    this.appId = "wxf337cbaa27790d8e";
    this.oej = new HashMap();
    this.context = aj.getContext();
    AppMethodBeat.o(209788);
  }
  
  public final Class<? extends Service> bOJ()
  {
    return WebViewStubService.class;
  }
  
  public final Object eK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(209787);
    p.h(paramString1, "canvasId");
    p.h(paramString2, "data");
    paramString1 = new a(paramString1, paramString2);
    AppMethodBeat.o(209787);
    return paramString1;
  }
  
  public final String getAppId()
  {
    return this.appId;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine$WebCanvasJsApiInterfaceRecCard;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine$WebCanvasJsApiInterface;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "canvasId", "", "dataStr", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine;Ljava/lang/String;Ljava/lang/String;)V", "TAG", "adRequest", "", "message", "subType", "callback", "Lcom/eclipsesource/v8/V8Function;", "canvasRequest", "businessId", "", "reqJson", "deleteCanvasCard", "fieldId", "getInfo", "", "key", "onItemClick", "pos", "", "plugin-brandservice_release"})
  final class a
    extends b.l
  {
    final String TAG;
    
    public a(String paramString)
    {
      super(paramString, localObject);
      AppMethodBeat.i(209786);
      this.TAG = "MicroMsg.WebCanvasJsApiInterfaceRecCard";
      AppMethodBeat.o(209786);
    }
    
    @JavascriptInterface
    public final void adRequest(String paramString1, String paramString2, final V8Function paramV8Function)
    {
      AppMethodBeat.i(209783);
      p.h(paramString1, "message");
      p.h(paramString2, "subType");
      p.h(paramV8Function, "callback");
      paramV8Function = paramV8Function.twin();
      ad.d(this.TAG, "adRequest %s", new Object[] { paramString1 });
      b.a locala = new b.a();
      dms localdms = new dms();
      localdms.FKa = 3;
      localdms.FKb = paramString1;
      localdms.HAP = paramString2;
      localdms.FJW = System.currentTimeMillis();
      locala.c((a)localdms);
      locala.d((a)new dmt());
      locala.Dl("/cgi-bin/mmbiz-bin/recommend/timelinecard");
      locala.oP(2781);
      locala.oR(0);
      locala.oS(0);
      IPCRunCgi.a(locala.aDC(), (IPCRunCgi.a)new a(this, paramV8Function));
      AppMethodBeat.o(209783);
    }
    
    @JavascriptInterface
    public final void canvasRequest(Number paramNumber, String paramString, final V8Function paramV8Function)
    {
      AppMethodBeat.i(209784);
      p.h(paramNumber, "businessId");
      p.h(paramString, "reqJson");
      p.h(paramV8Function, "callback");
      paramV8Function = paramV8Function.twin();
      Object localObject1 = new b.a();
      ((b.a)localObject1).c((a)new or());
      ((b.a)localObject1).d((a)new os());
      ((b.a)localObject1).Dl("/cgi-bin/mmbiz-bin/timeline/bizrecommendtimelinecard");
      ((b.a)localObject1).oP(1085);
      localObject1 = ((b.a)localObject1).aDC();
      Object localObject2 = ((com.tencent.mm.al.b)localObject1).aEE();
      if (localObject2 == null)
      {
        paramNumber = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizRecommendTimeLineCardReq");
        AppMethodBeat.o(209784);
        throw paramNumber;
      }
      localObject2 = (or)localObject2;
      ((or)localObject2).FKa = paramNumber.intValue();
      ((or)localObject2).FKb = paramString;
      ((or)localObject2).FJW = System.currentTimeMillis();
      ad.d(this.TAG, "canvasRequest %s", new Object[] { paramString });
      com.tencent.mm.al.x.a((com.tencent.mm.al.b)localObject1, (x.a)new b(this, paramV8Function));
      AppMethodBeat.o(209784);
    }
    
    @JavascriptInterface
    public final void deleteCanvasCard(String paramString)
    {
      AppMethodBeat.i(209782);
      p.h(paramString, "fieldId");
      ad.i(this.TAG, "deleteCanvasCard ".concat(String.valueOf(paramString)));
      ag.aGf().Dv(bt.getLong(paramString, -1L));
      AppMethodBeat.o(209782);
    }
    
    @JavascriptInterface
    public final Object getInfo(String paramString)
    {
      AppMethodBeat.i(209781);
      p.h(paramString, "key");
      switch (paramString.hashCode())
      {
      }
      do
      {
        do
        {
          AppMethodBeat.o(209781);
          return null;
        } while (!paramString.equals("msgId"));
        Long localLong = (Long)q.this.oej.get(this.ktn);
        paramString = localLong;
        if (localLong == null) {
          paramString = Long.valueOf(0L);
        }
        paramString = String.valueOf(paramString);
        ad.d(this.TAG, "getInfo canvasId=" + this.ktn + ", msgIds=" + paramString);
        AppMethodBeat.o(209781);
        return paramString;
      } while (!paramString.equals("sessionId"));
      paramString = (com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class);
      if (paramString != null)
      {
        int i = paramString.bNk();
        AppMethodBeat.o(209781);
        return Integer.valueOf(i);
      }
      AppMethodBeat.o(209781);
      return Integer.valueOf(0);
    }
    
    @JavascriptInterface
    public final void onItemClick(String paramString, int paramInt)
    {
      AppMethodBeat.i(209785);
      p.h(paramString, "fieldId");
      long l = bt.getLong(paramString, 0L);
      ad.i(this.TAG, "onItemClick msgId=%s, pos=%d", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt) });
      if ((q.this.context instanceof BizTimeLineUI))
      {
        paramString = q.this.context;
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI");
          AppMethodBeat.o(209785);
          throw paramString;
        }
        ((BizTimeLineUI)paramString).tn(l);
      }
      AppMethodBeat.o(209785);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
    static final class a
      implements IPCRunCgi.a
    {
      a(q.a parama, V8Function paramV8Function) {}
      
      public final void a(int paramInt1, final int paramInt2, final String paramString, com.tencent.mm.al.b paramb)
      {
        AppMethodBeat.i(209777);
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          ad.e(this.oel.TAG, "adRequest callback errType=" + paramInt1 + ", errCode=" + paramInt2);
          this.oel.oek.post((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(209775);
              V8Function localV8Function = this.oen.oem;
              V8Object localV8Object = q.a(this.oen.oel.oek).getGlobalObject();
              V8Array localV8Array = q.a(this.oen.oel.oek).newV8Array();
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("err_code", paramInt2);
              localJSONObject.put("err_msg", "fail");
              localV8Function.call(localV8Object, localV8Array.push(localJSONObject.toString()));
              AppMethodBeat.o(209775);
            }
          });
          AppMethodBeat.o(209777);
          return;
        }
        p.g(paramb, "rr");
        paramb = paramb.aEF();
        paramString = paramb;
        if (!(paramb instanceof dmt)) {
          paramString = null;
        }
        paramString = (dmt)paramString;
        if (paramString == null)
        {
          ad.e(this.oel.TAG, "adRequest resp is null");
          AppMethodBeat.o(209777);
          return;
        }
        this.oel.oek.post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(209776);
            ad.d(this.oen.oel.TAG, "adRequest resp data: " + paramString.FKb);
            V8Function localV8Function = this.oen.oem;
            V8Object localV8Object = q.a(this.oen.oel.oek).getGlobalObject();
            V8Array localV8Array = q.a(this.oen.oel.oek).newV8Array();
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("err_msg", "ok");
            String str2 = paramString.FKb;
            String str1 = str2;
            if (str2 == null) {
              str1 = "";
            }
            localJSONObject.put("data", str1);
            localV8Function.call(localV8Object, localV8Array.push(localJSONObject.toString()));
            AppMethodBeat.o(209776);
          }
        });
        AppMethodBeat.o(209777);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errType", "errCode", "<anonymous parameter 2>", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    static final class b
      implements x.a
    {
      b(q.a parama, V8Function paramV8Function) {}
      
      public final int a(int paramInt1, final int paramInt2, final String paramString, com.tencent.mm.al.b paramb, n paramn)
      {
        AppMethodBeat.i(209780);
        p.h(paramb, "rr");
        p.h(paramn, "<anonymous parameter 4>");
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          this.oel.oek.post((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(209778);
              V8Function localV8Function = this.oep.oem;
              V8Object localV8Object = q.a(this.oep.oel.oek).getGlobalObject();
              V8Array localV8Array = q.a(this.oep.oel.oek).newV8Array();
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("err_code", paramInt2);
              localJSONObject.put("err_msg", "fail");
              localV8Function.call(localV8Object, localV8Array.push(localJSONObject.toString()));
              AppMethodBeat.o(209778);
            }
          });
          AppMethodBeat.o(209780);
          return 0;
        }
        paramb = paramb.aEF();
        paramString = paramb;
        if (!(paramb instanceof os)) {
          paramString = null;
        }
        paramString = (os)paramString;
        if (paramString == null)
        {
          AppMethodBeat.o(209780);
          return 0;
        }
        ad.i(this.oel.TAG, "canvasRequest resp_json=" + paramString.FKb);
        this.oel.oek.post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(209779);
            this.oep.oem.call(q.a(this.oep.oel.oek).getGlobalObject(), q.a(this.oep.oel.oek).newV8Array().push(paramString.FKb));
            AppMethodBeat.o(209779);
          }
        });
        AppMethodBeat.o(209780);
        return 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.q
 * JD-Core Version:    0.7.0.1
 */