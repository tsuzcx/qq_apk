package com.tencent.mm.plugin.appbrand.weishi;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.i;
import com.tencent.mm.sdk.platformtools.ab;

final class b$3
  implements b.i
{
  b$3(ImageView paramImageView, Runnable paramRunnable, String paramString) {}
  
  public final void acG() {}
  
  public final void acH()
  {
    AppMethodBeat.i(133626);
    ab.e("MicroMsg.AppBrandThumbLoadingSplash", "splash thumb loaded fail");
    if (this.jad != null) {
      b.a(this.sa, this.jad, this.jag);
    }
    AppMethodBeat.o(133626);
  }
  
  public final String tX()
  {
    return "AppBrandWeishiLoadingSplash#THUMB";
  }
  
  public final void w(Bitmap paramBitmap)
  {
    AppMethodBeat.i(133625);
    ab.i("MicroMsg.AppBrandThumbLoadingSplash", "splash thumb loaded");
    b.a(this.sa, paramBitmap);
    if (this.jag != null) {
      this.jag.run();
    }
    AppMethodBeat.o(133625);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.weishi.b.3
 * JD-Core Version:    0.7.0.1
 */