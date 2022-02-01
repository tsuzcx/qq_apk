package com.bumptech.glide.load.b;

import com.bumptech.glide.load.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

final class s
{
  private final Map<g, l<?>> aHT;
  private final Map<g, l<?>> aHU;
  
  s()
  {
    AppMethodBeat.i(77031);
    this.aHT = new HashMap();
    this.aHU = new HashMap();
    AppMethodBeat.o(77031);
  }
  
  final void a(g paramg, l<?> paraml)
  {
    AppMethodBeat.i(77032);
    Map localMap = aG(paraml.aGr);
    if (paraml.equals(localMap.get(paramg))) {
      localMap.remove(paramg);
    }
    AppMethodBeat.o(77032);
  }
  
  final Map<g, l<?>> aG(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.aHU;
    }
    return this.aHT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.b.s
 * JD-Core Version:    0.7.0.1
 */