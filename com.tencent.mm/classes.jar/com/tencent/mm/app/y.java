package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class y
{
  private static final Set<String> cMw;
  
  static
  {
    AppMethodBeat.i(160098);
    HashSet localHashSet = new HashSet();
    cMw = localHashSet;
    localHashSet.add(":nospace");
    cMw.add(":cuploader");
    cMw.add(":dexopt");
    cMw.add(":recovery");
    cMw.add(":fallback");
    cMw.add(":isolated_process0");
    cMw.add(":hotpot");
    cMw.add(":extmig");
    AppMethodBeat.o(160098);
  }
  
  public static String eF(String paramString)
  {
    AppMethodBeat.i(160095);
    int i = paramString.indexOf(':');
    if (i != -1)
    {
      paramString = paramString.substring(i);
      AppMethodBeat.o(160095);
      return paramString;
    }
    AppMethodBeat.o(160095);
    return "";
  }
  
  public static boolean eG(String paramString)
  {
    AppMethodBeat.i(160096);
    paramString = eF(paramString);
    boolean bool = cMw.contains(paramString);
    AppMethodBeat.o(160096);
    return bool;
  }
  
  public static boolean eH(String paramString)
  {
    AppMethodBeat.i(160097);
    boolean bool = paramString.endsWith(":nospace");
    AppMethodBeat.o(160097);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.y
 * JD-Core Version:    0.7.0.1
 */