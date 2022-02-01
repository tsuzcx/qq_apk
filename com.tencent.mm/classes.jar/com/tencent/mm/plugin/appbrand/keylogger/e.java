package com.tencent.mm.plugin.appbrand.keylogger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.base.c;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class e
  implements c
{
  private static final Pattern lfX;
  c lfY = null;
  
  static
  {
    AppMethodBeat.i(201028);
    lfX = Pattern.compile(String.format("%s(.*)%s", new Object[] { "<kLog>", "</kLog>" }));
    AppMethodBeat.o(201028);
  }
  
  public static String Of(String paramString)
  {
    AppMethodBeat.i(201027);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(201027);
      return paramString;
    }
    paramString = lfX.matcher(paramString);
    if (paramString.find())
    {
      paramString = paramString.group(1);
      AppMethodBeat.o(201027);
      return paramString;
    }
    AppMethodBeat.o(201027);
    return null;
  }
  
  public final List<String> O(String paramString, long paramLong)
  {
    AppMethodBeat.i(201026);
    if (this.lfY == null)
    {
      paramString = new ArrayList();
      AppMethodBeat.o(201026);
      return paramString;
    }
    paramString = this.lfY.O(paramString, paramLong);
    AppMethodBeat.o(201026);
    return paramString;
  }
  
  public final void c(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(201025);
    if (this.lfY == null)
    {
      AppMethodBeat.o(201025);
      return;
    }
    this.lfY.c(paramString1, String.format("%s%s%s", new Object[] { "<kLog>", paramString2, "</kLog>" }), paramVarArgs);
    AppMethodBeat.o(201025);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.e
 * JD-Core Version:    0.7.0.1
 */