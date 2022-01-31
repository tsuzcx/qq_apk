package com.github.henryye.nativeiv.b;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.github.henryye.nativeiv.bitmap.b;
import com.tencent.magicbrush.a.d.f;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private static final Map<String, b> asF;
  
  static
  {
    HashMap localHashMap = new HashMap(6);
    asF = localHashMap;
    localHashMap.put("image/jpeg", b.ast);
    asF.put("image/gif", b.asw);
    asF.put("image/png", b.asu);
    asF.put("image/x-ms-bmp", b.asv);
    asF.put("image/bmp", b.asv);
    asF.put("image/webp", b.asx);
  }
  
  public static com.github.henryye.nativeiv.bitmap.c d(InputStream paramInputStream)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    InputStream localInputStream = d.e(paramInputStream);
    d.f(localInputStream);
    BitmapFactory.decodeStream(localInputStream, null, localOptions);
    Object localObject = (b)asF.get(localOptions.outMimeType);
    paramInputStream = (InputStream)localObject;
    if (localObject == null) {
      paramInputStream = b.asy;
    }
    try
    {
      localInputStream.reset();
      localObject = new com.github.henryye.nativeiv.bitmap.c();
      ((com.github.henryye.nativeiv.bitmap.c)localObject).asA = paramInputStream;
      ((com.github.henryye.nativeiv.bitmap.c)localObject).asC = localOptions.outHeight;
      ((com.github.henryye.nativeiv.bitmap.c)localObject).asB = localOptions.outWidth;
      return localObject;
    }
    catch (IOException paramInputStream)
    {
      for (;;)
      {
        d.f.a("Ni.FormatUtil", paramInputStream, "hy: the given stream is markable, but still reset error. should not forward", new Object[0]);
        paramInputStream = b.asy;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.github.henryye.nativeiv.b.c
 * JD-Core Version:    0.7.0.1
 */