package com.tencent.magicbrush.b;

import android.util.Base64;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.b.b;
import com.github.henryye.nativeiv.b.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;

public final class a
  implements b
{
  private static int cO(String paramString)
  {
    int j = 14;
    AppMethodBeat.i(140064);
    if (paramString == null)
    {
      AppMethodBeat.o(140064);
      return 0;
    }
    if (!paramString.startsWith("data:image/"))
    {
      AppMethodBeat.o(140064);
      return 0;
    }
    int i;
    if (paramString.startsWith("jpeg", 11)) {
      i = 15;
    }
    while (!paramString.startsWith(";base64,", i))
    {
      AppMethodBeat.o(140064);
      return 0;
      i = j;
      if (!paramString.startsWith("png", 11))
      {
        i = j;
        if (!paramString.startsWith("gif", 11))
        {
          AppMethodBeat.o(140064);
          return 0;
        }
      }
    }
    AppMethodBeat.o(140064);
    return i + 8;
  }
  
  public final b.a a(Object paramObject, ImageDecodeConfig paramImageDecodeConfig)
  {
    AppMethodBeat.i(193562);
    paramObject = (String)paramObject;
    paramObject = new b.a(new ByteArrayInputStream(Base64.decode(paramObject.substring(cO(paramObject)), 2)));
    AppMethodBeat.o(193562);
    return paramObject;
  }
  
  public final boolean accept(Object paramObject)
  {
    AppMethodBeat.i(140065);
    if (!(paramObject instanceof String))
    {
      AppMethodBeat.o(140065);
      return false;
    }
    if (cO((String)paramObject) > 0)
    {
      AppMethodBeat.o(140065);
      return true;
    }
    AppMethodBeat.o(140065);
    return false;
  }
  
  public final String rg()
  {
    return "base64";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.magicbrush.b.a
 * JD-Core Version:    0.7.0.1
 */