package com.tencent.mm.plugin.appbrand.jsapi.al.e;

import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

public final class d
  implements c
{
  private c.a sQL;
  
  public final void a(c.a parama)
  {
    this.sQL = parama;
  }
  
  public final void di(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(139580);
    Log.i("MicroMsg.SameLayer.AppBrandVideoErrorHandler", "onVideoError(%d, %d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    c.a locala;
    String str;
    if (this.sQL != null)
    {
      locala = this.sQL;
      if (paramInt1 != -1024) {
        break label69;
      }
      str = "VIDEO_ERROR";
    }
    for (;;)
    {
      locala.onVideoError(str, paramInt1, paramInt2);
      AppMethodBeat.o(139580);
      return;
      label69:
      if (paramInt1 == -20000) {
        str = "MEDIA_ERR_DRM";
      } else if (paramInt1 == -1010) {
        str = "MEDIA_ERR_SRC_NOT_SUPPORTED";
      } else if (paramInt1 == -1007) {
        str = "MEDIA_ERR_SRC_NOT_SUPPORTED";
      } else if (paramInt1 == -1004)
      {
        if (!NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
          str = "MEDIA_ERR_NETWORK";
        } else {
          str = "MEDIA_ERR_DECODE";
        }
      }
      else if (!NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
        str = "MEDIA_ERR_NETWORK";
      } else {
        str = "MEDIA_ERR_DECODE";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.e.d
 * JD-Core Version:    0.7.0.1
 */