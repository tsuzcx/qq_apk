package com.tencent.matrix.resource.analyzer.a;

public final class b
{
  public static <T> T checkNotNull(T paramT, String paramString)
  {
    if (paramT == null) {
      throw new NullPointerException(paramString + " must not be null");
    }
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.resource.analyzer.a.b
 * JD-Core Version:    0.7.0.1
 */