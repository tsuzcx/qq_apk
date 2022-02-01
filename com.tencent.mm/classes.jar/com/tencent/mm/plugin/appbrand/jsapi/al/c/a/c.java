package com.tencent.mm.plugin.appbrand.jsapi.al.c.a;

import android.graphics.Point;
import android.os.Handler;
import android.view.Surface;
import android.webkit.ValueCallback;
import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.a.b.16;
import com.tencent.luggage.xweb_ext.extendplugin.component.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.w.g;
import com.tencent.mm.plugin.appbrand.jsapi.w.g.a;
import com.tencent.mm.plugin.appbrand.jsapi.w.i.a;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  implements g
{
  public final com.tencent.luggage.xweb_ext.extendplugin.component.live.a.b ezM;
  private a sPP;
  
  public c(com.tencent.luggage.xweb_ext.extendplugin.component.live.a.b paramb)
  {
    AppMethodBeat.i(177217);
    this.ezM = paramb;
    this.sPP = new a((byte)0);
    AppMethodBeat.o(177217);
  }
  
  public final void a(ad paramad, final g.a parama)
  {
    AppMethodBeat.i(327137);
    paramad = paramad.getJsRuntime();
    if (paramad == null)
    {
      Log.w("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", "getVideoPositionAsync, null == jsRuntime");
      parama.fx(this.ezM.eyB, this.ezM.eyC);
      AppMethodBeat.o(327137);
      return;
    }
    String str = "document.querySelector('embed[embed-id=\"" + this.ezM.getId() + "\"]').getBoundingClientRect().toJSON()";
    Log.i("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", "getVideoPositionAsync, jsScript: ".concat(String.valueOf(str)));
    paramad.evaluateJavascript(str, new ValueCallback() {});
    AppMethodBeat.o(327137);
  }
  
  public final int auH()
  {
    return this.ezM.eyz;
  }
  
  public final int auI()
  {
    return this.ezM.eyA;
  }
  
  public final Point cum()
  {
    AppMethodBeat.i(327135);
    Point localPoint = new Point(this.ezM.eyB, this.ezM.eyC);
    AppMethodBeat.o(327135);
    return localPoint;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.w.i cun()
  {
    return this.sPP;
  }
  
  public final boolean dd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(327146);
    boolean bool = this.ezM.dd(paramInt1, paramInt2);
    AppMethodBeat.o(327146);
    return bool;
  }
  
  public final boolean j(Surface paramSurface)
  {
    AppMethodBeat.i(327142);
    boolean bool = this.ezM.j(paramSurface);
    AppMethodBeat.o(327142);
    return bool;
  }
  
  final class a
    implements com.tencent.mm.plugin.appbrand.jsapi.w.i
  {
    int eyS;
    i.a sPS;
    private s sPT;
    
    private a()
    {
      AppMethodBeat.i(177211);
      this.sPS = null;
      this.eyS = -1;
      this.sPT = new s()
      {
        public final void atP()
        {
          AppMethodBeat.i(177205);
          if (c.a.this.sPS != null)
          {
            c.a.this.sPS.a(c.a.this);
            AppMethodBeat.o(177205);
            return;
          }
          c.a.this.eyS = 0;
          AppMethodBeat.o(177205);
        }
        
        public final void atQ()
        {
          AppMethodBeat.i(177206);
          if (c.a.this.sPS != null)
          {
            c.a.this.sPS.b(c.a.this);
            AppMethodBeat.o(177206);
            return;
          }
          c.a.this.eyS = 1;
          AppMethodBeat.o(177206);
        }
        
        public final void atR() {}
        
        public final void atS()
        {
          AppMethodBeat.i(177210);
          if (c.a.this.sPS != null)
          {
            c.a.this.sPS.g(c.a.this);
            AppMethodBeat.o(177210);
            return;
          }
          c.a.this.eyS = 7;
          AppMethodBeat.o(177210);
        }
        
        public final void cS(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(177207);
          if (c.a.this.sPS != null)
          {
            c.a.this.sPS.a(c.a.this, paramAnonymousBoolean);
            AppMethodBeat.o(177207);
            return;
          }
          c.a locala = c.a.this;
          if (paramAnonymousBoolean) {}
          for (int i = 2;; i = 3)
          {
            locala.eyS = i;
            AppMethodBeat.o(177207);
            return;
          }
        }
        
        public final void onPause()
        {
          AppMethodBeat.i(177208);
          if (c.a.this.sPS != null)
          {
            c.a.this.sPS.c(c.a.this);
            AppMethodBeat.o(177208);
            return;
          }
          c.a.this.eyS = 4;
          AppMethodBeat.o(177208);
        }
        
        public final void onStop()
        {
          AppMethodBeat.i(177209);
          if (c.a.this.sPS != null)
          {
            c.a.this.sPS.e(c.a.this);
            AppMethodBeat.o(177209);
            return;
          }
          c.a.this.eyS = 6;
          AppMethodBeat.o(177209);
        }
      };
      this$1 = c.this.ezM;
      s locals = this.sPT;
      c.this.eyR = locals;
      if (locals != null) {
        switch (c.this.eyS)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(177211);
        return;
        locals.atP();
        AppMethodBeat.o(177211);
        return;
        locals.atQ();
        AppMethodBeat.o(177211);
        return;
        locals.atQ();
        locals.cS(true);
        AppMethodBeat.o(177211);
        return;
        locals.atQ();
        locals.cS(false);
        AppMethodBeat.o(177211);
        return;
        locals.onPause();
        AppMethodBeat.o(177211);
        return;
        locals.atR();
        AppMethodBeat.o(177211);
        return;
        locals.onStop();
        AppMethodBeat.o(177211);
        return;
        locals.atS();
      }
    }
    
    public final void a(i.a parama)
    {
      AppMethodBeat.i(177216);
      this.sPS = parama;
      if (parama != null) {
        switch (this.eyS)
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
    
    public final Integer auG()
    {
      Object localObject1 = null;
      AppMethodBeat.i(178853);
      com.tencent.luggage.xweb_ext.extendplugin.component.live.a.b localb = c.this.ezM;
      Object localObject2 = localb.eyx;
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
    
    public final boolean cuo()
    {
      return c.this.ezM.eyW;
    }
    
    public final String getKey()
    {
      AppMethodBeat.i(177212);
      String str = c.this.ezM.getKey();
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
      c.this.ezM.fQ("pause");
      AppMethodBeat.o(177214);
    }
    
    public final void release()
    {
      AppMethodBeat.i(177215);
      com.tencent.luggage.xweb_ext.extendplugin.component.live.a.b localb = c.this.ezM;
      if (localb.eyJ != null) {
        localb.eyJ.post(new b.16(localb));
      }
      AppMethodBeat.o(177215);
    }
    
    public final void start()
    {
      AppMethodBeat.i(177213);
      c.this.ezM.aua();
      AppMethodBeat.o(177213);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.c.a.c
 * JD-Core Version:    0.7.0.1
 */