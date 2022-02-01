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
    AppMethodBeat.i(193665);
    String str = new StringBuilder("txegsmron").reverse().toString();
    if (Process.myPid() == Process.myTid())
    {
      System.loadLibrary(str);
      AppMethodBeat.o(193665);
      return;
    }
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193664);
        System.loadLibrary(this.iJZ);
        localCountDownLatch.countDown();
        AppMethodBeat.o(193664);
      }
    });
    try
    {
      localCountDownLatch.await();
      AppMethodBeat.o(193665);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(193665);
    }
  }
  
  static native boolean ba(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, QValue<Integer> paramQValue1, QValue<Integer> paramQValue2, QValue<byte[]> paramQValue);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.normsgext.d.m
 * JD-Core Version:    0.7.0.1
 */