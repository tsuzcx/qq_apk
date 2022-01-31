package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.IAsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;

class KindaUIEventLoop$1
  implements Runnable
{
  KindaUIEventLoop$1(KindaUIEventLoop paramKindaUIEventLoop, IAsyncTask paramIAsyncTask) {}
  
  public void run()
  {
    AppMethodBeat.i(144539);
    this.val$task.execute();
    AppMethodBeat.o(144539);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaUIEventLoop.1
 * JD-Core Version:    0.7.0.1
 */