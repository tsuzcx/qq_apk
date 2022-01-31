package com.tencent.map.lib.thread;

import com.tencent.matrix.trace.core.AppMethodBeat;

class AsyncTask$3
  implements Runnable
{
  AsyncTask$3(AsyncTask paramAsyncTask, Object[] paramArrayOfObject) {}
  
  public void run()
  {
    AppMethodBeat.i(98167);
    if (AsyncTask.b(this.b) == AsyncTask.d.a) {
      this.b.execute(this.a);
    }
    AppMethodBeat.o(98167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.map.lib.thread.AsyncTask.3
 * JD-Core Version:    0.7.0.1
 */