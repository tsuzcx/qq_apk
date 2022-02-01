package com.tencent.mm.plugin.appbrand.dynamic.b;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.d;
import com.tencent.mm.modelappbrand.a.b.l;
import com.tencent.mm.plugin.appbrand.dynamic.j.c;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.xweb.WebResourceResponse;
import java.io.IOException;
import java.io.InputStream;

public final class a
{
  private static final b.l jLD;
  
  static
  {
    AppMethodBeat.i(121250);
    jLD = new b.d();
    AppMethodBeat.o(121250);
  }
  
  public static Bitmap cI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121249);
    if ((bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(121249);
      return null;
    }
    Object localObject = LaunchParcel.IZ(paramString2);
    if (bs.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(121249);
      return null;
    }
    paramString2 = paramString1 + '#' + (String)localObject;
    Bitmap localBitmap = jLD.te(paramString2);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      AppMethodBeat.o(121249);
      return localBitmap;
    }
    paramString1 = c.cO(paramString1, (String)localObject);
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
      localObject = f.decodeStream(paramString1.mInputStream);
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        jLD.put(paramString2, (Bitmap)localObject);
        return localObject;
      }
      if (paramString1 != null) {
        bs.d(paramString1.mInputStream);
      }
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        ac.e("MicroMsg.CanvasImageCache", "try decode icon e = %s", new Object[] { paramString2 });
        if (paramString1 != null) {
          bs.d(paramString1.mInputStream);
        }
      }
    }
    finally
    {
      if (paramString1 == null) {
        break label255;
      }
      bs.d(paramString1.mInputStream);
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