package com.tencent.mm.plugin.luckymoney.sns.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

public final class a
{
  public static void JM(int paramInt)
  {
    AppMethodBeat.i(65409);
    g.ajS();
    g.ajR().ajA().set(am.a.IOT, Integer.valueOf(paramInt));
    g.ajS();
    g.ajR().ajA().fuc();
    AppMethodBeat.o(65409);
  }
  
  public static int dlH()
  {
    AppMethodBeat.i(65408);
    g.ajS();
    int i = ((Integer)g.ajR().ajA().get(am.a.IOT, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(65408);
    return i;
  }
  
  public static String dlI()
  {
    AppMethodBeat.i(65410);
    g.ajS();
    String str = (String)g.ajR().ajA().get(am.a.IOY, "");
    AppMethodBeat.o(65410);
    return str;
  }
  
  public static String dlJ()
  {
    AppMethodBeat.i(65411);
    g.ajS();
    String str = (String)g.ajR().ajA().get(am.a.IOZ, "");
    AppMethodBeat.o(65411);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.b.a
 * JD-Core Version:    0.7.0.1
 */