package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class b$a$b
{
  StringBuffer muN;
  
  b$a$b()
  {
    AppMethodBeat.i(21826);
    this.muN = new StringBuffer();
    AppMethodBeat.o(21826);
  }
  
  private void setText(int paramInt)
  {
    AppMethodBeat.i(21830);
    this.muN.append(paramInt);
    AppMethodBeat.o(21830);
  }
  
  private void setText(String paramString)
  {
    AppMethodBeat.i(21829);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(21829);
      return;
    }
    if (paramString.contains(b.a.muL))
    {
      this.muN.append("<![CDATA[" + bt.aGf(paramString) + "]]>");
      AppMethodBeat.o(21829);
      return;
    }
    this.muN.append("<![CDATA[" + paramString + "]]>");
    AppMethodBeat.o(21829);
  }
  
  public final void Oq(String paramString)
  {
    AppMethodBeat.i(21827);
    this.muN.append("<" + paramString + ">");
    AppMethodBeat.o(21827);
  }
  
  public final void Or(String paramString)
  {
    AppMethodBeat.i(21828);
    this.muN.append("</" + paramString + ">");
    AppMethodBeat.o(21828);
  }
  
  public final void cd(String paramString, int paramInt)
  {
    AppMethodBeat.i(21832);
    Oq(paramString);
    setText(paramInt);
    Or(paramString);
    AppMethodBeat.o(21832);
  }
  
  public final void eb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(21831);
    Oq(paramString1);
    setText(paramString2);
    Or(paramString1);
    AppMethodBeat.o(21831);
  }
  
  public final void p(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(21833);
    this.muN.append("<".concat(String.valueOf(paramString)));
    paramString = paramMap.keySet().iterator();
    while (paramString.hasNext())
    {
      String str1 = (String)paramString.next();
      String str2 = (String)paramMap.get(str1);
      this.muN.append(" " + str1 + " =  \"" + str2 + "\" ");
    }
    this.muN.append(">");
    paramMap.clear();
    AppMethodBeat.o(21833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.b.a.b
 * JD-Core Version:    0.7.0.1
 */