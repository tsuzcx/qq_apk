package com.tencent.e.a;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.StringTokenizer;

public final class b
{
  private static volatile a wRN;
  
  static
  {
    try
    {
      Class.forName("android.util.Log");
      a locala = new a();
      wRN = locala;
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        a local1 = new a()
        {
          public final boolean isLoggable(String paramAnonymousString, int paramAnonymousInt)
          {
            return true;
          }
          
          public final void println(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
          {
            System.out.println("[" + paramAnonymousString1 + "] " + paramAnonymousString2);
          }
        };
      }
    }
  }
  
  public static void a(a parama)
  {
    wRN = parama;
  }
  
  private static void b(int paramInt, String paramString1, String paramString2, Object... paramVarArgs)
  {
    a locala = wRN;
    if ((locala == null) || (!locala.isLoggable(paramString1, paramInt))) {
      return;
    }
    locala.println(paramInt, paramString1, String.format(paramString2, paramVarArgs));
  }
  
  private static void b(int paramInt, String paramString, Throwable paramThrowable)
  {
    a locala = wRN;
    if ((locala == null) || (!locala.isLoggable(paramString, paramInt))) {}
    for (;;)
    {
      return;
      StringWriter localStringWriter = new StringWriter(512);
      paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
      paramThrowable = new StringTokenizer(localStringWriter.toString(), "\n");
      while (paramThrowable.hasMoreTokens()) {
        locala.println(paramInt, paramString, paramThrowable.nextToken());
      }
    }
  }
  
  public static void b(String paramString1, Throwable paramThrowable, String paramString2)
  {
    if (!paramString2.isEmpty()) {
      println(6, paramString1, paramString2);
    }
    b(6, paramString1, paramThrowable);
  }
  
  public static void c(String paramString1, Throwable paramThrowable, String paramString2)
  {
    if (!paramString2.isEmpty()) {
      println(5, paramString1, paramString2);
    }
    b(5, paramString1, paramThrowable);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    println(3, paramString1, paramString2);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    b(3, paramString1, paramString2, paramVarArgs);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    println(6, paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    b(6, paramString1, paramString2, paramVarArgs);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    println(4, paramString1, paramString2);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    b(4, paramString1, paramString2, paramVarArgs);
  }
  
  private static void println(int paramInt, String paramString1, String paramString2)
  {
    a locala = wRN;
    if (locala == null) {
      return;
    }
    locala.println(paramInt, paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    println(5, paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    b(5, paramString1, paramString2, paramVarArgs);
  }
  
  public static abstract interface a
  {
    public abstract boolean isLoggable(String paramString, int paramInt);
    
    public abstract void println(int paramInt, String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.a.b
 * JD-Core Version:    0.7.0.1
 */