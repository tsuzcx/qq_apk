package com.tencent.mm.plugin.luckymoney.sns.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

public final class a
{
  public static void HR(int paramInt)
  {
    AppMethodBeat.i(65409);
    g.agS();
    g.agR().agA().set(ah.a.GId, Integer.valueOf(paramInt));
    g.agS();
    g.agR().agA().faa();
    AppMethodBeat.o(65409);
  }
  
  public static int cZw()
  {
    AppMethodBeat.i(65408);
    g.agS();
    int i = ((Integer)g.agR().agA().get(ah.a.GId, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(65408);
    return i;
  }
  
  public static String cZx()
  {
    AppMethodBeat.i(65410);
    g.agS();
    String str = (String)g.agR().agA().get(ah.a.GIi, "");
    AppMethodBeat.o(65410);
    return str;
  }
  
  public static String cZy()
  {
    AppMethodBeat.i(65411);
    g.agS();
    String str = (String)g.agR().agA().get(ah.a.GIj, "");
    AppMethodBeat.o(65411);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.b.a
 * JD-Core Version:    0.7.0.1
 */