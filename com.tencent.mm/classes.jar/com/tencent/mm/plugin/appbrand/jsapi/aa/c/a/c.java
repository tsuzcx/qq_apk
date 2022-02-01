package com.tencent.mm.plugin.appbrand.jsapi.aa.c.a;

import android.graphics.Point;
import android.os.Handler;
import android.view.Surface;
import android.webkit.ValueCallback;
import com.tencent.luggage.k.a.a.a.a.a.9;
import com.tencent.luggage.k.a.a.b;
import com.tencent.luggage.k.a.a.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.o.h;
import com.tencent.mm.plugin.appbrand.jsapi.o.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.o.j;
import com.tencent.mm.plugin.appbrand.jsapi.o.j.a;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  implements h
{
  public final com.tencent.luggage.k.a.a.a.a.a clF;
  private a kzJ;
  
  public c(com.tencent.luggage.k.a.a.a.a.a parama)
  {
    AppMethodBeat.i(177217);
    this.clF = parama;
    this.kzJ = new a((byte)0);
    AppMethodBeat.o(177217);
  }
  
  public final void a(aa paramaa, final h.a parama)
  {
    AppMethodBeat.i(195092);
    paramaa = paramaa.aOf();
    if (paramaa == null)
    {
      ad.w("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", "getVideoPositionAsync, null == jsRuntime");
      parama.dQ(this.clF.cky, this.clF.ckz);
      AppMethodBeat.o(195092);
      return;
    }
    String str = "document.querySelector('embed[embed-id=\"" + this.clF.getId() + "\"]').getBoundingClientRect().toJSON()";
    ad.i("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", "getVideoPositionAsync, jsScript: ".concat(String.valueOf(str)));
    paramaa.evaluateJavascript(str, new ValueCallback() {});
    AppMethodBeat.o(195092);
  }
  
  public final boolean bV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195094);
    boolean bool = this.clF.bV(paramInt1, paramInt2);
    AppMethodBeat.o(195094);
    return bool;
  }
  
  public final int bbC()
  {
    return this.clF.ckw;
  }
  
  public final int bbD()
  {
    return this.clF.ckx;
  }
  
  public final Point bbE()
  {
    AppMethodBeat.i(195091);
    Point localPoint = new Point(this.clF.cky, this.clF.ckz);
    AppMethodBeat.o(195091);
    return localPoint;
  }
  
  public final j bbF()
  {
    return this.kzJ;
  }
  
  public final boolean f(Surface paramSurface)
  {
    AppMethodBeat.i(195093);
    boolean bool = this.clF.f(paramSurface);
    AppMethodBeat.o(195093);
    return bool;
  }
  
  final class a
    implements j
  {
    int ckO;
    j.a kzM;
    private r kzN;
    
    private a()
    {
      AppMethodBeat.i(177211);
      this.kzM = null;
      this.ckO = -1;
      this.kzN = new r()
      {
        public final void ET()
        {
          AppMethodBeat.i(177205);
          if (c.a.this.kzM != null)
          {
            c.a.this.kzM.a(c.a.this);
            AppMethodBeat.o(177205);
            return;
          }
          c.a.this.ckO = 0;
          AppMethodBeat.o(177205);
        }
        
        public final void EU()
        {
          AppMethodBeat.i(177206);
          if (c.a.this.kzM != null)
          {
            c.a.this.kzM.b(c.a.this);
            AppMethodBeat.o(177206);
            return;
          }
          c.a.this.ckO = 1;
          AppMethodBeat.o(177206);
        }
        
        public final void EV()
        {
          AppMethodBeat.i(177210);
          if (c.a.this.kzM != null)
          {
            c.a.this.kzM.g(c.a.this);
            AppMethodBeat.o(177210);
            return;
          }
          c.a.this.ckO = 7;
          AppMethodBeat.o(177210);
        }
        
        public final void bB(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(177207);
          if (c.a.this.kzM != null)
          {
            c.a.this.kzM.a(c.a.this, paramAnonymousBoolean);
            AppMethodBeat.o(177207);
            return;
          }
          c.a locala = c.a.this;
          if (paramAnonymousBoolean) {}
          for (int i = 2;; i = 3)
          {
            locala.ckO = i;
            AppMethodBeat.o(177207);
            return;
          }
        }
        
        public final void onError() {}
        
        public final void onPause()
        {
          AppMethodBeat.i(177208);
          if (c.a.this.kzM != null)
          {
            c.a.this.kzM.c(c.a.this);
            AppMethodBeat.o(177208);
            return;
          }
          c.a.this.ckO = 4;
          AppMethodBeat.o(177208);
        }
        
        public final void onStop()
        {
          AppMethodBeat.i(177209);
          if (c.a.this.kzM != null)
          {
            c.a.this.kzM.e(c.a.this);
            AppMethodBeat.o(177209);
            return;
          }
          c.a.this.ckO = 6;
          AppMethodBeat.o(177209);
        }
      };
      this$1 = c.this.clF;
      r localr = this.kzN;
      c.this.ckN = localr;
      if (localr != null) {
        switch (c.this.ckO)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(177211);
        return;
        localr.ET();
        AppMethodBeat.o(177211);
        return;
        localr.EU();
        AppMethodBeat.o(177211);
        return;
        localr.EU();
        localr.bB(true);
        AppMethodBeat.o(177211);
        return;
        localr.EU();
        localr.bB(false);
        AppMethodBeat.o(177211);
        return;
        localr.onPause();
        AppMethodBeat.o(177211);
        return;
        localr.onError();
        AppMethodBeat.o(177211);
        return;
        localr.onStop();
        AppMethodBeat.o(177211);
        return;
        localr.EV();
      }
    }
    
    public final void a(j.a parama)
    {
      AppMethodBeat.i(177216);
      this.kzM = parama;
      if (parama != null) {
        switch (this.ckO)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(177216);
        return;
        parama.a(this);
        AppMethodBeat.o(177216);
        return;
        parama.b(this);
        AppMethodBeat.o(177216);
        return;
        parama.b(this);
        parama.a(this, true);
        AppMethodBeat.o(177216);
        return;
        parama.b(this);
        parama.a(this, false);
        AppMethodBeat.o(177216);
        return;
        parama.c(this);
        AppMethodBeat.o(177216);
        return;
        parama.d(this);
        AppMethodBeat.o(177216);
        return;
        parama.e(this);
        AppMethodBeat.o(177216);
        return;
        parama.g(this);
      }
    }
    
    public final Integer bbG()
    {
      Object localObject1 = null;
      AppMethodBeat.i(178853);
      com.tencent.luggage.k.a.a.a.a.a locala = c.this.clF;
      Object localObject2 = locala.cku;
      if (localObject2 == null) {
        ad.w(locala.EE(), "getOriginPageViewId, invokeContext is null");
      }
      for (;;)
      {
        ad.d("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", "getOriginPageViewId, originPageViewId: ".concat(String.valueOf(localObject1)));
        AppMethodBeat.o(178853);
        return localObject1;
        localObject2 = b.f((com.tencent.luggage.k.a.a)localObject2);
        if (localObject2 == null) {
          ad.w(locala.EE(), "getOriginPageViewId, pageView is null");
        } else {
          localObject1 = Integer.valueOf(localObject2.hashCode());
        }
      }
    }
    
    public final boolean bbH()
    {
      return c.this.clF.ckS;
    }
    
    public final String getKey()
    {
      AppMethodBeat.i(177212);
      String str = c.this.clF.getKey();
      ad.d("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", "getKey, key: ".concat(String.valueOf(str)));
      AppMethodBeat.o(177212);
      return str;
    }
    
    public final int getVideoHeight()
    {
      return -1;
    }
    
    public final int getVideoWidth()
    {
      return -1;
    }
    
    public final void pause()
    {
      AppMethodBeat.i(177214);
      c.this.clF.cF("pause");
      AppMethodBeat.o(177214);
    }
    
    public final void release()
    {
      AppMethodBeat.i(177215);
      com.tencent.luggage.k.a.a.a.a.a locala = c.this.clF;
      if (locala.ckF != null) {
        locala.ckF.post(new a.9(locala));
      }
      AppMethodBeat.o(177215);
    }
    
    public final void start()
    {
      AppMethodBeat.i(177213);
      c.this.clF.Fc();
      AppMethodBeat.o(177213);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.c.a.c
 * JD-Core Version:    0.7.0.1
 */