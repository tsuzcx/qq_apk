package com.tencent.mm.console;

import com.tencent.mm.sdk.platformtools.y;

final class Shell$3
  implements Runnable
{
  public final void run()
  {
    y.d("MicroMsg.Shell", "dkcrash begin tid:%d [%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName() });
    Object[] arrayOfObject = new Object[1];
    throw new NullPointerException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.console.Shell.3
 * JD-Core Version:    0.7.0.1
 */