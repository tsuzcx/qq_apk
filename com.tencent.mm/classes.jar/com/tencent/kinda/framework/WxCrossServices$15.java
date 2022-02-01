package com.tencent.kinda.framework;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.UseCaseCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI;
import com.tencent.mm.sdk.platformtools.Log;

class WxCrossServices$15
  implements UseCaseCallback
{
  private byte _hellAccFlag_;
  
  WxCrossServices$15(WxCrossServices paramWxCrossServices, Context paramContext, Bundle paramBundle) {}
  
  public void call(ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(178760);
    if (!(this.val$context instanceof WalletBalanceFetchUI))
    {
      AppMethodBeat.o(178760);
      return;
    }
    int i = paramITransmitKvData.getInt("result");
    Log.i("MicroMsg.WxCrossServices", "startWalletBalanceFetchUseCase result：%s", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    default: 
      Log.i("MicroMsg.WxCrossServices", "startWalletBalanceFetch unknown result：%s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(178760);
      return;
    case 1: 
      Object localObject = new Intent(this.val$context, WalletBalanceManagerUI.class);
      ((Intent)localObject).addFlags(67108864);
      paramITransmitKvData = this.val$context;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramITransmitKvData, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/kinda/framework/WxCrossServices$15", "call", "(Lcom/tencent/kinda/gen/ITransmitKvData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramITransmitKvData.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramITransmitKvData, "com/tencent/kinda/framework/WxCrossServices$15", "call", "(Lcom/tencent/kinda/gen/ITransmitKvData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(178760);
      return;
    case 2: 
      AppMethodBeat.o(178760);
      return;
    }
    h.IzE.a(16398, new Object[] { this.val$bundle.getString("reportSessionId"), Integer.valueOf(8), "", "" });
    AppMethodBeat.o(178760);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.framework.WxCrossServices.15
 * JD-Core Version:    0.7.0.1
 */