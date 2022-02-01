package com.tencent.mm.plugin.luckymoney.sns.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

public final class a
{
  public static void FW(int paramInt)
  {
    AppMethodBeat.i(65409);
    g.afC();
    g.afB().afk().set(ae.a.Fko, Integer.valueOf(paramInt));
    g.afC();
    g.afB().afk().eKy();
    AppMethodBeat.o(65409);
  }
  
  public static int cLQ()
  {
    AppMethodBeat.i(65408);
    g.afC();
    int i = ((Integer)g.afB().afk().get(ae.a.Fko, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(65408);
    return i;
  }
  
  public static String cLR()
  {
    AppMethodBeat.i(65410);
    g.afC();
    String str = (String)g.afB().afk().get(ae.a.Fkt, "");
    AppMethodBeat.o(65410);
    return str;
  }
  
  public static String cLS()
  {
    AppMethodBeat.i(65411);
    g.afC();
    String str = (String)g.afB().afk().get(ae.a.Fku, "");
    AppMethodBeat.o(65411);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.b.a
 * JD-Core Version:    0.7.0.1
 */