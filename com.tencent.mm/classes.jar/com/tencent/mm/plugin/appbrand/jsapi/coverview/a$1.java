package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.x.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.MultiTouchImageView;
import java.io.InputStream;

final class a$1
  implements a.c
{
  a$1(String paramString, MultiTouchImageView paramMultiTouchImageView, float paramFloat) {}
  
  public final void A(InputStream paramInputStream)
  {
    AppMethodBeat.i(195822);
    if (paramInputStream == null)
    {
      ad.e("MicroMsg.ImagePreviewerUtils", "openRead failed, url=%s", new Object[] { this.gXI });
      AppMethodBeat.o(195822);
      return;
    }
    paramInputStream = b.D(paramInputStream);
    paramInputStream.mark(b.getCompatibleRewindBufferSize());
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    a.aZI().b(paramInputStream, (BitmapFactory.Options)localObject);
    localObject = ((BitmapFactory.Options)localObject).outMimeType;
    int i = -1;
    switch (((String)localObject).hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      }
      try
      {
        paramInputStream.reset();
        localObject = a.aZI().decodeStream(paramInputStream);
        org.apache.commons.a.d.X(paramInputStream);
        if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
        {
          this.ibB.setImageBitmap((Bitmap)localObject);
          this.ibB.cH(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
          this.ibB.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(195821);
              if (a.1.this.cSz >= 0.5F)
              {
                a.1.this.ibB.bF(a.1.this.cSz);
                a.1.this.ibB.eSA();
              }
              AppMethodBeat.o(195821);
            }
          }, 100L);
        }
        AppMethodBeat.o(195822);
        return;
      }
      catch (Throwable paramInputStream)
      {
        ad.e("MicroMsg.ImagePreviewerUtils", "setImageBitmap failed, url=%s", new Object[] { this.gXI });
        AppMethodBeat.o(195822);
      }
      if (((String)localObject).equals("image/gif"))
      {
        i = 0;
        continue;
        if (((String)localObject).equals("image/GIF")) {
          i = 1;
        }
      }
    }
    ad.e("MicroMsg.ImagePreviewerUtils", "not support gift image");
    AppMethodBeat.o(195822);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.a.1
 * JD-Core Version:    0.7.0.1
 */