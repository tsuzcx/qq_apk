package com.tencent.mm.plugin.appbrand.jsapi.ag.c.a;

import android.graphics.Point;
import android.os.Handler;
import android.view.Surface;
import android.webkit.ValueCallback;
import com.tencent.luggage.xweb_ext.extendplugin.component.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.16;
import com.tencent.luggage.xweb_ext.extendplugin.component.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s.g;
import com.tencent.mm.plugin.appbrand.jsapi.s.g.a;
import com.tencent.mm.plugin.appbrand.jsapi.s.i.a;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  implements g
{
  public final com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a cFS;
  private a mKe;
  
  public c(com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a parama)
  {
    AppMethodBeat.i(177217);
    this.cFS = parama;
    this.mKe = new a((byte)0);
    AppMethodBeat.o(177217);
  }
  
  public final void a(ac paramac, final g.a parama)
  {
    AppMethodBeat.i(215865);
    paramac = paramac.getJsRuntime();
    if (paramac == null)
    {
      Log.w("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", "getVideoPositionAsync, null == jsRuntime");
      parama.ef(this.cFS.cEH, this.cFS.cEI);
      AppMethodBeat.o(215865);
      return;
    }
    String str = "document.querySelector('embed[embed-id=\"" + this.cFS.getId() + "\"]').getBoundingClientRect().toJSON()";
    Log.i("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", "getVideoPositionAsync, jsScript: ".concat(String.valueOf(str)));
    paramac.evaluateJavascript(str, new ValueCallback() {});
    AppMethodBeat.o(215865);
  }
  
  public final int bIp()
  {
    return this.cFS.cEF;
  }
  
  public final int bIq()
  {
    return this.cFS.cEG;
  }
  
  public final Point bIr()
  {
    AppMethodBeat.i(215864);
    Point localPoint = new Point(this.cFS.cEH, this.cFS.cEI);
    AppMethodBeat.o(215864);
    return localPoint;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.s.i bIs()
  {
    return this.mKe;
  }
  
  public final boolean bU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(215867);
    boolean bool = this.cFS.bU(paramInt1, paramInt2);
    AppMethodBeat.o(215867);
    return bool;
  }
  
  public final boolean e(Surface paramSurface)
  {
    AppMethodBeat.i(215866);
    boolean bool = this.cFS.e(paramSurface);
    AppMethodBeat.o(215866);
    return bool;
  }
  
  final class a
    implements com.tencent.mm.plugin.appbrand.jsapi.s.i
  {
    int cEY;
    i.a mKh;
    private s mKi;
    
    private a()
    {
      AppMethodBeat.i(177211);
      this.mKh = null;
      this.cEY = -1;
      this.mKi = new s()
      {
        public final void PL()
        {
          AppMethodBeat.i(177205);
          if (c.a.this.mKh != null)
          {
            c.a.this.mKh.a(c.a.this);
            AppMethodBeat.o(177205);
            return;
          }
          c.a.this.cEY = 0;
          AppMethodBeat.o(177205);
        }
        
        public final void PM()
        {
          AppMethodBeat.i(177206);
          if (c.a.this.mKh != null)
          {
            c.a.this.mKh.b(c.a.this);
            AppMethodBeat.o(177206);
            return;
          }
          c.a.this.cEY = 1;
          AppMethodBeat.o(177206);
        }
        
        public final void PN()
        {
          AppMethodBeat.i(177210);
          if (c.a.this.mKh != null)
          {
            c.a.this.mKh.g(c.a.this);
            AppMethodBeat.o(177210);
            return;
          }
          c.a.this.cEY = 7;
          AppMethodBeat.o(177210);
        }
        
        public final void bZ(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(177207);
          if (c.a.this.mKh != null)
          {
            c.a.this.mKh.a(c.a.this, paramAnonymousBoolean);
            AppMethodBeat.o(177207);
            return;
          }
          c.a locala = c.a.this;
          if (paramAnonymousBoolean) {}
          for (int i = 2;; i = 3)
          {
            locala.cEY = i;
            AppMethodBeat.o(177207);
            return;
          }
        }
        
        public final void onError() {}
        
        public final void onPause()
        {
          AppMethodBeat.i(177208);
          if (c.a.this.mKh != null)
          {
            c.a.this.mKh.c(c.a.this);
            AppMethodBeat.o(177208);
            return;
          }
          c.a.this.cEY = 4;
          AppMethodBeat.o(177208);
        }
        
        public final void onStop()
        {
          AppMethodBeat.i(177209);
          if (c.a.this.mKh != null)
          {
            c.a.this.mKh.e(c.a.this);
            AppMethodBeat.o(177209);
            return;
          }
          c.a.this.cEY = 6;
          AppMethodBeat.o(177209);
        }
      };
      this$1 = c.this.cFS;
      s locals = this.mKi;
      c.this.cEX = locals;
      if (locals != null) {
        switch (c.this.cEY)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(177211);
        return;
        locals.PL();
        AppMethodBeat.o(177211);
        return;
        locals.PM();
        AppMethodBeat.o(177211);
        return;
        locals.PM();
        locals.bZ(true);
        AppMethodBeat.o(177211);
        return;
        locals.PM();
        locals.bZ(false);
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
        locals.PN();
      }
    }
    
    public final void a(i.a parama)
    {
      AppMethodBeat.i(177216);
      this.mKh = parama;
      if (parama != null) {
        switch (this.cEY)
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
    
    public final Integer bIt()
    {
      Object localObject1 = null;
      AppMethodBeat.i(178853);
      com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a locala = c.this.cFS;
      Object localObject2 = locala.cED;
      if (localObject2 == null) {
        Log.w(locala.getLogTag(), "getOriginPageViewId, invokeContext is null");
      }
      for (;;)
      {
        Log.d("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", "getOriginPageViewId, originPageViewId: ".concat(String.valueOf(localObject1)));
        AppMethodBeat.o(178853);
        return localObject1;
        localObject2 = b.e((com.tencent.luggage.xweb_ext.extendplugin.a)localObject2);
        if (localObject2 == null) {
          Log.w(locala.getLogTag(), "getOriginPageViewId, pageView is null");
        } else {
          localObject1 = Integer.valueOf(localObject2.hashCode());
        }
      }
    }
    
    public final boolean bIu()
    {
      return c.this.cFS.cFc;
    }
    
    public final String getKey()
    {
      AppMethodBeat.i(177212);
      String str = c.this.cFS.getKey();
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
      c.this.cFS.dR("pause");
      AppMethodBeat.o(177214);
    }
    
    public final void release()
    {
      AppMethodBeat.i(177215);
      com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a locala = c.this.cFS;
      if (locala.cEP != null) {
        locala.cEP.post(new a.16(locala));
      }
      AppMethodBeat.o(177215);
    }
    
    public final void start()
    {
      AppMethodBeat.i(177213);
      c.this.cFS.PU();
      AppMethodBeat.o(177213);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.c
 * JD-Core Version:    0.7.0.1
 */