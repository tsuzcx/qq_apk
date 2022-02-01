package com.tencent.mm.plugin.appbrand.jsapi.z.e;

import android.graphics.Point;
import android.view.Surface;
import android.webkit.ValueCallback;
import com.tencent.luggage.k.a.a.b.b.16;
import com.tencent.luggage.k.a.a.b.b.a;
import com.tencent.luggage.k.a.a.b.b.d;
import com.tencent.luggage.k.a.a.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.n.g;
import com.tencent.mm.plugin.appbrand.jsapi.n.g.a;
import com.tencent.mm.plugin.appbrand.jsapi.n.i.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.sdk.platformtools.ac;

public final class j
  implements g
{
  public final com.tencent.luggage.k.a.a.b.b ckO;
  a lce;
  
  public j(com.tencent.luggage.k.a.a.b.b paramb)
  {
    AppMethodBeat.i(177243);
    this.ckO = paramb;
    this.lce = new a((byte)0);
    paramb.cky = new com.tencent.luggage.k.a.a.b.a()
    {
      public final void bX(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(177222);
        if (j.this.lce.lbd != null)
        {
          float f = paramAnonymousInt1 * 100.0F / paramAnonymousInt2;
          if ((f >= 99.0F) && (paramAnonymousInt2 - paramAnonymousInt1 <= 1000))
          {
            j.this.lce.lbd.f(j.this.lce);
            AppMethodBeat.o(177222);
            return;
          }
          j.this.lce.lbd.a(j.this.lce, f);
        }
        AppMethodBeat.o(177222);
      }
    };
    if (paramb.cjV != null) {
      paramb.cjV.a(paramb.cky);
    }
    n local2 = new n()
    {
      public final void Ex()
      {
        AppMethodBeat.i(177223);
        if (j.this.lce.lbd != null)
        {
          ac.i("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "onLoading from XWebOnPlayListener");
          j.this.lce.lbd.a(j.this.lce);
        }
        AppMethodBeat.o(177223);
      }
      
      public final void Ey()
      {
        AppMethodBeat.i(177224);
        if (j.this.lce.lbd != null)
        {
          ac.i("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "onLoadEnd from XWebOnPlayListener");
          j.this.lce.lbd.b(j.this.lce);
        }
        AppMethodBeat.o(177224);
      }
      
      public final void Ez()
      {
        AppMethodBeat.i(177229);
        if (j.this.lce.lbd != null) {
          j.this.lce.lbd.g(j.this.lce);
        }
        AppMethodBeat.o(177229);
      }
      
      public final void bA(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(177225);
        if (j.this.lce.lbd != null) {
          j.this.lce.lbd.a(j.this.lce, paramAnonymousBoolean);
        }
        AppMethodBeat.o(177225);
      }
      
      public final void onError()
      {
        AppMethodBeat.i(177227);
        if (j.this.lce.lbd != null) {
          j.this.lce.lbd.d(j.this.lce);
        }
        AppMethodBeat.o(177227);
      }
      
      public final void onPause()
      {
        AppMethodBeat.i(177226);
        if (j.this.lce.lbd != null) {
          j.this.lce.lbd.c(j.this.lce);
        }
        AppMethodBeat.o(177226);
      }
      
      public final void onStop()
      {
        AppMethodBeat.i(177228);
        if (j.this.lce.lbd != null) {
          j.this.lce.lbd.e(j.this.lce);
        }
        AppMethodBeat.o(177228);
      }
    };
    paramb.chP = local2;
    if (paramb.cjV != null) {
      paramb.cjV.a(local2);
    }
    AppMethodBeat.o(177243);
  }
  
  public final void a(aa paramaa, final g.a parama)
  {
    AppMethodBeat.i(206767);
    paramaa = paramaa.aUV();
    if (paramaa == null)
    {
      ac.w("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "getVideoPositionAsync, null == jsRuntime");
      parama.dR(this.ckO.Ff(), this.ckO.Fg());
      AppMethodBeat.o(206767);
      return;
    }
    String str = "document.querySelector('embed[embed-id=\"" + this.ckO.getId() + "\"]').getBoundingClientRect().toJSON()";
    ac.i("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "getVideoPositionAsync, jsScript: ".concat(String.valueOf(str)));
    paramaa.evaluateJavascript(str, new ValueCallback() {});
    AppMethodBeat.o(206767);
  }
  
  public final int biv()
  {
    AppMethodBeat.i(177244);
    com.tencent.luggage.k.a.a.b.b localb = this.ckO;
    int i = (int)(localb.ckz * localb.chv);
    ac.d(localb.getLogTag(), "getVideoContainerWidth, videoContainerWidth: ".concat(String.valueOf(i)));
    AppMethodBeat.o(177244);
    return i;
  }
  
  public final int biw()
  {
    AppMethodBeat.i(177245);
    com.tencent.luggage.k.a.a.b.b localb = this.ckO;
    int i = (int)(localb.ckA * localb.chw);
    ac.d(localb.getLogTag(), "getVideoContainerHeight, videoContainerHeight: ".concat(String.valueOf(i)));
    AppMethodBeat.o(177245);
    return i;
  }
  
  public final Point bix()
  {
    AppMethodBeat.i(206766);
    Point localPoint = new Point(this.ckO.Ff(), this.ckO.Fg());
    AppMethodBeat.o(206766);
    return localPoint;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.n.i biy()
  {
    return this.lce;
  }
  
  public final c bmg()
  {
    com.tencent.mm.plugin.appbrand.jsapi.video.e.b localb = this.ckO.cjU;
    if (!(localb instanceof c)) {
      return null;
    }
    return (c)localb;
  }
  
  public final boolean e(Surface paramSurface)
  {
    AppMethodBeat.i(206768);
    boolean bool = this.ckO.e(paramSurface);
    AppMethodBeat.o(206768);
    return bool;
  }
  
  final class a
    implements com.tencent.mm.plugin.appbrand.jsapi.n.i
  {
    final String cgL;
    i.a lbd;
    volatile boolean lcg;
    b.e lch;
    b.f lci;
    b.b lcj;
    
    private a()
    {
      AppMethodBeat.i(177235);
      this.cgL = ("MicroMsg.AppBrand.XWebVideoVideoController#" + hashCode());
      this.lbd = null;
      this.lcg = false;
      this.lch = new b.e()
      {
        public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramAnonymousb)
        {
          AppMethodBeat.i(206763);
          j.a.this.lcg = true;
          if (j.a.this.lbd != null)
          {
            ac.i(j.a.this.cgL, "onLoadEnd from OnPreparedListener");
            j.a.this.lbd.b(j.a.this);
          }
          AppMethodBeat.o(206763);
        }
      };
      this.lci = new b.f()
      {
        public final void b(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramAnonymousb)
        {
          AppMethodBeat.i(206764);
          if (j.a.this.lbd != null)
          {
            ac.i(j.a.this.cgL, "onLoadEnd from OnSeekCompleteListener");
            j.a.this.lbd.b(j.a.this);
            j.a.this.lbd.a(j.a.this, false);
          }
          AppMethodBeat.o(206764);
        }
      };
      this.lcj = new b.b()
      {
        public final void Fh()
        {
          AppMethodBeat.i(206765);
          if (j.a.this.lbd != null) {
            j.a.this.lbd.g(j.a.this);
          }
          AppMethodBeat.o(206765);
        }
      };
      this$1 = j.this.ckO;
      b.a local4 = new b.a()
      {
        public final void bG(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(177234);
          c localc = j.this.bmg();
          if (localc == null)
          {
            AppMethodBeat.o(177234);
            return;
          }
          j.a.this.lcg = paramAnonymousBoolean;
          localc.b(j.a.this.lch);
          localc.b(j.a.this.lci);
          localc.b(j.a.this.lcj);
          AppMethodBeat.o(177234);
        }
      };
      j.this.ckx = local4;
      if (j.this.cjU != null) {
        local4.bG(j.this.cki);
      }
      AppMethodBeat.o(177235);
    }
    
    public final void a(i.a parama)
    {
      AppMethodBeat.i(177242);
      if (parama != null)
      {
        if (this.lcg) {
          break label43;
        }
        ac.i(this.cgL, "onLoading from mPrepared");
        parama.a(this);
      }
      for (;;)
      {
        this.lbd = parama;
        AppMethodBeat.o(177242);
        return;
        label43:
        ac.i(this.cgL, "onLoadEnd from mPrepared");
        parama.b(this);
      }
    }
    
    public final boolean biA()
    {
      return j.this.ckO.chU;
    }
    
    public final Integer biz()
    {
      Object localObject1 = null;
      AppMethodBeat.i(178858);
      com.tencent.luggage.k.a.a.b.b localb = j.this.ckO;
      Object localObject2 = localb.cht;
      if (localObject2 == null) {
        ac.w(localb.getLogTag(), "getOriginPageViewId, invokeContext is null");
      }
      for (;;)
      {
        ac.d("MicroMsg.AppBrand.XWebVideoVideoController", "getOriginPageViewId, originPageViewId: ".concat(String.valueOf(localObject1)));
        AppMethodBeat.o(178858);
        return localObject1;
        localObject2 = com.tencent.luggage.k.a.a.b.e((com.tencent.luggage.k.a.a)localObject2);
        if (localObject2 == null) {
          ac.w(localb.getLogTag(), "getOriginPageViewId, pageView is null");
        } else {
          localObject1 = Integer.valueOf(localObject2.hashCode());
        }
      }
    }
    
    public final String getKey()
    {
      AppMethodBeat.i(177236);
      String str = j.this.ckO.getKey();
      AppMethodBeat.o(177236);
      return str;
    }
    
    public final int getVideoHeight()
    {
      AppMethodBeat.i(177238);
      c localc = j.this.bmg();
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
      c localc = j.this.bmg();
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
      ac.d(this.cgL, "pause");
      j.this.ckO.Fa();
      AppMethodBeat.o(177240);
    }
    
    public final void release()
    {
      AppMethodBeat.i(177241);
      ac.d(this.cgL, "release");
      com.tencent.luggage.k.a.a.b.b localb = j.this.ckO;
      localb.k(new b.16(localb));
      AppMethodBeat.o(177241);
    }
    
    public final void start()
    {
      AppMethodBeat.i(177239);
      ac.d(this.cgL, "start");
      j.this.ckO.EH();
      AppMethodBeat.o(177239);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.e.j
 * JD-Core Version:    0.7.0.1
 */