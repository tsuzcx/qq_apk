package com.tencent.mm.plugin.appbrand.app;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.luggage.bridge.a.a.a;
import com.tencent.luggage.bridge.a.a.c;
import com.tencent.luggage.sdk.b.a.c.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.MediaCodecProxyUtils;
import com.tencent.mm.compatible.deviceinfo.u;
import com.tencent.mm.modelappbrand.a.b.g;
import com.tencent.mm.plugin.appbrand.appcache.bq;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.debugger.t;
import com.tencent.mm.plugin.appbrand.jsapi.video.m;
import com.tencent.mm.plugin.appbrand.luggage.b.f;
import com.tencent.mm.plugin.appbrand.media.record.h.a;
import com.tencent.mm.plugin.appbrand.ui.ab;
import com.tencent.mm.plugin.appbrand.ui.o;
import com.tencent.mm.plugin.appbrand.utils.v;
import com.tencent.mm.plugin.appbrand.xweb_ext.video.d.a;
import com.tencent.mm.plugin.appbrand.y.p.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.io.InputStream;

final class k
  extends com.tencent.luggage.sdk.b
{
  com.tencent.luggage.bridge.a.a.b jHS;
  private final com.tencent.mm.kernel.b.g jHT;
  
  public k(final com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(44225);
    this.jHS = null;
    this.jHT = paramg;
    com.tencent.luggage.sdk.g.c.a("WeChatMultiProcessInitDelegateImpl<init>", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44217);
        ae.i("MicroMsg.WeChatMultiProcessInitDelegateImpl", "<init> %s", new Object[] { paramg.mProcessName });
        com.tencent.luggage.h.i locali = com.tencent.luggage.h.i.cre;
        com.tencent.luggage.h.i.a(v.mUi);
        com.tencent.mm.plugin.appbrand.media.record.h.a(new h.a()
        {
          public final void dK(String paramAnonymous2String)
          {
            AppMethodBeat.i(174700);
            com.tencent.mm.compatible.util.j.vN(paramAnonymous2String);
            AppMethodBeat.o(174700);
          }
        });
        com.tencent.mm.modelappbrand.a.b.CW(com.tencent.mm.loader.j.b.asj());
        com.tencent.mm.modelappbrand.a.b.a(new b.g()
        {
          public final Bitmap decodeStream(InputStream paramAnonymous2InputStream)
          {
            AppMethodBeat.i(174701);
            paramAnonymous2InputStream = com.tencent.mm.sdk.platformtools.h.decodeStream(paramAnonymous2InputStream);
            AppMethodBeat.o(174701);
            return paramAnonymous2InputStream;
          }
        });
        AppBrandLocalMediaObjectManager.CW(com.tencent.mm.loader.j.b.asj());
        if ((ak.foC()) || (ak.foD()) || (PluginAppBrand.isAppBrandProcess()))
        {
          k.this.jHS = new com.tencent.mm.plugin.appbrand.luggage.a();
          AppMethodBeat.o(44217);
          return;
        }
        if (PluginAppBrand.isSupportProcess())
        {
          k.this.jHS = new com.tencent.mm.plugin.appbrand.luggage.b();
          AppMethodBeat.o(44217);
          return;
        }
        k.this.jHS = new com.tencent.luggage.bridge.a.a.b()
        {
          public final void a(a.a paramAnonymous2a) {}
          
          public final void a(a.c paramAnonymous2c) {}
        };
        AppMethodBeat.o(44217);
      }
    });
    AppMethodBeat.o(44225);
  }
  
  public final void DY()
  {
    AppMethodBeat.i(44228);
    if (this.jHT.xP(":appbrand"))
    {
      super.DY();
      com.tencent.luggage.sdk.b.a.c.d.EW().a(new b.a(), com.tencent.mm.plugin.appbrand.service.b.class);
      com.tencent.luggage.sdk.b.a.c.d.EW().a(new com.tencent.luggage.game.d.a.a.a.b(), com.tencent.mm.plugin.appbrand.game.a.class);
      com.tencent.luggage.sdk.b.a.c.d.EW().a(com.tencent.luggage.sdk.b.a.c.i.cpb, t.class);
    }
    AppMethodBeat.o(44228);
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(44227);
    ae.i("MicroMsg.WeChatMultiProcessInitDelegateImpl", "onInitComponent %s", new Object[] { ak.getProcessName() });
    super.a(parama);
    this.jHS.a(parama);
    AppMethodBeat.o(44227);
  }
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(44226);
    ae.i("MicroMsg.WeChatMultiProcessInitDelegateImpl", "onInitialize %s", new Object[] { ak.getProcessName() });
    super.a(paramc);
    this.jHS.a(paramc);
    paramc.a(ab.class, new o());
    paramc.a(p.a.class, new f(ak.getContext()));
    paramc.a(com.tencent.mm.plugin.appbrand.jsapi.video.h.class, new m());
    paramc.a(com.tencent.mm.plugin.appbrand.s.a.class, new com.tencent.mm.plugin.appbrand.luggage.d.a());
    paramc.a(com.tencent.mm.plugin.appbrand.s.b.class, new com.tencent.mm.plugin.appbrand.luggage.d.b());
    paramc.a(com.tencent.mm.plugin.appbrand.jsapi.video.g.class, com.tencent.mm.plugin.appbrand.jsapi.video.j.bob());
    paramc.a(com.tencent.mm.plugin.appbrand.jsapi.ad.e.h.class, d.a.bHo());
    paramc.a(com.tencent.mm.plugin.appbrand.ad.k.class, com.tencent.mm.plugin.appbrand.ad.d.jEX);
    paramc.a(com.tencent.luggage.sdk.customize.a.class, new com.tencent.mm.plugin.appbrand.luggage.b.b());
    paramc.a(com.tencent.mm.plugin.appbrand.networking.c.class, com.tencent.mm.plugin.appbrand.networking.h.mbU);
    paramc.a(com.tencent.mm.plugin.appbrand.permission.i.class, new com.tencent.mm.plugin.appbrand.task.a.d());
    paramc.a(com.tencent.mm.plugin.appbrand.widget.a.a.class, new bq());
    com.tencent.mm.plugin.appbrand.jsapi.autofill.i.init();
    MediaCodecProxyUtils.a(new u()
    {
      public final boolean aaW()
      {
        AppMethodBeat.i(174704);
        if (TextUtils.equals(com.tencent.mm.plugin.expt.h.d.ctr().b("clicfg_media_codec_proxy_kv_switch", "1", false, false), "0"))
        {
          AppMethodBeat.o(174704);
          return false;
        }
        AppMethodBeat.o(174704);
        return true;
      }
      
      public final void rd(long paramAnonymousLong)
      {
        AppMethodBeat.i(174702);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1132L, paramAnonymousLong, 1L, false);
        AppMethodBeat.o(174702);
      }
      
      public final void vG(String paramAnonymousString)
      {
        AppMethodBeat.i(174703);
        com.tencent.mm.plugin.report.service.g.yxI.kvStat(17952, paramAnonymousString);
        AppMethodBeat.o(174703);
      }
    });
    AppMethodBeat.o(44226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.k
 * JD-Core Version:    0.7.0.1
 */