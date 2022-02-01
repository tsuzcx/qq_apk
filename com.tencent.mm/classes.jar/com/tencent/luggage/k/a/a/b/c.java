package com.tencent.luggage.k.a.a.b;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.luggage.k.a.a.d;
import com.tencent.luggage.k.a.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.n.g;
import com.tencent.mm.plugin.appbrand.jsapi.n.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.z.e.j;
import com.tencent.mm.sdk.platformtools.ac;

final class c
  extends com.tencent.luggage.k.a.a.c<j, TextureView>
{
  static com.tencent.mm.plugin.appbrand.jsapi.n.c ciA;
  protected static h.a<j, TextureView> ciz;
  final g ciB;
  
  static
  {
    AppMethodBeat.i(177180);
    ciz = new h.a() {};
    ciA = new com.tencent.mm.plugin.appbrand.jsapi.n.c()
    {
      public final com.tencent.mm.plugin.appbrand.jsapi.n.a gB(int paramAnonymousInt)
      {
        AppMethodBeat.i(177177);
        com.tencent.mm.plugin.appbrand.jsapi.z.e.b.a locala = new com.tencent.mm.plugin.appbrand.jsapi.z.e.b.a();
        locala.q("videoPlayerId", Integer.valueOf(paramAnonymousInt));
        AppMethodBeat.o(177177);
        return locala;
      }
      
      public final com.tencent.mm.plugin.appbrand.jsapi.n.a gC(int paramAnonymousInt)
      {
        AppMethodBeat.i(177178);
        com.tencent.mm.plugin.appbrand.jsapi.z.e.b.b localb = new com.tencent.mm.plugin.appbrand.jsapi.z.e.b.b();
        localb.q("videoPlayerId", Integer.valueOf(paramAnonymousInt));
        AppMethodBeat.o(177178);
        return localb;
      }
    };
    AppMethodBeat.o(177180);
  }
  
  public c(b paramb)
  {
    super(paramb);
    AppMethodBeat.i(177179);
    this.ciB = new j(paramb);
    AppMethodBeat.o(177179);
  }
  
  public final g Eu()
  {
    return this.ciB;
  }
  
  public final h.a<j, TextureView> Ev()
  {
    return ciz;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.n.c Ew()
  {
    return ciA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.k.a.a.b.c
 * JD-Core Version:    0.7.0.1
 */