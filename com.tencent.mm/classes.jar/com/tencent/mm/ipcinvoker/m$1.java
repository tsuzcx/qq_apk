package com.tencent.mm.ipcinvoker;

import android.os.HandlerThread;
import com.tencent.mm.ipcinvoker.h.b;

final class m$1
  implements Runnable
{
  m$1(m paramm, HandlerThread paramHandlerThread) {}
  
  public final void run()
  {
    b.i("IPC.ThreadPool", "createHandlerThread(id : %d)", new Object[] { Integer.valueOf(this.dGT.getThreadId()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.m.1
 * JD-Core Version:    0.7.0.1
 */