package com.tencent.luggage.xweb_ext.extendplugin.component.live.a;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.xweb_ext.extendplugin.component.i;
import com.tencent.luggage.xweb_ext.extendplugin.component.t;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.TextureImageViewLikeImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.w.d;
import com.tencent.mm.plugin.appbrand.jsapi.w.h;
import com.tencent.mm.plugin.appbrand.jsapi.w.h.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;

final class g
  extends com.tencent.luggage.xweb_ext.extendplugin.component.c<com.tencent.mm.plugin.appbrand.jsapi.al.c.a.c, View>
{
  private h.a<com.tencent.mm.plugin.appbrand.jsapi.al.c.a.c, View> ezL;
  final b ezM;
  private final f ezN;
  
  protected g(b paramb)
  {
    super(paramb);
    AppMethodBeat.i(220658);
    this.ezL = new h.a() {};
    this.ezM = paramb;
    this.ezN = new f(paramb);
    AppMethodBeat.o(220658);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.w.g atM()
  {
    return this.ezN.ezG;
  }
  
  public final h.a<com.tencent.mm.plugin.appbrand.jsapi.al.c.a.c, View> atN()
  {
    return this.ezL;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.w.c atO()
  {
    return f.ezF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.a.g
 * JD-Core Version:    0.7.0.1
 */