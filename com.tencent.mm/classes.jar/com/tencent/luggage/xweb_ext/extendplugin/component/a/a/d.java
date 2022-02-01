package com.tencent.luggage.xweb_ext.extendplugin.component.a.a;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.xweb_ext.extendplugin.component.i;
import com.tencent.luggage.xweb_ext.extendplugin.component.t;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.TextureImageViewLikeImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.q.g;
import com.tencent.mm.plugin.appbrand.jsapi.q.h;
import com.tencent.mm.plugin.appbrand.jsapi.q.h.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.concurrent.atomic.AtomicBoolean;

final class d
  extends com.tencent.luggage.xweb_ext.extendplugin.component.c<com.tencent.mm.plugin.appbrand.jsapi.ad.c.a.c, View>
{
  final a ctA;
  private final c ctB;
  private h.a<com.tencent.mm.plugin.appbrand.jsapi.ad.c.a.c, View> ctz;
  
  protected d(a parama)
  {
    super(parama);
    AppMethodBeat.i(220467);
    this.ctz = new h.a() {};
    this.ctA = parama;
    this.ctB = new c(parama);
    AppMethodBeat.o(220467);
  }
  
  public final g FZ()
  {
    return this.ctB.ctt;
  }
  
  public final h.a<com.tencent.mm.plugin.appbrand.jsapi.ad.c.a.c, View> Ga()
  {
    return this.ctz;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.q.c Gb()
  {
    return c.cts;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a.a.d
 * JD-Core Version:    0.7.0.1
 */