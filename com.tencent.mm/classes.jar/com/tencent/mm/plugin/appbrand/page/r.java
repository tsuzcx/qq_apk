package com.tencent.mm.plugin.appbrand.page;

public final class r
{
  public static String vN(String paramString)
  {
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
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.r
 * JD-Core Version:    0.7.0.1
 */