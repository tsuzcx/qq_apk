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
  private static final Map<String, c> cEO;
  
  static
  {
    AppMethodBeat.i(127398);
    HashMap localHashMap = new HashMap(6);
    cEO = localHashMap;
    localHashMap.put("image/jpeg", c.cEA);
    cEO.put("image/gif", c.cED);
    cEO.put("image/png", c.cEB);
    cEO.put("image/x-ms-bmp", c.cEC);
    cEO.put("image/bmp", c.cEC);
    cEO.put("image/webp", c.cEE);
    AppMethodBeat.o(127398);
  }
  
  public static com.github.henryye.nativeiv.bitmap.d s(InputStream paramInputStream)
  {
    AppMethodBeat.i(127397);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    InputStream localInputStream = e.t(paramInputStream);
    localInputStream.mark(8388608);
    BitmapFactory.decodeStream(localInputStream, null, localOptions);
    Object localObject = (c)cEO.get(localOptions.outMimeType);
    paramInputStream = (InputStream)localObject;
    if (localObject == null) {
      paramInputStream = c.cEG;
    }
    try
    {
      localInputStream.reset();
      localObject = new com.github.henryye.nativeiv.bitmap.d();
      ((com.github.henryye.nativeiv.bitmap.d)localObject).cEI = paramInputStream;
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
        paramInputStream = c.cEG;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.github.henryye.nativeiv.c.d
 * JD-Core Version:    0.7.0.1
 */