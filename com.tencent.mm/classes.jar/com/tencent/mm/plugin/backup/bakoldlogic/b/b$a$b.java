package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.mm.sdk.platformtools.bk;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class b$a$b
{
  StringBuffer hJQ = new StringBuffer();
  
  public final void bg(String paramString, int paramInt)
  {
    xw(paramString);
    this.hJQ.append(paramInt);
    xx(paramString);
  }
  
  public final void cj(String paramString1, String paramString2)
  {
    xw(paramString1);
    if (!bk.bl(paramString2))
    {
      if (!paramString2.contains(b.a.hJN)) {
        break label60;
      }
      this.hJQ.append("<![CDATA[" + bk.ZP(paramString2) + "]]>");
    }
    for (;;)
    {
      xx(paramString1);
      return;
      label60:
      this.hJQ.append("<![CDATA[" + paramString2 + "]]>");
    }
  }
  
  public final void k(String paramString, Map<String, String> paramMap)
  {
    this.hJQ.append("<" + paramString);
    paramString = paramMap.keySet().iterator();
    while (paramString.hasNext())
    {
      String str1 = (String)paramString.next();
      String str2 = (String)paramMap.get(str1);
      this.hJQ.append(" " + str1 + " =  \"" + str2 + "\" ");
    }
    this.hJQ.append(">");
    paramMap.clear();
  }
  
  public final void xw(String paramString)
  {
    this.hJQ.append("<" + paramString + ">");
  }
  
  public final void xx(String paramString)
  {
    this.hJQ.append("</" + paramString + ">");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.b.a.b
 * JD-Core Version:    0.7.0.1
 */