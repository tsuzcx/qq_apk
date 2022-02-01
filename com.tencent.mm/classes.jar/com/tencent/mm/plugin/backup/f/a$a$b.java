package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class a$a$b
{
  StringBuffer muN;
  
  a$a$b()
  {
    AppMethodBeat.i(21497);
    this.muN = new StringBuffer();
    AppMethodBeat.o(21497);
  }
  
  private void setText(int paramInt)
  {
    AppMethodBeat.i(21501);
    this.muN.append(paramInt);
    AppMethodBeat.o(21501);
  }
  
  private void setText(String paramString)
  {
    AppMethodBeat.i(21500);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(21500);
      return;
    }
    if (paramString.contains(a.a.muL))
    {
      this.muN.append("<![CDATA[" + bt.aGf(paramString) + "]]>");
      AppMethodBeat.o(21500);
      return;
    }
    this.muN.append("<![CDATA[" + paramString + "]]>");
    AppMethodBeat.o(21500);
  }
  
  public final void Oq(String paramString)
  {
    AppMethodBeat.i(21498);
    this.muN.append("<" + paramString + ">");
    AppMethodBeat.o(21498);
  }
  
  public final void Or(String paramString)
  {
    AppMethodBeat.i(21499);
    this.muN.append("</" + paramString + ">");
    AppMethodBeat.o(21499);
  }
  
  public final void cd(String paramString, int paramInt)
  {
    AppMethodBeat.i(21503);
    Oq(paramString);
    setText(paramInt);
    Or(paramString);
    AppMethodBeat.o(21503);
  }
  
  public final void eb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(21502);
    Oq(paramString1);
    setText(paramString2);
    Or(paramString1);
    AppMethodBeat.o(21502);
  }
  
  public final void p(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(21504);
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
    AppMethodBeat.o(21504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.a.a.b
 * JD-Core Version:    0.7.0.1
 */