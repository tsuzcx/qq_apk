package com.tencent.mm.ipcinvoker;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BaseIPCService$2
  implements Runnable
{
  BaseIPCService$2(BaseIPCService paramBaseIPCService) {}
  
  public final void run()
  {
    AppMethodBeat.i(158710);
    Process.killProcess(Process.myPid());
    AppMethodBeat.o(158710);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.BaseIPCService.2
 * JD-Core Version:    0.7.0.1
 */