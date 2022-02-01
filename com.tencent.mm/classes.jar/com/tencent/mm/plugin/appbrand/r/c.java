package com.tencent.mm.plugin.appbrand.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashSet;
import java.util.Set;

public final class c
{
  private static Set<String> kWt;
  
  static
  {
    AppMethodBeat.i(47770);
    HashSet localHashSet = new HashSet();
    kWt = localHashSet;
    localHashSet.add(ai.du("wx9a3998a6d8b89d42"));
    AppMethodBeat.o(47770);
  }
  
  public static boolean Lj(String paramString)
  {
    AppMethodBeat.i(47769);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(47769);
      return true;
    }
    boolean bool = kWt.contains(ai.du(paramString));
    AppMethodBeat.o(47769);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.c
 * JD-Core Version:    0.7.0.1
 */