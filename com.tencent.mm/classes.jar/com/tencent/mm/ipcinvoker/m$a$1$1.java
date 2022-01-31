package com.tencent.mm.ipcinvoker;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.g.a;
import com.tencent.mm.ipcinvoker.h.b;

final class m$a$1$1
  implements Runnable
{
  m$a$1$1(m.a.1 param1, Runnable paramRunnable) {}
  
  public final void run()
  {
    AppMethodBeat.i(114057);
    ThreadLocal localThreadLocal = (ThreadLocal)new a(Looper.class, "sThreadLocal").PV();
    if ((localThreadLocal != null) && (localThreadLocal.get() == null))
    {
      b.d("IPC.ExecutorServiceCreatorImpl", "create a new Looper ThreadLocal variable.", new Object[0]);
      localThreadLocal.set(this.eEB.eEz.mHandlerThread.getLooper());
    }
    for (;;)
    {
      this.eEA.run();
      AppMethodBeat.o(114057);
      return;
      b.d("IPC.ExecutorServiceCreatorImpl", "ThreadLocal Looper variable is null or has set.(%s)", new Object[] { localThreadLocal });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.m.a.1.1
 * JD-Core Version:    0.7.0.1
 */