package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.be;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.InputStream;

public final class h
  extends d
{
  public h(String paramString, c paramc, q paramq)
  {
    super(paramString, paramc, paramq);
  }
  
  public final void bBJ()
  {
    AppMethodBeat.i(135548);
    final AppBrandRuntime localAppBrandRuntime = this.jiP.getRuntime();
    if ((localAppBrandRuntime != null) && (this.mPt != null)) {
      com.tencent.e.h.JZN.aS(new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "PackageIconLoader";
        }
        
        public final void run()
        {
          AppMethodBeat.i(135547);
          InputStream localInputStream = be.f(localAppBrandRuntime, h.this.mPt);
          Bitmap localBitmap = BitmapFactory.decodeStream(localInputStream);
          if (localBitmap == null) {
            h.this.mPu.a("Failed to load icon via package path", h.this);
          }
          for (;;)
          {
            if (localInputStream != null) {
              bs.d(localInputStream);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.h
 * JD-Core Version:    0.7.0.1
 */