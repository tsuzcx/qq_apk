package com.tencent.mm.plugin.luckymoney.sns.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public final class a
{
  public static void ZW(int paramInt)
  {
    AppMethodBeat.i(65409);
    h.baF();
    h.baE().ban().set(at.a.acMo, Integer.valueOf(paramInt));
    h.baF();
    h.baE().ban().iZy();
    AppMethodBeat.o(65409);
  }
  
  public static int fXE()
  {
    AppMethodBeat.i(65408);
    h.baF();
    int i = ((Integer)h.baE().ban().get(at.a.acMo, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(65408);
    return i;
  }
  
  public static String fXF()
  {
    AppMethodBeat.i(65410);
    h.baF();
    String str = (String)h.baE().ban().get(at.a.acMt, "");
    AppMethodBeat.o(65410);
    return str;
  }
  
  public static String fXG()
  {
    AppMethodBeat.i(65411);
    h.baF();
    String str = (String)h.baE().ban().get(at.a.acMu, "");
    AppMethodBeat.o(65411);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.b.a
 * JD-Core Version:    0.7.0.1
 */