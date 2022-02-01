package com.tencent.luggage.xweb_ext.extendplugin.component.live.a;

import android.view.Surface;
import com.tencent.luggage.xweb_ext.extendplugin.component.d;
import com.tencent.luggage.xweb_ext.extendplugin.component.d.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.TextureImageViewLikeImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.w.a;
import com.tencent.mm.plugin.appbrand.jsapi.w.g;
import com.tencent.mm.plugin.appbrand.jsapi.w.h.a;

final class f
  extends com.tencent.luggage.xweb_ext.extendplugin.component.c<com.tencent.mm.plugin.appbrand.jsapi.al.c.a.c, TextureImageViewLikeImpl>
{
  protected static h.a<com.tencent.mm.plugin.appbrand.jsapi.al.c.a.c, TextureImageViewLikeImpl> ezE;
  static com.tencent.mm.plugin.appbrand.jsapi.w.c ezF;
  final g ezG;
  
  static
  {
    AppMethodBeat.i(177147);
    ezE = new h.a() {};
    ezF = new com.tencent.mm.plugin.appbrand.jsapi.w.c()
    {
      public final a mB(int paramAnonymousInt)
      {
        AppMethodBeat.i(177144);
        com.tencent.mm.plugin.appbrand.jsapi.al.c.a.a.b localb = new com.tencent.mm.plugin.appbrand.jsapi.al.c.a.a.b();
        localb.w("livePlayerId", Integer.valueOf(paramAnonymousInt));
        AppMethodBeat.o(177144);
        return localb;
      }
      
      public final a mC(int paramAnonymousInt)
      {
        AppMethodBeat.i(177145);
        com.tencent.mm.plugin.appbrand.jsapi.al.c.a.a.c localc = new com.tencent.mm.plugin.appbrand.jsapi.al.c.a.a.c();
        localc.w("livePlayerId", Integer.valueOf(paramAnonymousInt));
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
    this.ezG = new com.tencent.mm.plugin.appbrand.jsapi.al.c.a.c(paramb);
    AppMethodBeat.o(177146);
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
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.a.f
 * JD-Core Version:    0.7.0.1
 */