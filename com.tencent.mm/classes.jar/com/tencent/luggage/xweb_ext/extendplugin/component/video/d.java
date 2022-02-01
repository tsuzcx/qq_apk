package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.luggage.xweb_ext.extendplugin.component.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai.e.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.ai.e.j;
import com.tencent.mm.plugin.appbrand.jsapi.t.g;
import com.tencent.mm.plugin.appbrand.jsapi.t.h.a;
import com.tencent.mm.sdk.platformtools.Log;

final class d
  extends com.tencent.luggage.xweb_ext.extendplugin.component.c<j, TextureImageViewLikeImpl>
{
  protected static h.a<j, TextureImageViewLikeImpl> cGq;
  static com.tencent.mm.plugin.appbrand.jsapi.t.c cGr;
  final g cGs;
  
  static
  {
    AppMethodBeat.i(177180);
    cGq = new h.a() {};
    cGr = new com.tencent.mm.plugin.appbrand.jsapi.t.c()
    {
      public final com.tencent.mm.plugin.appbrand.jsapi.t.a iZ(int paramAnonymousInt)
      {
        AppMethodBeat.i(177177);
        com.tencent.mm.plugin.appbrand.jsapi.ai.e.b.a locala = new com.tencent.mm.plugin.appbrand.jsapi.ai.e.b.a();
        locala.o("videoPlayerId", Integer.valueOf(paramAnonymousInt));
        AppMethodBeat.o(177177);
        return locala;
      }
      
      public final com.tencent.mm.plugin.appbrand.jsapi.t.a ja(int paramAnonymousInt)
      {
        AppMethodBeat.i(177178);
        b localb = new b();
        localb.o("videoPlayerId", Integer.valueOf(paramAnonymousInt));
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
    this.cGs = new j(paramc);
    AppMethodBeat.o(177179);
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
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.d
 * JD-Core Version:    0.7.0.1
 */