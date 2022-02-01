package com.tencent.mm.plugin.appbrand.jsapi.aa.e;

import android.graphics.Point;
import android.view.Surface;
import android.webkit.ValueCallback;
import com.tencent.luggage.k.a.a.b.b.16;
import com.tencent.luggage.k.a.a.b.b.a;
import com.tencent.luggage.k.a.a.b.b.d;
import com.tencent.luggage.k.a.a.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.o.h;
import com.tencent.mm.plugin.appbrand.jsapi.o.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.sdk.platformtools.ad;

public final class j
  implements h
{
  public final com.tencent.luggage.k.a.a.b.b cnM;
  a kAM;
  
  public j(com.tencent.luggage.k.a.a.b.b paramb)
  {
    AppMethodBeat.i(177243);
    this.cnM = paramb;
    this.kAM = new a((byte)0);
    paramb.cnw = new com.tencent.luggage.k.a.a.b.a()
    {
      public final void ca(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(177222);
        if (j.this.kAM.kzM != null)
        {
          float f = paramAnonymousInt1 * 100.0F / paramAnonymousInt2;
          if ((f >= 99.0F) && (paramAnonymousInt2 - paramAnonymousInt1 <= 1000))
          {
            j.this.kAM.kzM.f(j.this.kAM);
            AppMethodBeat.o(177222);
            return;
          }
          j.this.kAM.kzM.a(j.this.kAM, f);
        }
        AppMethodBeat.o(177222);
      }
    };
    if (paramb.cmT != null) {
      paramb.cmT.a(paramb.cnw);
    }
    r local2 = new r()
    {
      public final void ET()
      {
        AppMethodBeat.i(177223);
        if (j.this.kAM.kzM != null)
        {
          ad.i("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "onLoading from XWebOnPlayListener");
          j.this.kAM.kzM.a(j.this.kAM);
        }
        AppMethodBeat.o(177223);
      }
      
      public final void EU()
      {
        AppMethodBeat.i(177224);
        if (j.this.kAM.kzM != null)
        {
          ad.i("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "onLoadEnd from XWebOnPlayListener");
          j.this.kAM.kzM.b(j.this.kAM);
        }
        AppMethodBeat.o(177224);
      }
      
      public final void EV()
      {
        AppMethodBeat.i(177229);
        if (j.this.kAM.kzM != null) {
          j.this.kAM.kzM.g(j.this.kAM);
        }
        AppMethodBeat.o(177229);
      }
      
      public final void bB(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(177225);
        if (j.this.kAM.kzM != null) {
          j.this.kAM.kzM.a(j.this.kAM, paramAnonymousBoolean);
        }
        AppMethodBeat.o(177225);
      }
      
      public final void onError()
      {
        AppMethodBeat.i(177227);
        if (j.this.kAM.kzM != null) {
          j.this.kAM.kzM.d(j.this.kAM);
        }
        AppMethodBeat.o(177227);
      }
      
      public final void onPause()
      {
        AppMethodBeat.i(177226);
        if (j.this.kAM.kzM != null) {
          j.this.kAM.kzM.c(j.this.kAM);
        }
        AppMethodBeat.o(177226);
      }
      
      public final void onStop()
      {
        AppMethodBeat.i(177228);
        if (j.this.kAM.kzM != null) {
          j.this.kAM.kzM.e(j.this.kAM);
        }
        AppMethodBeat.o(177228);
      }
    };
    paramb.ckN = local2;
    if (paramb.cmT != null) {
      paramb.cmT.a(local2);
    }
    AppMethodBeat.o(177243);
  }
  
  public final void a(aa paramaa, final h.a parama)
  {
    AppMethodBeat.i(195123);
    paramaa = paramaa.aOf();
    if (paramaa == null)
    {
      ad.w("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "getVideoPositionAsync, null == jsRuntime");
      parama.dQ(this.cnM.Fx(), this.cnM.Fy());
      AppMethodBeat.o(195123);
      return;
    }
    String str = "document.querySelector('embed[embed-id=\"" + this.cnM.getId() + "\"]').getBoundingClientRect().toJSON()";
    ad.i("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "getVideoPositionAsync, jsScript: ".concat(String.valueOf(str)));
    paramaa.evaluateJavascript(str, new ValueCallback() {});
    AppMethodBeat.o(195123);
  }
  
  public final int bbC()
  {
    AppMethodBeat.i(177244);
    com.tencent.luggage.k.a.a.b.b localb = this.cnM;
    int i = (int)(localb.cnx * localb.ckw);
    ad.d(localb.EE(), "getVideoContainerWidth, videoContainerWidth: ".concat(String.valueOf(i)));
    AppMethodBeat.o(177244);
    return i;
  }
  
  public final int bbD()
  {
    AppMethodBeat.i(177245);
    com.tencent.luggage.k.a.a.b.b localb = this.cnM;
    int i = (int)(localb.cny * localb.ckx);
    ad.d(localb.EE(), "getVideoContainerHeight, videoContainerHeight: ".concat(String.valueOf(i)));
    AppMethodBeat.o(177245);
    return i;
  }
  
  public final Point bbE()
  {
    AppMethodBeat.i(195122);
    Point localPoint = new Point(this.cnM.Fx(), this.cnM.Fy());
    AppMethodBeat.o(195122);
    return localPoint;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.o.j bbF()
  {
    return this.kAM;
  }
  
  public final c bfm()
  {
    com.tencent.mm.plugin.appbrand.jsapi.video.e.b localb = this.cnM.cmS;
    if (!(localb instanceof c)) {
      return null;
    }
    return (c)localb;
  }
  
  public final boolean f(Surface paramSurface)
  {
    AppMethodBeat.i(195124);
    boolean bool = this.cnM.f(paramSurface);
    AppMethodBeat.o(195124);
    return bool;
  }
  
  final class a
    implements com.tencent.mm.plugin.appbrand.jsapi.o.j
  {
    final String cjP;
    volatile boolean kAO;
    b.e kAP;
    b.f kAQ;
    b.b kAR;
    com.tencent.mm.plugin.appbrand.jsapi.o.j.a kzM;
    
    private a()
    {
      AppMethodBeat.i(177235);
      this.cjP = ("MicroMsg.AppBrand.XWebVideoVideoController#" + hashCode());
      this.kzM = null;
      this.kAO = false;
      this.kAP = new b.e()
      {
        public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramAnonymousb)
        {
          AppMethodBeat.i(195119);
          j.a.this.kAO = true;
          if (j.a.this.kzM != null)
          {
            ad.i(j.a.this.cjP, "onLoadEnd from OnPreparedListener");
            j.a.this.kzM.b(j.a.this);
          }
          AppMethodBeat.o(195119);
        }
      };
      this.kAQ = new b.f()
      {
        public final void b(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramAnonymousb)
        {
          AppMethodBeat.i(195120);
          if (j.a.this.kzM != null)
          {
            ad.i(j.a.this.cjP, "onLoadEnd from OnSeekCompleteListener");
            j.a.this.kzM.b(j.a.this);
          }
          AppMethodBeat.o(195120);
        }
      };
      this.kAR = new b.b()
      {
        public final void Fz()
        {
          AppMethodBeat.i(195121);
          if (j.a.this.kzM != null) {
            j.a.this.kzM.g(j.a.this);
          }
          AppMethodBeat.o(195121);
        }
      };
      this$1 = j.this.cnM;
      b.a local4 = new b.a()
      {
        public final void bG(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(177234);
          c localc = j.this.bfm();
          if (localc == null)
          {
            AppMethodBeat.o(177234);
            return;
          }
          j.a.this.kAO = paramAnonymousBoolean;
          localc.b(j.a.this.kAP);
          localc.b(j.a.this.kAQ);
          localc.b(j.a.this.kAR);
          AppMethodBeat.o(177234);
        }
      };
      j.this.cnv = local4;
      if (j.this.cmS != null) {
        local4.bG(j.this.cng);
      }
      AppMethodBeat.o(177235);
    }
    
    public final void a(com.tencent.mm.plugin.appbrand.jsapi.o.j.a parama)
    {
      AppMethodBeat.i(177242);
      if (parama != null)
      {
        if (this.kAO) {
          break label43;
        }
        ad.i(this.cjP, "onLoading from mPrepared");
        parama.a(this);
      }
      for (;;)
      {
        this.kzM = parama;
        AppMethodBeat.o(177242);
        return;
        label43:
        ad.i(this.cjP, "onLoadEnd from mPrepared");
        parama.b(this);
      }
    }
    
    public final Integer bbG()
    {
      Object localObject1 = null;
      AppMethodBeat.i(178858);
      com.tencent.luggage.k.a.a.b.b localb = j.this.cnM;
      Object localObject2 = localb.cku;
      if (localObject2 == null) {
        ad.w(localb.EE(), "getOriginPageViewId, invokeContext is null");
      }
      for (;;)
      {
        ad.d("MicroMsg.AppBrand.XWebVideoVideoController", "getOriginPageViewId, originPageViewId: ".concat(String.valueOf(localObject1)));
        AppMethodBeat.o(178858);
        return localObject1;
        localObject2 = com.tencent.luggage.k.a.a.b.f((com.tencent.luggage.k.a.a)localObject2);
        if (localObject2 == null) {
          ad.w(localb.EE(), "getOriginPageViewId, pageView is null");
        } else {
          localObject1 = Integer.valueOf(localObject2.hashCode());
        }
      }
    }
    
    public final boolean bbH()
    {
      return j.this.cnM.ckS;
    }
    
    public final String getKey()
    {
      AppMethodBeat.i(177236);
      String str = j.this.cnM.getKey();
      AppMethodBeat.o(177236);
      return str;
    }
    
    public final int getVideoHeight()
    {
      AppMethodBeat.i(177238);
      c localc = j.this.bfm();
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
      c localc = j.this.bfm();
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
      ad.d(this.cjP, "pause");
      j.this.cnM.Fs();
      AppMethodBeat.o(177240);
    }
    
    public final void release()
    {
      AppMethodBeat.i(177241);
      ad.d(this.cjP, "release");
      com.tencent.luggage.k.a.a.b.b localb = j.this.cnM;
      localb.k(new b.16(localb));
      AppMethodBeat.o(177241);
    }
    
    public final void start()
    {
      AppMethodBeat.i(177239);
      ad.d(this.cjP, "start");
      j.this.cnM.Fc();
      AppMethodBeat.o(177239);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.e.j
 * JD-Core Version:    0.7.0.1
 */