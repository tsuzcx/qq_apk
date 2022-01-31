package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.af;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.collector.CollectSession;
import com.tencent.mm.plugin.appbrand.dynamic.f.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.z.b.d;
import java.util.Map;
import junit.framework.Assert;

final class a$a$1
  implements Runnable
{
  a$a$1(a.a parama, c paramc, String paramString1, String paramString2, Bundle paramBundle) {}
  
  public final void run()
  {
    AppMethodBeat.i(10642);
    u.i("MicroMsg.IPCInvoke_AttachTo", "ui thread attach", new Object[0]);
    c localc;
    String str1;
    Bundle localBundle;
    long l;
    label278:
    Object localObject3;
    try
    {
      localc = this.hmU;
      str3 = this.val$id;
      str1 = this.val$appId;
      localBundle = this.hmS;
      Assert.assertNotNull(str3);
      if ((!str3.equals(localc.equ)) && (localc.eGt != null))
      {
        localc.cleanup();
        localc.ajS = false;
        localc.eGt = null;
      }
      localc.equ = str3;
      localc.appId = str1;
      if (localBundle == null) {
        break label1155;
      }
      localObject1 = localBundle.getString("cache_key", "");
      localc.DK = localBundle.getString("query");
      localc.hne = localBundle.getBoolean("is_testing_ui");
      localc.mUrl = localBundle.getString("url");
      localc.hnd = localBundle.getInt("widget_type");
      localc.hng = localBundle.getString("search_id");
      localc.mSessionId = localBundle.getString("__session_id");
      l = localBundle.getLong("__on_bind_nano_time");
      if (bo.isNullOrNil(localc.mSessionId)) {
        break label1165;
      }
      com.tencent.mm.plugin.appbrand.collector.c.a((CollectSession)localBundle.getParcelable("__cost_time_session"));
    }
    catch (Exception localException)
    {
      String str3;
      Object localObject1;
      com.tencent.mm.z.c.e locale;
      String str2;
      int k;
      com.tencent.mm.plugin.appbrand.dynamic.f.b localb;
      ab.printErrStackTrace("MicroMsg.IPCInvoke_AttachTo", localException, "caught exception", new Object[0]);
      AppMethodBeat.o(10642);
      return;
    }
    u.i("MicroMsg.DynamicPageViewIPCProxy", "attach(%s, %s)", new Object[] { str3, str1 });
    int i = 1;
    int j;
    if (localc.hnd == 1)
    {
      i = 0;
      if (localc.hnf != null) {
        break label1150;
      }
      localc.hnf = new com.tencent.mm.plugin.appbrand.widget.f();
      j = 0;
      localc.hnf.field_id = str3;
      localc.hnf.field_cacheKey = ((String)localObject1);
      localc.hnf.field_appId = u.qn(localc.equ);
      if (localc.eGt != null) {
        break label1018;
      }
      u.i("MicroMsg.DynamicPageViewIPCProxy", "jsbridge is null", new Object[0]);
      com.tencent.mm.plugin.appbrand.collector.c.bH(localc.mSessionId, "before_init_js_engine");
      localObject1 = localc.mContext;
      str1 = localc.equ;
      localObject3 = k.Bd(str1);
      if ((localObject3 != null) && (localBundle != null)) {
        break label953;
      }
      ab.w("MicroMsg.WxaWidgetInitializer", "FwContext is null(id : %s)", new Object[] { str1 });
      localObject1 = null;
      label394:
      localc.eGt = ((com.tencent.mm.z.c.e)localObject1);
      com.tencent.mm.plugin.appbrand.collector.c.bH(localc.mSessionId, "after_init_js_engine");
      localc.eGt.equ = localc.equ;
      if ((localc.eGt.eGy instanceof com.tencent.mm.plugin.appbrand.dynamic.e.a))
      {
        ((com.tencent.mm.plugin.appbrand.dynamic.e.a)localc.eGt.eGy).setJsExceptionHandler(new c.3(localc));
        localc.eGt.eGy.a(new c.4(localc));
      }
      if (localBundle != null) {
        localc.v(localBundle.getBundle("__env_args"));
      }
      localc.eGt.onStart();
      if (!localc.hnh) {
        break label1000;
      }
      localc.eGt.a(new com.tencent.mm.plugin.appbrand.dynamic.f.f());
      label532:
      u.i("MicroMsg.DynamicPageViewIPCProxy", "before dispatch onCanvasInsertJsEvent", new Object[0]);
      locale = localc.eGt;
      str1 = "";
      localObject1 = "";
      str2 = "";
      localObject3 = null;
      k = 0;
      i = 0;
      if (localBundle != null)
      {
        k = localBundle.getInt("view_init_width");
        i = localBundle.getInt("view_init_height");
        str1 = localBundle.getString("cache_key", "");
        localObject1 = localBundle.getString("msg_title", "");
        localObject3 = localBundle.getString("msg_path", "");
        str2 = com.tencent.luggage.g.h.cg((String)localObject3);
        localObject3 = com.tencent.luggage.g.h.ch((String)localObject3);
      }
      localb = new com.tencent.mm.plugin.appbrand.dynamic.f.b();
      localb.cacheKey = str1;
      localb.title = ((String)localObject1);
      localb.path = str2;
      localb.hpW = ((Map)localObject3);
      localb.hpX = k;
      localb.hpY = i;
      locale.a(localb, new c.5(localc));
      u.i("MicroMsg.DynamicPageViewIPCProxy", "after dispatch onCanvasInsertJsEvent", new Object[0]);
      localObject1 = new af().fB(u.qn(str3));
      ((af)localObject1).cUl = u.qm(str3);
      ((af)localObject1).cUh = 8L;
      localObject1 = ((af)localObject1).fA(str3);
      ((af)localObject1).cUi = System.currentTimeMillis();
      ((af)localObject1).fC(at.gU(ah.getContext())).ake();
      if (l > 0L)
      {
        l = (System.nanoTime() - l) / 1000000L;
        i = 22;
        if (l > 50L) {
          break label1168;
        }
        i = 0;
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(677L, i, 1L, false);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(677L, 8L, 1L, false);
      com.tencent.mm.plugin.appbrand.collector.c.bH(localc.mSessionId, "init_finish");
      com.tencent.mm.plugin.appbrand.collector.c.print(localc.mSessionId);
      u.i("MicroMsg.DynamicPageViewIPCProxy", "jsbridge init complete", new Object[0]);
      label880:
      localc.ajS = true;
      if (j != 0) {
        localc.a(localc.eGt, localc.hnf);
      }
      for (;;)
      {
        localc.azw();
        AppMethodBeat.o(10642);
        return;
        localc.hnf = com.tencent.mm.plugin.appbrand.dynamic.j.b.Bp(str3);
        break;
        label953:
        ab.i("MicroMsg.WxaWidgetInitializer", "initJsBridge(%s)", new Object[] { str1 });
        localObject2 = com.tencent.mm.plugin.appbrand.dynamic.h.e.a(localException, (WxaWidgetContext)localObject3, new com.tencent.mm.plugin.appbrand.dynamic.d.c.a(str1, ((WxaWidgetContext)localObject3).azH()), localBundle);
        break label394;
        label1000:
        localc.eGt.b(new g());
        break label532;
        label1018:
        u.i("MicroMsg.DynamicPageViewIPCProxy", "jsbridge not null", new Object[0]);
        com.tencent.mm.plugin.appbrand.collector.c.zK(localc.mSessionId);
        if (localBundle != null) {
          localc.v(localBundle.getBundle("__env_args"));
        }
        localc.eGt.onStart();
        if (localc.hnh)
        {
          localc.eGt.a(new com.tencent.mm.plugin.appbrand.dynamic.f.f());
          break label880;
        }
        localc.eGt.b(new g());
        break label880;
        if (localc.hne)
        {
          localc.hnf.field_data = localBundle.getString("init_data");
          localc.a(localc.eGt, localc.hnf);
        }
      }
      label1150:
      j = i;
      break label278;
      label1155:
      l = 0L;
      Object localObject2 = "";
      break;
      label1165:
      break;
      label1168:
      if (l <= 100L) {
        i = 1;
      } else if (l <= 200L) {
        i = 2;
      } else if (l <= 300L) {
        i = 3;
      } else if (l <= 400L) {
        i = 4;
      } else if (l <= 500L) {
        i = 5;
      } else if (l <= 600L) {
        i = 6;
      } else if (l <= 1000L) {
        i = 17;
      } else if (l <= 1500L) {
        i = 18;
      } else if (l <= 2000L) {
        i = 19;
      } else if (l <= 2500L) {
        i = 20;
      } else if (l <= 3000L) {
        i = 21;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.a.a.1
 * JD-Core Version:    0.7.0.1
 */