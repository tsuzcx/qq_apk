package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.xweb_ext.extendplugin.component.i;
import com.tencent.luggage.xweb_ext.extendplugin.component.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e.j;
import com.tencent.mm.plugin.appbrand.jsapi.q.g;
import com.tencent.mm.plugin.appbrand.jsapi.q.h;
import com.tencent.mm.plugin.appbrand.jsapi.q.h.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.concurrent.atomic.AtomicBoolean;

final class e
  extends com.tencent.luggage.xweb_ext.extendplugin.component.c<j, View>
{
  private h.a<j, View> csV;
  final c cvq;
  private final d cvr;
  
  public e(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(186849);
    this.csV = new h.a() {};
    this.cvq = paramc;
    this.cvr = new d(paramc);
    AppMethodBeat.o(186849);
  }
  
  public final g FT()
  {
    return this.cvr.csQ;
  }
  
  public final h.a<j, View> FU()
  {
    return this.csV;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.q.c FV()
  {
    return d.csP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.e
 * JD-Core Version:    0.7.0.1
 */