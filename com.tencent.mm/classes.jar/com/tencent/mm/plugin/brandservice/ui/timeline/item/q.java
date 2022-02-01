package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.app.Service;
import android.content.Context;
import android.webkit.JavascriptInterface;
import com.eclipsesource.v8.V8Function;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.al.ag;
import com.tencent.mm.bw.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.plugin.webcanvas.c;
import com.tencent.mm.plugin.webcanvas.c.l;
import com.tencent.mm.plugin.webview.stub.WebViewStubService;
import com.tencent.mm.protocal.protobuf.dnp;
import com.tencent.mm.protocal.protobuf.dnq;
import com.tencent.mm.protocal.protobuf.ot;
import com.tencent.mm.protocal.protobuf.ou;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import d.v;
import java.lang.ref.WeakReference;
import java.util.HashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "context", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext$plugin_brandservice_release", "()Ljava/lang/ref/WeakReference;", "setContext$plugin_brandservice_release", "(Ljava/lang/ref/WeakReference;)V", "msgIds", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getMsgIds$plugin_brandservice_release", "()Ljava/util/HashMap;", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "getStubService", "()Ljava/lang/Class;", "createClientJsApi", "", "canvasId", "data", "WebCanvasJsApiInterfaceRecCard", "plugin-brandservice_release"})
public final class q
  extends c
{
  private final String appId;
  WeakReference<Context> kwC;
  final HashMap<String, Long> ojZ;
  
  public q()
  {
    AppMethodBeat.i(208762);
    this.appId = "wxf337cbaa27790d8e";
    this.ojZ = new HashMap();
    this.kwC = new WeakReference(ak.getContext());
    AppMethodBeat.o(208762);
  }
  
  public final Class<? extends Service> bPH()
  {
    return WebViewStubService.class;
  }
  
  public final Object eN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(208761);
    p.h(paramString1, "canvasId");
    p.h(paramString2, "data");
    paramString1 = new a(paramString1, paramString2);
    AppMethodBeat.o(208761);
    return paramString1;
  }
  
  public final String getAppId()
  {
    return this.appId;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine$WebCanvasJsApiInterfaceRecCard;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine$WebCanvasJsApiInterface;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "canvasId", "", "dataStr", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine;Ljava/lang/String;Ljava/lang/String;)V", "TAG", "adRequest", "", "message", "subType", "callback", "Lcom/eclipsesource/v8/V8Function;", "canvasRequest", "businessId", "", "reqJson", "deleteCanvasCard", "fieldId", "getInfo", "", "key", "onItemClick", "pos", "", "plugin-brandservice_release"})
  final class a
    extends c.l
  {
    final String TAG;
    
    public a(String paramString)
    {
      super(paramString, localObject);
      AppMethodBeat.i(208760);
      this.TAG = "MicroMsg.WebCanvasJsApiInterfaceRecCard";
      AppMethodBeat.o(208760);
    }
    
    @JavascriptInterface
    public final void adRequest(String paramString1, String paramString2, V8Function paramV8Function)
    {
      AppMethodBeat.i(208757);
      p.h(paramString1, "message");
      p.h(paramString2, "subType");
      p.h(paramV8Function, "callback");
      paramV8Function = paramV8Function.twin();
      ae.d(this.TAG, "adRequest %s", new Object[] { paramString1 });
      b.a locala = new b.a();
      dnp localdnp = new dnp();
      localdnp.Gcz = 3;
      localdnp.GcA = paramString1;
      localdnp.HUC = paramString2;
      localdnp.Gcv = System.currentTimeMillis();
      locala.c((a)localdnp);
      locala.d((a)new dnq());
      locala.DN("/cgi-bin/mmbiz-bin/recommend/timelinecard");
      locala.oS(2781);
      locala.oU(0);
      locala.oV(0);
      IPCRunCgi.a(locala.aDS(), (IPCRunCgi.a)new q.a.a(this, paramV8Function));
      AppMethodBeat.o(208757);
    }
    
    @JavascriptInterface
    public final void canvasRequest(Number paramNumber, String paramString, V8Function paramV8Function)
    {
      AppMethodBeat.i(208758);
      p.h(paramNumber, "businessId");
      p.h(paramString, "reqJson");
      p.h(paramV8Function, "callback");
      paramV8Function = paramV8Function.twin();
      Object localObject1 = new b.a();
      ((b.a)localObject1).c((a)new ot());
      ((b.a)localObject1).d((a)new ou());
      ((b.a)localObject1).DN("/cgi-bin/mmbiz-bin/timeline/bizrecommendtimelinecard");
      ((b.a)localObject1).oS(1085);
      localObject1 = ((b.a)localObject1).aDS();
      Object localObject2 = ((com.tencent.mm.ak.b)localObject1).aEU();
      if (localObject2 == null)
      {
        paramNumber = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizRecommendTimeLineCardReq");
        AppMethodBeat.o(208758);
        throw paramNumber;
      }
      localObject2 = (ot)localObject2;
      ((ot)localObject2).Gcz = paramNumber.intValue();
      ((ot)localObject2).GcA = paramString;
      ((ot)localObject2).Gcv = System.currentTimeMillis();
      ae.d(this.TAG, "canvasRequest %s", new Object[] { paramString });
      com.tencent.mm.ak.x.a((com.tencent.mm.ak.b)localObject1, (x.a)new q.a.b(this, paramV8Function));
      AppMethodBeat.o(208758);
    }
    
    @JavascriptInterface
    public final void deleteCanvasCard(String paramString)
    {
      AppMethodBeat.i(208756);
      p.h(paramString, "fieldId");
      ae.i(this.TAG, "deleteCanvasCard ".concat(String.valueOf(paramString)));
      ag.aGv().DU(bu.getLong(paramString, -1L));
      AppMethodBeat.o(208756);
    }
    
    @JavascriptInterface
    public final Object getInfo(String paramString)
    {
      AppMethodBeat.i(208755);
      p.h(paramString, "key");
      switch (paramString.hashCode())
      {
      }
      do
      {
        do
        {
          AppMethodBeat.o(208755);
          return null;
        } while (!paramString.equals("msgId"));
        Long localLong = (Long)q.this.ojZ.get(this.kwD);
        paramString = localLong;
        if (localLong == null) {
          paramString = Long.valueOf(0L);
        }
        paramString = String.valueOf(paramString);
        ae.d(this.TAG, "getInfo canvasId=" + this.kwD + ", msgIds=" + paramString);
        AppMethodBeat.o(208755);
        return paramString;
      } while (!paramString.equals("sessionId"));
      paramString = (com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class);
      if (paramString != null)
      {
        int i = paramString.bOi();
        AppMethodBeat.o(208755);
        return Integer.valueOf(i);
      }
      AppMethodBeat.o(208755);
      return Integer.valueOf(0);
    }
    
    @JavascriptInterface
    public final void onItemClick(String paramString, int paramInt)
    {
      AppMethodBeat.i(208759);
      p.h(paramString, "fieldId");
      long l = bu.getLong(paramString, 0L);
      ae.i(this.TAG, "onItemClick msgId=%s, pos=%d", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt) });
      if ((q.this.kwC.get() instanceof BizTimeLineUI))
      {
        paramString = q.this.kwC.get();
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI");
          AppMethodBeat.o(208759);
          throw paramString;
        }
        ((BizTimeLineUI)paramString).tB(l);
      }
      h.MqF.aO((Runnable)new q.a.c(l));
      AppMethodBeat.o(208759);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.q
 * JD-Core Version:    0.7.0.1
 */