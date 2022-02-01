package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.google.android.exoplayer2.h.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

final class c$1
  implements d.a
{
  c$1(c paramc) {}
  
  public final void k(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(194113);
    ac.d("MicroMsg.SameLayer.ExoVideoCacheHandler", "onCachedBytesRead, cacheSpace:%s, totalCachedBytesRead:%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(194113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.c.1
 * JD-Core Version:    0.7.0.1
 */