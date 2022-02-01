package com.tencent.mm.plugin.appbrand.app;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.luggage.bridge.a.a.a;
import com.tencent.luggage.bridge.a.a.c;
import com.tencent.luggage.sdk.b.a.c.b.a;
import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.MediaCodecProxyUtils;
import com.tencent.mm.compatible.deviceinfo.u;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.modelappbrand.a.b.g;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.jsapi.video.l;
import com.tencent.mm.plugin.appbrand.jsapi.video.n;
import com.tencent.mm.plugin.appbrand.media.record.h.a;
import com.tencent.mm.plugin.appbrand.ui.m;
import com.tencent.mm.plugin.appbrand.ui.y;
import com.tencent.mm.plugin.appbrand.utils.t;
import com.tencent.mm.plugin.appbrand.xweb_ext.video.d.a;
import com.tencent.mm.plugin.appbrand.z.o.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.io.InputStream;

final class k
  extends com.tencent.luggage.sdk.b
{
  com.tencent.luggage.bridge.a.a.b jld;
  private final com.tencent.mm.kernel.b.g jle;
  
  public k(final com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(44225);
    this.jld = null;
    this.jle = paramg;
    com.tencent.luggage.sdk.g.c.a("WeChatMultiProcessInitDelegateImpl<init>", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44217);
        ac.i("MicroMsg.WeChatMultiProcessInitDelegateImpl", "<init> %s", new Object[] { paramg.mProcessName });
        com.tencent.luggage.h.i locali = com.tencent.luggage.h.i.cgk;
        com.tencent.luggage.h.i.a(t.moB);
        com.tencent.mm.plugin.appbrand.media.record.h.a(new h.a()
        {
          public final void cE(String paramAnonymous2String)
          {
            AppMethodBeat.i(174700);
            j.sC(paramAnonymous2String);
            AppMethodBeat.o(174700);
          }
        });
        com.tencent.mm.modelappbrand.a.b.zv(com.tencent.mm.loader.j.b.aph());
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
        AppBrandLocalMediaObjectManager.zv(com.tencent.mm.loader.j.b.aph());
        if ((ai.eVd()) || (ai.eVe()) || (PluginAppBrand.isAppBrandProcess()))
        {
          k.this.jld = new com.tencent.mm.plugin.appbrand.luggage.a();
          AppMethodBeat.o(44217);
          return;
        }
        if (PluginAppBrand.isSupportProcess())
        {
          k.this.jld = new com.tencent.mm.plugin.appbrand.luggage.b();
          AppMethodBeat.o(44217);
          return;
        }
        k.this.jld = new com.tencent.luggage.bridge.a.a.b()
        {
          public final void a(a.a paramAnonymous2a) {}
          
          public final void a(a.c paramAnonymous2c) {}
        };
        AppMethodBeat.o(44217);
      }
    });
    AppMethodBeat.o(44225);
  }
  
  public final void Cw()
  {
    AppMethodBeat.i(44228);
    if (this.jle.uq(":appbrand"))
    {
      super.Cw();
      d.Dv().a(new b.a(), com.tencent.mm.plugin.appbrand.service.b.class);
      d.Dv().a(new com.tencent.luggage.game.d.a.a.a.b(), com.tencent.mm.plugin.appbrand.game.a.class);
      d.Dv().a(com.tencent.luggage.sdk.b.a.c.h.ceG, com.tencent.mm.plugin.appbrand.debugger.s.class);
    }
    AppMethodBeat.o(44228);
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(44227);
    ac.i("MicroMsg.WeChatMultiProcessInitDelegateImpl", "onInitComponent %s", new Object[] { ai.getProcessName() });
    super.a(parama);
    this.jld.a(parama);
    AppMethodBeat.o(44227);
  }
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(44226);
    ac.i("MicroMsg.WeChatMultiProcessInitDelegateImpl", "onInitialize %s", new Object[] { ai.getProcessName() });
    super.a(paramc);
    this.jld.a(paramc);
    paramc.a(y.class, new m());
    paramc.a(o.a.class, new com.tencent.mm.plugin.appbrand.luggage.b.f(ai.getContext()));
    paramc.a(l.class, new com.tencent.mm.plugin.appbrand.jsapi.video.s());
    paramc.a(com.tencent.mm.plugin.appbrand.t.a.class, new com.tencent.mm.plugin.appbrand.luggage.d.a());
    paramc.a(com.tencent.mm.plugin.appbrand.t.b.class, new com.tencent.mm.plugin.appbrand.luggage.d.b());
    paramc.a(com.tencent.mm.plugin.appbrand.jsapi.video.g.class, n.bjG());
    paramc.a(com.tencent.mm.plugin.appbrand.jsapi.z.e.h.class, d.a.bCn());
    paramc.a(com.tencent.mm.plugin.appbrand.ad.g.class, com.tencent.mm.plugin.appbrand.ad.c.jiE);
    paramc.a(com.tencent.luggage.sdk.customize.a.class, new com.tencent.mm.plugin.appbrand.luggage.b.b());
    paramc.a(com.tencent.mm.plugin.appbrand.networking.a.class, com.tencent.mm.plugin.appbrand.networking.f.lxV);
    com.tencent.mm.plugin.appbrand.jsapi.autofill.i.init();
    MediaCodecProxyUtils.a(new u()
    {
      public final boolean Yl()
      {
        AppMethodBeat.i(174704);
        if (TextUtils.equals(com.tencent.mm.plugin.expt.e.b.cmk().b("clicfg_media_codec_proxy_kv_switch", "1", false, false), "0"))
        {
          AppMethodBeat.o(174704);
          return false;
        }
        AppMethodBeat.o(174704);
        return true;
      }
      
      public final void oQ(long paramAnonymousLong)
      {
        AppMethodBeat.i(174702);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1132L, paramAnonymousLong, 1L, false);
        AppMethodBeat.o(174702);
      }
      
      public final void sv(String paramAnonymousString)
      {
        AppMethodBeat.i(174703);
        com.tencent.mm.plugin.report.service.h.wUl.kvStat(17952, paramAnonymousString);
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