package com.tencent.mm.plugin.downloader_app.b;

import java.util.LinkedList;

public final class h<E extends e>
  extends LinkedList<E>
{
  public final int a(E paramE)
  {
    int i = 0;
    if (i < size())
    {
      e locale = (e)get(i);
      if (paramE.aGm() >= locale.aGm()) {}
    }
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        i = size();
      }
      add(i, paramE);
      return i;
      i += 1;
      break;
      i = 0;
    }
  }
  
  public final int pG(int paramInt)
  {
    int i = 0;
    int k;
    for (int j = 0; i < size(); j = k)
    {
      k = j;
      if (((e)get(i)).aGm() == paramInt) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.b.h
 * JD-Core Version:    0.7.0.1
 */