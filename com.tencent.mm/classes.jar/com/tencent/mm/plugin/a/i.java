package com.tencent.mm.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
{
  public static a d(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(133870);
    Object localObject;
    if (paramInt2 == a.baW) {
      localObject = new p(paramInt1, paramLong, paramInt2);
    }
    for (;;)
    {
      AppMethodBeat.o(133870);
      return localObject;
      if (paramInt2 == a.baX) {
        localObject = new g(paramInt1, paramLong, paramInt2);
      } else if (paramInt2 == a.baZ) {
        localObject = new o(paramInt1, paramLong, paramInt2);
      } else if (paramInt2 == a.bbi) {
        localObject = new d(paramInt1, paramLong, paramInt2);
      } else {
        localObject = new a(paramInt1, paramLong, paramInt2, 0L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.a.i
 * JD-Core Version:    0.7.0.1
 */