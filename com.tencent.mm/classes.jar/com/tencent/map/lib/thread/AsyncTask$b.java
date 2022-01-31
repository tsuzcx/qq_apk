package com.tencent.map.lib.thread;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

class AsyncTask$b
  extends Handler
{
  public AsyncTask$b(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(98169);
    AsyncTask.a locala = (AsyncTask.a)paramMessage.obj;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(98169);
      return;
      AsyncTask.c(locala.a, locala.b[0]);
      AppMethodBeat.o(98169);
      return;
      locala.a.onProgressUpdate(locala.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.map.lib.thread.AsyncTask.b
 * JD-Core Version:    0.7.0.1
 */