package com.tencent.mm.normsgext;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CountDownLatch;

final class d$m
{
  static
  {
    AppMethodBeat.i(248729);
    String str = new StringBuilder("txegsmron").reverse().toString();
    if (Process.myPid() == Process.myTid())
    {
      System.loadLibrary(str);
      AppMethodBeat.o(248729);
      return;
    }
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(248724);
        System.loadLibrary(this.mxi);
        localCountDownLatch.countDown();
        AppMethodBeat.o(248724);
      }
    });
    try
    {
      localCountDownLatch.await();
      AppMethodBeat.o(248729);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(248729);
    }
  }
  
  static native boolean ba(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, QValue<Integer> paramQValue1, QValue<Integer> paramQValue2, QValue<byte[]> paramQValue);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.normsgext.d.m
 * JD-Core Version:    0.7.0.1
 */