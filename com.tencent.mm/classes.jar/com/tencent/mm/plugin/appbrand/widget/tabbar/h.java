package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.io.InputStream;

public final class h
  extends d
{
  public h(String paramString, c paramc, y paramy)
  {
    super(paramString, paramc, paramy);
  }
  
  public final void cSY()
  {
    AppMethodBeat.i(135548);
    final AppBrandRuntime localAppBrandRuntime = this.qqV.getRuntime();
    if ((localAppBrandRuntime != null) && (this.uSe != null)) {
      com.tencent.threadpool.h.ahAA.bm(new com.tencent.threadpool.i.h()
      {
        public final String getKey()
        {
          return "PackageIconLoader";
        }
        
        public final void run()
        {
          AppMethodBeat.i(135547);
          InputStream localInputStream = bl.f(localAppBrandRuntime, h.this.uSe);
          Bitmap localBitmap = BitmapFactory.decodeStream(localInputStream);
          if (localBitmap == null) {
            h.this.uSf.a("Failed to load icon via package path", h.this);
          }
          for (;;)
          {
            if (localInputStream != null) {
              Util.qualityClose(localInputStream);
            }
            AppMethodBeat.o(135547);
            return;
            h.this.ae(localBitmap);
          }
        }
      });
    }
    AppMethodBeat.o(135548);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.h
 * JD-Core Version:    0.7.0.1
 */