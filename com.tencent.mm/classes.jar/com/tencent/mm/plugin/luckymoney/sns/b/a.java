package com.tencent.mm.plugin.luckymoney.sns.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public final class a
{
  public static void Jn(int paramInt)
  {
    AppMethodBeat.i(65409);
    g.ajD();
    g.ajC().ajl().set(al.a.Iuv, Integer.valueOf(paramInt));
    g.ajD();
    g.ajC().ajl().fqc();
    AppMethodBeat.o(65409);
  }
  
  public static int diI()
  {
    AppMethodBeat.i(65408);
    g.ajD();
    int i = ((Integer)g.ajC().ajl().get(al.a.Iuv, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(65408);
    return i;
  }
  
  public static String diJ()
  {
    AppMethodBeat.i(65410);
    g.ajD();
    String str = (String)g.ajC().ajl().get(al.a.IuA, "");
    AppMethodBeat.o(65410);
    return str;
  }
  
  public static String diK()
  {
    AppMethodBeat.i(65411);
    g.ajD();
    String str = (String)g.ajC().ajl().get(al.a.IuB, "");
    AppMethodBeat.o(65411);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.b.a
 * JD-Core Version:    0.7.0.1
 */