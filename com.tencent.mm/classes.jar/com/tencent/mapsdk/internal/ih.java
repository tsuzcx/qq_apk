package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ih
  implements is<Object>
{
  public final Object a(float paramFloat, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(223376);
    int m = ((Integer)paramObject1).intValue();
    int i = m >> 24;
    int j = m >> 16 & 0xFF;
    int k = m >> 8 & 0xFF;
    m &= 0xFF;
    int i3 = ((Integer)paramObject2).intValue();
    int n = (int)(((i3 >> 24) - i) * paramFloat);
    int i1 = (int)(((i3 >> 16 & 0xFF) - j) * paramFloat);
    int i2 = (int)(((i3 >> 8 & 0xFF) - k) * paramFloat);
    i3 = (int)(((i3 & 0xFF) - m) * paramFloat);
    AppMethodBeat.o(223376);
    return Integer.valueOf(m + i3 | i + n << 24 | j + i1 << 16 | i2 + k << 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ih
 * JD-Core Version:    0.7.0.1
 */