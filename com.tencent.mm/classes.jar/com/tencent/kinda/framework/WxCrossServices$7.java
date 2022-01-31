package com.tencent.kinda.framework;

import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.UseCaseCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vk;
import com.tencent.mm.sdk.b.a;

class WxCrossServices$7
  implements UseCaseCallback
{
  WxCrossServices$7(WxCrossServices paramWxCrossServices) {}
  
  public void call(ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(144244);
    boolean bool = paramITransmitKvData.getBool("pay_result");
    paramITransmitKvData = new vk();
    paramITransmitKvData.cMA.result = 0;
    if (bool) {
      paramITransmitKvData.cMA.result = -1;
    }
    a.ymk.l(paramITransmitKvData);
    AppMethodBeat.o(144244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.framework.WxCrossServices.7
 * JD-Core Version:    0.7.0.1
 */