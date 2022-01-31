package com.tencent.magicbrush.handler.image;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

final class a$b
  extends a.d
{
  public a$b(IMBImageHandler paramIMBImageHandler)
  {
    super(paramIMBImageHandler);
  }
  
  private static int cu(String paramString)
  {
    int j = 14;
    AppMethodBeat.i(115963);
    if (paramString == null)
    {
      AppMethodBeat.o(115963);
      return 0;
    }
    if (!paramString.startsWith("data:image/"))
    {
      AppMethodBeat.o(115963);
      return 0;
    }
    int i;
    if (paramString.startsWith("jpeg", 11)) {
      i = 15;
    }
    while (!paramString.startsWith(";base64,", i))
    {
      AppMethodBeat.o(115963);
      return 0;
      i = j;
      if (!paramString.startsWith("png", 11))
      {
        i = j;
        if (!paramString.startsWith("gif", 11))
        {
          AppMethodBeat.o(115963);
          return 0;
        }
      }
    }
    AppMethodBeat.o(115963);
    return i + 8;
  }
  
  public final boolean bL(String paramString)
  {
    AppMethodBeat.i(115964);
    if (cu(paramString) > 0)
    {
      AppMethodBeat.o(115964);
      return true;
    }
    AppMethodBeat.o(115964);
    return false;
  }
  
  public final InputStream bM(String paramString)
  {
    AppMethodBeat.i(115965);
    paramString = new ByteArrayInputStream(Base64.decode(paramString.substring(cu(paramString)), 2));
    AppMethodBeat.o(115965);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.magicbrush.handler.image.a.b
 * JD-Core Version:    0.7.0.1
 */