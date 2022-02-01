package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ad
{
  public static String adO(String paramString)
  {
    AppMethodBeat.i(135207);
    int i = paramString.indexOf("<page>");
    int j = paramString.indexOf("</page>");
    if ((i == -1) || (j == -i))
    {
      AppMethodBeat.o(135207);
      return "";
    }
    paramString = paramString.substring(i + 6, j);
    AppMethodBeat.o(135207);
    return paramString;
  }
  
  public static String adP(String paramString)
  {
    AppMethodBeat.i(135208);
    int i = paramString.indexOf("<style>");
    int j = paramString.indexOf("</style>");
    if ((i == -1) || (j == -i))
    {
      AppMethodBeat.o(135208);
      return "";
    }
    paramString = paramString.substring(i + 7, j);
    AppMethodBeat.o(135208);
    return paramString;
  }
  
  public static String adQ(String paramString)
  {
    AppMethodBeat.i(135209);
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
    AppMethodBeat.o(135209);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ad
 * JD-Core Version:    0.7.0.1
 */