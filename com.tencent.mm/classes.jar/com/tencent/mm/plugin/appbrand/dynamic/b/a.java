package com.tencent.mm.plugin.appbrand.dynamic.b;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.c;
import com.tencent.mm.modelappbrand.a.b.j;
import com.tencent.mm.plugin.appbrand.dynamic.j.c;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.xweb.s;
import java.io.IOException;
import java.io.InputStream;

public final class a
{
  private static final b.j hoi;
  
  static
  {
    AppMethodBeat.i(10768);
    hoi = new b.c();
    AppMethodBeat.o(10768);
  }
  
  public static Bitmap bP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(10767);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(10767);
      return null;
    }
    Object localObject = LaunchParcel.Dq(paramString2);
    if (bo.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(10767);
      return null;
    }
    paramString2 = paramString1 + '#' + (String)localObject;
    Bitmap localBitmap = hoi.lK(paramString2);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      AppMethodBeat.o(10767);
      return localBitmap;
    }
    paramString1 = c.bV(paramString1, (String)localObject);
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
      localObject = d.decodeStream(paramString1.mInputStream);
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        hoi.c(paramString2, (Bitmap)localObject);
        return localObject;
      }
      if (paramString1 != null) {
        bo.b(paramString1.mInputStream);
      }
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        ab.e("MicroMsg.CanvasImageCache", "try decode icon e = %s", new Object[] { paramString2 });
        if (paramString1 != null) {
          bo.b(paramString1.mInputStream);
        }
      }
    }
    finally
    {
      if (paramString1 == null) {
        break label262;
      }
      bo.b(paramString1.mInputStream);
      AppMethodBeat.o(10767);
    }
    AppMethodBeat.o(10767);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.b.a
 * JD-Core Version:    0.7.0.1
 */