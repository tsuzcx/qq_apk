package com.tencent.mm.plugin.appbrand.jsapi.v.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e.a;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.skia_canvas.IXWebImageLoader;
import com.tencent.xweb.skia_canvas.IXWebImageLoader.LoadImageCallback;

public final class b
  implements IXWebImageLoader
{
  a byB;
  r iip;
  com.tencent.mm.plugin.appbrand.e.b iiq;
  
  public b(com.tencent.mm.plugin.appbrand.e.b paramb, a parama, r paramr)
  {
    this.iiq = paramb;
    this.byB = parama;
    this.iip = paramr;
  }
  
  public final Bitmap loadImage(String paramString)
  {
    AppMethodBeat.i(154461);
    if ((this.byB == null) || (this.iiq == null) || (this.iip == null))
    {
      ab.e("MicroMsg.WxaNativeImageLoader", "mImageLoader or mUrlBuilder is null, return");
      AppMethodBeat.o(154461);
      return null;
    }
    paramString = this.iiq.b(this.iip, paramString);
    paramString = this.byB.a(paramString, null, new b.1(this));
    AppMethodBeat.o(154461);
    return paramString;
  }
  
  public final void loadImageAsync(String paramString, IXWebImageLoader.LoadImageCallback paramLoadImageCallback)
  {
    AppMethodBeat.i(154462);
    if ((this.byB == null) || (this.iiq == null) || (this.iip == null))
    {
      ab.e("MicroMsg.WxaNativeImageLoader", "mImageLoader or mUrlBuilder is null, return");
      paramLoadImageCallback.onLoadImageCallback(null);
      AppMethodBeat.o(154462);
      return;
    }
    paramString = this.iiq.b(this.iip, paramString);
    ab.i("MicroMsg.WxaNativeImageLoader", "finalUrl : %s", new Object[] { paramString });
    this.byB.a(paramString, new b.2(this, paramLoadImageCallback));
    AppMethodBeat.o(154462);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.a.b
 * JD-Core Version:    0.7.0.1
 */