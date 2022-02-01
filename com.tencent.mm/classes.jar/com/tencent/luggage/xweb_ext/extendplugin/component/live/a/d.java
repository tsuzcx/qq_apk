package com.tencent.luggage.xweb_ext.extendplugin.component.live.a;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.xweb_ext.extendplugin.component.i;
import com.tencent.luggage.xweb_ext.extendplugin.component.t;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.TextureImageViewLikeImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s.g;
import com.tencent.mm.plugin.appbrand.jsapi.s.h;
import com.tencent.mm.plugin.appbrand.jsapi.s.h.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;

final class d
  extends com.tencent.luggage.xweb_ext.extendplugin.component.c<com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.c, View>
{
  private h.a<com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.c, View> cFR;
  final a cFS;
  private final c cFT;
  
  protected d(a parama)
  {
    super(parama);
    AppMethodBeat.i(215625);
    this.cFR = new h.a() {};
    this.cFS = parama;
    this.cFT = new c(parama);
    AppMethodBeat.o(215625);
  }
  
  public final g PI()
  {
    return this.cFT.cFM;
  }
  
  public final h.a<com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.c, View> PJ()
  {
    return this.cFR;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.s.c PK()
  {
    return c.cFL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.a.d
 * JD-Core Version:    0.7.0.1
 */