package com.google.android.exoplayer2.d;

public final class b
{
  public static boolean DEBUG = true;
  private static a aFI = null;
  
  public static void a(a parama)
  {
    aFI = parama;
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (aFI != null) {
      aFI.e(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (aFI != null) {
      aFI.i(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (aFI != null) {
      aFI.w(paramString1, paramString2, paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.d.b
 * JD-Core Version:    0.7.0.1
 */