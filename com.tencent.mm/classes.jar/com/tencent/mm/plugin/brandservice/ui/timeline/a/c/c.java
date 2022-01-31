package com.tencent.mm.plugin.brandservice.ui.timeline.a.c;

import com.tencent.mm.sdk.platformtools.h;

public final class c
{
  private static String ayx()
  {
    if (com.tencent.mm.plugin.brandservice.ui.timeline.a.c.ayu()) {}
    for (String str1 = com.tencent.mm.compatible.util.e.bkH;; str1 = com.tencent.mm.kernel.g.DP().cachePath)
    {
      String str2 = str1;
      if (!str1.endsWith("/")) {
        str2 = str1 + "/";
      }
      str1 = str2 + "WebViewTmpl/";
      h.Vu(str1);
      return str1;
    }
  }
  
  static String k(int paramInt1, int paramInt2, String paramString)
  {
    return s(oD(paramInt1), paramInt2, paramString);
  }
  
  static String oD(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    if (com.tencent.mm.plugin.brandservice.ui.timeline.a.c.ayq()) {
      localStringBuilder.append("#TEST_SERVER");
    }
    return localStringBuilder.toString();
  }
  
  static String s(String paramString1, int paramInt, String paramString2)
  {
    com.tencent.luggage.j.c.i("MicroMsg.LocalTmplInfoHelper", "genTmplPath() tmplName:%s, version:%d, fullVersion:%s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    if (com.tencent.mm.plugin.brandservice.ui.timeline.a.c.ayu()) {}
    for (paramString1 = ayx() + String.format("type#%s#%d#%s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 }) + ".html";; paramString1 = ayx() + com.tencent.mm.a.g.o(String.format("type#%s#%d#%s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 }).getBytes()) + ".html")
    {
      com.tencent.luggage.j.c.i("MicroMsg.LocalTmplInfoHelper", "genTmplPath() tmplPath:%s", new Object[] { paramString1 });
      return paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.c.c
 * JD-Core Version:    0.7.0.1
 */