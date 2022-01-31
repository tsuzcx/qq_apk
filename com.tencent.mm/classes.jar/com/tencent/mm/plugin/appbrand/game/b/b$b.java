package com.tencent.mm.plugin.appbrand.game.b;

import android.util.Base64;
import com.tencent.magicbrush.handler.image.a.a;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public final class b$b
  extends a.a
{
  private static int tu(String paramString)
  {
    int j = 14;
    if (paramString == null) {
      return 0;
    }
    if (!paramString.startsWith("data:image/")) {
      return 0;
    }
    int i;
    if (paramString.startsWith("jpeg", 11)) {
      i = 15;
    }
    while (!paramString.startsWith(";base64,", i))
    {
      return 0;
      i = j;
      if (!paramString.startsWith("png", 11))
      {
        i = j;
        if (!paramString.startsWith("gif", 11)) {
          return 0;
        }
      }
    }
    return i + 8;
  }
  
  public final boolean bs(String paramString)
  {
    return tu(paramString) > 0;
  }
  
  public final InputStream bt(String paramString)
  {
    return new ByteArrayInputStream(Base64.decode(paramString.substring(tu(paramString)), 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.b.b.b
 * JD-Core Version:    0.7.0.1
 */