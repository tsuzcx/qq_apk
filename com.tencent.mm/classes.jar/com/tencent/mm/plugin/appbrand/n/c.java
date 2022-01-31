package com.tencent.mm.plugin.appbrand.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.Set;

public final class c
{
  private static Set<String> itZ;
  
  static
  {
    AppMethodBeat.i(132327);
    HashSet localHashSet = new HashSet();
    itZ = localHashSet;
    localHashSet.add(ag.cE("wx9a3998a6d8b89d42"));
    AppMethodBeat.o(132327);
  }
  
  public static boolean Ea(String paramString)
  {
    AppMethodBeat.i(132326);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(132326);
      return true;
    }
    boolean bool = itZ.contains(ag.cE(paramString));
    AppMethodBeat.o(132326);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.c
 * JD-Core Version:    0.7.0.1
 */