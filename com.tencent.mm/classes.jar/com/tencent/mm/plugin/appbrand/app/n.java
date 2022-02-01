package com.tencent.mm.plugin.appbrand.app;

import android.graphics.Bitmap;
import com.tencent.luggage.bridge.a.a.a;
import com.tencent.luggage.bridge.a.a.c;
import com.tencent.luggage.sdk.b.a.c.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.MediaCodecProxyUtils;
import com.tencent.mm.modelappbrand.a.b.g;
import com.tencent.mm.plugin.appbrand.ac.p.a;
import com.tencent.mm.plugin.appbrand.appcache.by;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.debugger.v;
import com.tencent.mm.plugin.appbrand.jsapi.video.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.l;
import com.tencent.mm.plugin.appbrand.media.record.h.a;
import com.tencent.mm.plugin.appbrand.networking.c;
import com.tencent.mm.plugin.appbrand.ui.ah;
import com.tencent.mm.plugin.appbrand.ui.p;
import com.tencent.mm.plugin.appbrand.utils.y;
import com.tencent.mm.plugin.appbrand.xweb_ext.video.e.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.InputStream;

final class n
  extends com.tencent.luggage.sdk.b
{
  com.tencent.luggage.bridge.a.a.b nDI;
  private final com.tencent.mm.kernel.b.g nDJ;
  
  public n(final com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(44225);
    this.nDI = null;
    this.nDJ = paramg;
    com.tencent.luggage.sdk.h.d.a("WeChatMultiProcessInitDelegateImpl<init>", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44217);
        Log.i("MicroMsg.WeChatMultiProcessInitDelegateImpl", "<init> %s", new Object[] { paramg.mProcessName });
        com.tencent.luggage.k.j localj = com.tencent.luggage.k.j.cEc;
        com.tencent.luggage.k.j.a(y.riX);
        com.tencent.mm.plugin.appbrand.media.record.h.a(new h.a()
        {
          public final void eG(String paramAnonymous2String)
          {
            AppMethodBeat.i(174700);
            com.tencent.mm.compatible.util.j.KW(paramAnonymous2String);
            AppMethodBeat.o(174700);
          }
        });
        com.tencent.mm.modelappbrand.a.b.SZ(com.tencent.mm.loader.j.b.aSL());
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
        AppBrandLocalMediaObjectManager.SZ(com.tencent.mm.loader.j.b.aSL());
        if ((MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()) || (PluginAppBrand.isAppBrandProcess()))
        {
          n.this.nDI = new com.tencent.mm.plugin.appbrand.luggage.a();
          AppMethodBeat.o(44217);
          return;
        }
        if (PluginAppBrand.isSupportProcess())
        {
          n.this.nDI = new com.tencent.mm.plugin.appbrand.luggage.b();
          AppMethodBeat.o(44217);
          return;
        }
        n.this.nDI = new com.tencent.luggage.bridge.a.a.b()
        {
          public final void a(a.a paramAnonymous2a) {}
          
          public final void a(a.c paramAnonymous2c) {}
        };
        AppMethodBeat.o(44217);
      }
    });
    AppMethodBeat.o(44225);
  }
  
  public final void Qp()
  {
    AppMethodBeat.i(44228);
    if (this.nDJ.MZ(":appbrand"))
    {
      super.Qp();
      com.tencent.luggage.sdk.b.a.c.e.Rx().a(new c.a(), com.tencent.mm.plugin.appbrand.service.b.class);
      com.tencent.luggage.sdk.b.a.c.e.Rx().a(new com.tencent.luggage.game.d.a.a.a.b(), com.tencent.mm.plugin.appbrand.game.a.class);
      com.tencent.luggage.sdk.b.a.c.e.Rx().a(com.tencent.luggage.sdk.b.a.c.k.cAC, v.class);
    }
    AppMethodBeat.o(44228);
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(44227);
    Log.i("MicroMsg.WeChatMultiProcessInitDelegateImpl", "onInitComponent %s", new Object[] { MMApplicationContext.getProcessName() });
    super.a(parama);
    this.nDI.a(parama);
    AppMethodBeat.o(44227);
  }
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(44226);
    Log.i("MicroMsg.WeChatMultiProcessInitDelegateImpl", "onInitialize %s", new Object[] { MMApplicationContext.getProcessName() });
    super.a(paramc);
    this.nDI.a(paramc);
    paramc.a(ah.class, p.qYV);
    paramc.a(p.a.class, new com.tencent.mm.plugin.appbrand.luggage.b.e(MMApplicationContext.getContext()));
    paramc.a(com.tencent.mm.plugin.appbrand.jsapi.video.g.class, new l());
    paramc.a(com.tencent.mm.plugin.appbrand.w.a.class, new com.tencent.mm.plugin.appbrand.luggage.c.a());
    paramc.a(com.tencent.mm.plugin.appbrand.w.b.class, new com.tencent.mm.plugin.appbrand.luggage.c.b());
    paramc.a(f.class, com.tencent.mm.plugin.appbrand.jsapi.video.i.bVn());
    paramc.a(com.tencent.mm.plugin.appbrand.jsapi.ai.e.h.class, e.a.cqZ());
    paramc.a(com.tencent.mm.plugin.appbrand.ad.k.class, com.tencent.mm.plugin.appbrand.ad.d.nAo);
    paramc.a(com.tencent.luggage.sdk.customize.a.class, new com.tencent.mm.plugin.appbrand.luggage.b.b());
    paramc.a(c.class, com.tencent.mm.plugin.appbrand.networking.h.qld);
    paramc.a(com.tencent.mm.plugin.appbrand.permission.i.class, new com.tencent.mm.plugin.appbrand.task.a.d());
    paramc.a(com.tencent.mm.plugin.appbrand.widget.a.a.class, new by());
    com.tencent.mm.plugin.appbrand.jsapi.autofill.j.init();
    MediaCodecProxyUtils.a(new n.2(this));
    AppMethodBeat.o(44226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.n
 * JD-Core Version:    0.7.0.1
 */