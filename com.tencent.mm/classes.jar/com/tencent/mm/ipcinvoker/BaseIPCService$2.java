package com.tencent.mm.ipcinvoker;

import android.os.Process;

final class BaseIPCService$2
  implements Runnable
{
  BaseIPCService$2(BaseIPCService paramBaseIPCService) {}
  
  public final void run()
  {
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.BaseIPCService.2
 * JD-Core Version:    0.7.0.1
 */