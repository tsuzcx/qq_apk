package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cj;
import com.tencent.mm.sdk.b.c;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class l
{
  Map<Integer, Object<?>> fMF;
  public c fMG;
  public c fMH;
  
  public l()
  {
    AppMethodBeat.i(78479);
    this.fMF = new ConcurrentHashMap();
    this.fMG = new l.1(this);
    this.fMH = new c() {};
    AppMethodBeat.o(78479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ba.l
 * JD-Core Version:    0.7.0.1
 */