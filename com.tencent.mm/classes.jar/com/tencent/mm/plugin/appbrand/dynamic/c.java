package com.tencent.mm.plugin.appbrand.dynamic;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.aa.b.d;
import com.tencent.mm.aa.c.e.a;
import com.tencent.mm.aa.d.a;
import com.tencent.mm.h.b.a.r;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.model.u.b;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.i.q;
import com.tencent.mm.protocal.c.un;
import com.tencent.mm.protocal.c.uo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.Set;

public final class c
  implements com.tencent.mm.plugin.appbrand.canvas.widget.b
{
  String Db;
  boolean ahC;
  String appId;
  volatile com.tencent.mm.aa.c.e dIU;
  String dIX;
  String fKV;
  int fTC;
  boolean fTD;
  com.tencent.mm.plugin.appbrand.widget.g fTE;
  String fTF;
  volatile boolean fTG;
  private volatile boolean fTH;
  boolean fTI = false;
  boolean fTJ = false;
  private com.tencent.mm.ipcinvoker.wx_extension.b.a fTK;
  Runnable fTL;
  Context mContext;
  String mUrl;
  
  public c(Context paramContext)
  {
    this.mContext = paramContext;
    this.fTK = new c.1(this);
    this.fTL = new Runnable()
    {
      public final void run()
      {
        c.this.aeT();
      }
    };
  }
  
  final void a(com.tencent.mm.aa.c.e parame, com.tencent.mm.plugin.appbrand.widget.g paramg)
  {
    boolean bool2 = false;
    if ((parame == null) || (paramg == null) || (bk.bl(paramg.field_data)))
    {
      if (parame == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (paramg == null) {
          bool2 = true;
        }
        y.i("MicroMsg.DynamicPageViewIPCProxy", "pushData failed, jsBridge(isNull : %s) or cacheData(isNull : %s) or cacheData.field_data is null", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        return;
      }
    }
    u.i("MicroMsg.DynamicPageViewIPCProxy", "pushData %s", new Object[] { paramg.field_id });
    com.tencent.mm.plugin.appbrand.dynamic.f.c localc = new com.tencent.mm.plugin.appbrand.dynamic.f.c();
    localc.data = paramg.field_data;
    parame.a(localc, new c.6(this));
    parame = new Bundle();
    parame.putString("widgetId", paramg.field_id);
    parame.putString("respData", paramg.field_data);
    paramg = i.aeX().sX(paramg.field_id);
    u.i("MicroMsg.DynamicPageViewIPCProxy", "dispatch onDataPush event to view proce %s", new Object[] { paramg });
    if (paramg == null)
    {
      ToolsProcessIPCService.a(parame, c.a.class);
      return;
    }
    com.tencent.mm.ipcinvoker.f.a(paramg, parame, c.a.class, null);
  }
  
  final void aeT()
  {
    u.i("MicroMsg.DynamicPageViewIPCProxy", "try to refresh", new Object[0]);
    if (this.fTD) {
      return;
    }
    com.tencent.mm.plugin.appbrand.widget.g localg = this.fTE;
    if ((localg == null) || (!this.ahC))
    {
      if (localg == null) {}
      for (boolean bool = true;; bool = false)
      {
        u.i("MicroMsg.DynamicPageViewIPCProxy", "cacheData %b, mRunning %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.ahC) });
        return;
      }
    }
    if (this.fTG)
    {
      u.i("MicroMsg.DynamicPageViewIPCProxy", "paused", new Object[0]);
      this.fTH = true;
      return;
    }
    if (bk.bl(localg.field_appId))
    {
      y.e("MicroMsg.DynamicPageViewIPCProxy", "tryToRefresh(%s) failed, has no appId", new Object[] { this.dIX });
      return;
    }
    this.fTH = false;
    long l = localg.field_updateTime + localg.field_interval * 1000L - System.currentTimeMillis();
    if (l > 0L)
    {
      u.i("MicroMsg.DynamicPageViewIPCProxy", "post delay refresh(%s) data.", new Object[] { Long.valueOf(l) });
      b.h(this.fTL, l);
      return;
    }
    u.i("MicroMsg.DynamicPageViewIPCProxy", "refresh data(%s, %s)", new Object[] { this.fTE.field_id, this.fTE.field_appId });
    if ((this.fTC == 1) && (!this.fTI))
    {
      v.jdMethod_if(16);
      localObject = new r();
      ((r)localObject).cjv = u.jy(this.dIX);
      ((r)localObject).cjw = u.jx(this.dIX);
      ((r)localObject).cjs = 9L;
      ((r)localObject).cjr = this.dIX;
      ((r)localObject).cjt = System.currentTimeMillis();
      ((r)localObject).cjy = aq.fH(ae.getContext());
      ((r)localObject).QX();
    }
    Object localObject = new com.tencent.mm.ah.b.a();
    ((com.tencent.mm.ah.b.a)localObject).ecG = 1193;
    ((com.tencent.mm.ah.b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/getdynamicdata";
    un localun = new un();
    localun.bOL = localg.field_appId;
    localun.key = localg.field_cacheKey;
    localun.scene = this.fTC;
    localun.bVk = this.Db;
    localun.url = this.mUrl;
    ((com.tencent.mm.ah.b.a)localObject).ecH = localun;
    ((com.tencent.mm.ah.b.a)localObject).ecI = new uo();
    com.tencent.mm.ipcinvoker.wx_extension.b.a(((com.tencent.mm.ah.b.a)localObject).Kt(), this.fTK);
  }
  
  public final boolean bl(String paramString1, String paramString2)
  {
    if ((this.dIU == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    com.tencent.mm.aa.c.f localf = this.dIU.dIZ;
    Object localObject = localf.dJd.fO(paramString1);
    if (localObject == null)
    {
      y.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) do not exist.", new Object[] { paramString1 });
      return false;
    }
    if (!localf.dIP.hi(((com.tencent.mm.aa.b.e)localObject).getIndex()))
    {
      y.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) no permission.", new Object[] { paramString1 });
      return false;
    }
    localObject = paramString2;
    if (bk.bl(paramString2)) {
      localObject = "{}";
    }
    y.d("MicroMsg.MiniJsEventDispatcher", "dispatch, event: %s, data size: %s, srcId: %d", new Object[] { paramString1, Integer.valueOf(((String)localObject).length()), Integer.valueOf(0) });
    localf.dJa.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\", %s, %s, %s)", new Object[] { paramString1, localObject, "undefined", com.tencent.mm.aa.c.f.CG() }), null);
    return true;
  }
  
  final void cleanup()
  {
    if (this.fTE != null) {
      y.i("MicroMsg.DynamicPageViewIPCProxy", "cleanup(%s, %s)", new Object[] { this.fTE.field_id, this.fTE.field_appId });
    }
    for (;;)
    {
      if (this.dIU != null)
      {
        com.tencent.mm.aa.c.e locale = this.dIU;
        y.v("MicroMsg.MiniJsBridge", "onStop(%s)", new Object[] { locale.dIX });
        locale.ahC = false;
        locale.dJa.cleanup();
        com.tencent.mm.aa.c.c localc = locale.dIY;
        localc.dIR.quit();
        localc.dIO.dIV.recycle();
        if (locale.dJc != null)
        {
          locale.dJc.D(locale.dIX, 4);
          locale.dJc = null;
        }
      }
      return;
      y.i("MicroMsg.DynamicPageViewIPCProxy", "cleanup");
    }
  }
  
  public final boolean isPaused()
  {
    return this.fTG;
  }
  
  public final void m(Bundle paramBundle)
  {
    if (paramBundle == null) {
      break label4;
    }
    for (;;)
    {
      label4:
      return;
      if (this.dIU != null)
      {
        u.b localb = this.dIU.dIY.dIO.dIV;
        if (localb == null) {
          break;
        }
        Object localObject = paramBundle.keySet();
        if ((localObject == null) || (localb == null)) {
          break;
        }
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          localb.h(str, paramBundle.get(str));
        }
      }
    }
  }
  
  public final void onPause()
  {
    y.i("MicroMsg.DynamicPageViewIPCProxy", "onPause(%s)", new Object[] { this.dIX });
    this.fTG = true;
    if (this.dIU != null)
    {
      com.tencent.mm.aa.c.e locale = this.dIU;
      new com.tencent.mm.plugin.appbrand.dynamic.f.f();
      locale.CE();
    }
  }
  
  public final void onResume()
  {
    y.i("MicroMsg.DynamicPageViewIPCProxy", "onResume(%s)", new Object[] { this.dIX });
    boolean bool = this.fTG;
    if (this.dIU != null)
    {
      com.tencent.mm.aa.c.e locale = this.dIU;
      new com.tencent.mm.plugin.appbrand.dynamic.f.g();
      locale.CF();
    }
    this.fTG = false;
    if ((bool) && (this.fTH)) {
      aeT();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.c
 * JD-Core Version:    0.7.0.1
 */