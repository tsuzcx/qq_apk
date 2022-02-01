package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class ad
{
  private static final Set<String> hhK;
  
  static
  {
    AppMethodBeat.i(160098);
    HashSet localHashSet = new HashSet();
    hhK = localHashSet;
    localHashSet.add(":nospace");
    hhK.add(":cuploader");
    hhK.add(":dexopt");
    hhK.add(":recovery");
    hhK.add(":fallback");
    hhK.add(":isolated_process0");
    hhK.add(":extmig");
    AppMethodBeat.o(160098);
  }
  
  public static String iu(String paramString)
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
  
  public static boolean iv(String paramString)
  {
    AppMethodBeat.i(160096);
    paramString = iu(paramString);
    boolean bool = hhK.contains(paramString);
    AppMethodBeat.o(160096);
    return bool;
  }
  
  public static boolean iw(String paramString)
  {
    AppMethodBeat.i(160097);
    boolean bool = paramString.endsWith(":nospace");
    AppMethodBeat.o(160097);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.ad
 * JD-Core Version:    0.7.0.1
 */