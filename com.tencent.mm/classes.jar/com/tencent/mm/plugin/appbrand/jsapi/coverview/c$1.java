package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.media.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.MultiTouchImageView;
import java.io.InputStream;
import org.apache.commons.a.d;

final class c$1
  implements a.c
{
  c$1(c.a parama, String paramString1, String paramString2, MultiTouchImageView paramMultiTouchImageView, float paramFloat) {}
  
  public final void A(InputStream paramInputStream)
  {
    AppMethodBeat.i(280441);
    if (paramInputStream == null)
    {
      if (this.oPS != null) {
        this.oPS.dA(this.val$url, "null InputStream, finalUrl: " + this.lEX);
      }
      Log.e("MicroMsg.ImagePreviewerUtils", "openRead failed, url=%s", new Object[] { this.lEX });
      AppMethodBeat.o(280441);
      return;
    }
    paramInputStream = com.tencent.mm.plugin.appbrand.jsapi.ae.c.D(paramInputStream);
    paramInputStream.mark(com.tencent.mm.plugin.appbrand.jsapi.ae.c.getCompatibleRewindBufferSize());
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    c.bRU().b(paramInputStream, (BitmapFactory.Options)localObject);
    localObject = ((BitmapFactory.Options)localObject).outMimeType;
    int i = -1;
    switch (((String)localObject).hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        try
        {
          paramInputStream.reset();
          localObject = c.bRU().decodeStream(paramInputStream);
          d.T(paramInputStream);
          if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
            break label372;
          }
          this.mLX.setImageBitmap((Bitmap)localObject);
          this.mLX.di(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
          this.mLX.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(265411);
              if (c.1.this.val$scale >= 0.5F)
              {
                c.1.this.mLX.cK(c.1.this.val$scale);
                c.1.this.mLX.hJy();
              }
              AppMethodBeat.o(265411);
            }
          }, 100L);
          AppMethodBeat.o(280441);
          return;
        }
        catch (Throwable paramInputStream)
        {
          if (this.oPS != null) {
            this.oPS.dA(this.val$url, "exception found: " + paramInputStream.toString());
          }
          Log.e("MicroMsg.ImagePreviewerUtils", "setImageBitmap failed, url=%s", new Object[] { this.lEX });
          AppMethodBeat.o(280441);
          return;
        }
        if (((String)localObject).equals("image/gif"))
        {
          i = 0;
          continue;
          if (((String)localObject).equals("image/GIF")) {
            i = 1;
          }
        }
        break;
      }
    }
    if (this.oPS != null) {
      this.oPS.dA(this.val$url, "not support gif");
    }
    Log.e("MicroMsg.ImagePreviewerUtils", "not support gift image");
    AppMethodBeat.o(280441);
    return;
    label372:
    if (this.oPS != null) {
      this.oPS.dA(this.val$url, "bmp is null or recycled");
    }
    AppMethodBeat.o(280441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.c.1
 * JD-Core Version:    0.7.0.1
 */