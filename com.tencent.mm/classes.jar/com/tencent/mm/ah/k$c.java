package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public final class k$c
{
  private static final List<c<? extends f>> hkF;
  private static final HashMap<Integer, c<? extends f>> hkG;
  
  static
  {
    AppMethodBeat.i(150128);
    hkF = Collections.synchronizedList(new ArrayList());
    hkG = new HashMap();
    AppMethodBeat.o(150128);
  }
  
  public static void a(c<? extends f> paramc)
  {
    AppMethodBeat.i(150126);
    hkF.add(paramc);
    AppMethodBeat.o(150126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ah.k.c
 * JD-Core Version:    0.7.0.1
 */