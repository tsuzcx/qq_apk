package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import java.util.List;

final class n$b
  implements ap.a
{
  Runnable fsD;
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(77950);
    int j = n.Yo().size();
    ab.e("MicroMsg.RemoveAvatarTask", "RemoveOldAvatar left count:".concat(String.valueOf(j)));
    if ((j <= 2000) || (n.access$100() >= 300))
    {
      if (this.fsD != null) {
        this.fsD.run();
      }
      n.adc();
      AppMethodBeat.o(77950);
      return false;
    }
    long l = g.RL().eHS.kr(Thread.currentThread().getId());
    int i = j - 1;
    while (i >= j - 30)
    {
      n.ade();
      String str = (String)n.Yo().get(i);
      n.Yo().remove(i);
      o.acQ();
      d.F(str, false);
      o.acQ();
      d.F(str, true);
      o.adg().rk(str);
      i -= 1;
    }
    g.RL().eHS.nY(l);
    AppMethodBeat.o(77950);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ah.n.b
 * JD-Core Version:    0.7.0.1
 */