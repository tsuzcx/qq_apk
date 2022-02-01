package com.tencent.matrix.e;

public final class c
{
  private static a fiZ;
  private static a fja;
  
  static
  {
    c.1 local1 = new c.1();
    fiZ = local1;
    fja = local1;
  }
  
  public static void b(a parama)
  {
    fja = parama;
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (fja != null) {
      fja.d(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (fja != null) {
      fja.e(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (fja != null) {
      fja.i(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (fja != null) {
      fja.printErrStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
    }
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (fja != null) {
      fja.v(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (fja != null) {
      fja.w(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static abstract interface a
  {
    public abstract void d(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void e(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void i(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs);
    
    public abstract void v(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void w(String paramString1, String paramString2, Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.e.c
 * JD-Core Version:    0.7.0.1
 */