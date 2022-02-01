package com.tencent.mm.plugin.luckymoney.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Random;

public final class a
{
  public static boolean bfV()
  {
    AppMethodBeat.i(213538);
    int i = ((Integer)g.aAh().azQ().get(ar.a.OfN, Integer.valueOf(0))).intValue();
    if (i <= 0)
    {
      AppMethodBeat.o(213538);
      return false;
    }
    if (i >= 100)
    {
      AppMethodBeat.o(213538);
      return true;
    }
    int j = new Random().nextInt(101);
    Log.i("MicroMsg.GetTimeLimitPromotBlindBox", "random: %s, %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
    if (j <= i)
    {
      AppMethodBeat.o(213538);
      return true;
    }
    AppMethodBeat.o(213538);
    return false;
  }
  
  public static void gW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(213537);
    int i = ((Integer)g.aAh().azQ().get(ar.a.OfM, Integer.valueOf(-1))).intValue();
    Log.i("MicroMsg.GetTimeLimitPromotBlindBox", "new: [%s, %s], old: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(i) });
    if (paramInt2 > i)
    {
      g.aAh().azQ().set(ar.a.OfM, Integer.valueOf(paramInt2));
      g.aAh().azQ().set(ar.a.OfN, Integer.valueOf(paramInt1));
    }
    AppMethodBeat.o(213537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.a.a
 * JD-Core Version:    0.7.0.1
 */