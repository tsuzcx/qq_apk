package com.tencent.map.lib.thread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

class AsyncTask$1
  extends AsyncTask.e<Params, Result>
{
  AsyncTask$1(AsyncTask paramAsyncTask)
  {
    super(null);
  }
  
  public Result call()
  {
    AppMethodBeat.i(98165);
    AsyncTask.a(this.a).set(true);
    Object localObject = this.a.doInBackground(this.b);
    localObject = AsyncTask.a(this.a, localObject);
    AppMethodBeat.o(98165);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.map.lib.thread.AsyncTask.1
 * JD-Core Version:    0.7.0.1
 */