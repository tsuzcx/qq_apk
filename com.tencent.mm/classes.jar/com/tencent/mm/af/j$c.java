package com.tencent.mm.af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public final class j$c
{
  private static final List<c<? extends f>> fjw;
  private static final HashMap<Integer, c<? extends f>> fjx;
  
  static
  {
    AppMethodBeat.i(77790);
    fjw = Collections.synchronizedList(new ArrayList());
    fjx = new HashMap();
    AppMethodBeat.o(77790);
  }
  
  public static void a(c<? extends f> paramc)
  {
    AppMethodBeat.i(77788);
    fjw.add(paramc);
    AppMethodBeat.o(77788);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.af.j.c
 * JD-Core Version:    0.7.0.1
 */