package com.tencent.kinda.framework;

import android.content.Context;
import android.os.Bundle;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.UseCaseCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI;
import com.tencent.mm.sdk.platformtools.Log;

class WxCrossServices$18
  implements UseCaseCallback
{
  WxCrossServices$18(WxCrossServices paramWxCrossServices, Context paramContext, Bundle paramBundle) {}
  
  public void call(ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(226301);
    if (!(this.val$context instanceof WalletBalanceSaveUI))
    {
      AppMethodBeat.o(226301);
      return;
    }
    int i = paramITransmitKvData.getInt("result");
    Log.i("MicroMsg.WxCrossServices", "startWalletBalanceSaveUseCase result：%s", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    default: 
      Log.i("MicroMsg.WxCrossServices", "startWalletBalanceSave unknown result：%s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(226301);
      return;
    case 1: 
      ((WalletBalanceSaveUI)this.val$context).Vdg = false;
      ((WalletBalanceSaveUI)this.val$context).finish();
      AppMethodBeat.o(226301);
      return;
    case 2: 
      ((WalletBalanceSaveUI)this.val$context).Vdg = false;
      AppMethodBeat.o(226301);
      return;
    }
    ((WalletBalanceSaveUI)this.val$context).Vdg = false;
    h.OAn.b(16398, new Object[] { this.val$bundle.getString("reportSessionId"), Integer.valueOf(8), "", "" });
    AppMethodBeat.o(226301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.WxCrossServices.18
 * JD-Core Version:    0.7.0.1
 */