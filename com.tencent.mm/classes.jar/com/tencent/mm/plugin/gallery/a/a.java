package com.tencent.mm.plugin.gallery.a;

import java.util.Collections;
import java.util.List;

public final class a
{
  public static void swap(List<?> paramList, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 > paramInt2) {
      while (paramInt1 > paramInt2)
      {
        Collections.swap(paramList, paramInt1, paramInt1 - 1);
        paramInt1 -= 1;
      }
    }
    while (i < paramInt2)
    {
      Collections.swap(paramList, i, i + 1);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.a.a
 * JD-Core Version:    0.7.0.1
 */