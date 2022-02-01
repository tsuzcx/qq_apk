package com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a;

import com.google.android.exoplayer2.h.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class d$1
  implements d.a
{
  d$1(d paramd) {}
  
  public final void l(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(228075);
    Log.d("MicroMsg.SameLayer.ExoVideoCacheHandler", "onCachedBytesRead, cacheSpace:%s, totalCachedBytesRead:%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(228075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a.d.1
 * JD-Core Version:    0.7.0.1
 */