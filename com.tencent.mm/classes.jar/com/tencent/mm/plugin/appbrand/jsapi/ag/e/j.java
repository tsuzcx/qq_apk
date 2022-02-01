package com.tencent.mm.plugin.appbrand.jsapi.ag.e;

import android.graphics.Point;
import android.view.Surface;
import android.webkit.ValueCallback;
import com.tencent.luggage.xweb_ext.extendplugin.component.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.s;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.c.26;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s.g;
import com.tencent.mm.plugin.appbrand.jsapi.s.g.a;
import com.tencent.mm.plugin.appbrand.jsapi.s.i.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.h;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.sdk.platformtools.Log;

public final class j
  implements g
{
  public final com.tencent.luggage.xweb_ext.extendplugin.component.video.c cJT;
  a mLl;
  
  public j(com.tencent.luggage.xweb_ext.extendplugin.component.video.c paramc)
  {
    AppMethodBeat.i(177243);
    this.cJT = paramc;
    this.mLl = new a((byte)0);
    paramc.cJC = new com.tencent.luggage.xweb_ext.extendplugin.component.video.a()
    {
      public final void bZ(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(177222);
        if (j.this.mLl.mKh != null)
        {
          float f = paramAnonymousInt1 * 100.0F / paramAnonymousInt2;
          if ((f >= 99.0F) && (paramAnonymousInt2 - paramAnonymousInt1 <= 1000))
          {
            j.this.mLl.mKh.f(j.this.mLl);
            AppMethodBeat.o(177222);
            return;
          }
          j.this.mLl.mKh.a(j.this.mLl, f);
        }
        AppMethodBeat.o(177222);
      }
    };
    if (paramc.cIW != null) {
      paramc.cIW.a(paramc.cJC);
    }
    s local2 = new s()
    {
      public final void PL()
      {
        AppMethodBeat.i(177223);
        if (j.this.mLl.mKh != null)
        {
          Log.i("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "onLoading from XWebOnPlayListener");
          j.this.mLl.mKh.a(j.this.mLl);
        }
        AppMethodBeat.o(177223);
      }
      
      public final void PM()
      {
        AppMethodBeat.i(177224);
        if (j.this.mLl.mKh != null)
        {
          Log.i("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "onLoadEnd from XWebOnPlayListener");
          j.this.mLl.mKh.b(j.this.mLl);
        }
        AppMethodBeat.o(177224);
      }
      
      public final void PN()
      {
        AppMethodBeat.i(177229);
        if (j.this.mLl.mKh != null) {
          j.this.mLl.mKh.g(j.this.mLl);
        }
        AppMethodBeat.o(177229);
      }
      
      public final void bZ(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(177225);
        if (j.this.mLl.mKh != null) {
          j.this.mLl.mKh.a(j.this.mLl, paramAnonymousBoolean);
        }
        AppMethodBeat.o(177225);
      }
      
      public final void onError()
      {
        AppMethodBeat.i(177227);
        if (j.this.mLl.mKh != null) {
          j.this.mLl.mKh.d(j.this.mLl);
        }
        AppMethodBeat.o(177227);
      }
      
      public final void onPause()
      {
        AppMethodBeat.i(177226);
        if (j.this.mLl.mKh != null) {
          j.this.mLl.mKh.c(j.this.mLl);
        }
        AppMethodBeat.o(177226);
      }
      
      public final void onStop()
      {
        AppMethodBeat.i(177228);
        if (j.this.mLl.mKh != null) {
          j.this.mLl.mKh.e(j.this.mLl);
        }
        AppMethodBeat.o(177228);
      }
    };
    paramc.cEX = local2;
    if (paramc.cIW != null) {
      paramc.cIW.a(local2);
    }
    AppMethodBeat.o(177243);
  }
  
  public final void a(ac paramac, final g.a parama)
  {
    AppMethodBeat.i(215903);
    paramac = paramac.getJsRuntime();
    if (paramac == null)
    {
      Log.w("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "getVideoPositionAsync, null == jsRuntime");
      parama.ef(this.cJT.Qy(), this.cJT.Qz());
      AppMethodBeat.o(215903);
      return;
    }
    String str = "document.querySelector('embed[embed-id=\"" + this.cJT.getId() + "\"]').getBoundingClientRect().toJSON()";
    Log.i("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "getVideoPositionAsync, jsScript: ".concat(String.valueOf(str)));
    paramac.evaluateJavascript(str, new ValueCallback() {});
    AppMethodBeat.o(215903);
  }
  
  public final int bIp()
  {
    AppMethodBeat.i(177244);
    com.tencent.luggage.xweb_ext.extendplugin.component.video.c localc = this.cJT;
    int i = (int)(localc.cJD * localc.cEF);
    Log.d(localc.getLogTag(), "getVideoContainerWidth, videoContainerWidth: ".concat(String.valueOf(i)));
    AppMethodBeat.o(177244);
    return i;
  }
  
  public final int bIq()
  {
    AppMethodBeat.i(177245);
    com.tencent.luggage.xweb_ext.extendplugin.component.video.c localc = this.cJT;
    int i = (int)(localc.cJE * localc.cEG);
    Log.d(localc.getLogTag(), "getVideoContainerHeight, videoContainerHeight: ".concat(String.valueOf(i)));
    AppMethodBeat.o(177245);
    return i;
  }
  
  public final Point bIr()
  {
    AppMethodBeat.i(215902);
    Point localPoint = new Point(this.cJT.Qy(), this.cJT.Qz());
    AppMethodBeat.o(215902);
    return localPoint;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.s.i bIs()
  {
    return this.mLl;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.video.e.d bMm()
  {
    com.tencent.mm.plugin.appbrand.jsapi.video.e.c localc = this.cJT.cIV;
    if (!(localc instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.d)) {
      return null;
    }
    return (com.tencent.mm.plugin.appbrand.jsapi.video.e.d)localc;
  }
  
  public final boolean e(Surface paramSurface)
  {
    AppMethodBeat.i(215904);
    boolean bool = this.cJT.e(paramSurface);
    AppMethodBeat.o(215904);
    return bool;
  }
  
  final class a
    implements com.tencent.mm.plugin.appbrand.jsapi.s.i
  {
    final String cDW;
    i.a mKh;
    volatile boolean mLn;
    c.g mLo;
    c.h mLp;
    com.tencent.mm.plugin.appbrand.jsapi.video.e.c.b mLq;
    
    private a()
    {
      AppMethodBeat.i(177235);
      this.cDW = ("MicroMsg.AppBrand.XWebVideoVideoController#" + hashCode());
      this.mKh = null;
      this.mLn = false;
      this.mLo = new c.g()
      {
        public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.c paramAnonymousc)
        {
          AppMethodBeat.i(215899);
          j.a.this.mLn = true;
          if (j.a.this.mKh != null)
          {
            Log.i(j.a.this.cDW, "onLoadEnd from OnPreparedListener");
            j.a.this.mKh.b(j.a.this);
          }
          AppMethodBeat.o(215899);
        }
      };
      this.mLp = new c.h()
      {
        public final void b(com.tencent.mm.plugin.appbrand.jsapi.video.e.c paramAnonymousc)
        {
          AppMethodBeat.i(215900);
          if (j.a.this.mKh != null)
          {
            Log.i(j.a.this.cDW, "onLoadEnd from OnSeekCompleteListener");
            j.a.this.mKh.b(j.a.this);
            j.a.this.mKh.a(j.a.this, false);
          }
          AppMethodBeat.o(215900);
        }
      };
      this.mLq = new com.tencent.mm.plugin.appbrand.jsapi.video.e.c.b()
      {
        public final void QA()
        {
          AppMethodBeat.i(215901);
          if (j.a.this.mKh != null) {
            j.a.this.mKh.g(j.a.this);
          }
          AppMethodBeat.o(215901);
        }
      };
      this$1 = j.this.cJT;
      com.tencent.luggage.xweb_ext.extendplugin.component.video.c.b local4 = new com.tencent.luggage.xweb_ext.extendplugin.component.video.c.b()
      {
        public final void cf(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(177234);
          com.tencent.mm.plugin.appbrand.jsapi.video.e.d locald = j.this.bMm();
          if (locald == null)
          {
            AppMethodBeat.o(177234);
            return;
          }
          j.a.this.mLn = paramAnonymousBoolean;
          locald.b(j.a.this.mLo);
          locald.b(j.a.this.mLp);
          locald.b(j.a.this.mLq);
          AppMethodBeat.o(177234);
        }
      };
      j.this.cJB = local4;
      if (j.this.cIV != null) {
        local4.cf(j.this.cJj);
      }
      AppMethodBeat.o(177235);
    }
    
    public final void a(i.a parama)
    {
      AppMethodBeat.i(177242);
      if (parama != null)
      {
        if (this.mLn) {
          break label43;
        }
        Log.i(this.cDW, "onLoading from mPrepared");
        parama.a(this);
      }
      for (;;)
      {
        this.mKh = parama;
        AppMethodBeat.o(177242);
        return;
        label43:
        Log.i(this.cDW, "onLoadEnd from mPrepared");
        parama.b(this);
      }
    }
    
    public final Integer bIt()
    {
      Object localObject1 = null;
      AppMethodBeat.i(178858);
      com.tencent.luggage.xweb_ext.extendplugin.component.video.c localc = j.this.cJT;
      Object localObject2 = localc.cED;
      if (localObject2 == null) {
        Log.w(localc.getLogTag(), "getOriginPageViewId, invokeContext is null");
      }
      for (;;)
      {
        Log.d("MicroMsg.AppBrand.XWebVideoVideoController", "getOriginPageViewId, originPageViewId: ".concat(String.valueOf(localObject1)));
        AppMethodBeat.o(178858);
        return localObject1;
        localObject2 = b.e((com.tencent.luggage.xweb_ext.extendplugin.a)localObject2);
        if (localObject2 == null) {
          Log.w(localc.getLogTag(), "getOriginPageViewId, pageView is null");
        } else {
          localObject1 = Integer.valueOf(localObject2.hashCode());
        }
      }
    }
    
    public final boolean bIu()
    {
      return j.this.cJT.cFc;
    }
    
    public final String getKey()
    {
      AppMethodBeat.i(177236);
      String str = j.this.cJT.getKey();
      AppMethodBeat.o(177236);
      return str;
    }
    
    public final int getVideoHeight()
    {
      AppMethodBeat.i(177238);
      com.tencent.mm.plugin.appbrand.jsapi.video.e.d locald = j.this.bMm();
      if (locald == null)
      {
        AppMethodBeat.o(177238);
        return 0;
      }
      int i = locald.getVideoHeight();
      AppMethodBeat.o(177238);
      return i;
    }
    
    public final int getVideoWidth()
    {
      AppMethodBeat.i(177237);
      com.tencent.mm.plugin.appbrand.jsapi.video.e.d locald = j.this.bMm();
      if (locald == null)
      {
        AppMethodBeat.o(177237);
        return 0;
      }
      int i = locald.getVideoWidth();
      AppMethodBeat.o(177237);
      return i;
    }
    
    public final void pause()
    {
      AppMethodBeat.i(177240);
      Log.d(this.cDW, "pause");
      j.this.cJT.Qs();
      AppMethodBeat.o(177240);
    }
    
    public final void release()
    {
      AppMethodBeat.i(177241);
      Log.d(this.cDW, "release");
      com.tencent.luggage.xweb_ext.extendplugin.component.video.c localc = j.this.cJT;
      localc.k(new c.26(localc));
      AppMethodBeat.o(177241);
    }
    
    public final void start()
    {
      AppMethodBeat.i(177239);
      Log.d(this.cDW, "start");
      j.this.cJT.PU();
      AppMethodBeat.o(177239);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.e.j
 * JD-Core Version:    0.7.0.1
 */