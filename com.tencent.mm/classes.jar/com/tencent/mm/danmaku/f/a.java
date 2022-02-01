package com.tencent.mm.danmaku.f;

import android.app.Application;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.a.c;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

public class a
{
  private static final AtomicInteger QH;
  private static volatile Application gQX;
  private static volatile boolean gQY;
  
  static
  {
    AppMethodBeat.i(241779);
    QH = new AtomicInteger(1);
    AppMethodBeat.o(241779);
  }
  
  public static boolean atn()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  public static boolean ato()
  {
    return Build.VERSION.SDK_INT >= 16;
  }
  
  public static boolean atp()
  {
    return Build.VERSION.SDK_INT >= 17;
  }
  
  public static boolean atq()
  {
    return Build.VERSION.SDK_INT >= 26;
  }
  
  public static Application atr()
  {
    AppMethodBeat.i(241778);
    Application localApplication = c.arU();
    if (localApplication != null)
    {
      AppMethodBeat.o(241778);
      return localApplication;
    }
    if (!gQY) {}
    try
    {
      boolean bool = gQY;
      if (!bool) {}
      try
      {
        localApplication = (Application)Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
        gQX = localApplication;
        if (localApplication != null) {
          gQY = true;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          gQY = true;
        }
      }
      localApplication = gQX;
      AppMethodBeat.o(241778);
      return localApplication;
    }
    finally
    {
      AppMethodBeat.o(241778);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.danmaku.f.a
 * JD-Core Version:    0.7.0.1
 */