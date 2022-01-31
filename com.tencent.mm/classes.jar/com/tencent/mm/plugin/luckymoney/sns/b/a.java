package com.tencent.mm.plugin.luckymoney.sns.b;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class a
{
  public static int bfW()
  {
    g.DQ();
    return ((Integer)g.DP().Dz().get(ac.a.urS, Integer.valueOf(0))).intValue();
  }
  
  public static String bfX()
  {
    g.DQ();
    return (String)g.DP().Dz().get(ac.a.urX, "");
  }
  
  public static String bfY()
  {
    g.DQ();
    return (String)g.DP().Dz().get(ac.a.urY, "");
  }
  
  public static void tp(int paramInt)
  {
    g.DQ();
    g.DP().Dz().c(ac.a.urS, Integer.valueOf(paramInt));
    g.DQ();
    g.DP().Dz().mC(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.b.a
 * JD-Core Version:    0.7.0.1
 */