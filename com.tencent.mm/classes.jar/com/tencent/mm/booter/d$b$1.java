package com.tencent.mm.booter;

import android.os.Process;

final class d$b$1
  implements Runnable
{
  d$b$1(d.b paramb) {}
  
  public final void run()
  {
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.booter.d.b.1
 * JD-Core Version:    0.7.0.1
 */