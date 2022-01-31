package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class w
{
  public static String Eo(String paramString)
  {
    AppMethodBeat.i(87276);
    String str = "";
    int i = 0;
    int j = paramString.indexOf("<script>", i);
    int k = paramString.indexOf("</script>", i);
    if ((j != -1) && (k != -1) && (k > j))
    {
      StringBuilder localStringBuilder = new StringBuilder().append(str);
      if (i > 0) {}
      for (str = ";";; str = "")
      {
        str = str + paramString.substring(j + 8, k);
        i = k + 9;
        break;
      }
    }
    AppMethodBeat.o(87276);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.w
 * JD-Core Version:    0.7.0.1
 */