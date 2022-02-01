package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.luggage.xweb_ext.extendplugin.component.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ad.e.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.ad.e.j;
import com.tencent.mm.plugin.appbrand.jsapi.q.g;
import com.tencent.mm.plugin.appbrand.jsapi.q.h.a;
import com.tencent.mm.sdk.platformtools.ae;

final class d
  extends com.tencent.luggage.xweb_ext.extendplugin.component.c<j, TextureImageViewLikeImpl>
{
  protected static h.a<j, TextureImageViewLikeImpl> ctr;
  static com.tencent.mm.plugin.appbrand.jsapi.q.c cts;
  final g ctt;
  
  static
  {
    AppMethodBeat.i(177180);
    ctr = new h.a() {};
    cts = new com.tencent.mm.plugin.appbrand.jsapi.q.c()
    {
      public final com.tencent.mm.plugin.appbrand.jsapi.q.a gH(int paramAnonymousInt)
      {
        AppMethodBeat.i(177177);
        com.tencent.mm.plugin.appbrand.jsapi.ad.e.b.a locala = new com.tencent.mm.plugin.appbrand.jsapi.ad.e.b.a();
        locala.p("videoPlayerId", Integer.valueOf(paramAnonymousInt));
        AppMethodBeat.o(177177);
        return locala;
      }
      
      public final com.tencent.mm.plugin.appbrand.jsapi.q.a gI(int paramAnonymousInt)
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
    this.ctt = new j(paramc);
    AppMethodBeat.o(177179);
  }
  
  public final g FZ()
  {
    return this.ctt;
  }
  
  public final h.a Ga()
  {
    return ctr;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.q.c Gb()
  {
    return cts;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.d
 * JD-Core Version:    0.7.0.1
 */