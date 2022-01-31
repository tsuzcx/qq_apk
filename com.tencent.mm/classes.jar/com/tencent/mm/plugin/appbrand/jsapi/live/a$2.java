package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.sdk.platformtools.ab;

final class a$2
  implements f.d
{
  a$2(a parama, AppBrandLivePlayerView paramAppBrandLivePlayerView) {}
  
  public final void onForeground()
  {
    AppMethodBeat.i(96071);
    Object localObject = this.hNC.hNq;
    if (((k)localObject).bGp) {}
    for (localObject = ((k)localObject).Ce("resume");; localObject = new i())
    {
      ab.i("MicroMsg.AppBrandLivePlayerView", "onForeground code:%d info:%s", new Object[] { Integer.valueOf(((i)localObject).errorCode), ((i)localObject).bFT });
      AppMethodBeat.o(96071);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.a.2
 * JD-Core Version:    0.7.0.1
 */