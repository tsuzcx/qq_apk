package com.tencent.mm.plugin.appbrand.widget.i;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ax;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.InputStream;

final class h$1
  implements Runnable
{
  h$1(h paramh, i parami) {}
  
  public final void run()
  {
    AppMethodBeat.i(87568);
    InputStream localInputStream = ax.f(this.gWQ, this.jxj.jxc);
    Bitmap localBitmap = BitmapFactory.decodeStream(localInputStream);
    if (localBitmap == null) {
      this.jxj.jxd.a("Failed to load icon via package path", this.jxj);
    }
    for (;;)
    {
      if (localInputStream != null) {
        bo.b(localInputStream);
      }
      AppMethodBeat.o(87568);
      return;
      this.jxj.G(localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.i.h.1
 * JD-Core Version:    0.7.0.1
 */