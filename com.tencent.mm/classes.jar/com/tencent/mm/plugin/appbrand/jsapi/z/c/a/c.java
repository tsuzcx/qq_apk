package com.tencent.mm.plugin.appbrand.jsapi.z.c.a;

import android.graphics.Point;
import android.os.Handler;
import android.view.Surface;
import android.webkit.ValueCallback;
import com.tencent.luggage.k.a.a.a.a.a.9;
import com.tencent.luggage.k.a.a.b;
import com.tencent.luggage.k.a.a.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.n.g;
import com.tencent.mm.plugin.appbrand.jsapi.n.g.a;
import com.tencent.mm.plugin.appbrand.jsapi.n.i.a;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.sdk.platformtools.ac;

public final class c
  implements g
{
  public final com.tencent.luggage.k.a.a.a.a.a ciH;
  private a lba;
  
  public c(com.tencent.luggage.k.a.a.a.a.a parama)
  {
    AppMethodBeat.i(177217);
    this.ciH = parama;
    this.lba = new a((byte)0);
    AppMethodBeat.o(177217);
  }
  
  public final void a(aa paramaa, final g.a parama)
  {
    AppMethodBeat.i(206735);
    paramaa = paramaa.aUV();
    if (paramaa == null)
    {
      ac.w("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", "getVideoPositionAsync, null == jsRuntime");
      parama.dR(this.ciH.chx, this.ciH.chy);
      AppMethodBeat.o(206735);
      return;
    }
    String str = "document.querySelector('embed[embed-id=\"" + this.ciH.getId() + "\"]').getBoundingClientRect().toJSON()";
    ac.i("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", "getVideoPositionAsync, jsScript: ".concat(String.valueOf(str)));
    paramaa.evaluateJavascript(str, new ValueCallback() {});
    AppMethodBeat.o(206735);
  }
  
  public final boolean bS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(206737);
    boolean bool = this.ciH.bS(paramInt1, paramInt2);
    AppMethodBeat.o(206737);
    return bool;
  }
  
  public final int biv()
  {
    return this.ciH.chv;
  }
  
  public final int biw()
  {
    return this.ciH.chw;
  }
  
  public final Point bix()
  {
    AppMethodBeat.i(206734);
    Point localPoint = new Point(this.ciH.chx, this.ciH.chy);
    AppMethodBeat.o(206734);
    return localPoint;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.n.i biy()
  {
    return this.lba;
  }
  
  public final boolean e(Surface paramSurface)
  {
    AppMethodBeat.i(206736);
    boolean bool = this.ciH.e(paramSurface);
    AppMethodBeat.o(206736);
    return bool;
  }
  
  final class a
    implements com.tencent.mm.plugin.appbrand.jsapi.n.i
  {
    int chQ;
    i.a lbd;
    private n lbe;
    
    private a()
    {
      AppMethodBeat.i(177211);
      this.lbd = null;
      this.chQ = -1;
      this.lbe = new n()
      {
        public final void Ex()
        {
          AppMethodBeat.i(177205);
          if (c.a.this.lbd != null)
          {
            c.a.this.lbd.a(c.a.this);
            AppMethodBeat.o(177205);
            return;
          }
          c.a.this.chQ = 0;
          AppMethodBeat.o(177205);
        }
        
        public final void Ey()
        {
          AppMethodBeat.i(177206);
          if (c.a.this.lbd != null)
          {
            c.a.this.lbd.b(c.a.this);
            AppMethodBeat.o(177206);
            return;
          }
          c.a.this.chQ = 1;
          AppMethodBeat.o(177206);
        }
        
        public final void Ez()
        {
          AppMethodBeat.i(177210);
          if (c.a.this.lbd != null)
          {
            c.a.this.lbd.g(c.a.this);
            AppMethodBeat.o(177210);
            return;
          }
          c.a.this.chQ = 7;
          AppMethodBeat.o(177210);
        }
        
        public final void bA(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(177207);
          if (c.a.this.lbd != null)
          {
            c.a.this.lbd.a(c.a.this, paramAnonymousBoolean);
            AppMethodBeat.o(177207);
            return;
          }
          c.a locala = c.a.this;
          if (paramAnonymousBoolean) {}
          for (int i = 2;; i = 3)
          {
            locala.chQ = i;
            AppMethodBeat.o(177207);
            return;
          }
        }
        
        public final void onError() {}
        
        public final void onPause()
        {
          AppMethodBeat.i(177208);
          if (c.a.this.lbd != null)
          {
            c.a.this.lbd.c(c.a.this);
            AppMethodBeat.o(177208);
            return;
          }
          c.a.this.chQ = 4;
          AppMethodBeat.o(177208);
        }
        
        public final void onStop()
        {
          AppMethodBeat.i(177209);
          if (c.a.this.lbd != null)
          {
            c.a.this.lbd.e(c.a.this);
            AppMethodBeat.o(177209);
            return;
          }
          c.a.this.chQ = 6;
          AppMethodBeat.o(177209);
        }
      };
      this$1 = c.this.ciH;
      n localn = this.lbe;
      c.this.chP = localn;
      if (localn != null) {
        switch (c.this.chQ)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(177211);
        return;
        localn.Ex();
        AppMethodBeat.o(177211);
        return;
        localn.Ey();
        AppMethodBeat.o(177211);
        return;
        localn.Ey();
        localn.bA(true);
        AppMethodBeat.o(177211);
        return;
        localn.Ey();
        localn.bA(false);
        AppMethodBeat.o(177211);
        return;
        localn.onPause();
        AppMethodBeat.o(177211);
        return;
        localn.onError();
        AppMethodBeat.o(177211);
        return;
        localn.onStop();
        AppMethodBeat.o(177211);
        return;
        localn.Ez();
      }
    }
    
    public final void a(i.a parama)
    {
      AppMethodBeat.i(177216);
      this.lbd = parama;
      if (parama != null) {
        switch (this.chQ)
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
    
    public final boolean biA()
    {
      return c.this.ciH.chU;
    }
    
    public final Integer biz()
    {
      Object localObject1 = null;
      AppMethodBeat.i(178853);
      com.tencent.luggage.k.a.a.a.a.a locala = c.this.ciH;
      Object localObject2 = locala.cht;
      if (localObject2 == null) {
        ac.w(locala.getLogTag(), "getOriginPageViewId, invokeContext is null");
      }
      for (;;)
      {
        ac.d("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", "getOriginPageViewId, originPageViewId: ".concat(String.valueOf(localObject1)));
        AppMethodBeat.o(178853);
        return localObject1;
        localObject2 = b.e((com.tencent.luggage.k.a.a)localObject2);
        if (localObject2 == null) {
          ac.w(locala.getLogTag(), "getOriginPageViewId, pageView is null");
        } else {
          localObject1 = Integer.valueOf(localObject2.hashCode());
        }
      }
    }
    
    public final String getKey()
    {
      AppMethodBeat.i(177212);
      String str = c.this.ciH.getKey();
      ac.d("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", "getKey, key: ".concat(String.valueOf(str)));
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
      c.this.ciH.cu("pause");
      AppMethodBeat.o(177214);
    }
    
    public final void release()
    {
      AppMethodBeat.i(177215);
      com.tencent.luggage.k.a.a.a.a.a locala = c.this.ciH;
      if (locala.chE != null) {
        locala.chE.post(new a.9(locala));
      }
      AppMethodBeat.o(177215);
    }
    
    public final void start()
    {
      AppMethodBeat.i(177213);
      c.this.ciH.EH();
      AppMethodBeat.o(177213);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.c.a.c
 * JD-Core Version:    0.7.0.1
 */