package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class z
{
  private static final Set<String> cVR;
  
  static
  {
    AppMethodBeat.i(160098);
    HashSet localHashSet = new HashSet();
    cVR = localHashSet;
    localHashSet.add(":nospace");
    cVR.add(":cuploader");
    cVR.add(":dexopt");
    cVR.add(":recovery");
    cVR.add(":fallback");
    cVR.add(":isolated_process0");
    cVR.add(":extmig");
    AppMethodBeat.o(160098);
  }
  
  public static String fw(String paramString)
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
  
  public static boolean fx(String paramString)
  {
    AppMethodBeat.i(160096);
    paramString = fw(paramString);
    boolean bool = cVR.contains(paramString);
    AppMethodBeat.o(160096);
    return bool;
  }
  
  public static boolean fy(String paramString)
  {
    AppMethodBeat.i(160097);
    boolean bool = paramString.endsWith(":nospace");
    AppMethodBeat.o(160097);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.z
 * JD-Core Version:    0.7.0.1
 */