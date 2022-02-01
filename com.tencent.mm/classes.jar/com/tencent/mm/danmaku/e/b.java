package com.tencent.mm.danmaku.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  implements Thread.UncaughtExceptionHandler
{
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    AppMethodBeat.i(241755);
    e.e("DanmakuManager", "danmaku crash thread:" + paramThread.getName(), paramThrowable);
    AppMethodBeat.o(241755);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.danmaku.e.b
 * JD-Core Version:    0.7.0.1
 */