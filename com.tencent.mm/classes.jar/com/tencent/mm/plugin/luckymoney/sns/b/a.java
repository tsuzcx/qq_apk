package com.tencent.mm.plugin.luckymoney.sns.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class a
{
  public static int bNI()
  {
    AppMethodBeat.i(42551);
    g.RM();
    int i = ((Integer)g.RL().Ru().get(ac.a.yBS, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(42551);
    return i;
  }
  
  public static String bNJ()
  {
    AppMethodBeat.i(42553);
    g.RM();
    String str = (String)g.RL().Ru().get(ac.a.yBX, "");
    AppMethodBeat.o(42553);
    return str;
  }
  
  public static String bNK()
  {
    AppMethodBeat.i(42554);
    g.RM();
    String str = (String)g.RL().Ru().get(ac.a.yBY, "");
    AppMethodBeat.o(42554);
    return str;
  }
  
  public static void yt(int paramInt)
  {
    AppMethodBeat.i(42552);
    g.RM();
    g.RL().Ru().set(ac.a.yBS, Integer.valueOf(paramInt));
    g.RM();
    g.RL().Ru().dww();
    AppMethodBeat.o(42552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.b.a
 * JD-Core Version:    0.7.0.1
 */