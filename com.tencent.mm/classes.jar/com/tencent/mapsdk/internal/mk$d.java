package com.tencent.mapsdk.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class mk$d
  extends Handler
{
  private static final int b = 600000;
  
  private mk$d(mk parammk, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a()
  {
    AppMethodBeat.i(221837);
    c();
    AppMethodBeat.o(221837);
  }
  
  private void b()
  {
    AppMethodBeat.i(221845);
    if (hasMessages(0)) {
      removeMessages(0);
    }
    AppMethodBeat.o(221845);
  }
  
  private void c()
  {
    AppMethodBeat.i(221853);
    if (!hasMessages(0)) {
      sendEmptyMessageDelayed(0, 600000L);
    }
    AppMethodBeat.o(221853);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(221862);
    mk.f(this.a);
    c();
    AppMethodBeat.o(221862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mapsdk.internal.mk.d
 * JD-Core Version:    0.7.0.1
 */