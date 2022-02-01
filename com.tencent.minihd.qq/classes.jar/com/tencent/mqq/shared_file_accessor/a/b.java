package com.tencent.mqq.shared_file_accessor.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.FileWriter;
import java.io.IOException;

final class b
  extends Handler
{
  public b(a parama, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message arg1)
  {
    switch (???.what)
    {
    default: 
    case 0: 
      do
      {
        return;
        ??? = (String)???.obj;
      } while (a.b(this.a) == null);
      try
      {
        a.b(this.a).write(???);
        a.b(this.a).flush();
        return;
      }
      catch (IOException ???)
      {
        ???.printStackTrace();
        return;
      }
    }
    synchronized (this.a)
    {
      sendMessage(Message.obtain(this, 0, a.a(this.a).toString()));
      a.a(this.a).setLength(0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.a.b
 * JD-Core Version:    0.7.0.1
 */