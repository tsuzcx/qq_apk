package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class b$a$b
{
  StringBuffer jDt;
  
  b$a$b()
  {
    AppMethodBeat.i(17769);
    this.jDt = new StringBuffer();
    AppMethodBeat.o(17769);
  }
  
  private void setText(int paramInt)
  {
    AppMethodBeat.i(17773);
    this.jDt.append(paramInt);
    AppMethodBeat.o(17773);
  }
  
  private void setText(String paramString)
  {
    AppMethodBeat.i(17772);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(17772);
      return;
    }
    if (paramString.contains(b.a.jDr))
    {
      this.jDt.append("<![CDATA[" + bo.apT(paramString) + "]]>");
      AppMethodBeat.o(17772);
      return;
    }
    this.jDt.append("<![CDATA[" + paramString + "]]>");
    AppMethodBeat.o(17772);
  }
  
  public final void Gp(String paramString)
  {
    AppMethodBeat.i(17770);
    this.jDt.append("<" + paramString + ">");
    AppMethodBeat.o(17770);
  }
  
  public final void Gq(String paramString)
  {
    AppMethodBeat.i(17771);
    this.jDt.append("</" + paramString + ">");
    AppMethodBeat.o(17771);
  }
  
  public final void bG(String paramString, int paramInt)
  {
    AppMethodBeat.i(17775);
    Gp(paramString);
    setText(paramInt);
    Gq(paramString);
    AppMethodBeat.o(17775);
  }
  
  public final void da(String paramString1, String paramString2)
  {
    AppMethodBeat.i(17774);
    Gp(paramString1);
    setText(paramString2);
    Gq(paramString1);
    AppMethodBeat.o(17774);
  }
  
  public final void n(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(17776);
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
    AppMethodBeat.o(17776);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.b.a.b
 * JD-Core Version:    0.7.0.1
 */