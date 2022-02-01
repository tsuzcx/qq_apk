package com.tencent.mm.plugin.appbrand.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashSet;
import java.util.Set;

public final class c
{
  private static Set<String> lXB;
  
  static
  {
    AppMethodBeat.i(47770);
    HashSet localHashSet = new HashSet();
    lXB = localHashSet;
    localHashSet.add(ai.ee("wx9a3998a6d8b89d42"));
    AppMethodBeat.o(47770);
  }
  
  public static boolean SU(String paramString)
  {
    AppMethodBeat.i(47769);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(47769);
      return true;
    }
    boolean bool = lXB.contains(ai.ee(paramString));
    AppMethodBeat.o(47769);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.c
 * JD-Core Version:    0.7.0.1
 */