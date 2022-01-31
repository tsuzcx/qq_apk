package com.tencent.mm.ipcinvoker.h;

public final class b
{
  private static com.tencent.mm.ipcinvoker.h.a.a dHn = new a();
  
  public static boolean b(com.tencent.mm.ipcinvoker.h.a.a parama)
  {
    if (parama == null) {
      return false;
    }
    dHn = parama;
    return true;
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    dHn.a(3, paramString1, paramString2, paramVarArgs);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    dHn.a(6, paramString1, paramString2, paramVarArgs);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    dHn.a(4, paramString1, paramString2, paramVarArgs);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    dHn.a(5, paramString1, paramString2, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.h.b
 * JD-Core Version:    0.7.0.1
 */