package com.tencent.mm.plugin.appbrand.dynamic.b;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.d;
import com.tencent.mm.modelappbrand.a.b.l;
import com.tencent.mm.plugin.appbrand.dynamic.j.c;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.xweb.WebResourceResponse;
import java.io.IOException;
import java.io.InputStream;

public final class a
{
  private static final b.l kfO;
  
  static
  {
    AppMethodBeat.i(121250);
    kfO = new b.d();
    AppMethodBeat.o(121250);
  }
  
  public static Bitmap cK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121249);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(121249);
      return null;
    }
    Object localObject = LaunchParcel.Mq(paramString2);
    if (bt.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(121249);
      return null;
    }
    paramString2 = paramString1 + '#' + (String)localObject;
    Bitmap localBitmap = kfO.vT(paramString2);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      AppMethodBeat.o(121249);
      return localBitmap;
    }
    paramString1 = c.cQ(paramString1, (String)localObject);
    if (paramString1 != null) {}
    try
    {
      if (paramString1.mInputStream != null)
      {
        int i = paramString1.mInputStream.available();
        if (i > 0) {}
      }
      else
      {
        return null;
      }
      localObject = g.decodeStream(paramString1.mInputStream);
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        kfO.put(paramString2, (Bitmap)localObject);
        return localObject;
      }
      if (paramString1 != null) {
        bt.d(paramString1.mInputStream);
      }
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        ad.e("MicroMsg.CanvasImageCache", "try decode icon e = %s", new Object[] { paramString2 });
        if (paramString1 != null) {
          bt.d(paramString1.mInputStream);
        }
      }
    }
    finally
    {
      if (paramString1 == null) {
        break label255;
      }
      bt.d(paramString1.mInputStream);
      AppMethodBeat.o(121249);
    }
    AppMethodBeat.o(121249);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.b.a
 * JD-Core Version:    0.7.0.1
 */