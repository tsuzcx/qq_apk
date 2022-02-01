package com.tencent.luggage.k.a.a.a.a;

import android.view.Surface;
import android.view.TextureView;
import com.tencent.luggage.k.a.a.d;
import com.tencent.luggage.k.a.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.n.g;
import com.tencent.mm.plugin.appbrand.jsapi.n.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.z.c.a.a.b;
import com.tencent.mm.sdk.platformtools.ac;

final class c
  extends com.tencent.luggage.k.a.a.c<com.tencent.mm.plugin.appbrand.jsapi.z.c.a.c, TextureView>
{
  static com.tencent.mm.plugin.appbrand.jsapi.n.c ciA;
  protected static h.a<com.tencent.mm.plugin.appbrand.jsapi.z.c.a.c, TextureView> ciz;
  final g ciB;
  
  static
  {
    AppMethodBeat.i(177147);
    ciz = new h.a() {};
    ciA = new com.tencent.mm.plugin.appbrand.jsapi.n.c()
    {
      public final com.tencent.mm.plugin.appbrand.jsapi.n.a gB(int paramAnonymousInt)
      {
        AppMethodBeat.i(177144);
        b localb = new b();
        localb.q("livePlayerId", Integer.valueOf(paramAnonymousInt));
        AppMethodBeat.o(177144);
        return localb;
      }
      
      public final com.tencent.mm.plugin.appbrand.jsapi.n.a gC(int paramAnonymousInt)
      {
        AppMethodBeat.i(177145);
        com.tencent.mm.plugin.appbrand.jsapi.z.c.a.a.c localc = new com.tencent.mm.plugin.appbrand.jsapi.z.c.a.a.c();
        localc.q("livePlayerId", Integer.valueOf(paramAnonymousInt));
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
    this.ciB = new com.tencent.mm.plugin.appbrand.jsapi.z.c.a.c(parama);
    AppMethodBeat.o(177146);
  }
  
  public final g Eu()
  {
    return this.ciB;
  }
  
  public final h.a<com.tencent.mm.plugin.appbrand.jsapi.z.c.a.c, TextureView> Ev()
  {
    return ciz;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.n.c Ew()
  {
    return ciA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.k.a.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */