package com.tencent.luggage.xweb_ext.extendplugin.component.live.a;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.xweb_ext.extendplugin.component.i;
import com.tencent.luggage.xweb_ext.extendplugin.component.t;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.TextureImageViewLikeImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.t.d;
import com.tencent.mm.plugin.appbrand.jsapi.t.h;
import com.tencent.mm.plugin.appbrand.jsapi.t.h.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;

final class g
  extends com.tencent.luggage.xweb_ext.extendplugin.component.c<com.tencent.mm.plugin.appbrand.jsapi.ai.c.a.c, View>
{
  private h.a<com.tencent.mm.plugin.appbrand.jsapi.ai.c.a.c, View> cGx;
  final b cGy;
  private final f cGz;
  
  protected g(b paramb)
  {
    super(paramb);
    AppMethodBeat.i(225006);
    this.cGx = new h.a() {};
    this.cGy = paramb;
    this.cGz = new f(paramb);
    AppMethodBeat.o(225006);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.t.g Th()
  {
    return this.cGz.cGs;
  }
  
  public final h.a<com.tencent.mm.plugin.appbrand.jsapi.ai.c.a.c, View> Ti()
  {
    return this.cGx;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.t.c Tj()
  {
    return f.cGr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.a.g
 * JD-Core Version:    0.7.0.1
 */