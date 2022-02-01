package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.luggage.h.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.service.SupportProcessIPCService;
import com.tencent.mm.modelappbrand.ab;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.modelappbrand.g;
import com.tencent.mm.modelappbrand.h;
import com.tencent.mm.modelappbrand.p;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.w;
import com.tencent.mm.plugin.appbrand.appcache.ae;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer;
import com.tencent.mm.plugin.appbrand.dynamic.b.d;
import com.tencent.mm.plugin.appbrand.dynamic.h.a.a;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.1;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView.3;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IOnUncaughtExceptionListener;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  implements View.OnAttachStateChangeListener, g, a.a, MMUncaughtExceptionHandler.IOnUncaughtExceptionListener
{
  private volatile com.tencent.mm.modelappbrand.e lmA;
  private volatile b lmH;
  private volatile e lmI;
  private String mToken;
  
  private com.tencent.mm.modelappbrand.e bBW()
  {
    AppMethodBeat.i(121231);
    if (this.lmA == null) {}
    try
    {
      if (this.lmA == null) {
        this.lmA = new a();
      }
      com.tencent.mm.modelappbrand.e locale = this.lmA;
      AppMethodBeat.o(121231);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(121231);
    }
  }
  
  public final void Lp(String paramString)
  {
    AppMethodBeat.i(121230);
    com.tencent.mm.plugin.appbrand.dynamic.h.a.bCk().lpd.remove(paramString);
    Object localObject1 = com.tencent.mm.plugin.appbrand.dynamic.h.a.bCk();
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      localObject1 = bBW().ci(paramString);
      if ((localObject1 != null) && (!((Set)localObject1).isEmpty())) {
        break;
      }
      AppMethodBeat.o(121230);
      return;
      ((com.tencent.mm.plugin.appbrand.dynamic.h.a)localObject1).lpe.remove(paramString);
    }
    localObject1 = ((Set)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (View)((Iterator)localObject1).next();
      if ((localObject2 != null) && ((localObject2 instanceof IPCDynamicPageView)))
      {
        localObject2 = (IPCDynamicPageView)localObject2;
        com.tencent.mm.sdk.platformtools.Log.v("MicroMsg.DynamicPageService", "onUnbindAllView, do unBindView(%s)", new Object[] { ((IPCDynamicPageView)localObject2).getExtId() });
        ((IPCDynamicPageView)localObject2).removeOnAttachStateChangeListener(this);
        ((IPCDynamicPageView)localObject2).detach();
      }
    }
    if (bBW().aXG().isEmpty()) {
      com.tencent.mm.ch.a.post(new a.1());
    }
    i.bBL().Yo(paramString);
    AppMethodBeat.o(121230);
  }
  
  public final String a(String paramString, View paramView, Bundle paramBundle, ab paramab)
  {
    AppMethodBeat.i(121227);
    if (!(paramView instanceof IPCDynamicPageView))
    {
      AppMethodBeat.o(121227);
      return "";
    }
    com.tencent.mm.plugin.expansions.a.cMr();
    Object localObject1 = com.tencent.mm.plugin.appbrand.ac.n.Bs(System.nanoTime());
    com.tencent.mm.plugin.appbrand.collector.c.c("widget_launch", (String)localObject1, "on_bind_view", true);
    com.tencent.mm.plugin.appbrand.collector.c.cQ((String)localObject1, "init_finish");
    IPCDynamicPageView localIPCDynamicPageView = (IPCDynamicPageView)paramView;
    Object localObject2 = null;
    if (paramBundle != null)
    {
      paramView = paramBundle.getString("app_id");
      localObject2 = paramBundle.getString("msg_id");
      paramBundle.putString("__session_id", paramString);
      paramBundle.putLong("__on_bind_nano_time", System.nanoTime());
      paramBundle.putString("__session_id", (String)localObject1);
      paramBundle.putParcelable("__cost_time_session", com.tencent.mm.plugin.appbrand.collector.c.WJ((String)localObject1));
    }
    for (;;)
    {
      Object localObject4 = paramBundle.getString("wxa_unique_id");
      localObject1 = localObject4;
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        localObject1 = WxaWidgetInitializer.da(paramView, (String)localObject2);
      }
      localObject2 = paramBundle.getString("exec_process_name", SupportProcessIPCService.dkO);
      i.bBL().cZ((String)localObject1, (String)localObject2);
      u.i("MicroMsg.DynamicPageService", "onBindView(%s)", new Object[] { localObject1 });
      com.tencent.mm.plugin.appbrand.dynamic.e.bBI().c((String)localObject1, localIPCDynamicPageView);
      localObject4 = (String)l.dN(paramBundle.getString("msg_path", "")).get("widgetData");
      if (!TextUtils.isEmpty((CharSequence)localObject4)) {}
      try
      {
        localObject4 = new JSONObject(URLDecoder.decode((String)localObject4));
        if ((((JSONObject)localObject4).has("render_data")) && (((JSONObject)localObject4).getJSONObject("render_data").has("actions")))
        {
          u.i("MicroMsg.DynamicPageService", "get render_data and begin predraw", new Object[0]);
          Object localObject5 = ((JSONObject)localObject4).getJSONObject("render_data").getJSONArray("actions");
          localObject4 = new JSONObject();
          ((JSONObject)localObject4).put("actions", localObject5);
          ((JSONObject)localObject4).put("reserve", false);
          localObject5 = ((JSONObject)localObject4).toString();
          ((JSONObject)localObject4).put("__invoke_jsapi_timestamp", System.currentTimeMillis());
          com.tencent.mm.plugin.appbrand.dynamic.d.b.b localb = new com.tencent.mm.plugin.appbrand.dynamic.d.b.b();
          localb.a((String)localObject2, (String)localObject1, (JSONObject)localObject4, null, null, com.tencent.mm.plugin.appbrand.dynamic.d.b.a.bH((String)localObject1, paramBundle.getInt("draw_strategy")), (String)localObject5);
          com.tencent.mm.plugin.appbrand.dynamic.d.b.a.bH((String)localObject1, paramBundle.getInt("draw_strategy")).a(localb);
          localObject2 = (w)paramab.LA("WidgetPreDrawCallback");
          if (localObject2 != null) {
            ((w)localObject2).aXT();
          }
          u.Ls((String)localObject1);
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.DynamicPageService", localJSONException, "", new Object[0]);
          continue;
          Object localObject3 = null;
          continue;
          paramView.lpe.put(paramString, this);
        }
      }
      localIPCDynamicPageView.removeOnAttachStateChangeListener(this);
      localIPCDynamicPageView.addOnAttachStateChangeListener(this);
      Assert.assertNotNull(localObject1);
      localIPCDynamicPageView.lpP = System.currentTimeMillis();
      if (paramab != null)
      {
        localObject2 = paramab.aXU();
        if ((localIPCDynamicPageView.gIx != null) && (!((String)localObject1).equals(localIPCDynamicPageView.gIx))) {
          localIPCDynamicPageView.cleanup();
        }
        if ((localObject2 != null) && ((!((String)localObject1).equals(localIPCDynamicPageView.gIx)) || (!localIPCDynamicPageView.gPl))) {
          ((h)localObject2).L(localIPCDynamicPageView, 0);
        }
        localIPCDynamicPageView.gPl = false;
        u.i("MicroMsg.IPCDynamicPageView", "attach (%s)", new Object[] { localObject1 });
        IPCDynamicPageView.llG.post(new IPCDynamicPageView.3(localIPCDynamicPageView, (String)localObject1, paramBundle, paramab, paramView));
        com.tencent.mm.sdk.platformtools.Log.v("MicroMsg.DynamicPageService", "onBindView(%s)", new Object[] { localObject1 });
        paramView = com.tencent.mm.plugin.appbrand.dynamic.h.a.bCk();
        if ((paramString != null) && (paramString.length() != 0)) {
          break label658;
        }
        com.tencent.mm.plugin.appbrand.dynamic.h.a.bCk().c(paramString, localIPCDynamicPageView);
        bBW().d(paramString, localIPCDynamicPageView);
        AppMethodBeat.o(121227);
        return localObject1;
      }
      label658:
      paramView = null;
    }
  }
  
  public final void a(String paramString, View paramView)
  {
    AppMethodBeat.i(121228);
    if (!(paramView instanceof IPCDynamicPageView))
    {
      AppMethodBeat.o(121228);
      return;
    }
    paramView = (IPCDynamicPageView)paramView;
    com.tencent.mm.sdk.platformtools.Log.v("MicroMsg.DynamicPageService", "onUnBindView(%s)", new Object[] { paramView.getExtId() });
    paramView.removeOnAttachStateChangeListener(this);
    bBW().e(paramString, paramView);
    com.tencent.mm.plugin.appbrand.dynamic.h.a.bCk().b(paramString, paramView);
    paramView.detach();
    i.bBL().Yo(paramString);
    AppMethodBeat.o(121228);
  }
  
  public final void a(String paramString, IPCDynamicPageView paramIPCDynamicPageView)
  {
    AppMethodBeat.i(121237);
    com.tencent.mm.sdk.platformtools.Log.v("MicroMsg.DynamicPageService", "onOverLength(sessionId : %s, view : %s)", new Object[] { paramString, paramIPCDynamicPageView.getExtId() });
    a(paramString, paramIPCDynamicPageView);
    AppMethodBeat.o(121237);
  }
  
  public final f aXH()
  {
    AppMethodBeat.i(121232);
    if (this.lmH == null) {}
    try
    {
      if (this.lmH == null) {
        this.lmH = new b(bBW());
      }
      b localb = this.lmH;
      AppMethodBeat.o(121232);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(121232);
    }
  }
  
  public final com.tencent.mm.modelappbrand.n aXI()
  {
    AppMethodBeat.i(121233);
    if (this.lmI == null) {}
    try
    {
      if (this.lmI == null) {
        this.lmI = new e();
      }
      e locale = this.lmI;
      AppMethodBeat.o(121233);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(121233);
    }
  }
  
  public final View cU(Context paramContext)
  {
    AppMethodBeat.i(121226);
    paramContext = new IPCDynamicPageView(paramContext);
    AppMethodBeat.o(121226);
    return paramContext;
  }
  
  public final void cq(View paramView)
  {
    AppMethodBeat.i(121229);
    if (!(paramView instanceof IPCDynamicPageView))
    {
      AppMethodBeat.o(121229);
      return;
    }
    ((IPCDynamicPageView)paramView).ws(2104);
    AppMethodBeat.o(121229);
  }
  
  public final p cr(View paramView)
  {
    if ((paramView instanceof IPCDynamicPageView)) {
      return (p)paramView;
    }
    return null;
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(121224);
    if ((this.mToken != null) && (this.mToken.length() != 0)) {
      shutdown();
    }
    this.mToken = ("Token#" + System.nanoTime());
    MMUncaughtExceptionHandler.addOnUncaughtExceptionListener(this);
    ae.a(new d());
    AppMethodBeat.o(121224);
  }
  
  public final void onViewAttachedToWindow(View paramView)
  {
    AppMethodBeat.i(121235);
    if ((paramView == null) || (!(paramView instanceof IPCDynamicPageView)))
    {
      AppMethodBeat.o(121235);
      return;
    }
    paramView = (IPCDynamicPageView)paramView;
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.DynamicPageService", "onViewAttachedToWindow(%s)", new Object[] { paramView.getExtId() });
    paramView.onResume();
    AppMethodBeat.o(121235);
  }
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    AppMethodBeat.i(121236);
    if ((paramView == null) || (!(paramView instanceof IPCDynamicPageView)))
    {
      AppMethodBeat.o(121236);
      return;
    }
    paramView = (IPCDynamicPageView)paramView;
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.DynamicPageService", "onViewDetachedFromWindow(%s)", new Object[] { paramView.getExtId() });
    paramView.onPause();
    AppMethodBeat.o(121236);
  }
  
  public final void shutdown()
  {
    AppMethodBeat.i(121225);
    Object localObject1 = bBW().aXG();
    if ((localObject1 == null) || (((Map)localObject1).isEmpty()))
    {
      AppMethodBeat.o(121225);
      return;
    }
    localObject1 = new LinkedHashSet(((Map)localObject1).keySet()).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if ((localObject2 != null) && ((localObject2 instanceof String))) {
        Lp((String)localObject2);
      }
    }
    AppMethodBeat.o(121225);
  }
  
  public final void uncaughtException(MMUncaughtExceptionHandler paramMMUncaughtExceptionHandler, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(192517);
    com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.DynamicPageService", "uncaughtException(%s)", new Object[] { android.util.Log.getStackTraceString(paramThrowable) });
    shutdown();
    AppMethodBeat.o(192517);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.a.c
 * JD-Core Version:    0.7.0.1
 */