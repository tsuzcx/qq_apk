package com.tencent.luggage.xweb_ext.extendplugin.component.live.a;

import android.view.Surface;
import com.tencent.luggage.xweb_ext.extendplugin.component.d;
import com.tencent.luggage.xweb_ext.extendplugin.component.d.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.TextureImageViewLikeImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.t.a;
import com.tencent.mm.plugin.appbrand.jsapi.t.g;
import com.tencent.mm.plugin.appbrand.jsapi.t.h.a;

final class f
  extends com.tencent.luggage.xweb_ext.extendplugin.component.c<com.tencent.mm.plugin.appbrand.jsapi.ai.c.a.c, TextureImageViewLikeImpl>
{
  protected static h.a<com.tencent.mm.plugin.appbrand.jsapi.ai.c.a.c, TextureImageViewLikeImpl> cGq;
  static com.tencent.mm.plugin.appbrand.jsapi.t.c cGr;
  final g cGs;
  
  static
  {
    AppMethodBeat.i(177147);
    cGq = new h.a() {};
    cGr = new com.tencent.mm.plugin.appbrand.jsapi.t.c()
    {
      public final a iZ(int paramAnonymousInt)
      {
        AppMethodBeat.i(177144);
        com.tencent.mm.plugin.appbrand.jsapi.ai.c.a.a.b localb = new com.tencent.mm.plugin.appbrand.jsapi.ai.c.a.a.b();
        localb.o("livePlayerId", Integer.valueOf(paramAnonymousInt));
        AppMethodBeat.o(177144);
        return localb;
      }
      
      public final a ja(int paramAnonymousInt)
      {
        AppMethodBeat.i(177145);
        com.tencent.mm.plugin.appbrand.jsapi.ai.c.a.a.c localc = new com.tencent.mm.plugin.appbrand.jsapi.ai.c.a.a.c();
        localc.o("livePlayerId", Integer.valueOf(paramAnonymousInt));
        AppMethodBeat.o(177145);
        return localc;
      }
    };
    AppMethodBeat.o(177147);
  }
  
  protected f(b paramb)
  {
    super(paramb);
    AppMethodBeat.i(177146);
    this.cGs = new com.tencent.mm.plugin.appbrand.jsapi.ai.c.a.c(paramb);
    AppMethodBeat.o(177146);
  }
  
  public final g Th()
  {
    return this.cGs;
  }
  
  public final h.a Ti()
  {
    return cGq;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.t.c Tj()
  {
    return cGr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.a.f
 * JD-Core Version:    0.7.0.1
 */