package com.tencent.magicbrush.b;

import android.util.Base64;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.b.b.a;
import com.tencent.magicbrush.utils.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;

public final class b
  implements com.github.henryye.nativeiv.b.b
{
  private static String[] cAh = { "jpeg", "png", "gif", "svg+xml" };
  
  private static int dJ(String paramString)
  {
    int j = 11;
    AppMethodBeat.i(140064);
    if (h.isNullOrNil(paramString))
    {
      AppMethodBeat.o(140064);
      return 0;
    }
    if (!paramString.startsWith("data:image/"))
    {
      AppMethodBeat.o(140064);
      return 0;
    }
    String[] arrayOfString = cAh;
    int k = arrayOfString.length;
    int i = 0;
    if (i < k)
    {
      String str = arrayOfString[i];
      if (paramString.startsWith(str, 11)) {
        j = str.length() + 11;
      }
    }
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        AppMethodBeat.o(140064);
        return 0;
        i += 1;
        break;
      }
      if (!paramString.startsWith(";base64,", j))
      {
        AppMethodBeat.o(140064);
        return 0;
      }
      AppMethodBeat.o(140064);
      return j + 8;
    }
  }
  
  public final b.a a(Object paramObject, ImageDecodeConfig paramImageDecodeConfig)
  {
    AppMethodBeat.i(213318);
    paramObject = (String)paramObject;
    paramObject = new b.a(new ByteArrayInputStream(Base64.decode(paramObject.substring(dJ(paramObject)), 2)));
    AppMethodBeat.o(213318);
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
    if (dJ((String)paramObject) > 0)
    {
      AppMethodBeat.o(140065);
      return true;
    }
    AppMethodBeat.o(140065);
    return false;
  }
  
  public final String sP()
  {
    return "base64";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.b.b
 * JD-Core Version:    0.7.0.1
 */