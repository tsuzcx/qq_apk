package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.ui.e.b;

final class i$1
  implements e.b
{
  i$1(int paramInt) {}
  
  public final void bS(Object paramObject)
  {
    AppMethodBeat.i(43111);
    ab.i("MicroMsg.QueryWeChatWalletManager", "get from push done: %s", new Object[] { paramObject });
    long l = 0L;
    if ((paramObject instanceof Long)) {
      l = ((Long)paramObject).longValue();
    }
    i.B(l, this.oxU);
    AppMethodBeat.o(43111);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.i.1
 * JD-Core Version:    0.7.0.1
 */