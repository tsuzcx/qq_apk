package com.tencent.mm.plugin.luckymoney.appbrand.ui.receive;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.d.a;
import com.tencent.mm.sdk.platformtools.ab;

final class c$3
  implements d.a
{
  c$3(c paramc) {}
  
  public final void f(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(42127);
    if (paramInt == -1)
    {
      paramIntent = this.okq;
      if (paramIntent.okm == null)
      {
        ab.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "WxaGetLuckyMoneyLogic.succeed ui == null");
        AppMethodBeat.o(42127);
        return;
      }
      paramIntent.okm.bMO();
      paramIntent.okm.e(-1, new Intent());
      AppMethodBeat.o(42127);
      return;
    }
    this.okq.ae(paramIntent);
    AppMethodBeat.o(42127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.c.3
 * JD-Core Version:    0.7.0.1
 */