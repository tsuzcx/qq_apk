package com.tencent.liteav.audio.impl;

import android.media.AudioManager;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

class a$4
  implements Runnable
{
  a$4(a parama) {}
  
  public void run()
  {
    AppMethodBeat.i(66543);
    try
    {
      a.d(this.a).stopBluetoothSco();
      a.d(this.a).setBluetoothScoOn(false);
      AppMethodBeat.o(66543);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      TXCLog.i(a.a(this.a), "checkBTHeadsetState, startBluetoothSco exception = ".concat(String.valueOf(localNullPointerException)));
      AppMethodBeat.o(66543);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.a.4
 * JD-Core Version:    0.7.0.1
 */