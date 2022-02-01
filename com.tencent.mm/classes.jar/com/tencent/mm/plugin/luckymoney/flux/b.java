package com.tencent.mm.plugin.luckymoney.flux;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
{
  public static b KqI;
  private Map<Integer, BaseStore> KqJ;
  AtomicInteger cqS;
  
  static
  {
    AppMethodBeat.i(283822);
    KqI = new b();
    AppMethodBeat.o(283822);
  }
  
  private b()
  {
    AppMethodBeat.i(283819);
    this.cqS = new AtomicInteger(1);
    this.KqJ = new HashMap();
    AppMethodBeat.o(283819);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.flux.b
 * JD-Core Version:    0.7.0.1
 */