package com.google.a;

final class e
{
  private static final Class<?> bNe = bY("libcore.io.Memory");
  private static final boolean bNf;
  
  static
  {
    if (bY("org.robolectric.Robolectric") != null) {}
    for (boolean bool = true;; bool = false)
    {
      bNf = bool;
      return;
    }
  }
  
  private static <T> Class<T> bY(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      return paramString;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  static boolean yM()
  {
    return (bNe != null) && (!bNf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.a.e
 * JD-Core Version:    0.7.0.1
 */