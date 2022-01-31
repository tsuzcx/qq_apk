package com.tencent.mm.plugin.appbrand.jsapi.v.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.skia_canvas.IXWebImageLoader.LoadImageCallback;

final class b$2
  implements a.c
{
  b$2(b paramb, IXWebImageLoader.LoadImageCallback paramLoadImageCallback) {}
  
  public final void C(Bitmap paramBitmap)
  {
    boolean bool = true;
    AppMethodBeat.i(154460);
    if (paramBitmap != null) {}
    for (;;)
    {
      ab.i("MicroMsg.WxaNativeImageLoader", "onResult bitmap:%b", new Object[] { Boolean.valueOf(bool) });
      if (this.iis != null) {
        this.iis.onLoadImageCallback(paramBitmap);
      }
      AppMethodBeat.o(154460);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.a.b.2
 * JD-Core Version:    0.7.0.1
 */