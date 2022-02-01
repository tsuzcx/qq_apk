package com.tencent.mm.booter;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pi;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;

final class MMReceivers$AlarmReceiver$1
  implements Runnable
{
  MMReceivers$AlarmReceiver$1(MMReceivers.AlarmReceiver paramAlarmReceiver) {}
  
  public final void run()
  {
    AppMethodBeat.i(131882);
    pi localpi = new pi();
    a.IbL.a(localpi, Looper.getMainLooper());
    ad.i("MicroMsg.AlarmReceiver", "onReceive() publish PushKeepAliveEvent");
    AppMethodBeat.o(131882);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.MMReceivers.AlarmReceiver.1
 * JD-Core Version:    0.7.0.1
 */