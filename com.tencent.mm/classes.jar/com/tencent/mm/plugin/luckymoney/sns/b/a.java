package com.tencent.mm.plugin.luckymoney.sns.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class a
{
  public static void Wa(int paramInt)
  {
    AppMethodBeat.i(65409);
    h.aHH();
    h.aHG().aHp().set(ar.a.VkU, Integer.valueOf(paramInt));
    h.aHH();
    h.aHG().aHp().hxT();
    AppMethodBeat.o(65409);
  }
  
  public static int ePa()
  {
    AppMethodBeat.i(65408);
    h.aHH();
    int i = ((Integer)h.aHG().aHp().get(ar.a.VkU, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(65408);
    return i;
  }
  
  public static String ePb()
  {
    AppMethodBeat.i(65410);
    h.aHH();
    String str = (String)h.aHG().aHp().get(ar.a.VkZ, "");
    AppMethodBeat.o(65410);
    return str;
  }
  
  public static String ePc()
  {
    AppMethodBeat.i(65411);
    h.aHH();
    String str = (String)h.aHG().aHp().get(ar.a.Vla, "");
    AppMethodBeat.o(65411);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.b.a
 * JD-Core Version:    0.7.0.1
 */