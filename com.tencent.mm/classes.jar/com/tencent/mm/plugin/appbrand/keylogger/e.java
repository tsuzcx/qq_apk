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
  private static final Pattern mPj;
  c mPk = null;
  
  static
  {
    AppMethodBeat.i(221311);
    mPj = Pattern.compile(String.format("%s(.*)%s", new Object[] { "<kLog>", "</kLog>" }));
    AppMethodBeat.o(221311);
  }
  
  public static String abS(String paramString)
  {
    AppMethodBeat.i(221310);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(221310);
      return paramString;
    }
    paramString = mPj.matcher(paramString);
    if (paramString.find())
    {
      paramString = paramString.group(1);
      AppMethodBeat.o(221310);
      return paramString;
    }
    AppMethodBeat.o(221310);
    return null;
  }
  
  public final List<String> V(String paramString, long paramLong)
  {
    AppMethodBeat.i(221309);
    if (this.mPk == null)
    {
      paramString = new ArrayList();
      AppMethodBeat.o(221309);
      return paramString;
    }
    paramString = this.mPk.V(paramString, paramLong);
    AppMethodBeat.o(221309);
    return paramString;
  }
  
  public final void g(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(221308);
    if (this.mPk == null)
    {
      AppMethodBeat.o(221308);
      return;
    }
    this.mPk.g(paramString1, String.format("%s%s%s", new Object[] { "<kLog>", paramString2, "</kLog>" }), paramVarArgs);
    AppMethodBeat.o(221308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.e
 * JD-Core Version:    0.7.0.1
 */