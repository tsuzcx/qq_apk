package com.tencent.map.lib.thread;

class AsyncTask$c$1
  implements Runnable
{
  AsyncTask$c$1(AsyncTask.c paramc, Runnable paramRunnable) {}
  
  public void run()
  {
    try
    {
      this.a.run();
      return;
    }
    finally
    {
      this.b.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.lib.thread.AsyncTask.c.1
 * JD-Core Version:    0.7.0.1
 */