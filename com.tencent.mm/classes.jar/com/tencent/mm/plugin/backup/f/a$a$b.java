package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class a$a$b
{
  StringBuffer jDt;
  
  a$a$b()
  {
    AppMethodBeat.i(17437);
    this.jDt = new StringBuffer();
    AppMethodBeat.o(17437);
  }
  
  private void setText(int paramInt)
  {
    AppMethodBeat.i(17441);
    this.jDt.append(paramInt);
    AppMethodBeat.o(17441);
  }
  
  private void setText(String paramString)
  {
    AppMethodBeat.i(17440);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(17440);
      return;
    }
    if (paramString.contains(a.a.jDr))
    {
      this.jDt.append("<![CDATA[" + bo.apT(paramString) + "]]>");
      AppMethodBeat.o(17440);
      return;
    }
    this.jDt.append("<![CDATA[" + paramString + "]]>");
    AppMethodBeat.o(17440);
  }
  
  public final void Gp(String paramString)
  {
    AppMethodBeat.i(17438);
    this.jDt.append("<" + paramString + ">");
    AppMethodBeat.o(17438);
  }
  
  public final void Gq(String paramString)
  {
    AppMethodBeat.i(17439);
    this.jDt.append("</" + paramString + ">");
    AppMethodBeat.o(17439);
  }
  
  public final void bG(String paramString, int paramInt)
  {
    AppMethodBeat.i(17443);
    Gp(paramString);
    setText(paramInt);
    Gq(paramString);
    AppMethodBeat.o(17443);
  }
  
  public final void da(String paramString1, String paramString2)
  {
    AppMethodBeat.i(17442);
    Gp(paramString1);
    setText(paramString2);
    Gq(paramString1);
    AppMethodBeat.o(17442);
  }
  
  public final void n(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(17444);
    this.jDt.append("<".concat(String.valueOf(paramString)));
    paramString = paramMap.keySet().iterator();
    while (paramString.hasNext())
    {
      String str1 = (String)paramString.next();
      String str2 = (String)paramMap.get(str1);
      this.jDt.append(" " + str1 + " =  \"" + str2 + "\" ");
    }
    this.jDt.append(">");
    paramMap.clear();
    AppMethodBeat.o(17444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.a.a.b
 * JD-Core Version:    0.7.0.1
 */