package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ik
  implements is<Integer>
{
  private static Integer a(float paramFloat, Integer paramInteger1, Integer paramInteger2)
  {
    AppMethodBeat.i(223312);
    int i = paramInteger1.intValue();
    float f = i;
    i = (int)((paramInteger2.intValue() - i) * paramFloat + f);
    AppMethodBeat.o(223312);
    return Integer.valueOf(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ik
 * JD-Core Version:    0.7.0.1
 */