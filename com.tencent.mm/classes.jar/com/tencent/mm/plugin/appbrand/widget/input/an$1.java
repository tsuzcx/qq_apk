package com.tencent.mm.plugin.appbrand.widget.input;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class an$1
  extends Handler
{
  an$1(an paraman, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(123866);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(123866);
      return;
      if (an.a(this.joL)) {
        sendMessageDelayed(Message.obtain(an.b(this.joL), 2), 50L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.an.1
 * JD-Core Version:    0.7.0.1
 */