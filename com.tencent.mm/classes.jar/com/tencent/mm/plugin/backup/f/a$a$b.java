package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class a$a$b
{
  StringBuffer sb;
  
  a$a$b()
  {
    AppMethodBeat.i(21497);
    this.sb = new StringBuffer();
    AppMethodBeat.o(21497);
  }
  
  private void setText(int paramInt)
  {
    AppMethodBeat.i(21501);
    this.sb.append(paramInt);
    AppMethodBeat.o(21501);
  }
  
  private void setText(String paramString)
  {
    AppMethodBeat.i(21500);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(21500);
      return;
    }
    if (paramString.contains(a.a.INVALID_TAG))
    {
      this.sb.append("<![CDATA[" + Util.escapeStringForXml(paramString) + "]]>");
      AppMethodBeat.o(21500);
      return;
    }
    this.sb.append("<![CDATA[" + paramString + "]]>");
    AppMethodBeat.o(21500);
  }
  
  public final void addTag(String paramString, int paramInt)
  {
    AppMethodBeat.i(21503);
    startTag(paramString);
    setText(paramInt);
    endTag(paramString);
    AppMethodBeat.o(21503);
  }
  
  public final void addTag(String paramString1, String paramString2)
  {
    AppMethodBeat.i(21502);
    startTag(paramString1);
    setText(paramString2);
    endTag(paramString1);
    AppMethodBeat.o(21502);
  }
  
  public final void endTag(String paramString)
  {
    AppMethodBeat.i(21499);
    this.sb.append("</" + paramString + ">");
    AppMethodBeat.o(21499);
  }
  
  public final void startTag(String paramString)
  {
    AppMethodBeat.i(21498);
    this.sb.append("<" + paramString + ">");
    AppMethodBeat.o(21498);
  }
  
  public final void startTag(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(21504);
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
    AppMethodBeat.o(21504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.a.a.b
 * JD-Core Version:    0.7.0.1
 */