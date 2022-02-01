package com.tencent.mm.plugin.appbrand.dynamic.b;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.d;
import com.tencent.mm.modelappbrand.a.b.l;
import com.tencent.mm.plugin.appbrand.dynamic.j.c;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.xweb.WebResourceResponse;
import java.io.IOException;
import java.io.InputStream;

public final class a
{
  private static final b.l kje;
  
  static
  {
    AppMethodBeat.i(121250);
    kje = new b.d();
    AppMethodBeat.o(121250);
  }
  
  public static Bitmap cM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121249);
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(121249);
      return null;
    }
    Object localObject = LaunchParcel.MW(paramString2);
    if (bu.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(121249);
      return null;
    }
    paramString2 = paramString1 + '#' + (String)localObject;
    Bitmap localBitmap = kje.wA(paramString2);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      AppMethodBeat.o(121249);
      return localBitmap;
    }
    paramString1 = c.cS(paramString1, (String)localObject);
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
      localObject = h.decodeStream(paramString1.mInputStream);
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        kje.put(paramString2, (Bitmap)localObject);
        return localObject;
      }
      if (paramString1 != null) {
        bu.d(paramString1.mInputStream);
      }
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        ae.e("MicroMsg.CanvasImageCache", "try decode icon e = %s", new Object[] { paramString2 });
        if (paramString1 != null) {
          bu.d(paramString1.mInputStream);
        }
      }
    }
    finally
    {
      if (paramString1 == null) {
        break label255;
      }
      bu.d(paramString1.mInputStream);
      AppMethodBeat.o(121249);
    }
    AppMethodBeat.o(121249);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.b.a
 * JD-Core Version:    0.7.0.1
 */