package com.tencent.mm.plugin.appbrand.jsapi.al.e;

import android.graphics.Point;
import android.view.Surface;
import android.webkit.ValueCallback;
import com.tencent.luggage.xweb_ext.extendplugin.component.s;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.c;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.c.26;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g.i;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.h;
import com.tencent.mm.plugin.appbrand.jsapi.w.g.a;
import com.tencent.mm.plugin.appbrand.jsapi.w.i.a;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.sdk.platformtools.Log;

public final class j
  implements com.tencent.mm.plugin.appbrand.jsapi.w.g
{
  public final c eEh;
  a sQT;
  
  public j(c paramc)
  {
    AppMethodBeat.i(177243);
    this.eEh = paramc;
    this.sQT = new a((byte)0);
    paramc.eDR = new a()
    {
      public final void dh(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(177222);
        if (j.this.sQT.sPS != null)
        {
          float f = paramAnonymousInt1 * 100.0F / paramAnonymousInt2;
          if ((f >= 99.0F) && (paramAnonymousInt2 - paramAnonymousInt1 <= 1000))
          {
            j.this.sQT.sPS.f(j.this.sQT);
            AppMethodBeat.o(177222);
            return;
          }
          j.this.sQT.sPS.a(j.this.sQT, f);
        }
        AppMethodBeat.o(177222);
      }
    };
    if (paramc.eDj != null) {
      paramc.eDj.a(paramc.eDR);
    }
    s local2 = new s()
    {
      public final void atP()
      {
        AppMethodBeat.i(177223);
        if (j.this.sQT.sPS != null)
        {
          Log.i("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "onLoading from XWebOnPlayListener");
          j.this.sQT.sPS.a(j.this.sQT);
        }
        AppMethodBeat.o(177223);
      }
      
      public final void atQ()
      {
        AppMethodBeat.i(177224);
        if (j.this.sQT.sPS != null)
        {
          Log.i("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "onLoadEnd from XWebOnPlayListener");
          j.this.sQT.sPS.b(j.this.sQT);
        }
        AppMethodBeat.o(177224);
      }
      
      public final void atR()
      {
        AppMethodBeat.i(177227);
        if (j.this.sQT.sPS != null) {
          j.this.sQT.sPS.d(j.this.sQT);
        }
        AppMethodBeat.o(177227);
      }
      
      public final void atS()
      {
        AppMethodBeat.i(177229);
        if (j.this.sQT.sPS != null) {
          j.this.sQT.sPS.g(j.this.sQT);
        }
        AppMethodBeat.o(177229);
      }
      
      public final void cS(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(177225);
        if (j.this.sQT.sPS != null) {
          j.this.sQT.sPS.a(j.this.sQT, paramAnonymousBoolean);
        }
        AppMethodBeat.o(177225);
      }
      
      public final void onPause()
      {
        AppMethodBeat.i(177226);
        if (j.this.sQT.sPS != null) {
          j.this.sQT.sPS.c(j.this.sQT);
        }
        AppMethodBeat.o(177226);
      }
      
      public final void onStop()
      {
        AppMethodBeat.i(177228);
        if (j.this.sQT.sPS != null) {
          j.this.sQT.sPS.e(j.this.sQT);
        }
        AppMethodBeat.o(177228);
      }
    };
    paramc.eyR = local2;
    if (paramc.eDj != null) {
      paramc.eDj.a(local2);
    }
    AppMethodBeat.o(177243);
  }
  
  public final void a(ad paramad, final g.a parama)
  {
    AppMethodBeat.i(327161);
    paramad = paramad.getJsRuntime();
    if (paramad == null)
    {
      Log.w("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "getVideoPositionAsync, null == jsRuntime");
      parama.fx(this.eEh.auJ(), this.eEh.auK());
      AppMethodBeat.o(327161);
      return;
    }
    String str = "document.querySelector('embed[embed-id=\"" + this.eEh.getId() + "\"]').getBoundingClientRect().toJSON()";
    Log.i("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "getVideoPositionAsync, jsScript: ".concat(String.valueOf(str)));
    paramad.evaluateJavascript(str, new ValueCallback() {});
    AppMethodBeat.o(327161);
  }
  
  public final int auH()
  {
    AppMethodBeat.i(177244);
    int i = this.eEh.auH();
    AppMethodBeat.o(177244);
    return i;
  }
  
  public final int auI()
  {
    AppMethodBeat.i(177245);
    int i = this.eEh.auI();
    AppMethodBeat.o(177245);
    return i;
  }
  
  public final Point cum()
  {
    AppMethodBeat.i(327159);
    Point localPoint = new Point(this.eEh.auJ(), this.eEh.auK());
    AppMethodBeat.o(327159);
    return localPoint;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.w.i cun()
  {
    return this.sQT;
  }
  
  public final h cyU()
  {
    com.tencent.mm.plugin.appbrand.jsapi.video.e.g localg = this.eEh.eDi;
    if (!(localg instanceof h)) {
      return null;
    }
    return (h)localg;
  }
  
  public final boolean j(Surface paramSurface)
  {
    AppMethodBeat.i(327167);
    boolean bool = this.eEh.j(paramSurface);
    AppMethodBeat.o(327167);
    return bool;
  }
  
  final class a
    implements com.tencent.mm.plugin.appbrand.jsapi.w.i
  {
    final String exO;
    i.a sPS;
    volatile boolean sQV;
    g.h sQW;
    g.i sQX;
    g.b sQY;
    
    private a()
    {
      AppMethodBeat.i(177235);
      this.exO = ("MicroMsg.AppBrand.XWebVideoVideoController#" + hashCode());
      this.sPS = null;
      this.sQV = false;
      this.sQW = new g.h()
      {
        public final void onPrepared(com.tencent.mm.plugin.appbrand.jsapi.video.e.g paramAnonymousg)
        {
          AppMethodBeat.i(327157);
          j.a.this.sQV = true;
          if (j.a.this.sPS != null)
          {
            Log.i(j.a.this.exO, "onLoadEnd from OnPreparedListener");
            j.a.this.sPS.b(j.a.this);
          }
          AppMethodBeat.o(327157);
        }
      };
      this.sQX = new g.i()
      {
        public final void onSeekComplete(com.tencent.mm.plugin.appbrand.jsapi.video.e.g paramAnonymousg)
        {
          AppMethodBeat.i(327150);
          if (j.a.this.sPS != null)
          {
            Log.i(j.a.this.exO, "onLoadEnd from OnSeekCompleteListener");
            j.a.this.sPS.b(j.a.this);
            j.a.this.sPS.a(j.a.this, false);
          }
          AppMethodBeat.o(327150);
        }
      };
      this.sQY = new g.b()
      {
        public final void onCompletion(com.tencent.mm.plugin.appbrand.jsapi.video.e.g paramAnonymousg)
        {
          AppMethodBeat.i(327152);
          if (j.a.this.sPS != null) {
            j.a.this.sPS.g(j.a.this);
          }
          AppMethodBeat.o(327152);
        }
      };
      this$1 = j.this.eEh;
      c.b local4 = new c.b()
      {
        public final void cY(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(177234);
          h localh = j.this.cyU();
          if (localh == null)
          {
            AppMethodBeat.o(177234);
            return;
          }
          j.a.this.sQV = paramAnonymousBoolean;
          localh.b(j.a.this.sQW);
          localh.b(j.a.this.sQX);
          localh.b(j.a.this.sQY);
          AppMethodBeat.o(177234);
        }
      };
      j.this.eDQ = local4;
      if (j.this.eDi != null) {
        local4.cY(j.this.eDw);
      }
      AppMethodBeat.o(177235);
    }
    
    public final void a(i.a parama)
    {
      AppMethodBeat.i(177242);
      if (parama != null)
      {
        if (this.sQV) {
          break label43;
        }
        Log.i(this.exO, "onLoading from mPrepared");
        parama.a(this);
      }
      for (;;)
      {
        this.sPS = parama;
        AppMethodBeat.o(177242);
        return;
        label43:
        Log.i(this.exO, "onLoadEnd from mPrepared");
        parama.b(this);
      }
    }
    
    public final Integer auG()
    {
      AppMethodBeat.i(178858);
      Integer localInteger = j.this.eEh.auG();
      Log.d("MicroMsg.AppBrand.XWebVideoVideoController", "getOriginPageViewId, originPageViewId: ".concat(String.valueOf(localInteger)));
      AppMethodBeat.o(178858);
      return localInteger;
    }
    
    public final boolean cuo()
    {
      return j.this.eEh.eyW;
    }
    
    public final String getKey()
    {
      AppMethodBeat.i(177236);
      String str = j.this.eEh.getKey();
      AppMethodBeat.o(177236);
      return str;
    }
    
    public final int getVideoHeight()
    {
      AppMethodBeat.i(177238);
      h localh = j.this.cyU();
      if (localh == null)
      {
        AppMethodBeat.o(177238);
        return 0;
      }
      int i = localh.getVideoHeight();
      AppMethodBeat.o(177238);
      return i;
    }
    
    public final int getVideoWidth()
    {
      AppMethodBeat.i(177237);
      h localh = j.this.cyU();
      if (localh == null)
      {
        AppMethodBeat.o(177237);
        return 0;
      }
      int i = localh.getVideoWidth();
      AppMethodBeat.o(177237);
      return i;
    }
    
    public final void pause()
    {
      AppMethodBeat.i(177240);
      Log.d(this.exO, "pause");
      j.this.eEh.auB();
      AppMethodBeat.o(177240);
    }
    
    public final void release()
    {
      AppMethodBeat.i(177241);
      Log.d(this.exO, "release");
      c localc = j.this.eEh;
      localc.o(new c.26(localc));
      AppMethodBeat.o(177241);
    }
    
    public final void start()
    {
      AppMethodBeat.i(177239);
      Log.d(this.exO, "start");
      j.this.eEh.aua();
      AppMethodBeat.o(177239);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.e.j
 * JD-Core Version:    0.7.0.1
 */