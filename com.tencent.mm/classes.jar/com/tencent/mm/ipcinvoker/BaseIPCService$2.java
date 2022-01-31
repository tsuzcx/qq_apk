package com.tencent.mm.ipcinvoker;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BaseIPCService$2
  implements Runnable
{
  BaseIPCService$2(BaseIPCService paramBaseIPCService) {}
  
  public final void run()
  {
    AppMethodBeat.i(114000);
    Process.killProcess(Process.myPid());
    AppMethodBeat.o(114000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.BaseIPCService.2
 * JD-Core Version:    0.7.0.1
 */