package com.github.henryye.nativeiv.b;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private static final Map<String, com.github.henryye.nativeiv.bitmap.c> auW;
  
  static
  {
    AppMethodBeat.i(115776);
    HashMap localHashMap = new HashMap(6);
    auW = localHashMap;
    localHashMap.put("image/jpeg", com.github.henryye.nativeiv.bitmap.c.auJ);
    auW.put("image/gif", com.github.henryye.nativeiv.bitmap.c.auM);
    auW.put("image/png", com.github.henryye.nativeiv.bitmap.c.auK);
    auW.put("image/x-ms-bmp", com.github.henryye.nativeiv.bitmap.c.auL);
    auW.put("image/bmp", com.github.henryye.nativeiv.bitmap.c.auL);
    auW.put("image/webp", com.github.henryye.nativeiv.bitmap.c.auN);
    AppMethodBeat.o(115776);
  }
  
  public static com.github.henryye.nativeiv.bitmap.d d(InputStream paramInputStream)
  {
    AppMethodBeat.i(115775);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    InputStream localInputStream = d.e(paramInputStream);
    localInputStream.mark(8388608);
    BitmapFactory.decodeStream(localInputStream, null, localOptions);
    Object localObject = (com.github.henryye.nativeiv.bitmap.c)auW.get(localOptions.outMimeType);
    paramInputStream = (InputStream)localObject;
    if (localObject == null) {
      paramInputStream = com.github.henryye.nativeiv.bitmap.c.auO;
    }
    try
    {
      localInputStream.reset();
      localObject = new com.github.henryye.nativeiv.bitmap.d();
      ((com.github.henryye.nativeiv.bitmap.d)localObject).auQ = paramInputStream;
      ((com.github.henryye.nativeiv.bitmap.d)localObject).auS = localOptions.outHeight;
      ((com.github.henryye.nativeiv.bitmap.d)localObject).auR = localOptions.outWidth;
      AppMethodBeat.o(115775);
      return localObject;
    }
    catch (IOException paramInputStream)
    {
      for (;;)
      {
        c.c.printStackTrace("Ni.FormatUtil", paramInputStream, "hy: the given stream is markable, but still reset error. should not forward", new Object[0]);
        paramInputStream = com.github.henryye.nativeiv.bitmap.c.auO;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.github.henryye.nativeiv.b.c
 * JD-Core Version:    0.7.0.1
 */