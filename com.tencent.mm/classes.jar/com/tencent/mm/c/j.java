package com.tencent.mm.c;

public final class j
{
  public static int getInt(String paramString, int paramInt)
  {
    if (paramString != null) {
      try
      {
        if (paramString.length() <= 0) {
          return paramInt;
        }
        int i = Integer.parseInt(paramString);
        return i;
      }
      catch (NumberFormatException paramString) {}
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.c.j
 * JD-Core Version:    0.7.0.1
 */