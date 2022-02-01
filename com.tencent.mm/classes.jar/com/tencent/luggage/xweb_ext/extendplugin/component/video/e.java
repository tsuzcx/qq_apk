package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.xweb_ext.extendplugin.component.i;
import com.tencent.luggage.xweb_ext.extendplugin.component.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ad.e.j;
import com.tencent.mm.plugin.appbrand.jsapi.q.g;
import com.tencent.mm.plugin.appbrand.jsapi.q.h;
import com.tencent.mm.plugin.appbrand.jsapi.q.h.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.concurrent.atomic.AtomicBoolean;

final class e
  extends com.tencent.luggage.xweb_ext.extendplugin.component.c<j, View>
{
  private h.a<j, View> ctz;
  final c cvU;
  private final d cvV;
  
  public e(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(220541);
    this.ctz = new h.a() {};
    this.cvU = paramc;
    this.cvV = new d(paramc);
    AppMethodBeat.o(220541);
  }
  
  public final g FZ()
  {
    return this.cvV.ctt;
  }
  
  public final h.a<j, View> Ga()
  {
    return this.ctz;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.q.c Gb()
  {
    return d.cts;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.e
 * JD-Core Version:    0.7.0.1
 */