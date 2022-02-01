package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.InputStream;

public final class h
  extends d
{
  public h(String paramString, c paramc, r paramr)
  {
    super(paramString, paramc, paramr);
  }
  
  public final void bGG()
  {
    AppMethodBeat.i(135548);
    final AppBrandRuntime localAppBrandRuntime = this.jFj.getRuntime();
    if ((localAppBrandRuntime != null) && (this.nva != null)) {
      com.tencent.e.h.MqF.aO(new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "PackageIconLoader";
        }
        
        public final void run()
        {
          AppMethodBeat.i(135547);
          InputStream localInputStream = bg.f(localAppBrandRuntime, h.this.nva);
          Bitmap localBitmap = BitmapFactory.decodeStream(localInputStream);
          if (localBitmap == null) {
            h.this.nvb.a("Failed to load icon via package path", h.this);
          }
          for (;;)
          {
            if (localInputStream != null) {
              bu.d(localInputStream);
            }
            AppMethodBeat.o(135547);
            return;
            h.this.S(localBitmap);
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