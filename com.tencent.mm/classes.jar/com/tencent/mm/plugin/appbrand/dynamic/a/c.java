package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.luggage.h.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.ab;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.modelappbrand.g;
import com.tencent.mm.modelappbrand.h;
import com.tencent.mm.modelappbrand.n;
import com.tencent.mm.modelappbrand.p;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.w;
import com.tencent.mm.plugin.appbrand.aa.m;
import com.tencent.mm.plugin.appbrand.appcache.ac;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer;
import com.tencent.mm.plugin.appbrand.dynamic.b.d;
import com.tencent.mm.plugin.appbrand.dynamic.h.a.a;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.1;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView.3;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.c;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  implements View.OnAttachStateChangeListener, g, a.a, au.c
{
  private volatile com.tencent.mm.modelappbrand.e jle;
  private volatile b jll;
  private volatile e jlm;
  private String mToken;
  
  private com.tencent.mm.modelappbrand.e aVt()
  {
    AppMethodBeat.i(121231);
    if (this.jle == null) {}
    try
    {
      if (this.jle == null) {
        this.jle = new a();
      }
      com.tencent.mm.modelappbrand.e locale = this.jle;
      AppMethodBeat.o(121231);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(121231);
    }
  }
  
  public final String a(String paramString, View paramView, Bundle paramBundle, ab paramab)
  {
    AppMethodBeat.i(121227);
    if (!(paramView instanceof IPCDynamicPageView))
    {
      AppMethodBeat.o(121227);
      return "";
    }
    com.tencent.mm.plugin.expansions.a.cbc();
    Object localObject1 = m.no(System.nanoTime());
    com.tencent.mm.plugin.appbrand.collector.c.c("widget_launch", (String)localObject1, "on_bind_view", true);
    com.tencent.mm.plugin.appbrand.collector.c.co((String)localObject1, "init_finish");
    IPCDynamicPageView localIPCDynamicPageView = (IPCDynamicPageView)paramView;
    Object localObject2 = null;
    if (paramBundle != null)
    {
      paramView = paramBundle.getString("app_id");
      localObject2 = paramBundle.getString("msg_id");
      paramBundle.putString("__session_id", paramString);
      paramBundle.putLong("__on_bind_nano_time", System.nanoTime());
      paramBundle.putString("__session_id", (String)localObject1);
      paramBundle.putParcelable("__cost_time_session", com.tencent.mm.plugin.appbrand.collector.c.Fx((String)localObject1));
    }
    for (;;)
    {
      Object localObject4 = paramBundle.getString("wxa_unique_id");
      localObject1 = localObject4;
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        localObject1 = WxaWidgetInitializer.cx(paramView, (String)localObject2);
      }
      localObject2 = paramBundle.getString("exec_process_name", "com.tencent.mm:support");
      i.aVi().cw((String)localObject1, (String)localObject2);
      u.i("MicroMsg.DynamicPageService", "onBindView(%s)", new Object[] { localObject1 });
      com.tencent.mm.plugin.appbrand.dynamic.e.aVf().c((String)localObject1, localIPCDynamicPageView);
      localObject4 = (String)k.cB(paramBundle.getString("msg_path", "")).get("widgetData");
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
          localb.a((String)localObject2, (String)localObject1, (JSONObject)localObject4, null, null, com.tencent.mm.plugin.appbrand.dynamic.d.b.a.bt((String)localObject1, paramBundle.getInt("draw_strategy")), (String)localObject5);
          com.tencent.mm.plugin.appbrand.dynamic.d.b.a.bt((String)localObject1, paramBundle.getInt("draw_strategy")).a(localb);
          localObject2 = (w)paramab.vi("WidgetPreDrawCallback");
          if (localObject2 != null) {
            ((w)localObject2).atW();
          }
          u.va((String)localObject1);
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.DynamicPageService", localJSONException, "", new Object[0]);
          continue;
          Object localObject3 = null;
          continue;
          paramView.jnG.put(paramString, this);
        }
      }
      localIPCDynamicPageView.removeOnAttachStateChangeListener(this);
      localIPCDynamicPageView.addOnAttachStateChangeListener(this);
      Assert.assertNotNull(localObject1);
      localIPCDynamicPageView.jos = System.currentTimeMillis();
      if (paramab != null)
      {
        localObject2 = paramab.atX();
        if ((localIPCDynamicPageView.fDK != null) && (!((String)localObject1).equals(localIPCDynamicPageView.fDK))) {
          localIPCDynamicPageView.cleanup();
        }
        if ((localObject2 != null) && ((!((String)localObject1).equals(localIPCDynamicPageView.fDK)) || (!localIPCDynamicPageView.jor))) {
          ((h)localObject2).N(localIPCDynamicPageView, 0);
        }
        localIPCDynamicPageView.jor = false;
        u.i("MicroMsg.IPCDynamicPageView", "attach (%s)", new Object[] { localObject1 });
        IPCDynamicPageView.jki.post(new IPCDynamicPageView.3(localIPCDynamicPageView, (String)localObject1, paramBundle, paramab, paramView));
        ad.v("MicroMsg.DynamicPageService", "onBindView(%s)", new Object[] { localObject1 });
        paramView = com.tencent.mm.plugin.appbrand.dynamic.h.a.aVH();
        if ((paramString != null) && (paramString.length() != 0)) {
          break label644;
        }
        com.tencent.mm.plugin.appbrand.dynamic.h.a.aVH().c(paramString, localIPCDynamicPageView);
        aVt().d(paramString, localIPCDynamicPageView);
        AppMethodBeat.o(121227);
        return localObject1;
      }
      label644:
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
    ad.v("MicroMsg.DynamicPageService", "onUnBindView(%s)", new Object[] { paramView.getExtId() });
    paramView.removeOnAttachStateChangeListener(this);
    aVt().e(paramString, paramView);
    com.tencent.mm.plugin.appbrand.dynamic.h.a.aVH().b(paramString, paramView);
    paramView.detach();
    i.aVi().GX(paramString);
    AppMethodBeat.o(121228);
  }
  
  public final void a(String paramString, IPCDynamicPageView paramIPCDynamicPageView)
  {
    AppMethodBeat.i(121237);
    ad.v("MicroMsg.DynamicPageService", "onOverLength(sessionId : %s, view : %s)", new Object[] { paramString, paramIPCDynamicPageView.getExtId() });
    a(paramString, paramIPCDynamicPageView);
    AppMethodBeat.o(121237);
  }
  
  public final f atK()
  {
    AppMethodBeat.i(121232);
    if (this.jll == null) {}
    try
    {
      if (this.jll == null) {
        this.jll = new b(aVt());
      }
      b localb = this.jll;
      AppMethodBeat.o(121232);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(121232);
    }
  }
  
  public final n atL()
  {
    AppMethodBeat.i(121233);
    if (this.jlm == null) {}
    try
    {
      if (this.jlm == null) {
        this.jlm = new e();
      }
      e locale = this.jlm;
      AppMethodBeat.o(121233);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(121233);
    }
  }
  
  public final void b(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(121234);
    ad.e("MicroMsg.DynamicPageService", "uncaughtException(%s)", new Object[] { Log.getStackTraceString(paramThrowable) });
    shutdown();
    AppMethodBeat.o(121234);
  }
  
  public final View cq(Context paramContext)
  {
    AppMethodBeat.i(121226);
    paramContext = new IPCDynamicPageView(paramContext);
    AppMethodBeat.o(121226);
    return paramContext;
  }
  
  public final void cw(View paramView)
  {
    AppMethodBeat.i(121229);
    if (!(paramView instanceof IPCDynamicPageView))
    {
      AppMethodBeat.o(121229);
      return;
    }
    ((IPCDynamicPageView)paramView).re(2104);
    AppMethodBeat.o(121229);
  }
  
  public final p cx(View paramView)
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
    au.a(this);
    ac.a(new d());
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
    ad.d("MicroMsg.DynamicPageService", "onViewAttachedToWindow(%s)", new Object[] { paramView.getExtId() });
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
    ad.d("MicroMsg.DynamicPageService", "onViewDetachedFromWindow(%s)", new Object[] { paramView.getExtId() });
    paramView.onPause();
    AppMethodBeat.o(121236);
  }
  
  public final void shutdown()
  {
    AppMethodBeat.i(121225);
    Object localObject1 = aVt().atJ();
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
        uX((String)localObject2);
      }
    }
    AppMethodBeat.o(121225);
  }
  
  public final void uX(String paramString)
  {
    AppMethodBeat.i(121230);
    com.tencent.mm.plugin.appbrand.dynamic.h.a.aVH().jnF.remove(paramString);
    Object localObject1 = com.tencent.mm.plugin.appbrand.dynamic.h.a.aVH();
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      localObject1 = aVt().bY(paramString);
      if ((localObject1 != null) && (!((Set)localObject1).isEmpty())) {
        break;
      }
      AppMethodBeat.o(121230);
      return;
      ((com.tencent.mm.plugin.appbrand.dynamic.h.a)localObject1).jnG.remove(paramString);
    }
    localObject1 = ((Set)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (View)((Iterator)localObject1).next();
      if ((localObject2 != null) && ((localObject2 instanceof IPCDynamicPageView)))
      {
        localObject2 = (IPCDynamicPageView)localObject2;
        ad.v("MicroMsg.DynamicPageService", "onUnbindAllView, do unBindView(%s)", new Object[] { ((IPCDynamicPageView)localObject2).getExtId() });
        ((IPCDynamicPageView)localObject2).removeOnAttachStateChangeListener(this);
        ((IPCDynamicPageView)localObject2).detach();
      }
    }
    if (aVt().atJ().isEmpty()) {
      com.tencent.mm.cj.a.post(new a.1());
    }
    i.aVi().GX(paramString);
    AppMethodBeat.o(121230);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.a.c
 * JD-Core Version:    0.7.0.1
 */