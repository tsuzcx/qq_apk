package com.tencent.mm.plugin.appbrand.jsapi.s;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.c.a;

final class b$1$1
  implements Runnable
{
  b$1$1(b.1 param1, byte[] paramArrayOfByte) {}
  
  public final void run()
  {
    AppMethodBeat.i(126628);
    if ((this.ieT == null) || (this.ieT.length == 0))
    {
      AppMethodBeat.o(126628);
      return;
    }
    Object localObject = this.ieT;
    int i;
    if ((localObject == null) || (localObject.length <= 0)) {
      i = 0;
    }
    label42:
    while (i != 0)
    {
      this.ieU.ieS.setImageByteArray(this.ieT);
      AppMethodBeat.o(126628);
      return;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length, localOptions);
      localObject = localOptions.outMimeType;
      com.tencent.luggage.g.d.v("Util", "imageType:%s", new Object[] { localObject });
      i = -1;
      switch (((String)localObject).hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          i = 0;
          break label42;
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
      i = 1;
    }
    try
    {
      localObject = com.tencent.mm.sdk.platformtools.d.bT(this.ieT);
      this.ieU.ieS.setImageBitmap((Bitmap)localObject);
      AppMethodBeat.o(126628);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.luggage.g.d.b("Luggage.ViewAttributeHelper", "", new Object[] { localException });
      AppMethodBeat.o(126628);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.b.1.1
 * JD-Core Version:    0.7.0.1
 */