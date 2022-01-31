package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.modelappbrand.l;
import com.tencent.mm.modelappbrand.n;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.z;
import com.tencent.mm.plugin.appbrand.appcache.t;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer;
import com.tencent.mm.plugin.appbrand.dynamic.h.a.a;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.1;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView.3;
import com.tencent.mm.plugin.appbrand.u.o;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

public final class c
  implements View.OnAttachStateChangeListener, com.tencent.mm.modelappbrand.e, a.a, al.c
{
  private volatile b fUB;
  private volatile e fUC;
  private volatile com.tencent.mm.modelappbrand.c fUu;
  private String fdD;
  
  private com.tencent.mm.modelappbrand.c afi()
  {
    if (this.fUu == null) {}
    try
    {
      if (this.fUu == null) {
        this.fUu = new a();
      }
      return this.fUu;
    }
    finally {}
  }
  
  public final com.tencent.mm.modelappbrand.d Jm()
  {
    if (this.fUB == null) {}
    try
    {
      if (this.fUB == null) {
        this.fUB = new b(afi());
      }
      return this.fUB;
    }
    finally {}
  }
  
  public final l Jn()
  {
    if (this.fUC == null) {}
    try
    {
      if (this.fUC == null) {
        this.fUC = new e();
      }
      return this.fUC;
    }
    finally {}
  }
  
  public final String a(String paramString, View paramView, Bundle paramBundle, z paramz)
  {
    Object localObject3 = null;
    if (!(paramView instanceof IPCDynamicPageView)) {
      return "";
    }
    Object localObject1 = o.cF(System.nanoTime());
    com.tencent.mm.plugin.appbrand.collector.c.c("widget_launch", (String)localObject1, "on_bind_view", true);
    com.tencent.mm.plugin.appbrand.collector.c.bg((String)localObject1, "init_finish");
    IPCDynamicPageView localIPCDynamicPageView = (IPCDynamicPageView)paramView;
    Object localObject2;
    if (paramBundle != null)
    {
      paramView = paramBundle.getString("app_id");
      localObject2 = paramBundle.getString("msg_id");
      paramBundle.putString("__session_id", paramString);
      paramBundle.putLong("__on_bind_nano_time", System.nanoTime());
      paramBundle.putString("__session_id", (String)localObject1);
      paramBundle.putParcelable("__cost_time_session", com.tencent.mm.plugin.appbrand.collector.c.rT((String)localObject1));
    }
    for (;;)
    {
      String str = paramBundle.getString("wxa_unique_id");
      localObject1 = str;
      if (TextUtils.isEmpty(str)) {
        localObject1 = WxaWidgetInitializer.bn(paramView, (String)localObject2);
      }
      localObject2 = paramBundle.getString("exec_process_name", "com.tencent.mm:support");
      i.aeX().bm((String)localObject1, (String)localObject2);
      u.i("MicroMsg.DynamicPageService", "onBindView(%s)", new Object[] { localObject1 });
      localIPCDynamicPageView.removeOnAttachStateChangeListener(this);
      localIPCDynamicPageView.addOnAttachStateChangeListener(this);
      Assert.assertNotNull(localObject1);
      localIPCDynamicPageView.fXJ = System.currentTimeMillis();
      localObject2 = localObject3;
      if (paramz != null) {
        localObject2 = paramz.JA();
      }
      if ((localIPCDynamicPageView.dIX != null) && (!((String)localObject1).equals(localIPCDynamicPageView.dIX))) {
        localIPCDynamicPageView.cleanup();
      }
      if ((localObject2 != null) && ((!((String)localObject1).equals(localIPCDynamicPageView.dIX)) || (!localIPCDynamicPageView.fXI))) {
        ((f)localObject2).y(localIPCDynamicPageView, 0);
      }
      localIPCDynamicPageView.fXI = false;
      u.i("MicroMsg.IPCDynamicPageView", "attach (%s)", new Object[] { localObject1 });
      IPCDynamicPageView.fTz.post(new IPCDynamicPageView.3(localIPCDynamicPageView, (String)localObject1, paramBundle, paramz, paramView));
      y.v("MicroMsg.DynamicPageService", "onBindView(%s)", new Object[] { localObject1 });
      paramView = com.tencent.mm.plugin.appbrand.dynamic.h.a.afw();
      if ((this == null) || (paramString == null) || (paramString.length() == 0)) {}
      for (;;)
      {
        com.tencent.mm.plugin.appbrand.dynamic.h.a.afw().c(paramString, localIPCDynamicPageView);
        afi().d(paramString, localIPCDynamicPageView);
        return localObject1;
        paramView.fWX.put(paramString, this);
      }
      localObject2 = null;
      paramView = null;
    }
  }
  
  public final void a(String paramString, IPCDynamicPageView paramIPCDynamicPageView)
  {
    y.v("MicroMsg.DynamicPageService", "onOverLength(sessionId : %s, view : %s)", new Object[] { paramString, paramIPCDynamicPageView.getExtId() });
    b(paramString, paramIPCDynamicPageView);
  }
  
  public final void b(String paramString, View paramView)
  {
    if (!(paramView instanceof IPCDynamicPageView)) {
      return;
    }
    paramView = (IPCDynamicPageView)paramView;
    y.v("MicroMsg.DynamicPageService", "onUnBindView(%s)", new Object[] { paramView.getExtId() });
    paramView.removeOnAttachStateChangeListener(this);
    afi().e(paramString, paramView);
    com.tencent.mm.plugin.appbrand.dynamic.h.a.afw().b(paramString, paramView);
    paramView.detach();
    i.aeX().sY(paramString);
  }
  
  public final void bM(View paramView)
  {
    if (!(paramView instanceof IPCDynamicPageView)) {
      return;
    }
    ((IPCDynamicPageView)paramView).kM(2104);
  }
  
  public final n bN(View paramView)
  {
    if ((paramView instanceof IPCDynamicPageView)) {
      return (n)paramView;
    }
    return null;
  }
  
  public final View bt(Context paramContext)
  {
    return new IPCDynamicPageView(paramContext);
  }
  
  public final void c(String paramString, Throwable paramThrowable)
  {
    y.e("MicroMsg.DynamicPageService", "uncaughtException(%s)", new Object[] { Log.getStackTraceString(paramThrowable) });
    shutdown();
  }
  
  public final void initialize()
  {
    if ((this.fdD != null) && (this.fdD.length() != 0)) {
      shutdown();
    }
    this.fdD = ("Token#" + System.nanoTime());
    al.a(this);
    t.a(new com.tencent.mm.plugin.appbrand.dynamic.b.d());
  }
  
  public final void ju(String paramString)
  {
    com.tencent.mm.plugin.appbrand.dynamic.h.a.afw().fWW.remove(paramString);
    Object localObject1 = com.tencent.mm.plugin.appbrand.dynamic.h.a.afw();
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      localObject1 = afi().az(paramString);
      if ((localObject1 != null) && (!((Set)localObject1).isEmpty())) {
        break;
      }
      return;
      ((com.tencent.mm.plugin.appbrand.dynamic.h.a)localObject1).fWX.remove(paramString);
    }
    localObject1 = ((Set)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (View)((Iterator)localObject1).next();
      if ((localObject2 != null) && ((localObject2 instanceof IPCDynamicPageView)))
      {
        localObject2 = (IPCDynamicPageView)localObject2;
        y.v("MicroMsg.DynamicPageService", "onUnbindAllView, do unBindView(%s)", new Object[] { ((IPCDynamicPageView)localObject2).getExtId() });
        ((IPCDynamicPageView)localObject2).removeOnAttachStateChangeListener(this);
        ((IPCDynamicPageView)localObject2).detach();
      }
    }
    if (afi().Jl().isEmpty()) {
      com.tencent.mm.cg.a.post(new a.1());
    }
    i.aeX().sY(paramString);
  }
  
  public final void onViewAttachedToWindow(View paramView)
  {
    if ((paramView == null) || (!(paramView instanceof IPCDynamicPageView))) {
      return;
    }
    paramView = (IPCDynamicPageView)paramView;
    y.d("MicroMsg.DynamicPageService", "onViewAttachedToWindow(%s)", new Object[] { paramView.getExtId() });
    paramView.onResume();
  }
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    if ((paramView == null) || (!(paramView instanceof IPCDynamicPageView))) {
      return;
    }
    paramView = (IPCDynamicPageView)paramView;
    y.d("MicroMsg.DynamicPageService", "onViewDetachedFromWindow(%s)", new Object[] { paramView.getExtId() });
    paramView.onPause();
  }
  
  public final void shutdown()
  {
    Object localObject1 = afi().Jl();
    if ((localObject1 == null) || (((Map)localObject1).isEmpty())) {}
    for (;;)
    {
      return;
      localObject1 = new LinkedHashSet(((Map)localObject1).keySet()).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 != null) && ((localObject2 instanceof String))) {
          ju((String)localObject2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.a.c
 * JD-Core Version:    0.7.0.1
 */