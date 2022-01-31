package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.mm.plugin.appbrand.jsapi.e.d;
import com.tencent.mm.sdk.platformtools.y;

final class b$2
  implements e.d
{
  b$2(b paramb, AppBrandLivePlayerView paramAppBrandLivePlayerView) {}
  
  public final void pY()
  {
    Object localObject = this.gsg.grW;
    if ((((l)localObject).gsB) && (((l)localObject).gsH)) {}
    for (localObject = ((l)localObject).ue("resume");; localObject = new j())
    {
      y.i("MicroMsg.AppBrandLivePlayerView", "onForeground code:%d info:%s", new Object[] { Integer.valueOf(((j)localObject).errorCode), ((j)localObject).gst });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.b.2
 * JD-Core Version:    0.7.0.1
 */