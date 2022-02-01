package com.tencent.mm.plugin.appbrand.keylogger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.base.c;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class e
  implements c
{
  private static final Pattern lHu;
  c lHv = null;
  
  static
  {
    AppMethodBeat.i(201267);
    lHu = Pattern.compile(String.format("%s(.*)%s", new Object[] { "<kLog>", "</kLog>" }));
    AppMethodBeat.o(201267);
  }
  
  public static String Sm(String paramString)
  {
    AppMethodBeat.i(201266);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(201266);
      return paramString;
    }
    paramString = lHu.matcher(paramString);
    if (paramString.find())
    {
      paramString = paramString.group(1);
      AppMethodBeat.o(201266);
      return paramString;
    }
    AppMethodBeat.o(201266);
    return null;
  }
  
  public final List<String> V(String paramString, long paramLong)
  {
    AppMethodBeat.i(201265);
    if (this.lHv == null)
    {
      paramString = new ArrayList();
      AppMethodBeat.o(201265);
      return paramString;
    }
    paramString = this.lHv.V(paramString, paramLong);
    AppMethodBeat.o(201265);
    return paramString;
  }
  
  public final void c(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(201264);
    if (this.lHv == null)
    {
      AppMethodBeat.o(201264);
      return;
    }
    this.lHv.c(paramString1, String.format("%s%s%s", new Object[] { "<kLog>", paramString2, "</kLog>" }), paramVarArgs);
    AppMethodBeat.o(201264);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.e
 * JD-Core Version:    0.7.0.1
 */