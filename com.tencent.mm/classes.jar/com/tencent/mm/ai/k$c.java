package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public final class k$c
{
  private static final List<c<? extends f>> gKf;
  private static final HashMap<Integer, c<? extends f>> gKg;
  
  static
  {
    AppMethodBeat.i(150128);
    gKf = Collections.synchronizedList(new ArrayList());
    gKg = new HashMap();
    AppMethodBeat.o(150128);
  }
  
  public static void a(c<? extends f> paramc)
  {
    AppMethodBeat.i(150126);
    gKf.add(paramc);
    AppMethodBeat.o(150126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ai.k.c
 * JD-Core Version:    0.7.0.1
 */