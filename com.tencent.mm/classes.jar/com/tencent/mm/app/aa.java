package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class aa
{
  private static final Set<String> fdU;
  
  static
  {
    AppMethodBeat.i(160098);
    HashSet localHashSet = new HashSet();
    fdU = localHashSet;
    localHashSet.add(":nospace");
    fdU.add(":cuploader");
    fdU.add(":dexopt");
    fdU.add(":recovery");
    fdU.add(":fallback");
    fdU.add(":isolated_process0");
    fdU.add(":extmig");
    AppMethodBeat.o(160098);
  }
  
  public static String gT(String paramString)
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
  
  public static boolean gU(String paramString)
  {
    AppMethodBeat.i(160096);
    paramString = gT(paramString);
    boolean bool = fdU.contains(paramString);
    AppMethodBeat.o(160096);
    return bool;
  }
  
  public static boolean gV(String paramString)
  {
    AppMethodBeat.i(160097);
    boolean bool = paramString.endsWith(":nospace");
    AppMethodBeat.o(160097);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.aa
 * JD-Core Version:    0.7.0.1
 */