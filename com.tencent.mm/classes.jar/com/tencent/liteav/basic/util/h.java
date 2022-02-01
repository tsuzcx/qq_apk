package com.tencent.liteav.basic.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class h
  extends Handler
{
  private int a;
  private boolean b = false;
  private a c;
  
  public h(Looper paramLooper, a parama)
  {
    super(paramLooper);
    this.c = parama;
  }
  
  public void a()
  {
    AppMethodBeat.i(187251);
    while (hasMessages(0)) {
      removeMessages(0);
    }
    this.b = false;
    AppMethodBeat.o(187251);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187250);
    a();
    this.a = paramInt2;
    this.b = true;
    sendEmptyMessageDelayed(0, paramInt1);
    AppMethodBeat.o(187250);
  }
  
  public void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(187249);
    if (this.c != null) {
      this.c.a();
    }
    if (this.b) {
      sendEmptyMessageDelayed(0, this.a);
    }
    AppMethodBeat.o(187249);
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.util.h
 * JD-Core Version:    0.7.0.1
 */