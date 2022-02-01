package com.tencent.mm.normsg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CountDownLatch;

final class c$p$1
  implements Runnable
{
  c$p$1(String paramString, CountDownLatch paramCountDownLatch) {}
  
  public final void run()
  {
    AppMethodBeat.i(62425);
    System.loadLibrary(this.inO);
    this.val$latch.countDown();
    AppMethodBeat.o(62425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.normsg.c.p.1
 * JD-Core Version:    0.7.0.1
 */