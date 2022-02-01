package com.tencent.mm.plugin.appbrand.keylogger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.base.c;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class e
  implements c
{
  private static final Pattern kEE;
  c kEF = null;
  
  static
  {
    AppMethodBeat.i(194873);
    kEE = Pattern.compile(String.format("%s(.*)%s", new Object[] { "<kLog>", "</kLog>" }));
    AppMethodBeat.o(194873);
  }
  
  public static String JY(String paramString)
  {
    AppMethodBeat.i(194872);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(194872);
      return paramString;
    }
    paramString = kEE.matcher(paramString);
    if (paramString.find())
    {
      paramString = paramString.group(1);
      AppMethodBeat.o(194872);
      return paramString;
    }
    AppMethodBeat.o(194872);
    return null;
  }
  
  public final List<String> N(String paramString, long paramLong)
  {
    AppMethodBeat.i(194871);
    if (this.kEF == null)
    {
      paramString = new ArrayList();
      AppMethodBeat.o(194871);
      return paramString;
    }
    paramString = this.kEF.N(paramString, paramLong);
    AppMethodBeat.o(194871);
    return paramString;
  }
  
  public final void c(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(194870);
    if (this.kEF == null)
    {
      AppMethodBeat.o(194870);
      return;
    }
    this.kEF.c(paramString1, String.format("%s%s%s", new Object[] { "<kLog>", paramString2, "</kLog>" }), paramVarArgs);
    AppMethodBeat.o(194870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.e
 * JD-Core Version:    0.7.0.1
 */