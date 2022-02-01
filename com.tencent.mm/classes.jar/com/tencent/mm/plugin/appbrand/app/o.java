package com.tencent.mm.plugin.appbrand.app;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.luggage.bridge.a.a.a;
import com.tencent.luggage.bridge.a.a.c;
import com.tencent.luggage.sdk.b.a.c.c.a;
import com.tencent.luggage.sdk.b.a.c.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.MediaCodecProxyUtils;
import com.tencent.mm.compatible.deviceinfo.u;
import com.tencent.mm.modelappbrand.a.b.g;
import com.tencent.mm.plugin.appbrand.ac.p.a;
import com.tencent.mm.plugin.appbrand.ad.k;
import com.tencent.mm.plugin.appbrand.appcache.bq;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.debugger.t;
import com.tencent.mm.plugin.appbrand.jsapi.video.m;
import com.tencent.mm.plugin.appbrand.luggage.b.f;
import com.tencent.mm.plugin.appbrand.media.record.h.a;
import com.tencent.mm.plugin.appbrand.ui.ah;
import com.tencent.mm.plugin.appbrand.ui.r;
import com.tencent.mm.plugin.appbrand.utils.v;
import com.tencent.mm.plugin.appbrand.xweb_ext.video.d.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.InputStream;

final class o
  extends com.tencent.luggage.sdk.b
{
  com.tencent.luggage.bridge.a.a.b kJQ;
  private final com.tencent.mm.kernel.b.g kJR;
  
  public o(final com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(44225);
    this.kJQ = null;
    this.kJR = paramg;
    com.tencent.luggage.sdk.g.c.a("WeChatMultiProcessInitDelegateImpl<init>", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44217);
        Log.i("MicroMsg.WeChatMultiProcessInitDelegateImpl", "<init> %s", new Object[] { paramg.mProcessName });
        com.tencent.luggage.h.j localj = com.tencent.luggage.h.j.cDv;
        com.tencent.luggage.h.j.a(v.ohj);
        com.tencent.mm.plugin.appbrand.media.record.h.a(new h.a()
        {
          public final void ef(String paramAnonymous2String)
          {
            AppMethodBeat.i(174700);
            com.tencent.mm.compatible.util.j.Ed(paramAnonymous2String);
            AppMethodBeat.o(174700);
          }
        });
        com.tencent.mm.modelappbrand.a.b.LH(com.tencent.mm.loader.j.b.aKJ());
        com.tencent.mm.modelappbrand.a.b.a(new b.g()
        {
          public final Bitmap decodeStream(InputStream paramAnonymous2InputStream)
          {
            AppMethodBeat.i(174701);
            paramAnonymous2InputStream = BitmapUtil.decodeStream(paramAnonymous2InputStream);
            AppMethodBeat.o(174701);
            return paramAnonymous2InputStream;
          }
        });
        AppBrandLocalMediaObjectManager.LH(com.tencent.mm.loader.j.b.aKJ());
        if ((MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()) || (PluginAppBrand.isAppBrandProcess()))
        {
          o.this.kJQ = new com.tencent.mm.plugin.appbrand.luggage.a();
          AppMethodBeat.o(44217);
          return;
        }
        if (PluginAppBrand.isSupportProcess())
        {
          o.this.kJQ = new com.tencent.mm.plugin.appbrand.luggage.b();
          AppMethodBeat.o(44217);
          return;
        }
        o.this.kJQ = new com.tencent.luggage.bridge.a.a.b()
        {
          public final void a(a.a paramAnonymous2a) {}
          
          public final void a(a.c paramAnonymous2c) {}
        };
        AppMethodBeat.o(44217);
      }
    });
    AppMethodBeat.o(44225);
  }
  
  public final void Nu()
  {
    AppMethodBeat.i(44228);
    if (this.kJR.FZ(":appbrand"))
    {
      super.Nu();
      e.Oy().a(new c.a(), com.tencent.mm.plugin.appbrand.service.b.class);
      e.Oy().a(new com.tencent.luggage.game.d.a.a.a.b(), com.tencent.mm.plugin.appbrand.game.a.class);
      e.Oy().a(com.tencent.luggage.sdk.b.a.c.j.cBs, t.class);
    }
    AppMethodBeat.o(44228);
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(44227);
    Log.i("MicroMsg.WeChatMultiProcessInitDelegateImpl", "onInitComponent %s", new Object[] { MMApplicationContext.getProcessName() });
    super.a(parama);
    this.kJQ.a(parama);
    AppMethodBeat.o(44227);
  }
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(44226);
    Log.i("MicroMsg.WeChatMultiProcessInitDelegateImpl", "onInitialize %s", new Object[] { MMApplicationContext.getProcessName() });
    super.a(paramc);
    this.kJQ.a(paramc);
    paramc.a(ah.class, new r());
    paramc.a(p.a.class, new f(MMApplicationContext.getContext()));
    paramc.a(com.tencent.mm.plugin.appbrand.jsapi.video.h.class, new m());
    paramc.a(com.tencent.mm.plugin.appbrand.w.a.class, new com.tencent.mm.plugin.appbrand.luggage.c.a());
    paramc.a(com.tencent.mm.plugin.appbrand.w.b.class, new com.tencent.mm.plugin.appbrand.luggage.c.b());
    paramc.a(com.tencent.mm.plugin.appbrand.jsapi.video.g.class, com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE());
    paramc.a(com.tencent.mm.plugin.appbrand.jsapi.ag.e.h.class, d.a.cdQ());
    paramc.a(k.class, com.tencent.mm.plugin.appbrand.ad.d.kGH);
    paramc.a(com.tencent.luggage.sdk.customize.a.class, new com.tencent.mm.plugin.appbrand.luggage.b.b());
    paramc.a(com.tencent.mm.plugin.appbrand.networking.c.class, com.tencent.mm.plugin.appbrand.networking.h.njF);
    paramc.a(com.tencent.mm.plugin.appbrand.permission.i.class, new com.tencent.mm.plugin.appbrand.task.a.d());
    paramc.a(com.tencent.mm.plugin.appbrand.widget.a.a.class, new bq());
    com.tencent.mm.plugin.appbrand.jsapi.autofill.i.init();
    MediaCodecProxyUtils.a(new u()
    {
      public final void DX(String paramAnonymousString)
      {
        AppMethodBeat.i(174703);
        com.tencent.mm.plugin.report.service.h.CyF.kvStat(17952, paramAnonymousString);
        AppMethodBeat.o(174703);
      }
      
      public final boolean aoV()
      {
        AppMethodBeat.i(174704);
        if (TextUtils.equals(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_media_codec_proxy_kv_switch", "1", false, false), "0"))
        {
          AppMethodBeat.o(174704);
          return false;
        }
        AppMethodBeat.o(174704);
        return true;
      }
      
      public final void yU(long paramAnonymousLong)
      {
        AppMethodBeat.i(174702);
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1132L, paramAnonymousLong, 1L, false);
        AppMethodBeat.o(174702);
      }
    });
    AppMethodBeat.o(44226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.o
 * JD-Core Version:    0.7.0.1
 */