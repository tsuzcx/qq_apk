package com.tencent.kinda.framework;

import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.UseCaseCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

class WxCrossServices$25
  implements UseCaseCallback
{
  WxCrossServices$25(WxCrossServices paramWxCrossServices) {}
  
  public void call(ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(226351);
    if (paramITransmitKvData.getInt("scene") == 1) {
      throw new NullPointerException();
    }
    AppMethodBeat.o(226351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.WxCrossServices.25
 * JD-Core Version:    0.7.0.1
 */