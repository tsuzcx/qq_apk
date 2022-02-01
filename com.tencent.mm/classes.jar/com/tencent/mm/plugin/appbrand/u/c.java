package com.tencent.mm.plugin.appbrand.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Set;

public final class c
{
  private static Set<String> njT;
  
  static
  {
    AppMethodBeat.i(47770);
    HashSet localHashSet = new HashSet();
    njT = localHashSet;
    localHashSet.add(MD5Util.getMD5String("wx9a3998a6d8b89d42"));
    AppMethodBeat.o(47770);
  }
  
  public static boolean adj(String paramString)
  {
    AppMethodBeat.i(47769);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(47769);
      return true;
    }
    boolean bool = njT.contains(MD5Util.getMD5String(paramString));
    AppMethodBeat.o(47769);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.c
 * JD-Core Version:    0.7.0.1
 */