package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.luggage.xweb_ext.extendplugin.component.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.al.e.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.al.e.j;
import com.tencent.mm.plugin.appbrand.jsapi.w.g;
import com.tencent.mm.plugin.appbrand.jsapi.w.h.a;
import com.tencent.mm.sdk.platformtools.Log;

final class d
  extends com.tencent.luggage.xweb_ext.extendplugin.component.c<j, TextureImageViewLikeImpl>
{
  protected static h.a<j, TextureImageViewLikeImpl> ezE;
  static com.tencent.mm.plugin.appbrand.jsapi.w.c ezF;
  final g ezG;
  
  static
  {
    AppMethodBeat.i(177180);
    ezE = new h.a() {};
    ezF = new com.tencent.mm.plugin.appbrand.jsapi.w.c()
    {
      public final com.tencent.mm.plugin.appbrand.jsapi.w.a mB(int paramAnonymousInt)
      {
        AppMethodBeat.i(177177);
        com.tencent.mm.plugin.appbrand.jsapi.al.e.b.a locala = new com.tencent.mm.plugin.appbrand.jsapi.al.e.b.a();
        locala.w("videoPlayerId", Integer.valueOf(paramAnonymousInt));
        AppMethodBeat.o(177177);
        return locala;
      }
      
      public final com.tencent.mm.plugin.appbrand.jsapi.w.a mC(int paramAnonymousInt)
      {
        AppMethodBeat.i(177178);
        b localb = new b();
        localb.w("videoPlayerId", Integer.valueOf(paramAnonymousInt));
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
    this.ezG = new j(paramc);
    AppMethodBeat.o(177179);
  }
  
  public final g atM()
  {
    return this.ezG;
  }
  
  public final h.a atN()
  {
    return ezE;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.w.c atO()
  {
    return ezF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.d
 * JD-Core Version:    0.7.0.1
 */