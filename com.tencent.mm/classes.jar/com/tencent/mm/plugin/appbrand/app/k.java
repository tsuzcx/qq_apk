package com.tencent.mm.plugin.appbrand.app;

import android.graphics.Bitmap;
import com.tencent.luggage.bridge.a.a.a;
import com.tencent.luggage.bridge.a.a.c;
import com.tencent.luggage.sdk.b.a.c.b.a;
import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.MediaCodecProxyUtils;
import com.tencent.mm.modelappbrand.a.b.g;
import com.tencent.mm.plugin.appbrand.appcache.bo;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.jsapi.video.m;
import com.tencent.mm.plugin.appbrand.luggage.b.f;
import com.tencent.mm.plugin.appbrand.media.record.h.a;
import com.tencent.mm.plugin.appbrand.ui.aa;
import com.tencent.mm.plugin.appbrand.ui.n;
import com.tencent.mm.plugin.appbrand.xweb_ext.video.d.a;
import com.tencent.mm.plugin.appbrand.z.p.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.io.InputStream;

final class k
  extends com.tencent.luggage.sdk.b
{
  com.tencent.luggage.bridge.a.a.b jET;
  private final com.tencent.mm.kernel.b.g jEU;
  
  public k(final com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(44225);
    this.jET = null;
    this.jEU = paramg;
    com.tencent.luggage.sdk.g.c.a("WeChatMultiProcessInitDelegateImpl<init>", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44217);
        ad.i("MicroMsg.WeChatMultiProcessInitDelegateImpl", "<init> %s", new Object[] { paramg.mProcessName });
        com.tencent.luggage.h.i locali = com.tencent.luggage.h.i.cqA;
        com.tencent.luggage.h.i.a(com.tencent.mm.plugin.appbrand.utils.t.mPd);
        com.tencent.mm.plugin.appbrand.media.record.h.a(new h.a()
        {
          public final void dH(String paramAnonymous2String)
          {
            AppMethodBeat.i(174700);
            com.tencent.mm.compatible.util.j.vr(paramAnonymous2String);
            AppMethodBeat.o(174700);
          }
        });
        com.tencent.mm.modelappbrand.a.b.Cu(com.tencent.mm.loader.j.b.arU());
        com.tencent.mm.modelappbrand.a.b.a(new b.g()
        {
          public final Bitmap decodeStream(InputStream paramAnonymous2InputStream)
          {
            AppMethodBeat.i(174701);
            paramAnonymous2InputStream = com.tencent.mm.sdk.platformtools.g.decodeStream(paramAnonymous2InputStream);
            AppMethodBeat.o(174701);
            return paramAnonymous2InputStream;
          }
        });
        AppBrandLocalMediaObjectManager.Cu(com.tencent.mm.loader.j.b.arU());
        if ((aj.fkI()) || (aj.fkJ()) || (PluginAppBrand.isAppBrandProcess()))
        {
          k.this.jET = new com.tencent.mm.plugin.appbrand.luggage.a();
          AppMethodBeat.o(44217);
          return;
        }
        if (PluginAppBrand.isSupportProcess())
        {
          k.this.jET = new com.tencent.mm.plugin.appbrand.luggage.b();
          AppMethodBeat.o(44217);
          return;
        }
        k.this.jET = new com.tencent.luggage.bridge.a.a.b()
        {
          public final void a(a.a paramAnonymous2a) {}
          
          public final void a(a.c paramAnonymous2c) {}
        };
        AppMethodBeat.o(44217);
      }
    });
    AppMethodBeat.o(44225);
  }
  
  public final void DV()
  {
    AppMethodBeat.i(44228);
    if (this.jEU.xg(":appbrand"))
    {
      super.DV();
      d.EU().a(new b.a(), com.tencent.mm.plugin.appbrand.service.b.class);
      d.EU().a(new com.tencent.luggage.game.d.a.a.a.b(), com.tencent.mm.plugin.appbrand.game.a.class);
      d.EU().a(com.tencent.luggage.sdk.b.a.c.h.coX, com.tencent.mm.plugin.appbrand.debugger.t.class);
    }
    AppMethodBeat.o(44228);
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(44227);
    ad.i("MicroMsg.WeChatMultiProcessInitDelegateImpl", "onInitComponent %s", new Object[] { aj.getProcessName() });
    super.a(parama);
    this.jET.a(parama);
    AppMethodBeat.o(44227);
  }
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(44226);
    ad.i("MicroMsg.WeChatMultiProcessInitDelegateImpl", "onInitialize %s", new Object[] { aj.getProcessName() });
    super.a(paramc);
    this.jET.a(paramc);
    paramc.a(aa.class, new n());
    paramc.a(p.a.class, new f(aj.getContext()));
    paramc.a(com.tencent.mm.plugin.appbrand.jsapi.video.h.class, new m());
    paramc.a(com.tencent.mm.plugin.appbrand.t.a.class, new com.tencent.mm.plugin.appbrand.luggage.d.a());
    paramc.a(com.tencent.mm.plugin.appbrand.t.b.class, new com.tencent.mm.plugin.appbrand.luggage.d.b());
    paramc.a(com.tencent.mm.plugin.appbrand.jsapi.video.g.class, com.tencent.mm.plugin.appbrand.jsapi.video.j.bnr());
    paramc.a(com.tencent.mm.plugin.appbrand.jsapi.ac.e.h.class, d.a.bGs());
    paramc.a(com.tencent.mm.plugin.appbrand.ad.j.class, com.tencent.mm.plugin.appbrand.ad.c.jCa);
    paramc.a(com.tencent.luggage.sdk.customize.a.class, new com.tencent.mm.plugin.appbrand.luggage.b.b());
    paramc.a(com.tencent.mm.plugin.appbrand.networking.b.class, com.tencent.mm.plugin.appbrand.networking.g.lXn);
    paramc.a(com.tencent.mm.plugin.appbrand.widget.a.a.class, new bo());
    com.tencent.mm.plugin.appbrand.jsapi.autofill.i.init();
    MediaCodecProxyUtils.a(new k.2(this));
    AppMethodBeat.o(44226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.k
 * JD-Core Version:    0.7.0.1
 */