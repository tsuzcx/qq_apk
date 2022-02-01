package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.xweb_ext.extendplugin.component.i;
import com.tencent.luggage.xweb_ext.extendplugin.component.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ag.e.j;
import com.tencent.mm.plugin.appbrand.jsapi.s.g;
import com.tencent.mm.plugin.appbrand.jsapi.s.h;
import com.tencent.mm.plugin.appbrand.jsapi.s.h.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;

final class e
  extends com.tencent.luggage.xweb_ext.extendplugin.component.c<j, View>
{
  private h.a<j, View> cFR;
  final c cJT;
  private final d cJU;
  
  public e(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(215747);
    this.cFR = new h.a() {};
    this.cJT = paramc;
    this.cJU = new d(paramc);
    AppMethodBeat.o(215747);
  }
  
  public final g PI()
  {
    return this.cJU.cFM;
  }
  
  public final h.a<j, View> PJ()
  {
    return this.cFR;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.s.c PK()
  {
    return d.cFL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.e
 * JD-Core Version:    0.7.0.1
 */