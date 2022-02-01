package com.tencent.luggage.xweb_ext.extendplugin.component.live.a;

import android.view.Surface;
import com.tencent.luggage.xweb_ext.extendplugin.component.d;
import com.tencent.luggage.xweb_ext.extendplugin.component.d.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.TextureImageViewLikeImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.s.g;
import com.tencent.mm.plugin.appbrand.jsapi.s.h.a;

final class c
  extends com.tencent.luggage.xweb_ext.extendplugin.component.c<com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.c, TextureImageViewLikeImpl>
{
  protected static h.a<com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.c, TextureImageViewLikeImpl> cFK;
  static com.tencent.mm.plugin.appbrand.jsapi.s.c cFL;
  final g cFM;
  
  static
  {
    AppMethodBeat.i(177147);
    cFK = new h.a() {};
    cFL = new com.tencent.mm.plugin.appbrand.jsapi.s.c()
    {
      public final com.tencent.mm.plugin.appbrand.jsapi.s.a hW(int paramAnonymousInt)
      {
        AppMethodBeat.i(177144);
        b localb = new b();
        localb.p("livePlayerId", Integer.valueOf(paramAnonymousInt));
        AppMethodBeat.o(177144);
        return localb;
      }
      
      public final com.tencent.mm.plugin.appbrand.jsapi.s.a hX(int paramAnonymousInt)
      {
        AppMethodBeat.i(177145);
        com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a.c localc = new com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a.c();
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
    this.cFM = new com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.c(parama);
    AppMethodBeat.o(177146);
  }
  
  public final g PI()
  {
    return this.cFM;
  }
  
  public final h.a PJ()
  {
    return cFK;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.s.c PK()
  {
    return cFL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.a.c
 * JD-Core Version:    0.7.0.1
 */