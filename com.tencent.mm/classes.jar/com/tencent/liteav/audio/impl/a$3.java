package com.tencent.liteav.audio.impl;

import android.media.AudioManager;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

class a$3
  implements Runnable
{
  a$3(a parama) {}
  
  public void run()
  {
    AppMethodBeat.i(66567);
    try
    {
      a.d(this.a).startBluetoothSco();
      AppMethodBeat.o(66567);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      TXCLog.i(a.a(this.a), "checkBTHeadsetState, startBluetoothSco exception = ".concat(String.valueOf(localNullPointerException)));
      AppMethodBeat.o(66567);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.a.3
 * JD-Core Version:    0.7.0.1
 */