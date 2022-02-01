package com.tencent.luggage.k.a.a.a.a;

import android.view.Surface;
import android.view.TextureView;
import com.tencent.luggage.k.a.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.aa.c.a.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.o.h;
import com.tencent.mm.plugin.appbrand.jsapi.o.i.a;

final class c
  extends com.tencent.luggage.k.a.a.c<com.tencent.mm.plugin.appbrand.jsapi.aa.c.a.c, TextureView>
{
  protected static i.a<com.tencent.mm.plugin.appbrand.jsapi.aa.c.a.c, TextureView> clx;
  static com.tencent.mm.plugin.appbrand.jsapi.o.d cly;
  final h clz;
  
  static
  {
    AppMethodBeat.i(177147);
    clx = new i.a() {};
    cly = new com.tencent.mm.plugin.appbrand.jsapi.o.d()
    {
      public final com.tencent.mm.plugin.appbrand.jsapi.o.a gR(int paramAnonymousInt)
      {
        AppMethodBeat.i(177144);
        b localb = new b();
        localb.r("livePlayerId", Integer.valueOf(paramAnonymousInt));
        AppMethodBeat.o(177144);
        return localb;
      }
      
      public final com.tencent.mm.plugin.appbrand.jsapi.o.a gS(int paramAnonymousInt)
      {
        AppMethodBeat.i(177145);
        com.tencent.mm.plugin.appbrand.jsapi.aa.c.a.a.c localc = new com.tencent.mm.plugin.appbrand.jsapi.aa.c.a.a.c();
        localc.r("livePlayerId", Integer.valueOf(paramAnonymousInt));
        AppMethodBeat.o(177145);
        return localc;
      }
    };
    AppMethodBeat.o(177147);
  }
  
  protected c(a parama)
  {
    super(parama);
    AppMethodBeat.i(177146);
    this.clz = new com.tencent.mm.plugin.appbrand.jsapi.aa.c.a.c(parama);
    AppMethodBeat.o(177146);
  }
  
  public final h EQ()
  {
    return this.clz;
  }
  
  public final i.a<com.tencent.mm.plugin.appbrand.jsapi.aa.c.a.c, TextureView> ER()
  {
    return clx;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.o.d ES()
  {
    return cly;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.k.a.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */