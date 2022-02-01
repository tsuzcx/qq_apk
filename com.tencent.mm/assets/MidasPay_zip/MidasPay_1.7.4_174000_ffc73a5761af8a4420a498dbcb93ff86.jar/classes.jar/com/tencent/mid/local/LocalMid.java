package com.tencent.mid.local;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;

public class LocalMid
{
  private static Context a;
  private static Handler b;
  private static LocalMid c;
  
  private LocalMid(Context paramContext)
  {
    HandlerThread localHandlerThread = new HandlerThread(LocalMid.class.getSimpleName());
    localHandlerThread.start();
    b = new Handler(localHandlerThread.getLooper());
    a = paramContext.getApplicationContext();
  }
  
  public static LocalMid getInstance(Context paramContext)
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new LocalMid(paramContext);
        }
      }
      finally {}
    }
    return c;
  }
  
  public String getLocalMid()
  {
    return h.a(a).a().c;
  }
  
  public boolean isMidValid(String paramString)
  {
    return i.c(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.tencent.mid.local.LocalMid
 * JD-Core Version:    0.7.0.1
 */