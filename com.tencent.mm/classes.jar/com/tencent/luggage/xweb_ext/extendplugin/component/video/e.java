package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.xweb_ext.extendplugin.component.i;
import com.tencent.luggage.xweb_ext.extendplugin.component.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai.e.j;
import com.tencent.mm.plugin.appbrand.jsapi.t.g;
import com.tencent.mm.plugin.appbrand.jsapi.t.h;
import com.tencent.mm.plugin.appbrand.jsapi.t.h.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;

final class e
  extends com.tencent.luggage.xweb_ext.extendplugin.component.c<j, View>
{
  private h.a<j, View> cGx;
  final c cKw;
  private final d cKx;
  
  public e(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(225583);
    this.cGx = new h.a() {};
    this.cKw = paramc;
    this.cKx = new d(paramc);
    AppMethodBeat.o(225583);
  }
  
  public final g Th()
  {
    return this.cKx.cGs;
  }
  
  public final h.a<j, View> Ti()
  {
    return this.cGx;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.t.c Tj()
  {
    return d.cGr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.e
 * JD-Core Version:    0.7.0.1
 */