package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class b$a$b
{
  StringBuffer sb;
  
  b$a$b()
  {
    AppMethodBeat.i(21826);
    this.sb = new StringBuffer();
    AppMethodBeat.o(21826);
  }
  
  private void setText(int paramInt)
  {
    AppMethodBeat.i(21830);
    this.sb.append(paramInt);
    AppMethodBeat.o(21830);
  }
  
  private void setText(String paramString)
  {
    AppMethodBeat.i(21829);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(21829);
      return;
    }
    if (paramString.contains(b.a.INVALID_TAG))
    {
      this.sb.append("<![CDATA[" + Util.escapeStringForXml(paramString) + "]]>");
      AppMethodBeat.o(21829);
      return;
    }
    this.sb.append("<![CDATA[" + paramString + "]]>");
    AppMethodBeat.o(21829);
  }
  
  public final void addTag(String paramString, int paramInt)
  {
    AppMethodBeat.i(21832);
    startTag(paramString);
    setText(paramInt);
    endTag(paramString);
    AppMethodBeat.o(21832);
  }
  
  public final void addTag(String paramString1, String paramString2)
  {
    AppMethodBeat.i(21831);
    startTag(paramString1);
    setText(paramString2);
    endTag(paramString1);
    AppMethodBeat.o(21831);
  }
  
  public final void endTag(String paramString)
  {
    AppMethodBeat.i(21828);
    this.sb.append("</" + paramString + ">");
    AppMethodBeat.o(21828);
  }
  
  public final void startTag(String paramString)
  {
    AppMethodBeat.i(21827);
    this.sb.append("<" + paramString + ">");
    AppMethodBeat.o(21827);
  }
  
  public final void startTag(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(21833);
    this.sb.append("<".concat(String.valueOf(paramString)));
    paramString = paramMap.keySet().iterator();
    while (paramString.hasNext())
    {
      String str1 = (String)paramString.next();
      String str2 = (String)paramMap.get(str1);
      this.sb.append(" " + str1 + " =  \"" + str2 + "\" ");
    }
    this.sb.append(">");
    paramMap.clear();
    AppMethodBeat.o(21833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.b.a.b
 * JD-Core Version:    0.7.0.1
 */