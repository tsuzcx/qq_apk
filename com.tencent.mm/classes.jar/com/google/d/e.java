package com.google.d;

final class e
{
  private static final Class<?> dIF = dR("libcore.io.Memory");
  private static final boolean dIG;
  
  static
  {
    if (dR("org.robolectric.Robolectric") != null) {}
    for (boolean bool = true;; bool = false)
    {
      dIG = bool;
      return;
    }
  }
  
  static boolean ZR()
  {
    return (dIF != null) && (!dIG);
  }
  
  private static <T> Class<T> dR(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      return paramString;
    }
    finally {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.d.e
 * JD-Core Version:    0.7.0.1
 */