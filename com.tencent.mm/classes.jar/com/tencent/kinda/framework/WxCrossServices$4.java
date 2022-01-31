package com.tencent.kinda.framework;

import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.UseCaseCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vk;
import com.tencent.mm.g.a.vk.a;
import com.tencent.mm.sdk.b.a;

class WxCrossServices$4
  implements UseCaseCallback
{
  WxCrossServices$4(WxCrossServices paramWxCrossServices) {}
  
  public void call(ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(144242);
    vk localvk = new vk();
    vk.a locala = localvk.cMA;
    if (paramITransmitKvData.getString("result").equals("ok")) {}
    for (int i = -1;; i = 0)
    {
      locala.result = i;
      a.ymk.l(localvk);
      AppMethodBeat.o(144242);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.WxCrossServices.4
 * JD-Core Version:    0.7.0.1
 */