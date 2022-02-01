package com.tencent.mm.plugin.luckymoney.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Random;

public final class a
{
  public static boolean bpl()
  {
    AppMethodBeat.i(267398);
    int i = ((Integer)h.aHG().aHp().get(ar.a.Vub, Integer.valueOf(0))).intValue();
    if (i <= 0)
    {
      AppMethodBeat.o(267398);
      return false;
    }
    if (i >= 100)
    {
      AppMethodBeat.o(267398);
      return true;
    }
    int j = new Random().nextInt(101);
    Log.i("MicroMsg.GetTimeLimitPromotBlindBox", "random: %s, %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
    if (j <= i)
    {
      AppMethodBeat.o(267398);
      return true;
    }
    AppMethodBeat.o(267398);
    return false;
  }
  
  public static void ib(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(267397);
    int i = ((Integer)h.aHG().aHp().get(ar.a.Vua, Integer.valueOf(-1))).intValue();
    Log.i("MicroMsg.GetTimeLimitPromotBlindBox", "new: [%s, %s], old: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(i) });
    if (paramInt2 > i)
    {
      h.aHG().aHp().set(ar.a.Vua, Integer.valueOf(paramInt2));
      h.aHG().aHp().set(ar.a.Vub, Integer.valueOf(paramInt1));
    }
    AppMethodBeat.o(267397);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.a.a
 * JD-Core Version:    0.7.0.1
 */