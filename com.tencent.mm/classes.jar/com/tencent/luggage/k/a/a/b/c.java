package com.tencent.luggage.k.a.a.b;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.luggage.k.a.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.aa.e.j;
import com.tencent.mm.plugin.appbrand.jsapi.o.h;
import com.tencent.mm.plugin.appbrand.jsapi.o.i.a;
import com.tencent.mm.plugin.appbrand.utils.i;
import com.tencent.mm.sdk.platformtools.ad;

final class c
  extends com.tencent.luggage.k.a.a.c<j, TextureView>
{
  protected static i.a<j, TextureView> clx;
  static com.tencent.mm.plugin.appbrand.jsapi.o.d cly;
  final h clz;
  
  static
  {
    AppMethodBeat.i(177180);
    clx = new i.a() {};
    cly = new com.tencent.mm.plugin.appbrand.jsapi.o.d()
    {
      public final com.tencent.mm.plugin.appbrand.jsapi.o.a gR(int paramAnonymousInt)
      {
        AppMethodBeat.i(177177);
        com.tencent.mm.plugin.appbrand.jsapi.aa.e.b.a locala = new com.tencent.mm.plugin.appbrand.jsapi.aa.e.b.a();
        locala.r("videoPlayerId", Integer.valueOf(paramAnonymousInt));
        AppMethodBeat.o(177177);
        return locala;
      }
      
      public final com.tencent.mm.plugin.appbrand.jsapi.o.a gS(int paramAnonymousInt)
      {
        AppMethodBeat.i(177178);
        com.tencent.mm.plugin.appbrand.jsapi.aa.e.b.b localb = new com.tencent.mm.plugin.appbrand.jsapi.aa.e.b.b();
        localb.r("videoPlayerId", Integer.valueOf(paramAnonymousInt));
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
    this.clz = new j(paramb);
    AppMethodBeat.o(177179);
  }
  
  public final h EQ()
  {
    return this.clz;
  }
  
  public final i.a<j, TextureView> ER()
  {
    return clx;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.o.d ES()
  {
    return cly;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.k.a.a.b.c
 * JD-Core Version:    0.7.0.1
 */