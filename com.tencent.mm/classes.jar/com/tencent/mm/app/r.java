package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class r
{
  private static final Set<String> bYT;
  
  static
  {
    AppMethodBeat.i(137979);
    HashSet localHashSet = new HashSet();
    bYT = localHashSet;
    localHashSet.add(":nospace");
    bYT.add(":cuploader");
    bYT.add(":dexopt");
    bYT.add(":recovery");
    bYT.add(":fallback");
    bYT.add(":isolated_process0");
    AppMethodBeat.o(137979);
  }
  
  public static boolean Bx()
  {
    return false;
  }
  
  public static boolean dB(String paramString)
  {
    AppMethodBeat.i(137978);
    int i = paramString.indexOf(':');
    if (i != -1) {}
    for (paramString = paramString.substring(i);; paramString = "")
    {
      boolean bool = bYT.contains(paramString);
      AppMethodBeat.o(137978);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.r
 * JD-Core Version:    0.7.0.1
 */