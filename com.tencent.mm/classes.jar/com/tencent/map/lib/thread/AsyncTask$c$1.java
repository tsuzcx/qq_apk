package com.tencent.map.lib.thread;

import com.tencent.matrix.trace.core.AppMethodBeat;

class AsyncTask$c$1
  implements Runnable
{
  AsyncTask$c$1(AsyncTask.c paramc, Runnable paramRunnable) {}
  
  public void run()
  {
    AppMethodBeat.i(98170);
    try
    {
      this.a.run();
      return;
    }
    finally
    {
      this.b.a();
      AppMethodBeat.o(98170);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.map.lib.thread.AsyncTask.c.1
 * JD-Core Version:    0.7.0.1
 */