package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.InputStream;

public final class h
  extends d
{
  public h(String paramString, c paramc, v paramv)
  {
    super(paramString, paramc, paramv);
  }
  
  public final void cqr()
  {
    AppMethodBeat.i(135548);
    final AppBrandRuntime localAppBrandRuntime = this.nAz.getRuntime();
    if ((localAppBrandRuntime != null) && (this.rGO != null)) {
      com.tencent.e.h.ZvG.be(new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "PackageIconLoader";
        }
        
        public final void run()
        {
          AppMethodBeat.i(135547);
          InputStream localInputStream = bl.f(localAppBrandRuntime, h.this.rGO);
          Bitmap localBitmap = BitmapFactory.decodeStream(localInputStream);
          if (localBitmap == null) {
            h.this.rGP.a("Failed to load icon via package path", h.this);
          }
          for (;;)
          {
            if (localInputStream != null) {
              Util.qualityClose(localInputStream);
            }
            AppMethodBeat.o(135547);
            return;
            h.this.V(localBitmap);
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