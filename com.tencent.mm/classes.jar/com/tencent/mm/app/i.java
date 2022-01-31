package com.tencent.mm.app;

import android.os.HandlerThread;
import android.os.Process;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vending.h.h;

public final class i
{
  static i bwu;
  HandlerThread bwv;
  com.tencent.mm.vending.h.d bww;
  ah handler;
  
  public i(String paramString)
  {
    this.bwv = e.ds(paramString, 10);
    this.bwv.start();
    this.handler = new ah(this.bwv.getLooper());
    this.bww = new h(com.tencent.mm.ck.d.c(this.handler), paramString);
  }
  
  public final void sQ()
  {
    if ((this.bwv == null) || (!this.bwv.isAlive()))
    {
      y.e("MicroMsg.InitThreadController", "setHighPriority failed thread is dead");
      return;
    }
    int i = this.bwv.getThreadId();
    try
    {
      if (-8 == Process.getThreadPriority(i))
      {
        y.w("MicroMsg.InitThreadController", "setHighPriority No Need.");
        return;
      }
    }
    catch (Exception localException)
    {
      y.w("MicroMsg.InitThreadController", "thread:%d setHighPriority failed", new Object[] { Integer.valueOf(i) });
      y.printErrStackTrace("MicroMsg.InitThreadController", localException, "", new Object[0]);
      return;
    }
    Process.setThreadPriority(i, -8);
    y.i("MicroMsg.InitThreadController", "InitThreadController:%d setHighPriority to %d", new Object[] { Integer.valueOf(i), Integer.valueOf(Process.getThreadPriority(i)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.app.i
 * JD-Core Version:    0.7.0.1
 */