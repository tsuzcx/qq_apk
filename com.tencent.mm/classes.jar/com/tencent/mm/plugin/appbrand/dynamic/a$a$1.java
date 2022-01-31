package com.tencent.mm.plugin.appbrand.dynamic;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.h.b.a.r;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.collector.CollectSession;
import com.tencent.mm.plugin.appbrand.dynamic.f.f;
import com.tencent.mm.plugin.appbrand.i.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;

final class a$a$1
  implements Runnable
{
  a$a$1(a.a parama, c paramc, String paramString1, String paramString2, Bundle paramBundle) {}
  
  public final void run()
  {
    u.i("MicroMsg.IPCInvoke_AttachTo", "ui thread attach", new Object[0]);
    c localc = this.fTt;
    String str2 = this.BD;
    Object localObject2 = this.val$appId;
    Bundle localBundle = this.fTr;
    Assert.assertNotNull(str2);
    if ((!str2.equals(localc.dIX)) && (localc.dIU != null))
    {
      localc.cleanup();
      localc.ahC = false;
      localc.dIU = null;
    }
    localc.dIX = str2;
    localc.appId = ((String)localObject2);
    Object localObject1 = "";
    long l;
    if (localBundle != null)
    {
      localObject1 = localBundle.getString("cache_key", "");
      localc.Db = localBundle.getString("query");
      localc.fTD = localBundle.getBoolean("is_testing_ui");
      localc.mUrl = localBundle.getString("url");
      localc.fTC = localBundle.getInt("widget_type");
      localc.fTF = localBundle.getString("search_id");
      localc.fKV = localBundle.getString("__session_id");
      l = localBundle.getLong("__on_bind_nano_time");
      if (!bk.bl(localc.fKV)) {
        com.tencent.mm.plugin.appbrand.collector.c.a((CollectSession)localBundle.getParcelable("__cost_time_session"));
      }
    }
    for (;;)
    {
      u.i("MicroMsg.DynamicPageViewIPCProxy", "attach(%s, %s)", new Object[] { str2, localObject2 });
      int i = 1;
      if (localc.fTC == 1)
      {
        i = 0;
        if (localc.fTE != null) {
          break label1392;
        }
        localc.fTE = new com.tencent.mm.plugin.appbrand.widget.g();
      }
      label976:
      label1392:
      for (int j = 0;; j = i)
      {
        localc.fTE.field_id = str2;
        localc.fTE.field_cacheKey = ((String)localObject1);
        localc.fTE.field_appId = u.jy(localc.dIX);
        if (localc.dIU == null)
        {
          u.i("MicroMsg.DynamicPageViewIPCProxy", "jsbridge is null", new Object[0]);
          com.tencent.mm.plugin.appbrand.collector.c.bf(localc.fKV, "before_init_js_engine");
          localObject1 = localc.mContext;
          localObject2 = localc.dIX;
          Object localObject3 = k.tb((String)localObject2);
          if ((localObject3 == null) || (localBundle == null)) {
            y.w("MicroMsg.WxaWidgetInitializer", "FwContext is null(id : %s)", new Object[] { localObject2 });
          }
          for (localObject1 = null;; localObject1 = com.tencent.mm.plugin.appbrand.dynamic.h.e.a((Context)localObject1, (WxaWidgetContext)localObject3, new com.tencent.mm.plugin.appbrand.dynamic.d.c.a((String)localObject2, ((WxaWidgetContext)localObject3).afd()), localBundle))
          {
            localc.dIU = ((com.tencent.mm.aa.c.e)localObject1);
            com.tencent.mm.plugin.appbrand.collector.c.bf(localc.fKV, "after_init_js_engine");
            localc.dIU.dIX = localc.dIX;
            if (!(localc.dIU.dJa instanceof com.tencent.mm.plugin.appbrand.dynamic.e.a)) {
              break label631;
            }
            localObject1 = (com.tencent.mm.plugin.appbrand.dynamic.e.a)localc.dIU.dJa;
            localObject2 = new c.3(localc);
            if (((com.tencent.mm.plugin.appbrand.dynamic.e.a)localObject1).fWr != null) {
              ((com.tencent.mm.plugin.appbrand.dynamic.e.a)localObject1).fWr.setJsExceptionHandler((com.tencent.mm.plugin.appbrand.i.e)localObject2);
            }
            localObject2 = (com.tencent.mm.plugin.appbrand.dynamic.e.a)localc.dIU.dJa;
            localObject1 = new c.4(localc);
            localObject2 = ((com.tencent.mm.plugin.appbrand.dynamic.e.a)localObject2).fWr;
            if (((com.tencent.mm.plugin.appbrand.i.a)localObject2).gIp == null) {
              break label631;
            }
            localObject2 = ((com.tencent.mm.plugin.appbrand.i.a)localObject2).gIp.bza.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (com.tencent.mm.d.a.c)((Iterator)localObject2).next();
              if ((localObject3 instanceof com.tencent.mm.d.a.e)) {
                ((com.tencent.mm.d.a.e)localObject3).bzl = ((q)localObject1);
              }
            }
            localc.fTE = com.tencent.mm.plugin.appbrand.dynamic.j.b.tl(str2);
            break;
            y.i("MicroMsg.WxaWidgetInitializer", "initJsBridge(%s)", new Object[] { localObject2 });
          }
          label631:
          if (localBundle != null) {
            localc.m(localBundle.getBundle("__env_args"));
          }
          localc.dIU.onStart();
          if (localc.fTG)
          {
            localObject1 = localc.dIU;
            new f();
            ((com.tencent.mm.aa.c.e)localObject1).CE();
            u.i("MicroMsg.DynamicPageViewIPCProxy", "before dispatch onCanvasInsertJsEvent", new Object[0]);
            com.tencent.mm.aa.c.e locale = localc.dIU;
            localObject2 = "";
            localObject1 = "";
            String str1 = "";
            localObject3 = null;
            int k = 0;
            i = 0;
            if (localBundle != null)
            {
              k = localBundle.getInt("view_init_width");
              i = localBundle.getInt("view_init_height");
              localObject2 = localBundle.getString("cache_key", "");
              localObject1 = localBundle.getString("msg_title", "");
              localObject3 = localBundle.getString("msg_path", "");
              str1 = com.tencent.luggage.j.g.bi((String)localObject3);
              localObject3 = com.tencent.luggage.j.g.bj((String)localObject3);
            }
            com.tencent.mm.plugin.appbrand.dynamic.f.b localb = new com.tencent.mm.plugin.appbrand.dynamic.f.b();
            localb.fWw = ((String)localObject2);
            localb.title = ((String)localObject1);
            localb.path = str1;
            localb.fWv = ((Map)localObject3);
            localb.fWx = k;
            localb.fWy = i;
            locale.a(localb, new c.5(localc));
            u.i("MicroMsg.DynamicPageViewIPCProxy", "after dispatch onCanvasInsertJsEvent", new Object[0]);
            localObject1 = new r();
            ((r)localObject1).cjv = u.jy(str2);
            ((r)localObject1).cjw = u.jx(str2);
            ((r)localObject1).cjs = 8L;
            ((r)localObject1).cjr = str2;
            ((r)localObject1).cjt = System.currentTimeMillis();
            ((r)localObject1).cjy = aq.fH(ae.getContext());
            ((r)localObject1).QX();
            if (l > 0L)
            {
              l = (System.nanoTime() - l) / 1000000L;
              i = 22;
              if (l > 50L) {
                break label1089;
              }
              i = 0;
              h.nFQ.a(677L, i, 1L, false);
              h.nFQ.a(677L, 8L, 1L, false);
            }
            com.tencent.mm.plugin.appbrand.collector.c.bf(localc.fKV, "init_finish");
            com.tencent.mm.plugin.appbrand.collector.c.print(localc.fKV);
            u.i("MicroMsg.DynamicPageViewIPCProxy", "jsbridge init complete", new Object[0]);
            localc.ahC = true;
            if (j == 0) {
              break label1350;
            }
            localc.a(localc.dIU, localc.fTE);
          }
        }
        for (;;)
        {
          localc.aeT();
          return;
          localObject1 = localc.dIU;
          new com.tencent.mm.plugin.appbrand.dynamic.f.g();
          ((com.tencent.mm.aa.c.e)localObject1).CF();
          break;
          if (l <= 100L)
          {
            i = 1;
            break label976;
          }
          if (l <= 200L)
          {
            i = 2;
            break label976;
          }
          if (l <= 300L)
          {
            i = 3;
            break label976;
          }
          if (l <= 400L)
          {
            i = 4;
            break label976;
          }
          if (l <= 500L)
          {
            i = 5;
            break label976;
          }
          if (l <= 600L)
          {
            i = 6;
            break label976;
          }
          if (l <= 1000L)
          {
            i = 17;
            break label976;
          }
          if (l <= 1500L)
          {
            i = 18;
            break label976;
          }
          if (l <= 2000L)
          {
            i = 19;
            break label976;
          }
          if (l <= 2500L)
          {
            i = 20;
            break label976;
          }
          if (l > 3000L) {
            break label976;
          }
          i = 21;
          break label976;
          u.i("MicroMsg.DynamicPageViewIPCProxy", "jsbridge not null", new Object[0]);
          com.tencent.mm.plugin.appbrand.collector.c.rU(localc.fKV);
          if (localBundle != null) {
            localc.m(localBundle.getBundle("__env_args"));
          }
          localc.dIU.onStart();
          if (localc.fTG)
          {
            localObject1 = localc.dIU;
            new f();
            ((com.tencent.mm.aa.c.e)localObject1).CE();
            break label1035;
          }
          localObject1 = localc.dIU;
          new com.tencent.mm.plugin.appbrand.dynamic.f.g();
          ((com.tencent.mm.aa.c.e)localObject1).CF();
          break label1035;
          if (localc.fTD)
          {
            localc.fTE.field_data = localBundle.getString("init_data");
            localc.a(localc.dIU, localc.fTE);
          }
        }
      }
      label1035:
      label1089:
      label1350:
      l = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.a.a.1
 * JD-Core Version:    0.7.0.1
 */