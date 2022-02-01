package com.tencent.mm.plugin.appbrand.jsapi.ai.e;

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
import com.tencent.mm.plugin.appbrand.jsapi.t.g;
import com.tencent.mm.plugin.appbrand.jsapi.t.g.a;
import com.tencent.mm.plugin.appbrand.jsapi.t.i.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e.i;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.f;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.sdk.platformtools.Log;

public final class j
  implements g
{
  public final c cKw;
  a pMd;
  
  public j(c paramc)
  {
    AppMethodBeat.i(177243);
    this.cKw = paramc;
    this.pMd = new a((byte)0);
    paramc.cKg = new a()
    {
      public final void cs(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(177222);
        if (j.this.pMd.pKZ != null)
        {
          float f = paramAnonymousInt1 * 100.0F / paramAnonymousInt2;
          if ((f >= 99.0F) && (paramAnonymousInt2 - paramAnonymousInt1 <= 1000))
          {
            j.this.pMd.pKZ.f(j.this.pMd);
            AppMethodBeat.o(177222);
            return;
          }
          j.this.pMd.pKZ.a(j.this.pMd, f);
        }
        AppMethodBeat.o(177222);
      }
    };
    if (paramc.cJA != null) {
      paramc.cJA.a(paramc.cKg);
    }
    s local2 = new s()
    {
      public final void Tk()
      {
        AppMethodBeat.i(177223);
        if (j.this.pMd.pKZ != null)
        {
          Log.i("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "onLoading from XWebOnPlayListener");
          j.this.pMd.pKZ.a(j.this.pMd);
        }
        AppMethodBeat.o(177223);
      }
      
      public final void Tl()
      {
        AppMethodBeat.i(177224);
        if (j.this.pMd.pKZ != null)
        {
          Log.i("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "onLoadEnd from XWebOnPlayListener");
          j.this.pMd.pKZ.b(j.this.pMd);
        }
        AppMethodBeat.o(177224);
      }
      
      public final void Tm()
      {
        AppMethodBeat.i(177229);
        if (j.this.pMd.pKZ != null) {
          j.this.pMd.pKZ.g(j.this.pMd);
        }
        AppMethodBeat.o(177229);
      }
      
      public final void cm(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(177225);
        if (j.this.pMd.pKZ != null) {
          j.this.pMd.pKZ.a(j.this.pMd, paramAnonymousBoolean);
        }
        AppMethodBeat.o(177225);
      }
      
      public final void onError()
      {
        AppMethodBeat.i(177227);
        if (j.this.pMd.pKZ != null) {
          j.this.pMd.pKZ.d(j.this.pMd);
        }
        AppMethodBeat.o(177227);
      }
      
      public final void onPause()
      {
        AppMethodBeat.i(177226);
        if (j.this.pMd.pKZ != null) {
          j.this.pMd.pKZ.c(j.this.pMd);
        }
        AppMethodBeat.o(177226);
      }
      
      public final void onStop()
      {
        AppMethodBeat.i(177228);
        if (j.this.pMd.pKZ != null) {
          j.this.pMd.pKZ.e(j.this.pMd);
        }
        AppMethodBeat.o(177228);
      }
    };
    paramc.cFD = local2;
    if (paramc.cJA != null) {
      paramc.cJA.a(local2);
    }
    AppMethodBeat.o(177243);
  }
  
  public final int Ub()
  {
    AppMethodBeat.i(177244);
    int i = this.cKw.Ub();
    AppMethodBeat.o(177244);
    return i;
  }
  
  public final int Uc()
  {
    AppMethodBeat.i(177245);
    int i = this.cKw.Uc();
    AppMethodBeat.o(177245);
    return i;
  }
  
  public final void a(ad paramad, final g.a parama)
  {
    AppMethodBeat.i(224673);
    paramad = paramad.getJsRuntime();
    if (paramad == null)
    {
      Log.w("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "getVideoPositionAsync, null == jsRuntime");
      parama.eD(this.cKw.Ud(), this.cKw.Ue());
      AppMethodBeat.o(224673);
      return;
    }
    String str = "document.querySelector('embed[embed-id=\"" + this.cKw.getId() + "\"]').getBoundingClientRect().toJSON()";
    Log.i("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "getVideoPositionAsync, jsScript: ".concat(String.valueOf(str)));
    paramad.evaluateJavascript(str, new ValueCallback() {});
    AppMethodBeat.o(224673);
  }
  
  public final Point bTZ()
  {
    AppMethodBeat.i(224670);
    Point localPoint = new Point(this.cKw.Ud(), this.cKw.Ue());
    AppMethodBeat.o(224670);
    return localPoint;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.t.i bUa()
  {
    return this.pMd;
  }
  
  public final f bYD()
  {
    e locale = this.cKw.cJz;
    if (!(locale instanceof f)) {
      return null;
    }
    return (f)locale;
  }
  
  public final boolean f(Surface paramSurface)
  {
    AppMethodBeat.i(224674);
    boolean bool = this.cKw.f(paramSurface);
    AppMethodBeat.o(224674);
    return bool;
  }
  
  final class a
    implements com.tencent.mm.plugin.appbrand.jsapi.t.i
  {
    final String cED;
    i.a pKZ;
    volatile boolean pMf;
    e.h pMg;
    e.i pMh;
    e.b pMi;
    
    private a()
    {
      AppMethodBeat.i(177235);
      this.cED = ("MicroMsg.AppBrand.XWebVideoVideoController#" + hashCode());
      this.pKZ = null;
      this.pMf = false;
      this.pMg = new e.h()
      {
        public final void a(e paramAnonymouse)
        {
          AppMethodBeat.i(224996);
          j.a.this.pMf = true;
          if (j.a.this.pKZ != null)
          {
            Log.i(j.a.this.cED, "onLoadEnd from OnPreparedListener");
            j.a.this.pKZ.b(j.a.this);
          }
          AppMethodBeat.o(224996);
        }
      };
      this.pMh = new e.i()
      {
        public final void b(e paramAnonymouse)
        {
          AppMethodBeat.i(226409);
          if (j.a.this.pKZ != null)
          {
            Log.i(j.a.this.cED, "onLoadEnd from OnSeekCompleteListener");
            j.a.this.pKZ.b(j.a.this);
            j.a.this.pKZ.a(j.a.this, false);
          }
          AppMethodBeat.o(226409);
        }
      };
      this.pMi = new e.b()
      {
        public final void Uh()
        {
          AppMethodBeat.i(222656);
          if (j.a.this.pKZ != null) {
            j.a.this.pKZ.g(j.a.this);
          }
          AppMethodBeat.o(222656);
        }
      };
      this$1 = j.this.cKw;
      c.b local4 = new c.b()
      {
        public final void cs(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(177234);
          f localf = j.this.bYD();
          if (localf == null)
          {
            AppMethodBeat.o(177234);
            return;
          }
          j.a.this.pMf = paramAnonymousBoolean;
          localf.b(j.a.this.pMg);
          localf.b(j.a.this.pMh);
          localf.b(j.a.this.pMi);
          AppMethodBeat.o(177234);
        }
      };
      j.this.cKf = local4;
      if (j.this.cJz != null) {
        local4.cs(j.this.cJN);
      }
      AppMethodBeat.o(177235);
    }
    
    public final Integer Ua()
    {
      AppMethodBeat.i(178858);
      Integer localInteger = j.this.cKw.Ua();
      Log.d("MicroMsg.AppBrand.XWebVideoVideoController", "getOriginPageViewId, originPageViewId: ".concat(String.valueOf(localInteger)));
      AppMethodBeat.o(178858);
      return localInteger;
    }
    
    public final void a(i.a parama)
    {
      AppMethodBeat.i(177242);
      if (parama != null)
      {
        if (this.pMf) {
          break label43;
        }
        Log.i(this.cED, "onLoading from mPrepared");
        parama.a(this);
      }
      for (;;)
      {
        this.pKZ = parama;
        AppMethodBeat.o(177242);
        return;
        label43:
        Log.i(this.cED, "onLoadEnd from mPrepared");
        parama.b(this);
      }
    }
    
    public final boolean bUb()
    {
      return j.this.cKw.cFI;
    }
    
    public final String getKey()
    {
      AppMethodBeat.i(177236);
      String str = j.this.cKw.getKey();
      AppMethodBeat.o(177236);
      return str;
    }
    
    public final int getVideoHeight()
    {
      AppMethodBeat.i(177238);
      f localf = j.this.bYD();
      if (localf == null)
      {
        AppMethodBeat.o(177238);
        return 0;
      }
      int i = localf.getVideoHeight();
      AppMethodBeat.o(177238);
      return i;
    }
    
    public final int getVideoWidth()
    {
      AppMethodBeat.i(177237);
      f localf = j.this.bYD();
      if (localf == null)
      {
        AppMethodBeat.o(177237);
        return 0;
      }
      int i = localf.getVideoWidth();
      AppMethodBeat.o(177237);
      return i;
    }
    
    public final void pause()
    {
      AppMethodBeat.i(177240);
      Log.d(this.cED, "pause");
      j.this.cKw.TU();
      AppMethodBeat.o(177240);
    }
    
    public final void release()
    {
      AppMethodBeat.i(177241);
      Log.d(this.cED, "release");
      c localc = j.this.cKw;
      localc.k(new c.26(localc));
      AppMethodBeat.o(177241);
    }
    
    public final void start()
    {
      AppMethodBeat.i(177239);
      Log.d(this.cED, "start");
      j.this.cKw.Tv();
      AppMethodBeat.o(177239);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.e.j
 * JD-Core Version:    0.7.0.1
 */