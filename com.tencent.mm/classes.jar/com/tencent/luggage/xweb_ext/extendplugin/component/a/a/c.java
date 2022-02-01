package com.tencent.luggage.xweb_ext.extendplugin.component.a.a;

import android.view.Surface;
import com.tencent.luggage.xweb_ext.extendplugin.component.d;
import com.tencent.luggage.xweb_ext.extendplugin.component.d.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.TextureImageViewLikeImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ad.c.a.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.q.g;
import com.tencent.mm.plugin.appbrand.jsapi.q.h.a;

final class c
  extends com.tencent.luggage.xweb_ext.extendplugin.component.c<com.tencent.mm.plugin.appbrand.jsapi.ad.c.a.c, TextureImageViewLikeImpl>
{
  protected static h.a<com.tencent.mm.plugin.appbrand.jsapi.ad.c.a.c, TextureImageViewLikeImpl> ctr;
  static com.tencent.mm.plugin.appbrand.jsapi.q.c cts;
  final g ctt;
  
  static
  {
    AppMethodBeat.i(177147);
    ctr = new h.a() {};
    cts = new com.tencent.mm.plugin.appbrand.jsapi.q.c()
    {
      public final com.tencent.mm.plugin.appbrand.jsapi.q.a gH(int paramAnonymousInt)
      {
        AppMethodBeat.i(177144);
        b localb = new b();
        localb.p("livePlayerId", Integer.valueOf(paramAnonymousInt));
        AppMethodBeat.o(177144);
        return localb;
      }
      
      public final com.tencent.mm.plugin.appbrand.jsapi.q.a gI(int paramAnonymousInt)
      {
        AppMethodBeat.i(177145);
        com.tencent.mm.plugin.appbrand.jsapi.ad.c.a.a.c localc = new com.tencent.mm.plugin.appbrand.jsapi.ad.c.a.a.c();
        localc.p("livePlayerId", Integer.valueOf(paramAnonymousInt));
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
    this.ctt = new com.tencent.mm.plugin.appbrand.jsapi.ad.c.a.c(parama);
    AppMethodBeat.o(177146);
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
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a.a.c
 * JD-Core Version:    0.7.0.1
 */