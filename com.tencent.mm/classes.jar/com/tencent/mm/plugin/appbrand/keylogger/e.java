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
  private static final Pattern sUC;
  c sUD = null;
  
  static
  {
    AppMethodBeat.i(319485);
    sUC = Pattern.compile(String.format("%s(.*)%s", new Object[] { "<kLog>", "</kLog>" }));
    AppMethodBeat.o(319485);
  }
  
  public static String acN(String paramString)
  {
    AppMethodBeat.i(319480);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(319480);
      return paramString;
    }
    paramString = sUC.matcher(paramString);
    if (paramString.find())
    {
      paramString = paramString.group(1);
      AppMethodBeat.o(319480);
      return paramString;
    }
    AppMethodBeat.o(319480);
    return null;
  }
  
  public final List<String> aa(String paramString, long paramLong)
  {
    AppMethodBeat.i(319499);
    if (this.sUD == null)
    {
      paramString = new ArrayList();
      AppMethodBeat.o(319499);
      return paramString;
    }
    paramString = this.sUD.aa(paramString, paramLong);
    AppMethodBeat.o(319499);
    return paramString;
  }
  
  public final void j(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(319493);
    if (this.sUD == null)
    {
      AppMethodBeat.o(319493);
      return;
    }
    this.sUD.j(paramString1, String.format("%s%s%s", new Object[] { "<kLog>", paramString2, "</kLog>" }), paramVarArgs);
    AppMethodBeat.o(319493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.e
 * JD-Core Version:    0.7.0.1
 */