package com.tencent.mm.plugin.appbrand.app;

import android.graphics.Bitmap;
import com.tencent.luggage.bridge.a.a.a;
import com.tencent.luggage.bridge.a.a.c;
import com.tencent.luggage.sdk.b.a.d.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.MediaCodecProxyUtils;
import com.tencent.mm.modelappbrand.a.b.g;
import com.tencent.mm.plugin.appbrand.af.r.a;
import com.tencent.mm.plugin.appbrand.appcache.bx;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.debugger.v;
import com.tencent.mm.plugin.appbrand.jsapi.video.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.l;
import com.tencent.mm.plugin.appbrand.media.record.h.a;
import com.tencent.mm.plugin.appbrand.networking.c;
import com.tencent.mm.plugin.appbrand.ui.ap;
import com.tencent.mm.plugin.appbrand.ui.t;
import com.tencent.mm.plugin.appbrand.utils.ad;
import com.tencent.mm.plugin.appbrand.xweb_ext.video.e.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.InputStream;

final class o
  extends com.tencent.luggage.sdk.b
{
  com.tencent.luggage.bridge.a.a.b qDB;
  private final com.tencent.mm.kernel.b.g qDC;
  
  public o(final com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(44225);
    this.qDB = null;
    this.qDC = paramg;
    com.tencent.luggage.sdk.h.d.a("WeChatMultiProcessInitDelegateImpl<init>", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44217);
        Log.i("MicroMsg.WeChatMultiProcessInitDelegateImpl", "<init> %s", new Object[] { paramg.mProcessName });
        com.tencent.luggage.l.k localk = com.tencent.luggage.l.k.exm;
        com.tencent.luggage.l.k.a(ad.urk);
        com.tencent.mm.plugin.appbrand.media.record.h.a(new h.a()
        {
          public final void ge(String paramAnonymous2String)
          {
            AppMethodBeat.i(174700);
            com.tencent.mm.compatible.util.k.DA(paramAnonymous2String);
            AppMethodBeat.o(174700);
          }
        });
        com.tencent.mm.modelappbrand.a.b.Lb(com.tencent.mm.loader.i.b.bmz());
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
        AppBrandLocalMediaObjectManager.Lb(com.tencent.mm.loader.i.b.bmz());
        if ((MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()) || (PluginAppBrand.isAppBrandProcess()))
        {
          o.this.qDB = new com.tencent.mm.plugin.appbrand.luggage.a();
          AppMethodBeat.o(44217);
          return;
        }
        if (PluginAppBrand.isSupportProcess())
        {
          o.this.qDB = new com.tencent.mm.plugin.appbrand.luggage.b();
          AppMethodBeat.o(44217);
          return;
        }
        o.this.qDB = new com.tencent.luggage.bridge.a.a.b()
        {
          public final void a(a.a paramAnonymous2a) {}
          
          public final void a(a.c paramAnonymous2c) {}
        };
        AppMethodBeat.o(44217);
      }
    });
    AppMethodBeat.o(44225);
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(44227);
    Log.i("MicroMsg.WeChatMultiProcessInitDelegateImpl", "onInitComponent %s", new Object[] { MMApplicationContext.getProcessName() });
    super.a(parama);
    this.qDB.a(parama);
    AppMethodBeat.o(44227);
  }
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(44226);
    Log.i("MicroMsg.WeChatMultiProcessInitDelegateImpl", "onInitialize %s", new Object[] { MMApplicationContext.getProcessName() });
    super.a(paramc);
    this.qDB.a(paramc);
    paramc.a(ap.class, t.ueR);
    paramc.a(r.a.class, new com.tencent.mm.plugin.appbrand.luggage.b.e(MMApplicationContext.getContext()));
    paramc.a(com.tencent.mm.plugin.appbrand.jsapi.video.g.class, new l());
    paramc.a(com.tencent.mm.plugin.appbrand.x.a.class, new com.tencent.mm.plugin.appbrand.luggage.c.a());
    paramc.a(com.tencent.mm.plugin.appbrand.x.b.class, new com.tencent.mm.plugin.appbrand.luggage.c.b());
    paramc.a(f.class, com.tencent.mm.plugin.appbrand.jsapi.video.i.cvD());
    paramc.a(com.tencent.mm.plugin.appbrand.jsapi.al.e.h.class, e.a.cTG());
    paramc.a(com.tencent.mm.plugin.appbrand.ad.k.class, com.tencent.mm.plugin.appbrand.ad.d.qzu);
    paramc.a(com.tencent.luggage.sdk.customize.a.class, new com.tencent.mm.plugin.appbrand.luggage.b.b());
    paramc.a(c.class, com.tencent.mm.plugin.appbrand.networking.h.tpZ);
    paramc.a(com.tencent.mm.plugin.appbrand.permission.i.class, new com.tencent.mm.plugin.appbrand.task.a.d());
    paramc.a(com.tencent.mm.plugin.appbrand.widget.b.a.class, new bx());
    paramc = com.tencent.mm.ui.base.j.adPk;
    com.tencent.mm.ui.base.j.a(new o.2(this));
    com.tencent.mm.plugin.appbrand.jsapi.autofill.j.init();
    MediaCodecProxyUtils.a(new o.3(this));
    AppMethodBeat.o(44226);
  }
  
  public final void aqz()
  {
    AppMethodBeat.i(44228);
    if (this.qDC.FI(":appbrand"))
    {
      super.aqz();
      com.tencent.luggage.sdk.b.a.d.e.arL().a(new c.a(), com.tencent.mm.plugin.appbrand.service.b.class);
      com.tencent.luggage.sdk.b.a.d.e.arL().a(new com.tencent.luggage.game.d.a.a.a.b(), com.tencent.mm.plugin.appbrand.game.a.class);
      com.tencent.luggage.sdk.b.a.d.e.arL().a(com.tencent.luggage.sdk.b.a.d.k.esX, v.class);
    }
    AppMethodBeat.o(44228);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.o
 * JD-Core Version:    0.7.0.1
 */