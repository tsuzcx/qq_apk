package com.google.b;

final class e
{
  private static final Class<?> bPd = cs("libcore.io.Memory");
  private static final boolean bPe;
  
  static
  {
    if (cs("org.robolectric.Robolectric") != null) {}
    for (boolean bool = true;; bool = false)
    {
      bPe = bool;
      return;
    }
  }
  
  static boolean An()
  {
    return (bPd != null) && (!bPe);
  }
  
  private static <T> Class<T> cs(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      return paramString;
    }
    catch (Throwable paramString) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.e
 * JD-Core Version:    0.7.0.1
 */