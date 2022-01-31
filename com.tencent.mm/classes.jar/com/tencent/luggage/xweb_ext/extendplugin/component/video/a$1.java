package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.luggage.xweb_ext.extendplugin.component.video.a.b.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.a.c;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class a$1
  implements b.a
{
  public a$1(a parama) {}
  
  public final void f(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(154409);
    ab.w("MicroMsg.SameLayer.VideoPluginHandler", "send video error event, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.bHR.xt()) {
      this.bHR.bHv.f(paramString, paramInt1, paramInt2);
    }
    if (this.bHR.bHx != null) {
      this.bHR.bHx.at(0L);
    }
    AppMethodBeat.o(154409);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.a.1
 * JD-Core Version:    0.7.0.1
 */