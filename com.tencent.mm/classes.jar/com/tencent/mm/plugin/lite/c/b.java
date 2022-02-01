package com.tencent.mm.plugin.lite.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.URLDecoder;

public final class b
{
  public static String[] bS(String paramString, boolean paramBoolean)
  {
    String[] arrayOfString1 = null;
    AppMethodBeat.i(233913);
    String[] arrayOfString2 = new String[2];
    Object localObject = paramString;
    if (paramBoolean) {}
    for (;;)
    {
      int i;
      try
      {
        localObject = URLDecoder.decode(paramString, "UTF-8");
        paramString = ((String)localObject).split("\\?");
        if (paramString.length > 1)
        {
          arrayOfString2[0] = paramString[0];
          paramString = paramString[1];
          localObject = new i();
          if (paramString != null)
          {
            paramString = paramString.split("&");
            int j = paramString.length;
            i = 0;
            if (i < j)
            {
              arrayOfString1 = paramString[i].split("=");
              if ((arrayOfString1 == null) || (arrayOfString1.length < 2)) {
                break label197;
              }
              ((i)localObject).g(arrayOfString1[0].trim(), arrayOfString1[1].trim());
              break label197;
            }
          }
        }
        else
        {
          if (((String)localObject).contains("="))
          {
            arrayOfString2[0] = null;
            paramString = paramString[0];
            continue;
          }
          arrayOfString2[0] = paramString[0];
          paramString = arrayOfString1;
          continue;
        }
        arrayOfString2[1] = ((i)localObject).toString();
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("LiteAppUtils", paramString, "", new Object[0]);
        AppMethodBeat.o(233913);
        return arrayOfString2;
      }
      continue;
      label197:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.c.b
 * JD-Core Version:    0.7.0.1
 */