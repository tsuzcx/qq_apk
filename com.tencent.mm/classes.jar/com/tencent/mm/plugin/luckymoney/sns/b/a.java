package com.tencent.mm.plugin.luckymoney.sns.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class a
{
  public static void PO(int paramInt)
  {
    AppMethodBeat.i(65409);
    g.aAi();
    g.aAh().azQ().set(ar.a.NWU, Integer.valueOf(paramInt));
    g.aAi();
    g.aAh().azQ().gBI();
    AppMethodBeat.o(65409);
  }
  
  public static int efC()
  {
    AppMethodBeat.i(65408);
    g.aAi();
    int i = ((Integer)g.aAh().azQ().get(ar.a.NWU, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(65408);
    return i;
  }
  
  public static String efD()
  {
    AppMethodBeat.i(65410);
    g.aAi();
    String str = (String)g.aAh().azQ().get(ar.a.NWZ, "");
    AppMethodBeat.o(65410);
    return str;
  }
  
  public static String efE()
  {
    AppMethodBeat.i(65411);
    g.aAi();
    String str = (String)g.aAh().azQ().get(ar.a.NXa, "");
    AppMethodBeat.o(65411);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.b.a
 * JD-Core Version:    0.7.0.1
 */