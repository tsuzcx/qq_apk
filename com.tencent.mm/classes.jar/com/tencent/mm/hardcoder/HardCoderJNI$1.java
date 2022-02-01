package com.tencent.mm.hardcoder;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class HardCoderJNI$1
  implements HardCoderJNI.HCPerfManagerThread
{
  public final Thread newThread(Runnable paramRunnable, String paramString, int paramInt)
  {
    AppMethodBeat.i(62459);
    paramRunnable = new Thread(paramRunnable, paramString);
    AppMethodBeat.o(62459);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.hardcoder.HardCoderJNI.1
 * JD-Core Version:    0.7.0.1
 */