package com.tencent.mm.plugin.appbrand.jsapi.ai.c.a;

import android.graphics.Point;
import android.os.Handler;
import android.view.Surface;
import android.webkit.ValueCallback;
import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.a.b.16;
import com.tencent.luggage.xweb_ext.extendplugin.component.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.t.g;
import com.tencent.mm.plugin.appbrand.jsapi.t.g.a;
import com.tencent.mm.plugin.appbrand.jsapi.t.i.a;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  implements g
{
  public final com.tencent.luggage.xweb_ext.extendplugin.component.live.a.b cGy;
  private a pKW;
  
  public c(com.tencent.luggage.xweb_ext.extendplugin.component.live.a.b paramb)
  {
    AppMethodBeat.i(177217);
    this.cGy = paramb;
    this.pKW = new a((byte)0);
    AppMethodBeat.o(177217);
  }
  
  public final int Ub()
  {
    return this.cGy.cFl;
  }
  
  public final int Uc()
  {
    return this.cGy.cFm;
  }
  
  public final void a(ad paramad, final g.a parama)
  {
    AppMethodBeat.i(226611);
    paramad = paramad.getJsRuntime();
    if (paramad == null)
    {
      Log.w("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", "getVideoPositionAsync, null == jsRuntime");
      parama.eD(this.cGy.cFn, this.cGy.cFo);
      AppMethodBeat.o(226611);
      return;
    }
    String str = "document.querySelector('embed[embed-id=\"" + this.cGy.getId() + "\"]').getBoundingClientRect().toJSON()";
    Log.i("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", "getVideoPositionAsync, jsScript: ".concat(String.valueOf(str)));
    paramad.evaluateJavascript(str, new ValueCallback() {});
    AppMethodBeat.o(226611);
  }
  
  public final Point bTZ()
  {
    AppMethodBeat.i(226607);
    Point localPoint = new Point(this.cGy.cFn, this.cGy.cFo);
    AppMethodBeat.o(226607);
    return localPoint;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.t.i bUa()
  {
    return this.pKW;
  }
  
  public final boolean co(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(226617);
    boolean bool = this.cGy.co(paramInt1, paramInt2);
    AppMethodBeat.o(226617);
    return bool;
  }
  
  public final boolean f(Surface paramSurface)
  {
    AppMethodBeat.i(226615);
    boolean bool = this.cGy.f(paramSurface);
    AppMethodBeat.o(226615);
    return bool;
  }
  
  final class a
    implements com.tencent.mm.plugin.appbrand.jsapi.t.i
  {
    int cFE;
    i.a pKZ;
    private s pLa;
    
    private a()
    {
      AppMethodBeat.i(177211);
      this.pKZ = null;
      this.cFE = -1;
      this.pLa = new s()
      {
        public final void Tk()
        {
          AppMethodBeat.i(177205);
          if (c.a.this.pKZ != null)
          {
            c.a.this.pKZ.a(c.a.this);
            AppMethodBeat.o(177205);
            return;
          }
          c.a.this.cFE = 0;
          AppMethodBeat.o(177205);
        }
        
        public final void Tl()
        {
          AppMethodBeat.i(177206);
          if (c.a.this.pKZ != null)
          {
            c.a.this.pKZ.b(c.a.this);
            AppMethodBeat.o(177206);
            return;
          }
          c.a.this.cFE = 1;
          AppMethodBeat.o(177206);
        }
        
        public final void Tm()
        {
          AppMethodBeat.i(177210);
          if (c.a.this.pKZ != null)
          {
            c.a.this.pKZ.g(c.a.this);
            AppMethodBeat.o(177210);
            return;
          }
          c.a.this.cFE = 7;
          AppMethodBeat.o(177210);
        }
        
        public final void cm(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(177207);
          if (c.a.this.pKZ != null)
          {
            c.a.this.pKZ.a(c.a.this, paramAnonymousBoolean);
            AppMethodBeat.o(177207);
            return;
          }
          c.a locala = c.a.this;
          if (paramAnonymousBoolean) {}
          for (int i = 2;; i = 3)
          {
            locala.cFE = i;
            AppMethodBeat.o(177207);
            return;
          }
        }
        
        public final void onError() {}
        
        public final void onPause()
        {
          AppMethodBeat.i(177208);
          if (c.a.this.pKZ != null)
          {
            c.a.this.pKZ.c(c.a.this);
            AppMethodBeat.o(177208);
            return;
          }
          c.a.this.cFE = 4;
          AppMethodBeat.o(177208);
        }
        
        public final void onStop()
        {
          AppMethodBeat.i(177209);
          if (c.a.this.pKZ != null)
          {
            c.a.this.pKZ.e(c.a.this);
            AppMethodBeat.o(177209);
            return;
          }
          c.a.this.cFE = 6;
          AppMethodBeat.o(177209);
        }
      };
      this$1 = c.this.cGy;
      s locals = this.pLa;
      c.this.cFD = locals;
      if (locals != null) {
        switch (c.this.cFE)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(177211);
        return;
        locals.Tk();
        AppMethodBeat.o(177211);
        return;
        locals.Tl();
        AppMethodBeat.o(177211);
        return;
        locals.Tl();
        locals.cm(true);
        AppMethodBeat.o(177211);
        return;
        locals.Tl();
        locals.cm(false);
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
        locals.Tm();
      }
    }
    
    public final Integer Ua()
    {
      Object localObject1 = null;
      AppMethodBeat.i(178853);
      com.tencent.luggage.xweb_ext.extendplugin.component.live.a.b localb = c.this.cGy;
      Object localObject2 = localb.cFj;
      if (localObject2 == null) {
        Log.w(localb.getLogTag(), "getOriginPageViewId, invokeContext is null");
      }
      for (;;)
      {
        Log.d("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", "getOriginPageViewId, originPageViewId: ".concat(String.valueOf(localObject1)));
        AppMethodBeat.o(178853);
        return localObject1;
        localObject2 = com.tencent.luggage.xweb_ext.extendplugin.component.b.e((a)localObject2);
        if (localObject2 == null) {
          Log.w(localb.getLogTag(), "getOriginPageViewId, pageView is null");
        } else {
          localObject1 = Integer.valueOf(localObject2.hashCode());
        }
      }
    }
    
    public final void a(i.a parama)
    {
      AppMethodBeat.i(177216);
      this.pKZ = parama;
      if (parama != null) {
        switch (this.cFE)
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
    
    public final boolean bUb()
    {
      return c.this.cGy.cFI;
    }
    
    public final String getKey()
    {
      AppMethodBeat.i(177212);
      String str = c.this.cGy.getKey();
      Log.d("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", "getKey, key: ".concat(String.valueOf(str)));
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
      c.this.cGy.et("pause");
      AppMethodBeat.o(177214);
    }
    
    public final void release()
    {
      AppMethodBeat.i(177215);
      com.tencent.luggage.xweb_ext.extendplugin.component.live.a.b localb = c.this.cGy;
      if (localb.cFv != null) {
        localb.cFv.post(new b.16(localb));
      }
      AppMethodBeat.o(177215);
    }
    
    public final void start()
    {
      AppMethodBeat.i(177213);
      c.this.cGy.Tv();
      AppMethodBeat.o(177213);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.c.a.c
 * JD-Core Version:    0.7.0.1
 */