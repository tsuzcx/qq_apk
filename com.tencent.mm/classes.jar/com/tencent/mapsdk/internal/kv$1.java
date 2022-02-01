package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;

final class kv$1
  implements Comparator<Integer>
{
  private static int a(Integer paramInteger1, Integer paramInteger2)
  {
    AppMethodBeat.i(221509);
    int i = paramInteger1.intValue();
    int j = paramInteger2.intValue();
    AppMethodBeat.o(221509);
    return i - j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mapsdk.internal.kv.1
 * JD-Core Version:    0.7.0.1
 */