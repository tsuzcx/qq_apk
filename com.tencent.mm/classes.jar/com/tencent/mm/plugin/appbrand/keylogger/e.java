package com.tencent.mm.plugin.appbrand.keylogger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.base.c;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class e
  implements c
{
  private static final Pattern pQc;
  c pQd = null;
  
  static
  {
    AppMethodBeat.i(207620);
    pQc = Pattern.compile(String.format("%s(.*)%s", new Object[] { "<kLog>", "</kLog>" }));
    AppMethodBeat.o(207620);
  }
  
  public static String ajN(String paramString)
  {
    AppMethodBeat.i(207618);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(207618);
      return paramString;
    }
    paramString = pQc.matcher(paramString);
    if (paramString.find())
    {
      paramString = paramString.group(1);
      AppMethodBeat.o(207618);
      return paramString;
    }
    AppMethodBeat.o(207618);
    return null;
  }
  
  public final List<String> V(String paramString, long paramLong)
  {
    AppMethodBeat.i(207616);
    if (this.pQd == null)
    {
      paramString = new ArrayList();
      AppMethodBeat.o(207616);
      return paramString;
    }
    paramString = this.pQd.V(paramString, paramLong);
    AppMethodBeat.o(207616);
    return paramString;
  }
  
  public final void h(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(207614);
    if (this.pQd == null)
    {
      AppMethodBeat.o(207614);
      return;
    }
    this.pQd.h(paramString1, String.format("%s%s%s", new Object[] { "<kLog>", paramString2, "</kLog>" }), paramVarArgs);
    AppMethodBeat.o(207614);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.e
 * JD-Core Version:    0.7.0.1
 */