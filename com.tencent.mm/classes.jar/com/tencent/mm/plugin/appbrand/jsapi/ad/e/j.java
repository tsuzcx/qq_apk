package com.tencent.mm.plugin.appbrand.jsapi.ad.e;

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
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.sdk.platformtools.ae;

public final class j
  implements g
{
  public final com.tencent.luggage.xweb_ext.extendplugin.component.video.c cvU;
  a lDC;
  
  public j(com.tencent.luggage.xweb_ext.extendplugin.component.video.c paramc)
  {
    AppMethodBeat.i(177243);
    this.cvU = paramc;
    this.lDC = new a((byte)0);
    paramc.cvE = new com.tencent.luggage.xweb_ext.extendplugin.component.video.a()
    {
      public final void bZ(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(177222);
        if (j.this.lDC.lCC != null)
        {
          float f = paramAnonymousInt1 * 100.0F / paramAnonymousInt2;
          if ((f >= 99.0F) && (paramAnonymousInt2 - paramAnonymousInt1 <= 1000))
          {
            j.this.lDC.lCC.f(j.this.lDC);
            AppMethodBeat.o(177222);
            return;
          }
          j.this.lDC.lCC.a(j.this.lDC, f);
        }
        AppMethodBeat.o(177222);
      }
    };
    if (paramc.cuY != null) {
      paramc.cuY.a(paramc.cvE);
    }
    s local2 = new s()
    {
      public final void Gc()
      {
        AppMethodBeat.i(177223);
        if (j.this.lDC.lCC != null)
        {
          ae.i("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "onLoading from XWebOnPlayListener");
          j.this.lDC.lCC.a(j.this.lDC);
        }
        AppMethodBeat.o(177223);
      }
      
      public final void Gd()
      {
        AppMethodBeat.i(177224);
        if (j.this.lDC.lCC != null)
        {
          ae.i("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "onLoadEnd from XWebOnPlayListener");
          j.this.lDC.lCC.b(j.this.lDC);
        }
        AppMethodBeat.o(177224);
      }
      
      public final void Ge()
      {
        AppMethodBeat.i(177229);
        if (j.this.lDC.lCC != null) {
          j.this.lDC.lCC.g(j.this.lDC);
        }
        AppMethodBeat.o(177229);
      }
      
      public final void bA(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(177225);
        if (j.this.lDC.lCC != null) {
          j.this.lDC.lCC.a(j.this.lDC, paramAnonymousBoolean);
        }
        AppMethodBeat.o(177225);
      }
      
      public final void onError()
      {
        AppMethodBeat.i(177227);
        if (j.this.lDC.lCC != null) {
          j.this.lDC.lCC.d(j.this.lDC);
        }
        AppMethodBeat.o(177227);
      }
      
      public final void onPause()
      {
        AppMethodBeat.i(177226);
        if (j.this.lDC.lCC != null) {
          j.this.lDC.lCC.c(j.this.lDC);
        }
        AppMethodBeat.o(177226);
      }
      
      public final void onStop()
      {
        AppMethodBeat.i(177228);
        if (j.this.lDC.lCC != null) {
          j.this.lDC.lCC.e(j.this.lDC);
        }
        AppMethodBeat.o(177228);
      }
    };
    paramc.csH = local2;
    if (paramc.cuY != null) {
      paramc.cuY.a(local2);
    }
    AppMethodBeat.o(177243);
  }
  
  public final void a(z paramz, final g.a parama)
  {
    AppMethodBeat.i(220653);
    paramz = paramz.aYB();
    if (paramz == null)
    {
      ae.w("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "getVideoPositionAsync, null == jsRuntime");
      parama.dT(this.cvU.GF(), this.cvU.GG());
      AppMethodBeat.o(220653);
      return;
    }
    String str = "document.querySelector('embed[embed-id=\"" + this.cvU.getId() + "\"]').getBoundingClientRect().toJSON()";
    ae.i("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "getVideoPositionAsync, jsScript: ".concat(String.valueOf(str)));
    paramz.evaluateJavascript(str, new ValueCallback() {});
    AppMethodBeat.o(220653);
  }
  
  public final int bmQ()
  {
    AppMethodBeat.i(177244);
    com.tencent.luggage.xweb_ext.extendplugin.component.video.c localc = this.cvU;
    int i = (int)(localc.cvF * localc.csq);
    ae.d(localc.getLogTag(), "getVideoContainerWidth, videoContainerWidth: ".concat(String.valueOf(i)));
    AppMethodBeat.o(177244);
    return i;
  }
  
  public final int bmR()
  {
    AppMethodBeat.i(177245);
    com.tencent.luggage.xweb_ext.extendplugin.component.video.c localc = this.cvU;
    int i = (int)(localc.cvG * localc.csr);
    ae.d(localc.getLogTag(), "getVideoContainerHeight, videoContainerHeight: ".concat(String.valueOf(i)));
    AppMethodBeat.o(177245);
    return i;
  }
  
  public final Point bmS()
  {
    AppMethodBeat.i(220652);
    Point localPoint = new Point(this.cvU.GF(), this.cvU.GG());
    AppMethodBeat.o(220652);
    return localPoint;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.q.i bmT()
  {
    return this.lDC;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.video.e.c bqB()
  {
    com.tencent.mm.plugin.appbrand.jsapi.video.e.b localb = this.cvU.cuX;
    if (!(localb instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.c)) {
      return null;
    }
    return (com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localb;
  }
  
  public final boolean e(Surface paramSurface)
  {
    AppMethodBeat.i(220654);
    boolean bool = this.cvU.e(paramSurface);
    AppMethodBeat.o(220654);
    return bool;
  }
  
  final class a
    implements com.tencent.mm.plugin.appbrand.jsapi.q.i
  {
    final String crG;
    i.a lCC;
    volatile boolean lDE;
    b.f lDF;
    b.g lDG;
    b.b lDH;
    
    private a()
    {
      AppMethodBeat.i(177235);
      this.crG = ("MicroMsg.AppBrand.XWebVideoVideoController#" + hashCode());
      this.lCC = null;
      this.lDE = false;
      this.lDF = new b.f()
      {
        public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramAnonymousb)
        {
          AppMethodBeat.i(220649);
          j.a.this.lDE = true;
          if (j.a.this.lCC != null)
          {
            ae.i(j.a.this.crG, "onLoadEnd from OnPreparedListener");
            j.a.this.lCC.b(j.a.this);
          }
          AppMethodBeat.o(220649);
        }
      };
      this.lDG = new b.g()
      {
        public final void b(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramAnonymousb)
        {
          AppMethodBeat.i(220650);
          if (j.a.this.lCC != null)
          {
            ae.i(j.a.this.crG, "onLoadEnd from OnSeekCompleteListener");
            j.a.this.lCC.b(j.a.this);
            j.a.this.lCC.a(j.a.this, false);
          }
          AppMethodBeat.o(220650);
        }
      };
      this.lDH = new b.b()
      {
        public final void GH()
        {
          AppMethodBeat.i(220651);
          if (j.a.this.lCC != null) {
            j.a.this.lCC.g(j.a.this);
          }
          AppMethodBeat.o(220651);
        }
      };
      this$1 = j.this.cvU;
      c.b local4 = new c.b()
      {
        public final void bG(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(177234);
          com.tencent.mm.plugin.appbrand.jsapi.video.e.c localc = j.this.bqB();
          if (localc == null)
          {
            AppMethodBeat.o(177234);
            return;
          }
          j.a.this.lDE = paramAnonymousBoolean;
          localc.b(j.a.this.lDF);
          localc.b(j.a.this.lDG);
          localc.b(j.a.this.lDH);
          AppMethodBeat.o(177234);
        }
      };
      j.this.cvD = local4;
      if (j.this.cuX != null) {
        local4.bG(j.this.cvl);
      }
      AppMethodBeat.o(177235);
    }
    
    public final void a(i.a parama)
    {
      AppMethodBeat.i(177242);
      if (parama != null)
      {
        if (this.lDE) {
          break label43;
        }
        ae.i(this.crG, "onLoading from mPrepared");
        parama.a(this);
      }
      for (;;)
      {
        this.lCC = parama;
        AppMethodBeat.o(177242);
        return;
        label43:
        ae.i(this.crG, "onLoadEnd from mPrepared");
        parama.b(this);
      }
    }
    
    public final Integer bmU()
    {
      Object localObject1 = null;
      AppMethodBeat.i(178858);
      com.tencent.luggage.xweb_ext.extendplugin.component.video.c localc = j.this.cvU;
      Object localObject2 = localc.cso;
      if (localObject2 == null) {
        ae.w(localc.getLogTag(), "getOriginPageViewId, invokeContext is null");
      }
      for (;;)
      {
        ae.d("MicroMsg.AppBrand.XWebVideoVideoController", "getOriginPageViewId, originPageViewId: ".concat(String.valueOf(localObject1)));
        AppMethodBeat.o(178858);
        return localObject1;
        localObject2 = com.tencent.luggage.xweb_ext.extendplugin.component.b.e((com.tencent.luggage.xweb_ext.extendplugin.a)localObject2);
        if (localObject2 == null) {
          ae.w(localc.getLogTag(), "getOriginPageViewId, pageView is null");
        } else {
          localObject1 = Integer.valueOf(localObject2.hashCode());
        }
      }
    }
    
    public final boolean bmV()
    {
      return j.this.cvU.csM;
    }
    
    public final String getKey()
    {
      AppMethodBeat.i(177236);
      String str = j.this.cvU.getKey();
      AppMethodBeat.o(177236);
      return str;
    }
    
    public final int getVideoHeight()
    {
      AppMethodBeat.i(177238);
      com.tencent.mm.plugin.appbrand.jsapi.video.e.c localc = j.this.bqB();
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
      com.tencent.mm.plugin.appbrand.jsapi.video.e.c localc = j.this.bqB();
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
      ae.d(this.crG, "pause");
      j.this.cvU.GA();
      AppMethodBeat.o(177240);
    }
    
    public final void release()
    {
      AppMethodBeat.i(177241);
      ae.d(this.crG, "release");
      com.tencent.luggage.xweb_ext.extendplugin.component.video.c localc = j.this.cvU;
      localc.k(new c.16(localc));
      AppMethodBeat.o(177241);
    }
    
    public final void start()
    {
      AppMethodBeat.i(177239);
      ae.d(this.crG, "start");
      j.this.cvU.Gl();
      AppMethodBeat.o(177239);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.e.j
 * JD-Core Version:    0.7.0.1
 */