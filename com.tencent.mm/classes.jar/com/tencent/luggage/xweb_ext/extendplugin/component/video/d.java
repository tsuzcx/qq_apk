package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.luggage.xweb_ext.extendplugin.component.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ag.e.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.ag.e.j;
import com.tencent.mm.plugin.appbrand.jsapi.s.g;
import com.tencent.mm.plugin.appbrand.jsapi.s.h.a;
import com.tencent.mm.sdk.platformtools.Log;

final class d
  extends com.tencent.luggage.xweb_ext.extendplugin.component.c<j, TextureImageViewLikeImpl>
{
  protected static h.a<j, TextureImageViewLikeImpl> cFK;
  static com.tencent.mm.plugin.appbrand.jsapi.s.c cFL;
  final g cFM;
  
  static
  {
    AppMethodBeat.i(177180);
    cFK = new h.a() {};
    cFL = new com.tencent.mm.plugin.appbrand.jsapi.s.c()
    {
      public final com.tencent.mm.plugin.appbrand.jsapi.s.a hW(int paramAnonymousInt)
      {
        AppMethodBeat.i(177177);
        com.tencent.mm.plugin.appbrand.jsapi.ag.e.b.a locala = new com.tencent.mm.plugin.appbrand.jsapi.ag.e.b.a();
        locala.p("videoPlayerId", Integer.valueOf(paramAnonymousInt));
        AppMethodBeat.o(177177);
        return locala;
      }
      
      public final com.tencent.mm.plugin.appbrand.jsapi.s.a hX(int paramAnonymousInt)
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
    this.cFM = new j(paramc);
    AppMethodBeat.o(177179);
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
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.d
 * JD-Core Version:    0.7.0.1
 */