package com.tencent.mm.d.a;

import android.os.Process;
import com.eclipsesource.v8.MultiContextV8;
import com.eclipsesource.v8.V8Locker;
import com.eclipsesource.v8.utils.MemoryManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.CountDownLatch;

final class a$2
  extends Thread
{
  a$2(a parama, String paramString, CountDownLatch paramCountDownLatch)
  {
    super(paramString);
  }
  
  public final void run()
  {
    AppMethodBeat.i(113796);
    a.a(this.cbl, Process.myTid());
    a.a(this.cbl, this.cbl.Ci());
    a.b(this.cbl).a(new a.2.1(this));
    this.val$latch.countDown();
    a.c(this.cbl).countDown();
    long l = System.currentTimeMillis();
    ab.i("MicroMsg.AbstractJSRuntime", "prepareV8WhenThreadStart");
    a.a(this.cbl, this.cbl.Ch());
    a.a(this.cbl, new x(a.a(this.cbl)));
    a.d(this.cbl);
    a.a(this.cbl, a.a(this.cbl).createMemoryManager());
    ab.i("MicroMsg.AbstractJSRuntime", "v8 init cost:%d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    V8Locker localV8Locker = a.a(this.cbl).getV8Locker();
    if (localV8Locker.hasLock())
    {
      ab.i("MicroMsg.AbstractJSRuntime", "has lock release");
      localV8Locker.release();
    }
    localV8Locker.acquire();
    a.b(this.cbl).loop();
    a.e(this.cbl);
    a.f(this.cbl).release();
    a.d(this.cbl);
    this.cbl.Cj();
    AppMethodBeat.o(113796);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.d.a.a.2
 * JD-Core Version:    0.7.0.1
 */