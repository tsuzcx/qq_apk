package com.bumptech.glide.c.b;

import com.bumptech.glide.c.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

final class r
{
  private final Map<h, k<?>> aHZ;
  private final Map<h, k<?>> aIa;
  
  r()
  {
    AppMethodBeat.i(77031);
    this.aHZ = new HashMap();
    this.aIa = new HashMap();
    AppMethodBeat.o(77031);
  }
  
  final void a(h paramh, k<?> paramk)
  {
    AppMethodBeat.i(77032);
    Map localMap = aH(paramk.aGz);
    if (paramk.equals(localMap.get(paramh))) {
      localMap.remove(paramh);
    }
    AppMethodBeat.o(77032);
  }
  
  final Map<h, k<?>> aH(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.aIa;
    }
    return this.aHZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.r
 * JD-Core Version:    0.7.0.1
 */