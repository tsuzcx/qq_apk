package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.o;

final class c$1
  implements ap.a
{
  c$1(c paramc) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(78658);
    boolean bool2 = o.gE(ah.getContext());
    String str = c.ci(ah.getContext());
    if (!bo.isNullOrNil(str)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ab.d("MicroMsg.ClickFlowStatReceiver", "monitorHandler ScreenOn:%s isTop:%s top:%s ", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), str });
      if ((bool2) && (bool1)) {
        break;
      }
      c.b(this.fSd).post(new c.1.1(this));
      AppMethodBeat.o(78658);
      return false;
    }
    AppMethodBeat.o(78658);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelstat.c.1
 * JD-Core Version:    0.7.0.1
 */