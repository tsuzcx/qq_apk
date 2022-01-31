package com.tencent.mm.booter;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nd;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;

final class MMReceivers$AlarmReceiver$1
  implements Runnable
{
  MMReceivers$AlarmReceiver$1(MMReceivers.AlarmReceiver paramAlarmReceiver) {}
  
  public final void run()
  {
    AppMethodBeat.i(57766);
    nd localnd = new nd();
    a.ymk.a(localnd, Looper.getMainLooper());
    ab.i("MicroMsg.AlarmReceiver", "onReceive() publish PushKeepAliveEvent");
    AppMethodBeat.o(57766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.MMReceivers.AlarmReceiver.1
 * JD-Core Version:    0.7.0.1
 */