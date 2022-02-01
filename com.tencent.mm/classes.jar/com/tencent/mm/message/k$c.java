package com.tencent.mm.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cp.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public final class k$c
{
  private static final List<c<? extends f>> nUn;
  private static final HashMap<Integer, c<? extends f>> nUo;
  
  static
  {
    AppMethodBeat.i(150128);
    nUn = Collections.synchronizedList(new ArrayList());
    nUo = new HashMap();
    AppMethodBeat.o(150128);
  }
  
  public static void a(c<? extends f> paramc)
  {
    AppMethodBeat.i(150126);
    nUn.add(paramc);
    AppMethodBeat.o(150126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.message.k.c
 * JD-Core Version:    0.7.0.1
 */