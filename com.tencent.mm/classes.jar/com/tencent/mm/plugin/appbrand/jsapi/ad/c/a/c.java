package com.tencent.mm.plugin.appbrand.jsapi.ad.c.a;

import android.graphics.Point;
import android.os.Handler;
import android.view.Surface;
import android.webkit.ValueCallback;
import com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a.9;
import com.tencent.luggage.xweb_ext.extendplugin.component.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.q.g;
import com.tencent.mm.plugin.appbrand.jsapi.q.g.a;
import com.tencent.mm.plugin.appbrand.jsapi.q.i.a;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
  implements g
{
  public final com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a ctA;
  private a lCz;
  
  public c(com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a parama)
  {
    AppMethodBeat.i(177217);
    this.ctA = parama;
    this.lCz = new a((byte)0);
    AppMethodBeat.o(177217);
  }
  
  public final void a(z paramz, final g.a parama)
  {
    AppMethodBeat.i(220621);
    paramz = paramz.aYB();
    if (paramz == null)
    {
      ae.w("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", "getVideoPositionAsync, null == jsRuntime");
      parama.dT(this.ctA.css, this.ctA.cst);
      AppMethodBeat.o(220621);
      return;
    }
    String str = "document.querySelector('embed[embed-id=\"" + this.ctA.getId() + "\"]').getBoundingClientRect().toJSON()";
    ae.i("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", "getVideoPositionAsync, jsScript: ".concat(String.valueOf(str)));
    paramz.evaluateJavascript(str, new ValueCallback() {});
    AppMethodBeat.o(220621);
  }
  
  public final boolean bU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220623);
    boolean bool = this.ctA.bU(paramInt1, paramInt2);
    AppMethodBeat.o(220623);
    return bool;
  }
  
  public final int bmQ()
  {
    return this.ctA.csq;
  }
  
  public final int bmR()
  {
    return this.ctA.csr;
  }
  
  public final Point bmS()
  {
    AppMethodBeat.i(220620);
    Point localPoint = new Point(this.ctA.css, this.ctA.cst);
    AppMethodBeat.o(220620);
    return localPoint;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.q.i bmT()
  {
    return this.lCz;
  }
  
  public final boolean e(Surface paramSurface)
  {
    AppMethodBeat.i(220622);
    boolean bool = this.ctA.e(paramSurface);
    AppMethodBeat.o(220622);
    return bool;
  }
  
  final class a
    implements com.tencent.mm.plugin.appbrand.jsapi.q.i
  {
    int csI;
    i.a lCC;
    private s lCD;
    
    private a()
    {
      AppMethodBeat.i(177211);
      this.lCC = null;
      this.csI = -1;
      this.lCD = new s()
      {
        public final void Gc()
        {
          AppMethodBeat.i(177205);
          if (c.a.this.lCC != null)
          {
            c.a.this.lCC.a(c.a.this);
            AppMethodBeat.o(177205);
            return;
          }
          c.a.this.csI = 0;
          AppMethodBeat.o(177205);
        }
        
        public final void Gd()
        {
          AppMethodBeat.i(177206);
          if (c.a.this.lCC != null)
          {
            c.a.this.lCC.b(c.a.this);
            AppMethodBeat.o(177206);
            return;
          }
          c.a.this.csI = 1;
          AppMethodBeat.o(177206);
        }
        
        public final void Ge()
        {
          AppMethodBeat.i(177210);
          if (c.a.this.lCC != null)
          {
            c.a.this.lCC.g(c.a.this);
            AppMethodBeat.o(177210);
            return;
          }
          c.a.this.csI = 7;
          AppMethodBeat.o(177210);
        }
        
        public final void bA(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(177207);
          if (c.a.this.lCC != null)
          {
            c.a.this.lCC.a(c.a.this, paramAnonymousBoolean);
            AppMethodBeat.o(177207);
            return;
          }
          c.a locala = c.a.this;
          if (paramAnonymousBoolean) {}
          for (int i = 2;; i = 3)
          {
            locala.csI = i;
            AppMethodBeat.o(177207);
            return;
          }
        }
        
        public final void onError() {}
        
        public final void onPause()
        {
          AppMethodBeat.i(177208);
          if (c.a.this.lCC != null)
          {
            c.a.this.lCC.c(c.a.this);
            AppMethodBeat.o(177208);
            return;
          }
          c.a.this.csI = 4;
          AppMethodBeat.o(177208);
        }
        
        public final void onStop()
        {
          AppMethodBeat.i(177209);
          if (c.a.this.lCC != null)
          {
            c.a.this.lCC.e(c.a.this);
            AppMethodBeat.o(177209);
            return;
          }
          c.a.this.csI = 6;
          AppMethodBeat.o(177209);
        }
      };
      this$1 = c.this.ctA;
      s locals = this.lCD;
      c.this.csH = locals;
      if (locals != null) {
        switch (c.this.csI)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(177211);
        return;
        locals.Gc();
        AppMethodBeat.o(177211);
        return;
        locals.Gd();
        AppMethodBeat.o(177211);
        return;
        locals.Gd();
        locals.bA(true);
        AppMethodBeat.o(177211);
        return;
        locals.Gd();
        locals.bA(false);
        AppMethodBeat.o(177211);
        return;
        locals.onPause();
        AppMethodBeat.o(177211);
        return;
        locals.onError();
        AppMethodBeat.o(177211);
        return;
        locals.onStop();
        AppMethodBeat.o(177211);
        return;
        locals.Ge();
      }
    }
    
    public final void a(i.a parama)
    {
      AppMethodBeat.i(177216);
      this.lCC = parama;
      if (parama != null) {
        switch (this.csI)
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
    
    public final Integer bmU()
    {
      Object localObject1 = null;
      AppMethodBeat.i(178853);
      com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a locala = c.this.ctA;
      Object localObject2 = locala.cso;
      if (localObject2 == null) {
        ae.w(locala.getLogTag(), "getOriginPageViewId, invokeContext is null");
      }
      for (;;)
      {
        ae.d("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", "getOriginPageViewId, originPageViewId: ".concat(String.valueOf(localObject1)));
        AppMethodBeat.o(178853);
        return localObject1;
        localObject2 = b.e((com.tencent.luggage.xweb_ext.extendplugin.a)localObject2);
        if (localObject2 == null) {
          ae.w(locala.getLogTag(), "getOriginPageViewId, pageView is null");
        } else {
          localObject1 = Integer.valueOf(localObject2.hashCode());
        }
      }
    }
    
    public final boolean bmV()
    {
      return c.this.ctA.csM;
    }
    
    public final String getKey()
    {
      AppMethodBeat.i(177212);
      String str = c.this.ctA.getKey();
      ae.d("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", "getKey, key: ".concat(String.valueOf(str)));
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
      c.this.ctA.dy("pause");
      AppMethodBeat.o(177214);
    }
    
    public final void release()
    {
      AppMethodBeat.i(177215);
      com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a locala = c.this.ctA;
      if (locala.csz != null) {
        locala.csz.post(new a.9(locala));
      }
      AppMethodBeat.o(177215);
    }
    
    public final void start()
    {
      AppMethodBeat.i(177213);
      c.this.ctA.Gl();
      AppMethodBeat.o(177213);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.c.a.c
 * JD-Core Version:    0.7.0.1
 */