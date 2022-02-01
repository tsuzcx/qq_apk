package com.tencent.mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.concurrent.Executor;

final class ExportFileUtil$1
  implements Executor
{
  public final void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(234073);
    h.ahAA.g(paramRunnable, "MicroMsg.ExportFileUtil");
    AppMethodBeat.o(234073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.platformtools.ExportFileUtil.1
 * JD-Core Version:    0.7.0.1
 */