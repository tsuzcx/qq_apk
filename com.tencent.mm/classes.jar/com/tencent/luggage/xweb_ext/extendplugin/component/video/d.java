package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.luggage.xweb_ext.extendplugin.component.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e.j;
import com.tencent.mm.plugin.appbrand.jsapi.q.g;
import com.tencent.mm.plugin.appbrand.jsapi.q.h.a;
import com.tencent.mm.sdk.platformtools.ad;

final class d
  extends com.tencent.luggage.xweb_ext.extendplugin.component.c<j, TextureImageViewLikeImpl>
{
  protected static h.a<j, TextureImageViewLikeImpl> csO;
  static com.tencent.mm.plugin.appbrand.jsapi.q.c csP;
  final g csQ;
  
  static
  {
    AppMethodBeat.i(177180);
    csO = new h.a() {};
    csP = new com.tencent.mm.plugin.appbrand.jsapi.q.c()
    {
      public final com.tencent.mm.plugin.appbrand.jsapi.q.a gG(int paramAnonymousInt)
      {
        AppMethodBeat.i(177177);
        com.tencent.mm.plugin.appbrand.jsapi.ac.e.b.a locala = new com.tencent.mm.plugin.appbrand.jsapi.ac.e.b.a();
        locala.p("videoPlayerId", Integer.valueOf(paramAnonymousInt));
        AppMethodBeat.o(177177);
        return locala;
      }
      
      public final com.tencent.mm.plugin.appbrand.jsapi.q.a gH(int paramAnonymousInt)
      {
        AppMethodBeat.i(177178);
        b localb = new b();
        localb.p("videoPlayerId", Integer.valueOf(paramAnonymousInt));
        AppMethodBeat.o(177178);
        return localb;
      }
    };
    AppMethodBeat.o(177180);
  }
  
  public d(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(177179);
    this.csQ = new j(paramc);
    AppMethodBeat.o(177179);
  }
  
  public final g FT()
  {
    return this.csQ;
  }
  
  public final h.a FU()
  {
    return csO;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.q.c FV()
  {
    return csP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.d
 * JD-Core Version:    0.7.0.1
 */