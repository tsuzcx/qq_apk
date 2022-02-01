package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;

final class os$2
  implements Comparator<Integer>
{
  os$2(os paramos) {}
  
  private static int a(Integer paramInteger1, Integer paramInteger2)
  {
    AppMethodBeat.i(225262);
    int i = paramInteger1.compareTo(paramInteger2);
    AppMethodBeat.o(225262);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mapsdk.internal.os.2
 * JD-Core Version:    0.7.0.1
 */