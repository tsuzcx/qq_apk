package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;

final class a$5
  implements Runnable
{
  a$5(a parama, String paramString, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(186288);
    long l = Util.currentTicks();
    az localaz = ((n)h.ae(n.class)).bbR().bwx(this.iXG);
    int j;
    if ((localaz != null) && (ab.Lj(this.iXG)))
    {
      if (localaz.field_hbMarkRed != 1) {
        break label181;
      }
      j = 1;
      if (j != this.Eto)
      {
        Log.i("MicroMsg.SubCoreLuckyMoney", "update red flag: %s, %s", new Object[] { this.iXG, Boolean.valueOf(this.Eto) });
        if (!this.Eto) {
          break label187;
        }
      }
    }
    label181:
    label187:
    for (int i = 1;; i = 0)
    {
      localaz.pR(i);
      Log.i("MicroMsg.SubCoreLuckyMoney", "update ret: %s", new Object[] { Integer.valueOf(((n)h.ae(n.class)).bbR().a(localaz, this.iXG)) });
      Log.i("MicroMsg.SubCoreLuckyMoney", "finish update red flag: %s", new Object[] { Long.valueOf(Util.currentTicks() - l) });
      AppMethodBeat.o(186288);
      return;
      j = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.a.5
 * JD-Core Version:    0.7.0.1
 */