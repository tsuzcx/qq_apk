package com.tencent.mm.hardcoder;

public final class c
{
  private static a dEM = null;
  
  public static void a(a parama)
  {
    dEM = parama;
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (dEM != null) {
      dEM.d(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (dEM != null) {
      dEM.e(paramString1, paramString2);
    }
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (dEM != null) {
      dEM.i(paramString1, paramString2);
    }
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (dEM != null) {
      dEM.printErrStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
    }
  }
  
  public static abstract interface a
  {
    public abstract void d(String paramString1, String paramString2);
    
    public abstract void e(String paramString1, String paramString2);
    
    public abstract void i(String paramString1, String paramString2);
    
    public abstract void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hardcoder.c
 * JD-Core Version:    0.7.0.1
 */