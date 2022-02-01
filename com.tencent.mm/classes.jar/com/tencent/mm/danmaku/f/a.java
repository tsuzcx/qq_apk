package com.tencent.mm.danmaku.f;

import android.app.Application;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.a.c;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

public class a
{
  private static final AtomicInteger Nu;
  private static volatile Application jBq;
  private static volatile boolean jBr;
  
  static
  {
    AppMethodBeat.i(270733);
    Nu = new AtomicInteger(1);
    AppMethodBeat.o(270733);
  }
  
  public static boolean aAd()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  public static boolean aAe()
  {
    return Build.VERSION.SDK_INT >= 16;
  }
  
  public static boolean aAf()
  {
    return Build.VERSION.SDK_INT >= 17;
  }
  
  public static boolean aAg()
  {
    return Build.VERSION.SDK_INT >= 26;
  }
  
  public static Application aAh()
  {
    AppMethodBeat.i(270732);
    Application localApplication = c.ayF();
    if (localApplication != null)
    {
      AppMethodBeat.o(270732);
      return localApplication;
    }
    if (!jBr) {}
    try
    {
      boolean bool = jBr;
      if (!bool) {}
      try
      {
        localApplication = (Application)Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
        jBq = localApplication;
        if (localApplication != null) {
          jBr = true;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          jBr = true;
        }
      }
      localApplication = jBq;
      AppMethodBeat.o(270732);
      return localApplication;
    }
    finally
    {
      AppMethodBeat.o(270732);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.danmaku.f.a
 * JD-Core Version:    0.7.0.1
 */