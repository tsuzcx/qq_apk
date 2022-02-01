package com.tencent.mm.bc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cp;
import com.tencent.mm.g.a.wh;
import com.tencent.mm.sdk.b.c;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class n
{
  Map<Integer, Object<?>> hpB;
  public c hpC;
  public c hpD;
  
  public n()
  {
    AppMethodBeat.i(150833);
    this.hpB = new ConcurrentHashMap();
    this.hpC = new c() {};
    this.hpD = new c() {};
    AppMethodBeat.o(150833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bc.n
 * JD-Core Version:    0.7.0.1
 */