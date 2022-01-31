package com.tencent.mm.plugin.appbrand.game.b;

import com.tencent.magicbrush.handler.image.a.a;
import com.tencent.mm.sdk.platformtools.y;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;

public final class b$c
  extends a.a
{
  public final boolean bs(String paramString)
  {
    return (paramString != null) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://")));
  }
  
  public final InputStream bt(String paramString)
  {
    try
    {
      BufferedInputStream localBufferedInputStream = new BufferedInputStream(new URL(paramString).openStream());
      return localBufferedInputStream;
    }
    catch (Exception localException)
    {
      y.e("HttpDecoder", "fetch error failed. path = [%s], error = [%s]", new Object[] { paramString, localException.toString() });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.b.b.c
 * JD-Core Version:    0.7.0.1
 */