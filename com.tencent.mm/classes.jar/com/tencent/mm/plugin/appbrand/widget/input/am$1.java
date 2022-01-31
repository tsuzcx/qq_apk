package com.tencent.mm.plugin.appbrand.widget.input;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class am$1
  extends Handler
{
  am$1(am paramam, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
    } while (!am.a(this.hwB));
    sendMessageDelayed(Message.obtain(am.b(this.hwB), 2), 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.am.1
 * JD-Core Version:    0.7.0.1
 */