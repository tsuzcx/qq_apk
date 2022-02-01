package com.tencent.mm.plugin.appbrand.jsapi.ac.c.a;

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
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  implements g
{
  public final com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a csW;
  private a lyb;
  
  public c(com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a parama)
  {
    AppMethodBeat.i(177217);
    this.csW = parama;
    this.lyb = new a((byte)0);
    AppMethodBeat.o(177217);
  }
  
  public final void a(aa paramaa, final g.a parama)
  {
    AppMethodBeat.i(186924);
    paramaa = paramaa.aYh();
    if (paramaa == null)
    {
      ad.w("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", "getVideoPositionAsync, null == jsRuntime");
      parama.dT(this.csW.crP, this.csW.crQ);
      AppMethodBeat.o(186924);
      return;
    }
    String str = "document.querySelector('embed[embed-id=\"" + this.csW.getId() + "\"]').getBoundingClientRect().toJSON()";
    ad.i("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", "getVideoPositionAsync, jsScript: ".concat(String.valueOf(str)));
    paramaa.evaluateJavascript(str, new ValueCallback() {});
    AppMethodBeat.o(186924);
  }
  
  public final boolean bU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186926);
    boolean bool = this.csW.bU(paramInt1, paramInt2);
    AppMethodBeat.o(186926);
    return bool;
  }
  
  public final int bmh()
  {
    return this.csW.crN;
  }
  
  public final int bmi()
  {
    return this.csW.crO;
  }
  
  public final Point bmj()
  {
    AppMethodBeat.i(186923);
    Point localPoint = new Point(this.csW.crP, this.csW.crQ);
    AppMethodBeat.o(186923);
    return localPoint;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.q.i bmk()
  {
    return this.lyb;
  }
  
  public final boolean e(Surface paramSurface)
  {
    AppMethodBeat.i(186925);
    boolean bool = this.csW.e(paramSurface);
    AppMethodBeat.o(186925);
    return bool;
  }
  
  final class a
    implements com.tencent.mm.plugin.appbrand.jsapi.q.i
  {
    int csf;
    i.a lye;
    private s lyf;
    
    private a()
    {
      AppMethodBeat.i(177211);
      this.lye = null;
      this.csf = -1;
      this.lyf = new s()
      {
        public final void FW()
        {
          AppMethodBeat.i(177205);
          if (c.a.this.lye != null)
          {
            c.a.this.lye.a(c.a.this);
            AppMethodBeat.o(177205);
            return;
          }
          c.a.this.csf = 0;
          AppMethodBeat.o(177205);
        }
        
        public final void FX()
        {
          AppMethodBeat.i(177206);
          if (c.a.this.lye != null)
          {
            c.a.this.lye.b(c.a.this);
            AppMethodBeat.o(177206);
            return;
          }
          c.a.this.csf = 1;
          AppMethodBeat.o(177206);
        }
        
        public final void FY()
        {
          AppMethodBeat.i(177210);
          if (c.a.this.lye != null)
          {
            c.a.this.lye.g(c.a.this);
            AppMethodBeat.o(177210);
            return;
          }
          c.a.this.csf = 7;
          AppMethodBeat.o(177210);
        }
        
        public final void bA(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(177207);
          if (c.a.this.lye != null)
          {
            c.a.this.lye.a(c.a.this, paramAnonymousBoolean);
            AppMethodBeat.o(177207);
            return;
          }
          c.a locala = c.a.this;
          if (paramAnonymousBoolean) {}
          for (int i = 2;; i = 3)
          {
            locala.csf = i;
            AppMethodBeat.o(177207);
            return;
          }
        }
        
        public final void onError() {}
        
        public final void onPause()
        {
          AppMethodBeat.i(177208);
          if (c.a.this.lye != null)
          {
            c.a.this.lye.c(c.a.this);
            AppMethodBeat.o(177208);
            return;
          }
          c.a.this.csf = 4;
          AppMethodBeat.o(177208);
        }
        
        public final void onStop()
        {
          AppMethodBeat.i(177209);
          if (c.a.this.lye != null)
          {
            c.a.this.lye.e(c.a.this);
            AppMethodBeat.o(177209);
            return;
          }
          c.a.this.csf = 6;
          AppMethodBeat.o(177209);
        }
      };
      this$1 = c.this.csW;
      s locals = this.lyf;
      c.this.cse = locals;
      if (locals != null) {
        switch (c.this.csf)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(177211);
        return;
        locals.FW();
        AppMethodBeat.o(177211);
        return;
        locals.FX();
        AppMethodBeat.o(177211);
        return;
        locals.FX();
        locals.bA(true);
        AppMethodBeat.o(177211);
        return;
        locals.FX();
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
        locals.FY();
      }
    }
    
    public final void a(i.a parama)
    {
      AppMethodBeat.i(177216);
      this.lye = parama;
      if (parama != null) {
        switch (this.csf)
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
    
    public final Integer bml()
    {
      Object localObject1 = null;
      AppMethodBeat.i(178853);
      com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a locala = c.this.csW;
      Object localObject2 = locala.crL;
      if (localObject2 == null) {
        ad.w(locala.getLogTag(), "getOriginPageViewId, invokeContext is null");
      }
      for (;;)
      {
        ad.d("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", "getOriginPageViewId, originPageViewId: ".concat(String.valueOf(localObject1)));
        AppMethodBeat.o(178853);
        return localObject1;
        localObject2 = b.e((com.tencent.luggage.xweb_ext.extendplugin.a)localObject2);
        if (localObject2 == null) {
          ad.w(locala.getLogTag(), "getOriginPageViewId, pageView is null");
        } else {
          localObject1 = Integer.valueOf(localObject2.hashCode());
        }
      }
    }
    
    public final boolean bmm()
    {
      return c.this.csW.csj;
    }
    
    public final String getKey()
    {
      AppMethodBeat.i(177212);
      String str = c.this.csW.getKey();
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
      c.this.csW.dw("pause");
      AppMethodBeat.o(177214);
    }
    
    public final void release()
    {
      AppMethodBeat.i(177215);
      com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a locala = c.this.csW;
      if (locala.crW != null) {
        locala.crW.post(new a.9(locala));
      }
      AppMethodBeat.o(177215);
    }
    
    public final void start()
    {
      AppMethodBeat.i(177213);
      c.this.csW.Gf();
      AppMethodBeat.o(177213);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.c.a.c
 * JD-Core Version:    0.7.0.1
 */