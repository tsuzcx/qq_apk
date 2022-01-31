package com.tencent.luggage.xweb_ext.extendplugin.component.video.cache;

import com.google.android.exoplayer2.h.a.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$2$1
  implements c.a
{
  a$2$1(a.2 param2) {}
  
  public final void l(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(139876);
    ab.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "onCachedBytesRead, cacheSpace:%s, totalCachedBytesRead:%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(139876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.cache.a.2.1
 * JD-Core Version:    0.7.0.1
 */