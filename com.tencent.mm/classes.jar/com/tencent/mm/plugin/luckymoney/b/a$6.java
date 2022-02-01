package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;

final class a$6
  implements Runnable
{
  a$6(a parama, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(228565);
    Log.i("MicroMsg.SubCoreLuckyMoney", "start update");
    long l = Util.currentTicks();
    boolean bool = a.aNB(this.iXG);
    az localaz = ((n)h.ae(n.class)).bbR().bwx(this.iXG);
    if ((localaz != null) && (ab.Lj(this.iXG)))
    {
      Log.i("MicroMsg.SubCoreLuckyMoney", "update red flag: %s, %s", new Object[] { this.iXG, Boolean.valueOf(bool) });
      if (!bool) {
        break label172;
      }
    }
    label172:
    for (int i = 1;; i = 0)
    {
      localaz.pR(i);
      Log.i("MicroMsg.SubCoreLuckyMoney", "update ret: %s", new Object[] { Integer.valueOf(((n)h.ae(n.class)).bbR().a(localaz, this.iXG)) });
      Log.i("MicroMsg.SubCoreLuckyMoney", "finish update red flag: %s", new Object[] { Long.valueOf(Util.currentTicks() - l) });
      AppMethodBeat.o(228565);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.a.6
 * JD-Core Version:    0.7.0.1
 */