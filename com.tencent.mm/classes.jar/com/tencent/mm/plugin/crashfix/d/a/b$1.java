package com.tencent.mm.plugin.crashfix.d.a;

import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$1
  extends Handler
{
  b$1(b paramb, Handler paramHandler) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(151902);
    try
    {
      ab.i("MicroMsg.INotificationManagerInvocationHandler", "run on my handler");
      this.kTh.handleMessage(paramMessage);
      AppMethodBeat.o(151902);
      return;
    }
    catch (Exception paramMessage)
    {
      ab.i("MicroMsg.INotificationManagerInvocationHandler", "protect succ");
      AppMethodBeat.o(151902);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.d.a.b.1
 * JD-Core Version:    0.7.0.1
 */