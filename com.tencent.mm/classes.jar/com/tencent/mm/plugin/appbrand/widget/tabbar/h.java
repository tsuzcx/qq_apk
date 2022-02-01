package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.InputStream;

public final class h
  extends d
{
  public h(String paramString, c paramc, q paramq)
  {
    super(paramString, paramc, paramq);
  }
  
  public final void bFL()
  {
    AppMethodBeat.i(135548);
    final AppBrandRuntime localAppBrandRuntime = this.jCl.getRuntime();
    if ((localAppBrandRuntime != null) && (this.npQ != null)) {
      com.tencent.e.h.LTJ.aR(new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "PackageIconLoader";
        }
        
        public final void run()
        {
          AppMethodBeat.i(135547);
          InputStream localInputStream = bf.f(localAppBrandRuntime, h.this.npQ);
          Bitmap localBitmap = BitmapFactory.decodeStream(localInputStream);
          if (localBitmap == null) {
            h.this.npR.a("Failed to load icon via package path", h.this);
          }
          for (;;)
          {
            if (localInputStream != null) {
              bt.d(localInputStream);
            }
            AppMethodBeat.o(135547);
            return;
            h.this.R(localBitmap);
          }
        }
      });
    }
    AppMethodBeat.o(135548);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.h
 * JD-Core Version:    0.7.0.1
 */