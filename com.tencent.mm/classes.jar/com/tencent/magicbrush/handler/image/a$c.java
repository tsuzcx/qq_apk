package com.tencent.magicbrush.handler.image;

import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;

final class a$c
  extends a.d
{
  public a$c(IMBImageHandler paramIMBImageHandler)
  {
    super(paramIMBImageHandler);
  }
  
  public final boolean bL(String paramString)
  {
    AppMethodBeat.i(115966);
    if ((paramString != null) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
    {
      AppMethodBeat.o(115966);
      return true;
    }
    AppMethodBeat.o(115966);
    return false;
  }
  
  public final InputStream bM(String paramString)
  {
    AppMethodBeat.i(115967);
    try
    {
      BufferedInputStream localBufferedInputStream = new BufferedInputStream(new URL(paramString).openStream());
      paramString = localBufferedInputStream;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        c.c.e("HttpDecoder", "fetch error failed. path = [%s], error = [%s]", new Object[] { paramString, localException.toString() });
        paramString = null;
      }
    }
    AppMethodBeat.o(115967);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.magicbrush.handler.image.a.c
 * JD-Core Version:    0.7.0.1
 */