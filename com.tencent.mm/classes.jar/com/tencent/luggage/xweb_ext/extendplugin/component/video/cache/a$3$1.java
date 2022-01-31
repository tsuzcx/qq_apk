package com.tencent.luggage.xweb_ext.extendplugin.component.video.cache;

import com.google.android.exoplayer2.h.a.a;
import com.google.android.exoplayer2.h.a.a.b;
import com.google.android.exoplayer2.h.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$3$1
  implements a.b
{
  a$3$1(a.3 param3) {}
  
  public final void a(a parama, e parame)
  {
    AppMethodBeat.i(139878);
    ab.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "onSpanAdded, cacheSpan isCached:%s [%s, %s]", new Object[] { Boolean.valueOf(parame.aZZ), Long.valueOf(parame.position), Long.valueOf(parame.aPF) });
    AppMethodBeat.o(139878);
  }
  
  public final void a(a parama, e parame1, e parame2)
  {
    AppMethodBeat.i(139880);
    ab.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "onSpanTouched, cacheSpan isCached:%s [%s, %s]", new Object[] { Boolean.valueOf(parame1.aZZ), Long.valueOf(parame1.position), Long.valueOf(parame1.aPF) });
    AppMethodBeat.o(139880);
  }
  
  public final void c(e parame)
  {
    AppMethodBeat.i(139879);
    ab.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "onSpanRemoved, cacheSpan isCached:%s [%s, %s]", new Object[] { Boolean.valueOf(parame.aZZ), Long.valueOf(parame.position), Long.valueOf(parame.aPF) });
    AppMethodBeat.o(139879);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.cache.a.3.1
 * JD-Core Version:    0.7.0.1
 */