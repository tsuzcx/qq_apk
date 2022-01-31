package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.luggage.g.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.modelappbrand.l;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.w;
import com.tencent.mm.plugin.appbrand.appcache.z;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer;
import com.tencent.mm.plugin.appbrand.dynamic.h.a.a;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.1;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView.3;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ao.c;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  implements View.OnAttachStateChangeListener, com.tencent.mm.modelappbrand.e, a.a, ao.c
{
  private volatile com.tencent.mm.modelappbrand.c hnW;
  private volatile b hod;
  private volatile e hoe;
  private String mToken;
  
  private com.tencent.mm.modelappbrand.c azM()
  {
    AppMethodBeat.i(10749);
    if (this.hnW == null) {}
    try
    {
      if (this.hnW == null) {
        this.hnW = new a();
      }
      com.tencent.mm.modelappbrand.c localc = this.hnW;
      AppMethodBeat.o(10749);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(10749);
    }
  }
  
  public final String a(String paramString, View paramView, Bundle paramBundle, com.tencent.mm.modelappbrand.ab paramab)
  {
    AppMethodBeat.i(10745);
    if (!(paramView instanceof IPCDynamicPageView))
    {
      AppMethodBeat.o(10745);
      return "";
    }
    Object localObject1 = com.tencent.mm.plugin.appbrand.s.n.hH(System.nanoTime());
    com.tencent.mm.plugin.appbrand.collector.c.c("widget_launch", (String)localObject1, "on_bind_view", true);
    com.tencent.mm.plugin.appbrand.collector.c.bI((String)localObject1, "init_finish");
    IPCDynamicPageView localIPCDynamicPageView = (IPCDynamicPageView)paramView;
    Object localObject2 = null;
    if (paramBundle != null)
    {
      paramView = paramBundle.getString("app_id");
      localObject2 = paramBundle.getString("msg_id");
      paramBundle.putString("__session_id", paramString);
      paramBundle.putLong("__on_bind_nano_time", System.nanoTime());
      paramBundle.putString("__session_id", (String)localObject1);
      paramBundle.putParcelable("__cost_time_session", com.tencent.mm.plugin.appbrand.collector.c.zJ((String)localObject1));
    }
    for (;;)
    {
      Object localObject4 = paramBundle.getString("wxa_unique_id");
      localObject1 = localObject4;
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        localObject1 = WxaWidgetInitializer.bO(paramView, (String)localObject2);
      }
      localObject2 = paramBundle.getString("exec_process_name", "com.tencent.mm:support");
      i.azB().bN((String)localObject1, (String)localObject2);
      u.i("MicroMsg.DynamicPageService", "onBindView(%s)", new Object[] { localObject1 });
      com.tencent.mm.plugin.appbrand.dynamic.e.azy().b((String)localObject1, localIPCDynamicPageView);
      localObject4 = (String)h.ch(paramBundle.getString("msg_path", "")).get("widgetData");
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
          localb.a((String)localObject2, (String)localObject1, (JSONObject)localObject4, null, null, com.tencent.mm.plugin.appbrand.dynamic.d.b.a.bb((String)localObject1, paramBundle.getInt("draw_strategy")), (String)localObject5);
          com.tencent.mm.plugin.appbrand.dynamic.d.b.a.bb((String)localObject1, paramBundle.getInt("draw_strategy")).a(localb);
          localObject2 = (w)paramab.qs("WidgetPreDrawCallback");
          if (localObject2 != null) {
            ((w)localObject2).acy();
          }
          u.ql((String)localObject1);
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.DynamicPageService", localJSONException, "", new Object[0]);
          continue;
          Object localObject3 = null;
          continue;
          paramView.hqx.put(paramString, this);
        }
      }
      localIPCDynamicPageView.removeOnAttachStateChangeListener(this);
      localIPCDynamicPageView.addOnAttachStateChangeListener(this);
      Assert.assertNotNull(localObject1);
      localIPCDynamicPageView.hrj = System.currentTimeMillis();
      if (paramab != null)
      {
        localObject2 = paramab.acz();
        if ((localIPCDynamicPageView.equ != null) && (!((String)localObject1).equals(localIPCDynamicPageView.equ))) {
          localIPCDynamicPageView.cleanup();
        }
        if ((localObject2 != null) && ((!((String)localObject1).equals(localIPCDynamicPageView.equ)) || (!localIPCDynamicPageView.hri))) {
          ((f)localObject2).I(localIPCDynamicPageView, 0);
        }
        localIPCDynamicPageView.hri = false;
        u.i("MicroMsg.IPCDynamicPageView", "attach (%s)", new Object[] { localObject1 });
        IPCDynamicPageView.hna.post(new IPCDynamicPageView.3(localIPCDynamicPageView, (String)localObject1, paramBundle, paramab, paramView));
        com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.DynamicPageService", "onBindView(%s)", new Object[] { localObject1 });
        paramView = com.tencent.mm.plugin.appbrand.dynamic.h.a.aAa();
        if ((paramString != null) && (paramString.length() != 0)) {
          break label642;
        }
        com.tencent.mm.plugin.appbrand.dynamic.h.a.aAa().c(paramString, localIPCDynamicPageView);
        azM().d(paramString, localIPCDynamicPageView);
        AppMethodBeat.o(10745);
        return localObject1;
      }
      label642:
      paramView = null;
    }
  }
  
  public final void a(String paramString, View paramView)
  {
    AppMethodBeat.i(10746);
    if (!(paramView instanceof IPCDynamicPageView))
    {
      AppMethodBeat.o(10746);
      return;
    }
    paramView = (IPCDynamicPageView)paramView;
    com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.DynamicPageService", "onUnBindView(%s)", new Object[] { paramView.getExtId() });
    paramView.removeOnAttachStateChangeListener(this);
    azM().e(paramString, paramView);
    com.tencent.mm.plugin.appbrand.dynamic.h.a.aAa().b(paramString, paramView);
    paramView.detach();
    i.azB().AZ(paramString);
    AppMethodBeat.o(10746);
  }
  
  public final void a(String paramString, IPCDynamicPageView paramIPCDynamicPageView)
  {
    AppMethodBeat.i(10755);
    com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.DynamicPageService", "onOverLength(sessionId : %s, view : %s)", new Object[] { paramString, paramIPCDynamicPageView.getExtId() });
    a(paramString, paramIPCDynamicPageView);
    AppMethodBeat.o(10755);
  }
  
  public final com.tencent.mm.modelappbrand.d ack()
  {
    AppMethodBeat.i(10750);
    if (this.hod == null) {}
    try
    {
      if (this.hod == null) {
        this.hod = new b(azM());
      }
      b localb = this.hod;
      AppMethodBeat.o(10750);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(10750);
    }
  }
  
  public final l acl()
  {
    AppMethodBeat.i(10751);
    if (this.hoe == null) {}
    try
    {
      if (this.hoe == null) {
        this.hoe = new e();
      }
      e locale = this.hoe;
      AppMethodBeat.o(10751);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(10751);
    }
  }
  
  public final void b(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(10752);
    com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.DynamicPageService", "uncaughtException(%s)", new Object[] { Log.getStackTraceString(paramThrowable) });
    shutdown();
    AppMethodBeat.o(10752);
  }
  
  public final View bX(Context paramContext)
  {
    AppMethodBeat.i(10744);
    paramContext = new IPCDynamicPageView(paramContext);
    AppMethodBeat.o(10744);
    return paramContext;
  }
  
  public final void cl(View paramView)
  {
    AppMethodBeat.i(10747);
    if (!(paramView instanceof IPCDynamicPageView))
    {
      AppMethodBeat.o(10747);
      return;
    }
    ((IPCDynamicPageView)paramView).nK(2104);
    AppMethodBeat.o(10747);
  }
  
  public final com.tencent.mm.modelappbrand.n cm(View paramView)
  {
    if ((paramView instanceof IPCDynamicPageView)) {
      return (com.tencent.mm.modelappbrand.n)paramView;
    }
    return null;
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(10742);
    if ((this.mToken != null) && (this.mToken.length() != 0)) {
      shutdown();
    }
    this.mToken = ("Token#" + System.nanoTime());
    ao.a(this);
    z.a(new com.tencent.mm.plugin.appbrand.dynamic.b.d());
    AppMethodBeat.o(10742);
  }
  
  public final void onViewAttachedToWindow(View paramView)
  {
    AppMethodBeat.i(10753);
    if ((paramView == null) || (!(paramView instanceof IPCDynamicPageView)))
    {
      AppMethodBeat.o(10753);
      return;
    }
    paramView = (IPCDynamicPageView)paramView;
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.DynamicPageService", "onViewAttachedToWindow(%s)", new Object[] { paramView.getExtId() });
    paramView.onResume();
    AppMethodBeat.o(10753);
  }
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    AppMethodBeat.i(10754);
    if ((paramView == null) || (!(paramView instanceof IPCDynamicPageView)))
    {
      AppMethodBeat.o(10754);
      return;
    }
    paramView = (IPCDynamicPageView)paramView;
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.DynamicPageService", "onViewDetachedFromWindow(%s)", new Object[] { paramView.getExtId() });
    paramView.onPause();
    AppMethodBeat.o(10754);
  }
  
  public final void qi(String paramString)
  {
    AppMethodBeat.i(10748);
    com.tencent.mm.plugin.appbrand.dynamic.h.a.aAa().hqw.remove(paramString);
    Object localObject1 = com.tencent.mm.plugin.appbrand.dynamic.h.a.aAa();
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      localObject1 = azM().aT(paramString);
      if ((localObject1 != null) && (!((Set)localObject1).isEmpty())) {
        break;
      }
      AppMethodBeat.o(10748);
      return;
      ((com.tencent.mm.plugin.appbrand.dynamic.h.a)localObject1).hqx.remove(paramString);
    }
    localObject1 = ((Set)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (View)((Iterator)localObject1).next();
      if ((localObject2 != null) && ((localObject2 instanceof IPCDynamicPageView)))
      {
        localObject2 = (IPCDynamicPageView)localObject2;
        com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.DynamicPageService", "onUnbindAllView, do unBindView(%s)", new Object[] { ((IPCDynamicPageView)localObject2).getExtId() });
        ((IPCDynamicPageView)localObject2).removeOnAttachStateChangeListener(this);
        ((IPCDynamicPageView)localObject2).detach();
      }
    }
    if (azM().acj().isEmpty()) {
      com.tencent.mm.ch.a.post(new a.1());
    }
    i.azB().AZ(paramString);
    AppMethodBeat.o(10748);
  }
  
  public final void shutdown()
  {
    AppMethodBeat.i(10743);
    Object localObject1 = azM().acj();
    if ((localObject1 == null) || (((Map)localObject1).isEmpty()))
    {
      AppMethodBeat.o(10743);
      return;
    }
    localObject1 = new LinkedHashSet(((Map)localObject1).keySet()).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if ((localObject2 != null) && ((localObject2 instanceof String))) {
        qi((String)localObject2);
      }
    }
    AppMethodBeat.o(10743);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.a.c
 * JD-Core Version:    0.7.0.1
 */