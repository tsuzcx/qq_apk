package com.tencent.mm.plugin.luckymoney.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Random;

public final class a
{
  public static boolean bMS()
  {
    AppMethodBeat.i(284545);
    int i = ((Integer)h.baE().ban().get(at.a.acVG, Integer.valueOf(0))).intValue();
    if (i <= 0)
    {
      AppMethodBeat.o(284545);
      return false;
    }
    if (i >= 100)
    {
      AppMethodBeat.o(284545);
      return true;
    }
    int j = new Random().nextInt(101);
    Log.i("MicroMsg.GetTimeLimitPromotBlindBox", "random: %s, %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
    if (j <= i)
    {
      AppMethodBeat.o(284545);
      return true;
    }
    AppMethodBeat.o(284545);
    return false;
  }
  
  public static void jG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(284544);
    int i = ((Integer)h.baE().ban().get(at.a.acVF, Integer.valueOf(-1))).intValue();
    Log.i("MicroMsg.GetTimeLimitPromotBlindBox", "new: [%s, %s], old: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(i) });
    if (paramInt2 > i)
    {
      h.baE().ban().set(at.a.acVF, Integer.valueOf(paramInt2));
      h.baE().ban().set(at.a.acVG, Integer.valueOf(paramInt1));
    }
    AppMethodBeat.o(284544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.a.a
 * JD-Core Version:    0.7.0.1
 */