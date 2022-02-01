package com.tencent.mm.hardcoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.c.d;

class WXHardCoderJNI$2
  implements HardCoderJNI.HCPerfManagerThread
{
  public Thread newThread(Runnable paramRunnable, String paramString, int paramInt)
  {
    AppMethodBeat.i(155948);
    paramRunnable = d.b(paramString, paramRunnable, paramInt);
    AppMethodBeat.o(155948);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.hardcoder.WXHardCoderJNI.2
 * JD-Core Version:    0.7.0.1
 */