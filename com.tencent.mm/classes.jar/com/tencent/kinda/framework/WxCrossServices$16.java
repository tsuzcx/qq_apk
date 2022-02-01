package com.tencent.kinda.framework;

import android.content.Context;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.UseCaseCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI;

class WxCrossServices$16
  implements UseCaseCallback
{
  WxCrossServices$16(WxCrossServices paramWxCrossServices, Context paramContext) {}
  
  public void call(ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(263841);
    if (((this.val$context instanceof WalletLqtDetailUI)) && (paramITransmitKvData != null) && (paramITransmitKvData.getInt("LQTMainPageShouldRefresh") == 1)) {
      ((WalletLqtDetailUI)this.val$context).by(0, true);
    }
    AppMethodBeat.o(263841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.framework.WxCrossServices.16
 * JD-Core Version:    0.7.0.1
 */