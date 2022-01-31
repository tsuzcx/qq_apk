package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.jsapi.e.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayer;

final class b$3
  implements e.b
{
  b$3(b paramb, AppBrandLivePlayerView paramAppBrandLivePlayerView) {}
  
  public final void qa()
  {
    Object localObject = this.gsg.grW;
    ((l)localObject).gsB = ((l)localObject).gsx.isPlaying();
    if ((((l)localObject).gsB) && (((l)localObject).gsH)) {
      if ((((l)localObject).gsa) && (((l)localObject).gsy != null)) {
        ((l)localObject).gsy.onPlayEvent(6000, new Bundle());
      }
    }
    for (localObject = ((l)localObject).ue("pause");; localObject = new j())
    {
      y.i("MicroMsg.AppBrandLivePlayerView", "onBackground code:%d info:%s", new Object[] { Integer.valueOf(((j)localObject).errorCode), ((j)localObject).gst });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.b.3
 * JD-Core Version:    0.7.0.1
 */