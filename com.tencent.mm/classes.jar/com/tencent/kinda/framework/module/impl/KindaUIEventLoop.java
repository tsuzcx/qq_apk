package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.IAsyncTask;
import com.tencent.kinda.gen.KEventLoop;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;

public class KindaUIEventLoop
  implements KEventLoop
{
  public void post(IAsyncTask paramIAsyncTask)
  {
    AppMethodBeat.i(144540);
    al.d(new KindaUIEventLoop.1(this, paramIAsyncTask));
    AppMethodBeat.o(144540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaUIEventLoop
 * JD-Core Version:    0.7.0.1
 */