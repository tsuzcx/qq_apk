package com.tencent.mm.plugin.appbrand.jsapi.ac.e;

import android.graphics.Point;
import android.view.Surface;
import android.webkit.ValueCallback;
import com.tencent.luggage.xweb_ext.extendplugin.component.s;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.c.16;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.q.g;
import com.tencent.mm.plugin.appbrand.jsapi.q.g.a;
import com.tencent.mm.plugin.appbrand.jsapi.q.i.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.sdk.platformtools.ad;

public final class j
  implements g
{
  public final com.tencent.luggage.xweb_ext.extendplugin.component.video.c cvq;
  a lze;
  
  public j(com.tencent.luggage.xweb_ext.extendplugin.component.video.c paramc)
  {
    AppMethodBeat.i(177243);
    this.cvq = paramc;
    this.lze = new a((byte)0);
    paramc.cvb = new com.tencent.luggage.xweb_ext.extendplugin.component.video.a()
    {
      public final void bZ(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(177222);
        if (j.this.lze.lye != null)
        {
          float f = paramAnonymousInt1 * 100.0F / paramAnonymousInt2;
          if ((f >= 99.0F) && (paramAnonymousInt2 - paramAnonymousInt1 <= 1000))
          {
            j.this.lze.lye.f(j.this.lze);
            AppMethodBeat.o(177222);
            return;
          }
          j.this.lze.lye.a(j.this.lze, f);
        }
        AppMethodBeat.o(177222);
      }
    };
    if (paramc.cuv != null) {
      paramc.cuv.a(paramc.cvb);
    }
    s local2 = new s()
    {
      public final void FW()
      {
        AppMethodBeat.i(177223);
        if (j.this.lze.lye != null)
        {
          ad.i("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "onLoading from XWebOnPlayListener");
          j.this.lze.lye.a(j.this.lze);
        }
        AppMethodBeat.o(177223);
      }
      
      public final void FX()
      {
        AppMethodBeat.i(177224);
        if (j.this.lze.lye != null)
        {
          ad.i("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "onLoadEnd from XWebOnPlayListener");
          j.this.lze.lye.b(j.this.lze);
        }
        AppMethodBeat.o(177224);
      }
      
      public final void FY()
      {
        AppMethodBeat.i(177229);
        if (j.this.lze.lye != null) {
          j.this.lze.lye.g(j.this.lze);
        }
        AppMethodBeat.o(177229);
      }
      
      public final void bA(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(177225);
        if (j.this.lze.lye != null) {
          j.this.lze.lye.a(j.this.lze, paramAnonymousBoolean);
        }
        AppMethodBeat.o(177225);
      }
      
      public final void onError()
      {
        AppMethodBeat.i(177227);
        if (j.this.lze.lye != null) {
          j.this.lze.lye.d(j.this.lze);
        }
        AppMethodBeat.o(177227);
      }
      
      public final void onPause()
      {
        AppMethodBeat.i(177226);
        if (j.this.lze.lye != null) {
          j.this.lze.lye.c(j.this.lze);
        }
        AppMethodBeat.o(177226);
      }
      
      public final void onStop()
      {
        AppMethodBeat.i(177228);
        if (j.this.lze.lye != null) {
          j.this.lze.lye.e(j.this.lze);
        }
        AppMethodBeat.o(177228);
      }
    };
    paramc.cse = local2;
    if (paramc.cuv != null) {
      paramc.cuv.a(local2);
    }
    AppMethodBeat.o(177243);
  }
  
  public final void a(aa paramaa, final g.a parama)
  {
    AppMethodBeat.i(186955);
    paramaa = paramaa.aYh();
    if (paramaa == null)
    {
      ad.w("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "getVideoPositionAsync, null == jsRuntime");
      parama.dT(this.cvq.Gz(), this.cvq.GA());
      AppMethodBeat.o(186955);
      return;
    }
    String str = "document.querySelector('embed[embed-id=\"" + this.cvq.getId() + "\"]').getBoundingClientRect().toJSON()";
    ad.i("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "getVideoPositionAsync, jsScript: ".concat(String.valueOf(str)));
    paramaa.evaluateJavascript(str, new ValueCallback() {});
    AppMethodBeat.o(186955);
  }
  
  public final int bmh()
  {
    AppMethodBeat.i(177244);
    com.tencent.luggage.xweb_ext.extendplugin.component.video.c localc = this.cvq;
    int i = (int)(localc.cvc * localc.crN);
    ad.d(localc.getLogTag(), "getVideoContainerWidth, videoContainerWidth: ".concat(String.valueOf(i)));
    AppMethodBeat.o(177244);
    return i;
  }
  
  public final int bmi()
  {
    AppMethodBeat.i(177245);
    com.tencent.luggage.xweb_ext.extendplugin.component.video.c localc = this.cvq;
    int i = (int)(localc.cvd * localc.crO);
    ad.d(localc.getLogTag(), "getVideoContainerHeight, videoContainerHeight: ".concat(String.valueOf(i)));
    AppMethodBeat.o(177245);
    return i;
  }
  
  public final Point bmj()
  {
    AppMethodBeat.i(186954);
    Point localPoint = new Point(this.cvq.Gz(), this.cvq.GA());
    AppMethodBeat.o(186954);
    return localPoint;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.q.i bmk()
  {
    return this.lze;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.video.e.c bpR()
  {
    com.tencent.mm.plugin.appbrand.jsapi.video.e.b localb = this.cvq.cuu;
    if (!(localb instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.c)) {
      return null;
    }
    return (com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localb;
  }
  
  public final boolean e(Surface paramSurface)
  {
    AppMethodBeat.i(186956);
    boolean bool = this.cvq.e(paramSurface);
    AppMethodBeat.o(186956);
    return bool;
  }
  
  final class a
    implements com.tencent.mm.plugin.appbrand.jsapi.q.i
  {
    final String crd;
    i.a lye;
    volatile boolean lzg;
    b.f lzh;
    b.g lzi;
    b.b lzj;
    
    private a()
    {
      AppMethodBeat.i(177235);
      this.crd = ("MicroMsg.AppBrand.XWebVideoVideoController#" + hashCode());
      this.lye = null;
      this.lzg = false;
      this.lzh = new b.f()
      {
        public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramAnonymousb)
        {
          AppMethodBeat.i(186951);
          j.a.this.lzg = true;
          if (j.a.this.lye != null)
          {
            ad.i(j.a.this.crd, "onLoadEnd from OnPreparedListener");
            j.a.this.lye.b(j.a.this);
          }
          AppMethodBeat.o(186951);
        }
      };
      this.lzi = new b.g()
      {
        public final void b(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramAnonymousb)
        {
          AppMethodBeat.i(186952);
          if (j.a.this.lye != null)
          {
            ad.i(j.a.this.crd, "onLoadEnd from OnSeekCompleteListener");
            j.a.this.lye.b(j.a.this);
            j.a.this.lye.a(j.a.this, false);
          }
          AppMethodBeat.o(186952);
        }
      };
      this.lzj = new b.b()
      {
        public final void GB()
        {
          AppMethodBeat.i(186953);
          if (j.a.this.lye != null) {
            j.a.this.lye.g(j.a.this);
          }
          AppMethodBeat.o(186953);
        }
      };
      this$1 = j.this.cvq;
      c.b local4 = new c.b()
      {
        public final void bG(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(177234);
          com.tencent.mm.plugin.appbrand.jsapi.video.e.c localc = j.this.bpR();
          if (localc == null)
          {
            AppMethodBeat.o(177234);
            return;
          }
          j.a.this.lzg = paramAnonymousBoolean;
          localc.b(j.a.this.lzh);
          localc.b(j.a.this.lzi);
          localc.b(j.a.this.lzj);
          AppMethodBeat.o(177234);
        }
      };
      j.this.cva = local4;
      if (j.this.cuu != null) {
        local4.bG(j.this.cuI);
      }
      AppMethodBeat.o(177235);
    }
    
    public final void a(i.a parama)
    {
      AppMethodBeat.i(177242);
      if (parama != null)
      {
        if (this.lzg) {
          break label43;
        }
        ad.i(this.crd, "onLoading from mPrepared");
        parama.a(this);
      }
      for (;;)
      {
        this.lye = parama;
        AppMethodBeat.o(177242);
        return;
        label43:
        ad.i(this.crd, "onLoadEnd from mPrepared");
        parama.b(this);
      }
    }
    
    public final Integer bml()
    {
      Object localObject1 = null;
      AppMethodBeat.i(178858);
      com.tencent.luggage.xweb_ext.extendplugin.component.video.c localc = j.this.cvq;
      Object localObject2 = localc.crL;
      if (localObject2 == null) {
        ad.w(localc.getLogTag(), "getOriginPageViewId, invokeContext is null");
      }
      for (;;)
      {
        ad.d("MicroMsg.AppBrand.XWebVideoVideoController", "getOriginPageViewId, originPageViewId: ".concat(String.valueOf(localObject1)));
        AppMethodBeat.o(178858);
        return localObject1;
        localObject2 = com.tencent.luggage.xweb_ext.extendplugin.component.b.e((com.tencent.luggage.xweb_ext.extendplugin.a)localObject2);
        if (localObject2 == null) {
          ad.w(localc.getLogTag(), "getOriginPageViewId, pageView is null");
        } else {
          localObject1 = Integer.valueOf(localObject2.hashCode());
        }
      }
    }
    
    public final boolean bmm()
    {
      return j.this.cvq.csj;
    }
    
    public final String getKey()
    {
      AppMethodBeat.i(177236);
      String str = j.this.cvq.getKey();
      AppMethodBeat.o(177236);
      return str;
    }
    
    public final int getVideoHeight()
    {
      AppMethodBeat.i(177238);
      com.tencent.mm.plugin.appbrand.jsapi.video.e.c localc = j.this.bpR();
      if (localc == null)
      {
        AppMethodBeat.o(177238);
        return 0;
      }
      int i = localc.getVideoHeight();
      AppMethodBeat.o(177238);
      return i;
    }
    
    public final int getVideoWidth()
    {
      AppMethodBeat.i(177237);
      com.tencent.mm.plugin.appbrand.jsapi.video.e.c localc = j.this.bpR();
      if (localc == null)
      {
        AppMethodBeat.o(177237);
        return 0;
      }
      int i = localc.getVideoWidth();
      AppMethodBeat.o(177237);
      return i;
    }
    
    public final void pause()
    {
      AppMethodBeat.i(177240);
      ad.d(this.crd, "pause");
      j.this.cvq.Gu();
      AppMethodBeat.o(177240);
    }
    
    public final void release()
    {
      AppMethodBeat.i(177241);
      ad.d(this.crd, "release");
      com.tencent.luggage.xweb_ext.extendplugin.component.video.c localc = j.this.cvq;
      localc.k(new c.16(localc));
      AppMethodBeat.o(177241);
    }
    
    public final void start()
    {
      AppMethodBeat.i(177239);
      ad.d(this.crd, "start");
      j.this.cvq.Gf();
      AppMethodBeat.o(177239);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.e.j
 * JD-Core Version:    0.7.0.1
 */