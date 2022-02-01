package com.tencent.mm.plugin.appbrand.app;

import android.graphics.Bitmap;
import com.tencent.luggage.bridge.a.a.a;
import com.tencent.luggage.bridge.a.a.c;
import com.tencent.luggage.h.i;
import com.tencent.luggage.sdk.b.a.c.b.a;
import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.MediaCodecProxyUtils;
import com.tencent.mm.modelappbrand.a.b.g;
import com.tencent.mm.plugin.appbrand.aa.o.a;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.debugger.s;
import com.tencent.mm.plugin.appbrand.media.record.h.a;
import com.tencent.mm.plugin.appbrand.ui.z;
import com.tencent.mm.plugin.appbrand.utils.t;
import com.tencent.mm.plugin.appbrand.xweb_ext.video.d.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.io.InputStream;

final class k
  extends com.tencent.luggage.sdk.b
{
  com.tencent.luggage.bridge.a.a.b iKW;
  private final com.tencent.mm.kernel.b.g iKX;
  
  public k(final com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(44225);
    this.iKW = null;
    this.iKX = paramg;
    com.tencent.luggage.sdk.g.c.a("WeChatMultiProcessInitDelegateImpl<init>", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44217);
        ad.i("MicroMsg.WeChatMultiProcessInitDelegateImpl", "<init> %s", new Object[] { paramg.mProcessName });
        i locali = i.cjn;
        i.a(t.lME);
        com.tencent.mm.plugin.appbrand.media.record.h.a(new h.a()
        {
          public final void cP(String paramAnonymous2String)
          {
            AppMethodBeat.i(174700);
            com.tencent.mm.compatible.util.j.pq(paramAnonymous2String);
            AppMethodBeat.o(174700);
          }
        });
        com.tencent.mm.modelappbrand.a.b.vp(com.tencent.mm.loader.j.b.aih());
        com.tencent.mm.modelappbrand.a.b.a(new b.g()
        {
          public final Bitmap decodeStream(InputStream paramAnonymous2InputStream)
          {
            AppMethodBeat.i(174701);
            paramAnonymous2InputStream = com.tencent.mm.sdk.platformtools.f.decodeStream(paramAnonymous2InputStream);
            AppMethodBeat.o(174701);
            return paramAnonymous2InputStream;
          }
        });
        AppBrandLocalMediaObjectManager.vp(com.tencent.mm.loader.j.b.aih());
        if ((aj.eFJ()) || (aj.eFK()) || (PluginAppBrand.isAppBrandProcess()))
        {
          k.this.iKW = new com.tencent.mm.plugin.appbrand.luggage.a();
          AppMethodBeat.o(44217);
          return;
        }
        if (PluginAppBrand.isSupportProcess())
        {
          k.this.iKW = new com.tencent.mm.plugin.appbrand.luggage.b();
          AppMethodBeat.o(44217);
          return;
        }
        k.this.iKW = new com.tencent.luggage.bridge.a.a.b()
        {
          public final void a(a.a paramAnonymous2a) {}
          
          public final void a(a.c paramAnonymous2c) {}
        };
        AppMethodBeat.o(44217);
      }
    });
    AppMethodBeat.o(44225);
  }
  
  public final void CT()
  {
    AppMethodBeat.i(44228);
    if (this.iKX.rb(":appbrand"))
    {
      super.CT();
      d.DS().a(new b.a(), com.tencent.mm.plugin.appbrand.service.b.class);
      d.DS().a(new com.tencent.luggage.game.d.a.a.a.b(), com.tencent.mm.plugin.appbrand.game.a.class);
      d.DS().a(com.tencent.luggage.sdk.b.a.c.h.chL, s.class);
    }
    AppMethodBeat.o(44228);
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(44227);
    ad.i("MicroMsg.WeChatMultiProcessInitDelegateImpl", "onInitComponent %s", new Object[] { aj.getProcessName() });
    super.a(parama);
    this.iKW.a(parama);
    AppMethodBeat.o(44227);
  }
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(44226);
    ad.i("MicroMsg.WeChatMultiProcessInitDelegateImpl", "onInitialize %s", new Object[] { aj.getProcessName() });
    super.a(paramc);
    this.iKW.a(paramc);
    paramc.a(z.class, new com.tencent.mm.plugin.appbrand.ui.m());
    paramc.a(o.a.class, new com.tencent.mm.plugin.appbrand.luggage.b.f(aj.getContext()));
    paramc.a(com.tencent.mm.plugin.appbrand.jsapi.video.h.class, new com.tencent.mm.plugin.appbrand.jsapi.video.m());
    paramc.a(com.tencent.mm.plugin.appbrand.u.a.class, new com.tencent.mm.plugin.appbrand.luggage.d.a());
    paramc.a(com.tencent.mm.plugin.appbrand.u.b.class, new com.tencent.mm.plugin.appbrand.luggage.d.b());
    paramc.a(com.tencent.mm.plugin.appbrand.jsapi.video.g.class, com.tencent.mm.plugin.appbrand.jsapi.video.j.bcK());
    paramc.a(com.tencent.mm.plugin.appbrand.jsapi.aa.e.h.class, d.a.bvr());
    paramc.a(com.tencent.mm.plugin.appbrand.ad.g.class, com.tencent.mm.plugin.appbrand.ad.c.iIA);
    paramc.a(com.tencent.luggage.sdk.customize.a.class, new com.tencent.mm.plugin.appbrand.luggage.b.b());
    paramc.a(com.tencent.mm.plugin.appbrand.networking.a.class, com.tencent.mm.plugin.appbrand.networking.f.kWl);
    com.tencent.mm.plugin.appbrand.jsapi.a.h.init();
    MediaCodecProxyUtils.a(new k.2(this));
    AppMethodBeat.o(44226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.k
 * JD-Core Version:    0.7.0.1
 */