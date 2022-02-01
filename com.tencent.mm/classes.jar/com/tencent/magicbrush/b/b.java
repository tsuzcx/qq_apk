package com.tencent.magicbrush.b;

import android.util.Base64;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.b.b.a;
import com.tencent.magicbrush.utils.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;

public final class b
  implements com.github.henryye.nativeiv.b.b
{
  private static String[] cPc = { "jpeg", "png", "gif", "svg+xml" };
  
  private static int eF(String paramString)
  {
    int j = 11;
    AppMethodBeat.i(140064);
    if (i.isNullOrNil(paramString))
    {
      AppMethodBeat.o(140064);
      return 0;
    }
    if (!paramString.startsWith("data:image/"))
    {
      AppMethodBeat.o(140064);
      return 0;
    }
    String[] arrayOfString = cPc;
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
  
  public final boolean V(Object paramObject)
  {
    AppMethodBeat.i(140065);
    if (!(paramObject instanceof String))
    {
      AppMethodBeat.o(140065);
      return false;
    }
    if (eF((String)paramObject) > 0)
    {
      AppMethodBeat.o(140065);
      return true;
    }
    AppMethodBeat.o(140065);
    return false;
  }
  
  public final b.a a(Object paramObject, ImageDecodeConfig paramImageDecodeConfig)
  {
    AppMethodBeat.i(203886);
    paramObject = (String)paramObject;
    paramObject = new b.a(new ByteArrayInputStream(Base64.decode(paramObject.substring(eF(paramObject)), 2)));
    AppMethodBeat.o(203886);
    return paramObject;
  }
  
  public final String qG()
  {
    return "base64";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.magicbrush.b.b
 * JD-Core Version:    0.7.0.1
 */