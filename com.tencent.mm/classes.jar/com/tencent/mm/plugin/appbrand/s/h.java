package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class h
{
  private static final Set<Object> hwB;
  
  static
  {
    AppMethodBeat.i(91164);
    hwB = new HashSet();
    AppMethodBeat.o(91164);
  }
  
  public static void ai(Object paramObject)
  {
    AppMethodBeat.i(91163);
    hwB.remove(paramObject);
    AppMethodBeat.o(91163);
  }
  
  public static <T> T bq(T paramT)
  {
    AppMethodBeat.i(91162);
    if (paramT != null) {
      hwB.add(paramT);
    }
    AppMethodBeat.o(91162);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.h
 * JD-Core Version:    0.7.0.1
 */