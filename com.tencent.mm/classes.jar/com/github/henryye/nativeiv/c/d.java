package com.github.henryye.nativeiv.c;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.github.henryye.nativeiv.a.b;
import com.github.henryye.nativeiv.bitmap.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public final class d
{
  private static final Map<String, c> aKS;
  
  static
  {
    AppMethodBeat.i(127398);
    HashMap localHashMap = new HashMap(6);
    aKS = localHashMap;
    localHashMap.put("image/jpeg", c.aKE);
    aKS.put("image/gif", c.aKH);
    aKS.put("image/png", c.aKF);
    aKS.put("image/x-ms-bmp", c.aKG);
    aKS.put("image/bmp", c.aKG);
    aKS.put("image/webp", c.aKI);
    AppMethodBeat.o(127398);
  }
  
  public static com.github.henryye.nativeiv.bitmap.d i(InputStream paramInputStream)
  {
    AppMethodBeat.i(127397);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    InputStream localInputStream = e.j(paramInputStream);
    localInputStream.mark(8388608);
    BitmapFactory.decodeStream(localInputStream, null, localOptions);
    Object localObject = (c)aKS.get(localOptions.outMimeType);
    paramInputStream = (InputStream)localObject;
    if (localObject == null) {
      paramInputStream = c.aKK;
    }
    try
    {
      localInputStream.reset();
      localObject = new com.github.henryye.nativeiv.bitmap.d();
      ((com.github.henryye.nativeiv.bitmap.d)localObject).aKM = paramInputStream;
      ((com.github.henryye.nativeiv.bitmap.d)localObject).height = localOptions.outHeight;
      ((com.github.henryye.nativeiv.bitmap.d)localObject).width = localOptions.outWidth;
      AppMethodBeat.o(127397);
      return localObject;
    }
    catch (IOException paramInputStream)
    {
      for (;;)
      {
        b.printStackTrace("Ni.FormatUtil", paramInputStream, "hy: the given stream is markable, but still reset error. should not forward", new Object[0]);
        paramInputStream = c.aKK;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.github.henryye.nativeiv.c.d
 * JD-Core Version:    0.7.0.1
 */