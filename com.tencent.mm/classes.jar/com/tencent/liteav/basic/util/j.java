package com.tencent.liteav.basic.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class j
  extends Handler
{
  private int a;
  private boolean b = false;
  private a c;
  
  public j(Looper paramLooper, a parama)
  {
    super(paramLooper);
    this.c = parama;
  }
  
  public void a()
  {
    AppMethodBeat.i(230150);
    while (hasMessages(0)) {
      removeMessages(0);
    }
    this.b = false;
    AppMethodBeat.o(230150);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(230146);
    a();
    this.a = paramInt2;
    this.b = true;
    sendEmptyMessageDelayed(0, paramInt1);
    AppMethodBeat.o(230146);
  }
  
  public void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(230141);
    if (this.c != null) {
      this.c.onTimeout();
    }
    if (this.b) {
      sendEmptyMessageDelayed(0, this.a);
    }
    AppMethodBeat.o(230141);
  }
  
  public static abstract interface a
  {
    public abstract void onTimeout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.basic.util.j
 * JD-Core Version:    0.7.0.1
 */