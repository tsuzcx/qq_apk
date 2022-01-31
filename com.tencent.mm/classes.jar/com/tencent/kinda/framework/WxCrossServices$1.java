package com.tencent.kinda.framework;

import android.content.Context;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.UseCaseCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_index.ui.OrderHandlerUI;

class WxCrossServices$1
  implements UseCaseCallback
{
  WxCrossServices$1(WxCrossServices paramWxCrossServices, Context paramContext) {}
  
  public void call(ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(144239);
    if ((this.val$context instanceof OrderHandlerUI)) {
      ((OrderHandlerUI)this.val$context).finish();
    }
    AppMethodBeat.o(144239);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.WxCrossServices.1
 * JD-Core Version:    0.7.0.1
 */