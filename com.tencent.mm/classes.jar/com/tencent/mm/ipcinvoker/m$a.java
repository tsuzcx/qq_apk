package com.tencent.mm.ipcinvoker;

import android.os.HandlerThread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

final class m$a
  implements com.tencent.mm.ipcinvoker.a.b
{
  private int dGV = 3;
  HandlerThread mHandlerThread;
  
  m$a()
  {
    HandlerThread localHandlerThread = new HandlerThread("ThreadPool#InnerWorkerThread-" + hashCode());
    localHandlerThread.start();
    com.tencent.mm.ipcinvoker.h.b.i("IPC.ExecutorServiceCreatorImpl", "createHandlerThread(hash : %d)", new Object[] { Integer.valueOf(localHandlerThread.hashCode()) });
    this.mHandlerThread = localHandlerThread;
  }
  
  public final ExecutorService Ca()
  {
    m.a.2 local2 = new m.a.2(this, this.dGV, new m.a.1(this));
    local2.setMaximumPoolSize((int)(this.dGV * 1.5D));
    local2.setRejectedExecutionHandler(new m.a.3(this));
    return local2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.m.a
 * JD-Core Version:    0.7.0.1
 */