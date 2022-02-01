package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.MultiTouchImageView;
import java.io.InputStream;

final class c$1
  implements a.c
{
  c$1(c.a parama, String paramString1, String paramString2, MultiTouchImageView paramMultiTouchImageView, float paramFloat) {}
  
  public final void C(InputStream paramInputStream)
  {
    AppMethodBeat.i(226735);
    if (paramInputStream == null)
    {
      if (this.lTj != null) {
        this.lTj.dr(this.val$url, "null InputStream, finalUrl: " + this.iOH);
      }
      Log.e("MicroMsg.ImagePreviewerUtils", "openRead failed, url=%s", new Object[] { this.iOH });
      AppMethodBeat.o(226735);
      return;
    }
    paramInputStream = com.tencent.mm.plugin.appbrand.jsapi.ac.c.F(paramInputStream);
    paramInputStream.mark(com.tencent.mm.plugin.appbrand.jsapi.ac.c.getCompatibleRewindBufferSize());
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    c.bGk().b(paramInputStream, (BitmapFactory.Options)localObject);
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
          localObject = c.bGk().decodeStream(paramInputStream);
          org.apache.commons.a.e.W(paramInputStream);
          if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
            break label372;
          }
          this.jUK.setImageBitmap((Bitmap)localObject);
          this.jUK.cN(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
          this.jUK.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(226734);
              if (c.1.this.dsJ >= 0.5F)
              {
                c.1.this.jUK.cs(c.1.this.dsJ);
                c.1.this.jUK.gKz();
              }
              AppMethodBeat.o(226734);
            }
          }, 100L);
          AppMethodBeat.o(226735);
          return;
        }
        catch (Throwable paramInputStream)
        {
          if (this.lTj != null) {
            this.lTj.dr(this.val$url, "exception found: " + paramInputStream.toString());
          }
          Log.e("MicroMsg.ImagePreviewerUtils", "setImageBitmap failed, url=%s", new Object[] { this.iOH });
          AppMethodBeat.o(226735);
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
    if (this.lTj != null) {
      this.lTj.dr(this.val$url, "not support gif");
    }
    Log.e("MicroMsg.ImagePreviewerUtils", "not support gift image");
    AppMethodBeat.o(226735);
    return;
    label372:
    if (this.lTj != null) {
      this.lTj.dr(this.val$url, "bmp is null or recycled");
    }
    AppMethodBeat.o(226735);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.c.1
 * JD-Core Version:    0.7.0.1
 */