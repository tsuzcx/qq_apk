package com.tencent.matrix.trace;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class a
{
  public static long bQK;
  
  static
  {
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        a.ax(Process.myTid());
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.trace.a
 * JD-Core Version:    0.7.0.1
 */