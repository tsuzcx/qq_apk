package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.xweb_ext.extendplugin.component.i;
import com.tencent.luggage.xweb_ext.extendplugin.component.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.al.e.j;
import com.tencent.mm.plugin.appbrand.jsapi.w.g;
import com.tencent.mm.plugin.appbrand.jsapi.w.h;
import com.tencent.mm.plugin.appbrand.jsapi.w.h.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;

final class e
  extends com.tencent.luggage.xweb_ext.extendplugin.component.c<j, View>
{
  final c eEh;
  private final d eEi;
  private h.a<j, View> ezL;
  
  public e(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(220980);
    this.ezL = new h.a() {};
    this.eEh = paramc;
    this.eEi = new d(paramc);
    AppMethodBeat.o(220980);
  }
  
  public final g atM()
  {
    return this.eEi.ezG;
  }
  
  public final h.a<j, View> atN()
  {
    return this.ezL;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.w.c atO()
  {
    return d.ezF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.e
 * JD-Core Version:    0.7.0.1
 */