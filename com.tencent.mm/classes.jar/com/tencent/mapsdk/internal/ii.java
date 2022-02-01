package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ii
  implements is<Number>
{
  private static Number a(float paramFloat, Number paramNumber1, Number paramNumber2)
  {
    AppMethodBeat.i(223346);
    double d1 = paramNumber1.doubleValue();
    double d2 = paramFloat;
    double d3 = paramNumber2.doubleValue();
    AppMethodBeat.o(223346);
    return Double.valueOf(d1 + d2 * (d3 - d1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ii
 * JD-Core Version:    0.7.0.1
 */