package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.b.d;
import com.tencent.mm.g.b.a.ca;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.collector.CollectSession;
import com.tencent.mm.plugin.appbrand.dynamic.f.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;
import junit.framework.Assert;

final class a$a$1
  implements Runnable
{
  a$a$1(a.a parama, c paramc, String paramString1, String paramString2, Bundle paramBundle) {}
  
  public final void run()
  {
    AppMethodBeat.i(121123);
    u.i("MicroMsg.IPCInvoke_AttachTo", "ui thread attach", new Object[0]);
    c localc;
    String str1;
    Bundle localBundle;
    long l;
    label277:
    Object localObject3;
    try
    {
      localc = this.jkc;
      str3 = this.val$id;
      str1 = this.val$appId;
      localBundle = this.jka;
      Assert.assertNotNull(str3);
      if ((!str3.equals(localc.fDK)) && (localc.gbB != null))
      {
        localc.cleanup();
        localc.arf = false;
        localc.gbB = null;
      }
      localc.fDK = str3;
      localc.appId = str1;
      if (localBundle == null) {
        break label1152;
      }
      localObject1 = localBundle.getString("cache_key", "");
      localc.Ky = localBundle.getString("query");
      localc.jkm = localBundle.getBoolean("is_testing_ui");
      localc.mUrl = localBundle.getString("url");
      localc.jkl = localBundle.getInt("widget_type");
      localc.jko = localBundle.getString("search_id");
      localc.mSessionId = localBundle.getString("__session_id");
      l = localBundle.getLong("__on_bind_nano_time");
      if (bt.isNullOrNil(localc.mSessionId)) {
        break label1162;
      }
      com.tencent.mm.plugin.appbrand.collector.c.a((CollectSession)localBundle.getParcelable("__cost_time_session"));
    }
    catch (Exception localException)
    {
      String str3;
      Object localObject1;
      com.tencent.mm.ab.c.e locale;
      String str2;
      int k;
      com.tencent.mm.plugin.appbrand.dynamic.f.b localb;
      ad.printErrStackTrace("MicroMsg.IPCInvoke_AttachTo", localException, "caught exception", new Object[0]);
      AppMethodBeat.o(121123);
      return;
    }
    u.i("MicroMsg.DynamicPageViewIPCProxy", "attach(%s, %s)", new Object[] { str3, str1 });
    int i = 1;
    int j;
    if (localc.jkl == 1)
    {
      i = 0;
      if (localc.jkn != null) {
        break label1147;
      }
      localc.jkn = new com.tencent.mm.plugin.appbrand.widget.f();
      j = 0;
      localc.jkn.field_id = str3;
      localc.jkn.field_cacheKey = ((String)localObject1);
      localc.jkn.field_appId = u.vd(localc.fDK);
      if (localc.gbB != null) {
        break label1015;
      }
      u.i("MicroMsg.DynamicPageViewIPCProxy", "jsbridge is null", new Object[0]);
      com.tencent.mm.plugin.appbrand.collector.c.cn(localc.mSessionId, "before_init_js_engine");
      localObject1 = localc.mContext;
      str1 = localc.fDK;
      localObject3 = k.Hb(str1);
      if ((localObject3 != null) && (localBundle != null)) {
        break label950;
      }
      ad.w("MicroMsg.WxaWidgetInitializer", "FwContext is null(id : %s)", new Object[] { str1 });
      localObject1 = null;
      label393:
      localc.gbB = ((com.tencent.mm.ab.c.e)localObject1);
      com.tencent.mm.plugin.appbrand.collector.c.cn(localc.mSessionId, "after_init_js_engine");
      localc.gbB.fDK = localc.fDK;
      if ((localc.gbB.gbG instanceof com.tencent.mm.plugin.appbrand.dynamic.e.a))
      {
        ((com.tencent.mm.plugin.appbrand.dynamic.e.a)localc.gbB.gbG).setJsExceptionHandler(new c.3(localc));
        localc.gbB.gbG.a(new c.4(localc));
      }
      if (localBundle != null) {
        localc.z(localBundle.getBundle("__env_args"));
      }
      localc.gbB.onStart();
      if (!localc.jkp) {
        break label997;
      }
      localc.gbB.a(new com.tencent.mm.plugin.appbrand.dynamic.f.f());
      label531:
      u.i("MicroMsg.DynamicPageViewIPCProxy", "before dispatch onCanvasInsertJsEvent", new Object[0]);
      locale = localc.gbB;
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
        str2 = com.tencent.luggage.h.k.cA((String)localObject3);
        localObject3 = com.tencent.luggage.h.k.cB((String)localObject3);
      }
      localb = new com.tencent.mm.plugin.appbrand.dynamic.f.b();
      localb.cacheKey = str1;
      localb.title = ((String)localObject1);
      localb.path = str2;
      localb.jne = ((Map)localObject3);
      localb.jnf = k;
      localb.jng = i;
      locale.a(localb, new c.5(localc));
      u.i("MicroMsg.DynamicPageViewIPCProxy", "after dispatch onCanvasInsertJsEvent", new Object[0]);
      localObject1 = new ca().iI(u.vd(str3));
      ((ca)localObject1).dQy = u.vb(str3);
      ((ca)localObject1).dQv = 8L;
      localObject1 = ((ca)localObject1).iH(str3);
      ((ca)localObject1).dQw = System.currentTimeMillis();
      ((ca)localObject1).iJ(ay.iw(aj.getContext())).aBj();
      if (l > 0L)
      {
        l = (System.nanoTime() - l) / 1000000L;
        i = 22;
        if (l > 50L) {
          break label1165;
        }
        i = 0;
      }
    }
    for (;;)
    {
      h.vKh.idkeyStat(677L, i, 1L, false);
      h.vKh.idkeyStat(677L, 8L, 1L, false);
      com.tencent.mm.plugin.appbrand.collector.c.cn(localc.mSessionId, "init_finish");
      com.tencent.mm.plugin.appbrand.collector.c.print(localc.mSessionId);
      u.i("MicroMsg.DynamicPageViewIPCProxy", "jsbridge init complete", new Object[0]);
      label879:
      localc.arf = true;
      if (j != 0) {
        localc.a(localc.gbB, localc.jkn);
      }
      for (;;)
      {
        localc.aVd();
        AppMethodBeat.o(121123);
        return;
        localc.jkn = com.tencent.mm.plugin.appbrand.dynamic.j.b.Hn(str3);
        break;
        label950:
        ad.i("MicroMsg.WxaWidgetInitializer", "initJsBridge(%s)", new Object[] { str1 });
        localObject2 = com.tencent.mm.plugin.appbrand.dynamic.h.e.a(localException, (WxaWidgetContext)localObject3, new com.tencent.mm.plugin.appbrand.dynamic.d.c.a(str1, ((WxaWidgetContext)localObject3).aVo()), localBundle);
        break label393;
        label997:
        localc.gbB.b(new g());
        break label531;
        label1015:
        u.i("MicroMsg.DynamicPageViewIPCProxy", "jsbridge not null", new Object[0]);
        com.tencent.mm.plugin.appbrand.collector.c.Fy(localc.mSessionId);
        if (localBundle != null) {
          localc.z(localBundle.getBundle("__env_args"));
        }
        localc.gbB.onStart();
        if (localc.jkp)
        {
          localc.gbB.a(new com.tencent.mm.plugin.appbrand.dynamic.f.f());
          break label879;
        }
        localc.gbB.b(new g());
        break label879;
        if (localc.jkm)
        {
          localc.jkn.field_data = localBundle.getString("init_data");
          localc.a(localc.gbB, localc.jkn);
        }
      }
      label1147:
      j = i;
      break label277;
      label1152:
      l = 0L;
      Object localObject2 = "";
      break;
      label1162:
      break;
      label1165:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.a.a.1
 * JD-Core Version:    0.7.0.1
 */